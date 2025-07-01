package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzanr implements zzacb {
    private final zzek zza;
    private final zzed zzb = new zzed();
    private final int zzc;

    public zzanr(int i, zzek zzek, int i2) {
        this.zzc = i;
        this.zza = zzek;
    }

    public final zzaca zza(zzacs zzacs, long j) throws IOException {
        int zza2;
        int i;
        long zzf = zzacs.zzf();
        int min = (int) Math.min(112800, zzacs.zzd() - zzf);
        this.zzb.zzI(min);
        zzacs.zzh(this.zzb.zzN(), 0, min);
        zzed zzed = this.zzb;
        int zze = zzed.zze();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzed.zzb() >= 188 && (i = zza2 + 188) <= zze) {
            long zzb2 = zzaoc.zzb(zzed, (zza2 = zzaoc.zza(zzed.zzN(), zzed.zzd(), zze)), this.zzc);
            if (zzb2 != -9223372036854775807L) {
                long zzb3 = this.zza.zzb(zzb2);
                if (zzb3 > j) {
                    return j3 == -9223372036854775807L ? zzaca.zzd(zzb3, zzf) : zzaca.zze(zzf + j4);
                }
                j4 = (long) zza2;
                if (100000 + zzb3 > j) {
                    return zzaca.zze(zzf + j4);
                }
                j3 = zzb3;
            }
            zzed.zzL(i);
            j2 = (long) i;
        }
        return j3 != -9223372036854775807L ? zzaca.zzf(j3, zzf + j2) : zzaca.zza;
    }

    public final void zzb() {
        byte[] bArr = zzen.zzf;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
    }
}
