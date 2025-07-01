package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzvv implements zzuq {
    private final zzgc zza;
    private int zzb = 1048576;
    private final zzvu zzc;
    private final zzyw zzd;

    public zzvv(zzgc zzgc, zzvu zzvu) {
        zzyw zzyw = new zzyw(-1);
        this.zza = zzgc;
        this.zzc = zzvu;
        this.zzd = zzyw;
    }

    public final zzvv zza(int i) {
        this.zzb = i;
        return this;
    }

    public final zzvx zzb(zzaw zzaw) {
        zzaw.zzb.getClass();
        return new zzvx(zzaw, this.zza, this.zzc, zzrp.zza, this.zzd, this.zzb, (zzvw) null);
    }
}
