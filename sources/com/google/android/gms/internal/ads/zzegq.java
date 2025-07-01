package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzegq implements zzefb {
    private final Context zza;
    private final zzdgn zzb;
    private final Executor zzc;
    private final zzfes zzd;

    public zzegq(Context context, Executor executor, zzdgn zzdgn, zzfes zzfes) {
        this.zza = context;
        this.zzb = zzdgn;
        this.zzc = executor;
        this.zzd = zzfes;
    }

    private static String zzd(zzfet zzfet) {
        try {
            return zzfet.zzv.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        String zzd2 = zzd(zzfet);
        return zzgei.zzn(zzgei.zzh((Object) null), new zzego(this, zzd2 != null ? Uri.parse(zzd2) : null, zzfff, zzfet), this.zzc);
    }

    public final boolean zzb(zzfff zzfff, zzfet zzfet) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbdo.zzg(context) && !TextUtils.isEmpty(zzd(zzfet));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Uri uri, zzfff zzfff, zzfet zzfet, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzc zzc2 = new zzc(build.intent, (zzaa) null);
            zzcao zzcao = new zzcao();
            zzdfk zze = this.zzb.zze(new zzcsg(zzfff, zzfet, (String) null), new zzdfn(new zzegp(zzcao), (zzcfk) null));
            zzcao.zzc(new AdOverlayInfoParcel(zzc2, (zza) null, zze.zza(), (zzac) null, new VersionInfoParcel(0, 0, false), (zzcfk) null, (zzdel) null));
            this.zzd.zza();
            return zzgei.zzh(zze.zzg());
        } catch (Throwable th) {
            Throwable th2 = th;
            zzm.zzh("Error in CustomTabsAdRenderer", th2);
            throw th2;
        }
    }
}
