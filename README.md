# Plin Shift (Decompiled)

This repository contains a **decompiled version** of the Android application *Plin Shift*. The APK was unpacked using Apktool and is intended for analysis, reverse engineering, and research purposes.

---

## 📁 Repository Structure

```text
Plin-Shift-decompiled/
├── resources/
│   ├── AndroidManifest.xml         # Manifest file with app metadata and entry point
│   ├── res/                        # Layouts, drawables, UI strings, etc.
│   ├── lib/                        # Native libraries (.so)
│   ├── META-INF/, assets/, kotlin/
│   ├── firebase / Google configs
├── sources/
│   ├── android/, androidx/, com/, coil3/, okhttp3/, etc. — decompiled sources
├── .DS_Store                       # macOS system file (not relevant)


---

## 🚀 Entry Point

The main `Activity` (app launcher) is defined in the manifest:

```xml
<activity android:name="com.plinkofortune.cash.winspin.Soleq" android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>


So the main entry point is:
com.plinkofortune.cash.winspin.Soleq
This is the launcher Activity, initialized when the app is opened from the device UI.
