package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzbce {
    private final int zza;
    private final String zzb;
    private final Object zzc;
    private final Object zzd;

    /* synthetic */ zzbce(int i, String str, Object obj, Object obj2, zzbcd zzbcd) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        zzbe.zza().zzd(this);
    }

    public static zzbce zzf(int i, String str, float f, float f2) {
        return new zzbcb(1, str, Float.valueOf(f), Float.valueOf(f2));
    }

    public static zzbce zzg(int i, String str, int i2, int i3) {
        return new zzbbz(1, str, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static zzbce zzh(int i, String str, long j, long j2) {
        return new zzbca(1, str, Long.valueOf(j), Long.valueOf(j2));
    }

    public static zzbce zzi(int i, String str) {
        String str2 = null;
        zzbcc zzbcc = new zzbcc(1, "gads:sdk_core_constants:experiment_id", (String) null, (String) null);
        zzbe.zza().zzc(zzbcc);
        return zzbcc;
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(JSONObject jSONObject);

    public abstract Object zzb(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract Object zzc(SharedPreferences sharedPreferences);

    public abstract void zzd(SharedPreferences.Editor editor, Object obj);

    public final int zze() {
        return this.zza;
    }

    public final Object zzj() {
        return zzbe.zzc().zza(this);
    }

    public final Object zzk() {
        return zzbe.zzc().zzf() ? this.zzd : this.zzc;
    }

    public final String zzl() {
        return this.zzb;
    }
}
