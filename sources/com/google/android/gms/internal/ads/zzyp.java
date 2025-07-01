package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzyp {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzyq zzyq) {
        zzc(zzyq);
        this.zza.add(new zzyo(handler, zzyq));
    }

    public final void zzb(int i, long j, long j2) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzyo zzyo = (zzyo) it.next();
            if (!zzyo.zzc) {
                zzyo.zza.post(new zzyn(zzyo, i, j, j2));
            }
        }
    }

    public final void zzc(zzyq zzyq) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzyo zzyo = (zzyo) it.next();
            if (zzyo.zzb == zzyq) {
                zzyo.zzc();
                this.zza.remove(zzyo);
            }
        }
    }
}
