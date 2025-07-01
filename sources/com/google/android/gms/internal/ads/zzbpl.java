package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzbpl extends zzayd implements zzbpm {
    public zzbpl() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzbpm zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return queryLocalInterface instanceof zzbpm ? (zzbpm) queryLocalInterface : new zzbpk(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                int readInt = parcel.readInt();
                zzaye.zzc(parcel);
                zzg(readInt);
                break;
            case 4:
                zzn();
                break;
            case 5:
                zzp();
                break;
            case 6:
                zzo();
                break;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (queryLocalInterface instanceof zzbpq) {
                        zzbpq zzbpq = (zzbpq) queryLocalInterface;
                    }
                }
                zzaye.zzc(parcel);
                break;
            case 8:
                zzm();
                break;
            case 9:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                zzaye.zzc(parcel);
                zzq(readString, readString2);
                break;
            case 10:
                zzbgr.zzb(parcel.readStrongBinder());
                parcel.readString();
                zzaye.zzc(parcel);
                break;
            case 11:
                zzv();
                break;
            case 12:
                parcel.readString();
                zzaye.zzc(parcel);
                break;
            case 13:
                zzy();
                break;
            case 14:
                zzaye.zzc(parcel);
                zzs((zzbwv) zzaye.zza(parcel, zzbwv.CREATOR));
                break;
            case 15:
                zzw();
                break;
            case 16:
                zzbwz zzb = zzbwy.zzb(parcel.readStrongBinder());
                zzaye.zzc(parcel);
                zzt(zzb);
                break;
            case 17:
                int readInt2 = parcel.readInt();
                zzaye.zzc(parcel);
                zzj(readInt2);
                break;
            case 18:
                zzu();
                break;
            case 19:
                Bundle bundle = (Bundle) zzaye.zza(parcel, Bundle.CREATOR);
                zzaye.zzc(parcel);
                break;
            case 20:
                zzx();
                break;
            case 21:
                String readString3 = parcel.readString();
                zzaye.zzc(parcel);
                zzl(readString3);
                break;
            case 22:
                int readInt3 = parcel.readInt();
                String readString4 = parcel.readString();
                zzaye.zzc(parcel);
                zzi(readInt3, readString4);
                break;
            case 23:
                zzaye.zzc(parcel);
                zzh((zze) zzaye.zza(parcel, zze.CREATOR));
                break;
            case 24:
                zzaye.zzc(parcel);
                zzk((zze) zzaye.zza(parcel, zze.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
