package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzva {
    public final int zza;
    public final zzur zzb;
    private final CopyOnWriteArrayList zzc;

    public zzva() {
        this(new CopyOnWriteArrayList(), 0, (zzur) null);
    }

    private zzva(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzur zzur) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzur;
    }

    public final zzva zza(int i, zzur zzur) {
        return new zzva(this.zzc, 0, zzur);
    }

    public final void zzb(Handler handler, zzvb zzvb) {
        this.zzc.add(new zzuz(handler, zzvb));
    }

    public final void zzc(zzun zzun) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuz = (zzuz) it.next();
            zzen.zzN(zzuz.zza, new zzuu(this, zzuz.zzb, zzun));
        }
    }

    public final void zzd(zzui zzui, zzun zzun) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuz = (zzuz) it.next();
            zzen.zzN(zzuz.zza, new zzuy(this, zzuz.zzb, zzui, zzun));
        }
    }

    public final void zze(zzui zzui, zzun zzun) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuz = (zzuz) it.next();
            zzen.zzN(zzuz.zza, new zzuw(this, zzuz.zzb, zzui, zzun));
        }
    }

    public final void zzf(zzui zzui, zzun zzun, IOException iOException, boolean z) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuz = (zzuz) it.next();
            zzen.zzN(zzuz.zza, new zzux(this, zzuz.zzb, zzui, zzun, iOException, z));
        }
    }

    public final void zzg(zzui zzui, zzun zzun) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuz = (zzuz) it.next();
            zzen.zzN(zzuz.zza, new zzuv(this, zzuz.zzb, zzui, zzun));
        }
    }

    public final void zzh(zzvb zzvb) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuz zzuz = (zzuz) it.next();
            if (zzuz.zzb == zzvb) {
                this.zzc.remove(zzuz);
            }
        }
    }
}
