package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcgh implements zzbjr {
    final /* synthetic */ zzcgj zza;

    zzcgh(zzcgj zzcgj) {
        this.zza = zzcgj;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfk zzcfk = (zzcfk) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zza) {
                        zzcgj zzcgj = this.zza;
                        if (zzcgj.zzI != parseInt) {
                            zzcgj.zzI = parseInt;
                            this.zza.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzm.zzk("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
