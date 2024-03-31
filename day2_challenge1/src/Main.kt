import java.nio.file.Paths

/*
Input:
Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green

Output
8
 */


fun main() {
    println("Day 2 Challenge 1")
    val text = Paths.get("input.txt").toFile().readText(Charsets.UTF_8)
    val result = text.split("\n")
        .filter { line -> line.isNotEmpty() }
        .filter { line -> // filter out invalid games
            line
                .split(":")[1]
                .split(";")
                .all { set ->
                    val theMap = set.split(",").map { item ->
                        val tokens = item.trim().split(" ")
                        Pair(tokens.last(), tokens.first().toInt())
                    }.toMap()

                    val red = theMap["red"] ?: 0
                    val green = theMap["green"] ?: 0
                    val blue = theMap["blue"] ?: 0
                    red <= 12 && green <= 13 && blue <= 14
                }
        }
        .sumOf { line ->
            line.split(":").first().split(" ")[1].toInt()
        }
    println(result)
}
