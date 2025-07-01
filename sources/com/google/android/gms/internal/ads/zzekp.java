package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzekp extends zzbpl {
    private final zzcwk zza;
    private final zzdej zzb;
    private final zzcxe zzc;
    private final zzcxt zzd;
    private final zzcxy zze;
    private final zzdbi zzf;
    private final zzcys zzg;
    private final zzdfg zzh;
    private final zzdbe zzi;
    private final zzcwz zzj;

    public zzekp(zzcwk zzcwk, zzdej zzdej, zzcxe zzcxe, zzcxt zzcxt, zzcxy zzcxy, zzdbi zzdbi, zzcys zzcys, zzdfg zzdfg, zzdbe zzdbe, zzcwz zzcwz) {
        this.zza = zzcwk;
        this.zzb = zzdej;
        this.zzc = zzcxe;
        this.zzd = zzcxt;
        this.zze = zzcxy;
        this.zzf = zzdbi;
        this.zzg = zzcys;
        this.zzh = zzdfg;
        this.zzi = zzdbe;
        this.zzj = zzcwz;
    }

    public final void zze() {
        this.zza.onAdClicked();
        this.zzb.zzdG();
    }

    public final void zzf() {
        this.zzg.zzdu(4);
    }

    public final void zzg(int i) {
    }

    public final void zzh(zze zze2) {
    }

    public final void zzi(int i, String str) {
    }

    @Deprecated
    public final void zzj(int i) throws RemoteException {
        zzk(new zze(i, "", AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
    }

    public final void zzk(zze zze2) {
        this.zzj.zza(zzfgq.zzc(8, zze2));
    }

    public final void zzl(String str) {
        zzk(new zze(0, str, AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
    }

    public void zzm() {
        this.zzc.zza();
        this.zzi.zzb();
    }

    public final void zzn() {
        this.zzd.zzb();
    }

    public final void zzo() {
        this.zze.zzs();
    }

    public final void zzp() {
        this.zzg.zzdr();
        this.zzi.zza();
    }

    public final void zzq(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    public final void zzr(zzbgs zzbgs, String str) {
    }

    public void zzs(zzbwv zzbwv) {
    }

    public void zzt(zzbwz zzbwz) throws RemoteException {
    }

    public void zzu() throws RemoteException {
    }

    public void zzv() {
        this.zzh.zza();
    }

    public final void zzw() {
        this.zzh.zzb();
    }

    public final void zzx() throws RemoteException {
        this.zzh.zzc();
    }

    public void zzy() {
        this.zzh.zzd();
    }
}
