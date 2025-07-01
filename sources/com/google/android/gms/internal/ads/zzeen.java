package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeen implements zzeep {
    public final /* synthetic */ VersionInfoParcel zza;
    public final /* synthetic */ WebView zzb;

    public /* synthetic */ zzeen(VersionInfoParcel versionInfoParcel, WebView webView, boolean z) {
        this.zza = versionInfoParcel;
        this.zzb = webView;
    }

    public final Object zza() {
        VersionInfoParcel versionInfoParcel = this.zza;
        int i = versionInfoParcel.buddyApkVersion;
        int i2 = versionInfoParcel.clientJarVersion;
        return zzfnh.zza(zzfnj.zza("Google", i + "." + i2), this.zzb, true);
    }
}
