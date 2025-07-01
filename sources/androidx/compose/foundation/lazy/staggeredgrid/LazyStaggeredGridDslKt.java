package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010$\u001aÐ\u0001\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0'2%\b\n\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u00010\u00142%\b\u0006\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,0\u00142%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u00010\u001423\b\u0004\u00100\u001a-\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000101¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u00104\u001aÐ\u0001\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&052%\b\n\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u00010\u00142%\b\u0006\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,0\u00142%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u00010\u001423\b\u0004\u00100\u001a-\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000101¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u00106\u001a¤\u0002\u00107\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0'2:\b\n\u0010(\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u0001012:\b\u0006\u0010-\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,012:\b\n\u0010.\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u0001012H\b\u0004\u00100\u001aB\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u0010;\u001a¤\u0002\u00107\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&052:\b\n\u0010(\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u0001012:\b\u0006\u0010-\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,012:\b\n\u0010.\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u0001012H\b\u0004\u00100\u001aB\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u0010<\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"LazyHorizontalStaggeredGrid", "", "rows", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalItemSpacing", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyHorizontalStaggeredGrid-cJHQLPU", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalStaggeredGrid", "columns", "verticalItemSpacing", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "LazyVerticalStaggeredGrid-zadm560", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "rememberRowSlots", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridDsl.kt */
public final class LazyStaggeredGridDslKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fb  */
    /* renamed from: LazyVerticalStaggeredGrid-zadm560  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1040LazyVerticalStaggeredGridzadm560(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells r28, androidx.compose.ui.Modifier r29, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r30, androidx.compose.foundation.layout.PaddingValues r31, boolean r32, float r33, androidx.compose.foundation.layout.Arrangement.Horizontal r34, androidx.compose.foundation.gestures.FlingBehavior r35, boolean r36, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r28
            r11 = r39
            r12 = r40
            r0 = 1695323794(0x650c9692, float:4.1494302E22)
            r2 = r38
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LazyVerticalStaggeredGrid)P(!1,5,7,2,6,9:c#ui.unit.Dp,4,3,8)64@3068L32,69@3365L15,83@3878L67,73@3476L502:LazyStaggeredGridDsl.kt#fzvcnm"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r12 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r11 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r11 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r11
            goto L_0x002b
        L_0x002a:
            r3 = r11
        L_0x002b:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r11 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r29
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r29
        L_0x0047:
            r6 = r11 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0060
            r6 = r12 & 4
            if (r6 != 0) goto L_0x005a
            r6 = r30
            boolean r7 = r2.changedInstance(r6)
            if (r7 == 0) goto L_0x005c
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r6 = r30
        L_0x005c:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r3 = r3 | r7
            goto L_0x0062
        L_0x0060:
            r6 = r30
        L_0x0062:
            r7 = r12 & 8
            if (r7 == 0) goto L_0x0069
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r8 = r11 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007c
            r8 = r31
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r9
            goto L_0x007e
        L_0x007c:
            r8 = r31
        L_0x007e:
            r9 = r12 & 16
            if (r9 == 0) goto L_0x0085
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0085:
            r10 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0098
            r10 = r32
            boolean r13 = r2.changed((boolean) r10)
            if (r13 == 0) goto L_0x0094
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r3 = r3 | r13
            goto L_0x009a
        L_0x0098:
            r10 = r32
        L_0x009a:
            r13 = r12 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a2
            r3 = r3 | r14
            goto L_0x00b4
        L_0x00a2:
            r14 = r14 & r11
            if (r14 != 0) goto L_0x00b4
            r14 = r33
            boolean r15 = r2.changed((float) r14)
            if (r15 == 0) goto L_0x00b0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r3 = r3 | r15
            goto L_0x00b6
        L_0x00b4:
            r14 = r33
        L_0x00b6:
            r15 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c1
            r3 = r3 | r16
            r0 = r34
            goto L_0x00d4
        L_0x00c1:
            r16 = r11 & r16
            r0 = r34
            if (r16 != 0) goto L_0x00d4
            boolean r17 = r2.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00d0
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r3 = r3 | r17
        L_0x00d4:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r11 & r17
            if (r17 != 0) goto L_0x00f0
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00e9
            r0 = r35
            boolean r17 = r2.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00eb
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00e9:
            r0 = r35
        L_0x00eb:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r3 = r3 | r17
            goto L_0x00f2
        L_0x00f0:
            r0 = r35
        L_0x00f2:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fb
            r3 = r3 | r17
            goto L_0x0111
        L_0x00fb:
            r17 = r11 & r17
            if (r17 != 0) goto L_0x0111
            r17 = r0
            r0 = r36
            boolean r18 = r2.changed((boolean) r0)
            if (r18 == 0) goto L_0x010c
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010c:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r3 = r3 | r18
            goto L_0x0115
        L_0x0111:
            r17 = r0
            r0 = r36
        L_0x0115:
            r0 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x011e
            r3 = r3 | r18
            goto L_0x0132
        L_0x011e:
            r0 = r11 & r18
            if (r0 != 0) goto L_0x0132
            r0 = r37
            boolean r18 = r2.changedInstance(r0)
            if (r18 == 0) goto L_0x012d
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012f
        L_0x012d:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012f:
            r3 = r3 | r18
            goto L_0x0134
        L_0x0132:
            r0 = r37
        L_0x0134:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r3 & r18
            r38 = r4
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r4) goto L_0x0159
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0147
            goto L_0x0159
        L_0x0147:
            r2.skipToGroupEnd()
            r7 = r34
            r9 = r36
            r24 = r2
            r2 = r5
            r3 = r6
            r4 = r8
            r5 = r10
            r6 = r14
            r8 = r35
            goto L_0x0257
        L_0x0159:
            r2.startDefaults()
            r0 = r11 & 1
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            if (r0 == 0) goto L_0x0185
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x016a
            goto L_0x0185
        L_0x016a:
            r2.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0173
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0173:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0178
            r3 = r3 & r4
        L_0x0178:
            r0 = r34
            r19 = r35
            r20 = r36
        L_0x017e:
            r13 = r6
        L_0x017f:
            r18 = r10
            r21 = r14
            goto L_0x01e2
        L_0x0185:
            if (r38 == 0) goto L_0x018c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x018c:
            r0 = r12 & 4
            r38 = r4
            r4 = 0
            if (r0 == 0) goto L_0x019b
            r0 = 3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r0 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(r4, r4, r2, r4, r0)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r0
        L_0x019b:
            if (r7 == 0) goto L_0x01a7
            float r0 = (float) r4
            float r0 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r0)
            androidx.compose.foundation.layout.PaddingValues r0 = androidx.compose.foundation.layout.PaddingKt.m768PaddingValues0680j_4(r0)
            r8 = r0
        L_0x01a7:
            if (r9 == 0) goto L_0x01aa
            r10 = r4
        L_0x01aa:
            if (r13 == 0) goto L_0x01b2
            float r0 = (float) r4
            float r0 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r0)
            r14 = r0
        L_0x01b2:
            if (r15 == 0) goto L_0x01c2
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r0 = r0.m623spacedBy0680j_4(r4)
            androidx.compose.foundation.layout.Arrangement$Horizontal r0 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r0
            goto L_0x01c4
        L_0x01c2:
            r0 = r34
        L_0x01c4:
            r4 = r12 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x01d2
            androidx.compose.foundation.gestures.ScrollableDefaults r4 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r7 = 6
            androidx.compose.foundation.gestures.FlingBehavior r4 = r4.flingBehavior(r2, r7)
            r3 = r3 & r38
            goto L_0x01d4
        L_0x01d2:
            r4 = r35
        L_0x01d4:
            if (r17 == 0) goto L_0x01dd
            r7 = 1
            r19 = r4
            r13 = r6
            r20 = r7
            goto L_0x017f
        L_0x01dd:
            r20 = r36
            r19 = r4
            goto L_0x017e
        L_0x01e2:
            r2.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x01f4
            r4 = -1
            java.lang.String r6 = "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:72)"
            r7 = 1695323794(0x650c9692, float:4.1494302E22)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r4, r6)
        L_0x01f4:
            androidx.compose.foundation.gestures.Orientation r14 = androidx.compose.foundation.gestures.Orientation.Vertical
            float r22 = r0.m631getSpacingD9Ej5fM()
            r4 = r3 & 14
            int r6 = r3 >> 15
            r6 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            int r6 = r3 >> 3
            r7 = r6 & 896(0x380, float:1.256E-42)
            r4 = r4 | r7
            androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider r15 = rememberColumnSlots(r1, r0, r8, r2, r4)
            int r4 = r3 >> 6
            r4 = r4 & 14
            r4 = r4 | 48
            int r7 = r3 << 6
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r7
            int r7 = r3 << 3
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r7
            r4 = r4 | r9
            r9 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r9
            r4 = r4 | r7
            r7 = 3670016(0x380000, float:5.142788E-39)
            r7 = r7 & r6
            r4 = r4 | r7
            r7 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r7
            r4 = r4 | r6
            int r6 = r3 << 9
            r7 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r7
            r25 = r4 | r6
            int r3 = r3 >> 27
            r26 = r3 & 14
            r27 = 0
            r23 = r37
            r24 = r2
            r16 = r5
            r17 = r8
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.m1045LazyStaggeredGridLJWHXA8(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0249
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0249:
            r7 = r0
            r3 = r13
            r2 = r16
            r4 = r17
            r5 = r18
            r8 = r19
            r9 = r20
            r6 = r21
        L_0x0257:
            androidx.compose.runtime.ScopeUpdateScope r13 = r24.endRestartGroup()
            if (r13 == 0) goto L_0x0269
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1 r0 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1
            r10 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0269:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.m1040LazyVerticalStaggeredGridzadm560(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.layout.PaddingValues, boolean, float, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberColumnSlots(StaggeredGridCells staggeredGridCells, Arrangement.Horizontal horizontal, PaddingValues paddingValues, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1267076841, "C(rememberColumnSlots)P(!1,2)94@4216L1114:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1267076841, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnSlots (LazyStaggeredGridDsl.kt:94)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 463564400, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        boolean z = false;
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed((Object) staggeredGridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed((Object) horizontal)) || (i & 48) == 32);
        if ((((i & 896) ^ 384) > 256 && composer.changed((Object) paddingValues)) || (i & 384) == 256) {
            z = true;
        }
        boolean z3 = z2 | z;
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyStaggeredGridSlotCache(new LazyStaggeredGridDslKt$rememberColumnSlots$1$1(paddingValues, staggeredGridCells, horizontal));
            composer.updateRememberedValue(rememberedValue);
        }
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridStaggeredGridSlotsProvider;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fb  */
    /* renamed from: LazyHorizontalStaggeredGrid-cJHQLPU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1039LazyHorizontalStaggeredGridcJHQLPU(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells r28, androidx.compose.ui.Modifier r29, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r30, androidx.compose.foundation.layout.PaddingValues r31, boolean r32, androidx.compose.foundation.layout.Arrangement.Vertical r33, float r34, androidx.compose.foundation.gestures.FlingBehavior r35, boolean r36, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r28
            r11 = r39
            r12 = r40
            r0 = -8666074(0xffffffffff7bc426, float:-3.3465469E38)
            r2 = r38
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LazyHorizontalStaggeredGrid)P(6,4,7,1,5,9,3:c#ui.unit.Dp,2,8)154@6993L32,159@7288L15,173@7803L59,163@7399L496:LazyStaggeredGridDsl.kt#fzvcnm"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r12 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r11 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r11 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r11
            goto L_0x002b
        L_0x002a:
            r3 = r11
        L_0x002b:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r11 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r29
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r29
        L_0x0047:
            r6 = r11 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0060
            r6 = r12 & 4
            if (r6 != 0) goto L_0x005a
            r6 = r30
            boolean r7 = r2.changedInstance(r6)
            if (r7 == 0) goto L_0x005c
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r6 = r30
        L_0x005c:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r3 = r3 | r7
            goto L_0x0062
        L_0x0060:
            r6 = r30
        L_0x0062:
            r7 = r12 & 8
            if (r7 == 0) goto L_0x0069
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r8 = r11 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007c
            r8 = r31
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r9
            goto L_0x007e
        L_0x007c:
            r8 = r31
        L_0x007e:
            r9 = r12 & 16
            if (r9 == 0) goto L_0x0085
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0085:
            r10 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0098
            r10 = r32
            boolean r13 = r2.changed((boolean) r10)
            if (r13 == 0) goto L_0x0094
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r3 = r3 | r13
            goto L_0x009a
        L_0x0098:
            r10 = r32
        L_0x009a:
            r13 = r12 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a2
            r3 = r3 | r14
            goto L_0x00b4
        L_0x00a2:
            r14 = r14 & r11
            if (r14 != 0) goto L_0x00b4
            r14 = r33
            boolean r15 = r2.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r3 = r3 | r15
            goto L_0x00b6
        L_0x00b4:
            r14 = r33
        L_0x00b6:
            r15 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c1
            r3 = r3 | r16
            r0 = r34
            goto L_0x00d4
        L_0x00c1:
            r16 = r11 & r16
            r0 = r34
            if (r16 != 0) goto L_0x00d4
            boolean r17 = r2.changed((float) r0)
            if (r17 == 0) goto L_0x00d0
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r3 = r3 | r17
        L_0x00d4:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r11 & r17
            if (r17 != 0) goto L_0x00f0
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00e9
            r0 = r35
            boolean r17 = r2.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00eb
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00e9:
            r0 = r35
        L_0x00eb:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r3 = r3 | r17
            goto L_0x00f2
        L_0x00f0:
            r0 = r35
        L_0x00f2:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fb
            r3 = r3 | r17
            goto L_0x0111
        L_0x00fb:
            r17 = r11 & r17
            if (r17 != 0) goto L_0x0111
            r17 = r0
            r0 = r36
            boolean r18 = r2.changed((boolean) r0)
            if (r18 == 0) goto L_0x010c
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010c:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r3 = r3 | r18
            goto L_0x0115
        L_0x0111:
            r17 = r0
            r0 = r36
        L_0x0115:
            r0 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x011e
            r3 = r3 | r18
            goto L_0x0132
        L_0x011e:
            r0 = r11 & r18
            if (r0 != 0) goto L_0x0132
            r0 = r37
            boolean r18 = r2.changedInstance(r0)
            if (r18 == 0) goto L_0x012d
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012f
        L_0x012d:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012f:
            r3 = r3 | r18
            goto L_0x0134
        L_0x0132:
            r0 = r37
        L_0x0134:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r3 & r18
            r38 = r4
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r4) goto L_0x0159
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0147
            goto L_0x0159
        L_0x0147:
            r2.skipToGroupEnd()
            r7 = r34
            r9 = r36
            r24 = r2
            r2 = r5
            r3 = r6
            r4 = r8
            r5 = r10
            r6 = r14
            r8 = r35
            goto L_0x0258
        L_0x0159:
            r2.startDefaults()
            r0 = r11 & 1
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            if (r0 == 0) goto L_0x0184
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x016a
            goto L_0x0184
        L_0x016a:
            r2.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0173
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0173:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0178
            r3 = r3 & r4
        L_0x0178:
            r21 = r34
            r19 = r35
            r20 = r36
        L_0x017e:
            r13 = r6
        L_0x017f:
            r18 = r10
            r0 = r14
            goto L_0x01e5
        L_0x0184:
            if (r38 == 0) goto L_0x018b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x018b:
            r0 = r12 & 4
            r38 = r4
            r4 = 0
            if (r0 == 0) goto L_0x019a
            r0 = 3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r0 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(r4, r4, r2, r4, r0)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r0
        L_0x019a:
            if (r7 == 0) goto L_0x01a6
            float r0 = (float) r4
            float r0 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r0)
            androidx.compose.foundation.layout.PaddingValues r0 = androidx.compose.foundation.layout.PaddingKt.m768PaddingValues0680j_4(r0)
            r8 = r0
        L_0x01a6:
            if (r9 == 0) goto L_0x01a9
            r10 = r4
        L_0x01a9:
            if (r13 == 0) goto L_0x01b9
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            float r7 = (float) r4
            float r7 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r7)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r0 = r0.m623spacedBy0680j_4(r7)
            androidx.compose.foundation.layout.Arrangement$Vertical r0 = (androidx.compose.foundation.layout.Arrangement.Vertical) r0
            r14 = r0
        L_0x01b9:
            if (r15 == 0) goto L_0x01c1
            float r0 = (float) r4
            float r0 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r0)
            goto L_0x01c3
        L_0x01c1:
            r0 = r34
        L_0x01c3:
            r4 = r12 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x01d1
            androidx.compose.foundation.gestures.ScrollableDefaults r4 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r7 = 6
            androidx.compose.foundation.gestures.FlingBehavior r4 = r4.flingBehavior(r2, r7)
            r3 = r3 & r38
            goto L_0x01d3
        L_0x01d1:
            r4 = r35
        L_0x01d3:
            if (r17 == 0) goto L_0x01de
            r7 = 1
            r21 = r0
            r19 = r4
            r13 = r6
            r20 = r7
            goto L_0x017f
        L_0x01de:
            r20 = r36
            r21 = r0
            r19 = r4
            goto L_0x017e
        L_0x01e5:
            r2.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x01f7
            r4 = -1
            java.lang.String r6 = "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:162)"
            r7 = -8666074(0xffffffffff7bc426, float:-3.3465469E38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r4, r6)
        L_0x01f7:
            androidx.compose.foundation.gestures.Orientation r14 = androidx.compose.foundation.gestures.Orientation.Horizontal
            float r22 = r0.m645getSpacingD9Ej5fM()
            r4 = r3 & 14
            int r6 = r3 >> 12
            r6 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            int r6 = r3 >> 3
            r7 = r6 & 896(0x380, float:1.256E-42)
            r4 = r4 | r7
            androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider r15 = rememberRowSlots(r1, r0, r8, r2, r4)
            int r4 = r3 >> 6
            r4 = r4 & 14
            r4 = r4 | 48
            int r7 = r3 << 6
            r9 = r7 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r9
            int r9 = r3 << 3
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r9
            r4 = r4 | r10
            r10 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r10
            r4 = r4 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r6
            r4 = r4 | r9
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r9
            r4 = r4 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r7
            r25 = r4 | r6
            int r3 = r3 >> 27
            r26 = r3 & 14
            r27 = 0
            r23 = r37
            r24 = r2
            r16 = r5
            r17 = r8
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.m1045LazyStaggeredGridLJWHXA8(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x024a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x024a:
            r6 = r0
            r3 = r13
            r2 = r16
            r4 = r17
            r5 = r18
            r8 = r19
            r9 = r20
            r7 = r21
        L_0x0258:
            androidx.compose.runtime.ScopeUpdateScope r13 = r24.endRestartGroup()
            if (r13 == 0) goto L_0x026a
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1 r0 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1
            r10 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x026a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.m1039LazyHorizontalStaggeredGridcJHQLPU(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, float, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberRowSlots(StaggeredGridCells staggeredGridCells, Arrangement.Vertical vertical, PaddingValues paddingValues, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1532383053, "C(rememberRowSlots)P(1,2)184@8120L940:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1532383053, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowSlots (LazyStaggeredGridDsl.kt:184)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1011137904, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        boolean z = false;
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed((Object) staggeredGridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed((Object) vertical)) || (i & 48) == 32);
        if ((((i & 896) ^ 384) > 256 && composer.changed((Object) paddingValues)) || (i & 384) == 256) {
            z = true;
        }
        boolean z3 = z2 | z;
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyStaggeredGridSlotCache(new LazyStaggeredGridDslKt$rememberRowSlots$1$1(paddingValues, staggeredGridCells, vertical));
            composer.updateRememberedValue(rememberedValue);
        }
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridStaggeredGridSlotsProvider;
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function1 function1, Function1 function12, Function1 function13, Function4 function4, int i, Object obj) {
        Function1 function14 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyStaggeredGridDslKt$items$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        int size = list.size();
        Function1 lazyStaggeredGridDslKt$items$2$1 = function1 != null ? new LazyStaggeredGridDslKt$items$2$1(function1, list) : null;
        Function1 lazyStaggeredGridDslKt$items$3 = new LazyStaggeredGridDslKt$items$3(function12, list);
        if (function13 != null) {
            function14 = new LazyStaggeredGridDslKt$items$4$1(function13, list);
        }
        lazyStaggeredGridScope.items(size, lazyStaggeredGridDslKt$items$2$1, lazyStaggeredGridDslKt$items$3, function14, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new LazyStaggeredGridDslKt$items$5(function4, list)));
    }

    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function1<? super T, StaggeredGridItemSpan> function13, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        List<? extends T> list2 = list;
        int size = list2.size();
        Function1 function14 = null;
        Function1 lazyStaggeredGridDslKt$items$2$1 = function1 != null ? new LazyStaggeredGridDslKt$items$2$1(function1, list2) : null;
        Function1 lazyStaggeredGridDslKt$items$3 = new LazyStaggeredGridDslKt$items$3(function12, list2);
        if (function13 != null) {
            function14 = new LazyStaggeredGridDslKt$items$4$1(function13, list2);
        }
        lazyStaggeredGridScope.items(size, lazyStaggeredGridDslKt$items$2$1, lazyStaggeredGridDslKt$items$3, function14, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new LazyStaggeredGridDslKt$items$5(function4, list2)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function2 function2, Function2 function22, Function2 function23, Function5 function5, int i, Object obj) {
        Function1 function1 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = LazyStaggeredGridDslKt$itemsIndexed$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            function23 = null;
        }
        int size = list.size();
        Function1 lazyStaggeredGridDslKt$itemsIndexed$2$1 = function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list) : null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$3 = new LazyStaggeredGridDslKt$itemsIndexed$3(function22, list);
        if (function23 != null) {
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(function23, list);
        }
        lazyStaggeredGridScope.items(size, lazyStaggeredGridDslKt$itemsIndexed$2$1, lazyStaggeredGridDslKt$itemsIndexed$3, function1, ComposableLambdaKt.composableLambdaInstance(284833944, true, new LazyStaggeredGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function23, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        List<? extends T> list2 = list;
        int size = list2.size();
        Function1 function1 = null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$2$1 = function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list2) : null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$3 = new LazyStaggeredGridDslKt$itemsIndexed$3(function22, list2);
        if (function23 != null) {
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(function23, list2);
        }
        lazyStaggeredGridScope.items(size, lazyStaggeredGridDslKt$itemsIndexed$2$1, lazyStaggeredGridDslKt$itemsIndexed$3, function1, ComposableLambdaKt.composableLambdaInstance(284833944, true, new LazyStaggeredGridDslKt$itemsIndexed$5(function5, list2)));
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function1 function1, Function1 function12, Function1 function13, Function4 function4, int i, Object obj) {
        Function1 function14 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyStaggeredGridDslKt$items$6.INSTANCE;
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        int length = objArr.length;
        Function1 lazyStaggeredGridDslKt$items$7$1 = function1 != null ? new LazyStaggeredGridDslKt$items$7$1(function1, objArr) : null;
        Function1 lazyStaggeredGridDslKt$items$8 = new LazyStaggeredGridDslKt$items$8(function12, objArr);
        if (function13 != null) {
            function14 = new LazyStaggeredGridDslKt$items$9$1(function13, objArr);
        }
        lazyStaggeredGridScope.items(length, lazyStaggeredGridDslKt$items$7$1, lazyStaggeredGridDslKt$items$8, function14, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new LazyStaggeredGridDslKt$items$10(function4, objArr)));
    }

    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function1<? super T, StaggeredGridItemSpan> function13, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        T[] tArr2 = tArr;
        int length = tArr2.length;
        Function1 function14 = null;
        Function1 lazyStaggeredGridDslKt$items$7$1 = function1 != null ? new LazyStaggeredGridDslKt$items$7$1(function1, tArr2) : null;
        Function1 lazyStaggeredGridDslKt$items$8 = new LazyStaggeredGridDslKt$items$8(function12, tArr2);
        if (function13 != null) {
            function14 = new LazyStaggeredGridDslKt$items$9$1(function13, tArr2);
        }
        lazyStaggeredGridScope.items(length, lazyStaggeredGridDslKt$items$7$1, lazyStaggeredGridDslKt$items$8, function14, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new LazyStaggeredGridDslKt$items$10(function4, tArr2)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function2 function2, Function2 function22, Function2 function23, Function5 function5, int i, Object obj) {
        Function1 function1 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = LazyStaggeredGridDslKt$itemsIndexed$6.INSTANCE;
        }
        if ((i & 8) != 0) {
            function23 = null;
        }
        int length = objArr.length;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$7$1 = function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, objArr) : null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$8 = new LazyStaggeredGridDslKt$itemsIndexed$8(function22, objArr);
        if (function23 != null) {
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(function23, objArr);
        }
        lazyStaggeredGridScope.items(length, lazyStaggeredGridDslKt$itemsIndexed$7$1, lazyStaggeredGridDslKt$itemsIndexed$8, function1, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new LazyStaggeredGridDslKt$itemsIndexed$10(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function23, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        T[] tArr2 = tArr;
        int length = tArr2.length;
        Function1 function1 = null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$7$1 = function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, tArr2) : null;
        Function1 lazyStaggeredGridDslKt$itemsIndexed$8 = new LazyStaggeredGridDslKt$itemsIndexed$8(function22, tArr2);
        if (function23 != null) {
            function1 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(function23, tArr2);
        }
        lazyStaggeredGridScope.items(length, lazyStaggeredGridDslKt$itemsIndexed$7$1, lazyStaggeredGridDslKt$itemsIndexed$8, function1, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new LazyStaggeredGridDslKt$itemsIndexed$10(function5, tArr2)));
    }
}
