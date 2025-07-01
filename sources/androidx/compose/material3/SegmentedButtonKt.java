package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aD\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0011\u001a\u00020\u00062\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010\u0014\u001aD\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0010\u001a\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010&\u001a\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\u00162\u0006\u0010'\u001a\u00020\u001a2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010)\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020-H\u0003¢\u0006\u0002\u0010.\u001a\"\u0010/\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"CheckedZIndexFactor", "", "IconSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "MultiChoiceSegmentedButtonRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "space", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SegmentedButtonContent", "icon", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SingleChoiceSegmentedButtonRow", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "SegmentedButton", "checked", "", "onCheckedChange", "shape", "Landroidx/compose/ui/graphics/Shape;", "enabled", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "label", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "onClick", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "interactionCountAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionZIndex", "interactionCount", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentedButton.kt */
public final class SegmentedButtonKt {
    private static final float CheckedZIndexFactor = 5.0f;
    /* access modifiers changed from: private */
    public static final float IconSpacing = Dp.m7111constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SegmentedButton(androidx.compose.material3.MultiChoiceSegmentedButtonRowScope r26, boolean r27, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r28, androidx.compose.ui.graphics.Shape r29, androidx.compose.ui.Modifier r30, boolean r31, androidx.compose.material3.SegmentedButtonColors r32, androidx.compose.foundation.BorderStroke r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39, int r40) {
        /*
            r1 = r26
            r2 = r27
            r0 = r36
            r3 = r38
            r4 = r40
            r5 = -1596038053(0xffffffffa0de645b, float:-3.7674673E-19)
            r6 = r37
            androidx.compose.runtime.Composer r6 = r6.startRestartGroup(r5)
            java.lang.String r7 = "C(SegmentedButton)P(1,8,9,7,3,2!1,5)133@6692L8,137@6905L41,144@7279L25,163@7880L51,146@7310L621:SegmentedButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r7)
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r7 & r4
            if (r7 == 0) goto L_0x0020
            r7 = r3 | 6
            goto L_0x0030
        L_0x0020:
            r7 = r3 & 6
            if (r7 != 0) goto L_0x002f
            boolean r7 = r6.changed((java.lang.Object) r1)
            if (r7 == 0) goto L_0x002c
            r7 = 4
            goto L_0x002d
        L_0x002c:
            r7 = 2
        L_0x002d:
            r7 = r7 | r3
            goto L_0x0030
        L_0x002f:
            r7 = r3
        L_0x0030:
            r10 = r4 & 1
            if (r10 == 0) goto L_0x0037
            r7 = r7 | 48
            goto L_0x0047
        L_0x0037:
            r10 = r3 & 48
            if (r10 != 0) goto L_0x0047
            boolean r10 = r6.changed((boolean) r2)
            if (r10 == 0) goto L_0x0044
            r10 = 32
            goto L_0x0046
        L_0x0044:
            r10 = 16
        L_0x0046:
            r7 = r7 | r10
        L_0x0047:
            r10 = r4 & 2
            if (r10 == 0) goto L_0x004e
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r10 = r3 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x0061
            r10 = r28
            boolean r11 = r6.changedInstance(r10)
            if (r11 == 0) goto L_0x005d
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r11 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r7 = r7 | r11
            goto L_0x0063
        L_0x0061:
            r10 = r28
        L_0x0063:
            r11 = r4 & 4
            if (r11 == 0) goto L_0x006a
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r11 = r3 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x007d
            r11 = r29
            boolean r12 = r6.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0079
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r7 = r7 | r12
            goto L_0x007f
        L_0x007d:
            r11 = r29
        L_0x007f:
            r12 = r4 & 8
            if (r12 == 0) goto L_0x0086
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r13 = r3 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0099
            r13 = r30
            boolean r14 = r6.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0095
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r7 = r7 | r14
            goto L_0x009b
        L_0x0099:
            r13 = r30
        L_0x009b:
            r14 = r4 & 16
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a3
            r7 = r7 | r15
            goto L_0x00b6
        L_0x00a3:
            r15 = r15 & r3
            if (r15 != 0) goto L_0x00b6
            r15 = r31
            boolean r16 = r6.changed((boolean) r15)
            if (r16 == 0) goto L_0x00b1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r7 = r7 | r16
            goto L_0x00b8
        L_0x00b6:
            r15 = r31
        L_0x00b8:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r3 & r16
            if (r16 != 0) goto L_0x00d2
            r16 = r4 & 32
            r8 = r32
            if (r16 != 0) goto L_0x00cd
            boolean r16 = r6.changed((java.lang.Object) r8)
            if (r16 == 0) goto L_0x00cd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00cd:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cf:
            r7 = r7 | r16
            goto L_0x00d4
        L_0x00d2:
            r8 = r32
        L_0x00d4:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r3 & r16
            if (r16 != 0) goto L_0x00ee
            r16 = r4 & 64
            r5 = r33
            if (r16 != 0) goto L_0x00e9
            boolean r17 = r6.changed((java.lang.Object) r5)
            if (r17 == 0) goto L_0x00e9
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00eb
        L_0x00e9:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00eb:
            r7 = r7 | r17
            goto L_0x00f0
        L_0x00ee:
            r5 = r33
        L_0x00f0:
            r9 = r4 & 128(0x80, float:1.794E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r9 == 0) goto L_0x00fb
            r7 = r7 | r18
            r1 = r34
            goto L_0x010e
        L_0x00fb:
            r18 = r3 & r18
            r1 = r34
            if (r18 != 0) goto L_0x010e
            boolean r18 = r6.changed((java.lang.Object) r1)
            if (r18 == 0) goto L_0x010a
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010c
        L_0x010a:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010c:
            r7 = r7 | r18
        L_0x010e:
            r1 = r4 & 256(0x100, float:3.59E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r1 == 0) goto L_0x0117
            r7 = r7 | r18
            goto L_0x012d
        L_0x0117:
            r18 = r3 & r18
            if (r18 != 0) goto L_0x012d
            r18 = r1
            r1 = r35
            boolean r19 = r6.changedInstance(r1)
            if (r19 == 0) goto L_0x0128
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012a
        L_0x0128:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012a:
            r7 = r7 | r19
            goto L_0x0131
        L_0x012d:
            r18 = r1
            r1 = r35
        L_0x0131:
            r1 = r4 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0138
            r1 = r39 | 6
            goto L_0x014a
        L_0x0138:
            r1 = r39 & 6
            if (r1 != 0) goto L_0x0148
            boolean r1 = r6.changedInstance(r0)
            if (r1 == 0) goto L_0x0144
            r1 = 4
            goto L_0x0145
        L_0x0144:
            r1 = 2
        L_0x0145:
            r1 = r39 | r1
            goto L_0x014a
        L_0x0148:
            r1 = r39
        L_0x014a:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r3 = r7 & r19
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r4) goto L_0x016f
            r3 = r1 & 3
            r4 = 2
            if (r3 != r4) goto L_0x016f
            boolean r3 = r6.getSkipping()
            if (r3 != 0) goto L_0x0160
            goto L_0x016f
        L_0x0160:
            r6.skipToGroupEnd()
            r9 = r34
            r10 = r35
            r16 = r6
            r7 = r8
            r6 = r15
            r8 = r5
            r5 = r13
            goto L_0x02d0
        L_0x016f:
            r6.startDefaults()
            r3 = r38 & 1
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r19 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = 6
            if (r3 == 0) goto L_0x01a0
            boolean r3 = r6.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0184
            goto L_0x01a0
        L_0x0184:
            r6.skipToGroupEnd()
            r3 = r40 & 32
            if (r3 == 0) goto L_0x018d
            r7 = r7 & r19
        L_0x018d:
            r3 = r40 & 64
            if (r3 == 0) goto L_0x0193
            r7 = r7 & r17
        L_0x0193:
            r20 = r34
            r17 = r4
            r4 = r8
            r3 = r13
            r13 = r5
            r8 = r7
            r5 = r15
        L_0x019c:
            r7 = r35
            goto L_0x01f9
        L_0x01a0:
            if (r12 == 0) goto L_0x01a7
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x01a8
        L_0x01a7:
            r3 = r13
        L_0x01a8:
            if (r14 == 0) goto L_0x01ab
            r15 = 1
        L_0x01ab:
            r12 = r40 & 32
            if (r12 == 0) goto L_0x01b7
            androidx.compose.material3.SegmentedButtonDefaults r8 = androidx.compose.material3.SegmentedButtonDefaults.INSTANCE
            androidx.compose.material3.SegmentedButtonColors r8 = r8.colors(r6, r4)
            r7 = r7 & r19
        L_0x01b7:
            r12 = r40 & 64
            if (r12 == 0) goto L_0x01cd
            androidx.compose.material3.SegmentedButtonDefaults r20 = androidx.compose.material3.SegmentedButtonDefaults.INSTANCE
            long r21 = r8.m2418borderColorWaAFU9c$material3_release(r15, r2)
            r24 = 2
            r25 = 0
            r23 = 0
            androidx.compose.foundation.BorderStroke r5 = androidx.compose.material3.SegmentedButtonDefaults.m2435borderStrokel07J4OM$default(r20, r21, r23, r24, r25)
            r7 = r7 & r17
        L_0x01cd:
            if (r9 == 0) goto L_0x01d1
            r9 = 0
            goto L_0x01d3
        L_0x01d1:
            r9 = r34
        L_0x01d3:
            if (r18 == 0) goto L_0x01f0
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$1 r12 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$1
            r12.<init>(r2)
            r13 = 970447394(0x39d7da22, float:4.1170517E-4)
            r17 = r4
            r4 = 1
            r14 = 54
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r13, r4, r12, r6, r14)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = r5
            r4 = r8
            r20 = r9
            r5 = r15
            r8 = r7
            r7 = r12
            goto L_0x01f9
        L_0x01f0:
            r17 = r4
            r13 = r5
            r4 = r8
            r20 = r9
            r5 = r15
            r8 = r7
            goto L_0x019c
        L_0x01f9:
            r6.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x020a
            java.lang.String r9 = "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:139)"
            r12 = -1596038053(0xffffffffa0de645b, float:-3.7674673E-19)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r8, r1, r9)
        L_0x020a:
            r1 = 1788099965(0x6a943d7d, float:8.96057E25)
            r6.startReplaceGroup(r1)
            java.lang.String r1 = "141@7068L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            if (r20 != 0) goto L_0x0239
            r1 = 1788100616(0x6a944008, float:8.96117E25)
            java.lang.String r9 = "CC(remember):SegmentedButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r9)
            java.lang.Object r1 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r1 != r9) goto L_0x0232
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r1)
        L_0x0232:
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r14 = r1
            goto L_0x023b
        L_0x0239:
            r14 = r20
        L_0x023b:
            r6.endReplaceGroup()
            long r15 = r4.m2419containerColorWaAFU9c$material3_release(r5, r2)
            long r9 = r4.m2420contentColorWaAFU9c$material3_release(r5, r2)
            r1 = r14
            androidx.compose.foundation.interaction.InteractionSource r1 = (androidx.compose.foundation.interaction.InteractionSource) r1
            r12 = 0
            androidx.compose.runtime.State r1 = interactionCountAsState(r1, r6, r12)
            r12 = r26
            androidx.compose.foundation.layout.RowScope r12 = (androidx.compose.foundation.layout.RowScope) r12
            r18 = 2
            r19 = 0
            r21 = 1065353216(0x3f800000, float:1.0)
            r22 = 0
            r31 = r3
            r30 = r12
            r34 = r18
            r35 = r19
            r32 = r21
            r33 = r22
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.RowScope.weight$default(r30, r31, r32, r33, r34, r35)
            r21 = r31
            androidx.compose.ui.Modifier r1 = interactionZIndex(r3, r2, r1)
            androidx.compose.material3.ButtonDefaults r3 = androidx.compose.material3.ButtonDefaults.INSTANCE
            float r3 = r3.m1770getMinWidthD9Ej5fM()
            androidx.compose.material3.ButtonDefaults r12 = androidx.compose.material3.ButtonDefaults.INSTANCE
            float r12 = r12.m1769getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m829defaultMinSizeVpY3zN4(r1, r3, r12)
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$2 r3 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$2
            r3.<init>(r7, r0)
            r12 = 1635710341(0x617ef585, float:2.9394778E20)
            r30 = r1
            r0 = 54
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r12, r1, r3, r6, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r1 = r8 >> 3
            r1 = r1 & 126(0x7e, float:1.77E-43)
            int r3 = r8 >> 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            int r12 = r8 << 3
            r3 = r3 & r12
            r1 = r1 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            int r8 = r8 << 6
            r3 = r3 & r8
            r17 = r1 | r3
            r18 = 48
            r19 = 384(0x180, float:5.38E-43)
            r11 = 0
            r12 = 0
            r3 = r28
            r1 = r7
            r7 = r15
            r15 = r0
            r0 = r4
            r16 = r6
            r6 = r29
            r4 = r30
            androidx.compose.material3.SurfaceKt.m2538Surfaced85dljk((boolean) r2, (kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>) r3, (androidx.compose.ui.Modifier) r4, (boolean) r5, (androidx.compose.ui.graphics.Shape) r6, (long) r7, (long) r9, (float) r11, (float) r12, (androidx.compose.foundation.BorderStroke) r13, (androidx.compose.foundation.interaction.MutableInteractionSource) r14, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x02c8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02c8:
            r7 = r0
            r10 = r1
            r6 = r5
            r8 = r13
            r9 = r20
            r5 = r21
        L_0x02d0:
            androidx.compose.runtime.ScopeUpdateScope r15 = r16.endRestartGroup()
            if (r15 == 0) goto L_0x02f0
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$3 r0 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$3
            r1 = r26
            r2 = r27
            r3 = r28
            r4 = r29
            r11 = r36
            r12 = r38
            r13 = r39
            r14 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x02f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonKt.SegmentedButton(androidx.compose.material3.MultiChoiceSegmentedButtonRowScope, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.graphics.Shape, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SegmentedButtonColors, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SegmentedButton(androidx.compose.material3.SingleChoiceSegmentedButtonRowScope r27, boolean r28, kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.graphics.Shape r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.material3.SegmentedButtonColors r33, androidx.compose.foundation.BorderStroke r34, androidx.compose.foundation.interaction.MutableInteractionSource r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40, int r41) {
        /*
            r1 = r27
            r2 = r28
            r0 = r37
            r3 = r39
            r4 = r41
            r5 = -1016574361(0xffffffffc3684e67, float:-232.30626)
            r6 = r38
            androidx.compose.runtime.Composer r6 = r6.startRestartGroup(r5)
            java.lang.String r7 = "C(SegmentedButton)P(8,7,9,6,2,1!1,4)211@10255L8,215@10469L42,222@10846L25,242@11489L51,224@10877L663:SegmentedButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r7)
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r7 & r4
            if (r7 == 0) goto L_0x0020
            r7 = r3 | 6
            goto L_0x0030
        L_0x0020:
            r7 = r3 & 6
            if (r7 != 0) goto L_0x002f
            boolean r7 = r6.changed((java.lang.Object) r1)
            if (r7 == 0) goto L_0x002c
            r7 = 4
            goto L_0x002d
        L_0x002c:
            r7 = 2
        L_0x002d:
            r7 = r7 | r3
            goto L_0x0030
        L_0x002f:
            r7 = r3
        L_0x0030:
            r10 = r4 & 1
            if (r10 == 0) goto L_0x0037
            r7 = r7 | 48
            goto L_0x0047
        L_0x0037:
            r10 = r3 & 48
            if (r10 != 0) goto L_0x0047
            boolean r10 = r6.changed((boolean) r2)
            if (r10 == 0) goto L_0x0044
            r10 = 32
            goto L_0x0046
        L_0x0044:
            r10 = 16
        L_0x0046:
            r7 = r7 | r10
        L_0x0047:
            r10 = r4 & 2
            if (r10 == 0) goto L_0x004e
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r10 = r3 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x0061
            r10 = r29
            boolean r11 = r6.changedInstance(r10)
            if (r11 == 0) goto L_0x005d
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r11 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r7 = r7 | r11
            goto L_0x0063
        L_0x0061:
            r10 = r29
        L_0x0063:
            r11 = r4 & 4
            if (r11 == 0) goto L_0x006a
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r11 = r3 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x007d
            r11 = r30
            boolean r12 = r6.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0079
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r7 = r7 | r12
            goto L_0x007f
        L_0x007d:
            r11 = r30
        L_0x007f:
            r12 = r4 & 8
            if (r12 == 0) goto L_0x0086
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r13 = r3 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0099
            r13 = r31
            boolean r14 = r6.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0095
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r7 = r7 | r14
            goto L_0x009b
        L_0x0099:
            r13 = r31
        L_0x009b:
            r14 = r4 & 16
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a3
            r7 = r7 | r15
            goto L_0x00b6
        L_0x00a3:
            r15 = r15 & r3
            if (r15 != 0) goto L_0x00b6
            r15 = r32
            boolean r16 = r6.changed((boolean) r15)
            if (r16 == 0) goto L_0x00b1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r7 = r7 | r16
            goto L_0x00b8
        L_0x00b6:
            r15 = r32
        L_0x00b8:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r3 & r16
            if (r16 != 0) goto L_0x00d2
            r16 = r4 & 32
            r8 = r33
            if (r16 != 0) goto L_0x00cd
            boolean r16 = r6.changed((java.lang.Object) r8)
            if (r16 == 0) goto L_0x00cd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00cd:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cf:
            r7 = r7 | r16
            goto L_0x00d4
        L_0x00d2:
            r8 = r33
        L_0x00d4:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r3 & r16
            if (r16 != 0) goto L_0x00ee
            r16 = r4 & 64
            r5 = r34
            if (r16 != 0) goto L_0x00e9
            boolean r17 = r6.changed((java.lang.Object) r5)
            if (r17 == 0) goto L_0x00e9
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00eb
        L_0x00e9:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00eb:
            r7 = r7 | r17
            goto L_0x00f0
        L_0x00ee:
            r5 = r34
        L_0x00f0:
            r9 = r4 & 128(0x80, float:1.794E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r9 == 0) goto L_0x00fb
            r7 = r7 | r18
            r1 = r35
            goto L_0x010e
        L_0x00fb:
            r18 = r3 & r18
            r1 = r35
            if (r18 != 0) goto L_0x010e
            boolean r18 = r6.changed((java.lang.Object) r1)
            if (r18 == 0) goto L_0x010a
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010c
        L_0x010a:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010c:
            r7 = r7 | r18
        L_0x010e:
            r1 = r4 & 256(0x100, float:3.59E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r1 == 0) goto L_0x0117
            r7 = r7 | r18
            goto L_0x012d
        L_0x0117:
            r18 = r3 & r18
            if (r18 != 0) goto L_0x012d
            r18 = r1
            r1 = r36
            boolean r19 = r6.changedInstance(r1)
            if (r19 == 0) goto L_0x0128
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012a
        L_0x0128:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012a:
            r7 = r7 | r19
            goto L_0x0131
        L_0x012d:
            r18 = r1
            r1 = r36
        L_0x0131:
            r1 = r4 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0138
            r1 = r40 | 6
            goto L_0x014a
        L_0x0138:
            r1 = r40 & 6
            if (r1 != 0) goto L_0x0148
            boolean r1 = r6.changedInstance(r0)
            if (r1 == 0) goto L_0x0144
            r1 = 4
            goto L_0x0145
        L_0x0144:
            r1 = 2
        L_0x0145:
            r1 = r40 | r1
            goto L_0x014a
        L_0x0148:
            r1 = r40
        L_0x014a:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r3 = r7 & r19
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r4) goto L_0x016f
            r3 = r1 & 3
            r4 = 2
            if (r3 != r4) goto L_0x016f
            boolean r3 = r6.getSkipping()
            if (r3 != 0) goto L_0x0160
            goto L_0x016f
        L_0x0160:
            r6.skipToGroupEnd()
            r9 = r35
            r10 = r36
            r16 = r6
            r7 = r8
            r6 = r15
            r8 = r5
            r5 = r13
            goto L_0x02df
        L_0x016f:
            r6.startDefaults()
            r3 = r39 & 1
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r19 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = 6
            if (r3 == 0) goto L_0x01a0
            boolean r3 = r6.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0184
            goto L_0x01a0
        L_0x0184:
            r6.skipToGroupEnd()
            r3 = r41 & 32
            if (r3 == 0) goto L_0x018d
            r7 = r7 & r19
        L_0x018d:
            r3 = r41 & 64
            if (r3 == 0) goto L_0x0193
            r7 = r7 & r17
        L_0x0193:
            r21 = r35
            r17 = r4
            r4 = r8
            r3 = r13
            r13 = r5
            r8 = r7
            r5 = r15
        L_0x019c:
            r7 = r36
            goto L_0x01f9
        L_0x01a0:
            if (r12 == 0) goto L_0x01a7
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x01a8
        L_0x01a7:
            r3 = r13
        L_0x01a8:
            if (r14 == 0) goto L_0x01ab
            r15 = 1
        L_0x01ab:
            r12 = r41 & 32
            if (r12 == 0) goto L_0x01b7
            androidx.compose.material3.SegmentedButtonDefaults r8 = androidx.compose.material3.SegmentedButtonDefaults.INSTANCE
            androidx.compose.material3.SegmentedButtonColors r8 = r8.colors(r6, r4)
            r7 = r7 & r19
        L_0x01b7:
            r12 = r41 & 64
            if (r12 == 0) goto L_0x01cd
            androidx.compose.material3.SegmentedButtonDefaults r21 = androidx.compose.material3.SegmentedButtonDefaults.INSTANCE
            long r22 = r8.m2418borderColorWaAFU9c$material3_release(r15, r2)
            r25 = 2
            r26 = 0
            r24 = 0
            androidx.compose.foundation.BorderStroke r5 = androidx.compose.material3.SegmentedButtonDefaults.m2435borderStrokel07J4OM$default(r21, r22, r24, r25, r26)
            r7 = r7 & r17
        L_0x01cd:
            if (r9 == 0) goto L_0x01d1
            r9 = 0
            goto L_0x01d3
        L_0x01d1:
            r9 = r35
        L_0x01d3:
            if (r18 == 0) goto L_0x01f0
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$4 r12 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$4
            r12.<init>(r2)
            r13 = 54
            r14 = 1235063168(0x499d9180, float:1290800.0)
            r17 = r4
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r14, r4, r12, r6, r13)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = r5
            r4 = r8
            r21 = r9
            r5 = r15
            r8 = r7
            r7 = r12
            goto L_0x01f9
        L_0x01f0:
            r17 = r4
            r13 = r5
            r4 = r8
            r21 = r9
            r5 = r15
            r8 = r7
            goto L_0x019c
        L_0x01f9:
            r6.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x020a
            java.lang.String r9 = "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:217)"
            r12 = -1016574361(0xffffffffc3684e67, float:-232.30626)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r8, r1, r9)
        L_0x020a:
            r1 = 1788214045(0x6a95fb1d, float:9.06579E25)
            r6.startReplaceGroup(r1)
            java.lang.String r1 = "219@10633L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            if (r21 != 0) goto L_0x0239
            r1 = 1788214696(0x6a95fda8, float:9.06639E25)
            java.lang.String r9 = "CC(remember):SegmentedButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r9)
            java.lang.Object r1 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r1 != r9) goto L_0x0232
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r1)
        L_0x0232:
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r14 = r1
            goto L_0x023b
        L_0x0239:
            r14 = r21
        L_0x023b:
            r6.endReplaceGroup()
            long r15 = r4.m2419containerColorWaAFU9c$material3_release(r5, r2)
            long r9 = r4.m2420contentColorWaAFU9c$material3_release(r5, r2)
            r1 = r14
            androidx.compose.foundation.interaction.InteractionSource r1 = (androidx.compose.foundation.interaction.InteractionSource) r1
            r12 = 0
            androidx.compose.runtime.State r1 = interactionCountAsState(r1, r6, r12)
            r18 = r27
            androidx.compose.foundation.layout.RowScope r18 = (androidx.compose.foundation.layout.RowScope) r18
            r19 = 2
            r22 = 0
            r23 = 1065353216(0x3f800000, float:1.0)
            r24 = 0
            r32 = r3
            r31 = r18
            r35 = r19
            r36 = r22
            r33 = r23
            r34 = r24
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.RowScope.weight$default(r31, r32, r33, r34, r35, r36)
            r22 = r32
            androidx.compose.ui.Modifier r1 = interactionZIndex(r3, r2, r1)
            androidx.compose.material3.ButtonDefaults r3 = androidx.compose.material3.ButtonDefaults.INSTANCE
            float r3 = r3.m1770getMinWidthD9Ej5fM()
            androidx.compose.material3.ButtonDefaults r18 = androidx.compose.material3.ButtonDefaults.INSTANCE
            float r12 = r18.m1769getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m829defaultMinSizeVpY3zN4(r1, r3, r12)
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$5 r3 = androidx.compose.material3.SegmentedButtonKt$SegmentedButton$5.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r18 = r4
            r2 = 0
            r4 = 1
            r12 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r12, r3, r4, r2)
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$6 r2 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$6
            r2.<init>(r7, r0)
            r3 = 54
            r12 = 383378045(0x16d9e27d, float:3.5201175E-25)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r12, r4, r2, r6, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            int r3 = r8 >> 3
            r3 = r3 & 126(0x7e, float:1.77E-43)
            int r4 = r8 >> 6
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            int r12 = r8 << 3
            r4 = r4 & r12
            r3 = r3 | r4
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            int r8 = r8 << 6
            r4 = r4 & r8
            r17 = r3 | r4
            r8 = r18
            r18 = 48
            r19 = 384(0x180, float:5.38E-43)
            r11 = 0
            r12 = 0
            r3 = r29
            r4 = r1
            r20 = r7
            r1 = r8
            r7 = r15
            r15 = r2
            r16 = r6
            r2 = r28
            r6 = r30
            androidx.compose.material3.SurfaceKt.m2537Surfaced85dljk((boolean) r2, (kotlin.jvm.functions.Function0<kotlin.Unit>) r3, (androidx.compose.ui.Modifier) r4, (boolean) r5, (androidx.compose.ui.graphics.Shape) r6, (long) r7, (long) r9, (float) r11, (float) r12, (androidx.compose.foundation.BorderStroke) r13, (androidx.compose.foundation.interaction.MutableInteractionSource) r14, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x02d6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02d6:
            r7 = r1
            r6 = r5
            r8 = r13
            r10 = r20
            r9 = r21
            r5 = r22
        L_0x02df:
            androidx.compose.runtime.ScopeUpdateScope r15 = r16.endRestartGroup()
            if (r15 == 0) goto L_0x02ff
            androidx.compose.material3.SegmentedButtonKt$SegmentedButton$7 r0 = new androidx.compose.material3.SegmentedButtonKt$SegmentedButton$7
            r1 = r27
            r2 = r28
            r3 = r29
            r4 = r30
            r11 = r37
            r12 = r39
            r13 = r40
            r14 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x02ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonKt.SegmentedButton(androidx.compose.material3.SingleChoiceSegmentedButtonRowScope, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.graphics.Shape, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SegmentedButtonColors, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: SingleChoiceSegmentedButtonRow-uFdPcIQ  reason: not valid java name */
    public static final void m2441SingleChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, Function3<? super SingleChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1520863498);
        ComposerKt.sourceInformation(startRestartGroup, "C(SingleChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)269@12565L447:SegmentedButton.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (i5 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m2438getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520863498, i3, -1, "androidx.compose.material3.SingleChoiceSegmentedButtonRow (SegmentedButton.kt:268)");
            }
            Modifier width = IntrinsicKt.width(SizeKt.m830defaultMinSizeVpY3zN4$default(SelectableGroupKt.selectableGroup(modifier), 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3379getContainerHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m623spacedBy0680j_4(Dp.m7111constructorimpl(-f)), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, width);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r5 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1586778660, "C278@12924L58,279@12997L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1334286565, "CC(remember):SegmentedButton.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SingleChoiceSegmentedButtonScopeWrapper(rowScope);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            function3.invoke((SingleChoiceSegmentedButtonScopeWrapper) rememberedValue, startRestartGroup, Integer.valueOf(((i3 >> 3) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        float f2 = f;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SegmentedButtonKt$SingleChoiceSegmentedButtonRow$2(modifier2, f2, function3, i, i2));
        }
    }

    /* renamed from: MultiChoiceSegmentedButtonRow-uFdPcIQ  reason: not valid java name */
    public static final void m2440MultiChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, Function3<? super MultiChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(155922315);
        ComposerKt.sourceInformation(startRestartGroup, "C(MultiChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)307@14058L411:SegmentedButton.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (i5 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m2438getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(155922315, i3, -1, "androidx.compose.material3.MultiChoiceSegmentedButtonRow (SegmentedButton.kt:306)");
            }
            Modifier width = IntrinsicKt.width(SizeKt.m830defaultMinSizeVpY3zN4$default(modifier, 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3379getContainerHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m623spacedBy0680j_4(Dp.m7111constructorimpl(-f)), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, width);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r5 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1297400858, "C315@14382L57,316@14454L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 596041317, "CC(remember):SegmentedButton.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MultiChoiceSegmentedButtonScopeWrapper(rowScope);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            function3.invoke((MultiChoiceSegmentedButtonScopeWrapper) rememberedValue, startRestartGroup, Integer.valueOf(((i3 >> 3) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        float f2 = f;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SegmentedButtonKt$MultiChoiceSegmentedButtonRow$2(modifier2, f2, function3, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void SegmentedButtonContent(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1464121570);
        ComposerKt.sourceInformation(startRestartGroup, "C(SegmentedButtonContent)P(1)325@14600L595:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1464121570, i2, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:324)");
            }
            Alignment center = Alignment.Companion.getCenter();
            Modifier padding = PaddingKt.padding(Modifier.Companion, ButtonDefaults.INSTANCE.getTextButtonContentPadding());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, padding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r4 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r4, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r4.getInserting() || !Intrinsics.areEqual(r4.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r4, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1425737070, "C329@14804L5,330@14847L342,330@14818L371:SegmentedButton.kt#uh7d8r");
            TextKt.ProvideTextStyle(TypographyKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont(), startRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1420592651, true, new SegmentedButtonKt$SegmentedButtonContent$1$1(function2, function22), startRestartGroup, 54), startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SegmentedButtonKt$SegmentedButtonContent$2(function2, function22, i));
        }
    }

    private static final State<Integer> interactionCountAsState(InteractionSource interactionSource, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 281890131, "C(interactionCountAsState)397@17381L33,398@17440L499,398@17419L520:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(281890131, i, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:396)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 408875648, "CC(remember):SegmentedButton.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        boolean z = false;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableIntState mutableIntState = (MutableIntState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 408878002, "CC(remember):SegmentedButton.kt#9igjgp");
        int i2 = i & 14;
        if (((i2 ^ 6) > 4 && composer.changed((Object) interactionSource)) || (i & 6) == 4) {
            z = true;
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (z || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new SegmentedButtonKt$interactionCountAsState$1$1(interactionSource, mutableIntState, (Continuation<? super SegmentedButtonKt$interactionCountAsState$1$1>) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect((Object) interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, composer, i2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableIntState;
    }

    private static final Modifier interactionZIndex(Modifier modifier, boolean z, State<Integer> state) {
        return LayoutModifierKt.layout(modifier, new SegmentedButtonKt$interactionZIndex$1(state, z));
    }
}
