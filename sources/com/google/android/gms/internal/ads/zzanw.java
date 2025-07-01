package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzanw implements zzacr {
    private final int zza;
    /* access modifiers changed from: private */
    public final List zzb;
    private final zzed zzc;
    private final SparseIntArray zzd;
    /* access modifiers changed from: private */
    public final zzanz zze;
    private final zzakg zzf;
    /* access modifiers changed from: private */
    public final SparseArray zzg;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzh;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzi;
    private final zzant zzj;
    private zzans zzk;
    /* access modifiers changed from: private */
    public zzacu zzl;
    /* access modifiers changed from: private */
    public int zzm;
    /* access modifiers changed from: private */
    public boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    /* access modifiers changed from: private */
    public int zzr;

    @Deprecated
    public zzanw() {
        this(1, 1, zzakg.zza, new zzek(0), new zzamj(0), 112800);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01b8, code lost:
        if (r1 == false) goto L_0x01ba;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacs r20, com.google.android.gms.internal.ads.zzadn r21) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            long r7 = r1.zzd()
            boolean r3 = r0.zzn
            r11 = -1
            r13 = 1
            r14 = 0
            if (r3 == 0) goto L_0x009c
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzant r3 = r0.zzj
            boolean r4 = r3.zzd()
            if (r4 == 0) goto L_0x001f
            goto L_0x0026
        L_0x001f:
            int r4 = r0.zzr
            int r1 = r3.zza(r1, r2, r4)
            return r1
        L_0x0026:
            boolean r3 = r0.zzo
            r4 = 0
            if (r3 != 0) goto L_0x0074
            r0.zzo = r13
            com.google.android.gms.internal.ads.zzant r3 = r0.zzj
            long r9 = r3.zzb()
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r6 == 0) goto L_0x0061
            r6 = r3
            com.google.android.gms.internal.ads.zzans r3 = new com.google.android.gms.internal.ads.zzans
            r9 = r4
            com.google.android.gms.internal.ads.zzek r4 = r6.zzc()
            long r5 = r6.zzb()
            r15 = r9
            int r9 = r0.zzr
            r10 = 112800(0x1b8a0, float:1.58066E-40)
            r17 = r11
            r11 = r15
            r3.<init>(r4, r5, r7, r9, r10)
            r0.zzk = r3
            com.google.android.gms.internal.ads.zzacu r4 = r0.zzl
            com.google.android.gms.internal.ads.zzadq r3 = r3.zzb()
            r4.zzO(r3)
            goto L_0x0077
        L_0x0061:
            r6 = r3
            r17 = r11
            r11 = r4
            com.google.android.gms.internal.ads.zzacu r3 = r0.zzl
            com.google.android.gms.internal.ads.zzadp r4 = new com.google.android.gms.internal.ads.zzadp
            long r5 = r6.zzb()
            r4.<init>(r5, r11)
            r3.zzO(r4)
            goto L_0x0077
        L_0x0074:
            r17 = r11
            r11 = r4
        L_0x0077:
            boolean r3 = r0.zzp
            if (r3 == 0) goto L_0x008c
            r0.zzp = r14
            r0.zzf(r11, r11)
            long r3 = r1.zzf()
            int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0089
            goto L_0x008c
        L_0x0089:
            r2.zza = r11
            return r13
        L_0x008c:
            com.google.android.gms.internal.ads.zzans r3 = r0.zzk
            if (r3 == 0) goto L_0x009e
            boolean r4 = r3.zze()
            if (r4 != 0) goto L_0x0097
            goto L_0x009e
        L_0x0097:
            int r1 = r3.zza(r1, r2)
            return r1
        L_0x009c:
            r17 = r11
        L_0x009e:
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            byte[] r3 = r2.zzN()
            int r4 = r2.zzd()
            int r4 = 9400 - r4
            r5 = 188(0xbc, float:2.63E-43)
            if (r4 < r5) goto L_0x00af
            goto L_0x00c1
        L_0x00af:
            int r4 = r2.zzb()
            if (r4 <= 0) goto L_0x00bc
            int r2 = r2.zzd()
            java.lang.System.arraycopy(r3, r2, r3, r14, r4)
        L_0x00bc:
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            r2.zzJ(r3, r4)
        L_0x00c1:
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            int r4 = r2.zzb()
            r6 = -1
            if (r4 >= r5) goto L_0x0106
            int r2 = r2.zze()
            int r4 = 9400 - r2
            int r4 = r1.zza(r3, r2, r4)
            if (r4 != r6) goto L_0x00ff
            r1 = r14
        L_0x00d7:
            android.util.SparseArray r2 = r0.zzg
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x00fe
            android.util.SparseArray r2 = r0.zzg
            java.lang.Object r2 = r2.valueAt(r1)
            com.google.android.gms.internal.ads.zzaob r2 = (com.google.android.gms.internal.ads.zzaob) r2
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzang
            if (r3 == 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzang r2 = (com.google.android.gms.internal.ads.zzang) r2
            boolean r3 = r2.zzd(r14)
            if (r3 == 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzed r3 = new com.google.android.gms.internal.ads.zzed
            r3.<init>()
            r2.zza(r3, r13)
        L_0x00fb:
            int r1 = r1 + 1
            goto L_0x00d7
        L_0x00fe:
            return r6
        L_0x00ff:
            com.google.android.gms.internal.ads.zzed r6 = r0.zzc
            int r2 = r2 + r4
            r6.zzK(r2)
            goto L_0x00c1
        L_0x0106:
            int r1 = r2.zzd()
            int r3 = r2.zze()
            byte[] r2 = r2.zzN()
            int r2 = com.google.android.gms.internal.ads.zzaoc.zza(r2, r1, r3)
            com.google.android.gms.internal.ads.zzed r4 = r0.zzc
            r4.zzL(r2)
            int r4 = r2 + 188
            if (r4 <= r3) goto L_0x0126
            int r3 = r0.zzq
            int r2 = r2 - r1
            int r3 = r3 + r2
            r0.zzq = r3
            goto L_0x0128
        L_0x0126:
            r0.zzq = r14
        L_0x0128:
            com.google.android.gms.internal.ads.zzed r1 = r0.zzc
            int r2 = r1.zze()
            if (r4 <= r2) goto L_0x0131
            return r14
        L_0x0131:
            int r1 = r1.zzg()
            r3 = 8388608(0x800000, float:1.17549435E-38)
            r3 = r3 & r1
            if (r3 == 0) goto L_0x0140
            com.google.android.gms.internal.ads.zzed r1 = r0.zzc
            r1.zzL(r4)
            return r14
        L_0x0140:
            r3 = 4194304(0x400000, float:5.877472E-39)
            r3 = r3 & r1
            if (r3 == 0) goto L_0x0147
            r3 = r13
            goto L_0x0148
        L_0x0147:
            r3 = r14
        L_0x0148:
            int r5 = r1 >> 8
            r9 = r1 & 32
            r10 = r1 & 16
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            if (r10 == 0) goto L_0x015b
            android.util.SparseArray r10 = r0.zzg
            java.lang.Object r10 = r10.get(r5)
            com.google.android.gms.internal.ads.zzaob r10 = (com.google.android.gms.internal.ads.zzaob) r10
            goto L_0x015c
        L_0x015b:
            r10 = 0
        L_0x015c:
            if (r10 != 0) goto L_0x0164
            com.google.android.gms.internal.ads.zzed r1 = r0.zzc
            r1.zzL(r4)
            return r14
        L_0x0164:
            r1 = r1 & 15
            android.util.SparseIntArray r11 = r0.zzd
            int r12 = r1 + -1
            int r11 = r11.get(r5, r12)
            android.util.SparseIntArray r12 = r0.zzd
            r12.put(r5, r1)
            if (r11 != r1) goto L_0x017b
            com.google.android.gms.internal.ads.zzed r1 = r0.zzc
            r1.zzL(r4)
            return r14
        L_0x017b:
            int r11 = r11 + r13
            r11 = r11 & 15
            if (r1 == r11) goto L_0x0183
            r10.zzc()
        L_0x0183:
            if (r9 == 0) goto L_0x019d
            com.google.android.gms.internal.ads.zzed r1 = r0.zzc
            int r9 = r1.zzm()
            int r1 = r1.zzm()
            r1 = r1 & 64
            if (r1 == 0) goto L_0x0195
            r1 = 2
            goto L_0x0196
        L_0x0195:
            r1 = r14
        L_0x0196:
            r3 = r3 | r1
            com.google.android.gms.internal.ads.zzed r1 = r0.zzc
            int r9 = r9 + r6
            r1.zzM(r9)
        L_0x019d:
            boolean r1 = r0.zzn
            if (r1 != 0) goto L_0x01a9
            android.util.SparseBooleanArray r6 = r0.zzi
            boolean r5 = r6.get(r5, r14)
            if (r5 != 0) goto L_0x01ba
        L_0x01a9:
            com.google.android.gms.internal.ads.zzed r5 = r0.zzc
            r5.zzK(r4)
            com.google.android.gms.internal.ads.zzed r5 = r0.zzc
            r10.zza(r5, r3)
            com.google.android.gms.internal.ads.zzed r3 = r0.zzc
            r3.zzK(r2)
            if (r1 != 0) goto L_0x01c4
        L_0x01ba:
            boolean r1 = r0.zzn
            if (r1 == 0) goto L_0x01c4
            int r1 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r1 == 0) goto L_0x01c4
            r0.zzp = r13
        L_0x01c4:
            com.google.android.gms.internal.ads.zzed r1 = r0.zzc
            r1.zzL(r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanw.zzb(com.google.android.gms.internal.ads.zzacs, com.google.android.gms.internal.ads.zzadn):int");
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        if (this.zza == 0) {
            zzacu = new zzakj(zzacu, this.zzf);
        }
        this.zzl = zzacu;
    }

    public final void zzf(long j, long j2) {
        zzans zzans;
        int size = this.zzb.size();
        for (int i = 0; i < size; i++) {
            zzek zzek = (zzek) this.zzb.get(i);
            if (zzek.zzf() != -9223372036854775807L) {
                long zzd2 = zzek.zzd();
                if (zzd2 != -9223372036854775807L) {
                    if (zzd2 != 0) {
                        if (zzd2 == j2) {
                        }
                    }
                }
            }
            zzek.zzi(j2);
        }
        if (!(j2 == 0 || (zzans = this.zzk) == null)) {
            zzans.zzd(j2);
        }
        this.zzc.zzI(0);
        this.zzd.clear();
        for (int i2 = 0; i2 < this.zzg.size(); i2++) {
            ((zzaob) this.zzg.valueAt(i2)).zzc();
        }
        this.zzq = 0;
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        byte[] zzN = this.zzc.zzN();
        zzacg zzacg = (zzacg) zzacs;
        zzacg.zzm(zzN, 0, 940, false);
        int i = 0;
        while (i < 188) {
            int i2 = 0;
            while (i2 < 5) {
                if (zzN[(i2 * 188) + i] != 71) {
                    i++;
                } else {
                    i2++;
                }
            }
            zzacg.zzo(i, false);
            return true;
        }
        return false;
    }

    public zzanw(int i, int i2, zzakg zzakg, zzek zzek, zzanz zzanz, int i3) {
        zzanz zzanz2 = zzanz;
        this.zze = zzanz;
        this.zza = i2;
        this.zzf = zzakg;
        this.zzb = Collections.singletonList(zzek);
        this.zzc = new zzed(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzant(112800);
        this.zzl = zzacu.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray zza2 = zzanz.zza();
        int size = zza2.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.zzg.put(zza2.keyAt(i4), (zzaob) zza2.valueAt(i4));
        }
        this.zzg.put(0, new zzano(new zzanu(this)));
    }
}
