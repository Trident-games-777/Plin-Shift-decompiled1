package androidx.compose.material3;

import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
final class ExposedDropdownMenu_androidKt$expandable$2 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $anchorType;
    final /* synthetic */ String $collapsedDescription;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ String $expandedDescription;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    final /* synthetic */ Function0<Unit> $onExpandedChange;
    final /* synthetic */ String $toggleDescription;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenu_androidKt$expandable$2(String str, boolean z, String str2, String str3, String str4, Function0<Unit> function0, SoftwareKeyboardController softwareKeyboardController) {
        super(1);
        this.$anchorType = str;
        this.$expanded = z;
        this.$expandedDescription = str2;
        this.$collapsedDescription = str3;
        this.$toggleDescription = str4;
        this.$onExpandedChange = function0;
        this.$keyboardController = softwareKeyboardController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (MenuAnchorType.m2195equalsimpl0(this.$anchorType, MenuAnchorType.Companion.m2201getSecondaryEditableMg6Rgbw())) {
            SemanticsPropertiesKt.m6386setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m6367getButtono7Vup1c());
            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, this.$expanded ? this.$expandedDescription : this.$collapsedDescription);
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, this.$toggleDescription);
        } else {
            SemanticsPropertiesKt.m6386setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m6369getDropdownListo7Vup1c());
        }
        final Function0<Unit> function0 = this.$onExpandedChange;
        final String str = this.$anchorType;
        final SoftwareKeyboardController softwareKeyboardController = this.$keyboardController;
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                SoftwareKeyboardController softwareKeyboardController;
                function0.invoke();
                if (MenuAnchorType.m2195equalsimpl0(str, MenuAnchorType.Companion.m2199getPrimaryEditableMg6Rgbw()) && (softwareKeyboardController = softwareKeyboardController) != null) {
                    softwareKeyboardController.show();
                }
                return true;
            }
        }, 1, (Object) null);
    }
}
