package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaet implements zzacb {
    private final zzadc zza;
    private final int zzb;
    private final zzacx zzc = new zzacx();

    /* synthetic */ zzaet(zzadc zzadc, int i, zzaeu zzaeu) {
        this.zza = zzadc;
        this.zzb = i;
    }

    private final long zzc(zzacs zzacs) throws IOException {
        while (zzacs.zze() < zzacs.zzd() - 6) {
            zzadc zzadc = this.zza;
            int i = this.zzb;
            zzacx zzacx = this.zzc;
            long zze = zzacs.zze();
            byte[] bArr = new byte[2];
            zzacs.zzh(bArr, 0, 2);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                zzacs.zzj();
                zzacs.zzg((int) (zze - zzacs.zzf()));
            } else {
                zzed zzed = new zzed(16);
                System.arraycopy(bArr, 0, zzed.zzN(), 0, 2);
                zzed.zzK(zzacv.zza(zzacs, zzed.zzN(), 2, 14));
                zzacs.zzj();
                zzacs.zzg((int) (zze - zzacs.zzf()));
                if (zzacy.zzc(zzed, zzadc, i, zzacx)) {
                    break;
                }
            }
            zzacs.zzg(1);
        }
        if (zzacs.zze() < zzacs.zzd() - 6) {
            return this.zzc.zza;
        }
        zzacs.zzg((int) (zzacs.zzd() - zzacs.zze()));
        return this.zza.zzj;
    }

    public final zzaca zza(zzacs zzacs, long j) throws IOException {
        long zzf = zzacs.zzf();
        long zzc2 = zzc(zzacs);
        long zze = zzacs.zze();
        zzacs.zzg(Math.max(6, this.zza.zzc));
        int i = (zzc2 > j ? 1 : (zzc2 == j ? 0 : -1));
        long zzc3 = zzc(zzacs);
        long zze2 = zzacs.zze();
        if (i > 0 || zzc3 <= j) {
            return zzc3 <= j ? zzaca.zzf(zzc3, zze2) : zzaca.zzd(zzc2, zzf);
        }
        return zzaca.zze(zze);
    }

    public final /* synthetic */ void zzb() {
    }
}
