package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
class zzgxm extends zzgxl {
    protected final byte[] zza;

    zzgxm(byte[] bArr) {
        super((zzgxo) null);
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgxp) || zzd() != ((zzgxp) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgxm)) {
            return obj.equals(this);
        }
        zzgxm zzgxm = (zzgxm) obj;
        int zzr = zzr();
        int zzr2 = zzgxm.zzr();
        if (zzr == 0 || zzr2 == 0 || zzr == zzr2) {
            return zzg(zzgxm, 0, zzd());
        }
        return false;
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: protected */
    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    /* access modifiers changed from: protected */
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(zzgxp zzgxp, int i, int i2) {
        if (i2 <= zzgxp.zzd()) {
            int i3 = i + i2;
            if (i3 > zzgxp.zzd()) {
                int zzd = zzgxp.zzd();
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzd);
            } else if (!(zzgxp instanceof zzgxm)) {
                return zzgxp.zzk(i, i3).equals(zzk(0, i2));
            } else {
                zzgxm zzgxm = (zzgxm) zzgxp;
                byte[] bArr = this.zza;
                byte[] bArr2 = zzgxm.zza;
                int zzc = zzc() + i2;
                int zzc2 = zzc();
                int zzc3 = zzgxm.zzc() + i;
                while (zzc2 < zzc) {
                    if (bArr[zzc2] != bArr2[zzc3]) {
                        return false;
                    }
                    zzc2++;
                    zzc3++;
                }
                return true;
            }
        } else {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + i2 + zzd2);
        }
    }

    /* access modifiers changed from: protected */
    public final int zzi(int i, int i2, int i3) {
        return zzgzk.zzb(i, this.zza, zzc() + i2, i3);
    }

    /* access modifiers changed from: protected */
    public final int zzj(int i, int i2, int i3) {
        int zzc = zzc() + i2;
        return zzhbz.zzf(i, this.zza, zzc, i3 + zzc);
    }

    public final zzgxp zzk(int i, int i2) {
        int zzq = zzq(i, i2, zzd());
        if (zzq == 0) {
            return zzgxp.zzb;
        }
        return new zzgxj(this.zza, zzc() + i, zzq);
    }

    public final zzgxv zzl() {
        return zzgxv.zzH(this.zza, zzc(), zzd(), true);
    }

    /* access modifiers changed from: protected */
    public final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public final void zzo(zzgxg zzgxg) throws IOException {
        zzgxg.zza(this.zza, zzc(), zzd());
    }

    public final boolean zzp() {
        int zzc = zzc();
        return zzhbz.zzi(this.zza, zzc, zzd() + zzc);
    }
}
