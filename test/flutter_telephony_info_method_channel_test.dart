// import 'package:flutter/services.dart';
// import 'package:flutter_test/flutter_test.dart';
// import 'package:flutter_telephony_info/flutter_telephony_info_method_channel.dart';

// void main() {
//   MethodChannelFlutterTelephonyInfo platform = MethodChannelFlutterTelephonyInfo();
//   const MethodChannel channel = MethodChannel('flutter_telephony_info');

//   TestWidgetsFlutterBinding.ensureInitialized();

//   setUp(() {
//     channel.setMockMethodCallHandler((MethodCall methodCall) async {
//       return '42';
//     });
//   });

//   tearDown(() {
//     channel.setMockMethodCallHandler(null);
//   });

//   test('getPlatformVersion', () async {
//     expect(await platform.getPlatformVersion(), '42');
//   });
// }
