package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdks {
    private final zzdpn zza;
    private final zzdoc zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdks(zzdpn zzdpn, zzdoc zzdoc) {
        this.zza = zzdpn;
        this.zzb = zzdoc;
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzbc.zzb();
        return zzf.zzy(context, i);
    }

    public final View zza(View view, WindowManager windowManager) throws zzcfw {
        zzcfk zza2 = this.zza.zza(zzs.zzc(), (zzfet) null, (zzfew) null);
        zza2.zzF().setVisibility(4);
        zza2.zzF().setContentDescription("policy_validator");
        zza2.zzag("/sendMessageToSdk", new zzdkm(this));
        zza2.zzag("/hideValidatorOverlay", new zzdkn(this, windowManager, view));
        zza2.zzag("/open", new zzbkd((zzb) null, (zzbse) null, (zzedp) null, (zzdsm) null, (zzcnb) null));
        this.zzb.zzm(new WeakReference(zza2), "/loadNativeAdPolicyViolations", new zzdko(this, view, windowManager));
        this.zzb.zzm(new WeakReference(zza2), "/showValidatorOverlay", new zzdkp());
        return zza2.zzF();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcfk zzcfk, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcfk zzcfk, Map map) {
        zzm.zze("Hide native ad policy validator overlay.");
        zzcfk.zzF().setVisibility(8);
        if (zzcfk.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcfk.zzF());
        }
        zzcfk.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzc);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzj("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(View view, WindowManager windowManager, zzcfk zzcfk, Map map) {
        zzcfk zzcfk2;
        int i;
        zzcfk.zzN().zzB(new zzdkr(this, map));
        if (map != null) {
            Context context = view.getContext();
            int zzf = zzf(context, (String) map.get("validator_width"), ((Integer) zzbe.zzc().zza(zzbcn.zzhK)).intValue());
            int zzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) zzbe.zzc().zza(zzbcn.zzhL)).intValue());
            int zzf3 = zzf(context, (String) map.get("validator_x"), 0);
            int zzf4 = zzf(context, (String) map.get("validator_y"), 0);
            zzcfk.zzaj(zzche.zzb(zzf, zzf2));
            try {
                zzcfk.zzG().getSettings().setUseWideViewPort(((Boolean) zzbe.zzc().zza(zzbcn.zzhM)).booleanValue());
                zzcfk.zzG().getSettings().setLoadWithOverviewMode(((Boolean) zzbe.zzc().zza(zzbcn.zzhN)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzb2 = zzbu.zzb();
            zzb2.x = zzf3;
            zzb2.y = zzf4;
            windowManager.updateViewLayout(zzcfk.zzF(), zzb2);
            String str = (String) map.get("orientation");
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                zzcfk2 = zzcfk;
            } else {
                if (DiskLruCache.VERSION.equals(str) || ExifInterface.GPS_MEASUREMENT_2D.equals(str)) {
                    i = rect.bottom;
                } else {
                    i = rect.top;
                }
                View view2 = view;
                zzcfk2 = zzcfk;
                this.zzc = new zzdkq(view2, zzcfk2, str, zzb2, i - zzf4, windowManager);
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzc);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzcfk2.loadUrl(str2);
            }
        }
    }
}
