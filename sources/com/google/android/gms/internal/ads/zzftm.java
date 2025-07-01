package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzftm extends zzftk {
    private static zzftm zzd;

    private zzftm(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzftm zzi(Context context) {
        zzftm zzftm;
        synchronized (zzftm.class) {
            if (zzd == null) {
                zzd = new zzftm(context);
            }
            zzftm = zzd;
        }
        return zzftm;
    }

    /* JADX INFO: finally extract failed */
    public final zzfth zzh(long j, boolean z) throws IOException {
        synchronized (zzftm.class) {
            try {
                if (!this.zzc.zzd()) {
                    zzfth zzfth = new zzfth();
                    return zzfth;
                }
                zzfth zzb = zzb((String) null, (String) null, j, z);
                return zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzftm.class) {
            if (zzg(false)) {
                zzf(false);
            }
        }
    }
}
