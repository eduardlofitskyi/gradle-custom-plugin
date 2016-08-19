package com.nixsolutions.plugin

import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.Plugin

class PokemonCatcher implements Plugin<Project>{

    @Override
    void apply(Project project) {
        project.task("catchPokemon") << {
            project.sourceSets.main.java.srcDui.each { srcDir ->
                project.fileTree(srcDir).each { File file ->
                    file.each { line ->
                        if (line.contains(project.properties.pokemons)){
                            project.logger.error("Dangerous! Pokemons strike")
                            throw new GradleException("Project failed on pokemon powerful")
                        }
                    }
                }
            }
        }
    }

}
