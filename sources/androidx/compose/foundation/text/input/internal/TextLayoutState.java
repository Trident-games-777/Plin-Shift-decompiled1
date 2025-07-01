package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0000ø\u0001\u0000¢\u0006\u0004\b4\u00105J\"\u00106\u001a\u0002072\u0006\u00108\u001a\u0002022\b\b\u0002\u00109\u001a\u00020:ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0018\u0010=\u001a\u00020:2\u0006\u00103\u001a\u000202ø\u0001\u0000¢\u0006\u0004\b>\u0010?J0\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020Gø\u0001\u0000¢\u0006\u0004\bH\u0010IJ&\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020:R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R/\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR/\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R1\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c8F@FX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\"\u0010\u000f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R;\u0010#\u001a#\u0012\u0004\u0012\u00020%\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170&\u0012\u0004\u0012\u00020'\u0018\u00010$¢\u0006\u0002\b(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R/\u0010-\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0002¢\u0006\u0012\n\u0004\b0\u0010\u000f\u001a\u0004\b.\u0010\u000b\"\u0004\b/\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "", "()V", "bringIntoViewRequester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "getBringIntoViewRequester", "()Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "coreNodeCoordinates", "getCoreNodeCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setCoreNodeCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "coreNodeCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "decoratorNodeCoordinates", "getDecoratorNodeCoordinates", "setDecoratorNodeCoordinates", "decoratorNodeCoordinates$delegate", "layoutCache", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult$delegate", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "", "Lkotlin/ExtensionFunctionType;", "getOnTextLayout", "()Lkotlin/jvm/functions/Function2;", "setOnTextLayout", "(Lkotlin/jvm/functions/Function2;)V", "textLayoutNodeCoordinates", "getTextLayoutNodeCoordinates", "setTextLayoutNodeCoordinates", "textLayoutNodeCoordinates$delegate", "coercedInVisibleBoundsOfInputText", "Landroidx/compose/ui/geometry/Offset;", "offset", "coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release", "(J)J", "getOffsetForPosition", "", "position", "coerceInVisibleBounds", "", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", "isPositionOnText-k-4lQ0M", "(J)Z", "layoutWithNewMeasureInputs", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutWithNewMeasureInputs--hBUhpc", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Landroidx/compose/ui/text/TextLayoutResult;", "updateNonMeasureInputs", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "softWrap", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayoutState.kt */
public final class TextLayoutState {
    public static final int $stable = 8;
    private final BringIntoViewRequester bringIntoViewRequester = BringIntoViewRequesterKt.BringIntoViewRequester();
    private final MutableState coreNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
    private final MutableState decoratorNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
    /* access modifiers changed from: private */
    public TextFieldLayoutStateCache layoutCache;
    private final TextFieldLayoutStateCache layoutResult$delegate;
    private final MutableState minHeightForSingleLineField$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m7109boximpl(Dp.m7111constructorimpl((float) 0)), (SnapshotMutationPolicy) null, 2, (Object) null);
    private Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout;
    private final MutableState textLayoutNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());

    public TextLayoutState() {
        TextFieldLayoutStateCache textFieldLayoutStateCache = new TextFieldLayoutStateCache();
        this.layoutCache = textFieldLayoutStateCache;
        this.layoutResult$delegate = textFieldLayoutStateCache;
    }

    public final Function2<Density, Function0<TextLayoutResult>, Unit> getOnTextLayout() {
        return this.onTextLayout;
    }

    public final void setOnTextLayout(Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        this.onTextLayout = function2;
    }

    public final TextLayoutResult getLayoutResult() {
        return (TextLayoutResult) this.layoutResult$delegate.getValue();
    }

    public final LayoutCoordinates getTextLayoutNodeCoordinates() {
        return (LayoutCoordinates) this.textLayoutNodeCoordinates$delegate.getValue();
    }

    public final void setTextLayoutNodeCoordinates(LayoutCoordinates layoutCoordinates) {
        this.textLayoutNodeCoordinates$delegate.setValue(layoutCoordinates);
    }

    public final LayoutCoordinates getCoreNodeCoordinates() {
        return (LayoutCoordinates) this.coreNodeCoordinates$delegate.getValue();
    }

    public final void setCoreNodeCoordinates(LayoutCoordinates layoutCoordinates) {
        this.coreNodeCoordinates$delegate.setValue(layoutCoordinates);
    }

    public final LayoutCoordinates getDecoratorNodeCoordinates() {
        return (LayoutCoordinates) this.decoratorNodeCoordinates$delegate.getValue();
    }

    public final void setDecoratorNodeCoordinates(LayoutCoordinates layoutCoordinates) {
        this.decoratorNodeCoordinates$delegate.setValue(layoutCoordinates);
    }

    /* renamed from: getMinHeightForSingleLineField-D9Ej5fM  reason: not valid java name */
    public final float m1431getMinHeightForSingleLineFieldD9Ej5fM() {
        return ((Dp) this.minHeightForSingleLineField$delegate.getValue()).m7125unboximpl();
    }

    /* renamed from: setMinHeightForSingleLineField-0680j_4  reason: not valid java name */
    public final void m1435setMinHeightForSingleLineField0680j_4(float f) {
        this.minHeightForSingleLineField$delegate.setValue(Dp.m7109boximpl(f));
    }

    public final BringIntoViewRequester getBringIntoViewRequester() {
        return this.bringIntoViewRequester;
    }

    public final void updateNonMeasureInputs(TransformedTextFieldState transformedTextFieldState, TextStyle textStyle, boolean z, boolean z2) {
        this.layoutCache.updateNonMeasureInputs(transformedTextFieldState, textStyle, z, z2);
    }

    /* renamed from: layoutWithNewMeasureInputs--hBUhpc  reason: not valid java name */
    public final TextLayoutResult m1434layoutWithNewMeasureInputshBUhpc(Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j) {
        Density density2 = density;
        TextLayoutResult r7 = this.layoutCache.m1421layoutWithNewMeasureInputshBUhpc(density2, layoutDirection, resolver, j);
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2 = this.onTextLayout;
        if (function2 != null) {
            function2.invoke(density2, new TextLayoutState$layoutWithNewMeasureInputs$1$textLayoutProvider$1(this));
        }
        return r7;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k$default  reason: not valid java name */
    public static /* synthetic */ int m1429getOffsetForPosition3MmeM6k$default(TextLayoutState textLayoutState, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return textLayoutState.m1432getOffsetForPosition3MmeM6k(j, z);
    }

    /* renamed from: getOffsetForPosition-3MmeM6k  reason: not valid java name */
    public final int m1432getOffsetForPosition3MmeM6k(long j, boolean z) {
        TextLayoutResult layoutResult = getLayoutResult();
        if (layoutResult == null) {
            return -1;
        }
        if (z) {
            j = m1430coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(j);
        }
        return layoutResult.m6536getOffsetForPositionk4lQ0M(TextLayoutStateKt.m1437fromDecorationToTextLayoutUv8p0NA(this, j));
    }

    /* renamed from: isPositionOnText-k-4lQ0M  reason: not valid java name */
    public final boolean m1433isPositionOnTextk4lQ0M(long j) {
        TextLayoutResult layoutResult = getLayoutResult();
        if (layoutResult == null) {
            return false;
        }
        long r6 = TextLayoutStateKt.m1437fromDecorationToTextLayoutUv8p0NA(this, m1430coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(j));
        int lineForVerticalPosition = layoutResult.getLineForVerticalPosition(Offset.m3988getYimpl(r6));
        if (Offset.m3987getXimpl(r6) < layoutResult.getLineLeft(lineForVerticalPosition) || Offset.m3987getXimpl(r6) > layoutResult.getLineRight(lineForVerticalPosition)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (r2 == null) goto L_0x0022;
     */
    /* renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m1430coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(long r6) {
        /*
            r5 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r5.getTextLayoutNodeCoordinates()
            if (r0 == 0) goto L_0x0022
            boolean r1 = r0.isAttached()
            if (r1 == 0) goto L_0x001a
            androidx.compose.ui.layout.LayoutCoordinates r1 = r5.getDecoratorNodeCoordinates()
            r2 = 0
            if (r1 == 0) goto L_0x0020
            r3 = 0
            r4 = 2
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.layout.LayoutCoordinates.localBoundingBoxOf$default(r1, r0, r3, r4, r2)
            goto L_0x0020
        L_0x001a:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L_0x0020:
            if (r2 != 0) goto L_0x0028
        L_0x0022:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L_0x0028:
            long r6 = androidx.compose.foundation.text.input.internal.TextLayoutStateKt.m1436coerceIn3MmeM6k(r6, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextLayoutState.m1430coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(long):long");
    }
}
