package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzebm implements zzgdp {
    public final /* synthetic */ zzext zza;

    public /* synthetic */ zzebm(zzext zzext) {
        this.zza = zzext;
    }

    public final ListenableFuture zza(Object obj) {
        Void voidR = (Void) obj;
        return this.zza.zza().zza(new JSONObject(), new Bundle());
    }
}
