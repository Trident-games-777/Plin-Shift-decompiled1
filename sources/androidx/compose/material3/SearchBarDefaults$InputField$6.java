package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBarDefaults$InputField$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;
    final /* synthetic */ Function1<String, Unit> $onQueryChange;
    final /* synthetic */ Function1<String, Unit> $onSearch;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ String $query;
    final /* synthetic */ SearchBarDefaults $tmp7_rcvr;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarDefaults$InputField$6(SearchBarDefaults searchBarDefaults, String str, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z, Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3) {
        super(2);
        this.$tmp7_rcvr = searchBarDefaults;
        this.$query = str;
        this.$onQueryChange = function1;
        this.$onSearch = function12;
        this.$expanded = z;
        this.$onExpandedChange = function13;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$placeholder = function2;
        this.$leadingIcon = function22;
        this.$trailingIcon = function23;
        this.$colors = textFieldColors;
        this.$interactionSource = mutableInteractionSource;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp7_rcvr.InputField(this.$query, this.$onQueryChange, this.$onSearch, this.$expanded, this.$onExpandedChange, this.$modifier, this.$enabled, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
