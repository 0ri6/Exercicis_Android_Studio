import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.compose.reload.ComposeHotRun
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.hotreload)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlinx.serialization)
    id("app.cash.sqldelight") version "2.0.2"
}

composeCompiler {
    featureFlags.add(ComposeFeatureFlag.OptimizeNonSkippingGroups)
}

kotlin {
    jvmToolchain(11)
    androidTarget {
        //https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-test.html
        instrumentedTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)
    }

    jvm()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.kermit)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.client.logging)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.androidx.navigation.composee)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.datetime)
            implementation("com.russhwolf:multiplatform-settings-no-arg:1.3.0")
            implementation("com.russhwolf:multiplatform-settings-serialization:1.3.0")
            implementation("io.ktor:ktor-client-core:3.0.2")
            implementation("io.ktor:ktor-client-cio:3.0.2")
            implementation("io.ktor:ktor-client-content-negotiation:3.0.2")
            implementation("io.ktor:ktor-serialization-kotlinx-json:3.0.2")

            implementation("io.ktor:ktor-client-core:2.2.3") // Versión de Ktor (ajusta según lo último disponible)
            implementation("io.ktor:ktor-client-cio:2.2.3")  // El motor que estás usando, en este caso CIO
            implementation("io.ktor:ktor-client-content-negotiation:2.2.3") // Para negociación de contenido
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.2.3") // Para serialización de JSON con Kotlin
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0") // Versión de Kotlinx Serialization

            implementation("io.coil-kt.coil3:coil-compose:3.1.0")
            implementation("io.coil-kt.coil3:coil-network-ktor3:3.1.0")

            implementation("app.cash.sqldelight:coroutines-extensions:2.0.2")

        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.uiTest)
            implementation(libs.kotlinx.coroutines.test)
        }

        androidMain.dependencies {
            implementation(compose.uiTooling)
            implementation(libs.androidx.activityCompose)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.ktor.client.okhttp)
            implementation("app.cash.sqldelight:android-driver:2.0.2")
            implementation("androidx.camera:camera-core:1.5.0-alpha06")
            implementation("androidx.camera:camera-camera2:1.5.0-alpha06")
            implementation("androidx.camera:camera-compose:1.5.0-alpha06")
            implementation("androidx.camera:camera-lifecycle:1.5.0-alpha06")
            implementation("androidx.camera:camera-extensions:1.5.0-alpha06")

            implementation("com.google.accompanist:accompanist-permissions:0.37.2")
            implementation(libs.androidx.startup.runtime)


        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.ktor.client.okhttp)
            implementation("app.cash.sqldelight:sqlite-driver:2.0.2")

        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation("app.cash.sqldelight:native-driver:2.0.2")

        }

    }
}

android {
    namespace = "cat.itb.m78.exercices"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        targetSdk = 35

        applicationId = "cat.itb.m78.exercices.androidApp"
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

//https://developer.android.com/develop/ui/compose/testing#setup
//dependencies {
//    implementation(libs.androidx.ui.android)
//    implementation(libs.androidx.startup.runtime)
//    implementation(libs.androidx.camera.core)
//    implementation(libs.androidx.lifecycle.common.jvm)
//    implementation(libs.androidx.compiler)
//    implementation(libs.androidx.camera.lifecycle)
//    androidTestImplementation(libs.androidx.uitest.junit4)
//    debugImplementation(libs.androidx.uitest.testManifest)
//}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "M78Exercices"
            packageVersion = "1.0.0"

            linux {
                iconFile.set(project.file("desktopAppIcons/LinuxIcon.png"))
            }
            windows {
                iconFile.set(project.file("desktopAppIcons/WindowsIcon.ico"))
            }
            macOS {
                iconFile.set(project.file("desktopAppIcons/MacosIcon.icns"))
                bundleID = "cat.itb.m78.exercices.desktopApp"
            }
        }
    }
}

tasks.register<ComposeHotRun>("runHot") {
    mainClass.set("HotrunKt")
}


sqldelight {
    databases {
        create("Database") {
            packageName.set("cat.itb.m78.exercices.db")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/databases"))
            verifyMigrations.set(true)
        }
    }
}