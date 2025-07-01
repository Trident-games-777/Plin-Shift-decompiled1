package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzace implements zzadq {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zzace(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length > 0) {
            int i = length - 1;
            this.zzf = jArr2[i] + jArr3[i];
            return;
        }
        this.zzf = 0;
    }

    public final String toString() {
        long[] jArr = this.zzd;
        long[] jArr2 = this.zze;
        long[] jArr3 = this.zzc;
        String arrays = Arrays.toString(this.zzb);
        String arrays2 = Arrays.toString(jArr3);
        String arrays3 = Arrays.toString(jArr2);
        String arrays4 = Arrays.toString(jArr);
        return "ChunkIndex(length=" + this.zza + ", sizes=" + arrays + ", offsets=" + arrays2 + ", timeUs=" + arrays3 + ", durationsUs=" + arrays4 + ")";
    }

    public final long zza() {
        return this.zzf;
    }

    public final zzado zzg(long j) {
        long[] jArr = this.zze;
        int zzd2 = zzen.zzd(jArr, j, true, true);
        zzadr zzadr = new zzadr(jArr[zzd2], this.zzc[zzd2]);
        if (zzadr.zzb >= j || zzd2 == this.zza - 1) {
            return new zzado(zzadr, zzadr);
        }
        int i = zzd2 + 1;
        return new zzado(zzadr, new zzadr(this.zze[i], this.zzc[i]));
    }

    public final boolean zzh() {
        return true;
    }
}
