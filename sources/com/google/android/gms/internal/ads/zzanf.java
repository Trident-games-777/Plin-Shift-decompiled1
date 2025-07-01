package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzanf implements zzann {
    private zzad zza;
    private zzek zzb;
    private zzadx zzc;

    public zzanf(String str) {
        zzab zzab = new zzab();
        zzab.zzZ(str);
        this.zza = zzab.zzaf();
    }

    public final void zza(zzed zzed) {
        zzdb.zzb(this.zzb);
        int i = zzen.zza;
        long zze = this.zzb.zze();
        long zzf = this.zzb.zzf();
        if (zze != -9223372036854775807L && zzf != -9223372036854775807L) {
            zzad zzad = this.zza;
            if (zzf != zzad.zzt) {
                zzab zzb2 = zzad.zzb();
                zzb2.zzad(zzf);
                zzad zzaf = zzb2.zzaf();
                this.zza = zzaf;
                this.zzc.zzl(zzaf);
            }
            int zzb3 = zzed.zzb();
            this.zzc.zzq(zzed, zzb3);
            this.zzc.zzs(zze, 1, zzb3, 0, (zzadw) null);
        }
    }

    public final void zzb(zzek zzek, zzacu zzacu, zzaoa zzaoa) {
        this.zzb = zzek;
        zzaoa.zzc();
        zzadx zzw = zzacu.zzw(zzaoa.zza(), 5);
        this.zzc = zzw;
        zzw.zzl(this.zza);
    }
}
