package coil3;

import coil3.EventListener;
import coil3.ImageLoader;
import coil3.request.ImageRequest;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImageLoader$Builder$$ExternalSyntheticLambda5 implements EventListener.Factory {
    public final /* synthetic */ EventListener f$0;

    public /* synthetic */ ImageLoader$Builder$$ExternalSyntheticLambda5(EventListener eventListener) {
        this.f$0 = eventListener;
    }

    public final EventListener create(ImageRequest imageRequest) {
        return ImageLoader.Builder.eventListener$lambda$6(this.f$0, imageRequest);
    }
}
