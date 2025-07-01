package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfyf extends zzfyd implements ListIterator {
    final /* synthetic */ zzfyg zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfyf(zzfyg zzfyg) {
        super(zzfyg);
        this.zzd = zzfyg;
    }

    public final void add(Object obj) {
        boolean isEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzfyh zzfyh = this.zzd.zzf;
        zzfyh.zzb = zzfyh.zzb + 1;
        if (isEmpty) {
            this.zzd.zza();
        }
    }

    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfyf(zzfyg zzfyg, int i) {
        super(zzfyg, ((List) zzfyg.zzb).listIterator(i));
        this.zzd = zzfyg;
    }
}
