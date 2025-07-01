package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzanm implements zzacr {
    private final zzek zza = new zzek(0);
    private final SparseArray zzb = new SparseArray();
    private final zzed zzc = new zzed(4096);
    private final zzank zzd = new zzank();
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private long zzh;
    private zzanj zzi;
    private zzacu zzj;
    private boolean zzk;

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacs r13, com.google.android.gms.internal.ads.zzadn r14) throws java.io.IOException {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzacu r0 = r12.zzj
            com.google.android.gms.internal.ads.zzdb.zzb(r0)
            long r5 = r13.zzd()
            r7 = -1
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x001d
            com.google.android.gms.internal.ads.zzank r1 = r12.zzd
            boolean r2 = r1.zze()
            if (r2 == 0) goto L_0x0018
            goto L_0x001d
        L_0x0018:
            int r13 = r1.zza(r13, r14)
            return r13
        L_0x001d:
            boolean r1 = r12.zzk
            r9 = 1
            if (r1 != 0) goto L_0x005f
            r12.zzk = r9
            com.google.android.gms.internal.ads.zzank r1 = r12.zzd
            long r2 = r1.zzb()
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x004e
            r2 = r1
            com.google.android.gms.internal.ads.zzanj r1 = new com.google.android.gms.internal.ads.zzanj
            r3 = r2
            com.google.android.gms.internal.ads.zzek r2 = r3.zzd()
            long r3 = r3.zzb()
            r1.<init>(r2, r3, r5)
            r12.zzi = r1
            com.google.android.gms.internal.ads.zzacu r2 = r12.zzj
            com.google.android.gms.internal.ads.zzadq r1 = r1.zzb()
            r2.zzO(r1)
            goto L_0x005f
        L_0x004e:
            r3 = r1
            com.google.android.gms.internal.ads.zzacu r1 = r12.zzj
            com.google.android.gms.internal.ads.zzadp r2 = new com.google.android.gms.internal.ads.zzadp
            long r3 = r3.zzb()
            r10 = 0
            r2.<init>(r3, r10)
            r1.zzO(r2)
        L_0x005f:
            com.google.android.gms.internal.ads.zzanj r1 = r12.zzi
            if (r1 == 0) goto L_0x006f
            boolean r2 = r1.zze()
            if (r2 != 0) goto L_0x006a
            goto L_0x006f
        L_0x006a:
            int r13 = r1.zza(r13, r14)
            return r13
        L_0x006f:
            r13.zzj()
            if (r0 == 0) goto L_0x007a
            long r0 = r13.zze()
            long r5 = r5 - r0
            goto L_0x007b
        L_0x007a:
            r5 = r7
        L_0x007b:
            int r14 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r0 = -1
            if (r14 == 0) goto L_0x0088
            r1 = 4
            int r14 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r14 < 0) goto L_0x0087
            goto L_0x0088
        L_0x0087:
            return r0
        L_0x0088:
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            byte[] r14 = r14.zzN()
            r1 = 4
            r2 = 0
            boolean r14 = r13.zzm(r14, r2, r1, r9)
            if (r14 != 0) goto L_0x0097
            return r0
        L_0x0097:
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            r14.zzL(r2)
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            int r14 = r14.zzg()
            r1 = 441(0x1b9, float:6.18E-43)
            if (r14 != r1) goto L_0x00a7
            return r0
        L_0x00a7:
            r0 = 442(0x1ba, float:6.2E-43)
            if (r14 != r0) goto L_0x00cb
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            byte[] r14 = r14.zzN()
            r0 = 10
            r13.zzh(r14, r2, r0)
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            r0 = 9
            r14.zzL(r0)
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            int r14 = r14.zzm()
            r14 = r14 & 7
            int r14 = r14 + 14
            r13.zzk(r14)
            return r2
        L_0x00cb:
            r0 = 443(0x1bb, float:6.21E-43)
            r1 = 2
            r3 = 6
            if (r14 != r0) goto L_0x00ea
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            byte[] r14 = r14.zzN()
            r13.zzh(r14, r2, r1)
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            r14.zzL(r2)
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            int r14 = r14.zzq()
            int r14 = r14 + r3
            r13.zzk(r14)
            return r2
        L_0x00ea:
            int r0 = r14 >> 8
            if (r0 == r9) goto L_0x00f2
            r13.zzk(r9)
            return r2
        L_0x00f2:
            r0 = r14 & 255(0xff, float:3.57E-43)
            android.util.SparseArray r4 = r12.zzb
            java.lang.Object r4 = r4.get(r0)
            com.google.android.gms.internal.ads.zzanl r4 = (com.google.android.gms.internal.ads.zzanl) r4
            boolean r5 = r12.zze
            if (r5 != 0) goto L_0x0179
            if (r4 != 0) goto L_0x015a
            r5 = 189(0xbd, float:2.65E-43)
            r6 = 0
            if (r0 != r5) goto L_0x0116
            com.google.android.gms.internal.ads.zzame r14 = new com.google.android.gms.internal.ads.zzame
            r14.<init>(r6, r2)
            r12.zzf = r9
            long r5 = r13.zzf()
            r12.zzh = r5
        L_0x0114:
            r6 = r14
            goto L_0x013e
        L_0x0116:
            r5 = r14 & 224(0xe0, float:3.14E-43)
            r7 = 192(0xc0, float:2.69E-43)
            if (r5 != r7) goto L_0x012a
            com.google.android.gms.internal.ads.zzamy r14 = new com.google.android.gms.internal.ads.zzamy
            r14.<init>(r6, r2)
            r12.zzf = r9
            long r5 = r13.zzf()
            r12.zzh = r5
            goto L_0x0114
        L_0x012a:
            r14 = r14 & 240(0xf0, float:3.36E-43)
            r5 = 224(0xe0, float:3.14E-43)
            if (r14 != r5) goto L_0x013e
            com.google.android.gms.internal.ads.zzamo r14 = new com.google.android.gms.internal.ads.zzamo
            r14.<init>(r6)
            r12.zzg = r9
            long r5 = r13.zzf()
            r12.zzh = r5
            goto L_0x0114
        L_0x013e:
            if (r6 == 0) goto L_0x015a
            com.google.android.gms.internal.ads.zzaoa r14 = new com.google.android.gms.internal.ads.zzaoa
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 256(0x100, float:3.59E-43)
            r14.<init>(r4, r0, r5)
            com.google.android.gms.internal.ads.zzacu r4 = r12.zzj
            r6.zzb(r4, r14)
            com.google.android.gms.internal.ads.zzek r14 = r12.zza
            com.google.android.gms.internal.ads.zzanl r4 = new com.google.android.gms.internal.ads.zzanl
            r4.<init>(r6, r14)
            android.util.SparseArray r14 = r12.zzb
            r14.put(r0, r4)
        L_0x015a:
            boolean r14 = r12.zzf
            r5 = 1048576(0x100000, double:5.180654E-318)
            if (r14 == 0) goto L_0x016a
            boolean r14 = r12.zzg
            if (r14 == 0) goto L_0x016a
            long r5 = r12.zzh
            r7 = 8192(0x2000, double:4.0474E-320)
            long r5 = r5 + r7
        L_0x016a:
            long r7 = r13.zzf()
            int r14 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x0179
            r12.zze = r9
            com.google.android.gms.internal.ads.zzacu r14 = r12.zzj
            r14.zzD()
        L_0x0179:
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            byte[] r14 = r14.zzN()
            r13.zzh(r14, r2, r1)
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            r14.zzL(r2)
            com.google.android.gms.internal.ads.zzed r14 = r12.zzc
            int r14 = r14.zzq()
            int r14 = r14 + r3
            if (r4 != 0) goto L_0x0194
            r13.zzk(r14)
            goto L_0x01b5
        L_0x0194:
            com.google.android.gms.internal.ads.zzed r0 = r12.zzc
            r0.zzI(r14)
            com.google.android.gms.internal.ads.zzed r0 = r12.zzc
            byte[] r0 = r0.zzN()
            r13.zzi(r0, r2, r14)
            com.google.android.gms.internal.ads.zzed r13 = r12.zzc
            r13.zzL(r3)
            com.google.android.gms.internal.ads.zzed r13 = r12.zzc
            r4.zza(r13)
            com.google.android.gms.internal.ads.zzed r13 = r12.zzc
            int r14 = r13.zzc()
            r13.zzK(r14)
        L_0x01b5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanm.zzb(com.google.android.gms.internal.ads.zzacs, com.google.android.gms.internal.ads.zzadn):int");
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zzj = zzacu;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r0 != r7) goto L_0x0021;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[LOOP:0: B:12:0x002c->B:14:0x0034, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(long r5, long r7) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzek r5 = r4.zza
            long r0 = r5.zzf()
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0021
            long r0 = r5.zzd()
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
            int r6 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
        L_0x0021:
            r5.zzi(r7)
        L_0x0024:
            com.google.android.gms.internal.ads.zzanj r5 = r4.zzi
            r6 = 0
            if (r5 == 0) goto L_0x002c
            r5.zzd(r7)
        L_0x002c:
            android.util.SparseArray r5 = r4.zzb
            int r5 = r5.size()
            if (r6 >= r5) goto L_0x0042
            android.util.SparseArray r5 = r4.zzb
            java.lang.Object r5 = r5.valueAt(r6)
            com.google.android.gms.internal.ads.zzanl r5 = (com.google.android.gms.internal.ads.zzanl) r5
            r5.zzb()
            int r6 = r6 + 1
            goto L_0x002c
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanm.zzf(long, long):void");
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        byte[] bArr = new byte[14];
        zzacg zzacg = (zzacg) zzacs;
        zzacg.zzm(bArr, 0, 14, false);
        if ((((bArr[0] & 255) << Ascii.CAN) | ((bArr[1] & 255) << Ascii.DLE) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzacg.zzl(bArr[13] & 7, false);
        zzacg.zzm(bArr, 0, 3, false);
        return ((((bArr[0] & 255) << Ascii.DLE) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255)) == 1;
    }
}
