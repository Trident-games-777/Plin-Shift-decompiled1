package coil3.decode;

import android.content.res.AssetFileDescriptor;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class StaticImageDecoderKt$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ AssetFileDescriptor f$0;

    public /* synthetic */ StaticImageDecoderKt$$ExternalSyntheticLambda0(AssetFileDescriptor assetFileDescriptor) {
        this.f$0 = assetFileDescriptor;
    }

    public final Object call() {
        return StaticImageDecoderKt.toImageDecoderSourceOrNull$lambda$0(this.f$0);
    }
}
