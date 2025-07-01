package coil3.compose;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import coil3.size.SizeResolver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: SubcomposeAsyncImage.kt */
final class SubcomposeAsyncImageKt$SubcomposeAsyncImage$2 implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ Alignment $alignment;
    final /* synthetic */ float $alpha;
    final /* synthetic */ boolean $clipToBounds;
    final /* synthetic */ ColorFilter $colorFilter;
    final /* synthetic */ Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> $content;
    final /* synthetic */ String $contentDescription;
    final /* synthetic */ ContentScale $contentScale;
    final /* synthetic */ AsyncImagePainter $painter;
    final /* synthetic */ SizeResolver $sizeResolver;

    SubcomposeAsyncImageKt$SubcomposeAsyncImage$2(SizeResolver sizeResolver, Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, AsyncImagePainter asyncImagePainter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z) {
        this.$sizeResolver = sizeResolver;
        this.$content = function3;
        this.$painter = asyncImagePainter;
        this.$contentDescription = str;
        this.$alignment = alignment;
        this.$contentScale = contentScale;
        this.$alpha = f;
        this.$colorFilter = colorFilter;
        this.$clipToBounds = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        if ((i & 6) == 0) {
            i |= composer.changed((Object) boxWithConstraintsScope) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-374957172, i, -1, "coil3.compose.SubcomposeAsyncImage.<anonymous> (SubcomposeAsyncImage.kt:216)");
            }
            ((ConstraintsSizeResolver) this.$sizeResolver).m7468setConstraintsBRTryo0(boxWithConstraintsScope.m660getConstraintsmsEJaDk());
            this.$content.invoke(new RealSubcomposeAsyncImageScope(boxWithConstraintsScope, this.$painter, this.$contentDescription, this.$alignment, this.$contentScale, this.$alpha, this.$colorFilter, this.$clipToBounds), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
