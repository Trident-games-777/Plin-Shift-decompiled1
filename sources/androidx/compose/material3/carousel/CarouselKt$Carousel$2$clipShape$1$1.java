package androidx.compose.material3.carousel;

import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"androidx/compose/material3/carousel/CarouselKt$Carousel$2$clipShape$1$1", "Landroidx/compose/ui/graphics/Shape;", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Carousel.kt */
public final class CarouselKt$Carousel$2$clipShape$1$1 implements Shape {
    final /* synthetic */ CarouselItemInfoImpl $carouselItemInfo;

    CarouselKt$Carousel$2$clipShape$1$1(CarouselItemInfoImpl carouselItemInfoImpl) {
        this.$carouselItemInfo = carouselItemInfoImpl;
    }

    /* renamed from: createOutline-Pq9zytI  reason: not valid java name */
    public Outline m2898createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        return new Outline.Rectangle(this.$carouselItemInfo.getMaskRect());
    }
}
