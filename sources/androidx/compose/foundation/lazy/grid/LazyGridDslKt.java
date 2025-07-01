package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a~\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001a%\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010#\u001a%\u0010$\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010%\u001aÛ\u0001\u0010&\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0(2%\b\n\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010\u001420\b\n\u0010.\u001a*\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010/¢\u0006\u0002\b\u00162%\b\n\u00102\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010/¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u00106\u001aÛ\u0001\u0010&\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0\u001c2%\b\n\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010\u001420\b\n\u0010.\u001a*\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010/¢\u0006\u0002\b\u00162%\b\n\u00102\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010/¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u00107\u001a¯\u0002\u00108\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0(2:\b\n\u0010)\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010/2E\b\n\u0010.\u001a?\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010:¢\u0006\u0002\b\u00162:\b\u0006\u00102\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0/2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u0010;\u001a¯\u0002\u00108\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0\u001c2:\b\n\u0010)\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010/2E\b\n\u0010.\u001a?\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010:¢\u0006\u0002\b\u00162:\b\u0006\u00102\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0/2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u0010<¨\u0006="}, d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridDsl.kt */
public final class LazyGridDslKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells r28, androidx.compose.ui.Modifier r29, androidx.compose.foundation.lazy.grid.LazyGridState r30, androidx.compose.foundation.layout.PaddingValues r31, boolean r32, androidx.compose.foundation.layout.Arrangement.Vertical r33, androidx.compose.foundation.layout.Arrangement.Horizontal r34, androidx.compose.foundation.gestures.FlingBehavior r35, boolean r36, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r28
            r11 = r39
            r12 = r40
            r0 = 1485410512(0x588990d0, float:1.21004046E15)
            r2 = r38
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LazyVerticalGrid)P(!1,5,7,2,6,9,4,3,8)64@2980L23,70@3340L15,75@3468L71,74@3442L481:LazyGridDsl.kt#7791vq"
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
            boolean r7 = r2.changed((java.lang.Object) r6)
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
            r13 = 196608(0x30000, float:2.75506E-40)
            r14 = r11 & r13
            if (r14 != 0) goto L_0x00b5
            r14 = r12 & 32
            if (r14 != 0) goto L_0x00af
            r14 = r33
            boolean r15 = r2.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b1
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00af:
            r14 = r33
        L_0x00b1:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r3 = r3 | r15
            goto L_0x00b7
        L_0x00b5:
            r14 = r33
        L_0x00b7:
            r15 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c4
            r3 = r3 | r16
            r38 = r13
            r13 = r34
            goto L_0x00d9
        L_0x00c4:
            r16 = r11 & r16
            r38 = r13
            r13 = r34
            if (r16 != 0) goto L_0x00d9
            boolean r16 = r2.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x00d5
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r3 = r3 | r16
        L_0x00d9:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x00f5
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00ee
            r0 = r35
            boolean r17 = r2.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00f0
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00ee:
            r0 = r35
        L_0x00f0:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r3 = r3 | r17
            goto L_0x00f7
        L_0x00f5:
            r0 = r35
        L_0x00f7:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0100
            r3 = r3 | r17
            goto L_0x0116
        L_0x0100:
            r17 = r11 & r17
            if (r17 != 0) goto L_0x0116
            r17 = r0
            r0 = r36
            boolean r18 = r2.changed((boolean) r0)
            if (r18 == 0) goto L_0x0111
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0111:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0113:
            r3 = r3 | r18
            goto L_0x011a
        L_0x0116:
            r17 = r0
            r0 = r36
        L_0x011a:
            r0 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0123
            r3 = r3 | r18
            goto L_0x0137
        L_0x0123:
            r0 = r11 & r18
            if (r0 != 0) goto L_0x0137
            r0 = r37
            boolean r18 = r2.changedInstance(r0)
            if (r18 == 0) goto L_0x0132
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0134
        L_0x0132:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0134:
            r3 = r3 | r18
            goto L_0x0139
        L_0x0137:
            r0 = r37
        L_0x0139:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r3 & r18
            r18 = r4
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r4) goto L_0x015d
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x014c
            goto L_0x015d
        L_0x014c:
            r2.skipToGroupEnd()
            r9 = r36
            r24 = r2
            r2 = r5
            r3 = r6
            r4 = r8
            r5 = r10
            r7 = r13
            r6 = r14
            r8 = r35
            goto L_0x0264
        L_0x015d:
            r2.startDefaults()
            r0 = r11 & 1
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r19 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x0192
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0171
            goto L_0x0192
        L_0x0171:
            r2.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x017a
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x017a:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0180
            r3 = r3 & r19
        L_0x0180:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0185
            r3 = r3 & r4
        L_0x0185:
            r19 = r35
            r20 = r36
            r17 = r10
        L_0x018b:
            r0 = r13
            r21 = r14
            r13 = r5
            r14 = r6
            goto L_0x01f6
        L_0x0192:
            if (r18 == 0) goto L_0x0199
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x0199:
            r0 = r12 & 4
            r18 = r4
            r4 = 0
            if (r0 == 0) goto L_0x01a8
            r0 = 3
            androidx.compose.foundation.lazy.grid.LazyGridState r0 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r4, r4, r2, r4, r0)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r0
        L_0x01a8:
            if (r7 == 0) goto L_0x01b4
            float r0 = (float) r4
            float r0 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r0)
            androidx.compose.foundation.layout.PaddingValues r0 = androidx.compose.foundation.layout.PaddingKt.m768PaddingValues0680j_4(r0)
            r8 = r0
        L_0x01b4:
            if (r9 == 0) goto L_0x01b7
            goto L_0x01b8
        L_0x01b7:
            r4 = r10
        L_0x01b8:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x01cc
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r4 != 0) goto L_0x01c5
            androidx.compose.foundation.layout.Arrangement$Vertical r0 = r0.getTop()
            goto L_0x01c9
        L_0x01c5:
            androidx.compose.foundation.layout.Arrangement$Vertical r0 = r0.getBottom()
        L_0x01c9:
            r3 = r3 & r19
            r14 = r0
        L_0x01cc:
            if (r15 == 0) goto L_0x01d5
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r0 = r0.getStart()
            r13 = r0
        L_0x01d5:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01e3
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r7 = 6
            androidx.compose.foundation.gestures.FlingBehavior r0 = r0.flingBehavior(r2, r7)
            r3 = r3 & r18
            goto L_0x01e5
        L_0x01e3:
            r0 = r35
        L_0x01e5:
            if (r17 == 0) goto L_0x01ef
            r7 = 1
            r19 = r0
            r17 = r4
            r20 = r7
            goto L_0x018b
        L_0x01ef:
            r20 = r36
            r19 = r0
            r17 = r4
            goto L_0x018b
        L_0x01f6:
            r2.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0208
            r4 = -1
            java.lang.String r5 = "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)"
            r6 = 1485410512(0x588990d0, float:1.21004046E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r3, r4, r5)
        L_0x0208:
            r4 = r3 & 14
            int r5 = r3 >> 15
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            int r5 = r3 >> 3
            r6 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r6
            androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider r15 = rememberColumnWidthSums(r1, r0, r8, r2, r4)
            r4 = r5 & 14
            r4 = r4 | r38
            r6 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            r6 = r3 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r3
            r4 = r4 | r6
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r5
            r4 = r4 | r6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r6
            r4 = r4 | r5
            int r5 = r3 << 9
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r5
            r4 = r4 | r6
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r5 = r5 & r6
            r25 = r4 | r5
            int r3 = r3 >> 27
            r26 = r3 & 14
            r27 = 0
            r18 = 1
            r23 = r37
            r22 = r0
            r24 = r2
            r16 = r8
            androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0256
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0256:
            r2 = r13
            r3 = r14
            r4 = r16
            r5 = r17
            r8 = r19
            r9 = r20
            r6 = r21
            r7 = r22
        L_0x0264:
            androidx.compose.runtime.ScopeUpdateScope r13 = r24.endRestartGroup()
            if (r13 == 0) goto L_0x0276
            androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1 r0 = new androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1
            r10 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0276:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells r28, androidx.compose.ui.Modifier r29, androidx.compose.foundation.lazy.grid.LazyGridState r30, androidx.compose.foundation.layout.PaddingValues r31, boolean r32, androidx.compose.foundation.layout.Arrangement.Horizontal r33, androidx.compose.foundation.layout.Arrangement.Vertical r34, androidx.compose.foundation.gestures.FlingBehavior r35, boolean r36, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r28
            r11 = r39
            r12 = r40
            r0 = 2123608858(0x7e93b31a, float:9.816323E37)
            r2 = r38
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LazyHorizontalGrid)P(6,4,7,1,5,3,9,2,8)117@5477L23,123@5834L15,128@5962L64,127@5936L475:LazyGridDsl.kt#7791vq"
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
            boolean r7 = r2.changed((java.lang.Object) r6)
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
            r13 = 196608(0x30000, float:2.75506E-40)
            r14 = r11 & r13
            if (r14 != 0) goto L_0x00b5
            r14 = r12 & 32
            if (r14 != 0) goto L_0x00af
            r14 = r33
            boolean r15 = r2.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b1
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00af:
            r14 = r33
        L_0x00b1:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r3 = r3 | r15
            goto L_0x00b7
        L_0x00b5:
            r14 = r33
        L_0x00b7:
            r15 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c4
            r3 = r3 | r16
            r38 = r13
            r13 = r34
            goto L_0x00d9
        L_0x00c4:
            r16 = r11 & r16
            r38 = r13
            r13 = r34
            if (r16 != 0) goto L_0x00d9
            boolean r16 = r2.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x00d5
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r3 = r3 | r16
        L_0x00d9:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x00f5
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00ee
            r0 = r35
            boolean r17 = r2.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00f0
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00ee:
            r0 = r35
        L_0x00f0:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r3 = r3 | r17
            goto L_0x00f7
        L_0x00f5:
            r0 = r35
        L_0x00f7:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0100
            r3 = r3 | r17
            goto L_0x0116
        L_0x0100:
            r17 = r11 & r17
            if (r17 != 0) goto L_0x0116
            r17 = r0
            r0 = r36
            boolean r18 = r2.changed((boolean) r0)
            if (r18 == 0) goto L_0x0111
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0111:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0113:
            r3 = r3 | r18
            goto L_0x011a
        L_0x0116:
            r17 = r0
            r0 = r36
        L_0x011a:
            r0 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0123
            r3 = r3 | r18
            goto L_0x0137
        L_0x0123:
            r0 = r11 & r18
            if (r0 != 0) goto L_0x0137
            r0 = r37
            boolean r18 = r2.changedInstance(r0)
            if (r18 == 0) goto L_0x0132
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0134
        L_0x0132:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0134:
            r3 = r3 | r18
            goto L_0x0139
        L_0x0137:
            r0 = r37
        L_0x0139:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r3 & r18
            r18 = r4
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r4) goto L_0x015d
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x014c
            goto L_0x015d
        L_0x014c:
            r2.skipToGroupEnd()
            r9 = r36
            r24 = r2
            r2 = r5
            r3 = r6
            r4 = r8
            r5 = r10
            r7 = r13
            r6 = r14
            r8 = r35
            goto L_0x0266
        L_0x015d:
            r2.startDefaults()
            r0 = r11 & 1
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r19 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x0192
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0171
            goto L_0x0192
        L_0x0171:
            r2.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x017a
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x017a:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0180
            r3 = r3 & r19
        L_0x0180:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0185
            r3 = r3 & r4
        L_0x0185:
            r19 = r35
            r20 = r36
            r17 = r10
        L_0x018b:
            r0 = r13
            r22 = r14
            r13 = r5
            r14 = r6
            goto L_0x01f6
        L_0x0192:
            if (r18 == 0) goto L_0x0199
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x0199:
            r0 = r12 & 4
            r18 = r4
            r4 = 0
            if (r0 == 0) goto L_0x01a8
            r0 = 3
            androidx.compose.foundation.lazy.grid.LazyGridState r0 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r4, r4, r2, r4, r0)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r0
        L_0x01a8:
            if (r7 == 0) goto L_0x01b4
            float r0 = (float) r4
            float r0 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r0)
            androidx.compose.foundation.layout.PaddingValues r0 = androidx.compose.foundation.layout.PaddingKt.m768PaddingValues0680j_4(r0)
            r8 = r0
        L_0x01b4:
            if (r9 == 0) goto L_0x01b7
            goto L_0x01b8
        L_0x01b7:
            r4 = r10
        L_0x01b8:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x01cc
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r4 != 0) goto L_0x01c5
            androidx.compose.foundation.layout.Arrangement$Horizontal r0 = r0.getStart()
            goto L_0x01c9
        L_0x01c5:
            androidx.compose.foundation.layout.Arrangement$Horizontal r0 = r0.getEnd()
        L_0x01c9:
            r3 = r3 & r19
            r14 = r0
        L_0x01cc:
            if (r15 == 0) goto L_0x01d5
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r0 = r0.getTop()
            r13 = r0
        L_0x01d5:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01e3
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r7 = 6
            androidx.compose.foundation.gestures.FlingBehavior r0 = r0.flingBehavior(r2, r7)
            r3 = r3 & r18
            goto L_0x01e5
        L_0x01e3:
            r0 = r35
        L_0x01e5:
            if (r17 == 0) goto L_0x01ef
            r7 = 1
            r19 = r0
            r17 = r4
            r20 = r7
            goto L_0x018b
        L_0x01ef:
            r20 = r36
            r19 = r0
            r17 = r4
            goto L_0x018b
        L_0x01f6:
            r2.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0208
            r4 = -1
            java.lang.String r5 = "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:126)"
            r6 = 2123608858(0x7e93b31a, float:9.816323E37)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r3, r4, r5)
        L_0x0208:
            r4 = r3 & 14
            int r5 = r3 >> 15
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            int r5 = r3 >> 3
            r6 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r6
            androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider r15 = rememberRowHeightSums(r1, r0, r8, r2, r4)
            r4 = r5 & 14
            r4 = r4 | r38
            r6 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            r6 = r3 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r3
            r4 = r4 | r6
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r5
            r4 = r4 | r6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r6
            r4 = r4 | r5
            int r5 = r3 << 6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r5 = r5 & r6
            r4 = r4 | r5
            int r5 = r3 << 12
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r5 = r5 & r6
            r25 = r4 | r5
            int r3 = r3 >> 27
            r26 = r3 & 14
            r27 = 0
            r18 = 0
            r23 = r37
            r21 = r0
            r24 = r2
            r16 = r8
            androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0258
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0258:
            r2 = r13
            r3 = r14
            r4 = r16
            r5 = r17
            r8 = r19
            r9 = r20
            r7 = r21
            r6 = r22
        L_0x0266:
            androidx.compose.runtime.ScopeUpdateScope r13 = r24.endRestartGroup()
            if (r13 == 0) goto L_0x0278
            androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1 r0 = new androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1
            r10 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0278:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final LazyGridSlotsProvider rememberColumnWidthSums(GridCells gridCells, Arrangement.Horizontal horizontal, PaddingValues paddingValues, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1632454918, "C(rememberColumnWidthSums)P(!1,2)148@6622L975:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1632454918, i, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:148)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -2103044334, "CC(remember):LazyGridDsl.kt#9igjgp");
        boolean z = false;
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed((Object) gridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed((Object) horizontal)) || (i & 48) == 32);
        if ((((i & 896) ^ 384) > 256 && composer.changed((Object) paddingValues)) || (i & 384) == 256) {
            z = true;
        }
        boolean z3 = z2 | z;
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new GridSlotCache(new LazyGridDslKt$rememberColumnWidthSums$1$1(paddingValues, gridCells, horizontal));
            composer.updateRememberedValue(rememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridSlotsProvider;
    }

    private static final LazyGridSlotsProvider rememberRowHeightSums(GridCells gridCells, Arrangement.Vertical vertical, PaddingValues paddingValues, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -741512409, "C(rememberRowHeightSums)P(1,2)181@7795L909:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-741512409, i, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:181)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -380187903, "CC(remember):LazyGridDsl.kt#9igjgp");
        boolean z = false;
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed((Object) gridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed((Object) vertical)) || (i & 48) == 32);
        if ((((i & 896) ^ 384) > 256 && composer.changed((Object) paddingValues)) || (i & 384) == 256) {
            z = true;
        }
        boolean z3 = z2 | z;
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new GridSlotCache(new LazyGridDslKt$rememberRowHeightSums$1$1(paddingValues, gridCells, vertical));
            composer.updateRememberedValue(rememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridSlotsProvider;
    }

    /* access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List list, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        Function2 function22 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = LazyGridDslKt$items$1.INSTANCE;
        }
        int size = list.size();
        Function1 lazyGridDslKt$items$2 = function1 != null ? new LazyGridDslKt$items$2(function1, list) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$3(function2, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$items$2, function22, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        List<? extends T> list2 = list;
        int size = list2.size();
        Function2 function22 = null;
        Function1 lazyGridDslKt$items$2 = function1 != null ? new LazyGridDslKt$items$2(function1, list2) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$3(function2, list2);
        }
        lazyGridScope.items(size, lazyGridDslKt$items$2, function22, new LazyGridDslKt$items$4(function12, list2), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list2)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List list, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        Function2 function23 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = LazyGridDslKt$itemsIndexed$1.INSTANCE;
        }
        int size = list.size();
        Function1 lazyGridDslKt$itemsIndexed$2 = function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$3(function3, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$itemsIndexed$2, function23, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        List<? extends T> list2 = list;
        int size = list2.size();
        Function2 function23 = null;
        Function1 lazyGridDslKt$itemsIndexed$2 = function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list2) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$3(function3, list2);
        }
        lazyGridScope.items(size, lazyGridDslKt$itemsIndexed$2, function23, new LazyGridDslKt$itemsIndexed$4(function22, list2), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list2)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] objArr, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        Function2 function22 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = LazyGridDslKt$items$6.INSTANCE;
        }
        int length = objArr.length;
        Function1 lazyGridDslKt$items$7 = function1 != null ? new LazyGridDslKt$items$7(function1, objArr) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$8(function2, objArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$items$7, function22, new LazyGridDslKt$items$9(function12, objArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, objArr)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        T[] tArr2 = tArr;
        int length = tArr2.length;
        Function2 function22 = null;
        Function1 lazyGridDslKt$items$7 = function1 != null ? new LazyGridDslKt$items$7(function1, tArr2) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$8(function2, tArr2);
        }
        lazyGridScope.items(length, lazyGridDslKt$items$7, function22, new LazyGridDslKt$items$9(function12, tArr2), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, tArr2)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] objArr, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        Function2 function23 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = LazyGridDslKt$itemsIndexed$6.INSTANCE;
        }
        int length = objArr.length;
        Function1 lazyGridDslKt$itemsIndexed$7 = function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, objArr) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$8(function3, objArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$itemsIndexed$7, function23, new LazyGridDslKt$itemsIndexed$9(function22, objArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        T[] tArr2 = tArr;
        int length = tArr2.length;
        Function2 function23 = null;
        Function1 lazyGridDslKt$itemsIndexed$7 = function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, tArr2) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$8(function3, tArr2);
        }
        lazyGridScope.items(length, lazyGridDslKt$itemsIndexed$7, function23, new LazyGridDslKt$itemsIndexed$9(function22, tArr2), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, tArr2)));
    }
}
