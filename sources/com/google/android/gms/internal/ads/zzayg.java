package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzayg extends zzayd implements zzayh {
    public static zzayh zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        return queryLocalInterface instanceof zzayh ? (zzayh) queryLocalInterface : new zzayf(iBinder);
    }
}
