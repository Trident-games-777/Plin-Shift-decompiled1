package androidx.fragment.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0001H\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"fragmentStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/fragment/compose/FragmentState;", "rememberFragmentState", "(Landroidx/compose/runtime/Composer;I)Landroidx/fragment/compose/FragmentState;", "fragment-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FragmentState.kt */
public final class FragmentStateKt {
    public static final FragmentState rememberFragmentState(Composer composer, int i) {
        composer.startReplaceableGroup(-496803845);
        ComposerKt.sourceInformation(composer, "C(rememberFragmentState)32@1157L78:FragmentState.kt#dnbm1l");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-496803845, i, -1, "androidx.fragment.compose.rememberFragmentState (FragmentState.kt:31)");
        }
        Composer composer2 = composer;
        FragmentState fragmentState = (FragmentState) RememberSaveableKt.rememberSaveable(new Object[0], fragmentStateSaver(), (String) null, FragmentStateKt$rememberFragmentState$1.INSTANCE, composer2, 3072, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return fragmentState;
    }

    private static final Saver<FragmentState, ?> fragmentStateSaver() {
        return SaverKt.Saver(FragmentStateKt$fragmentStateSaver$1.INSTANCE, FragmentStateKt$fragmentStateSaver$2.INSTANCE);
    }
}
