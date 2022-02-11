package com.patrykmichalik.preferencemanager

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class PreferenceImpl<C, S>(
    override val parse: (S) -> C,
    override val save: (C) -> S,
    override val onSet: () -> Unit,
    override val defaultValue: C,
    override val key: Preferences.Key<S>,
    override val preferencesDataStore: DataStore<Preferences>,
): Preference<C, S> {

    private fun S?.parsedOrDefault() = this?.let { parse(it) } ?: defaultValue

    override fun get() = preferencesDataStore.data.map { preferences ->
        preferences[key].parsedOrDefault()
    }

    override suspend fun set(value: C) {
        preferencesDataStore.edit { mutablePreferences ->
            mutablePreferences[key] = save(value)
        }
        onSet()
    }

    override suspend fun update(block: (C) -> C) {
        preferencesDataStore.edit { mutablePreferences ->
            val current = mutablePreferences[key].parsedOrDefault()
            mutablePreferences[key] = save(block(current))
        }
        onSet()
    }
}
