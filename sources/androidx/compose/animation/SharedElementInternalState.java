package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0013\u0010a\u001a\u00020bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bc\u00101J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J\b\u0010h\u001a\u00020eH\u0016J\b\u0010i\u001a\u00020eH\u0016J\b\u0010j\u001a\u00020eH\u0016R+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0013\u001a\u0004\u0018\u00010 8F@FX\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0017\u0010.\u001a\u00020/8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b0\u00101R+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f8F@FX\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0019\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00107\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R+\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b8F@FX\u0002¢\u0006\u0012\n\u0004\b@\u0010\u0019\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R+\u0010\r\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\bE\u0010\u0019\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR+\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\bH\u0010\u0019\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\bM\u0010\u0019\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010BR\u0014\u0010P\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010BR\u0011\u0010R\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bS\u0010BR\u0011\u0010T\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bU\u0010BR+\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f8F@FX\u0002¢\u0006\u0012\n\u0004\bZ\u0010\u0019\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR+\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00118V@VX\u0002¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006k"}, d2 = {"Landroidx/compose/animation/SharedElementInternalState;", "Landroidx/compose/animation/LayerRenderer;", "Landroidx/compose/runtime/RememberObserver;", "sharedElement", "Landroidx/compose/animation/SharedElement;", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "placeHolderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "renderOnlyWhenVisible", "", "overlayClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "renderInOverlayDuringTransition", "userState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "zIndex", "", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZLandroidx/compose/animation/SharedTransitionScope$OverlayClip;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;F)V", "<set-?>", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "setBoundsAnimation", "(Landroidx/compose/animation/BoundsAnimation;)V", "boundsAnimation$delegate", "Landroidx/compose/runtime/MutableState;", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay$animation_release", "()Landroidx/compose/ui/graphics/Path;", "setClipPathInOverlay$animation_release", "(Landroidx/compose/ui/graphics/Path;)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layer$delegate", "lookaheadCoords", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLookaheadCoords", "()Lkotlin/jvm/functions/Function0;", "setLookaheadCoords", "(Lkotlin/jvm/functions/Function0;)V", "nonNullLookaheadSize", "Landroidx/compose/ui/geometry/Size;", "getNonNullLookaheadSize-NH-jbRc", "()J", "getOverlayClip", "()Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "setOverlayClip", "(Landroidx/compose/animation/SharedTransitionScope$OverlayClip;)V", "overlayClip$delegate", "parentState", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "setParentState", "(Landroidx/compose/animation/SharedElementInternalState;)V", "getPlaceHolderSize", "()Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "setPlaceHolderSize", "(Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;)V", "placeHolderSize$delegate", "getRenderInOverlayDuringTransition", "()Z", "setRenderInOverlayDuringTransition", "(Z)V", "renderInOverlayDuringTransition$delegate", "getRenderOnlyWhenVisible", "setRenderOnlyWhenVisible", "renderOnlyWhenVisible$delegate", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "setSharedElement", "(Landroidx/compose/animation/SharedElement;)V", "sharedElement$delegate", "shouldRenderBasedOnTarget", "getShouldRenderBasedOnTarget", "shouldRenderInOverlay", "getShouldRenderInOverlay$animation_release", "shouldRenderInPlace", "getShouldRenderInPlace", "target", "getTarget", "getUserState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "setUserState", "(Landroidx/compose/animation/SharedTransitionScope$SharedContentState;)V", "userState$delegate", "getZIndex", "()F", "setZIndex", "(F)V", "zIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "calculateLookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "calculateLookaheadOffset-F1C5BW0", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onAbandoned", "onForgotten", "onRemembered", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedElement.kt */
public final class SharedElementInternalState implements LayerRenderer, RememberObserver {
    public static final int $stable = 8;
    private final MutableState boundsAnimation$delegate;
    private Path clipPathInOverlay;
    private final MutableState layer$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private Function0<? extends LayoutCoordinates> lookaheadCoords = SharedElementInternalState$lookaheadCoords$1.INSTANCE;
    private final MutableState overlayClip$delegate;
    private SharedElementInternalState parentState;
    private final MutableState placeHolderSize$delegate;
    private final MutableState renderInOverlayDuringTransition$delegate;
    private final MutableState renderOnlyWhenVisible$delegate;
    private final MutableState sharedElement$delegate;
    private final MutableState userState$delegate;
    private final MutableFloatState zIndex$delegate;

