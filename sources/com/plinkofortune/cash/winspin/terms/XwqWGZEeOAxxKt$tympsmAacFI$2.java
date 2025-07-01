package com.plinkofortune.cash.winspin.terms;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.Soleq;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.terms.XwqWGZEeOAxxKt$tympsmAacFI$2", f = "XwqWGZEeOAxx.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: XwqWGZEeOAxx.kt */
final class XwqWGZEeOAxxKt$tympsmAacFI$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $a7;
    final /* synthetic */ OgNFEsnlSFL $ogNFEsnlSFL;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    XwqWGZEeOAxxKt$tympsmAacFI$2(FragmentActivity fragmentActivity, OgNFEsnlSFL ogNFEsnlSFL, Continuation<? super XwqWGZEeOAxxKt$tympsmAacFI$2> continuation) {
        super(2, continuation);
        this.$a7 = fragmentActivity;
        this.$ogNFEsnlSFL = ogNFEsnlSFL;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new XwqWGZEeOAxxKt$tympsmAacFI$2(this.$a7, this.$ogNFEsnlSFL, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((XwqWGZEeOAxxKt$tympsmAacFI$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            WindowCompat.setDecorFitsSystemWindows(((Soleq) this.$a7).getWindow(), true);
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(((Soleq) this.$a7).getWindow(), ((Soleq) this.$a7).getWindow().getDecorView());
            windowInsetsControllerCompat.setAppearanceLightStatusBars(false);
            windowInsetsControllerCompat.setAppearanceLightNavigationBars(false);
            ((Soleq) this.$a7).getWindow().setStatusBarColor(ColorKt.m4293toArgb8_81llA(Color.Companion.m4265getBlack0d7_KjU()));
            ((Soleq) this.$a7).getWindow().setNavigationBarColor(ColorKt.m4293toArgb8_81llA(Color.Companion.m4265getBlack0d7_KjU()));
            ((Soleq) this.$a7).po9();
            ((Soleq) this.$a7).setRequestedOrientation(-1);
            OgNFEsnlSFL ogNFEsnlSFL = this.$ogNFEsnlSFL;
            if (ogNFEsnlSFL != null) {
                ogNFEsnlSFL.y90(true, true);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(StringFog.decrypt(new byte[]{-4, -83, -68, Ascii.CAN, 91, -120, 102, -78, -72, -66, -75, 7, Ascii.SO, -111, 108, -75, -65, -82, -75, Ascii.DC2, Ascii.DC4, -114, 108, -78, -72, -91, -66, 2, Ascii.DC4, -105, 108, -75, -65, -69, -71, 0, 19, -36, 106, -3, -19, -93, -91, 0, Ascii.DC2, -110, 108}, new byte[]{-97, -52, -48, 116, 123, -4, 9, -110}));
    }
}
