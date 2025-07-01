package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1$1$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ OffsetProvider $offsetProvider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1$1$1(OffsetProvider offsetProvider) {
        super(0);
        this.$offsetProvider = offsetProvider;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(OffsetKt.m4006isSpecifiedk4lQ0M(this.$offsetProvider.m1569provideF1C5BW0()));
    }
}
