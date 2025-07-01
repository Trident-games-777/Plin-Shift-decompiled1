package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzv;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzchn {
    private final VersionInfoParcel zza;
    private final Context zzb;
    private final long zzc;
    private final WeakReference zzd;

    /* synthetic */ zzchn(zzchl zzchl, zzchm zzchm) {
        this.zza = zzchl.zza;
        this.zzb = zzchl.zzb;
        this.zzd = zzchl.zzd;
        this.zzc = zzchl.zzc;
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final Context zzb() {
        return this.zzb;
    }

    public final zzk zzc() {
        return new zzk(this.zzb, this.zza);
    }

    /* access modifiers changed from: package-private */
    public final zzbfg zzd() {
        return new zzbfg(this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final VersionInfoParcel zze() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzf() {
        return zzv.zzq().zzc(this.zzb, this.zza.afmaVersion);
    }

    /* access modifiers changed from: package-private */
    public final WeakReference zzg() {
        return this.zzd;
    }
}
