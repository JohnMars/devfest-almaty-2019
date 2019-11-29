package com.marshal.janibek.devfest.domain.authorization.entity

import java.util.*

data class Statement(
    val id: Long,
    val date: Date,
    val amount: Amount
)