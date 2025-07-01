package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001at\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001al\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aQ\u0010\u001f\u001a\u00020\t2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\b\u00192\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#2\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010$\u001at\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001at\u0010*\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001c\u001al\u0010*\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010\u001e\u001a`\u0010-\u001a\u00020\t2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\b\u00192\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010.\u001a\u00020\u00112\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a\u0001\u00101\u001a\u00020\t2\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\b\u00192\u0006\u00103\u001a\u00020#2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\t0!2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010!¢\u0006\u0002\b\u00192\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010!¢\u0006\u0002\b\u00192\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u0002092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;H\u0007¢\u0006\u0002\u0010<\u001al\u0010=\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010\u001e\u001a=\u0010?\u001a\u00020\t2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\b\u00192\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010@\u001a>\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020#2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0!2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00020!2\u0006\u0010E\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a \u0010H\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u0002H\u0002\u001a+\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020N2\u0014\b\u0002\u0010O\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020#0\u0017H\u0007¢\u0006\u0002\u0010P\u001a\u0014\u0010Q\u001a\u00020\u0002*\u00020R2\u0006\u0010&\u001a\u00020'H\u0002\u001a\u0014\u0010S\u001a\u00020\u0002*\u00020R2\u0006\u0010&\u001a\u00020'H\u0002\u001a\u001c\u0010T\u001a\u00020\r*\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010U\u001a\u00020#H\u0002\u001a\u001c\u0010V\u001a\u00020\r*\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010U\u001a\u00020#H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002XD¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006W²\u0006\n\u0010X\u001a\u00020#X\u0002²\u0006\n\u0010Y\u001a\u00020\u0002X\u0002²\u0006\n\u0010X\u001a\u00020#X\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "MinimumDrawerWidth", "DismissibleDrawerSheet", "", "drawerState", "Landroidx/compose/material3/DrawerState;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerTonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DismissibleDrawerSheet-Snr_uVM", "(Landroidx/compose/material3/DrawerState;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "drawerContent", "Lkotlin/Function0;", "gesturesEnabled", "", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DrawerSheet", "drawerPredictiveBackState", "Landroidx/compose/material3/DrawerPredictiveBackState;", "DrawerSheet-7zSek6w", "(Landroidx/compose/material3/DrawerPredictiveBackState;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "ModalDrawerSheet-Snr_uVM", "ModalDrawerSheet-afqeVBk", "ModalNavigationDrawer", "scrimColor", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberDrawerState", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "calculatePredictiveBackScaleY", "predictiveBackDrawerChild", "isRtl", "predictiveBackDrawerContainer", "material3_release", "anchorsInitialized", "minValue"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
public final class NavigationDrawerKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float DrawerPositionalThreshold = 0.5f;
    /* access modifiers changed from: private */
    public static final float DrawerVelocityThreshold = Dp.m7111constructorimpl((float) 400);
    /* access modifiers changed from: private */
    public static final float MinimumDrawerWidth = Dp.m7111constructorimpl((float) 240);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.material3.DrawerState, androidx.compose.material3.DrawerValue>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.DrawerState rememberDrawerState(androidx.compose.material3.DrawerValue r7, kotlin.jvm.functions.Function1<? super androidx.compose.material3.DrawerValue, java.lang.Boolean> r8, androidx.compose.runtime.Composer r9, int r10, int r11) {
        /*
            java.lang.String r0 = "C(rememberDrawerState)P(1)286@11488L61,286@11424L125:NavigationDrawer.kt#uh7d8r"
            r1 = 2098699222(0x7d179bd6, float:1.2595161E37)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r0)
            r11 = r11 & 2
            if (r11 == 0) goto L_0x0010
            androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$1 r8 = androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$1.INSTANCE
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
        L_0x0010:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x001c
            r11 = -1
            java.lang.String r0 = "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:285)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r10, r11, r0)
        L_0x001c:
            r11 = 0
            java.lang.Object[] r0 = new java.lang.Object[r11]
            androidx.compose.material3.DrawerState$Companion r1 = androidx.compose.material3.DrawerState.Companion
            androidx.compose.runtime.saveable.Saver r1 = r1.Saver(r8)
            r2 = -666801427(0xffffffffd8416aed, float:-8.5065995E14)
            java.lang.String r3 = "CC(remember):NavigationDrawer.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r3)
            r2 = r10 & 14
            r2 = r2 ^ 6
            r3 = 1
            r4 = 4
            if (r2 <= r4) goto L_0x003b
            boolean r2 = r9.changed((java.lang.Object) r7)
            if (r2 != 0) goto L_0x003f
        L_0x003b:
            r2 = r10 & 6
            if (r2 != r4) goto L_0x0041
        L_0x003f:
            r2 = r3
            goto L_0x0042
        L_0x0041:
            r2 = r11
        L_0x0042:
            r4 = r10 & 112(0x70, float:1.57E-43)
            r4 = r4 ^ 48
            r5 = 32
            if (r4 <= r5) goto L_0x0050
            boolean r4 = r9.changed((java.lang.Object) r8)
            if (r4 != 0) goto L_0x0054
        L_0x0050:
            r10 = r10 & 48
            if (r10 != r5) goto L_0x0055
        L_0x0054:
            r11 = r3
        L_0x0055:
            r10 = r2 | r11
            java.lang.Object r11 = r9.rememberedValue()
            if (r10 != 0) goto L_0x0065
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x0070
        L_0x0065:
            androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$2$1 r10 = new androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$2$1
            r10.<init>(r7, r8)
            r11 = r10
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r9.updateRememberedValue(r11)
        L_0x0070:
            r3 = r11
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r5 = 0
            r6 = 4
            r2 = 0
            r4 = r9
            java.lang.Object r7 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.material3.DrawerState r7 = (androidx.compose.material3.DrawerState) r7
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0089
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0089:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.rememberDrawerState(androidx.compose.material3.DrawerValue, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.DrawerState");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: androidx.compose.runtime.MutableFloatState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03ec  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03ff  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x043c  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0491  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0493  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x04cd  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0564  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0570  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0574  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x05ec  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x05fb  */
    /* JADX WARNING: Removed duplicated region for block: B:238:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x014e  */
    /* renamed from: ModalNavigationDrawer-FHprtrg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2262ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, androidx.compose.material3.DrawerState r30, boolean r31, long r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r1 = r28
            r7 = r34
            r8 = r36
            r0 = -1169303680(0xffffffffba4dd780, float:-7.8522414E-4)
            r2 = r35
            androidx.compose.runtime.Composer r14 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(ModalNavigationDrawer)P(1,4,2,3,5:c#ui.graphics.Color)316@12708L39,318@12825L10,321@12893L24,322@12943L33,323@13008L7,324@13046L34,325@13101L45,328@13185L33,328@13174L44,330@13257L7,331@13292L3053:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            r2 = r37 & 1
            r3 = 2
            if (r2 == 0) goto L_0x001c
            r2 = r8 | 6
            goto L_0x002c
        L_0x001c:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002b
            boolean r2 = r14.changedInstance(r1)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = r3
        L_0x0029:
            r2 = r2 | r8
            goto L_0x002c
        L_0x002b:
            r2 = r8
        L_0x002c:
            r4 = r37 & 2
            if (r4 == 0) goto L_0x0033
            r2 = r2 | 48
            goto L_0x0046
        L_0x0033:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x0046
            r5 = r29
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0042
            r6 = 32
            goto L_0x0044
        L_0x0042:
            r6 = 16
        L_0x0044:
            r2 = r2 | r6
            goto L_0x0048
        L_0x0046:
            r5 = r29
        L_0x0048:
            r6 = r8 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0061
            r6 = r37 & 4
            if (r6 != 0) goto L_0x005b
            r6 = r30
            boolean r10 = r14.changed((java.lang.Object) r6)
            if (r10 == 0) goto L_0x005d
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005b:
            r6 = r30
        L_0x005d:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r10
            goto L_0x0063
        L_0x0061:
            r6 = r30
        L_0x0063:
            r10 = r37 & 8
            if (r10 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r12 = r8 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007d
            r12 = r31
            boolean r13 = r14.changed((boolean) r12)
            if (r13 == 0) goto L_0x0079
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r13
            goto L_0x007f
        L_0x007d:
            r12 = r31
        L_0x007f:
            r13 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0096
            r13 = r37 & 16
            r11 = r32
            if (r13 != 0) goto L_0x0092
            boolean r13 = r14.changed((long) r11)
            if (r13 == 0) goto L_0x0092
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r2 = r2 | r13
            goto L_0x0098
        L_0x0096:
            r11 = r32
        L_0x0098:
            r13 = r37 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a0
            r2 = r2 | r15
            goto L_0x00b0
        L_0x00a0:
            r13 = r8 & r15
            if (r13 != 0) goto L_0x00b0
            boolean r13 = r14.changedInstance(r7)
            if (r13 == 0) goto L_0x00ad
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r2 = r2 | r13
        L_0x00b0:
            r13 = 74899(0x12493, float:1.04956E-40)
            r13 = r13 & r2
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r13 != r15) goto L_0x00ca
            boolean r13 = r14.getSkipping()
            if (r13 != 0) goto L_0x00c0
            goto L_0x00ca
        L_0x00c0:
            r14.skipToGroupEnd()
            r4 = r31
            r2 = r5
            r3 = r6
            r5 = r11
            goto L_0x05f5
        L_0x00ca:
            r14.startDefaults()
            r13 = r8 & 1
            r15 = 0
            r9 = 6
            if (r13 == 0) goto L_0x00f0
            boolean r13 = r14.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00da
            goto L_0x00f0
        L_0x00da:
            r14.skipToGroupEnd()
            r4 = r37 & 4
            if (r4 == 0) goto L_0x00e3
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00e3:
            r4 = r37 & 16
            if (r4 == 0) goto L_0x00eb
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r4
        L_0x00eb:
            r21 = r31
            r4 = r5
        L_0x00ee:
            r12 = r11
            goto L_0x0120
        L_0x00f0:
            if (r4 == 0) goto L_0x00f7
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00f8
        L_0x00f7:
            r4 = r5
        L_0x00f8:
            r5 = r37 & 4
            if (r5 == 0) goto L_0x0105
            androidx.compose.material3.DrawerValue r5 = androidx.compose.material3.DrawerValue.Closed
            androidx.compose.material3.DrawerState r5 = rememberDrawerState(r5, r15, r14, r9, r3)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r5
        L_0x0105:
            if (r10 == 0) goto L_0x0109
            r5 = 1
            goto L_0x010b
        L_0x0109:
            r5 = r31
        L_0x010b:
            r10 = r37 & 16
            if (r10 == 0) goto L_0x011d
            androidx.compose.material3.DrawerDefaults r10 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r10 = r10.getScrimColor(r14, r9)
            r12 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r12
            r21 = r5
            r12 = r10
            goto L_0x0120
        L_0x011d:
            r21 = r5
            goto L_0x00ee
        L_0x0120:
            r14.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0132
            r5 = -1
            java.lang.String r10 = "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:320)"
            r11 = -1169303680(0xffffffffba4dd780, float:-7.8522414E-4)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r2, r5, r10)
        L_0x0132:
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r10 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r10)
            r5 = -954363344(0xffffffffc71d9230, float:-40338.188)
            java.lang.String r10 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r10)
            java.lang.Object r5 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r5 != r10) goto L_0x015f
            kotlin.coroutines.EmptyCoroutineContext r5 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            kotlinx.coroutines.CoroutineScope r5 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r5, r14)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r10 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r10.<init>(r5)
            r14.updateRememberedValue(r10)
            r5 = r10
        L_0x015f:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            kotlinx.coroutines.CoroutineScope r5 = r5.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.material3.internal.Strings$Companion r10 = androidx.compose.material3.internal.Strings.Companion
            int r10 = androidx.compose.ui.R.string.navigation_menu
            int r10 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r10)
            r11 = 0
            java.lang.String r10 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r10, r14, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r9 = r17
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            r29 = r11
            java.lang.String r11 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r11)
            java.lang.Object r0 = r14.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r9 = -2145781231(0xffffffff8019fa11, float:-2.385594E-39)
            java.lang.String r11 = "CC(remember):NavigationDrawer.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r9, r11)
            java.lang.Object r9 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r18.getEmpty()
            if (r9 != r3) goto L_0x01b3
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r29)
            r9 = 2
            androidx.compose.runtime.MutableState r9 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r15, r9, r15)
            r14.updateRememberedValue(r9)
        L_0x01b3:
            r3 = r9
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r9 = -2145779460(0xffffffff801a00fc, float:-2.388076E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r9, r11)
            boolean r9 = r14.changed((java.lang.Object) r0)
            java.lang.Object r15 = r14.rememberedValue()
            r8 = 0
            if (r9 != 0) goto L_0x01d2
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r15 != r9) goto L_0x01d9
        L_0x01d2:
            androidx.compose.runtime.MutableFloatState r15 = androidx.compose.runtime.PrimitiveSnapshotStateKt.mutableFloatStateOf(r8)
            r14.updateRememberedValue(r15)
        L_0x01d9:
            r9 = r15
            androidx.compose.runtime.MutableFloatState r9 = (androidx.compose.runtime.MutableFloatState) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r15 = -2145776784(0xffffffff801a0b70, float:-2.391826E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r15, r11)
            r15 = r2 & 896(0x380, float:1.256E-42)
            r15 = r15 ^ 384(0x180, float:5.38E-43)
            r8 = 256(0x100, float:3.59E-43)
            if (r15 <= r8) goto L_0x01f7
            boolean r16 = r14.changed((java.lang.Object) r6)
            if (r16 != 0) goto L_0x01f4
            goto L_0x01f7
        L_0x01f4:
            r31 = r10
            goto L_0x01fd
        L_0x01f7:
            r31 = r10
            r10 = r2 & 384(0x180, float:5.38E-43)
            if (r10 != r8) goto L_0x01ff
        L_0x01fd:
            r8 = 1
            goto L_0x0201
        L_0x01ff:
            r8 = r29
        L_0x0201:
            boolean r10 = r14.changed((java.lang.Object) r0)
            r8 = r8 | r10
            java.lang.Object r10 = r14.rememberedValue()
            if (r8 != 0) goto L_0x0214
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r10 != r8) goto L_0x021f
        L_0x0214:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1 r8 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1
            r8.<init>(r6, r0)
            r10 = r8
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r14.updateRememberedValue(r10)
        L_0x021f:
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r0 = r29
            androidx.compose.runtime.EffectsKt.SideEffect(r10, r14, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r8, r10)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r8 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r0 != r8) goto L_0x0245
            r22 = 1
            goto L_0x0247
        L_0x0245:
            r22 = 0
        L_0x0247:
            r0 = 0
            r8 = 0
            r10 = 1
            androidx.compose.ui.Modifier r18 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r4, r0, r10, r8)
            androidx.compose.material3.internal.AnchoredDraggableState r19 = r6.getAnchoredDraggableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r20 = androidx.compose.foundation.gestures.Orientation.Horizontal
            r24 = 16
            r25 = 0
            r23 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.material3.internal.AnchoredDraggableKt.anchoredDraggable$default(r18, r19, r20, r21, r22, r23, r24, r25)
            r10 = r21
            r8 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r18 = r4
            java.lang.String r4 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r8, r4)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r8 = 0
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r4, r8)
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r1 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r8, r1)
            r8 = 0
            int r19 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r8)
            androidx.compose.runtime.CompositionLocalMap r8 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r14, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            r21 = r12
            kotlin.jvm.functions.Function0 r12 = r20.getConstructor()
            r13 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r33 = r3
            java.lang.String r3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r13, r3)
            androidx.compose.runtime.Applier r13 = r14.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x02a7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02a7:
            r14.startReusableNode()
            boolean r13 = r14.getInserting()
            if (r13 == 0) goto L_0x02b4
            r14.createNode(r12)
            goto L_0x02b7
        L_0x02b4:
            r14.useNode()
        L_0x02b7:
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m3675constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r12, r4, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r12, r8, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            boolean r8 = r12.getInserting()
            if (r8 != 0) goto L_0x02e7
            java.lang.Object r8 = r12.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r19)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r13)
            if (r8 != 0) goto L_0x02f5
        L_0x02e7:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r19)
            r12.updateRememberedValue(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r19)
            r12.apply(r8, r4)
        L_0x02f5:
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r12, r0, r4)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r4 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -1884917117(0xffffffff8fa67283, float:-1.6412972E-29)
            java.lang.String r4 = "C341@13601L17,344@13695L268,352@13988L70,342@13627L473,358@14209L245,364@14486L623,379@15121L1218,355@14109L2230:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r4)
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r4 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r4)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r8 = 0
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r4, r8)
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r12, r1)
            int r12 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r8)
            androidx.compose.runtime.CompositionLocalMap r13 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r14, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r19.getConstructor()
            r19 = r12
            r12 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r12, r3)
            androidx.compose.runtime.Applier r12 = r14.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0354
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0354:
            r14.startReusableNode()
            boolean r12 = r14.getInserting()
            if (r12 == 0) goto L_0x0361
            r14.createNode(r8)
            goto L_0x0364
        L_0x0361:
            r14.useNode()
        L_0x0364:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m3675constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r4, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r13, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            boolean r12 = r8.getInserting()
            if (r12 != 0) goto L_0x0394
            java.lang.Object r12 = r8.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r19)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 != 0) goto L_0x03a2
        L_0x0394:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r19)
            r8.updateRememberedValue(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r19)
            r8.apply(r12, r4)
        L_0x03a2:
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r0, r4)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r4 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 2020094509(0x7868322d, float:1.8837977E34)
            java.lang.String r4 = "C341@13607L9:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r4)
            int r0 = r2 >> 15
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.invoke(r14, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r14.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            boolean r0 = r6.isOpen()
            r4 = -2139013222(0xffffffff80813f9a, float:-1.1869595E-38)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r11)
            r4 = r2 & 7168(0x1c00, float:1.0045E-41)
            r8 = 2048(0x800, float:2.87E-42)
            if (r4 != r8) goto L_0x03ee
            r4 = 1
            goto L_0x03ef
        L_0x03ee:
            r4 = 0
        L_0x03ef:
            r8 = 256(0x100, float:3.59E-43)
            if (r15 <= r8) goto L_0x03f9
            boolean r12 = r14.changed((java.lang.Object) r6)
            if (r12 != 0) goto L_0x03fd
        L_0x03f9:
            r12 = r2 & 384(0x180, float:5.38E-43)
            if (r12 != r8) goto L_0x03ff
        L_0x03fd:
            r8 = 1
            goto L_0x0400
        L_0x03ff:
            r8 = 0
        L_0x0400:
            r4 = r4 | r8
            boolean r8 = r14.changedInstance(r5)
            r4 = r4 | r8
            java.lang.Object r8 = r14.rememberedValue()
            if (r4 != 0) goto L_0x0414
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r8 != r4) goto L_0x041f
        L_0x0414:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1 r4 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1
            r4.<init>(r10, r6, r5)
            r8 = r4
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r14.updateRememberedValue(r8)
        L_0x041f:
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r4 = -2139004044(0xffffffff80816374, float:-1.1882456E-38)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r11)
            boolean r4 = r14.changed((java.lang.Object) r9)
            r12 = 256(0x100, float:3.59E-43)
            if (r15 <= r12) goto L_0x0438
            boolean r13 = r14.changed((java.lang.Object) r6)
            if (r13 != 0) goto L_0x043c
        L_0x0438:
            r13 = r2 & 384(0x180, float:5.38E-43)
            if (r13 != r12) goto L_0x043e
        L_0x043c:
            r13 = 1
            goto L_0x043f
        L_0x043e:
            r13 = 0
        L_0x043f:
            r4 = r4 | r13
            java.lang.Object r13 = r14.rememberedValue()
            if (r4 != 0) goto L_0x044e
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r13 != r4) goto L_0x045a
        L_0x044e:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1 r4 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
            r13 = 0
            r4.<init>(r13, r6, r9)
            r13 = r4
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r14.updateRememberedValue(r13)
        L_0x045a:
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            int r4 = r2 >> 3
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r7 = r11
            r11 = r13
            r26 = 6
            r27 = r0
            r0 = r31
            r31 = r3
            r3 = r12
            r12 = r21
            r21 = r10
            r10 = r8
            r8 = r15
            r15 = r4
            r4 = r9
            r9 = r27
            m2264ScrimBx497Mc(r9, r10, r11, r12, r14, r15)
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r10 = -2138996797(0xffffffff80817fc3, float:-1.1892611E-38)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r10, r7)
            if (r8 <= r3) goto L_0x048d
            boolean r10 = r14.changed((java.lang.Object) r6)
            if (r10 != 0) goto L_0x0491
        L_0x048d:
            r10 = r2 & 384(0x180, float:5.38E-43)
            if (r10 != r3) goto L_0x0493
        L_0x0491:
            r11 = 1
            goto L_0x0494
        L_0x0493:
            r11 = 0
        L_0x0494:
            java.lang.Object r10 = r14.rememberedValue()
            if (r11 != 0) goto L_0x04a2
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r10 != r11) goto L_0x04ac
        L_0x04a2:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1 r10 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
            r10.<init>(r6)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r14.updateRememberedValue(r10)
        L_0x04ac:
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.OffsetKt.offset(r9, r10)
            r10 = -2138987555(0xffffffff8081a3dd, float:-1.1905562E-38)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r10, r7)
            boolean r10 = r14.changed((java.lang.Object) r0)
            if (r8 <= r3) goto L_0x04c7
            boolean r11 = r14.changed((java.lang.Object) r6)
            if (r11 != 0) goto L_0x04cb
        L_0x04c7:
            r11 = r2 & 384(0x180, float:5.38E-43)
            if (r11 != r3) goto L_0x04cd
        L_0x04cb:
            r11 = 1
            goto L_0x04ce
        L_0x04cd:
            r11 = 0
        L_0x04ce:
            r10 = r10 | r11
            boolean r11 = r14.changedInstance(r5)
            r10 = r10 | r11
            java.lang.Object r11 = r14.rememberedValue()
            if (r10 != 0) goto L_0x04e2
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x04ed
        L_0x04e2:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1 r10 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1
            r10.<init>(r0, r6, r5)
            r11 = r10
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r14.updateRememberedValue(r11)
        L_0x04ed:
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r0 = 0
            r5 = 0
            r10 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r9, r5, r11, r10, r0)
            r5 = -2138966640(0xffffffff8081f590, float:-1.193487E-38)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r7)
            if (r8 <= r3) goto L_0x0507
            boolean r5 = r14.changed((java.lang.Object) r6)
            if (r5 != 0) goto L_0x050d
        L_0x0507:
            r5 = r2 & 384(0x180, float:5.38E-43)
            if (r5 != r3) goto L_0x050c
            goto L_0x050d
        L_0x050c:
            r10 = 0
        L_0x050d:
            boolean r3 = r14.changed((java.lang.Object) r4)
            r3 = r3 | r10
            java.lang.Object r5 = r14.rememberedValue()
            if (r3 != 0) goto L_0x0520
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x052e
        L_0x0520:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$6$1 r3 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$6$1
            r9 = r33
            r5 = 0
            r3.<init>(r6, r9, r4, r5)
            r5 = r3
            androidx.compose.ui.layout.MeasurePolicy r5 = (androidx.compose.ui.layout.MeasurePolicy) r5
            r14.updateRememberedValue(r5)
        L_0x052e:
            androidx.compose.ui.layout.MeasurePolicy r5 = (androidx.compose.ui.layout.MeasurePolicy) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r2 = r2 & 14
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r1)
            r8 = 0
            int r1 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r8)
            androidx.compose.runtime.CompositionLocalMap r3 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r14, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r4.getConstructor()
            int r2 = r2 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r2 = r2 | 6
            r7 = r31
            r8 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r8, r7)
            androidx.compose.runtime.Applier r7 = r14.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0567
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0567:
            r14.startReusableNode()
            boolean r7 = r14.getInserting()
            if (r7 == 0) goto L_0x0574
            r14.createNode(r4)
            goto L_0x0577
        L_0x0574:
            r14.useNode()
        L_0x0577:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m3675constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r5, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r3, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r5 = r4.getInserting()
            if (r5 != 0) goto L_0x05a7
            java.lang.Object r5 = r4.rememberedValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 != 0) goto L_0x05b5
        L_0x05a7:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            r4.updateRememberedValue(r5)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.apply(r1, r3)
        L_0x05b5:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r0, r1)
            int r0 = r2 >> 6
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = r28
            r1.invoke(r14, r0)
            r14.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r14.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x05ef
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05ef:
            r3 = r6
            r5 = r12
            r2 = r18
            r4 = r21
        L_0x05f5:
            androidx.compose.runtime.ScopeUpdateScope r10 = r14.endRestartGroup()
            if (r10 == 0) goto L_0x060b
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3 r0 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3
            r7 = r34
            r8 = r36
            r9 = r37
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x060b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2262ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.DrawerState, boolean, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final boolean ModalNavigationDrawer_FHprtrg$lambda$2(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void ModalNavigationDrawer_FHprtrg$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static final float ModalNavigationDrawer_FHprtrg$lambda$5(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0492  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x04a2  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0541  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0550  */
    /* JADX WARNING: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DismissibleNavigationDrawer(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.ui.Modifier r25, androidx.compose.material3.DrawerState r26, boolean r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r1 = r24
            r5 = r28
            r6 = r30
            r0 = 398812198(0x17c56426, float:1.2756108E-24)
            r2 = r29
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(DismissibleNavigationDrawer)P(1,4,2,3)434@17575L39,438@17723L34,439@17789L7,440@17812L33,440@17801L44,442@17863L24,443@17913L33,445@17985L7,446@18020L2358:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r31 & 1
            r4 = 2
            if (r3 == 0) goto L_0x001c
            r3 = r6 | 6
            goto L_0x002c
        L_0x001c:
            r3 = r6 & 6
            if (r3 != 0) goto L_0x002b
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = r4
        L_0x0029:
            r3 = r3 | r6
            goto L_0x002c
        L_0x002b:
            r3 = r6
        L_0x002c:
            r7 = r31 & 2
            if (r7 == 0) goto L_0x0033
            r3 = r3 | 48
            goto L_0x0046
        L_0x0033:
            r8 = r6 & 48
            if (r8 != 0) goto L_0x0046
            r8 = r25
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0042
            r9 = 32
            goto L_0x0044
        L_0x0042:
            r9 = 16
        L_0x0044:
            r3 = r3 | r9
            goto L_0x0048
        L_0x0046:
            r8 = r25
        L_0x0048:
            r9 = r6 & 384(0x180, float:5.38E-43)
            r10 = 256(0x100, float:3.59E-43)
            if (r9 != 0) goto L_0x0062
            r9 = r31 & 4
            if (r9 != 0) goto L_0x005c
            r9 = r26
            boolean r11 = r2.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x005e
            r11 = r10
            goto L_0x0060
        L_0x005c:
            r9 = r26
        L_0x005e:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r3 = r3 | r11
            goto L_0x0064
        L_0x0062:
            r9 = r26
        L_0x0064:
            r11 = r31 & 8
            if (r11 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r12 = r6 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007e
            r12 = r27
            boolean r13 = r2.changed((boolean) r12)
            if (r13 == 0) goto L_0x007a
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r3 = r3 | r13
            goto L_0x0080
        L_0x007e:
            r12 = r27
        L_0x0080:
            r13 = r31 & 16
            if (r13 == 0) goto L_0x0087
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0087:
            r13 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0097
            boolean r13 = r2.changedInstance(r5)
            if (r13 == 0) goto L_0x0094
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r3 = r3 | r13
        L_0x0097:
            r13 = r3 & 9363(0x2493, float:1.312E-41)
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r13 != r14) goto L_0x00ab
            boolean r13 = r2.getSkipping()
            if (r13 != 0) goto L_0x00a4
            goto L_0x00ab
        L_0x00a4:
            r2.skipToGroupEnd()
            r4 = r12
        L_0x00a8:
            r3 = r9
            goto L_0x054a
        L_0x00ab:
            r2.startDefaults()
            r13 = r6 & 1
            r14 = 0
            if (r13 == 0) goto L_0x00c8
            boolean r13 = r2.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00ba
            goto L_0x00c8
        L_0x00ba:
            r2.skipToGroupEnd()
            r7 = r31 & 4
            if (r7 == 0) goto L_0x00c3
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c3:
            r16 = r8
            r19 = r12
            goto L_0x00e3
        L_0x00c8:
            if (r7 == 0) goto L_0x00cf
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r8 = r7
        L_0x00cf:
            r7 = r31 & 4
            if (r7 == 0) goto L_0x00dd
            androidx.compose.material3.DrawerValue r7 = androidx.compose.material3.DrawerValue.Closed
            r9 = 6
            androidx.compose.material3.DrawerState r7 = rememberDrawerState(r7, r14, r2, r9, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r9 = r7
        L_0x00dd:
            if (r11 == 0) goto L_0x00c3
            r16 = r8
            r19 = 1
        L_0x00e3:
            r2.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00f2
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:437)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r7, r8)
        L_0x00f2:
            r0 = 1034571360(0x3daa4e60, float:0.0831573)
            java.lang.String r7 = "CC(remember):NavigationDrawer.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r7)
            java.lang.Object r0 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            r11 = 0
            if (r0 != r8) goto L_0x0112
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r14, r4, r14)
            r2.updateRememberedValue(r0)
        L_0x0112:
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r12 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r12)
            java.lang.Object r4 = r2.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            r8 = 1034574207(0x3daa597f, float:0.08317851)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r7)
            r8 = r3 & 896(0x380, float:1.256E-42)
            r8 = r8 ^ 384(0x180, float:5.38E-43)
            if (r8 <= r10) goto L_0x0140
            boolean r12 = r2.changed((java.lang.Object) r9)
            if (r12 != 0) goto L_0x0144
        L_0x0140:
            r12 = r3 & 384(0x180, float:5.38E-43)
            if (r12 != r10) goto L_0x0146
        L_0x0144:
            r12 = 1
            goto L_0x0147
        L_0x0146:
            r12 = r11
        L_0x0147:
            boolean r13 = r2.changed((java.lang.Object) r4)
            r12 = r12 | r13
            java.lang.Object r13 = r2.rememberedValue()
            if (r12 != 0) goto L_0x015a
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x0165
        L_0x015a:
            androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1 r12 = new androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1
            r12.<init>(r9, r4)
            r13 = r12
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r2.updateRememberedValue(r13)
        L_0x0165:
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.EffectsKt.SideEffect(r13, r2, r11)
            r4 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r12 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r4, r12)
            r4 = -954363344(0xffffffffc71d9230, float:-40338.188)
            java.lang.String r12 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r4, r12)
            java.lang.Object r4 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r4 != r12) goto L_0x019a
            kotlin.coroutines.EmptyCoroutineContext r4 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            kotlinx.coroutines.CoroutineScope r4 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r4, r2)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r12 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r12.<init>(r4)
            r2.updateRememberedValue(r12)
            r4 = r12
        L_0x019a:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r4 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            kotlinx.coroutines.CoroutineScope r4 = r4.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.material3.internal.Strings$Companion r12 = androidx.compose.material3.internal.Strings.Companion
            int r12 = androidx.compose.ui.R.string.navigation_menu
            int r12 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r12)
            java.lang.String r12 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r12, r2, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r15 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r14, r15)
            java.lang.Object r13 = r2.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.LayoutDirection r14 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r13 != r14) goto L_0x01ce
            r20 = 1
            goto L_0x01d0
        L_0x01ce:
            r20 = r11
        L_0x01d0:
            androidx.compose.material3.internal.AnchoredDraggableState r17 = r9.getAnchoredDraggableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r18 = androidx.compose.foundation.gestures.Orientation.Horizontal
            r22 = 16
            r23 = 0
            r21 = 0
            androidx.compose.ui.Modifier r13 = androidx.compose.material3.internal.AnchoredDraggableKt.anchoredDraggable$default(r16, r17, r18, r19, r20, r21, r22, r23)
            r14 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r15 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r14, r15)
            androidx.compose.ui.Alignment$Companion r17 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r14 = r17.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r14, r11)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r10, r6)
            int r18 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r11)
            androidx.compose.runtime.CompositionLocalMap r11 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r2, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r20.getConstructor()
            r5 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r1 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r1)
            androidx.compose.runtime.Applier r5 = r2.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x021f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x021f:
            r2.startReusableNode()
            boolean r5 = r2.getInserting()
            if (r5 == 0) goto L_0x022c
            r2.createNode(r10)
            goto L_0x022f
        L_0x022c:
            r2.useNode()
        L_0x022f:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3675constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r14, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r11, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetCompositeKeyHash()
            boolean r11 = r5.getInserting()
            if (r11 != 0) goto L_0x025f
            java.lang.Object r11 = r5.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r18)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r14)
            if (r11 != 0) goto L_0x026d
        L_0x025f:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r18)
            r5.updateRememberedValue(r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r18)
            r5.apply(r11, r10)
        L_0x026d:
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r13, r10)
            r5 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r10 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r10)
            androidx.compose.foundation.layout.BoxScopeInstance r11 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r11 = (androidx.compose.foundation.layout.BoxScope) r11
            r11 = -1218087217(0xffffffffb76576cf, float:-1.3677126E-5)
            java.lang.String r13 = "C477@19117L1255,454@18269L2103:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r11, r13)
            r11 = 99280484(0x5eae664, float:2.2089886E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r11, r7)
            r11 = 256(0x100, float:3.59E-43)
            if (r8 <= r11) goto L_0x029a
            boolean r13 = r2.changed((java.lang.Object) r9)
            if (r13 != 0) goto L_0x029e
        L_0x029a:
            r13 = r3 & 384(0x180, float:5.38E-43)
            if (r13 != r11) goto L_0x02a0
        L_0x029e:
            r11 = 1
            goto L_0x02a1
        L_0x02a0:
            r11 = 0
        L_0x02a1:
            java.lang.Object r13 = r2.rememberedValue()
            if (r11 != 0) goto L_0x02af
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r13 != r11) goto L_0x02ba
        L_0x02af:
            androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1 r11 = new androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1
            r11.<init>(r9, r0)
            r13 = r11
            androidx.compose.ui.layout.MeasurePolicy r13 = (androidx.compose.ui.layout.MeasurePolicy) r13
            r2.updateRememberedValue(r13)
        L_0x02ba:
            androidx.compose.ui.layout.MeasurePolicy r13 = (androidx.compose.ui.layout.MeasurePolicy) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r6)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r11 = 0
            int r14 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r11)
            androidx.compose.runtime.CompositionLocalMap r11 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r2, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r18.getConstructor()
            r18 = r14
            r14 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r14, r1)
            androidx.compose.runtime.Applier r14 = r2.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x02ef
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02ef:
            r2.startReusableNode()
            boolean r14 = r2.getInserting()
            if (r14 == 0) goto L_0x02fc
            r2.createNode(r5)
            goto L_0x02ff
        L_0x02fc:
            r2.useNode()
        L_0x02ff:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3675constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r13, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r11, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetCompositeKeyHash()
            boolean r13 = r5.getInserting()
            if (r13 != 0) goto L_0x032f
            java.lang.Object r13 = r5.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r18)
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 != 0) goto L_0x033d
        L_0x032f:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r18)
            r5.updateRememberedValue(r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r18)
            r5.apply(r13, r11)
        L_0x033d:
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r0, r11)
            r0 = 285475168(0x11040160, float:1.0413388E-28)
            java.lang.String r5 = "C457@18361L623,456@18317L741,475@19075L17:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r5)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = -1376263189(0xffffffffadf7e3eb, float:-2.8181865E-11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r7)
            boolean r5 = r2.changed((java.lang.Object) r12)
            r11 = 256(0x100, float:3.59E-43)
            if (r8 <= r11) goto L_0x0366
            boolean r7 = r2.changed((java.lang.Object) r9)
            if (r7 != 0) goto L_0x036a
        L_0x0366:
            r7 = r3 & 384(0x180, float:5.38E-43)
            if (r7 != r11) goto L_0x036c
        L_0x036a:
            r7 = 1
            goto L_0x036d
        L_0x036c:
            r7 = 0
        L_0x036d:
            r5 = r5 | r7
            boolean r7 = r2.changedInstance(r4)
            r5 = r5 | r7
            java.lang.Object r7 = r2.rememberedValue()
            if (r5 != 0) goto L_0x0381
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r7 != r5) goto L_0x038c
        L_0x0381:
            androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1 r5 = new androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1
            r5.<init>(r12, r9, r4)
            r7 = r5
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r2.updateRememberedValue(r7)
        L_0x038c:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r4 = 0
            r5 = 1
            r11 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r11, r7, r5, r4)
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r4, r15)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r4, r11)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r6)
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r11)
            androidx.compose.runtime.CompositionLocalMap r7 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r2, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            r14 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r14, r1)
            androidx.compose.runtime.Applier r11 = r2.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x03d1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03d1:
            r2.startReusableNode()
            boolean r11 = r2.getInserting()
            if (r11 == 0) goto L_0x03de
            r2.createNode(r8)
            goto L_0x03e1
        L_0x03de:
            r2.useNode()
        L_0x03e1:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m3675constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r4, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r7, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            boolean r7 = r8.getInserting()
            if (r7 != 0) goto L_0x0411
            java.lang.Object r7 = r8.rememberedValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r11)
            if (r7 != 0) goto L_0x041f
        L_0x0411:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r8.updateRememberedValue(r7)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r8.apply(r5, r4)
        L_0x041f:
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r0, r4)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r10)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 590398649(0x2330c4b9, float:9.582637E-18)
            java.lang.String r4 = "C473@19025L15:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r4)
            r0 = r3 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4 = r24
            r4.invoke(r2, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r15)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            r11 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r5, r11)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r6)
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r11)
            androidx.compose.runtime.CompositionLocalMap r7 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r2, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            r14 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r14, r1)
            androidx.compose.runtime.Applier r1 = r2.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x0495
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0495:
            r2.startReusableNode()
            boolean r1 = r2.getInserting()
            if (r1 == 0) goto L_0x04a2
            r2.createNode(r8)
            goto L_0x04a5
        L_0x04a2:
            r2.useNode()
        L_0x04a5:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m3675constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r5, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r7, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
            boolean r7 = r1.getInserting()
            if (r7 != 0) goto L_0x04d5
            java.lang.Object r7 = r1.rememberedValue()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x04e3
        L_0x04d5:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r1.updateRememberedValue(r7)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r1.apply(r6, r5)
        L_0x04e3:
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r0, r5)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r10)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 590454015(0x23319cff, float:9.6284344E-18)
            java.lang.String r1 = "C475@19081L9:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            int r0 = r3 >> 12
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5 = r28
            r5.invoke(r2, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0544
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0544:
            r8 = r16
            r4 = r19
            goto L_0x00a8
        L_0x054a:
            androidx.compose.runtime.ScopeUpdateScope r9 = r2.endRestartGroup()
            if (r9 == 0) goto L_0x0561
            androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3 r0 = new androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3
            r1 = r24
            r6 = r30
            r7 = r31
            r2 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0561:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.DrawerState, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final boolean DismissibleNavigationDrawer$lambda$16(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void DismissibleNavigationDrawer$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void PermanentNavigationDrawer(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r16, androidx.compose.ui.Modifier r17, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r1 = r16
            r3 = r18
            r4 = r20
            r0 = -276843608(0xffffffffef7fb3a8, float:-7.913587E28)
            r2 = r19
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r5 = "C(PermanentNavigationDrawer)P(1,2)532@21415L85:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            r5 = r21 & 1
            if (r5 == 0) goto L_0x001b
            r5 = r4 | 6
            goto L_0x002b
        L_0x001b:
            r5 = r4 & 6
            if (r5 != 0) goto L_0x002a
            boolean r5 = r2.changedInstance(r1)
            if (r5 == 0) goto L_0x0027
            r5 = 4
            goto L_0x0028
        L_0x0027:
            r5 = 2
        L_0x0028:
            r5 = r5 | r4
            goto L_0x002b
        L_0x002a:
            r5 = r4
        L_0x002b:
            r6 = r21 & 2
            if (r6 == 0) goto L_0x0032
            r5 = r5 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r4 & 48
            if (r7 != 0) goto L_0x0045
            r7 = r17
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0041
            r8 = 32
            goto L_0x0043
        L_0x0041:
            r8 = 16
        L_0x0043:
            r5 = r5 | r8
            goto L_0x0047
        L_0x0045:
            r7 = r17
        L_0x0047:
            r8 = r21 & 4
            if (r8 == 0) goto L_0x004e
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004e:
            r8 = r4 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x005e
            boolean r8 = r2.changedInstance(r3)
            if (r8 == 0) goto L_0x005b
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r5 = r5 | r8
        L_0x005e:
            r8 = r5 & 147(0x93, float:2.06E-43)
            r9 = 146(0x92, float:2.05E-43)
            if (r8 != r9) goto L_0x0071
            boolean r8 = r2.getSkipping()
            if (r8 != 0) goto L_0x006b
            goto L_0x0071
        L_0x006b:
            r2.skipToGroupEnd()
            r6 = r7
            goto L_0x0225
        L_0x0071:
            if (r6 == 0) goto L_0x0078
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x0079
        L_0x0078:
            r6 = r7
        L_0x0079:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0085
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:531)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r7, r8)
        L_0x0085:
            r0 = 0
            r7 = 0
            r8 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r6, r0, r8, r7)
            r7 = 693286680(0x2952b718, float:4.6788176E-14)
            java.lang.String r8 = "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r8)
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r7.getStart()
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r8 = r8.getTop()
            r9 = 0
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r7, r8, r2, r9)
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r10 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r10)
            int r11 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r9)
            androidx.compose.runtime.CompositionLocalMap r12 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r2, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            r14 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r15 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r14, r15)
            androidx.compose.runtime.Applier r14 = r2.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x00d2
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00d2:
            r2.startReusableNode()
            boolean r14 = r2.getInserting()
            if (r14 == 0) goto L_0x00df
            r2.createNode(r13)
            goto L_0x00e2
        L_0x00df:
            r2.useNode()
        L_0x00e2:
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m3675constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r13, r7, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r13, r12, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            boolean r12 = r13.getInserting()
            if (r12 != 0) goto L_0x0112
            java.lang.Object r12 = r13.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r14)
            if (r12 != 0) goto L_0x0120
        L_0x0112:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r13.updateRememberedValue(r12)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r13.apply(r11, r7)
        L_0x0120:
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r13, r0, r7)
            r0 = -407918630(0xffffffffe7afa7da, float:-1.6590209E24)
            java.lang.String r7 = "C100@5047L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r7)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
            r0 = -882916661(0xffffffffcb5fc2cb, float:-1.4664395E7)
            java.lang.String r7 = "C533@21453L15,534@21477L17:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r7)
            r0 = r5 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.invoke(r2, r0)
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r7 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r7)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r7, r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r10)
            int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r9)
            androidx.compose.runtime.CompositionLocalMap r9 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r2, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            r11 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r11, r15)
            androidx.compose.runtime.Applier r11 = r2.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0182
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0182:
            r2.startReusableNode()
            boolean r11 = r2.getInserting()
            if (r11 == 0) goto L_0x018f
            r2.createNode(r10)
            goto L_0x0192
        L_0x018f:
            r2.useNode()
        L_0x0192:
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m3675constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r7, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r9, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            boolean r9 = r10.getInserting()
            if (r9 != 0) goto L_0x01c2
            java.lang.Object r9 = r10.rememberedValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r8)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r9 != 0) goto L_0x01d0
        L_0x01c2:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r10.updateRememberedValue(r9)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r10.apply(r8, r7)
        L_0x01d0:
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r0, r7)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r7 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r7)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -1559720052(0xffffffffa3088f8c, float:-7.402972E-18)
            java.lang.String r7 = "C534@21483L9:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r7)
            int r0 = r5 >> 6
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3.invoke(r2, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0225
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0225:
            androidx.compose.runtime.ScopeUpdateScope r7 = r2.endRestartGroup()
            if (r7 == 0) goto L_0x0238
            androidx.compose.material3.NavigationDrawerKt$PermanentNavigationDrawer$2 r0 = new androidx.compose.material3.NavigationDrawerKt$PermanentNavigationDrawer$2
            r5 = r21
            r2 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x0238:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.PermanentNavigationDrawer(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f1  */
    /* renamed from: ModalDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2261ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier r24, androidx.compose.ui.graphics.Shape r25, long r26, long r28, float r30, androidx.compose.foundation.layout.WindowInsets r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r10 = r34
            r0 = 1001163336(0x3bac8a48, float:0.005265508)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ModalDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)561@22840L5,562@22896L19,563@22949L37,565@23104L12,568@23174L225:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r35 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r10 | 6
            r4 = r3
            r3 = r24
            goto L_0x002e
        L_0x001a:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r24
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r10
            goto L_0x002e
        L_0x002b:
            r3 = r24
            r4 = r10
        L_0x002e:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0047
            r5 = r35 & 2
            if (r5 != 0) goto L_0x0041
            r5 = r25
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0043
            r6 = 32
            goto L_0x0045
        L_0x0041:
            r5 = r25
        L_0x0043:
            r6 = 16
        L_0x0045:
            r4 = r4 | r6
            goto L_0x0049
        L_0x0047:
            r5 = r25
        L_0x0049:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0062
            r6 = r35 & 4
            if (r6 != 0) goto L_0x005c
            r6 = r26
            boolean r8 = r1.changed((long) r6)
            if (r8 == 0) goto L_0x005e
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r6 = r26
        L_0x005e:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r4 = r4 | r8
            goto L_0x0064
        L_0x0062:
            r6 = r26
        L_0x0064:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007d
            r8 = r35 & 8
            if (r8 != 0) goto L_0x0077
            r8 = r28
            boolean r11 = r1.changed((long) r8)
            if (r11 == 0) goto L_0x0079
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0077:
            r8 = r28
        L_0x0079:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r4 = r4 | r11
            goto L_0x007f
        L_0x007d:
            r8 = r28
        L_0x007f:
            r11 = r35 & 16
            if (r11 == 0) goto L_0x0086
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0099
            r12 = r30
            boolean r13 = r1.changed((float) r12)
            if (r13 == 0) goto L_0x0095
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r4 = r4 | r13
            goto L_0x009b
        L_0x0099:
            r12 = r30
        L_0x009b:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00b5
            r13 = r35 & 32
            if (r13 != 0) goto L_0x00af
            r13 = r31
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b1
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00af:
            r13 = r31
        L_0x00b1:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r4 = r4 | r14
            goto L_0x00b7
        L_0x00b5:
            r13 = r31
        L_0x00b7:
            r14 = r35 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00bf
            r4 = r4 | r15
            goto L_0x00d2
        L_0x00bf:
            r14 = r10 & r15
            if (r14 != 0) goto L_0x00d2
            r14 = r32
            boolean r15 = r1.changedInstance(r14)
            if (r15 == 0) goto L_0x00ce
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r4 = r4 | r15
            goto L_0x00d4
        L_0x00d2:
            r14 = r32
        L_0x00d4:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r4
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00f1
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e4
            goto L_0x00f1
        L_0x00e4:
            r1.skipToGroupEnd()
            r21 = r1
            r1 = r3
            r2 = r5
            r3 = r6
            r5 = r8
            r7 = r12
            r8 = r13
            goto L_0x01d6
        L_0x00f1:
            r1.startDefaults()
            r0 = r10 & 1
            r33 = -458753(0xfffffffffff8ffff, float:NaN)
            r15 = 6
            if (r0 == 0) goto L_0x012c
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0103
            goto L_0x012c
        L_0x0103:
            r1.skipToGroupEnd()
            r0 = r35 & 2
            if (r0 == 0) goto L_0x010c
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x010c:
            r0 = r35 & 4
            if (r0 == 0) goto L_0x0112
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0112:
            r0 = r35 & 8
            if (r0 == 0) goto L_0x0118
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0118:
            r0 = r35 & 32
            if (r0 == 0) goto L_0x011e
            r4 = r4 & r33
        L_0x011e:
            r14 = r5
            r17 = r8
            r19 = r12
            r12 = r13
            r0 = r15
            r2 = 1001163336(0x3bac8a48, float:0.005265508)
            r13 = r3
        L_0x0129:
            r15 = r6
            goto L_0x018b
        L_0x012c:
            if (r2 == 0) goto L_0x0133
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0134
        L_0x0133:
            r0 = r3
        L_0x0134:
            r2 = r35 & 2
            if (r2 == 0) goto L_0x0141
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r1, r15)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
            r5 = r2
        L_0x0141:
            r2 = r35 & 4
            if (r2 == 0) goto L_0x014e
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r2 = r2.getModalContainerColor(r1, r15)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r2
        L_0x014e:
            r2 = r35 & 8
            if (r2 == 0) goto L_0x015d
            int r2 = r4 >> 6
            r2 = r2 & 14
            long r2 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r6, r1, r2)
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            r8 = r2
        L_0x015d:
            if (r11 == 0) goto L_0x0166
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m2038getModalDrawerElevationD9Ej5fM()
            r12 = r2
        L_0x0166:
            r2 = r35 & 32
            if (r2 == 0) goto L_0x017f
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r1, r15)
            r4 = r4 & r33
            r13 = r0
            r14 = r5
            r17 = r8
            r19 = r12
            r0 = r15
            r12 = r2
            r15 = r6
            r2 = 1001163336(0x3bac8a48, float:0.005265508)
            goto L_0x018b
        L_0x017f:
            r14 = r5
            r17 = r8
            r19 = r12
            r12 = r13
            r2 = 1001163336(0x3bac8a48, float:0.005265508)
            r13 = r0
            r0 = r15
            goto L_0x0129
        L_0x018b:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x019a
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:567)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r3, r5)
        L_0x019a:
            int r2 = r4 >> 12
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r4 << 6
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r4 << 3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r3
            r22 = r0 | r2
            r23 = 0
            r11 = 0
            r20 = r32
            r21 = r1
            m2259DrawerSheet7zSek6w(r11, r12, r13, r14, r15, r17, r19, r20, r21, r22, r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ce
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ce:
            r8 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r5 = r17
            r7 = r19
        L_0x01d6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r21.endRestartGroup()
            if (r12 == 0) goto L_0x01ea
            androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1 r0 = new androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1
            r9 = r32
            r11 = r35
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x01ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2261ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x010f  */
    /* renamed from: ModalDrawerSheet-Snr_uVM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2260ModalDrawerSheetSnr_uVM(androidx.compose.material3.DrawerState r27, androidx.compose.ui.Modifier r28, androidx.compose.ui.graphics.Shape r29, long r30, long r32, float r34, androidx.compose.foundation.layout.WindowInsets r35, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r1 = r27
            r11 = r38
            r12 = r39
            r0 = 1513027356(0x5a2ef71c, float:1.23120864E16)
            r2 = r37
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(ModalDrawerSheet)P(4,6,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,7)605@24793L5,606@24849L19,607@24902L37,609@25057L12,612@25168L299,612@25127L340:NavigationDrawer.kt#uh7d8r"
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
            r5 = r28
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
            r5 = r28
        L_0x0047:
            r6 = r11 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0060
            r6 = r12 & 4
            if (r6 != 0) goto L_0x005a
            r6 = r29
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005c
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r6 = r29
        L_0x005c:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r3 = r3 | r7
            goto L_0x0062
        L_0x0060:
            r6 = r29
        L_0x0062:
            r7 = r11 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007b
            r7 = r12 & 8
            if (r7 != 0) goto L_0x0075
            r7 = r30
            boolean r9 = r2.changed((long) r7)
            if (r9 == 0) goto L_0x0077
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r7 = r30
        L_0x0077:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r3 = r3 | r9
            goto L_0x007d
        L_0x007b:
            r7 = r30
        L_0x007d:
            r9 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0096
            r9 = r12 & 16
            if (r9 != 0) goto L_0x0090
            r9 = r32
            boolean r13 = r2.changed((long) r9)
            if (r13 == 0) goto L_0x0092
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0090:
            r9 = r32
        L_0x0092:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r3 = r3 | r13
            goto L_0x0098
        L_0x0096:
            r9 = r32
        L_0x0098:
            r13 = r12 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a0
            r3 = r3 | r14
            goto L_0x00b2
        L_0x00a0:
            r14 = r14 & r11
            if (r14 != 0) goto L_0x00b2
            r14 = r34
            boolean r15 = r2.changed((float) r14)
            if (r15 == 0) goto L_0x00ae
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ae:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r3 = r3 | r15
            goto L_0x00b4
        L_0x00b2:
            r14 = r34
        L_0x00b4:
            r15 = 1572864(0x180000, float:2.204052E-39)
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00cf
            r15 = r12 & 64
            if (r15 != 0) goto L_0x00c8
            r15 = r35
            boolean r16 = r2.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00ca
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00c8:
            r15 = r35
        L_0x00ca:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cc:
            r3 = r3 | r16
            goto L_0x00d1
        L_0x00cf:
            r15 = r35
        L_0x00d1:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00da
            r3 = r3 | r17
            goto L_0x00ee
        L_0x00da:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00ee
            r0 = r36
            boolean r17 = r2.changedInstance(r0)
            if (r17 == 0) goto L_0x00e9
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00eb
        L_0x00e9:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00eb:
            r3 = r3 | r17
            goto L_0x00f0
        L_0x00ee:
            r0 = r36
        L_0x00f0:
            r17 = 4793491(0x492493, float:6.717112E-39)
            r0 = r3 & r17
            r37 = r4
            r4 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r4) goto L_0x010f
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0103
            goto L_0x010f
        L_0x0103:
            r2.skipToGroupEnd()
            r19 = r5
            r3 = r6
            r4 = r7
            r6 = r9
            r8 = r14
            r9 = r15
            goto L_0x01de
        L_0x010f:
            r2.startDefaults()
            r0 = r11 & 1
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x014a
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0123
            goto L_0x014a
        L_0x0123:
            r2.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x012c
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012c:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x0132
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0132:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0138
            r3 = r3 & r17
        L_0x0138:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x013d
            r3 = r3 & r4
        L_0x013d:
            r19 = r5
            r20 = r6
            r21 = r7
            r23 = r9
            r25 = r14
            r18 = r15
            goto L_0x019d
        L_0x014a:
            if (r37 == 0) goto L_0x0151
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x0151:
            r0 = r12 & 4
            r37 = r4
            r4 = 6
            if (r0 == 0) goto L_0x0161
            androidx.compose.material3.DrawerDefaults r0 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r0 = r0.getShape(r2, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r0
        L_0x0161:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x016d
            androidx.compose.material3.DrawerDefaults r0 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r7 = r0.getModalContainerColor(r2, r4)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x016d:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x017c
            int r0 = r3 >> 9
            r0 = r0 & 14
            long r9 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r7, r2, r0)
            r0 = r3 & r17
            r3 = r0
        L_0x017c:
            if (r13 == 0) goto L_0x0185
            androidx.compose.material3.DrawerDefaults r0 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r0 = r0.m2038getModalDrawerElevationD9Ej5fM()
            r14 = r0
        L_0x0185:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x013d
            androidx.compose.material3.DrawerDefaults r0 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r0 = r0.getWindowInsets(r2, r4)
            r3 = r3 & r37
            r18 = r0
            r19 = r5
            r20 = r6
            r21 = r7
            r23 = r9
            r25 = r14
        L_0x019d:
            r2.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01af
            r0 = -1
            java.lang.String r4 = "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:611)"
            r5 = 1513027356(0x5a2ef71c, float:1.23120864E16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r0, r4)
        L_0x01af:
            androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$2 r17 = new androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$2
            r26 = r36
            r17.<init>(r18, r19, r20, r21, r23, r25, r26)
            r0 = r17
            r4 = 54
            r5 = 1552342929(0x5c86df91, float:3.03707686E17)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r6, r0, r2, r4)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r3 = r3 & 14
            r3 = r3 | 48
            androidx.compose.material3.NavigationDrawer_androidKt.DrawerPredictiveBackHandler(r1, r0, r2, r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01d4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d4:
            r9 = r18
            r3 = r20
            r4 = r21
            r6 = r23
            r8 = r25
        L_0x01de:
            androidx.compose.runtime.ScopeUpdateScope r13 = r2.endRestartGroup()
            if (r13 == 0) goto L_0x01f2
            androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$3 r0 = new androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$3
            r10 = r36
            r2 = r19
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x01f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2260ModalDrawerSheetSnr_uVM(androidx.compose.material3.DrawerState, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f5  */
    /* renamed from: DismissibleDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2258DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier r24, androidx.compose.ui.graphics.Shape r25, long r26, long r28, float r30, androidx.compose.foundation.layout.WindowInsets r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r10 = r34
            r0 = -588600583(0xffffffffdceaaaf9, float:-5.28425048E17)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(DismissibleDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)650@26887L22,651@26943L37,653@27104L12,656@27174L225:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r35 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r10 | 6
            r4 = r3
            r3 = r24
            goto L_0x002e
        L_0x001a:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r24
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r10
            goto L_0x002e
        L_0x002b:
            r3 = r24
            r4 = r10
        L_0x002e:
            r5 = r35 & 2
            if (r5 == 0) goto L_0x0035
            r4 = r4 | 48
            goto L_0x0048
        L_0x0035:
            r6 = r10 & 48
            if (r6 != 0) goto L_0x0048
            r6 = r25
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0044
            r7 = 32
            goto L_0x0046
        L_0x0044:
            r7 = 16
        L_0x0046:
            r4 = r4 | r7
            goto L_0x004a
        L_0x0048:
            r6 = r25
        L_0x004a:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0063
            r7 = r35 & 4
            if (r7 != 0) goto L_0x005d
            r7 = r26
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005d:
            r7 = r26
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r4 = r4 | r9
            goto L_0x0065
        L_0x0063:
            r7 = r26
        L_0x0065:
            r9 = r10 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007c
            r9 = r35 & 8
            r11 = r28
            if (r9 != 0) goto L_0x0078
            boolean r9 = r1.changed((long) r11)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r4 = r4 | r9
            goto L_0x007e
        L_0x007c:
            r11 = r28
        L_0x007e:
            r9 = r35 & 16
            if (r9 == 0) goto L_0x0085
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0085:
            r13 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0098
            r13 = r30
            boolean r14 = r1.changed((float) r13)
            if (r14 == 0) goto L_0x0094
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r4 = r4 | r14
            goto L_0x009a
        L_0x0098:
            r13 = r30
        L_0x009a:
            r14 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b4
            r14 = r35 & 32
            if (r14 != 0) goto L_0x00ae
            r14 = r31
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r14 = r31
        L_0x00b0:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r4 = r4 | r15
            goto L_0x00b6
        L_0x00b4:
            r14 = r31
        L_0x00b6:
            r15 = r35 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bf
            r4 = r4 | r16
            goto L_0x00d3
        L_0x00bf:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d3
            r15 = r32
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00ce
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r4 = r4 | r16
            goto L_0x00d5
        L_0x00d3:
            r15 = r32
        L_0x00d5:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r4 & r16
            r33 = r2
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r2) goto L_0x00f5
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e8
            goto L_0x00f5
        L_0x00e8:
            r1.skipToGroupEnd()
            r21 = r1
            r1 = r3
            r2 = r6
            r3 = r7
            r5 = r11
            r7 = r13
            r8 = r14
            goto L_0x01c6
        L_0x00f5:
            r1.startDefaults()
            r0 = r10 & 1
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r2 = 6
            if (r0 == 0) goto L_0x0128
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0107
            goto L_0x0128
        L_0x0107:
            r1.skipToGroupEnd()
            r0 = r35 & 4
            if (r0 == 0) goto L_0x0110
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0110:
            r0 = r35 & 8
            if (r0 == 0) goto L_0x0116
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0116:
            r0 = r35 & 32
            if (r0 == 0) goto L_0x011c
            r4 = r4 & r16
        L_0x011c:
            r15 = r7
            r17 = r11
            r19 = r13
            r12 = r14
            r0 = -588600583(0xffffffffdceaaaf9, float:-5.28425048E17)
            r13 = r3
            r14 = r6
            goto L_0x017b
        L_0x0128:
            if (r33 == 0) goto L_0x012f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0130
        L_0x012f:
            r0 = r3
        L_0x0130:
            if (r5 == 0) goto L_0x0137
            androidx.compose.ui.graphics.Shape r3 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r6 = r3
        L_0x0137:
            r3 = r35 & 4
            if (r3 == 0) goto L_0x0143
            androidx.compose.material3.DrawerDefaults r3 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r7 = r3.getStandardContainerColor(r1, r2)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0143:
            r3 = r35 & 8
            if (r3 == 0) goto L_0x0152
            int r3 = r4 >> 6
            r3 = r3 & 14
            long r11 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r7, r1, r3)
            r3 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            r4 = r3
        L_0x0152:
            if (r9 == 0) goto L_0x015b
            androidx.compose.material3.DrawerDefaults r3 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r3 = r3.m2036getDismissibleDrawerElevationD9Ej5fM()
            r13 = r3
        L_0x015b:
            r3 = r35 & 32
            if (r3 == 0) goto L_0x0170
            androidx.compose.material3.DrawerDefaults r3 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r2)
            r4 = r4 & r16
            r14 = r6
            r15 = r7
            r17 = r11
            r19 = r13
            r13 = r0
            r12 = r3
            goto L_0x0178
        L_0x0170:
            r15 = r7
            r17 = r11
            r19 = r13
            r12 = r14
            r13 = r0
            r14 = r6
        L_0x0178:
            r0 = -588600583(0xffffffffdceaaaf9, float:-5.28425048E17)
        L_0x017b:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x018a
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:655)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r3, r5)
        L_0x018a:
            int r0 = r4 >> 12
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r4 << 6
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r4 << 3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r3
            r22 = r0 | r2
            r23 = 0
            r11 = 0
            r20 = r32
            r21 = r1
            m2259DrawerSheet7zSek6w(r11, r12, r13, r14, r15, r17, r19, r20, r21, r22, r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01be
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01be:
            r8 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r5 = r17
            r7 = r19
        L_0x01c6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r21.endRestartGroup()
            if (r12 == 0) goto L_0x01da
            androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1 r0 = new androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1
            r9 = r32
            r11 = r35
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2258DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x010f  */
    /* renamed from: DismissibleDrawerSheet-Snr_uVM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2257DismissibleDrawerSheetSnr_uVM(androidx.compose.material3.DrawerState r27, androidx.compose.ui.Modifier r28, androidx.compose.ui.graphics.Shape r29, long r30, long r32, float r34, androidx.compose.foundation.layout.WindowInsets r35, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r1 = r27
            r11 = r38
            r12 = r39
            r0 = 1473549901(0x57d4964d, float:4.67484004E14)
            r2 = r37
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(DismissibleDrawerSheet)P(4,6,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,7)694@28867L22,695@28923L37,697@29084L12,700@29195L299,700@29154L340:NavigationDrawer.kt#uh7d8r"
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
            r5 = r28
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
            r5 = r28
        L_0x0047:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r11 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0061
            r7 = r29
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r29
        L_0x0063:
            r8 = r11 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007c
            r8 = r12 & 8
            if (r8 != 0) goto L_0x0076
            r8 = r30
            boolean r10 = r2.changed((long) r8)
            if (r10 == 0) goto L_0x0078
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r8 = r30
        L_0x0078:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r10
            goto L_0x007e
        L_0x007c:
            r8 = r30
        L_0x007e:
            r10 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0095
            r10 = r12 & 16
            r13 = r32
            if (r10 != 0) goto L_0x0091
            boolean r10 = r2.changed((long) r13)
            if (r10 == 0) goto L_0x0091
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r3 = r3 | r10
            goto L_0x0097
        L_0x0095:
            r13 = r32
        L_0x0097:
            r10 = r12 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x009f
            r3 = r3 | r15
            goto L_0x00b2
        L_0x009f:
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00b2
            r15 = r34
            boolean r16 = r2.changed((float) r15)
            if (r16 == 0) goto L_0x00ad
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r3 = r3 | r16
            goto L_0x00b4
        L_0x00b2:
            r15 = r34
        L_0x00b4:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x00ce
            r16 = r12 & 64
            r0 = r35
            if (r16 != 0) goto L_0x00c9
            boolean r17 = r2.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00c9
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cb
        L_0x00c9:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00cb:
            r3 = r3 | r17
            goto L_0x00d0
        L_0x00ce:
            r0 = r35
        L_0x00d0:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00d9
            r3 = r3 | r17
            goto L_0x00ed
        L_0x00d9:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00ed
            r0 = r36
            boolean r17 = r2.changedInstance(r0)
            if (r17 == 0) goto L_0x00e8
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00e8:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ea:
            r3 = r3 | r17
            goto L_0x00ef
        L_0x00ed:
            r0 = r36
        L_0x00ef:
            r17 = 4793491(0x492493, float:6.717112E-39)
            r0 = r3 & r17
            r37 = r4
            r4 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r4) goto L_0x010f
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0102
            goto L_0x010f
        L_0x0102:
            r2.skipToGroupEnd()
            r19 = r5
            r3 = r7
            r4 = r8
            r6 = r13
            r8 = r15
            r9 = r35
            goto L_0x01c6
        L_0x010f:
            r2.startDefaults()
            r0 = r11 & 1
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0144
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0123
            goto L_0x0144
        L_0x0123:
            r2.skipToGroupEnd()
            r0 = r12 & 8
            if (r0 == 0) goto L_0x012c
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x012c:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0132
            r3 = r3 & r17
        L_0x0132:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x0137
            r3 = r3 & r4
        L_0x0137:
            r18 = r35
        L_0x0139:
            r19 = r5
            r20 = r7
            r21 = r8
            r23 = r13
            r25 = r15
            goto L_0x0185
        L_0x0144:
            if (r37 == 0) goto L_0x014b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x014b:
            if (r6 == 0) goto L_0x0152
            androidx.compose.ui.graphics.Shape r0 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r7 = r0
        L_0x0152:
            r0 = r12 & 8
            r6 = 6
            if (r0 == 0) goto L_0x015f
            androidx.compose.material3.DrawerDefaults r0 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r8 = r0.getStandardContainerColor(r2, r6)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x015f:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x016e
            int r0 = r3 >> 9
            r0 = r0 & 14
            long r13 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r8, r2, r0)
            r0 = r3 & r17
            r3 = r0
        L_0x016e:
            if (r10 == 0) goto L_0x0177
            androidx.compose.material3.DrawerDefaults r0 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r0 = r0.m2036getDismissibleDrawerElevationD9Ej5fM()
            r15 = r0
        L_0x0177:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x0137
            androidx.compose.material3.DrawerDefaults r0 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r0 = r0.getWindowInsets(r2, r6)
            r3 = r3 & r4
            r18 = r0
            goto L_0x0139
        L_0x0185:
            r2.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0197
            r0 = -1
            java.lang.String r4 = "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:699)"
            r5 = 1473549901(0x57d4964d, float:4.67484004E14)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r0, r4)
        L_0x0197:
            androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$2 r17 = new androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$2
            r26 = r36
            r17.<init>(r18, r19, r20, r21, r23, r25, r26)
            r0 = r17
            r4 = 54
            r5 = -807955710(0xffffffffcfd79302, float:-7.2334715E9)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r6, r0, r2, r4)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r3 = r3 & 14
            r3 = r3 | 48
            androidx.compose.material3.NavigationDrawer_androidKt.DrawerPredictiveBackHandler(r1, r0, r2, r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01bc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01bc:
            r9 = r18
            r3 = r20
            r4 = r21
            r6 = r23
            r8 = r25
        L_0x01c6:
            androidx.compose.runtime.ScopeUpdateScope r13 = r2.endRestartGroup()
            if (r13 == 0) goto L_0x01da
            androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$3 r0 = new androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$3
            r10 = r36
            r2 = r19
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2257DismissibleDrawerSheetSnr_uVM(androidx.compose.material3.DrawerState, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f5  */
    /* renamed from: PermanentDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2263PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier r24, androidx.compose.ui.graphics.Shape r25, long r26, long r28, float r30, androidx.compose.foundation.layout.WindowInsets r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r10 = r34
            r0 = -1733353241(0xffffffff98af20e7, float:-4.5269663E-24)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(PermanentDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)734@30666L22,735@30722L37,737@30881L12,740@30972L33,744@31114L30,741@31010L266:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r35 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r10 | 6
            r4 = r3
            r3 = r24
            goto L_0x002e
        L_0x001a:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r24
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r10
            goto L_0x002e
        L_0x002b:
            r3 = r24
            r4 = r10
        L_0x002e:
            r5 = r35 & 2
            if (r5 == 0) goto L_0x0035
            r4 = r4 | 48
            goto L_0x0048
        L_0x0035:
            r6 = r10 & 48
            if (r6 != 0) goto L_0x0048
            r6 = r25
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0044
            r7 = 32
            goto L_0x0046
        L_0x0044:
            r7 = 16
        L_0x0046:
            r4 = r4 | r7
            goto L_0x004a
        L_0x0048:
            r6 = r25
        L_0x004a:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0063
            r7 = r35 & 4
            if (r7 != 0) goto L_0x005d
            r7 = r26
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005d:
            r7 = r26
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r4 = r4 | r9
            goto L_0x0065
        L_0x0063:
            r7 = r26
        L_0x0065:
            r9 = r10 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007c
            r9 = r35 & 8
            r11 = r28
            if (r9 != 0) goto L_0x0078
            boolean r9 = r1.changed((long) r11)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r4 = r4 | r9
            goto L_0x007e
        L_0x007c:
            r11 = r28
        L_0x007e:
            r9 = r35 & 16
            if (r9 == 0) goto L_0x0085
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0085:
            r13 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0098
            r13 = r30
            boolean r14 = r1.changed((float) r13)
            if (r14 == 0) goto L_0x0094
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r4 = r4 | r14
            goto L_0x009a
        L_0x0098:
            r13 = r30
        L_0x009a:
            r14 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b4
            r14 = r35 & 32
            if (r14 != 0) goto L_0x00ae
            r14 = r31
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r14 = r31
        L_0x00b0:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r4 = r4 | r15
            goto L_0x00b6
        L_0x00b4:
            r14 = r31
        L_0x00b6:
            r15 = r35 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bf
            r4 = r4 | r16
            goto L_0x00d3
        L_0x00bf:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d3
            r15 = r32
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00ce
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r4 = r4 | r16
            goto L_0x00d5
        L_0x00d3:
            r15 = r32
        L_0x00d5:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r4 & r16
            r33 = r2
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r2) goto L_0x00f5
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e8
            goto L_0x00f5
        L_0x00e8:
            r1.skipToGroupEnd()
            r21 = r1
            r1 = r3
            r2 = r6
            r3 = r7
            r5 = r11
            r7 = r13
            r8 = r14
            goto L_0x01f6
        L_0x00f5:
            r1.startDefaults()
            r0 = r10 & 1
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r2 = 6
            if (r0 == 0) goto L_0x0128
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0107
            goto L_0x0128
        L_0x0107:
            r1.skipToGroupEnd()
            r0 = r35 & 4
            if (r0 == 0) goto L_0x0110
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0110:
            r0 = r35 & 8
            if (r0 == 0) goto L_0x0116
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0116:
            r0 = r35 & 32
            if (r0 == 0) goto L_0x011c
            r4 = r4 & r16
        L_0x011c:
            r0 = r3
        L_0x011d:
            r15 = r7
            r17 = r11
            r19 = r13
            r12 = r14
            r3 = -1733353241(0xffffffff98af20e7, float:-4.5269663E-24)
            r14 = r6
            goto L_0x0171
        L_0x0128:
            if (r33 == 0) goto L_0x012f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0130
        L_0x012f:
            r0 = r3
        L_0x0130:
            if (r5 == 0) goto L_0x0137
            androidx.compose.ui.graphics.Shape r3 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r6 = r3
        L_0x0137:
            r3 = r35 & 4
            if (r3 == 0) goto L_0x0143
            androidx.compose.material3.DrawerDefaults r3 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r7 = r3.getStandardContainerColor(r1, r2)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0143:
            r3 = r35 & 8
            if (r3 == 0) goto L_0x0152
            int r3 = r4 >> 6
            r3 = r3 & 14
            long r11 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r7, r1, r3)
            r3 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            r4 = r3
        L_0x0152:
            if (r9 == 0) goto L_0x015b
            androidx.compose.material3.DrawerDefaults r3 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r3 = r3.m2039getPermanentDrawerElevationD9Ej5fM()
            r13 = r3
        L_0x015b:
            r3 = r35 & 32
            if (r3 == 0) goto L_0x011d
            androidx.compose.material3.DrawerDefaults r3 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r2)
            r4 = r4 & r16
            r14 = r6
            r15 = r7
            r17 = r11
            r19 = r13
            r12 = r3
            r3 = -1733353241(0xffffffff98af20e7, float:-4.5269663E-24)
        L_0x0171:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0180
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:739)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r4, r5, r6)
        L_0x0180:
            androidx.compose.material3.internal.Strings$Companion r3 = androidx.compose.material3.internal.Strings.Companion
            int r3 = androidx.compose.ui.R.string.navigation_menu
            int r3 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r3)
            r5 = 0
            java.lang.String r3 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r3, r1, r5)
            r6 = 391082081(0x174f7061, float:6.702715E-25)
            java.lang.String r7 = "CC(remember):NavigationDrawer.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r6, r7)
            boolean r6 = r1.changed((java.lang.Object) r3)
            java.lang.Object r7 = r1.rememberedValue()
            if (r6 != 0) goto L_0x01a7
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x01b2
        L_0x01a7:
            androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1 r6 = new androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
            r6.<init>(r3)
            r7 = r6
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r1.updateRememberedValue(r7)
        L_0x01b2:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r3 = 0
            r6 = 1
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r5, r7, r6, r3)
            int r3 = r4 >> 12
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            int r3 = r4 << 6
            r5 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r5
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r3
            r2 = r2 | r5
            r5 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r3
            r2 = r2 | r5
            r5 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r5
            r2 = r2 | r3
            int r3 = r4 << 3
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r4
            r22 = r2 | r3
            r23 = 0
            r11 = 0
            r20 = r32
            r21 = r1
            m2259DrawerSheet7zSek6w(r11, r12, r13, r14, r15, r17, r19, r20, r21, r22, r23)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01ee
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ee:
            r1 = r0
            r8 = r12
            r2 = r14
            r3 = r15
            r5 = r17
            r7 = r19
        L_0x01f6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r21.endRestartGroup()
            if (r12 == 0) goto L_0x020a
            androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2 r0 = new androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2
            r9 = r32
            r11 = r35
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x020a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2263PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0105  */
    /* renamed from: DrawerSheet-7zSek6w  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2259DrawerSheet7zSek6w(androidx.compose.material3.DrawerPredictiveBackState r27, androidx.compose.foundation.layout.WindowInsets r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, float r35, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r1 = r27
            r2 = r28
            r10 = r36
            r11 = r38
            r12 = r39
            r0 = -151557245(0xfffffffff6f76b83, float:-2.5091366E33)
            r3 = r37
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(DrawerSheet)P(3,7,6,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp)759@31534L22,760@31590L37,764@31790L7,779@32434L545,769@32027L952:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r12 & 1
            if (r4 == 0) goto L_0x001f
            r4 = r11 | 6
            goto L_0x002f
        L_0x001f:
            r4 = r11 & 6
            if (r4 != 0) goto L_0x002e
            boolean r4 = r3.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x002b
            r4 = 4
            goto L_0x002c
        L_0x002b:
            r4 = 2
        L_0x002c:
            r4 = r4 | r11
            goto L_0x002f
        L_0x002e:
            r4 = r11
        L_0x002f:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x0036
            r4 = r4 | 48
            goto L_0x0046
        L_0x0036:
            r5 = r11 & 48
            if (r5 != 0) goto L_0x0046
            boolean r5 = r3.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r4 = r4 | r5
        L_0x0046:
            r5 = r12 & 4
            if (r5 == 0) goto L_0x004d
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r6 = r11 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0060
            r6 = r29
            boolean r7 = r3.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005c
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r4 = r4 | r7
            goto L_0x0062
        L_0x0060:
            r6 = r29
        L_0x0062:
            r7 = r12 & 8
            if (r7 == 0) goto L_0x0069
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r8 = r11 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007c
            r8 = r30
            boolean r9 = r3.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r4 = r4 | r9
            goto L_0x007e
        L_0x007c:
            r8 = r30
        L_0x007e:
            r9 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0095
            r9 = r12 & 16
            r13 = r31
            if (r9 != 0) goto L_0x0091
            boolean r9 = r3.changed((long) r13)
            if (r9 == 0) goto L_0x0091
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r4 = r4 | r9
            goto L_0x0097
        L_0x0095:
            r13 = r31
        L_0x0097:
            r9 = 196608(0x30000, float:2.75506E-40)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00af
            r9 = r12 & 32
            r0 = r33
            if (r9 != 0) goto L_0x00ab
            boolean r15 = r3.changed((long) r0)
            if (r15 == 0) goto L_0x00ab
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ad
        L_0x00ab:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00ad:
            r4 = r4 | r15
            goto L_0x00b1
        L_0x00af:
            r0 = r33
        L_0x00b1:
            r15 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bc
            r4 = r4 | r16
            r9 = r35
            goto L_0x00cf
        L_0x00bc:
            r16 = r11 & r16
            r9 = r35
            if (r16 != 0) goto L_0x00cf
            boolean r16 = r3.changed((float) r9)
            if (r16 == 0) goto L_0x00cb
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r4 = r4 | r16
        L_0x00cf:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r1 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00d7
            r4 = r4 | r1
            goto L_0x00e7
        L_0x00d7:
            r0 = r11 & r1
            if (r0 != 0) goto L_0x00e7
            boolean r0 = r3.changedInstance(r10)
            if (r0 == 0) goto L_0x00e4
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e6
        L_0x00e4:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e6:
            r4 = r4 | r0
        L_0x00e7:
            r0 = 4793491(0x492493, float:6.717112E-39)
            r0 = r0 & r4
            r16 = r1
            r1 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r1) goto L_0x0105
            boolean r0 = r3.getSkipping()
            if (r0 != 0) goto L_0x00f9
            goto L_0x0105
        L_0x00f9:
            r3.skipToGroupEnd()
            r23 = r3
            r3 = r6
            r4 = r8
            r5 = r13
            r7 = r33
            goto L_0x0221
        L_0x0105:
            r3.startDefaults()
            r0 = r11 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = 6
            if (r0 == 0) goto L_0x0132
            boolean r0 = r3.getDefaultsInvalid()
            if (r0 == 0) goto L_0x011a
            goto L_0x0132
        L_0x011a:
            r3.skipToGroupEnd()
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0123
            r4 = r4 & r17
        L_0x0123:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0129
            r4 = r4 & r18
        L_0x0129:
            r17 = r33
            r19 = r9
        L_0x012d:
            r0 = r16
        L_0x012f:
            r15 = r13
            r14 = r8
            goto L_0x0172
        L_0x0132:
            if (r5 == 0) goto L_0x0139
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x0139:
            if (r7 == 0) goto L_0x0140
            androidx.compose.ui.graphics.Shape r0 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r8 = r0
        L_0x0140:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x014c
            androidx.compose.material3.DrawerDefaults r0 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r13 = r0.getStandardContainerColor(r3, r1)
            r4 = r4 & r17
        L_0x014c:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x015c
            int r0 = r4 >> 12
            r0 = r0 & 14
            long r19 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r13, r3, r0)
            r0 = r4 & r18
            r4 = r0
            goto L_0x015e
        L_0x015c:
            r19 = r33
        L_0x015e:
            if (r15 == 0) goto L_0x016b
            androidx.compose.material3.DrawerDefaults r0 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r0 = r0.m2039getPermanentDrawerElevationD9Ej5fM()
            r17 = r19
            r19 = r0
            goto L_0x012d
        L_0x016b:
            r0 = r16
            r17 = r19
            r19 = r9
            goto L_0x012f
        L_0x0172:
            r3.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0184
            r5 = -1
            java.lang.String r7 = "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:763)"
            r9 = -151557245(0xfffffffff6f76b83, float:-2.5091366E33)
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r4, r5, r7)
        L_0x0184:
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r7, r8)
            java.lang.Object r5 = r3.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.LayoutDirection r7 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r8 = 1
            if (r5 != r7) goto L_0x01a0
            r5 = r8
            goto L_0x01a1
        L_0x01a0:
            r5 = 0
        L_0x01a1:
            if (r27 == 0) goto L_0x01ae
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r9 = r27
            androidx.compose.ui.Modifier r7 = predictiveBackDrawerContainer(r7, r9, r5)
            goto L_0x01b4
        L_0x01ae:
            r9 = r27
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
        L_0x01b4:
            float r13 = MinimumDrawerWidth
            androidx.compose.material3.DrawerDefaults r20 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r20 = r20.m2037getMaximumDrawerWidthD9Ej5fM()
            r21 = 10
            r22 = 0
            r23 = 0
            r24 = 0
            r29 = r6
            r30 = r13
            r32 = r20
            r34 = r21
            r35 = r22
            r31 = r23
            r33 = r24
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m849sizeInqDBjuR0$default(r29, r30, r31, r32, r33, r34, r35)
            r26 = r29
            androidx.compose.ui.Modifier r6 = r6.then(r7)
            r7 = 0
            r13 = 0
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r6, r7, r8, r13)
            androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1 r6 = new androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
            r6.<init>(r9, r5, r2, r10)
            r5 = 54
            r7 = 669057502(0x27e101de, float:6.245207E-15)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r8, r6, r3, r5)
            r22 = r5
            kotlin.jvm.functions.Function2 r22 = (kotlin.jvm.functions.Function2) r22
            int r1 = r4 >> 6
            r4 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r4
            r4 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r4
            r4 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r4
            r24 = r0 | r1
            r25 = 96
            r20 = 0
            r21 = 0
            r23 = r3
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24, r25)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0219
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0219:
            r4 = r14
            r5 = r15
            r7 = r17
            r9 = r19
            r3 = r26
        L_0x0221:
            androidx.compose.runtime.ScopeUpdateScope r13 = r23.endRestartGroup()
            if (r13 == 0) goto L_0x0233
            androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2 r0 = new androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2
            r1 = r27
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0233:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2259DrawerSheet7zSek6w(androidx.compose.material3.DrawerPredictiveBackState, androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Modifier predictiveBackDrawerContainer(Modifier modifier, DrawerPredictiveBackState drawerPredictiveBackState, boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new NavigationDrawerKt$predictiveBackDrawerContainer$1(drawerPredictiveBackState, z));
    }

    /* access modifiers changed from: private */
    public static final Modifier predictiveBackDrawerChild(Modifier modifier, DrawerPredictiveBackState drawerPredictiveBackState, boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new NavigationDrawerKt$predictiveBackDrawerChild$1(drawerPredictiveBackState, z));
    }

    /* access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, DrawerPredictiveBackState drawerPredictiveBackState) {
        float r2 = Size.m4056getWidthimpl(graphicsLayerScope.m4427getSizeNHjbRc());
        if (Float.isNaN(r2) || r2 == 0.0f) {
            return 1.0f;
        }
        return ((drawerPredictiveBackState.getScaleXDistance() * ((float) (drawerPredictiveBackState.getSwipeEdgeMatchesDrawer() ? 1 : -1))) / r2) + 1.0f;
    }

    /* access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, DrawerPredictiveBackState drawerPredictiveBackState) {
        float r2 = Size.m4053getHeightimpl(graphicsLayerScope.m4427getSizeNHjbRc());
        if (Float.isNaN(r2) || r2 == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (drawerPredictiveBackState.getScaleYDistance() / r2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavigationDrawerItem(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, boolean r33, kotlin.jvm.functions.Function0<kotlin.Unit> r34, androidx.compose.ui.Modifier r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.ui.graphics.Shape r38, androidx.compose.material3.NavigationDrawerItemColors r39, androidx.compose.foundation.interaction.MutableInteractionSource r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r0 = r33
            r1 = r42
            r2 = r43
            r3 = -1304626543(0xffffffffb23cfa91, float:-1.10000125E-8)
            r4 = r41
            androidx.compose.runtime.Composer r14 = r4.startRestartGroup(r3)
            java.lang.String r4 = "C(NavigationDrawerItem)P(4,7,6,5,2!1,8)925@38341L5,926@38418L8,938@38801L24,940@38886L884,929@38492L1278:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            r4 = r2 & 1
            if (r4 == 0) goto L_0x001e
            r4 = r1 | 6
            r6 = r4
            r4 = r32
            goto L_0x0032
        L_0x001e:
            r4 = r1 & 6
            if (r4 != 0) goto L_0x002f
            r4 = r32
            boolean r6 = r14.changedInstance(r4)
            if (r6 == 0) goto L_0x002c
            r6 = 4
            goto L_0x002d
        L_0x002c:
            r6 = 2
        L_0x002d:
            r6 = r6 | r1
            goto L_0x0032
        L_0x002f:
            r4 = r32
            r6 = r1
        L_0x0032:
            r7 = r2 & 2
            if (r7 == 0) goto L_0x0039
            r6 = r6 | 48
            goto L_0x0049
        L_0x0039:
            r7 = r1 & 48
            if (r7 != 0) goto L_0x0049
            boolean r7 = r14.changed((boolean) r0)
            if (r7 == 0) goto L_0x0046
            r7 = 32
            goto L_0x0048
        L_0x0046:
            r7 = 16
        L_0x0048:
            r6 = r6 | r7
        L_0x0049:
            r7 = r2 & 4
            if (r7 == 0) goto L_0x0050
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r7 = r1 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0063
            r7 = r34
            boolean r8 = r14.changedInstance(r7)
            if (r8 == 0) goto L_0x005f
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r6 = r6 | r8
            goto L_0x0065
        L_0x0063:
            r7 = r34
        L_0x0065:
            r8 = r2 & 8
            if (r8 == 0) goto L_0x006c
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r9 = r1 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007f
            r9 = r35
            boolean r10 = r14.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x007b
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r6 = r6 | r10
            goto L_0x0081
        L_0x007f:
            r9 = r35
        L_0x0081:
            r10 = r2 & 16
            if (r10 == 0) goto L_0x0088
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r11 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009b
            r11 = r36
            boolean r12 = r14.changedInstance(r11)
            if (r12 == 0) goto L_0x0097
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r6 = r6 | r12
            goto L_0x009d
        L_0x009b:
            r11 = r36
        L_0x009d:
            r12 = r2 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a5
            r6 = r6 | r13
            goto L_0x00b7
        L_0x00a5:
            r13 = r13 & r1
            if (r13 != 0) goto L_0x00b7
            r13 = r37
            boolean r15 = r14.changedInstance(r13)
            if (r15 == 0) goto L_0x00b3
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r6 = r6 | r15
            goto L_0x00b9
        L_0x00b7:
            r13 = r37
        L_0x00b9:
            r15 = 1572864(0x180000, float:2.204052E-39)
            r15 = r15 & r1
            if (r15 != 0) goto L_0x00d4
            r15 = r2 & 64
            if (r15 != 0) goto L_0x00cd
            r15 = r38
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00cf
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cd:
            r15 = r38
        L_0x00cf:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r6 = r6 | r16
            goto L_0x00d6
        L_0x00d4:
            r15 = r38
        L_0x00d6:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r1 & r16
            if (r16 != 0) goto L_0x00f2
            r5 = r2 & 128(0x80, float:1.794E-43)
            if (r5 != 0) goto L_0x00eb
            r5 = r39
            boolean r16 = r14.changed((java.lang.Object) r5)
            if (r16 == 0) goto L_0x00ed
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r5 = r39
        L_0x00ed:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r6 = r6 | r16
            goto L_0x00f4
        L_0x00f2:
            r5 = r39
        L_0x00f4:
            r3 = r2 & 256(0x100, float:3.59E-43)
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            if (r3 == 0) goto L_0x00ff
            r6 = r6 | r16
            r5 = r40
            goto L_0x0112
        L_0x00ff:
            r16 = r1 & r16
            r5 = r40
            if (r16 != 0) goto L_0x0112
            boolean r16 = r14.changed((java.lang.Object) r5)
            if (r16 == 0) goto L_0x010e
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0110
        L_0x010e:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0110:
            r6 = r6 | r16
        L_0x0112:
            r16 = 38347923(0x2492493, float:1.4777644E-37)
            r1 = r6 & r16
            r24 = r3
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r1 != r3) goto L_0x0133
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x0125
            goto L_0x0133
        L_0x0125:
            r14.skipToGroupEnd()
            r8 = r39
            r4 = r9
            r6 = r13
            r21 = r14
            r7 = r15
            r9 = r5
            r5 = r11
            goto L_0x0266
        L_0x0133:
            r14.startDefaults()
            r1 = r42 & 1
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r25 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = 0
            if (r1 == 0) goto L_0x0160
            boolean r1 = r14.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0148
            goto L_0x0160
        L_0x0148:
            r14.skipToGroupEnd()
            r1 = r2 & 64
            if (r1 == 0) goto L_0x0151
            r6 = r6 & r16
        L_0x0151:
            r1 = r2 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0157
            r6 = r6 & r25
        L_0x0157:
            r12 = r5
            r1 = r9
            r27 = r13
            r4 = r15
            r5 = r39
            goto L_0x01c3
        L_0x0160:
            if (r8 == 0) goto L_0x0167
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0168
        L_0x0167:
            r1 = r9
        L_0x0168:
            if (r10 == 0) goto L_0x016d
            r26 = r3
            goto L_0x016f
        L_0x016d:
            r26 = r11
        L_0x016f:
            if (r12 == 0) goto L_0x0174
            r27 = r3
            goto L_0x0176
        L_0x0174:
            r27 = r13
        L_0x0176:
            r8 = r2 & 64
            if (r8 == 0) goto L_0x018a
            androidx.compose.material3.tokens.NavigationDrawerTokens r8 = androidx.compose.material3.tokens.NavigationDrawerTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r8 = r8.getActiveIndicatorShape()
            r9 = 6
            androidx.compose.ui.graphics.Shape r8 = androidx.compose.material3.ShapesKt.getValue(r8, r14, r9)
            r6 = r6 & r16
            r28 = r8
            goto L_0x018c
        L_0x018a:
            r28 = r15
        L_0x018c:
            r29 = r6
            r6 = r2 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x01b4
            androidx.compose.material3.NavigationDrawerItemDefaults r4 = androidx.compose.material3.NavigationDrawerItemDefaults.INSTANCE
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            r23 = 255(0xff, float:3.57E-43)
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r21 = r14
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            androidx.compose.material3.NavigationDrawerItemColors r4 = r4.m2256colorsoq7We08(r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r23)
            r14 = r21
            r5 = r29 & r25
            r6 = r5
            goto L_0x01b8
        L_0x01b4:
            r4 = r39
            r6 = r29
        L_0x01b8:
            if (r24 == 0) goto L_0x01bc
            r12 = r3
            goto L_0x01be
        L_0x01bc:
            r12 = r40
        L_0x01be:
            r5 = r4
            r11 = r26
            r4 = r28
        L_0x01c3:
            r14.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x01d5
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:928)"
            r9 = -1304626543(0xffffffffb23cfa91, float:-1.10000125E-8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r6, r7, r8)
        L_0x01d5:
            androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$1 r7 = androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$1.INSTANCE
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8 = 0
            r9 = 1
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r8, r7, r9, r3)
            androidx.compose.material3.tokens.NavigationDrawerTokens r8 = androidx.compose.material3.tokens.NavigationDrawerTokens.INSTANCE
            float r8 = r8.m3345getActiveIndicatorHeightD9Ej5fM()
            r10 = 0
            r13 = 2
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m833heightInVpY3zN4$default(r7, r8, r10, r13, r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r7, r10, r9, r3)
            int r7 = r6 >> 3
            r8 = r7 & 14
            int r10 = r6 >> 18
            r10 = r10 & 112(0x70, float:1.57E-43)
            r8 = r8 | r10
            androidx.compose.runtime.State r8 = r5.containerColor(r0, r14, r8)
            java.lang.Object r8 = r8.getValue()
            androidx.compose.ui.graphics.Color r8 = (androidx.compose.ui.graphics.Color) r8
            long r15 = r8.m4249unboximpl()
            androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2 r8 = new androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
            r40 = r32
            r38 = r0
            r37 = r5
            r35 = r8
            r36 = r11
            r39 = r27
            r35.<init>(r36, r37, r38, r39, r40)
            r0 = r35
            r26 = r36
            r18 = r37
            r5 = 54
            r8 = 191488423(0xb69e1a7, float:4.504393E-32)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r8, r9, r0, r14, r5)
            r13 = r0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r0 = r7 & 126(0x7e, float:1.77E-43)
            int r5 = r6 >> 6
            r7 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r7
            r0 = r0 | r5
            int r5 = r6 >> 24
            r5 = r5 & 14
            r5 = r5 | 48
            r17 = 968(0x3c8, float:1.356E-42)
            r2 = r3
            r3 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r30 = r15
            r16 = r5
            r5 = r30
            r15 = r0
            r19 = r1
            r0 = r33
            r1 = r34
            androidx.compose.material3.SurfaceKt.m2537Surfaced85dljk((boolean) r0, (kotlin.jvm.functions.Function0<kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (androidx.compose.ui.graphics.Shape) r4, (long) r5, (long) r7, (float) r9, (float) r10, (androidx.compose.foundation.BorderStroke) r11, (androidx.compose.foundation.interaction.MutableInteractionSource) r12, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16, (int) r17)
            r21 = r14
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x025c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x025c:
            r7 = r4
            r9 = r12
            r8 = r18
            r4 = r19
            r5 = r26
            r6 = r27
        L_0x0266:
            androidx.compose.runtime.ScopeUpdateScope r12 = r21.endRestartGroup()
            if (r12 == 0) goto L_0x0280
            androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3 r0 = new androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
            r1 = r32
            r2 = r33
            r3 = r34
            r10 = r42
            r11 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0280:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem(kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.NavigationDrawerItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-Bx497Mc  reason: not valid java name */
    public static final void m2264ScrimBx497Mc(boolean z, Function0<Unit> function0, Function0<Float> function02, long j, Composer composer, int i) {
        int i2;
        Modifier modifier;
        int i3;
        boolean z2 = z;
        Function0<Unit> function03 = function0;
        Function0<Float> function04 = function02;
        long j2 = j;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(2106487387);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)1136@46594L30,1151@47092L39,1151@47041L90:NavigationDrawer.kt#uh7d8r");
        if ((i4 & 6) == 0) {
            i2 = (startRestartGroup.changed(z2) ? 4 : 2) | i4;
        } else {
            i2 = i4;
        }
        if ((i4 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function03) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function04) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106487387, i2, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:1135)");
            }
            Strings.Companion companion = Strings.Companion;
            String r0 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.close_drawer), startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(-1784754787);
            ComposerKt.sourceInformation(startRestartGroup, "1139@46712L35,1140@46800L187");
            if (z2) {
                Modifier modifier2 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1784753370, "CC(remember):NavigationDrawer.kt#9igjgp");
                int i5 = i2 & 112;
                boolean z3 = i5 == 32;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(function03, (Continuation<? super NavigationDrawerKt$Scrim$dismissDrawer$1$1>) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier2, (Object) function03, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1784750402, "CC(remember):NavigationDrawer.kt#9igjgp");
                boolean changed = (i5 == 32) | startRestartGroup.changed((Object) r0);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new NavigationDrawerKt$Scrim$dismissDrawer$2$1(r0, function03);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                i3 = 1;
                modifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
            } else {
                i3 = 1;
                modifier = Modifier.Companion;
            }
            startRestartGroup.endReplaceGroup();
            Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, i3, (Object) null).then(modifier);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1784741206, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i6 = ((i2 & 7168) == 2048 ? i3 : 0) | ((i2 & 896) == 256 ? i3 : 0);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (i6 != 0 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new NavigationDrawerKt$Scrim$1$1(j2, function04);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationDrawerKt$Scrim$2(z2, function03, function04, j2, i4));
        }
    }

    /* access modifiers changed from: private */
    public static final void ModalNavigationDrawer_FHprtrg$lambda$6(MutableFloatState mutableFloatState, float f) {
        mutableFloatState.setFloatValue(f);
    }
}
