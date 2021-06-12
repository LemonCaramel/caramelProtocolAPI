plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
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
            expand("project_version" to project.version, "project_description" to project.description)
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
    implementation("com.destroystokyo.paper", "paper-api", property("bukkitAPIVersion") as String)
}