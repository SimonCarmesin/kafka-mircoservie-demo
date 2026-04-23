package com.example.notificationservice.service

import com.example.notificationservice.model.BookingEvent
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class NotificationListener {

    @KafkaListener(topics = ["booking-created"], groupId = "notification-service-group")
    fun listen(event: BookingEvent) {
        println("notification-service: Bestätigung gesendet für Buchung ${event.bookingId} von ${event.customerName}")
    }
}