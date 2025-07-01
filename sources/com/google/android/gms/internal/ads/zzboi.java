package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbc;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzboi {
    static final zzbc zza = new zzbog();
    static final zzbc zzb = new zzboh();
    private final zzbnu zzc;

    public zzboi(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable zzfko zzfko) {
        this.zzc = new zzbnu(context, versionInfoParcel, str, zza, zzb, zzfko);
    }

    public final zzbny zza(String str, zzbob zzbob, zzboa zzboa) {
        return new zzbom(this.zzc, str, zzbob, zzboa);
    }

    public final zzbor zzb() {
        return new zzbor(this.zzc);
    }
}
