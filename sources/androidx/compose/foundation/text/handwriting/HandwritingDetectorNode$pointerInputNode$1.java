package androidx.compose.foundation.text.handwriting;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandwritingDetector.android.kt */
final class HandwritingDetectorNode$pointerInputNode$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ HandwritingDetectorNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandwritingDetectorNode$pointerInputNode$1(HandwritingDetectorNode handwritingDetectorNode) {
        super(0);
        this.this$0 = handwritingDetectorNode;
    }

    public final Boolean invoke() {
        this.this$0.getCallback().invoke();
        this.this$0.getComposeImm().prepareStylusHandwritingDelegation();
        return true;
    }
}
