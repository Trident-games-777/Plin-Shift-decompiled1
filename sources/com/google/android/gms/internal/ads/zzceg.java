package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzceg implements zzgd {
    private final zzgd zza;
    private final long zzb;
    private final zzgd zzc;
    private long zzd;
    private Uri zze;

    zzceg(zzgd zzgd, int i, zzgd zzgd2) {
        this.zza = zzgd;
        this.zzb = (long) i;
        this.zzc = zzgd2;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int zza2 = this.zza.zza(bArr, i, (int) Math.min((long) i2, j2 - j));
            long j3 = this.zzd + ((long) zza2);
            this.zzd = j3;
            i3 = zza2;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < this.zzb) {
            return i3;
        }
        int zza3 = this.zzc.zza(bArr, i + i3, i2 - i3);
        int i4 = i3 + zza3;
        this.zzd += (long) zza3;
        return i4;
    }

    public final long zzb(zzgi zzgi) throws IOException {
        zzgi zzgi2;
        zzgi zzgi3 = zzgi;
        this.zze = zzgi3.zza;
        long j = zzgi3.zze;
        long j2 = this.zzb;
        zzgi zzgi4 = null;
        if (j >= j2) {
            zzgi2 = null;
        } else {
            long j3 = zzgi3.zzf;
            long j4 = j2 - j;
            if (j3 != -1) {
                j4 = Math.min(j3, j4);
            }
            zzgi2 = new zzgi(zzgi3.zza, j, j4, (String) null);
        }
        long j5 = zzgi3.zzf;
        if (j5 == -1 || zzgi3.zze + j5 > this.zzb) {
            long max = Math.max(this.zzb, zzgi3.zze);
            long j6 = zzgi3.zzf;
            zzgi4 = new zzgi(zzgi3.zza, max, j6 != -1 ? Math.min(j6, (zzgi3.zze + j6) - this.zzb) : -1, (String) null);
        }
        long j7 = 0;
        long zzb2 = zzgi2 != null ? this.zza.zzb(zzgi2) : 0;
        if (zzgi4 != null) {
            j7 = this.zzc.zzb(zzgi4);
        }
        this.zzd = zzgi3.zze;
        if (zzb2 == -1 || j7 == -1) {
            return -1;
        }
        return zzb2 + j7;
    }

    public final Uri zzc() {
        return this.zze;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    public final Map zze() {
        return zzfzr.zzd();
    }

    public final void zzf(zzhd zzhd) {
    }
}
