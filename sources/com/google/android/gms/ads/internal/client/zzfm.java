package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzblw;
import com.google.android.gms.internal.ads.zzbpg;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzfm extends zzcy {
    private zzblw zza;

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        zzblw zzblw = this.zza;
        if (zzblw != null) {
            try {
                zzblw.zzb(Collections.emptyList());
            } catch (RemoteException e) {
                zzm.zzk("Could not notify onComplete event.", e);
            }
        }
    }

    public final float zze() throws RemoteException {
        return 1.0f;
    }

    public final String zzf() {
        return "";
    }

    public final List zzg() throws RemoteException {
        return Collections.emptyList();
    }

    public final void zzh(String str) throws RemoteException {
    }

    public final void zzi() {
    }

    public final void zzj(boolean z) throws RemoteException {
    }

    public final void zzk() throws RemoteException {
        zzm.zzg("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzf.zza.post(new zzfl(this));
    }

    public final void zzl(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzm(zzdl zzdl) {
    }

    public final void zzn(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    public final void zzo(zzbpg zzbpg) throws RemoteException {
    }

    public final void zzp(boolean z) throws RemoteException {
    }

    public final void zzq(float f) throws RemoteException {
    }

    public final void zzr(String str) throws RemoteException {
    }

    public final void zzs(zzblw zzblw) throws RemoteException {
        this.zza = zzblw;
    }

    public final void zzt(String str) {
    }

    public final void zzu(zzfv zzfv) throws RemoteException {
    }

    public final boolean zzv() throws RemoteException {
        return false;
    }
}
