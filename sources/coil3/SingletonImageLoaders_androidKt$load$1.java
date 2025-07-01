package coil3;

import coil3.request.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* compiled from: singletonImageLoaders.android.kt */
public final class SingletonImageLoaders_androidKt$load$1 implements Function1<ImageRequest.Builder, Unit> {
    public static final SingletonImageLoaders_androidKt$load$1 INSTANCE = new SingletonImageLoaders_androidKt$load$1();

    public final void invoke(ImageRequest.Builder builder) {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ImageRequest.Builder) obj);
        return Unit.INSTANCE;
    }
}
