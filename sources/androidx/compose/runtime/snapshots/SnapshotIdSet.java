package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J:\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002'\u0010\u0011\u001a#\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0012H\bJ\u001d\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u0019H\bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\"\u001a\u00020#H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotIdSet.kt */
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, (int[]) null);
    /* access modifiers changed from: private */
    public final int[] belowBound;
    /* access modifiers changed from: private */
    public final int lowerBound;
    /* access modifiers changed from: private */
    public final long lowerSet;
    /* access modifiers changed from: private */
    public final long upperSet;

    private SnapshotIdSet(long j, long j2, int i, int[] iArr) {
        this.upperSet = j;
        this.lowerSet = j2;
        this.lowerBound = i;
        this.belowBound = iArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        r0 = r10.belowBound;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean get(int r11) {
        /*
            r10 = this;
            int r0 = r10.lowerBound
            int r0 = r11 - r0
            r1 = 0
            r3 = 1
            r5 = 1
            r6 = 64
            r7 = 0
            if (r0 < 0) goto L_0x001a
            if (r0 >= r6) goto L_0x001a
            long r3 = r3 << r0
            long r8 = r10.lowerSet
            long r3 = r3 & r8
            int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r11 == 0) goto L_0x0019
            return r5
        L_0x0019:
            return r7
        L_0x001a:
            if (r0 < r6) goto L_0x002b
            r8 = 128(0x80, float:1.794E-43)
            if (r0 >= r8) goto L_0x002b
            int r0 = r0 - r6
            long r3 = r3 << r0
            long r8 = r10.upperSet
            long r3 = r3 & r8
            int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r11 == 0) goto L_0x002a
            return r5
        L_0x002a:
            return r7
        L_0x002b:
            if (r0 <= 0) goto L_0x002e
            return r7
        L_0x002e:
            int[] r0 = r10.belowBound
            if (r0 == 0) goto L_0x0039
            int r11 = androidx.compose.runtime.snapshots.SnapshotIdSetKt.binarySearch(r0, r11)
            if (r11 < 0) goto L_0x0039
            return r5
        L_0x0039:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.get(int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.runtime.snapshots.SnapshotIdSet set(int r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            int r6 = r0.lowerBound
            int r2 = r1 - r6
            r3 = 1
            r7 = 0
            r5 = 64
            if (r2 < 0) goto L_0x0029
            if (r2 >= r5) goto L_0x0029
            long r1 = r3 << r2
            long r3 = r0.lowerSet
            long r9 = r3 & r1
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x010d
            r7 = r1
            androidx.compose.runtime.snapshots.SnapshotIdSet r1 = new androidx.compose.runtime.snapshots.SnapshotIdSet
            r4 = r3
            long r2 = r0.upperSet
            long r4 = r4 | r7
            int[] r7 = r0.belowBound
            r1.<init>(r2, r4, r6, r7)
            return r1
        L_0x0029:
            r9 = 128(0x80, float:1.794E-43)
            if (r2 < r5) goto L_0x0047
            if (r2 >= r9) goto L_0x0047
            int r2 = r2 - r5
            long r1 = r3 << r2
            long r3 = r0.upperSet
            long r9 = r3 & r1
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x010d
            r7 = r1
            androidx.compose.runtime.snapshots.SnapshotIdSet r1 = new androidx.compose.runtime.snapshots.SnapshotIdSet
            long r2 = r3 | r7
            long r4 = r0.lowerSet
            int[] r7 = r0.belowBound
            r1.<init>(r2, r4, r6, r7)
            return r1
        L_0x0047:
            r10 = 0
            if (r2 < r9) goto L_0x00d0
            boolean r2 = r21.get(r22)
            if (r2 != 0) goto L_0x010d
            long r11 = r0.upperSet
            long r13 = r0.lowerSet
            int r2 = r0.lowerBound
            int r6 = r1 + 1
            int r6 = r6 / r5
            int r6 = r6 * r5
            r9 = 0
            r14 = r13
            r12 = r11
        L_0x005d:
            if (r2 >= r6) goto L_0x00b6
            int r11 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x00a0
            if (r9 != 0) goto L_0x0086
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List r9 = (java.util.List) r9
            int[] r11 = r0.belowBound
            if (r11 == 0) goto L_0x0086
            r16 = r3
            int r3 = r11.length
            r4 = r10
        L_0x0074:
            if (r4 >= r3) goto L_0x0088
            r18 = r11[r4]
            r19 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r18)
            r9.add(r7)
            int r4 = r4 + 1
            r7 = r19
            goto L_0x0074
        L_0x0086:
            r16 = r3
        L_0x0088:
            r19 = r7
            r3 = r10
        L_0x008b:
            if (r3 >= r5) goto L_0x00a4
            long r7 = r16 << r3
            long r7 = r7 & r14
            int r4 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r4 == 0) goto L_0x009d
            int r4 = r3 + r2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r9.add(r4)
        L_0x009d:
            int r3 = r3 + 1
            goto L_0x008b
        L_0x00a0:
            r16 = r3
            r19 = r7
        L_0x00a4:
            int r3 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x00ad
            r16 = r6
            r14 = r19
            goto L_0x00b8
        L_0x00ad:
            int r2 = r2 + 64
            r14 = r12
            r3 = r16
            r7 = r19
            r12 = r7
            goto L_0x005d
        L_0x00b6:
            r16 = r2
        L_0x00b8:
            androidx.compose.runtime.snapshots.SnapshotIdSet r11 = new androidx.compose.runtime.snapshots.SnapshotIdSet
            if (r9 == 0) goto L_0x00c4
            java.util.Collection r9 = (java.util.Collection) r9
            int[] r2 = kotlin.collections.CollectionsKt.toIntArray(r9)
            if (r2 != 0) goto L_0x00c6
        L_0x00c4:
            int[] r2 = r0.belowBound
        L_0x00c6:
            r17 = r2
            r11.<init>(r12, r14, r16, r17)
            androidx.compose.runtime.snapshots.SnapshotIdSet r1 = r11.set(r1)
            return r1
        L_0x00d0:
            int[] r2 = r0.belowBound
            if (r2 != 0) goto L_0x00e4
            androidx.compose.runtime.snapshots.SnapshotIdSet r1 = new androidx.compose.runtime.snapshots.SnapshotIdSet
            long r2 = r0.upperSet
            r7 = r22
            long r4 = r0.lowerSet
            int[] r7 = new int[]{r7}
            r1.<init>(r2, r4, r6, r7)
            return r1
        L_0x00e4:
            r7 = r1
            int r1 = androidx.compose.runtime.snapshots.SnapshotIdSetKt.binarySearch(r2, r7)
            if (r1 >= 0) goto L_0x010d
            int r1 = r1 + 1
            int r1 = -r1
            int r3 = r2.length
            int r4 = r3 + 1
            int[] r4 = new int[r4]
            kotlin.collections.ArraysKt.copyInto((int[]) r2, (int[]) r4, (int) r10, (int) r10, (int) r1)
            int r5 = r1 + 1
            kotlin.collections.ArraysKt.copyInto((int[]) r2, (int[]) r4, (int) r5, (int) r1, (int) r3)
            r4[r1] = r7
            androidx.compose.runtime.snapshots.SnapshotIdSet r11 = new androidx.compose.runtime.snapshots.SnapshotIdSet
            long r12 = r0.upperSet
            long r14 = r0.lowerSet
            int r1 = r0.lowerBound
            r16 = r1
            r17 = r4
            r11.<init>(r12, r14, r16, r17)
            return r11
        L_0x010d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.set(int):androidx.compose.runtime.snapshots.SnapshotIdSet");
    }

    public final SnapshotIdSet clear(int i) {
        int[] iArr;
        int binarySearch;
        int i2 = this.lowerBound;
        int i3 = i - i2;
        if (i3 >= 0 && i3 < 64) {
            long j = 1 << i3;
            long j2 = this.lowerSet;
            if ((j2 & j) != 0) {
                return new SnapshotIdSet(this.upperSet, (~j) & j2, i2, this.belowBound);
            }
        } else if (i3 >= 64 && i3 < 128) {
            long j3 = 1 << (i3 - 64);
            long j4 = this.upperSet;
            if ((j4 & j3) != 0) {
                return new SnapshotIdSet((~j3) & j4, this.lowerSet, i2, this.belowBound);
            }
        } else if (i3 < 0 && (iArr = this.belowBound) != null && (binarySearch = SnapshotIdSetKt.binarySearch(iArr, i)) >= 0) {
            int length = iArr.length;
            int i4 = length - 1;
            if (i4 == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, (int[]) null);
            }
            int[] iArr2 = new int[i4];
            if (binarySearch > 0) {
                ArraysKt.copyInto(iArr, iArr2, 0, 0, binarySearch);
            }
            if (binarySearch < i4) {
                ArraysKt.copyInto(iArr, iArr2, binarySearch, binarySearch + 1, length);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr2);
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        int[] iArr;
        SnapshotIdSet snapshotIdSet3 = EMPTY;
        if (snapshotIdSet == snapshotIdSet3) {
            return this;
        }
        if (this == snapshotIdSet3) {
            return snapshotIdSet3;
        }
        int i = snapshotIdSet.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2 && snapshotIdSet.belowBound == (iArr = this.belowBound)) {
            return new SnapshotIdSet(this.upperSet & (~snapshotIdSet.upperSet), this.lowerSet & (~snapshotIdSet.lowerSet), i2, iArr);
        }
        int[] access$getBelowBound$p = snapshotIdSet.belowBound;
        if (access$getBelowBound$p != null) {
            snapshotIdSet2 = this;
            for (int clear : access$getBelowBound$p) {
                SnapshotIdSet snapshotIdSet4 = snapshotIdSet2;
                snapshotIdSet2 = snapshotIdSet2.clear(clear);
            }
        } else {
            snapshotIdSet2 = this;
        }
        if (snapshotIdSet.lowerSet != 0) {
            for (int i3 = 0; i3 < 64; i3++) {
                if ((snapshotIdSet.lowerSet & (1 << i3)) != 0) {
                    SnapshotIdSet snapshotIdSet5 = snapshotIdSet2;
                    snapshotIdSet2 = snapshotIdSet2.clear(snapshotIdSet.lowerBound + i3);
                }
            }
        }
        if (snapshotIdSet.upperSet != 0) {
            for (int i4 = 0; i4 < 64; i4++) {
                if ((snapshotIdSet.upperSet & (1 << i4)) != 0) {
                    SnapshotIdSet snapshotIdSet6 = snapshotIdSet2;
                    snapshotIdSet2 = snapshotIdSet2.clear(i4 + 64 + snapshotIdSet.lowerBound);
                }
            }
        }
        SnapshotIdSet snapshotIdSet7 = snapshotIdSet2;
        return snapshotIdSet2;
    }

    public final SnapshotIdSet and(SnapshotIdSet snapshotIdSet) {
        int[] iArr;
        SnapshotIdSet snapshotIdSet2 = snapshotIdSet;
        SnapshotIdSet snapshotIdSet3 = EMPTY;
        if (Intrinsics.areEqual((Object) snapshotIdSet2, (Object) snapshotIdSet3) || Intrinsics.areEqual((Object) this, (Object) snapshotIdSet3)) {
            return snapshotIdSet3;
        }
        int i = snapshotIdSet2.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2 && snapshotIdSet2.belowBound == (iArr = this.belowBound)) {
            long j = this.upperSet;
            long j2 = snapshotIdSet2.upperSet;
            long j3 = this.lowerSet;
            SnapshotIdSet snapshotIdSet4 = snapshotIdSet3;
            long j4 = snapshotIdSet2.lowerSet;
            long j5 = j3 & j4;
            if ((j & j2) == 0 && j5 == 0 && iArr == null) {
                return snapshotIdSet4;
            }
            return new SnapshotIdSet(j & j2, j3 & j4, i2, iArr);
        }
        SnapshotIdSet snapshotIdSet5 = snapshotIdSet3;
        int i3 = 0;
        if (this.belowBound == null) {
            int[] access$getBelowBound$p = this.belowBound;
            if (access$getBelowBound$p != null) {
                for (int i4 : access$getBelowBound$p) {
                    if (snapshotIdSet2.get(i4)) {
                        snapshotIdSet5 = snapshotIdSet5.set(i4);
                    }
                }
            }
            SnapshotIdSet snapshotIdSet6 = snapshotIdSet5;
            if (this.lowerSet != 0) {
                for (int i5 = 0; i5 < 64; i5++) {
                    if ((this.lowerSet & (1 << i5)) != 0) {
                        int access$getLowerBound$p = this.lowerBound + i5;
                        if (snapshotIdSet2.get(access$getLowerBound$p)) {
                            snapshotIdSet6 = snapshotIdSet6.set(access$getLowerBound$p);
                        }
                    }
                }
            }
            if (this.upperSet != 0) {
                while (i3 < 64) {
                    if ((this.upperSet & (1 << i3)) != 0) {
                        int access$getLowerBound$p2 = i3 + 64 + this.lowerBound;
                        if (snapshotIdSet2.get(access$getLowerBound$p2)) {
                            snapshotIdSet6 = snapshotIdSet6.set(access$getLowerBound$p2);
                        }
                    }
                    i3++;
                }
            }
            return snapshotIdSet6;
        }
        int[] access$getBelowBound$p2 = snapshotIdSet2.belowBound;
        if (access$getBelowBound$p2 != null) {
            for (int i6 : access$getBelowBound$p2) {
                if (get(i6)) {
                    snapshotIdSet5 = snapshotIdSet5.set(i6);
                }
            }
        }
        SnapshotIdSet snapshotIdSet7 = snapshotIdSet5;
        if (snapshotIdSet2.lowerSet != 0) {
            for (int i7 = 0; i7 < 64; i7++) {
                if ((snapshotIdSet2.lowerSet & (1 << i7)) != 0) {
                    int access$getLowerBound$p3 = snapshotIdSet2.lowerBound + i7;
                    if (get(access$getLowerBound$p3)) {
                        snapshotIdSet7 = snapshotIdSet7.set(access$getLowerBound$p3);
                    }
                }
            }
        }
        if (snapshotIdSet2.upperSet != 0) {
            while (i3 < 64) {
                if ((snapshotIdSet2.upperSet & (1 << i3)) != 0) {
                    int access$getLowerBound$p4 = i3 + 64 + snapshotIdSet2.lowerBound;
                    if (get(access$getLowerBound$p4)) {
                        snapshotIdSet7 = snapshotIdSet7.set(access$getLowerBound$p4);
                    }
                }
                i3++;
            }
        }
        return snapshotIdSet7;
    }

    public final SnapshotIdSet or(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        int[] iArr;
        SnapshotIdSet snapshotIdSet3 = EMPTY;
        if (snapshotIdSet == snapshotIdSet3) {
            return this;
        }
        if (this == snapshotIdSet3) {
            return snapshotIdSet;
        }
        int i = snapshotIdSet.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2 && snapshotIdSet.belowBound == (iArr = this.belowBound)) {
            return new SnapshotIdSet(this.upperSet | snapshotIdSet.upperSet, this.lowerSet | snapshotIdSet.lowerSet, i2, iArr);
        }
        int i3 = 0;
        if (this.belowBound == null) {
            int[] access$getBelowBound$p = this.belowBound;
            if (access$getBelowBound$p != null) {
                for (int i4 : access$getBelowBound$p) {
                    snapshotIdSet = snapshotIdSet.set(i4);
                }
            }
            if (this.lowerSet != 0) {
                for (int i5 = 0; i5 < 64; i5++) {
                    if ((this.lowerSet & (1 << i5)) != 0) {
                        snapshotIdSet = snapshotIdSet.set(this.lowerBound + i5);
                    }
                }
            }
            if (this.upperSet != 0) {
                while (i3 < 64) {
                    if ((this.upperSet & (1 << i3)) != 0) {
                        snapshotIdSet = snapshotIdSet.set(i3 + 64 + this.lowerBound);
                    }
                    i3++;
                }
            }
            return snapshotIdSet;
        }
        int[] access$getBelowBound$p2 = snapshotIdSet.belowBound;
        if (access$getBelowBound$p2 != null) {
            snapshotIdSet2 = this;
            for (int i6 : access$getBelowBound$p2) {
                SnapshotIdSet snapshotIdSet4 = snapshotIdSet2;
                snapshotIdSet2 = snapshotIdSet2.set(i6);
            }
        } else {
            snapshotIdSet2 = this;
        }
        if (snapshotIdSet.lowerSet != 0) {
            for (int i7 = 0; i7 < 64; i7++) {
                if ((snapshotIdSet.lowerSet & (1 << i7)) != 0) {
                    SnapshotIdSet snapshotIdSet5 = snapshotIdSet2;
                    snapshotIdSet2 = snapshotIdSet2.set(snapshotIdSet.lowerBound + i7);
                }
            }
        }
        if (snapshotIdSet.upperSet != 0) {
            while (i3 < 64) {
                if ((snapshotIdSet.upperSet & (1 << i3)) != 0) {
                    SnapshotIdSet snapshotIdSet6 = snapshotIdSet2;
                    snapshotIdSet2 = snapshotIdSet2.set(i3 + 64 + snapshotIdSet.lowerBound);
                }
                i3++;
            }
        }
        SnapshotIdSet snapshotIdSet7 = snapshotIdSet2;
        return snapshotIdSet2;
    }

    public Iterator<Integer> iterator() {
        return SequencesKt.sequence(new SnapshotIdSet$iterator$1(this, (Continuation<? super SnapshotIdSet$iterator$1>) null)).iterator();
    }

    public final void fastForEach(Function1<? super Integer, Unit> function1) {
        int[] access$getBelowBound$p = this.belowBound;
        if (access$getBelowBound$p != null) {
            for (int valueOf : access$getBelowBound$p) {
                function1.invoke(Integer.valueOf(valueOf));
            }
        }
        if (this.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((this.lowerSet & (1 << i)) != 0) {
                    function1.invoke(Integer.valueOf(this.lowerBound + i));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((this.upperSet & (1 << i2)) != 0) {
                    function1.invoke(Integer.valueOf(i2 + 64 + this.lowerBound));
                }
            }
        }
    }

    public final int lowest(int i) {
        int[] iArr = this.belowBound;
        if (iArr != null) {
            return iArr[0];
        }
        long j = this.lowerSet;
        if (j != 0) {
            return this.lowerBound + Long.numberOfTrailingZeros(j);
        }
        long j2 = this.upperSet;
        return j2 != 0 ? this.lowerBound + 64 + Long.numberOfTrailingZeros(j2) : i;
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append(super.toString()).append(" [");
        Iterable<Number> iterable = this;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Number intValue : iterable) {
            arrayList.add(String.valueOf(intValue.intValue()));
        }
        return append.append(ListUtilsKt.fastJoinToString$default((List) arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).append(']').toString();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotIdSet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }

    public final SnapshotIdSet fastFold(SnapshotIdSet snapshotIdSet, Function2<? super SnapshotIdSet, ? super Integer, SnapshotIdSet> function2) {
        int[] access$getBelowBound$p = this.belowBound;
        int i = 0;
        SnapshotIdSet snapshotIdSet2 = snapshotIdSet;
        if (access$getBelowBound$p != null) {
            int length = access$getBelowBound$p.length;
            int i2 = 0;
            SnapshotIdSet snapshotIdSet3 = snapshotIdSet;
            while (i2 < length) {
                i2++;
                snapshotIdSet3 = function2.invoke(snapshotIdSet3, Integer.valueOf(access$getBelowBound$p[i2]));
            }
            snapshotIdSet2 = snapshotIdSet3;
        }
        SnapshotIdSet snapshotIdSet4 = snapshotIdSet2;
        if (this.lowerSet != 0) {
            int i3 = 0;
            SnapshotIdSet snapshotIdSet5 = snapshotIdSet2;
            while (i3 < 64) {
                SnapshotIdSet invoke = (this.lowerSet & (1 << i3)) != 0 ? function2.invoke(snapshotIdSet5, Integer.valueOf(this.lowerBound + i3)) : snapshotIdSet5;
                i3++;
                snapshotIdSet5 = invoke;
            }
            snapshotIdSet4 = snapshotIdSet5;
        }
        SnapshotIdSet snapshotIdSet6 = snapshotIdSet4;
        SnapshotIdSet snapshotIdSet7 = snapshotIdSet4;
        if (this.upperSet != 0) {
            while (i < 64) {
                SnapshotIdSet invoke2 = (this.upperSet & (1 << i)) != 0 ? function2.invoke(snapshotIdSet6, Integer.valueOf(i + 64 + this.lowerBound)) : snapshotIdSet6;
                i++;
                snapshotIdSet6 = invoke2;
            }
            snapshotIdSet7 = snapshotIdSet6;
        }
        return snapshotIdSet7;
    }
}
