package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdlq implements Callable {
    public final /* synthetic */ zzdlr zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ ListenableFuture zzd;
    public final /* synthetic */ ListenableFuture zze;
    public final /* synthetic */ ListenableFuture zzf;
    public final /* synthetic */ JSONObject zzg;
    public final /* synthetic */ ListenableFuture zzh;
    public final /* synthetic */ ListenableFuture zzi;
    public final /* synthetic */ ListenableFuture zzj;
    public final /* synthetic */ ListenableFuture zzk;
    public final /* synthetic */ ListenableFuture zzl;

    public /* synthetic */ zzdlq(zzdlr zzdlr, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3, ListenableFuture listenableFuture4, ListenableFuture listenableFuture5, JSONObject jSONObject, ListenableFuture listenableFuture6, ListenableFuture listenableFuture7, ListenableFuture listenableFuture8, ListenableFuture listenableFuture9, ListenableFuture listenableFuture10) {
        this.zza = zzdlr;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = listenableFuture3;
        this.zze = listenableFuture4;
        this.zzf = listenableFuture5;
        this.zzg = jSONObject;
        this.zzh = listenableFuture6;
        this.zzi = listenableFuture7;
        this.zzj = listenableFuture8;
        this.zzk = listenableFuture9;
        this.zzl = listenableFuture10;
    }

    public final Object call() {
        zzdiy zzdiy = (zzdiy) this.zzb.get();
        zzdiy.zzP((List) this.zzc.get());
        zzdiy.zzM((zzbfy) this.zzd.get());
        zzdiy.zzQ((zzbfy) this.zze.get());
        zzdiy.zzJ((zzbfr) this.zzf.get());
        JSONObject jSONObject = this.zzg;
        zzdiy.zzS(zzdmg.zzj(jSONObject));
        zzdiy.zzL(zzdmg.zzi(jSONObject));
        zzcfk zzcfk = (zzcfk) this.zzh.get();
        if (zzcfk != null) {
            zzdiy.zzad(zzcfk);
            zzdiy.zzac(zzcfk.zzF());
            zzdiy.zzab(zzcfk.zzq());
        }
        ListenableFuture listenableFuture = this.zzi;
        ListenableFuture listenableFuture2 = this.zzj;
        zzdiy.zzd().putAll((Bundle) listenableFuture.get());
        zzcfk zzcfk2 = (zzcfk) listenableFuture2.get();
        if (zzcfk2 != null) {
            zzdiy.zzO(zzcfk2);
            zzdiy.zzae(zzcfk2.zzF());
        }
        ListenableFuture listenableFuture3 = this.zzk;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfk)).booleanValue()) {
            zzdiy.zzU(listenableFuture3);
            zzdiy.zzX(new zzcao());
        } else {
            zzcfk zzcfk3 = (zzcfk) listenableFuture3.get();
            if (zzcfk3 != null) {
                zzdiy.zzT(zzcfk3);
            }
        }
        for (zzdmk zzdmk : (List) this.zzl.get()) {
            if (zzdmk.zza != 1) {
                zzdiy.zzN(zzdmk.zzb, zzdmk.zzd);
            } else {
                zzdiy.zzZ(zzdmk.zzb, zzdmk.zzc);
            }
        }
        return zzdiy;
    }
}
