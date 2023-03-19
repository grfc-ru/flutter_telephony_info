package ru.grfc.telephony.flutter_telephony_info

import android.app.Activity
import android.content.Context
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler

import android.telephony.TelephonyManager
import android.telephony.cdma.CdmaCellLocation
import android.telephony.gsm.GsmCellLocation

/** PigeonPlugin */
class FlutterTelephonyInfoPlugin : FlutterPlugin, MethodCallHandler, ActivityAware, Telephony.TelephonyAPI {
    private lateinit var channel: MethodChannel

    private lateinit var context: Context
    private lateinit var activity: Activity

    override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        Telephony.TelephonyAPI.setup(flutterPluginBinding.binaryMessenger, this)
        context = flutterPluginBinding.applicationContext
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        Telephony.TelephonyAPI.setup(binding.binaryMessenger, null)
    }

    override fun getInfo(): List<Telephony.TelephonyInfo> {
        var mTelephonyManager: TelephonyManager? = null

        mTelephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        val telephonyList: List<Telephony.TelephonyInfo>

        val t1 = Telephony.TelephonyInfo()
        val t2 = Telephony.TelephonyInfo()
        t1.networkCountryIso = "1234"
        t2.networkCountryIso = "5678"
        result = listOf(t1, t2)

//        val telephonyList: ArrayList<HashMap<String, Any?>> = ArrayList()
        for (i in 0 until mTelephonyManager!!.phoneCount) {
            val data = hashMapOf<String, Any?>(
                "carrierName" to mTelephonyManager!!.simOperatorName,
                "dataActivity" to mTelephonyManager!!.dataActivity,
                "radioType" to if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) radioType() else null,
                "cellId" to cellId(),
                "simState" to simState(i),
                "phoneNumber" to mTelephonyManager!!.line1Number,
                "networkOperatorName" to mTelephonyManager!!.networkOperatorName,
                "subscriptionId" to mTelephonyManager!!.subscriptionId,
                "isoCountryCode" to mTelephonyManager!!.simCountryIso,
                "networkCountryIso" to mTelephonyManager!!.getNetworkCountryIso(i),
                "mobileNetworkCode" to mTelephonyManager!!.simOperator?.substring(3),
                "displayName" to mTelephonyManager!!.simOperatorName,
                "mobileCountryCode" to mTelephonyManager!!.simOperator?.substring(0, 3),
                "networkGeneration" to if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) networkGeneration() else null,
            )

            telephonyList.add(data)
        }
        return result
    }
}