package org.dukecon.builder.plugin

import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import kotlin.test.assertEquals
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.junit.Test
import java.io.File

class IrBuildertest {
    @Test
    fun `IR plugin success`() {
        val result = compile(
            sourceFile = SourceFile.kotlin(
                "main.kt", """

data class Conference(val name:String) 

fun main() {
  println(debug())
}

fun debug() = "Hello, World!"
"""
            )
        )
        assertEquals(KotlinCompilation.ExitCode.OK, result.exitCode)
    }

    @Test
    fun `IR plugin syntax error`() {
        val result = compile(
            sourceFile = SourceFile.fromPath(File("/home/miso/projects/extern/private/kotlin-compiler-experiments/javaland2021/builder-kotlinc-plugin/builder-plugin-jvm/src/test/resources/hello.kt"))
        )
        println(result.messages)
        assertEquals(KotlinCompilation.ExitCode.COMPILATION_ERROR, result.exitCode)
    }
}
