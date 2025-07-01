package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdnz implements Callable {
    /* access modifiers changed from: private */
    public final zza zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final zzdsm zzc;
    /* access modifiers changed from: private */
    public final zzedp zzd;
    /* access modifiers changed from: private */
    public final Executor zze;
    /* access modifiers changed from: private */
    public final zzavc zzf;
    /* access modifiers changed from: private */
    public final VersionInfoParcel zzg;
    /* access modifiers changed from: private */
    public final zzflr zzh;
    /* access modifiers changed from: private */
    public final zzeea zzi;
    /* access modifiers changed from: private */
    public final zzffs zzj;

    public zzdnz(Context context, Executor executor, zzavc zzavc, VersionInfoParcel versionInfoParcel, zza zza2, zzcfx zzcfx, zzedp zzedp, zzflr zzflr, zzdsm zzdsm, zzeea zzeea, zzffs zzffs) {
        this.zzb = context;
        this.zze = executor;
        this.zzf = zzavc;
        this.zzg = versionInfoParcel;
        this.zza = zza2;
        this.zzd = zzedp;
        this.zzh = zzflr;
        this.zzc = zzdsm;
        this.zzi = zzeea;
        this.zzj = zzffs;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdoc zzdoc = new zzdoc(this);
        zzdoc.zzk();
        return zzdoc;
    }
}
