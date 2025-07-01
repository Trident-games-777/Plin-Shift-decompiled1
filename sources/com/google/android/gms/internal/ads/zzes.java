package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzes extends zzev {
    public final long zza;
    public final List zzb = new ArrayList();
    public final List zzc = new ArrayList();

    public zzes(int i, long j) {
        super(i, (zzeu) null);
        this.zza = j;
    }

    public final String toString() {
        List list = this.zzb;
        String zze = zze(this.zzd);
        String arrays = Arrays.toString(list.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        return zze + " leaves: " + arrays + " containers: " + arrays2;
    }

    public final zzes zza(int i) {
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzes zzes = (zzes) this.zzc.get(i2);
            if (zzes.zzd == i) {
                return zzes;
            }
        }
        return null;
    }

    public final zzet zzb(int i) {
        int size = this.zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzet zzet = (zzet) this.zzb.get(i2);
            if (zzet.zzd == i) {
                return zzet;
            }
        }
        return null;
    }

    public final void zzc(zzes zzes) {
        this.zzc.add(zzes);
    }

    public final void zzd(zzet zzet) {
        this.zzb.add(zzet);
    }
}
