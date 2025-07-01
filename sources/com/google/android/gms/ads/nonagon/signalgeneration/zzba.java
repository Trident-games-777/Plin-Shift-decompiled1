package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.internal.ads.zzbvx;
import com.google.android.gms.internal.ads.zzdyx;
import com.google.android.gms.internal.ads.zzgdp;
import com.google.android.gms.internal.ads.zzgei;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzba implements zzgdp {
    public final /* synthetic */ zzbvx zza;

    public /* synthetic */ zzba(zzbvx zzbvx) {
        this.zza = zzbvx;
    }

    public final ListenableFuture zza(Object obj) {
        zzdyx zzdyx = (zzdyx) obj;
        zzbd zzbd = new zzbd(new JsonReader(new InputStreamReader(zzdyx.zzb())), zzdyx.zza());
        try {
            zzbd.zzb = zzbc.zzb().zzi(this.zza.zza).toString();
        } catch (JSONException unused) {
            zzbd.zzb = "{}";
        }
        return zzgei.zzh(zzbd);
    }
}
