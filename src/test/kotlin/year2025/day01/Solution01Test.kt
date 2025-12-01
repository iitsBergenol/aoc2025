package year2025.day01

import de.bergenholtz.year2025.day01.Solution01
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class Solution01Test {

    val day01 = Solution01()
    val input = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
        """.trimIndent().split("\n")


    @Test
    fun firstPart() {



        val solution = day01.solveFirst(input)

        solution shouldBe 3

    }

    @Test
    fun secondPart() {
        val solution = day01.solveSecond(input, true)

        solution shouldBe 6
    }


    @Test
    fun secondPartLong() {
        val solution = day01.solveSecond(listOf("R1000"), true)

        solution shouldBe 10

        val solution2 = day01.solveSecond(listOf("L1000"), true)

        solution2 shouldBe 10

        val solution3 = day01.solveSecond(listOf("L1080"), true)

        solution3 shouldBe 11

        val solution4 = day01.solveSecond(listOf("R1080"), true)

        solution4 shouldBe 11
    }

    @Test
    fun secondPartNoRevolution() {

        val solution = day01.solveSecond(listOf("L50"), true)

        solution shouldBe 1
    }

}