package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbsm extends NativeAd.AdChoicesInfo {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbsm(zzbfr zzbfr) {
        try {
            this.zzb = zzbfr.zzg();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            this.zzb = "";
        }
        try {
            for (Object next : zzbfr.zzh()) {
                zzbfy zzg = next instanceof IBinder ? zzbfx.zzg((IBinder) next) : null;
                if (zzg != null) {
                    this.zza.add(new zzbso(zzg));
                }
            }
        } catch (RemoteException e2) {
            zzm.zzh("", e2);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    public final CharSequence getText() {
        return this.zzb;
    }
}
