package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.lifecycle.Lifecycle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Wrapper.android.kt */
final class WrappedComposition$setContent$1 extends Lambda implements Function1<AndroidComposeView.ViewTreeOwners, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ WrappedComposition this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WrappedComposition$setContent$1(WrappedComposition wrappedComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(1);
        this.this$0 = wrappedComposition;
        this.$content = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AndroidComposeView.ViewTreeOwners) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AndroidComposeView.ViewTreeOwners viewTreeOwners) {
        if (!this.this$0.disposed) {
            Lifecycle lifecycle = viewTreeOwners.getLifecycleOwner().getLifecycle();
            this.this$0.lastContent = this.$content;
            if (this.this$0.addedToLifecycle == null) {
                this.this$0.addedToLifecycle = lifecycle;
                lifecycle.addObserver(this.this$0);
            } else if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                Composition original = this.this$0.getOriginal();
                final WrappedComposition wrappedComposition = this.this$0;
                final Function2<Composer, Integer, Unit> function2 = this.$content;
                original.setContent(ComposableLambdaKt.composableLambdaInstance(-2000640158, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C146@6196L99,146@6174L121,149@6342L100,149@6320L122,153@6541L103,153@6468L176:Wrapper.android.kt#itgzvw");
                        if ((i & 3) != 2 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2000640158, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:134)");
                            }
                            Object tag = wrappedComposition.getOwner().getTag(R.id.inspection_slot_table_set);
                            Set set = TypeIntrinsics.isMutableSet(tag) ? (Set) tag : null;
                            if (set == null) {
                                ViewParent parent = wrappedComposition.getOwner().getParent();
                                View view = parent instanceof View ? (View) parent : null;
                                Object tag2 = view != null ? view.getTag(R.id.inspection_slot_table_set) : null;
                                set = TypeIntrinsics.isMutableSet(tag2) ? (Set) tag2 : null;
                            }
                            if (set != null) {
                                set.add(composer.getCompositionData());
                                composer.collectParameterInformation();
                            }
                            AndroidComposeView owner = wrappedComposition.getOwner();
                            ComposerKt.sourceInformationMarkerStart(composer, 828769887, "CC(remember):Wrapper.android.kt#9igjgp");
                            boolean changedInstance = composer.changedInstance(wrappedComposition);
                            WrappedComposition wrappedComposition = wrappedComposition;
                            Object rememberedValue = composer.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new WrappedComposition$setContent$1$1$1$1(wrappedComposition, (Continuation<? super WrappedComposition$setContent$1$1$1$1>) null);
                                composer.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            EffectsKt.LaunchedEffect((Object) owner, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue, composer, 0);
                            AndroidComposeView owner2 = wrappedComposition.getOwner();
                            ComposerKt.sourceInformationMarkerStart(composer, 828774560, "CC(remember):Wrapper.android.kt#9igjgp");
                            boolean changedInstance2 = composer.changedInstance(wrappedComposition);
                            WrappedComposition wrappedComposition2 = wrappedComposition;
                            Object rememberedValue2 = composer.rememberedValue();
                            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new WrappedComposition$setContent$1$1$2$1(wrappedComposition2, (Continuation<? super WrappedComposition$setContent$1$1$2$1>) null);
                                composer.updateRememberedValue(rememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            EffectsKt.LaunchedEffect((Object) owner2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, composer, 0);
                            ProvidedValue<Set<CompositionData>> provides = InspectionTablesKt.getLocalInspectionTables().provides(set);
                            final WrappedComposition wrappedComposition3 = wrappedComposition;
                            final Function2<Composer, Integer, Unit> function2 = function2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1193460702, true, new Function2<Composer, Integer, Unit>() {
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer, int i) {
                                    ComposerKt.sourceInformation(composer, "C154@6571L47:Wrapper.android.kt#itgzvw");
                                    if ((i & 3) != 2 || !composer.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1193460702, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:154)");
                                        }
                                        AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(wrappedComposition3.getOwner(), function2, composer, 0);
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
                }));
            }
        }
    }
}
