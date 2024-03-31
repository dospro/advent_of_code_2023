import java.nio.file.Paths

/*
two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen

Result: 281
 */

fun main() {
    val numbers = mapOf(
        "one" to "o1e",
        "two" to "t2o",
        "three" to "t3e",
        "four" to "f4r",
        "five" to "f5e",
        "six" to "s6x",
        "seven" to "s7n",
        "eight" to "e8t",
        "nine" to "n9e",
        "zero" to "z0o"
    )

    val text = Paths.get("input.txt").toFile().readText(Charsets.UTF_8)
//    val text = """
//        two1nine
//        eightwothree
//        abcone2threexyz
//        xtwone3four
//        4nineeightseven2
//        zoneight234
//        7pqrstsixteen
//        """.trimIndent()
    val regex = numbers.keys.joinToString("|").toRegex()
    val result = text.split("\n")
        .filter { line -> line.isNotEmpty() }
        .map { line ->
            var newLine = line
            while (true) {
                val match = regex.find(newLine)?.value ?: break
                newLine = newLine.replace(match, numbers[match].toString())
            }
            newLine
        }
        .sumOf { line ->
            line.first { char -> char.isDigit() }.digitToInt() * 10 + line.last { char -> char.isDigit() }.digitToInt()
        }
    println(result)
}
