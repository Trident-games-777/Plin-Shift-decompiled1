package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J&\u0010\n\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u00038PX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"androidx/compose/material3/ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "anchorType", "Landroidx/compose/material3/MenuAnchorType;", "getAnchorType-Mg6Rgbw$material3_release", "()Ljava/lang/String;", "exposedDropdownSize", "Landroidx/compose/ui/Modifier;", "matchTextFieldWidth", "", "menuAnchor", "type", "enabled", "menuAnchor-fsE2BvY", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
public final class ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 extends ExposedDropdownMenuBoxScopeImpl {
    final /* synthetic */ MutableState<MenuAnchorType> $anchorTypeState;
    final /* synthetic */ MutableIntState $anchorWidth$delegate;
    final /* synthetic */ String $collapsedDescription;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ String $expandedDescription;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    final /* synthetic */ MutableIntState $menuMaxHeight$delegate;
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;
    final /* synthetic */ String $toggleDescription;

    ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1(FocusRequester focusRequester, boolean z, String str, String str2, String str3, SoftwareKeyboardController softwareKeyboardController, MutableState<MenuAnchorType> mutableState, Function1<? super Boolean, Unit> function1, MutableIntState mutableIntState, MutableIntState mutableIntState2) {
        this.$focusRequester = focusRequester;
        this.$expanded = z;
        this.$expandedDescription = str;
        this.$collapsedDescription = str2;
        this.$toggleDescription = str3;
        this.$keyboardController = softwareKeyboardController;
        this.$anchorTypeState = mutableState;
        this.$onExpandedChange = function1;
        this.$anchorWidth$delegate = mutableIntState;
        this.$menuMaxHeight$delegate = mutableIntState2;
    }

    /* renamed from: menuAnchor-fsE2BvY  reason: not valid java name */
    public Modifier m2066menuAnchorfsE2BvY(Modifier modifier, String str, boolean z) {
        Modifier modifier2;
        Modifier focusRequester = FocusRequesterModifierKt.focusRequester(modifier, this.$focusRequester);
        if (!z) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = ExposedDropdownMenu_androidKt.m2064expandableGq7TBQ4(Modifier.Companion, this.$expanded, new ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1(this.$anchorTypeState, str, this.$onExpandedChange, this.$expanded), str, this.$expandedDescription, this.$collapsedDescription, this.$toggleDescription, this.$keyboardController);
        }
        return focusRequester.then(modifier2);
    }

    /* renamed from: getAnchorType-Mg6Rgbw$material3_release  reason: not valid java name */
    public String m2065getAnchorTypeMg6Rgbw$material3_release() {
        return this.$anchorTypeState.getValue().m2198unboximpl();
    }

    public Modifier exposedDropdownSize(Modifier modifier, boolean z) {
        return LayoutModifierKt.layout(modifier, new ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1(z, this.$anchorWidth$delegate, this.$menuMaxHeight$delegate));
    }
}
