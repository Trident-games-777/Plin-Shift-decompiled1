package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLinkScope.kt */
final class TextLinkScope$StyleAnnotation$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function1<TextAnnotatorScope, Unit> $block;
    final /* synthetic */ Object[] $keys;
    final /* synthetic */ TextLinkScope $tmp1_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextLinkScope$StyleAnnotation$2(TextLinkScope textLinkScope, Object[] objArr, Function1<? super TextAnnotatorScope, Unit> function1, int i) {
        super(2);
        this.$tmp1_rcvr = textLinkScope;
        this.$keys = objArr;
        this.$block = function1;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TextLinkScope textLinkScope = this.$tmp1_rcvr;
        Object[] objArr = this.$keys;
        textLinkScope.StyleAnnotation(Arrays.copyOf(objArr, objArr.length), this.$block, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
