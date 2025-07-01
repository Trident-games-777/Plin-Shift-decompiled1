package coil3.compose.internal;

import coil3.compose.AsyncImagePainter;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UtilsKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ UtilsKt$$ExternalSyntheticLambda2(Function1 function1, Function1 function12, Function1 function13) {
        this.f$0 = function1;
        this.f$1 = function12;
        this.f$2 = function13;
    }

    public final Object invoke(Object obj) {
        return UtilsKt.onStateOf$lambda$4(this.f$0, this.f$1, this.f$2, (AsyncImagePainter.State) obj);
    }
}
