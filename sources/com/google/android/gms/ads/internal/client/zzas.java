package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.internal.util.client.zzo;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzas implements zzo {
    public final Object zza(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloaderCreator");
        return queryLocalInterface instanceof zzcj ? (zzcj) queryLocalInterface : new zzcj(iBinder);
    }
}
