package com.plinkofortune.cash.winspin;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.rounds.RoundModel;
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
@DebugMetadata(c = "com.plinkofortune.cash.winspin.GlobalRepo$setRounds$2", f = "GlobalRepo.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GlobalRepo.kt */
final class GlobalRepo$setRounds$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Preferences>, Object> {
    final /* synthetic */ List<RoundModel> $rounds;
    int label;
    final /* synthetic */ GlobalRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalRepo$setRounds$2(GlobalRepo globalRepo, List<RoundModel> list, Continuation<? super GlobalRepo$setRounds$2> continuation) {
        super(2, continuation);
        this.this$0 = globalRepo;
        this.$rounds = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalRepo$setRounds$2(this.this$0, this.$rounds, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Preferences> continuation) {
        return ((GlobalRepo$setRounds$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "prefs", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.plinkofortune.cash.winspin.GlobalRepo$setRounds$2$1", f = "GlobalRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.plinkofortune.cash.winspin.GlobalRepo$setRounds$2$1  reason: invalid class name */
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
                ((MutablePreferences) this.L$0).set(globalRepo.roundKey, globalRepo.gson.toJson((Object) list, new GlobalRepo$setRounds$2$1$token$1().getType()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException(StringFog.decrypt(new byte[]{125, 3, -12, -25, -27, 9, -113, -95, 57, Ascii.DLE, -3, -8, -80, Ascii.DLE, -123, -90, 62, 0, -3, -19, -86, Ascii.SI, -123, -95, 57, Ascii.VT, -10, -3, -86, Ascii.SYN, -123, -90, 62, Ascii.NAK, -15, -1, -83, 93, -125, -18, 108, Ascii.CR, -19, -1, -84, 19, -123}, new byte[]{Ascii.RS, 98, -104, -117, -59, 125, -32, -127}));
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DataStore access$getStorage$p = this.this$0.storage;
            final GlobalRepo globalRepo = this.this$0;
            final List<RoundModel> list = this.$rounds;
            this.label = 1;
            Object edit = PreferencesKt.edit(access$getStorage$p, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this);
            return edit == coroutine_suspended ? coroutine_suspended : edit;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{100, -28, -111, 110, 120, 124, -125, -101, 32, -9, -104, 113, 45, 101, -119, -100, 39, -25, -104, 100, 55, 122, -119, -101, 32, -20, -109, 116, 55, 99, -119, -100, 39, -14, -108, 118, 48, 40, -113, -44, 117, -22, -120, 118, 49, 102, -119}, new byte[]{7, -123, -3, 2, 88, 8, -20, -69}));
        }
    }
}
