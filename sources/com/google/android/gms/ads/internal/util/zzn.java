package com.google.android.gms.ads.internal.util;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzftd;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzn implements Callable {
    public final /* synthetic */ Uri zza;

    public /* synthetic */ zzn(Uri uri) {
        this.zza = uri;
    }

    public final Object call() {
        zzftd zzftd = zzs.zza;
        zzv.zzq();
        return zzs.zzP(this.zza);
    }
}
