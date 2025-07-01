package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzds {
    private final zzdc zza;
    private final zzdm zzb;
    private final zzdq zzc;
    private final CopyOnWriteArraySet zzd;
    private final ArrayDeque zze;
    private final ArrayDeque zzf;
    private final Object zzg;
    private boolean zzh;
    private boolean zzi;

    public zzds(Looper looper, zzdc zzdc, zzdq zzdq) {
        this(new CopyOnWriteArraySet(), looper, zzdc, zzdq, true);
    }

    public static /* synthetic */ boolean zzg(zzds zzds, Message message) {
        Iterator it = zzds.zzd.iterator();
        while (it.hasNext()) {
            ((zzdr) it.next()).zzb(zzds.zzc);
            if (zzds.zzb.zzg(1)) {
                break;
            }
        }
        return true;
    }

    private final void zzh() {
        if (this.zzi) {
            zzdb.zzf(Thread.currentThread() == this.zzb.zza().getThread());
        }
    }

    public final zzds zza(Looper looper, zzdq zzdq) {
        return new zzds(this.zzd, looper, this.zza, zzdq, this.zzi);
    }

    public final void zzb(Object obj) {
        synchronized (this.zzg) {
            if (!this.zzh) {
                this.zzd.add(new zzdr(obj));
            }
        }
    }

    public final void zzc() {
        zzh();
        if (!this.zzf.isEmpty()) {
            if (!this.zzb.zzg(1)) {
                zzdm zzdm = this.zzb;
                zzdm.zzk(zzdm.zzb(1));
            }
            boolean isEmpty = this.zze.isEmpty();
            this.zze.addAll(this.zzf);
            this.zzf.clear();
            if (isEmpty) {
                while (!this.zze.isEmpty()) {
                    ((Runnable) this.zze.peekFirst()).run();
                    this.zze.removeFirst();
                }
            }
        }
    }

    public final void zzd(int i, zzdp zzdp) {
        zzh();
        this.zzf.add(new zzdo(new CopyOnWriteArraySet(this.zzd), i, zzdp));
    }

    public final void zze() {
        zzh();
        synchronized (this.zzg) {
            this.zzh = true;
        }
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            ((zzdr) it.next()).zzc(this.zzc);
        }
        this.zzd.clear();
    }

    public final void zzf(Object obj) {
        zzh();
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            zzdr zzdr = (zzdr) it.next();
            if (zzdr.zza.equals(obj)) {
                zzdr.zzc(this.zzc);
                this.zzd.remove(zzdr);
            }
        }
    }

    private zzds(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, zzdc zzdc, zzdq zzdq, boolean z) {
        this.zza = zzdc;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzdq;
        this.zzg = new Object();
        this.zze = new ArrayDeque();
        this.zzf = new ArrayDeque();
        this.zzb = zzdc.zzd(looper, new zzdn(this));
        this.zzi = z;
    }
}
