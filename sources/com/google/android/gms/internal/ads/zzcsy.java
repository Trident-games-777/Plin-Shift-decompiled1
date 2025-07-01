package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcsy {
    private final zzdya zza;
    private final zzffo zzb;
    private final zzfjr zzc;
    private final zzclp zzd;
    private final zzejc zze;
    /* access modifiers changed from: private */
    public final zzdbt zzf;
    private zzfff zzg;
    private final zzdzj zzh;
    private final zzcvq zzi;
    private final Executor zzj;
    private final zzdyt zzk;
    private final zzefg zzl;
    private final zzdzz zzm;
    private final zzeag zzn;

    zzcsy(zzdya zzdya, zzffo zzffo, zzfjr zzfjr, zzclp zzclp, zzejc zzejc, zzdbt zzdbt, zzfff zzfff, zzdzj zzdzj, zzcvq zzcvq, Executor executor, zzdyt zzdyt, zzefg zzefg, zzdzz zzdzz, zzeag zzeag) {
        this.zza = zzdya;
        this.zzb = zzffo;
        this.zzc = zzfjr;
        this.zzd = zzclp;
        this.zze = zzejc;
        this.zzf = zzdbt;
        this.zzg = zzfff;
        this.zzh = zzdzj;
        this.zzi = zzcvq;
        this.zzj = executor;
        this.zzk = zzdyt;
        this.zzl = zzefg;
        this.zzm = zzdzz;
        this.zzn = zzeag;
    }

    public final zze zza(Throwable th) {
        return zzfgq.zzb(th, this.zzl);
    }

    public final zzdbt zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfff zzd(zzfff zzfff) throws Exception {
        this.zzd.zza(zzfff);
        return zzfff;
    }

    public final ListenableFuture zze(zzfhj zzfhj) {
        zzfix zza2 = this.zzc.zzb(zzfjl.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzcsu(this, zzfhj)).zza();
        zzgei.zzr(zza2, new zzcsw(this), this.zzj);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(zzfhj zzfhj, zzbvx zzbvx) throws Exception {
        zzbvx.zzi = zzfhj;
        return this.zzh.zza(zzbvx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzg(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3) throws Exception {
        return this.zzn.zzc((zzbvx) listenableFuture.get(), (JSONObject) listenableFuture2.get(), (zzbvz) listenableFuture3.get());
    }

    public final ListenableFuture zzh(zzbvx zzbvx) {
        zzfix zza2 = this.zzc.zzb(zzfjl.NOTIFY_CACHE_HIT, this.zzh.zzg(zzbvx)).zza();
        zzgei.zzr(zza2, new zzcsx(this), this.zzj);
        return zza2;
    }

    public final ListenableFuture zzi(ListenableFuture listenableFuture) {
        zzfjh zzf2 = this.zzc.zzb(zzfjl.RENDERER, listenableFuture).zze(new zzcsp(this)).zzf(this.zze);
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfw)).booleanValue()) {
            zzf2 = zzf2.zzi((long) ((Integer) zzbe.zzc().zza(zzbcn.zzfx)).intValue(), TimeUnit.SECONDS);
        }
        return zzf2.zza();
    }

    public final ListenableFuture zzj() {
        zzm zzm2 = this.zzb.zzd;
        if (zzm2.zzx == null && zzm2.zzs == null) {
            return zzk(this.zzi.zzc());
        }
        zzfjr zzfjr = this.zzc;
        zzdya zzdya = this.zza;
        return zzfjb.zzc(zzdya.zza(), zzfjl.PRELOADED_LOADER, zzfjr).zza();
    }

    public final ListenableFuture zzk(ListenableFuture listenableFuture) {
        if (this.zzg != null) {
            zzfjr zzfjr = this.zzc;
            return zzfjb.zzc(zzgei.zzh(this.zzg), zzfjl.SERVER_TRANSACTION, zzfjr).zza();
        }
        zzv.zzc().zzj();
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzli)).booleanValue() || ((Boolean) zzbet.zzc.zze()).booleanValue()) {
            zzfjh zzb2 = this.zzc.zzb(zzfjl.SERVER_TRANSACTION, listenableFuture);
            zzdyt zzdyt = this.zzk;
            Objects.requireNonNull(zzdyt);
            return zzb2.zzf(new zzcsv(zzdyt)).zza();
        }
        zzdzz zzdzz = this.zzm;
        Objects.requireNonNull(zzdzz);
        ListenableFuture zzn2 = zzgei.zzn(listenableFuture, new zzcsq(zzdzz), this.zzj);
        zzfjh zzb3 = this.zzc.zzb(zzfjl.BUILD_URL, zzn2);
        zzdzj zzdzj = this.zzh;
        Objects.requireNonNull(zzdzj);
        zzfix zza2 = zzb3.zzf(new zzcsr(zzdzj)).zza();
        return this.zzc.zza(zzfjl.SERVER_TRANSACTION, listenableFuture, zzn2, zza2).zza(new zzcss(this, listenableFuture, zzn2, zza2)).zzf(new zzcst()).zza();
    }

    public final void zzl(zzfff zzfff) {
        this.zzg = zzfff;
    }
}
