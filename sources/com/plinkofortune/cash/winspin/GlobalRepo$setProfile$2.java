package com.plinkofortune.cash.winspin;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.profile.ProfileData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.GlobalRepo$setProfile$2", f = "GlobalRepo.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GlobalRepo.kt */
final class GlobalRepo$setProfile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Preferences>, Object> {
    final /* synthetic */ ProfileData $profileData;
    int label;
    final /* synthetic */ GlobalRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalRepo$setProfile$2(GlobalRepo globalRepo, ProfileData profileData, Continuation<? super GlobalRepo$setProfile$2> continuation) {
        super(2, continuation);
        this.this$0 = globalRepo;
        this.$profileData = profileData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalRepo$setProfile$2(this.this$0, this.$profileData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Preferences> continuation) {
        return ((GlobalRepo$setProfile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "prefs", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.plinkofortune.cash.winspin.GlobalRepo$setProfile$2$1", f = "GlobalRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.plinkofortune.cash.winspin.GlobalRepo$setProfile$2$1  reason: invalid class name */
    /* compiled from: GlobalRepo.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(globalRepo, profileData, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ((MutablePreferences) this.L$0).set(globalRepo.profileKey, globalRepo.gson.toJson((Object) profileData, new GlobalRepo$setProfile$2$1$token$1().getType()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException(StringFog.decrypt(new byte[]{-56, 70, 103, 97, -124, -114, -125, 48, -116, 85, 110, 126, -47, -105, -119, 55, -117, 69, 110, 107, -53, -120, -119, 48, -116, 78, 101, 123, -53, -111, -119, 55, -117, 80, 98, 121, -52, -38, -113, Byte.MAX_VALUE, -39, 72, 126, 121, -51, -108, -119}, new byte[]{-85, 39, Ascii.VT, Ascii.CR, -92, -6, -20, Ascii.DLE}));
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DataStore access$getStorage$p = this.this$0.storage;
            final GlobalRepo globalRepo = this.this$0;
            final ProfileData profileData = this.$profileData;
            this.label = 1;
            Object edit = PreferencesKt.edit(access$getStorage$p, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this);
            return edit == coroutine_suspended ? coroutine_suspended : edit;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{-68, -125, Ascii.ESC, -96, -55, -94, -53, 48, -8, -112, Ascii.DC2, -65, -100, -69, -63, 55, -1, Byte.MIN_VALUE, Ascii.DC2, -86, -122, -92, -63, 48, -8, -117, Ascii.EM, -70, -122, -67, -63, 55, -1, -107, Ascii.RS, -72, -127, -10, -57, Byte.MAX_VALUE, -83, -115, 2, -72, Byte.MIN_VALUE, -72, -63}, new byte[]{-33, -30, 119, -52, -23, -42, -92, Ascii.DLE}));
        }
    }
}
