package com.patrykmichalik.preferencemanager

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface Preference <C, S> {
    val defaultValue: C
    val key: Preferences.Key<S>

    fun get(): Flow<C>
    suspend fun set(value: C)
    suspend fun update(block: (C) -> C)
}
