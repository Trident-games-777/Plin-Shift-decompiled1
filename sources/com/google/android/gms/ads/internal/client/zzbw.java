package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayc;
import com.google.android.gms.internal.ads.zzaye;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbdi;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.internal.ads.zzbwp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbw extends zzayc implements zzby {
    zzbw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public final void zzA() throws RemoteException {
        zzdc(11, zza());
    }

    public final void zzB() throws RemoteException {
        zzdc(6, zza());
    }

    public final void zzC(zzbi zzbi) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbi);
        zzdc(20, zza);
    }

    public final void zzD(zzbl zzbl) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbl);
        zzdc(7, zza);
    }

    public final void zzE(zzcc zzcc) throws RemoteException {
        throw null;
    }

    public final void zzF(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzs);
        zzdc(13, zza);
    }

    public final void zzG(zzcm zzcm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzcm);
        zzdc(8, zza);
    }

    public final void zzH(zzbai zzbai) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbai);
        zzdc(40, zza);
    }

    public final void zzI(zzy zzy) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzy);
        zzdc(39, zza);
    }

    public final void zzJ(zzct zzct) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzct);
        zzdc(45, zza);
    }

    public final void zzK(zzef zzef) throws RemoteException {
        throw null;
    }

    public final void zzL(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzaye.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(34, zza);
    }

    public final void zzM(zzbtp zzbtp) throws RemoteException {
        throw null;
    }

    public final void zzN(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzaye.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(22, zza);
    }

    public final void zzO(zzbdi zzbdi) throws RemoteException {
        throw null;
    }

    public final void zzP(zzdr zzdr) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzdr);
        zzdc(42, zza);
    }

    public final void zzQ(zzbts zzbts, String str) throws RemoteException {
        throw null;
    }

    public final void zzR(String str) throws RemoteException {
        throw null;
    }

    public final void zzS(zzbwp zzbwp) throws RemoteException {
        throw null;
    }

    public final void zzT(String str) throws RemoteException {
        throw null;
    }

    public final void zzU(zzga zzga) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzga);
        zzdc(29, zza);
    }

    public final void zzW(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzdc(44, zza);
    }

    public final void zzX() throws RemoteException {
        throw null;
    }

    public final boolean zzY() throws RemoteException {
        Parcel zzdb = zzdb(46, zza());
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzZ() throws RemoteException {
        Parcel zzdb = zzdb(23, zza());
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzaa() throws RemoteException {
        throw null;
    }

    public final boolean zzab(zzm zzm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzm);
        Parcel zzdb = zzdb(4, zza);
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final void zzac(zzcq zzcq) throws RemoteException {
        throw null;
    }

    public final Bundle zzd() throws RemoteException {
        throw null;
    }

    public final zzs zzg() throws RemoteException {
        Parcel zzdb = zzdb(12, zza());
        zzs zzs = (zzs) zzaye.zza(zzdb, zzs.CREATOR);
        zzdb.recycle();
        return zzs;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzbl zzi() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 33
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzbl
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzbl r1 = (com.google.android.gms.ads.internal.client.zzbl) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzbj r2 = new com.google.android.gms.ads.internal.client.zzbj
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbw.zzi():com.google.android.gms.ads.internal.client.zzbl");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzcm zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 32
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzcm
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzcm r1 = (com.google.android.gms.ads.internal.client.zzcm) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzck r2 = new com.google.android.gms.ads.internal.client.zzck
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbw.zzj():com.google.android.gms.ads.internal.client.zzcm");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzdy zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 41
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IResponseInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzdy
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzdy r1 = (com.google.android.gms.ads.internal.client.zzdy) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzdw r2 = new com.google.android.gms.ads.internal.client.zzdw
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbw.zzk():com.google.android.gms.ads.internal.client.zzdy");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzeb zzl() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 26
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoController"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzeb
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzeb r1 = (com.google.android.gms.ads.internal.client.zzeb) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzdz r2 = new com.google.android.gms.ads.internal.client.zzdz
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbw.zzl():com.google.android.gms.ads.internal.client.zzeb");
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzdb = zzdb(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final String zzr() throws RemoteException {
        Parcel zzdb = zzdb(31, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzs() throws RemoteException {
        throw null;
    }

    public final String zzt() throws RemoteException {
        throw null;
    }

    public final void zzx() throws RemoteException {
        zzdc(2, zza());
    }

    public final void zzy(zzm zzm, zzbo zzbo) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzm);
        zzaye.zzf(zza, zzbo);
        zzdc(43, zza);
    }

    public final void zzz() throws RemoteException {
        zzdc(5, zza());
    }
}
