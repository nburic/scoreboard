# Scoreboard

This is a simple coding exercise. Code is intended to be built as Kotlin Library and be used in other projects.

You can build the library by running a command:

```bash
./gradlew build
```

To change a version make sure to change it in `build.gradle.kts` file under `version`.

To use the library you can import .jar file in your project. For example you can create a console app and include it in.
Make sure to create Main.kt file that looks like this:

```kotlin
fun main() {
    val scoreboard = Scoreboard()

    scoreboard.startGame("Mexico", "Canada")
    scoreboard.startGame("Spain", "Brazil")
    scoreboard.startGame("Germany", "France")
    scoreboard.startGame("Uruguay", "Italy")
    scoreboard.startGame("Argentina", "Australia")

    scoreboard.updateScore("Mexico", "Canada", 0, 5)
    scoreboard.updateScore("Spain", "Brazil", 10, 2)
    scoreboard.updateScore("Germany", "France", 2, 2)
    scoreboard.updateScore("Uruguay", "Italy", 6, 6)
    scoreboard.updateScore("Argentina", "Australia", 3, 1)

    println("\n*** Summary ***")
    scoreboard.getSummary().forEach { println(it) }
}
```
