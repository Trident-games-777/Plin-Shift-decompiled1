package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdo implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzdp zzc;

    public /* synthetic */ zzdo(CopyOnWriteArraySet copyOnWriteArraySet, int i, zzdp zzdp) {
        this.zza = copyOnWriteArraySet;
        this.zzb = i;
        this.zzc = zzdp;
    }

    public final void run() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzdp zzdp = this.zzc;
            ((zzdr) it.next()).zza(this.zzb, zzdp);
        }
    }
}
