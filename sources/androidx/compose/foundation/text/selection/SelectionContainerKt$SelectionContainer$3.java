package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionContainer.kt */
final class SelectionContainerKt$SelectionContainer$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $children;
    final /* synthetic */ SelectionManager $manager;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ SelectionRegistrarImpl $registrarImpl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionContainerKt$SelectionContainer$3(SelectionRegistrarImpl selectionRegistrarImpl, Modifier modifier, SelectionManager selectionManager, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.$registrarImpl = selectionRegistrarImpl;
        this.$modifier = modifier;
        this.$manager = selectionManager;
        this.$children = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C104@3930L1971,104@3857L2044:SelectionContainer.kt#eksfi3");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-123806316, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous> (SelectionContainer.kt:104)");
            }
            ProvidedValue<SelectionRegistrar> provides = SelectionRegistrarKt.getLocalSelectionRegistrar().provides(this.$registrarImpl);
            final Modifier modifier = this.$modifier;
            final SelectionManager selectionManager = this.$manager;
            final Function2<Composer, Integer, Unit> function2 = this.$children;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(935424596, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C107@4138L1753,107@4081L1810:SelectionContainer.kt#eksfi3");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(935424596, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:107)");
                        }
                        Modifier then = modifier.then(selectionManager.getModifier());
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final SelectionManager selectionManager = selectionManager;
                        SimpleLayoutKt.SimpleLayout(then, ComposableLambdaKt.rememberComposableLambda(1375295262, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                ResolvedTextDirection resolvedTextDirection;
                                Function0 function0;
                                Composer composer2 = composer;
                                int i2 = i;
                                ComposerKt.sourceInformation(composer2, "C108@4156L10:SelectionContainer.kt#eksfi3");
                                if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1375295262, i2, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:108)");
                                    }
                                    function2.invoke(composer2, 0);
                                    if (!selectionManager.isInTouchMode() || !selectionManager.getHasFocus() || selectionManager.isTriviallyCollapsedSelection$foundation_release()) {
                                        composer2.startReplaceGroup(-880741817);
                                        composer2.endReplaceGroup();
                                    } else {
                                        composer2.startReplaceGroup(-882227523);
                                        ComposerKt.sourceInformation(composer2, "");
                                        Selection selection = selectionManager.getSelection();
                                        if (selection == null) {
                                            composer2.startReplaceGroup(-882188681);
                                        } else {
                                            composer2.startReplaceGroup(-882188680);
                                            ComposerKt.sourceInformation(composer2, "");
                                            SelectionManager selectionManager = selectionManager;
                                            composer2.startReplaceGroup(1495564482);
                                            ComposerKt.sourceInformation(composer2, "*115@4496L129,119@4692L361,138@5661L119,133@5316L495");
                                            List listOf = CollectionsKt.listOf(true, false);
                                            int size = listOf.size();
                                            for (int i3 = 0; i3 < size; i3++) {
                                                boolean booleanValue = ((Boolean) listOf.get(i3)).booleanValue();
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1635778182, "CC(remember):SelectionContainer.kt#9igjgp");
                                                boolean changed = composer2.changed(booleanValue);
                                                Object rememberedValue = composer2.rememberedValue();
                                                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                                    rememberedValue = selectionManager.handleDragObserver(booleanValue);
                                                    composer2.updateRememberedValue(rememberedValue);
                                                }
                                                TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1635771678, "CC(remember):SelectionContainer.kt#9igjgp");
                                                boolean changed2 = composer2.changed(booleanValue);
                                                Object rememberedValue2 = composer2.rememberedValue();
                                                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                                    if (booleanValue) {
                                                        function0 = new SelectionContainerKt$SelectionContainer$3$1$1$1$1$positionProvider$1$1(selectionManager);
                                                    } else {
                                                        function0 = new SelectionContainerKt$SelectionContainer$3$1$1$1$1$positionProvider$1$2(selectionManager);
                                                    }
                                                    rememberedValue2 = function0;
                                                    composer2.updateRememberedValue(rememberedValue2);
                                                }
                                                Function0 function02 = (Function0) rememberedValue2;
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                if (booleanValue) {
                                                    resolvedTextDirection = selection.getStart().getDirection();
                                                } else {
                                                    resolvedTextDirection = selection.getEnd().getDirection();
                                                }
                                                OffsetProvider selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 = new SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(function02);
                                                boolean handlesCrossed = selection.getHandlesCrossed();
                                                Modifier modifier = Modifier.Companion;
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1635740912, "CC(remember):SelectionContainer.kt#9igjgp");
                                                boolean changedInstance = composer2.changedInstance(textDragObserver);
                                                Object rememberedValue3 = composer2.rememberedValue();
                                                if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                                                    rememberedValue3 = new SelectionContainerKt$SelectionContainer$3$1$1$1$1$1$1(textDragObserver, (Continuation<? super SelectionContainerKt$SelectionContainer$3$1$1$1$1$1$1>) null);
                                                    composer2.updateRememberedValue(rememberedValue3);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                AndroidSelectionHandles_androidKt.m1553SelectionHandlepzduO1o(selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0, booleanValue, resolvedTextDirection, handlesCrossed, 0, SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue3), composer2, 0, 16);
                                            }
                                            composer2.endReplaceGroup();
                                        }
                                        composer2.endReplaceGroup();
                                        composer2.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composer, 54), composer, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
