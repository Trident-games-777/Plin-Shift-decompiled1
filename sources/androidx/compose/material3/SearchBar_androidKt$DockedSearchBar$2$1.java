package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$DockedSearchBar$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$DockedSearchBar$2$1(Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$onExpandedChange = function1;
    }

    public final void invoke() {
        this.$onExpandedChange.invoke(false);
    }
}
