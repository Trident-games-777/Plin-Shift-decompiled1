package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzbgm extends zzayd implements zzbgn {
    public zzbgm() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper zzh = zzh();
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzh);
                return true;
            case 3:
                String zzk = zzk();
                parcel2.writeNoException();
                parcel2.writeString(zzk);
                return true;
            case 4:
                List zzo = zzo();
                parcel2.writeNoException();
                parcel2.writeList(zzo);
                return true;
            case 5:
                String zzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(zzi);
                return true;
            case 6:
                zzbfy zzf = zzf();
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzf);
                return true;
            case 7:
                String zzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(zzj);
                return true;
            case 8:
                double zzb = zzb();
                parcel2.writeNoException();
                parcel2.writeDouble(zzb);
                return true;
            case 9:
                String zzn = zzn();
                parcel2.writeNoException();
                parcel2.writeString(zzn);
                return true;
            case 10:
                String zzm = zzm();
                parcel2.writeNoException();
                parcel2.writeString(zzm);
                return true;
            case 11:
                Bundle zzc = zzc();
                parcel2.writeNoException();
                zzaye.zze(parcel2, zzc);
                return true;
            case 12:
                zzp();
                parcel2.writeNoException();
                return true;
            case 13:
                zzeb zzd = zzd();
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzd);
                return true;
            case 14:
                zzaye.zzc(parcel);
                zzq((Bundle) zzaye.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzaye.zzc(parcel);
                boolean zzs = zzs((Bundle) zzaye.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(zzs ? 1 : 0);
                return true;
            case 16:
                zzaye.zzc(parcel);
                zzr((Bundle) zzaye.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 17:
                zzbfr zze = zze();
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zze);
                return true;
            case 18:
                IObjectWrapper zzg = zzg();
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzg);
                return true;
            case 19:
                String zzl = zzl();
                parcel2.writeNoException();
                parcel2.writeString(zzl);
                return true;
            default:
                return false;
        }
    }
}
