package org.kartbahn.api

import org.jetbrains.kotlin.compiler.plugin.AbstractCliOption
import org.jetbrains.kotlin.compiler.plugin.CliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.CompilerConfigurationKey
import java.io.File

class BuilderCommandLineProcessor : CommandLineProcessor {
    override val pluginId: String = "builder"
    override val pluginOptions: Collection<AbstractCliOption> =
        listOf(
            CliOption(
                "enabled",
                "<true|false>",
                "Whether plugin is enabled",
                required = false
            )
        )

    override fun processOption(option: AbstractCliOption, value: String, configuration: CompilerConfiguration) {
        when (option.optionName) {
            "enabled" -> configuration.put(KEY_ENABLED, value.toBoolean())
        }
    }

    companion object {
        val KEY_ENABLED = CompilerConfigurationKey<Boolean>("builder.enabled")
    }
}
