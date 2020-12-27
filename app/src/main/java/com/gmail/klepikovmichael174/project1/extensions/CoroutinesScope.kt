package com.gmail.klepikovmichael174.project1.extensions

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun CoroutineScope.launchWithErrorHandler(
    block: suspend ()->Unit,
    onError:(Throwable)->Unit
) {
    launch(CoroutineExceptionHandler{ context, throwable ->
        onError(throwable)
        Log.e("tag", throwable.message, throwable)
    }) {
        block()
    }
}