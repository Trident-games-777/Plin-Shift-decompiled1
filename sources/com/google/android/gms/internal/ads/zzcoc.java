package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzv;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcoc implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzcoc(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        VersionInfoParcel zza2 = ((zzcid) this.zza).zza();
        VersionInfoParcel versionInfoParcel = zza2;
        String str = (String) this.zzc.zzb();
        boolean equals = "native".equals(str);
        zzv.zzq();
        zzayi zzayi = new zzayi(UUID.randomUUID().toString(), zza2, str, (JSONObject) this.zzb.zzb(), false, equals);
        zzayi zzayi2 = zzayi;
        return zzayi;
    }
}
