package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzar {
    public final Uri zza;
    public final String zzb = null;
    public final zzao zzc = null;
    public final zzaj zzd = null;
    public final List zze;
    public final String zzf;
    public final zzfzo zzg;
    public final Object zzh;
    public final long zzi;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
    }

    /* synthetic */ zzar(Uri uri, String str, zzao zzao, zzaj zzaj, List list, String str2, zzfzo zzfzo, Object obj, long j, zzav zzav) {
        this.zza = uri;
        int i = zzbg.zza;
        this.zze = list;
        this.zzf = null;
        this.zzg = zzfzo;
        zzfzl zzfzl = new zzfzl();
        if (zzfzo.size() <= 0) {
            zzfzl.zzi();
            this.zzh = null;
            this.zzi = -9223372036854775807L;
            return;
        }
        zzau zzau = (zzau) zzfzo.get(0);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzar)) {
            return false;
        }
        zzar zzar = (zzar) obj;
        if (this.zza.equals(zzar.zza)) {
            String str = zzar.zzb;
            if (Objects.equals((Object) null, (Object) null)) {
                zzao zzao = zzar.zzc;
                if (Objects.equals((Object) null, (Object) null)) {
                    zzaj zzaj = zzar.zzd;
                    if (Objects.equals((Object) null, (Object) null) && this.zze.equals(zzar.zze)) {
                        String str2 = zzar.zzf;
                        if (Objects.equals((Object) null, (Object) null) && this.zzg.equals(zzar.zzg)) {
                            Object obj2 = zzar.zzh;
                            if (Objects.equals((Object) null, (Object) null)) {
                                long j = zzar.zzi;
                                if (Objects.equals(-9223372036854775807L, -9223372036854775807L)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) ((((long) (((((this.zza.hashCode() * 923521) + this.zze.hashCode()) * 961) + this.zzg.hashCode()) * 31)) * 31) - Long.MAX_VALUE);
    }
}
