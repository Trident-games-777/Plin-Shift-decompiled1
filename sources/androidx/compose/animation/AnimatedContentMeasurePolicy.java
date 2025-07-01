package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u000e\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J,\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/AnimatedContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "rootScope", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "getRootScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    private final AnimatedContentTransitionScopeImpl<?> rootScope;

    public AnimatedContentMeasurePolicy(AnimatedContentTransitionScopeImpl<?> animatedContentTransitionScopeImpl) {
        this.rootScope = animatedContentTransitionScopeImpl;
    }

    public final AnimatedContentTransitionScopeImpl<?> getRootScope() {
        return this.rootScope;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData} */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1, types: [androidx.compose.ui.layout.Placeable] */
    /* JADX WARNING: type inference failed for: r11v12 */
    /* JADX WARNING: type inference failed for: r11v14 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0101  */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m41measure3p2s80s(androidx.compose.ui.layout.MeasureScope r21, java.util.List<? extends androidx.compose.ui.layout.Measurable> r22, long r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            r2 = r23
            int r4 = r1.size()
            androidx.compose.ui.layout.Placeable[] r5 = new androidx.compose.ui.layout.Placeable[r4]
            androidx.compose.ui.unit.IntSize$Companion r6 = androidx.compose.ui.unit.IntSize.Companion
            long r6 = r6.m7288getZeroYbymL2g()
            int r8 = r1.size()
            r9 = 0
            r10 = r9
        L_0x0018:
            r11 = 0
            r12 = 1
            if (r10 >= r8) goto L_0x004d
            java.lang.Object r13 = r1.get(r10)
            androidx.compose.ui.layout.Measurable r13 = (androidx.compose.ui.layout.Measurable) r13
            java.lang.Object r14 = r13.getParentData()
            boolean r15 = r14 instanceof androidx.compose.animation.AnimatedContentTransitionScopeImpl.ChildData
            if (r15 == 0) goto L_0x002d
            r11 = r14
            androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData r11 = (androidx.compose.animation.AnimatedContentTransitionScopeImpl.ChildData) r11
        L_0x002d:
            if (r11 == 0) goto L_0x004a
            boolean r11 = r11.isTarget()
            if (r11 != r12) goto L_0x004a
            androidx.compose.ui.layout.Placeable r6 = r13.m5848measureBRTryo0(r2)
            int r7 = r6.getWidth()
            int r11 = r6.getHeight()
            long r11 = androidx.compose.ui.unit.IntSizeKt.IntSize(r7, r11)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            r5[r10] = r6
            r6 = r11
        L_0x004a:
            int r10 = r10 + 1
            goto L_0x0018
        L_0x004d:
            int r8 = r1.size()
            r10 = r9
        L_0x0052:
            if (r10 >= r8) goto L_0x0067
            java.lang.Object r13 = r1.get(r10)
            androidx.compose.ui.layout.Measurable r13 = (androidx.compose.ui.layout.Measurable) r13
            r14 = r5[r10]
            if (r14 != 0) goto L_0x0064
            androidx.compose.ui.layout.Placeable r13 = r13.m5848measureBRTryo0(r2)
            r5[r10] = r13
        L_0x0064:
            int r10 = r10 + 1
            goto L_0x0052
        L_0x0067:
            boolean r1 = r21.isLookingAhead()
            if (r1 == 0) goto L_0x0073
            int r1 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r6)
        L_0x0071:
            r14 = r1
            goto L_0x00b2
        L_0x0073:
            if (r4 != 0) goto L_0x0077
            r1 = r11
            goto L_0x00aa
        L_0x0077:
            r1 = r5[r9]
            int r2 = kotlin.collections.ArraysKt.getLastIndex((T[]) r5)
            if (r2 != 0) goto L_0x0080
            goto L_0x00aa
        L_0x0080:
            if (r1 == 0) goto L_0x0087
            int r3 = r1.getWidth()
            goto L_0x0088
        L_0x0087:
            r3 = r9
        L_0x0088:
            kotlin.ranges.IntRange r8 = new kotlin.ranges.IntRange
            r8.<init>(r12, r2)
            kotlin.collections.IntIterator r2 = r8.iterator()
        L_0x0091:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x00aa
            int r8 = r2.nextInt()
            r8 = r5[r8]
            if (r8 == 0) goto L_0x00a4
            int r10 = r8.getWidth()
            goto L_0x00a5
        L_0x00a4:
            r10 = r9
        L_0x00a5:
            if (r3 >= r10) goto L_0x0091
            r1 = r8
            r3 = r10
            goto L_0x0091
        L_0x00aa:
            if (r1 == 0) goto L_0x00b1
            int r1 = r1.getWidth()
            goto L_0x0071
        L_0x00b1:
            r14 = r9
        L_0x00b2:
            boolean r1 = r21.isLookingAhead()
            if (r1 == 0) goto L_0x00be
            int r9 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r6)
        L_0x00bc:
            r15 = r9
            goto L_0x00fb
        L_0x00be:
            if (r4 != 0) goto L_0x00c1
            goto L_0x00f4
        L_0x00c1:
            r11 = r5[r9]
            int r1 = kotlin.collections.ArraysKt.getLastIndex((T[]) r5)
            if (r1 != 0) goto L_0x00ca
            goto L_0x00f4
        L_0x00ca:
            if (r11 == 0) goto L_0x00d1
            int r2 = r11.getHeight()
            goto L_0x00d2
        L_0x00d1:
            r2 = r9
        L_0x00d2:
            kotlin.ranges.IntRange r3 = new kotlin.ranges.IntRange
            r3.<init>(r12, r1)
            kotlin.collections.IntIterator r1 = r3.iterator()
        L_0x00db:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00f4
            int r3 = r1.nextInt()
            r3 = r5[r3]
            if (r3 == 0) goto L_0x00ee
            int r4 = r3.getHeight()
            goto L_0x00ef
        L_0x00ee:
            r4 = r9
        L_0x00ef:
            if (r2 >= r4) goto L_0x00db
            r11 = r3
            r2 = r4
            goto L_0x00db
        L_0x00f4:
            if (r11 == 0) goto L_0x00bc
            int r9 = r11.getHeight()
            goto L_0x00bc
        L_0x00fb:
            boolean r1 = r21.isLookingAhead()
            if (r1 != 0) goto L_0x010a
            androidx.compose.animation.AnimatedContentTransitionScopeImpl<?> r1 = r0.rootScope
            long r2 = androidx.compose.ui.unit.IntSizeKt.IntSize(r14, r15)
            r1.m66setMeasuredSizeozmzZPI$animation_release(r2)
        L_0x010a:
            androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3 r1 = new androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3
            r1.<init>(r5, r0, r14, r15)
            r17 = r1
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r18 = 4
            r19 = 0
            r16 = 0
            r13 = r21
            androidx.compose.ui.layout.MeasureResult r1 = androidx.compose.ui.layout.MeasureScope.layout$default(r13, r14, r15, r16, r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentMeasurePolicy.m41measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Comparable comparable;
        if (list.isEmpty()) {
            comparable = null;
        } else {
            comparable = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).minIntrinsicWidth(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable valueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).minIntrinsicWidth(i));
                    if (valueOf.compareTo(comparable) > 0) {
                        comparable = valueOf;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Comparable comparable;
        if (list.isEmpty()) {
            comparable = null;
        } else {
            comparable = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).minIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable valueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).minIntrinsicHeight(i));
                    if (valueOf.compareTo(comparable) > 0) {
                        comparable = valueOf;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Comparable comparable;
        if (list.isEmpty()) {
            comparable = null;
        } else {
            comparable = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).maxIntrinsicWidth(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable valueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).maxIntrinsicWidth(i));
                    if (valueOf.compareTo(comparable) > 0) {
                        comparable = valueOf;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Comparable comparable;
        if (list.isEmpty()) {
            comparable = null;
        } else {
            comparable = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).maxIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable valueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).maxIntrinsicHeight(i));
                    if (valueOf.compareTo(comparable) > 0) {
                        comparable = valueOf;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
