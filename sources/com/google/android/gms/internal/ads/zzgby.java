package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import javax.annotation.CheckForNull;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgby extends zzgca {
    private zzgby(zzgbw zzgbw, @CheckForNull Character ch) {
        super(zzgbw, ch);
        zzfwq.zze(zzgbw.zzf.length == 64);
    }

    /* access modifiers changed from: package-private */
    public final int zza(byte[] bArr, CharSequence charSequence) throws zzgbz {
        CharSequence zzg = zzg(charSequence);
        if (this.zzb.zzd(zzg.length())) {
            int i = 0;
            int i2 = 0;
            while (i < zzg.length()) {
                int i3 = i2 + 1;
                int zzb = (this.zzb.zzb(zzg.charAt(i)) << 18) | (this.zzb.zzb(zzg.charAt(i + 1)) << 12);
                bArr[i2] = (byte) (zzb >>> 16);
                int i4 = i + 2;
                if (i4 < zzg.length()) {
                    int i5 = i + 3;
                    int zzb2 = zzb | (this.zzb.zzb(zzg.charAt(i4)) << 6);
                    int i6 = i2 + 2;
                    bArr[i3] = (byte) ((zzb2 >>> 8) & 255);
                    if (i5 < zzg.length()) {
                        i += 4;
                        i2 += 3;
                        bArr[i6] = (byte) ((zzb2 | this.zzb.zzb(zzg.charAt(i5))) & 255);
                    } else {
                        i2 = i6;
                        i = i5;
                    }
                } else {
                    i = i4;
                    i2 = i3;
                }
            }
            return i2;
        }
        throw new zzgbz("Invalid input length " + zzg.length());
    }

    /* access modifiers changed from: package-private */
    public final zzgcb zzb(zzgbw zzgbw, @CheckForNull Character ch) {
        return new zzgby(zzgbw, ch);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzfwq.zzj(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            zzgbw zzgbw = this.zzb;
            byte b = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << Ascii.DLE) | (bArr[i3 + 2] & 255);
            appendable.append(zzgbw.zza(b >>> Ascii.DC2));
            appendable.append(this.zzb.zza((b >>> Ascii.FF) & 63));
            appendable.append(this.zzb.zza((b >>> 6) & 63));
            appendable.append(this.zzb.zza(b & Utf8.REPLACEMENT_BYTE));
            i3 += 3;
        }
        if (i3 < i2) {
            zzh(appendable, bArr, i3, i2 - i3);
        }
    }

    zzgby(String str, String str2, @CheckForNull Character ch) {
        this(new zzgbw(str, str2.toCharArray()), ch);
    }
}
