package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayc;
import com.google.android.gms.internal.ads.zzaye;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbaf;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbxb;
import com.google.android.gms.internal.ads.zzbxc;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzcg extends zzayc implements zzci {
    zzcg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloader");
    }

    public final zzbaf zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzdb = zzdb(5, zza);
        zzbaf zzb = zzbae.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzby zzf(java.lang.String r4) throws android.os.RemoteException {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.zza()
            r0.writeString(r4)
            r4 = 7
            android.os.Parcel r4 = r3.zzdb(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.ads.internal.client.IAdManager"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.ads.internal.client.zzby
            if (r2 == 0) goto L_0x0022
            r0 = r1
            com.google.android.gms.ads.internal.client.zzby r0 = (com.google.android.gms.ads.internal.client.zzby) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.ads.internal.client.zzbw r1 = new com.google.android.gms.ads.internal.client.zzbw
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzcg.zzf(java.lang.String):com.google.android.gms.ads.internal.client.zzby");
    }

    public final zzbxc zzg(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzdb = zzdb(3, zza);
        zzbxc zzq = zzbxb.zzq(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzq;
    }

    public final void zzh(zzbpg zzbpg) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbpg);
        zzdc(8, zza);
    }

    public final void zzi(List list, zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzaye.zzf(zza, zzcf);
        zzdc(1, zza);
    }

    public final boolean zzj(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzdb = zzdb(4, zza);
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzk(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzdb = zzdb(6, zza);
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzdb = zzdb(2, zza);
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
