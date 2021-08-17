plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("dependencies") {
            id = "com.health.depen.dependencies"
            implementationClass = "com.health.depen.MyClass"
        }
    }
}