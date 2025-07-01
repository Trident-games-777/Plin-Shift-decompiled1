package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbuj;
import com.google.android.gms.internal.ads.zzbul;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzk extends RemoteCreator {
    private zzbul zza;

    public zzk() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return queryLocalInterface instanceof zzbz ? (zzbz) queryLocalInterface : new zzbz(iBinder);
    }

    public final zzby zza(Context context, zzs zzs, String str, zzbpg zzbpg, int i) {
        zzbcn.zza(context);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzkp)).booleanValue()) {
            try {
                IBinder zze = ((zzbz) zzq.zzb(context, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", new zzj())).zze(ObjectWrapper.wrap(context), zzs, str, zzbpg, 243799000, i);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                return queryLocalInterface instanceof zzby ? (zzby) queryLocalInterface : new zzbw(zze);
            } catch (RemoteException | zzp | NullPointerException e) {
                Throwable th = e;
                zzbul zza2 = zzbuj.zza(context);
                this.zza = zza2;
                zza2.zzh(th, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzm.zzl("#007 Could not call remote method.", th);
                return null;
            }
        } else {
            try {
                IBinder zze2 = ((zzbz) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), zzs, str, zzbpg, 243799000, i);
                if (zze2 == null) {
                    return null;
                }
                IInterface queryLocalInterface2 = zze2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface2 instanceof zzby) {
                    return (zzby) queryLocalInterface2;
                }
                return new zzbw(zze2);
            } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
                zzm.zzf("Could not create remote AdManager.", e2);
                return null;
            }
        }
    }
}
