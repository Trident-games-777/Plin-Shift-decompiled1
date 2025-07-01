package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeeq implements zzeer {
    static /* synthetic */ zzeew zzc(String str, String str2, String str3, zzees zzees, String str4, WebView webView, String str5, String str6, zzeet zzeet) {
        zzfnj zza = zzfnj.zza("Google", str2);
        zzfni zzp = zzp("javascript");
        zzfnb zzn = zzn(zzees.toString());
        if (zzp == zzfni.NONE) {
            zzm.zzj("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzn == null) {
            zzm.zzj("Omid html session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzees))));
            return null;
        } else {
            zzfni zzp2 = zzp(str4);
            if (zzn == zzfnb.VIDEO && zzp2 == zzfni.NONE) {
                zzm.zzj("Omid html session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
                return null;
            }
            zzfmy zzb = zzfmy.zzb(zza, webView, str5, "");
            return new zzeew(zzfmw.zza(zzfmx.zza(zzn, zzo(zzeet.toString()), zzp, zzp2, true), zzb), zzb);
        }
    }

    static /* synthetic */ zzeew zzd(String str, String str2, String str3, String str4, zzees zzees, WebView webView, String str5, String str6, zzeet zzeet) {
        zzfnj zza = zzfnj.zza(str, str2);
        zzfni zzp = zzp("javascript");
        zzfni zzp2 = zzp(str4);
        zzfnb zzn = zzn(zzees.toString());
        if (zzp == zzfni.NONE) {
            zzm.zzj("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzn == null) {
            zzm.zzj("Omid js session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzees))));
            return null;
        } else if (zzn == zzfnb.VIDEO && zzp2 == zzfni.NONE) {
            zzm.zzj("Omid js session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        } else {
            zzfmy zzc = zzfmy.zzc(zza, webView, str5, "");
            return new zzeew(zzfmw.zza(zzfmx.zza(zzn, zzo(zzeet.toString()), zzp, zzp2, true), zzc), zzc);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfnb zzn(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -382745961(0xffffffffe92fc297, float:-1.3280059E25)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 714893483(0x2a9c68ab, float:2.7783795E-13)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "nativeDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r3
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "htmlDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0043
            if (r4 == r3) goto L_0x0040
            if (r4 == r2) goto L_0x003d
            r4 = 0
            return r4
        L_0x003d:
            com.google.android.gms.internal.ads.zzfnb r4 = com.google.android.gms.internal.ads.zzfnb.VIDEO
            return r4
        L_0x0040:
            com.google.android.gms.internal.ads.zzfnb r4 = com.google.android.gms.internal.ads.zzfnb.NATIVE_DISPLAY
            return r4
        L_0x0043:
            com.google.android.gms.internal.ads.zzfnb r4 = com.google.android.gms.internal.ads.zzfnb.HTML_DISPLAY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeeq.zzn(java.lang.String):com.google.android.gms.internal.ads.zzfnb");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfne zzo(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1104128070(0xffffffffbe3057ba, float:-0.17220965)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1318088141(0x4e906dcd, float:1.2115575E9)
            if (r0 == r1) goto L_0x0020
            r1 = 1988248512(0x768243c0, float:1.3210405E33)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "onePixel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "definedByJavascript"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r3
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "beginToRender"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0044
            if (r4 == r3) goto L_0x0041
            if (r4 == r2) goto L_0x003e
            com.google.android.gms.internal.ads.zzfne r4 = com.google.android.gms.internal.ads.zzfne.UNSPECIFIED
            return r4
        L_0x003e:
            com.google.android.gms.internal.ads.zzfne r4 = com.google.android.gms.internal.ads.zzfne.ONE_PIXEL
            return r4
        L_0x0041:
            com.google.android.gms.internal.ads.zzfne r4 = com.google.android.gms.internal.ads.zzfne.DEFINED_BY_JAVASCRIPT
            return r4
        L_0x0044:
            com.google.android.gms.internal.ads.zzfne r4 = com.google.android.gms.internal.ads.zzfne.BEGIN_TO_RENDER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeeq.zzo(java.lang.String):com.google.android.gms.internal.ads.zzfne");
    }

    private static zzfni zzp(String str) {
        if ("native".equals(str)) {
            return zzfni.NATIVE;
        }
        if ("javascript".equals(str)) {
            return zzfni.JAVASCRIPT;
        }
        return zzfni.NONE;
    }

    private static final Object zzq(zzeep zzeep) {
        try {
            return zzeep.zza();
        } catch (RuntimeException e) {
            zzv.zzp().zzv(e, "omid exception");
            return null;
        }
    }

    private static final void zzr(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            zzv.zzp().zzv(e, "omid exception");
        }
    }

    public final zzeew zza(String str, WebView webView, String str2, String str3, String str4, zzeet zzeet, zzees zzees, String str5) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfb)).booleanValue() || !zzfmu.zzb()) {
            return null;
        }
        return (zzeew) zzq(new zzeef("Google", str, "javascript", zzees, str4, webView, str5, "", zzeet));
    }

    public final zzeew zzb(String str, WebView webView, String str2, String str3, String str4, String str5, zzeet zzeet, zzees zzees, String str6) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfb)).booleanValue() || !zzfmu.zzb()) {
            return null;
        }
        return (zzeew) zzq(new zzeei(str5, str, "javascript", str4, zzees, webView, str6, "", zzeet));
    }

    public final zzfnh zze(VersionInfoParcel versionInfoParcel, WebView webView, boolean z) {
        return (zzfnh) zzq(new zzeen(versionInfoParcel, webView, true));
    }

    public final String zzf(Context context) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfb)).booleanValue()) {
            return null;
        }
        return (String) zzq(new zzeel());
    }

    public final void zzg(zzfmw zzfmw, View view) {
        zzr(new zzeee(zzfmw, view));
    }

    public final void zzh(zzfnh zzfnh, View view) {
        zzr(new zzeek(zzfnh, view));
    }

    public final void zzi(zzfmw zzfmw) {
        zzr(new zzeeo(zzfmw));
    }

    public final void zzj(zzfmw zzfmw, View view) {
        zzr(new zzeeg(zzfmw, view));
    }

    public final void zzk(zzfmw zzfmw) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfb)).booleanValue() && zzfmu.zzb()) {
            Objects.requireNonNull(zzfmw);
            zzr(new zzeeh(zzfmw));
        }
    }

    public final boolean zzl(Context context) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfb)).booleanValue()) {
            zzm.zzj("Omid flag is disabled");
            return false;
        }
        Boolean bool = (Boolean) zzq(new zzeej(context));
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public final void zzm(zzfnh zzfnh, zzcfz zzcfz) {
        zzr(new zzeem(zzfnh, zzcfz));
    }
}
