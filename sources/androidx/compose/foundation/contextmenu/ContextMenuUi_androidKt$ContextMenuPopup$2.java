package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextMenuUi.android.kt */
final class ContextMenuUi_androidKt$ContextMenuPopup$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ContextMenuColors $colors;
    final /* synthetic */ Function1<ContextMenuScope, Unit> $contextMenuBuilderBlock;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextMenuUi_androidKt$ContextMenuPopup$2(ContextMenuColors contextMenuColors, Modifier modifier, Function1<? super ContextMenuScope, Unit> function1) {
        super(2);
        this.$colors = contextMenuColors;
        this.$modifier = modifier;
        this.$contextMenuBuilderBlock = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C127@4727L205,127@4691L241:ContextMenuUi.android.kt#3xeu6s");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(795909757, i, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous> (ContextMenuUi.android.kt:127)");
            }
            ContextMenuColors contextMenuColors = this.$colors;
            Modifier modifier = this.$modifier;
            final Function1<ContextMenuScope, Unit> function1 = this.$contextMenuBuilderBlock;
            final ContextMenuColors contextMenuColors2 = this.$colors;
            ContextMenuUi_androidKt.ContextMenuColumn(contextMenuColors, modifier, ComposableLambdaKt.rememberComposableLambda(1156688164, true, new Function3<ColumnScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope columnScope, Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C128@4753L31,*132@4893L15:ContextMenuUi.android.kt#3xeu6s");
                    if ((i & 17) != 16 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1156688164, i, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous>.<anonymous> (ContextMenuUi.android.kt:128)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer, 1358376149, "CC(remember):ContextMenuUi.android.kt#9igjgp");
                        Object rememberedValue = composer.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new ContextMenuScope();
                            composer.updateRememberedValue(rememberedValue);
                        }
                        ContextMenuScope contextMenuScope = (ContextMenuScope) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        Function1<ContextMenuScope, Unit> function1 = function1;
                        ContextMenuColors contextMenuColors = contextMenuColors2;
                        contextMenuScope.clear$foundation_release();
                        function1.invoke(contextMenuScope);
                        contextMenuScope.Content$foundation_release(contextMenuColors, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }, composer, 54), composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
