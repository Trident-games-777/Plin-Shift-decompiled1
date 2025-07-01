package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzzp {
    /* access modifiers changed from: private */
    public final Context zza;
    /* access modifiers changed from: private */
    public final zzaap zzb;
    private zzcf zzc;
    /* access modifiers changed from: private */
    public zzbq zzd;
    /* access modifiers changed from: private */
    public zzdc zze = zzdc.zza;
    private boolean zzf;

    public zzzp(Context context, zzaap zzaap) {
        this.zza = context.getApplicationContext();
        this.zzb = zzaap;
    }

    public final zzzp zzd(zzdc zzdc) {
        this.zze = zzdc;
        return this;
    }

    public final zzaaa zze() {
        zzdb.zzf(!this.zzf);
        if (this.zzd == null) {
            if (this.zzc == null) {
                this.zzc = new zzzt((zzzz) null);
            }
            this.zzd = new zzzu(this.zzc);
        }
        zzaaa zzaaa = new zzaaa(this, (zzzz) null);
        this.zzf = true;
        return zzaaa;
    }
}
