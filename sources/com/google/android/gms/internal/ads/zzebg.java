package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzebg extends zzbve {
    private final Context zza;
    private final zzges zzb;
    private final zzeby zzc;
    private final zzclo zzd;
    private final ArrayDeque zze;
    private final zzfko zzf;
    private final zzbwf zzg;

    public zzebg(Context context, zzges zzges, zzbwf zzbwf, zzclo zzclo, zzeby zzeby, ArrayDeque arrayDeque, zzebv zzebv, zzfko zzfko) {
        zzbcn.zza(context);
        this.zza = context;
        this.zzb = zzges;
        this.zzg = zzbwf;
        this.zzc = zzeby;
        this.zzd = zzclo;
        this.zze = arrayDeque;
        this.zzf = zzfko;
    }

    private final synchronized zzebd zzl(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzebd zzebd = (zzebd) it.next();
            if (zzebd.zzc.equals(str)) {
                it.remove();
                return zzebd;
            }
        }
        return null;
    }

    private static ListenableFuture zzm(ListenableFuture listenableFuture, zzfjr zzfjr, zzboi zzboi, zzfkl zzfkl, zzfka zzfka) {
        zzbny zza2 = zzboi.zza("AFMA_getAdDictionary", zzbof.zza, new zzeax());
        zzfkk.zzd(listenableFuture, zzfka);
        zzfix zza3 = zzfjr.zzb(zzfjl.BUILD_URL, listenableFuture).zzf(zza2).zza();
        zzfkk.zzc(zza3, zzfkl, zzfka);
        return zza3;
    }

    private static ListenableFuture zzn(zzbvx zzbvx, zzfjr zzfjr, zzexc zzexc) {
        zzear zzear = new zzear(zzexc, zzbvx);
        return zzfjr.zzb(zzfjl.GMS_SIGNALS, zzgei.zzh(zzbvx.zza)).zzf(zzear).zze(new zzeas()).zza();
    }

    private final synchronized void zzo(zzebd zzebd) {
        zzp();
        this.zze.addLast(zzebd);
    }

    private final synchronized void zzp() {
        int intValue = ((Long) zzbeu.zzc.zze()).intValue();
        while (this.zze.size() >= intValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzq(ListenableFuture listenableFuture, zzbvp zzbvp, zzbvx zzbvx) {
        zzgei.zzr(zzgei.zzn(listenableFuture, new zzeay(this), zzcaj.zza), new zzebc(this, zzbvx, zzbvp), zzcaj.zzf);
    }

    public final ListenableFuture zzb(zzbvx zzbvx, int i) {
        if (!((Boolean) zzbeu.zza.zze()).booleanValue()) {
            return zzgei.zzg(new Exception("Split request is disabled."));
        }
        zzfhj zzfhj = zzbvx.zzi;
        if (zzfhj == null) {
            return zzgei.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfhj.zzc == 0 || zzfhj.zzd == 0) {
            return zzgei.zzg(new Exception("Caching is disabled."));
        }
        zzboi zzb2 = zzv.zzg().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        zzexc zzr = this.zzd.zzr(zzbvx, i);
        zzfjr zzc2 = zzr.zzc();
        ListenableFuture zzn = zzn(zzbvx, zzc2, zzr);
        zzfkl zzd2 = zzr.zzd();
        zzfka zza2 = zzfjz.zza(this.zza, 9);
        ListenableFuture zzm = zzm(zzn, zzc2, zzb2, zzd2, zza2);
        return zzc2.zza(zzfjl.GET_URL_AND_CACHE_KEY, zzn, zzm).zza(new zzeav(this, zzm, zzn, zzbvx, zza2)).zza();
    }

    public final ListenableFuture zzc(zzbvx zzbvx, int i) {
        zzebd zzebd;
        zzfka zzfka;
        zzfix zzfix;
        zzboi zzb2 = zzv.zzg().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        zzexc zzr = this.zzd.zzr(zzbvx, i);
        zzbny zza2 = zzb2.zza("google.afma.response.normalize", zzebf.zza, zzbof.zzb);
        if (!((Boolean) zzbeu.zza.zze()).booleanValue()) {
            String str = zzbvx.zzj;
            zzebd = null;
            if (str != null && !str.isEmpty()) {
                zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            zzebd = zzl(zzbvx.zzh);
            if (zzebd == null) {
                zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        }
        if (zzebd == null) {
            zzfka = zzfjz.zza(this.zza, 9);
        } else {
            zzfka = zzebd.zzd;
        }
        zzfkl zzd2 = zzr.zzd();
        zzd2.zzd(zzbvx.zza.getStringArrayList("ad_types"));
        zzebx zzebx = new zzebx(zzbvx.zzg, zzd2, zzfka);
        zzebu zzebu = new zzebu(this.zza, zzbvx.zzb.afmaVersion, this.zzg, i);
        zzfjr zzc2 = zzr.zzc();
        zzfka zza3 = zzfjz.zza(this.zza, 11);
        if (zzebd == null) {
            ListenableFuture zzn = zzn(zzbvx, zzc2, zzr);
            ListenableFuture zzm = zzm(zzn, zzc2, zzb2, zzd2, zzfka);
            zzfka zza4 = zzfjz.zza(this.zza, 10);
            zzfix zza5 = zzc2.zza(zzfjl.HTTP, zzm, zzn).zza(new zzeat(zzm, zzbvx, zzn)).zze(zzebx).zze(new zzfkg(zza4)).zze(zzebu).zza();
            zzfkk.zza(zza5, zzd2, zza4);
            zzfkk.zzd(zza5, zza3);
            zzfix = zzc2.zza(zzfjl.PRE_PROCESS, zzn, zzm, zza5).zza(new zzeau(zzbvx, zza5, zzn, zzm)).zzf(zza2).zza();
        } else {
            zzebw zzebw = new zzebw(zzebd.zzb, zzebd.zza);
            zzfka zza6 = zzfjz.zza(this.zza, 10);
            zzfix zza7 = zzc2.zzb(zzfjl.HTTP, zzgei.zzh(zzebw)).zze(zzebx).zze(new zzfkg(zza6)).zze(zzebu).zza();
            zzfkk.zza(zza7, zzd2, zza6);
            ListenableFuture zzh = zzgei.zzh(zzebd);
            zzfkk.zzd(zza7, zza3);
            zzfix = zzc2.zza(zzfjl.PRE_PROCESS, zza7, zzh).zza(new zzeaq(zza7, zzh)).zzf(zza2).zza();
        }
        zzfkk.zza(zzfix, zzd2, zza3);
        return zzfix;
    }

    public final ListenableFuture zzd(zzbvx zzbvx, int i) {
        zzboi zzb2 = zzv.zzg().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        if (!((Boolean) zzbez.zza.zze()).booleanValue()) {
            return zzgei.zzg(new Exception("Signal collection disabled."));
        }
        zzexc zzr = this.zzd.zzr(zzbvx, i);
        zzewc zza2 = zzr.zza();
        zzbny zza3 = zzb2.zza("google.afma.request.getSignals", zzbof.zza, zzbof.zzb);
        zzfka zza4 = zzfjz.zza(this.zza, 22);
        zzfix zza5 = zzr.zzc().zzb(zzfjl.GET_SIGNALS, zzgei.zzh(zzbvx.zza)).zze(new zzfkg(zza4)).zzf(new zzeaz(zza2, zzbvx)).zzb(zzfjl.JS_SIGNALS).zzf(zza3).zza();
        zzfkl zzd2 = zzr.zzd();
        zzd2.zzd(zzbvx.zza.getStringArrayList("ad_types"));
        zzd2.zzf(zzbvx.zza.getBundle("extras"));
        zzfkk.zzb(zza5, zzd2, zza4);
        if (((Boolean) zzben.zzg.zze()).booleanValue()) {
            zzeby zzeby = this.zzc;
            Objects.requireNonNull(zzeby);
            zza5.addListener(new zzeaw(zzeby), this.zzb);
        }
        return zza5;
    }

    public final void zze(zzbvx zzbvx, zzbvp zzbvp) {
        zzq(zzb(zzbvx, Binder.getCallingUid()), zzbvp, zzbvx);
    }

    public final void zzf(zzbvx zzbvx, zzbvp zzbvp) {
        Bundle bundle;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue() && (bundle = zzbvx.zzm) != null) {
            bundle.putLong(zzdrv.SERVICE_CONNECTED.zza(), zzv.zzC().currentTimeMillis());
        }
        zzq(zzd(zzbvx, Binder.getCallingUid()), zzbvp, zzbvx);
    }

    public final void zzg(zzbvx zzbvx, zzbvp zzbvp) {
        Bundle bundle;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue() && (bundle = zzbvx.zzm) != null) {
            bundle.putLong(zzdrv.SERVICE_CONNECTED.zza(), zzv.zzC().currentTimeMillis());
        }
        ListenableFuture zzc2 = zzc(zzbvx, Binder.getCallingUid());
        zzq(zzc2, zzbvp, zzbvx);
        if (((Boolean) zzben.zze.zze()).booleanValue()) {
            zzeby zzeby = this.zzc;
            Objects.requireNonNull(zzeby);
            zzc2.addListener(new zzeaw(zzeby), this.zzb);
        }
    }

    public final void zzh(String str, zzbvp zzbvp) {
        zzq(zzj(str), zzbvp, (zzbvx) null);
    }

    public final void zzi(zzbuz zzbuz, zzbvq zzbvq) {
        if (!((Boolean) zzbfb.zza.zze()).booleanValue()) {
            try {
                zzbvq.zzf("", zzbuz);
            } catch (RemoteException e) {
                zze.zzb("Service can't call client", e);
            }
        } else {
            this.zzd.zzF();
            String str = zzbuz.zza;
            zzgei.zzr(zzgei.zzh((Object) null), new zzeba(this, zzbvq, zzbuz), zzcaj.zzf);
        }
    }

    public final ListenableFuture zzj(String str) {
        if (!((Boolean) zzbeu.zza.zze()).booleanValue()) {
            return zzgei.zzg(new Exception("Split request is disabled."));
        }
        zzebb zzebb = new zzebb(this);
        if (zzl(str) == null) {
            return zzgei.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str))));
        }
        return zzgei.zzh(zzebb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzk(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbvx zzbvx, zzfka zzfka) throws Exception {
        String zze2 = ((zzbvz) listenableFuture.get()).zze();
        String str = zzbvx.zzh;
        zzo(new zzebd((zzbvz) listenableFuture.get(), (JSONObject) listenableFuture2.get(), str, zze2, zzfka));
        return new ByteArrayInputStream(zze2.getBytes(StandardCharsets.UTF_8));
    }
}
