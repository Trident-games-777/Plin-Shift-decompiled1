package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
class zzfye extends AbstractCollection {
    final Object zza;
    Collection zzb;
    @CheckForNull
    final zzfye zzc;
    @CheckForNull
    final Collection zzd;
    final /* synthetic */ zzfyh zze;

    zzfye(zzfyh zzfyh, Object obj, @CheckForNull Collection collection, zzfye zzfye) {
        this.zze = zzfyh;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzfye;
        this.zzd = zzfye == null ? null : zzfye.zzb;
    }

    public final boolean add(Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(obj);
        if (add) {
            zzfyh zzfyh = this.zze;
            zzfyh.zzb = zzfyh.zzb + 1;
            if (isEmpty) {
                zza();
                return true;
            }
        }
        return add;
    }

    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzfyh zzfyh = this.zze;
        zzfyh.zzb = zzfyh.zzb + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final void clear() {
        int size = size();
        if (size != 0) {
            this.zzb.clear();
            zzfyh zzfyh = this.zze;
            zzfyh.zzb = zzfyh.zzb - size;
            zzc();
        }
    }

    public final boolean contains(@CheckForNull Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    public final boolean containsAll(Collection collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    public final Iterator iterator() {
        zzb();
        return new zzfyd(this);
    }

    public final boolean remove(@CheckForNull Object obj) {
        zzb();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzfyh zzfyh = this.zze;
            zzfyh.zzb = zzfyh.zzb - 1;
            zzc();
        }
        return remove;
    }

    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            int size2 = this.zzb.size();
            zzfyh zzfyh = this.zze;
            zzfyh.zzb = zzfyh.zzb + (size2 - size);
            zzc();
        }
        return removeAll;
    }

    public final int size() {
        zzb();
        return this.zzb.size();
    }

    public final String toString() {
        zzb();
        return this.zzb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        zzfye zzfye = this.zzc;
        if (zzfye != null) {
            zzfye.zza();
            return;
        }
        zzfyh zzfyh = this.zze;
        zzfyh.zza.put(this.zza, this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        zzfye zzfye = this.zzc;
        if (zzfye != null) {
            zzfye.zzb();
            zzfye zzfye2 = this.zzc;
            if (zzfye2.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
        } else if (this.zzb.isEmpty()) {
            zzfyh zzfyh = this.zze;
            Collection collection = (Collection) zzfyh.zza.get(this.zza);
            if (collection != null) {
                this.zzb = collection;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        zzfye zzfye = this.zzc;
        if (zzfye != null) {
            zzfye.zzc();
        } else if (this.zzb.isEmpty()) {
            zzfyh zzfyh = this.zze;
            zzfyh.zza.remove(this.zza);
        }
    }

    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            int size2 = this.zzb.size();
            zzfyh zzfyh = this.zze;
            zzfyh.zzb = zzfyh.zzb + (size2 - size);
            zzc();
        }
        return retainAll;
    }
}
