package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzaye;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzed extends zzayd implements zzee {
    public zzed() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzi();
        } else if (i == 2) {
            zzh();
        } else if (i == 3) {
            zzg();
        } else if (i == 4) {
            zze();
        } else if (i != 5) {
            return false;
        } else {
            boolean zzg = zzaye.zzg(parcel);
            zzaye.zzc(parcel);
            zzf(zzg);
        }
        parcel2.writeNoException();
        return true;
    }
}
