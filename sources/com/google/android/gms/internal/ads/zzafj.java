package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzafj extends zzade {
    final /* synthetic */ zzadq zza;
    final /* synthetic */ zzafk zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzafj(zzafk zzafk, zzadq zzadq, zzadq zzadq2) {
        super(zzadq);
        this.zza = zzadq2;
        this.zzb = zzafk;
    }

    public final zzado zzg(long j) {
        zzado zzg = this.zza.zzg(j);
        zzadr zzadr = zzg.zza;
        zzadr zzadr2 = new zzadr(zzadr.zzb, zzadr.zzc + this.zzb.zzb);
        zzadr zzadr3 = zzg.zzb;
        return new zzado(zzadr2, new zzadr(zzadr3.zzb, zzadr3.zzc + this.zzb.zzb));
    }
}
