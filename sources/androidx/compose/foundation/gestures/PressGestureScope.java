package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TapGestureDetector.kt */
public interface PressGestureScope extends Density {
    Object awaitRelease(Continuation<? super Unit> continuation);

    Object tryAwaitRelease(Continuation<? super Boolean> continuation);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TapGestureDetector.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m507roundToPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.m7085roundToPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m508roundToPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.m7086roundToPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m509toDpGaN1DYA(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.m7222toDpGaN1DYA(j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m510toDpu2uoSUM(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.m7087toDpu2uoSUM(f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m511toDpu2uoSUM(PressGestureScope pressGestureScope, int i) {
            return PressGestureScope.super.m7088toDpu2uoSUM(i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m512toDpSizekrfVVM(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.m7089toDpSizekrfVVM(j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m513toPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.m7090toPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m514toPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.m7091toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(PressGestureScope pressGestureScope, DpRect dpRect) {
            return PressGestureScope.super.toRect(dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m515toSizeXkaWNTQ(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.m7092toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m516toSp0xMU5do(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.m7223toSp0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m517toSpkPz2Gy4(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.m7093toSpkPz2Gy4(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m518toSpkPz2Gy4(PressGestureScope pressGestureScope, int i) {
            return PressGestureScope.super.m7094toSpkPz2Gy4(i);
        }
    }
}
