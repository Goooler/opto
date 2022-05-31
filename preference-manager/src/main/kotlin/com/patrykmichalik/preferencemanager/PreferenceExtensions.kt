package com.patrykmichalik.preferencemanager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

suspend fun Preference<Boolean, Boolean>.toggle() {
    update { !it }
}

suspend fun Preference<Int, Int>.increment(by: Int = 1) {
    update { it + by }
}

suspend fun Preference<Int, Int>.decrement(by: Int = 1) {
    increment(by = -by)
}

suspend fun Preference<Float, Float>.increment(by: Float = 1f) {
    update { it + by }
}

suspend fun Preference<Float, Float>.decrement(by: Float = 1f) {
    increment(by = -by)
}

suspend fun Preference<String, String>.clear() {
    set(value = "")
}

suspend fun <C, S> Preference<C, S>.first() = get().first()

fun <C, S> Preference<C, S>.firstBlocking() = runBlocking { first() }

fun <C, S> Preference<C, S>.setBlocking(value: C) = runBlocking { set(value = value) }

fun Preference<Boolean, Boolean>.toggleBlocking() = runBlocking { toggle() }

fun Preference<Int, Int>.incrementBlocking(by: Int = 1) = runBlocking { increment(by = by) }

fun Preference<Int, Int>.decrementBlocking(by: Int = 1) = runBlocking { decrement(by = by) }

fun Preference<Float, Float>.incrementBlocking(by: Float = 1f) = runBlocking { increment(by = by) }

fun Preference<Float, Float>.decrementBlocking(by: Float = 1f) = runBlocking { decrement(by = by) }

fun Preference<String, String>.clearBlocking() = runBlocking { clear() }

@Composable
fun <C, S> Preference<C, S>.state(initial: C? = null) = get().collectAsState(initial = initial)

fun <C, S> Preference<C, S>.onEach(
    launchIn: CoroutineScope,
    block: (C) -> Unit,
) {
    get()
        .onEach { block(it) }
        .launchIn(scope = launchIn)
}
