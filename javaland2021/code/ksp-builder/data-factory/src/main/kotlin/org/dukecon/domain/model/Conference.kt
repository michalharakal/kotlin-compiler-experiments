package org.dukecon.domain.model

import org.dukecon.kotlin.processor.builder.Builder

@Builder
internal data class Conference(
    val id: String,
    val name: String?,
    val url: String?,
    val events: List<Event>
)

internal data class Event(
    val id: String,
    val start: String,
    val end: String,
    val title: String,
    val abstractText: String,
    val demo: Boolean,
    val simultan: Boolean,
    val veryPopular: Boolean
)