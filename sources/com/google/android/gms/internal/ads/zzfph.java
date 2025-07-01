package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfph extends zzfpc {
    public zzfph(zzfov zzfov, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfov, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzfon.zzg(this.zzb, this.zzd.zza())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        zzfnr zza;
        if (!TextUtils.isEmpty(str) && (zza = zzfnr.zza()) != null) {
            for (zzfna zzfna : zza.zzc()) {
                if (this.zza.contains(zzfna.zzh())) {
                    zzfna.zzg().zzh(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
