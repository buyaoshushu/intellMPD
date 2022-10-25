plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.9.0"
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
}

group = "com.buyaoshushu"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2021.3.3")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

dependencies {
    //implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("com.inthebacklog:javampd:7.1.0"){
        exclude(group = "org.slf4j", module = "slf4j-api")
    }
    testImplementation("junit", "junit", "4.12")
}


tasks {
    buildSearchableOptions {
        enabled = false
    }
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    patchPluginXml {
        sinceBuild.set("213")
        untilBuild.set("223.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
