package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayc;
import com.google.android.gms.internal.ads.zzaye;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzdw extends zzayc implements zzdy {
    zzdw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public final Bundle zze() throws RemoteException {
        Parcel zzdb = zzdb(5, zza());
        Bundle bundle = (Bundle) zzaye.zza(zzdb, Bundle.CREATOR);
        zzdb.recycle();
        return bundle;
    }

    public final zzw zzf() throws RemoteException {
        Parcel zzdb = zzdb(4, zza());
        zzw zzw = (zzw) zzaye.zza(zzdb, zzw.CREATOR);
        zzdb.recycle();
        return zzw;
    }

    public final String zzg() throws RemoteException {
        Parcel zzdb = zzdb(1, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzh() throws RemoteException {
        Parcel zzdb = zzdb(6, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzi() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final List zzj() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        ArrayList<zzw> createTypedArrayList = zzdb.createTypedArrayList(zzw.CREATOR);
        zzdb.recycle();
        return createTypedArrayList;
    }
}
