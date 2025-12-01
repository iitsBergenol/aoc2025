package de.bergenholtz

import de.bergenholtz.year2025.day01.Solution01
import org.example.utils.Utils.Companion.readInput
import org.example.utils.measureMeanRuntime

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {


    val input01 = readInput("day01/input.txt")
    measureMeanRuntime(1, 0) {
        val s01 = Solution01()
        s01.solveFirst(input01)

    }.also { println("Day 01 first part runtime is ${it.first}, solution is ${it.second}") }

    measureMeanRuntime(1, 0) {
        val s25 = Solution01()
        s25.solveSecond(input01) // 1783 too low 5621 too low  5828 too low

    }.also { println("Day 01 second part runtime is ${it.first}, solution is ${it.second}") }

}