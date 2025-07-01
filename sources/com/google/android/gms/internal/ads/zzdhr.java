package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdhr implements zzbjr {
    private final WeakReference zza;

    /* synthetic */ zzdhr(zzdhu zzdhu, zzdht zzdht) {
        this.zza = new WeakReference(zzdhu);
    }

    public final void zza(Object obj, Map map) {
        zzdhu zzdhu = (zzdhu) this.zza.get();
        if (zzdhu != null) {
            zzdhu.zzh.onAdClicked();
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzkt)).booleanValue()) {
                zzdhu.zzi.zzdG();
                if (!TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                    zzdhu.zzi.zzdf();
                }
            }
        }
    }
}
