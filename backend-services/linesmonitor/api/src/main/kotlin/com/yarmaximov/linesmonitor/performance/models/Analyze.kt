package com.yarmaximov.linesmonitor.performance.models

import org.hibernate.validator.constraints.URL

interface Analyze {
    data class Response<T>(
        val url: String,
//        val renderTime: Long,
//        val domContentLoadedTime: Long,
        //val webVitals: WebVitals
        val payload: T,
    )

    data class Request(
        @field:URL
        val url: String,
    )
}