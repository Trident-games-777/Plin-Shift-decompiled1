package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$SelectionHandle$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $isLeft;
    final /* synthetic */ long $minTouchTargetSize;
    final /* synthetic */ OffsetProvider $offsetProvider;
    final /* synthetic */ Modifier $semanticsModifier;
    final /* synthetic */ ViewConfiguration $viewConfiguration;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$SelectionHandle$1(ViewConfiguration viewConfiguration, long j, boolean z, Modifier modifier, OffsetProvider offsetProvider) {
        super(2);
        this.$viewConfiguration = viewConfiguration;
        this.$minTouchTargetSize = j;
        this.$isLeft = z;
        this.$semanticsModifier = modifier;
        this.$offsetProvider = offsetProvider;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C82@3665L1180,82@3589L1256:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(280174801, i, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:82)");
            }
            ProvidedValue<ViewConfiguration> provides = CompositionLocalsKt.getLocalViewConfiguration().provides(this.$viewConfiguration);
            final long j = this.$minTouchTargetSize;
            final boolean z = this.$isLeft;
            final Modifier modifier = this.$semanticsModifier;
            final OffsetProvider offsetProvider = this.$offsetProvider;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1426434671, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    Arrangement.Horizontal horizontal;
                    ComposerKt.sourceInformation(composer, "C:AndroidSelectionHandles.android.kt#eksfi3");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1426434671, i, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous>.<anonymous> (AndroidSelectionHandles.android.kt:83)");
                        }
                        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
                            composer.startReplaceGroup(-837727128);
                            ComposerKt.sourceInformation(composer, "92@4044L538");
                            if (z) {
                                horizontal = Arrangement.Absolute.INSTANCE.getRight();
                            } else {
                                horizontal = Arrangement.Absolute.INSTANCE.getLeft();
                            }
                            Modifier r2 = SizeKt.m841requiredSizeInqDBjuR0$default(modifier, DpSize.m7209getWidthD9Ej5fM(j), DpSize.m7207getHeightD9Ej5fM(j), 0.0f, 0.0f, 12, (Object) null);
                            OffsetProvider offsetProvider = offsetProvider;
                            boolean z = z;
                            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, Alignment.Companion.getTop(), composer, 0);
                            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, r2);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer.startReusableNode();
                            if (composer.getInserting()) {
                                composer.createNode(constructor);
                            } else {
                                composer.useNode();
                            }
                            Composer r6 = Updater.m3675constructorimpl(composer);
                            Updater.m3682setimpl(r6, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3682setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m3682setimpl(r6, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer, -2057944533, "C101@4460L40,99@4356L208:AndroidSelectionHandles.android.kt#eksfi3");
                            Modifier modifier = Modifier.Companion;
                            ComposerKt.sourceInformationMarkerStart(composer, -482024144, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
                            boolean changedInstance = composer.changedInstance(offsetProvider);
                            Object rememberedValue = composer.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1$1$1(offsetProvider);
                                composer.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            AndroidSelectionHandles_androidKt.SelectionHandleIcon(modifier, (Function0) rememberedValue, z, composer, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            composer.endReplaceGroup();
                        } else {
                            composer.startReplaceGroup(-836867312);
                            ComposerKt.sourceInformation(composer, "108@4725L40,106@4620L201");
                            Modifier modifier2 = modifier;
                            ComposerKt.sourceInformationMarkerStart(composer, 1912670673, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
                            boolean changedInstance2 = composer.changedInstance(offsetProvider);
                            OffsetProvider offsetProvider2 = offsetProvider;
                            Object rememberedValue2 = composer.rememberedValue();
                            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new AndroidSelectionHandles_androidKt$SelectionHandle$1$1$2$1(offsetProvider2);
                                composer.updateRememberedValue(rememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            AndroidSelectionHandles_androidKt.SelectionHandleIcon(modifier2, (Function0) rememberedValue2, z, composer, 0);
                            composer.endReplaceGroup();
                        }
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
