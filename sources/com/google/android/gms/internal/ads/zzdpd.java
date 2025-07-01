package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdpd implements zzcha {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzcao zzb;

    public /* synthetic */ zzdpd(Bundle bundle, zzcao zzcao) {
        this.zza = bundle;
        this.zzb = zzcao;
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzcao zzcao = this.zzb;
        if (z) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzck)).booleanValue()) {
                this.zza.putLong(zzdrv.RENDERING_WEBVIEW_LOAD_HTML_END.zza(), zzv.zzC().currentTimeMillis());
            }
            zzcao.zzc((Object) null);
            return;
        }
        zzcao.zzd(new Exception("Ad Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
