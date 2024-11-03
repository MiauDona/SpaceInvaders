plugins {
    java
}

group = "miau.dona"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "miau.dona.Main"
        )
    }
}