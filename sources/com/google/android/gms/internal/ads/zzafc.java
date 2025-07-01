package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzafc extends zzafb {
    private final zzed zzb = new zzed(zzfp.zza);
    private final zzed zzc = new zzed(4);
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzafc(zzadx zzadx) {
        super(zzadx);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzed zzed) throws zzafa {
        int zzm = zzed.zzm();
        int i = zzm >> 4;
        int i2 = zzm & 15;
        if (i2 == 7) {
            this.zzg = i;
            return i != 5;
        }
        throw new zzafa("Video format not supported: " + i2);
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzed zzed, long j) throws zzbh {
        int i;
        int zzm = zzed.zzm();
        long zzh = (long) zzed.zzh();
        if (zzm == 0) {
            if (!this.zze) {
                zzed zzed2 = new zzed(new byte[zzed.zzb()]);
                zzed.zzH(zzed2.zzN(), 0, zzed.zzb());
                zzabv zza = zzabv.zza(zzed2);
                this.zzd = zza.zzb;
                zzab zzab = new zzab();
                zzab.zzZ("video/avc");
                zzab.zzA(zza.zzl);
                zzab.zzae(zza.zzc);
                zzab.zzJ(zza.zzd);
                zzab.zzV(zza.zzk);
                zzab.zzM(zza.zza);
                this.zza.zzl(zzab.zzaf());
                this.zze = true;
                return false;
            }
        } else if (zzm == 1 && this.zze) {
            int i2 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i = i2;
            } else if (i2 != 0) {
                i = 1;
            }
            byte[] zzN = this.zzc.zzN();
            zzN[0] = 0;
            zzN[1] = 0;
            zzN[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzed.zzb() > 0) {
                zzed.zzH(this.zzc.zzN(), i3, this.zzd);
                this.zzc.zzL(0);
                zzed zzed3 = this.zzc;
                zzed zzed4 = this.zzb;
                int zzp = zzed3.zzp();
                zzed4.zzL(0);
                this.zza.zzq(this.zzb, 4);
                this.zza.zzq(zzed, zzp);
                i4 = i4 + 4 + zzp;
            }
            this.zza.zzs(j + (zzh * 1000), i, i4, 0, (zzadw) null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
