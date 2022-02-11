package com.patrykmichalik.preferencemanager

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

interface PreferenceManager {

    val preferencesDataStore: DataStore<Preferences>

    fun <S> preference(
        key: Preferences.Key<S>,
        defaultValue: S,
        onSet: () -> Unit = {},
    ): Preference<S, S> = PreferenceImpl(
        preferencesDataStore = preferencesDataStore,
        key = key,
        defaultValue = defaultValue,
        onSet = onSet,
        parse = { it },
        save = { it },
    )

    fun <C, S> preference(
        key: Preferences.Key<S>,
        defaultValue: C,
        onSet: () -> Unit = {},
        parse: (S) -> C,
        save: (C) -> S,
    ): Preference<C, S> = PreferenceImpl(
        preferencesDataStore = preferencesDataStore,
        key = key,
        defaultValue = defaultValue,
        onSet = onSet,
        parse = parse,
        save = save,
    )
}
