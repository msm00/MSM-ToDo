package com.msm.msmtodo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NoteResponse(
    val items: List<Note>,
//    val hasMore: Boolean,
//    val limit: Int,
//    val offset: Int,
//    val count: Int,
//    val links: List<Link>
)

@Serializable
data class Note(
    /*@SerialName("note_id")*/ val noteId: Int,
    val description: String,
    val completed: Boolean
)

@Serializable
data class Link(
    val rel: String,
    val href: String
)