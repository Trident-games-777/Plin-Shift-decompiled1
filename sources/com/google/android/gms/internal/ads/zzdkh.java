package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdkh implements zzbjr {
    public final /* synthetic */ zzdkk zza;

    public /* synthetic */ zzdkh(zzdkk zzdkk) {
        this.zza = zzdkk;
    }

    public final void zza(Object obj, Map map) {
        zzcfk zzcfk = (zzcfk) obj;
        zzcfk.zzN().zzB(new zzdke(this.zza, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzcfk.loadData(str, "text/html", "UTF-8");
        } else {
            zzcfk.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        }
    }
}
