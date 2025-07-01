package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0003BCDB\u0005¢\u0006\u0002\u0010\u0004J \u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002J0\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,ø\u0001\u0000¢\u0006\u0004\b-\u0010.J \u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0016J\u0010\u00103\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u00104\u001a\u0002052\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\"\u00106\u001a\u0002052\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020508¢\u0006\u0002\b9H\bJ&\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00128B@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "<set-?>", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "measureInputs", "getMeasureInputs", "()Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "setMeasureInputs", "(Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;)V", "measureInputs$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "nonMeasureInputs", "getNonMeasureInputs", "()Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "setNonMeasureInputs", "(Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;)V", "nonMeasureInputs$delegate", "record", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$CacheRecord;", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "value", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "computeLayout", "visualText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOrComputeLayout", "layoutWithNewMeasureInputs", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutWithNewMeasureInputs--hBUhpc", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Landroidx/compose/ui/text/TextLayoutResult;", "mergeRecords", "previous", "current", "applied", "obtainTextMeasurer", "prependStateRecord", "", "updateCacheIfWritable", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "updateNonMeasureInputs", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "softWrap", "CacheRecord", "MeasureInputs", "NonMeasureInputs", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldLayoutStateCache.kt */
public final class TextFieldLayoutStateCache implements State<TextLayoutResult>, StateObject {
    public static final int $stable = 0;
    private final MutableState measureInputs$delegate = SnapshotStateKt.mutableStateOf(null, MeasureInputs.Companion.getMutationPolicy());
    private final MutableState nonMeasureInputs$delegate = SnapshotStateKt.mutableStateOf(null, NonMeasureInputs.Companion.getMutationPolicy());
    private CacheRecord record = new CacheRecord();
    private TextMeasurer textMeasurer;

