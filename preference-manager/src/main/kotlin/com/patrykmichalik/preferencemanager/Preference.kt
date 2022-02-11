package com.patrykmichalik.preferencemanager

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface Preference <C, S> {
    val parse: (S) -> C
    val save: (C) -> S
    val onSet: () -> Unit
    val defaultValue: C
    val key: Preferences.Key<S>
    val preferencesDataStore: DataStore<Preferences>

    fun get(): Flow<C>
    suspend fun set(value: C)
    suspend fun update(block: (C) -> C)
}
