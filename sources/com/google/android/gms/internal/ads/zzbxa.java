package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdo;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbxa extends zzayc implements zzbxc {
    zzbxa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public final Bundle zzb() throws RemoteException {
        Parcel zzdb = zzdb(9, zza());
        Bundle bundle = (Bundle) zzaye.zza(zzdb, Bundle.CREATOR);
        zzdb.recycle();
        return bundle;
    }

    public final zzdy zzc() throws RemoteException {
        Parcel zzdb = zzdb(12, zza());
        zzdy zzb = zzdx.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbwz zzd() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 11
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbwz
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbwz r1 = (com.google.android.gms.internal.ads.zzbwz) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbwx r2 = new com.google.android.gms.internal.ads.zzbwx
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxa.zzd():com.google.android.gms.internal.ads.zzbwz");
    }

    public final String zze() throws RemoteException {
        throw null;
    }

    public final void zzf(zzm zzm, zzbxj zzbxj) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzm);
        zzaye.zzf(zza, zzbxj);
        zzdc(1, zza);
    }

    public final void zzg(zzm zzm, zzbxj zzbxj) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzm);
        zzaye.zzf(zza, zzbxj);
        zzdc(14, zza);
    }

    public final void zzh(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzaye.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(15, zza);
    }

    public final void zzi(zzdo zzdo) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzdo);
        zzdc(8, zza);
    }

    public final void zzj(zzdr zzdr) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzdr);
        zzdc(13, zza);
    }

    public final void zzk(zzbxf zzbxf) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbxf);
        zzdc(2, zza);
    }

    public final void zzl(zzbxq zzbxq) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzbxq);
        zzdc(7, zza);
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzdc(5, zza);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        throw null;
    }

    public final boolean zzo() throws RemoteException {
        throw null;
    }

    public final void zzp(zzbxk zzbxk) throws RemoteException {
        throw null;
    }
}
