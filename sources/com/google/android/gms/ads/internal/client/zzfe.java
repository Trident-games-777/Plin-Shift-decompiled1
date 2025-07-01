package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzfe extends RemoteCreator {
    public zzfe() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        return queryLocalInterface instanceof zzda ? (zzda) queryLocalInterface : new zzda(iBinder);
    }

    public final zzcz zza(Context context) {
        try {
            IBinder zze = ((zzda) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), 243799000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            return queryLocalInterface instanceof zzcz ? (zzcz) queryLocalInterface : new zzcx(zze);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzm.zzk("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }
}
