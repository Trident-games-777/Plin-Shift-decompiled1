package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbtf;
import com.google.android.gms.internal.ads.zzdel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzab extends zzbtf {
    private final AdOverlayInfoParcel zza;
    private final Activity zzb;
    private boolean zzc = false;
    private boolean zzd = false;
    private boolean zze = false;

    public zzab(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zza = adOverlayInfoParcel;
        this.zzb = activity;
    }

    private final synchronized void zzb() {
        if (!this.zzd) {
            zzr zzr = this.zza.zzc;
            if (zzr != null) {
                zzr.zzdu(4);
            }
            this.zzd = true;
        }
    }

    public final boolean zzH() throws RemoteException {
        return false;
    }

    public final void zzh(int i, int i2, Intent intent) throws RemoteException {
    }

    public final void zzi() throws RemoteException {
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzl(Bundle bundle) {
        zzr zzr;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzix)).booleanValue() && !this.zze) {
            this.zzb.requestWindowFeature(1);
        }
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zza;
        if (adOverlayInfoParcel == null) {
            this.zzb.finish();
        } else if (z) {
            this.zzb.finish();
        } else {
            if (bundle == null) {
                zza zza2 = adOverlayInfoParcel.zzb;
                if (zza2 != null) {
                    zza2.onAdClicked();
                }
                zzdel zzdel = this.zza.zzu;
                if (zzdel != null) {
                    zzdel.zzdG();
                }
                if (!(this.zzb.getIntent() == null || !this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || (zzr = this.zza.zzc) == null)) {
                    zzr.zzdr();
                }
            }
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zza;
            zzv.zzi();
            zzc zzc2 = adOverlayInfoParcel2.zza;
            if (!zza.zzb(activity, zzc2, adOverlayInfoParcel2.zzi, zzc2.zzi)) {
                this.zzb.finish();
            }
        }
    }

    public final void zzm() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzo() throws RemoteException {
        zzr zzr = this.zza.zzc;
        if (zzr != null) {
            zzr.zzdk();
        }
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzp(int i, String[] strArr, int[] iArr) {
    }

    public final void zzq() throws RemoteException {
    }

    public final void zzr() throws RemoteException {
        if (this.zzc) {
            this.zzb.finish();
            return;
        }
        this.zzc = true;
        zzr zzr = this.zza.zzc;
        if (zzr != null) {
            zzr.zzdH();
        }
    }

    public final void zzs(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzc);
    }

    public final void zzt() throws RemoteException {
    }

    public final void zzu() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzv() throws RemoteException {
        zzr zzr = this.zza.zzc;
        if (zzr != null) {
            zzr.zzdt();
        }
    }

    public final void zzx() throws RemoteException {
        this.zze = true;
    }
}
