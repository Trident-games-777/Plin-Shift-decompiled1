package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/Path;", "size", "Landroidx/compose/ui/geometry/Size;", "<anonymous parameter 1>", "Landroidx/compose/ui/unit/LayoutDirection;", "invoke-12SF9DM", "(Landroidx/compose/ui/graphics/Path;JLandroidx/compose/ui/unit/LayoutDirection;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$SearchBarImpl$animatedShape$1$1 extends Lambda implements Function3<Path, Size, LayoutDirection, Unit> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ Density $density;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBarImpl$animatedShape$1$1(Density density, Animatable<Float, AnimationVector1D> animatable) {
        super(3);
        this.$density = density;
        this.$animationProgress = animatable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m2415invoke12SF9DM((Path) obj, ((Size) obj2).m4061unboximpl(), (LayoutDirection) obj3);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-12SF9DM  reason: not valid java name */
    public final void m2415invoke12SF9DM(Path path, long j, LayoutDirection layoutDirection) {
        Path.addRoundRect$default(path, RoundRectKt.m4042RoundRectsniSvfs(SizeKt.m4077toRectuvyYCjk(j), CornerRadiusKt.CornerRadius$default(this.$density.m7091toPx0680j_4(Dp.m7111constructorimpl(SearchBar_androidKt.SearchBarCornerRadius * (((float) 1) - this.$animationProgress.getValue().floatValue()))), 0.0f, 2, (Object) null)), (Path.Direction) null, 2, (Object) null);
    }
}
