package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbqh extends zzbpi {
    /* access modifiers changed from: private */
    public final Object zza;
    private zzbqj zzb;
    private zzbwu zzc;
    private IObjectWrapper zzd;
    /* access modifiers changed from: private */
    public View zze;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzf;
    /* access modifiers changed from: private */
    public UnifiedNativeAdMapper zzg;
    /* access modifiers changed from: private */
    public NativeAdMapper zzh;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzi;
    /* access modifiers changed from: private */
    public MediationInterscrollerAd zzj;
    /* access modifiers changed from: private */
    public MediationAppOpenAd zzk;
    private final String zzl = "";

    public zzbqh(Adapter adapter) {
        this.zza = adapter;
    }

    private final Bundle zzV(zzm zzm) {
        Bundle bundle;
        Bundle bundle2 = zzm.zzm;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    private final Bundle zzW(String str, zzm zzm, String str2) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzm.zze("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zza instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzm != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzm.zzg);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            throw new RemoteException();
        }
    }

    private static final boolean zzX(zzm zzm) {
        if (zzm.zzf) {
            return true;
        }
        zzbc.zzb();
        return zzf.zzs();
    }

    private static final String zzY(String str, zzm zzm) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzm.zzu;
        }
    }

    public final void zzA(IObjectWrapper iObjectWrapper, zzm zzm, String str, zzbpm zzbpm) throws RemoteException {
        zzm zzm2 = zzm;
        String str2 = str;
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting rewarded ad from adapter.");
            try {
                ((Adapter) this.zza).loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str2, zzm2, (String) null), zzV(zzm2), zzX(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzY(str2, zzm2), ""), new zzbqf(this, zzbpm));
            } catch (Exception e) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", e);
                zzbpd.zza(iObjectWrapper, e, "adapter.loadRewardedAd");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzB(zzm zzm, String str, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzA(this.zzd, zzm, str, new zzbqk((Adapter) obj, this.zzc));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj.getClass().getCanonicalName();
        com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
        throw new RemoteException();
    }

    public final void zzC(IObjectWrapper iObjectWrapper, zzm zzm, String str, zzbpm zzbpm) throws RemoteException {
        zzm zzm2 = zzm;
        String str2 = str;
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting rewarded interstitial ad from adapter.");
            try {
                ((Adapter) this.zza).loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str2, zzm2, (String) null), zzV(zzm2), zzX(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzY(str2, zzm2), ""), new zzbqf(this, zzbpm));
            } catch (Exception e) {
                zzbpd.zza(iObjectWrapper, e, "adapter.loadRewardedInterstitialAd");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zza;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    public final void zzE() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzF() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzG(boolean z) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            }
        } else {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zze(canonicalName + " #009 Class mismatch: " + canonicalName2);
        }
    }

    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Show app open ad from adapter.");
            MediationAppOpenAd mediationAppOpenAd = this.zzk;
            if (mediationAppOpenAd != null) {
                try {
                    mediationAppOpenAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
                } catch (RuntimeException e) {
                    zzbpd.zza(iObjectWrapper, e, "adapter.appOpen.showAd");
                    throw e;
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Can not show null mediation app open ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzI() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationInterstitialAdapter) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zza).showInterstitial();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter) && !(obj instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        } else if (obj instanceof MediationInterstitialAdapter) {
            zzI();
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Show interstitial ad from adapter.");
            MediationInterstitialAd mediationInterstitialAd = this.zzf;
            if (mediationInterstitialAd != null) {
                try {
                    mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
                } catch (RuntimeException e) {
                    zzbpd.zza(iObjectWrapper, e, "adapter.interstitial.showAd");
                    throw e;
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Can not show null mediation interstitial ad.");
                throw new RemoteException();
            }
        }
    }

    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzi;
            if (mediationRewardedAd != null) {
                try {
                    mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
                } catch (RuntimeException e) {
                    zzbpd.zza(iObjectWrapper, e, "adapter.rewarded.showAd");
                    throw e;
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzL() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzi;
            if (mediationRewardedAd != null) {
                try {
                    mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzd));
                } catch (RuntimeException e) {
                    zzbpd.zza(this.zzd, e, "adapter.showVideo");
                    throw e;
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final boolean zzM() {
        return false;
    }

    public final boolean zzN() throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            return this.zzc != null;
        }
        Object obj2 = this.zza;
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj2.getClass().getCanonicalName();
        com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
        throw new RemoteException();
    }

    public final zzbpr zzO() {
        return null;
    }

    public final zzbps zzP() {
        return null;
    }

    public final Bundle zze() {
        return new Bundle();
    }

    public final Bundle zzf() {
        return new Bundle();
    }

    public final Bundle zzg() {
        return new Bundle();
    }

    public final zzeb zzh() {
        Object obj = this.zza;
        if (obj instanceof zza) {
            try {
                return ((zza) obj).getVideoController();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            }
        }
        return null;
    }

    public final zzbgs zzi() {
        zzbqj zzbqj = this.zzb;
        if (zzbqj == null) {
            return null;
        }
        zzbgt zzc2 = zzbqj.zzc();
        if (!(zzc2 instanceof zzbgt)) {
            return null;
        }
        zzbgt zzbgt = zzc2;
        return zzc2.zza();
    }

    public final zzbpp zzj() {
        MediationInterscrollerAd mediationInterscrollerAd = this.zzj;
        if (mediationInterscrollerAd != null) {
            return new zzbqi(mediationInterscrollerAd);
        }
        return null;
    }

    public final zzbpv zzk() {
        UnifiedNativeAdMapper zza2;
        Object obj = this.zza;
        if (obj instanceof MediationNativeAdapter) {
            zzbqj zzbqj = this.zzb;
            if (zzbqj == null || (zza2 = zzbqj.zza()) == null) {
                return null;
            }
            return new zzbqn(zza2);
        } else if (!(obj instanceof Adapter)) {
            return null;
        } else {
            NativeAdMapper nativeAdMapper = this.zzh;
            if (nativeAdMapper != null) {
                return new zzbql(nativeAdMapper);
            }
            UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzg;
            if (unifiedNativeAdMapper != null) {
                return new zzbqn(unifiedNativeAdMapper);
            }
            return null;
        }
    }

    public final zzbru zzl() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzbru.zza(((Adapter) obj).getVersionInfo());
    }

    public final zzbru zzm() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzbru.zza(((Adapter) obj).getSDKVersionInfo());
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return ObjectWrapper.wrap(this.zze);
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        }
    }

    public final void zzo() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper, zzm zzm, String str, zzbwu zzbwu, String str2) throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            this.zzd = iObjectWrapper;
            this.zzc = zzbwu;
            zzbwu.zzl(ObjectWrapper.wrap(this.zza));
            return;
        }
        Object obj2 = this.zza;
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj2.getClass().getCanonicalName();
        com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
        throw new RemoteException();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzq(com.google.android.gms.dynamic.IObjectWrapper r6, com.google.android.gms.internal.ads.zzblt r7, java.util.List r8) throws android.os.RemoteException {
        /*
            r5 = this;
            java.lang.Object r0 = r5.zza
            boolean r0 = r0 instanceof com.google.android.gms.ads.mediation.Adapter
            if (r0 == 0) goto L_0x00b8
            com.google.android.gms.internal.ads.zzbqa r0 = new com.google.android.gms.internal.ads.zzbqa
            r0.<init>(r5, r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0014:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x00aa
            java.lang.Object r1 = r8.next()
            com.google.android.gms.internal.ads.zzblz r1 = (com.google.android.gms.internal.ads.zzblz) r1
            java.lang.String r2 = r1.zza
            int r3 = r2.hashCode()
            switch(r3) {
                case -1396342996: goto L_0x0066;
                case -1052618729: goto L_0x005c;
                case -239580146: goto L_0x0052;
                case 604727084: goto L_0x0048;
                case 1167692200: goto L_0x003e;
                case 1778294298: goto L_0x0034;
                case 1911491517: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0070
        L_0x002a:
            java.lang.String r3 = "rewarded_interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 3
            goto L_0x0071
        L_0x0034:
            java.lang.String r3 = "app_open_ad"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 6
            goto L_0x0071
        L_0x003e:
            java.lang.String r3 = "app_open"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 5
            goto L_0x0071
        L_0x0048:
            java.lang.String r3 = "interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 1
            goto L_0x0071
        L_0x0052:
            java.lang.String r3 = "rewarded"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 2
            goto L_0x0071
        L_0x005c:
            java.lang.String r3 = "native"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 4
            goto L_0x0071
        L_0x0066:
            java.lang.String r3 = "banner"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0071
        L_0x0070:
            r2 = -1
        L_0x0071:
            r3 = 0
            switch(r2) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0097;
                case 2: goto L_0x0094;
                case 3: goto L_0x0091;
                case 4: goto L_0x008e;
                case 5: goto L_0x008b;
                case 6: goto L_0x0076;
                default: goto L_0x0075;
            }
        L_0x0075:
            goto L_0x009c
        L_0x0076:
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzlz
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r4.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x009c
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.APP_OPEN_AD
            goto L_0x009c
        L_0x008b:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.APP_OPEN_AD
            goto L_0x009c
        L_0x008e:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.NATIVE
            goto L_0x009c
        L_0x0091:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.REWARDED_INTERSTITIAL
            goto L_0x009c
        L_0x0094:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.REWARDED
            goto L_0x009c
        L_0x0097:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.INTERSTITIAL
            goto L_0x009c
        L_0x009a:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.BANNER
        L_0x009c:
            if (r3 == 0) goto L_0x0014
            com.google.android.gms.ads.mediation.MediationConfiguration r2 = new com.google.android.gms.ads.mediation.MediationConfiguration
            android.os.Bundle r1 = r1.zzb
            r2.<init>(r3, r1)
            r7.add(r2)
            goto L_0x0014
        L_0x00aa:
            java.lang.Object r8 = r5.zza
            com.google.android.gms.ads.mediation.Adapter r8 = (com.google.android.gms.ads.mediation.Adapter) r8
            java.lang.Object r6 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r6)
            android.content.Context r6 = (android.content.Context) r6
            r8.initialize(r6, r0, r7)
            return
        L_0x00b8:
            android.os.RemoteException r6 = new android.os.RemoteException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqh.zzq(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzblt, java.util.List):void");
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzbwu zzbwu, List list) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not initialize rewarded video adapter.");
        throw new RemoteException();
    }

    public final void zzs(zzm zzm, String str) throws RemoteException {
        zzB(zzm, str, (String) null);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, zzm zzm, String str, zzbpm zzbpm) throws RemoteException {
        zzm zzm2 = zzm;
        String str2 = str;
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting app open ad from adapter.");
            try {
                ((Adapter) this.zza).loadAppOpenAd(new MediationAppOpenAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str2, zzm2, (String) null), zzV(zzm2), zzX(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzY(str2, zzm2), ""), new zzbqg(this, zzbpm));
            } catch (Exception e) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", e);
                zzbpd.zza(iObjectWrapper, e, "adapter.loadAppOpenAd");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzu(IObjectWrapper iObjectWrapper, zzs zzs, zzm zzm, String str, zzbpm zzbpm) throws RemoteException {
        zzv(iObjectWrapper, zzs, zzm, str, (String) null, zzbpm);
    }

    public final void zzv(IObjectWrapper iObjectWrapper, zzs zzs, zzm zzm, String str, String str2, zzbpm zzbpm) throws RemoteException {
        AdSize adSize;
        Date date;
        IObjectWrapper iObjectWrapper2 = iObjectWrapper;
        zzs zzs2 = zzs;
        zzm zzm2 = zzm;
        String str3 = str;
        String str4 = str2;
        zzbpm zzbpm2 = zzbpm;
        Object obj = this.zza;
        if ((obj instanceof MediationBannerAdapter) || (obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting banner ad from adapter.");
            if (zzs2.zzn) {
                adSize = zzb.zzd(zzs2.zze, zzs2.zzb);
            } else {
                adSize = zzb.zzc(zzs2.zze, zzs2.zzb, zzs2.zza);
            }
            AdSize adSize2 = adSize;
            Object obj2 = this.zza;
            if (obj2 instanceof MediationBannerAdapter) {
                try {
                    MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) obj2;
                    List list = zzm2.zze;
                    Bundle bundle = null;
                    HashSet hashSet = list != null ? new HashSet(list) : null;
                    long j = zzm2.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    zzbpy zzbpy = new zzbpy(date, zzm2.zzd, hashSet, zzm2.zzk, zzX(zzm2), zzm2.zzg, zzm2.zzr, zzm2.zzt, zzY(str3, zzm2));
                    Bundle bundle2 = zzm2.zzm;
                    if (bundle2 != null) {
                        bundle = bundle2.getBundle(mediationBannerAdapter.getClass().getName());
                    }
                    mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper2), new zzbqj(zzbpm2), zzW(str3, zzm2, str4), adSize2, zzbpy, bundle);
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                    zzbpd.zza(iObjectWrapper2, th, "adapter.requestBannerAd");
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    zzbqb zzbqb = new zzbqb(this, zzbpm2);
                    Bundle zzW = zzW(str3, zzm2, str4);
                    zzbqb zzbqb2 = zzbqb;
                    Bundle zzV = zzV(zzm2);
                    Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper2);
                    boolean zzX = zzX(zzm2);
                    Location location = zzm2.zzk;
                    zzbqb zzbqb3 = zzbqb2;
                    int i = zzm2.zzg;
                    Context context2 = context;
                    int i2 = zzm2.zzt;
                    String zzY = zzY(str3, zzm2);
                    ((Adapter) obj2).loadBannerAd(new MediationBannerAdConfiguration(context2, "", zzW, zzV, zzX, location, i, i2, zzY, adSize2, this.zzl), zzbqb3);
                } catch (Throwable th2) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", th2);
                    zzbpd.zza(iObjectWrapper2, th2, "adapter.loadBannerAd");
                    throw new RemoteException();
                }
            }
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(MediationBannerAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public final void zzw(IObjectWrapper iObjectWrapper, zzs zzs, zzm zzm, String str, String str2, zzbpm zzbpm) throws RemoteException {
        zzs zzs2 = zzs;
        zzm zzm2 = zzm;
        String str3 = str;
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting interscroller ad from adapter.");
            try {
                Adapter adapter = (Adapter) this.zza;
                adapter.loadInterscrollerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str3, zzm2, str2), zzV(zzm2), zzX(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzY(str3, zzm2), zzb.zze(zzs2.zze, zzs2.zzb), ""), new zzbpz(this, zzbpm, adapter));
            } catch (Exception e) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", e);
                zzbpd.zza(iObjectWrapper, e, "adapter.loadInterscrollerAd");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzx(IObjectWrapper iObjectWrapper, zzm zzm, String str, zzbpm zzbpm) throws RemoteException {
        zzy(iObjectWrapper, zzm, str, (String) null, zzbpm);
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzm zzm, String str, String str2, zzbpm zzbpm) throws RemoteException {
        Date date;
        IObjectWrapper iObjectWrapper2 = iObjectWrapper;
        zzm zzm2 = zzm;
        String str3 = str;
        String str4 = str2;
        zzbpm zzbpm2 = zzbpm;
        Object obj = this.zza;
        if ((obj instanceof MediationInterstitialAdapter) || (obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting interstitial ad from adapter.");
            Object obj2 = this.zza;
            if (obj2 instanceof MediationInterstitialAdapter) {
                try {
                    MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) obj2;
                    List list = zzm2.zze;
                    HashSet hashSet = list != null ? new HashSet(list) : null;
                    long j = zzm2.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    zzbpy zzbpy = new zzbpy(date, zzm2.zzd, hashSet, zzm2.zzk, zzX(zzm2), zzm2.zzg, zzm2.zzr, zzm2.zzt, zzY(str3, zzm2));
                    Bundle bundle = zzm2.zzm;
                    mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper2), new zzbqj(zzbpm2), zzW(str3, zzm2, str4), zzbpy, bundle != null ? bundle.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                    zzbpd.zza(iObjectWrapper2, th, "adapter.requestInterstitialAd");
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper2), "", zzW(str3, zzm2, str4), zzV(zzm2), zzX(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzY(str3, zzm2), this.zzl), new zzbqc(this, zzbpm2));
                } catch (Throwable th2) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", th2);
                    zzbpd.zza(iObjectWrapper2, th2, "adapter.loadInterstitialAd");
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        }
    }

    public final void zzz(IObjectWrapper iObjectWrapper, zzm zzm, String str, String str2, zzbpm zzbpm, zzbfn zzbfn, List list) throws RemoteException {
        Date date;
        IObjectWrapper iObjectWrapper2 = iObjectWrapper;
        zzm zzm2 = zzm;
        String str3 = str;
        String str4 = str2;
        zzbpm zzbpm2 = zzbpm;
        Object obj = this.zza;
        if ((obj instanceof MediationNativeAdapter) || (obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting native ad from adapter.");
            Object obj2 = this.zza;
            if (obj2 instanceof MediationNativeAdapter) {
                try {
                    MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj2;
                    List list2 = zzm2.zze;
                    HashSet hashSet = list2 != null ? new HashSet(list2) : null;
                    long j = zzm2.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    MediationNativeAdapter mediationNativeAdapter2 = mediationNativeAdapter;
                    zzbqm zzbqm = new zzbqm(date, zzm2.zzd, hashSet, zzm2.zzk, zzX(zzm2), zzm2.zzg, zzbfn, list, zzm2.zzr, zzm2.zzt, zzY(str3, zzm2));
                    Bundle bundle = zzm2.zzm;
                    Bundle bundle2 = bundle != null ? bundle.getBundle(mediationNativeAdapter2.getClass().getName()) : null;
                    this.zzb = new zzbqj(zzbpm2);
                    mediationNativeAdapter2.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper2), this.zzb, zzW(str3, zzm2, str4), zzbqm, bundle2);
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                    zzbpd.zza(iObjectWrapper2, th, "adapter.requestNativeAd");
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadNativeAdMapper(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper2), "", zzW(str3, zzm2, str4), zzV(zzm2), zzX(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzY(str3, zzm2), this.zzl, zzbfn), new zzbqe(this, zzbpm2));
                } catch (Throwable th2) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", th2);
                    zzbpd.zza(iObjectWrapper2, th2, "adapter.loadNativeAd");
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = obj.getClass().getCanonicalName();
            com.google.android.gms.ads.internal.util.client.zzm.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        }
    }

    public zzbqh(MediationAdapter mediationAdapter) {
        this.zza = mediationAdapter;
    }
}
