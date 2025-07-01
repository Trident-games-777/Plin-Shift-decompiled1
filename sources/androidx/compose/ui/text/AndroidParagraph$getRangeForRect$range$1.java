package androidx.compose.ui.text;

import android.graphics.RectF;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "segmentBounds", "Landroid/graphics/RectF;", "area", "invoke", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidParagraph.android.kt */
final class AndroidParagraph$getRangeForRect$range$1 extends Lambda implements Function2<RectF, RectF, Boolean> {
    final /* synthetic */ TextInclusionStrategy $inclusionStrategy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidParagraph$getRangeForRect$range$1(TextInclusionStrategy textInclusionStrategy) {
        super(2);
        this.$inclusionStrategy = textInclusionStrategy;
    }

    public final Boolean invoke(RectF rectF, RectF rectF2) {
        return Boolean.valueOf(this.$inclusionStrategy.isIncluded(RectHelper_androidKt.toComposeRect(rectF), RectHelper_androidKt.toComposeRect(rectF2)));
    }
}
