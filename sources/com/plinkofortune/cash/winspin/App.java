package com.plinkofortune.cash.winspin;

import android.app.Application;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/plinkofortune/cash/winspin/App;", "Landroid/app/Application;", "<init>", "()V", "storage", "Lcom/plinkofortune/cash/winspin/GlobalRepo;", "getStorage", "()Lcom/plinkofortune/cash/winspin/GlobalRepo;", "storage$delegate", "Lkotlin/Lazy;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: App.kt */
public final class App extends Application {
    public static final int $stable = 8;
    private final Lazy storage$delegate = LazyKt.lazy(new App$$ExternalSyntheticLambda0(this));

    /* access modifiers changed from: private */
    public static final GlobalRepo storage_delegate$lambda$0(App app) {
        return new GlobalRepo(app);
    }

    public final GlobalRepo getStorage() {
        return (GlobalRepo) this.storage$delegate.getValue();
    }
}
