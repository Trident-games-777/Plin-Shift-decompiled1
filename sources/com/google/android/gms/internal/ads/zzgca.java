package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
class zzgca extends zzgcb {
    @CheckForNull
    private volatile zzgcb zza;
    final zzgbw zzb;
    @CheckForNull
    final Character zzc;

    zzgca(zzgbw zzgbw, @CheckForNull Character ch) {
        zzgbw zzgbw2 = zzgbw;
        this.zzb = zzgbw;
        if (ch != null) {
            ch.charValue();
            if (zzgbw.zze('=')) {
                throw new IllegalArgumentException(zzfxf.zzb("Padding character %s was already in alphabet", ch));
            }
        }
        this.zzc = ch;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzgca) {
            zzgca zzgca = (zzgca) obj;
            if (!this.zzb.equals(zzgca.zzb) || !Objects.equals(this.zzc, zzgca.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzc;
        return Objects.hashCode(ch) ^ this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int zza(byte[] bArr, CharSequence charSequence) throws zzgbz {
        zzgbw zzgbw;
        CharSequence zzg = zzg(charSequence);
        if (this.zzb.zzd(zzg.length())) {
            int i = 0;
            int i2 = 0;
            while (i < zzg.length()) {
                long j = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    zzgbw = this.zzb;
                    if (i3 >= zzgbw.zzc) {
                        break;
                    }
                    j <<= zzgbw.zzb;
                    if (i + i3 < zzg.length()) {
                        j |= (long) this.zzb.zzb(zzg.charAt(i4 + i));
                        i4++;
                    }
                    i3++;
                }
                int i5 = zzgbw.zzd;
                int i6 = i4 * zzgbw.zzb;
                int i7 = (i5 - 1) * 8;
                while (i7 >= (i5 * 8) - i6) {
                    bArr[i2] = (byte) ((int) ((j >>> i7) & 255));
                    i7 -= 8;
                    i2++;
                }
                i += this.zzb.zzc;
            }
            return i2;
        }
        throw new zzgbz("Invalid input length " + zzg.length());
    }

    /* access modifiers changed from: package-private */
    public zzgcb zzb(zzgbw zzgbw, @CheckForNull Character ch) {
        return new zzgca(zzgbw, ch);
    }

    /* access modifiers changed from: package-private */
    public void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzfwq.zzj(0, i2, bArr.length);
        while (i3 < i2) {
            zzh(appendable, bArr, i3, Math.min(this.zzb.zzd, i2 - i3));
            i3 += this.zzb.zzd;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        return (int) (((((long) this.zzb.zzb) * ((long) i)) + 7) / 8);
    }

    /* access modifiers changed from: package-private */
    public final int zze(int i) {
        zzgbw zzgbw = this.zzb;
        return zzgbw.zzc * zzgck.zzb(i, zzgbw.zzd, RoundingMode.CEILING);
    }

    public final zzgcb zzf() {
        zzgcb zzgcb = this.zza;
        if (zzgcb == null) {
            zzgbw zzgbw = this.zzb;
            zzgbw zzc2 = zzgbw.zzc();
            if (zzc2 == zzgbw) {
                zzgcb = this;
            } else {
                zzgcb = zzb(zzc2, this.zzc);
            }
            this.zza = zzgcb;
        }
        return zzgcb;
    }

    /* access modifiers changed from: package-private */
    public final void zzh(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzfwq.zzj(i, i + i2, bArr.length);
        int i3 = 0;
        zzfwq.zze(i2 <= this.zzb.zzd);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | ((long) (bArr[i + i4] & 255))) << 8;
        }
        int i5 = (i2 + 1) * 8;
        zzgbw zzgbw = this.zzb;
        while (i3 < i2 * 8) {
            long j2 = j >>> ((i5 - zzgbw.zzb) - i3);
            zzgbw zzgbw2 = this.zzb;
            appendable.append(zzgbw2.zza(((int) j2) & zzgbw2.zza));
            i3 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i3 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i3 += this.zzb.zzb;
            }
        }
    }

    zzgca(String str, String str2, @CheckForNull Character ch) {
        this(new zzgbw(str, str2.toCharArray()), ch);
    }

    /* access modifiers changed from: package-private */
    public final CharSequence zzg(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0 || charSequence.charAt(length) != '=') {
            }
            length--;
            break;
        } while (charSequence.charAt(length) != '=');
        return charSequence.subSequence(0, length + 1);
    }
}
