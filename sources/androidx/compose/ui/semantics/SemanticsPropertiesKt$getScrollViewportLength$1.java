package androidx.compose.ui.semantics;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "invoke", "(Ljava/util/List;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsProperties.kt */
final class SemanticsPropertiesKt$getScrollViewportLength$1 extends Lambda implements Function1<List<Float>, Boolean> {
    final /* synthetic */ Function0<Float> $action;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SemanticsPropertiesKt$getScrollViewportLength$1(Function0<Float> function0) {
        super(1);
        this.$action = function0;
    }

    public final Boolean invoke(List<Float> list) {
        boolean z;
        Float invoke = this.$action.invoke();
        if (invoke == null) {
            z = false;
        } else {
            list.add(invoke);
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
