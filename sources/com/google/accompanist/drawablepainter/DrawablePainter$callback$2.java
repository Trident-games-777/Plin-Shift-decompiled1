package com.google.accompanist.drawablepainter;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/google/accompanist/drawablepainter/DrawablePainter$callback$2$1", "invoke", "()Lcom/google/accompanist/drawablepainter/DrawablePainter$callback$2$1;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: DrawablePainter.kt */
final class DrawablePainter$callback$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ DrawablePainter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawablePainter$callback$2(DrawablePainter drawablePainter) {
        super(0);
        this.this$0 = drawablePainter;
    }

    public final AnonymousClass1 invoke() {
        final DrawablePainter drawablePainter = this.this$0;
        return new Drawable.Callback() {
            public void invalidateDrawable(Drawable drawable) {
                Intrinsics.checkNotNullParameter(drawable, "d");
                DrawablePainter drawablePainter = drawablePainter;
                drawablePainter.setDrawInvalidateTick(drawablePainter.getDrawInvalidateTick() + 1);
                DrawablePainter drawablePainter2 = drawablePainter;
                drawablePainter2.m7566setDrawableIntrinsicSizeuvyYCjk(DrawablePainterKt.getIntrinsicSize(drawablePainter2.getDrawable()));
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                Intrinsics.checkNotNullParameter(drawable, "d");
                Intrinsics.checkNotNullParameter(runnable, "what");
                DrawablePainterKt.getMAIN_HANDLER().postAtTime(runnable, j);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                Intrinsics.checkNotNullParameter(drawable, "d");
                Intrinsics.checkNotNullParameter(runnable, "what");
                DrawablePainterKt.getMAIN_HANDLER().removeCallbacks(runnable);
            }
        };
    }
}
