package com.patrykmichalik.preferencemanager

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.map

class PreferenceImpl<C, S>(
    val parse: (S) -> C,
    val save: (C) -> S,
    val onSet: (C) -> Unit,
    override val defaultValue: C,
    override val key: Preferences.Key<S>,
    val preferencesDataStore: DataStore<Preferences>,
): Preference<C, S> {

    private fun S?.parsedOrDefault() = this?.let { parse(it) } ?: defaultValue

    override fun get() = preferencesDataStore.data.map { preferences ->
        preferences[key].parsedOrDefault()
    }

    override suspend fun set(value: C) {
        preferencesDataStore.edit { mutablePreferences ->
            mutablePreferences[key] = save(value)
        }
        onSet(value)
    }

    override suspend fun update(block: (C) -> C) {
        preferencesDataStore.edit { mutablePreferences ->
            val current = mutablePreferences[key].parsedOrDefault()
            val new = block(current)
            mutablePreferences[key] = save(new)
            onSet(new)
        }
    }
}
