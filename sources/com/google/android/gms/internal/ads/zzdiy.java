package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzez;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdiy {
    private int zza;
    private zzeb zzb;
    private zzbfr zzc;
    private View zzd;
    private List zze;
    private List zzf = Collections.emptyList();
    private zzez zzg;
    private Bundle zzh;
    private zzcfk zzi;
    private zzcfk zzj;
    private zzcfk zzk;
    private zzeew zzl;
    private ListenableFuture zzm;
    private zzcao zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbfy zzs;
    private zzbfy zzt;
    private String zzu;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private float zzx;
    private String zzy;

    public static zzdiy zzag(zzbpr zzbpr) {
        zzdiy zzdiy;
        try {
            zzdix zzak = zzak(zzbpr.zzg(), (zzbpv) null);
            zzbfr zzh2 = zzbpr.zzh();
            View view = (View) zzam(zzbpr.zzj());
            String zzo2 = zzbpr.zzo();
            List zzr2 = zzbpr.zzr();
            String zzm2 = zzbpr.zzm();
            Bundle zzf2 = zzbpr.zzf();
            String zzn2 = zzbpr.zzn();
            View view2 = (View) zzam(zzbpr.zzk());
            IObjectWrapper zzl2 = zzbpr.zzl();
            String zzq2 = zzbpr.zzq();
            String zzp2 = zzbpr.zzp();
            double zze2 = zzbpr.zze();
            zzbfy zzi2 = zzbpr.zzi();
            zzdiy = null;
            try {
                zzdiy zzdiy2 = new zzdiy();
                zzdiy2.zza = 2;
                zzdiy2.zzb = zzak;
                zzdiy2.zzc = zzh2;
                zzdiy2.zzd = view;
                zzdiy2.zzZ("headline", zzo2);
                zzdiy2.zze = zzr2;
                zzdiy2.zzZ("body", zzm2);
                zzdiy2.zzh = zzf2;
                zzdiy2.zzZ("call_to_action", zzn2);
                zzdiy2.zzo = view2;
                zzdiy2.zzq = zzl2;
                zzdiy2.zzZ("store", zzq2);
                zzdiy2.zzZ(FirebaseAnalytics.Param.PRICE, zzp2);
                zzdiy2.zzr = zze2;
                zzdiy2.zzs = zzi2;
                return zzdiy2;
            } catch (RemoteException e) {
                e = e;
                zzm.zzk("Failed to get native ad from app install ad mapper", e);
                return zzdiy;
            }
        } catch (RemoteException e2) {
            e = e2;
            zzdiy = null;
            zzm.zzk("Failed to get native ad from app install ad mapper", e);
            return zzdiy;
        }
    }

    public static zzdiy zzah(zzbps zzbps) {
        try {
            zzdix zzak = zzak(zzbps.zzf(), (zzbpv) null);
            zzbfr zzg2 = zzbps.zzg();
            String zzo2 = zzbps.zzo();
            List zzp2 = zzbps.zzp();
            String zzm2 = zzbps.zzm();
            Bundle zze2 = zzbps.zze();
            String zzn2 = zzbps.zzn();
            IObjectWrapper zzk2 = zzbps.zzk();
            String zzl2 = zzbps.zzl();
            zzbfy zzh2 = zzbps.zzh();
            zzdiy zzdiy = new zzdiy();
            zzdiy.zza = 1;
            zzdiy.zzb = zzak;
            zzdiy.zzc = zzg2;
            zzdiy.zzd = (View) zzam(zzbps.zzi());
            zzdiy.zzZ("headline", zzo2);
            zzdiy.zze = zzp2;
            zzdiy.zzZ("body", zzm2);
            zzdiy.zzh = zze2;
            zzdiy.zzZ("call_to_action", zzn2);
            zzdiy.zzo = (View) zzam(zzbps.zzj());
            zzdiy.zzq = zzk2;
            zzdiy.zzZ("advertiser", zzl2);
            zzdiy.zzt = zzh2;
            return zzdiy;
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdiy zzai(zzbpr zzbpr) {
        try {
            return zzal(zzak(zzbpr.zzg(), (zzbpv) null), zzbpr.zzh(), (View) zzam(zzbpr.zzj()), zzbpr.zzo(), zzbpr.zzr(), zzbpr.zzm(), zzbpr.zzf(), zzbpr.zzn(), (View) zzam(zzbpr.zzk()), zzbpr.zzl(), zzbpr.zzq(), zzbpr.zzp(), zzbpr.zze(), zzbpr.zzi(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdiy zzaj(zzbps zzbps) {
        try {
            return zzal(zzak(zzbps.zzf(), (zzbpv) null), zzbps.zzg(), (View) zzam(zzbps.zzi()), zzbps.zzo(), zzbps.zzp(), zzbps.zzm(), zzbps.zze(), zzbps.zzn(), (View) zzam(zzbps.zzj()), zzbps.zzk(), (String) null, (String) null, -1.0d, zzbps.zzh(), zzbps.zzl(), 0.0f);
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdix zzak(zzeb zzeb, zzbpv zzbpv) {
        if (zzeb == null) {
            return null;
        }
        return new zzdix(zzeb, zzbpv);
    }

    private static zzdiy zzal(zzeb zzeb, zzbfr zzbfr, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbfy zzbfy, String str6, float f) {
        zzdiy zzdiy = new zzdiy();
        zzdiy.zza = 6;
        zzdiy.zzb = zzeb;
        zzdiy.zzc = zzbfr;
        zzdiy.zzd = view;
        zzdiy.zzZ("headline", str);
        zzdiy.zze = list;
        zzdiy.zzZ("body", str2);
        zzdiy.zzh = bundle;
        zzdiy.zzZ("call_to_action", str3);
        zzdiy.zzo = view2;
        zzdiy.zzq = iObjectWrapper;
        zzdiy.zzZ("store", str4);
        zzdiy.zzZ(FirebaseAnalytics.Param.PRICE, str5);
        zzdiy.zzr = d;
        zzdiy.zzs = zzbfy;
        zzdiy.zzZ("advertiser", str6);
        zzdiy.zzR(f);
        return zzdiy;
    }

    private static Object zzam(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzdiy zzt(zzbpv zzbpv) {
        try {
            zzbpv zzbpv2 = zzbpv;
            return zzal(zzak(zzbpv.zzj(), zzbpv2), zzbpv2.zzk(), (View) zzam(zzbpv2.zzm()), zzbpv2.zzs(), zzbpv2.zzv(), zzbpv2.zzq(), zzbpv2.zzi(), zzbpv2.zzr(), (View) zzam(zzbpv2.zzn()), zzbpv2.zzo(), zzbpv2.zzu(), zzbpv2.zzt(), zzbpv2.zze(), zzbpv2.zzl(), zzbpv2.zzp(), zzbpv2.zzf());
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public final synchronized String zzA() {
        return this.zzu;
    }

    public final synchronized String zzB() {
        return zzF("headline");
    }

    public final synchronized String zzC() {
        return this.zzy;
    }

    public final synchronized String zzD() {
        return zzF(FirebaseAnalytics.Param.PRICE);
    }

    public final synchronized String zzE() {
        return zzF("store");
    }

    public final synchronized String zzF(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized List zzG() {
        return this.zze;
    }

    public final synchronized List zzH() {
        return this.zzf;
    }

    public final synchronized void zzI() {
        zzcfk zzcfk = this.zzi;
        if (zzcfk != null) {
            zzcfk.destroy();
            this.zzi = null;
        }
        zzcfk zzcfk2 = this.zzj;
        if (zzcfk2 != null) {
            zzcfk2.destroy();
            this.zzj = null;
        }
        zzcfk zzcfk3 = this.zzk;
        if (zzcfk3 != null) {
            zzcfk3.destroy();
            this.zzk = null;
        }
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.zzm = null;
        }
        zzcao zzcao = this.zzn;
        if (zzcao != null) {
            zzcao.cancel(false);
            this.zzn = null;
        }
        this.zzl = null;
        this.zzv.clear();
        this.zzw.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
    }

    public final synchronized void zzJ(zzbfr zzbfr) {
        this.zzc = zzbfr;
    }

    public final synchronized void zzK(String str) {
        this.zzu = str;
    }

    public final synchronized void zzL(zzez zzez) {
        this.zzg = zzez;
    }

    public final synchronized void zzM(zzbfy zzbfy) {
        this.zzs = zzbfy;
    }

    public final synchronized void zzN(String str, zzbfl zzbfl) {
        if (zzbfl == null) {
            this.zzv.remove(str);
        } else {
            this.zzv.put(str, zzbfl);
        }
    }

    public final synchronized void zzO(zzcfk zzcfk) {
        this.zzj = zzcfk;
    }

    public final synchronized void zzP(List list) {
        this.zze = list;
    }

    public final synchronized void zzQ(zzbfy zzbfy) {
        this.zzt = zzbfy;
    }

    public final synchronized void zzR(float f) {
        this.zzx = f;
    }

    public final synchronized void zzS(List list) {
        this.zzf = list;
    }

    public final synchronized void zzT(zzcfk zzcfk) {
        this.zzk = zzcfk;
    }

    public final synchronized void zzU(ListenableFuture listenableFuture) {
        this.zzm = listenableFuture;
    }

    public final synchronized void zzV(String str) {
        this.zzy = str;
    }

    public final synchronized void zzW(zzeew zzeew) {
        this.zzl = zzeew;
    }

    public final synchronized void zzX(zzcao zzcao) {
        this.zzn = zzcao;
    }

    public final synchronized void zzY(double d) {
        this.zzr = d;
    }

    public final synchronized void zzZ(String str, String str2) {
        if (str2 == null) {
            this.zzw.remove(str);
        } else {
            this.zzw.put(str, str2);
        }
    }

    public final synchronized double zza() {
        return this.zzr;
    }

    public final synchronized void zzaa(int i) {
        this.zza = i;
    }

    public final synchronized void zzab(zzeb zzeb) {
        this.zzb = zzeb;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized void zzad(zzcfk zzcfk) {
        this.zzi = zzcfk;
    }

    public final synchronized void zzae(View view) {
        this.zzp = view;
    }

    public final synchronized boolean zzaf() {
        return this.zzj != null;
    }

    public final synchronized float zzb() {
        return this.zzx;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzo;
    }

    public final synchronized View zzg() {
        return this.zzp;
    }

    public final synchronized SimpleArrayMap zzh() {
        return this.zzv;
    }

    public final synchronized SimpleArrayMap zzi() {
        return this.zzw;
    }

    public final synchronized zzeb zzj() {
        return this.zzb;
    }

    public final synchronized zzez zzk() {
        return this.zzg;
    }

    public final synchronized zzbfr zzl() {
        return this.zzc;
    }

    public final zzbfy zzm() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbfx.zzg((IBinder) obj);
        }
        return null;
    }

    public final synchronized zzbfy zzn() {
        return this.zzs;
    }

    public final synchronized zzbfy zzo() {
        return this.zzt;
    }

    public final synchronized zzcao zzp() {
        return this.zzn;
    }

    public final synchronized zzcfk zzq() {
        return this.zzj;
    }

    public final synchronized zzcfk zzr() {
        return this.zzk;
    }

    public final synchronized zzcfk zzs() {
        return this.zzi;
    }

    public final synchronized zzeew zzu() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzv() {
        return this.zzq;
    }

    public final synchronized ListenableFuture zzw() {
        return this.zzm;
    }

    public final synchronized String zzx() {
        return zzF("advertiser");
    }

    public final synchronized String zzy() {
        return zzF("body");
    }

    public final synchronized String zzz() {
        return zzF("call_to_action");
    }
}
