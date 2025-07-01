package androidx.compose.foundation.text;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "invoke-nOcc-ac", "()J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLinkScope.kt */
final class TextLinkScope$textRange$1$1 extends Lambda implements Function0<IntOffset> {
    final /* synthetic */ IntRect $bounds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextLinkScope$textRange$1$1(IntRect intRect) {
        super(0);
        this.$bounds = intRect;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return IntOffset.m7232boximpl(m1296invokenOccac());
    }

    /* renamed from: invoke-nOcc-ac  reason: not valid java name */
    public final long m1296invokenOccac() {
        return this.$bounds.m7269getTopLeftnOccac();
    }
}
