package org.kartbahn.builder.plugin

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.util.dump
import java.io.File

class BuilderIrGenerationExtension(
    private val messageCollector: MessageCollector,
    private val outputFile: String
) : IrGenerationExtension {
    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {

        print(moduleFragment.dump())

        File(outputFile).printWriter().use { out ->
            out.println(moduleFragment.dump())
            out.flush()
        }

        messageCollector.report(CompilerMessageSeverity.INFO, (moduleFragment.dump()))
        messageCollector.report(CompilerMessageSeverity.INFO, "Argument 'file' = $outputFile")
    }
}
