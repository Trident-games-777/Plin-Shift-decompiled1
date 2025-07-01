package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
class zzfyg extends zzfye implements List {
    final /* synthetic */ zzfyh zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfyg(zzfyh zzfyh, Object obj, @CheckForNull List list, zzfye zzfye) {
        super(zzfyh, obj, list, zzfye);
        this.zzf = zzfyh;
    }

    public final void add(int i, Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, obj);
        zzfyh zzfyh = this.zzf;
        zzfyh.zzb = zzfyh.zzb + 1;
        if (isEmpty) {
            zza();
        }
    }

    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i, collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzfyh zzfyh = this.zzf;
        zzfyh.zzb = zzfyh.zzb + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final Object get(int i) {
        zzb();
        return ((List) this.zzb).get(i);
    }

    public final int indexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    public final ListIterator listIterator() {
        zzb();
        return new zzfyf(this);
    }

    public final Object remove(int i) {
        zzb();
        Object remove = ((List) this.zzb).remove(i);
        zzfyh zzfyh = this.zzf;
        zzfyh.zzb = zzfyh.zzb - 1;
        zzc();
        return remove;
    }

    public final Object set(int i, Object obj) {
        zzb();
        return ((List) this.zzb).set(i, obj);
    }

    public final List subList(int i, int i2) {
        zzb();
        List subList = ((List) this.zzb).subList(i, i2);
        zzfye zzfye = this.zzc;
        if (zzfye == null) {
            zzfye = this;
        }
        return this.zzf.zzh(this.zza, subList, zzfye);
    }

    public final ListIterator listIterator(int i) {
        zzb();
        return new zzfyf(this, i);
    }
}
