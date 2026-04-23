package com.example.bookingservice.controller

import com.example.bookingservice.model.BookingEvent
import com.example.bookingservice.model.BookingRequest
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bookings")
class BookingController(
    private val kafkaTemplate: KafkaTemplate<String, BookingEvent>
) {

    @GetMapping("/check")
    fun check() = "booking-service läuft"

    @PostMapping
    fun createBooking(@RequestBody request: BookingRequest): String {
        val event = BookingEvent(
            bookingId = request.bookingId,
            customerName = request.customerName,
            resource = request.resource,
            timeslot = request.timeslot
        )

        val result = kafkaTemplate.send("booking-created", request.bookingId, event).get()

        return "Booking gespeichert und Event gesendet: topic=${result.recordMetadata.topic()}, offset=${result.recordMetadata.offset()}"
    }
}