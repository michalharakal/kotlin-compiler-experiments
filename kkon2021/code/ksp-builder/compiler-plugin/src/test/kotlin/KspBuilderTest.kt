package org.dukecon.kotlin.processor.builder

import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import com.tschuchort.compiletesting.symbolProcessorProviders
import kotlin.test.assertEquals
import org.junit.Test
import org.kartbahn.api.BuilderProcessorProvider

class IrBuildertest {
    @Test
    fun `IR plugin success`() {
        val result = compile(
            sourceFile = SourceFile.kotlin(
                "main.kt", """
import org.kartbahn.api.Builder

@Builder
class Road(val name:String) 

fun main() {
  val a = Road("A3")
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
    sourceFiles: List<SourceFile>
): KotlinCompilation.Result {
    val provider: SymbolProcessorProvider = BuilderProcessorProvider()
    return KotlinCompilation().apply {
        sources = sourceFiles
        symbolProcessorProviders = listOf(provider)
    }.compile()
}

fun compile(
    sourceFile: SourceFile,

    ): KotlinCompilation.Result {
    return compile(listOf(sourceFile))
}
