package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Lkotlin/Unit;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
final class SharedTransitionScopeImpl$sharedElementWithCallerManagedVisibility$1 extends Lambda implements Function1<Unit, Boolean> {
    final /* synthetic */ boolean $visible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedTransitionScopeImpl$sharedElementWithCallerManagedVisibility$1(boolean z) {
        super(1);
        this.$visible = z;
    }

    public final Boolean invoke(Unit unit) {
        return Boolean.valueOf(this.$visible);
    }
}
