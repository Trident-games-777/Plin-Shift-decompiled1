package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzewb implements Callable {
    public final /* synthetic */ List zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ Bundle zzd;

    public /* synthetic */ zzewb(List list, Object obj, Bundle bundle, Bundle bundle2) {
        this.zza = list;
        this.zzb = obj;
        this.zzc = bundle;
        this.zzd = bundle2;
    }

    public final Object call() {
        Object obj;
        Bundle bundle;
        Iterator it = this.zza.iterator();
        while (true) {
            obj = this.zzb;
            if (!it.hasNext()) {
                break;
            }
            zzevy zzevy = (zzevy) ((ListenableFuture) it.next()).get();
            if (zzevy != null) {
                zzevy.zzj(obj);
            }
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue() && (bundle = this.zzc) != null) {
            Bundle bundle2 = this.zzd;
            long currentTimeMillis = zzv.zzC().currentTimeMillis();
            if (obj instanceof Bundle) {
                bundle.putLong(zzdrv.CLIENT_SIGNALS_END.zza(), currentTimeMillis);
                bundle.putBundle("client_sig_latency_key", bundle2);
                return obj;
            }
            bundle.putLong(zzdrv.GMS_SIGNALS_END.zza(), currentTimeMillis);
            bundle.putBundle("gms_sig_latency_key", bundle2);
        }
        return obj;
    }
}
