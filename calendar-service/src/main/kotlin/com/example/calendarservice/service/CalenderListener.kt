package com.example.calendarservice.service

import com.example.calendarservice.model.BookingEvent
import com.example.calendarservice.model.CalendarEntryEvent
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CalendarListener(
    private val kafkaTemplate: KafkaTemplate<String, CalendarEntryEvent>
) {

    @KafkaListener(topics = ["booking-created"], groupId = "calendar-service-group")
    fun listen(event: BookingEvent) {
        println("calendar-service hat booking-created empfangen: $event")

        val calendarEvent = CalendarEntryEvent(
            bookingId = event.bookingId,
            calendarEntryId = "cal-${UUID.randomUUID()}",
            resource = event.resource,
            timeslot = event.timeslot
        )

        val result = kafkaTemplate.send("calendar-entry-created", event.bookingId, calendarEvent).get()
        println("calendar-service hat calendar-entry-created gesendet: topic=${result.recordMetadata.topic()}, offset=${result.recordMetadata.offset()}")
    }
}