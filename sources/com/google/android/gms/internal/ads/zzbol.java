package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbol implements zzbkg {
    final /* synthetic */ zzbom zza;
    private final zzbno zzb;
    private final zzcao zzc;

    public zzbol(zzbom zzbom, zzbno zzbno, zzcao zzcao) {
        this.zza = zzbom;
        this.zzb = zzbno;
        this.zzc = zzcao;
    }

    public final void zza(String str) {
        if (str == null) {
            try {
                this.zzc.zzd(new zzbnx());
            } catch (IllegalStateException unused) {
            } catch (Throwable th) {
                this.zzb.zzb();
                throw th;
            }
        } else {
            this.zzc.zzd(new zzbnx(str));
        }
        this.zzb.zzb();
    }

    public final void zzb(JSONObject jSONObject) {
        try {
            this.zzc.zzc(this.zza.zza.zza(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzc.zzd(e);
        } catch (Throwable th) {
            this.zzb.zzb();
            throw th;
        }
        this.zzb.zzb();
    }
}
