package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeag {
    public ListenableFuture zza;
    /* access modifiers changed from: private */
    public final zzczh zzb;
    private final zzdzo zzc;
    private final zzfjr zzd;
    private final zzffo zze;
    private final VersionInfoParcel zzf;
    private final zzfko zzg;
    private final zzfkl zzh;
    private final Context zzi;
    private final zzges zzj;

    zzeag(zzczh zzczh, zzdzo zzdzo, zzfjr zzfjr, zzffo zzffo, VersionInfoParcel versionInfoParcel, zzfko zzfko, zzfkl zzfkl, Context context, zzges zzges) {
        this.zzb = zzczh;
        this.zzc = zzdzo;
        this.zzd = zzfjr;
        this.zze = zzffo;
        this.zzf = versionInfoParcel;
        this.zzg = zzfko;
        this.zzh = zzfkl;
        this.zzi = context;
        this.zzj = zzges;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbvb zza(zzbvx zzbvx, zzebs zzebs) {
        zzebs.zzc.put("Content-Type", zzebs.zze);
        zzebs.zzc.put(HttpHeaders.USER_AGENT, zzv.zzq().zzc(this.zzi, zzbvx.zzb.afmaVersion));
        Bundle bundle = new Bundle();
        for (Map.Entry entry : zzebs.zzc.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return new zzbvb(zzebs.zza, zzebs.zzb, bundle, zzebs.zzd, zzebs.zzf, zzbvx.zzd, zzbvx.zzh);
    }

    public final ListenableFuture zzc(zzbvx zzbvx, JSONObject jSONObject, zzbvz zzbvz) {
        this.zzb.zzdn(zzbvx);
        zzfjh zzb2 = this.zzd.zzb(zzfjl.PROXY, zzgei.zzm(this.zzd.zzb(zzfjl.PREPARE_HTTP_REQUEST, zzgei.zzh(new zzebw(jSONObject, zzbvz))).zze(new zzebx(zzbvx.zzg, this.zzh, zzfjz.zza(this.zzi, 9))).zza(), new zzeac(this, zzbvx), this.zzj));
        zzdzo zzdzo = this.zzc;
        Objects.requireNonNull(zzdzo);
        zzfix zza2 = zzb2.zzf(new zzead(zzdzo)).zza();
        this.zza = zza2;
        ListenableFuture zzn = zzgei.zzn(this.zzd.zzb(zzfjl.PRE_PROCESS, zza2).zze(new zzeab(jSONObject, zzbvz)).zzf(zzv.zzg().zza(this.zzi, this.zzf, this.zzg).zza("google.afma.response.normalize", zzebf.zza, zzbof.zzb)).zza(), new zzeae(this, zzbvx), this.zzj);
        zzgei.zzr(zzn, new zzeaf(this), this.zzj);
        return zzn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzbvx zzbvx, InputStream inputStream) throws Exception {
        return zzgei.zzh(new zzfff(new zzffc(this.zze), zzffe.zza(new InputStreamReader(inputStream), zzbvx)));
    }
}
