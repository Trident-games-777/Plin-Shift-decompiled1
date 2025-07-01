package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamw implements zzamm {
    private final zzed zza = new zzed(10);
    private zzadx zzb;
    private boolean zzc;
    private long zzd = -9223372036854775807L;
    private int zze;
    private int zzf;

    public final void zza(zzed zzed) {
        zzdb.zzb(this.zzb);
        if (this.zzc) {
            int zzb2 = zzed.zzb();
            int i = this.zzf;
            if (i < 10) {
                int min = Math.min(zzb2, 10 - i);
                System.arraycopy(zzed.zzN(), zzed.zzd(), this.zza.zzN(), this.zzf, min);
                if (this.zzf + min == 10) {
                    this.zza.zzL(0);
                    if (this.zza.zzm() == 73 && this.zza.zzm() == 68 && this.zza.zzm() == 51) {
                        this.zza.zzM(3);
                        this.zze = this.zza.zzl() + 10;
                    } else {
                        zzdt.zzf("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzc = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(zzb2, this.zze - this.zzf);
            this.zzb.zzq(zzed, min2);
            this.zzf += min2;
        }
    }

    public final void zzb(zzacu zzacu, zzaoa zzaoa) {
        zzaoa.zzc();
        zzadx zzw = zzacu.zzw(zzaoa.zza(), 5);
        this.zzb = zzw;
        zzab zzab = new zzab();
        zzab.zzL(zzaoa.zzb());
        zzab.zzZ("application/id3");
        zzw.zzl(zzab.zzaf());
    }

    public final void zzc(boolean z) {
        int i;
        zzdb.zzb(this.zzb);
        if (this.zzc && (i = this.zze) != 0 && this.zzf == i) {
            zzdb.zzf(this.zzd != -9223372036854775807L);
            this.zzb.zzs(this.zzd, 1, this.zze, 0, (zzadw) null);
            this.zzc = false;
        }
    }

    public final void zzd(long j, int i) {
        if ((i & 4) != 0) {
            this.zzc = true;
            this.zzd = j;
            this.zze = 0;
            this.zzf = 0;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzd = -9223372036854775807L;
    }
}
