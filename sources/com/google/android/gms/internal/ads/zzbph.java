package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbph extends zzayc implements zzbpj {
    zzbph(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void zzA(IObjectWrapper iObjectWrapper, zzm zzm, String str, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzd(zza, zzm);
        zza.writeString(str);
        zzaye.zzf(zza, zzbpm);
        zzdc(28, zza);
    }

    public final void zzB(zzm zzm, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzC(IObjectWrapper iObjectWrapper, zzm zzm, String str, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzd(zza, zzm);
        zza.writeString(str);
        zzaye.zzf(zza, zzbpm);
        zzdc(32, zza);
    }

    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzdc(21, zza);
    }

    public final void zzE() throws RemoteException {
        zzdc(8, zza());
    }

    public final void zzF() throws RemoteException {
        zzdc(9, zza());
    }

    public final void zzG(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzaye.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(25, zza);
    }

    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzdc(39, zza);
    }

    public final void zzI() throws RemoteException {
        zzdc(4, zza());
    }

    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzdc(37, zza);
    }

    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzdc(30, zza);
    }

    public final void zzL() throws RemoteException {
        zzdc(12, zza());
    }

    public final boolean zzM() throws RemoteException {
        Parcel zzdb = zzdb(22, zza());
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzN() throws RemoteException {
        Parcel zzdb = zzdb(13, zza());
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbpr zzO() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 15
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbpr
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbpr r1 = (com.google.android.gms.internal.ads.zzbpr) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbpr r2 = new com.google.android.gms.internal.ads.zzbpr
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbph.zzO():com.google.android.gms.internal.ads.zzbpr");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbps zzP() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 16
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbps
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbps r1 = (com.google.android.gms.internal.ads.zzbps) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbps r2 = new com.google.android.gms.internal.ads.zzbps
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbph.zzP():com.google.android.gms.internal.ads.zzbps");
    }

    public final Bundle zze() throws RemoteException {
        throw null;
    }

    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    public final zzeb zzh() throws RemoteException {
        Parcel zzdb = zzdb(26, zza());
        zzeb zzb = zzea.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final zzbgs zzi() throws RemoteException {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbpp zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 36
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbpp
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbpp r1 = (com.google.android.gms.internal.ads.zzbpp) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbpn r2 = new com.google.android.gms.internal.ads.zzbpn
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbph.zzj():com.google.android.gms.internal.ads.zzbpp");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbpv zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 27
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbpv
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbpv r1 = (com.google.android.gms.internal.ads.zzbpv) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbpt r2 = new com.google.android.gms.internal.ads.zzbpt
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbph.zzk():com.google.android.gms.internal.ads.zzbpv");
    }

    public final zzbru zzl() throws RemoteException {
        Parcel zzdb = zzdb(33, zza());
        zzbru zzbru = (zzbru) zzaye.zza(zzdb, zzbru.CREATOR);
        zzdb.recycle();
        return zzbru;
    }

    public final zzbru zzm() throws RemoteException {
        Parcel zzdb = zzdb(34, zza());
        zzbru zzbru = (zzbru) zzaye.zza(zzdb, zzbru.CREATOR);
        zzdb.recycle();
        return zzbru;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final void zzo() throws RemoteException {
        zzdc(5, zza());
    }

    public final void zzp(IObjectWrapper iObjectWrapper, zzm zzm, String str, zzbwu zzbwu, String str2) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzd(zza, zzm);
        zza.writeString((String) null);
        zzaye.zzf(zza, zzbwu);
        zza.writeString(str2);
        zzdc(10, zza);
    }

    public final void zzq(IObjectWrapper iObjectWrapper, zzblt zzblt, List list) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzblt);
        zza.writeTypedList(list);
        zzdc(31, zza);
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzbwu zzbwu, List list) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbwu);
        zza.writeStringList(list);
        zzdc(23, zza);
    }

    public final void zzs(zzm zzm, String str) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzm);
        zza.writeString(str);
        zzdc(11, zza);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, zzm zzm, String str, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzd(zza, zzm);
        zza.writeString(str);
        zzaye.zzf(zza, zzbpm);
        zzdc(38, zza);
    }

    public final void zzu(IObjectWrapper iObjectWrapper, zzs zzs, zzm zzm, String str, zzbpm zzbpm) throws RemoteException {
        throw null;
    }

    public final void zzv(IObjectWrapper iObjectWrapper, zzs zzs, zzm zzm, String str, String str2, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzd(zza, zzs);
        zzaye.zzd(zza, zzm);
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzf(zza, zzbpm);
        zzdc(6, zza);
    }

    public final void zzw(IObjectWrapper iObjectWrapper, zzs zzs, zzm zzm, String str, String str2, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzd(zza, zzs);
        zzaye.zzd(zza, zzm);
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzf(zza, zzbpm);
        zzdc(35, zza);
    }

    public final void zzx(IObjectWrapper iObjectWrapper, zzm zzm, String str, zzbpm zzbpm) throws RemoteException {
        throw null;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzm zzm, String str, String str2, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzd(zza, zzm);
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzf(zza, zzbpm);
        zzdc(7, zza);
    }

    public final void zzz(IObjectWrapper iObjectWrapper, zzm zzm, String str, String str2, zzbpm zzbpm, zzbfn zzbfn, List list) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzd(zza, zzm);
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzf(zza, zzbpm);
        zzaye.zzd(zza, zzbfn);
        zza.writeStringList(list);
        zzdc(14, zza);
    }
}
