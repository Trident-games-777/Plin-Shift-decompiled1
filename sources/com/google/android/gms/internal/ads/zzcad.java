package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcad implements zzazf {
    final zzcaa zza;
    final HashSet zzb = new HashSet();
    final HashSet zzc = new HashSet();
    private final Object zzd = new Object();
    private final zzg zze;
    private final zzcab zzf;
    private boolean zzg = false;

    public zzcad(String str, zzg zzg2) {
        this.zza = new zzcaa(str, zzg2);
        this.zze = zzg2;
        this.zzf = new zzcab();
    }

    public final void zza(boolean z) {
        long currentTimeMillis = zzv.zzC().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zze.zzd() > ((Long) zzbe.zzc().zza(zzbcn.zzba)).longValue()) {
                this.zza.zzd = -1;
            } else {
                this.zza.zzd = this.zze.zzc();
            }
            this.zzg = true;
            return;
        }
        this.zze.zzr(currentTimeMillis);
        this.zze.zzG(this.zza.zzd);
    }

    public final int zzb() {
        int zza2;
        synchronized (this.zzd) {
            zza2 = this.zza.zza();
        }
        return zza2;
    }

    public final zzbzs zzc(Clock clock, String str) {
        return new zzbzs(clock, this, this.zzf.zza(), str);
    }

    public final String zzd() {
        return this.zzf.zzb();
    }

    public final void zze(zzbzs zzbzs) {
        synchronized (this.zzd) {
            this.zzb.add(zzbzs);
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            this.zza.zzc();
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zza.zzd();
        }
    }

    public final void zzh() {
        synchronized (this.zzd) {
            this.zza.zze();
        }
    }

    public final void zzi() {
        synchronized (this.zzd) {
            this.zza.zzf();
        }
    }

    public final void zzj(zzm zzm, long j) {
        synchronized (this.zzd) {
            this.zza.zzg(zzm, j);
        }
    }

    public final void zzk() {
        synchronized (this.zzd) {
            this.zza.zzh();
        }
    }

    public final void zzl(HashSet hashSet) {
        synchronized (this.zzd) {
            this.zzb.addAll(hashSet);
        }
    }

    public final boolean zzm() {
        return this.zzg;
    }

    public final Bundle zzn(Context context, zzfgw zzfgw) {
        HashSet hashSet = new HashSet();
        synchronized (this.zzd) {
            hashSet.addAll(this.zzb);
            this.zzb.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zza.zzb(context, this.zzf.zzb()));
        Bundle bundle2 = new Bundle();
        Iterator it = this.zzc.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzbzs) it2.next()).zza());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzfgw.zzc(hashSet);
            return bundle;
        }
        zzcac zzcac = (zzcac) it.next();
        throw null;
    }
}
