package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzei implements zzdm {
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzei(Handler handler) {
        this.zzb = handler;
    }

    static /* bridge */ /* synthetic */ void zzl(zzeg zzeg) {
        List list = zza;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(zzeg);
            }
        }
    }

    private static zzeg zzm() {
        zzeg zzeg;
        List list = zza;
        synchronized (list) {
            if (list.isEmpty()) {
                zzeg = new zzeg((zzeh) null);
            } else {
                zzeg = (zzeg) list.remove(list.size() - 1);
            }
        }
        return zzeg;
    }

    public final Looper zza() {
        return this.zzb.getLooper();
    }

    public final zzdl zzb(int i) {
        Handler handler = this.zzb;
        zzeg zzm = zzm();
        zzm.zzb(handler.obtainMessage(i), this);
        return zzm;
    }

    public final zzdl zzc(int i, Object obj) {
        Handler handler = this.zzb;
        zzeg zzm = zzm();
        zzm.zzb(handler.obtainMessage(i, obj), this);
        return zzm;
    }

    public final zzdl zzd(int i, int i2, int i3) {
        Handler handler = this.zzb;
        zzeg zzm = zzm();
        zzm.zzb(handler.obtainMessage(1, i2, i3), this);
        return zzm;
    }

    public final void zze(Object obj) {
        this.zzb.removeCallbacksAndMessages((Object) null);
    }

    public final void zzf(int i) {
        this.zzb.removeMessages(i);
    }

    public final boolean zzg(int i) {
        return this.zzb.hasMessages(1);
    }

    public final boolean zzh(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    public final boolean zzi(int i) {
        return this.zzb.sendEmptyMessage(i);
    }

    public final boolean zzj(int i, long j) {
        return this.zzb.sendEmptyMessageAtTime(2, j);
    }

    public final boolean zzk(zzdl zzdl) {
        return ((zzeg) zzdl).zzc(this.zzb);
    }
}
