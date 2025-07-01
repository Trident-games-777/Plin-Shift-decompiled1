package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzede extends zzeeb {
    private Activity zza;
    private zzm zzb;
    private String zzc;
    private String zzd;

    zzede() {
    }

    public final zzeeb zza(Activity activity) {
        if (activity != null) {
            this.zza = activity;
            return this;
        }
        throw new NullPointerException("Null activity");
    }

    public final zzeeb zzb(zzm zzm) {
        this.zzb = zzm;
        return this;
    }

    public final zzeeb zzc(String str) {
        this.zzc = str;
        return this;
    }

    public final zzeeb zzd(String str) {
        this.zzd = str;
        return this;
    }

    public final zzeec zze() {
        Activity activity = this.zza;
        if (activity != null) {
            return new zzedg(activity, this.zzb, this.zzc, this.zzd, (zzedf) null);
        }
        throw new IllegalStateException("Missing required properties: activity");
    }
}
