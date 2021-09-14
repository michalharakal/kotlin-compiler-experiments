package org.kartbahn.api

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.util.dump
import java.io.File

class DumpAstIrGeneration(private val messageCollector: MessageCollector) : IrGenerationExtension {
      override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {

        print(moduleFragment.dump())

        File("/Users/michalharakal/projects/fiwio/kotlin-compiler-experiments/kkon2021/code/builder-kotlinc-plugin/debug.log").printWriter().use { out ->
            out.println(moduleFragment.dump())
            out.flush()
        }
        messageCollector.report(CompilerMessageSeverity.INFO, (moduleFragment.dump()))
    }
}

