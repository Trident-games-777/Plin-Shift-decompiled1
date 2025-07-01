package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzave implements Callable {
    public final /* synthetic */ Context zza;

    public /* synthetic */ zzave(zzavf zzavf, Context context) {
        this.zza = context;
    }

    public final Object call() {
        Context context = this.zza;
        try {
            return zzfpx.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }
}
