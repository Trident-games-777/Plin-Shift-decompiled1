package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandwritingGesture.android.kt */
final class HandwritingGestureApi34$performRemoveSpaceGesture$newText$1 extends Lambda implements Function1<MatchResult, CharSequence> {
    final /* synthetic */ Ref.IntRef $firstMatchStart;
    final /* synthetic */ Ref.IntRef $lastMatchEnd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandwritingGestureApi34$performRemoveSpaceGesture$newText$1(Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(1);
        this.$firstMatchStart = intRef;
        this.$lastMatchEnd = intRef2;
    }

    public final CharSequence invoke(MatchResult matchResult) {
        if (this.$firstMatchStart.element == -1) {
            this.$firstMatchStart.element = matchResult.getRange().getFirst();
        }
        this.$lastMatchEnd.element = matchResult.getRange().getLast() + 1;
        return "";
    }
}
