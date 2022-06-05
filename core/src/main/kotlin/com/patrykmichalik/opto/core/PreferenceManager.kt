package com.patrykmichalik.opto.core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.patrykmichalik.opto.domain.Preference

interface PreferenceManager {

    val preferencesDataStore: DataStore<Preferences>

    fun <S> preference(
        key: Preferences.Key<S>,
        defaultValue: S,
        onSet: (S) -> Unit = {},
    ): Preference<S, S, Preferences.Key<S>> = PreferenceImpl(
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
        onSet: (C) -> Unit = {},
        parse: (S) -> C,
        save: (C) -> S,
    ): Preference<C, S, Preferences.Key<S>> = PreferenceImpl(
        preferencesDataStore = preferencesDataStore,
        key = key,
        defaultValue = defaultValue,
        onSet = onSet,
        parse = parse,
        save = save,
    )
}
