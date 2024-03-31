import java.nio.file.Paths
import kotlin.math.max

fun main() {
    println("Day 2 Challenge 2")
    val text = Paths.get("input.txt").toFile().readText(Charsets.UTF_8)
//    val text = """
//        Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
//        Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
//        Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
//        Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
//        Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
//        """.trimIndent()
    val result = text.split("\n")
        .filter { line -> line.isNotEmpty() }
        .map { line ->
            line.split(":")[1]
                .split(";")
                .map { set ->
                    set.split(",").associate { item ->
                        item.trim().split(" ").let { (first, last) ->
                            last to first.toInt()
                        }
                    }
                }
                .map { mapEntry -> mapEntry.withDefault { 0 } }
                .reduce { acc, mapEntry ->
                    mapOf(
                        "red" to acc.getValue("red"),
                        "green" to acc.getValue("green"),
                        "blue" to acc.getValue("blue")
                    ).mapValues { (key, value) -> max(value, mapEntry.getValue(key)) }
                }
        }
        .sumOf { game ->
            game.getValue("green") * game.getValue("red") * game.getValue("blue")
        }
    println(result)
}
