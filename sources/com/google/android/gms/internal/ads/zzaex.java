package com.google.android.gms.internal.ads;

import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaex extends zzafb {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzaex(zzadx zzadx) {
        super(zzadx);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzed zzed) throws zzafa {
        String str;
        if (!this.zzc) {
            int zzm = zzed.zzm();
            int i = zzm >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(zzm >> 2) & 3];
                zzab zzab = new zzab();
                zzab.zzZ("audio/mpeg");
                zzab.zzz(1);
                zzab.zzaa(i2);
                this.zza.zzl(zzab.zzaf());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzab zzab2 = new zzab();
                if (i == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                zzab2.zzZ(str);
                zzab2.zzz(1);
                zzab2.zzaa(8000);
                this.zza.zzl(zzab2.zzaf());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzafa("Audio format not supported: " + i);
            }
            this.zzc = true;
        } else {
            zzed.zzM(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzed zzed, long j) throws zzbh {
        zzed zzed2 = zzed;
        if (this.zze == 2) {
            int zzb2 = zzed2.zzb();
            this.zza.zzq(zzed2, zzb2);
            this.zza.zzs(j, 1, zzb2, 0, (zzadw) null);
            return true;
        }
        int zzm = zzed2.zzm();
        if (zzm == 0 && !this.zzd) {
            int zzb3 = zzed2.zzb();
            byte[] bArr = new byte[zzb3];
            zzed2.zzH(bArr, 0, zzb3);
            zzabm zza = zzabo.zza(bArr);
            zzab zzab = new zzab();
            zzab.zzZ("audio/mp4a-latm");
            zzab.zzA(zza.zzc);
            zzab.zzz(zza.zzb);
            zzab.zzaa(zza.zza);
            zzab.zzM(Collections.singletonList(bArr));
            this.zza.zzl(zzab.zzaf());
            this.zzd = true;
            return false;
        } else if (this.zze == 10 && zzm != 1) {
            return false;
        } else {
            int zzb4 = zzed2.zzb();
            this.zza.zzq(zzed2, zzb4);
            this.zza.zzs(j, 1, zzb4, 0, (zzadw) null);
            return true;
        }
    }
}
