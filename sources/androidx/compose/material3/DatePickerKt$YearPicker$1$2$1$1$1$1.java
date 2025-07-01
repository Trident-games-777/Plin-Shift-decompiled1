package androidx.compose.material3;

import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$YearPicker$1$2$1$1$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ int $it;
    final /* synthetic */ LazyGridState $lazyGridState;
    final /* synthetic */ String $scrollToEarlierYearsLabel;
    final /* synthetic */ String $scrollToLaterYearsLabel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$YearPicker$1$2$1$1$1$1(LazyGridState lazyGridState, int i, CoroutineScope coroutineScope, String str, String str2) {
        super(1);
        this.$lazyGridState = lazyGridState;
        this.$it = i;
        this.$coroutineScope = coroutineScope;
        this.$scrollToEarlierYearsLabel = str;
        this.$scrollToLaterYearsLabel = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        List list;
        LazyGridItemInfo lazyGridItemInfo;
        if (this.$lazyGridState.getFirstVisibleItemIndex() == this.$it || ((lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull(this.$lazyGridState.getLayoutInfo().getVisibleItemsInfo())) != null && lazyGridItemInfo.getIndex() == this.$it)) {
            list = DatePickerKt.customScrollActions(this.$lazyGridState, this.$coroutineScope, this.$scrollToEarlierYearsLabel, this.$scrollToLaterYearsLabel);
        } else {
            list = CollectionsKt.emptyList();
        }
        SemanticsPropertiesKt.setCustomActions(semanticsPropertyReceiver, list);
    }
}
