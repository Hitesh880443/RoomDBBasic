package com.health.depen

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyClass : Plugin<Project> {

    override fun apply(target: Project) {
    }

    companion object{
        val room = "2.3.0"
    }
}