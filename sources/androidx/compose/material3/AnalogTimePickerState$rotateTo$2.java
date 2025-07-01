package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$rotateTo$2", f = "TimePicker.kt", i = {}, l = {803, 806}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TimePicker.kt */
final class AnalogTimePickerState$rotateTo$2 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
    final /* synthetic */ float $angle;
    final /* synthetic */ boolean $animate;
    int label;
    final /* synthetic */ AnalogTimePickerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnalogTimePickerState$rotateTo$2(AnalogTimePickerState analogTimePickerState, float f, boolean z, Continuation<? super AnalogTimePickerState$rotateTo$2> continuation) {
        super(1, continuation);
        this.this$0 = analogTimePickerState;
        this.$angle = f;
        this.$animate = z;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AnalogTimePickerState$rotateTo$2(this.this$0, this.$angle, this.$animate, continuation);
    }

    public final Object invoke(Continuation<Object> continuation) {
        return ((AnalogTimePickerState$rotateTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a9, code lost:
        if (r11.this$0.anim.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(r11.this$0.offsetAngle(r11.$angle)), r11) == r0) goto L_0x00e1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r12)
            return r12
        L_0x0012:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00ac
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.material3.AnalogTimePickerState r12 = r11.this$0
            int r12 = r12.m1708getSelectionyecRtBI()
            androidx.compose.material3.TimePickerSelectionMode$Companion r1 = androidx.compose.material3.TimePickerSelectionMode.Companion
            int r1 = r1.m2754getHouryecRtBI()
            boolean r12 = androidx.compose.material3.TimePickerSelectionMode.m2750equalsimpl0(r12, r1)
            if (r12 == 0) goto L_0x0067
            androidx.compose.material3.AnalogTimePickerState r12 = r11.this$0
            float r1 = r11.$angle
            int r1 = r12.toHour(r1)
            r4 = 12
            int r1 = r1 % r4
            float r1 = (float) r1
            r5 = 1057360530(0x3f060a92, float:0.5235988)
            float r1 = r1 * r5
            r12.hourAngle = r1
            androidx.compose.material3.AnalogTimePickerState r12 = r11.this$0
            androidx.compose.material3.TimePickerState r12 = r12.getState()
            androidx.compose.material3.AnalogTimePickerState r1 = r11.this$0
            float r5 = r1.hourAngle
            int r1 = r1.toHour(r5)
            int r1 = r1 % r4
            androidx.compose.material3.AnalogTimePickerState r5 = r11.this$0
            boolean r5 = r5.isAfternoon()
            if (r5 == 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r4 = 0
        L_0x0062:
            int r1 = r1 + r4
            r12.setHour(r1)
            goto L_0x008a
        L_0x0067:
            androidx.compose.material3.AnalogTimePickerState r12 = r11.this$0
            float r1 = r11.$angle
            int r1 = r12.toMinute(r1)
            float r1 = (float) r1
            r4 = 1037465424(0x3dd67750, float:0.10471976)
            float r1 = r1 * r4
            r12.minuteAngle = r1
            androidx.compose.material3.AnalogTimePickerState r12 = r11.this$0
            androidx.compose.material3.TimePickerState r12 = r12.getState()
            androidx.compose.material3.AnalogTimePickerState r1 = r11.this$0
            float r4 = r1.minuteAngle
            int r1 = r1.toMinute(r4)
            r12.setMinute(r1)
        L_0x008a:
            boolean r12 = r11.$animate
            if (r12 != 0) goto L_0x00af
            androidx.compose.material3.AnalogTimePickerState r12 = r11.this$0
            androidx.compose.animation.core.Animatable r12 = r12.anim
            androidx.compose.material3.AnalogTimePickerState r1 = r11.this$0
            float r2 = r11.$angle
            float r1 = r1.offsetAngle(r2)
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r11.label = r3
            java.lang.Object r12 = r12.snapTo(r1, r2)
            if (r12 != r0) goto L_0x00ac
            goto L_0x00e1
        L_0x00ac:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00af:
            androidx.compose.material3.AnalogTimePickerState r12 = r11.this$0
            float r1 = r11.$angle
            float r1 = r12.offsetAngle(r1)
            float r12 = r12.endValueForAnimation(r1)
            androidx.compose.material3.AnalogTimePickerState r1 = r11.this$0
            androidx.compose.animation.core.Animatable r3 = r1.anim
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r12)
            r12 = 1143930880(0x442f0000, float:700.0)
            r1 = 4
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            androidx.compose.animation.core.SpringSpec r12 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r5, r12, r6, r1, r6)
            r5 = r12
            androidx.compose.animation.core.AnimationSpec r5 = (androidx.compose.animation.core.AnimationSpec) r5
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r11.label = r2
            r7 = 0
            r9 = 12
            r10 = 0
            java.lang.Object r12 = androidx.compose.animation.core.Animatable.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L_0x00e2
        L_0x00e1:
            return r0
        L_0x00e2:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AnalogTimePickerState$rotateTo$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
