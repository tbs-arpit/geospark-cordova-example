# geospark-cordova-example
### GeoSpark Cordova example application with Location Listener Implementation in **Android**

## How to Run
* clone repo using following command:
```
git clone https://github.com/tbs-arpit/geospark-cordova-example.git
```

* Update your GeoSpark registered package name with existing package name in `config.xml`

* Update Your PUBLISH KEY in `plugins/cordova-plugin-geospark/src/android/GeoSparkPlugin.java` :
```
 GeoSpark.initialize(application, "YOUR-PUBLISHABLE-KEY");
```
* Add Platform and run application
```
cordova platform add android@8.1.0
cordova run android
```

## Prerequisites (Android)
* Platform >= 8.1.0
* Gradle version >= 5.4.1
* MinSdkVersion >= 21
* BuildToolsVersion >= 29.0.3
* Following Lines Should be in `platforms/android/app/src/main/java/com/cordova/development/MainActivity.java` (path will change after package name update, e.g. java/packageName/MainActivity.java)
```
package com.cordova.development;

import android.content.Intent;
import android.os.Bundle;

import com.geospark.lib.GeoSpark;                           //Add this Line

import org.apache.cordova.CordovaActivity;

public class MainActivity extends CordovaActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeoSpark.logger(this, true);                        //Add this Line
        GeoSpark.exportToFile(this);                        //Add this Line
        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }

        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
    }
}
```