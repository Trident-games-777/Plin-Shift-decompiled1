package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {574, 585}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.this$0, continuation);
        recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0076
            if (r2 == r4) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r2 = r0.L$8
            androidx.collection.MutableScatterSet r2 = (androidx.collection.MutableScatterSet) r2
            java.lang.Object r5 = r0.L$7
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r6 = r0.L$6
            androidx.collection.MutableScatterSet r6 = (androidx.collection.MutableScatterSet) r6
            java.lang.Object r7 = r0.L$5
            androidx.collection.MutableScatterSet r7 = (androidx.collection.MutableScatterSet) r7
            java.lang.Object r8 = r0.L$4
            androidx.collection.MutableScatterSet r8 = (androidx.collection.MutableScatterSet) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r0.L$2
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r0.L$1
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r0.L$0
            androidx.compose.runtime.MonotonicFrameClock r12 = (androidx.compose.runtime.MonotonicFrameClock) r12
            kotlin.ResultKt.throwOnFailure(r17)
            r15 = r12
            r12 = r2
            r2 = r15
            goto L_0x011a
        L_0x003c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0044:
            java.lang.Object r2 = r0.L$8
            androidx.collection.MutableScatterSet r2 = (androidx.collection.MutableScatterSet) r2
            java.lang.Object r5 = r0.L$7
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r6 = r0.L$6
            androidx.collection.MutableScatterSet r6 = (androidx.collection.MutableScatterSet) r6
            java.lang.Object r7 = r0.L$5
            androidx.collection.MutableScatterSet r7 = (androidx.collection.MutableScatterSet) r7
            java.lang.Object r8 = r0.L$4
            androidx.collection.MutableScatterSet r8 = (androidx.collection.MutableScatterSet) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r0.L$2
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r0.L$1
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r0.L$0
            androidx.compose.runtime.MonotonicFrameClock r12 = (androidx.compose.runtime.MonotonicFrameClock) r12
            kotlin.ResultKt.throwOnFailure(r17)
            r13 = r8
            r8 = r2
            r2 = r12
            r12 = r9
            r9 = r11
            r11 = r13
        L_0x0071:
            r14 = r5
            r13 = r7
            r7 = r6
            goto L_0x00e3
        L_0x0076:
            kotlin.ResultKt.throwOnFailure(r17)
            java.lang.Object r2 = r0.L$0
            androidx.compose.runtime.MonotonicFrameClock r2 = (androidx.compose.runtime.MonotonicFrameClock) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            androidx.collection.MutableScatterSet r8 = androidx.collection.ScatterSetKt.mutableScatterSetOf()
            androidx.collection.MutableScatterSet r9 = androidx.collection.ScatterSetKt.mutableScatterSetOf()
            androidx.collection.MutableScatterSet r10 = new androidx.collection.MutableScatterSet
            r11 = 0
            r12 = 0
            r10.<init>(r11, r4, r12)
            r11 = r10
            androidx.collection.ScatterSet r11 = (androidx.collection.ScatterSet) r11
            java.util.Set r11 = androidx.compose.runtime.collection.ScatterSetWrapperKt.wrapIntoSet(r11)
            androidx.collection.MutableScatterSet r12 = androidx.collection.ScatterSetKt.mutableScatterSetOf()
            r15 = r11
            r11 = r5
            r5 = r15
            r15 = r10
            r10 = r6
            r6 = r15
            r15 = r9
            r9 = r7
            r7 = r15
        L_0x00b5:
            androidx.compose.runtime.Recomposer r13 = r0.this$0
            boolean r13 = r13.getShouldKeepRecomposing()
            if (r13 == 0) goto L_0x0129
            androidx.compose.runtime.Recomposer r13 = r0.this$0
            r14 = r0
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r0.L$0 = r2
            r0.L$1 = r11
            r0.L$2 = r10
            r0.L$3 = r9
            r0.L$4 = r8
            r0.L$5 = r7
            r0.L$6 = r6
            r0.L$7 = r5
            r0.L$8 = r12
            r0.label = r4
            java.lang.Object r13 = r13.awaitWorkAvailable(r14)
            if (r13 != r1) goto L_0x00dd
            goto L_0x0111
        L_0x00dd:
            r13 = r11
            r11 = r8
            r8 = r12
            r12 = r9
            r9 = r13
            goto L_0x0071
        L_0x00e3:
            androidx.compose.runtime.Recomposer r5 = r0.this$0
            boolean r5 = r5.recordComposerModifications()
            if (r5 == 0) goto L_0x0120
            androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$1 r5 = new androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$1
            androidx.compose.runtime.Recomposer r6 = r0.this$0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r0.L$0 = r2
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r12
            r0.L$4 = r11
            r0.L$5 = r13
            r0.L$6 = r7
            r0.L$7 = r14
            r0.L$8 = r8
            r0.label = r3
            java.lang.Object r5 = r2.withFrameNanos(r5, r6)
            if (r5 != r1) goto L_0x0112
        L_0x0111:
            return r1
        L_0x0112:
            r5 = r12
            r12 = r8
            r8 = r11
            r11 = r9
            r9 = r5
            r6 = r7
            r7 = r13
            r5 = r14
        L_0x011a:
            androidx.compose.runtime.Recomposer r13 = r0.this$0
            r13.discardUnusedValues()
            goto L_0x00b5
        L_0x0120:
            r5 = r12
            r12 = r8
            r8 = r11
            r11 = r9
            r9 = r5
            r6 = r7
            r7 = r13
            r5 = r14
            goto L_0x00b5
        L_0x0129:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$clearRecompositionState(Recomposer recomposer, List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, MutableScatterSet<ControlledComposition> mutableScatterSet, MutableScatterSet<ControlledComposition> mutableScatterSet2, MutableScatterSet<Object> mutableScatterSet3, MutableScatterSet<ControlledComposition> mutableScatterSet4) {
        long j;
        long j2;
        long j3;
        Recomposer recomposer2 = recomposer;
        synchronized (recomposer2.stateLock) {
            list.clear();
            list2.clear();
            int size = list3.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = list3.get(i);
                controlledComposition.abandonChanges();
                recomposer2.recordFailedCompositionLocked(controlledComposition);
            }
            list3.clear();
            ScatterSet scatterSet = mutableScatterSet;
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            long j4 = 255;
            if (length >= 0) {
                Object[] objArr2 = objArr;
                int i2 = 0;
                while (true) {
                    long j5 = jArr[i2];
                    j2 = 128;
                    if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                        int i3 = 8 - ((~(i2 - length)) >>> 31);
                        int i4 = 0;
                        while (i4 < i3) {
                            if ((j5 & j4) < 128) {
                                j3 = j4;
                                ControlledComposition controlledComposition2 = (ControlledComposition) objArr2[(i2 << 3) + i4];
                                controlledComposition2.abandonChanges();
                                recomposer2.recordFailedCompositionLocked(controlledComposition2);
                            } else {
                                j3 = j4;
                            }
                            j5 >>= 8;
                            i4++;
                            j4 = j3;
                        }
                        j = j4;
                        if (i3 != 8) {
                            break;
                        }
                    } else {
                        j = j4;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                    j4 = j;
                }
            } else {
                j = 255;
                j2 = 128;
            }
            mutableScatterSet.clear();
            ScatterSet scatterSet2 = mutableScatterSet2;
            Object[] objArr3 = scatterSet2.elements;
            long[] jArr2 = scatterSet2.metadata;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                int i5 = 0;
                while (true) {
                    long j6 = jArr2[i5];
                    if ((((~j6) << 7) & j6 & -9187201950435737472L) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length2)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((j6 & j) < j2) {
                                ((ControlledComposition) objArr3[(i5 << 3) + i7]).changesApplied();
                            }
                            j6 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i5 == length2) {
                        break;
                    }
                    i5++;
                }
            }
            mutableScatterSet2.clear();
            mutableScatterSet3.clear();
            ScatterSet scatterSet3 = mutableScatterSet4;
            Object[] objArr4 = scatterSet3.elements;
            long[] jArr3 = scatterSet3.metadata;
            int length3 = jArr3.length - 2;
            if (length3 >= 0) {
                int i8 = 0;
                while (true) {
                    long j7 = jArr3[i8];
                    if ((((~j7) << 7) & j7 & -9187201950435737472L) != -9187201950435737472L) {
                        int i9 = 8 - ((~(i8 - length3)) >>> 31);
                        for (int i10 = 0; i10 < i9; i10++) {
                            if ((j7 & j) < j2) {
                                ControlledComposition controlledComposition3 = (ControlledComposition) objArr4[(i8 << 3) + i10];
                                controlledComposition3.abandonChanges();
                                recomposer2.recordFailedCompositionLocked(controlledComposition3);
                            }
                            j7 >>= 8;
                        }
                        if (i9 != 8) {
                            break;
                        }
                    }
                    if (i8 == length3) {
                        break;
                    }
                    i8++;
                }
            }
            mutableScatterSet4.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
        list.clear();
        synchronized (recomposer.stateLock) {
            List access$getCompositionValuesAwaitingInsert$p = recomposer.compositionValuesAwaitingInsert;
            int size = access$getCompositionValuesAwaitingInsert$p.size();
            for (int i = 0; i < size; i++) {
                list.add((MovableContentStateReference) access$getCompositionValuesAwaitingInsert$p.get(i));
            }
            recomposer.compositionValuesAwaitingInsert.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
