package com.plinkofortune.cash.winspin.profile;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.runtime.MutableState;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.profile.ProfileScreenKt$ProfileScreen$1$1", f = "ProfileScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProfileScreen.kt */
final class ProfileScreenKt$ProfileScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $actualNickname$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<Boolean> $exec$delegate;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileScreenKt$ProfileScreen$1$1(Context context, MutableState<Boolean> mutableState, MutableState<String> mutableState2, Continuation<? super ProfileScreenKt$ProfileScreen$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$exec$delegate = mutableState;
        this.$actualNickname$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileScreenKt$ProfileScreen$1$1(this.$context, this.$exec$delegate, this.$actualNickname$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileScreenKt$ProfileScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (ProfileScreenKt.ProfileScreen$lambda$8(this.$exec$delegate)) {
                Context context = this.$context;
                String access$ProfileScreen$lambda$5 = ProfileScreenKt.ProfileScreen$lambda$5(this.$actualNickname$delegate);
                Toast.makeText(context, (access$ProfileScreen$lambda$5 == null || access$ProfileScreen$lambda$5.length() != 0) ? StringFog.decrypt(new byte[]{-79, 78, -63, -95, -16, -82, -57}, new byte[]{-28, 62, -91, -64, -124, -53, -93, -102}) : StringFog.decrypt(new byte[]{-55, 96, 89, -62, 102, Utf8.REPLACEMENT_BYTE, 74, -53, -89, 96, 73, -119, 109, 51, 87, -38, -2}, new byte[]{-121, 9, 58, -87, 8, 94, 39, -82}), 0).show();
                ProfileScreenKt.ProfileScreen$lambda$9(this.$exec$delegate, false);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(StringFog.decrypt(new byte[]{74, 102, 59, -10, 102, Ascii.SUB, 105, 78, Ascii.SO, 117, 50, -23, 51, 3, 99, 73, 9, 101, 50, -4, 41, Ascii.FS, 99, 78, Ascii.SO, 110, 57, -20, 41, 5, 99, 73, 9, 112, 62, -18, 46, 78, 101, 1, 91, 104, 34, -18, 47, 0, 99}, new byte[]{41, 7, 87, -102, 70, 110, 6, 110}));
    }
}
