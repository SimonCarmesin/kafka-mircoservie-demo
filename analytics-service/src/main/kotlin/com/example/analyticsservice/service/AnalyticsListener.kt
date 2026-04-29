package com.example.analyticsservice.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class AnalyticsListener {

    @KafkaListener(topics = ["booking-created"])
    fun onBookingCreated(event: String) {
        println("analytics-service | booking-created       : $event")
    }

    @KafkaListener(topics = ["calendar-entry-created"])
    fun onCalendarEntryCreated(event: String) {
        println("analytics-service | calendar-entry-created: $event")
    }

    @KafkaListener(topics = ["notification-sent"])
    fun onNotificationSent(event: String) {
        println("analytics-service | notification-sent     : $event")
    }
}
