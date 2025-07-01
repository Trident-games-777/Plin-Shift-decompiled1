package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzvx extends zztq implements zzvo {
    private final zzgc zza;
    private final zzrp zzb;
    private final int zzc;
    private boolean zzd = true;
    private long zze = -9223372036854775807L;
    private boolean zzf;
    private boolean zzg;
    private zzhd zzh;
    private zzaw zzi;
    private final zzvu zzj;
    private final zzyw zzk;

    /* synthetic */ zzvx(zzaw zzaw, zzgc zzgc, zzvu zzvu, zzrp zzrp, zzyw zzyw, int i, zzvw zzvw) {
        this.zzi = zzaw;
        this.zza = zzgc;
        this.zzj = zzvu;
        this.zzb = zzrp;
        this.zzk = zzyw;
        this.zzc = i;
    }

    private final void zzw() {
        long j = this.zze;
        boolean z = this.zzf;
        boolean z2 = this.zzg;
        zzaw zzJ = zzJ();
        zzbv zzwk = new zzwk(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j, 0, 0, z, false, false, (Object) null, zzJ, z2 ? zzJ.zzc : null);
        if (this.zzd) {
            zzwk = new zzvt(this, zzwk);
        }
        zzo(zzwk);
    }

    public final void zzG(zzup zzup) {
        ((zzvs) zzup).zzN();
    }

    public final zzup zzI(zzur zzur, zzys zzys, long j) {
        zzgd zza2 = this.zza.zza();
        zzhd zzhd = this.zzh;
        if (zzhd != null) {
            zza2.zzf(zzhd);
        }
        zzar zzar = zzJ().zzb;
        zzar.getClass();
        zzar zzar2 = zzar;
        Uri uri = zzar.zza;
        zzvu zzvu = this.zzj;
        zzb();
        return new zzvs(uri, zza2, new zztt(zzvu.zza), this.zzb, zzc(zzur), this.zzk, zze(zzur), this, zzys, (String) null, this.zzc, zzen.zzs(-9223372036854775807L));
    }

    public final synchronized zzaw zzJ() {
        return this.zzi;
    }

    public final void zza(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.zze;
        }
        if (this.zzd || this.zze != j || this.zzf != z || this.zzg != z2) {
            this.zze = j;
            this.zzf = z;
            this.zzg = z2;
            this.zzd = false;
            zzw();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzhd zzhd) {
        this.zzh = zzhd;
        Looper myLooper = Looper.myLooper();
        myLooper.getClass();
        Looper looper = myLooper;
        zzb();
        zzw();
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
    }

    public final synchronized void zzt(zzaw zzaw) {
        this.zzi = zzaw;
    }

    public final void zzz() {
    }
}
