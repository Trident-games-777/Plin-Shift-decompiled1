package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhbg implements Iterator {
    final /* synthetic */ zzhbj zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzhbg(zzhbj zzhbj, zzhbi zzhbi) {
        this.zza = zzhbj;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzhbj zzhbj = this.zza;
        if (i >= zzhbj.zzb) {
            return !zzhbj.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzhbj zzhbj = this.zza;
        if (i < zzhbj.zzb) {
            return (zzhbf) zzhbj.zza[i];
        }
        return (Map.Entry) zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzo();
            int i = this.zzb;
            zzhbj zzhbj = this.zza;
            if (i < zzhbj.zzb) {
                this.zzb = i - 1;
                Object unused = zzhbj.zzm(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
