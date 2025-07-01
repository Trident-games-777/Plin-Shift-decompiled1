package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SpreadBuilder;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u001e\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001fJ>\u0010 \u001a\u00020\t2\u0016\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\"\"\u0004\u0018\u00010\u00012\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010$J\r\u0010%\u001a\u00020\u0003H\u0000¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u001c\u0010,\u001a\u0004\u0018\u00010-2\u0010\u0010.\u001a\f\u0012\u0004\u0012\u00020)0/j\u0002`0H\u0002J\u001c\u00101\u001a\u0004\u0018\u0001022\u0010\u0010.\u001a\f\u0012\u0004\u0012\u00020)0/j\u0002`0H\u0002J\u001a\u00103\u001a\u0004\u0018\u000104*\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000104H\u0002J\u001c\u00106\u001a\u000207*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0002R%\u0010\u0005\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0004R/\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006;²\u0006\n\u0010<\u001a\u00020\u000fX\u0002²\u0006\n\u0010=\u001a\u00020\u000fX\u0002²\u0006\n\u0010>\u001a\u00020\u000fX\u0002"}, d2 = {"Landroidx/compose/foundation/text/TextLinkScope;", "", "initialText", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", "annotators", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "Lkotlin/ExtensionFunctionType;", "getInitialText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "getShouldMeasureLinks", "()Lkotlin/jvm/functions/Function0;", "text", "getText$foundation_release", "setText$foundation_release", "<set-?>", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "LinksComposables", "(Landroidx/compose/runtime/Composer;I)V", "StyleAnnotation", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "applyAnnotators", "applyAnnotators$foundation_release", "handleLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "uriHandler", "Landroidx/compose/ui/platform/UriHandler;", "pathForRangeInRangeCoordinates", "Landroidx/compose/ui/graphics/Path;", "range", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/foundation/text/LinkRange;", "shapeForRange", "Landroidx/compose/ui/graphics/Shape;", "mergeOrUse", "Landroidx/compose/ui/text/SpanStyle;", "other", "textRange", "Landroidx/compose/ui/Modifier;", "start", "", "end", "foundation_release", "isHovered", "isFocused", "isPressed"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLinkScope.kt */
public final class TextLinkScope {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final SnapshotStateList<Function1<TextAnnotatorScope, Unit>> annotators;
    private final AnnotatedString initialText;
    private AnnotatedString text;
    private final MutableState textLayoutResult$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    public TextLinkScope(AnnotatedString annotatedString) {
        SpanStyle style;
        this.initialText = annotatedString;
        AnnotatedString.Builder builder = new AnnotatedString.Builder(annotatedString);
        List<AnnotatedString.Range<LinkAnnotation>> linkAnnotations = annotatedString.getLinkAnnotations(0, annotatedString.length());
        int size = linkAnnotations.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range range = linkAnnotations.get(i);
            TextLinkStyles styles = ((LinkAnnotation) range.getItem()).getStyles();
            if (!(styles == null || (style = styles.getStyle()) == null)) {
                builder.addStyle(style, range.getStart(), range.getEnd());
            }
        }
        this.text = builder.toAnnotatedString();
        this.annotators = SnapshotStateKt.mutableStateListOf();
    }

    public final AnnotatedString getInitialText$foundation_release() {
        return this.initialText;
    }

    public final TextLayoutResult getTextLayoutResult() {
        return (TextLayoutResult) this.textLayoutResult$delegate.getValue();
    }

    public final void setTextLayoutResult(TextLayoutResult textLayoutResult) {
        this.textLayoutResult$delegate.setValue(textLayoutResult);
    }

    public final AnnotatedString getText$foundation_release() {
        return this.text;
    }

    public final void setText$foundation_release(AnnotatedString annotatedString) {
        this.text = annotatedString;
    }

    public final Function0<Boolean> getShouldMeasureLinks() {
        return new TextLinkScope$shouldMeasureLinks$1(this);
    }

    private final Modifier textRange(Modifier modifier, int i, int i2) {
        return modifier.then(new TextRangeLayoutModifier(new TextLinkScope$$ExternalSyntheticLambda0(this, i, i2)));
    }

    /* access modifiers changed from: private */
    public static final TextRangeLayoutMeasureResult textRange$lambda$3(TextLinkScope textLinkScope, int i, int i2, TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
        TextLayoutResult textLayoutResult = textLinkScope.getTextLayoutResult();
        if (textLayoutResult == null) {
            return textRangeLayoutMeasureScope.layout(0, 0, TextLinkScope$textRange$1$layoutResult$1.INSTANCE);
        }
        IntRect roundToIntRect = IntRectKt.roundToIntRect(textLayoutResult.getPathForRange(i, i2).getBounds());
        return textRangeLayoutMeasureScope.layout(roundToIntRect.getWidth(), roundToIntRect.getHeight(), new TextLinkScope$textRange$1$1(roundToIntRect));
    }

    private final Shape shapeForRange(AnnotatedString.Range<LinkAnnotation> range) {
        Path pathForRangeInRangeCoordinates = pathForRangeInRangeCoordinates(range);
        return pathForRangeInRangeCoordinates != null ? new TextLinkScope$shapeForRange$1$1(pathForRangeInRangeCoordinates) : null;
    }

    private final Path pathForRangeInRangeCoordinates(AnnotatedString.Range<LinkAnnotation> range) {
        Path path = null;
        if (!getShouldMeasureLinks().invoke().booleanValue()) {
            return null;
        }
        TextLayoutResult textLayoutResult = getTextLayoutResult();
        if (textLayoutResult != null) {
            path = textLayoutResult.getPathForRange(range.getStart(), range.getEnd());
            Rect boundingBox = textLayoutResult.getBoundingBox(range.getStart());
            path.m4531translatek4lQ0M(Offset.m3996unaryMinusF1C5BW0(OffsetKt.Offset(textLayoutResult.getLineForOffset(range.getStart()) == textLayoutResult.getLineForOffset(range.getEnd()) ? Math.min(textLayoutResult.getBoundingBox(range.getEnd() - 1).getLeft(), boundingBox.getLeft()) : 0.0f, boundingBox.getTop())));
        }
        return path;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void LinksComposables(androidx.compose.runtime.Composer r29, int r30) {
        /*
            r28 = this;
            r1 = r28
            r6 = r30
            r0 = 1154651354(0x44d294da, float:1684.6516)
            r2 = r29
            androidx.compose.runtime.Composer r7 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(LinksComposables)153@6783L7,*159@7046L39,169@7474L38,161@7099L449,173@7597L25,174@7670L25,175@7743L25,185@8083L743,177@7782L1044:TextLinkScope.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            r2 = r6 & 6
            r8 = 2
            if (r2 != 0) goto L_0x0023
            boolean r2 = r7.changedInstance(r1)
            if (r2 == 0) goto L_0x001f
            r2 = 4
            goto L_0x0020
        L_0x001f:
            r2 = r8
        L_0x0020:
            r2 = r2 | r6
            r9 = r2
            goto L_0x0024
        L_0x0023:
            r9 = r6
        L_0x0024:
            r2 = r9 & 3
            if (r2 != r8) goto L_0x0034
            boolean r2 = r7.getSkipping()
            if (r2 != 0) goto L_0x002f
            goto L_0x0034
        L_0x002f:
            r7.skipToGroupEnd()
            goto L_0x01ea
        L_0x0034:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0040
            r2 = -1
            java.lang.String r3 = "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:152)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r2, r3)
        L_0x0040:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalUriHandler()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r2, r3)
            java.lang.Object r0 = r7.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r10 = r0
            androidx.compose.ui.platform.UriHandler r10 = (androidx.compose.ui.platform.UriHandler) r10
            androidx.compose.ui.text.AnnotatedString r0 = r1.text
            int r2 = r0.length()
            r11 = 0
            java.util.List r12 = r0.getLinkAnnotations(r11, r2)
            int r13 = r12.size()
            r14 = r11
        L_0x0068:
            if (r14 >= r13) goto L_0x01e1
            java.lang.Object r0 = r12.get(r14)
            r2 = r0
            androidx.compose.ui.text.AnnotatedString$Range r2 = (androidx.compose.ui.text.AnnotatedString.Range) r2
            androidx.compose.ui.graphics.Shape r0 = r1.shapeForRange(r2)
            if (r0 == 0) goto L_0x0081
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.ClipKt.clip(r3, r0)
            if (r0 != 0) goto L_0x0085
        L_0x0081:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x0085:
            r3 = -371005797(0xffffffffe9e2e69b, float:-3.428828E25)
            java.lang.String r4 = "CC(remember):TextLinkScope.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r4)
            java.lang.Object r3 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r3 != r5) goto L_0x00a0
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r3)
        L_0x00a0:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            int r5 = r2.getStart()
            int r15 = r2.getEnd()
            androidx.compose.ui.Modifier r0 = r1.textRange(r0, r5, r15)
            r5 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.HoverableKt.hoverable$default(r0, r3, r11, r8, r5)
            androidx.compose.ui.input.pointer.PointerIcon$Companion r15 = androidx.compose.ui.input.pointer.PointerIcon.Companion
            androidx.compose.ui.input.pointer.PointerIcon r15 = r15.getHand()
            androidx.compose.ui.Modifier r15 = androidx.compose.ui.input.pointer.PointerIconKt.pointerHoverIcon$default(r0, r15, r11, r8, r5)
            r0 = -370992102(0xffffffffe9e31c1a, float:-3.4319858E25)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r4)
            boolean r0 = r7.changedInstance(r1)
            boolean r16 = r7.changed((java.lang.Object) r2)
            r0 = r0 | r16
            boolean r16 = r7.changedInstance(r10)
            r0 = r0 | r16
            java.lang.Object r5 = r7.rememberedValue()
            if (r0 != 0) goto L_0x00e4
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r5 != r0) goto L_0x00ef
        L_0x00e4:
            androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$1$1 r0 = new androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$1$1
            r0.<init>(r1, r2, r10)
            r5 = r0
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r7.updateRememberedValue(r5)
        L_0x00ef:
            r24 = r5
            kotlin.jvm.functions.Function0 r24 = (kotlin.jvm.functions.Function0) r24
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r25 = 252(0xfc, float:3.53E-43)
            r26 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r16 = r3
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClickableKt.m283combinedClickableXVZzFYc$default(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            androidx.compose.foundation.layout.BoxKt.Box(r0, r7, r11)
            r3 = r16
            androidx.compose.foundation.interaction.InteractionSource r3 = (androidx.compose.foundation.interaction.InteractionSource) r3
            r15 = 6
            androidx.compose.runtime.State r0 = androidx.compose.foundation.interaction.HoverInteractionKt.collectIsHoveredAsState(r3, r7, r15)
            androidx.compose.runtime.State r5 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r3, r7, r15)
            androidx.compose.runtime.State r3 = androidx.compose.foundation.interaction.PressInteractionKt.collectIsPressedAsState(r3, r7, r15)
            boolean r16 = LinksComposables$lambda$13$lambda$9(r0)
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r16)
            boolean r16 = LinksComposables$lambda$13$lambda$10(r5)
            java.lang.Boolean r18 = java.lang.Boolean.valueOf(r16)
            boolean r16 = LinksComposables$lambda$13$lambda$11(r3)
            java.lang.Boolean r19 = java.lang.Boolean.valueOf(r16)
            java.lang.Object r16 = r2.getItem()
            androidx.compose.ui.text.LinkAnnotation r16 = (androidx.compose.ui.text.LinkAnnotation) r16
            androidx.compose.ui.text.TextLinkStyles r16 = r16.getStyles()
            if (r16 == 0) goto L_0x014d
            androidx.compose.ui.text.SpanStyle r16 = r16.getStyle()
            r20 = r16
            goto L_0x014f
        L_0x014d:
            r20 = 0
        L_0x014f:
            java.lang.Object r16 = r2.getItem()
            androidx.compose.ui.text.LinkAnnotation r16 = (androidx.compose.ui.text.LinkAnnotation) r16
            androidx.compose.ui.text.TextLinkStyles r16 = r16.getStyles()
            if (r16 == 0) goto L_0x0162
            androidx.compose.ui.text.SpanStyle r16 = r16.getFocusedStyle()
            r21 = r16
            goto L_0x0164
        L_0x0162:
            r21 = 0
        L_0x0164:
            java.lang.Object r16 = r2.getItem()
            androidx.compose.ui.text.LinkAnnotation r16 = (androidx.compose.ui.text.LinkAnnotation) r16
            androidx.compose.ui.text.TextLinkStyles r16 = r16.getStyles()
            if (r16 == 0) goto L_0x0177
            androidx.compose.ui.text.SpanStyle r16 = r16.getHoveredStyle()
            r22 = r16
            goto L_0x0179
        L_0x0177:
            r22 = 0
        L_0x0179:
            java.lang.Object r16 = r2.getItem()
            androidx.compose.ui.text.LinkAnnotation r16 = (androidx.compose.ui.text.LinkAnnotation) r16
            androidx.compose.ui.text.TextLinkStyles r16 = r16.getStyles()
            if (r16 == 0) goto L_0x018c
            androidx.compose.ui.text.SpanStyle r16 = r16.getPressedStyle()
            r23 = r16
            goto L_0x018e
        L_0x018c:
            r23 = 0
        L_0x018e:
            java.lang.Object[] r8 = new java.lang.Object[]{r17, r18, r19, r20, r21, r22, r23}
            r11 = -370971909(0xffffffffe9e36afb, float:-3.436642E25)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r11, r4)
            boolean r4 = r7.changedInstance(r1)
            boolean r11 = r7.changed((java.lang.Object) r2)
            r4 = r4 | r11
            boolean r11 = r7.changed((java.lang.Object) r5)
            r4 = r4 | r11
            boolean r11 = r7.changed((java.lang.Object) r0)
            r4 = r4 | r11
            boolean r11 = r7.changed((java.lang.Object) r3)
            r4 = r4 | r11
            java.lang.Object r11 = r7.rememberedValue()
            if (r4 != 0) goto L_0x01be
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r11 != r4) goto L_0x01cf
        L_0x01be:
            r4 = r0
            androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$2$1 r0 = new androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$2$1
            r27 = r5
            r5 = r3
            r3 = r27
            r0.<init>(r1, r2, r3, r4, r5)
            r11 = r0
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r7.updateRememberedValue(r11)
        L_0x01cf:
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            int r0 = r9 << 6
            r0 = r0 & 896(0x380, float:1.256E-42)
            r1.StyleAnnotation(r8, r11, r7, r0)
            int r14 = r14 + 1
            r8 = 2
            r11 = 0
            goto L_0x0068
        L_0x01e1:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ea
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ea:
            androidx.compose.runtime.ScopeUpdateScope r0 = r7.endRestartGroup()
            if (r0 == 0) goto L_0x01fa
            androidx.compose.foundation.text.TextLinkScope$LinksComposables$2 r2 = new androidx.compose.foundation.text.TextLinkScope$LinksComposables$2
            r2.<init>(r1, r6)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.updateScope(r2)
        L_0x01fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLinkScope.LinksComposables(androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.merge(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.text.SpanStyle mergeOrUse(androidx.compose.ui.text.SpanStyle r1, androidx.compose.ui.text.SpanStyle r2) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x000a
            androidx.compose.ui.text.SpanStyle r1 = r1.merge(r2)
            if (r1 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            return r1
        L_0x000a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLinkScope.mergeOrUse(androidx.compose.ui.text.SpanStyle, androidx.compose.ui.text.SpanStyle):androidx.compose.ui.text.SpanStyle");
    }

    /* access modifiers changed from: private */
    public final void handleLink(LinkAnnotation linkAnnotation, UriHandler uriHandler) {
        LinkInteractionListener linkInteractionListener;
        Unit unit;
        if (linkAnnotation instanceof LinkAnnotation.Url) {
            LinkInteractionListener linkInteractionListener2 = linkAnnotation.getLinkInteractionListener();
            if (linkInteractionListener2 != null) {
                linkInteractionListener2.onClick(linkAnnotation);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                try {
                    uriHandler.openUri(((LinkAnnotation.Url) linkAnnotation).getUrl());
                } catch (IllegalArgumentException unused) {
                }
            }
        } else if ((linkAnnotation instanceof LinkAnnotation.Clickable) && (linkInteractionListener = linkAnnotation.getLinkInteractionListener()) != null) {
            linkInteractionListener.onClick(linkAnnotation);
        }
    }

    public final AnnotatedString applyAnnotators$foundation_release() {
        AnnotatedString annotatedString;
        if (this.annotators.isEmpty()) {
            annotatedString = this.text;
        } else {
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            builder.append(this.initialText);
            TextAnnotatorScope textAnnotatorScope = new TextAnnotatorScope(builder);
            List list = this.annotators;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((Function1) list.get(i)).invoke(textAnnotatorScope);
            }
            annotatedString = builder.toAnnotatedString();
        }
        this.text = annotatedString;
        return annotatedString;
    }

    /* access modifiers changed from: private */
    public final void StyleAnnotation(Object[] objArr, Function1<? super TextAnnotatorScope, Unit> function1, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-2083052099);
        ComposerKt.sourceInformation(startRestartGroup, "C(StyleAnnotation)P(1)238@10311L117,238@10280L148:TextLinkScope.kt#423gt5");
        if ((i & 48) == 0) {
            i2 = (startRestartGroup.changedInstance(function1) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(this) ? 256 : 128;
        }
        startRestartGroup.startMovableGroup(-416717687, Integer.valueOf(objArr.length));
        int length = objArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            i2 |= startRestartGroup.changedInstance(objArr[i3]) ? 4 : 0;
        }
        startRestartGroup.endMovableGroup();
        if ((i2 & 14) == 0) {
            i2 |= 2;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2083052099, i2, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:237)");
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(function1);
            spreadBuilder.addSpread(objArr);
            Object[] array = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -416714451, "CC(remember):TextLinkScope.kt#9igjgp");
            boolean changedInstance = ((i2 & 112) == 32) | startRestartGroup.changedInstance(this);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TextLinkScope$StyleAnnotation$1$1(this, function1);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(array, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextLinkScope$StyleAnnotation$2(this, objArr, function1, i));
        }
    }

    /* access modifiers changed from: private */
    public static final boolean LinksComposables$lambda$13$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean LinksComposables$lambda$13$lambda$10(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean LinksComposables$lambda$13$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
