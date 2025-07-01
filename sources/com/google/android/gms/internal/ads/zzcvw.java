package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcvw {
    private final Context zza;
    private final zzffo zzb;
    private final Bundle zzc;
    private final zzffg zzd;
    private final zzcvo zze;
    private final zzefg zzf;

    /* synthetic */ zzcvw(zzcvu zzcvu, zzcvv zzcvv) {
        this.zza = zzcvu.zza;
        this.zzb = zzcvu.zzb;
        this.zzc = zzcvu.zzc;
        this.zzd = zzcvu.zzd;
        this.zze = zzcvu.zze;
        this.zzf = zzcvu.zzf;
    }

    /* access modifiers changed from: package-private */
    public final Context zza(Context context) {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzcvo zzc() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final zzcvu zzd() {
        zzcvu zzcvu = new zzcvu();
        zzcvu.zze(this.zza);
        zzcvu.zzi(this.zzb);
        zzcvu.zzf(this.zzc);
        zzcvu.zzg(this.zze);
        zzcvu.zzd(this.zzf);
        return zzcvu;
    }

    /* access modifiers changed from: package-private */
    public final zzefg zze(String str) {
        zzefg zzefg = this.zzf;
        return zzefg != null ? zzefg : new zzefg(str);
    }

    /* access modifiers changed from: package-private */
    public final zzffg zzf() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzffo zzg() {
        return this.zzb;
    }
}
