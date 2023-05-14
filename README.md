# Flutter telephony plugin
[![Pub](https://img.shields.io/pub/v/l.svg)](https://pub.dev/packages/flutter_telephony_info)
![Pub Version](https://img.shields.io/pub/v/flutter_telephony_info)
![Pub Points](https://img.shields.io/pub/points/flutter_telephony_info)
[![License: WTFPL](https://img.shields.io/badge/License-WTFPL-brightgreen.svg)](https://en.wikipedia.org/wiki/WTFPL)
[![Linter](https://img.shields.io/badge/style-linter-40c4ff.svg)](https://pub.dev/packages/linter)
## A minimal platform plugin that works through the 'Pigeon' code generator to interact with an Android device in order to retrieve information from the 'Telephony' module of the Android platform.
---
### **Attention! This plugin works with Android version 12 and higher!**
---
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
---
### **Don't forget to turn on GPS**
---
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
  
[END-USER LICENSE AGREEMENT](https://github.com/grfc-ru/flutter_telephony_info/blob/main/LICENSE)