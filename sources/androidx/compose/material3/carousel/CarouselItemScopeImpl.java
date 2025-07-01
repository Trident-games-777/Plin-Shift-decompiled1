package androidx.compose.material3.carousel;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0017¢\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0017¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/carousel/CarouselItemScopeImpl;", "Landroidx/compose/material3/carousel/CarouselItemScope;", "itemInfo", "Landroidx/compose/material3/carousel/CarouselItemInfo;", "(Landroidx/compose/material3/carousel/CarouselItemInfo;)V", "carouselItemInfo", "getCarouselItemInfo", "()Landroidx/compose/material3/carousel/CarouselItemInfo;", "rememberMaskShape", "Landroidx/compose/foundation/shape/GenericShape;", "shape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/GenericShape;", "maskBorder", "Landroidx/compose/ui/Modifier;", "border", "Landroidx/compose/foundation/BorderStroke;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "maskClip", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CarouselItemScope.kt */
public final class CarouselItemScopeImpl implements CarouselItemScope {
    public static final int $stable = 8;
    private final CarouselItemInfo itemInfo;

    public CarouselItemScopeImpl(CarouselItemInfo carouselItemInfo) {
        this.itemInfo = carouselItemInfo;
    }

    public CarouselItemInfo getCarouselItemInfo() {
        return this.itemInfo;
    }

    public Modifier maskClip(Modifier modifier, Shape shape, Composer composer, int i) {
        composer.startReplaceGroup(440683050);
        ComposerKt.sourceInformation(composer, "C(maskClip)80@3238L32:CarouselItemScope.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(440683050, i, -1, "androidx.compose.material3.carousel.CarouselItemScopeImpl.maskClip (CarouselItemScope.kt:80)");
        }
        Modifier clip = ClipKt.clip(modifier, rememberMaskShape(shape, composer, (i >> 3) & WebSocketProtocol.PAYLOAD_SHORT));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return clip;
    }

    public Modifier maskBorder(Modifier modifier, BorderStroke borderStroke, Shape shape, Composer composer, int i) {
        composer.startReplaceGroup(610897768);
        ComposerKt.sourceInformation(composer, "C(maskBorder)84@3397L32:CarouselItemScope.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(610897768, i, -1, "androidx.compose.material3.carousel.CarouselItemScopeImpl.maskBorder (CarouselItemScope.kt:84)");
        }
        Modifier border = BorderKt.border(modifier, borderStroke, rememberMaskShape(shape, composer, (i >> 6) & WebSocketProtocol.PAYLOAD_SHORT));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return border;
    }

    public GenericShape rememberMaskShape(Shape shape, Composer composer, int i) {
        composer.startReplaceGroup(152582312);
        ComposerKt.sourceInformation(composer, "C(rememberMaskShape)88@3548L7,89@3571L319:CarouselItemScope.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(152582312, i, -1, "androidx.compose.material3.carousel.CarouselItemScopeImpl.rememberMaskShape (CarouselItemScope.kt:87)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        CarouselItemInfo carouselItemInfo = getCarouselItemInfo();
        ComposerKt.sourceInformationMarkerStart(composer, 332766031, "CC(remember):CarouselItemScope.kt#9igjgp");
        boolean changed = composer.changed((Object) carouselItemInfo) | composer.changed((Object) density);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new GenericShape(new CarouselItemScopeImpl$rememberMaskShape$1$1(this, shape, density));
            composer.updateRememberedValue(rememberedValue);
        }
        GenericShape genericShape = (GenericShape) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return genericShape;
    }
}
