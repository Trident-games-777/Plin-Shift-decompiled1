package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzum extends zzwt {
    private final boolean zzb;
    private final zzbu zzc;
    private final zzbt zzd;
    private zzuk zze;
    private zzuj zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzum(zzut zzut, boolean z) {
        super(zzut);
        boolean z2;
        if (z) {
            zzut.zzv();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzbu();
        this.zzd = new zzbt();
        zzut.zzM();
        this.zze = zzuk.zzq(zzut.zzJ());
    }

    private final Object zzK(Object obj) {
        return (this.zze.zze == null || !obj.equals(zzuk.zzc)) ? obj : this.zze.zze;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final boolean zzL(long j) {
        zzuj zzuj = this.zzf;
        int zza = this.zze.zza(zzuj.zza.zza);
        if (zza == -1) {
            return false;
        }
        zzuk zzuk = this.zze;
        zzbt zzbt = this.zzd;
        zzuk.zzd(zza, zzbt, false);
        long j2 = zzbt.zzd;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0, j2 - 1);
        }
        zzuj.zzs(j);
        return true;
    }

    public final zzbv zzC() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final zzur zzD(zzur zzur) {
        Object zzs = this.zze.zze;
        Object obj = zzur.zza;
        if (zzs != null && this.zze.zze.equals(obj)) {
            obj = zzuk.zzc;
        }
        return zzur.zza(obj);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzE(com.google.android.gms.internal.ads.zzbv r15) {
        /*
            r14 = this;
            boolean r0 = r14.zzh
            r1 = 0
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzuk r0 = r14.zze
            com.google.android.gms.internal.ads.zzuk r15 = r0.zzp(r15)
            r14.zze = r15
            com.google.android.gms.internal.ads.zzuj r15 = r14.zzf
            if (r15 == 0) goto L_0x009e
            long r2 = r15.zzn()
            r14.zzL(r2)
            goto L_0x009e
        L_0x001a:
            boolean r0 = r15.zzo()
            if (r0 == 0) goto L_0x0036
            boolean r0 = r14.zzi
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzuk r0 = r14.zze
            com.google.android.gms.internal.ads.zzuk r15 = r0.zzp(r15)
            goto L_0x0033
        L_0x002b:
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbu.zza
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzuk.zzc
            com.google.android.gms.internal.ads.zzuk r15 = com.google.android.gms.internal.ads.zzuk.zzr(r15, r0, r2)
        L_0x0033:
            r14.zze = r15
            goto L_0x009e
        L_0x0036:
            com.google.android.gms.internal.ads.zzbu r0 = r14.zzc
            r2 = 0
            r3 = 0
            r15.zze(r2, r0, r3)
            com.google.android.gms.internal.ads.zzbu r0 = r14.zzc
            java.lang.Object r0 = r0.zzb
            com.google.android.gms.internal.ads.zzuj r5 = r14.zzf
            if (r5 == 0) goto L_0x0062
            long r6 = r5.zzq()
            com.google.android.gms.internal.ads.zzuk r8 = r14.zze
            com.google.android.gms.internal.ads.zzbt r9 = r14.zzd
            com.google.android.gms.internal.ads.zzur r5 = r5.zza
            java.lang.Object r5 = r5.zza
            r8.zzn(r5, r9)
            com.google.android.gms.internal.ads.zzuk r5 = r14.zze
            com.google.android.gms.internal.ads.zzbu r8 = r14.zzc
            r5.zze(r2, r8, r3)
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0062
            r12 = r6
            goto L_0x0063
        L_0x0062:
            r12 = r3
        L_0x0063:
            com.google.android.gms.internal.ads.zzbu r9 = r14.zzc
            com.google.android.gms.internal.ads.zzbt r10 = r14.zzd
            r11 = 0
            r8 = r15
            android.util.Pair r15 = r8.zzl(r9, r10, r11, r12)
            java.lang.Object r2 = r15.first
            java.lang.Object r15 = r15.second
            java.lang.Long r15 = (java.lang.Long) r15
            long r3 = r15.longValue()
            boolean r15 = r14.zzi
            if (r15 == 0) goto L_0x0082
            com.google.android.gms.internal.ads.zzuk r15 = r14.zze
            com.google.android.gms.internal.ads.zzuk r15 = r15.zzp(r8)
            goto L_0x0086
        L_0x0082:
            com.google.android.gms.internal.ads.zzuk r15 = com.google.android.gms.internal.ads.zzuk.zzr(r8, r0, r2)
        L_0x0086:
            r14.zze = r15
            com.google.android.gms.internal.ads.zzuj r15 = r14.zzf
            if (r15 == 0) goto L_0x009e
            boolean r0 = r14.zzL(r3)
            if (r0 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzur r15 = r15.zza
            java.lang.Object r0 = r15.zza
            java.lang.Object r0 = r14.zzK(r0)
            com.google.android.gms.internal.ads.zzur r1 = r15.zza(r0)
        L_0x009e:
            r15 = 1
            r14.zzi = r15
            r14.zzh = r15
            com.google.android.gms.internal.ads.zzuk r15 = r14.zze
            r14.zzo(r15)
            if (r1 == 0) goto L_0x00b5
            com.google.android.gms.internal.ads.zzuj r15 = r14.zzf
            r15.getClass()
            r0 = r15
            com.google.android.gms.internal.ads.zzuj r0 = (com.google.android.gms.internal.ads.zzuj) r0
            r15.zzr(r1)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzum.zzE(com.google.android.gms.internal.ads.zzbv):void");
    }

    public final void zzF() {
        if (!this.zzb) {
            this.zzg = true;
            zzB((Object) null, this.zza);
        }
    }

    public final void zzG(zzup zzup) {
        ((zzuj) zzup).zzt();
        if (zzup == this.zzf) {
            this.zzf = null;
        }
    }

    /* renamed from: zzH */
    public final zzuj zzI(zzur zzur, zzys zzys, long j) {
        zzuj zzuj = new zzuj(zzur, zzys, j);
        zzuj.zzu(this.zza);
        if (this.zzh) {
            zzuj.zzr(zzur.zza(zzK(zzur.zza)));
            return zzuj;
        }
        this.zzf = zzuj;
        if (!this.zzg) {
            this.zzg = true;
            zzB((Object) null, this.zza);
        }
        return zzuj;
    }

    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    public final void zzt(zzaw zzaw) {
        if (this.zzi) {
            this.zze = this.zze.zzp(new zzwp(this.zze.zzb, zzaw));
        } else {
            this.zze = zzuk.zzq(zzaw);
        }
        this.zza.zzt(zzaw);
    }

    public final void zzz() {
    }
}
