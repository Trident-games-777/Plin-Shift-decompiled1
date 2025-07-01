package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbou implements zzgdp {
    private final String zza = "google.afma.activeView.handleUpdate";
    private final ListenableFuture zzb;

    zzbou(ListenableFuture listenableFuture, String str, zzbob zzbob, zzboa zzboa) {
        this.zzb = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final ListenableFuture zzb(Object obj) {
        return zzgei.zzn(this.zzb, new zzbos(this, obj), zzcaj.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Object obj, zzbnv zzbnv) throws Exception {
        zzcao zzcao = new zzcao();
        zzv.zzq();
        String uuid = UUID.randomUUID().toString();
        zzbjq.zzo.zzc(uuid, new zzbot(this, zzcao));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", uuid);
        jSONObject.put("args", (JSONObject) obj);
        zzbnv.zzl(this.zza, jSONObject);
        return zzcao;
    }
}
