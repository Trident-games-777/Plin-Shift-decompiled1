package androidx.compose.foundation.text;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLinkScope.kt */
final class TextLinkScope$StyleAnnotation$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Function1<TextAnnotatorScope, Unit> $block;
    final /* synthetic */ TextLinkScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextLinkScope$StyleAnnotation$1$1(TextLinkScope textLinkScope, Function1<? super TextAnnotatorScope, Unit> function1) {
        super(1);
        this.this$0 = textLinkScope;
        this.$block = function1;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        this.this$0.annotators.add(this.$block);
        return new TextLinkScope$StyleAnnotation$1$1$invoke$$inlined$onDispose$1(this.this$0, this.$block);
    }
}
