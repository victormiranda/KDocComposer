plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}


dependencyResolutionManagement {
    versionCatalogs {
        create("testLibs") {
            from(files("gradle/test-libs.versions.toml"))
        }
    }
}


rootProject.name = "kDocsComposer"

include(
    "kDocsComposer-pdf",
    "kDocsComposer-api"
)
