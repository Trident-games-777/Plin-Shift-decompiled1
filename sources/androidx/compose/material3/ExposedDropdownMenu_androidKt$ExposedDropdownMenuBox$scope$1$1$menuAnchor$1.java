package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
final class ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<MenuAnchorType> $anchorTypeState;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;
    final /* synthetic */ String $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1(MutableState<MenuAnchorType> mutableState, String str, Function1<? super Boolean, Unit> function1, boolean z) {
        super(0);
        this.$anchorTypeState = mutableState;
        this.$type = str;
        this.$onExpandedChange = function1;
        this.$expanded = z;
    }

    public final void invoke() {
        this.$anchorTypeState.setValue(MenuAnchorType.m2192boximpl(this.$type));
        this.$onExpandedChange.invoke(Boolean.valueOf(!this.$expanded));
    }
}