    public StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return stateRecord3;
    }

    private final NonMeasureInputs getNonMeasureInputs() {
        return (NonMeasureInputs) this.nonMeasureInputs$delegate.getValue();
    }

    private final void setNonMeasureInputs(NonMeasureInputs nonMeasureInputs) {
        this.nonMeasureInputs$delegate.setValue(nonMeasureInputs);
    }

    private final MeasureInputs getMeasureInputs() {
        return (MeasureInputs) this.measureInputs$delegate.getValue();
    }

    private final void setMeasureInputs(MeasureInputs measureInputs) {
        this.measureInputs$delegate.setValue(measureInputs);
    }

    public TextLayoutResult getValue() {
        MeasureInputs measureInputs;
        NonMeasureInputs nonMeasureInputs = getNonMeasureInputs();
        if (nonMeasureInputs == null || (measureInputs = getMeasureInputs()) == null) {
            return null;
        }
        return getOrComputeLayout(nonMeasureInputs, measureInputs);
    }

    public final void updateNonMeasureInputs(TransformedTextFieldState transformedTextFieldState, TextStyle textStyle, boolean z, boolean z2) {
        setNonMeasureInputs(new NonMeasureInputs(transformedTextFieldState, textStyle, z, z2));
    }

    /* renamed from: layoutWithNewMeasureInputs--hBUhpc  reason: not valid java name */
    public final TextLayoutResult m1421layoutWithNewMeasureInputshBUhpc(Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j) {
        MeasureInputs measureInputs = new MeasureInputs(density, layoutDirection, resolver, j, (DefaultConstructorMarker) null);
        setMeasureInputs(measureInputs);
        NonMeasureInputs nonMeasureInputs = getNonMeasureInputs();
        if (nonMeasureInputs != null) {
            return getOrComputeLayout(nonMeasureInputs, measureInputs);
        }
        throw new IllegalStateException("Called layoutWithNewMeasureInputs before updateNonMeasureInputs".toString());
    }

    private final TextLayoutResult getOrComputeLayout(NonMeasureInputs nonMeasureInputs, MeasureInputs measureInputs) {
        CharSequence visualText;
        TextFieldCharSequence visualText2 = nonMeasureInputs.getTextFieldState().getVisualText();
        CacheRecord cacheRecord = (CacheRecord) SnapshotKt.current(this.record);
        TextLayoutResult layoutResult = cacheRecord.getLayoutResult();
        if (layoutResult != null && (visualText = cacheRecord.getVisualText()) != null && StringsKt.contentEquals(visualText, (CharSequence) visualText2) && Intrinsics.areEqual((Object) cacheRecord.m1422getCompositionMzsxiRA(), (Object) visualText2.m1311getCompositionMzsxiRA()) && cacheRecord.getSingleLine() == nonMeasureInputs.getSingleLine() && cacheRecord.getSoftWrap() == nonMeasureInputs.getSoftWrap() && cacheRecord.getLayoutDirection() == measureInputs.getLayoutDirection() && cacheRecord.getDensityValue() == measureInputs.getDensity().getDensity() && cacheRecord.getFontScale() == measureInputs.getDensity().getFontScale() && Constraints.m7045equalsimpl0(cacheRecord.m1423getConstraintsmsEJaDk(), measureInputs.m1426getConstraintsmsEJaDk()) && Intrinsics.areEqual((Object) cacheRecord.getFontFamilyResolver(), (Object) measureInputs.getFontFamilyResolver()) && !layoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            TextStyle textStyle = cacheRecord.getTextStyle();
            boolean z = false;
            boolean hasSameLayoutAffectingAttributes = textStyle != null ? textStyle.hasSameLayoutAffectingAttributes(nonMeasureInputs.getTextStyle()) : false;
            TextStyle textStyle2 = cacheRecord.getTextStyle();
            if (textStyle2 != null) {
                z = textStyle2.hasSameDrawAffectingAttributes(nonMeasureInputs.getTextStyle());
            }
            if (hasSameLayoutAffectingAttributes && z) {
                return layoutResult;
            }
            if (hasSameLayoutAffectingAttributes) {
                return TextLayoutResult.m6534copyO0kMr_c$default(layoutResult, new TextLayoutInput(layoutResult.getLayoutInput().getText(), nonMeasureInputs.getTextStyle(), (List) layoutResult.getLayoutInput().getPlaceholders(), layoutResult.getLayoutInput().getMaxLines(), layoutResult.getLayoutInput().getSoftWrap(), layoutResult.getLayoutInput().m6533getOverflowgIe3tQ8(), layoutResult.getLayoutInput().getDensity(), layoutResult.getLayoutInput().getLayoutDirection(), layoutResult.getLayoutInput().getFontFamilyResolver(), layoutResult.getLayoutInput().m6532getConstraintsmsEJaDk(), (DefaultConstructorMarker) null), 0, 2, (Object) null);
            }
        }
        NonMeasureInputs nonMeasureInputs2 = nonMeasureInputs;
        MeasureInputs measureInputs2 = measureInputs;
        TextLayoutResult computeLayout = computeLayout(visualText2, nonMeasureInputs2, measureInputs2);
        if (!Intrinsics.areEqual((Object) computeLayout, (Object) layoutResult)) {
            Snapshot current = Snapshot.Companion.getCurrent();
            if (!current.getReadOnly()) {
                StateRecord stateRecord = this.record;
                synchronized (SnapshotKt.getLock()) {
                    CacheRecord cacheRecord2 = (CacheRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                    cacheRecord2.setVisualText(visualText2);
                    cacheRecord2.m1424setCompositionOEnZFl4(visualText2.m1311getCompositionMzsxiRA());
                    cacheRecord2.setSingleLine(nonMeasureInputs2.getSingleLine());
                    cacheRecord2.setSoftWrap(nonMeasureInputs2.getSoftWrap());
                    cacheRecord2.setTextStyle(nonMeasureInputs2.getTextStyle());
                    cacheRecord2.setLayoutDirection(measureInputs2.getLayoutDirection());
                    cacheRecord2.setDensityValue(measureInputs2.getDensityValue());
                    cacheRecord2.setFontScale(measureInputs2.getFontScale());
                    cacheRecord2.m1425setConstraintsBRTryo0(measureInputs2.m1426getConstraintsmsEJaDk());
                    cacheRecord2.setFontFamilyResolver(measureInputs2.getFontFamilyResolver());
                    cacheRecord2.setLayoutResult(computeLayout);
                    Unit unit = Unit.INSTANCE;
                }
                SnapshotKt.notifyWrite(current, this);
                return computeLayout;
            }
        }
        return computeLayout;
    }

    private final void updateCacheIfWritable(Function1<? super CacheRecord, Unit> function1) {
        Snapshot current = Snapshot.Companion.getCurrent();
        if (!current.getReadOnly()) {
            StateRecord stateRecord = this.record;
            synchronized (SnapshotKt.getLock()) {
                function1.invoke(SnapshotKt.writableRecord(stateRecord, this, current));
            }
            SnapshotKt.notifyWrite(current, this);
        }
    }

    private final TextMeasurer obtainTextMeasurer(MeasureInputs measureInputs) {
        TextMeasurer textMeasurer2 = this.textMeasurer;
        if (textMeasurer2 != null) {
            return textMeasurer2;
        }
        TextMeasurer textMeasurer3 = new TextMeasurer(measureInputs.getFontFamilyResolver(), measureInputs.getDensity(), measureInputs.getLayoutDirection(), 1);
        this.textMeasurer = textMeasurer3;
        return textMeasurer3;
    }

    private final TextLayoutResult computeLayout(TextFieldCharSequence textFieldCharSequence, NonMeasureInputs nonMeasureInputs, MeasureInputs measureInputs) {
        TextMeasurer obtainTextMeasurer = obtainTextMeasurer(measureInputs);
        int i = 1;
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        builder.append(textFieldCharSequence.toString());
        if (textFieldCharSequence.m1311getCompositionMzsxiRA() != null) {
            builder.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), TextRange.m6562getMinimpl(textFieldCharSequence.m1311getCompositionMzsxiRA().m6568unboximpl()), TextRange.m6561getMaximpl(textFieldCharSequence.m1311getCompositionMzsxiRA().m6568unboximpl()));
        }
        TextMeasurer textMeasurer2 = obtainTextMeasurer;
        AnnotatedString annotatedString = builder.toAnnotatedString();
        TextStyle textStyle = nonMeasureInputs.getTextStyle();
        boolean softWrap = nonMeasureInputs.getSoftWrap();
        if (!nonMeasureInputs.getSingleLine()) {
            i = Integer.MAX_VALUE;
        }
        return TextMeasurer.m6540measurexDpz5zY$default(textMeasurer2, annotatedString, textStyle, 0, softWrap, i, (List) null, measureInputs.m1426getConstraintsmsEJaDk(), measureInputs.getLayoutDirection(), measureInputs.getDensity(), measureInputs.getFontFamilyResolver(), false, 1060, (Object) null);
    }

    public StateRecord getFirstStateRecord() {
        return this.record;
    }

    public void prependStateRecord(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord");
        this.record = (CacheRecord) stateRecord;
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0001H\u0016J\b\u0010C\u001a\u00020\u0001H\u0016J\b\u0010D\u001a\u00020EH\u0016R\"\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\nX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$CacheRecord;", "Landroidx/compose/runtime/snapshots/StateRecord;", "()V", "composition", "Landroidx/compose/ui/text/TextRange;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "setComposition-OEnZFl4", "(Landroidx/compose/ui/text/TextRange;)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk", "()J", "setConstraints-BRTryo0", "(J)V", "J", "densityValue", "", "getDensityValue", "()F", "setDensityValue", "(F)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontScale", "getFontScale", "setFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "singleLine", "", "getSingleLine", "()Z", "setSingleLine", "(Z)V", "softWrap", "getSoftWrap", "setSoftWrap", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "setTextStyle", "(Landroidx/compose/ui/text/TextStyle;)V", "visualText", "", "getVisualText", "()Ljava/lang/CharSequence;", "setVisualText", "(Ljava/lang/CharSequence;)V", "assign", "", "value", "create", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldLayoutStateCache.kt */
    private static final class CacheRecord extends StateRecord {
        private TextRange composition;
        private long constraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
        private float densityValue = Float.NaN;
        private FontFamily.Resolver fontFamilyResolver;
        private float fontScale = Float.NaN;
        private LayoutDirection layoutDirection;
        private TextLayoutResult layoutResult;
        private boolean singleLine;
        private boolean softWrap;
        private TextStyle textStyle;
        private CharSequence visualText;

        public final CharSequence getVisualText() {
            return this.visualText;
        }

        public final void setVisualText(CharSequence charSequence) {
            this.visualText = charSequence;
        }

        /* renamed from: getComposition-MzsxiRA  reason: not valid java name */
        public final TextRange m1422getCompositionMzsxiRA() {
            return this.composition;
        }

        /* renamed from: setComposition-OEnZFl4  reason: not valid java name */
        public final void m1424setCompositionOEnZFl4(TextRange textRange) {
            this.composition = textRange;
        }

        public final TextStyle getTextStyle() {
            return this.textStyle;
        }

        public final void setTextStyle(TextStyle textStyle2) {
            this.textStyle = textStyle2;
        }

        public final boolean getSingleLine() {
            return this.singleLine;
        }

        public final void setSingleLine(boolean z) {
            this.singleLine = z;
        }

        public final boolean getSoftWrap() {
            return this.softWrap;
        }

        public final void setSoftWrap(boolean z) {
            this.softWrap = z;
        }

        public final float getDensityValue() {
            return this.densityValue;
        }

        public final void setDensityValue(float f) {
            this.densityValue = f;
        }

        public final float getFontScale() {
            return this.fontScale;
        }

        public final void setFontScale(float f) {
            this.fontScale = f;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final void setLayoutDirection(LayoutDirection layoutDirection2) {
            this.layoutDirection = layoutDirection2;
        }

        public final FontFamily.Resolver getFontFamilyResolver() {
            return this.fontFamilyResolver;
        }

        public final void setFontFamilyResolver(FontFamily.Resolver resolver) {
            this.fontFamilyResolver = resolver;
        }

        /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
        public final long m1423getConstraintsmsEJaDk() {
            return this.constraints;
        }

        /* renamed from: setConstraints-BRTryo0  reason: not valid java name */
        public final void m1425setConstraintsBRTryo0(long j) {
            this.constraints = j;
        }

        public final TextLayoutResult getLayoutResult() {
            return this.layoutResult;
        }

        public final void setLayoutResult(TextLayoutResult textLayoutResult) {
            this.layoutResult = textLayoutResult;
        }

        public StateRecord create() {
            return new CacheRecord();
        }

        public void assign(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord");
            CacheRecord cacheRecord = (CacheRecord) stateRecord;
            this.visualText = cacheRecord.visualText;
            this.composition = cacheRecord.composition;
            this.textStyle = cacheRecord.textStyle;
            this.singleLine = cacheRecord.singleLine;
            this.softWrap = cacheRecord.softWrap;
            this.densityValue = cacheRecord.densityValue;
            this.fontScale = cacheRecord.fontScale;
            this.layoutDirection = cacheRecord.layoutDirection;
            this.fontFamilyResolver = cacheRecord.fontFamilyResolver;
            this.constraints = cacheRecord.constraints;
            this.layoutResult = cacheRecord.layoutResult;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CacheRecord(visualText=");
            sb.append(this.visualText).append(", composition=").append(this.composition).append(", textStyle=").append(this.textStyle).append(", singleLine=").append(this.singleLine).append(", softWrap=").append(this.softWrap).append(", densityValue=").append(this.densityValue).append(", fontScale=").append(this.fontScale).append(", layoutDirection=").append(this.layoutDirection).append(", fontFamilyResolver=").append(this.fontFamilyResolver).append(", constraints=").append(Constraints.m7057toStringimpl(this.constraints)).append(", layoutResult=").append(this.layoutResult).append(')');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "softWrap", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZZ)V", "getSingleLine", "()Z", "getSoftWrap", "getTextFieldState", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldLayoutStateCache.kt */
    private static final class NonMeasureInputs {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final SnapshotMutationPolicy<NonMeasureInputs> mutationPolicy = new TextFieldLayoutStateCache$NonMeasureInputs$Companion$mutationPolicy$1();
        private final boolean singleLine;
        private final boolean softWrap;
        private final TransformedTextFieldState textFieldState;
        private final TextStyle textStyle;

        public NonMeasureInputs(TransformedTextFieldState transformedTextFieldState, TextStyle textStyle2, boolean z, boolean z2) {
            this.textFieldState = transformedTextFieldState;
            this.textStyle = textStyle2;
            this.singleLine = z;
            this.softWrap = z2;
        }

        public final TransformedTextFieldState getTextFieldState() {
            return this.textFieldState;
        }

        public final TextStyle getTextStyle() {
            return this.textStyle;
        }

        public final boolean getSingleLine() {
            return this.singleLine;
        }

        public final boolean getSoftWrap() {
            return this.softWrap;
        }

        public String toString() {
            return "NonMeasureInputs(textFieldState=" + this.textFieldState + ", textStyle=" + this.textStyle + ", singleLine=" + this.singleLine + ", softWrap=" + this.softWrap + ')';
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs$Companion;", "", "()V", "mutationPolicy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "getMutationPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: TextFieldLayoutStateCache.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SnapshotMutationPolicy<NonMeasureInputs> getMutationPolicy() {
                return NonMeasureInputs.mutationPolicy;
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "densityValue", "", "getDensityValue", "()F", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontScale", "getFontScale", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldLayoutStateCache.kt */
    private static final class MeasureInputs {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final SnapshotMutationPolicy<MeasureInputs> mutationPolicy = new TextFieldLayoutStateCache$MeasureInputs$Companion$mutationPolicy$1();
        private final long constraints;
        private final Density density;
        private final float densityValue;
        private final FontFamily.Resolver fontFamilyResolver;
        private final float fontScale;
        private final LayoutDirection layoutDirection;

        public /* synthetic */ MeasureInputs(Density density2, LayoutDirection layoutDirection2, FontFamily.Resolver resolver, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(density2, layoutDirection2, resolver, j);
        }

        private MeasureInputs(Density density2, LayoutDirection layoutDirection2, FontFamily.Resolver resolver, long j) {
            this.density = density2;
            this.layoutDirection = layoutDirection2;
            this.fontFamilyResolver = resolver;
            this.constraints = j;
            this.densityValue = density2.getDensity();
            this.fontScale = density2.getFontScale();
        }

        public final Density getDensity() {
            return this.density;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final FontFamily.Resolver getFontFamilyResolver() {
            return this.fontFamilyResolver;
        }

        /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
        public final long m1426getConstraintsmsEJaDk() {
            return this.constraints;
        }

        public final float getDensityValue() {
            return this.densityValue;
        }

        public final float getFontScale() {
            return this.fontScale;
        }

        public String toString() {
            return "MeasureInputs(density=" + this.density + ", densityValue=" + this.densityValue + ", fontScale=" + this.fontScale + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + Constraints.m7057toStringimpl(this.constraints) + ')';
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs$Companion;", "", "()V", "mutationPolicy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "getMutationPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: TextFieldLayoutStateCache.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SnapshotMutationPolicy<MeasureInputs> getMutationPolicy() {
                return MeasureInputs.mutationPolicy;
            }
        }
    }
}
