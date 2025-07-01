package com.plinkofortune.cash.winspin;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.CompositionContext;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.plinkofortune.cash.winspin.nav.DMM;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0014J\u0006\u0010\u0011\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/plinkofortune/cash/winspin/Soleq;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "wcntrl", "Landroidx/core/view/WindowInsetsControllerCompat;", "getWcntrl", "()Landroidx/core/view/WindowInsetsControllerCompat;", "wcntrl$delegate", "Lkotlin/Lazy;", "ssb", "Landroid/os/Bundle;", "skc", "", "onCreate", "", "savedInstanceState", "po9", "command", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: Soleq.kt */
public final class Soleq extends FragmentActivity {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public boolean skc = true;
    private Bundle ssb;
    private final Lazy wcntrl$delegate = LazyKt.lazy(new Soleq$$ExternalSyntheticLambda0(this));

    private final WindowInsetsControllerCompat getWcntrl() {
        return (WindowInsetsControllerCompat) this.wcntrl$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsControllerCompat wcntrl_delegate$lambda$0(Soleq soleq) {
        return new WindowInsetsControllerCompat(soleq.getWindow(), soleq.getWindow().getDecorView());
    }

    /* access modifiers changed from: private */
    public static final boolean onCreate$lambda$1(Soleq soleq) {
        return soleq.skc;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SplashScreen.Companion.installSplashScreen(this).setKeepOnScreenCondition(new Soleq$$ExternalSyntheticLambda1(this));
        ComponentActivity componentActivity = this;
        DMM.init(componentActivity, R.style.Theme_PlinShift, R.style.Theme_PlinShift_DarkLight);
        super.onCreate(bundle);
        EdgeToEdge.enable$default(componentActivity, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
        this.ssb = bundle;
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new Soleq$onCreate$2(this, (Continuation<? super Soleq$onCreate$2>) null), 2, (Object) null);
        getWcntrl().setSystemBarsBehavior(2);
        getWcntrl().hide(WindowInsetsCompat.Type.systemBars());
        ComponentActivityKt.setContent$default(componentActivity, (CompositionContext) null, ComposableSingletons$SoleqKt.INSTANCE.m7771getLambda1$app_release(), 1, (Object) null);
    }

    public final void po9() {
        getWcntrl().show(WindowInsetsCompat.Type.systemBars());
    }

    public final Bundle command() {
        return this.ssb;
    }
}
