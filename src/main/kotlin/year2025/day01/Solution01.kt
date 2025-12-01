package de.bergenholtz.year2025.day01

import kotlin.math.abs

class Solution01 {

    fun solveFirst(input: List<String>, output: Boolean = false): Int {
        var currentPosition = 50
        var zeroes = 0

        input.forEach{
            currentPosition += turnDial(it)
            currentPosition += 100
            currentPosition %= 100
            if (currentPosition == 0) { zeroes++}


            if(output) {
                println("The dial is rotated $it to point at $currentPosition")
            }
        }

        return zeroes
    }

    fun solveSecond(input: List<String>, output: Boolean = false): Int {
        var currentPosition = 50
        var zeroes = 0

        input.forEach{

            val oldPosition = currentPosition
            val rotation = turnDial(it)
//            val revBefore = currentPosition / 100
            currentPosition += rotation
            currentPosition %= 100
            currentPosition += 100
            currentPosition %= 100
//            val revAfter = currentPosition / 100
            val zeroesWhileRotating = abs(rotation / 100)

            if(output) {
                print("The dial is rotated $it to point at $currentPosition")
                if(zeroesWhileRotating != 0) {
                    print(" during this rotation, it points at 0 $zeroesWhileRotating times.")
                }
            }


            if(currentPosition != 0 && oldPosition != 0) {
                if(rotation >= 0) {
                    if (oldPosition > currentPosition) {
                        zeroes++
                        if(output) {
                            print(" during this rotation, it points at 0 once going forwards.")
                        }
                    }
                } else {
                    if (oldPosition < currentPosition) {
                        zeroes++
                        if(output) {
                            print(" during this rotation, it points at 0 once going backwards.")
                        }
                    }
                }
            }


            zeroes += zeroesWhileRotating
            if(output) {
                println()
            }

            if (currentPosition == 0) { zeroes++ }



        }

        return zeroes
    }

    fun turnDial(input: String): Int {
        val direction = input.slice(0..0)
        val numbers = input.substring(1)

        if (direction == "L") {
            return numbers.toInt() * -1
        }
        return numbers.toInt()
    }


}