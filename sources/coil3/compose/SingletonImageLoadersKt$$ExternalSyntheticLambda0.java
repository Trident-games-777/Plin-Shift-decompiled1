package coil3.compose;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SingletonImageLoadersKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ SingletonImageLoadersKt$$ExternalSyntheticLambda0(Function1 function1, int i) {
        this.f$0 = function1;
        this.f$1 = i;
    }

    public final Object invoke(Object obj, Object obj2) {
        return SingletonImageLoadersKt.setSingletonImageLoaderFactory$lambda$0(this.f$0, this.f$1, (Composer) obj, ((Integer) obj2).intValue());
    }
}
