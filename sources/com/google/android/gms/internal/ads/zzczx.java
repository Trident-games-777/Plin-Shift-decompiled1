package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzczx implements zzdat {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzczx(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final void zza(Object obj) {
        ((zzems) obj).onAppEvent(this.zza, this.zzb);
    }
}
