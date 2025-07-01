package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzll extends zzhn {
    public static final /* synthetic */ int zzb = 0;
    private final int zzc;
    private final int zzd;
    private final int[] zze;
    private final int[] zzf;
    private final zzbv[] zzg;
    private final Object[] zzh;
    private final HashMap zzi;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzll(java.util.Collection r7, com.google.android.gms.internal.ads.zzwj r8) {
        /*
            r6 = this;
            int r0 = r7.size()
            com.google.android.gms.internal.ads.zzbv[] r0 = new com.google.android.gms.internal.ads.zzbv[r0]
            java.util.Iterator r1 = r7.iterator()
            r2 = 0
            r3 = r2
        L_0x000c:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0022
            java.lang.Object r4 = r1.next()
            com.google.android.gms.internal.ads.zzku r4 = (com.google.android.gms.internal.ads.zzku) r4
            int r5 = r3 + 1
            com.google.android.gms.internal.ads.zzbv r4 = r4.zza()
            r0[r3] = r4
            r3 = r5
            goto L_0x000c
        L_0x0022:
            int r1 = r7.size()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.util.Iterator r7 = r7.iterator()
        L_0x002c:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x0042
            java.lang.Object r3 = r7.next()
            com.google.android.gms.internal.ads.zzku r3 = (com.google.android.gms.internal.ads.zzku) r3
            int r4 = r2 + 1
            java.lang.Object r3 = r3.zzb()
            r1[r2] = r3
            r2 = r4
            goto L_0x002c
        L_0x0042:
            r6.<init>(r0, r1, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzll.<init>(java.util.Collection, com.google.android.gms.internal.ads.zzwj):void");
    }

    public final int zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final int zzp(Object obj) {
        Integer num = (Integer) this.zzi.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public final int zzq(int i) {
        return zzen.zzc(this.zze, i + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public final int zzr(int i) {
        return zzen.zzc(this.zzf, i + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public final int zzs(int i) {
        return this.zze[i];
    }

    /* access modifiers changed from: protected */
    public final int zzt(int i) {
        return this.zzf[i];
    }

    /* access modifiers changed from: protected */
    public final zzbv zzu(int i) {
        return this.zzg[i];
    }

    /* access modifiers changed from: protected */
    public final Object zzv(int i) {
        return this.zzh[i];
    }

    /* access modifiers changed from: package-private */
    public final List zzw() {
        return Arrays.asList(this.zzg);
    }

    public final zzll zzx(zzwj zzwj) {
        zzbv[] zzbvArr = new zzbv[this.zzg.length];
        int i = 0;
        while (true) {
            zzbv[] zzbvArr2 = this.zzg;
            if (i >= zzbvArr2.length) {
                return new zzll(zzbvArr, this.zzh, zzwj);
            }
            zzbvArr[i] = new zzlk(this, zzbvArr2[i]);
            i++;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzll(zzbv[] zzbvArr, Object[] objArr, zzwj zzwj) {
        super(false, zzwj);
        int i = 0;
        this.zzg = zzbvArr;
        int length = zzbvArr.length;
        this.zze = new int[length];
        this.zzf = new int[length];
        this.zzh = objArr;
        this.zzi = new HashMap();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < zzbvArr.length) {
            zzbv zzbv = zzbvArr[i];
            this.zzg[i4] = zzbv;
            this.zzf[i4] = i2;
            this.zze[i4] = i3;
            i2 += zzbv.zzc();
            i3 += this.zzg[i4].zzb();
            this.zzi.put(objArr[i4], Integer.valueOf(i4));
            i++;
            i4++;
        }
        this.zzc = i2;
        this.zzd = i3;
    }
}
