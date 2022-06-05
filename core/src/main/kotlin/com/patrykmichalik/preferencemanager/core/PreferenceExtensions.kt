package com.patrykmichalik.preferencemanager.core

import androidx.datastore.preferences.core.Preferences
import com.patrykmichalik.preferencemanager.domain.Preference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

suspend fun Preference<Boolean, Boolean, *>.toggle() {
    update { !it }
}

suspend fun Preference<Int, Int, *>.increment(by: Int = 1) {
    update { it + by }
}

suspend fun Preference<Int, Int, *>.decrement(by: Int = 1) {
    increment(by = -by)
}

suspend fun Preference<Float, Float, *>.increment(by: Float = 1f) {
    update { it + by }
}

suspend fun Preference<Float, Float, *>.decrement(by: Float = 1f) {
    increment(by = -by)
}

suspend fun Preference<String, String, *>.clear() {
    set(value = "")
}

suspend fun <C, S> Preference<C, S, *>.first() = get().first()

suspend fun <C, S> Preference<C, S, *>.reset() {
    set(value = defaultValue)
}

fun Preference<Boolean, Boolean, *>.toggleBlocking() {
    runBlocking { toggle() }
}

fun Preference<Int, Int, *>.incrementBlocking(by: Int = 1) {
    runBlocking { increment(by = by) }
}

fun Preference<Int, Int, *>.decrementBlocking(by: Int = 1) {
    runBlocking { decrement(by = by) }
}

fun Preference<Float, Float, *>.incrementBlocking(by: Float = 1f) {
    runBlocking { increment(by = by) }
}

fun Preference<Float, Float, *>.decrementBlocking(by: Float = 1f) {
    runBlocking { decrement(by = by) }
}

fun Preference<String, String, *>.clearBlocking() {
    runBlocking { clear() }
}

fun <C, S> Preference<C, S, *>.firstBlocking() = runBlocking { first() }

fun <C, S> Preference<C, S, *>.resetBlocking() = runBlocking { reset() }

fun <C, S> Preference<C, S, *>.setBlocking(value: C) {
    runBlocking { set(value = value) }
}

fun <C, S> Preference<C, S, *>.onEach(
    launchIn: CoroutineScope,
    block: (C) -> Unit,
) {
    get()
        .onEach { block(it) }
        .launchIn(scope = launchIn)
}

fun <C, S> Preference<C, S, Preferences.Key<S>>.getFromPreferences(preferences: Preferences): C =
    preferences.get(key = key)?.let { parse(it) } ?: defaultValue
