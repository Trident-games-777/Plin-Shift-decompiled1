package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@JvmInline
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0001\u0004¨\u0006 "}, d2 = {"Landroidx/compose/runtime/MutableScatterMultiMap;", "K", "V", "", "map", "Landroidx/collection/MutableScatterMap;", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "equals", "", "other", "equals-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/collection/MutableScatterMap;)I", "pop", "key", "pop-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "put", "", "value", "put-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "toString", "", "toString-impl", "(Landroidx/collection/MutableScatterMap;)Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
final class MutableScatterMultiMap<K, V> {
    private final MutableScatterMap<K, Object> map;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ MutableScatterMultiMap m3655boximpl(MutableScatterMap mutableScatterMap) {
        return new MutableScatterMultiMap(mutableScatterMap);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <K, V> MutableScatterMap<K, Object> m3656constructorimpl(MutableScatterMap<K, Object> mutableScatterMap) {
        return mutableScatterMap;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3657equalsimpl(MutableScatterMap<K, Object> mutableScatterMap, Object obj) {
        return (obj instanceof MutableScatterMultiMap) && Intrinsics.areEqual((Object) mutableScatterMap, (Object) ((MutableScatterMultiMap) obj).m3663unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3658equalsimpl0(MutableScatterMap<K, Object> mutableScatterMap, MutableScatterMap<K, Object> mutableScatterMap2) {
        return Intrinsics.areEqual((Object) mutableScatterMap, (Object) mutableScatterMap2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3659hashCodeimpl(MutableScatterMap<K, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3662toStringimpl(MutableScatterMap<K, Object> mutableScatterMap) {
        return "MutableScatterMultiMap(map=" + mutableScatterMap + ')';
    }

    public boolean equals(Object obj) {
        return m3657equalsimpl(this.map, obj);
    }

    public int hashCode() {
        return m3659hashCodeimpl(this.map);
    }

    public String toString() {
        return m3662toStringimpl(this.map);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ MutableScatterMap m3663unboximpl() {
        return this.map;
    }

    private /* synthetic */ MutableScatterMultiMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    public final MutableScatterMap<K, Object> getMap() {
        return this.map;
    }

    /* renamed from: pop-impl  reason: not valid java name */
    public static final V m3660popimpl(MutableScatterMap<K, Object> mutableScatterMap, K k) {
        V v = mutableScatterMap.get(k);
        if (v == null) {
            return null;
        }
        if (TypeIntrinsics.isMutableList(v)) {
            List asMutableList = TypeIntrinsics.asMutableList(v);
            V remove = asMutableList.remove(0);
            if (asMutableList.isEmpty()) {
                mutableScatterMap.remove(k);
            }
            v = remove;
        } else {
            mutableScatterMap.remove(k);
        }
        Intrinsics.checkNotNull(v, "null cannot be cast to non-null type V of androidx.compose.runtime.MutableScatterMultiMap.pop_impl$lambda$1");
        return v;
    }

    /* renamed from: put-impl  reason: not valid java name */
    public static final void m3661putimpl(MutableScatterMap<K, Object> mutableScatterMap, K k, V v) {
        Object obj;
        int findInsertIndex = mutableScatterMap.findInsertIndex(k);
        boolean z = findInsertIndex < 0;
        if (z) {
            obj = null;
        } else {
            obj = mutableScatterMap.values[findInsertIndex];
        }
        if (obj != null) {
            if (TypeIntrinsics.isMutableList(obj)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableList<V of androidx.compose.runtime.MutableScatterMultiMap.put_impl$lambda$0>");
                V asMutableList = TypeIntrinsics.asMutableList(obj);
                asMutableList.add(v);
                v = asMutableList;
            } else {
                v = CollectionsKt.mutableListOf(obj, v);
            }
        }
        if (z) {
            int i = ~findInsertIndex;
            mutableScatterMap.keys[i] = k;
            mutableScatterMap.values[i] = v;
            return;
        }
        mutableScatterMap.values[findInsertIndex] = v;
    }
}
