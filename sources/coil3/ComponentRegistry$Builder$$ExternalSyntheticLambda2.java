package coil3;

import coil3.ComponentRegistry;
import coil3.fetch.Fetcher;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ComponentRegistry$Builder$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ Fetcher.Factory f$0;
    public final /* synthetic */ KClass f$1;

    public /* synthetic */ ComponentRegistry$Builder$$ExternalSyntheticLambda2(Fetcher.Factory factory, KClass kClass) {
        this.f$0 = factory;
        this.f$1 = kClass;
    }

    public final Object invoke() {
        return ComponentRegistry.Builder.add$lambda$8$lambda$7(this.f$0, this.f$1);
    }
}
