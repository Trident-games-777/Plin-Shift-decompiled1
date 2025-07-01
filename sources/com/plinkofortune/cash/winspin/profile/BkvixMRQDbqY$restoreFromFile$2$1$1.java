package com.plinkofortune.cash.winspin.profile;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.profile.BkvixMRQDbqY$restoreFromFile$2$1$1", f = "BkvixMRQDbqY.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BkvixMRQDbqY.kt */
final class BkvixMRQDbqY$restoreFromFile$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $currentIndex;
    final /* synthetic */ File $dialog;
    final /* synthetic */ KFunction<Unit> $function;
    final /* synthetic */ File $scroll;
    final /* synthetic */ File $state;
    int label;
    final /* synthetic */ BkvixMRQDbqY this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BkvixMRQDbqY$restoreFromFile$2$1$1(BkvixMRQDbqY bkvixMRQDbqY, File file, int i, File file2, KFunction<Unit> kFunction, File file3, Continuation<? super BkvixMRQDbqY$restoreFromFile$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = bkvixMRQDbqY;
        this.$state = file;
        this.$currentIndex = i;
        this.$dialog = file2;
        this.$function = kFunction;
        this.$scroll = file3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BkvixMRQDbqY$restoreFromFile$2$1$1(this.this$0, this.$state, this.$currentIndex, this.$dialog, this.$function, this.$scroll, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BkvixMRQDbqY$restoreFromFile$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Bundle access$readBundleFromFile = this.this$0.readBundleFromFile(new File(this.$state, String.valueOf(this.$currentIndex)).getName());
            if (access$readBundleFromFile != null) {
                List<Fragment> fragments = this.this$0.activity.getSupportFragmentManager().getFragments();
                Intrinsics.checkNotNullExpressionValue(fragments, StringFog.decrypt(new byte[]{122, -117, 1, Ascii.FS, 121, 55, -123, -116, 120, Byte.MIN_VALUE, 1, 41, 35, 120, -52, -49, 52}, new byte[]{Ascii.GS, -18, 117, 90, Ascii.VT, 86, -30, -31}));
                if (!fragments.isEmpty()) {
                    WebView webView = new WebView(this.this$0.activity);
                    File file = this.$dialog;
                    int i = this.$currentIndex;
                    KFunction<Unit> kFunction = this.$function;
                    File file2 = this.$scroll;
                    webView.restoreState(access$readBundleFromFile);
                    if (webView.getUrl() != null && new File(file, String.valueOf(i)).exists() && !Boolean.parseBoolean(FilesKt.readText$default(new File(file, String.valueOf(i)), (Charset) null, 1, (Object) null))) {
                        try {
                            ((Function2) kFunction).invoke(Boxing.boxBoolean(false), new BkvixMRQDbqY$restoreFromFile$2$1$1$$ExternalSyntheticLambda0(access$readBundleFromFile, file2, i));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(StringFog.decrypt(new byte[]{-85, 7, -55, 88, 80, -92, -99, -19, -17, Ascii.DC4, -64, 71, 5, -67, -105, -22, -24, 4, -64, 82, Ascii.US, -94, -105, -19, -17, Ascii.SI, -53, 66, Ascii.US, -69, -105, -22, -24, 17, -52, SignedBytes.MAX_POWER_OF_TWO, Ascii.CAN, -16, -111, -94, -70, 9, -48, SignedBytes.MAX_POWER_OF_TWO, Ascii.EM, -66, -105}, new byte[]{-56, 102, -91, 52, 112, -48, -14, -51}));
    }

    /* access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$3$lambda$2(Bundle bundle, File file, int i, WebView webView) {
        webView.restoreState(bundle);
        if (new File(file, String.valueOf(i)).exists()) {
            try {
                webView.setScrollY(Integer.parseInt(FilesKt.readText$default(new File(file, String.valueOf(i)), (Charset) null, 1, (Object) null)));
            } catch (Exception unused) {
            }
        }
        return Unit.INSTANCE;
    }
}
