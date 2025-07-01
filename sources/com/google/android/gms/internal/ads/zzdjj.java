package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdjj {
    public static final zzdjj zza = new zzdjj(new zzdjh());
    private final zzbgz zzb;
    private final zzbgw zzc;
    private final zzbhm zzd;
    private final zzbhj zze;
    private final zzbmk zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    private zzdjj(zzdjh zzdjh) {
        this.zzb = zzdjh.zza;
        this.zzc = zzdjh.zzb;
        this.zzd = zzdjh.zzc;
        this.zzg = new SimpleArrayMap(zzdjh.zzf);
        this.zzh = new SimpleArrayMap(zzdjh.zzg);
        this.zze = zzdjh.zzd;
        this.zzf = zzdjh.zze;
    }

    public final zzbgw zza() {
        return this.zzc;
    }

    public final zzbgz zzb() {
        return this.zzb;
    }

    public final zzbhc zzc(String str) {
        return (zzbhc) this.zzh.get(str);
    }

    public final zzbhf zzd(String str) {
        return (zzbhf) this.zzg.get(str);
    }

    public final zzbhj zze() {
        return this.zze;
    }

    public final zzbhm zzf() {
        return this.zzd;
    }

    public final zzbmk zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList(this.zzg.size());
        for (int i = 0; i < this.zzg.size(); i++) {
            arrayList.add((String) this.zzg.keyAt(i));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }
}
