package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzn;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcfx {
    public static final zzcfk zza(Context context, zzche zzche, String str, boolean z, boolean z2, zzavc zzavc, zzbdu zzbdu, VersionInfoParcel versionInfoParcel, zzbdc zzbdc, zzn zzn, zza zza, zzbbl zzbbl, zzfet zzfet, zzfew zzfew, zzeea zzeea, zzffs zzffs) throws zzcfw {
        StrictMode.ThreadPolicy threadPolicy;
        zzbcn.zza(context);
        try {
            zzcft zzcft = new zzcft(context, zzche, str, z, z2, zzavc, zzbdu, versionInfoParcel, (zzbdc) null, zzn, zza, zzbbl, zzfet, zzfew, zzffs, zzeea);
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            Object zza2 = zzcft.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return (zzcfk) zza2;
        } catch (Throwable th) {
            throw new zzcfw("Webview initialization failed.", th);
        }
    }
}
