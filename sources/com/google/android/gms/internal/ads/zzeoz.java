package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.provider.Settings;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeoz implements Callable {
    public final /* synthetic */ ContentResolver zza;

    public /* synthetic */ zzeoz(ContentResolver contentResolver) {
        this.zza = contentResolver;
    }

    public final Object call() {
        ContentResolver contentResolver = this.zza;
        String string = Settings.Secure.getString(contentResolver, "advertising_id");
        boolean z = false;
        if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 0) == 1) {
            z = true;
        }
        return new zzepb(string, z);
    }
}
