package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzce implements Callable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzce(Context context, Context context2) {
        this.zza = context;
        this.zzb = context2;
    }

    public final Object call() {
        SharedPreferences sharedPreferences;
        Context context = this.zza;
        Context context2 = this.zzb;
        boolean z = false;
        if (context != null) {
            zze.zza("Attempting to read user agent from Google Play Services.");
            sharedPreferences = context.getSharedPreferences("admob_user_agent", 0);
        } else {
            zze.zza("Attempting to read user agent from local cache.");
            sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        zze.zza("Reading user agent from WebSettings");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context2);
        if (z) {
            sharedPreferences.edit().putString("user_agent", defaultUserAgent).apply();
            zze.zza("Persisting user agent.");
        }
        return defaultUserAgent;
    }
}
