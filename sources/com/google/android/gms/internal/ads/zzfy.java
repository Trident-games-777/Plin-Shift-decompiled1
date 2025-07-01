package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfy extends zzfw {
    private Uri zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private final zzfx zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfy(byte[] bArr) {
        super(false);
        zzfx zzfx = new zzfx(bArr);
        boolean z = false;
        zzfx zzfx2 = zzfx;
        this.zzf = zzfx;
        zzdb.zzd(bArr.length > 0 ? true : z);
    }

    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        byte[] bArr2 = this.zzb;
        zzdb.zzb(bArr2);
        System.arraycopy(bArr2, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    public final long zzb(zzgi zzgi) throws IOException {
        zzi(zzgi);
        this.zza = zzgi.zza;
        this.zzb = this.zzf.zza;
        long j = zzgi.zze;
        int length = this.zzb.length;
        if (j <= ((long) length)) {
            int i = (int) j;
            this.zzc = i;
            int i2 = length - i;
            this.zzd = i2;
            long j2 = zzgi.zzf;
            if (j2 != -1) {
                this.zzd = (int) Math.min((long) i2, j2);
            }
            this.zze = true;
            zzj(zzgi);
            long j3 = zzgi.zzf;
            return j3 != -1 ? j3 : (long) this.zzd;
        }
        throw new zzge(2008);
    }

    public final Uri zzc() {
        return this.zza;
    }

    public final void zzd() {
        if (this.zze) {
            this.zze = false;
            zzh();
        }
        this.zza = null;
        this.zzb = null;
    }
}
