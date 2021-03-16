package com.faceless.techfugeessurvailanceapp.data.response

data class ReportResponse(
    val area: String,
    val compound: String,
    val condition: String,
    val household: String,
    val neighborhood: String,
    val phone: String,
    val symptoms: String
)