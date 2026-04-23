package com.example.notificationservice.model

data class NotificationSentEvent(
    val bookingId: String,
    val customerName: String,
    val message: String,
    val status: String = "NOTIFICATION_SENT"
)