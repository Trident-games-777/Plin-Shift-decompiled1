package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzepm implements zzgdp {
    public final ListenableFuture zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        if (appSetIdInfo == null) {
            return zzgei.zzh(new zzepp((String) null, -1));
        }
        return zzgei.zzh(new zzepp(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
