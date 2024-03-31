import java.nio.file.Paths

/*
Examples
1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet

Result: 142
 */

fun main() {
    val text = Paths.get("input.txt").toFile().readText(Charsets.UTF_8)
    val result = text.split("\n")
        .filter { line -> line.isNotEmpty() }
        .sumOf { line ->
            line.first { char -> char.isDigit() }.digitToInt() * 10 + line.last { char -> char.isDigit() }.digitToInt()
        }
    println(result)
}
