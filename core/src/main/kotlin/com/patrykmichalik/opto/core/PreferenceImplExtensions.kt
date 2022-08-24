package com.patrykmichalik.opto.core

import androidx.datastore.preferences.core.Preferences

fun <C, S> PreferenceImpl<C, S>.getFromPreferences(preferences: Preferences): C =
    preferences.get(key = key)?.let { parse(it) } ?: defaultValue
