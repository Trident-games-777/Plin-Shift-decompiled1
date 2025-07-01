package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfs implements Comparable {
    /* access modifiers changed from: private */
    public final zzed zza = new zzed();
    /* access modifiers changed from: private */
    public long zzb = -9223372036854775807L;
    private long zzc;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzfs zzfs = (zzfs) obj;
        int compare = Long.compare(this.zzb, zzfs.zzb);
        if (compare != 0) {
            return compare;
        }
        return Long.compare(this.zzc, zzfs.zzc);
    }

    public final void zzc(long j, long j2, zzed zzed) {
        zzdb.zzf(j != -9223372036854775807L);
        this.zzb = j;
        this.zzc = j2;
        this.zza.zzI(zzed.zzb());
        System.arraycopy(zzed.zzN(), zzed.zzd(), this.zza.zzN(), 0, zzed.zzb());
    }
}
