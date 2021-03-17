package org.dukecon.builder.plugin

import com.google.auto.service.AutoService
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration

@AutoService(BuilderComponentRegistrar::class)
class BuilderComponentRegistrar(
    private val defaultFile: String,
) : ComponentRegistrar {

    @Suppress("unused") // Used by service loader
    constructor() : this(
        defaultFile = "compiler_logs.txt"
    )

    override fun registerProjectComponents(
        project: MockProject,
        configuration: CompilerConfiguration
    ) {
        val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)
        val file = configuration.get(BuilderCommandLineProcessor.ARG_OUTPUT_FILE, defaultFile)

        IrGenerationExtension.registerExtension(project, BuilderIrGenerationExtension(messageCollector, file))
    }
}


