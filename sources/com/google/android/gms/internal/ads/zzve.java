package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzve implements zzup, zzuo {
    private final zzup[] zza;
    private final IdentityHashMap zzb = new IdentityHashMap();
    private final ArrayList zzc = new ArrayList();
    private final HashMap zzd = new HashMap();
    private zzuo zze;
    private zzwr zzf;
    private zzup[] zzg;
    private zzwi zzh = new zzub(zzfzo.zzn(), zzfzo.zzn());

    public zzve(zzuc zzuc, long[] jArr, zzup... zzupArr) {
        this.zza = zzupArr;
        this.zzg = new zzup[0];
        for (int i = 0; i < zzupArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.zza[i] = new zzwo(zzupArr[i], j);
            }
        }
    }

    public final long zza(long j, zzls zzls) {
        zzup[] zzupArr = this.zzg;
        return (zzupArr.length > 0 ? zzupArr[0] : this.zza[0]).zza(j, zzls);
    }

    public final long zzb() {
        return this.zzh.zzb();
    }

    public final long zzc() {
        return this.zzh.zzc();
    }

    public final long zzd() {
        long j = -9223372036854775807L;
        for (zzup zzup : this.zzg) {
            long zzd2 = zzup.zzd();
            if (zzd2 != -9223372036854775807L) {
                if (j == -9223372036854775807L) {
                    zzup[] zzupArr = this.zzg;
                    int length = zzupArr.length;
                    int i = 0;
                    while (i < length) {
                        zzup zzup2 = zzupArr[i];
                        if (zzup2 == zzup) {
                            break;
                        } else if (zzup2.zze(zzd2) == zzd2) {
                            i++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j = zzd2;
                } else if (zzd2 != j) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j == -9223372036854775807L || zzup.zze(j) == j)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j;
    }

    public final long zze(long j) {
        long zze2 = this.zzg[0].zze(j);
        int i = 1;
        while (true) {
            zzup[] zzupArr = this.zzg;
            if (i >= zzupArr.length) {
                return zze2;
            }
            if (zzupArr[i].zze(zze2) == zze2) {
                i++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(com.google.android.gms.internal.ads.zzyd[] r21, boolean[] r22, com.google.android.gms.internal.ads.zzwg[] r23, boolean[] r24, long r25) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            int r3 = r1.length
            int[] r4 = new int[r3]
            int[] r3 = new int[r3]
            r5 = 0
            r6 = r5
        L_0x000d:
            int r7 = r1.length
            if (r6 >= r7) goto L_0x004a
            r7 = r2[r6]
            if (r7 != 0) goto L_0x0016
            r8 = 0
            goto L_0x001f
        L_0x0016:
            java.util.IdentityHashMap r8 = r0.zzb
            java.lang.Object r7 = r8.get(r7)
            r8 = r7
            java.lang.Integer r8 = (java.lang.Integer) r8
        L_0x001f:
            r7 = -1
            if (r8 != 0) goto L_0x0024
            r8 = r7
            goto L_0x0028
        L_0x0024:
            int r8 = r8.intValue()
        L_0x0028:
            r4[r6] = r8
            r8 = r1[r6]
            if (r8 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzbw r7 = r8.zze()
            java.lang.String r7 = r7.zzb
            java.lang.String r8 = ":"
            int r8 = r7.indexOf(r8)
            java.lang.String r7 = r7.substring(r5, r8)
            int r7 = java.lang.Integer.parseInt(r7)
            r3[r6] = r7
            goto L_0x0047
        L_0x0045:
            r3[r6] = r7
        L_0x0047:
            int r6 = r6 + 1
            goto L_0x000d
        L_0x004a:
            java.util.IdentityHashMap r6 = r0.zzb
            r6.clear()
            com.google.android.gms.internal.ads.zzup[] r6 = r0.zza
            com.google.android.gms.internal.ads.zzwg[] r9 = new com.google.android.gms.internal.ads.zzwg[r7]
            com.google.android.gms.internal.ads.zzwg[] r13 = new com.google.android.gms.internal.ads.zzwg[r7]
            com.google.android.gms.internal.ads.zzyd[] r11 = new com.google.android.gms.internal.ads.zzyd[r7]
            java.util.ArrayList r10 = new java.util.ArrayList
            int r6 = r6.length
            r10.<init>(r6)
            r15 = r25
            r6 = r5
        L_0x0060:
            com.google.android.gms.internal.ads.zzup[] r12 = r0.zza
            int r12 = r12.length
            if (r6 >= r12) goto L_0x0104
            r12 = r5
        L_0x0066:
            int r14 = r1.length
            if (r12 >= r14) goto L_0x00a4
            r14 = r4[r12]
            if (r14 != r6) goto L_0x0070
            r14 = r2[r12]
            goto L_0x0071
        L_0x0070:
            r14 = 0
        L_0x0071:
            r13[r12] = r14
            r14 = r3[r12]
            if (r14 != r6) goto L_0x009c
            r14 = r1[r12]
            r14.getClass()
            r17 = r14
            com.google.android.gms.internal.ads.zzyd r17 = (com.google.android.gms.internal.ads.zzyd) r17
            r17 = 0
            com.google.android.gms.internal.ads.zzbw r8 = r14.zze()
            java.util.HashMap r5 = r0.zzd
            java.lang.Object r5 = r5.get(r8)
            com.google.android.gms.internal.ads.zzbw r5 = (com.google.android.gms.internal.ads.zzbw) r5
            r5.getClass()
            r8 = r5
            com.google.android.gms.internal.ads.zzbw r8 = (com.google.android.gms.internal.ads.zzbw) r8
            com.google.android.gms.internal.ads.zzvd r8 = new com.google.android.gms.internal.ads.zzvd
            r8.<init>(r14, r5)
            r11[r12] = r8
            goto L_0x00a0
        L_0x009c:
            r17 = 0
            r11[r12] = r17
        L_0x00a0:
            int r12 = r12 + 1
            r5 = 0
            goto L_0x0066
        L_0x00a4:
            r17 = 0
            com.google.android.gms.internal.ads.zzup[] r5 = r0.zza
            r5 = r5[r6]
            r12 = r10
            r10 = r5
            r5 = r12
            r12 = r22
            r14 = r24
            long r18 = r10.zzf(r11, r12, r13, r14, r15)
            if (r6 != 0) goto L_0x00ba
            r15 = r18
            goto L_0x00be
        L_0x00ba:
            int r8 = (r18 > r15 ? 1 : (r18 == r15 ? 0 : -1))
            if (r8 != 0) goto L_0x00fc
        L_0x00be:
            r8 = 0
            r10 = 0
        L_0x00c0:
            int r12 = r1.length
            if (r8 >= r12) goto L_0x00ed
            r12 = r3[r8]
            if (r12 != r6) goto L_0x00dc
            r10 = r13[r8]
            r10.getClass()
            r12 = r10
            com.google.android.gms.internal.ads.zzwg r12 = (com.google.android.gms.internal.ads.zzwg) r12
            r9[r8] = r10
            java.util.IdentityHashMap r12 = r0.zzb
            java.lang.Integer r14 = java.lang.Integer.valueOf(r6)
            r12.put(r10, r14)
            r10 = 1
            goto L_0x00ea
        L_0x00dc:
            r12 = r4[r8]
            if (r12 != r6) goto L_0x00ea
            r12 = r13[r8]
            if (r12 != 0) goto L_0x00e6
            r14 = 1
            goto L_0x00e7
        L_0x00e6:
            r14 = 0
        L_0x00e7:
            com.google.android.gms.internal.ads.zzdb.zzf(r14)
        L_0x00ea:
            int r8 = r8 + 1
            goto L_0x00c0
        L_0x00ed:
            if (r10 == 0) goto L_0x00f6
            com.google.android.gms.internal.ads.zzup[] r8 = r0.zza
            r8 = r8[r6]
            r5.add(r8)
        L_0x00f6:
            int r6 = r6 + 1
            r10 = r5
            r5 = 0
            goto L_0x0060
        L_0x00fc:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Children enabled at different positions."
            r1.<init>(r2)
            throw r1
        L_0x0104:
            r1 = r5
            r5 = r10
            java.lang.System.arraycopy(r9, r1, r2, r1, r7)
            com.google.android.gms.internal.ads.zzup[] r1 = new com.google.android.gms.internal.ads.zzup[r1]
            java.lang.Object[] r1 = r5.toArray(r1)
            com.google.android.gms.internal.ads.zzup[] r1 = (com.google.android.gms.internal.ads.zzup[]) r1
            r0.zzg = r1
            com.google.android.gms.internal.ads.zzvc r1 = new com.google.android.gms.internal.ads.zzvc
            r1.<init>()
            java.util.List r1 = com.google.android.gms.internal.ads.zzgae.zzb(r5, r1)
            com.google.android.gms.internal.ads.zzub r2 = new com.google.android.gms.internal.ads.zzub
            r2.<init>(r5, r1)
            r0.zzh = r2
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzve.zzf(com.google.android.gms.internal.ads.zzyd[], boolean[], com.google.android.gms.internal.ads.zzwg[], boolean[], long):long");
    }

    public final /* bridge */ /* synthetic */ void zzg(zzwi zzwi) {
        zzup zzup = (zzup) zzwi;
        zzuo zzuo = this.zze;
        zzuo.getClass();
        zzuo zzuo2 = zzuo;
        zzuo.zzg(this);
    }

    public final void zzi(zzup zzup) {
        this.zzc.remove(zzup);
        if (this.zzc.isEmpty()) {
            zzup[] zzupArr = this.zza;
            int i = 0;
            for (zzup zzh2 : zzupArr) {
                i += zzh2.zzh().zzb;
            }
            zzbw[] zzbwArr = new zzbw[i];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                zzup[] zzupArr2 = this.zza;
                if (i2 < zzupArr2.length) {
                    zzwr zzh3 = zzupArr2[i2].zzh();
                    int i4 = zzh3.zzb;
                    int i5 = 0;
                    while (i5 < i4) {
                        zzbw zzb2 = zzh3.zzb(i5);
                        zzad[] zzadArr = new zzad[zzb2.zza];
                        for (int i6 = 0; i6 < zzb2.zza; i6++) {
                            zzad zzb3 = zzb2.zzb(i6);
                            zzab zzb4 = zzb3.zzb();
                            String str = zzb3.zza;
                            if (str == null) {
                                str = "";
                            }
                            zzb4.zzL(i2 + ":" + str);
                            zzadArr[i6] = zzb4.zzaf();
                        }
                        zzbw zzbw = new zzbw(i2 + ":" + zzb2.zzb, zzadArr);
                        this.zzd.put(zzbw, zzb2);
                        zzbwArr[i3] = zzbw;
                        i5++;
                        i3++;
                    }
                    i2++;
                } else {
                    this.zzf = new zzwr(zzbwArr);
                    zzuo zzuo = this.zze;
                    zzuo.getClass();
                    zzuo zzuo2 = zzuo;
                    zzuo.zzi(this);
                    return;
                }
            }
        }
    }

    public final void zzj(long j, boolean z) {
        for (zzup zzj : this.zzg) {
            zzj.zzj(j, false);
        }
    }

    public final void zzk() throws IOException {
        int i = 0;
        while (true) {
            zzup[] zzupArr = this.zza;
            if (i < zzupArr.length) {
                zzupArr[i].zzk();
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzl(zzuo zzuo, long j) {
        this.zze = zzuo;
        Collections.addAll(this.zzc, this.zza);
        int i = 0;
        while (true) {
            zzup[] zzupArr = this.zza;
            if (i < zzupArr.length) {
                zzupArr[i].zzl(this, j);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzm(long j) {
        this.zzh.zzm(j);
    }

    public final zzup zzn(int i) {
        zzup zzup = this.zza[i];
        return zzup instanceof zzwo ? ((zzwo) zzup).zzn() : zzup;
    }

    public final boolean zzo(zzko zzko) {
        if (this.zzc.isEmpty()) {
            return this.zzh.zzo(zzko);
        }
        int size = this.zzc.size();
        for (int i = 0; i < size; i++) {
            ((zzup) this.zzc.get(i)).zzo(zzko);
        }
        return false;
    }

    public final boolean zzp() {
        return this.zzh.zzp();
    }

    public final zzwr zzh() {
        zzwr zzwr = this.zzf;
        zzwr.getClass();
        zzwr zzwr2 = zzwr;
        return zzwr;
    }
}
