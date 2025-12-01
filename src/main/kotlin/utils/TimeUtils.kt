package org.example.utils

import jdk.jfr.internal.EventWriterKey.block
import kotlin.time.Duration
import kotlin.time.measureTimedValue

fun <T> measureMeanRuntime(runs: Int = 100, warmUp : Int = 100, block: () -> T): Pair<Duration, T> {

    val runtimesSecond = List(runs + warmUp) {
        measureTimedValue {
            block()
        }
    }

    val mean2 = runtimesSecond.drop(warmUp).fold(Duration.ZERO) { acc, d -> acc + d.duration } / runs

    return mean2 to runtimesSecond.first().value
}