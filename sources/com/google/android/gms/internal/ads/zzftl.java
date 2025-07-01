package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzftl extends zzftk {
    private static zzftl zzd;

    private zzftl(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzftl zzj(Context context) {
        zzftl zzftl;
        synchronized (zzftl.class) {
            if (zzd == null) {
                zzd = new zzftl(context);
            }
            zzftl = zzd;
        }
        return zzftl;
    }

    public final zzfth zzh(long j, boolean z) throws IOException {
        zzfth zzb;
        synchronized (zzftl.class) {
            try {
                zzb = zzb((String) null, (String) null, j, z);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzb;
    }

    public final zzfth zzi(String str, String str2, long j, boolean z) throws IOException {
        zzfth zzb;
        synchronized (zzftl.class) {
            try {
                zzb = zzb(str, str2, j, z);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzb;
    }

    public final void zzk() throws IOException {
        synchronized (zzftl.class) {
            zzf(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzftl.class) {
            zzf(true);
        }
    }
}
