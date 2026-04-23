package com.example.notificationservice.service

import com.example.notificationservice.model.BookingEvent
import com.example.notificationservice.model.NotificationSentEvent
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class NotificationListener(
    private val kafkaTemplate: KafkaTemplate<String, NotificationSentEvent>
) {

    @KafkaListener(topics = ["booking-created"], groupId = "notification-service-group")
    fun listen(event: BookingEvent) {
        println("notification-service: Buchung empfangen ${event.bookingId}")

        val notificationEvent = NotificationSentEvent(
            bookingId = event.bookingId,
            customerName = event.customerName,
            message = "Bestätigung für ${event.customerName} zur Ressource ${event.resource} wurde gesendet"
        )

        val result = kafkaTemplate.send(
            "notification-sent",
            event.bookingId,
            notificationEvent
        ).get()

        println("notification-service hat notification-sent gesendet: topic=${result.recordMetadata.topic()}, offset=${result.recordMetadata.offset()}")
    }
}