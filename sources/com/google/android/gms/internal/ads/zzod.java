package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzod implements zzoh {
    public static final zzfxg zza = new zzob();
    private static final Random zzb = new Random();
    /* access modifiers changed from: private */
    public final zzbu zzc;
    /* access modifiers changed from: private */
    public final zzbt zzd;
    private final HashMap zze;
    private zzog zzf;
    private zzbv zzg;
    private String zzh;
    private long zzi;

    public zzod() {
        throw null;
    }

    public zzod(zzfxg zzfxg) {
        this.zzc = new zzbu();
        this.zzd = new zzbt();
        this.zze = new HashMap();
        this.zzg = zzbv.zza;
        this.zzi = -1;
    }

    /* access modifiers changed from: private */
    public final long zzl() {
        zzoc zzoc = (zzoc) this.zze.get(this.zzh);
        return (zzoc == null || zzoc.zzd == -1) ? this.zzi + 1 : zzoc.zzd;
    }

    private final zzoc zzm(int i, zzur zzur) {
        int i2;
        long j = Long.MAX_VALUE;
        zzoc zzoc = null;
        for (zzoc zzoc2 : this.zze.values()) {
            zzoc2.zzg(i, zzur);
            if (zzoc2.zzj(i, zzur)) {
                long zzb2 = zzoc2.zzd;
                if (zzb2 == -1 || zzb2 < j) {
                    zzoc = zzoc2;
                    j = zzb2;
                } else if (i2 == 0) {
                    int i3 = zzen.zza;
                    zzoc zzoc3 = zzoc;
                    if (!(zzoc.zze == null || zzoc2.zze == null)) {
                        zzoc = zzoc2;
                    }
                }
            }
        }
        if (zzoc != null) {
            return zzoc;
        }
        String zzn = zzn();
        String str = zzn;
        zzoc zzoc4 = new zzoc(this, zzn, i, zzur);
        this.zze.put(zzn, zzoc4);
        return zzoc4;
    }

    /* access modifiers changed from: private */
    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzoc zzoc) {
        if (zzoc.zzd != -1) {
            this.zzi = zzoc.zzd;
        }
        this.zzh = null;
    }

    @RequiresNonNull({"listener"})
    private final void zzp(zzlx zzlx) {
        if (zzlx.zzb.zzo()) {
            String str = this.zzh;
            if (str != null) {
                zzoc zzoc = (zzoc) this.zze.get(str);
                zzoc.getClass();
                zzoc zzoc2 = zzoc;
                zzo(zzoc);
                return;
            }
            return;
        }
        zzoc zzoc3 = (zzoc) this.zze.get(this.zzh);
        zzoc zzm = zzm(zzlx.zzc, zzlx.zzd);
        this.zzh = zzm.zzb;
        zzi(zzlx);
        zzur zzur = zzlx.zzd;
        if (zzur != null && zzur.zzb()) {
            if (zzoc3 != null) {
                if (zzoc3.zzd == zzur.zzd && zzoc3.zze != null && zzoc3.zze.zzb == zzlx.zzd.zzb && zzoc3.zze.zzc == zzlx.zzd.zzc) {
                    return;
                }
            }
            zzur zzur2 = zzlx.zzd;
            String unused = zzm(zzlx.zzc, new zzur(zzur2.zza, zzur2.zzd)).zzb;
            String unused2 = zzm.zzb;
        }
    }

    public final synchronized String zze() {
        return this.zzh;
    }

    public final synchronized String zzf(zzbv zzbv, zzur zzur) {
        return zzm(zzbv.zzn(zzur.zza, this.zzd).zzc, zzur).zzb;
    }

    public final synchronized void zzg(zzlx zzlx) {
        zzog zzog;
        String str = this.zzh;
        if (str != null) {
            zzoc zzoc = (zzoc) this.zze.get(str);
            if (zzoc != null) {
                zzoc zzoc2 = zzoc;
                zzo(zzoc);
            } else {
                throw null;
            }
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzoc zzoc3 = (zzoc) it.next();
            it.remove();
            if (zzoc3.zzf && (zzog = this.zzf) != null) {
                zzog.zzd(zzlx, zzoc3.zzb, false);
            }
        }
    }

    public final void zzh(zzog zzog) {
        this.zzf = zzog;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        if (r0.zzc == r10.zzc) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzi(com.google.android.gms.internal.ads.zzlx r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzog r0 = r9.zzf     // Catch:{ all -> 0x00c7 }
            if (r0 == 0) goto L_0x00c5
            com.google.android.gms.internal.ads.zzbv r0 = r10.zzb     // Catch:{ all -> 0x00c7 }
            boolean r0 = r0.zzo()     // Catch:{ all -> 0x00c7 }
            if (r0 == 0) goto L_0x000f
            goto L_0x00c3
        L_0x000f:
            com.google.android.gms.internal.ads.zzur r0 = r10.zzd     // Catch:{ all -> 0x00c7 }
            if (r0 == 0) goto L_0x003b
            long r1 = r9.zzl()     // Catch:{ all -> 0x00c7 }
            long r3 = r0.zzd     // Catch:{ all -> 0x00c7 }
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00c3
            java.util.HashMap r0 = r9.zze     // Catch:{ all -> 0x00c7 }
            java.lang.String r1 = r9.zzh     // Catch:{ all -> 0x00c7 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzoc r0 = (com.google.android.gms.internal.ads.zzoc) r0     // Catch:{ all -> 0x00c7 }
            if (r0 == 0) goto L_0x003b
            long r1 = r0.zzd     // Catch:{ all -> 0x00c7 }
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x003b
            int r0 = r0.zzc     // Catch:{ all -> 0x00c7 }
            int r1 = r10.zzc     // Catch:{ all -> 0x00c7 }
            if (r0 != r1) goto L_0x00c3
        L_0x003b:
            int r0 = r10.zzc     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzur r1 = r10.zzd     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzoc r0 = r9.zzm(r0, r1)     // Catch:{ all -> 0x00c7 }
            java.lang.String r1 = r9.zzh     // Catch:{ all -> 0x00c7 }
            if (r1 != 0) goto L_0x004d
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00c7 }
            r9.zzh = r1     // Catch:{ all -> 0x00c7 }
        L_0x004d:
            com.google.android.gms.internal.ads.zzur r1 = r10.zzd     // Catch:{ all -> 0x00c7 }
            r2 = 1
            if (r1 == 0) goto L_0x0097
            boolean r3 = r1.zzb()     // Catch:{ all -> 0x00c7 }
            if (r3 == 0) goto L_0x0097
            java.lang.Object r3 = r1.zza     // Catch:{ all -> 0x00c7 }
            long r4 = r1.zzd     // Catch:{ all -> 0x00c7 }
            int r1 = r1.zzb     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzur r6 = new com.google.android.gms.internal.ads.zzur     // Catch:{ all -> 0x00c7 }
            r6.<init>(r3, r4, r1)     // Catch:{ all -> 0x00c7 }
            int r1 = r10.zzc     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzoc r1 = r9.zzm(r1, r6)     // Catch:{ all -> 0x00c7 }
            boolean r3 = r1.zzf     // Catch:{ all -> 0x00c7 }
            if (r3 != 0) goto L_0x0097
            r1.zzf = true     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzbv r3 = r10.zzb     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzur r4 = r10.zzd     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzbt r5 = r9.zzd     // Catch:{ all -> 0x00c7 }
            java.lang.Object r4 = r4.zza     // Catch:{ all -> 0x00c7 }
            r3.zzn(r4, r5)     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzbt r3 = r9.zzd     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzur r4 = r10.zzd     // Catch:{ all -> 0x00c7 }
            int r4 = r4.zzb     // Catch:{ all -> 0x00c7 }
            r3.zzg(r4)     // Catch:{ all -> 0x00c7 }
            r3 = 0
            long r5 = com.google.android.gms.internal.ads.zzen.zzv(r3)     // Catch:{ all -> 0x00c7 }
            long r7 = com.google.android.gms.internal.ads.zzen.zzv(r3)     // Catch:{ all -> 0x00c7 }
            long r5 = r5 + r7
            java.lang.Math.max(r3, r5)     // Catch:{ all -> 0x00c7 }
            java.lang.String unused = r1.zzb     // Catch:{ all -> 0x00c7 }
        L_0x0097:
            boolean r1 = r0.zzf     // Catch:{ all -> 0x00c7 }
            if (r1 != 0) goto L_0x00a3
            r0.zzf = true     // Catch:{ all -> 0x00c7 }
            java.lang.String unused = r0.zzb     // Catch:{ all -> 0x00c7 }
        L_0x00a3:
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00c7 }
            java.lang.String r3 = r9.zzh     // Catch:{ all -> 0x00c7 }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x00c3
            boolean r1 = r0.zzg     // Catch:{ all -> 0x00c7 }
            if (r1 != 0) goto L_0x00c3
            r0.zzg = true     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzog r1 = r9.zzf     // Catch:{ all -> 0x00c7 }
            java.lang.String r0 = r0.zzb     // Catch:{ all -> 0x00c7 }
            r1.zzc(r10, r0)     // Catch:{ all -> 0x00c7 }
            monitor-exit(r9)
            return
        L_0x00c3:
            monitor-exit(r9)
            return
        L_0x00c5:
            r10 = 0
            throw r10     // Catch:{ all -> 0x00c7 }
        L_0x00c7:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00c7 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzod.zzi(com.google.android.gms.internal.ads.zzlx):void");
    }

    public final synchronized void zzj(zzlx zzlx, int i) {
        if (this.zzf != null) {
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzoc zzoc = (zzoc) it.next();
                if (zzoc.zzk(zzlx)) {
                    it.remove();
                    if (zzoc.zzf) {
                        boolean equals = zzoc.zzb.equals(this.zzh);
                        boolean z = false;
                        if (i == 0 && equals && zzoc.zzg) {
                            z = true;
                        }
                        if (equals) {
                            zzo(zzoc);
                        }
                        this.zzf.zzd(zzlx, zzoc.zzb, z);
                    }
                }
            }
            zzp(zzlx);
        } else {
            throw null;
        }
    }

    public final synchronized void zzk(zzlx zzlx) {
        if (this.zzf != null) {
            zzbv zzbv = this.zzg;
            this.zzg = zzlx.zzb;
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzoc zzoc = (zzoc) it.next();
                if (!zzoc.zzl(zzbv, this.zzg) || zzoc.zzk(zzlx)) {
                    it.remove();
                    if (zzoc.zzf) {
                        if (zzoc.zzb.equals(this.zzh)) {
                            zzo(zzoc);
                        }
                        this.zzf.zzd(zzlx, zzoc.zzb, false);
                    }
                }
            }
            zzp(zzlx);
        } else {
            throw null;
        }
    }
}