    public void onAbandoned() {
    }

    public SharedElementInternalState(SharedElement sharedElement, BoundsAnimation boundsAnimation, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z, SharedTransitionScope.OverlayClip overlayClip, boolean z2, SharedTransitionScope.SharedContentState sharedContentState, float f) {
        this.zIndex$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.renderInOverlayDuringTransition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.sharedElement$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedElement, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.boundsAnimation$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(boundsAnimation, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.placeHolderSize$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(placeHolderSize, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.renderOnlyWhenVisible$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.overlayClip$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(overlayClip, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.userState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedContentState, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public float getZIndex() {
        return this.zIndex$delegate.getFloatValue();
    }

    public void setZIndex(float f) {
        this.zIndex$delegate.setFloatValue(f);
    }

    public final boolean getRenderInOverlayDuringTransition() {
        return ((Boolean) this.renderInOverlayDuringTransition$delegate.getValue()).booleanValue();
    }

    public final void setRenderInOverlayDuringTransition(boolean z) {
        this.renderInOverlayDuringTransition$delegate.setValue(Boolean.valueOf(z));
    }

    public final SharedElement getSharedElement() {
        return (SharedElement) this.sharedElement$delegate.getValue();
    }

    public final void setSharedElement(SharedElement sharedElement) {
        this.sharedElement$delegate.setValue(sharedElement);
    }

    public final BoundsAnimation getBoundsAnimation() {
        return (BoundsAnimation) this.boundsAnimation$delegate.getValue();
    }

    public final void setBoundsAnimation(BoundsAnimation boundsAnimation) {
        this.boundsAnimation$delegate.setValue(boundsAnimation);
    }

    public final SharedTransitionScope.PlaceHolderSize getPlaceHolderSize() {
        return (SharedTransitionScope.PlaceHolderSize) this.placeHolderSize$delegate.getValue();
    }

    public final void setPlaceHolderSize(SharedTransitionScope.PlaceHolderSize placeHolderSize) {
        this.placeHolderSize$delegate.setValue(placeHolderSize);
    }

    public final boolean getRenderOnlyWhenVisible() {
        return ((Boolean) this.renderOnlyWhenVisible$delegate.getValue()).booleanValue();
    }

    public final void setRenderOnlyWhenVisible(boolean z) {
        this.renderOnlyWhenVisible$delegate.setValue(Boolean.valueOf(z));
    }

    public final SharedTransitionScope.OverlayClip getOverlayClip() {
        return (SharedTransitionScope.OverlayClip) this.overlayClip$delegate.getValue();
    }

    public final void setOverlayClip(SharedTransitionScope.OverlayClip overlayClip) {
        this.overlayClip$delegate.setValue(overlayClip);
    }

    public final SharedTransitionScope.SharedContentState getUserState() {
        return (SharedTransitionScope.SharedContentState) this.userState$delegate.getValue();
    }

    public final void setUserState(SharedTransitionScope.SharedContentState sharedContentState) {
        this.userState$delegate.setValue(sharedContentState);
    }

    public final Path getClipPathInOverlay$animation_release() {
        return this.clipPathInOverlay;
    }

    public final void setClipPathInOverlay$animation_release(Path path) {
        this.clipPathInOverlay = path;
    }

    public void drawInOverlay(DrawScope drawScope) {
        GraphicsLayer layer = getLayer();
        if (layer == null || !getShouldRenderInOverlay$animation_release()) {
            return;
        }
        if (getSharedElement().getCurrentBounds() != null) {
            Rect currentBounds = getSharedElement().getCurrentBounds();
            Unit unit = null;
            Offset r1 = currentBounds != null ? Offset.m3976boximpl(currentBounds.m4022getTopLeftF1C5BW0()) : null;
            Intrinsics.checkNotNull(r1);
            long r3 = r1.m3997unboximpl();
            float r12 = Offset.m3987getXimpl(r3);
            float r32 = Offset.m3988getYimpl(r3);
            Path path = this.clipPathInOverlay;
            if (path != null) {
                int r2 = ClipOp.Companion.m4228getIntersectrtfAjoo();
                DrawContext drawContext = drawScope.getDrawContext();
                long r6 = drawContext.m4806getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    drawContext.getTransform().m4925clipPathmtrdDE(path, r2);
                    drawScope.getDrawContext().getTransform().translate(r12, r32);
                    GraphicsLayerKt.drawLayer(drawScope, layer);
                    drawScope.getDrawContext().getTransform().translate(-r12, -r32);
                    drawContext.getCanvas().restore();
                    drawContext.m4807setSizeuvyYCjk(r6);
                    unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    drawContext.getCanvas().restore();
                    drawContext.m4807setSizeuvyYCjk(r6);
                    throw th;
                }
            }
            if (unit == null) {
                drawScope.getDrawContext().getTransform().translate(r12, r32);
                try {
                    GraphicsLayerKt.drawLayer(drawScope, layer);
                } finally {
                    drawScope.getDrawContext().getTransform().translate(-r12, -r32);
                }
            }
        } else {
            throw new IllegalArgumentException("Error: current bounds not set yet.".toString());
        }
    }

    /* renamed from: getNonNullLookaheadSize-NH-jbRc  reason: not valid java name */
    public final long m114getNonNullLookaheadSizeNHjbRc() {
        Object invoke = this.lookaheadCoords.invoke();
        if (invoke != null) {
            return IntSizeKt.m7295toSizeozmzZPI(((LayoutCoordinates) invoke).m5800getSizeYbymL2g());
        }
        throw new IllegalArgumentException(("Error: lookahead coordinates is null for " + getSharedElement().getKey() + '.').toString());
    }

    public final Function0<LayoutCoordinates> getLookaheadCoords() {
        return this.lookaheadCoords;
    }

    public final void setLookaheadCoords(Function0<? extends LayoutCoordinates> function0) {
        this.lookaheadCoords = function0;
    }

    public SharedElementInternalState getParentState() {
        return this.parentState;
    }

    public void setParentState(SharedElementInternalState sharedElementInternalState) {
        this.parentState = sharedElementInternalState;
    }

    /* renamed from: calculateLookaheadOffset-F1C5BW0  reason: not valid java name */
    public final long m113calculateLookaheadOffsetF1C5BW0() {
        Object invoke = this.lookaheadCoords.invoke();
        if (invoke != null) {
            return getSharedElement().getScope().getLookaheadRoot$animation_release().m5801localPositionOfR5De75A((LayoutCoordinates) invoke, Offset.Companion.m4003getZeroF1C5BW0());
        }
        throw new IllegalArgumentException("Error: lookahead coordinates is null.".toString());
    }

    public final boolean getTarget() {
        return getBoundsAnimation().getTarget();
    }

    public final GraphicsLayer getLayer() {
        return (GraphicsLayer) this.layer$delegate.getValue();
    }

    public final void setLayer(GraphicsLayer graphicsLayer) {
        this.layer$delegate.setValue(graphicsLayer);
    }

    private final boolean getShouldRenderBasedOnTarget() {
        return Intrinsics.areEqual((Object) getSharedElement().getTargetBoundsProvider$animation_release(), (Object) this) || !getRenderOnlyWhenVisible();
    }

    public final boolean getShouldRenderInOverlay$animation_release() {
        return getShouldRenderBasedOnTarget() && getSharedElement().getFoundMatch() && getRenderInOverlayDuringTransition();
    }

    public final boolean getShouldRenderInPlace() {
        if (getSharedElement().getFoundMatch()) {
            return !getShouldRenderInOverlay$animation_release() && getShouldRenderBasedOnTarget();
        }
        return true;
    }

    public void onRemembered() {
        getSharedElement().getScope().onStateAdded$animation_release(this);
        getSharedElement().updateTargetBoundsProvider();
    }

    public void onForgotten() {
        getSharedElement().getScope().onStateRemoved$animation_release(this);
        getSharedElement().updateTargetBoundsProvider();
    }
}
