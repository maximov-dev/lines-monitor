package com.yarmaximov.linesmonitor.performance.models

interface Analyze {
    data class Response(
        val url: String,
        val renderTime: Long,
        val domContentLoadedTime: Long,
        //val webVitals: WebVitals
    )
}