package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzanl {
    private final zzamm zza;
    private final zzek zzb;
    private final zzec zzc = new zzec(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzanl(zzamm zzamm, zzek zzek) {
        this.zza = zzamm;
        this.zzb = zzek;
    }

    public final void zza(zzed zzed) throws zzbh {
        long j;
        boolean z;
        zzed zzed2 = zzed;
        zzed2.zzH(this.zzc.zza, 0, 3);
        this.zzc.zzl(0);
        this.zzc.zzn(8);
        this.zzd = this.zzc.zzp();
        this.zze = this.zzc.zzp();
        this.zzc.zzn(6);
        zzec zzec = this.zzc;
        zzed2.zzH(zzec.zza, 0, zzec.zzd(8));
        this.zzc.zzl(0);
        if (this.zzd) {
            this.zzc.zzn(4);
            long zzd2 = (long) this.zzc.zzd(3);
            this.zzc.zzn(1);
            int zzd3 = this.zzc.zzd(15) << 15;
            this.zzc.zzn(1);
            long zzd4 = (long) this.zzc.zzd(15);
            this.zzc.zzn(1);
            if (this.zzf || !this.zze) {
                z = true;
            } else {
                this.zzc.zzn(4);
                this.zzc.zzn(1);
                this.zzc.zzn(1);
                long zzd5 = (long) this.zzc.zzd(15);
                this.zzc.zzn(1);
                z = true;
                this.zzb.zzb((((long) this.zzc.zzd(3)) << 30) | ((long) (this.zzc.zzd(15) << 15)) | zzd5);
                this.zzf = true;
            }
            j = this.zzb.zzb((zzd2 << (z ? 1 : 0)) | ((long) zzd3) | zzd4);
        } else {
            j = 0;
        }
        this.zza.zzd(j, 4);
        this.zza.zza(zzed2);
        this.zza.zzc(false);
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zze();
    }
}
