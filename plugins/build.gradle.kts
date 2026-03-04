import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

import com.android.build.gradle.LibraryExtension
import com.aliucord.gradle.AliucordExtension

val authorName: String = "RazerTexz"
val authorDiscordId: Long = 0
val repositoryUrl: String = "https://github.com/RazerTexz/My-plugins"
val projectNamespace: String = "com.github.razertexz"

subprojects {
    apply(plugin = "org.jetbrains.kotlin.android")
    apply(plugin = "com.android.library")
    apply(plugin = "com.aliucord.plugin")

    configure<KotlinAndroidExtension> {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    configure<LibraryExtension> {
        namespace = projectNamespace
        compileSdk = 36

        defaultConfig {
            minSdk = 21
        }

        buildFeatures {
            resValues = false
            shaders = false
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }
    }

    configure<AliucordExtension> {
        author(authorName, authorDiscordId)
        github(repositoryUrl)
    }

    dependencies {
        val compileOnly by configurations

        compileOnly("org.jetbrains.kotlin:kotlin-stdlib:2.3.10")
        compileOnly("com.aliucord:Aliucord:2.6.0")
        compileOnly("com.aliucord:Aliuhook:1.1.4")
        compileOnly("com.discord:discord:126021")
    }
}