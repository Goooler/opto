package io.github.goooler.opto.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import io.github.goooler.opto.domain.Preference

@Composable
fun <C> Preference<C, *, *>.state(initial: C? = null) = get().collectAsState(initial = initial)
