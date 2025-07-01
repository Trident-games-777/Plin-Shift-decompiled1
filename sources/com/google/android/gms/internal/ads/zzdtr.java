package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdtr {
    private final zzbkq zza;

    zzdtr(zzbkq zzbkq) {
        this.zza = zzbkq;
    }

    private final void zzs(zzdtp zzdtp) throws RemoteException {
        String zza2 = zzdtp.zza(zzdtp);
        zzm.zzi("Dispatching AFMA event on publisher webview: ".concat(zza2));
        this.zza.zzb(zza2);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdtp("initialize", (zzdtq) null));
    }

    public final void zzb(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("interstitial", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onAdClicked";
        this.zza.zzb(zzdtp.zza(zzdtp));
    }

    public final void zzc(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("interstitial", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onAdClosed";
        zzs(zzdtp);
    }

    public final void zzd(long j, int i) throws RemoteException {
        zzdtp zzdtp = new zzdtp("interstitial", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onAdFailedToLoad";
        zzdtp.zzd = Integer.valueOf(i);
        zzs(zzdtp);
    }

    public final void zze(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("interstitial", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onAdLoaded";
        zzs(zzdtp);
    }

    public final void zzf(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("interstitial", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdtp);
    }

    public final void zzg(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("interstitial", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onAdOpened";
        zzs(zzdtp);
    }

    public final void zzh(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("creation", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "nativeObjectCreated";
        zzs(zzdtp);
    }

    public final void zzi(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("creation", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "nativeObjectNotCreated";
        zzs(zzdtp);
    }

    public final void zzj(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("rewarded", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onAdClicked";
        zzs(zzdtp);
    }

    public final void zzk(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("rewarded", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onRewardedAdClosed";
        zzs(zzdtp);
    }

    public final void zzl(long j, zzbwz zzbwz) throws RemoteException {
        zzdtp zzdtp = new zzdtp("rewarded", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onUserEarnedReward";
        zzdtp.zze = zzbwz.zzf();
        zzdtp.zzf = Integer.valueOf(zzbwz.zze());
        zzs(zzdtp);
    }

    public final void zzm(long j, int i) throws RemoteException {
        zzdtp zzdtp = new zzdtp("rewarded", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onRewardedAdFailedToLoad";
        zzdtp.zzd = Integer.valueOf(i);
        zzs(zzdtp);
    }

    public final void zzn(long j, int i) throws RemoteException {
        zzdtp zzdtp = new zzdtp("rewarded", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onRewardedAdFailedToShow";
        zzdtp.zzd = Integer.valueOf(i);
        zzs(zzdtp);
    }

    public final void zzo(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("rewarded", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onAdImpression";
        zzs(zzdtp);
    }

    public final void zzp(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("rewarded", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onRewardedAdLoaded";
        zzs(zzdtp);
    }

    public final void zzq(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("rewarded", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdtp);
    }

    public final void zzr(long j) throws RemoteException {
        zzdtp zzdtp = new zzdtp("rewarded", (zzdtq) null);
        zzdtp.zza = Long.valueOf(j);
        zzdtp.zzc = "onRewardedAdOpened";
        zzs(zzdtp);
    }
}
