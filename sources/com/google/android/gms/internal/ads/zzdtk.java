package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzv;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdtk implements AppEventListener, zzczj, zza, zzcwm, zzcxg, zzcxh, zzcya, zzcwp, zzfjs {
    private final List zza;
    private final zzdsy zzb;
    private long zzc;

    public zzdtk(zzdsy zzdsy, zzchk zzchk) {
        this.zzb = zzdsy;
        this.zza = Collections.singletonList(zzchk);
    }

    private final void zzg(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(String.valueOf(cls.getSimpleName())), str, objArr);
    }

    public final void onAdClicked() {
        zzg(zza.class, "onAdClicked", new Object[0]);
    }

    public final void onAppEvent(String str, String str2) {
        zzg(AppEventListener.class, "onAppEvent", str, str2);
    }

    public final void zza() {
        zzg(zzcwm.class, "onAdClosed", new Object[0]);
    }

    public final void zzb() {
        zzg(zzcwm.class, "onAdLeftApplication", new Object[0]);
    }

    public final void zzc() {
        zzg(zzcwm.class, "onAdOpened", new Object[0]);
    }

    public final void zzd(zzfjl zzfjl, String str) {
        zzg(zzfjk.class, "onTaskSucceeded", str);
    }

    public final void zzdB(zze zze) {
        zzg(zzcwp.class, "onAdFailedToLoad", Integer.valueOf(zze.zza), zze.zzb, zze.zzc);
    }

    public final void zzdC(zzfjl zzfjl, String str) {
        zzg(zzfjk.class, "onTaskCreated", str);
    }

    public final void zzdD(zzfjl zzfjl, String str, Throwable th) {
        zzg(zzfjk.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzdE(zzfjl zzfjl, String str) {
        zzg(zzfjk.class, "onTaskStarted", str);
    }

    public final void zzdj(Context context) {
        zzg(zzcxh.class, "onDestroy", context);
    }

    public final void zzdl(Context context) {
        zzg(zzcxh.class, "onPause", context);
    }

    public final void zzdm(Context context) {
        zzg(zzcxh.class, "onResume", context);
    }

    public final void zzdn(zzbvx zzbvx) {
        this.zzc = zzv.zzC().elapsedRealtime();
        zzg(zzczj.class, "onAdRequest", new Object[0]);
    }

    public final void zzdo(zzfff zzfff) {
    }

    @ParametersAreNonnullByDefault
    public final void zzds(zzbwj zzbwj, String str, String str2) {
        zzg(zzcwm.class, "onRewarded", zzbwj, str, str2);
    }

    public final void zze() {
        zzg(zzcwm.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zzf() {
        zzg(zzcwm.class, "onRewardedVideoStarted", new Object[0]);
    }

    public final void zzr() {
        zzg(zzcxg.class, "onAdImpression", new Object[0]);
    }

    public final void zzs() {
        long elapsedRealtime = zzv.zzC().elapsedRealtime() - this.zzc;
        com.google.android.gms.ads.internal.util.zze.zza("Ad Request Latency : " + elapsedRealtime);
        zzg(zzcya.class, "onAdLoaded", new Object[0]);
    }
}
