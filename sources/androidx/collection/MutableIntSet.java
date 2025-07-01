package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0001J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0001H\u0002J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0011\u0010\u0018\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0001H\u0002J\u0011\u0010\u0018\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0011\u0010\u0018\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0001J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\b\u0010\u001f\u001a\u00020\u0003H\u0007J\u0019\u0010 \u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\bR\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/collection/MutableIntSet;", "Landroidx/collection/IntSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "addAll", "elements", "", "adjustStorage", "", "clear", "dropDeletes", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "plusAssign", "remove", "removeAll", "removeElementAt", "index", "resizeStorage", "newCapacity", "trim", "writeMetadata", "value", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntSet.kt */
public final class MutableIntSet extends IntSet {
    private int growthLimit;

    public MutableIntSet() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableIntSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public MutableIntSet(int i) {
        super((DefaultConstructorMarker) null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    private final void initializeStorage(int i) {
        int max = i > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i)) : 0;
        this._capacity = max;
        initializeMetadata(max);
        this.elements = new int[max];
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

    public final boolean add(int i) {
        int i2 = this._size;
        this.elements[findAbsoluteInsertIndex(i)] = i;
        return this._size != i2;
    }

    public final void plusAssign(int i) {
        this.elements[findAbsoluteInsertIndex(i)] = i;
    }

    public final boolean addAll(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        int i = this._size;
        plusAssign(iArr);
        return i != this._size;
    }

    public final boolean addAll(IntSet intSet) {
        Intrinsics.checkNotNullParameter(intSet, "elements");
        int i = this._size;
        plusAssign(intSet);
        return i != this._size;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0060, code lost:
        r5 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0069, code lost:
        if (((r7 & ((~r7) << 6)) & -9187201950435737472L) == 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006b, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r0
            androidx.collection.IntSet r1 = (androidx.collection.IntSet) r1
            int r2 = java.lang.Integer.hashCode(r18)
            r3 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r2 = r2 * r3
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r1._capacity
            int r2 = r2 >>> 7
            r2 = r2 & r4
            r6 = 0
        L_0x0018:
            long[] r7 = r1.metadata
            int r8 = r2 >> 3
            r9 = r2 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r7 = r7[r8]
            int r13 = 64 - r9
            long r7 = r7 << r13
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r3
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L_0x0043:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x0060
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            int[] r15 = r1.elements
            r15 = r15[r11]
            r5 = r18
            if (r15 != r5) goto L_0x005a
            goto L_0x006c
        L_0x005a:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L_0x0043
        L_0x0060:
            r5 = r18
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L_0x0077
            r11 = -1
        L_0x006c:
            if (r11 < 0) goto L_0x0070
            r5 = r12
            goto L_0x0071
        L_0x0070:
            r5 = 0
        L_0x0071:
            if (r5 == 0) goto L_0x0076
            r0.removeElementAt(r11)
        L_0x0076:
            return r5
        L_0x0077:
            int r6 = r6 + 8
            int r2 = r2 + r6
            r2 = r2 & r4
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntSet.remove(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0063, code lost:
        if (((r5 & ((~r5) << 6)) & -9187201950435737472L) == 0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0065, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void minusAssign(int r15) {
        /*
            r14 = this;
            r0 = r14
            androidx.collection.IntSet r0 = (androidx.collection.IntSet) r0
            int r1 = java.lang.Integer.hashCode(r15)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0._capacity
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
        L_0x0016:
            long[] r5 = r0.metadata
            int r6 = r1 >> 3
            r7 = r1 & 7
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
            long r7 = (long) r2
            r9 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r7 = r7 * r9
            long r7 = r7 ^ r5
            long r9 = r7 - r9
            long r7 = ~r7
            long r7 = r7 & r9
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
        L_0x0041:
            r11 = 0
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x005c
            int r11 = java.lang.Long.numberOfTrailingZeros(r7)
            int r11 = r11 >> 3
            int r11 = r11 + r1
            r11 = r11 & r3
            int[] r12 = r0.elements
            r12 = r12[r11]
            if (r12 != r15) goto L_0x0056
            goto L_0x0066
        L_0x0056:
            r11 = 1
            long r11 = r7 - r11
            long r7 = r7 & r11
            goto L_0x0041
        L_0x005c:
            long r7 = ~r5
            r13 = 6
            long r7 = r7 << r13
            long r5 = r5 & r7
            long r5 = r5 & r9
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x006c
            r11 = -1
        L_0x0066:
            if (r11 < 0) goto L_0x006b
            r14.removeElementAt(r11)
        L_0x006b:
            return
        L_0x006c:
            int r4 = r4 + 8
            int r1 = r1 + r4
            r1 = r1 & r3
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntSet.minusAssign(int):void");
    }

    public final boolean removeAll(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        int i = this._size;
        minusAssign(iArr);
        return i != this._size;
    }

    public final boolean removeAll(IntSet intSet) {
        Intrinsics.checkNotNullParameter(intSet, "elements");
        int i = this._size;
        minusAssign(intSet);
        return i != this._size;
    }

    private final void removeElementAt(int i) {
        this._size--;
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
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
        resizeStorage(normalizeCapacity);
        return i - this._capacity;
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || Long.compareUnsigned(ULong.m7997constructorimpl(ULong.m7997constructorimpl((long) this._size) * 32), ULong.m7997constructorimpl(ULong.m7997constructorimpl((long) this._capacity) * 25)) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            dropDeletes();
        }
    }

    private final void dropDeletes() {
        long[] jArr = this.metadata;
        int i = this._capacity;
        int[] iArr = this.elements;
        ScatterMapKt.convertMetadataForCleanup(jArr, i);
        int i2 = -1;
        int i3 = 0;
        while (i3 != i) {
            int i4 = i3 >> 3;
            int i5 = (i3 & 7) << 3;
            long j = (jArr[i4] >> i5) & 255;
            if (j == 128) {
                i2 = i3;
                i3++;
            } else {
                if (j == 254) {
                    int hashCode = Integer.hashCode(iArr[i3]) * ScatterMapKt.MurmurHashC1;
                    int i6 = hashCode ^ (hashCode << 16);
                    int i7 = i6 >>> 7;
                    int findFirstAvailableSlot = findFirstAvailableSlot(i7);
                    int i8 = i7 & i;
                    if (((findFirstAvailableSlot - i8) & i) / 8 == ((i3 - i8) & i) / 8) {
                        jArr[i4] = (((long) (i6 & 127)) << i5) | ((~(255 << i5)) & jArr[i4]);
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i9 = findFirstAvailableSlot >> 3;
                        long j2 = jArr[i9];
                        int i10 = (findFirstAvailableSlot & 7) << 3;
                        if (((j2 >> i10) & 255) == 128) {
                            jArr[i9] = (((long) (i6 & 127)) << i10) | (j2 & (~(255 << i10)));
                            jArr[i4] = (jArr[i4] & (~(255 << i5))) | (128 << i5);
                            iArr[findFirstAvailableSlot] = iArr[i3];
                            iArr[i3] = 0;
                            i2 = i3;
                        } else {
                            jArr[i9] = (((long) (i6 & 127)) << i10) | (j2 & (~(255 << i10)));
                            if (i2 == -1) {
                                i2 = ScatterMapKt.findEmptySlot(jArr, i3 + 1, i);
                            }
                            iArr[i2] = iArr[findFirstAvailableSlot];
                            iArr[findFirstAvailableSlot] = iArr[i3];
                            iArr[i3] = iArr[i2];
                            i3--;
                        }
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                    }
                }
                i3++;
            }
        }
        initializeGrowth();
    }

    private final void resizeStorage(int i) {
        long[] jArr = this.metadata;
        int[] iArr = this.elements;
        int i2 = this._capacity;
        initializeStorage(i);
        long[] jArr2 = this.metadata;
        int[] iArr2 = this.elements;
        int i3 = this._capacity;
        for (int i4 = 0; i4 < i2; i4++) {
            if (((jArr[i4 >> 3] >> ((i4 & 7) << 3)) & 255) < 128) {
                int i5 = iArr[i4];
                int hashCode = Integer.hashCode(i5) * ScatterMapKt.MurmurHashC1;
                int i6 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i6 >>> 7);
                long j = (long) (i6 & 127);
                int i7 = findFirstAvailableSlot >> 3;
                int i8 = (findFirstAvailableSlot & 7) << 3;
                long j2 = (jArr2[i7] & (~(255 << i8))) | (j << i8);
                jArr2[i7] = j2;
                jArr2[(((findFirstAvailableSlot - 7) & i3) + (i3 & 7)) >> 3] = j2;
                iArr2[findFirstAvailableSlot] = i5;
            }
        }
    }

    private final void writeMetadata(int i, long j) {
        long[] jArr = this.metadata;
        int i2 = i >> 3;
        int i3 = (i & 7) << 3;
        jArr[i2] = (jArr[i2] & (~(255 << i3))) | (j << i3);
        int i4 = this._capacity;
        int i5 = ((i - 7) & i4) + (i4 & 7);
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        jArr[i6] = (j << i7) | (jArr[i6] & (~(255 << i7)));
    }

    public final void plusAssign(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        for (int plusAssign : iArr) {
            plusAssign(plusAssign);
        }
    }

    public final void plusAssign(IntSet intSet) {
        Intrinsics.checkNotNullParameter(intSet, "elements");
        int[] iArr = intSet.elements;
        long[] jArr = intSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            plusAssign(iArr[(i << 3) + i3]);
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

    public final void minusAssign(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        for (int minusAssign : iArr) {
            minusAssign(minusAssign);
        }
    }

    public final void minusAssign(IntSet intSet) {
        Intrinsics.checkNotNullParameter(intSet, "elements");
        int[] iArr = intSet.elements;
        long[] jArr = intSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            minusAssign(iArr[(i << 3) + i3]);
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

    private final int findAbsoluteInsertIndex(int i) {
        int hashCode = Integer.hashCode(i) * ScatterMapKt.MurmurHashC1;
        int i2 = hashCode ^ (hashCode << 16);
        int i3 = i2 >>> 7;
        int i4 = i2 & 127;
        int i5 = this._capacity;
        int i6 = i3 & i5;
        int i7 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            int i10 = 1;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-((long) i9)) >> 63)) | (jArr[i8] >>> i9);
            long j2 = (long) i4;
            int i11 = i7;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L;
            while (j4 != 0) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i6) & i5;
                int i12 = i10;
                if (this.elements[numberOfTrailingZeros] == i) {
                    return numberOfTrailingZeros;
                }
                j4 &= j4 - 1;
                i10 = i12;
            }
            int i13 = i10;
            int i14 = i;
            if ((((~j) << 6) & j & -9187201950435737472L) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i3);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i3);
                }
                this._size++;
                int i15 = findFirstAvailableSlot >> 3;
                int i16 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit -= ((this.metadata[i15] >> i16) & 255) == 128 ? i13 : 0;
                long[] jArr2 = this.metadata;
                int i17 = this._capacity;
                long j5 = ((~(255 << i16)) & jArr2[i15]) | (j2 << i16);
                jArr2[i15] = j5;
                jArr2[(((findFirstAvailableSlot - 7) & i17) + (i17 & 7)) >> 3] = j5;
                return findFirstAvailableSlot;
            }
            i7 = i11 + 8;
            i6 = (i6 + i7) & i5;
        }
    }
}
