package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zznz {
    private final zzbt zza;
    /* access modifiers changed from: private */
    public zzfzo zzb = zzfzo.zzn();
    private zzfzr zzc = zzfzr.zzd();
    private zzur zzd;
    private zzur zze;
    private zzur zzf;

    public zznz(zzbt zzbt) {
        this.zza = zzbt;
    }

    private static zzur zzj(zzbp zzbp, zzfzo zzfzo, zzur zzur, zzbt zzbt) {
        zzbv zzn = zzbp.zzn();
        int zze2 = zzbp.zze();
        Object zzf2 = zzn.zzo() ? null : zzn.zzf(zze2);
        int i = -1;
        if (!zzbp.zzw() && !zzn.zzo()) {
            i = zzn.zzd(zze2, zzbt, false).zzc(zzen.zzs(zzbp.zzk()));
        }
        int i2 = i;
        for (int i3 = 0; i3 < zzfzo.size(); i3++) {
            zzur zzur2 = (zzur) zzfzo.get(i3);
            if (zzm(zzur2, zzf2, zzbp.zzw(), zzbp.zzb(), zzbp.zzc(), i2)) {
                return zzur2;
            }
        }
        if (zzfzo.isEmpty() && zzur != null) {
            zzur zzur3 = zzur;
            if (zzm(zzur3, zzf2, zzbp.zzw(), zzbp.zzb(), zzbp.zzc(), i2)) {
                return zzur3;
            }
        }
        return null;
    }

    private final void zzk(zzfzq zzfzq, zzur zzur, zzbv zzbv) {
        if (zzur != null) {
            if (zzbv.zza(zzur.zza) != -1) {
                zzfzq.zza(zzur, zzbv);
                return;
            }
            zzbv zzbv2 = (zzbv) this.zzc.get(zzur);
            if (zzbv2 != null) {
                zzfzq.zza(zzur, zzbv2);
            }
        }
    }

    private final void zzl(zzbv zzbv) {
        zzfzq zzfzq = new zzfzq();
        if (this.zzb.isEmpty()) {
            zzk(zzfzq, this.zze, zzbv);
            if (!zzfwn.zza(this.zzf, this.zze)) {
                zzk(zzfzq, this.zzf, zzbv);
            }
            if (!zzfwn.zza(this.zzd, this.zze) && !zzfwn.zza(this.zzd, this.zzf)) {
                zzk(zzfzq, this.zzd, zzbv);
            }
        } else {
            for (int i = 0; i < this.zzb.size(); i++) {
                zzk(zzfzq, (zzur) this.zzb.get(i), zzbv);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfzq, this.zzd, zzbv);
            }
        }
        this.zzc = zzfzq.zzc();
    }

    private static boolean zzm(zzur zzur, Object obj, boolean z, int i, int i2, int i3) {
        if (!zzur.zza.equals(obj)) {
            return false;
        }
        return z ? zzur.zzb == i && zzur.zzc == i2 : zzur.zzb == -1 && zzur.zze == i3;
    }

    public final zzbv zza(zzur zzur) {
        return (zzbv) this.zzc.get(zzur);
    }

    public final zzur zzb() {
        return this.zzd;
    }

    public final zzur zzc() {
        Object obj;
        Object next;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfzo zzfzo = this.zzb;
        if (zzfzo instanceof List) {
            List list = zzfzo;
            if (!list.isEmpty()) {
                obj = list.get(list.size() - 1);
            } else {
                throw new NoSuchElementException();
            }
        } else {
            Iterator it = zzfzo.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        }
        return (zzur) obj;
    }

    public final zzur zzd() {
        return this.zze;
    }

    public final zzur zze() {
        return this.zzf;
    }

    public final void zzg(zzbp zzbp) {
        this.zzd = zzj(zzbp, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List list, zzur zzur, zzbp zzbp) {
        this.zzb = zzfzo.zzl(list);
        if (!list.isEmpty()) {
            this.zze = (zzur) list.get(0);
            zzur.getClass();
            zzur zzur2 = zzur;
            this.zzf = zzur;
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzbp, this.zzb, this.zze, this.zza);
        }
        zzl(zzbp.zzn());
    }

    public final void zzi(zzbp zzbp) {
        this.zzd = zzj(zzbp, this.zzb, this.zze, this.zza);
        zzl(zzbp.zzn());
    }
}
