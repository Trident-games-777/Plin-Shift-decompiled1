package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfrr {
    final zzfru zza;
    final boolean zzb;

    private zzfrr(zzfru zzfru) {
        this.zza = zzfru;
        this.zzb = zzfru != null;
    }

    public static zzfrr zzb(Context context, String str, String str2) {
        zzfru zzfru;
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
            IBinder iBinder = instantiate;
            if (instantiate == null) {
                zzfru = null;
            } else {
                IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                zzfru = queryLocalInterface instanceof zzfru ? (zzfru) queryLocalInterface : new zzfrs(instantiate);
            }
            try {
                zzfru zzfru2 = zzfru;
                zzfru.zze(ObjectWrapper.wrap(context), str, (String) null);
                Log.i("GASS", "GassClearcutLogger Initialized.");
                return new zzfrr(zzfru);
            } catch (RemoteException | zzfqt | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
                return new zzfrr(new zzfrv());
            }
        } catch (Exception e) {
            throw new zzfqt(e);
        } catch (Exception e2) {
            throw new zzfqt(e2);
        }
    }

    public static zzfrr zzc() {
        zzfrv zzfrv = new zzfrv();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfrr(zzfrv);
    }

    public final zzfrp zza(byte[] bArr) {
        return new zzfrp(this, bArr, (zzfrq) null);
    }
}
