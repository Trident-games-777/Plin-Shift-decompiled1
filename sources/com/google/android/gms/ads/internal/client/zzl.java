package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbpg;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzl extends RemoteCreator {
    public zzl() {
        super("com.google.android.gms.ads.AdPreloaderRemoteCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloaderCreator");
        return queryLocalInterface instanceof zzcj ? (zzcj) queryLocalInterface : new zzcj(iBinder);
    }

    @Nullable
    public final zzci zza(Context context, zzbpg zzbpg) {
        zzci zzci;
        try {
            IBinder zze = ((zzcj) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), zzbpg, 243799000);
            if (zze == null) {
                zzci = null;
            } else {
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
                zzci = queryLocalInterface instanceof zzci ? (zzci) queryLocalInterface : new zzcg(zze);
            }
            zzci.zzh(zzbpg);
            return zzci;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzm.zzk("Could not get remote AdPreloaderCreator.", e);
            return null;
        }
    }
}
