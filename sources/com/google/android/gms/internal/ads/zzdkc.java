package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdkc implements View.OnClickListener {
    String zza;
    Long zzb;
    WeakReference zzc;
    private final zzdoc zzd;
    private final Clock zze;
    private zzbhs zzf;
    private zzbjr zzg;

    public zzdkc(zzdoc zzdoc, Clock clock) {
        this.zzd = zzdoc;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference weakReference = this.zzc;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzc = null;
        }
    }

    public final void onClick(View view) {
        WeakReference weakReference = this.zzc;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zza == null || this.zzb == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zza);
                hashMap.put("time_interval", String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzd.zzj("sendMessageToNativeJs", hashMap);
            }
            zzd();
        }
    }

    public final zzbhs zza() {
        return this.zzf;
    }

    public final void zzb() {
        if (this.zzf != null && this.zzb != null) {
            zzd();
            try {
                this.zzf.zze();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzc(zzbhs zzbhs) {
        this.zzf = zzbhs;
        zzbjr zzbjr = this.zzg;
        if (zzbjr != null) {
            this.zzd.zzn("/unconfirmedClick", zzbjr);
        }
        zzdkb zzdkb = new zzdkb(this, zzbhs);
        this.zzg = zzdkb;
        this.zzd.zzl("/unconfirmedClick", zzdkb);
    }
}
