package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzawo {
    private static final String[] zza = {"android:establish_vpn_service", "android:establish_vpn_manager"};
    /* access modifiers changed from: private */
    public long zzb = 0;
    /* access modifiers changed from: private */
    public long zzc = 0;
    /* access modifiers changed from: private */
    public long zzd = -1;
    /* access modifiers changed from: private */
    public boolean zze = false;

    zzawo(Context context, Executor executor, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).startWatchingActive(strArr, executor, new zzawn(this));
            } catch (IllegalArgumentException | NoSuchMethodError unused) {
            }
        }
    }

    public static zzawo zzd(Context context, Executor executor) {
        return new zzawo(context, executor, zza);
    }

    public final long zzb() {
        long j = this.zzd;
        this.zzd = -1;
        return j;
    }

    public final long zzc() {
        if (this.zze) {
            return this.zzc - this.zzb;
        }
        return -1;
    }

    public final void zzh() {
        if (this.zze) {
            this.zzc = System.currentTimeMillis();
        }
    }
}
