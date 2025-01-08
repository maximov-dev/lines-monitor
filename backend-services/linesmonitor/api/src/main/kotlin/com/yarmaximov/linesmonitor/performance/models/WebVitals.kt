package com.yarmaximov.linesmonitor.performance.models

data class WebVitals(
    val cumulativeLayoutShift: Double,
    val largestContentfulPaint: Double,
    val firstInputDelay: Double,
    val timeToFirstByte: Double,
)