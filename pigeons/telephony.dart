import 'package:pigeon/pigeon.dart';

class TelephonyInfo {
  String? networkCountryIso;
  String? mobileCountryCode;

  /// The mobile network code (MNC) for the user’s cellular service provider.
  String? mobileNetworkCode;

  /// The name of the user’s home cellular service provider.
  String? displayName;

  /// Constant indicating the state of the device SIM card in a logical slot; SIM_STATE_UNKNOWN, SIM_STATE_ABSENT, SIM_STATE_PIN_REQUIRED, SIM_STATE_PUK_REQUIRED, SIM_STATE_NETWORK_LOCKED, SIM_STATE_READY, SIM_STATE_NOT_READY, SIM_STATE_PERM_DISABLED, SIM_STATE_CARD_IO_ERROR, SIM_STATE_CARD_RESTRICTED,
  String? simState;

  /// The ISO country code for the user’s cellular service provider.
  String? isoCountryCode;

  /// The cell id (cid) and local area code
  CellId? cellId;

  /// Phone number of the sim
  String? phoneNumber;

  /// Carrier name of the sim
  String? carrierName;

  /// The mobile network radioType: 5G, 4G ... 2G
  String? networkGeneration;

  /// The mobile network generation: LTE, HSDPA, e.t.c
  String? radioType;
}

class CellId {
  int? cid;
  int? lac;
}

@HostApi()
abstract class TelephonyAPI {
  List<TelephonyInfo>? getInfo();
}
