package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzvn implements zzzb, zzug {
    final /* synthetic */ zzvs zza;
    /* access modifiers changed from: private */
    public final long zzb = zzui.zza();
    private final Uri zzc;
    /* access modifiers changed from: private */
    public final zzhc zzd;
    private final zzvh zze;
    private final zzacu zzf;
    private final zzdf zzg;
    private final zzadn zzh = new zzadn();
    private volatile boolean zzi;
    private boolean zzj = true;
    /* access modifiers changed from: private */
    public long zzk;
    /* access modifiers changed from: private */
    public zzgi zzl = zzi(0);
    private zzadx zzm;
    private boolean zzn;

    public zzvn(zzvs zzvs, Uri uri, zzgd zzgd, zzvh zzvh, zzacu zzacu, zzdf zzdf) {
        this.zza = zzvs;
        this.zzc = uri;
        this.zzd = new zzhc(zzgd);
        this.zze = zzvh;
        this.zzf = zzacu;
        this.zzg = zzdf;
    }

    static /* bridge */ /* synthetic */ void zzf(zzvn zzvn, long j, long j2) {
        zzvn.zzh.zza = j;
        zzvn.zzk = j2;
        zzvn.zzj = true;
        zzvn.zzn = false;
    }

    private final zzgi zzi(long j) {
        zzgg zzgg = new zzgg();
        zzgg.zzd(this.zzc);
        zzgg.zzc(j);
        zzgg.zza(6);
        zzgg.zzb(zzvs.zzb);
        return zzgg.zze();
    }

    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(17:63|64|67|68|62|(0)|72|(0)(0)|78|(0)|81|(0)|84|(2:(0)(0)|120)|(0)|106|(0)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0127 */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x021a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01dd A[EDGE_INSN: B:121:0x01dd->B:101:0x01dd ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a5 A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00af A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c5 A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d1 A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00db A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e7 A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f7 A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0103 A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0137 A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0153 A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x016f A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0187 A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0190 A[Catch:{ all -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x019c A[SYNTHETIC, Splitter:B:86:0x019c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh() throws java.io.IOException {
        /*
            r25 = this;
            r1 = r25
            java.lang.String r0 = "Invalid metadata interval: "
        L_0x0004:
            boolean r2 = r1.zzi
            if (r2 != 0) goto L_0x021a
            r2 = -1
            r4 = 1
            r5 = 0
            com.google.android.gms.internal.ads.zzadn r6 = r1.zzh     // Catch:{ all -> 0x01fd }
            long r11 = r6.zza     // Catch:{ all -> 0x01fd }
            com.google.android.gms.internal.ads.zzgi r6 = r1.zzi(r11)     // Catch:{ all -> 0x01fd }
            r1.zzl = r6     // Catch:{ all -> 0x01fd }
            com.google.android.gms.internal.ads.zzhc r7 = r1.zzd     // Catch:{ all -> 0x01fd }
            long r6 = r7.zzb(r6)     // Catch:{ all -> 0x01fd }
            boolean r8 = r1.zzi     // Catch:{ all -> 0x01fd }
            if (r8 == 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzvh r0 = r1.zze
            long r4 = r0.zzb()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzadn r2 = r1.zzh
            long r3 = r0.zzb()
            r2.zza = r3
        L_0x0032:
            com.google.android.gms.internal.ads.zzhc r0 = r1.zzd
            com.google.android.gms.internal.ads.zzgf.zza(r0)
            return
        L_0x0038:
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0042
            long r6 = r6 + r11
            com.google.android.gms.internal.ads.zzvs r8 = r1.zza     // Catch:{ all -> 0x01fd }
            r8.zzq.post(new com.google.android.gms.internal.ads.zzvi(r8))     // Catch:{ all -> 0x01fd }
        L_0x0042:
            r13 = r6
            com.google.android.gms.internal.ads.zzvs r6 = r1.zza     // Catch:{ all -> 0x01fd }
            com.google.android.gms.internal.ads.zzhc r7 = r1.zzd     // Catch:{ all -> 0x01fd }
            java.util.Map r7 = r7.zze()     // Catch:{ all -> 0x01fd }
            java.lang.String r8 = "icy-br"
            java.lang.Object r8 = r7.get(r8)     // Catch:{ all -> 0x01fd }
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x01fd }
            java.lang.String r9 = "IcyHeaders"
            r10 = -1
            if (r8 == 0) goto L_0x0095
            java.lang.Object r8 = r8.get(r5)     // Catch:{ all -> 0x01fd }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x01fd }
            int r15 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x0083 }
            int r15 = r15 * 1000
            if (r15 <= 0) goto L_0x006c
            r16 = r2
            r2 = r4
        L_0x0069:
            r19 = r15
            goto L_0x009a
        L_0x006c:
            r16 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0086 }
            r2.<init>()     // Catch:{ NumberFormatException -> 0x0086 }
            java.lang.String r3 = "Invalid bitrate: "
            r2.append(r3)     // Catch:{ NumberFormatException -> 0x0086 }
            r2.append(r8)     // Catch:{ NumberFormatException -> 0x0086 }
            java.lang.String r2 = r2.toString()     // Catch:{ NumberFormatException -> 0x0086 }
            com.google.android.gms.internal.ads.zzdt.zzf(r9, r2)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0097
        L_0x0083:
            r16 = r2
            r15 = r10
        L_0x0086:
            java.lang.String r2 = "Invalid bitrate header: "
            java.lang.String r3 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x01fb }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzdt.zzf(r9, r2)     // Catch:{ all -> 0x01fb }
            r2 = r5
            goto L_0x0069
        L_0x0095:
            r16 = r2
        L_0x0097:
            r2 = r5
            r19 = r10
        L_0x009a:
            java.lang.String r3 = "icy-genre"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01fb }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01fb }
            r8 = 0
            if (r3 == 0) goto L_0x00af
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01fb }
            r20 = r2
            r2 = r4
            goto L_0x00b1
        L_0x00af:
            r20 = r8
        L_0x00b1:
            java.lang.String r3 = "icy-name"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01fb }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01fb }
            if (r3 == 0) goto L_0x00c5
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01fb }
            r21 = r2
            r2 = r4
            goto L_0x00c7
        L_0x00c5:
            r21 = r8
        L_0x00c7:
            java.lang.String r3 = "icy-url"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01fb }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01fb }
            if (r3 == 0) goto L_0x00db
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01fb }
            r22 = r2
            r2 = r4
            goto L_0x00dd
        L_0x00db:
            r22 = r8
        L_0x00dd:
            java.lang.String r3 = "icy-pub"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01fb }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01fb }
            if (r3 == 0) goto L_0x00f7
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = "1"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x01fb }
            r23 = r2
            r2 = r4
            goto L_0x00f9
        L_0x00f7:
            r23 = r5
        L_0x00f9:
            java.lang.String r3 = "icy-metaint"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01fb }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01fb }
            if (r3 == 0) goto L_0x0133
            java.lang.Object r3 = r3.get(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x01fb }
            int r7 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0126 }
            if (r7 <= 0) goto L_0x0113
            r2 = r4
        L_0x0110:
            r24 = r7
            goto L_0x0135
        L_0x0113:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0127 }
            r15.<init>()     // Catch:{ NumberFormatException -> 0x0127 }
            r15.append(r0)     // Catch:{ NumberFormatException -> 0x0127 }
            r15.append(r3)     // Catch:{ NumberFormatException -> 0x0127 }
            java.lang.String r15 = r15.toString()     // Catch:{ NumberFormatException -> 0x0127 }
            com.google.android.gms.internal.ads.zzdt.zzf(r9, r15)     // Catch:{ NumberFormatException -> 0x0127 }
            goto L_0x0133
        L_0x0126:
            r7 = r10
        L_0x0127:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = r0.concat(r3)     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzdt.zzf(r9, r3)     // Catch:{ all -> 0x01fb }
            goto L_0x0110
        L_0x0133:
            r24 = r10
        L_0x0135:
            if (r2 == 0) goto L_0x013e
            com.google.android.gms.internal.ads.zzafv r18 = new com.google.android.gms.internal.ads.zzafv     // Catch:{ all -> 0x01fb }
            r18.<init>(r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x01fb }
            r8 = r18
        L_0x013e:
            r6.zzs = r8     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzhc r2 = r1.zzd     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzvs r3 = r1.zza     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzafv r6 = r3.zzs     // Catch:{ all -> 0x01fb }
            if (r6 == 0) goto L_0x016f
            com.google.android.gms.internal.ads.zzafv r6 = r3.zzs     // Catch:{ all -> 0x01fb }
            int r6 = r6.zzf     // Catch:{ all -> 0x01fb }
            if (r6 == r10) goto L_0x016f
            com.google.android.gms.internal.ads.zzuh r6 = new com.google.android.gms.internal.ads.zzuh     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzafv r3 = r3.zzs     // Catch:{ all -> 0x01fb }
            int r3 = r3.zzf     // Catch:{ all -> 0x01fb }
            r6.<init>(r2, r3, r1)     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzvs r2 = r1.zza     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzadx r2 = r2.zzv()     // Catch:{ all -> 0x01fb }
            r1.zzm = r2     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzad r3 = com.google.android.gms.internal.ads.zzvs.zzc     // Catch:{ all -> 0x01fb }
            r2.zzl(r3)     // Catch:{ all -> 0x01fb }
            r8 = r6
            goto L_0x0170
        L_0x016f:
            r8 = r2
        L_0x0170:
            com.google.android.gms.internal.ads.zzvh r7 = r1.zze     // Catch:{ all -> 0x01fb }
            android.net.Uri r9 = r1.zzc     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzhc r2 = r1.zzd     // Catch:{ all -> 0x01fb }
            java.util.Map r10 = r2.zze()     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzacu r15 = r1.zzf     // Catch:{ all -> 0x01fb }
            r7.zzd(r8, r9, r10, r11, r13, r15)     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzvs r2 = r1.zza     // Catch:{ all -> 0x01fb }
            com.google.android.gms.internal.ads.zzafv r2 = r2.zzs     // Catch:{ all -> 0x01fb }
            if (r2 == 0) goto L_0x018c
            com.google.android.gms.internal.ads.zzvh r2 = r1.zze     // Catch:{ all -> 0x01fb }
            r2.zzc()     // Catch:{ all -> 0x01fb }
        L_0x018c:
            boolean r2 = r1.zzj     // Catch:{ all -> 0x01fb }
            if (r2 == 0) goto L_0x0199
            com.google.android.gms.internal.ads.zzvh r2 = r1.zze     // Catch:{ all -> 0x01fb }
            long r6 = r1.zzk     // Catch:{ all -> 0x01fb }
            r2.zzf(r11, r6)     // Catch:{ all -> 0x01fb }
            r1.zzj = r5     // Catch:{ all -> 0x01fb }
        L_0x0199:
            r2 = r5
        L_0x019a:
            if (r2 != 0) goto L_0x01dd
            boolean r3 = r1.zzi     // Catch:{ all -> 0x01da }
            if (r3 != 0) goto L_0x01d8
            com.google.android.gms.internal.ads.zzdf r3 = r1.zzg     // Catch:{ InterruptedException -> 0x01d2 }
            r3.zza()     // Catch:{ InterruptedException -> 0x01d2 }
            com.google.android.gms.internal.ads.zzvh r3 = r1.zze     // Catch:{ all -> 0x01da }
            com.google.android.gms.internal.ads.zzadn r6 = r1.zzh     // Catch:{ all -> 0x01da }
            int r2 = r3.zza(r6)     // Catch:{ all -> 0x01da }
            com.google.android.gms.internal.ads.zzvh r3 = r1.zze     // Catch:{ all -> 0x01da }
            long r6 = r3.zzb()     // Catch:{ all -> 0x01da }
            com.google.android.gms.internal.ads.zzvs r3 = r1.zza     // Catch:{ all -> 0x01da }
            long r8 = r3.zzj     // Catch:{ all -> 0x01da }
            long r8 = r8 + r11
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x019a
            com.google.android.gms.internal.ads.zzdf r3 = r1.zzg     // Catch:{ all -> 0x01da }
            r3.zzc()     // Catch:{ all -> 0x01da }
            com.google.android.gms.internal.ads.zzvs r3 = r1.zza     // Catch:{ all -> 0x01da }
            android.os.Handler r8 = r3.zzq     // Catch:{ all -> 0x01da }
            java.lang.Runnable r3 = r3.zzp     // Catch:{ all -> 0x01da }
            r8.post(r3)     // Catch:{ all -> 0x01da }
            r11 = r6
            goto L_0x019a
        L_0x01d2:
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch:{ all -> 0x01da }
            r0.<init>()     // Catch:{ all -> 0x01da }
            throw r0     // Catch:{ all -> 0x01da }
        L_0x01d8:
            r2 = r5
            goto L_0x01dd
        L_0x01da:
            r0 = move-exception
            r5 = r2
            goto L_0x0200
        L_0x01dd:
            if (r2 != r4) goto L_0x01e0
            goto L_0x01f3
        L_0x01e0:
            com.google.android.gms.internal.ads.zzvh r3 = r1.zze
            long r4 = r3.zzb()
            int r4 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x01f2
            com.google.android.gms.internal.ads.zzadn r4 = r1.zzh
            long r5 = r3.zzb()
            r4.zza = r5
        L_0x01f2:
            r5 = r2
        L_0x01f3:
            com.google.android.gms.internal.ads.zzhc r2 = r1.zzd
            com.google.android.gms.internal.ads.zzgf.zza(r2)
            if (r5 == 0) goto L_0x0004
            goto L_0x021a
        L_0x01fb:
            r0 = move-exception
            goto L_0x0200
        L_0x01fd:
            r0 = move-exception
            r16 = r2
        L_0x0200:
            if (r5 == r4) goto L_0x0214
            com.google.android.gms.internal.ads.zzvh r2 = r1.zze
            long r3 = r2.zzb()
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 == 0) goto L_0x0214
            com.google.android.gms.internal.ads.zzadn r3 = r1.zzh
            long r4 = r2.zzb()
            r3.zza = r4
        L_0x0214:
            com.google.android.gms.internal.ads.zzhc r2 = r1.zzd
            com.google.android.gms.internal.ads.zzgf.zza(r2)
            throw r0
        L_0x021a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvn.zzh():void");
    }

    public final void zza(zzed zzed) {
        long j;
        if (!this.zzn) {
            j = this.zzk;
        } else {
            j = Math.max(this.zza.zzR(true), this.zzk);
        }
        int zzb2 = zzed.zzb();
        zzadx zzadx = this.zzm;
        zzadx.getClass();
        zzadx zzadx2 = zzadx;
        zzadx.zzq(zzed, zzb2);
        zzadx.zzs(j, 1, zzb2, 0, (zzadw) null);
        this.zzn = true;
    }
}
