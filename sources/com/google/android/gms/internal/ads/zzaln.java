package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaln implements zzaki {
    private final zzed zza = new zzed();
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final float zzf;
    private final int zzg;

    public zzaln(List list) {
        String str = "sans-serif";
        boolean z = false;
        if (list.size() == 1 && (((byte[]) list.get(0)).length == 48 || ((byte[]) list.get(0)).length == 53)) {
            byte[] bArr = (byte[]) list.get(0);
            this.zzc = bArr[24];
            this.zzd = ((bArr[26] & 255) << Ascii.CAN) | ((bArr[27] & 255) << Ascii.DLE) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.zze = true == "Serif".equals(zzen.zzC(bArr, 43, bArr.length + -43)) ? "serif" : str;
            int i = bArr[25] * Ascii.DC4;
            this.zzg = i;
            z = (bArr[0] & 32) != 0 ? true : z;
            this.zzb = z;
            if (z) {
                this.zzf = Math.max(0.0f, Math.min(((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i), 0.95f));
            } else {
                this.zzf = 0.85f;
            }
        } else {
            this.zzc = 0;
            this.zzd = -1;
            this.zze = str;
            this.zzb = false;
            this.zzf = 0.85f;
            this.zzg = -1;
        }
    }

    private static void zzb(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzc(android.text.SpannableStringBuilder r4, int r5, int r6, int r7, int r8, int r9) {
        /*
            if (r5 == r6) goto L_0x0047
            r6 = r9 | 33
            r9 = r5 & 1
            r0 = r5 & 2
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L_0x0021
            if (r0 == 0) goto L_0x0018
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r3 = 3
            r0.<init>(r3)
            r4.setSpan(r0, r7, r8, r6)
            goto L_0x002e
        L_0x0018:
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r0.<init>(r2)
            r4.setSpan(r0, r7, r8, r6)
            goto L_0x002d
        L_0x0021:
            if (r0 == 0) goto L_0x002d
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r3 = 2
            r0.<init>(r3)
            r4.setSpan(r0, r7, r8, r6)
            goto L_0x002e
        L_0x002d:
            r2 = r1
        L_0x002e:
            r5 = r5 & 4
            if (r5 != 0) goto L_0x003f
            if (r9 != 0) goto L_0x0047
            if (r2 != 0) goto L_0x0047
            android.text.style.StyleSpan r5 = new android.text.style.StyleSpan
            r5.<init>(r1)
            r4.setSpan(r5, r7, r8, r6)
            return
        L_0x003f:
            android.text.style.UnderlineSpan r5 = new android.text.style.UnderlineSpan
            r5.<init>()
            r4.setSpan(r5, r7, r8, r6)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaln.zzc(android.text.SpannableStringBuilder, int, int, int, int, int):void");
    }

    public final void zza(byte[] bArr, int i, int i2, zzakh zzakh, zzdg zzdg) {
        String str;
        int i3;
        int i4 = i;
        zzdg zzdg2 = zzdg;
        this.zza.zzJ(bArr, i4 + i2);
        this.zza.zzL(i4);
        zzed zzed = this.zza;
        boolean z = true;
        boolean z2 = false;
        int i5 = 2;
        zzdb.zzd(zzed.zzb() >= 2);
        int zzq = zzed.zzq();
        if (zzq == 0) {
            str = "";
        } else {
            int zzd2 = zzed.zzd();
            Charset zzC = zzed.zzC();
            int zzd3 = zzed.zzd() - zzd2;
            if (zzC == null) {
                zzC = StandardCharsets.UTF_8;
            }
            str = zzed.zzB(zzq - zzd3, zzC);
        }
        if (str.isEmpty()) {
            zzdg2.zza(new zzaka(zzfzo.zzn(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        zzc(spannableStringBuilder, this.zzc, 0, 0, spannableStringBuilder.length(), 16711680);
        zzb(spannableStringBuilder, this.zzd, -1, 0, spannableStringBuilder.length(), 16711680);
        String str2 = this.zze;
        int length = spannableStringBuilder.length();
        if (str2 != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str2), 0, length, 16711713);
        }
        float f = this.zzf;
        while (true) {
            zzed zzed2 = this.zza;
            if (zzed2.zzb() >= 8) {
                int zzd4 = zzed2.zzd();
                int zzg2 = zzed2.zzg();
                int zzg3 = this.zza.zzg();
                if (zzg3 == 1937013100) {
                    zzdb.zzd(this.zza.zzb() >= i5 ? z : z2);
                    int zzq2 = this.zza.zzq();
                    int i6 = z2;
                    while (i6 < zzq2) {
                        zzed zzed3 = this.zza;
                        zzdb.zzd(zzed3.zzb() >= 12 ? z : z2);
                        int zzq3 = zzed3.zzq();
                        int zzq4 = zzed3.zzq();
                        zzed3.zzM(i5);
                        int zzm = zzed3.zzm();
                        zzed3.zzM(z ? 1 : 0);
                        int zzg4 = zzed3.zzg();
                        if (zzq4 > spannableStringBuilder.length()) {
                            int length2 = spannableStringBuilder.length();
                            zzdt.zzf("Tx3gParser", "Truncating styl end (" + zzq4 + ") to cueText.length() (" + length2 + ").");
                            zzq4 = spannableStringBuilder.length();
                        }
                        if (zzq3 >= zzq4) {
                            zzdt.zzf("Tx3gParser", "Ignoring styl with start (" + zzq3 + ") >= end (" + zzq4 + ").");
                        } else {
                            int i7 = zzm;
                            int i8 = zzq4;
                            zzc(spannableStringBuilder, i7, this.zzc, zzq3, i8, 0);
                            zzb(spannableStringBuilder, zzg4, this.zzd, zzq3, i8, 0);
                        }
                        i6++;
                        z = true;
                        z2 = false;
                        i5 = 2;
                    }
                    i3 = i5;
                } else if (zzg3 != 1952608120 || !this.zzb) {
                    i3 = 2;
                } else {
                    i3 = 2;
                    zzdb.zzd(this.zza.zzb() >= 2);
                    f = Math.max(0.0f, Math.min(((float) this.zza.zzq()) / ((float) this.zzg), 0.95f));
                }
                this.zza.zzL(zzd4 + zzg2);
                i5 = i3;
                z = true;
                z2 = false;
            } else {
                zzcr zzcr = new zzcr();
                zzcr.zzl(spannableStringBuilder);
                zzcr.zze(f, 0);
                zzcr.zzf(0);
                zzdg2.zza(new zzaka(zzfzo.zzo(zzcr.zzp()), -9223372036854775807L, -9223372036854775807L));
                return;
            }
        }
    }
}
