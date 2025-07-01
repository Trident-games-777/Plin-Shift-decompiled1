package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$ModalBottomSheet$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $animateToDismiss;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, WindowInsets> $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ Function1<Float, Unit> $settleToDismiss;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $sheetMaxWidth;
    final /* synthetic */ SheetState $sheetState;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$ModalBottomSheet$3(long j, Function0<Unit> function0, SheetState sheetState, Animatable<Float, AnimationVector1D> animatable, CoroutineScope coroutineScope, Function1<? super Float, Unit> function1, Modifier modifier, float f, Shape shape, long j2, long j3, float f2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, ? extends WindowInsets> function22, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$scrimColor = j;
        this.$animateToDismiss = function0;
        this.$sheetState = sheetState;
        this.$predictiveBackProgress = animatable;
        this.$scope = coroutineScope;
        this.$settleToDismiss = function1;
        this.$modifier = modifier;
        this.$sheetMaxWidth = f;
        this.$shape = shape;
        this.$containerColor = j2;
        this.$contentColor = j3;
        this.$tonalElevation = f2;
        this.$dragHandle = function2;
        this.$contentWindowInsets = function22;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C168@8241L755:ModalBottomSheet.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-314673510, i2, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:168)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null)), false, AnonymousClass1.INSTANCE, 1, (Object) null);
            long j = this.$scrimColor;
            Function0<Unit> function0 = this.$animateToDismiss;
            long j2 = j;
            SheetState sheetState = this.$sheetState;
            Animatable<Float, AnimationVector1D> animatable = this.$predictiveBackProgress;
            CoroutineScope coroutineScope = this.$scope;
            Function1<Float, Unit> function1 = this.$settleToDismiss;
            Modifier modifier = this.$modifier;
            long j3 = j2;
            float f = this.$sheetMaxWidth;
            Shape shape = this.$shape;
            Animatable<Float, AnimationVector1D> animatable2 = animatable;
            CoroutineScope coroutineScope2 = coroutineScope;
            long j4 = this.$containerColor;
            Function1<Float, Unit> function12 = function1;
            Modifier modifier2 = modifier;
            long j5 = this.$contentColor;
            long j6 = j3;
            float f2 = this.$tonalElevation;
            Function2<Composer, Integer, Unit> function2 = this.$dragHandle;
            Function2<Composer, Integer, WindowInsets> function22 = this.$contentWindowInsets;
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            Function2<Composer, Integer, WindowInsets> function23 = function22;
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, semantics$default);
            int i3 = currentCompositeKeyHash;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function0<Unit> function02 = function0;
            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer r2 = Updater.m3675constructorimpl(composer2);
            Updater.m3682setimpl(r2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r2.getInserting() || !Intrinsics.areEqual(r2.rememberedValue(), (Object) Integer.valueOf(i3))) {
                r2.updateRememberedValue(Integer.valueOf(i3));
                r2.apply(Integer.valueOf(i3), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1107507610, "C169@8345L169,174@8527L459:ModalBottomSheet.kt#uh7d8r");
            Function0<Unit> function03 = function02;
            ModalBottomSheetKt.m2220Scrim3JVO9M(j6, function03, sheetState.getTargetValue() != SheetValue.Hidden, composer2, 0);
            ModalBottomSheetKt.m2219ModalBottomSheetContentIQkwcL4(boxScope, animatable2, coroutineScope2, function03, function12, modifier2, sheetState, f, shape, j4, j5, f2, function2, function23, function32, composer, (Animatable.$stable << 3) | 6, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }
}
