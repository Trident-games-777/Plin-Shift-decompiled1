package androidx.compose.material3.carousel;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016JT\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0002J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002J \u0010\"\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl;", "Landroidx/compose/material3/carousel/KeylineListScope;", "()V", "firstFocalIndex", "", "focalItemSize", "", "pivotIndex", "pivotOffset", "tmpKeylines", "", "Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "add", "", "size", "isAnchor", "", "createKeylinesWithPivot", "", "Landroidx/compose/material3/carousel/Keyline;", "lastFocalIndex", "itemMainAxisSize", "carouselMainAxisSize", "itemSpacing", "createWithAlignment", "Landroidx/compose/material3/carousel/KeylineList;", "carouselAlignment", "Landroidx/compose/material3/carousel/CarouselAlignment;", "createWithAlignment-waks0t8", "(FFI)Landroidx/compose/material3/carousel/KeylineList;", "createWithPivot", "findLastFocalIndex", "isCutoffLeft", "offset", "isCutoffRight", "TmpKeyline", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeylineList.kt */
final class KeylineListScopeImpl implements KeylineListScope {
    private int firstFocalIndex = -1;
    private float focalItemSize;
    private int pivotIndex = -1;
    private float pivotOffset;
    private final List<TmpKeyline> tmpKeylines = new ArrayList();

    private final boolean isCutoffLeft(float f, float f2) {
        float f3 = f / ((float) 2);
        return f2 - f3 < 0.0f && f2 + f3 > 0.0f;
    }

    private final boolean isCutoffRight(float f, float f2, float f3) {
        float f4 = f / ((float) 2);
        return f2 - f4 < f3 && f2 + f4 > f3;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "", "size", "", "isAnchor", "", "(FZ)V", "()Z", "getSize", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: KeylineList.kt */
    private static final class TmpKeyline {
        private final boolean isAnchor;
        private final float size;

        public static /* synthetic */ TmpKeyline copy$default(TmpKeyline tmpKeyline, float f, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                f = tmpKeyline.size;
            }
            if ((i & 2) != 0) {
                z = tmpKeyline.isAnchor;
            }
            return tmpKeyline.copy(f, z);
        }

        public final float component1() {
            return this.size;
        }

        public final boolean component2() {
            return this.isAnchor;
        }

        public final TmpKeyline copy(float f, boolean z) {
            return new TmpKeyline(f, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TmpKeyline)) {
                return false;
            }
            TmpKeyline tmpKeyline = (TmpKeyline) obj;
            return Float.compare(this.size, tmpKeyline.size) == 0 && this.isAnchor == tmpKeyline.isAnchor;
        }

        public int hashCode() {
            return (Float.hashCode(this.size) * 31) + Boolean.hashCode(this.isAnchor);
        }

        public String toString() {
            return "TmpKeyline(size=" + this.size + ", isAnchor=" + this.isAnchor + ')';
        }

        public TmpKeyline(float f, boolean z) {
            this.size = f;
            this.isAnchor = z;
        }

        public final float getSize() {
            return this.size;
        }

