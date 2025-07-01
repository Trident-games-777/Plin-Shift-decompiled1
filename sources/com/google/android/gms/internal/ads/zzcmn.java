package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcmn implements zzclr {
    private final CookieManager zza;

    public zzcmn(Context context) {
        this.zza = zzv.zzr().zza(context);
    }

    public final void zza(Map map) {
        if (this.zza != null) {
            if (((String) map.get("clear")) != null) {
                String str = (String) zzbe.zzc().zza(zzbcn.zzaV);
                String cookie = this.zza.getCookie(str);
                if (cookie != null) {
                    List zze = zzfxd.zzb(zzfwf.zzc(';')).zze(cookie);
                    int i = 0;
                    while (i < zze.size()) {
                        CookieManager cookieManager = this.zza;
                        Iterator it = zzfxd.zzb(zzfwf.zzc('=')).zzc((String) zze.get(i)).iterator();
                        it.getClass();
                        if (it.hasNext()) {
                            cookieManager.setCookie(str, String.valueOf((String) it.next()).concat(String.valueOf((String) zzbe.zzc().zza(zzbcn.zzaH))));
                            i++;
                        } else {
                            throw new IndexOutOfBoundsException("position (0) must be less than the number of elements that remained (" + 0 + ")");
                        }
                    }
                    return;
                }
                return;
            }
            String str2 = (String) map.get("cookie");
            if (!TextUtils.isEmpty(str2)) {
                this.zza.setCookie((String) zzbe.zzc().zza(zzbcn.zzaV), str2);
            }
        }
    }
}
