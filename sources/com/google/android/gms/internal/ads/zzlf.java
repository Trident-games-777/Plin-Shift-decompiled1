package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzlf {
    private final zzoj zza;
    private final List zzb = new ArrayList();
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final zzle zze;
    private final HashMap zzf;
    private final Set zzg;
    /* access modifiers changed from: private */
    public final zzlw zzh;
    /* access modifiers changed from: private */
    public final zzdm zzi;
    private boolean zzj;
    private zzhd zzk;
    private zzwj zzl = new zzwj(0);

    public zzlf(zzle zzle, zzlw zzlw, zzdm zzdm, zzoj zzoj) {
        this.zza = zzoj;
        this.zze = zzle;
        this.zzh = zzlw;
        this.zzi = zzdm;
        this.zzf = new HashMap();
        this.zzg = new HashSet();
    }

    private final void zzr(int i, int i2) {
        while (i < this.zzb.size()) {
            ((zzld) this.zzb.get(i)).zzd += i2;
            i++;
        }
    }

    private final void zzs(zzld zzld) {
        zzlc zzlc = (zzlc) this.zzf.get(zzld);
        if (zzlc != null) {
            zzlc.zza.zzi(zzlc.zzb);
        }
    }

    private final void zzt() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzld zzld = (zzld) it.next();
            if (zzld.zzc.isEmpty()) {
                zzs(zzld);
                it.remove();
            }
        }
    }

    private final void zzu(zzld zzld) {
        if (zzld.zze && zzld.zzc.isEmpty()) {
            zzlc zzlc = (zzlc) this.zzf.remove(zzld);
            zzlc.getClass();
            zzlc zzlc2 = zzlc;
            zzlc.zza.zzp(zzlc.zzb);
            zzlc.zza.zzs(zzlc.zzc);
            zzlc.zza.zzr(zzlc.zzc);
            this.zzg.remove(zzld);
        }
    }

    private final void zzv(zzld zzld) {
        zzum zzum = zzld.zza;
        zzkv zzkv = new zzkv(this);
        zzlb zzlb = new zzlb(this, zzld);
        this.zzf.put(zzld, new zzlc(zzum, zzkv, zzlb));
        zzum.zzh(new Handler(zzen.zzz(), (Handler.Callback) null), zzlb);
        zzum.zzg(new Handler(zzen.zzz(), (Handler.Callback) null), zzlb);
        zzum.zzm(zzkv, this.zzk, this.zza);
    }

    private final void zzw(int i, int i2) {
        while (true) {
            i2--;
            if (i2 >= i) {
                zzld zzld = (zzld) this.zzb.remove(i2);
                this.zzd.remove(zzld.zzb);
                zzr(i2, -zzld.zza.zzC().zzc());
                zzld.zze = true;
                if (this.zzj) {
                    zzu(zzld);
                }
            } else {
                return;
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzbv zzb() {
        if (this.zzb.isEmpty()) {
            return zzbv.zza;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzb.size(); i2++) {
            zzld zzld = (zzld) this.zzb.get(i2);
            zzld.zzd = i;
            i += zzld.zza.zzC().zzc();
        }
        return new zzll(this.zzb, this.zzl);
    }

    public final zzbv zzc(int i, int i2, List list) {
        boolean z = true;
        zzdb.zzd(i >= 0 && i <= i2 && i2 <= zza());
        if (list.size() != i2 - i) {
            z = false;
        }
        zzdb.zzd(z);
        for (int i3 = i; i3 < i2; i3++) {
            ((zzld) this.zzb.get(i3)).zza.zzt((zzaw) list.get(i3 - i));
        }
        return zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzut zzut, zzbv zzbv) {
        this.zze.zzh();
    }

    public final void zzg(zzhd zzhd) {
        zzdb.zzf(!this.zzj);
        this.zzk = zzhd;
        for (int i = 0; i < this.zzb.size(); i++) {
            zzld zzld = (zzld) this.zzb.get(i);
            zzv(zzld);
            this.zzg.add(zzld);
        }
        this.zzj = true;
    }

    public final void zzh() {
        for (zzlc zzlc : this.zzf.values()) {
            try {
                zzlc.zza.zzp(zzlc.zzb);
            } catch (RuntimeException e) {
                zzdt.zzd("MediaSourceList", "Failed to release child source.", e);
            }
            zzlc.zza.zzs(zzlc.zzc);
            zzlc.zza.zzr(zzlc.zzc);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzi(zzup zzup) {
        zzld zzld = (zzld) this.zzc.remove(zzup);
        zzld.getClass();
        zzld zzld2 = zzld;
        zzld.zza.zzG(zzup);
        zzld.zzc.remove(((zzuj) zzup).zza);
        if (!this.zzc.isEmpty()) {
            zzt();
        }
        zzu(zzld);
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final zzbv zzk(int i, List list, zzwj zzwj) {
        if (!list.isEmpty()) {
            this.zzl = zzwj;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                zzld zzld = (zzld) list.get(i2 - i);
                if (i2 > 0) {
                    zzld zzld2 = (zzld) this.zzb.get(i2 - 1);
                    zzld.zzc(zzld2.zzd + zzld2.zza.zzC().zzc());
                } else {
                    zzld.zzc(0);
                }
                zzr(i2, zzld.zza.zzC().zzc());
                this.zzb.add(i2, zzld);
                this.zzd.put(zzld.zzb, zzld);
                if (this.zzj) {
                    zzv(zzld);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzld);
                    } else {
                        zzs(zzld);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzbv zzl(int i, int i2, int i3, zzwj zzwj) {
        zzdb.zzd(zza() >= 0);
        this.zzl = null;
        return zzb();
    }

    public final zzbv zzm(int i, int i2, zzwj zzwj) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= zza()) {
            z = true;
        }
        zzdb.zzd(z);
        this.zzl = zzwj;
        zzw(i, i2);
        return zzb();
    }

    public final zzbv zzn(List list, zzwj zzwj) {
        zzw(0, this.zzb.size());
        return zzk(this.zzb.size(), list, zzwj);
    }

    public final zzbv zzo(zzwj zzwj) {
        int zza2 = zza();
        if (zzwj.zzc() != zza2) {
            zzwj = zzwj.zzf().zzg(0, zza2);
        }
        this.zzl = zzwj;
        return zzb();
    }

    public final zzup zzp(zzur zzur, zzys zzys, long j) {
        int i = zzll.zzb;
        Object obj = ((Pair) zzur.zza).first;
        zzur zza2 = zzur.zza(((Pair) zzur.zza).second);
        zzld zzld = (zzld) this.zzd.get(obj);
        zzld.getClass();
        zzld zzld2 = zzld;
        this.zzg.add(zzld);
        zzlc zzlc = (zzlc) this.zzf.get(zzld);
        if (zzlc != null) {
            zzlc.zza.zzk(zzlc.zzb);
        }
        zzld.zzc.add(zza2);
        zzuj zzH = zzld.zza.zzI(zza2, zzys, j);
        this.zzc.put(zzH, zzld);
        zzt();
        return zzH;
    }

    public final zzwj zzq() {
        return this.zzl;
    }
}
