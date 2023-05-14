package ru.grfc.telephony.flutter_telephony_info

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.telephony.TelephonyManager
import androidx.annotation.RequiresApi
import io.flutter.embedding.engine.plugins.FlutterPlugin

/** PigeonPlugin */
class FlutterTelephonyInfoPlugin : FlutterPlugin, TelephonyAPI {
    private lateinit var context: Context
    private lateinit var mTelephonyManager: TelephonyManager

    override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        TelephonyAPI.setUp(flutterPluginBinding.binaryMessenger, this)
        context = flutterPluginBinding.applicationContext
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        TelephonyAPI.setUp(binding.binaryMessenger, null)
    }

    @SuppressLint("MissingPermission")
    override fun getInfo(): List<TelephonyInfo> {
        mTelephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        var cellId: String
        var cellSignalStrength: String
        val telephonyList: MutableList<TelephonyInfo> = mutableListOf()

        for (i in 0 until mTelephonyManager.activeModemCount) {
            if (mTelephonyManager.allCellInfo.isEmpty()) {
                cellId = "Error! GPS must be turned on."
                cellSignalStrength = "Error! GPS must be turned on."
            } else {
                cellId = mTelephonyManager.allCellInfo[i].cellIdentity.toString()
                cellSignalStrength =
                    mTelephonyManager.allCellInfo[i].cellSignalStrength.toString()
            }
            val telephonyInfo = TelephonyInfo(
                displayName = mTelephonyManager.simOperatorName,
                mobileNetworkCode = mTelephonyManager.simOperator,
                radioType = radioType(),
                networkGeneration = networkGeneration(),
                cellId = cellId,
                cellSignalStrength = cellSignalStrength
            )

            telephonyList += telephonyInfo
        }
        return telephonyList
    }

    @SuppressLint("MissingPermission")
    private fun radioType(): String {
        return when (mTelephonyManager.dataNetworkType) {
            TelephonyManager.NETWORK_TYPE_1xRTT -> return "1xRTT"
            TelephonyManager.NETWORK_TYPE_CDMA -> return "CDMA"
            TelephonyManager.NETWORK_TYPE_EDGE -> return "EDGE"
            TelephonyManager.NETWORK_TYPE_EHRPD -> return "eHRPD"
            TelephonyManager.NETWORK_TYPE_EVDO_0 -> return "EVDO rev. 0"
            TelephonyManager.NETWORK_TYPE_EVDO_A -> return "EVDO rev. A"
            TelephonyManager.NETWORK_TYPE_EVDO_B -> return "EVDO rev. B"
            TelephonyManager.NETWORK_TYPE_GPRS -> return "GPRS"
            TelephonyManager.NETWORK_TYPE_GSM -> return "GSM"
            TelephonyManager.NETWORK_TYPE_HSDPA -> return "HSDPA"
            TelephonyManager.NETWORK_TYPE_HSPA -> return "HSPA"
            TelephonyManager.NETWORK_TYPE_HSPAP -> return "HSPA+"
            TelephonyManager.NETWORK_TYPE_HSUPA -> return "HSUPA"
            TelephonyManager.NETWORK_TYPE_IDEN -> return "iDen"
            TelephonyManager.NETWORK_TYPE_UMTS -> return "UMTS"
            TelephonyManager.NETWORK_TYPE_LTE -> return "LTE"
            TelephonyManager.NETWORK_TYPE_NR -> return "NR"
            TelephonyManager.NETWORK_TYPE_TD_SCDMA -> return "TD SCDMA"
            TelephonyManager.NETWORK_TYPE_IWLAN -> return "IWLAN"
            TelephonyManager.NETWORK_TYPE_UNKNOWN -> return "Unknown"
            else -> ""
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("MissingPermission")
    private fun networkGeneration(): String {
        when (val radioType = mTelephonyManager.dataNetworkType) {
            TelephonyManager.NETWORK_TYPE_GPRS,
            TelephonyManager.NETWORK_TYPE_EDGE,
            TelephonyManager.NETWORK_TYPE_CDMA,
            TelephonyManager.NETWORK_TYPE_1xRTT,
            TelephonyManager.NETWORK_TYPE_IDEN,
            TelephonyManager.NETWORK_TYPE_GSM
            -> return "2G"

            TelephonyManager.NETWORK_TYPE_UMTS,
            TelephonyManager.NETWORK_TYPE_EVDO_0,
            TelephonyManager.NETWORK_TYPE_EVDO_A,
            TelephonyManager.NETWORK_TYPE_HSDPA,
            TelephonyManager.NETWORK_TYPE_HSUPA,
            TelephonyManager.NETWORK_TYPE_HSPA,
            TelephonyManager.NETWORK_TYPE_EVDO_B,
            TelephonyManager.NETWORK_TYPE_EHRPD,
            TelephonyManager.NETWORK_TYPE_HSPAP,
            TelephonyManager.NETWORK_TYPE_TD_SCDMA
            -> return "3G"

            TelephonyManager.NETWORK_TYPE_LTE
            -> return "4G"

            TelephonyManager.NETWORK_TYPE_NR,
            -> return "5G"

            else -> radioType.toString()
        }
        return "unknown"
    }
}