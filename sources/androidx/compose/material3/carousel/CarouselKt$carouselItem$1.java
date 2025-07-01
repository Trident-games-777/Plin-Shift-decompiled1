package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Carousel.kt */
final class CarouselKt$carouselItem$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    final /* synthetic */ CarouselItemInfoImpl $carouselItemInfo;
    final /* synthetic */ Shape $clipShape;
    final /* synthetic */ int $index;
    final /* synthetic */ CarouselState $state;
    final /* synthetic */ Function0<Strategy> $strategy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CarouselKt$carouselItem$1(Function0<Strategy> function0, CarouselState carouselState, int i, CarouselItemInfoImpl carouselItemInfoImpl, Shape shape) {
        super(3);
        this.$strategy = function0;
        this.$state = carouselState;
        this.$index = i;
        this.$carouselItemInfo = carouselItemInfoImpl;
        this.$clipShape = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m2899invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m7058unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m2899invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long j2;
        final Strategy invoke = this.$strategy.invoke();
        if (!invoke.isValid()) {
            return MeasureScope.layout$default(measureScope, 0, 0, (Map) null, AnonymousClass1.INSTANCE, 4, (Object) null);
        }
        final boolean z = this.$state.getPagerState$material3_release().getLayoutInfo().getOrientation() == Orientation.Vertical;
        final boolean z2 = measureScope.getLayoutDirection() == LayoutDirection.Rtl;
        float itemMainAxisSize = invoke.getItemMainAxisSize();
        if (z) {
            j2 = Constraints.m7042copyZbe2FdA(j, Constraints.m7054getMinWidthimpl(j), Constraints.m7052getMaxWidthimpl(j), MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize));
        } else {
            j2 = Constraints.m7042copyZbe2FdA(j, MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize), Constraints.m7053getMinHeightimpl(j), Constraints.m7051getMaxHeightimpl(j));
        }
        final Placeable r3 = measurable.m5848measureBRTryo0(j2);
        int width = r3.getWidth();
        int height = r3.getHeight();
        final CarouselState carouselState = this.$state;
        final int i = this.$index;
        final CarouselItemInfoImpl carouselItemInfoImpl = this.$carouselItemInfo;
        final Shape shape = this.$clipShape;
        return MeasureScope.layout$default(measureScope, width, height, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable placeable = r3;
                final CarouselState carouselState = carouselState;
                final Strategy strategy = invoke;
                final int i = i;
                final boolean z = z;
                final CarouselItemInfoImpl carouselItemInfoImpl = carouselItemInfoImpl;
                final Shape shape = shape;
                final boolean z2 = z2;
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, 0, 0.0f, (Function1) new Function1<GraphicsLayerScope, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        float calculateCurrentScrollOffset = CarouselKt.calculateCurrentScrollOffset(carouselState, strategy);
                        float calculateMaxScrollOffset = CarouselKt.calculateMaxScrollOffset(carouselState, strategy);
                        KeylineList keylineListForScrollOffset$material3_release$default = Strategy.getKeylineListForScrollOffset$material3_release$default(strategy, calculateCurrentScrollOffset, calculateMaxScrollOffset, false, 4, (Object) null);
                        KeylineList keylineListForScrollOffset$material3_release = strategy.getKeylineListForScrollOffset$material3_release(calculateCurrentScrollOffset, calculateMaxScrollOffset, true);
                        float itemMainAxisSize = ((((float) i) * (strategy.getItemMainAxisSize() + strategy.getItemSpacing())) + (strategy.getItemMainAxisSize() / 2.0f)) - calculateCurrentScrollOffset;
                        Keyline keylineBefore = keylineListForScrollOffset$material3_release$default.getKeylineBefore(itemMainAxisSize);
                        Keyline keylineAfter = keylineListForScrollOffset$material3_release$default.getKeylineAfter(itemMainAxisSize);
                        Keyline lerp = KeylineListKt.lerp(keylineBefore, keylineAfter, CarouselKt.access$getProgress(keylineBefore, keylineAfter, itemMainAxisSize));
                        boolean areEqual = Intrinsics.areEqual((Object) keylineBefore, (Object) keylineAfter);
                        float r3 = (z ? Size.m4053getHeightimpl(graphicsLayerScope.m4427getSizeNHjbRc()) : strategy.getItemMainAxisSize()) / 2.0f;
                        float itemMainAxisSize2 = (z ? strategy.getItemMainAxisSize() : Size.m4053getHeightimpl(graphicsLayerScope.m4427getSizeNHjbRc())) / 2.0f;
                        float r8 = (z ? Size.m4056getWidthimpl(graphicsLayerScope.m4427getSizeNHjbRc()) : lerp.getSize()) / 2.0f;
                        float size = (z ? lerp.getSize() : Size.m4053getHeightimpl(graphicsLayerScope.m4427getSizeNHjbRc())) / 2.0f;
                        Rect rect = new Rect(r3 - r8, itemMainAxisSize2 - size, r3 + r8, itemMainAxisSize2 + size);
                        carouselItemInfoImpl.setSizeState(lerp.getSize());
                        CarouselItemInfoImpl carouselItemInfoImpl = carouselItemInfoImpl;
                        Iterator it = keylineListForScrollOffset$material3_release.iterator();
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (!it.hasNext()) {
                                carouselItemInfoImpl.setMinSizeState(((Keyline) next).getSize());
                                carouselItemInfoImpl.setMaxSizeState(keylineListForScrollOffset$material3_release.getFirstFocal().getSize());
                                carouselItemInfoImpl.setMaskRectState(rect);
                                graphicsLayerScope.setClip(!Intrinsics.areEqual((Object) rect, (Object) new Rect(0.0f, 0.0f, Size.m4056getWidthimpl(graphicsLayerScope.m4427getSizeNHjbRc()), Size.m4053getHeightimpl(graphicsLayerScope.m4427getSizeNHjbRc()))));
                                graphicsLayerScope.setShape(shape);
                                float offset = lerp.getOffset() - itemMainAxisSize;
                            } else {
                                float size2 = ((Keyline) next).getSize();
                                do {
                                    Object next2 = it.next();
                                    float size3 = ((Keyline) next2).getSize();
                                    if (Float.compare(size2, size3) > 0) {
                                        next = next2;
                                        size2 = size3;
                                    }
                                } while (it.hasNext());
                            }
                            carouselItemInfoImpl.setMinSizeState(((Keyline) next).getSize());
                            carouselItemInfoImpl.setMaxSizeState(keylineListForScrollOffset$material3_release.getFirstFocal().getSize());
                            carouselItemInfoImpl.setMaskRectState(rect);
                            graphicsLayerScope.setClip(!Intrinsics.areEqual((Object) rect, (Object) new Rect(0.0f, 0.0f, Size.m4056getWidthimpl(graphicsLayerScope.m4427getSizeNHjbRc()), Size.m4053getHeightimpl(graphicsLayerScope.m4427getSizeNHjbRc()))));
                            graphicsLayerScope.setShape(shape);
                            float offset2 = lerp.getOffset() - itemMainAxisSize;
                            if (areEqual) {
                                offset2 += (itemMainAxisSize - lerp.getUnadjustedOffset()) / lerp.getSize();
                            }
                            if (z) {
                                graphicsLayerScope.setTranslationY(offset2);
                                return;
                            }
                            if (z2) {
                                offset2 = -offset2;
                            }
                            graphicsLayerScope.setTranslationX(offset2);
                            return;
                        }
                        throw new NoSuchElementException();
                    }
                }, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
