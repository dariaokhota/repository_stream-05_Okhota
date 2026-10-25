plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

//Задача 1 - запустить все тесты в проекте
tasks.register<Test>("FirstTask") {
    group = "testrun"

    // Эти строки пришлось добавить, они стали обязательны для Gradle 9
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath

    useJUnitPlatform {
        includeTags("smoke")
    }
    outputs.upToDateWhen {false} // Всегда запускать задачу, иначе отображает UP-TO-DATE, если с прошлого запуска не было изменений

    testLogging {
        // Добавила, чтобы отображались сообщения System.out.println из результатов тестов
        showStandardStreams = true
        //events("passed", "skipped", "failed") // Дополнительная информация о результате каждого теста
    }
}

//Задача 2 выводит текст в конце
tasks.register("SecondTask") {
    group = "testrun"
    doLast {
        println("Test run is over")
    }
}

//Задача 2 dependsOn Задача 1
tasks.named("SecondTask") {
    dependsOn("FirstTask")
}
