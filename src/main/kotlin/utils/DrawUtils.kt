package org.example.utils

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO


fun labyrinthToImage(labyrinth: List<String>, path: Set<Point>, cellSize: Int, outputPath: String) {
    val height = labyrinth.size
    val width = labyrinth[0].length

    val image = BufferedImage(width * cellSize, height * cellSize, BufferedImage.TYPE_INT_RGB)
    val graphics = image.createGraphics()

    // Hintergrundfarbe setzen
    graphics.color = Color.WHITE
    graphics.fillRect(0, 0, width * cellSize, height * cellSize)

    for ((y, row) in labyrinth.withIndex()) {
        for ((x, cell) in row.withIndex()) {
            if (cell == '#') {
                graphics.color = Color.BLACK
                graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize)
            }
            if(x to y in path) {

                graphics.color = Color.GREEN
                graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize)
//                graphics.fillRect(x * cellSize +1, y * cellSize +1, cellSize -2, cellSize -2)
            }
        }
    }

    graphics.dispose()

    // Bild speichern
    ImageIO.write(image, "png", File(outputPath))
}




fun drawLabyrinthWithPath(
    labyrinth: List<String>,
    cellSize: Int,
    path: Set<Pair<Int, Int>>,
    outputDir: String
) {
    val height = labyrinth.size
    val width = labyrinth[0].length
    val image = BufferedImage(width * cellSize, height * cellSize, BufferedImage.TYPE_INT_RGB)
    val graphics = image.createGraphics()

    // Hintergrund zeichnen
    graphics.color = Color.WHITE
    graphics.fillRect(0, 0, width * cellSize, height * cellSize)

    // Labyrinth zeichnen
    for ((y, row) in labyrinth.withIndex()) {
        for ((x, cell) in row.withIndex()) {
            if (cell == '#') {
                graphics.color = Color.BLACK
                graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize)
            }
        }
    }

    // Animation: Path zeichnen
    path.forEachIndexed { step, (x, y) ->
        graphics.color = Color.RED
        graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize)

        // Frame speichern
        val frameFile = File("$outputDir/frame_$step.png")
        ImageIO.write(image, "png", frameFile)
    }

    graphics.dispose()
}
