package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdnj implements zzbfm {
    final /* synthetic */ String zza = NativeCustomFormatAd.ASSET_NAME_VIDEO;
    final /* synthetic */ zzdnk zzb;

    zzdnj(zzdnk zzdnk, String str) {
        this.zzb = zzdnk;
    }

    public final JSONObject zza() {
        return null;
    }

    public final JSONObject zzb() {
        return null;
    }

    public final void zzc() {
        zzdnk zzdnk = this.zzb;
        if (zzdnk.zzd != null) {
            zzdnk.zzd.zzF(this.zza);
        }
    }

    public final void zzd(MotionEvent motionEvent) {
    }
}
