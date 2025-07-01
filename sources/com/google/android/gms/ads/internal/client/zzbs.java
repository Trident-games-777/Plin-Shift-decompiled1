package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzayc;
import com.google.android.gms.internal.ads.zzaye;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzbhm;
import com.google.android.gms.internal.ads.zzbmb;
import com.google.android.gms.internal.ads.zzbmk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbs extends zzayc implements zzbu {
    zzbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzbr zze() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 1
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzdb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoader"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzbr
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.ads.internal.client.zzbr r1 = (com.google.android.gms.ads.internal.client.zzbr) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.ads.internal.client.zzbp r2 = new com.google.android.gms.ads.internal.client.zzbp
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbs.zze():com.google.android.gms.ads.internal.client.zzbr");
    }

    public final void zzf(zzbgw zzbgw) throws RemoteException {
        throw null;
    }

    public final void zzg(zzbgz zzbgz) throws RemoteException {
        throw null;
    }

    public final void zzh(String str, zzbhf zzbhf, zzbhc zzbhc) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzaye.zzf(zza, zzbhf);
        zzaye.zzf(zza, zzbhc);
        zzdc(5, zza);
    }

    public final void zzi(zzbmk zzbmk) throws RemoteException {
        throw null;
    }

    public final void zzj(zzbhj zzbhj, zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbhj);
        zzaye.zzd(zza, zzs);
        zzdc(8, zza);
    }

    public final void zzk(zzbhm zzbhm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbhm);
        zzdc(10, zza);
    }

    public final void zzl(zzbl zzbl) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbl);
        zzdc(2, zza);
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, adManagerAdViewOptions);
        zzdc(15, zza);
    }

    public final void zzn(zzbmb zzbmb) throws RemoteException {
        throw null;
    }

    public final void zzo(zzbfn zzbfn) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzbfn);
        zzdc(6, zza);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        throw null;
    }

    public final void zzq(zzcq zzcq) throws RemoteException {
        throw null;
    }
}
