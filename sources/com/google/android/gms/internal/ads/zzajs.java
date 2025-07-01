package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzajs extends zzajw {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    zzajs() {
    }

    public static boolean zzd(zzed zzed) {
        return zzk(zzed, zza);
    }

    private static boolean zzk(zzed zzed, byte[] bArr) {
        if (zzed.zzb() < 8) {
            return false;
        }
        int zzd = zzed.zzd();
        byte[] bArr2 = new byte[8];
        zzed.zzH(bArr2, 0, 8);
        zzed.zzL(zzd);
        return Arrays.equals(bArr2, bArr);
    }

    /* access modifiers changed from: protected */
    public final long zza(zzed zzed) {
        return zzg(zzadm.zzd(zzed.zzN()));
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zzc = false;
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzed zzed, long j, zzajt zzajt) throws zzbh {
        if (zzk(zzed, zza)) {
            byte[] copyOf = Arrays.copyOf(zzed.zzN(), zzed.zze());
            byte b = copyOf[9] & 255;
            List zze = zzadm.zze(copyOf);
            if (zzajt.zza == null) {
                zzab zzab = new zzab();
                zzab.zzZ("audio/opus");
                zzab.zzz(b);
                zzab.zzaa(48000);
                zzab.zzM(zze);
                zzajt.zza = zzab.zzaf();
                return true;
            }
        } else if (zzk(zzed, zzb)) {
            zzdb.zzb(zzajt.zza);
            if (!this.zzc) {
                this.zzc = true;
                zzed.zzM(8);
                zzbd zzb2 = zzaed.zzb(zzfzo.zzm(zzaed.zzc(zzed, false, false).zza));
                if (zzb2 != null) {
                    zzab zzb3 = zzajt.zza.zzb();
                    zzb3.zzS(zzb2.zzd(zzajt.zza.zzl));
                    zzajt.zza = zzb3.zzaf();
                }
            }
        } else {
            zzdb.zzb(zzajt.zza);
            return false;
        }
        return true;
    }
}
