package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$SelectionToolbarAndHandles$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ boolean $show;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$SelectionToolbarAndHandles$2(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i) {
        super(2);
        this.$manager = textFieldSelectionManager;
        this.$show = z;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        CoreTextFieldKt.SelectionToolbarAndHandles(this.$manager, this.$show, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
