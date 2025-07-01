package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzfpd extends AsyncTask {
    private zzfpe zza;
    protected final zzfov zzd;

    public zzfpd(zzfov zzfov) {
        this.zzd = zzfov;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public void onPostExecute(String str) {
        zzfpe zzfpe = this.zza;
        if (zzfpe != null) {
            zzfpe.zza(this);
        }
    }

    public final void zzb(zzfpe zzfpe) {
        this.zza = zzfpe;
    }
}
