package org.dukecon.kotlin.processor.builder

import com.google.devtools.ksp.processing.SymbolProcessor
import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import com.tschuchort.compiletesting.symbolProcessors
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
import org.dukecon.kotlin.processor.builder.Builder

@Builder
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
}

fun compile(
    sourceFiles: List<SourceFile>,
    plugin: SymbolProcessor = BuilderProcessor(),
): KotlinCompilation.Result {
    return KotlinCompilation().apply {
        sources = sourceFiles
        symbolProcessors = listOf(plugin)
    }.compile()
}

fun compile(
    sourceFile: SourceFile,
    plugin: SymbolProcessor = BuilderProcessor(),
): KotlinCompilation.Result {
    return compile(listOf(sourceFile), plugin)
}
