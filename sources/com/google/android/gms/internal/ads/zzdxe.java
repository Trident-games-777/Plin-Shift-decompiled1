package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdxe implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzdxe(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* synthetic */ Object zzb() {
        CookieManager zza2 = zzv.zzr().zza((Context) this.zzb.zzb());
        zzfjl zzfjl = zzfjl.WEBVIEW_COOKIE;
        return zzfjb.zza(new zzdwz(zza2), zzfjl, (zzfjr) this.zza.zzb()).zzi(1, TimeUnit.SECONDS).zzc(Exception.class, new zzfjc(new zzdxa())).zza();
    }
}
