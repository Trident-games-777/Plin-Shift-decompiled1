package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "needle", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
final class LazyLayoutSemanticsModifierNode$indexForKeyMapping$1 extends Lambda implements Function1<Object, Integer> {
    final /* synthetic */ LazyLayoutSemanticsModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutSemanticsModifierNode$indexForKeyMapping$1(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode) {
        super(1);
        this.this$0 = lazyLayoutSemanticsModifierNode;
    }

    public final Integer invoke(Object obj) {
        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.this$0.itemProviderLambda.invoke();
        int itemCount = lazyLayoutItemProvider.getItemCount();
        int i = 0;
        while (true) {
            if (i >= itemCount) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(lazyLayoutItemProvider.getKey(i), obj)) {
                break;
            } else {
                i++;
            }
        }
        return Integer.valueOf(i);
    }
}
