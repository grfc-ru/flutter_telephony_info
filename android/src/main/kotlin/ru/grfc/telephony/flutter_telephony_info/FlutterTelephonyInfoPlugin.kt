package ru.grfc.telephony.flutter_telephony_info

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar


/** PigeonPlugin */
class FlutterTelephonyInfoPlugin: FlutterPlugin, Telephony.FlutterTelephonyInfoPlugin {
    private lateinit var channel : MethodChannel

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        Gsm.GsmAPI.setup(flutterPluginBinding.binaryMessenger, this)
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        Gsm.GsmAPI.setup(binding.binaryMessenger, null)
    }

    override fun getInfo(): String? {
        var result = "1234"
        return result
    }
}