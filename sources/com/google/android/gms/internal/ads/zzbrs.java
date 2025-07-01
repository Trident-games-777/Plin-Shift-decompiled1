package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbrs extends zzbre {
    private final RtbAdapter zza;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzb;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzc;
    /* access modifiers changed from: private */
    public MediationAppOpenAd zzd;
    private String zze = "";

    public zzbrs(RtbAdapter rtbAdapter) {
        this.zza = rtbAdapter;
    }

    private final Bundle zzv(zzm zzm) {
        Bundle bundle;
        Bundle bundle2 = zzm.zzm;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    private static final Bundle zzw(String str) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e);
            throw new RemoteException();
        }
    }

    private static final boolean zzx(zzm zzm) {
        if (zzm.zzf) {
            return true;
        }
        zzbc.zzb();
        return zzf.zzs();
    }

    private static final String zzy(String str, zzm zzm) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzm.zzu;
        }
    }

    public final zzeb zze() {
        RtbAdapter rtbAdapter = this.zza;
        if (rtbAdapter instanceof zza) {
            try {
                return ((zza) rtbAdapter).getVideoController();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            }
        }
        return null;
    }

    public final zzbru zzf() throws RemoteException {
        return zzbru.zza(this.zza.getVersionInfo());
    }

    public final zzbru zzg() throws RemoteException {
        return zzbru.zza(this.zza.getSDKVersionInfo());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0082, code lost:
        r1 = new com.google.android.gms.ads.mediation.MediationConfiguration(r6, r8);
        r6 = new java.util.ArrayList();
        r6.add(r1);
        r10.collectSignals(new com.google.android.gms.ads.mediation.rtb.RtbSignalData((android.content.Context) com.google.android.gms.dynamic.ObjectWrapper.unwrap(r5), r6, r7, com.google.android.gms.ads.zzb.zzc(r9.zze, r9.zzb, r9.zza)), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ad, code lost:
        throw new java.lang.IllegalArgumentException("Internal Error");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(com.google.android.gms.dynamic.IObjectWrapper r5, java.lang.String r6, android.os.Bundle r7, android.os.Bundle r8, com.google.android.gms.ads.internal.client.zzs r9, com.google.android.gms.internal.ads.zzbri r10) throws android.os.RemoteException {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzbrq r0 = new com.google.android.gms.internal.ads.zzbrq     // Catch:{ all -> 0x00ae }
            r0.<init>(r4, r10)     // Catch:{ all -> 0x00ae }
            com.google.android.gms.ads.mediation.rtb.RtbAdapter r10 = r4.zza     // Catch:{ all -> 0x00ae }
            com.google.android.gms.ads.mediation.MediationConfiguration r1 = new com.google.android.gms.ads.mediation.MediationConfiguration     // Catch:{ all -> 0x00ae }
            int r2 = r6.hashCode()     // Catch:{ all -> 0x00ae }
            switch(r2) {
                case -1396342996: goto L_0x004d;
                case -1052618729: goto L_0x0043;
                case -239580146: goto L_0x0039;
                case 604727084: goto L_0x002f;
                case 1167692200: goto L_0x0025;
                case 1778294298: goto L_0x001b;
                case 1911491517: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0057
        L_0x0011:
            java.lang.String r2 = "rewarded_interstitial"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0057
            r6 = 3
            goto L_0x0058
        L_0x001b:
            java.lang.String r2 = "app_open_ad"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0057
            r6 = 6
            goto L_0x0058
        L_0x0025:
            java.lang.String r2 = "app_open"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0057
            r6 = 5
            goto L_0x0058
        L_0x002f:
            java.lang.String r2 = "interstitial"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0057
            r6 = 1
            goto L_0x0058
        L_0x0039:
            java.lang.String r2 = "rewarded"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0057
            r6 = 2
            goto L_0x0058
        L_0x0043:
            java.lang.String r2 = "native"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0057
            r6 = 4
            goto L_0x0058
        L_0x004d:
            java.lang.String r2 = "banner"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0057
            r6 = 0
            goto L_0x0058
        L_0x0057:
            r6 = -1
        L_0x0058:
            switch(r6) {
                case 0: goto L_0x0080;
                case 1: goto L_0x007d;
                case 2: goto L_0x007a;
                case 3: goto L_0x0077;
                case 4: goto L_0x0074;
                case 5: goto L_0x0071;
                case 6: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x00a6
        L_0x005c:
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzlz     // Catch:{ all -> 0x00ae }
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x00ae }
            java.lang.Object r6 = r2.zza(r6)     // Catch:{ all -> 0x00ae }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x00ae }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x00ae }
            if (r6 == 0) goto L_0x00a6
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.APP_OPEN_AD     // Catch:{ all -> 0x00ae }
            goto L_0x0082
        L_0x0071:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.APP_OPEN_AD     // Catch:{ all -> 0x00ae }
            goto L_0x0082
        L_0x0074:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.NATIVE     // Catch:{ all -> 0x00ae }
            goto L_0x0082
        L_0x0077:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.REWARDED_INTERSTITIAL     // Catch:{ all -> 0x00ae }
            goto L_0x0082
        L_0x007a:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.REWARDED     // Catch:{ all -> 0x00ae }
            goto L_0x0082
        L_0x007d:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.INTERSTITIAL     // Catch:{ all -> 0x00ae }
            goto L_0x0082
        L_0x0080:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.BANNER     // Catch:{ all -> 0x00ae }
        L_0x0082:
            r1.<init>(r6, r8)     // Catch:{ all -> 0x00ae }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00ae }
            r6.<init>()     // Catch:{ all -> 0x00ae }
            r6.add(r1)     // Catch:{ all -> 0x00ae }
            com.google.android.gms.ads.mediation.rtb.RtbSignalData r8 = new com.google.android.gms.ads.mediation.rtb.RtbSignalData     // Catch:{ all -> 0x00ae }
            java.lang.Object r1 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r5)     // Catch:{ all -> 0x00ae }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x00ae }
            int r2 = r9.zze     // Catch:{ all -> 0x00ae }
            int r3 = r9.zzb     // Catch:{ all -> 0x00ae }
            java.lang.String r9 = r9.zza     // Catch:{ all -> 0x00ae }
            com.google.android.gms.ads.AdSize r9 = com.google.android.gms.ads.zzb.zzc(r2, r3, r9)     // Catch:{ all -> 0x00ae }
            r8.<init>(r1, r6, r7, r9)     // Catch:{ all -> 0x00ae }
            r10.collectSignals(r8, r0)     // Catch:{ all -> 0x00ae }
            return
        L_0x00a6:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = "Internal Error"
            r6.<init>(r7)     // Catch:{ all -> 0x00ae }
            throw r6     // Catch:{ all -> 0x00ae }
        L_0x00ae:
            r6 = move-exception
            java.lang.String r7 = "Error generating signals for RTB"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r7, r6)
            java.lang.String r7 = "adapter.collectSignals"
            com.google.android.gms.internal.ads.zzbpd.zza(r5, r6, r7)
            android.os.RemoteException r5 = new android.os.RemoteException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrs.zzh(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, android.os.Bundle, android.os.Bundle, com.google.android.gms.ads.internal.client.zzs, com.google.android.gms.internal.ads.zzbri):void");
    }

    public final void zzm(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqz zzbqz, zzbpm zzbpm) throws RemoteException {
        zzn(str, str2, zzm, iObjectWrapper, zzbqz, zzbpm, (zzbfn) null);
    }

    public final void zzn(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqz zzbqz, zzbpm zzbpm, zzbfn zzbfn) throws RemoteException {
        zzm zzm2 = zzm;
        IObjectWrapper iObjectWrapper2 = iObjectWrapper;
        zzbqz zzbqz2 = zzbqz;
        zzbpm zzbpm2 = zzbpm;
        try {
            zzbrn zzbrn = new zzbrn(this, zzbqz2, zzbpm2);
            String str3 = str;
            this.zza.loadRtbNativeAdMapper(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper2), str3, zzw(str2), zzv(zzm2), zzx(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzy(str2, zzm), this.zze, zzbfn), zzbrn);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render native ad.", th);
            zzbpd.zza(iObjectWrapper2, th, "adapter.loadRtbNativeAd");
            throw new RemoteException();
        }
    }

    public final void zzq(String str) {
        this.zze = str;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationAppOpenAd mediationAppOpenAd = this.zzd;
        if (mediationAppOpenAd == null) {
            return false;
        }
        try {
            mediationAppOpenAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            zzbpd.zza(iObjectWrapper, th, "adapter.showRtbAppOpenAd");
            return true;
        }
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzb;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            zzbpd.zza(iObjectWrapper, th, "adapter.showRtbInterstitialAd");
            return true;
        }
    }

    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzc;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            zzbpd.zza(iObjectWrapper, th, "adapter.showRtbRewardedAd");
            return true;
        }
    }

    public final void zzo(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbrc zzbrc, zzbpm zzbpm) throws RemoteException {
        zzm zzm2 = zzm;
        try {
            this.zza.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzm2), zzx(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzy(str2, zzm), this.zze), new zzbrr(this, zzbrc, zzbpm));
        } catch (Throwable th) {
            Throwable th2 = th;
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render rewarded interstitial ad.", th2);
            zzbpd.zza(iObjectWrapper, th2, "adapter.loadRtbRewardedInterstitialAd");
            throw new RemoteException();
        }
    }

    public final void zzp(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbrc zzbrc, zzbpm zzbpm) throws RemoteException {
        zzm zzm2 = zzm;
        try {
            this.zza.loadRtbRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzm2), zzx(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzy(str2, zzm), this.zze), new zzbrr(this, zzbrc, zzbpm));
        } catch (Throwable th) {
            Throwable th2 = th;
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render rewarded ad.", th2);
            zzbpd.zza(iObjectWrapper, th2, "adapter.loadRtbRewardedAd");
            throw new RemoteException();
        }
    }

    public final void zzi(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqq zzbqq, zzbpm zzbpm) throws RemoteException {
        zzm zzm2 = zzm;
        try {
            this.zza.loadRtbAppOpenAd(new MediationAppOpenAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzm2), zzx(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzy(str2, zzm), this.zze), new zzbrp(this, zzbqq, zzbpm));
        } catch (Throwable th) {
            Throwable th2 = th;
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render app open ad.", th2);
            zzbpd.zza(iObjectWrapper, th2, "adapter.loadRtbAppOpenAd");
            throw new RemoteException();
        }
    }

    public final void zzl(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqw zzbqw, zzbpm zzbpm) throws RemoteException {
        zzm zzm2 = zzm;
        try {
            this.zza.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzm2), zzx(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzy(str2, zzm), this.zze), new zzbrm(this, zzbqw, zzbpm));
        } catch (Throwable th) {
            Throwable th2 = th;
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render interstitial ad.", th2);
            zzbpd.zza(iObjectWrapper, th2, "adapter.loadRtbInterstitialAd");
            throw new RemoteException();
        }
    }

    public final void zzj(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqt zzbqt, zzbpm zzbpm, zzs zzs) throws RemoteException {
        zzm zzm2 = zzm;
        zzs zzs2 = zzs;
        try {
            zzbrk zzbrk = new zzbrk(this, zzbqt, zzbpm);
            this.zza.loadRtbBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzm2), zzx(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzy(str2, zzm), zzb.zzc(zzs2.zze, zzs2.zzb, zzs2.zza), this.zze), zzbrk);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render banner ad.", th);
            zzbpd.zza(iObjectWrapper, th, "adapter.loadRtbBannerAd");
            throw new RemoteException();
        }
    }

    public final void zzk(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqt zzbqt, zzbpm zzbpm, zzs zzs) throws RemoteException {
        zzm zzm2 = zzm;
        zzs zzs2 = zzs;
        try {
            zzbrl zzbrl = new zzbrl(this, zzbqt, zzbpm);
            this.zza.loadRtbInterscrollerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzm2), zzx(zzm2), zzm2.zzk, zzm2.zzg, zzm2.zzt, zzy(str2, zzm), zzb.zzc(zzs2.zze, zzs2.zzb, zzs2.zza), this.zze), zzbrl);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render interscroller ad.", th);
            zzbpd.zza(iObjectWrapper, th, "adapter.loadRtbInterscrollerAd");
            throw new RemoteException();
        }
    }
}
