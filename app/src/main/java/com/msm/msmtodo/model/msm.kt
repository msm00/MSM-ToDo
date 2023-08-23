package com.msm.msmtodo.model

import kotlinx.serialization.Serializable

@Serializable
data class MsmResponse(
    val items: List<Msm>,
    val hasMore: Boolean,
    val limit: Int,
    val offset: Int,
    val count: Int,
    val links: List<Link>
)

@Serializable
data class Msm(
    val id: Int,
    val name: String,
    val description: String
)

/*
@Serializable
data class Link(
    val rel: String,
    val href: String
)
--*/