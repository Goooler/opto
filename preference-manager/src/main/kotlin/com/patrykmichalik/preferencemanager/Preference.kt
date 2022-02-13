package com.patrykmichalik.preferencemanager

import kotlinx.coroutines.flow.Flow

interface Preference <C, S> {
    val defaultValue: C

    fun get(): Flow<C>
    suspend fun set(value: C)
    suspend fun update(block: (C) -> C)
}
