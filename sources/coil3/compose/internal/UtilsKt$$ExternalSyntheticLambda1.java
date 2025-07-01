package coil3.compose.internal;

import androidx.compose.ui.graphics.painter.Painter;
import coil3.compose.AsyncImagePainter;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UtilsKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ Painter f$0;
    public final /* synthetic */ Painter f$1;
    public final /* synthetic */ Painter f$2;

    public /* synthetic */ UtilsKt$$ExternalSyntheticLambda1(Painter painter, Painter painter2, Painter painter3) {
        this.f$0 = painter;
        this.f$1 = painter2;
        this.f$2 = painter3;
    }

    public final Object invoke(Object obj) {
        return UtilsKt.transformOf$lambda$3(this.f$0, this.f$1, this.f$2, (AsyncImagePainter.State) obj);
    }
}
