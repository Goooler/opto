package com.patrykmichalik.preferencemanager.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.patrykmichalik.preferencemanager.domain.Preference

@Composable
fun <C, S> Preference<C, S, *>.state(initial: C? = null) = get().collectAsState(initial = initial)
