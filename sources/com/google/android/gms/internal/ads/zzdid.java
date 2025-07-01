package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzv;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdid implements zzhfx {
    private final zzhgp zza;

    public zzdid(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
    }

    public final /* synthetic */ Object zzb() {
        VersionInfoParcel zza2 = ((zzcid) this.zza).zza();
        VersionInfoParcel versionInfoParcel = zza2;
        String str = "native";
        String str2 = "native";
        zzv.zzq();
        zzayi zzayi = new zzayi(UUID.randomUUID().toString(), zza2, "native", new JSONObject(), false, true);
        zzayi zzayi2 = zzayi;
        return zzayi;
    }
}
