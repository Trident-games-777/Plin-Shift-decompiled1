package coil3;

import coil3.ImageLoader;
import coil3.request.ImageRequest;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImageLoader$Builder$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ Image f$0;

    public /* synthetic */ ImageLoader$Builder$$ExternalSyntheticLambda3(Image image) {
        this.f$0 = image;
    }

    public final Object invoke(Object obj) {
        return ImageLoader.Builder.fallback$lambda$17(this.f$0, (ImageRequest) obj);
    }
}
