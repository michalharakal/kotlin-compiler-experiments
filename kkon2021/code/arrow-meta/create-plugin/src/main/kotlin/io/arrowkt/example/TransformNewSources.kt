package io.arrowkt.example

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.classDeclaration
import arrow.meta.quotes.classorobject.ClassDeclaration
import arrow.meta.quotes.map
import org.jetbrains.kotlin.name.Name

/*
  The base directory for the generated files is provided in the build.gradle file
  of the module that is using the plugin ('use-plugin' module):

  compileKotlin {
    kotlinOptions {
      ...
      freeCompilerArgs = [ ...
        "-P", "plugin:arrow.meta.plugin.compiler:generatedSrcOutputDir=${buildDir}"]
    }
  }

  If base directory is not provided, it will be "build" directory in the Gradle daemon workspace.
 */
val Meta.transformNewSources: CliPlugin
    get() = "Transform New Multiple Source" {
        meta(
            classDeclaration(this, { isData() }) {
                Transform.newSources(
                    """
            package org.dukecon.plugin.arrow

            class ${name}Builder {
            ${getBuilderProperties(name, this)}
            }
          """.file("${name}_Generated")
                )
            }
        )
    }

fun getBuilderProperties(name: Name?, classDeclaration: ClassDeclaration): String {
    val paramNames = ArrayList<String>()
    classDeclaration.primaryConstructorParameterList.map {
        paramNames.add(it.name ?: "name")
        it

    }

    val className = name ?: "className"
    val buildFunction = "fun build() = $className(${paramNames.joinToString (",")})"
    return paramNames.map { paramName ->
        """var $paramName: String = ""
        private set      
        fun set$paramName($paramName: String) = apply { this.$paramName = $paramName }"""
    }.plus(buildFunction).joinToString("\n")
}
