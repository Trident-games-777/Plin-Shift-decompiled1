package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcoi implements zzaym {
    private zzcfk zza;
    private final Executor zzb;
    private final zzcnu zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcnx zzg = new zzcnx();

    public zzcoi(Executor executor, zzcnu zzcnu, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcnu;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            JSONObject zza2 = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new zzcoh(this, zza2));
            }
        } catch (JSONException e) {
            zze.zzb("Failed to call video active view js", e);
        }
    }

    public final void zza() {
        this.zze = false;
    }

    public final void zzb() {
        this.zze = true;
        zzg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(JSONObject jSONObject) {
        this.zza.zzl("AFMA_updateActiveView", jSONObject);
    }

    public final void zzdp(zzayl zzayl) {
        boolean z;
        if (this.zzf) {
            z = false;
        } else {
            z = zzayl.zzj;
        }
        zzcnx zzcnx = this.zzg;
        zzcnx.zza = z;
        zzcnx.zzd = this.zzd.elapsedRealtime();
        this.zzg.zzf = zzayl;
        if (this.zze) {
            zzg();
        }
    }

    public final void zze(boolean z) {
        this.zzf = z;
    }

    public final void zzf(zzcfk zzcfk) {
        this.zza = zzcfk;
    }
}
