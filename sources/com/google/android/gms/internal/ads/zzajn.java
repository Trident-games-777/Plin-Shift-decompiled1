package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzajn extends zzajw {
    private zzadc zza;
    private zzajm zzb;

    zzajn() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* access modifiers changed from: protected */
    public final long zza(zzed zzed) {
        if (!zzd(zzed.zzN())) {
            return -1;
        }
        int i = (zzed.zzN()[2] & 255) >> 4;
        if (i != 6) {
            if (i == 7) {
                i = 7;
            }
            int zza2 = zzacy.zza(zzed, i);
            zzed.zzL(0);
            return (long) zza2;
        }
        zzed.zzM(4);
        zzed.zzx();
        int zza22 = zzacy.zza(zzed, i);
        zzed.zzL(0);
        return (long) zza22;
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzed zzed, long j, zzajt zzajt) {
        byte[] zzN = zzed.zzN();
        zzadc zzadc = this.zza;
        if (zzadc == null) {
            zzadc zzadc2 = new zzadc(zzN, 17);
            this.zza = zzadc2;
            zzajt.zza = zzadc2.zzc(Arrays.copyOfRange(zzN, 9, zzed.zze()), (zzbd) null);
            return true;
        } else if ((zzN[0] & Byte.MAX_VALUE) == 3) {
            zzadb zzb2 = zzacz.zzb(zzed);
            zzadc zzf = zzadc.zzf(zzb2);
            this.zza = zzf;
            this.zzb = new zzajm(zzf, zzb2);
            return true;
        } else if (!zzd(zzN)) {
            return true;
        } else {
            zzajm zzajm = this.zzb;
            if (zzajm != null) {
                zzajm.zza(j);
                zzajt.zzb = this.zzb;
            }
            zzajt.zza.getClass();
            return false;
        }
    }
}
