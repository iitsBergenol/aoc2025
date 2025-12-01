package org.example.utils

import kotlin.math.absoluteValue


class Utils {

    companion object {

        fun readInput(file: String): List<String> {
            return this::class.java.classLoader.getResource(file)!!.readText().split("\n").map { it.trim() }
        }
    }


}

typealias Point = Pair<Int, Int>

fun List<String>.getPos(pos: Point): Char {

    return this[pos.second][pos.first]
}


fun List<MutableList<Char>>.getPosMut(pos: Point): Char {

    return this[pos.second][pos.first]
}

fun List<MutableList<Char>>.setPos(pos: Point, item: Char) {

    this[pos.second][pos.first] = item
}


fun List<String>.print() = this.forEach { println(it) }

//directions
val up = 0 to -1
val down = 0 to 1
val left = -1 to 0
val right = 1 to 0


val directions = listOf(up, down, left, right)

fun Point.reverse() = 0 to 0 minus this

infix fun Point.add(other: Point): Point = this.first + other.first to this.second + other.second

infix fun Point.minus(other: Point): Point = this.first - other.first to this.second - other.second

fun Array<IntArray>.getPos(pos: Point) = this[pos.second][pos.first]

fun Array<IntArray>.setPos(pos: Point, value: Int) {
    this[pos.second][pos.first] = value
}


fun Array<IntArray>.isInGrid(pos: Point) =
    (pos.first >= 0 && pos.first < this[0].size && pos.second >= 0 && pos.second < this.size)


fun Array<IntArray>.dijkstra(start: Point, end: Point? = null): Array<IntArray> {

    val distancesFromStart = Array(this.size) { IntArray(this[0].size) { Int.MAX_VALUE } }
    distancesFromStart.setPos(start, 0)

    val queue = mutableListOf(start)

    while (queue.isNotEmpty()) {

        queue.sortedBy { distancesFromStart.getPos(it) }

        val node = queue.removeFirst()

        directions.forEach { direction ->
            val nextNode = node add direction
            val thisDistance = distancesFromStart.getPos(node)
            if (this.isInGrid(nextNode) && this.getPos(nextNode) == 0 && thisDistance + 1 < distancesFromStart.getPos(
                    nextNode
                )
            ) {
                queue.add(nextNode)
                distancesFromStart.setPos(nextNode, thisDistance + 1)
            }
        }

        if (end != null && node == end) {

            return distancesFromStart
        }

    }


    return distancesFromStart
}

infix fun Point.distTo(other: Point): Int =
    (this minus other).let { it.first.absoluteValue + it.second.absoluteValue }

fun Array<IntArray>.getPath(end: Pair<Int, Int>): List<Point> {
    val queue = mutableListOf(end)
    val path: MutableList<Point> = mutableListOf()
    while (queue.isNotEmpty()) {
        val currentNode = queue.removeFirst()
        val currentDistance = this.getPos(currentNode)
        path.add(currentNode)

        directions.forEach {
            val nextNode = currentNode add it
            if (this.getPos(nextNode) < currentDistance) {
                queue.add(nextNode)
            }
        }
    }

    return path

}

fun List<String>.findPoint(searchChar: Char): Point {
    this.forEachIndexed { yaxis, line ->
        line.forEachIndexed { xaxis, char ->
            if (char == searchChar) {
                return xaxis to yaxis
            }
        }
    }

    return -1 to -1
}