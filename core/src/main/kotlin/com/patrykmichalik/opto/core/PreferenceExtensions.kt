package com.patrykmichalik.opto.core

import com.patrykmichalik.opto.domain.Preference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

suspend fun Preference<Boolean, *, *>.toggle() {
    update { !it }
}

suspend fun Preference<Int, *, *>.increment(by: Int = 1) {
    update { it + by }
}

suspend fun Preference<Int, *, *>.decrement(by: Int = 1) {
    increment(by = -by)
}

suspend fun Preference<Float, *, *>.increment(by: Float = 1f) {
    update { it + by }
}

suspend fun Preference<Float, *, *>.decrement(by: Float = 1f) {
    increment(by = -by)
}

suspend fun Preference<String, *, *>.clear() {
    set(value = "")
}

suspend fun <C> Preference<C, *, *>.first() = get().first()

suspend fun <C> Preference<C, *, *>.reset() {
    set(value = defaultValue)
}

fun Preference<Boolean, *, *>.toggleBlocking() {
    runBlocking { toggle() }
}

fun Preference<Int, *, *>.incrementBlocking(by: Int = 1) {
    runBlocking { increment(by = by) }
}

fun Preference<Int, *, *>.decrementBlocking(by: Int = 1) {
    runBlocking { decrement(by = by) }
}

fun Preference<Float, *, *>.incrementBlocking(by: Float = 1f) {
    runBlocking { increment(by = by) }
}

fun Preference<Float, *, *>.decrementBlocking(by: Float = 1f) {
    runBlocking { decrement(by = by) }
}

fun Preference<String, *, *>.clearBlocking() {
    runBlocking { clear() }
}

fun <C> Preference<C, *, *>.firstBlocking() = runBlocking { first() }

fun <C> Preference<C, *, *>.resetBlocking() = runBlocking { reset() }

fun <C> Preference<C, *, *>.setBlocking(value: C) {
    runBlocking { set(value = value) }
}

fun <C> Preference<C, *, *>.onEach(
    launchIn: CoroutineScope,
    block: (C) -> Unit,
) {
    get()
        .onEach { block(it) }
        .launchIn(scope = launchIn)
}
