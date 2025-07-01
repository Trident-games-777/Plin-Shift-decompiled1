package com.plinkofortune.cash.winspin;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.leader.LeaderModel;
import java.util.List;
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
@DebugMetadata(c = "com.plinkofortune.cash.winspin.GlobalRepo$setLeaders$2", f = "GlobalRepo.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GlobalRepo.kt */
final class GlobalRepo$setLeaders$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Preferences>, Object> {
    final /* synthetic */ List<LeaderModel> $leaders;
    int label;
    final /* synthetic */ GlobalRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalRepo$setLeaders$2(GlobalRepo globalRepo, List<LeaderModel> list, Continuation<? super GlobalRepo$setLeaders$2> continuation) {
        super(2, continuation);
        this.this$0 = globalRepo;
        this.$leaders = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalRepo$setLeaders$2(this.this$0, this.$leaders, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Preferences> continuation) {
        return ((GlobalRepo$setLeaders$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "prefs", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.plinkofortune.cash.winspin.GlobalRepo$setLeaders$2$1", f = "GlobalRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.plinkofortune.cash.winspin.GlobalRepo$setLeaders$2$1  reason: invalid class name */
    /* compiled from: GlobalRepo.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(globalRepo, list, continuation);
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
                ((MutablePreferences) this.L$0).set(globalRepo.leaderKey, globalRepo.gson.toJson((Object) list, new GlobalRepo$setLeaders$2$1$token$1().getType()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException(StringFog.decrypt(new byte[]{Byte.MIN_VALUE, Ascii.SI, 6, -69, 72, 65, 74, 106, -60, Ascii.FS, Ascii.SI, -92, Ascii.GS, 88, SignedBytes.MAX_POWER_OF_TWO, 109, -61, Ascii.FF, Ascii.SI, -79, 7, 71, SignedBytes.MAX_POWER_OF_TWO, 106, -60, 7, 4, -95, 7, 94, SignedBytes.MAX_POWER_OF_TWO, 109, -61, Ascii.EM, 3, -93, 0, Ascii.NAK, 70, 37, -111, 1, Ascii.US, -93, 1, 91, SignedBytes.MAX_POWER_OF_TWO}, new byte[]{-29, 110, 106, -41, 104, 53, 37, 74}));
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DataStore access$getStorage$p = this.this$0.storage;
            final GlobalRepo globalRepo = this.this$0;
            final List<LeaderModel> list = this.$leaders;
            this.label = 1;
            Object edit = PreferencesKt.edit(access$getStorage$p, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this);
            return edit == coroutine_suspended ? coroutine_suspended : edit;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{82, -127, Ascii.US, -73, 3, -3, 90, 72, Ascii.SYN, -110, Ascii.SYN, -88, 86, -28, 80, 79, 17, -126, Ascii.SYN, -67, 76, -5, 80, 72, Ascii.SYN, -119, Ascii.GS, -83, 76, -30, 80, 79, 17, -105, Ascii.SUB, -81, 75, -87, 86, 7, 67, -113, 6, -81, 74, -25, 80}, new byte[]{49, -32, 115, -37, 35, -119, 53, 104}));
        }
    }
}
