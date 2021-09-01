plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

base {
    archivesBaseName = property("archivesBaseName") as String
    group = property("mavenGroup") as String
    version = property("projectVersion") as String
    description = "Fake API plugin that solves the compatibility problem between versions."
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version, "description" to project.description)
        }
    }

    withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
    }
}

repositories {
    mavenCentral()
    maven(url = "https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    /* Paper API */
    compileOnly("com.destroystokyo.paper", "paper-api", property("bukkitAPIVersion") as String)
}