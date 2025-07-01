package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdzj {
    private final zzges zza;
    private final zzdyn zzb;
    private final zzhfr zzc;
    private final zzfko zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;

    public zzdzj(zzges zzges, zzdyn zzdyn, zzhfr zzhfr, zzfko zzfko, Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = zzges;
        this.zzb = zzdyn;
        this.zzc = zzhfr;
        this.zzd = zzfko;
        this.zze = context;
        this.zzf = versionInfoParcel;
    }

    private final ListenableFuture zzh(zzbvx zzbvx, zzdzi zzdzi, zzdzi zzdzi2, zzgdp zzgdp) {
        ListenableFuture listenableFuture;
        String str = zzbvx.zzd;
        zzv.zzq();
        if (zzs.zzC(str)) {
            listenableFuture = zzgei.zzg(new zzdyw(1));
        } else {
            listenableFuture = zzgei.zzf(zzdzi.zza(zzbvx), ExecutionException.class, new zzdzh(), this.zza);
        }
        return (zzgdz) zzgei.zzf((zzgdz) zzgei.zzn((zzgdz) zzgei.zzn(zzgdz.zzu(listenableFuture), new zzdzf(), this.zza), zzgdp, this.zza), zzdyw.class, new zzdzg(this, zzdzi2, zzbvx, zzgdp), this.zza);
    }

    public final ListenableFuture zza(zzbvx zzbvx) {
        zzdzc zzdzc = new zzdzc(zzbvx);
        zzdyn zzdyn = this.zzb;
        Objects.requireNonNull(zzdyn);
        return zzh(zzbvx, new zzdzd(zzdyn), new zzdze(this), zzdzc);
    }

    public final ListenableFuture zzb(JSONObject jSONObject) {
        return (zzgdz) zzgei.zzn(zzgdz.zzu(zzgei.zzh(jSONObject)), zzv.zzg().zza(this.zze, this.zzf, this.zzd).zza("AFMA_getAdDictionary", zzbof.zza, new zzdyy()), this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzdzi zzdzi, zzbvx zzbvx, zzgdp zzgdp, zzdyw zzdyw) throws Exception {
        return zzgei.zzn(zzdzi.zza(zzbvx), zzgdp, this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzbvx zzbvx) {
        return ((zzebg) this.zzc.zzb()).zzb(zzbvx, Binder.getCallingUid());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(zzbvx zzbvx) {
        return this.zzb.zzd(zzbvx.zzh);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(zzbvx zzbvx) {
        return ((zzebg) this.zzc.zzb()).zzj(zzbvx.zzh);
    }

    public final ListenableFuture zzg(zzbvx zzbvx) {
        return zzh(zzbvx, new zzdza(this), new zzdzb(this), new zzdyz());
    }
}
