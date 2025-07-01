package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbom implements zzbny {
    /* access modifiers changed from: private */
    public final zzboa zza;
    private final zzbob zzb;
    private final zzbnu zzc;
    private final String zzd;

    zzbom(zzbnu zzbnu, String str, zzbob zzbob, zzboa zzboa) {
        this.zzc = zzbnu;
        this.zzd = str;
        this.zzb = zzbob;
        this.zza = zzboa;
    }

    static /* bridge */ /* synthetic */ void zzd(zzbom zzbom, zzbno zzbno, zzbnv zzbnv, Object obj, zzcao zzcao) {
        try {
            zzv.zzq();
            String uuid = UUID.randomUUID().toString();
            zzbjq.zzo.zzc(uuid, new zzbol(zzbom, zzbno, zzcao));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", uuid);
            jSONObject.put("args", zzbom.zzb.zzb(obj));
            zzbnv.zzl(zzbom.zzd, jSONObject);
        } catch (Exception e) {
            zzcao.zzd(e);
            zzm.zzh("Unable to invokeJavascript", e);
            zzbno.zzb();
        } catch (Throwable th) {
            zzbno.zzb();
            throw th;
        }
    }

    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final ListenableFuture zzb(Object obj) {
        zzcao zzcao = new zzcao();
        zzbno zzb2 = this.zzc.zzb((zzavc) null);
        zze.zza("callJs > getEngine: Promise created");
        zzb2.zzj(new zzboj(this, zzb2, obj, zzcao), new zzbok(this, zzcao, zzb2));
        return zzcao;
    }
}
