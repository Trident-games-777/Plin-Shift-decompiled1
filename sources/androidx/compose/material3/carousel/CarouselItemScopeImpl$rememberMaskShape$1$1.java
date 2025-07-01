package androidx.compose.material3.carousel;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/Path;", "size", "Landroidx/compose/ui/geometry/Size;", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "invoke-12SF9DM", "(Landroidx/compose/ui/graphics/Path;JLandroidx/compose/ui/unit/LayoutDirection;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CarouselItemScope.kt */
final class CarouselItemScopeImpl$rememberMaskShape$1$1 extends Lambda implements Function3<Path, Size, LayoutDirection, Unit> {
    final /* synthetic */ Density $density;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ CarouselItemScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CarouselItemScopeImpl$rememberMaskShape$1$1(CarouselItemScopeImpl carouselItemScopeImpl, Shape shape, Density density) {
        super(3);
        this.this$0 = carouselItemScopeImpl;
        this.$shape = shape;
        this.$density = density;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m2893invoke12SF9DM((Path) obj, ((Size) obj2).m4061unboximpl(), (LayoutDirection) obj3);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-12SF9DM  reason: not valid java name */
    public final void m2893invoke12SF9DM(Path path, long j, LayoutDirection layoutDirection) {
        Rect intersect = this.this$0.getCarouselItemInfo().getMaskRect().intersect(SizeKt.m4077toRectuvyYCjk(j));
        OutlineKt.addOutline(path, this.$shape.m4605createOutlinePq9zytI(intersect.m4020getSizeNHjbRc(), layoutDirection, this.$density));
        path.m4531translatek4lQ0M(OffsetKt.Offset(intersect.getLeft(), intersect.getTop()));
    }
}
