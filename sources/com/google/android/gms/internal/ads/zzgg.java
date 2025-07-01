package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgg {
    private Uri zza;
    private Map zzb;
    private long zzc;
    private final long zzd;
    private int zze;

    public zzgg() {
        this.zzb = Collections.emptyMap();
        this.zzd = -1;
    }

    /* synthetic */ zzgg(zzgi zzgi, zzgh zzgh) {
        this.zza = zzgi.zza;
        this.zzb = zzgi.zzd;
        this.zzc = zzgi.zze;
        this.zzd = zzgi.zzf;
        this.zze = zzgi.zzg;
    }

    public final zzgg zza(int i) {
        this.zze = 6;
        return this;
    }

    public final zzgg zzb(Map map) {
        this.zzb = map;
        return this;
    }

    public final zzgg zzc(long j) {
        this.zzc = j;
        return this;
    }

    public final zzgg zzd(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzgi zze() {
        if (this.zza != null) {
            return new zzgi(this.zza, 0, 1, (byte[]) null, this.zzb, this.zzc, this.zzd, (String) null, this.zze, (Object) null, (zzgh) null);
        }
        throw new IllegalStateException("The uri must be set.");
    }
}
