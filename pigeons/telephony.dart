import 'package:pigeon/pigeon.dart';

@ConfigurePigeon(
  PigeonOptions(
    dartOut: 'lib/flutter_telephony_info.dart',
    kotlinOut:
        'android/src/main/kotlin/ru/grfc/telephony/flutter_telephony_info/TelephonyInfoPigeonApi.kt',
    kotlinOptions:
        KotlinOptions(package: 'ru.grfc.telephony.flutter_telephony_info'),
  ),
)
class TelephonyInfo {
  /// The name of the user’s home cellular service provider.
  String? displayName;

  /// The mobile network code (MNC) for the user’s cellular service provider.
  String? mobileNetworkCode;

  /// The mobile network generation: LTE, HSDPA, e.t.c
  String? radioType;

  /// The mobile network radioType: 5G, 4G ... 2G
  String? networkGeneration;

  /// The cell id (cid) and local area code
  String? cellId;

  /// The cell signal strenght
  String? cellSignalStrength;
}

@HostApi()
abstract class TelephonyAPI {
  List<TelephonyInfo>? getInfo();
}
