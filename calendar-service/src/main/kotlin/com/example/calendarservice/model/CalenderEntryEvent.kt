package com.example.calendarservice.model

data class CalendarEntryEvent(
    val bookingId: String,
    val calendarEntryId: String,
    val resource: String,
    val timeslot: String,
    val status: String = "CALENDAR_ENTRY_CREATED"
)