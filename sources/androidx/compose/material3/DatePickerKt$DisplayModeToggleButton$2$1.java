package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DisplayModeToggleButton$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<DisplayMode, Unit> $onDisplayModeChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DisplayModeToggleButton$2$1(Function1<? super DisplayMode, Unit> function1) {
        super(0);
        this.$onDisplayModeChange = function1;
    }

    public final void invoke() {
        this.$onDisplayModeChange.invoke(DisplayMode.m2023boximpl(DisplayMode.Companion.m2031getPickerjFl4v0()));
    }
}
