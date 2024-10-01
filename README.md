# Scoreboard

This is a simple coding exercise. Code is intended to be built as Kotlin Library and be used in other projects.

You can build the library by running a command:

```bash
./gradlew build
```

To change a version make sure to change it in `build.gradle.kts` file under `version`.

## Usage Example

### Import .jar file
To use the library you can import .jar file in your project and add the following to build.gradle.kts file:

```kotlin
dependencies {
    implementation(files("libs/scoreboard-0.0.1.jar"))
}
```

### Import as dependency from GitHub packages
You can import it from GitHub packages as well. Add this to build.gradle.kts file:

```kotlin
repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/nburic/scoreboard")
    }
}

dependencies {
    implementation("com.github.nburic:scoreboard:0.0.1")
}
```

Create Main.kt file that looks like this:

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
