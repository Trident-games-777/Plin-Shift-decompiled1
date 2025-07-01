package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u000f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J9\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\b¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b0\u001aJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ9\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\u0015H\b¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010%J.\u0010&\u001a\u00020\u000e2#\b\u0004\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\bJ\u001b\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006*"}, d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", "Key", "", "Scope", "()V", "map", "Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize", "()I", "add", "", "key", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)V", "anyScopeOf", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "asMap", "", "", "clear", "contains", "element", "(Ljava/lang/Object;)Z", "forEachScopeOf", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScope", "(Ljava/lang/Object;)V", "removeScopeIf", "predicate", "set", "value", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScopeMap.kt */
public final class ScopeMap<Key, Scope> {
    public static final int $stable = 8;
    private final MutableScatterMap<Object, Object> map = ScatterMapKt.mutableScatterMapOf();

    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    public final int getSize() {
        return this.map.getSize();
    }

    public final void add(Key key, Scope scope) {
        Scope scope2;
        MutableScatterMap<Object, Object> mutableScatterMap = this.map;
        int findInsertIndex = mutableScatterMap.findInsertIndex(key);
        boolean z = findInsertIndex < 0;
        if (z) {
            scope2 = null;
        } else {
            scope2 = mutableScatterMap.values[findInsertIndex];
        }
        if (scope2 != null) {
            if (scope2 instanceof MutableScatterSet) {
                Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0>");
                ((MutableScatterSet) scope2).add(scope);
            } else if (scope2 != scope) {
                Scope mutableScatterSet = new MutableScatterSet(0, 1, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0");
                mutableScatterSet.add(scope2);
                mutableScatterSet.add(scope);
                scope = mutableScatterSet;
            }
            scope = scope2;
        }
        if (z) {
            int i = ~findInsertIndex;
            mutableScatterMap.keys[i] = key;
            mutableScatterMap.values[i] = scope;
            return;
        }
        mutableScatterMap.values[findInsertIndex] = scope;
    }

    public final void set(Key key, Scope scope) {
        this.map.set(key, scope);
    }

    public final boolean contains(Key key) {
        return this.map.containsKey(key);
    }

    public final void forEachScopeOf(Key key, Function1<? super Scope, Unit> function1) {
        Object obj = getMap().get(key);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            ScatterSet scatterSet = (MutableScatterSet) obj;
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                function1.invoke(objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            return;
                        }
                    }
                    if (i != length) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        } else {
            function1.invoke(obj);
        }
    }

    public final void clear() {
        this.map.clear();
    }

    public final boolean remove(Key key, Scope scope) {
        Object obj = this.map.get(key);
        if (obj == null) {
            return false;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            boolean remove = mutableScatterSet.remove(scope);
            if (remove && mutableScatterSet.isEmpty()) {
                this.map.remove(key);
            }
            return remove;
        } else if (!Intrinsics.areEqual(obj, (Object) scope)) {
            return false;
        } else {
            this.map.remove(key);
            return true;
        }
    }

    public final void removeScopeIf(Function1<? super Scope, Boolean> function1) {
        long[] jArr;
        long[] jArr2;
        long j;
        long j2;
        char c;
        int i;
        boolean z;
        MutableScatterSet mutableScatterSet;
        long[] jArr3;
        int i2;
        MutableScatterSet mutableScatterSet2;
        Function1<? super Scope, Boolean> function12 = function1;
        MutableScatterMap<Object, Object> map2 = getMap();
        long[] jArr4 = map2.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j3 = jArr4[i3];
                char c2 = 7;
                long j4 = -9187201950435737472L;
                if ((((~j3) << 7) & j3 & -9187201950435737472L) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j3 & 255) < 128) {
                            int i7 = (i3 << 3) + i6;
                            c = c2;
                            Object obj = map2.keys[i7];
                            Object obj2 = map2.values[i7];
                            j2 = j4;
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet3.elements;
                                long[] jArr5 = mutableScatterSet3.metadata;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    int i8 = i4;
                                    MutableScatterSet mutableScatterSet4 = mutableScatterSet3;
                                    int i9 = 0;
                                    while (true) {
                                        long j5 = jArr5[i9];
                                        j = j3;
                                        if ((((~j5) << c) & j5 & j2) != j2) {
                                            int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                            int i11 = 0;
                                            while (i11 < i10) {
                                                if ((j5 & 255) < 128) {
                                                    jArr3 = jArr4;
                                                    int i12 = (i9 << 3) + i11;
                                                    i2 = i11;
                                                    if (function12.invoke(objArr[i12]).booleanValue()) {
                                                        mutableScatterSet2 = mutableScatterSet4;
                                                        mutableScatterSet2.removeElementAt(i12);
                                                        j5 >>= i8;
                                                        mutableScatterSet4 = mutableScatterSet2;
                                                        i11 = i2 + 1;
                                                        jArr4 = jArr3;
                                                    }
                                                } else {
                                                    jArr3 = jArr4;
                                                    i2 = i11;
                                                }
                                                mutableScatterSet2 = mutableScatterSet4;
                                                j5 >>= i8;
                                                mutableScatterSet4 = mutableScatterSet2;
                                                i11 = i2 + 1;
                                                jArr4 = jArr3;
                                            }
                                            jArr2 = jArr4;
                                            mutableScatterSet = mutableScatterSet4;
                                            if (i10 != i8) {
                                                break;
                                            }
                                        } else {
                                            jArr2 = jArr4;
                                            mutableScatterSet = mutableScatterSet4;
                                        }
                                        if (i9 == length2) {
                                            break;
                                        }
                                        i9++;
                                        mutableScatterSet4 = mutableScatterSet;
                                        j3 = j;
                                        jArr4 = jArr2;
                                        i8 = 8;
                                    }
                                } else {
                                    jArr2 = jArr4;
                                    j = j3;
                                    mutableScatterSet = mutableScatterSet3;
                                }
                                z = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr4;
                                j = j3;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                z = function12.invoke(obj2).booleanValue();
                            }
                            if (z) {
                                map2.removeValueAt(i7);
                            }
                            i = 8;
                        } else {
                            jArr2 = jArr4;
                            j = j3;
                            c = c2;
                            j2 = j4;
                            i = i4;
                        }
                        j3 = j >> i;
                        i6++;
                        i4 = i;
                        c2 = c;
                        j4 = j2;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    if (i5 != i4) {
                        return;
                    }
                } else {
                    jArr = jArr4;
                }
                if (i3 != length) {
                    i3++;
                    jArr4 = jArr;
                } else {
                    return;
                }
            }
        }
    }

    public final void removeScope(Scope scope) {
        boolean z;
        MutableScatterMap<Object, Object> mutableScatterMap = this.map;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj = mutableScatterMap.keys[i4];
                            Scope scope2 = mutableScatterMap.values[i4];
                            if (scope2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScope$lambda$3>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) scope2;
                                mutableScatterSet.remove(scope);
                                z = mutableScatterSet.isEmpty();
                            } else {
                                z = scope2 == scope;
                            }
                            if (z) {
                                mutableScatterMap.removeValueAt(i4);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final Map<Key, Set<Scope>> asMap() {
        Set set;
        HashMap hashMap = new HashMap();
        ScatterMap scatterMap = this.map;
        Object[] objArr = scatterMap.keys;
        Object[] objArr2 = scatterMap.values;
        long[] jArr = scatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj = objArr[i4];
                            Object obj2 = objArr2[i4];
                            Map map2 = hashMap;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4");
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4>");
                                set = ((MutableScatterSet) obj2).asSet();
                            } else {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4");
                                set = SetsKt.mutableSetOf(obj2);
                            }
                            map2.put(obj, set);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return hashMap;
    }

    public final boolean anyScopeOf(Key key, Function1<? super Scope, Boolean> function1) {
        Function1<? super Scope, Boolean> function12 = function1;
        Object obj = getMap().get(key);
        if (obj != null) {
            if (obj instanceof MutableScatterSet) {
                ScatterSet scatterSet = (MutableScatterSet) obj;
                Object[] objArr = scatterSet.elements;
                long[] jArr = scatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128 && function12.invoke(objArr[(i << 3) + i3]).booleanValue()) {
                                    return true;
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            }
                        }
                        if (i == length) {
                            break;
                        }
                        i++;
                    }
                }
            } else if (function12.invoke(obj).booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
