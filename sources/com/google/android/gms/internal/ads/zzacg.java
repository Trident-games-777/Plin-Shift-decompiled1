package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzacg implements zzacs {
    private final byte[] zza = new byte[4096];
    private final zzn zzb;
    private final long zzc;
    private long zzd;
    private byte[] zze = new byte[65536];
    private int zzf;
    private int zzg;

    static {
        zzax.zzb("media3.extractor");
    }

    public zzacg(zzn zzn, long j, long j2) {
        this.zzb = zzn;
        this.zzd = j;
        this.zzc = j2;
    }

    private final int zzp(byte[] bArr, int i, int i2) {
        int i3 = this.zzg;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.zze, 0, bArr, i, min);
        zzu(min);
        return min;
    }

    private final int zzq(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (!Thread.interrupted()) {
            int zza2 = this.zzb.zza(bArr, i + i3, i2 - i3);
            if (zza2 != -1) {
                return i3 + zza2;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    private final int zzr(int i) {
        int min = Math.min(this.zzg, i);
        zzu(min);
        return min;
    }

    private final void zzs(int i) {
        if (i != -1) {
            this.zzd += (long) i;
        }
    }

    private final void zzt(int i) {
        int i2 = this.zzf + i;
        int length = this.zze.length;
        if (i2 > length) {
            this.zze = Arrays.copyOf(this.zze, Math.max(65536 + i2, Math.min(length + length, i2 + 524288)));
        }
    }

    private final void zzu(int i) {
        int i2 = this.zzg - i;
        this.zzg = i2;
        this.zzf = 0;
        byte[] bArr = this.zze;
        byte[] bArr2 = i2 < bArr.length + -524288 ? new byte[(65536 + i2)] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.zze = bArr2;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int zzp = zzp(bArr, i, i2);
        if (zzp == 0) {
            zzp = zzq(bArr, i, i2, 0, true);
        }
        zzs(zzp);
        return zzp;
    }

    public final int zzb(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        zzacg zzacg;
        zzt(i2);
        int i4 = this.zzg;
        int i5 = this.zzf;
        int i6 = i4 - i5;
        if (i6 == 0) {
            zzacg = this;
            i3 = zzacg.zzq(this.zze, i5, i2, 0, true);
            if (i3 == -1) {
                return -1;
            }
            zzacg.zzg += i3;
        } else {
            zzacg = this;
            i3 = Math.min(i2, i6);
        }
        System.arraycopy(zzacg.zze, zzacg.zzf, bArr, i, i3);
        zzacg.zzf += i3;
        return i3;
    }

    public final int zzc(int i) throws IOException {
        int zzr = zzr(1);
        if (zzr == 0) {
            zzr = zzq(this.zza, 0, Math.min(1, 4096), 0, true);
        }
        zzs(zzr);
        return zzr;
    }

    public final long zzd() {
        return this.zzc;
    }

    public final long zze() {
        return this.zzd + ((long) this.zzf);
    }

    public final long zzf() {
        return this.zzd;
    }

    public final void zzg(int i) throws IOException {
        zzl(i, false);
    }

    public final void zzh(byte[] bArr, int i, int i2) throws IOException {
        zzm(bArr, i, i2, false);
    }

    public final void zzi(byte[] bArr, int i, int i2) throws IOException {
        zzn(bArr, i, i2, false);
    }

    public final void zzj() {
        this.zzf = 0;
    }

    public final void zzk(int i) throws IOException {
        zzo(i, false);
    }

    public final boolean zzl(int i, boolean z) throws IOException {
        zzt(i);
        int i2 = this.zzg - this.zzf;
        while (i2 < i) {
            int i3 = i;
            boolean z2 = z;
            i2 = zzq(this.zze, this.zzf, i3, i2, z2);
            if (i2 == -1) {
                return false;
            }
            this.zzg = this.zzf + i2;
            i = i3;
            z = z2;
        }
        this.zzf += i;
        return true;
    }

    public final boolean zzm(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (!zzl(i2, z)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - i2, bArr, i, i2);
        return true;
    }

    public final boolean zzn(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int zzp = zzp(bArr, i, i2);
        while (zzp < i2 && zzp != -1) {
            zzp = zzq(bArr, i, i2, zzp, z);
        }
        zzs(zzp);
        return zzp != -1;
    }

    public final boolean zzo(int i, boolean z) throws IOException {
        int zzr = zzr(i);
        while (zzr < i && zzr != -1) {
            zzr = zzq(this.zza, -zzr, Math.min(i, zzr + 4096), zzr, false);
        }
        zzs(zzr);
        return zzr != -1;
    }
}
