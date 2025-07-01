package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0001\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a!\u00104\u001a\u00020\n2\b\b\u0002\u00105\u001a\u00020(2\b\b\u0002\u00106\u001a\u00020\u001bH\u0007¢\u0006\u0002\u00107\u001a7\u00108\u001a\u00020(2\b\b\u0002\u00109\u001a\u00020:2\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010<\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010=\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "", "sheetState", "Landroidx/compose/material3/SheetState;", "BottomSheetScaffoldLayout-2E65NiM", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;JJLandroidx/compose/runtime/Composer;I)V", "StandardBottomSheet", "state", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-w7I5h1o", "(Landroidx/compose/material3/SheetState;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
public final class BottomSheetScaffoldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v43, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v47, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v55, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x046f  */
    /* JADX WARNING: Removed duplicated region for block: B:284:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012f  */
    /* renamed from: BottomSheetScaffold-sdMYb0k  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1746BottomSheetScaffoldsdMYb0k(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.ui.Modifier r35, androidx.compose.material3.BottomSheetScaffoldState r36, float r37, float r38, androidx.compose.ui.graphics.Shape r39, long r40, long r42, float r44, float r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, boolean r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, long r50, long r52, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, androidx.compose.runtime.Composer r55, int r56, int r57, int r58) {
        /*
            r0 = r54
            r1 = r56
            r2 = r57
            r3 = r58
            r4 = -1523924135(0xffffffffa52ac359, float:-1.4811336E-16)
            r5 = r55
            androidx.compose.runtime.Composer r4 = r5.startRestartGroup(r4)
            java.lang.String r5 = "C(BottomSheetScaffold)P(6,3,4,10:c#ui.unit.Dp,9:c#ui.unit.Dp,12,5:c#ui.graphics.Color,7:c#ui.graphics.Color,14:c#ui.unit.Dp,11:c#ui.unit.Dp,8,13,16,15,0:c#ui.graphics.Color,2:c#ui.graphics.Color)112@5992L34,115@6194L13,116@6262L14,117@6309L36,124@6741L11,125@6788L31,131@6974L52,137@7329L597,132@7051L49,133@7124L50,128@6878L1054:BottomSheetScaffold.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r3 & 1
            if (r5 == 0) goto L_0x0020
            r5 = r1 | 6
            r8 = r5
            r5 = r34
            goto L_0x0034
        L_0x0020:
            r5 = r1 & 6
            if (r5 != 0) goto L_0x0031
            r5 = r34
            boolean r8 = r4.changedInstance(r5)
            if (r8 == 0) goto L_0x002e
            r8 = 4
            goto L_0x002f
        L_0x002e:
            r8 = 2
        L_0x002f:
            r8 = r8 | r1
            goto L_0x0034
        L_0x0031:
            r5 = r34
            r8 = r1
        L_0x0034:
            r9 = r3 & 2
            if (r9 == 0) goto L_0x003b
            r8 = r8 | 48
            goto L_0x004e
        L_0x003b:
            r12 = r1 & 48
            if (r12 != 0) goto L_0x004e
            r12 = r35
            boolean r13 = r4.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x004a
            r13 = 32
            goto L_0x004c
        L_0x004a:
            r13 = 16
        L_0x004c:
            r8 = r8 | r13
            goto L_0x0050
        L_0x004e:
            r12 = r35
        L_0x0050:
            r13 = r1 & 384(0x180, float:5.38E-43)
            if (r13 != 0) goto L_0x006a
            r13 = r3 & 4
            if (r13 != 0) goto L_0x0063
            r13 = r36
            boolean r16 = r4.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x0065
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r13 = r36
        L_0x0065:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r8 = r8 | r16
            goto L_0x006c
        L_0x006a:
            r13 = r36
        L_0x006c:
            r16 = r3 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0077
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x008b
        L_0x0077:
            r6 = r1 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x008b
            r6 = r37
            boolean r19 = r4.changed((float) r6)
            if (r19 == 0) goto L_0x0086
            r19 = r17
            goto L_0x0088
        L_0x0086:
            r19 = r18
        L_0x0088:
            r8 = r8 | r19
            goto L_0x008d
        L_0x008b:
            r6 = r37
        L_0x008d:
            r19 = r3 & 16
            r20 = 8192(0x2000, float:1.14794E-41)
            r21 = 16384(0x4000, float:2.2959E-41)
            if (r19 == 0) goto L_0x0098
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ac
        L_0x0098:
            r7 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x00ac
            r7 = r38
            boolean r23 = r4.changed((float) r7)
            if (r23 == 0) goto L_0x00a7
            r23 = r21
            goto L_0x00a9
        L_0x00a7:
            r23 = r20
        L_0x00a9:
            r8 = r8 | r23
            goto L_0x00ae
        L_0x00ac:
            r7 = r38
        L_0x00ae:
            r23 = 196608(0x30000, float:2.75506E-40)
            r23 = r1 & r23
            r24 = 65536(0x10000, float:9.18355E-41)
            if (r23 != 0) goto L_0x00ca
            r23 = r3 & 32
            r10 = r39
            if (r23 != 0) goto L_0x00c5
            boolean r25 = r4.changed((java.lang.Object) r10)
            if (r25 == 0) goto L_0x00c5
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c7
        L_0x00c5:
            r25 = r24
        L_0x00c7:
            r8 = r8 | r25
            goto L_0x00cc
        L_0x00ca:
            r10 = r39
        L_0x00cc:
            r25 = 1572864(0x180000, float:2.204052E-39)
            r26 = r1 & r25
            if (r26 != 0) goto L_0x00e6
            r26 = r3 & 64
            r11 = r40
            if (r26 != 0) goto L_0x00e1
            boolean r27 = r4.changed((long) r11)
            if (r27 == 0) goto L_0x00e1
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e3
        L_0x00e1:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00e3:
            r8 = r8 | r27
            goto L_0x00e8
        L_0x00e6:
            r11 = r40
        L_0x00e8:
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            r27 = r1 & r27
            if (r27 != 0) goto L_0x0104
            r15 = r3 & 128(0x80, float:1.794E-43)
            if (r15 != 0) goto L_0x00fd
            r14 = r42
            boolean r28 = r4.changed((long) r14)
            if (r28 == 0) goto L_0x00ff
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0101
        L_0x00fd:
            r14 = r42
        L_0x00ff:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x0101:
            r8 = r8 | r28
            goto L_0x0106
        L_0x0104:
            r14 = r42
        L_0x0106:
            r1 = r3 & 256(0x100, float:3.59E-43)
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x010f
            r8 = r8 | r28
            goto L_0x0125
        L_0x010f:
            r28 = r56 & r28
            if (r28 != 0) goto L_0x0125
            r28 = r1
            r1 = r44
            boolean r29 = r4.changed((float) r1)
            if (r29 == 0) goto L_0x0120
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0122
        L_0x0120:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0122:
            r8 = r8 | r29
            goto L_0x0129
        L_0x0125:
            r28 = r1
            r1 = r44
        L_0x0129:
            r1 = r3 & 512(0x200, float:7.175E-43)
            r29 = 805306368(0x30000000, float:4.656613E-10)
            if (r1 == 0) goto L_0x0132
            r8 = r8 | r29
            goto L_0x0148
        L_0x0132:
            r29 = r56 & r29
            if (r29 != 0) goto L_0x0148
            r29 = r1
            r1 = r45
            boolean r30 = r4.changed((float) r1)
            if (r30 == 0) goto L_0x0143
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0145
        L_0x0143:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0145:
            r8 = r8 | r30
            goto L_0x014c
        L_0x0148:
            r29 = r1
            r1 = r45
        L_0x014c:
            r1 = r3 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0157
            r22 = r2 | 6
            r30 = r1
            r1 = r46
            goto L_0x0173
        L_0x0157:
            r30 = r2 & 6
            if (r30 != 0) goto L_0x016d
            r30 = r1
            r1 = r46
            boolean r31 = r4.changedInstance(r1)
            if (r31 == 0) goto L_0x0168
            r22 = 4
            goto L_0x016a
        L_0x0168:
            r22 = 2
        L_0x016a:
            r22 = r2 | r22
            goto L_0x0173
        L_0x016d:
            r30 = r1
            r1 = r46
            r22 = r2
        L_0x0173:
            r1 = r3 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x017c
            r22 = r22 | 48
            r31 = r1
            goto L_0x0196
        L_0x017c:
            r31 = r2 & 48
            if (r31 != 0) goto L_0x0192
            r31 = r1
            r1 = r47
            boolean r32 = r4.changed((boolean) r1)
            if (r32 == 0) goto L_0x018d
            r23 = 32
            goto L_0x018f
        L_0x018d:
            r23 = 16
        L_0x018f:
            r22 = r22 | r23
            goto L_0x0196
        L_0x0192:
            r31 = r1
            r1 = r47
        L_0x0196:
            r1 = r22
            r5 = r3 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x019f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x01b9
        L_0x019f:
            r22 = r1
            r1 = r2 & 384(0x180, float:5.38E-43)
            if (r1 != 0) goto L_0x01b5
            r1 = r48
            boolean r23 = r4.changedInstance(r1)
            if (r23 == 0) goto L_0x01b0
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01b2
        L_0x01b0:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01b2:
            r22 = r22 | r27
            goto L_0x01b7
        L_0x01b5:
            r1 = r48
        L_0x01b7:
            r1 = r22
        L_0x01b9:
            r22 = r5
            r5 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01c4
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r23 = r1
            goto L_0x01da
        L_0x01c4:
            r23 = r1
            r1 = r2 & 3072(0xc00, float:4.305E-42)
            if (r1 != 0) goto L_0x01da
            r1 = r49
            boolean r26 = r4.changedInstance(r1)
            if (r26 == 0) goto L_0x01d3
            goto L_0x01d5
        L_0x01d3:
            r17 = r18
        L_0x01d5:
            r17 = r23 | r17
            r23 = r17
            goto L_0x01dc
        L_0x01da:
            r1 = r49
        L_0x01dc:
            r1 = r2 & 24576(0x6000, float:3.4438E-41)
            if (r1 != 0) goto L_0x01f4
            r1 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r1 != 0) goto L_0x01ef
            r1 = r50
            boolean r17 = r4.changed((long) r1)
            if (r17 == 0) goto L_0x01f1
            r20 = r21
            goto L_0x01f1
        L_0x01ef:
            r1 = r50
        L_0x01f1:
            r23 = r23 | r20
            goto L_0x01f6
        L_0x01f4:
            r1 = r50
        L_0x01f6:
            r17 = 196608(0x30000, float:2.75506E-40)
            r17 = r57 & r17
            r18 = 32768(0x8000, float:4.5918E-41)
            if (r17 != 0) goto L_0x0213
            r17 = r3 & r18
            r1 = r52
            if (r17 != 0) goto L_0x020e
            boolean r17 = r4.changed((long) r1)
            if (r17 == 0) goto L_0x020e
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0210
        L_0x020e:
            r17 = r24
        L_0x0210:
            r23 = r23 | r17
            goto L_0x0215
        L_0x0213:
            r1 = r52
        L_0x0215:
            r17 = r3 & r24
            if (r17 == 0) goto L_0x021c
            r23 = r23 | r25
            goto L_0x022d
        L_0x021c:
            r17 = r57 & r25
            if (r17 != 0) goto L_0x022d
            boolean r17 = r4.changedInstance(r0)
            if (r17 == 0) goto L_0x0229
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x022b
        L_0x0229:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x022b:
            r23 = r23 | r17
        L_0x022d:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r8 & r17
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x0266
            r1 = 599187(0x92493, float:8.3964E-40)
            r1 = r23 & r1
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r2) goto L_0x0266
            boolean r1 = r4.getSkipping()
            if (r1 != 0) goto L_0x0248
            goto L_0x0266
        L_0x0248:
            r4.skipToGroupEnd()
            r2 = r35
            r16 = r49
            r17 = r50
            r19 = r52
            r0 = r4
            r4 = r6
            r5 = r7
            r6 = r10
            r7 = r11
            r3 = r13
            r9 = r14
            r11 = r44
            r12 = r45
            r13 = r46
            r14 = r47
            r15 = r48
            goto L_0x0469
        L_0x0266:
            r4.startDefaults()
            r1 = r56 & 1
            r55 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r1 == 0) goto L_0x02bd
            boolean r1 = r4.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0277
            goto L_0x02bd
        L_0x0277:
            r4.skipToGroupEnd()
            r1 = r3 & 4
            if (r1 == 0) goto L_0x0280
            r8 = r8 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0280:
            r1 = r3 & 32
            if (r1 == 0) goto L_0x0286
            r8 = r8 & r55
        L_0x0286:
            r1 = r3 & 64
            if (r1 == 0) goto L_0x028e
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r1
        L_0x028e:
            r1 = r3 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0296
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r8 = r8 & r1
        L_0x0296:
            r1 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x029f
            r1 = -57345(0xffffffffffff1fff, float:NaN)
            r23 = r23 & r1
        L_0x029f:
            r1 = r3 & r18
            if (r1 == 0) goto L_0x02a5
            r23 = r23 & r55
        L_0x02a5:
            r22 = r35
            r16 = r45
            r19 = r46
            r20 = r47
            r21 = r48
            r5 = r49
            r1 = r50
            r24 = r52
            r9 = r13
            r13 = r14
            r3 = r23
            r15 = r44
            goto L_0x037a
        L_0x02bd:
            if (r9 == 0) goto L_0x02c4
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x02c6
        L_0x02c4:
            r1 = r35
        L_0x02c6:
            r9 = r3 & 4
            r2 = 0
            if (r9 == 0) goto L_0x02d4
            r9 = 0
            r13 = 3
            androidx.compose.material3.BottomSheetScaffoldState r9 = rememberBottomSheetScaffoldState(r2, r2, r4, r9, r13)
            r8 = r8 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x02d5
        L_0x02d4:
            r9 = r13
        L_0x02d5:
            if (r16 == 0) goto L_0x02dd
            androidx.compose.material3.BottomSheetDefaults r6 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r6 = r6.m1745getSheetPeekHeightD9Ej5fM()
        L_0x02dd:
            if (r19 == 0) goto L_0x02e5
            androidx.compose.material3.BottomSheetDefaults r7 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r7 = r7.m1744getSheetMaxWidthD9Ej5fM()
        L_0x02e5:
            r13 = r3 & 32
            r2 = 6
            if (r13 == 0) goto L_0x02f2
            androidx.compose.material3.BottomSheetDefaults r10 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r10 = r10.getExpandedShape(r4, r2)
            r8 = r8 & r55
        L_0x02f2:
            r13 = r3 & 64
            if (r13 == 0) goto L_0x0300
            androidx.compose.material3.BottomSheetDefaults r11 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            long r11 = r11.getContainerColor(r4, r2)
            r13 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r13
        L_0x0300:
            r13 = r3 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x0311
            int r13 = r8 >> 18
            r13 = r13 & 14
            long r13 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r11, r4, r13)
            r15 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r8 = r8 & r15
            goto L_0x0312
        L_0x0311:
            r13 = r14
        L_0x0312:
            if (r28 == 0) goto L_0x031b
            r15 = 0
            float r15 = (float) r15
            float r15 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r15)
            goto L_0x031d
        L_0x031b:
            r15 = r44
        L_0x031d:
            if (r29 == 0) goto L_0x0326
            androidx.compose.material3.BottomSheetDefaults r16 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r16 = r16.m1743getElevationD9Ej5fM()
            goto L_0x0328
        L_0x0326:
            r16 = r45
        L_0x0328:
            if (r30 == 0) goto L_0x0331
            androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt r19 = androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r19 = r19.m1915getLambda1$material3_release()
            goto L_0x0333
        L_0x0331:
            r19 = r46
        L_0x0333:
            if (r31 == 0) goto L_0x0338
            r20 = 1
            goto L_0x033a
        L_0x0338:
            r20 = r47
        L_0x033a:
            if (r22 == 0) goto L_0x033f
            r21 = 0
            goto L_0x0341
        L_0x033f:
            r21 = r48
        L_0x0341:
            if (r5 == 0) goto L_0x034a
            androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt r5 = androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r5 = r5.m1916getLambda2$material3_release()
            goto L_0x034c
        L_0x034a:
            r5 = r49
        L_0x034c:
            r2 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0363
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            r22 = r1
            r1 = 6
            androidx.compose.material3.ColorScheme r1 = r2.getColorScheme(r4, r1)
            long r1 = r1.m1872getSurface0d7_KjU()
            r24 = -57345(0xffffffffffff1fff, float:NaN)
            r23 = r23 & r24
            goto L_0x0367
        L_0x0363:
            r22 = r1
            r1 = r50
        L_0x0367:
            r18 = r3 & r18
            if (r18 == 0) goto L_0x0376
            int r18 = r23 >> 12
            r3 = r18 & 14
            long r24 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r1, r4, r3)
            r23 = r23 & r55
            goto L_0x0378
        L_0x0376:
            r24 = r52
        L_0x0378:
            r3 = r23
        L_0x037a:
            r4.endDefaults()
            boolean r18 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r49 = r1
            if (r18 == 0) goto L_0x038d
            r1 = -1523924135(0xffffffffa52ac359, float:-1.4811336E-16)
            java.lang.String r2 = "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:127)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r8, r3, r2)
        L_0x038d:
            androidx.compose.material3.SheetState r1 = r9.getBottomSheetState()
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1 r2 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
            r2.<init>(r0, r6)
            r0 = 54
            r51 = r1
            r1 = -459880832(0xffffffffe496c680, float:-2.225052E22)
            r18 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r1, r3, r2, r4, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2 r1 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
            r48 = r34
            r35 = r1
            r37 = r6
            r38 = r7
            r36 = r9
            r40 = r10
            r41 = r11
            r43 = r13
            r45 = r15
            r46 = r16
            r47 = r19
            r39 = r20
            r35.<init>(r36, r37, r38, r39, r40, r41, r43, r45, r46, r47, r48)
            r2 = 54
            r37 = r0
            r0 = 1961872927(0x74efce1f, float:1.5199458E32)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r3, r1, r4, r2)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3 r1 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3
            r1.<init>(r5, r9)
            r38 = r0
            r0 = 88659390(0x548d5be, float:9.443213E-36)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r3, r1, r4, r2)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = -1349215175(0xffffffffaf949c39, float:-2.7032046E-10)
            java.lang.String r2 = "CC(remember):BottomSheetScaffold.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r2)
            r1 = r8 & 896(0x380, float:1.256E-42)
            r1 = r1 ^ 384(0x180, float:5.38E-43)
            r2 = 256(0x100, float:3.59E-43)
            if (r1 <= r2) goto L_0x03f6
            boolean r1 = r4.changed((java.lang.Object) r9)
            if (r1 != 0) goto L_0x03fa
        L_0x03f6:
            r1 = r8 & 384(0x180, float:5.38E-43)
            if (r1 != r2) goto L_0x03fc
        L_0x03fa:
            r2 = r3
            goto L_0x03fd
        L_0x03fc:
            r2 = 0
        L_0x03fd:
            java.lang.Object r1 = r4.rememberedValue()
            if (r2 != 0) goto L_0x040b
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0415
        L_0x040b:
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$4$1 r1 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$4$1
            r1.<init>(r9)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r4.updateRememberedValue(r1)
        L_0x0415:
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            int r2 = r8 >> 3
            r2 = r2 & 14
            r2 = r2 | 28032(0x6d80, float:3.9281E-41)
            int r3 = r18 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            int r3 = r18 << 9
            r8 = 29360128(0x1c00000, float:7.052966E-38)
            r8 = r8 & r3
            r2 = r2 | r8
            r8 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r8
            r2 = r2 | r3
            r42 = r49
            r41 = r51
            r39 = r0
            r40 = r1
            r47 = r2
            r46 = r4
            r36 = r21
            r35 = r22
            r44 = r24
            m1747BottomSheetScaffoldLayout2E65NiM(r35, r36, r37, r38, r39, r40, r41, r42, r44, r46, r47)
            r1 = r42
            r0 = r46
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0451
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0451:
            r3 = r16
            r16 = r5
            r5 = r7
            r7 = r11
            r12 = r3
            r17 = r1
            r4 = r6
            r3 = r9
            r6 = r10
            r9 = r13
            r11 = r15
            r13 = r19
            r14 = r20
            r15 = r21
            r2 = r22
            r19 = r24
        L_0x0469:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x0488
            r1 = r0
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$5 r0 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$5
            r21 = r54
            r22 = r56
            r23 = r57
            r24 = r58
            r33 = r1
            r1 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14, r15, r16, r17, r19, r21, r22, r23, r24)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r33
            r1.updateScope(r0)
        L_0x0488:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt.m1746BottomSheetScaffoldsdMYb0k(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material3.BottomSheetScaffoldState, float, float, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState sheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1474606134, "C(rememberBottomSheetScaffoldState)178@8695L34,179@8774L32,181@8848L196:BottomSheetScaffold.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            sheetState = rememberStandardBottomSheetState((SheetValue) null, (Function1<? super SheetValue, Boolean>) null, false, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -787714761, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer2.updateRememberedValue(rememberedValue);
            }
            snackbarHostState = (SnackbarHostState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, i, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:180)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -787712229, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean z = false;
        boolean z2 = (((i & 14) ^ 6) > 4 && composer2.changed((Object) sheetState)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) > 32 && composer2.changed((Object) snackbarHostState)) || (i & 48) == 32) {
            z = true;
        }
        boolean z3 = z2 | z;
        Object rememberedValue2 = composer2.rememberedValue();
        if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new BottomSheetScaffoldState(sheetState, snackbarHostState);
            composer2.updateRememberedValue(rememberedValue2);
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return bottomSheetScaffoldState;
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue sheetValue, Function1<? super SheetValue, Boolean> function1, boolean z, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 678511581, "C(rememberStandardBottomSheetState)P(1)204@9680L154:BottomSheetScaffold.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            sheetValue = SheetValue.PartiallyExpanded;
        }
        SheetValue sheetValue2 = sheetValue;
        if ((i2 & 2) != 0) {
            function1 = BottomSheetScaffoldKt$rememberStandardBottomSheetState$1.INSTANCE;
        }
        Function1<? super SheetValue, Boolean> function12 = function1;
        if ((i2 & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, i, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:204)");
        }
        Composer composer2 = composer;
        SheetState rememberSheetState = SheetDefaultsKt.rememberSheetState(false, function12, sheetValue2, z2, composer2, (i & 112) | ((i << 6) & 896) | ((i << 3) & 7168), 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return rememberSheetState;
    }

    /* access modifiers changed from: private */
    /* renamed from: StandardBottomSheet-w7I5h1o  reason: not valid java name */
    public static final void m1748StandardBottomSheetw7I5h1o(SheetState sheetState, float f, float f2, boolean z, Shape shape, long j, long j2, float f3, float f4, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        int i3;
        int i4;
        Composer composer2;
        CoroutineScope coroutineScope;
        int i5;
        Modifier modifier;
        Object obj;
        SheetState sheetState2 = sheetState;
        float f5 = f;
        float f6 = f2;
        boolean z2 = z;
        int i6 = i;
        Composer startRestartGroup = composer.startRestartGroup(721467526);
        ComposerKt.sourceInformation(startRestartGroup, "C(StandardBottomSheet)P(9,4:c#ui.unit.Dp,7:c#ui.unit.Dp,8,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,10:c#ui.unit.Dp,5:c#ui.unit.Dp,3)225@10249L24,*227@10358L7,248@11164L1938,294@13493L2297,242@10889L4901:BottomSheetScaffold.kt#uh7d8r");
        if ((i6 & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) sheetState2) ? 4 : 2) | i6;
        } else {
            i3 = i6;
        }
        if ((i6 & 48) == 0) {
            i3 |= startRestartGroup.changed(f5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i3 |= startRestartGroup.changed(f6) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i3 |= startRestartGroup.changed((Object) shape) ? 16384 : 8192;
        } else {
            Shape shape2 = shape;
        }
        if ((196608 & i6) == 0) {
            i3 |= startRestartGroup.changed(j) ? 131072 : 65536;
        } else {
            long j3 = j;
        }
        if ((1572864 & i6) == 0) {
            i3 |= startRestartGroup.changed(j2) ? 1048576 : 524288;
        } else {
            long j4 = j2;
        }
        if ((i6 & 12582912) == 0) {
            i3 |= startRestartGroup.changed(f3) ? 8388608 : 4194304;
        } else {
            float f7 = f3;
        }
        float f8 = f4;
        if ((i6 & 100663296) == 0) {
            i3 |= startRestartGroup.changed(f8) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i6) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        }
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(function32) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i3 & 306783379) == 306783378 && (i4 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(721467526, i3, i4, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:224)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Orientation orientation = Orientation.Vertical;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float r0 = ((Density) consume).m7091toPx0680j_4(f5);
            startRestartGroup.startReplaceGroup(-1831611516);
            ComposerKt.sourceInformation(startRestartGroup, "231@10496L326");
            if (z2) {
                Modifier modifier2 = Modifier.Companion;
                AnchoredDraggableState<SheetValue> anchoredDraggableState$material3_release = sheetState2.getAnchoredDraggableState$material3_release();
                i5 = i3;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1831609222, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                boolean changed = startRestartGroup.changed((Object) anchoredDraggableState$material3_release);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState2, orientation, new BottomSheetScaffoldKt$StandardBottomSheet$nestedScroll$1$1(coroutineScope2, sheetState2));
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                coroutineScope = coroutineScope2;
                obj = null;
                modifier = NestedScrollModifierKt.nestedScroll$default(modifier2, (NestedScrollConnection) rememberedValue2, (NestedScrollDispatcher) null, 2, (Object) null);
            } else {
                coroutineScope = coroutineScope2;
                i5 = i3;
                obj = null;
                modifier = Modifier.Companion;
            }
            startRestartGroup.endReplaceGroup();
            Modifier then = SizeKt.m836requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m852widthInVpY3zN4$default(Modifier.Companion, 0.0f, f6, 1, obj), 0.0f, 1, obj), f5, 0.0f, 2, obj).then(modifier);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3_release2 = sheetState2.getAnchoredDraggableState$material3_release();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1831586234, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean changed2 = ((i5 & 14) == 4) | startRestartGroup.changed(r0);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new BottomSheetScaffoldKt$StandardBottomSheet$1$1(sheetState2, r0);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Composer composer3 = startRestartGroup;
            int i7 = i5 >> 9;
            composer2 = composer3;
            SurfaceKt.m2536SurfaceT9BRK9s(AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(then, anchoredDraggableState$material3_release2, orientation, (Function2) rememberedValue3), sheetState2.getAnchoredDraggableState$material3_release(), orientation, z, false, (MutableInteractionSource) null, 24, (Object) null), shape, j, j2, f3, f4, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(390720907, true, new BottomSheetScaffoldKt$StandardBottomSheet$2(function2, sheetState2, z, coroutineScope, function3), composer3, 54), composer2, (i7 & 112) | 12582912 | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (i7 & 458752), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomSheetScaffoldKt$StandardBottomSheet$3(sheetState, f5, f6, z, shape, j, j2, f3, f4, function2, function3, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-2E65NiM  reason: not valid java name */
    public static final void m1747BottomSheetScaffoldLayout2E65NiM(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function0<Float> function0, SheetState sheetState, long j, long j2, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        Function2<? super Composer, ? super Integer, Unit> function27 = function24;
        Function0<Float> function02 = function0;
        SheetState sheetState2 = sheetState;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1651214892);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheetScaffoldLayout)P(4,8!2,7,5,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color)359@16300L255,370@16635L1950,355@16183L2402:BottomSheetScaffold.kt#uh7d8r");
        Modifier modifier2 = modifier;
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function28 = function22;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function26) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function27) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) sheetState2) ? 1048576 : 524288;
        }
        long j3 = j;
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 8388608 : 4194304;
        }
        long j4 = j2;
        if ((100663296 & i3) == 0) {
            i2 |= startRestartGroup.changed(j4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i2 & 38347923) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651214892, i2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:354)");
            }
            Function2[] function2Arr = new Function2[4];
            function2Arr[0] = function25 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1917getLambda3$material3_release() : function25;
            boolean z = true;
            function2Arr[1] = ComposableLambdaKt.rememberComposableLambda(398963586, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1(modifier, j3, j2, function22), startRestartGroup, 54);
            function2Arr[2] = function26;
            function2Arr[3] = function27;
            List listOf = CollectionsKt.listOf(function2Arr);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221133327, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z2 = (3670016 & i2) == 1048576;
            if ((i2 & 458752) != 131072) {
                z = false;
            }
            boolean z3 = z2 | z;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1(sheetState2, function02);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
            Modifier modifier3 = Modifier.Companion;
            Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -290761997, "CC(remember):Layout.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) multiContentMeasurePolicy);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
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
            Composer r13 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r13, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r13, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r13.getInserting() || !Intrinsics.areEqual(r13.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r13.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r13, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            combineAsVirtualLayouts.invoke(startRestartGroup, 0);
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
            endRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$3(modifier, function25, function22, function26, function27, function02, sheetState2, j, j2, i3));
        }
    }
}
