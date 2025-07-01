package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzwk extends zzbv {
    private static final Object zzb = new Object();
    private final long zzc;
    private final long zzd;
    private final boolean zze;
    private final zzaw zzf;
    private final zzaq zzg;

    static {
        zzak zzak = new zzak();
        zzak.zza("SinglePeriodTimeline");
        zzak.zzb(Uri.EMPTY);
        zzak.zzc();
    }

    public final int zza(Object obj) {
        return zzb.equals(obj) ? 0 : -1;
    }

    public final int zzb() {
        return 1;
    }

    public final int zzc() {
        return 1;
    }

    public final zzbt zzd(int i, zzbt zzbt, boolean z) {
        zzdb.zza(i, 0, 1);
        zzbt zzbt2 = zzbt;
        zzbt2.zzi((Object) null, z ? zzb : null, 0, this.zzc, 0, zzb.zza, false);
        return zzbt2;
    }

    public final zzbu zze(int i, zzbu zzbu, long j) {
        zzdb.zza(i, 0, 1);
        Object obj = zzbu.zza;
        zzaw zzaw = this.zzf;
        long j2 = this.zzd;
        zzbu zzbu2 = zzbu;
        zzbu2.zza(obj, zzaw, (Object) null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.zze, false, this.zzg, 0, j2, 0, 0, 0);
        return zzbu;
    }

    public final Object zzf(int i) {
        zzdb.zza(i, 0, 1);
        return zzb;
    }

    public zzwk(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, zzaw zzaw, zzaq zzaq) {
        zzaw zzaw2 = zzaw;
        this.zzc = j4;
        this.zzd = j5;
        this.zze = z;
        zzaw2.getClass();
        zzaw zzaw3 = zzaw2;
        this.zzf = zzaw2;
        this.zzg = zzaq;
    }
}
