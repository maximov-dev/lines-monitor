package com.yarmaximov.linesmonitor.performance.models

import org.hibernate.validator.constraints.URL

interface Analyze {
    data class Response(
        val url: String,
        val renderTime: Long,
        val domContentLoadedTime: Long,
        //val webVitals: WebVitals
    )

    data class Request(
        @field:URL
        val url: String,
    )
}