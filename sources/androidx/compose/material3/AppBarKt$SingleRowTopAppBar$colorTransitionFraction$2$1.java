package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$SingleRowTopAppBar$colorTransitionFraction$2$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$SingleRowTopAppBar$colorTransitionFraction$2$1(TopAppBarScrollBehavior topAppBarScrollBehavior) {
        super(0);
        this.$scrollBehavior = topAppBarScrollBehavior;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Float invoke() {
        /*
            r3 = this;
            androidx.compose.material3.TopAppBarScrollBehavior r0 = r3.$scrollBehavior
            r1 = 0
            if (r0 == 0) goto L_0x0010
            androidx.compose.material3.TopAppBarState r0 = r0.getState()
            if (r0 == 0) goto L_0x0010
            float r0 = r0.getOverlappedFraction()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            r2 = 1008981770(0x3c23d70a, float:0.01)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x001a
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x001a:
            java.lang.Float r0 = java.lang.Float.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$colorTransitionFraction$2$1.invoke():java.lang.Float");
    }
}
