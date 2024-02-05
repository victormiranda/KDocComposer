plugins {
    kotlin("jvm")
}

dependencies {
    testImplementation(testLibs.kotlin.test.junit5)
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}