package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaee implements zzacr {
    private static final int[] zza = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzb = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    private static final byte[] zzc = "#!AMR\n".getBytes(StandardCharsets.UTF_8);
    private static final byte[] zzd = "#!AMR-WB\n".getBytes(StandardCharsets.UTF_8);
    private final byte[] zze;
    private final zzadx zzf;
    private boolean zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private zzacu zzn;
    private zzadx zzo;
    private zzadx zzp;
    private zzadq zzq;
    private long zzr;
    private boolean zzs;

    static {
        int i = zzen.zza;
    }

    public zzaee() {
        throw null;
    }

    public zzaee(int i) {
        this.zze = new byte[1];
        this.zzk = -1;
        zzacm zzacm = new zzacm();
        this.zzf = zzacm;
        this.zzp = zzacm;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a A[Catch:{ EOFException -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[Catch:{ EOFException -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0051  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"realTrackOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(com.google.android.gms.internal.ads.zzacs r12) throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = "Illegal AMR "
            java.lang.String r1 = "Invalid padding bits for frame header "
            int r2 = r11.zzj
            r3 = 0
            r4 = -1
            r5 = 1
            if (r2 != 0) goto L_0x0089
            r12.zzj()     // Catch:{ EOFException -> 0x0088 }
            byte[] r2 = r11.zze     // Catch:{ EOFException -> 0x0088 }
            r12.zzh(r2, r3, r5)     // Catch:{ EOFException -> 0x0088 }
            byte[] r2 = r11.zze     // Catch:{ EOFException -> 0x0088 }
            byte r2 = r2[r3]     // Catch:{ EOFException -> 0x0088 }
            r6 = r2 & 131(0x83, float:1.84E-43)
            r7 = 0
            if (r6 > 0) goto L_0x0077
            int r1 = r2 >> 3
            boolean r2 = r11.zzg     // Catch:{ EOFException -> 0x0088 }
            r1 = r1 & 15
            if (r2 == 0) goto L_0x002d
            r6 = 10
            if (r1 < r6) goto L_0x0038
            r6 = 13
            if (r1 <= r6) goto L_0x002d
            goto L_0x0038
        L_0x002d:
            if (r2 != 0) goto L_0x0057
            r6 = 12
            if (r1 < r6) goto L_0x0038
            r6 = 14
            if (r1 > r6) goto L_0x0038
            goto L_0x0057
        L_0x0038:
            if (r2 == 0) goto L_0x003f
            int[] r0 = zzb     // Catch:{ EOFException -> 0x0088 }
            r0 = r0[r1]     // Catch:{ EOFException -> 0x0088 }
            goto L_0x0043
        L_0x003f:
            int[] r0 = zza     // Catch:{ EOFException -> 0x0088 }
            r0 = r0[r1]     // Catch:{ EOFException -> 0x0088 }
        L_0x0043:
            r2 = r0
            r11.zzi = r2     // Catch:{ EOFException -> 0x0088 }
            r11.zzj = r2
            int r0 = r11.zzk
            if (r0 != r4) goto L_0x004f
            r11.zzk = r2
            r0 = r2
        L_0x004f:
            if (r0 != r2) goto L_0x0089
            int r0 = r11.zzl
            int r0 = r0 + r5
            r11.zzl = r0
            goto L_0x0089
        L_0x0057:
            java.lang.String r12 = "WB"
            java.lang.String r3 = "NB"
            if (r5 == r2) goto L_0x005e
            r12 = r3
        L_0x005e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0088 }
            r2.<init>(r0)     // Catch:{ EOFException -> 0x0088 }
            r2.append(r12)     // Catch:{ EOFException -> 0x0088 }
            java.lang.String r12 = " frame type "
            r2.append(r12)     // Catch:{ EOFException -> 0x0088 }
            r2.append(r1)     // Catch:{ EOFException -> 0x0088 }
            java.lang.String r12 = r2.toString()     // Catch:{ EOFException -> 0x0088 }
            com.google.android.gms.internal.ads.zzbh r12 = com.google.android.gms.internal.ads.zzbh.zza(r12, r7)     // Catch:{ EOFException -> 0x0088 }
            throw r12     // Catch:{ EOFException -> 0x0088 }
        L_0x0077:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0088 }
            r12.<init>(r1)     // Catch:{ EOFException -> 0x0088 }
            r12.append(r2)     // Catch:{ EOFException -> 0x0088 }
            java.lang.String r12 = r12.toString()     // Catch:{ EOFException -> 0x0088 }
            com.google.android.gms.internal.ads.zzbh r12 = com.google.android.gms.internal.ads.zzbh.zza(r12, r7)     // Catch:{ EOFException -> 0x0088 }
            throw r12     // Catch:{ EOFException -> 0x0088 }
        L_0x0088:
            return r4
        L_0x0089:
            com.google.android.gms.internal.ads.zzadx r0 = r11.zzp
            int r12 = r0.zzf(r12, r2, r5)
            if (r12 != r4) goto L_0x0092
            return r4
        L_0x0092:
            int r0 = r11.zzj
            int r0 = r0 - r12
            r11.zzj = r0
            if (r0 <= 0) goto L_0x009a
            return r3
        L_0x009a:
            com.google.android.gms.internal.ads.zzadx r4 = r11.zzp
            long r5 = r11.zzh
            int r8 = r11.zzi
            r9 = 0
            r10 = 0
            r7 = 1
            r4.zzs(r5, r7, r8, r9, r10)
            long r0 = r11.zzh
            r4 = 20000(0x4e20, double:9.8813E-320)
            long r0 = r0 + r4
            r11.zzh = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaee.zza(com.google.android.gms.internal.ads.zzacs):int");
    }

    private static boolean zzg(zzacs zzacs, byte[] bArr) throws IOException {
        zzacs.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        zzacs.zzh(bArr2, 0, length);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzh(zzacs zzacs) throws IOException {
        byte[] bArr = zzc;
        if (zzg(zzacs, bArr)) {
            this.zzg = false;
            zzacs.zzk(bArr.length);
            return true;
        }
        byte[] bArr2 = zzd;
        if (!zzg(zzacs, bArr2)) {
            return false;
        }
        this.zzg = true;
        zzacs.zzk(bArr2.length);
        return true;
    }

    public final int zzb(zzacs zzacs, zzadn zzadn) throws IOException {
        String str;
        zzdb.zzb(this.zzo);
        int i = zzen.zza;
        if (zzacs.zzf() != 0 || zzh(zzacs)) {
            if (!this.zzs) {
                this.zzs = true;
                boolean z = this.zzg;
                if (true != z) {
                    str = "audio/3gpp";
                } else {
                    str = "audio/amr-wb";
                }
                int i2 = true != z ? 8000 : 16000;
                int i3 = z ? zzb[8] : zza[7];
                zzadx zzadx = this.zzp;
                zzab zzab = new zzab();
                zzab.zzZ(str);
                zzab.zzQ(i3);
                zzab.zzz(1);
                zzab.zzaa(i2);
                zzadx.zzl(zzab.zzaf());
            }
            int zza2 = zza(zzacs);
            if (this.zzq == null) {
                zzadp zzadp = new zzadp(-9223372036854775807L, 0);
                this.zzq = zzadp;
                this.zzn.zzO(zzadp);
            }
            return zza2 == -1 ? -1 : 0;
        }
        throw zzbh.zza("Could not find AMR header.", (Throwable) null);
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zzn = zzacu;
        zzadx zzw = zzacu.zzw(0, 1);
        this.zzo = zzw;
        this.zzp = zzw;
        zzacu.zzD();
    }

    public final void zzf(long j, long j2) {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = 0;
        this.zzr = j2;
        this.zzm = 0;
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        return zzh(zzacs);
    }
}
