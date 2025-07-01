package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfnr {
    private static final zzfnr zza = new zzfnr();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzfnr() {
    }

    public static zzfnr zza() {
        return zza;
    }

    public final Collection zzb() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final Collection zzc() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final void zzd(zzfna zzfna) {
        this.zzb.add(zzfna);
    }

    public final void zze(zzfna zzfna) {
        ArrayList arrayList = this.zzb;
        boolean zzg = zzg();
        arrayList.remove(zzfna);
        this.zzc.remove(zzfna);
        if (zzg && !zzg()) {
            zzfnz.zzb().zzg();
        }
    }

    public final void zzf(zzfna zzfna) {
        ArrayList arrayList = this.zzc;
        boolean zzg = zzg();
        arrayList.add(zzfna);
        if (!zzg) {
            zzfnz.zzb().zzf();
        }
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
