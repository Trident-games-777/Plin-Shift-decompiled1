package com.plinkofortune.cash.winspin.profile;

import android.net.Uri;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.profile.ProfileVIewModel$save$1", f = "ProfileVIewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProfileVIewModel.kt */
final class ProfileVIewModel$save$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $nickname;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ ProfileVIewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileVIewModel$save$1(ProfileVIewModel profileVIewModel, Uri uri, String str, Continuation<? super ProfileVIewModel$save$1> continuation) {
        super(2, continuation);
        this.this$0 = profileVIewModel;
        this.$uri = uri;
        this.$nickname = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileVIewModel$save$1(this.this$0, this.$uri, this.$nickname, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileVIewModel$save$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String access$getPath = this.this$0.getPath(this.$uri);
            if (access$getPath == null) {
                ProfileData value = this.this$0.getProfile().getValue();
                access$getPath = value != null ? value.getPath() : null;
            }
            ProfileData profileData = new ProfileData(access$getPath, this.$nickname);
            this.label = 1;
            if (this.this$0.repo.setProfile(profileData, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{-107, -109, -50, -111, -62, -110, -49, 41, -47, Byte.MIN_VALUE, -57, -114, -105, -117, -59, 46, -42, -112, -57, -101, -115, -108, -59, 41, -47, -101, -52, -117, -115, -115, -59, 46, -42, -123, -53, -119, -118, -58, -61, 102, -124, -99, -41, -119, -117, -120, -59}, new byte[]{-10, -14, -94, -3, -30, -26, -96, 9}));
        }
        return Unit.INSTANCE;
    }
}
