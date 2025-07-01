package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzuk extends zzuf {
    public static final Object zzc = new Object();
    private final Object zzd;
    /* access modifiers changed from: private */
    public final Object zze;

    private zzuk(zzbv zzbv, Object obj, Object obj2) {
        super(zzbv);
        this.zzd = obj;
        this.zze = obj2;
    }

    public static zzuk zzq(zzaw zzaw) {
        return new zzuk(new zzul(zzaw), zzbu.zza, zzc);
    }

    public static zzuk zzr(zzbv zzbv, Object obj, Object obj2) {
        return new zzuk(zzbv, obj, obj2);
    }

    public final int zza(Object obj) {
        Object obj2;
        if (zzc.equals(obj) && (obj2 = this.zze) != null) {
            obj = obj2;
        }
        return this.zzb.zza(obj);
    }

    public final zzbt zzd(int i, zzbt zzbt, boolean z) {
        this.zzb.zzd(i, zzbt, z);
        if (Objects.equals(zzbt.zzb, this.zze) && z) {
            zzbt.zzb = zzc;
        }
        return zzbt;
    }

    public final zzbu zze(int i, zzbu zzbu, long j) {
        this.zzb.zze(i, zzbu, j);
        if (Objects.equals(zzbu.zzb, this.zzd)) {
            zzbu.zzb = zzbu.zza;
        }
        return zzbu;
    }

    public final Object zzf(int i) {
        Object zzf = this.zzb.zzf(i);
        return Objects.equals(zzf, this.zze) ? zzc : zzf;
    }

    public final zzuk zzp(zzbv zzbv) {
        return new zzuk(zzbv, this.zzd, this.zze);
    }
}
