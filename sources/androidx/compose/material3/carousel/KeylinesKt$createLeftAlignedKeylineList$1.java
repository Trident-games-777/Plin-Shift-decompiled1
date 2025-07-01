package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/material3/carousel/KeylineListScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Keylines.kt */
final class KeylinesKt$createLeftAlignedKeylineList$1 extends Lambda implements Function1<KeylineListScope, Unit> {
    final /* synthetic */ Arrangement $arrangement;
    final /* synthetic */ float $leftAnchorSize;
    final /* synthetic */ float $rightAnchorSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KeylinesKt$createLeftAlignedKeylineList$1(float f, Arrangement arrangement, float f2) {
        super(1);
        this.$leftAnchorSize = f;
        this.$arrangement = arrangement;
        this.$rightAnchorSize = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeylineListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(KeylineListScope keylineListScope) {
        keylineListScope.add(this.$leftAnchorSize, true);
        int largeCount = this.$arrangement.getLargeCount();
        Arrangement arrangement = this.$arrangement;
        for (int i = 0; i < largeCount; i++) {
            KeylineListScope.add$default(keylineListScope, arrangement.getLargeSize(), false, 2, (Object) null);
        }
        int mediumCount = this.$arrangement.getMediumCount();
        Arrangement arrangement2 = this.$arrangement;
        for (int i2 = 0; i2 < mediumCount; i2++) {
            KeylineListScope.add$default(keylineListScope, arrangement2.getMediumSize(), false, 2, (Object) null);
        }
        int smallCount = this.$arrangement.getSmallCount();
        Arrangement arrangement3 = this.$arrangement;
        for (int i3 = 0; i3 < smallCount; i3++) {
            KeylineListScope.add$default(keylineListScope, arrangement3.getSmallSize(), false, 2, (Object) null);
        }
        keylineListScope.add(this.$rightAnchorSize, true);
    }
}
