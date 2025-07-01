package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzyb extends zzyg implements zzlp {
    public static final /* synthetic */ int zzb = 0;
    /* access modifiers changed from: private */
    public static final zzgaz zzc = zzgaz.zzb(new zzxb());
    public final Context zza;
    private final Object zzd = new Object();
    private final boolean zze;
    private zzxp zzf;
    private zzxt zzg;
    private zzg zzh;
    private final zzwx zzi;

    public zzyb(Context context) {
        zzwx zzwx = new zzwx();
        zzxp zzd2 = zzxp.zzd(context);
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzi = zzwx;
        zzxp zzxp = zzd2;
        this.zzf = zzd2;
        this.zzh = zzg.zza;
        boolean z = false;
        if (context != null && zzen.zzM(context)) {
            z = true;
        }
        this.zze = z;
        if (!z && context != null && zzen.zza >= 32) {
            this.zzg = zzxt.zza(context);
        }
        if (this.zzf.zzM && context == null) {
            zzdt.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    static /* bridge */ /* synthetic */ int zzb(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    protected static int zzc(zzad zzad, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzad.zzd)) {
            return 4;
        }
        String zzh2 = zzh(str);
        String zzh3 = zzh(zzad.zzd);
        if (zzh3 == null || zzh2 == null) {
            if (!z || zzh3 != null) {
                return 0;
            }
            return 1;
        } else if (zzh3.startsWith(zzh2) || zzh2.startsWith(zzh3)) {
            return 3;
        } else {
            int i = zzen.zza;
            if (zzh3.split("-", 2)[0].equals(zzh2.split("-", 2)[0])) {
                return 2;
            }
            return 0;
        }
    }

    protected static String zzh(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ boolean zzm(com.google.android.gms.internal.ads.zzyb r8, com.google.android.gms.internal.ads.zzad r9) {
        /*
            java.lang.Object r0 = r8.zzd
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzxp r1 = r8.zzf     // Catch:{ all -> 0x008f }
            boolean r1 = r1.zzM     // Catch:{ all -> 0x008f }
            r2 = 1
            if (r1 == 0) goto L_0x008d
            boolean r1 = r8.zze     // Catch:{ all -> 0x008f }
            if (r1 != 0) goto L_0x008d
            int r1 = r9.zzC     // Catch:{ all -> 0x008f }
            r3 = 2
            if (r1 <= r3) goto L_0x008d
            java.lang.String r1 = r9.zzo     // Catch:{ all -> 0x008f }
            r4 = 32
            r5 = 0
            if (r1 != 0) goto L_0x001b
            goto L_0x0065
        L_0x001b:
            int r6 = r1.hashCode()     // Catch:{ all -> 0x008f }
            r7 = 3
            switch(r6) {
                case -2123537834: goto L_0x0042;
                case 187078296: goto L_0x0038;
                case 187078297: goto L_0x002e;
                case 1504578661: goto L_0x0024;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x004c
        L_0x0024:
            java.lang.String r6 = "audio/eac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r2
            goto L_0x004d
        L_0x002e:
            java.lang.String r6 = "audio/ac4"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r7
            goto L_0x004d
        L_0x0038:
            java.lang.String r6 = "audio/ac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r5
            goto L_0x004d
        L_0x0042:
            java.lang.String r6 = "audio/eac3-joc"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r3
            goto L_0x004d
        L_0x004c:
            r1 = -1
        L_0x004d:
            if (r1 == 0) goto L_0x0056
            if (r1 == r2) goto L_0x0056
            if (r1 == r3) goto L_0x0056
            if (r1 == r7) goto L_0x0056
            goto L_0x0065
        L_0x0056:
            int r1 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x008f }
            if (r1 < r4) goto L_0x008d
            com.google.android.gms.internal.ads.zzxt r1 = r8.zzg     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008d
            boolean r1 = r1.zzg()     // Catch:{ all -> 0x008f }
            if (r1 != 0) goto L_0x0065
            goto L_0x008d
        L_0x0065:
            int r1 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x008f }
            if (r1 < r4) goto L_0x008c
            com.google.android.gms.internal.ads.zzxt r1 = r8.zzg     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            boolean r3 = r1.zzg()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x008c
            boolean r1 = r1.zze()     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzxt r1 = r8.zzg     // Catch:{ all -> 0x008f }
            boolean r1 = r1.zzf()     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzxt r1 = r8.zzg     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzg r8 = r8.zzh     // Catch:{ all -> 0x008f }
            boolean r8 = r1.zzd(r8, r9)     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r2 = r5
        L_0x008d:
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            return r2
        L_0x008f:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyb.zzm(com.google.android.gms.internal.ads.zzyb, com.google.android.gms.internal.ads.zzad):boolean");
    }

    private static void zzt(zzwr zzwr, zzcb zzcb, Map map) {
        int i = 0;
        while (i < zzwr.zzb) {
            if (((zzbx) zzcb.zzA.get(zzwr.zzb(i))) == null) {
                i++;
            } else {
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzu() {
        boolean z;
        zzxt zzxt;
        synchronized (this.zzd) {
            z = false;
            if (this.zzf.zzM && !this.zze && zzen.zza >= 32 && (zzxt = this.zzg) != null && zzxt.zzg()) {
                z = true;
            }
        }
        if (z) {
            zzs();
        }
    }

    private static final Pair zzv(int i, zzyf zzyf, int[][][] iArr, zzxv zzxv, Comparator comparator) {
        Object obj;
        zzyf zzyf2 = zzyf;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < 2) {
            if (i == zzyf2.zzc(i2)) {
                zzwr zzd2 = zzyf2.zzd(i2);
                int i3 = 0;
                while (i3 < zzd2.zzb) {
                    zzbw zzb2 = zzd2.zzb(i3);
                    List zza2 = zzxv.zza(i2, zzb2, iArr[i2][i3]);
                    boolean[] zArr = new boolean[zzb2.zza];
                    int i4 = 0;
                    while (i4 < zzb2.zza) {
                        int i5 = i4 + 1;
                        zzxw zzxw = (zzxw) zza2.get(i4);
                        int zzb3 = zzxw.zzb();
                        if (!zArr[i4] && zzb3 != 0) {
                            if (zzb3 == 1) {
                                obj = zzfzo.zzo(zzxw);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzxw);
                                int i6 = i5;
                                while (i6 < zzb2.zza) {
                                    zzxw zzxw2 = (zzxw) zza2.get(i6);
                                    if (zzxw2.zzb() == 2 && zzxw.zzc(zzxw2)) {
                                        arrayList2.add(zzxw2);
                                        zArr[i6] = true;
                                    }
                                    i6++;
                                    zzyf zzyf3 = zzyf;
                                }
                                obj = arrayList2;
                            }
                            arrayList.add(obj);
                        }
                        zzyf zzyf4 = zzyf;
                        i4 = i5;
                    }
                    i3++;
                    zzyf zzyf5 = zzyf;
                }
            }
            zzxv zzxv2 = zzxv;
            i2++;
            zzyf2 = zzyf;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i7 = 0; i7 < list.size(); i7++) {
            iArr2[i7] = ((zzxw) list.get(i7)).zzc;
        }
        zzxw zzxw3 = (zzxw) list.get(0);
        return Pair.create(new zzyc(zzxw3.zzb, iArr2, 0), Integer.valueOf(zzxw3.zza));
    }

    public final void zza(zzln zzln) {
        synchronized (this.zzd) {
            boolean z = this.zzf.zzQ;
        }
    }

    /* access modifiers changed from: protected */
    public final Pair zzd(zzyf zzyf, int[][][] iArr, int[] iArr2, zzur zzur, zzbv zzbv) throws zzig {
        zzxp zzxp;
        Pair pair;
        int i;
        boolean z;
        String str;
        int[] iArr3;
        int length;
        zzyd zzyd;
        zzyc zzyc;
        zzxt zzxt;
        zzyf zzyf2 = zzyf;
        int[][][] iArr4 = iArr;
        int[] iArr5 = iArr2;
        synchronized (this.zzd) {
            zzxp = this.zzf;
            if (zzxp.zzM && zzen.zza >= 32 && (zzxt = this.zzg) != null) {
                Looper myLooper = Looper.myLooper();
                zzdb.zzb(myLooper);
                Looper looper = myLooper;
                zzxt.zzb(this, myLooper);
            }
        }
        int i2 = 2;
        zzyc[] zzycArr = new zzyc[2];
        zzbz zzbz = zzxp.zzs;
        Pair zzv = zzv(2, zzyf2, iArr4, new zzxh(zzxp, iArr5), new zzxi());
        boolean z2 = zzxp.zzx;
        int i3 = 4;
        if (zzv == null) {
            zzbz zzbz2 = zzxp.zzs;
            pair = zzv(4, zzyf2, iArr4, new zzxd(zzxp), new zzxe());
        } else {
            pair = null;
        }
        int i4 = 0;
        if (pair != null) {
            zzycArr[((Integer) pair.second).intValue()] = (zzyc) pair.first;
        } else if (zzv != null) {
            zzycArr[((Integer) zzv.second).intValue()] = (zzyc) zzv.first;
        }
        int i5 = 0;
        while (true) {
            i = 1;
            if (i5 < 2) {
                if (zzyf2.zzc(i5) == 2 && zzyf2.zzd(i5).zzb > 0) {
                    z = true;
                    break;
                }
                i5++;
            } else {
                z = false;
                break;
            }
        }
        Pair zzv2 = zzv(1, zzyf2, iArr4, new zzxf(this, zzxp, z, iArr5), new zzxg());
        if (zzv2 != null) {
            zzycArr[((Integer) zzv2.second).intValue()] = (zzyc) zzv2.first;
        }
        if (zzv2 == null) {
            str = null;
        } else {
            str = ((zzyc) zzv2.first).zza.zzb(((zzyc) zzv2.first).zzb[0]).zzd;
        }
        zzbz zzbz3 = zzxp.zzs;
        int i6 = 3;
        Pair zzv3 = zzv(3, zzyf2, iArr4, new zzxj(zzxp, str), new zzxk());
        if (zzv3 != null) {
            zzycArr[((Integer) zzv3.second).intValue()] = (zzyc) zzv3.first;
        }
        int i7 = 0;
        while (i7 < i2) {
            int zzc2 = zzyf2.zzc(i7);
            if (zzc2 != i2 && zzc2 != i && zzc2 != i6 && zzc2 != i3) {
                zzwr zzd2 = zzyf2.zzd(i7);
                int[][] iArr6 = iArr4[i7];
                zzbz zzbz4 = zzxp.zzs;
                int i8 = i4;
                int i9 = i8;
                zzbw zzbw = null;
                zzxn zzxn = null;
                while (i8 < zzd2.zzb) {
                    zzbw zzb2 = zzd2.zzb(i8);
                    int[] iArr7 = iArr6[i8];
                    zzxn zzxn2 = zzxn;
                    for (int i10 = i4; i10 < zzb2.zza; i10++) {
                        if (zzlo.zza(iArr7[i10], zzxp.zzN)) {
                            zzxn zzxn3 = new zzxn(zzb2.zzb(i10), iArr7[i10]);
                            if (zzxn2 == null || zzxn3.compareTo(zzxn2) > 0) {
                                zzbw = zzb2;
                                zzxn2 = zzxn3;
                                i9 = i10;
                            }
                        }
                    }
                    i8++;
                    zzxn = zzxn2;
                    i4 = 0;
                }
                if (zzbw == null) {
                    zzyc = null;
                } else {
                    zzyc = new zzyc(zzbw, new int[]{i9}, 0);
                }
                zzycArr[i7] = zzyc;
            }
            i7++;
            i2 = 2;
            i3 = 4;
            i = 1;
            i4 = 0;
            i6 = 3;
        }
        HashMap hashMap = new HashMap();
        int i11 = 2;
        for (int i12 = 0; i12 < 2; i12++) {
            zzt(zzyf2.zzd(i12), zzxp, hashMap);
        }
        zzt(zzyf2.zze(), zzxp, hashMap);
        int i13 = 0;
        while (i13 < 2) {
            if (((zzbx) hashMap.get(Integer.valueOf(zzyf2.zzc(i13)))) == null) {
                i13++;
            } else {
                throw null;
            }
        }
        int i14 = 0;
        while (i14 < i11) {
            zzwr zzd3 = zzyf2.zzd(i14);
            if (zzxp.zzg(i14, zzd3)) {
                if (zzxp.zze(i14, zzd3) == null) {
                    zzycArr[i14] = null;
                } else {
                    throw null;
                }
            }
            i14++;
            i11 = 2;
        }
        int i15 = 0;
        while (i15 < i11) {
            int zzc3 = zzyf2.zzc(i15);
            if (zzxp.zzf(i15) || zzxp.zzB.contains(Integer.valueOf(zzc3))) {
                zzycArr[i15] = null;
            }
            i15++;
            i11 = 2;
        }
        zzwx zzwx = this.zzi;
        zzyr zzq = zzq();
        zzfzo zzf2 = zzwy.zzf(zzycArr);
        int i16 = 2;
        zzyd[] zzydArr = new zzyd[2];
        int i17 = 0;
        while (i17 < i16) {
            zzyc zzyc2 = zzycArr[i17];
            if (zzyc2 != null && (length = iArr3.length) != 0) {
                if (length == 1) {
                    zzyd = new zzye(zzyc2.zza, iArr3[0], 0, 0, (Object) null);
                } else {
                    zzyd = zzwx.zza(zzyc2.zza, (iArr3 = zzyc2.zzb), 0, zzq, (zzfzo) zzf2.get(i17));
                }
                zzydArr[i17] = zzyd;
            }
            i17++;
            i16 = 2;
        }
        zzlr[] zzlrArr = new zzlr[i16];
        for (int i18 = 0; i18 < i16; i18++) {
            zzlrArr[i18] = (zzxp.zzf(i18) || zzxp.zzB.contains(Integer.valueOf(zzyf2.zzc(i18))) || (zzyf2.zzc(i18) != -2 && zzydArr[i18] == null)) ? null : zzlr.zza;
        }
        boolean z3 = zzxp.zzO;
        zzbz zzbz5 = zzxp.zzs;
        return Pair.create(zzlrArr, zzydArr);
    }

    public final zzlp zze() {
        return this;
    }

    public final zzxp zzf() {
        zzxp zzxp;
        synchronized (this.zzd) {
            zzxp = this.zzf;
        }
        return zzxp;
    }

    public final void zzj() {
        zzxt zzxt;
        synchronized (this.zzd) {
            if (zzen.zza >= 32 && (zzxt = this.zzg) != null) {
                zzxt.zzc();
            }
        }
        super.zzj();
    }

    public final void zzk(zzg zzg2) {
        boolean equals;
        synchronized (this.zzd) {
            equals = this.zzh.equals(zzg2);
            this.zzh = zzg2;
        }
        if (!equals) {
            zzu();
        }
    }

    public final void zzl(zzxo zzxo) {
        boolean equals;
        zzxp zzxp = new zzxp(zzxo);
        synchronized (this.zzd) {
            equals = this.zzf.equals(zzxp);
            this.zzf = zzxp;
        }
        if (!equals) {
            if (zzxp.zzM && this.zza == null) {
                zzdt.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzs();
        }
    }

    public final boolean zzn() {
        return true;
    }
}
