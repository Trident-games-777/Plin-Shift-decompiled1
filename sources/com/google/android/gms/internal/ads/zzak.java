package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzak {
    private String zza;
    private Uri zzb;
    private final zzal zzc = new zzal();
    private final List zzd;
    private final zzfzo zze;
    private final zzap zzf;
    private final zzat zzg;

    public zzak() {
        zzfzo.zzn();
        this.zzd = Collections.emptyList();
        this.zze = zzfzo.zzn();
        this.zzf = new zzap();
        this.zzg = zzat.zza;
    }

    public final zzak zza(String str) {
        String str2 = str;
        this.zza = str;
        return this;
    }

    public final zzak zzb(Uri uri) {
        this.zzb = uri;
        return this;
    }

    public final zzaw zzc() {
        Uri uri = this.zzb;
        zzar zzar = uri != null ? new zzar(uri, (String) null, (zzao) null, (zzaj) null, this.zzd, (String) null, this.zze, (Object) null, -9223372036854775807L, (zzav) null) : null;
        String str = this.zza;
        if (str == null) {
            str = "";
        }
        return new zzaw(str, new zzan(this.zzc, (zzav) null), zzar, new zzaq(this.zzf, (zzav) null), zzba.zza, this.zzg, (zzav) null);
    }
}
