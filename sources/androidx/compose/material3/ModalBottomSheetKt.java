package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÄ\u0001\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00132\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u001a0\n¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b0\u001e¢\u0006\u0002\b\u0018¢\u0006\u0002\b H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a0\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u00132\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a-\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020&2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020&0\u001eH\u0007¢\u0006\u0002\u0010-\u001aó\u0001\u0010.\u001a\u00020\b*\u00020/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203012\u0006\u00104\u001a\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\n2!\u00107\u001a\u001d\u0012\u0013\u0012\u001102¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\b0\u001e2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00042\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u001a0\n¢\u0006\u0002\b\u00182\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b0\u001e¢\u0006\u0002\b\u0018¢\u0006\u0002\b H\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u0014\u0010=\u001a\u000202*\u00020>2\u0006\u0010?\u001a\u000202H\u0002\u001a\u0014\u0010@\u001a\u000202*\u00020>2\u0006\u0010?\u001a\u000202H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A²\u0006\n\u0010B\u001a\u000202X\u0002"}, d2 = {"PredictiveBackChildTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "PredictiveBackMaxScaleXDistance", "Landroidx/compose/ui/unit/Dp;", "F", "PredictiveBackMaxScaleYDistance", "ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scrim", "color", "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "ModalBottomSheetContent", "Landroidx/compose/foundation/layout/BoxScope;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "animateToDismiss", "settleToDismiss", "Lkotlin/ParameterName;", "name", "velocity", "ModalBottomSheetContent-IQkwcL4", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "calculatePredictiveBackScaleY", "material3_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
public final class ModalBottomSheetKt {
    /* access modifiers changed from: private */
    public static final long PredictiveBackChildTransformOrigin = TransformOriginKt.TransformOrigin(0.5f, 0.0f);
    private static final float PredictiveBackMaxScaleXDistance = Dp.m7111constructorimpl((float) 48);
    private static final float PredictiveBackMaxScaleYDistance = Dp.m7111constructorimpl((float) 24);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x04aa  */
    /* JADX WARNING: Removed duplicated region for block: B:293:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011d  */
    /* renamed from: ModalBottomSheet-dYc4hso  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2218ModalBottomSheetdYc4hso(kotlin.jvm.functions.Function0<kotlin.Unit> r45, androidx.compose.ui.Modifier r46, androidx.compose.material3.SheetState r47, float r48, androidx.compose.ui.graphics.Shape r49, long r50, long r52, float r54, long r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, ? extends androidx.compose.foundation.layout.WindowInsets> r58, androidx.compose.material3.ModalBottomSheetProperties r59, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, androidx.compose.runtime.Composer r61, int r62, int r63, int r64) {
        /*
            r1 = r45
            r0 = r62
            r2 = r63
            r3 = r64
            r4 = 2132719801(0x7f1eb8b9, float:2.1097716E38)
            r5 = r61
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r4)
            java.lang.String r6 = "C(ModalBottomSheet)P(6,5,11,10:c#ui.unit.Dp,9,0:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.unit.Dp,8:c#ui.graphics.Color,4,3,7)121@6012L31,123@6143L13,124@6206L14,125@6248L31,127@6356L10,133@6697L24,134@6761L327,145@7142L149,151@7326L42,155@7458L708,167@8231L771,153@7374L1628,193@9077L21,193@9050L48:ModalBottomSheet.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = r3 & 1
            if (r6 == 0) goto L_0x001d
            r6 = r0 | 6
            goto L_0x002d
        L_0x001d:
            r6 = r0 & 6
            if (r6 != 0) goto L_0x002c
            boolean r6 = r5.changedInstance(r1)
            if (r6 == 0) goto L_0x0029
            r6 = 4
            goto L_0x002a
        L_0x0029:
            r6 = 2
        L_0x002a:
            r6 = r6 | r0
            goto L_0x002d
        L_0x002c:
            r6 = r0
        L_0x002d:
            r9 = r3 & 2
            if (r9 == 0) goto L_0x0034
            r6 = r6 | 48
            goto L_0x0047
        L_0x0034:
            r12 = r0 & 48
            if (r12 != 0) goto L_0x0047
            r12 = r46
            boolean r13 = r5.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0043
            r13 = 32
            goto L_0x0045
        L_0x0043:
            r13 = 16
        L_0x0045:
            r6 = r6 | r13
            goto L_0x0049
        L_0x0047:
            r12 = r46
        L_0x0049:
            r13 = r0 & 384(0x180, float:5.38E-43)
            if (r13 != 0) goto L_0x0063
            r13 = r3 & 4
            if (r13 != 0) goto L_0x005c
            r13 = r47
            boolean r16 = r5.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x005e
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r13 = r47
        L_0x005e:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r6 = r6 | r16
            goto L_0x0065
        L_0x0063:
            r13 = r47
        L_0x0065:
            r16 = r3 & 8
            if (r16 == 0) goto L_0x006c
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006c:
            r10 = r0 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0080
            r10 = r48
            boolean r17 = r5.changed((float) r10)
            if (r17 == 0) goto L_0x007b
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r6 = r6 | r17
            goto L_0x0082
        L_0x0080:
            r10 = r48
        L_0x0082:
            r11 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009c
            r11 = r3 & 16
            if (r11 != 0) goto L_0x0095
            r11 = r49
            boolean r18 = r5.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x0097
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0095:
            r11 = r49
        L_0x0097:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r6 = r6 | r18
            goto L_0x009e
        L_0x009c:
            r11 = r49
        L_0x009e:
            r18 = 196608(0x30000, float:2.75506E-40)
            r18 = r0 & r18
            if (r18 != 0) goto L_0x00b8
            r18 = r3 & 32
            r7 = r50
            if (r18 != 0) goto L_0x00b3
            boolean r20 = r5.changed((long) r7)
            if (r20 == 0) goto L_0x00b3
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r20 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r6 = r6 | r20
            goto L_0x00ba
        L_0x00b8:
            r7 = r50
        L_0x00ba:
            r20 = 1572864(0x180000, float:2.204052E-39)
            r20 = r0 & r20
            if (r20 != 0) goto L_0x00d4
            r20 = r3 & 64
            r14 = r52
            if (r20 != 0) goto L_0x00cf
            boolean r21 = r5.changed((long) r14)
            if (r21 == 0) goto L_0x00cf
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r6 = r6 | r21
            goto L_0x00d6
        L_0x00d4:
            r14 = r52
        L_0x00d6:
            r4 = r3 & 128(0x80, float:1.794E-43)
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            if (r4 == 0) goto L_0x00e1
            r6 = r6 | r22
            r0 = r54
            goto L_0x00f4
        L_0x00e1:
            r22 = r0 & r22
            r0 = r54
            if (r22 != 0) goto L_0x00f4
            boolean r22 = r5.changed((float) r0)
            if (r22 == 0) goto L_0x00f0
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00f0:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r6 = r6 | r22
        L_0x00f4:
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            r22 = r62 & r22
            if (r22 != 0) goto L_0x0111
            r0 = r3 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x010a
            r0 = r6
            r6 = r55
            boolean r8 = r5.changed((long) r6)
            if (r8 == 0) goto L_0x010d
            r8 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010a:
            r0 = r6
            r6 = r55
        L_0x010d:
            r8 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r0 = r0 | r8
            goto L_0x0114
        L_0x0111:
            r0 = r6
            r6 = r55
        L_0x0114:
            r8 = r3 & 512(0x200, float:7.175E-43)
            r22 = 805306368(0x30000000, float:4.656613E-10)
            if (r8 == 0) goto L_0x011d
            r0 = r0 | r22
            goto L_0x0139
        L_0x011d:
            r22 = r62 & r22
            if (r22 != 0) goto L_0x0133
            r22 = r0
            r0 = r57
            boolean r23 = r5.changedInstance(r0)
            if (r23 == 0) goto L_0x012e
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0130
        L_0x012e:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0130:
            r22 = r22 | r23
            goto L_0x0137
        L_0x0133:
            r22 = r0
            r0 = r57
        L_0x0137:
            r0 = r22
        L_0x0139:
            r22 = r2 & 6
            if (r22 != 0) goto L_0x0155
            r22 = r4
            r4 = r3 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L_0x014e
            r4 = r58
            boolean r23 = r5.changedInstance(r4)
            if (r23 == 0) goto L_0x0150
            r23 = 4
            goto L_0x0152
        L_0x014e:
            r4 = r58
        L_0x0150:
            r23 = 2
        L_0x0152:
            r23 = r2 | r23
            goto L_0x015b
        L_0x0155:
            r22 = r4
            r4 = r58
            r23 = r2
        L_0x015b:
            r4 = r3 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0164
            r23 = r23 | 48
            r24 = r4
            goto L_0x017e
        L_0x0164:
            r24 = r2 & 48
            if (r24 != 0) goto L_0x017a
            r24 = r4
            r4 = r59
            boolean r25 = r5.changed((java.lang.Object) r4)
            if (r25 == 0) goto L_0x0175
            r17 = 32
            goto L_0x0177
        L_0x0175:
            r17 = 16
        L_0x0177:
            r23 = r23 | r17
            goto L_0x017e
        L_0x017a:
            r24 = r4
            r4 = r59
        L_0x017e:
            r4 = r23
            r6 = r3 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0187
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x019b
        L_0x0187:
            r6 = r2 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x019b
            r6 = r60
            boolean r7 = r5.changedInstance(r6)
            if (r7 == 0) goto L_0x0196
            r20 = 256(0x100, float:3.59E-43)
            goto L_0x0198
        L_0x0196:
            r20 = 128(0x80, float:1.794E-43)
        L_0x0198:
            r4 = r4 | r20
            goto L_0x019d
        L_0x019b:
            r6 = r60
        L_0x019d:
            r7 = 306783379(0x12492493, float:6.34695E-28)
            r7 = r7 & r0
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r7 != r2) goto L_0x01c9
            r2 = r4 & 147(0x93, float:2.06E-43)
            r7 = 146(0x92, float:2.05E-43)
            if (r2 != r7) goto L_0x01c9
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L_0x01b3
            goto L_0x01c9
        L_0x01b3:
            r5.skipToGroupEnd()
            r6 = r50
            r26 = r55
            r2 = r5
            r4 = r10
            r5 = r11
            r3 = r13
            r8 = r14
            r10 = r54
            r13 = r57
            r14 = r58
            r15 = r59
            goto L_0x04a4
        L_0x01c9:
            r5.startDefaults()
            r2 = r62 & 1
            r7 = 0
            if (r2 == 0) goto L_0x021d
            boolean r2 = r5.getDefaultsInvalid()
            if (r2 == 0) goto L_0x01d8
            goto L_0x021d
        L_0x01d8:
            r5.skipToGroupEnd()
            r2 = r3 & 4
            if (r2 == 0) goto L_0x01e1
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x01e1:
            r2 = r3 & 16
            if (r2 == 0) goto L_0x01e9
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = r0 & r2
        L_0x01e9:
            r2 = r3 & 32
            if (r2 == 0) goto L_0x01f1
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r2
        L_0x01f1:
            r2 = r3 & 64
            if (r2 == 0) goto L_0x01f9
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r2
        L_0x01f9:
            r2 = r3 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0201
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r2
        L_0x0201:
            r2 = r3 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0207
            r4 = r4 & -15
        L_0x0207:
            r36 = r50
            r40 = r54
            r26 = r55
            r41 = r57
            r42 = r58
            r20 = r59
            r34 = r10
            r35 = r11
            r33 = r12
            r38 = r14
            goto L_0x02cd
        L_0x021d:
            if (r9 == 0) goto L_0x0224
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r12 = r2
        L_0x0224:
            r2 = r3 & 4
            if (r2 == 0) goto L_0x0231
            r2 = 3
            r9 = 0
            androidx.compose.material3.SheetState r2 = rememberModalBottomSheetState(r7, r9, r5, r7, r2)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            r13 = r2
        L_0x0231:
            if (r16 == 0) goto L_0x023a
            androidx.compose.material3.BottomSheetDefaults r2 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r2 = r2.m1744getSheetMaxWidthD9Ej5fM()
            goto L_0x023b
        L_0x023a:
            r2 = r10
        L_0x023b:
            r9 = r3 & 16
            if (r9 == 0) goto L_0x024b
            androidx.compose.material3.BottomSheetDefaults r9 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            r10 = 6
            androidx.compose.ui.graphics.Shape r9 = r9.getExpandedShape(r5, r10)
            r11 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = r0 & r11
            goto L_0x024d
        L_0x024b:
            r10 = 6
            r9 = r11
        L_0x024d:
            r11 = r3 & 32
            if (r11 == 0) goto L_0x025e
            androidx.compose.material3.BottomSheetDefaults r11 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            long r25 = r11.getContainerColor(r5, r10)
            r10 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r10
            r10 = r25
            goto L_0x0260
        L_0x025e:
            r10 = r50
        L_0x0260:
            r16 = r3 & 64
            if (r16 == 0) goto L_0x0271
            int r14 = r0 >> 15
            r14 = r14 & 14
            long r14 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r10, r5, r14)
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r16
        L_0x0271:
            r46 = r0
            if (r22 == 0) goto L_0x027b
            float r0 = (float) r7
            float r0 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r0)
            goto L_0x027d
        L_0x027b:
            r0 = r54
        L_0x027d:
            r7 = r3 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x0290
            androidx.compose.material3.BottomSheetDefaults r7 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            r47 = r0
            r0 = 6
            long r22 = r7.getScrimColor(r5, r0)
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r46 & r0
            goto L_0x0296
        L_0x0290:
            r47 = r0
            r0 = r46
            r22 = r55
        L_0x0296:
            if (r8 == 0) goto L_0x029f
            androidx.compose.material3.ComposableSingletons$ModalBottomSheetKt r7 = androidx.compose.material3.ComposableSingletons$ModalBottomSheetKt.INSTANCE
            kotlin.jvm.functions.Function2 r7 = r7.m1927getLambda1$material3_release()
            goto L_0x02a1
        L_0x029f:
            r7 = r57
        L_0x02a1:
            r8 = r3 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L_0x02ac
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$1 r8 = androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$1.INSTANCE
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r4 = r4 & -15
            goto L_0x02ae
        L_0x02ac:
            r8 = r58
        L_0x02ae:
            if (r24 == 0) goto L_0x02b9
            androidx.compose.material3.ModalBottomSheetDefaults r20 = androidx.compose.material3.ModalBottomSheetDefaults.INSTANCE
            androidx.compose.material3.ModalBottomSheetProperties r20 = r20.getProperties()
            r40 = r47
            goto L_0x02bd
        L_0x02b9:
            r40 = r47
            r20 = r59
        L_0x02bd:
            r34 = r2
            r41 = r7
            r42 = r8
            r35 = r9
            r36 = r10
            r33 = r12
            r38 = r14
            r26 = r22
        L_0x02cd:
            r5.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x02de
            java.lang.String r2 = "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:132)"
            r7 = 2132719801(0x7f1eb8b9, float:2.1097716E38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r0, r4, r2)
        L_0x02de:
            r2 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r7 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r7)
            r2 = -954363344(0xffffffffc71d9230, float:-40338.188)
            java.lang.String r7 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r7)
            java.lang.Object r2 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r2 != r7) goto L_0x030b
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r5)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r7 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r7.<init>(r2)
            r5.updateRememberedValue(r7)
            r2 = r7
        L_0x030b:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            kotlinx.coroutines.CoroutineScope r2 = r2.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r7 = -2011393839(0xffffffff881c90d1, float:-4.7114773E-34)
            java.lang.String r8 = "CC(remember):ModalBottomSheet.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r7, r8)
            r7 = r0 & 896(0x380, float:1.256E-42)
            r7 = r7 ^ 384(0x180, float:5.38E-43)
            r9 = 1
            r10 = 256(0x100, float:3.59E-43)
            if (r7 <= r10) goto L_0x032e
            boolean r11 = r5.changed((java.lang.Object) r13)
            if (r11 != 0) goto L_0x0332
        L_0x032e:
            r11 = r0 & 384(0x180, float:5.38E-43)
            if (r11 != r10) goto L_0x0334
        L_0x0332:
            r10 = r9
            goto L_0x0335
        L_0x0334:
            r10 = 0
        L_0x0335:
            boolean r11 = r5.changedInstance(r2)
            r10 = r10 | r11
            r11 = r0 & 14
            r12 = 4
            if (r11 != r12) goto L_0x0341
            r12 = r9
            goto L_0x0342
        L_0x0341:
            r12 = 0
        L_0x0342:
            r10 = r10 | r12
            java.lang.Object r12 = r5.rememberedValue()
            if (r10 != 0) goto L_0x0351
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r12 != r10) goto L_0x035c
        L_0x0351:
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$animateToDismiss$1$1 r10 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$animateToDismiss$1$1
            r10.<init>(r13, r2, r1)
            r12 = r10
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r5.updateRememberedValue(r12)
        L_0x035c:
            r28 = r12
            kotlin.jvm.functions.Function0 r28 = (kotlin.jvm.functions.Function0) r28
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r10 = -2011381825(0xffffffff881cbfbf, float:-4.716994E-34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r8)
            boolean r10 = r5.changedInstance(r2)
            r12 = 256(0x100, float:3.59E-43)
            if (r7 <= r12) goto L_0x0377
            boolean r14 = r5.changed((java.lang.Object) r13)
            if (r14 != 0) goto L_0x037b
        L_0x0377:
            r14 = r0 & 384(0x180, float:5.38E-43)
            if (r14 != r12) goto L_0x037d
        L_0x037b:
            r12 = r9
            goto L_0x037e
        L_0x037d:
            r12 = 0
        L_0x037e:
            r10 = r10 | r12
            r12 = 4
            if (r11 != r12) goto L_0x0384
            r12 = r9
            goto L_0x0385
        L_0x0384:
            r12 = 0
        L_0x0385:
            r10 = r10 | r12
            java.lang.Object r12 = r5.rememberedValue()
            if (r10 != 0) goto L_0x0394
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r12 != r10) goto L_0x039f
        L_0x0394:
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1 r10 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1
            r10.<init>(r2, r13, r1)
            r12 = r10
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r5.updateRememberedValue(r12)
        L_0x039f:
            r32 = r12
            kotlin.jvm.functions.Function1 r32 = (kotlin.jvm.functions.Function1) r32
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r10 = -2011376044(0xffffffff881cd654, float:-4.7196484E-34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r8)
            java.lang.Object r10 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r10 != r12) goto L_0x03c3
            r10 = 0
            r12 = 0
            r14 = 0
            r15 = 2
            androidx.compose.animation.core.Animatable r10 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r10, r12, r15, r14)
            r5.updateRememberedValue(r10)
        L_0x03c3:
            androidx.compose.animation.core.Animatable r10 = (androidx.compose.animation.core.Animatable) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r12 = -2011371154(0xffffffff881ce96e, float:-4.7218938E-34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r12, r8)
            r12 = 256(0x100, float:3.59E-43)
            if (r7 <= r12) goto L_0x03d8
            boolean r14 = r5.changed((java.lang.Object) r13)
            if (r14 != 0) goto L_0x03dc
        L_0x03d8:
            r14 = r0 & 384(0x180, float:5.38E-43)
            if (r14 != r12) goto L_0x03de
        L_0x03dc:
            r12 = r9
            goto L_0x03df
        L_0x03de:
            r12 = 0
        L_0x03df:
            boolean r14 = r5.changedInstance(r2)
            r12 = r12 | r14
            boolean r14 = r5.changedInstance(r10)
            r12 = r12 | r14
            r14 = 4
            if (r11 != r14) goto L_0x03ee
            r11 = r9
            goto L_0x03ef
        L_0x03ee:
            r11 = 0
        L_0x03ef:
            r11 = r11 | r12
            java.lang.Object r12 = r5.rememberedValue()
            if (r11 != 0) goto L_0x03fe
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x0409
        L_0x03fe:
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$2$1 r11 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$2$1
            r11.<init>(r13, r2, r10, r1)
            r12 = r11
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r5.updateRememberedValue(r12)
        L_0x0409:
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$3 r25 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$3
            r31 = r2
            r43 = r6
            r30 = r10
            r29 = r13
            r25.<init>(r26, r28, r29, r30, r31, r32, r33, r34, r35, r36, r38, r40, r41, r42, r43)
            r2 = r25
            r6 = 54
            r10 = -314673510(0xffffffffed3e769a, float:-3.6840958E27)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r10, r9, r2, r5, r6)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r4 = r4 & 112(0x70, float:1.57E-43)
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            int r6 = androidx.compose.animation.core.Animatable.$stable
            r17 = 6
            int r6 = r6 << 6
            r4 = r4 | r6
            r49 = r2
            r51 = r4
            r50 = r5
            r46 = r12
            r47 = r20
            r48 = r30
            androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheetDialog(r46, r47, r48, r49, r50, r51)
            r2 = r50
            boolean r4 = r13.getHasExpandedState()
            if (r4 == 0) goto L_0x0488
            r4 = -2011320033(0xffffffff881db11f, float:-4.7453674E-34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r4, r8)
            r12 = 256(0x100, float:3.59E-43)
            if (r7 <= r12) goto L_0x045a
            boolean r4 = r2.changed((java.lang.Object) r13)
            if (r4 != 0) goto L_0x045e
        L_0x045a:
            r4 = r0 & 384(0x180, float:5.38E-43)
            if (r4 != r12) goto L_0x0460
        L_0x045e:
            r7 = r9
            goto L_0x0461
        L_0x0460:
            r7 = 0
        L_0x0461:
            java.lang.Object r4 = r2.rememberedValue()
            if (r7 != 0) goto L_0x046f
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x047a
        L_0x046f:
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$4$1 r4 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$4$1
            r14 = 0
            r4.<init>(r13, r14)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.updateRememberedValue(r4)
        L_0x047a:
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r17 = 6
            int r0 = r0 >> 6
            r0 = r0 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r13, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r4, (androidx.compose.runtime.Composer) r2, (int) r0)
        L_0x0488:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0491
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0491:
            r3 = r13
            r15 = r20
            r12 = r33
            r4 = r34
            r5 = r35
            r6 = r36
            r8 = r38
            r10 = r40
            r13 = r41
            r14 = r42
        L_0x04a4:
            androidx.compose.runtime.ScopeUpdateScope r0 = r2.endRestartGroup()
            if (r0 == 0) goto L_0x04c4
            r2 = r0
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$5 r0 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$5
            r16 = r60
            r17 = r62
            r18 = r63
            r19 = r64
            r44 = r2
            r2 = r12
            r11 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r13, r14, r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r2 = r44
            r2.updateScope(r0)
        L_0x04c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheetKt.m2218ModalBottomSheetdYc4hso(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.ModalBottomSheetProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v0, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v72, resolved type: int} */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01ad, code lost:
        if (r6.changedInstance(r59) != false) goto L_0x01b4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x03c6  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x04c6  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:290:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0124  */
    /* renamed from: ModalBottomSheetContent-IQkwcL4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2219ModalBottomSheetContentIQkwcL4(androidx.compose.foundation.layout.BoxScope r44, androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r45, kotlinx.coroutines.CoroutineScope r46, kotlin.jvm.functions.Function0<kotlin.Unit> r47, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r48, androidx.compose.ui.Modifier r49, androidx.compose.material3.SheetState r50, float r51, androidx.compose.ui.graphics.Shape r52, long r53, long r55, float r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, ? extends androidx.compose.foundation.layout.WindowInsets> r59, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, androidx.compose.runtime.Composer r61, int r62, int r63, int r64) {
        /*
            r1 = r44
            r2 = r45
            r5 = r48
            r0 = r62
            r3 = r63
            r4 = r64
            r6 = -1676960531(0xffffffff9c0b9ced, float:-4.6194064E-22)
            r7 = r61
            androidx.compose.runtime.Composer r6 = r7.startRestartGroup(r6)
            java.lang.String r7 = "C(ModalBottomSheetContent)P(7,8!1,9,6,12,11:c#ui.unit.Dp,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.unit.Dp,5,4)205@9432L31,207@9563L13,208@9626L14,209@9668L31,215@10018L48,224@10294L324,232@10728L1476,267@12552L23,269@12621L112,273@12765L612,288@13518L2623,217@10072L6069:ModalBottomSheet.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r7)
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r7 & r4
            if (r7 == 0) goto L_0x0022
            r7 = r0 | 6
            goto L_0x0032
        L_0x0022:
            r7 = r0 & 6
            if (r7 != 0) goto L_0x0031
            boolean r7 = r6.changed((java.lang.Object) r1)
            if (r7 == 0) goto L_0x002e
            r7 = 4
            goto L_0x002f
        L_0x002e:
            r7 = 2
        L_0x002f:
            r7 = r7 | r0
            goto L_0x0032
        L_0x0031:
            r7 = r0
        L_0x0032:
            r10 = r4 & 1
            if (r10 == 0) goto L_0x0039
            r7 = r7 | 48
            goto L_0x0052
        L_0x0039:
            r10 = r0 & 48
            if (r10 != 0) goto L_0x0052
            r10 = r0 & 64
            if (r10 != 0) goto L_0x0046
            boolean r10 = r6.changed((java.lang.Object) r2)
            goto L_0x004a
        L_0x0046:
            boolean r10 = r6.changedInstance(r2)
        L_0x004a:
            if (r10 == 0) goto L_0x004f
            r10 = 32
            goto L_0x0051
        L_0x004f:
            r10 = 16
        L_0x0051:
            r7 = r7 | r10
        L_0x0052:
            r10 = r4 & 2
            if (r10 == 0) goto L_0x0059
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0059:
            r10 = r0 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x006c
            r10 = r46
            boolean r15 = r6.changedInstance(r10)
            if (r15 == 0) goto L_0x0068
            r15 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r15 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r7 = r7 | r15
            goto L_0x006e
        L_0x006c:
            r10 = r46
        L_0x006e:
            r15 = r4 & 4
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0079
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x008d
        L_0x0079:
            r15 = r0 & 3072(0xc00, float:4.305E-42)
            if (r15 != 0) goto L_0x008d
            r15 = r47
            boolean r18 = r6.changedInstance(r15)
            if (r18 == 0) goto L_0x0088
            r18 = r16
            goto L_0x008a
        L_0x0088:
            r18 = r17
        L_0x008a:
            r7 = r7 | r18
            goto L_0x008f
        L_0x008d:
            r15 = r47
        L_0x008f:
            r18 = r4 & 8
            r19 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x0098
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a8
        L_0x0098:
            r11 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x00a8
            boolean r11 = r6.changedInstance(r5)
            if (r11 == 0) goto L_0x00a5
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a5:
            r11 = r19
        L_0x00a7:
            r7 = r7 | r11
        L_0x00a8:
            r11 = r4 & 16
            r20 = 196608(0x30000, float:2.75506E-40)
            if (r11 == 0) goto L_0x00b3
            r7 = r7 | r20
            r13 = r49
            goto L_0x00c6
        L_0x00b3:
            r20 = r0 & r20
            r13 = r49
            if (r20 != 0) goto L_0x00c6
            boolean r21 = r6.changed((java.lang.Object) r13)
            if (r21 == 0) goto L_0x00c2
            r21 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c2:
            r21 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r7 = r7 | r21
        L_0x00c6:
            r21 = 1572864(0x180000, float:2.204052E-39)
            r22 = r0 & r21
            if (r22 != 0) goto L_0x00e0
            r22 = r4 & 32
            r12 = r50
            if (r22 != 0) goto L_0x00db
            boolean r24 = r6.changed((java.lang.Object) r12)
            if (r24 == 0) goto L_0x00db
            r24 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dd
        L_0x00db:
            r24 = 524288(0x80000, float:7.34684E-40)
        L_0x00dd:
            r7 = r7 | r24
            goto L_0x00e2
        L_0x00e0:
            r12 = r50
        L_0x00e2:
            r24 = r4 & 64
            r25 = 12582912(0xc00000, float:1.7632415E-38)
            if (r24 == 0) goto L_0x00ed
            r7 = r7 | r25
            r8 = r51
            goto L_0x0100
        L_0x00ed:
            r25 = r0 & r25
            r8 = r51
            if (r25 != 0) goto L_0x0100
            boolean r26 = r6.changed((float) r8)
            if (r26 == 0) goto L_0x00fc
            r26 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fe
        L_0x00fc:
            r26 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fe:
            r7 = r7 | r26
        L_0x0100:
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            r26 = r0 & r26
            if (r26 != 0) goto L_0x011c
            r9 = r4 & 128(0x80, float:1.794E-43)
            if (r9 != 0) goto L_0x0115
            r9 = r52
            boolean r27 = r6.changed((java.lang.Object) r9)
            if (r27 == 0) goto L_0x0117
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0119
        L_0x0115:
            r9 = r52
        L_0x0117:
            r27 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0119:
            r7 = r7 | r27
            goto L_0x011e
        L_0x011c:
            r9 = r52
        L_0x011e:
            r27 = 805306368(0x30000000, float:4.656613E-10)
            r27 = r0 & r27
            if (r27 != 0) goto L_0x013c
            r14 = r4 & 256(0x100, float:3.59E-43)
            if (r14 != 0) goto L_0x0134
            r14 = r7
            r7 = r53
            boolean r28 = r6.changed((long) r7)
            if (r28 == 0) goto L_0x0137
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0139
        L_0x0134:
            r14 = r7
            r7 = r53
        L_0x0137:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0139:
            r14 = r14 | r28
            goto L_0x013f
        L_0x013c:
            r14 = r7
            r7 = r53
        L_0x013f:
            r28 = r3 & 6
            if (r28 != 0) goto L_0x0154
            r0 = r4 & 512(0x200, float:7.175E-43)
            r7 = r55
            if (r0 != 0) goto L_0x0151
            boolean r0 = r6.changed((long) r7)
            if (r0 == 0) goto L_0x0151
            r0 = 4
            goto L_0x0152
        L_0x0151:
            r0 = 2
        L_0x0152:
            r0 = r0 | r3
            goto L_0x0157
        L_0x0154:
            r7 = r55
            r0 = r3
        L_0x0157:
            r61 = r0
            r0 = r4 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0164
            r18 = r61 | 48
            r28 = r0
        L_0x0161:
            r0 = r18
            goto L_0x0180
        L_0x0164:
            r28 = r3 & 48
            if (r28 != 0) goto L_0x017a
            r28 = r0
            r0 = r57
            boolean r29 = r6.changed((float) r0)
            if (r29 == 0) goto L_0x0175
            r18 = 32
            goto L_0x0177
        L_0x0175:
            r18 = 16
        L_0x0177:
            r18 = r61 | r18
            goto L_0x0161
        L_0x017a:
            r28 = r0
            r0 = r57
            r0 = r61
        L_0x0180:
            r7 = r4 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0187
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x019b
        L_0x0187:
            r8 = r3 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x019b
            r8 = r58
            boolean r18 = r6.changedInstance(r8)
            if (r18 == 0) goto L_0x0196
            r20 = 256(0x100, float:3.59E-43)
            goto L_0x0198
        L_0x0196:
            r20 = 128(0x80, float:1.794E-43)
        L_0x0198:
            r0 = r0 | r20
            goto L_0x019d
        L_0x019b:
            r8 = r58
        L_0x019d:
            r61 = r0
            r0 = r3 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01b9
            r0 = r4 & 4096(0x1000, float:5.74E-42)
            if (r0 != 0) goto L_0x01b0
            r0 = r59
            boolean r18 = r6.changedInstance(r0)
            if (r18 == 0) goto L_0x01b2
            goto L_0x01b4
        L_0x01b0:
            r0 = r59
        L_0x01b2:
            r16 = r17
        L_0x01b4:
            r16 = r61 | r16
            r0 = r16
            goto L_0x01bd
        L_0x01b9:
            r0 = r59
            r0 = r61
        L_0x01bd:
            r16 = r7
            r7 = r4 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x01c6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01d7
        L_0x01c6:
            r7 = r3 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x01d7
            r7 = r60
            boolean r17 = r6.changedInstance(r7)
            if (r17 == 0) goto L_0x01d4
            r19 = 16384(0x4000, float:2.2959E-41)
        L_0x01d4:
            r0 = r0 | r19
            goto L_0x01d9
        L_0x01d7:
            r7 = r60
        L_0x01d9:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r3 = r14 & r17
            r7 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r7) goto L_0x0204
            r3 = r0 & 9363(0x2493, float:1.312E-41)
            r7 = 9362(0x2492, float:1.3119E-41)
            if (r3 != r7) goto L_0x0204
            boolean r3 = r6.getSkipping()
            if (r3 != 0) goto L_0x01f0
            goto L_0x0204
        L_0x01f0:
            r6.skipToGroupEnd()
            r10 = r53
            r14 = r57
            r16 = r59
            r17 = r6
            r15 = r8
            r7 = r12
            r6 = r13
            r8 = r51
            r12 = r55
            goto L_0x04d6
        L_0x0204:
            r6.startDefaults()
            r3 = r62 & 1
            r7 = 0
            if (r3 == 0) goto L_0x024b
            boolean r3 = r6.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0213
            goto L_0x024b
        L_0x0213:
            r6.skipToGroupEnd()
            r3 = r4 & 32
            if (r3 == 0) goto L_0x021e
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r14 = r14 & r3
        L_0x021e:
            r3 = r4 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0226
            r3 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r14 = r14 & r3
        L_0x0226:
            r3 = r4 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x022e
            r3 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r14 = r14 & r3
        L_0x022e:
            r3 = r4 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0234
            r0 = r0 & -15
        L_0x0234:
            r3 = r4 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x023a
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x023a:
            r3 = r51
            r18 = r55
            r7 = r59
            r11 = r0
            r16 = r8
            r8 = r9
            r0 = r13
            r9 = r53
            r13 = r57
            goto L_0x02de
        L_0x024b:
            if (r11 == 0) goto L_0x0252
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r13 = r3
        L_0x0252:
            r3 = r4 & 32
            if (r3 == 0) goto L_0x0261
            r3 = 3
            r11 = 0
            androidx.compose.material3.SheetState r3 = rememberModalBottomSheetState(r7, r11, r6, r7, r3)
            r11 = -3670017(0xffffffffffc7ffff, float:NaN)
            r14 = r14 & r11
            r12 = r3
        L_0x0261:
            if (r24 == 0) goto L_0x026a
            androidx.compose.material3.BottomSheetDefaults r3 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r3 = r3.m1744getSheetMaxWidthD9Ej5fM()
            goto L_0x026c
        L_0x026a:
            r3 = r51
        L_0x026c:
            r11 = r4 & 128(0x80, float:1.794E-43)
            r7 = 6
            if (r11 == 0) goto L_0x027b
            androidx.compose.material3.BottomSheetDefaults r9 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r9 = r9.getExpandedShape(r6, r7)
            r11 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r14 = r14 & r11
        L_0x027b:
            r11 = r4 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x028d
            androidx.compose.material3.BottomSheetDefaults r11 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            long r18 = r11.getContainerColor(r6, r7)
            r7 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r7 = r7 & r14
            r14 = r7
            r7 = r18
            goto L_0x028f
        L_0x028d:
            r7 = r53
        L_0x028f:
            r11 = r4 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x029e
            int r11 = r14 >> 27
            r11 = r11 & 14
            long r18 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r7, r6, r11)
            r0 = r0 & -15
            goto L_0x02a0
        L_0x029e:
            r18 = r55
        L_0x02a0:
            if (r28 == 0) goto L_0x02a9
            androidx.compose.material3.BottomSheetDefaults r11 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r11 = r11.m1743getElevationD9Ej5fM()
            goto L_0x02ab
        L_0x02a9:
            r11 = r57
        L_0x02ab:
            if (r16 == 0) goto L_0x02b4
            androidx.compose.material3.ComposableSingletons$ModalBottomSheetKt r16 = androidx.compose.material3.ComposableSingletons$ModalBottomSheetKt.INSTANCE
            kotlin.jvm.functions.Function2 r16 = r16.m1928getLambda2$material3_release()
            goto L_0x02b6
        L_0x02b4:
            r16 = r58
        L_0x02b6:
            r49 = r3
            r3 = r4 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x02d1
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$1 r3 = androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$1.INSTANCE
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
            r42 = r7
            r8 = r9
            r9 = r42
            r42 = r11
            r11 = r0
            r0 = r13
            r13 = r42
            r7 = r3
            r3 = r49
            goto L_0x02de
        L_0x02d1:
            r42 = r7
            r8 = r9
            r9 = r42
            r3 = r11
            r11 = r0
            r0 = r13
            r13 = r3
            r3 = r49
            r7 = r59
        L_0x02de:
            r6.endDefaults()
            boolean r20 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r20 == 0) goto L_0x02f2
            r4 = -1676960531(0xffffffff9c0b9ced, float:-4.6194064E-22)
            r50 = r7
            java.lang.String r7 = "androidx.compose.material3.ModalBottomSheetContent (ModalBottomSheet.kt:214)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r14, r11, r7)
            goto L_0x02f4
        L_0x02f2:
            r50 = r7
        L_0x02f4:
            androidx.compose.material3.internal.Strings$Companion r4 = androidx.compose.material3.internal.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_bottom_sheet_pane_title
            int r4 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r4)
            r7 = 0
            java.lang.String r4 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r4, r6, r7)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopCenter()
            androidx.compose.ui.Modifier r7 = r1.align(r0, r7)
            r20 = r0
            r0 = 0
            r1 = 1
            r57 = r8
            r8 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m852widthInVpY3zN4$default(r7, r0, r3, r1, r8)
            r7 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r0, r7, r1, r8)
            r7 = 1237857395(0x49c83473, float:1640078.4)
            java.lang.String r8 = "CC(remember):ModalBottomSheet.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r7, r8)
            r7 = 3670016(0x380000, float:5.142788E-39)
            r7 = r7 & r14
            r7 = r7 ^ r21
            r1 = 1048576(0x100000, float:1.469368E-39)
            if (r7 <= r1) goto L_0x0336
            boolean r23 = r6.changed((java.lang.Object) r12)
            if (r23 != 0) goto L_0x0333
            goto L_0x0336
        L_0x0333:
            r23 = r3
            goto L_0x033c
        L_0x0336:
            r23 = r3
            r3 = r14 & r21
            if (r3 != r1) goto L_0x033e
        L_0x033c:
            r1 = 1
            goto L_0x033f
        L_0x033e:
            r1 = 0
        L_0x033f:
            java.lang.Object r3 = r6.rememberedValue()
            if (r1 != 0) goto L_0x034d
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x0356
        L_0x034d:
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = androidx.compose.material3.SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r12, r1, r5)
            r6.updateRememberedValue(r3)
        L_0x0356:
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r28 = r9
            r1 = 2
            r9 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r0, r3, r9, r1, r9)
            androidx.compose.material3.internal.AnchoredDraggableState r1 = r12.getAnchoredDraggableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r3 = androidx.compose.foundation.gestures.Orientation.Vertical
            r9 = 1237872435(0x49c86f33, float:1641958.4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r9, r8)
            r9 = 1048576(0x100000, float:1.469368E-39)
            if (r7 <= r9) goto L_0x0379
            boolean r10 = r6.changed((java.lang.Object) r12)
            if (r10 != 0) goto L_0x037d
        L_0x0379:
            r10 = r14 & r21
            if (r10 != r9) goto L_0x037f
        L_0x037d:
            r9 = 1
            goto L_0x0380
        L_0x037f:
            r9 = 0
        L_0x0380:
            java.lang.Object r10 = r6.rememberedValue()
            if (r9 != 0) goto L_0x038e
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x0399
        L_0x038e:
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$3$1 r9 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$3$1
            r9.<init>(r12)
            r10 = r9
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r6.updateRememberedValue(r10)
        L_0x0399:
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.Modifier r30 = androidx.compose.material3.internal.AnchoredDraggableKt.draggableAnchors(r0, r1, r3, r10)
            androidx.compose.material3.internal.AnchoredDraggableState r0 = r12.getAnchoredDraggableState$material3_release()
            androidx.compose.foundation.gestures.DraggableState r31 = r0.getDraggableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r32 = androidx.compose.foundation.gestures.Orientation.Vertical
            boolean r33 = r12.isVisible()
            androidx.compose.material3.internal.AnchoredDraggableState r0 = r12.getAnchoredDraggableState$material3_release()
            boolean r35 = r0.isAnimationRunning()
            r0 = 1237929350(0x49c94d86, float:1649072.8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r8)
            r0 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r14
            r1 = 16384(0x4000, float:2.2959E-41)
            if (r0 != r1) goto L_0x03c8
            r0 = 1
            goto L_0x03c9
        L_0x03c8:
            r0 = 0
        L_0x03c9:
            java.lang.Object r1 = r6.rememberedValue()
            if (r0 != 0) goto L_0x03d7
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x03e3
        L_0x03d7:
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$4$1 r0 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$4$1
            r9 = 0
            r0.<init>(r5, r9)
            r1 = r0
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r6.updateRememberedValue(r1)
        L_0x03e3:
            r37 = r1
            kotlin.jvm.functions.Function3 r37 = (kotlin.jvm.functions.Function3) r37
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r39 = 168(0xa8, float:2.35E-43)
            r40 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            r1 = 1237931647(0x49c9567f, float:1649359.9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r8)
            boolean r1 = r6.changed((java.lang.Object) r4)
            java.lang.Object r3 = r6.rememberedValue()
            if (r1 != 0) goto L_0x0410
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x041b
        L_0x0410:
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$5$1 r1 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$5$1
            r1.<init>(r4)
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r6.updateRememberedValue(r3)
        L_0x041b:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r1 = 0
            r4 = 1
            r9 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r1, r3, r4, r9)
            r3 = 1237936755(0x49c96a73, float:1649998.4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r8)
            r9 = 1048576(0x100000, float:1.469368E-39)
            if (r7 <= r9) goto L_0x0437
            boolean r3 = r6.changed((java.lang.Object) r12)
            if (r3 != 0) goto L_0x043b
        L_0x0437:
            r3 = r14 & r21
            if (r3 != r9) goto L_0x043d
        L_0x043b:
            r7 = 1
            goto L_0x043e
        L_0x043d:
            r7 = r1
        L_0x043e:
            r3 = r14 & 112(0x70, float:1.57E-43)
            r4 = 32
            if (r3 == r4) goto L_0x044e
            r3 = r14 & 64
            if (r3 == 0) goto L_0x044f
            boolean r3 = r6.changedInstance(r2)
            if (r3 == 0) goto L_0x044f
        L_0x044e:
            r1 = 1
        L_0x044f:
            r1 = r1 | r7
            java.lang.Object r3 = r6.rememberedValue()
            if (r1 != 0) goto L_0x045e
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x0469
        L_0x045e:
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$6$1 r1 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$6$1
            r1.<init>(r12, r2)
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r6.updateRememberedValue(r3)
        L_0x0469:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r0, r3)
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$7 r0 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$7
            r55 = r46
            r56 = r60
            r49 = r0
            r51 = r2
            r53 = r12
            r54 = r15
            r52 = r16
            r49.<init>(r50, r51, r52, r53, r54, r55, r56)
            r1 = r49
            r3 = r50
            r2 = r52
            r0 = r53
            r4 = 54
            r8 = -692668920(0xffffffffd6b6b608, float:-1.00446467E14)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r8, r9, r1, r6, r4)
            r16 = r1
            kotlin.jvm.functions.Function2 r16 = (kotlin.jvm.functions.Function2) r16
            int r1 = r14 >> 21
            r4 = r1 & 112(0x70, float:1.57E-43)
            r8 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r8
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r4
            int r4 = r11 << 9
            r8 = r4 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r8
            r8 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r8
            r1 = r1 | r4
            r11 = r18
            r19 = 96
            r14 = 0
            r15 = 0
            r8 = r57
            r18 = r1
            r17 = r6
            r9 = r28
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r7, r8, r9, r11, r13, r14, r15, r16, r17, r18, r19)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x04c9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04c9:
            r7 = r0
            r15 = r2
            r16 = r3
            r9 = r8
            r14 = r13
            r6 = r20
            r8 = r23
            r12 = r11
            r10 = r28
        L_0x04d6:
            androidx.compose.runtime.ScopeUpdateScope r0 = r17.endRestartGroup()
            if (r0 == 0) goto L_0x04fb
            r1 = r0
            androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$8 r0 = new androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$8
            r2 = r45
            r3 = r46
            r4 = r47
            r17 = r60
            r18 = r62
            r19 = r63
            r20 = r64
            r41 = r1
            r1 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r14, r15, r16, r17, r18, r19, r20)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r41
            r1.updateScope(r0)
        L_0x04fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheetKt.m2219ModalBottomSheetContentIQkwcL4(androidx.compose.foundation.layout.BoxScope, androidx.compose.animation.core.Animatable, kotlinx.coroutines.CoroutineScope, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, float f) {
        float r0 = Size.m4056getWidthimpl(graphicsLayerScope.m4427getSizeNHjbRc());
        if (Float.isNaN(r0) || r0 == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.m7091toPx0680j_4(PredictiveBackMaxScaleXDistance), r0), f) / r0);
    }

    /* access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, float f) {
        float r0 = Size.m4053getHeightimpl(graphicsLayerScope.m4427getSizeNHjbRc());
        if (Float.isNaN(r0) || r0 == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.m7091toPx0680j_4(PredictiveBackMaxScaleYDistance), r0), f) / r0);
    }

    public static final SheetState rememberModalBottomSheetState(boolean z, Function1<? super SheetValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -778250030, "C(rememberModalBottomSheetState)P(1)400@18058L160:ModalBottomSheet.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            function1 = ModalBottomSheetKt$rememberModalBottomSheetState$1.INSTANCE;
        }
        Function1<? super SheetValue, Boolean> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-778250030, i, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.kt:400)");
        }
        Composer composer2 = composer;
        SheetState rememberSheetState = SheetDefaultsKt.rememberSheetState(z2, function12, SheetValue.Hidden, false, composer2, (i & 14) | 384 | (i & 112), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return rememberSheetState;
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m2220Scrim3JVO9M(long j, Function0<Unit> function0, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifier;
        long j2 = j;
        Function0<Unit> function02 = function0;
        boolean z2 = z;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(951870469);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(0:c#ui.graphics.Color)410@18376L87,411@18489L29,426@19112L79,426@19062L129:ModalBottomSheet.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed(j2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(951870469, i2, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.kt:407)");
            }
            if (j2 != 16) {
                int i4 = i2;
                State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z2 ? 1.0f : 0.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (String) null, (Function1<? super Float, Unit>) null, startRestartGroup, 48, 28);
                Strings.Companion companion = Strings.Companion;
                String r7 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.close_sheet), startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(-1785653838);
                ComposerKt.sourceInformation(startRestartGroup, "414@18629L44,415@18730L263");
                boolean z3 = true;
                if (z2) {
                    Modifier modifier2 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1785652017, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    int i5 = i4 & 112;
                    boolean z4 = i5 == 32;
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new ModalBottomSheetKt$Scrim$dismissSheet$1$1(function02, (Continuation<? super ModalBottomSheetKt$Scrim$dismissSheet$1$1>) null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier2, (Object) function02, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1785648566, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean changed = (i5 == 32) | startRestartGroup.changed((Object) r7);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new ModalBottomSheetKt$Scrim$dismissSheet$2$1(r7, function02);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    modifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
                } else {
                    modifier = Modifier.Companion;
                }
                startRestartGroup.endReplaceGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(modifier);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1785636526, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if ((i4 & 14) != 4) {
                    z3 = false;
                }
                boolean changed2 = startRestartGroup.changed((Object) animateFloatAsState) | z3;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new ModalBottomSheetKt$Scrim$1$1(j2, animateFloatAsState);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ModalBottomSheetKt$Scrim$2(j2, function02, z2, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$10(State<Float> state) {
        return state.getValue().floatValue();
    }
}
