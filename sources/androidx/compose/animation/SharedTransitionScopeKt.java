package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LookaheadScopeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001cH\u0003\u001a5\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\u001c\u0010*\u001a\u0018\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020'0+¢\u0006\u0002\b-¢\u0006\u0002\b.H\u0007¢\u0006\u0002\u0010/\u001a1\u00100\u001a\u00020'2\"\u0010*\u001a\u001e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020'0\u0005¢\u0006\u0002\b-¢\u0006\u0002\b.H\u0007¢\u0006\u0002\u00101\u001a\"\u00102\u001a\u00020)*\u00020)2\u0006\u00103\u001a\u00020\u001d2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u00108\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003\"\u001b\u0010\u0012\u001a\u00020\u00138@X\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\"\u000e\u0010\u0018\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\".\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a0\u001a8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0003\"\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\"\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\"¨\u00065"}, d2 = {"DefaultBoundsTransform", "Landroidx/compose/animation/BoundsTransform;", "getDefaultBoundsTransform$annotations", "()V", "DefaultClipInOverlayDuringTransition", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "DefaultEnabled", "Lkotlin/Function0;", "", "DefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Rect;", "ParentClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "getParentClip$annotations", "SharedTransitionObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getSharedTransitionObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SharedTransitionObserver$delegate", "Lkotlin/Lazy;", "VisualDebugging", "cachedScaleToBoundsImplMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/ContentScale;", "Landroidx/compose/ui/Alignment;", "Landroidx/compose/animation/ScaleToBoundsImpl;", "getCachedScaleToBoundsImplMap$annotations", "shouldCache", "getShouldCache", "(Landroidx/compose/ui/Alignment;)Z", "(Landroidx/compose/ui/layout/ContentScale;)Z", "ScaleToBoundsCached", "contentScale", "alignment", "SharedTransitionLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SharedTransitionScope", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "createContentScaleModifier", "scaleToBounds", "isEnabled", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
public final class SharedTransitionScopeKt {
    /* access modifiers changed from: private */
    public static final BoundsTransform DefaultBoundsTransform = new SharedTransitionScopeKt$$ExternalSyntheticLambda0();
    /* access modifiers changed from: private */
    public static final Function2<LayoutDirection, Density, Path> DefaultClipInOverlayDuringTransition = SharedTransitionScopeKt$DefaultClipInOverlayDuringTransition$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final Function0<Boolean> DefaultEnabled = SharedTransitionScopeKt$DefaultEnabled$1.INSTANCE;
    private static final SpringSpec<Rect> DefaultSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 1, (Object) null);
    /* access modifiers changed from: private */
    public static final SharedTransitionScope.OverlayClip ParentClip = new SharedTransitionScopeKt$ParentClip$1();
    private static final Lazy SharedTransitionObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, SharedTransitionScopeKt$SharedTransitionObserver$2.INSTANCE);
    public static final boolean VisualDebugging = false;
    private static final MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> cachedScaleToBoundsImplMap = new MutableScatterMap<>(0, 1, (DefaultConstructorMarker) null);

    private static /* synthetic */ void getCachedScaleToBoundsImplMap$annotations() {
    }

    private static /* synthetic */ void getDefaultBoundsTransform$annotations() {
    }

    private static /* synthetic */ void getParentClip$annotations() {
    }

    public static final void SharedTransitionLayout(Modifier modifier, Function3<? super SharedTransitionScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(2043053727);
        ComposerKt.sourceInformation(startRestartGroup, "C(SharedTransitionLayout)P(1)112@5418L299,112@5396L321:SharedTransitionScope.kt#xbi5r1");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2043053727, i3, -1, "androidx.compose.animation.SharedTransitionLayout (SharedTransitionScope.kt:111)");
            }
            SharedTransitionScope(ComposableLambdaKt.rememberComposableLambda(-130587847, true, new SharedTransitionScopeKt$SharedTransitionLayout$1(modifier, function3), startRestartGroup, 54), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SharedTransitionScopeKt$SharedTransitionLayout$2(modifier, function3, i, i2));
        }
    }

    public static final void SharedTransitionScope(Function4<? super SharedTransitionScope, ? super Modifier, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-2093217917);
        ComposerKt.sourceInformation(startRestartGroup, "C(SharedTransitionScope)139@6613L1099,139@6598L1114:SharedTransitionScope.kt#xbi5r1");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2093217917, i2, -1, "androidx.compose.animation.SharedTransitionScope (SharedTransitionScope.kt:138)");
            }
            LookaheadScopeKt.LookaheadScope(ComposableLambdaKt.rememberComposableLambda(-863967934, true, new SharedTransitionScopeKt$SharedTransitionScope$1(function4), startRestartGroup, 54), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SharedTransitionScopeKt$SharedTransitionScope$2(function4, i));
        }
    }

    /* access modifiers changed from: private */
    public static final Modifier createContentScaleModifier(Modifier modifier, ScaleToBoundsImpl scaleToBoundsImpl, Function0<Boolean> function0) {
        Modifier modifier2;
        if (Intrinsics.areEqual((Object) scaleToBoundsImpl.getContentScale(), (Object) ContentScale.Companion.getCrop())) {
            modifier2 = GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion, new SharedTransitionScopeKt$createContentScaleModifier$1(function0));
        } else {
            modifier2 = Modifier.Companion;
        }
        return modifier.then(modifier2).then(new SkipToLookaheadElement(scaleToBoundsImpl, function0));
    }

    /* access modifiers changed from: private */
    public static final FiniteAnimationSpec DefaultBoundsTransform$lambda$0(Rect rect, Rect rect2) {
        return DefaultSpring;
    }

    public static final SnapshotStateObserver getSharedTransitionObserver() {
        return (SnapshotStateObserver) SharedTransitionObserver$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final ScaleToBoundsImpl ScaleToBoundsCached(ContentScale contentScale, Alignment alignment) {
        if (!getShouldCache(contentScale) || !getShouldCache(alignment)) {
            return new ScaleToBoundsImpl(contentScale, alignment);
        }
        MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> mutableScatterMap = cachedScaleToBoundsImplMap;
        MutableScatterMap<Alignment, ScaleToBoundsImpl> mutableScatterMap2 = mutableScatterMap.get(contentScale);
        if (mutableScatterMap2 == null) {
            mutableScatterMap2 = new MutableScatterMap<>(0, 1, (DefaultConstructorMarker) null);
            mutableScatterMap.set(contentScale, mutableScatterMap2);
        }
        MutableScatterMap mutableScatterMap3 = mutableScatterMap2;
        Object obj = mutableScatterMap3.get(alignment);
        if (obj == null) {
            obj = new ScaleToBoundsImpl(contentScale, alignment);
            mutableScatterMap3.set(alignment, obj);
        }
        return (ScaleToBoundsImpl) obj;
    }

    private static final boolean getShouldCache(Alignment alignment) {
        return alignment == Alignment.Companion.getTopStart() || alignment == Alignment.Companion.getTopCenter() || alignment == Alignment.Companion.getTopEnd() || alignment == Alignment.Companion.getCenterStart() || alignment == Alignment.Companion.getCenter() || alignment == Alignment.Companion.getCenterEnd() || alignment == Alignment.Companion.getBottomStart() || alignment == Alignment.Companion.getBottomCenter() || alignment == Alignment.Companion.getBottomEnd();
    }

    private static final boolean getShouldCache(ContentScale contentScale) {
        return contentScale == ContentScale.Companion.getFillWidth() || contentScale == ContentScale.Companion.getFillHeight() || contentScale == ContentScale.Companion.getFillBounds() || contentScale == ContentScale.Companion.getFit() || contentScale == ContentScale.Companion.getCrop() || contentScale == ContentScale.Companion.getNone() || contentScale == ContentScale.Companion.getInside();
    }
}