        public final boolean isAnchor() {
            return this.isAnchor;
        }
    }

    public void add(float f, boolean z) {
        this.tmpKeylines.add(new TmpKeyline(f, z));
        if (f > this.focalItemSize) {
            this.firstFocalIndex = CollectionsKt.getLastIndex(this.tmpKeylines);
            this.focalItemSize = f;
        }
    }

    public final KeylineList createWithPivot(float f, float f2, int i, float f3) {
        return new KeylineList(createKeylinesWithPivot(i, f3, this.firstFocalIndex, findLastFocalIndex(), this.focalItemSize, f, f2, this.tmpKeylines));
    }

    /* renamed from: createWithAlignment-waks0t8  reason: not valid java name */
    public final KeylineList m2901createWithAlignmentwaks0t8(float f, float f2, int i) {
        float f3;
        int findLastFocalIndex = findLastFocalIndex();
        int i2 = this.firstFocalIndex;
        int i3 = findLastFocalIndex - i2;
        this.pivotIndex = i2;
        if (CarouselAlignment.m2883equalsimpl0(i, CarouselAlignment.Companion.m2887getCenterNUL3oTo())) {
            float f4 = 0.0f;
            if (f2 != 0.0f) {
                int i4 = i3 % 2;
                if (i4 + ((((i4 ^ 2) & ((-i4) | i4)) >> 31) & 2) != 0) {
                    f4 = f2 / 2.0f;
                }
            }
            float f5 = (float) 2;
            f3 = ((f / f5) - ((this.focalItemSize / f5) * ((float) i3))) - f4;
        } else if (CarouselAlignment.m2883equalsimpl0(i, CarouselAlignment.Companion.m2888getEndNUL3oTo())) {
            f3 = f - (this.focalItemSize / ((float) 2));
        } else {
            f3 = this.focalItemSize / ((float) 2);
        }
        this.pivotOffset = f3;
        return new KeylineList(createKeylinesWithPivot(this.pivotIndex, f3, this.firstFocalIndex, findLastFocalIndex, this.focalItemSize, f, f2, this.tmpKeylines));
    }

    private final int findLastFocalIndex() {
        int i = this.firstFocalIndex;
        while (i < CollectionsKt.getLastIndex(this.tmpKeylines)) {
            int i2 = i + 1;
            if (this.tmpKeylines.get(i2).getSize() != this.focalItemSize) {
                break;
            }
            i = i2;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<androidx.compose.material3.carousel.Keyline> createKeylinesWithPivot(int r28, float r29, int r30, int r31, float r32, float r33, float r34, java.util.List<androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline> r35) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r4 = r29
            r10 = r30
            r11 = r31
            r12 = r33
            r13 = r35
            java.lang.Object r2 = r13.get(r1)
            androidx.compose.material3.carousel.KeylineListScopeImpl$TmpKeyline r2 = (androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r14 = r3
            java.util.List r14 = (java.util.List) r14
            float r3 = r2.getSize()
            boolean r3 = r0.isCutoffLeft(r3, r4)
            r5 = 2
            if (r3 == 0) goto L_0x0032
            float r3 = r2.getSize()
            float r6 = (float) r5
            float r3 = r3 / r6
            float r3 = r4 - r3
        L_0x002f:
            r9 = r3
            r3 = r2
            goto L_0x0047
        L_0x0032:
            float r3 = r2.getSize()
            boolean r3 = r0.isCutoffRight(r3, r4, r12)
            if (r3 == 0) goto L_0x0045
            float r3 = r2.getSize()
            float r6 = (float) r5
            float r3 = r3 / r6
            float r3 = r3 + r4
            float r3 = r3 - r12
            goto L_0x002f
        L_0x0045:
            r3 = r2
            r9 = 0
        L_0x0047:
            androidx.compose.material3.carousel.Keyline r2 = new androidx.compose.material3.carousel.Keyline
            r6 = r3
            float r3 = r6.getSize()
            r16 = 1
            r7 = 0
            if (r10 > r1) goto L_0x0059
            if (r1 > r11) goto L_0x0059
            r8 = r6
            r6 = r16
            goto L_0x005b
        L_0x0059:
            r8 = r6
            r6 = r7
        L_0x005b:
            boolean r8 = r8.isAnchor()
            r17 = r7
            r7 = r8
            r8 = 1
            r18 = r5
            r5 = r29
            r15 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r14.add(r2)
            float r2 = (float) r15
            float r3 = r32 / r2
            float r4 = r29 - r3
            float r4 = r4 - r34
            int r5 = r1 + -1
            r6 = 0
            kotlin.ranges.IntProgression r5 = kotlin.ranges.RangesKt.downTo((int) r5, (int) r6)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            r6 = r4
        L_0x0084:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e5
            r7 = r5
            kotlin.collections.IntIterator r7 = (kotlin.collections.IntIterator) r7
            int r7 = r7.nextInt()
            java.lang.Object r8 = r13.get(r7)
            androidx.compose.material3.carousel.KeylineListScopeImpl$TmpKeyline r8 = (androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline) r8
            float r9 = r8.getSize()
            float r9 = r9 / r2
            float r9 = r4 - r9
            float r22 = r6 - r3
            float r15 = r8.getSize()
            boolean r15 = r0.isCutoffLeft(r15, r9)
            if (r15 == 0) goto L_0x00b8
            float r15 = r8.getSize()
            float r15 = r15 / r2
            float r15 = r9 - r15
            float r15 = java.lang.Math.abs(r15)
            r26 = r15
            goto L_0x00ba
        L_0x00b8:
            r26 = 0
        L_0x00ba:
            androidx.compose.material3.carousel.Keyline r19 = new androidx.compose.material3.carousel.Keyline
            float r20 = r8.getSize()
            if (r10 > r7) goto L_0x00c7
            if (r7 > r11) goto L_0x00c7
            r23 = r16
            goto L_0x00c9
        L_0x00c7:
            r23 = 0
        L_0x00c9:
            boolean r24 = r8.isAnchor()
            r25 = 0
            r21 = r9
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            r7 = r19
            r9 = 0
            r14.add(r9, r7)
            float r7 = r8.getSize()
            float r7 = r7 + r34
            float r4 = r4 - r7
            float r7 = r32 + r34
            float r6 = r6 - r7
            goto L_0x0084
        L_0x00e5:
            r9 = 0
            float r4 = r29 + r3
            float r4 = r4 + r34
            int r1 = r1 + 1
            int r5 = r13.size()
            kotlin.ranges.IntRange r1 = kotlin.ranges.RangesKt.until((int) r1, (int) r5)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            r5 = r4
        L_0x00fb:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0156
            r6 = r1
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            java.lang.Object r7 = r13.get(r6)
            androidx.compose.material3.carousel.KeylineListScopeImpl$TmpKeyline r7 = (androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline) r7
            float r8 = r7.getSize()
            float r8 = r8 / r2
            float r8 = r8 + r4
            float r22 = r5 + r3
            float r15 = r7.getSize()
            boolean r15 = r0.isCutoffRight(r15, r8, r12)
            if (r15 == 0) goto L_0x012a
            float r15 = r7.getSize()
            float r15 = r15 / r2
            float r15 = r15 + r8
            float r15 = r15 - r12
            r26 = r15
            goto L_0x012c
        L_0x012a:
            r26 = 0
        L_0x012c:
            androidx.compose.material3.carousel.Keyline r19 = new androidx.compose.material3.carousel.Keyline
            float r20 = r7.getSize()
            if (r10 > r6) goto L_0x0139
            if (r6 > r11) goto L_0x0139
            r23 = r16
            goto L_0x013b
        L_0x0139:
            r23 = r9
        L_0x013b:
            boolean r24 = r7.isAnchor()
            r25 = 0
            r21 = r8
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            r6 = r19
            r14.add(r6)
            float r6 = r7.getSize()
            float r6 = r6 + r34
            float r4 = r4 + r6
            float r6 = r32 + r34
            float r5 = r5 + r6
            goto L_0x00fb
        L_0x0156:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.KeylineListScopeImpl.createKeylinesWithPivot(int, float, int, int, float, float, float, java.util.List):java.util.List");
    }
}
