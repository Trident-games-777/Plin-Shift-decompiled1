package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbei;
import com.google.android.gms.internal.ads.zzbew;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
abstract class zzbb {
    private static final zzcp zza;

    static {
        zzcp zzcp = null;
        try {
            Object newInstance = zzba.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzm.zzj("ClientApi class is not an instance of IBinder.");
            } else {
                IBinder iBinder = (IBinder) newInstance;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzcp = queryLocalInterface instanceof zzcp ? (zzcp) queryLocalInterface : new zzcn(iBinder);
                }
            }
        } catch (Exception unused) {
            zzm.zzj("Failed to instantiate ClientApi class.");
        }
        zza = zzcp;
    }

    zzbb() {
    }

    private final Object zze() {
        zzcp zzcp = zza;
        if (zzcp != null) {
            try {
                return zzb(zzcp);
            } catch (RemoteException e) {
                zzm.zzk("Cannot invoke local loader using ClientApi class.", e);
                return null;
            }
        } else {
            zzm.zzj("ClientApi class cannot be loaded.");
            return null;
        }
    }

    private final Object zzf() {
        try {
            return zzc();
        } catch (RemoteException e) {
            zzm.zzk("Cannot invoke remote loader.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza();

    /* access modifiers changed from: protected */
    public abstract Object zzb(zzcp zzcp) throws RemoteException;

    /* access modifiers changed from: protected */
    public abstract Object zzc() throws RemoteException;

    public final Object zzd(Context context, boolean z) {
        boolean z2;
        Object obj;
        if (!z) {
            zzbc.zzb();
            if (!zzf.zzt(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzm.zze("Google Play Services is not available.");
                z = true;
            }
        }
        boolean z3 = false;
        boolean z4 = !(DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) <= DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
        zzbcn.zza(context);
        if (((Boolean) zzbei.zza.zze()).booleanValue()) {
            z2 = false;
        } else if (((Boolean) zzbei.zzb.zze()).booleanValue()) {
            z2 = true;
            z3 = true;
        } else {
            z3 = z | z4;
            z2 = false;
        }
        if (z3) {
            obj = zze();
            if (obj == null && !z2) {
                obj = zzf();
            }
        } else {
            Object zzf = zzf();
            if (zzf == null) {
                if (zzbc.zze().nextInt(((Long) zzbew.zza.zze()).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    zzbc.zzb().zzo(context, zzbc.zzc().afmaVersion, "gmob-apps", bundle, true);
                }
            }
            obj = zzf == null ? zze() : zzf;
        }
        return obj == null ? zza() : obj;
    }
}
