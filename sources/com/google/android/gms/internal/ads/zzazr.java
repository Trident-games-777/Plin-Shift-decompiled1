package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.MurmurHash3;
import java.io.UnsupportedEncodingException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzazr {
    public static int zza(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        return MurmurHash3.murmurhash3_x86_32(bArr, 0, bArr.length, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ee, code lost:
        if (true != r4) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fe, code lost:
        if (true != r4) goto L_0x0100;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] zzb(java.lang.String r11, boolean r12) {
        /*
            if (r11 != 0) goto L_0x0004
            r11 = 0
            return r11
        L_0x0004:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            char[] r1 = r11.toCharArray()
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
        L_0x0011:
            int r6 = r11.length()
            if (r3 >= r6) goto L_0x0105
            int r6 = java.lang.Character.codePointAt(r1, r3)
            int r7 = java.lang.Character.charCount(r6)
            boolean r8 = java.lang.Character.isLetter(r6)
            if (r8 == 0) goto L_0x00c5
            java.lang.Character$UnicodeBlock r8 = java.lang.Character.UnicodeBlock.of(r6)
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.BOPOMOFO
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.BOPOMOFO_EXTENDED
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.HANGUL_JAMO
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.HANGUL_SYLLABLES
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.HIRAGANA
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.KATAKANA
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00af
            java.lang.Character$UnicodeBlock r9 = java.lang.Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x009a
            goto L_0x00af
        L_0x009a:
            r8 = 65382(0xff66, float:9.162E-41)
            if (r6 < r8) goto L_0x00a4
            r8 = 65437(0xff9d, float:9.1697E-41)
            if (r6 <= r8) goto L_0x00af
        L_0x00a4:
            r8 = 65441(0xffa1, float:9.1702E-41)
            if (r6 < r8) goto L_0x00c5
            r8 = 65500(0xffdc, float:9.1785E-41)
            if (r6 <= r8) goto L_0x00af
            goto L_0x00c5
        L_0x00af:
            if (r4 == 0) goto L_0x00bb
            int r4 = r3 - r5
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r5, r4)
            r0.add(r6)
        L_0x00bb:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r1, r3, r7)
            r0.add(r4)
        L_0x00c3:
            r4 = r2
            goto L_0x0102
        L_0x00c5:
            boolean r8 = java.lang.Character.isLetterOrDigit(r6)
            r9 = 1
            if (r8 != 0) goto L_0x00fe
            int r8 = java.lang.Character.getType(r6)
            r10 = 6
            if (r8 == r10) goto L_0x00fe
            int r8 = java.lang.Character.getType(r6)
            r10 = 8
            if (r8 != r10) goto L_0x00dc
            goto L_0x00fe
        L_0x00dc:
            if (r12 == 0) goto L_0x00f1
            int r8 = java.lang.Character.charCount(r6)
            if (r8 != r9) goto L_0x00f1
            char[] r6 = java.lang.Character.toChars(r6)
            char r6 = r6[r2]
            r8 = 39
            if (r6 != r8) goto L_0x00f1
            if (r9 == r4) goto L_0x0101
            goto L_0x0100
        L_0x00f1:
            if (r4 == 0) goto L_0x00c3
            int r4 = r3 - r5
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r5, r4)
            r0.add(r6)
            goto L_0x00c3
        L_0x00fe:
            if (r9 == r4) goto L_0x0101
        L_0x0100:
            r5 = r3
        L_0x0101:
            r4 = r9
        L_0x0102:
            int r3 = r3 + r7
            goto L_0x0011
        L_0x0105:
            if (r4 == 0) goto L_0x0110
            int r3 = r3 - r5
            java.lang.String r11 = new java.lang.String
            r11.<init>(r1, r5, r3)
            r0.add(r11)
        L_0x0110:
            int r11 = r0.size()
            java.lang.String[] r11 = new java.lang.String[r11]
            java.lang.Object[] r11 = r0.toArray(r11)
            java.lang.String[] r11 = (java.lang.String[]) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazr.zzb(java.lang.String, boolean):java.lang.String[]");
    }
}
