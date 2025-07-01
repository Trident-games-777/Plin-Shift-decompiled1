package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zztq implements zzut {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zzva zzc = new zzva();
    private final zzrk zzd = new zzrk();
    private Looper zze;
    private zzbv zzf;
    private zzoj zzg;

    public /* synthetic */ zzbv zzM() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final zzoj zzb() {
        zzoj zzoj = this.zzg;
        zzdb.zzb(zzoj);
        zzoj zzoj2 = zzoj;
        return zzoj;
    }

    /* access modifiers changed from: protected */
    public final zzrk zzc(zzur zzur) {
        return this.zzd.zza(0, zzur);
    }

    /* access modifiers changed from: protected */
    public final zzrk zzd(int i, zzur zzur) {
        return this.zzd.zza(0, zzur);
    }

    /* access modifiers changed from: protected */
    public final zzva zze(zzur zzur) {
        return this.zzc.zza(0, zzur);
    }

    /* access modifiers changed from: protected */
    public final zzva zzf(int i, zzur zzur) {
        return this.zzc.zza(0, zzur);
    }

    public final void zzg(Handler handler, zzrl zzrl) {
        this.zzd.zzb(handler, zzrl);
    }

    public final void zzh(Handler handler, zzvb zzvb) {
        this.zzc.zzb(handler, zzvb);
    }

    public final void zzi(zzus zzus) {
        boolean isEmpty = this.zzb.isEmpty();
        this.zzb.remove(zzus);
        if (!isEmpty && this.zzb.isEmpty()) {
            zzj();
        }
    }

    /* access modifiers changed from: protected */
    public void zzj() {
    }

    public final void zzk(zzus zzus) {
        this.zze.getClass();
        HashSet hashSet = this.zzb;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.add(zzus);
        if (isEmpty) {
            zzl();
        }
    }

    /* access modifiers changed from: protected */
    public void zzl() {
    }

    public final void zzm(zzus zzus, zzhd zzhd, zzoj zzoj) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z = true;
        if (!(looper == null || looper == myLooper)) {
            z = false;
        }
        zzdb.zzd(z);
        this.zzg = zzoj;
        zzbv zzbv = this.zzf;
        this.zza.add(zzus);
        if (this.zze == null) {
            this.zze = myLooper;
            this.zzb.add(zzus);
            zzn(zzhd);
        } else if (zzbv != null) {
            zzk(zzus);
            zzus.zza(this, zzbv);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzn(zzhd zzhd);

    /* access modifiers changed from: protected */
    public final void zzo(zzbv zzbv) {
        this.zzf = zzbv;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzus) arrayList.get(i)).zza(this, zzbv);
        }
    }

    public final void zzp(zzus zzus) {
        this.zza.remove(zzus);
        if (this.zza.isEmpty()) {
            this.zze = null;
            this.zzf = null;
            this.zzg = null;
            this.zzb.clear();
            zzq();
            return;
        }
        zzi(zzus);
    }

    /* access modifiers changed from: protected */
    public abstract void zzq();

    public final void zzr(zzrl zzrl) {
        this.zzd.zzc(zzrl);
    }

    public final void zzs(zzvb zzvb) {
        this.zzc.zzh(zzvb);
    }

    public /* synthetic */ void zzt(zzaw zzaw) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzu() {
        return !this.zzb.isEmpty();
    }

    public /* synthetic */ boolean zzv() {
        return true;
    }
}
