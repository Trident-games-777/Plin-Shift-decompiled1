package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzgxn extends OutputStream {
    private static final byte[] zza = new byte[0];
    private final int zzb = 128;
    private final ArrayList zzc = new ArrayList();
    private int zzd;
    private byte[] zze = new byte[128];
    private int zzf;

    zzgxn(int i) {
    }

    private final void zzc(int i) {
        this.zzc.add(new zzgxm(this.zze));
        int length = this.zzd + this.zze.length;
        this.zzd = length;
        this.zze = new byte[Math.max(this.zzb, Math.max(i, length >>> 1))];
        this.zzf = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zza())});
    }

    public final synchronized void write(int i) {
        if (this.zzf == this.zze.length) {
            zzc(1);
        }
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        this.zzf = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public final synchronized int zza() {
        return this.zzd + this.zzf;
    }

    public final synchronized zzgxp zzb() {
        int i = this.zzf;
        byte[] bArr = this.zze;
        if (i >= bArr.length) {
            this.zzc.add(new zzgxm(this.zze));
            this.zze = zza;
        } else if (i > 0) {
            this.zzc.add(new zzgxm(Arrays.copyOf(bArr, i)));
        }
        this.zzd += this.zzf;
        this.zzf = 0;
        return zzgxp.zzu(this.zzc);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.zze;
        int length = bArr2.length;
        int i3 = this.zzf;
        int i4 = length - i3;
        if (i2 <= i4) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.zzf += i2;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i3, i4);
        int i5 = i2 - i4;
        zzc(i5);
        System.arraycopy(bArr, i + i4, this.zze, 0, i5);
        this.zzf = i5;
    }
}
