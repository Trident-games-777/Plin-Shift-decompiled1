package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaqa {
    public static final boolean zza = zzaqb.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    zzaqa() {
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        if (!this.zzc) {
            zzb("Request on the loose");
            zzaqb.zzb("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void zza(String str, long j) {
        try {
            if (!this.zzc) {
                this.zzb.add(new zzapz(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb(String str) {
        long j;
        this.zzc = true;
        if (this.zzb.size() == 0) {
            j = 0;
        } else {
            long j2 = ((zzapz) this.zzb.get(0)).zzc;
            List list = this.zzb;
            j = ((zzapz) list.get(list.size() - 1)).zzc - j2;
        }
        if (j > 0) {
            long j3 = ((zzapz) this.zzb.get(0)).zzc;
            zzaqb.zza("(%-4d ms) %s", Long.valueOf(j), str);
            for (zzapz zzapz : this.zzb) {
                long j4 = zzapz.zzc;
                zzaqb.zza("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(zzapz.zzb), zzapz.zza);
                j3 = j4;
            }
        }
    }
}
