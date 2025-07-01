package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B]\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00126\u0010\r\u001a2\u0012\u0004\u0012\u00020\u000f\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e¢\u0006\u0002\b\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0016J^\u0010!\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f26\u0010\r\u001a2\u0012\u0004\u0012\u00020\u000f\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e¢\u0006\u0002\b\u0016J&\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010*R\"\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001dR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;)V", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getBaselineCache$annotations", "()V", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "updateNode", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldTextLayoutModifier.kt */
public final class TextFieldTextLayoutModifierNode extends Modifier.Node implements LayoutModifierNode, GlobalPositionAwareModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private Map<AlignmentLine, Integer> baselineCache;
    private boolean singleLine;
    private TextLayoutState textLayoutState;

    private static /* synthetic */ void getBaselineCache$annotations() {
    }

    public TextFieldTextLayoutModifierNode(TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextStyle textStyle, boolean z, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        this.textLayoutState = textLayoutState2;
        this.singleLine = z;
        textLayoutState2.setOnTextLayout(function2);
        TextLayoutState textLayoutState3 = this.textLayoutState;
        boolean z2 = this.singleLine;
        textLayoutState3.updateNonMeasureInputs(transformedTextFieldState, textStyle, z2, !z2);
    }

    public final void updateNode(TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextStyle textStyle, boolean z, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        this.textLayoutState = textLayoutState2;
        textLayoutState2.setOnTextLayout(function2);
        this.singleLine = z;
        this.textLayoutState.updateNonMeasureInputs(transformedTextFieldState, textStyle, z, !z);
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        this.textLayoutState.setTextLayoutNodeCoordinates(layoutCoordinates);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1427measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        TextLayoutResult r9 = this.textLayoutState.m1434layoutWithNewMeasureInputshBUhpc(measureScope, measureScope.getLayoutDirection(), (FontFamily.Resolver) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFontFamilyResolver()), j);
        Placeable r8 = measurable.m5848measureBRTryo0(Constraints.Companion.m7061fitPrioritizingWidthZbe2FdA(IntSize.m7283getWidthimpl(r9.m6537getSizeYbymL2g()), IntSize.m7283getWidthimpl(r9.m6537getSizeYbymL2g()), IntSize.m7282getHeightimpl(r9.m6537getSizeYbymL2g()), IntSize.m7282getHeightimpl(r9.m6537getSizeYbymL2g())));
        this.textLayoutState.m1435setMinHeightForSingleLineField0680j_4(this.singleLine ? measureScope.m7088toDpu2uoSUM(TextDelegateKt.ceilToIntPx(r9.getLineBottom(0))) : Dp.m7111constructorimpl((float) 0));
        Map<AlignmentLine, Integer> map = this.baselineCache;
        if (map == null) {
            map = new LinkedHashMap<>(2);
        }
        map.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(r9.getFirstBaseline())));
        map.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(r9.getLastBaseline())));
        this.baselineCache = map;
        int r10 = IntSize.m7283getWidthimpl(r9.m6537getSizeYbymL2g());
        int r92 = IntSize.m7282getHeightimpl(r9.m6537getSizeYbymL2g());
        Map<AlignmentLine, Integer> map2 = this.baselineCache;
        Intrinsics.checkNotNull(map2);
        return measureScope.layout(r10, r92, map2, new TextFieldTextLayoutModifierNode$measure$1(r8));
    }
}
