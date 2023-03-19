// import 'package:flutter_test/flutter_test.dart';
// import 'package:flutter_telephony_info/flutter_telephony_info.dart';
// import 'package:flutter_telephony_info/flutter_telephony_info_platform_interface.dart';
// import 'package:flutter_telephony_info/flutter_telephony_info_method_channel.dart';
// import 'package:plugin_platform_interface/plugin_platform_interface.dart';

// class MockFlutterTelephonyInfoPlatform
//     with MockPlatformInterfaceMixin
//     implements FlutterTelephonyInfoPlatform {

//   @override
//   Future<String?> getPlatformVersion() => Future.value('42');
// }

// void main() {
//   final FlutterTelephonyInfoPlatform initialPlatform = FlutterTelephonyInfoPlatform.instance;

//   test('$MethodChannelFlutterTelephonyInfo is the default instance', () {
//     expect(initialPlatform, isInstanceOf<MethodChannelFlutterTelephonyInfo>());
//   });

//   test('getPlatformVersion', () async {
//     FlutterTelephonyInfo flutterTelephonyInfoPlugin = FlutterTelephonyInfo();
//     MockFlutterTelephonyInfoPlatform fakePlatform = MockFlutterTelephonyInfoPlatform();
//     FlutterTelephonyInfoPlatform.instance = fakePlatform;

//     expect(await flutterTelephonyInfoPlugin.getPlatformVersion(), '42');
//   });
// }
