package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Jt\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020$2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Landroidx/compose/ui/text/TextMeasurer;", "", "defaultFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "defaultDensity", "Landroidx/compose/ui/unit/Density;", "defaultLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cacheSize", "", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;I)V", "textLayoutCache", "Landroidx/compose/ui/text/TextLayoutCache;", "measure", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "density", "fontFamilyResolver", "skipCache", "measure-xDpz5zY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILjava/util/List;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "", "measure-wNUYSr0", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;IZIJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextMeasurer.kt */
public final class TextMeasurer {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int cacheSize;
    private final Density defaultDensity;
    private final FontFamily.Resolver defaultFontFamilyResolver;
    private final LayoutDirection defaultLayoutDirection;
    private final TextLayoutCache textLayoutCache;

    public TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i) {
        this.defaultFontFamilyResolver = resolver;
        this.defaultDensity = density;
        this.defaultLayoutDirection = layoutDirection;
        this.cacheSize = i;
        this.textLayoutCache = i > 0 ? new TextLayoutCache(i) : null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver, density, layoutDirection, (i2 & 8) != 0 ? TextMeasurerKt.DefaultCacheSize : i);
    }

    /* renamed from: measure-xDpz5zY$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m6540measurexDpz5zY$default(TextMeasurer textMeasurer, AnnotatedString annotatedString, TextStyle textStyle, int i, boolean z, int i2, List list, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        FontFamily.Resolver resolver2;
        int i4 = i3;
        if ((i4 & 2) != 0) {
            textStyle = TextStyle.Companion.getDefault();
        }
        TextStyle textStyle2 = textStyle;
        int r3 = (i4 & 4) != 0 ? TextOverflow.Companion.m7037getClipgIe3tQ8() : i;
        boolean z3 = (i4 & 8) != 0 ? true : z;
        int i5 = (i4 & 16) != 0 ? Integer.MAX_VALUE : i2;
        List emptyList = (i4 & 32) != 0 ? CollectionsKt.emptyList() : list;
        long Constraints$default = (i4 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null) : j;
        LayoutDirection layoutDirection2 = (i4 & 128) != 0 ? textMeasurer.defaultLayoutDirection : layoutDirection;
        Density density2 = (i4 & 256) != 0 ? textMeasurer.defaultDensity : density;
        if ((i4 & 512) != 0) {
            resolver2 = textMeasurer.defaultFontFamilyResolver;
        } else {
            resolver2 = resolver;
        }
        return textMeasurer.m6542measurexDpz5zY(annotatedString, textStyle2, r3, z3, i5, emptyList, Constraints$default, layoutDirection2, density2, resolver2, (i4 & 1024) != 0 ? false : z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001a, code lost:
        r14 = r13.textLayoutCache;
     */
    /* renamed from: measure-xDpz5zY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.text.TextLayoutResult m6542measurexDpz5zY(androidx.compose.ui.text.AnnotatedString r14, androidx.compose.ui.text.TextStyle r15, int r16, boolean r17, int r18, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> r19, long r20, androidx.compose.ui.unit.LayoutDirection r22, androidx.compose.ui.unit.Density r23, androidx.compose.ui.text.font.FontFamily.Resolver r24, boolean r25) {
        /*
            r13 = this;
            androidx.compose.ui.text.TextLayoutInput r0 = new androidx.compose.ui.text.TextLayoutInput
            r12 = 0
            r1 = r14
            r2 = r15
            r6 = r16
            r5 = r17
            r4 = r18
            r3 = r19
            r10 = r20
            r8 = r22
            r7 = r23
            r9 = r24
            r0.<init>((androidx.compose.ui.text.AnnotatedString) r1, (androidx.compose.ui.text.TextStyle) r2, (java.util.List) r3, (int) r4, (boolean) r5, (int) r6, (androidx.compose.ui.unit.Density) r7, (androidx.compose.ui.unit.LayoutDirection) r8, (androidx.compose.ui.text.font.FontFamily.Resolver) r9, (long) r10, (kotlin.jvm.internal.DefaultConstructorMarker) r12)
            if (r25 != 0) goto L_0x0023
            androidx.compose.ui.text.TextLayoutCache r14 = r13.textLayoutCache
            if (r14 == 0) goto L_0x0023
            androidx.compose.ui.text.TextLayoutResult r14 = r14.get(r0)
            goto L_0x0024
        L_0x0023:
            r14 = 0
        L_0x0024:
            if (r14 == 0) goto L_0x004d
            androidx.compose.ui.text.MultiParagraph r15 = r14.getMultiParagraph()
            float r15 = r15.getWidth()
            int r15 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r15)
            androidx.compose.ui.text.MultiParagraph r1 = r14.getMultiParagraph()
            float r1 = r1.getHeight()
            int r1 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r1)
            long r1 = androidx.compose.ui.unit.IntSizeKt.IntSize(r15, r1)
            r10 = r20
            long r1 = androidx.compose.ui.unit.ConstraintsKt.m7066constrain4WqzIAM(r10, r1)
            androidx.compose.ui.text.TextLayoutResult r14 = r14.m6535copyO0kMr_c(r0, r1)
            return r14
        L_0x004d:
            androidx.compose.ui.text.TextMeasurer$Companion r14 = Companion
            androidx.compose.ui.text.TextLayoutResult r14 = r14.layout(r0)
            androidx.compose.ui.text.TextLayoutCache r15 = r13.textLayoutCache
            if (r15 == 0) goto L_0x005a
            r15.put(r0, r14)
        L_0x005a:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextMeasurer.m6542measurexDpz5zY(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, int, boolean, int, java.util.List, long, androidx.compose.ui.unit.LayoutDirection, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.FontFamily$Resolver, boolean):androidx.compose.ui.text.TextLayoutResult");
    }

    /* renamed from: measure-wNUYSr0$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m6539measurewNUYSr0$default(TextMeasurer textMeasurer, String str, TextStyle textStyle, int i, boolean z, int i2, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        FontFamily.Resolver resolver2;
        int i4 = i3;
        if ((i4 & 2) != 0) {
            textStyle = TextStyle.Companion.getDefault();
        }
        TextStyle textStyle2 = textStyle;
        if ((i4 & 4) != 0) {
            i = TextOverflow.Companion.m7037getClipgIe3tQ8();
        }
        int i5 = i;
        boolean z3 = (i4 & 8) != 0 ? true : z;
        int i6 = (i4 & 16) != 0 ? Integer.MAX_VALUE : i2;
        long Constraints$default = (i4 & 32) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null) : j;
        LayoutDirection layoutDirection2 = (i4 & 64) != 0 ? textMeasurer.defaultLayoutDirection : layoutDirection;
        Density density2 = (i4 & 128) != 0 ? textMeasurer.defaultDensity : density;
        if ((i4 & 256) != 0) {
            resolver2 = textMeasurer.defaultFontFamilyResolver;
        } else {
            resolver2 = resolver;
        }
        return textMeasurer.m6541measurewNUYSr0(str, textStyle2, i5, z3, i6, Constraints$default, layoutDirection2, density2, resolver2, (i4 & 512) != 0 ? false : z2);
    }

    /* renamed from: measure-wNUYSr0  reason: not valid java name */
    public final TextLayoutResult m6541measurewNUYSr0(String str, TextStyle textStyle, int i, boolean z, int i2, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2) {
        return m6540measurexDpz5zY$default(this, new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), textStyle, i, z, i2, (List) null, j, layoutDirection, density, resolver, z2, 32, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/TextMeasurer$Companion;", "", "()V", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextMeasurer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final TextLayoutResult layout(TextLayoutInput textLayoutInput) {
            int i;
            MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(textLayoutInput.getText(), TextStyleKt.resolveDefaults(textLayoutInput.getStyle(), textLayoutInput.getLayoutDirection()), textLayoutInput.getPlaceholders(), textLayoutInput.getDensity(), textLayoutInput.getFontFamilyResolver());
            int r1 = Constraints.m7054getMinWidthimpl(textLayoutInput.m6532getConstraintsmsEJaDk());
            int r2 = ((textLayoutInput.getSoftWrap() || TextOverflow.m7030equalsimpl0(textLayoutInput.m6533getOverflowgIe3tQ8(), TextOverflow.Companion.m7038getEllipsisgIe3tQ8())) && Constraints.m7048getHasBoundedWidthimpl(textLayoutInput.m6532getConstraintsmsEJaDk())) ? Constraints.m7052getMaxWidthimpl(textLayoutInput.m6532getConstraintsmsEJaDk()) : Integer.MAX_VALUE;
            if (textLayoutInput.getSoftWrap() || !TextOverflow.m7030equalsimpl0(textLayoutInput.m6533getOverflowgIe3tQ8(), TextOverflow.Companion.m7038getEllipsisgIe3tQ8())) {
                i = textLayoutInput.getMaxLines();
            } else {
                i = 1;
            }
            int i2 = i;
            if (r1 != r2) {
                r2 = RangesKt.coerceIn(ParagraphKt.ceilToInt(multiParagraphIntrinsics.getMaxIntrinsicWidth()), r1, r2);
            }
            MultiParagraph multiParagraph = new MultiParagraph(multiParagraphIntrinsics, Constraints.Companion.m7061fitPrioritizingWidthZbe2FdA(0, r2, 0, Constraints.m7051getMaxHeightimpl(textLayoutInput.m6532getConstraintsmsEJaDk())), i2, TextOverflow.m7030equalsimpl0(textLayoutInput.m6533getOverflowgIe3tQ8(), TextOverflow.Companion.m7038getEllipsisgIe3tQ8()), (DefaultConstructorMarker) null);
            return new TextLayoutResult(textLayoutInput, multiParagraph, ConstraintsKt.m7066constrain4WqzIAM(textLayoutInput.m6532getConstraintsmsEJaDk(), IntSizeKt.IntSize((int) ((float) Math.ceil((double) multiParagraph.getWidth())), (int) ((float) Math.ceil((double) multiParagraph.getHeight())))), (DefaultConstructorMarker) null);
        }
    }
}
