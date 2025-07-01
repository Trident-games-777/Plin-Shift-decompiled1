package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzqk {
    /* access modifiers changed from: private */
    public final Context zza;
    /* access modifiers changed from: private */
    public final zzop zzb;
    private boolean zzc;
    private final zzqj zzd;
    /* access modifiers changed from: private */
    public zzqm zze;
    /* access modifiers changed from: private */
    public zzqc zzf;

    @Deprecated
    public zzqk() {
        this.zza = null;
        this.zzb = zzop.zza;
        this.zzd = zzqj.zza;
    }

    public final zzqw zzc() {
        zzdb.zzf(!this.zzc);
        this.zzc = true;
        if (this.zze == null) {
            this.zze = new zzqm(new zzcm[0]);
        }
        if (this.zzf == null) {
            this.zzf = new zzqc(this.zza);
        }
        return new zzqw(this, (zzqv) null);
    }

    public zzqk(Context context) {
        this.zza = context;
        this.zzb = zzop.zza;
        this.zzd = zzqj.zza;
    }
}
