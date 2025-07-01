package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00140(¢\u0006\u0002\b*¢\u0006\u0002\b+H\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u0001\u0010.\u001a\u00020\u00142\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u001400¢\u0006\u0002\b*2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u0014002\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u000100¢\u0006\u0002\b*2\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u000100¢\u0006\u0002\b*2\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0001¢\u0006\u0002\u0010;\u001a\u001d\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0000¢\u0006\u0002\u0010@\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u0010\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0010\u001a\u00020\u0004X\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0011\u0010\n\"\u000e\u0010\u0012\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A²\u0006\n\u0010B\u001a\u00020\u0001X\u0002²\u0006\n\u0010C\u001a\u00020\u0001X\u0002"}, d2 = {"ClosedAlphaTarget", "", "ClosedScaleTarget", "DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "ExpandedAlphaTarget", "ExpandedScaleTarget", "InTransitionDuration", "", "MenuListItemContainerHeight", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "expandedState", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenuContent-Qj0Zi0g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DropdownMenuItemContent", "text", "Lkotlin/Function0;", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material3_release", "scale", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Menu.kt */
public final class MenuKt {
    public static final float ClosedAlphaTarget = 0.0f;
    public static final float ClosedScaleTarget = 0.8f;
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m7111constructorimpl((float) 280);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m7111constructorimpl((float) 112);
    /* access modifiers changed from: private */
    public static final float DropdownMenuItemHorizontalPadding = Dp.m7111constructorimpl((float) 12);
    private static final float DropdownMenuVerticalPadding = Dp.m7111constructorimpl((float) 8);
    public static final float ExpandedAlphaTarget = 1.0f;
    public static final float ExpandedScaleTarget = 1.0f;
    public static final int InTransitionDuration = 120;
    private static final float MenuListItemContainerHeight;
    private static final float MenuVerticalMargin;
    public static final int OutTransitionDuration = 75;

    /* renamed from: DropdownMenuContent-Qj0Zi0g  reason: not valid java name */
    public static final void m2216DropdownMenuContentQj0Zi0g(Modifier modifier, MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, ScrollState scrollState, Shape shape, long j, float f, float f2, BorderStroke borderStroke, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i) {
        int i2;
        Composer composer2;
        boolean z;
        int i3;
        Function1 function1;
        Modifier modifier2 = modifier;
        MutableTransitionState<Boolean> mutableTransitionState2 = mutableTransitionState;
        ScrollState scrollState2 = scrollState;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(-151448888);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenuContent)P(4,3,9,5,7,1:c#ui.graphics.Color,8:c#ui.unit.Dp,6:c#ui.unit.Dp)376@17481L47,379@17566L531,394@18135L460,408@18640L7,411@18715L587,428@19474L276,409@18652L1098:Menu.kt#uh7d8r");
        if ((i4 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i4;
        } else {
            i2 = i4;
        }
        if ((i4 & 48) == 0) {
            i2 |= (i4 & 64) == 0 ? startRestartGroup.changed((Object) mutableTransitionState2) : startRestartGroup.changedInstance(mutableTransitionState2) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableState) ? 256 : 128;
        } else {
            MutableState<TransformOrigin> mutableState2 = mutableState;
        }
        if ((i4 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) scrollState2) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i2 |= startRestartGroup.changed((Object) shape) ? 16384 : 8192;
        } else {
            Shape shape2 = shape;
        }
        long j2 = j;
        if ((196608 & i4) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if ((1572864 & i4) == 0) {
            i2 |= startRestartGroup.changed(f) ? 1048576 : 524288;
        } else {
            float f3 = f;
        }
        if ((i4 & 12582912) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
        } else {
            float f4 = f2;
        }
        BorderStroke borderStroke2 = borderStroke;
        if ((i4 & 100663296) == 0) {
            i2 |= startRestartGroup.changed((Object) borderStroke2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i4 & 805306368) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-151448888, i2, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:374)");
            }
            Transition<T> updateTransition = TransitionKt.updateTransition(mutableTransitionState2, "DropDownMenu", startRestartGroup, MutableTransitionState.$stable | 48 | ((i2 >> 3) & 14), 0);
            Function3 function33 = MenuKt$DropdownMenuContent$scale$2.INSTANCE;
            Transition<T> transition = updateTransition;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
            boolean booleanValue = ((Boolean) transition.getCurrentState()).booleanValue();
            startRestartGroup.startReplaceGroup(2139028452);
            ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2139028452, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:390)");
            }
            float f5 = booleanValue ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            Float valueOf = Float.valueOf(f5);
            boolean booleanValue2 = ((Boolean) transition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceGroup(2139028452);
            ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                z = booleanValue2;
                ComposerKt.traceEventStart(2139028452, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:390)");
            } else {
                z = booleanValue2;
            }
            float f6 = z ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            Transition<T> transition2 = transition;
            State<Float> createTransitionAnimation = TransitionKt.createTransitionAnimation(transition2, valueOf, Float.valueOf(f6), (FiniteAnimationSpec) function33.invoke(transition.getSegment(), startRestartGroup, 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Function3 function34 = MenuKt$DropdownMenuContent$alpha$2.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
            boolean booleanValue3 = ((Boolean) transition2.getCurrentState()).booleanValue();
            startRestartGroup.startReplaceGroup(-249413128);
            ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249413128, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:405)");
            }
            float f7 = booleanValue3 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            Float valueOf2 = Float.valueOf(f7);
            boolean booleanValue4 = ((Boolean) transition2.getTargetState()).booleanValue();
            startRestartGroup.startReplaceGroup(-249413128);
            ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249413128, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:405)");
            }
            float f8 = booleanValue4 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            boolean z2 = false;
            Composer composer3 = startRestartGroup;
            State<Float> createTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition2, valueOf2, Float.valueOf(f8), (FiniteAnimationSpec) function34.invoke(transition2.getSegment(), startRestartGroup, 0), vectorConverter2, "FloatAnimation", composer3, 0);
            Composer composer4 = composer3;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer4.consume(InspectionModeKt.getLocalInspectionMode());
            ComposerKt.sourceInformationMarkerEnd(composer4);
            boolean booleanValue5 = ((Boolean) consume).booleanValue();
            Modifier modifier3 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer4, 526637745, "CC(remember):Menu.kt#9igjgp");
            boolean changed = composer4.changed(booleanValue5) | composer4.changed((Object) createTransitionAnimation) | ((i2 & 112) == 32 || ((i2 & 64) != 0 && composer4.changedInstance(mutableTransitionState2))) | composer4.changed((Object) createTransitionAnimation2);
            if ((i2 & 896) == 256) {
                z2 = true;
            }
            boolean z3 = changed | z2;
            Object rememberedValue = composer4.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                i3 = i2;
                function1 = new MenuKt$DropdownMenuContent$1$1(booleanValue5, mutableTransitionState2, mutableState, createTransitionAnimation, createTransitionAnimation2);
                composer4.updateRememberedValue(function1);
            } else {
                function1 = rememberedValue;
                i3 = i2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            int i5 = i3 >> 9;
            int i6 = i3 >> 6;
            Composer composer5 = composer4;
            SurfaceKt.m2536SurfaceT9BRK9s(GraphicsLayerModifierKt.graphicsLayer(modifier3, function1), shape, j, 0, f, f2, borderStroke, ComposableLambdaKt.rememberComposableLambda(1573559053, true, new MenuKt$DropdownMenuContent$2(modifier2, scrollState2, function32), composer4, 54), composer5, (i5 & 896) | (i5 & 112) | 12582912 | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 8);
            composer2 = composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MenuKt$DropdownMenuContent$3(modifier2, mutableTransitionState, mutableState, scrollState, shape, j, f, f2, borderStroke, function32, i));
        }
    }

    public static final void DropdownMenuItemContent(Function2<? super Composer, ? super Integer, Unit> function2, Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, int i) {
        int i2;
        PaddingValues paddingValues2 = paddingValues;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1564716777);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenuItemContent)P(7,6,5,4,8,2)459@20361L36,452@20118L2520:Menu.kt#uh7d8r");
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function24) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        Function0<Unit> function02 = function0;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        Modifier modifier2 = modifier;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) modifier2) ? 256 : 128;
        }
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 2048 : 1024;
        }
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function26) ? 16384 : 8192;
        }
        boolean z2 = z;
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) menuItemColors) ? 1048576 : 524288;
        } else {
            MenuItemColors menuItemColors2 = menuItemColors;
        }
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) paddingValues2) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableInteractionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1564716777, i2, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:451)");
            }
            Modifier padding = PaddingKt.padding(SizeKt.m849sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m279clickableO2vRcR0$default(modifier2, mutableInteractionSource, RippleKt.m2389rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, 0, startRestartGroup, 6, 6), z, (String) null, (Role) null, function02, 24, (Object) null), 0.0f, 1, (Object) null), DropdownMenuItemDefaultMinWidth, MenuListItemContainerHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, (Object) null), paddingValues2);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
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
            Composer r7 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r7, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r7, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r7.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r7, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1949444430, "C472@20996L10,472@21019L1613,472@20965L1667:Menu.kt#uh7d8r");
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getLabelLarge(), ComposableLambdaKt.rememberComposableLambda(1065051884, true, new MenuKt$DropdownMenuItemContent$1$1(function22, menuItemColors, z, function23, RowScopeInstance.INSTANCE, function24), startRestartGroup, 54), startRestartGroup, 48);
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
            endRestartGroup.updateScope(new MenuKt$DropdownMenuItemContent$2(function2, function0, modifier, function22, function23, z, menuItemColors, paddingValues2, mutableInteractionSource, i3));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long calculateTransformOrigin(androidx.compose.ui.unit.IntRect r5, androidx.compose.ui.unit.IntRect r6) {
        /*
            int r0 = r6.getLeft()
            int r1 = r5.getRight()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r0 < r1) goto L_0x000f
        L_0x000d:
            r0 = r3
            goto L_0x0049
        L_0x000f:
            int r0 = r6.getRight()
            int r1 = r5.getLeft()
            if (r0 > r1) goto L_0x001b
            r0 = r2
            goto L_0x0049
        L_0x001b:
            int r0 = r6.getWidth()
            if (r0 != 0) goto L_0x0022
            goto L_0x000d
        L_0x0022:
            int r0 = r5.getLeft()
            int r1 = r6.getLeft()
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r5.getRight()
            int r4 = r6.getRight()
            int r1 = java.lang.Math.min(r1, r4)
            int r0 = r0 + r1
            int r0 = r0 / 2
            int r1 = r6.getLeft()
            int r0 = r0 - r1
            float r0 = (float) r0
            int r1 = r6.getWidth()
            float r1 = (float) r1
            float r0 = r0 / r1
        L_0x0049:
            int r1 = r6.getTop()
            int r4 = r5.getBottom()
            if (r1 < r4) goto L_0x0055
        L_0x0053:
            r2 = r3
            goto L_0x008f
        L_0x0055:
            int r1 = r6.getBottom()
            int r4 = r5.getTop()
            if (r1 > r4) goto L_0x0060
            goto L_0x008f
        L_0x0060:
            int r1 = r6.getHeight()
            if (r1 != 0) goto L_0x0067
            goto L_0x0053
        L_0x0067:
            int r1 = r5.getTop()
            int r2 = r6.getTop()
            int r1 = java.lang.Math.max(r1, r2)
            int r5 = r5.getBottom()
            int r2 = r6.getBottom()
            int r5 = java.lang.Math.min(r5, r2)
            int r1 = r1 + r5
            int r1 = r1 / 2
            int r5 = r6.getTop()
            int r1 = r1 - r5
            float r5 = (float) r1
            int r6 = r6.getHeight()
            float r6 = (float) r6
            float r2 = r5 / r6
        L_0x008f:
            long r5 = androidx.compose.ui.graphics.TransformOriginKt.TransformOrigin(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MenuKt.calculateTransformOrigin(androidx.compose.ui.unit.IntRect, androidx.compose.ui.unit.IntRect):long");
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    /* access modifiers changed from: private */
    public static final float DropdownMenuContent_Qj0Zi0g$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    public static final float DropdownMenuContent_Qj0Zi0g$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    static {
        float f = (float) 48;
        MenuVerticalMargin = Dp.m7111constructorimpl(f);
        MenuListItemContainerHeight = Dp.m7111constructorimpl(f);
    }
}
