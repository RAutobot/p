pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven("https://maven.aliucord.com/releases")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.aliucord.com/releases")
    }
}

rootProject.name = "Aliucord Plugins"
rootDir.resolve("plugins").listFiles().forEach {
    if (it.isDirectory && it.resolve("build.gradle.kts").exists()) {
        include(":plugins:${it.name}")
    }
}