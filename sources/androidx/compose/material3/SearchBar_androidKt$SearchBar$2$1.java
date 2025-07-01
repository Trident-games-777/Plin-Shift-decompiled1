package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H@"}, d2 = {"<anonymous>", "", "progress", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1", f = "SearchBar.android.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$SearchBar$2$1 extends SuspendLambda implements Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    final /* synthetic */ MutatorMutex $mutatorMutex;
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBar$2$1(MutatorMutex mutatorMutex, MutableFloatState mutableFloatState, Animatable<Float, AnimationVector1D> animatable, Function1<? super Boolean, Unit> function1, MutableState<BackEventCompat> mutableState, MutableState<BackEventCompat> mutableState2, Continuation<? super SearchBar_androidKt$SearchBar$2$1> continuation) {
        super(2, continuation);
        this.$mutatorMutex = mutatorMutex;
        this.$finalBackProgress = mutableFloatState;
        this.$animationProgress = animatable;
        this.$onExpandedChange = function1;
        this.$firstBackEvent = mutableState;
        this.$currentBackEvent = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SearchBar_androidKt$SearchBar$2$1 searchBar_androidKt$SearchBar$2$1 = new SearchBar_androidKt$SearchBar$2$1(this.$mutatorMutex, this.$finalBackProgress, this.$animationProgress, this.$onExpandedChange, this.$firstBackEvent, this.$currentBackEvent, continuation);
        searchBar_androidKt$SearchBar$2$1.L$0 = obj;
        return searchBar_androidKt$SearchBar$2$1;
    }

    public final Object invoke(Flow<BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return ((SearchBar_androidKt$SearchBar$2$1) create(flow, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1", f = "SearchBar.android.kt", i = {}, l = {205, 216}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1  reason: invalid class name */
    /* compiled from: SearchBar.android.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(mutableFloatState, flow, animatable, function1, mutableState, mutableState2, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x007c, code lost:
            if (androidx.compose.animation.core.Animatable.animateTo$default(r6, kotlin.coroutines.jvm.internal.Boxing.boxFloat(1.0f), androidx.compose.material3.SearchBar_androidKt.AnimationPredictiveBackExitFloatSpec, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, r12, 12, (java.lang.Object) null) != r0) goto L_0x007f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                r2 = 2143289344(0x7fc00000, float:NaN)
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r4) goto L_0x001c
                if (r1 != r3) goto L_0x0014
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x007f
            L_0x0014:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x001c:
                kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x005f }
                goto L_0x0043
            L_0x0020:
                kotlin.ResultKt.throwOnFailure(r13)
                androidx.compose.runtime.MutableFloatState r13 = r4     // Catch:{ CancellationException -> 0x005f }
                r13.setFloatValue(r2)     // Catch:{ CancellationException -> 0x005f }
                kotlinx.coroutines.flow.Flow<androidx.activity.BackEventCompat> r13 = r5     // Catch:{ CancellationException -> 0x005f }
                androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1$1 r1 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1$1     // Catch:{ CancellationException -> 0x005f }
                androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r5 = r8     // Catch:{ CancellationException -> 0x005f }
                androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r6 = r9     // Catch:{ CancellationException -> 0x005f }
                androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r7 = r6     // Catch:{ CancellationException -> 0x005f }
                r1.<init>(r5, r6, r7)     // Catch:{ CancellationException -> 0x005f }
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1     // Catch:{ CancellationException -> 0x005f }
                r5 = r12
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ CancellationException -> 0x005f }
                r12.label = r4     // Catch:{ CancellationException -> 0x005f }
                java.lang.Object r13 = r13.collect(r1, r5)     // Catch:{ CancellationException -> 0x005f }
                if (r13 != r0) goto L_0x0043
                goto L_0x007e
            L_0x0043:
                androidx.compose.runtime.MutableFloatState r13 = r4     // Catch:{ CancellationException -> 0x005f }
                androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r6     // Catch:{ CancellationException -> 0x005f }
                java.lang.Object r1 = r1.getValue()     // Catch:{ CancellationException -> 0x005f }
                java.lang.Number r1 = (java.lang.Number) r1     // Catch:{ CancellationException -> 0x005f }
                float r1 = r1.floatValue()     // Catch:{ CancellationException -> 0x005f }
                r13.setFloatValue(r1)     // Catch:{ CancellationException -> 0x005f }
                kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r13 = r7     // Catch:{ CancellationException -> 0x005f }
                r1 = 0
                java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)     // Catch:{ CancellationException -> 0x005f }
                r13.invoke(r1)     // Catch:{ CancellationException -> 0x005f }
                goto L_0x008f
            L_0x005f:
                androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r6
                r13 = 1065353216(0x3f800000, float:1.0)
                java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
                androidx.compose.animation.core.FiniteAnimationSpec r13 = androidx.compose.material3.SearchBar_androidKt.AnimationPredictiveBackExitFloatSpec
                r6 = r13
                androidx.compose.animation.core.AnimationSpec r6 = (androidx.compose.animation.core.AnimationSpec) r6
                r9 = r12
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r12.label = r3
                r7 = 0
                r8 = 0
                r10 = 12
                r11 = 0
                java.lang.Object r13 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)
                if (r13 != r0) goto L_0x007f
            L_0x007e:
                return r0
            L_0x007f:
                androidx.compose.runtime.MutableFloatState r13 = r4
                r13.setFloatValue(r2)
                androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r13 = r8
                r0 = 0
                r13.setValue(r0)
                androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r13 = r9
                r13.setValue(r0)
            L_0x008f:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Flow flow = (Flow) this.L$0;
            MutatorMutex mutatorMutex = this.$mutatorMutex;
            final MutableFloatState mutableFloatState = this.$finalBackProgress;
            final Animatable<Float, AnimationVector1D> animatable = this.$animationProgress;
            final Function1<Boolean, Unit> function1 = this.$onExpandedChange;
            final MutableState<BackEventCompat> mutableState = this.$firstBackEvent;
            final MutableState<BackEventCompat> mutableState2 = this.$currentBackEvent;
            this.label = 1;
            if (MutatorMutex.mutate$default(mutatorMutex, (MutatePriority) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this, 1, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
