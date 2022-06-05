package com.patrykmichalik.preferencemanager.domain

import kotlinx.coroutines.flow.Flow

interface Preference <C, S, K> {
    val defaultValue: C
    val key: K
    val parse: (S) -> C
    val save: (C) -> S

    fun get(): Flow<C>
    suspend fun set(value: C)
    suspend fun update(block: (C) -> C)
}
