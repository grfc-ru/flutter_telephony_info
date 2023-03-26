# Flutter telephony plugin

## A minimal platform plugin that works through the 'Pigeon' code generator to interact with an Android device in order to retrieve information from the 'Telephony' module of the Android platform.

Flutter telephony plugin gets:
 - name cellular service provider;
 - mobile network code (MNC);
 - mobile network generation (LTE, HSDPA, e.t.c);
 - mobile network radioType (5G, 4G ... 2G);
 - cell id (cid);
 - cell signal strenght.

The minimum required SDK of the application is 30

.\android\app\build.gradle

```
defaultConfig {

...

//      minSdkVersion flutter.minSdkVersion
        minSdkVersion 30

...

    }
```


The following Android permissions are required for the plugin to work

```
<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
```
Don't forget to turn on GPS

## Usage

```dart
  import 'package:flutter_telephony_info/flutter_telephony_info.dart';

  final _flutterTelephonyInfoPlugin = TelephonyAPI();
  List<TelephonyInfo?>? telephonyInfo;
  try {
      telephonyInfo = await _flutterTelephonyInfoPlugin.getInfo();
    } on PlatformException {
      telephonyInfo = null;
    }

  telephonyInfo?.first?.displayName
```

## Changelog  
  
Refer to the [Changelog](https://github.com/grfc-ru/flutter_telephony_info/blob/main/CHANGELOG.md) to get all release notes.  
  
  
## Features and bugs  
  
Please file feature requests and bugs at the [issue tracker][tracker].
  
[tracker]: https://github.com/grfc-ru/flutter_telephony_info/issues
  
  
## License  
  
[WTFPL](https://github.com/grfc-ru/flutter_telephony_info/blob/main/LICENSE)