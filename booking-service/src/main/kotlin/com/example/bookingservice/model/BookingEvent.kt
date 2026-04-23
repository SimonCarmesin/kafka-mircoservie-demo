package com.example.bookingservice.model

data class BookingEvent(
    val bookingId: String,
    val customerName: String,
    val resource: String,
    val timeslot: String,
    val status: String = "CREATED"
)