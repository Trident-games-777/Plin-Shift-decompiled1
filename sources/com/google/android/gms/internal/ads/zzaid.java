package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaid {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzed zzf;
    private final zzed zzg;
    private int zzh;
    private int zzi;

    public zzaid(zzed zzed, zzed zzed2, boolean z) throws zzbh {
        this.zzg = zzed;
        this.zzf = zzed2;
        this.zze = z;
        zzed2.zzL(12);
        this.zza = zzed2.zzp();
        zzed.zzL(12);
        this.zzi = zzed.zzp();
        zzacv.zzb(zzed.zzg() != 1 ? false : true, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        long j;
        int i = this.zzb + 1;
        this.zzb = i;
        if (i == this.zza) {
            return false;
        }
        if (this.zze) {
            j = this.zzf.zzw();
        } else {
            j = this.zzf.zzu();
        }
        this.zzd = j;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzp();
            this.zzg.zzM(4);
            int i2 = -1;
            int i3 = this.zzi - 1;
            this.zzi = i3;
            if (i3 > 0) {
                i2 = -1 + this.zzg.zzp();
            }
            this.zzh = i2;
        }
        return true;
    }
}
