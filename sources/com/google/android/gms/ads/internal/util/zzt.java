package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbbl;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfs;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzeea;
import java.io.InputStream;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzt extends zzaa {
    public zzt() {
        super((zzz) null);
    }

    public final CookieManager zza(Context context) {
        zzv.zzq();
        if (zzs.zzF()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzm.zzh("Failed to obtain CookieManager.", th);
            zzv.zzp().zzv(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final WebResourceResponse zzb(String str, String str2, int i, String str3, Map map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }

    public final zzcfs zzc(zzcfk zzcfk, zzbbl zzbbl, boolean z, zzeea zzeea) {
        return new zzcgt(zzcfk, zzbbl, z, zzeea);
    }
}
