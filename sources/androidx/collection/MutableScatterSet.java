package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u00011B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rJ\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u001b\u0010\u000b\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010J\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016J\u0006\u0010\u0017\u001a\u00020\u0013J\r\u0010\u0018\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0019J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010\"\u001a\u00020\u00132\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010#J\u0017\u0010\"\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002J\u0017\u0010\"\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002J\u001e\u0010\"\u001a\u00020\u00132\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0002\u0010$J\u0017\u0010\"\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0002J\u0017\u0010\"\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0002J\u0016\u0010%\u001a\u00020\u00132\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010#J\u0017\u0010%\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002J\u0017\u0010%\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002J\u001e\u0010%\u001a\u00020\u00132\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0002\u0010$J\u0017\u0010%\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0002J\u0017\u0010%\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0002J\u0013\u0010&\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010'\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rJ\u0014\u0010'\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u001b\u0010'\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e¢\u0006\u0002\u0010\u000fJ\u0014\u0010'\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010J\u0014\u0010'\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0004H\u0001J \u0010*\u001a\u00020\u00132\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0,H\bø\u0001\u0000J\u0015\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0004H\u0000¢\u0006\u0002\b/J\b\u00100\u001a\u00020\u0004H\u0007R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u00062"}, d2 = {"Landroidx/collection/MutableScatterSet;", "E", "Landroidx/collection/ScatterSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "Landroidx/collection/ObjectList;", "", "([Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "adjustStorage", "", "adjustStorage$collection", "asMutableSet", "", "clear", "dropDeletes", "dropDeletes$collection", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeElementAt", "index", "removeIf", "predicate", "Lkotlin/Function1;", "resizeStorage", "newCapacity", "resizeStorage$collection", "trim", "MutableSetWrapper", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScatterSet.kt */
public final class MutableScatterSet<E> extends ScatterSet<E> {
    private int growthLimit;

    public MutableScatterSet() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public MutableScatterSet(int i) {
        super((DefaultConstructorMarker) null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableScatterSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    private final void initializeStorage(int i) {
        int max = i > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i)) : 0;
        this._capacity = max;
        initializeMetadata(max);
        this.elements = new Object[max];
    }

    private final void initializeMetadata(int i) {
        long[] jArr;
        if (i == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            long[] jArr2 = new long[(((i + 15) & -8) >> 3)];
            ArraysKt.fill$default(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.metadata = jArr;
        long[] jArr3 = this.metadata;
        int i2 = i >> 3;
        long j = 255 << ((i & 7) << 3);
        jArr3[i2] = (jArr3[i2] & (~j)) | j;
        initializeGrowth();
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    public final boolean add(E e) {
        int size = getSize();
        this.elements[findAbsoluteInsertIndex(e)] = e;
        return getSize() != size;
    }

    public final void plusAssign(E e) {
        this.elements[findAbsoluteInsertIndex(e)] = e;
    }

    public final boolean addAll(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        int size = getSize();
        plusAssign(eArr);
        return size != getSize();
    }

    public final boolean addAll(Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "elements");
        int size = getSize();
        plusAssign(iterable);
        return size != getSize();
    }

    public final boolean addAll(Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "elements");
        int size = getSize();
        plusAssign(sequence);
        return size != getSize();
    }

    public final boolean addAll(ScatterSet<E> scatterSet) {
        Intrinsics.checkNotNullParameter(scatterSet, "elements");
        int size = getSize();
        plusAssign(scatterSet);
        return size != getSize();
    }

    public final boolean addAll(ObjectList<E> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "elements");
        int size = getSize();
        plusAssign(objectList);
        return size != getSize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0070, code lost:
        if (((r8 & ((~r8) << 6)) & -9187201950435737472L) == 0) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0072, code lost:
        r12 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(E r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r0
            androidx.collection.ScatterSet r2 = (androidx.collection.ScatterSet) r2
            if (r1 == 0) goto L_0x000e
            int r4 = r1.hashCode()
            goto L_0x000f
        L_0x000e:
            r4 = 0
        L_0x000f:
            r5 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r4 = r4 * r5
            int r5 = r4 << 16
            r4 = r4 ^ r5
            r5 = r4 & 127(0x7f, float:1.78E-43)
            int r6 = r2._capacity
            int r4 = r4 >>> 7
            r4 = r4 & r6
            r7 = 0
        L_0x001e:
            long[] r8 = r2.metadata
            int r9 = r4 >> 3
            r10 = r4 & 7
            int r10 = r10 << 3
            r11 = r8[r9]
            long r11 = r11 >>> r10
            r13 = 1
            int r9 = r9 + r13
            r8 = r8[r9]
            int r14 = 64 - r10
            long r8 = r8 << r14
            long r14 = (long) r10
            long r14 = -r14
            r10 = 63
            long r14 = r14 >> r10
            long r8 = r8 & r14
            long r8 = r8 | r11
            long r10 = (long) r5
            r14 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r10 = r10 * r14
            long r10 = r10 ^ r8
            long r14 = r10 - r14
            long r10 = ~r10
            long r10 = r10 & r14
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r14
        L_0x0049:
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 == 0) goto L_0x0069
            int r12 = java.lang.Long.numberOfTrailingZeros(r10)
            int r12 = r12 >> 3
            int r12 = r12 + r4
            r12 = r12 & r6
            java.lang.Object[] r3 = r2.elements
            r3 = r3[r12]
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x0062
            goto L_0x0073
        L_0x0062:
            r16 = 1
            long r16 = r10 - r16
            long r10 = r10 & r16
            goto L_0x0049
        L_0x0069:
            long r10 = ~r8
            r3 = 6
            long r10 = r10 << r3
            long r8 = r8 & r10
            long r8 = r8 & r14
            int r3 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r3 == 0) goto L_0x007e
            r12 = -1
        L_0x0073:
            if (r12 < 0) goto L_0x0077
            r3 = r13
            goto L_0x0078
        L_0x0077:
            r3 = 0
        L_0x0078:
            if (r3 == 0) goto L_0x007d
            r0.removeElementAt(r12)
        L_0x007d:
            return r3
        L_0x007e:
            int r7 = r7 + 8
            int r4 = r4 + r7
            r4 = r4 & r6
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.remove(java.lang.Object):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006b, code lost:
        if (((r5 & ((~r5) << 6)) & -9187201950435737472L) == 0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006d, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void minusAssign(E r15) {
        /*
            r14 = this;
            r0 = r14
            androidx.collection.ScatterSet r0 = (androidx.collection.ScatterSet) r0
            r1 = 0
            if (r15 == 0) goto L_0x000b
            int r2 = r15.hashCode()
            goto L_0x000c
        L_0x000b:
            r2 = r1
        L_0x000c:
            r3 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r2 = r2 * r3
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r0._capacity
            int r2 = r2 >>> 7
        L_0x0019:
            r2 = r2 & r4
            long[] r5 = r0.metadata
            int r6 = r2 >> 3
            r7 = r2 & 7
            int r7 = r7 << 3
            r8 = r5[r6]
            long r8 = r8 >>> r7
            int r6 = r6 + 1
            r5 = r5[r6]
            int r10 = 64 - r7
            long r5 = r5 << r10
            long r10 = (long) r7
            long r10 = -r10
            r7 = 63
            long r10 = r10 >> r7
            long r5 = r5 & r10
            long r5 = r5 | r8
            long r7 = (long) r3
            r9 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r7 = r7 * r9
            long r7 = r7 ^ r5
            long r9 = r7 - r9
            long r7 = ~r7
            long r7 = r7 & r9
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
        L_0x0045:
            r11 = 0
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0064
            int r11 = java.lang.Long.numberOfTrailingZeros(r7)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            java.lang.Object[] r12 = r0.elements
            r12 = r12[r11]
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r15)
            if (r12 == 0) goto L_0x005e
            goto L_0x006e
        L_0x005e:
            r11 = 1
            long r11 = r7 - r11
            long r7 = r7 & r11
            goto L_0x0045
        L_0x0064:
            long r7 = ~r5
            r13 = 6
            long r7 = r7 << r13
            long r5 = r5 & r7
            long r5 = r5 & r9
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0074
            r11 = -1
        L_0x006e:
            if (r11 < 0) goto L_0x0073
            r14.removeElementAt(r11)
        L_0x0073:
            return
        L_0x0074:
            int r1 = r1 + 8
            int r2 = r2 + r1
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.minusAssign(java.lang.Object):void");
    }

    public final boolean removeAll(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        int size = getSize();
        minusAssign(eArr);
        return size != getSize();
    }

    public final boolean removeAll(Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "elements");
        int size = getSize();
        minusAssign(sequence);
        return size != getSize();
    }

    public final boolean removeAll(Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "elements");
        int size = getSize();
        minusAssign(iterable);
        return size != getSize();
    }

    public final boolean removeAll(ScatterSet<E> scatterSet) {
        Intrinsics.checkNotNullParameter(scatterSet, "elements");
        int size = getSize();
        minusAssign(scatterSet);
        return size != getSize();
    }

    public final boolean removeAll(ObjectList<E> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "elements");
        int size = getSize();
        minusAssign(objectList);
        return size != getSize();
    }

    public final void removeIf(Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
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
                            if (function1.invoke(objArr[i4]).booleanValue()) {
                                removeElementAt(i4);
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

    public final void removeElementAt(int i) {
        this._size--;
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
        this.elements[i] = null;
    }

    public final void clear() {
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr = this.metadata;
            int i = this._capacity;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr[i2] = (jArr[i2] & (~j)) | j;
        }
        ArraysKt.fill((T[]) this.elements, null, 0, this._capacity);
        initializeGrowth();
    }

    private final int findFirstAvailableSlot(int i) {
        int i2 = this._capacity;
        int i3 = i & i2;
        int i4 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i5 = i3 >> 3;
            int i6 = (i3 & 7) << 3;
            long j = ((jArr[i5 + 1] << (64 - i6)) & ((-((long) i6)) >> 63)) | (jArr[i5] >>> i6);
            long j2 = j & ((~j) << 7) & -9187201950435737472L;
            if (j2 != 0) {
                return (i3 + (Long.numberOfTrailingZeros(j2) >> 3)) & i2;
            }
            i4 += 8;
            i3 = (i3 + i4) & i2;
        }
    }

    public final int trim() {
        int i = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity >= i) {
            return 0;
        }
        resizeStorage$collection(normalizeCapacity);
        return i - this._capacity;
    }

    public final void adjustStorage$collection() {
        if (this._capacity <= 8 || Long.compareUnsigned(ULong.m7997constructorimpl(ULong.m7997constructorimpl((long) this._size) * 32), ULong.m7997constructorimpl(ULong.m7997constructorimpl((long) this._capacity) * 25)) > 0) {
            resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            dropDeletes$collection();
        }
    }

    public final void dropDeletes$collection() {
        int i;
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        Object[] objArr = this.elements;
        ScatterMapKt.convertMetadataForCleanup(jArr, i2);
        int i3 = -1;
        int i4 = 0;
        while (i4 != i2) {
            int i5 = i4 >> 3;
            int i6 = (i4 & 7) << 3;
            long j = (jArr[i5] >> i6) & 255;
            if (j == 128) {
                i3 = i4;
                i4++;
            } else {
                if (j == 254) {
                    Object obj = objArr[i4];
                    if (obj != null) {
                        i = obj.hashCode();
                    } else {
                        i = 0;
                    }
                    int i7 = i * ScatterMapKt.MurmurHashC1;
                    int i8 = i7 ^ (i7 << 16);
                    int i9 = i8 >>> 7;
                    int findFirstAvailableSlot = findFirstAvailableSlot(i9);
                    int i10 = i9 & i2;
                    if (((findFirstAvailableSlot - i10) & i2) / 8 == ((i4 - i10) & i2) / 8) {
                        jArr[i5] = (((long) (i8 & 127)) << i6) | ((~(255 << i6)) & jArr[i5]);
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i11 = findFirstAvailableSlot >> 3;
                        long j2 = jArr[i11];
                        int i12 = (findFirstAvailableSlot & 7) << 3;
                        if (((j2 >> i12) & 255) == 128) {
                            jArr[i11] = (((long) (i8 & 127)) << i12) | (j2 & (~(255 << i12)));
                            jArr[i5] = (jArr[i5] & (~(255 << i6))) | (128 << i6);
                            objArr[findFirstAvailableSlot] = objArr[i4];
                            objArr[i4] = null;
                            i3 = i4;
                        } else {
                            jArr[i11] = (((long) (i8 & 127)) << i12) | (j2 & (~(255 << i12)));
                            if (i3 == -1) {
                                i3 = ScatterMapKt.findEmptySlot(jArr, i4 + 1, i2);
                            }
                            objArr[i3] = objArr[findFirstAvailableSlot];
                            objArr[findFirstAvailableSlot] = objArr[i4];
                            objArr[i4] = objArr[i3];
                            i4--;
                        }
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                    }
                }
                i4++;
            }
        }
        initializeGrowth();
    }

    public final void resizeStorage$collection(int i) {
        int i2;
        long[] jArr = this.metadata;
        Object[] objArr = this.elements;
        int i3 = this._capacity;
        initializeStorage(i);
        long[] jArr2 = this.metadata;
        Object[] objArr2 = this.elements;
        int i4 = this._capacity;
        for (int i5 = 0; i5 < i3; i5++) {
            if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i5];
                if (obj != null) {
                    i2 = obj.hashCode();
                } else {
                    i2 = 0;
                }
                int i6 = i2 * ScatterMapKt.MurmurHashC1;
                int i7 = i6 ^ (i6 << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i7 >>> 7);
                long j = (long) (i7 & 127);
                int i8 = findFirstAvailableSlot >> 3;
                int i9 = (findFirstAvailableSlot & 7) << 3;
                long j2 = (jArr2[i8] & (~(255 << i9))) | (j << i9);
                jArr2[i8] = j2;
                jArr2[(((findFirstAvailableSlot - 7) & i4) + (i4 & 7)) >> 3] = j2;
                objArr2[findFirstAvailableSlot] = obj;
            }
        }
    }

    public final Set<E> asMutableSet() {
        return new MutableSetWrapper();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\b\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002J\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0016\u0010\u0011\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u0016\u0010\u0012\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¨\u0006\u0013"}, d2 = {"Landroidx/collection/MutableScatterSet$MutableSetWrapper;", "Landroidx/collection/ScatterSet$SetWrapper;", "Landroidx/collection/ScatterSet;", "", "(Landroidx/collection/MutableScatterSet;)V", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "iterator", "", "remove", "removeAll", "retainAll", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ScatterSet.kt */
    private final class MutableSetWrapper extends ScatterSet<E>.SetWrapper implements Set<E>, KMutableSet {
        public MutableSetWrapper() {
            super();
        }

        public boolean add(E e) {
            return MutableScatterSet.this.add(e);
        }

        public boolean addAll(Collection<? extends E> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return MutableScatterSet.this.addAll(collection);
        }

        public void clear() {
            MutableScatterSet.this.clear();
        }

        public Iterator<E> iterator() {
            return new MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet.this);
        }

        public boolean remove(Object obj) {
            return MutableScatterSet.this.remove(obj);
        }

        public boolean retainAll(Collection<? extends Object> collection) {
            Collection<? extends Object> collection2 = collection;
            Intrinsics.checkNotNullParameter(collection2, "elements");
            MutableScatterSet<E> mutableScatterSet = MutableScatterSet.this;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return false;
            }
            int i = 0;
            boolean z = false;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (!collection2.contains(mutableScatterSet.elements[i4])) {
                                mutableScatterSet.removeElementAt(i4);
                                z = true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return z;
                    }
                }
                if (i == length) {
                    return z;
                }
                i++;
            }
        }

        public boolean removeAll(Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            int size = MutableScatterSet.this.getSize();
            for (Object minusAssign : collection) {
                MutableScatterSet.this.minusAssign(minusAssign);
            }
            return size != MutableScatterSet.this.getSize();
        }
    }

    public final void plusAssign(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        for (E plusAssign : eArr) {
            plusAssign(plusAssign);
        }
    }

    public final void plusAssign(Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "elements");
        for (Object plusAssign : iterable) {
            plusAssign(plusAssign);
        }
    }

    public final void plusAssign(Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "elements");
        for (Object plusAssign : sequence) {
            plusAssign(plusAssign);
        }
    }

    public final void plusAssign(ScatterSet<E> scatterSet) {
        Intrinsics.checkNotNullParameter(scatterSet, "elements");
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
                            plusAssign(objArr[(i << 3) + i3]);
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

    public final void plusAssign(ObjectList<E> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "elements");
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            plusAssign(objArr[i2]);
        }
    }

    public final void minusAssign(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        for (E minusAssign : eArr) {
            minusAssign(minusAssign);
        }
    }

    public final void minusAssign(Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "elements");
        for (Object minusAssign : sequence) {
            minusAssign(minusAssign);
        }
    }

    public final void minusAssign(Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "elements");
        for (Object minusAssign : iterable) {
            minusAssign(minusAssign);
        }
    }

    public final void minusAssign(ScatterSet<E> scatterSet) {
        Intrinsics.checkNotNullParameter(scatterSet, "elements");
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
                            minusAssign(objArr[(i << 3) + i3]);
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

    public final void minusAssign(ObjectList<E> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "elements");
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            minusAssign(objArr[i2]);
        }
    }

    private final int findAbsoluteInsertIndex(E e) {
        int i;
        E e2 = e;
        if (e2 != null) {
            i = e2.hashCode();
        } else {
            i = 0;
        }
        int i2 = i * ScatterMapKt.MurmurHashC1;
        int i3 = i2 ^ (i2 << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this._capacity;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j = ((jArr[i9 + 1] << (64 - i10)) & ((-((long) i10)) >> 63)) | (jArr[i9] >>> i10);
            long j2 = (long) i5;
            int i11 = i5;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j4 != 0; j4 &= j4 - 1) {
                int numberOfTrailingZeros = (i7 + (Long.numberOfTrailingZeros(j4) >> 3)) & i6;
                if (Intrinsics.areEqual(this.elements[numberOfTrailingZeros], (Object) e2)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & -9187201950435737472L) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i4);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage$collection();
                    findFirstAvailableSlot = findFirstAvailableSlot(i4);
                }
                this._size++;
                int i12 = findFirstAvailableSlot >> 3;
                int i13 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit -= ((this.metadata[i12] >> i13) & 255) == 128 ? 1 : 0;
                long[] jArr2 = this.metadata;
                int i14 = this._capacity;
                long j5 = ((~(255 << i13)) & jArr2[i12]) | (j2 << i13);
                jArr2[i12] = j5;
                jArr2[(((findFirstAvailableSlot - 7) & i14) + (i14 & 7)) >> 3] = j5;
                return findFirstAvailableSlot;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
            i5 = i11;
        }
    }
}
