package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzrk {
    public final int zza;
    public final zzur zzb;
    private final CopyOnWriteArrayList zzc;

    public zzrk() {
        this(new CopyOnWriteArrayList(), 0, (zzur) null);
    }

    private zzrk(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzur zzur) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzur;
    }

    public final zzrk zza(int i, zzur zzur) {
        return new zzrk(this.zzc, 0, zzur);
    }

    public final void zzb(Handler handler, zzrl zzrl) {
        this.zzc.add(new zzrj(handler, zzrl));
    }

    public final void zzc(zzrl zzrl) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzrj zzrj = (zzrj) it.next();
            if (zzrj.zza == zzrl) {
                this.zzc.remove(zzrj);
            }
        }
    }
}
