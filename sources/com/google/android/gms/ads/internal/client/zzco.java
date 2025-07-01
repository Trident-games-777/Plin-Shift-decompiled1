package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzaye;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbkp;
import com.google.android.gms.internal.ads.zzbkq;
import com.google.android.gms.internal.ads.zzbkt;
import com.google.android.gms.internal.ads.zzbpf;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbtg;
import com.google.android.gms.internal.ads.zzbwm;
import com.google.android.gms.internal.ads.zzbxc;
import com.google.android.gms.internal.ads.zzbzh;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzco extends zzayd implements zzcp {
    public zzco() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String readString = parcel.readString();
                zzbpg zzf = zzbpf.zzf(parcel.readStrongBinder());
                int readInt = parcel.readInt();
                zzaye.zzc(parcel);
                zzby zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzs) zzaye.zza(parcel, zzs.CREATOR), readString, zzf, readInt);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzd);
                return true;
            case 2:
                String readString2 = parcel.readString();
                zzbpg zzf2 = zzbpf.zzf(parcel.readStrongBinder());
                int readInt2 = parcel.readInt();
                zzaye.zzc(parcel);
                zzby zze = zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzs) zzaye.zza(parcel, zzs.CREATOR), readString2, zzf2, readInt2);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zze);
                return true;
            case 3:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString3 = parcel.readString();
                zzbpg zzf3 = zzbpf.zzf(parcel.readStrongBinder());
                int readInt3 = parcel.readInt();
                zzaye.zzc(parcel);
                zzbu zzb = zzb(asInterface, readString3, zzf3, readInt3);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzb);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaye.zzc(parcel);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, (IInterface) null);
                return true;
            case 5:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaye.zzc(parcel);
                zzbgc zzj = zzj(asInterface2, asInterface3);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzj);
                return true;
            case 6:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpg zzf4 = zzbpf.zzf(parcel.readStrongBinder());
                int readInt4 = parcel.readInt();
                zzaye.zzc(parcel);
                zzbwm zzo = zzo(asInterface4, zzf4, readInt4);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzo);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaye.zzc(parcel);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, (IInterface) null);
                return true;
            case 8:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaye.zzc(parcel);
                zzbtg zzn = zzn(asInterface5);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzn);
                return true;
            case 9:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int readInt5 = parcel.readInt();
                zzaye.zzc(parcel);
                zzcz zzh = zzh(asInterface6, readInt5);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzh);
                return true;
            case 10:
                String readString4 = parcel.readString();
                int readInt6 = parcel.readInt();
                zzaye.zzc(parcel);
                zzby zzf5 = zzf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzs) zzaye.zza(parcel, zzs.CREATOR), readString4, readInt6);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzf5);
                return true;
            case 11:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaye.zzc(parcel);
                zzbgi zzk = zzk(asInterface7, asInterface8, asInterface9);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzk);
                return true;
            case 12:
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString5 = parcel.readString();
                zzbpg zzf6 = zzbpf.zzf(parcel.readStrongBinder());
                int readInt7 = parcel.readInt();
                zzaye.zzc(parcel);
                zzbxc zzp = zzp(asInterface10, readString5, zzf6, readInt7);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzp);
                return true;
            case 13:
                String readString6 = parcel.readString();
                zzbpg zzf7 = zzbpf.zzf(parcel.readStrongBinder());
                int readInt8 = parcel.readInt();
                zzaye.zzc(parcel);
                zzby zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzs) zzaye.zza(parcel, zzs.CREATOR), readString6, zzf7, readInt8);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzc);
                return true;
            case 14:
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpg zzf8 = zzbpf.zzf(parcel.readStrongBinder());
                int readInt9 = parcel.readInt();
                zzaye.zzc(parcel);
                zzbzh zzq = zzq(asInterface11, zzf8, readInt9);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzq);
                return true;
            case 15:
                IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpg zzf9 = zzbpf.zzf(parcel.readStrongBinder());
                int readInt10 = parcel.readInt();
                zzaye.zzc(parcel);
                zzbsz zzm = zzm(asInterface12, zzf9, readInt10);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzm);
                return true;
            case 16:
                IObjectWrapper asInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpg zzf10 = zzbpf.zzf(parcel.readStrongBinder());
                int readInt11 = parcel.readInt();
                zzbkq zzc2 = zzbkp.zzc(parcel.readStrongBinder());
                zzaye.zzc(parcel);
                zzbkt zzl = zzl(asInterface13, zzf10, readInt11, zzc2);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzl);
                return true;
            case 17:
                IObjectWrapper asInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpg zzf11 = zzbpf.zzf(parcel.readStrongBinder());
                int readInt12 = parcel.readInt();
                zzaye.zzc(parcel);
                zzdu zzi = zzi(asInterface14, zzf11, readInt12);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzi);
                return true;
            case 18:
                IObjectWrapper asInterface15 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbpg zzf12 = zzbpf.zzf(parcel.readStrongBinder());
                int readInt13 = parcel.readInt();
                zzaye.zzc(parcel);
                zzci zzg = zzg(asInterface15, zzf12, readInt13);
                parcel2.writeNoException();
                zzaye.zzf(parcel2, zzg);
                return true;
            default:
                return false;
        }
    }
}
