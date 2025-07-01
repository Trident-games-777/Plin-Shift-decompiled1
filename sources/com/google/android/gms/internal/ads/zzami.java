package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzami implements zzamm {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzec zzc = new zzec(new byte[7], 7);
    private final zzed zzd = new zzed(Arrays.copyOf(zza, 10));
    private final String zze;
    private final int zzf;
    private String zzg;
    private zzadx zzh;
    private zzadx zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private long zzs;
    private int zzt;
    private long zzu;
    private zzadx zzv;
    private long zzw;

    public zzami(boolean z, String str, int i) {
        zzh();
        this.zzo = -1;
        this.zzp = -1;
        this.zzs = -9223372036854775807L;
        this.zzu = -9223372036854775807L;
        this.zzb = z;
        this.zze = str;
        this.zzf = i;
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzn = false;
        zzh();
    }

    private final void zzh() {
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = 256;
    }

    private final void zzi() {
        this.zzj = 3;
        this.zzk = 0;
    }

    private final void zzj(zzadx zzadx, long j, int i, int i2) {
        this.zzj = 4;
        this.zzk = i;
        this.zzv = zzadx;
        this.zzw = j;
        this.zzt = i2;
    }

    private final boolean zzk(zzed zzed, byte[] bArr, int i) {
        int min = Math.min(zzed.zzb(), i - this.zzk);
        zzed.zzH(bArr, this.zzk, min);
        int i2 = this.zzk + min;
        this.zzk = i2;
        return i2 == i;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | 65280);
    }

    private static final boolean zzm(zzed zzed, byte[] bArr, int i) {
        if (zzed.zzb() < i) {
            return false;
        }
        zzed.zzH(bArr, 0, i);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzed r19) throws com.google.android.gms.internal.ads.zzbh {
        /*
            r18 = this;
            r0 = r18
            r6 = r19
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzh
            r1.getClass()
            int r1 = com.google.android.gms.internal.ads.zzen.zza
        L_0x000b:
            int r1 = r6.zzb()
            if (r1 <= 0) goto L_0x02e0
            int r1 = r0.zzj
            r2 = 13
            r3 = 7
            r4 = 4
            r5 = 3
            r7 = -1
            r8 = 0
            r9 = 2
            r10 = 1
            if (r1 == 0) goto L_0x0199
            if (r1 == r10) goto L_0x015e
            r7 = 10
            if (r1 == r9) goto L_0x0132
            if (r1 == r5) goto L_0x0067
            int r1 = r6.zzb()
            int r2 = r0.zzt
            int r3 = r0.zzk
            int r2 = r2 - r3
            int r1 = java.lang.Math.min(r1, r2)
            com.google.android.gms.internal.ads.zzadx r2 = r0.zzv
            r2.zzq(r6, r1)
            int r2 = r0.zzk
            int r2 = r2 + r1
            r0.zzk = r2
            int r1 = r0.zzt
            if (r2 != r1) goto L_0x000b
            long r1 = r0.zzu
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x004d
            r8 = r10
        L_0x004d:
            com.google.android.gms.internal.ads.zzdb.zzf(r8)
            com.google.android.gms.internal.ads.zzadx r9 = r0.zzv
            long r10 = r0.zzu
            int r13 = r0.zzt
            r14 = 0
            r15 = 0
            r12 = 1
            r9.zzs(r10, r12, r13, r14, r15)
            long r1 = r0.zzu
            long r3 = r0.zzw
            long r1 = r1 + r3
            r0.zzu = r1
            r0.zzh()
            goto L_0x000b
        L_0x0067:
            boolean r1 = r0.zzm
            r11 = 5
            if (r10 == r1) goto L_0x006e
            r1 = r11
            goto L_0x006f
        L_0x006e:
            r1 = r3
        L_0x006f:
            com.google.android.gms.internal.ads.zzec r12 = r0.zzc
            byte[] r12 = r12.zza
            boolean r1 = r0.zzk(r6, r12, r1)
            if (r1 == 0) goto L_0x000b
            com.google.android.gms.internal.ads.zzec r1 = r0.zzc
            r1.zzl(r8)
            boolean r1 = r0.zzr
            if (r1 != 0) goto L_0x010f
            com.google.android.gms.internal.ads.zzec r1 = r0.zzc
            int r1 = r1.zzd(r9)
            int r1 = r1 + r10
            if (r1 == r9) goto L_0x00a3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r12 = "Detected audio object type: "
            r7.<init>(r12)
            r7.append(r1)
            java.lang.String r1 = ", but assuming AAC LC."
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            java.lang.String r7 = "AdtsReader"
            com.google.android.gms.internal.ads.zzdt.zzf(r7, r1)
        L_0x00a3:
            com.google.android.gms.internal.ads.zzec r1 = r0.zzc
            r1.zzn(r11)
            com.google.android.gms.internal.ads.zzec r1 = r0.zzc
            int r1 = r1.zzd(r5)
            int r7 = r0.zzp
            int r11 = com.google.android.gms.internal.ads.zzabo.zza
            int r11 = r7 >> 1
            r11 = r11 & r3
            r11 = r11 | 16
            byte r11 = (byte) r11
            int r3 = r7 << 7
            int r1 = r1 << r5
            r3 = r3 & 128(0x80, float:1.794E-43)
            r1 = r1 & 120(0x78, float:1.68E-43)
            r1 = r1 | r3
            byte r1 = (byte) r1
            byte[] r3 = new byte[r9]
            r3[r8] = r11
            r3[r10] = r1
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzabo.zza(r3)
            com.google.android.gms.internal.ads.zzab r5 = new com.google.android.gms.internal.ads.zzab
            r5.<init>()
            java.lang.String r7 = r0.zzg
            r5.zzL(r7)
            java.lang.String r7 = "audio/mp4a-latm"
            r5.zzZ(r7)
            java.lang.String r7 = r1.zzc
            r5.zzA(r7)
            int r7 = r1.zzb
            r5.zzz(r7)
            int r1 = r1.zza
            r5.zzaa(r1)
            java.util.List r1 = java.util.Collections.singletonList(r3)
            r5.zzM(r1)
            java.lang.String r1 = r0.zze
            r5.zzP(r1)
            int r1 = r0.zzf
            r5.zzX(r1)
            com.google.android.gms.internal.ads.zzad r1 = r5.zzaf()
            int r3 = r1.zzD
            long r7 = (long) r3
            r11 = 1024000000(0x3d090000, double:5.059232213E-315)
            long r11 = r11 / r7
            r0.zzs = r11
            com.google.android.gms.internal.ads.zzadx r3 = r0.zzh
            r3.zzl(r1)
            r0.zzr = r10
            goto L_0x0114
        L_0x010f:
            com.google.android.gms.internal.ads.zzec r1 = r0.zzc
            r1.zzn(r7)
        L_0x0114:
            com.google.android.gms.internal.ads.zzec r1 = r0.zzc
            r1.zzn(r4)
            com.google.android.gms.internal.ads.zzec r1 = r0.zzc
            int r1 = r1.zzd(r2)
            int r2 = r1 + -7
            boolean r3 = r0.zzm
            if (r3 == 0) goto L_0x0127
            int r2 = r1 + -9
        L_0x0127:
            r5 = r2
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzh
            long r2 = r0.zzs
            r4 = 0
            r0.zzj(r1, r2, r4, r5)
            goto L_0x000b
        L_0x0132:
            com.google.android.gms.internal.ads.zzed r1 = r0.zzd
            byte[] r1 = r1.zzN()
            boolean r1 = r0.zzk(r6, r1, r7)
            if (r1 == 0) goto L_0x000b
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzi
            com.google.android.gms.internal.ads.zzed r2 = r0.zzd
            r1.zzq(r2, r7)
            com.google.android.gms.internal.ads.zzed r1 = r0.zzd
            r2 = 6
            r1.zzL(r2)
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzi
            com.google.android.gms.internal.ads.zzed r2 = r0.zzd
            int r2 = r2.zzl()
            r4 = 10
            int r5 = r2 + 10
            r2 = 0
            r0.zzj(r1, r2, r4, r5)
            goto L_0x000b
        L_0x015e:
            int r1 = r6.zzb()
            if (r1 == 0) goto L_0x000b
            com.google.android.gms.internal.ads.zzec r1 = r0.zzc
            byte[] r2 = r1.zza
            byte[] r3 = r6.zzN()
            int r5 = r6.zzd()
            byte r3 = r3[r5]
            r2[r8] = r3
            r1.zzl(r9)
            com.google.android.gms.internal.ads.zzec r1 = r0.zzc
            int r1 = r1.zzd(r4)
            int r2 = r0.zzp
            if (r2 == r7) goto L_0x0188
            if (r1 == r2) goto L_0x0188
            r0.zzg()
            goto L_0x000b
        L_0x0188:
            boolean r2 = r0.zzn
            if (r2 != 0) goto L_0x0194
            r0.zzn = r10
            int r2 = r0.zzq
            r0.zzo = r2
            r0.zzp = r1
        L_0x0194:
            r0.zzi()
            goto L_0x000b
        L_0x0199:
            byte[] r1 = r6.zzN()
            int r11 = r6.zzd()
            int r12 = r6.zze()
        L_0x01a5:
            if (r11 >= r12) goto L_0x02db
            int r13 = r11 + 1
            byte r14 = r1[r11]
            r15 = r14 & 255(0xff, float:3.57E-43)
            r16 = r5
            int r5 = r0.zzl
            r8 = 512(0x200, float:7.175E-43)
            if (r5 != r8) goto L_0x027f
            byte r5 = (byte) r15
            boolean r5 = zzl(r7, r5)
            if (r5 == 0) goto L_0x027f
            boolean r5 = r0.zzn
            if (r5 != 0) goto L_0x025d
            int r5 = r11 + -1
            r6.zzL(r11)
            com.google.android.gms.internal.ads.zzec r8 = r0.zzc
            byte[] r8 = r8.zza
            boolean r8 = zzm(r6, r8, r10)
            if (r8 != 0) goto L_0x01d1
            goto L_0x027f
        L_0x01d1:
            com.google.android.gms.internal.ads.zzec r8 = r0.zzc
            r8.zzl(r4)
            com.google.android.gms.internal.ads.zzec r8 = r0.zzc
            int r8 = r8.zzd(r10)
            int r3 = r0.zzo
            if (r3 == r7) goto L_0x01e6
            if (r8 != r3) goto L_0x01e3
            goto L_0x01e6
        L_0x01e3:
            r9 = 7
            goto L_0x0280
        L_0x01e6:
            int r3 = r0.zzp
            if (r3 == r7) goto L_0x0209
            com.google.android.gms.internal.ads.zzec r3 = r0.zzc
            byte[] r3 = r3.zza
            boolean r3 = zzm(r6, r3, r10)
            if (r3 != 0) goto L_0x01f5
            goto L_0x025d
        L_0x01f5:
            com.google.android.gms.internal.ads.zzec r3 = r0.zzc
            r3.zzl(r9)
            com.google.android.gms.internal.ads.zzec r3 = r0.zzc
            int r3 = r3.zzd(r4)
            int r9 = r0.zzp
            if (r3 != r9) goto L_0x01e3
            int r3 = r11 + 1
            r6.zzL(r3)
        L_0x0209:
            com.google.android.gms.internal.ads.zzec r3 = r0.zzc
            byte[] r3 = r3.zza
            boolean r3 = zzm(r6, r3, r4)
            if (r3 == 0) goto L_0x025d
            com.google.android.gms.internal.ads.zzec r3 = r0.zzc
            r9 = 14
            r3.zzl(r9)
            com.google.android.gms.internal.ads.zzec r3 = r0.zzc
            int r3 = r3.zzd(r2)
            r9 = 7
            if (r3 < r9) goto L_0x0280
            byte[] r17 = r6.zzN()
            int r2 = r6.zze()
            int r5 = r5 + r3
            if (r5 >= r2) goto L_0x025d
            byte r3 = r17[r5]
            if (r3 != r7) goto L_0x0245
            int r5 = r5 + 1
            if (r5 == r2) goto L_0x025d
            byte r2 = r17[r5]
            boolean r3 = zzl(r7, r2)
            if (r3 == 0) goto L_0x0280
            r2 = r2 & 8
            int r2 = r2 >> 3
            if (r2 != r8) goto L_0x0280
            goto L_0x025d
        L_0x0245:
            r8 = 73
            if (r3 != r8) goto L_0x0280
            int r3 = r5 + 1
            if (r3 == r2) goto L_0x025d
            byte r3 = r17[r3]
            r8 = 68
            if (r3 != r8) goto L_0x0280
            int r5 = r5 + 2
            if (r5 == r2) goto L_0x025d
            byte r2 = r17[r5]
            r3 = 51
            if (r2 != r3) goto L_0x0280
        L_0x025d:
            r1 = r14 & 8
            int r1 = r1 >> 3
            r0.zzq = r1
            r1 = r14 & 1
            r1 = r1 ^ r10
            if (r10 == r1) goto L_0x026a
            r1 = 0
            goto L_0x026b
        L_0x026a:
            r1 = r10
        L_0x026b:
            r0.zzm = r1
            boolean r1 = r0.zzn
            if (r1 != 0) goto L_0x0277
            r0.zzj = r10
            r1 = 0
            r0.zzk = r1
            goto L_0x027a
        L_0x0277:
            r0.zzi()
        L_0x027a:
            r6.zzL(r13)
            goto L_0x000b
        L_0x027f:
            r9 = r3
        L_0x0280:
            int r2 = r0.zzl
            r3 = r2 | r15
            r5 = 329(0x149, float:4.61E-43)
            if (r3 == r5) goto L_0x02ca
            r5 = 511(0x1ff, float:7.16E-43)
            if (r3 == r5) goto L_0x02c3
            r5 = 836(0x344, float:1.171E-42)
            if (r3 == r5) goto L_0x02bc
            r5 = 1075(0x433, float:1.506E-42)
            if (r3 == r5) goto L_0x02a8
            r3 = 256(0x100, float:3.59E-43)
            if (r2 == r3) goto L_0x02a3
            r0.zzl = r3
            r3 = r9
            r5 = r16
            r2 = 13
            r8 = 0
            r9 = 2
            goto L_0x01a5
        L_0x02a3:
            r3 = r16
            r2 = 2
            r5 = 0
            goto L_0x02d2
        L_0x02a8:
            r2 = 2
            r0.zzj = r2
            r3 = r16
            r0.zzk = r3
            r5 = 0
            r0.zzt = r5
            com.google.android.gms.internal.ads.zzed r1 = r0.zzd
            r1.zzL(r5)
            r6.zzL(r13)
            goto L_0x000b
        L_0x02bc:
            r3 = r16
            r2 = 2
            r5 = 0
            r8 = 1024(0x400, float:1.435E-42)
            goto L_0x02d0
        L_0x02c3:
            r3 = r16
            r2 = 2
            r5 = 0
            r8 = 512(0x200, float:7.175E-43)
            goto L_0x02d0
        L_0x02ca:
            r3 = r16
            r2 = 2
            r5 = 0
            r8 = 768(0x300, float:1.076E-42)
        L_0x02d0:
            r0.zzl = r8
        L_0x02d2:
            r8 = r5
            r11 = r13
            r5 = r3
            r3 = r9
            r9 = r2
            r2 = 13
            goto L_0x01a5
        L_0x02db:
            r6.zzL(r11)
            goto L_0x000b
        L_0x02e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzami.zza(com.google.android.gms.internal.ads.zzed):void");
    }

    public final void zzb(zzacu zzacu, zzaoa zzaoa) {
        zzaoa.zzc();
        this.zzg = zzaoa.zzb();
        zzadx zzw2 = zzacu.zzw(zzaoa.zza(), 1);
        this.zzh = zzw2;
        this.zzv = zzw2;
        if (this.zzb) {
            zzaoa.zzc();
            zzadx zzw3 = zzacu.zzw(zzaoa.zza(), 5);
            this.zzi = zzw3;
            zzab zzab = new zzab();
            zzab.zzL(zzaoa.zzb());
            zzab.zzZ("application/id3");
            zzw3.zzl(zzab.zzaf());
            return;
        }
        this.zzi = new zzacm();
    }

    public final void zzc(boolean z) {
    }

    public final void zzd(long j, int i) {
        this.zzu = j;
    }

    public final void zze() {
        this.zzu = -9223372036854775807L;
        zzg();
    }
}
