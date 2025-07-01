package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbgt {
    private final zzbgs zza;

    public zzbgt(zzbgs zzbgs) {
        Context context;
        this.zza = zzbgs;
        try {
            context = (Context) ObjectWrapper.unwrap(zzbgs.zzh());
        } catch (RemoteException | NullPointerException e) {
            zzm.zzh("", e);
            context = null;
        }
        if (context != null) {
            try {
                this.zza.zzs(ObjectWrapper.wrap(new MediaView(context)));
            } catch (RemoteException e2) {
                zzm.zzh("", e2);
            }
        }
    }

    public final zzbgs zza() {
        return this.zza;
    }

    public final String zzb() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }
}
