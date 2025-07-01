package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.unit.Constraints;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001ag\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001ag\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u001b2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010!\u001a5\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010&\u001a\u0001\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172#\u0010.\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002¢\u0006\u0002\u00102\u001a[\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002¢\u0006\u0002\u00106\u001aS\u00107\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172\u0006\u00108\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0002\u001a\u0001\u00109\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172#\u0010.\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172\u0006\u00108\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002\u001a%\u0010:\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010;\u001a5\u0010<\u001a\u00020#2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010=\u001a\\\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020J2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0000ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a\u001c\u0010M\u001a\u00020\u000f*\u00020+2\u0006\u0010N\u001a\u00020O2\u0006\u0010,\u001a\u00020\u000fH\u0000\u001a\u001c\u0010P\u001a\u00020\u000f*\u00020+2\u0006\u0010N\u001a\u00020O2\u0006\u0010.\u001a\u00020\u000fH\u0000\u001a<\u0010Q\u001a\u00020(*\u00020E2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020R2\u0014\u0010S\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010T\u0012\u0004\u0012\u00020\u00070\u0014H\u0000ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001aT\u0010W\u001a\u00020?*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020?0[2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u000204H\u0000ø\u0001\u0000¢\u0006\u0004\b^\u0010_\u001a\u001e\u0010`\u001a\u0004\u0018\u00010E*\b\u0012\u0004\u0012\u00020E0D2\b\u0010a\u001a\u0004\u0018\u00010bH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c"}, d2 = {"CROSS_AXIS_ALIGNMENT_START", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_START", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_TOP", "getCROSS_AXIS_ALIGNMENT_TOP", "FlowColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "maxItemsInEachColumn", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowColumnOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowRowScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurementMultiContentHelper", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "intrinsicCrossAxisSize", "Landroidx/collection/IntIntPair;", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "crossAxisSize", "mainAxisAvailable", "mainAxisSpacing", "crossAxisSpacing", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "mainAxisSizes", "", "crossAxisSizes", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "maxIntrinsicMainAxisSize", "crossAxisAvailable", "minIntrinsicMainAxisSize", "rowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "breakDownItems", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurablesIterator", "", "Landroidx/compose/ui/layout/Measurable;", "mainAxisSpacingDp", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacingDp", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "crossAxisMin", "isHorizontal", "", "mainAxisMin", "measureAndCache", "Landroidx/compose/ui/unit/Constraints;", "storePlaceable", "Landroidx/compose/ui/layout/Placeable;", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function1;)J", "placeHelper", "mainAxisTotalSize", "crossAxisTotalSize", "items", "Landroidx/compose/runtime/collection/MutableVector;", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "safeNext", "info", "Landroidx/compose/foundation/layout/FlowLineInfo;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
public final class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START = CrossAxisAlignment.Companion.horizontal$foundation_layout_release(Alignment.Companion.getStart());
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP = CrossAxisAlignment.Companion.vertical$foundation_layout_release(Alignment.Companion.getTop());

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: androidx.compose.foundation.layout.FlowLayoutOverflowState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0197, code lost:
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0199;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FlowRow(androidx.compose.ui.Modifier r19, androidx.compose.foundation.layout.Arrangement.Horizontal r20, androidx.compose.foundation.layout.Arrangement.Vertical r21, int r22, int r23, androidx.compose.foundation.layout.FlowRowOverflow r24, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.FlowRowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r7 = r25
            r8 = r27
            r0 = 437853230(0x1a191c2e, float:3.1662422E-23)
            r1 = r26
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FlowRow)P(4,1,6,2,3,5)93@4089L65,96@4179L166,103@4391L261,110@4658L105:FlowLayout.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r28 & 1
            if (r1 == 0) goto L_0x001c
            r2 = r8 | 6
            r3 = r2
            r2 = r19
            goto L_0x0030
        L_0x001c:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r19
            boolean r3 = r14.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r8
            goto L_0x0030
        L_0x002d:
            r2 = r19
            r3 = r8
        L_0x0030:
            r4 = r28 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x004a
            r5 = r20
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r20
        L_0x004c:
            r6 = r28 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r9 = r8 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0066
            r9 = r21
            boolean r10 = r14.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0062
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r10
            goto L_0x0068
        L_0x0066:
            r9 = r21
        L_0x0068:
            r10 = r28 & 8
            if (r10 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r11 = r8 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0082
            r11 = r22
            boolean r12 = r14.changed((int) r11)
            if (r12 == 0) goto L_0x007e
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r12
            goto L_0x0084
        L_0x0082:
            r11 = r22
        L_0x0084:
            r12 = r28 & 16
            if (r12 == 0) goto L_0x008b
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x008b:
            r13 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009e
            r13 = r23
            boolean r15 = r14.changed((int) r13)
            if (r15 == 0) goto L_0x009a
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r3 = r3 | r15
            goto L_0x00a0
        L_0x009e:
            r13 = r23
        L_0x00a0:
            r15 = r28 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r15 == 0) goto L_0x00ab
            r3 = r3 | r16
            r0 = r24
            goto L_0x00be
        L_0x00ab:
            r16 = r8 & r16
            r0 = r24
            if (r16 != 0) goto L_0x00be
            boolean r16 = r14.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x00ba
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r3 = r3 | r16
        L_0x00be:
            r16 = r28 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c7
            r3 = r3 | r17
            goto L_0x00d8
        L_0x00c7:
            r16 = r8 & r17
            if (r16 != 0) goto L_0x00d8
            boolean r16 = r14.changedInstance(r7)
            if (r16 == 0) goto L_0x00d4
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r3 = r3 | r16
        L_0x00d8:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r3 & r16
            r16 = r1
            r1 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r1) goto L_0x00f7
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00eb
            goto L_0x00f7
        L_0x00eb:
            r14.skipToGroupEnd()
            r6 = r24
            r1 = r2
            r2 = r5
            r3 = r9
            r5 = r13
        L_0x00f4:
            r4 = r11
            goto L_0x0299
        L_0x00f7:
            if (r16 == 0) goto L_0x00fe
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x00ff
        L_0x00fe:
            r0 = r2
        L_0x00ff:
            if (r4 == 0) goto L_0x0108
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r1 = r1.getStart()
            goto L_0x0109
        L_0x0108:
            r1 = r5
        L_0x0109:
            if (r6 == 0) goto L_0x0112
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r2 = r2.getTop()
            r9 = r2
        L_0x0112:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r10 == 0) goto L_0x0118
            r11 = r2
        L_0x0118:
            if (r12 == 0) goto L_0x011c
            r12 = r2
            goto L_0x011d
        L_0x011c:
            r12 = r13
        L_0x011d:
            if (r15 == 0) goto L_0x0126
            androidx.compose.foundation.layout.FlowRowOverflow$Companion r2 = androidx.compose.foundation.layout.FlowRowOverflow.Companion
            androidx.compose.foundation.layout.FlowRowOverflow r2 = r2.getClip()
            goto L_0x0128
        L_0x0126:
            r2 = r24
        L_0x0128:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0137
            r4 = -1
            java.lang.String r5 = "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:92)"
            r6 = 437853230(0x1a191c2e, float:3.1662422E-23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r3, r4, r5)
        L_0x0137:
            r4 = 454955587(0x1b1e1243, float:1.3075354E-22)
            java.lang.String r5 = "CC(remember):FlowLayout.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r5)
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r3
            r10 = 1
            r13 = 131072(0x20000, float:1.83671E-40)
            if (r4 != r13) goto L_0x0149
            r13 = r10
            goto L_0x014a
        L_0x0149:
            r13 = 0
        L_0x014a:
            java.lang.Object r15 = r14.rememberedValue()
            if (r13 != 0) goto L_0x0158
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r15 != r13) goto L_0x015f
        L_0x0158:
            androidx.compose.foundation.layout.FlowLayoutOverflowState r15 = r2.createOverflowState$foundation_layout_release()
            r14.updateRememberedValue(r15)
        L_0x015f:
            r13 = r15
            androidx.compose.foundation.layout.FlowLayoutOverflowState r13 = (androidx.compose.foundation.layout.FlowLayoutOverflowState) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            int r15 = r3 >> 3
            r15 = r15 & 8190(0x1ffe, float:1.1477E-41)
            r18 = r9
            r9 = r1
            r1 = r10
            r10 = r18
            androidx.compose.ui.layout.MultiContentMeasurePolicy r15 = rowMeasurementMultiContentHelper(r9, r10, r11, r12, r13, r14, r15)
            r6 = 454965447(0x1b1e38c7, float:1.30878E-22)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r6, r5)
            r5 = 131072(0x20000, float:1.83671E-40)
            if (r4 != r5) goto L_0x017f
            r4 = r1
            goto L_0x0180
        L_0x017f:
            r4 = 0
        L_0x0180:
            r5 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r5
            r5 = 1048576(0x100000, float:1.469368E-39)
            if (r3 != r5) goto L_0x0189
            r3 = r1
            goto L_0x018a
        L_0x0189:
            r3 = 0
        L_0x018a:
            r3 = r3 | r4
            java.lang.Object r4 = r14.rememberedValue()
            if (r3 != 0) goto L_0x0199
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x01b6
        L_0x0199:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = r3
            java.util.List r4 = (java.util.List) r4
            androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$list$1$1 r3 = new androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$list$1$1
            r3.<init>(r7)
            r5 = -139531073(0xfffffffff7aeecbf, float:-7.0957925E33)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r5, r1, r3)
            r4.add(r1)
            r2.addOverflowComposables$foundation_layout_release(r13, r4)
            r14.updateRememberedValue(r4)
        L_0x01b6:
            java.util.List r4 = (java.util.List) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r1 = 1399185516(0x5365e06c, float:9.8731269E11)
            java.lang.String r3 = "CC(Layout)P(!1,2)174@7002L62,171@6888L182:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r3)
            kotlin.jvm.functions.Function2 r1 = androidx.compose.ui.layout.LayoutKt.combineAsVirtualLayouts(r4)
            r3 = -290761165(0xffffffffeeab5633, float:-2.6513073E28)
            java.lang.String r4 = "CC(remember):Layout.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            boolean r3 = r14.changed((java.lang.Object) r15)
            java.lang.Object r4 = r14.rememberedValue()
            if (r3 != 0) goto L_0x01e1
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x01e8
        L_0x01e1:
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.ui.layout.MultiContentMeasurePolicyKt.createMeasurePolicy(r15)
            r14.updateRememberedValue(r4)
        L_0x01e8:
            androidx.compose.ui.layout.MeasurePolicy r4 = (androidx.compose.ui.layout.MeasurePolicy) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r5 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r5)
            r3 = 0
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r14, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            r15 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r16 = r0
            java.lang.String r0 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r15, r0)
            androidx.compose.runtime.Applier r0 = r14.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x021d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x021d:
            r14.startReusableNode()
            boolean r0 = r14.getInserting()
            if (r0 == 0) goto L_0x022a
            r14.createNode(r13)
            goto L_0x022d
        L_0x022a:
            r14.useNode()
        L_0x022d:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m3675constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r4, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r3, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r4 = r0.getInserting()
            if (r4 != 0) goto L_0x025d
            java.lang.Object r4 = r0.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r13)
            if (r4 != 0) goto L_0x026b
        L_0x025d:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r0.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r0.apply(r4, r3)
        L_0x026b:
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r6, r3)
            r3 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r1.invoke(r14, r0)
            r14.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0291
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0291:
            r6 = r2
            r2 = r9
            r3 = r10
            r5 = r12
            r1 = r16
            goto L_0x00f4
        L_0x0299:
            androidx.compose.runtime.ScopeUpdateScope r10 = r14.endRestartGroup()
            if (r10 == 0) goto L_0x02ab
            androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$1 r0 = new androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$1
            r9 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x02ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.FlowRow(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, int, int, androidx.compose.foundation.layout.FlowRowOverflow, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: androidx.compose.foundation.layout.FlowLayoutOverflowState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0197, code lost:
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0199;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FlowColumn(androidx.compose.ui.Modifier r19, androidx.compose.foundation.layout.Arrangement.Vertical r20, androidx.compose.foundation.layout.Arrangement.Horizontal r21, int r22, int r23, androidx.compose.foundation.layout.FlowColumnOverflow r24, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.FlowColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r7 = r25
            r8 = r27
            r0 = -1704849416(0xffffffff9a620ff8, float:-4.6748604E-23)
            r1 = r26
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FlowColumn)P(4,6,1,2,3,5)157@6483L65,160@6573L172,167@6791L264,173@7060L105:FlowLayout.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r28 & 1
            if (r1 == 0) goto L_0x001c
            r2 = r8 | 6
            r3 = r2
            r2 = r19
            goto L_0x0030
        L_0x001c:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r19
            boolean r3 = r14.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r8
            goto L_0x0030
        L_0x002d:
            r2 = r19
            r3 = r8
        L_0x0030:
            r4 = r28 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x004a
            r5 = r20
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r20
        L_0x004c:
            r6 = r28 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r9 = r8 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0066
            r9 = r21
            boolean r10 = r14.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0062
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r10
            goto L_0x0068
        L_0x0066:
            r9 = r21
        L_0x0068:
            r10 = r28 & 8
            if (r10 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r11 = r8 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0082
            r11 = r22
            boolean r12 = r14.changed((int) r11)
            if (r12 == 0) goto L_0x007e
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r12
            goto L_0x0084
        L_0x0082:
            r11 = r22
        L_0x0084:
            r12 = r28 & 16
            if (r12 == 0) goto L_0x008b
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x008b:
            r13 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009e
            r13 = r23
            boolean r15 = r14.changed((int) r13)
            if (r15 == 0) goto L_0x009a
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r3 = r3 | r15
            goto L_0x00a0
        L_0x009e:
            r13 = r23
        L_0x00a0:
            r15 = r28 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r15 == 0) goto L_0x00ab
            r3 = r3 | r16
            r0 = r24
            goto L_0x00be
        L_0x00ab:
            r16 = r8 & r16
            r0 = r24
            if (r16 != 0) goto L_0x00be
            boolean r16 = r14.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x00ba
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r3 = r3 | r16
        L_0x00be:
            r16 = r28 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c7
            r3 = r3 | r17
            goto L_0x00d8
        L_0x00c7:
            r16 = r8 & r17
            if (r16 != 0) goto L_0x00d8
            boolean r16 = r14.changedInstance(r7)
            if (r16 == 0) goto L_0x00d4
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r3 = r3 | r16
        L_0x00d8:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r3 & r16
            r16 = r1
            r1 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r1) goto L_0x00f7
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00eb
            goto L_0x00f7
        L_0x00eb:
            r14.skipToGroupEnd()
            r6 = r24
            r1 = r2
            r2 = r5
            r3 = r9
            r5 = r13
        L_0x00f4:
            r4 = r11
            goto L_0x0299
        L_0x00f7:
            if (r16 == 0) goto L_0x00fe
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x00ff
        L_0x00fe:
            r0 = r2
        L_0x00ff:
            if (r4 == 0) goto L_0x0108
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r1 = r1.getTop()
            goto L_0x0109
        L_0x0108:
            r1 = r5
        L_0x0109:
            if (r6 == 0) goto L_0x0112
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = r2.getStart()
            r9 = r2
        L_0x0112:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r10 == 0) goto L_0x0118
            r11 = r2
        L_0x0118:
            if (r12 == 0) goto L_0x011c
            r12 = r2
            goto L_0x011d
        L_0x011c:
            r12 = r13
        L_0x011d:
            if (r15 == 0) goto L_0x0126
            androidx.compose.foundation.layout.FlowColumnOverflow$Companion r2 = androidx.compose.foundation.layout.FlowColumnOverflow.Companion
            androidx.compose.foundation.layout.FlowColumnOverflow r2 = r2.getClip()
            goto L_0x0128
        L_0x0126:
            r2 = r24
        L_0x0128:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0137
            r4 = -1
            java.lang.String r5 = "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:156)"
            r6 = -1704849416(0xffffffff9a620ff8, float:-4.6748604E-23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r3, r4, r5)
        L_0x0137:
            r4 = -1515615249(0xffffffffa5a98bef, float:-2.941165E-16)
            java.lang.String r5 = "CC(remember):FlowLayout.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r5)
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r3
            r10 = 1
            r13 = 131072(0x20000, float:1.83671E-40)
            if (r4 != r13) goto L_0x0149
            r13 = r10
            goto L_0x014a
        L_0x0149:
            r13 = 0
        L_0x014a:
            java.lang.Object r15 = r14.rememberedValue()
            if (r13 != 0) goto L_0x0158
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r15 != r13) goto L_0x015f
        L_0x0158:
            androidx.compose.foundation.layout.FlowLayoutOverflowState r15 = r2.createOverflowState$foundation_layout_release()
            r14.updateRememberedValue(r15)
        L_0x015f:
            r13 = r15
            androidx.compose.foundation.layout.FlowLayoutOverflowState r13 = (androidx.compose.foundation.layout.FlowLayoutOverflowState) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            int r15 = r3 >> 3
            r15 = r15 & 8190(0x1ffe, float:1.1477E-41)
            r18 = r9
            r9 = r1
            r1 = r10
            r10 = r18
            androidx.compose.ui.layout.MultiContentMeasurePolicy r15 = columnMeasurementMultiContentHelper(r9, r10, r11, r12, r13, r14, r15)
            r6 = -1515605194(0xffffffffa5a9b336, float:-2.9438265E-16)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r6, r5)
            r5 = 131072(0x20000, float:1.83671E-40)
            if (r4 != r5) goto L_0x017f
            r4 = r1
            goto L_0x0180
        L_0x017f:
            r4 = 0
        L_0x0180:
            r5 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r5
            r5 = 1048576(0x100000, float:1.469368E-39)
            if (r3 != r5) goto L_0x0189
            r3 = r1
            goto L_0x018a
        L_0x0189:
            r3 = 0
        L_0x018a:
            r3 = r3 | r4
            java.lang.Object r4 = r14.rememberedValue()
            if (r3 != 0) goto L_0x0199
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x01b6
        L_0x0199:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = r3
            java.util.List r4 = (java.util.List) r4
            androidx.compose.foundation.layout.FlowLayoutKt$FlowColumn$list$1$1 r3 = new androidx.compose.foundation.layout.FlowLayoutKt$FlowColumn$list$1$1
            r3.<init>(r7)
            r5 = 985886665(0x3ac36fc9, float:0.0014910634)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r5, r1, r3)
            r4.add(r1)
            r2.addOverflowComposables$foundation_layout_release(r13, r4)
            r14.updateRememberedValue(r4)
        L_0x01b6:
            java.util.List r4 = (java.util.List) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r1 = 1399185516(0x5365e06c, float:9.8731269E11)
            java.lang.String r3 = "CC(Layout)P(!1,2)174@7002L62,171@6888L182:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r3)
            kotlin.jvm.functions.Function2 r1 = androidx.compose.ui.layout.LayoutKt.combineAsVirtualLayouts(r4)
            r3 = -290761165(0xffffffffeeab5633, float:-2.6513073E28)
            java.lang.String r4 = "CC(remember):Layout.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            boolean r3 = r14.changed((java.lang.Object) r15)
            java.lang.Object r4 = r14.rememberedValue()
            if (r3 != 0) goto L_0x01e1
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x01e8
        L_0x01e1:
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.ui.layout.MultiContentMeasurePolicyKt.createMeasurePolicy(r15)
            r14.updateRememberedValue(r4)
        L_0x01e8:
            androidx.compose.ui.layout.MeasurePolicy r4 = (androidx.compose.ui.layout.MeasurePolicy) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r5 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r5)
            r3 = 0
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r14, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            r15 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r16 = r0
            java.lang.String r0 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r15, r0)
            androidx.compose.runtime.Applier r0 = r14.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x021d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x021d:
            r14.startReusableNode()
            boolean r0 = r14.getInserting()
            if (r0 == 0) goto L_0x022a
            r14.createNode(r13)
            goto L_0x022d
        L_0x022a:
            r14.useNode()
        L_0x022d:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m3675constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r4, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r3, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r4 = r0.getInserting()
            if (r4 != 0) goto L_0x025d
            java.lang.Object r4 = r0.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r13)
            if (r4 != 0) goto L_0x026b
        L_0x025d:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r0.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r0.apply(r4, r3)
        L_0x026b:
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r6, r3)
            r3 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r1.invoke(r14, r0)
            r14.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0291
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0291:
            r6 = r2
            r2 = r9
            r3 = r10
            r5 = r12
            r1 = r16
            goto L_0x00f4
        L_0x0299:
            androidx.compose.runtime.ScopeUpdateScope r10 = r14.endRestartGroup()
            if (r10 == 0) goto L_0x02ab
            androidx.compose.foundation.layout.FlowLayoutKt$FlowColumn$1 r0 = new androidx.compose.foundation.layout.FlowLayoutKt$FlowColumn$1
            r9 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x02ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.FlowColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, int, int, androidx.compose.foundation.layout.FlowColumnOverflow, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, Composer composer, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        ComposerKt.sourceInformationMarkerStart(composer2, 1479255111, "C(rowMeasurementHelper)P(!1,2)380@13086L883:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i3, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:379)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -75342195, "CC(remember):FlowLayout.kt#9igjgp");
        boolean z = false;
        Arrangement.Horizontal horizontal2 = horizontal;
        Arrangement.Vertical vertical2 = vertical;
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer2.changed((Object) horizontal2)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer2.changed((Object) vertical2)) || (i3 & 48) == 32);
        int i4 = i;
        if ((((i3 & 896) ^ 384) > 256 && composer2.changed(i4)) || (i3 & 384) == 256) {
            z = true;
        }
        boolean z3 = z2 | z;
        Object rememberedValue = composer2.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new FlowLayoutKt$rowMeasurementHelper$1$1(new FlowMeasurePolicy(true, horizontal2, vertical2, horizontal2.m631getSpacingD9Ej5fM(), CROSS_AXIS_ALIGNMENT_TOP, vertical2.m645getSpacingD9Ej5fM(), i4, Integer.MAX_VALUE, FlowRowOverflow.Companion.getVisible().createOverflowState$foundation_layout_release(), (DefaultConstructorMarker) null));
            composer2.updateRememberedValue(rememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return measurePolicy;
    }

    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        ComposerKt.sourceInformationMarkerStart(composer2, -2134502475, "C(rowMeasurementMultiContentHelper)P(!1,4)414@14301L649:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2134502475, i4, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:413)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 744443043, "CC(remember):FlowLayout.kt#9igjgp");
        boolean z = false;
        Arrangement.Horizontal horizontal2 = horizontal;
        Arrangement.Vertical vertical2 = vertical;
        int i5 = i;
        boolean z2 = ((((i4 & 14) ^ 6) > 4 && composer2.changed((Object) horizontal2)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer2.changed((Object) vertical2)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) > 256 && composer2.changed(i5)) || (i4 & 384) == 256);
        int i6 = i2;
        if ((((i4 & 7168) ^ 3072) > 2048 && composer2.changed(i6)) || (i4 & 3072) == 2048) {
            z = true;
        }
        FlowLayoutOverflowState flowLayoutOverflowState2 = flowLayoutOverflowState;
        boolean changed = z2 | z | composer2.changed((Object) flowLayoutOverflowState2);
        Object rememberedValue = composer2.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal2, vertical2, horizontal2.m631getSpacingD9Ej5fM(), CROSS_AXIS_ALIGNMENT_TOP, vertical2.m645getSpacingD9Ej5fM(), i5, i6, flowLayoutOverflowState2, (DefaultConstructorMarker) null);
            composer2.updateRememberedValue(flowMeasurePolicy);
            rememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return flowMeasurePolicy2;
    }

    public static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, Composer composer, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        ComposerKt.sourceInformationMarkerStart(composer2, -2013098357, "C(columnMeasurementHelper)P(2)443@15212L856:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i3, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:442)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 1837869538, "CC(remember):FlowLayout.kt#9igjgp");
        boolean z = false;
        Arrangement.Vertical vertical2 = vertical;
        Arrangement.Horizontal horizontal2 = horizontal;
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer2.changed((Object) vertical2)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer2.changed((Object) horizontal2)) || (i3 & 48) == 32);
        int i4 = i;
        if ((((i3 & 896) ^ 384) > 256 && composer2.changed(i4)) || (i3 & 384) == 256) {
            z = true;
        }
        boolean z3 = z2 | z;
        Object rememberedValue = composer2.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new FlowLayoutKt$columnMeasurementHelper$1$1(new FlowMeasurePolicy(false, horizontal2, vertical2, vertical2.m645getSpacingD9Ej5fM(), CROSS_AXIS_ALIGNMENT_START, horizontal2.m631getSpacingD9Ej5fM(), i4, Integer.MAX_VALUE, FlowRowOverflow.Companion.getVisible().createOverflowState$foundation_layout_release(), (DefaultConstructorMarker) null));
            composer2.updateRememberedValue(rememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return measurePolicy;
    }

    public static final MultiContentMeasurePolicy columnMeasurementMultiContentHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        ComposerKt.sourceInformationMarkerStart(composer2, 748776953, "C(columnMeasurementMultiContentHelper)P(4)475@16365L652:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(748776953, i4, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:474)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 287541334, "CC(remember):FlowLayout.kt#9igjgp");
        boolean z = false;
        Arrangement.Vertical vertical2 = vertical;
        Arrangement.Horizontal horizontal2 = horizontal;
        int i5 = i;
        boolean z2 = ((((i4 & 14) ^ 6) > 4 && composer2.changed((Object) vertical2)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer2.changed((Object) horizontal2)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) > 256 && composer2.changed(i5)) || (i4 & 384) == 256);
        int i6 = i2;
        if ((((i4 & 7168) ^ 3072) > 2048 && composer2.changed(i6)) || (i4 & 3072) == 2048) {
            z = true;
        }
        FlowLayoutOverflowState flowLayoutOverflowState2 = flowLayoutOverflowState;
        boolean changed = z2 | z | composer2.changed((Object) flowLayoutOverflowState2);
        Object rememberedValue = composer2.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal2, vertical2, vertical2.m645getSpacingD9Ej5fM(), CROSS_AXIS_ALIGNMENT_START, horizontal2.m631getSpacingD9Ej5fM(), i5, i6, flowLayoutOverflowState2, (DefaultConstructorMarker) null);
            composer2.updateRememberedValue(flowMeasurePolicy);
            rememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return flowMeasurePolicy2;
    }

    /* access modifiers changed from: private */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i6;
        int i7 = i;
        int i8 = i4;
        int i9 = i5;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = 0;
        }
        int size2 = list.size();
        int[] iArr2 = new int[size2];
        for (int i11 = 0; i11 < size2; i11++) {
            iArr2[i11] = 0;
        }
        int size3 = list.size();
        for (int i12 = 0; i12 < size3; i12++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i12);
            int intValue = function3.invoke(intrinsicMeasurable, Integer.valueOf(i12), Integer.valueOf(i7)).intValue();
            iArr[i12] = intValue;
            iArr2[i12] = function32.invoke(intrinsicMeasurable, Integer.valueOf(i12), Integer.valueOf(intValue)).intValue();
        }
        List<? extends IntrinsicMeasurable> list2 = list;
        int i13 = Integer.MAX_VALUE;
        if (!(i9 == Integer.MAX_VALUE || i8 == Integer.MAX_VALUE)) {
            i13 = i8 * i9;
        }
        if ((i13 >= list2.size() || !(flowLayoutOverflowState.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandIndicator || flowLayoutOverflowState.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) && (i13 < list2.size() || i9 < flowLayoutOverflowState.getMinLinesToShowCollapse$foundation_layout_release() || flowLayoutOverflowState.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) {
            i6 = 0;
        } else {
            i6 = 1;
        }
        int min = Math.min(i13 - i6, list2.size());
        int sum = ArraysKt.sum(iArr) + ((list2.size() - 1) * i2);
        if (size2 != 0) {
            int i14 = iArr2[0];
            IntIterator it = new IntRange(1, ArraysKt.getLastIndex(iArr2)).iterator();
            while (it.hasNext()) {
                int i15 = iArr2[it.nextInt()];
                if (i14 < i15) {
                    i14 = i15;
                }
            }
            if (size != 0) {
                int i16 = iArr[0];
                IntIterator it2 = new IntRange(1, ArraysKt.getLastIndex(iArr)).iterator();
                while (it2.hasNext()) {
                    int i17 = iArr[it2.nextInt()];
                    if (i16 < i17) {
                        i16 = i17;
                    }
                }
                int i18 = i16;
                int i19 = sum;
                while (i18 <= i19 && i14 != i7) {
                    int i20 = (i18 + i19) / 2;
                    long intrinsicCrossAxisSize = intrinsicCrossAxisSize(list2, iArr, iArr2, i20, i2, i3, i8, i9, flowLayoutOverflowState);
                    int r1 = IntIntPair.m33getFirstimpl(intrinsicCrossAxisSize);
                    int r5 = IntIntPair.m34getSecondimpl(intrinsicCrossAxisSize);
                    if (r1 > i7 || r5 < min) {
                        i18 = i20 + 1;
                        if (i18 > i19) {
                            return i18;
                        }
                    } else if (r1 >= i7) {
                        return i20;
                    } else {
                        i19 = i20 - 1;
                    }
                    list2 = list;
                    i8 = i4;
                    i9 = i5;
                    sum = i20;
                    i14 = r1;
                }
                return sum;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        return intrinsicCrossAxisSize(list, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) new FlowLayoutKt$intrinsicCrossAxisSize$1(iArr), (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) new FlowLayoutKt$intrinsicCrossAxisSize$2(iArr2), i, i2, i3, i4, i5, flowLayoutOverflowState);
    }

    /* access modifiers changed from: private */
    public static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        IntIntPair intIntPair;
        int i6;
        IntIntPair intIntPair2;
        List<? extends IntrinsicMeasurable> list2 = list;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function33 = function3;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function34 = function32;
        int i7 = i;
        if (list2.isEmpty()) {
            return IntIntPair.m29constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i4, flowLayoutOverflowState, OrientationIndependentConstraints.m742constructorimpl(0, i7, 0, Integer.MAX_VALUE), i5, i2, i3, (DefaultConstructorMarker) null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list2, 0);
        int intValue = intrinsicMeasurable != null ? function34.invoke(intrinsicMeasurable, 0, Integer.valueOf(i7)).intValue() : 0;
        int intValue2 = intrinsicMeasurable != null ? function33.invoke(intrinsicMeasurable, 0, Integer.valueOf(intValue)).intValue() : 0;
        boolean z = true;
        boolean z2 = list2.size() > 1;
        long r15 = IntIntPair.m29constructorimpl(i7, Integer.MAX_VALUE);
        if (intrinsicMeasurable == null) {
            intIntPair = null;
        } else {
            intIntPair = IntIntPair.m26boximpl(IntIntPair.m29constructorimpl(intValue2, intValue));
        }
        int i8 = 0;
        int i9 = 0;
        if (flowLayoutBuildingBlocks.m689getWrapInfoOpUlnko(z2, 0, r15, intIntPair, 0, 0, 0, false, false).isLastItemInContainer()) {
            if (intrinsicMeasurable == null) {
                z = false;
            }
            IntIntPair r0 = flowLayoutOverflowState.m696ellipsisSizeF35zmw$foundation_layout_release(z, 0, 0);
            return IntIntPair.m29constructorimpl(r0 != null ? IntIntPair.m34getSecondimpl(r0.m37unboximpl()) : 0, 0);
        }
        int size = list2.size();
        int i10 = i7;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = i9;
            if (i11 >= size) {
                i6 = i12;
                break;
            }
            int i16 = i10 - intValue2;
            int i17 = i11 + 1;
            i9 = Math.max(i15, intValue);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list2, i17);
            int intValue3 = intrinsicMeasurable2 != null ? function34.invoke(intrinsicMeasurable2, Integer.valueOf(i17), Integer.valueOf(i7)).intValue() : 0;
            int intValue4 = intrinsicMeasurable2 != null ? function33.invoke(intrinsicMeasurable2, Integer.valueOf(i17), Integer.valueOf(intValue3)).intValue() + i2 : 0;
            boolean z3 = i11 + 2 < list2.size();
            i6 = i17;
            int i18 = i17 - i13;
            int i19 = i14;
            long r152 = IntIntPair.m29constructorimpl(i16, Integer.MAX_VALUE);
            if (intrinsicMeasurable2 == null) {
                intIntPair2 = null;
            } else {
                intIntPair2 = IntIntPair.m26boximpl(IntIntPair.m29constructorimpl(intValue4, intValue3));
            }
            FlowLayoutBuildingBlocks.WrapInfo r13 = flowLayoutBuildingBlocks.m689getWrapInfoOpUlnko(z3, i18, r152, intIntPair2, i19, i8, i9, false, false);
            if (r13.isLastItemInLine()) {
                int i20 = i8 + i9 + i3;
                int i21 = i19;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(r13, intrinsicMeasurable2 != null, i21, i20, i16, i18);
                intValue4 -= i2;
                i14 = i21 + 1;
                if (r13.isLastItemInContainer()) {
                    if (wrapEllipsisInfo != null) {
                        long r02 = wrapEllipsisInfo.m690getEllipsisSizeOO21N7I();
                        if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                            i20 += IntIntPair.m34getSecondimpl(r02) + i3;
                        }
                    }
                    i8 = i20;
                } else {
                    i10 = i7;
                    i13 = i6;
                    i8 = i20;
                    i9 = 0;
                }
            } else {
                i10 = i16;
                i14 = i19;
            }
            intValue2 = intValue4;
            intValue = intValue3;
            i11 = i6;
            i12 = i11;
        }
        return IntIntPair.m29constructorimpl(i8 - i3, i6);
    }

    private static final Measurable safeNext(Iterator<? extends Measurable> it, FlowLineInfo flowLineInfo) {
        try {
            if (!(it instanceof ContextualFlowItemIterator)) {
                return (Measurable) it.next();
            }
            Intrinsics.checkNotNull(flowLineInfo);
            return ((ContextualFlowItemIterator) it).getNext$foundation_layout_release(flowLineInfo);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static final int mainAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        if (z) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    public static final int crossAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        if (z) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_TOP() {
        return CROSS_AXIS_ALIGNMENT_TOP;
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_START() {
        return CROSS_AXIS_ALIGNMENT_START;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r1 = r1.getFlowLayoutData();
     */
    /* renamed from: measureAndCache-rqJ1uqs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long m692measureAndCacherqJ1uqs(androidx.compose.ui.layout.Measurable r3, androidx.compose.foundation.layout.FlowLineMeasurePolicy r4, long r5, kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable, kotlin.Unit> r7) {
        /*
            r0 = r3
            androidx.compose.ui.layout.IntrinsicMeasurable r0 = (androidx.compose.ui.layout.IntrinsicMeasurable) r0
            androidx.compose.foundation.layout.RowColumnParentData r1 = androidx.compose.foundation.layout.RowColumnImplKt.getRowColumnParentData((androidx.compose.ui.layout.IntrinsicMeasurable) r0)
            float r1 = androidx.compose.foundation.layout.RowColumnImplKt.getWeight(r1)
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x003c
            androidx.compose.foundation.layout.RowColumnParentData r1 = androidx.compose.foundation.layout.RowColumnImplKt.getRowColumnParentData((androidx.compose.ui.layout.IntrinsicMeasurable) r0)
            if (r1 == 0) goto L_0x0025
            androidx.compose.foundation.layout.FlowLayoutData r1 = r1.getFlowLayoutData()
            if (r1 == 0) goto L_0x0025
            float r1 = r1.getFillCrossAxisFraction()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            if (r1 != 0) goto L_0x003c
            androidx.compose.ui.layout.Placeable r3 = r3.m5848measureBRTryo0(r5)
            r7.invoke(r3)
            int r5 = r4.mainAxisSize(r3)
            int r3 = r4.crossAxisSize(r3)
            long r3 = androidx.collection.IntIntPair.m29constructorimpl(r5, r3)
            return r3
        L_0x003c:
            boolean r3 = r4.isHorizontal()
            r5 = 2147483647(0x7fffffff, float:NaN)
            int r3 = mainAxisMin(r0, r3, r5)
            boolean r4 = r4.isHorizontal()
            int r4 = crossAxisMin(r0, r4, r3)
            long r3 = androidx.collection.IntIntPair.m29constructorimpl(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.m692measureAndCacherqJ1uqs(androidx.compose.ui.layout.Measurable, androidx.compose.foundation.layout.FlowLineMeasurePolicy, long, kotlin.jvm.functions.Function1):long");
    }

    /* renamed from: placeHelper-BmaY500  reason: not valid java name */
    public static final MeasureResult m693placeHelperBmaY500(MeasureScope measureScope, long j, int i, int i2, int[] iArr, MutableVector<MeasureResult> mutableVector, FlowLineMeasurePolicy flowLineMeasurePolicy, int[] iArr2) {
        int i3;
        int i4;
        int i5;
        boolean isHorizontal = flowLineMeasurePolicy.isHorizontal();
        Arrangement.Vertical verticalArrangement = flowLineMeasurePolicy.getVerticalArrangement();
        Arrangement.Horizontal horizontalArrangement = flowLineMeasurePolicy.getHorizontalArrangement();
        if (!isHorizontal) {
            int[] iArr3 = iArr2;
            if (horizontalArrangement != null) {
                int coerceIn = RangesKt.coerceIn(i2 + (measureScope.m7086roundToPx0680j_4(horizontalArrangement.m631getSpacingD9Ej5fM()) * (mutableVector.getSize() - 1)), Constraints.m7053getMinHeightimpl(j), Constraints.m7051getMaxHeightimpl(j));
                horizontalArrangement.arrange(measureScope, coerceIn, iArr, measureScope.getLayoutDirection(), iArr3);
                i3 = coerceIn;
            } else {
                throw new IllegalArgumentException("null horizontalArrangement".toString());
            }
        } else if (verticalArrangement != null) {
            i3 = RangesKt.coerceIn(i2 + (measureScope.m7086roundToPx0680j_4(verticalArrangement.m645getSpacingD9Ej5fM()) * (mutableVector.getSize() - 1)), Constraints.m7053getMinHeightimpl(j), Constraints.m7051getMaxHeightimpl(j));
            verticalArrangement.arrange(measureScope, i3, iArr, iArr2);
        } else {
            throw new IllegalArgumentException("null verticalArrangement".toString());
        }
        int coerceIn2 = RangesKt.coerceIn(i, Constraints.m7054getMinWidthimpl(j), Constraints.m7052getMaxWidthimpl(j));
        if (isHorizontal) {
            i5 = coerceIn2;
            i4 = i3;
        } else {
            i4 = coerceIn2;
            i5 = i3;
        }
        return MeasureScope.layout$default(measureScope, i5, i4, (Map) null, new FlowLayoutKt$placeHelper$5(mutableVector), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int i, int i2, int i3) {
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < size) {
            int intValue = function3.invoke((IntrinsicMeasurable) list.get(i4), Integer.valueOf(i4), Integer.valueOf(i)).intValue() + i2;
            int i8 = i4 + 1;
            if (i8 - i6 == i3 || i8 == list.size()) {
                i5 = Math.max(i5, (i7 + intValue) - i2);
                i7 = 0;
                i6 = i4;
            } else {
                i7 += intValue;
            }
            i4 = i8;
        }
        return i5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: androidx.compose.ui.layout.Placeable[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: breakDownItems-di9J0FM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.layout.MeasureResult m691breakDownItemsdi9J0FM(androidx.compose.ui.layout.MeasureScope r55, androidx.compose.foundation.layout.FlowLineMeasurePolicy r56, java.util.Iterator<? extends androidx.compose.ui.layout.Measurable> r57, float r58, float r59, long r60, int r62, int r63, androidx.compose.foundation.layout.FlowLayoutOverflowState r64) {
        /*
            r6 = r55
            r13 = r56
            r0 = r57
            androidx.compose.runtime.collection.MutableVector r14 = new androidx.compose.runtime.collection.MutableVector
            r1 = 16
            androidx.compose.ui.layout.MeasureResult[] r1 = new androidx.compose.ui.layout.MeasureResult[r1]
            r15 = 0
            r14.<init>(r1, r15)
            int r1 = androidx.compose.ui.unit.Constraints.m7052getMaxWidthimpl(r60)
            int r2 = androidx.compose.ui.unit.Constraints.m7054getMinWidthimpl(r60)
            int r3 = androidx.compose.ui.unit.Constraints.m7051getMaxHeightimpl(r60)
            androidx.collection.MutableIntObjectMap r4 = androidx.collection.IntObjectMapKt.mutableIntObjectMapOf()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r7 = r5
            java.util.List r7 = (java.util.List) r7
            r5 = r58
            float r5 = r6.m7091toPx0680j_4(r5)
            double r8 = (double) r5
            double r8 = java.lang.Math.ceil(r8)
            float r5 = (float) r8
            int r5 = (int) r5
            r8 = r59
            float r8 = r6.m7091toPx0680j_4(r8)
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            float r8 = (float) r8
            int r8 = (int) r8
            long r16 = androidx.compose.foundation.layout.OrientationIndependentConstraints.m742constructorimpl(r15, r1, r15, r3)
            r22 = 14
            r23 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            long r9 = androidx.compose.foundation.layout.OrientationIndependentConstraints.m746copyyUG9Ft0$default(r16, r18, r19, r20, r21, r22, r23)
            r25 = r16
            boolean r11 = r13.isHorizontal()
            if (r11 == 0) goto L_0x0061
            androidx.compose.foundation.layout.LayoutOrientation r11 = androidx.compose.foundation.layout.LayoutOrientation.Horizontal
            goto L_0x0063
        L_0x0061:
            androidx.compose.foundation.layout.LayoutOrientation r11 = androidx.compose.foundation.layout.LayoutOrientation.Vertical
        L_0x0063:
            long r9 = androidx.compose.foundation.layout.OrientationIndependentConstraints.m757toBoxConstraintsOenEA2s(r9, r11)
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            boolean r12 = r0 instanceof androidx.compose.foundation.layout.ContextualFlowItemIterator
            r17 = 0
            if (r12 == 0) goto L_0x0086
            androidx.compose.foundation.layout.FlowLineInfo r16 = new androidx.compose.foundation.layout.FlowLineInfo
            float r19 = r6.m7088toDpu2uoSUM((int) r1)
            float r20 = r6.m7088toDpu2uoSUM((int) r3)
            r21 = 0
            r18 = 0
            r16.<init>(r17, r18, r19, r20, r21)
            r12 = r16
            goto L_0x0087
        L_0x0086:
            r12 = 0
        L_0x0087:
            boolean r16 = r0.hasNext()
            if (r16 != 0) goto L_0x008f
            r15 = 0
            goto L_0x0095
        L_0x008f:
            androidx.compose.ui.layout.Measurable r16 = safeNext(r0, r12)
            r15 = r16
        L_0x0095:
            r28 = r2
            if (r15 == 0) goto L_0x00ab
            androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1$1 r2 = new androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1$1
            r2.<init>(r11)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            long r16 = m692measureAndCacherqJ1uqs(r15, r13, r9, r2)
            androidx.collection.IntIntPair r2 = androidx.collection.IntIntPair.m26boximpl(r16)
            r34 = r2
            goto L_0x00ad
        L_0x00ab:
            r34 = 0
        L_0x00ad:
            if (r34 == 0) goto L_0x00bc
            long r16 = r34.m37unboximpl()
            int r2 = androidx.collection.IntIntPair.m33getFirstimpl(r16)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x00bd
        L_0x00bc:
            r2 = 0
        L_0x00bd:
            if (r34 == 0) goto L_0x00ce
            long r16 = r34.m37unboximpl()
            int r16 = androidx.collection.IntIntPair.m34getSecondimpl(r16)
            java.lang.Integer r16 = java.lang.Integer.valueOf(r16)
            r40 = r16
            goto L_0x00d0
        L_0x00ce:
            r40 = 0
        L_0x00d0:
            r41 = r2
            androidx.collection.MutableIntList r2 = new androidx.collection.MutableIntList
            r22 = r5
            r5 = 1
            r23 = r8
            r42 = r15
            r8 = 0
            r15 = 0
            r2.<init>(r15, r5, r8)
            r43 = r14
            androidx.collection.MutableIntList r14 = new androidx.collection.MutableIntList
            r14.<init>(r15, r5, r8)
            androidx.compose.foundation.layout.FlowLayoutBuildingBlocks r44 = new androidx.compose.foundation.layout.FlowLayoutBuildingBlocks
            r24 = 0
            r19 = r60
            r17 = r62
            r21 = r63
            r18 = r64
            r16 = r44
            r16.<init>(r17, r18, r19, r21, r22, r23, r24)
            r8 = r5
            r5 = r22
            boolean r30 = r0.hasNext()
            long r32 = androidx.collection.IntIntPair.m29constructorimpl(r1, r3)
            r38 = 0
            r39 = 0
            r31 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r29 = r44
            androidx.compose.foundation.layout.FlowLayoutBuildingBlocks$WrapInfo r17 = r29.m689getWrapInfoOpUlnko(r30, r31, r32, r34, r35, r36, r37, r38, r39)
            boolean r15 = r17.isLastItemInContainer()
            if (r15 == 0) goto L_0x0133
            if (r34 == 0) goto L_0x0120
            r18 = r8
            goto L_0x0122
        L_0x0120:
            r18 = 0
        L_0x0122:
            r20 = 0
            r22 = 0
            r19 = -1
            r21 = r1
            r16 = r44
            androidx.compose.foundation.layout.FlowLayoutBuildingBlocks$WrapEllipsisInfo r1 = r16.getWrapEllipsisInfo(r17, r18, r19, r20, r21, r22)
            r15 = r21
            goto L_0x0135
        L_0x0133:
            r15 = r1
            r1 = 0
        L_0x0135:
            r63 = r1
            r21 = r2
            r2 = r3
            r20 = r2
            r22 = r5
            r58 = r8
            r16 = r15
            r18 = r17
            r8 = r28
            r1 = r42
            r3 = 0
            r5 = 0
            r17 = 0
            r19 = 0
            r47 = 0
            r51 = 0
        L_0x0152:
            boolean r18 = r18.isLastItemInContainer()
            if (r18 != 0) goto L_0x02cb
            if (r1 == 0) goto L_0x02cb
            kotlin.jvm.internal.Intrinsics.checkNotNull(r41)
            int r18 = r41.intValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r40)
            r24 = r14
            int r14 = r40.intValue()
            r28 = r15
            int r15 = r19 + r18
            int r52 = java.lang.Math.max(r3, r14)
            int r3 = r16 - r18
            int r14 = r5 + 1
            r16 = r8
            r8 = r64
            r8.setItemShown$foundation_layout_release(r14)
            r7.add(r1)
            T r1 = r11.element
            r4.set(r5, r1)
            int r1 = r14 - r17
            r5 = r62
            if (r1 >= r5) goto L_0x018e
            r18 = r58
            goto L_0x0190
        L_0x018e:
            r18 = 0
        L_0x0190:
            if (r12 == 0) goto L_0x01d2
            if (r18 == 0) goto L_0x0199
            r46 = r1
            r1 = r47
            goto L_0x019f
        L_0x0199:
            int r19 = r47 + 1
            r46 = r1
            r1 = r19
        L_0x019f:
            if (r18 == 0) goto L_0x01a4
            r5 = r46
            goto L_0x01a5
        L_0x01a4:
            r5 = 0
        L_0x01a5:
            if (r18 == 0) goto L_0x01b1
            int r8 = r3 - r22
            r19 = r4
            r4 = 0
            int r8 = kotlin.ranges.RangesKt.coerceAtLeast((int) r8, (int) r4)
            goto L_0x01b6
        L_0x01b1:
            r19 = r4
            r4 = 0
            r8 = r28
        L_0x01b6:
            float r8 = r6.m7088toDpu2uoSUM((int) r8)
            if (r18 == 0) goto L_0x01c0
            r29 = r7
            r7 = r2
            goto L_0x01ca
        L_0x01c0:
            int r18 = r2 - r52
            r29 = r7
            int r7 = r18 - r23
            int r7 = kotlin.ranges.RangesKt.coerceAtLeast((int) r7, (int) r4)
        L_0x01ca:
            float r4 = r6.m7088toDpu2uoSUM((int) r7)
            r12.m704update4j6BHR0$foundation_layout_release(r1, r5, r8, r4)
            goto L_0x01d8
        L_0x01d2:
            r46 = r1
            r19 = r4
            r29 = r7
        L_0x01d8:
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x01e0
            r1 = 0
            goto L_0x01e4
        L_0x01e0:
            androidx.compose.ui.layout.Measurable r1 = safeNext(r0, r12)
        L_0x01e4:
            r8 = 0
            r11.element = r8
            if (r1 == 0) goto L_0x01f9
            androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1$1 r4 = new androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1$1
            r4.<init>(r11)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            long r4 = m692measureAndCacherqJ1uqs(r1, r13, r9, r4)
            androidx.collection.IntIntPair r4 = androidx.collection.IntIntPair.m26boximpl(r4)
            goto L_0x01fa
        L_0x01f9:
            r4 = r8
        L_0x01fa:
            if (r4 == 0) goto L_0x020b
            long r30 = r4.m37unboximpl()
            int r5 = androidx.collection.IntIntPair.m33getFirstimpl(r30)
            int r5 = r5 + r22
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x020c
        L_0x020b:
            r5 = r8
        L_0x020c:
            if (r4 == 0) goto L_0x021d
            long r30 = r4.m37unboximpl()
            int r7 = androidx.collection.IntIntPair.m34getSecondimpl(r30)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r40 = r7
            goto L_0x021f
        L_0x021d:
            r40 = r8
        L_0x021f:
            boolean r45 = r0.hasNext()
            r50 = r47
            long r47 = androidx.collection.IntIntPair.m29constructorimpl(r3, r2)
            if (r4 != 0) goto L_0x022c
            goto L_0x0242
        L_0x022c:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r7 = r5.intValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r40)
            int r8 = r40.intValue()
            long r7 = androidx.collection.IntIntPair.m29constructorimpl(r7, r8)
            androidx.collection.IntIntPair r8 = androidx.collection.IntIntPair.m26boximpl(r7)
        L_0x0242:
            r49 = r8
            r53 = 0
            r54 = 0
            androidx.compose.foundation.layout.FlowLayoutBuildingBlocks$WrapInfo r45 = r44.m689getWrapInfoOpUlnko(r45, r46, r47, r49, r50, r51, r52, r53, r54)
            r7 = r52
            boolean r8 = r45.isLastItemInLine()
            if (r8 == 0) goto L_0x02a5
            r8 = r16
            int r2 = java.lang.Math.max(r8, r15)
            r8 = r28
            int r2 = java.lang.Math.min(r2, r8)
            int r48 = r51 + r7
            r47 = r50
            r50 = r46
            if (r4 == 0) goto L_0x026b
            r46 = r58
            goto L_0x026d
        L_0x026b:
            r46 = 0
        L_0x026d:
            r49 = r3
            androidx.compose.foundation.layout.FlowLayoutBuildingBlocks$WrapEllipsisInfo r3 = r44.getWrapEllipsisInfo(r45, r46, r47, r48, r49, r50)
            r4 = r24
            r50 = r47
            r4.add(r7)
            int r7 = r20 - r48
            int r7 = r7 - r23
            r15 = r21
            r15.add(r14)
            if (r5 == 0) goto L_0x0290
            int r5 = r5.intValue()
            int r5 = r5 - r22
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x0291
        L_0x0290:
            r5 = 0
        L_0x0291:
            int r47 = r50 + 1
            int r48 = r48 + r23
            r41 = r5
            r16 = r8
            r28 = r16
            r17 = r14
            r51 = r48
            r5 = 0
            r8 = r2
            r2 = r3
            r3 = r15
            r15 = 0
            goto L_0x02b7
        L_0x02a5:
            r49 = r3
            r8 = r16
            r3 = r21
            r4 = r24
            r41 = r5
            r5 = r7
            r16 = r49
            r47 = r50
            r7 = r2
            r2 = r63
        L_0x02b7:
            r63 = r2
            r21 = r3
            r3 = r5
            r2 = r7
            r5 = r14
            r7 = r29
            r18 = r45
            r14 = r4
            r4 = r19
            r19 = r15
            r15 = r28
            goto L_0x0152
        L_0x02cb:
            r19 = r4
            r29 = r7
            r4 = r14
            r3 = r21
            if (r63 == 0) goto L_0x0331
            androidx.compose.ui.layout.Measurable r0 = r63.getEllipsis()
            r7 = r29
            r7.add(r0)
            int r0 = r7.size()
            int r0 = r0 + -1
            androidx.compose.ui.layout.Placeable r1 = r63.getPlaceable()
            r2 = r19
            r2.set(r0, r1)
            r0 = r3
            androidx.collection.IntList r0 = (androidx.collection.IntList) r0
            int r0 = r0._size
            int r0 = r0 + -1
            boolean r1 = r63.getPlaceEllipsisOnLastContentLine()
            if (r1 == 0) goto L_0x031c
            int r1 = r3.getSize()
            int r1 = r1 + -1
            int r5 = r4.get(r0)
            long r9 = r63.m690getEllipsisSizeOO21N7I()
            int r9 = androidx.collection.IntIntPair.m34getSecondimpl(r9)
            int r5 = java.lang.Math.max(r5, r9)
            r4.set(r0, r5)
            int r0 = r3.last()
            int r0 = r0 + 1
            r3.set(r1, r0)
            goto L_0x0335
        L_0x031c:
            long r0 = r63.m690getEllipsisSizeOO21N7I()
            int r0 = androidx.collection.IntIntPair.m34getSecondimpl(r0)
            r4.add(r0)
            int r0 = r3.last()
            int r0 = r0 + 1
            r3.add(r0)
            goto L_0x0335
        L_0x0331:
            r2 = r19
            r7 = r29
        L_0x0335:
            int r0 = r7.size()
            r16 = r8
            androidx.compose.ui.layout.Placeable[] r8 = new androidx.compose.ui.layout.Placeable[r0]
            r15 = 0
        L_0x033e:
            if (r15 >= r0) goto L_0x0349
            java.lang.Object r1 = r2.get(r15)
            r8[r15] = r1
            int r15 = r15 + 1
            goto L_0x033e
        L_0x0349:
            int r0 = r3.getSize()
            int[] r11 = new int[r0]
            r15 = 0
        L_0x0350:
            if (r15 >= r0) goto L_0x0359
            r27 = 0
            r11[r15] = r27
            int r15 = r15 + 1
            goto L_0x0350
        L_0x0359:
            r27 = 0
            int r0 = r3.getSize()
            int[] r14 = new int[r0]
            r15 = r27
        L_0x0363:
            if (r15 >= r0) goto L_0x036a
            r14[r15] = r27
            int r15 = r15 + 1
            goto L_0x0363
        L_0x036a:
            r2 = r3
            androidx.collection.IntList r2 = (androidx.collection.IntList) r2
            int[] r15 = r2.content
            int r0 = r2._size
            r1 = r16
            r9 = r27
            r12 = r9
            r16 = r12
        L_0x0378:
            if (r12 >= r0) goto L_0x03c6
            r10 = r15[r12]
            r2 = r4
            int r4 = r2.get(r12)
            r3 = r0
            r0 = r13
            androidx.compose.foundation.layout.RowColumnMeasurePolicy r0 = (androidx.compose.foundation.layout.RowColumnMeasurePolicy) r0
            r24 = r2
            int r2 = androidx.compose.ui.unit.Constraints.m7053getMinHeightimpl(r25)
            r5 = r3
            int r3 = androidx.compose.ui.unit.Constraints.m7052getMaxWidthimpl(r25)
            r17 = r5
            r5 = r22
            androidx.compose.ui.layout.MeasureResult r0 = androidx.compose.foundation.layout.RowColumnMeasurePolicyKt.measure(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            boolean r2 = r13.isHorizontal()
            if (r2 == 0) goto L_0x03a7
            int r2 = r0.getWidth()
            int r3 = r0.getHeight()
            goto L_0x03af
        L_0x03a7:
            int r2 = r0.getHeight()
            int r3 = r0.getWidth()
        L_0x03af:
            r14[r12] = r3
            int r16 = r16 + r3
            int r1 = java.lang.Math.max(r1, r2)
            r6 = r43
            r6.add(r0)
            int r12 = r12 + 1
            r9 = r10
            r0 = r17
            r4 = r24
            r6 = r55
            goto L_0x0378
        L_0x03c6:
            r6 = r43
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x03d9
            r3 = r27
            r4 = r3
            r0 = r55
            r1 = r60
            r8 = r11
            r7 = r13
            r5 = r14
            goto L_0x03e3
        L_0x03d9:
            r3 = r1
            r4 = r16
            r0 = r55
            r8 = r11
            r7 = r13
            r5 = r14
            r1 = r60
        L_0x03e3:
            androidx.compose.ui.layout.MeasureResult r0 = m693placeHelperBmaY500(r0, r1, r3, r4, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.m691breakDownItemsdi9J0FM(androidx.compose.ui.layout.MeasureScope, androidx.compose.foundation.layout.FlowLineMeasurePolicy, java.util.Iterator, float, float, long, int, int, androidx.compose.foundation.layout.FlowLayoutOverflowState):androidx.compose.ui.layout.MeasureResult");
    }
}
