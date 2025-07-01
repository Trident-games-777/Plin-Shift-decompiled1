package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdly implements zzcha {
    public final /* synthetic */ zzcan zza;

    public /* synthetic */ zzdly(zzcan zzcan) {
        this.zza = zzcan;
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzcan zzcan = this.zza;
        if (z) {
            zzcan.zzb();
            return;
        }
        zzcan.zzd(new zzeiz(1, "Image Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
