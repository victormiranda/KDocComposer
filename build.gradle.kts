plugins {
    alias(libs.plugins.jvm)
}

allprojects {
    repositories {
        mavenCentral()
    }


}

subprojects {
    apply(plugin = "kotlin")

    dependencies {
        testImplementation(rootProject.testLibs.kotlin.test.junit5)
        testImplementation(rootProject.testLibs.junit.jupiter.api)
        testImplementation(rootProject.testLibs.junit.jupiter.engine)
    }
}