package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzba {
    public static final zzba zza = new zzba(new zzay());
    public final CharSequence zzb;
    public final CharSequence zzc;
    public final CharSequence zzd;
    public final CharSequence zze;
    public final CharSequence zzf;
    public final byte[] zzg;
    public final Integer zzh;
    public final Integer zzi;
    public final Integer zzj;
    @Deprecated
    public final Integer zzk;
    public final Boolean zzl;
    @Deprecated
    public final Integer zzm;
    public final Integer zzn;
    public final Integer zzo;
    public final Integer zzp;
    public final Integer zzq;
    public final Integer zzr;
    public final Integer zzs;
    public final CharSequence zzt;
    public final CharSequence zzu;
    public final CharSequence zzv;
    public final CharSequence zzw;
    public final CharSequence zzx;
    public final Integer zzy;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
        Integer.toString(32, 36);
        Integer.toString(33, 36);
        Integer.toString(1000, 36);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: int} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzba(com.google.android.gms.internal.ads.zzay r8) {
        /*
            r7 = this;
            r7.<init>()
            java.lang.Boolean r0 = r8.zzk
            java.lang.Integer r1 = r8.zzj
            java.lang.Integer r2 = r8.zzw
            r3 = 1
            r4 = -1
            r5 = 0
            if (r0 == 0) goto L_0x0042
            boolean r6 = r0.booleanValue()
            if (r6 != 0) goto L_0x0020
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0076
        L_0x0020:
            if (r1 == 0) goto L_0x0028
            int r6 = r1.intValue()
            if (r6 != r4) goto L_0x0076
        L_0x0028:
            if (r2 == 0) goto L_0x003c
            int r1 = r2.intValue()
            switch(r1) {
                case 1: goto L_0x003d;
                case 2: goto L_0x003d;
                case 3: goto L_0x003d;
                case 4: goto L_0x003d;
                case 5: goto L_0x003d;
                case 6: goto L_0x003d;
                case 7: goto L_0x003d;
                case 8: goto L_0x003d;
                case 9: goto L_0x003d;
                case 10: goto L_0x003d;
                case 11: goto L_0x003d;
                case 12: goto L_0x003d;
                case 13: goto L_0x003d;
                case 14: goto L_0x003d;
                case 15: goto L_0x003d;
                case 16: goto L_0x003d;
                case 17: goto L_0x003d;
                case 18: goto L_0x003d;
                case 19: goto L_0x003d;
                case 20: goto L_0x0031;
                case 21: goto L_0x003a;
                case 22: goto L_0x0038;
                case 23: goto L_0x0036;
                case 24: goto L_0x0034;
                case 25: goto L_0x0032;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x003c
        L_0x0032:
            r3 = 6
            goto L_0x003d
        L_0x0034:
            r3 = 5
            goto L_0x003d
        L_0x0036:
            r3 = 4
            goto L_0x003d
        L_0x0038:
            r3 = 3
            goto L_0x003d
        L_0x003a:
            r3 = 2
            goto L_0x003d
        L_0x003c:
            r3 = r5
        L_0x003d:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x0076
        L_0x0042:
            if (r1 == 0) goto L_0x0075
            int r0 = r1.intValue()
            if (r0 == r4) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r3 = r5
        L_0x004c:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            boolean r3 = r0.booleanValue()
            if (r3 == 0) goto L_0x0076
            if (r2 != 0) goto L_0x0076
            int r2 = r1.intValue()
            switch(r2) {
                case 1: goto L_0x0070;
                case 2: goto L_0x006e;
                case 3: goto L_0x006b;
                case 4: goto L_0x0068;
                case 5: goto L_0x0065;
                case 6: goto L_0x0062;
                default: goto L_0x005f;
            }
        L_0x005f:
            r5 = 20
            goto L_0x0070
        L_0x0062:
            r5 = 25
            goto L_0x0070
        L_0x0065:
            r5 = 24
            goto L_0x0070
        L_0x0068:
            r5 = 23
            goto L_0x0070
        L_0x006b:
            r5 = 22
            goto L_0x0070
        L_0x006e:
            r5 = 21
        L_0x0070:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            goto L_0x0076
        L_0x0075:
            r1 = 0
        L_0x0076:
            java.lang.CharSequence r3 = r8.zza
            r7.zzb = r3
            java.lang.CharSequence r3 = r8.zzb
            r7.zzc = r3
            java.lang.CharSequence r3 = r8.zzc
            r7.zzd = r3
            java.lang.CharSequence r3 = r8.zzd
            r7.zze = r3
            java.lang.CharSequence r3 = r8.zze
            r7.zzf = r3
            byte[] r3 = r8.zzf
            r7.zzg = r3
            java.lang.Integer r3 = r8.zzg
            r7.zzh = r3
            java.lang.Integer r3 = r8.zzh
            r7.zzi = r3
            java.lang.Integer r3 = r8.zzi
            r7.zzj = r3
            r7.zzk = r1
            r7.zzl = r0
            java.lang.Integer r0 = r8.zzl
            r7.zzm = r0
            java.lang.Integer r0 = r8.zzl
            r7.zzn = r0
            java.lang.Integer r0 = r8.zzm
            r7.zzo = r0
            java.lang.Integer r0 = r8.zzn
            r7.zzp = r0
            java.lang.Integer r0 = r8.zzo
            r7.zzq = r0
            java.lang.Integer r0 = r8.zzp
            r7.zzr = r0
            java.lang.Integer r0 = r8.zzq
            r7.zzs = r0
            java.lang.CharSequence r0 = r8.zzr
            r7.zzt = r0
            java.lang.CharSequence r0 = r8.zzs
            r7.zzu = r0
            java.lang.CharSequence r0 = r8.zzt
            r7.zzv = r0
            java.lang.CharSequence r0 = r8.zzu
            r7.zzw = r0
            java.lang.CharSequence r8 = r8.zzv
            r7.zzx = r8
            r7.zzy = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzba.<init>(com.google.android.gms.internal.ads.zzay):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzba zzba = (zzba) obj;
            return Objects.equals(this.zzb, zzba.zzb) && Objects.equals(this.zzc, zzba.zzc) && Objects.equals(this.zzd, zzba.zzd) && Objects.equals(this.zze, zzba.zze) && Objects.equals((Object) null, (Object) null) && Objects.equals((Object) null, (Object) null) && Objects.equals(this.zzf, zzba.zzf) && Objects.equals((Object) null, (Object) null) && Objects.equals((Object) null, (Object) null) && Objects.equals((Object) null, (Object) null) && Arrays.equals(this.zzg, zzba.zzg) && Objects.equals(this.zzh, zzba.zzh) && Objects.equals((Object) null, (Object) null) && Objects.equals(this.zzi, zzba.zzi) && Objects.equals(this.zzj, zzba.zzj) && Objects.equals(this.zzk, zzba.zzk) && Objects.equals(this.zzl, zzba.zzl) && Objects.equals((Object) null, (Object) null) && Objects.equals(this.zzn, zzba.zzn) && Objects.equals(this.zzo, zzba.zzo) && Objects.equals(this.zzp, zzba.zzp) && Objects.equals(this.zzq, zzba.zzq) && Objects.equals(this.zzr, zzba.zzr) && Objects.equals(this.zzs, zzba.zzs) && Objects.equals(this.zzt, zzba.zzt) && Objects.equals(this.zzu, zzba.zzu) && Objects.equals(this.zzv, zzba.zzv) && Objects.equals((Object) null, (Object) null) && Objects.equals((Object) null, (Object) null) && Objects.equals(this.zzw, zzba.zzw) && Objects.equals((Object) null, (Object) null) && Objects.equals(this.zzx, zzba.zzx) && Objects.equals(this.zzy, zzba.zzy);
        }
    }

    public final int hashCode() {
        CharSequence charSequence = this.zzb;
        return Arrays.hashCode(new Object[]{charSequence, this.zzc, this.zzd, this.zze, null, null, this.zzf, null, null, null, Integer.valueOf(Arrays.hashCode(this.zzg)), this.zzh, null, this.zzi, this.zzj, this.zzk, this.zzl, null, this.zzn, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, null, null, this.zzw, null, this.zzx, this.zzy, true});
    }

    public final zzay zza() {
        return new zzay(this, (zzaz) null);
    }
}
