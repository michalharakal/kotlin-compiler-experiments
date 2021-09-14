package org.kartbahn.builder.plugin

import com.google.auto.service.AutoService
import org.jetbrains.kotlin.compiler.plugin.AbstractCliOption
import org.jetbrains.kotlin.compiler.plugin.CliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.CompilerConfigurationKey
import org.kartbahn.BuildConfig

@AutoService(BuilderCommandLineProcessor::class)
class BuilderCommandLineProcessor : CommandLineProcessor {
    companion object {
        private const val OPTION_OUTPUT_FILE = "outputFile"

        val ARG_OUTPUT_FILE = CompilerConfigurationKey<String>(OPTION_OUTPUT_FILE)
    }

    override val pluginId: String = BuildConfig.KOTLIN_PLUGIN_ID

    override val pluginOptions: Collection<CliOption> = listOf(
        CliOption(
            optionName = OPTION_OUTPUT_FILE,
            valueDescription = "output",
            description = "compiler log output file",
            required = false,
        ),
    )

    override fun processOption(
        option: AbstractCliOption,
        value: String,
        configuration: CompilerConfiguration
    ) {
        return when (option.optionName) {
            OPTION_OUTPUT_FILE -> configuration.put(ARG_OUTPUT_FILE, value)
            else -> throw IllegalArgumentException("Unexpected config option ${option.optionName}")
        }
    }
}
