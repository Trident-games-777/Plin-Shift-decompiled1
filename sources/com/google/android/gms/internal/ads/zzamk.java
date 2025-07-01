package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamk implements zzamm {
    private final zzed zza;
    private final AtomicInteger zzb = new AtomicInteger();
    private final String zzc;
    private final int zzd;
    private String zze;
    private zzadx zzf;
    private int zzg = 0;
    private int zzh;
    private int zzi;
    private long zzj;
    private zzad zzk;
    private int zzl;
    private int zzm;
    private int zzn = -1;
    private int zzo = -1;
    private long zzp = -9223372036854775807L;

    public zzamk(String str, int i, int i2) {
        this.zza = new zzed(new byte[i2]);
        this.zzc = str;
        this.zzd = i;
    }

    @RequiresNonNull({"output"})
    private final void zzf(zzaco zzaco) {
        int i;
        zzab zzab;
        int i2 = zzaco.zzb;
        if (i2 != -2147483647 && (i = zzaco.zzc) != -1) {
            zzad zzad = this.zzk;
            if (zzad == null || i != zzad.zzC || i2 != zzad.zzD || !Objects.equals(zzaco.zza, zzad.zzo)) {
                zzad zzad2 = this.zzk;
                if (zzad2 == null) {
                    zzab = new zzab();
                } else {
                    zzab = zzad2.zzb();
                }
                zzab.zzL(this.zze);
                zzab.zzZ(zzaco.zza);
                zzab.zzz(zzaco.zzc);
                zzab.zzaa(zzaco.zzb);
                zzab.zzP(this.zzc);
                zzab.zzX(this.zzd);
                zzad zzaf = zzab.zzaf();
                this.zzk = zzaf;
                this.zzf.zzl(zzaf);
            }
        }
    }

    private final boolean zzg(zzed zzed, byte[] bArr, int i) {
        int min = Math.min(zzed.zzb(), i - this.zzh);
        zzed.zzH(bArr, this.zzh, min);
        int i2 = this.zzh + min;
        this.zzh = i2;
        return i2 == i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzed r20) throws com.google.android.gms.internal.ads.zzbh {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            com.google.android.gms.internal.ads.zzadx r2 = r0.zzf
            com.google.android.gms.internal.ads.zzdb.zzb(r2)
        L_0x0009:
            int r2 = r1.zzb()
            if (r2 <= 0) goto L_0x02ac
            int r2 = r0.zzg
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 4
            r8 = 1
            if (r2 == 0) goto L_0x0219
            r9 = 5
            r10 = 7
            r11 = 6
            if (r2 == r8) goto L_0x0134
            if (r2 == r5) goto L_0x0118
            r12 = 0
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == r4) goto L_0x00dd
            if (r2 == r7) goto L_0x00b0
            if (r2 == r9) goto L_0x006f
            int r2 = r1.zzb()
            int r3 = r0.zzl
            int r4 = r0.zzh
            int r3 = r3 - r4
            int r2 = java.lang.Math.min(r2, r3)
            com.google.android.gms.internal.ads.zzadx r3 = r0.zzf
            r3.zzq(r1, r2)
            int r3 = r0.zzh
            int r3 = r3 + r2
            r0.zzh = r3
            int r2 = r0.zzl
            if (r3 != r2) goto L_0x0009
            long r2 = r0.zzp
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 == 0) goto L_0x004f
            r2 = r8
            goto L_0x0050
        L_0x004f:
            r2 = r6
        L_0x0050:
            com.google.android.gms.internal.ads.zzdb.zzf(r2)
            com.google.android.gms.internal.ads.zzadx r9 = r0.zzf
            long r10 = r0.zzp
            int r2 = r0.zzm
            if (r2 != r7) goto L_0x005d
            r12 = r6
            goto L_0x005e
        L_0x005d:
            r12 = r8
        L_0x005e:
            int r13 = r0.zzl
            r14 = 0
            r15 = 0
            r9.zzs(r10, r12, r13, r14, r15)
            long r2 = r0.zzp
            long r4 = r0.zzj
            long r2 = r2 + r4
            r0.zzp = r2
            r0.zzg = r6
            goto L_0x0009
        L_0x006f:
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            int r3 = r0.zzo
            boolean r2 = r0.zzg(r1, r2, r3)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            java.util.concurrent.atomic.AtomicInteger r3 = r0.zzb
            byte[] r2 = r2.zzN()
            com.google.android.gms.internal.ads.zzaco r2 = com.google.android.gms.internal.ads.zzacq.zze(r2, r3)
            int r3 = r0.zzm
            if (r3 != r4) goto L_0x0090
            r0.zzf(r2)
        L_0x0090:
            int r3 = r2.zzd
            r0.zzl = r3
            long r2 = r2.zze
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 != 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r12 = r2
        L_0x009c:
            r0.zzj = r12
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            r2.zzL(r6)
            com.google.android.gms.internal.ads.zzadx r2 = r0.zzf
            com.google.android.gms.internal.ads.zzed r3 = r0.zza
            int r4 = r0.zzo
            r2.zzq(r3, r4)
            r0.zzg = r11
            goto L_0x0009
        L_0x00b0:
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            boolean r2 = r0.zzg(r1, r2, r11)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            int r2 = com.google.android.gms.internal.ads.zzacq.zzb(r2)
            r0.zzo = r2
            int r3 = r0.zzh
            if (r3 <= r2) goto L_0x00d9
            int r2 = r3 - r2
            int r3 = r3 - r2
            r0.zzh = r3
            int r3 = r1.zzd()
            int r3 = r3 - r2
            r1.zzL(r3)
        L_0x00d9:
            r0.zzg = r9
            goto L_0x0009
        L_0x00dd:
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            int r3 = r0.zzn
            boolean r2 = r0.zzg(r1, r2, r3)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            com.google.android.gms.internal.ads.zzaco r2 = com.google.android.gms.internal.ads.zzacq.zzd(r2)
            r0.zzf(r2)
            int r3 = r2.zzd
            r0.zzl = r3
            long r2 = r2.zze
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 != 0) goto L_0x0103
            goto L_0x0104
        L_0x0103:
            r12 = r2
        L_0x0104:
            r0.zzj = r12
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            r2.zzL(r6)
            com.google.android.gms.internal.ads.zzadx r2 = r0.zzf
            com.google.android.gms.internal.ads.zzed r3 = r0.zza
            int r4 = r0.zzn
            r2.zzq(r3, r4)
            r0.zzg = r11
            goto L_0x0009
        L_0x0118:
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            boolean r2 = r0.zzg(r1, r2, r10)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            int r2 = com.google.android.gms.internal.ads.zzacq.zza(r2)
            r0.zzn = r2
            r0.zzg = r4
            goto L_0x0009
        L_0x0134:
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            r12 = 18
            boolean r2 = r0.zzg(r1, r2, r12)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            com.google.android.gms.internal.ads.zzad r13 = r0.zzk
            if (r13 != 0) goto L_0x0161
            java.lang.String r13 = r0.zze
            java.lang.String r14 = r0.zzc
            int r15 = r0.zzd
            r16 = 8
            r3 = 0
            com.google.android.gms.internal.ads.zzad r3 = com.google.android.gms.internal.ads.zzacq.zzc(r2, r13, r14, r15, r3)
            r0.zzk = r3
            com.google.android.gms.internal.ads.zzadx r13 = r0.zzf
            r13.zzl(r3)
            goto L_0x0163
        L_0x0161:
            r16 = 8
        L_0x0163:
            int r3 = com.google.android.gms.internal.ads.zzacq.zza
            byte r3 = r2[r6]
            r13 = 31
            r14 = -1
            r15 = -2
            if (r3 == r15) goto L_0x01ae
            if (r3 == r14) goto L_0x0194
            if (r3 == r13) goto L_0x0183
            byte r16 = r2[r9]
            r4 = r16 & 3
            int r4 = r4 << 12
            r17 = r9
            byte r9 = r2[r11]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r7
            r18 = r10
            byte r10 = r2[r18]
            goto L_0x01be
        L_0x0183:
            r17 = r9
            r18 = r10
            byte r9 = r2[r11]
            r4 = r4 & r9
            int r4 = r4 << 12
            byte r9 = r2[r18]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r7
            byte r10 = r2[r16]
            goto L_0x01a6
        L_0x0194:
            r17 = r9
            r18 = r10
            byte r9 = r2[r18]
            r4 = r4 & r9
            int r4 = r4 << 12
            byte r9 = r2[r11]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r7
            r10 = 9
            byte r10 = r2[r10]
        L_0x01a6:
            r10 = r10 & 60
            int r10 = r10 >> r5
            r4 = r4 | r9
            r4 = r4 | r10
            int r4 = r4 + r8
            r9 = r8
            goto L_0x01c5
        L_0x01ae:
            r17 = r9
            r18 = r10
            byte r9 = r2[r7]
            r4 = r4 & r9
            int r4 = r4 << 12
            byte r9 = r2[r18]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r7
            byte r10 = r2[r11]
        L_0x01be:
            r10 = r10 & 240(0xf0, float:3.36E-43)
            int r10 = r10 >> r7
            r4 = r4 | r9
            r4 = r4 | r10
            int r4 = r4 + r8
            r9 = r6
        L_0x01c5:
            if (r9 == 0) goto L_0x01cb
            int r4 = r4 * 16
            int r4 = r4 / 14
        L_0x01cb:
            r0.zzl = r4
            if (r3 == r15) goto L_0x01ec
            if (r3 == r14) goto L_0x01e2
            if (r3 == r13) goto L_0x01da
            byte r3 = r2[r7]
            r3 = r3 & r8
            int r3 = r3 << r11
            byte r2 = r2[r17]
            goto L_0x01f2
        L_0x01da:
            byte r3 = r2[r17]
            r3 = r3 & 7
            int r3 = r3 << r7
            byte r2 = r2[r11]
            goto L_0x01e9
        L_0x01e2:
            byte r3 = r2[r7]
            r3 = r3 & 7
            int r3 = r3 << r7
            byte r2 = r2[r18]
        L_0x01e9:
            r2 = r2 & 60
            goto L_0x01f4
        L_0x01ec:
            byte r3 = r2[r17]
            r3 = r3 & r8
            int r3 = r3 << r11
            byte r2 = r2[r7]
        L_0x01f2:
            r2 = r2 & 252(0xfc, float:3.53E-43)
        L_0x01f4:
            int r2 = r2 >> r5
            r2 = r2 | r3
            int r2 = r2 + r8
            com.google.android.gms.internal.ads.zzad r3 = r0.zzk
            int r3 = r3.zzD
            int r2 = r2 * 32
            long r4 = (long) r2
            long r2 = com.google.android.gms.internal.ads.zzen.zzt(r4, r3)
            int r2 = com.google.android.gms.internal.ads.zzgcr.zzb(r2)
            long r2 = (long) r2
            r0.zzj = r2
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            r2.zzL(r6)
            com.google.android.gms.internal.ads.zzadx r2 = r0.zzf
            com.google.android.gms.internal.ads.zzed r3 = r0.zza
            r2.zzq(r3, r12)
            r0.zzg = r11
            goto L_0x0009
        L_0x0219:
            r16 = 8
        L_0x021b:
            int r2 = r1.zzb()
            if (r2 <= 0) goto L_0x0009
            int r2 = r0.zzi
            int r2 = r2 << 8
            r0.zzi = r2
            int r3 = r1.zzm()
            r2 = r2 | r3
            r0.zzi = r2
            int r3 = com.google.android.gms.internal.ads.zzacq.zza
            r3 = 2147385345(0x7ffe8001, float:NaN)
            if (r2 == r3) goto L_0x026e
            r3 = -25230976(0xfffffffffe7f0180, float:-8.474023E37)
            if (r2 == r3) goto L_0x026e
            r3 = 536864768(0x1fffe800, float:1.0838051E-19)
            if (r2 == r3) goto L_0x026e
            r3 = -14745368(0xffffffffff1f00e8, float:-2.1135196E38)
            if (r2 != r3) goto L_0x0245
            goto L_0x026e
        L_0x0245:
            r3 = 1683496997(0x64582025, float:1.5947252E22)
            if (r2 == r3) goto L_0x026c
            r3 = 622876772(0x25205864, float:1.3907736E-16)
            if (r2 != r3) goto L_0x0250
            goto L_0x026c
        L_0x0250:
            r3 = 1078008818(0x40411bf2, float:3.0173306)
            if (r2 == r3) goto L_0x026a
            r3 = -233094848(0xfffffffff21b4140, float:-3.0751398E30)
            if (r2 != r3) goto L_0x025b
            goto L_0x026a
        L_0x025b:
            r3 = 1908687592(0x71c442e8, float:1.9436783E30)
            if (r2 == r3) goto L_0x0268
            r3 = -398277519(0xffffffffe842c471, float:-3.6790512E24)
            if (r2 != r3) goto L_0x0266
            goto L_0x0268
        L_0x0266:
            r2 = r6
            goto L_0x026f
        L_0x0268:
            r2 = r7
            goto L_0x026f
        L_0x026a:
            r2 = r4
            goto L_0x026f
        L_0x026c:
            r2 = r5
            goto L_0x026f
        L_0x026e:
            r2 = r8
        L_0x026f:
            r0.zzm = r2
            if (r2 == 0) goto L_0x021b
            com.google.android.gms.internal.ads.zzed r3 = r0.zza
            byte[] r3 = r3.zzN()
            int r9 = r0.zzi
            int r10 = r9 >> 24
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r3[r6] = r10
            int r10 = r9 >> 16
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r3[r8] = r10
            int r10 = r9 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r3[r5] = r10
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r3[r4] = r9
            r0.zzh = r7
            r0.zzi = r6
            if (r2 == r4) goto L_0x02a8
            if (r2 != r7) goto L_0x029e
            goto L_0x02a8
        L_0x029e:
            if (r2 != r8) goto L_0x02a4
            r0.zzg = r8
            goto L_0x0009
        L_0x02a4:
            r0.zzg = r5
            goto L_0x0009
        L_0x02a8:
            r0.zzg = r7
            goto L_0x0009
        L_0x02ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamk.zza(com.google.android.gms.internal.ads.zzed):void");
    }

    public final void zzb(zzacu zzacu, zzaoa zzaoa) {
        zzaoa.zzc();
        this.zze = zzaoa.zzb();
        this.zzf = zzacu.zzw(zzaoa.zza(), 1);
    }

    public final void zzc(boolean z) {
    }

    public final void zzd(long j, int i) {
        this.zzp = j;
    }

    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zzp = -9223372036854775807L;
        this.zzb.set(0);
    }
}
