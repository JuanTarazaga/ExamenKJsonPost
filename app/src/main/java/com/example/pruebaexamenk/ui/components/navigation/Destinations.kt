package com.example.pruebaexamenk.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.pruebaexamenk.ui.components.topBot.TopBar

object Destinations {
    const val PANTALLA_INICIAL = "pantalla-inicial"
    const val PANTALLA_SECUNDARIA = "pantalla-secundaria"
}

fun getTopBarForRoute(route: String?, navController: NavController): @Composable (() -> Unit)? {
    return when (route) {

        Destinations.PANTALLA_INICIAL -> {
            { TopBar("JsonPosts") }
        }

        Destinations.PANTALLA_SECUNDARIA -> {
            { TopBar("JsonPosts") }
        }

        else -> null
    }
}