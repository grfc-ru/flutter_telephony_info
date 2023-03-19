package ru.grfc.telephony.flutter_telephony_info

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar


/** PigeonPlugin */
class FlutterTelephonyInfoPlugin: FlutterPlugin, Telephony.TelephonyAPI {
    private lateinit var channel : MethodChannel

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        Telephony.TelephonyAPI.setup(flutterPluginBinding.binaryMessenger, this)
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        Telephony.TelephonyAPI.setup(binding.binaryMessenger, null)
    }

    override fun getInfo(): List<Telephony.TelephonyInfo>? {
        val result: List<Telephony.TelephonyInfo>

        var t1= Telephony.TelephonyInfo()
        var t2= Telephony.TelephonyInfo()
        t1.setNetworkCountryIso("1234")
        t2.setNetworkCountryIso("5678")
        result = listOf(t1,t2)
        return result
    }
}