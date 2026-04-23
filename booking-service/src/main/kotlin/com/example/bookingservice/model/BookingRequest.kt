package com.example.bookingservice.model

data class BookingRequest(
    val bookingId: String,
    val customerName: String,
    val resource: String,
    val timeslot: String
)