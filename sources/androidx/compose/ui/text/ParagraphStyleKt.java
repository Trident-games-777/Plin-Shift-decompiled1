package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001af\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-j5T8yCg", "(Landroidx/compose/ui/text/ParagraphStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ParagraphStyle.kt */
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.Companion.m7317getUnspecifiedXSAIIZE();

    public static final ParagraphStyle lerp(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, float f) {
        int r1 = ((TextAlign) SpanStyleKt.lerpDiscrete(TextAlign.m6979boximpl(paragraphStyle.m6470getTextAligne0LSkKk()), TextAlign.m6979boximpl(paragraphStyle2.m6470getTextAligne0LSkKk()), f)).m6985unboximpl();
        int r2 = ((TextDirection) SpanStyleKt.lerpDiscrete(TextDirection.m6993boximpl(paragraphStyle.m6472getTextDirections_7Xco()), TextDirection.m6993boximpl(paragraphStyle2.m6472getTextDirections_7Xco()), f)).m6999unboximpl();
        long r3 = SpanStyleKt.m6520lerpTextUnitInheritableC3pnCVY(paragraphStyle.m6468getLineHeightXSAIIZE(), paragraphStyle2.m6468getLineHeightXSAIIZE(), f);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.Companion.getNone();
        }
        return new ParagraphStyle(r1, r2, r3, TextIndentKt.lerp(textIndent, textIndent2, f), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f), ((LineBreak) SpanStyleKt.lerpDiscrete(LineBreak.m6899boximpl(paragraphStyle.m6467getLineBreakrAG3T2k()), LineBreak.m6899boximpl(paragraphStyle2.m6467getLineBreakrAG3T2k()), f)).m6911unboximpl(), ((Hyphens) SpanStyleKt.lerpDiscrete(Hyphens.m6889boximpl(paragraphStyle.m6465getHyphensvmbZdU8()), Hyphens.m6889boximpl(paragraphStyle2.m6465getHyphensvmbZdU8()), f)).m6895unboximpl(), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.Companion.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle paragraphStyle, LayoutDirection layoutDirection) {
        int r1 = TextAlign.m6982equalsimpl0(paragraphStyle.m6470getTextAligne0LSkKk(), TextAlign.Companion.m6992getUnspecifiede0LSkKk()) ? TextAlign.Companion.m6991getStarte0LSkKk() : paragraphStyle.m6470getTextAligne0LSkKk();
        int r2 = TextStyleKt.m6610resolveTextDirectionIhaHGbI(layoutDirection, paragraphStyle.m6472getTextDirections_7Xco());
        long r3 = TextUnitKt.m7324isUnspecifiedR2X_6o(paragraphStyle.m6468getLineHeightXSAIIZE()) ? DefaultLineHeight : paragraphStyle.m6468getLineHeightXSAIIZE();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        int r8 = LineBreak.m6905equalsimpl0(paragraphStyle.m6467getLineBreakrAG3T2k(), LineBreak.Companion.m6919getUnspecifiedrAG3T2k()) ? LineBreak.Companion.m6918getSimplerAG3T2k() : paragraphStyle.m6467getLineBreakrAG3T2k();
        int r9 = Hyphens.m6892equalsimpl0(paragraphStyle.m6465getHyphensvmbZdU8(), Hyphens.Companion.m6898getUnspecifiedvmbZdU8()) ? Hyphens.Companion.m6897getNonevmbZdU8() : paragraphStyle.m6465getHyphensvmbZdU8();
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        return new ParagraphStyle(r1, r2, r3, textIndent2, platformStyle, lineHeightStyle, r8, r9, textMotion, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003d, code lost:
        if (androidx.compose.ui.unit.TextUnit.m7303equalsimpl0(r11, r0.m6468getLineHeightXSAIIZE()) != false) goto L_0x0042;
     */
    /* renamed from: fastMerge-j5T8yCg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.text.ParagraphStyle m6473fastMergej5T8yCg(androidx.compose.ui.text.ParagraphStyle r23, int r24, int r25, long r26, androidx.compose.ui.text.style.TextIndent r28, androidx.compose.ui.text.PlatformParagraphStyle r29, androidx.compose.ui.text.style.LineHeightStyle r30, int r31, int r32, androidx.compose.ui.text.style.TextMotion r33) {
        /*
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r8 = r33
            androidx.compose.ui.text.style.TextAlign$Companion r9 = androidx.compose.ui.text.style.TextAlign.Companion
            int r9 = r9.m6992getUnspecifiede0LSkKk()
            boolean r9 = androidx.compose.ui.text.style.TextAlign.m6982equalsimpl0(r1, r9)
            if (r9 != 0) goto L_0x002d
            int r9 = r0.m6470getTextAligne0LSkKk()
            boolean r9 = androidx.compose.ui.text.style.TextAlign.m6982equalsimpl0(r1, r9)
            if (r9 == 0) goto L_0x0029
            goto L_0x002d
        L_0x0029:
            r11 = r26
            goto L_0x00b4
        L_0x002d:
            boolean r9 = androidx.compose.ui.unit.TextUnitKt.m7324isUnspecifiedR2X_6o(r26)
            if (r9 != 0) goto L_0x0040
            long r9 = r0.m6468getLineHeightXSAIIZE()
            r11 = r26
            boolean r9 = androidx.compose.ui.unit.TextUnit.m7303equalsimpl0(r11, r9)
            if (r9 == 0) goto L_0x00b4
            goto L_0x0042
        L_0x0040:
            r11 = r26
        L_0x0042:
            if (r3 == 0) goto L_0x004e
            androidx.compose.ui.text.style.TextIndent r9 = r0.getTextIndent()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x00b4
        L_0x004e:
            androidx.compose.ui.text.style.TextDirection$Companion r9 = androidx.compose.ui.text.style.TextDirection.Companion
            int r9 = r9.m7005getUnspecifieds_7Xco()
            boolean r9 = androidx.compose.ui.text.style.TextDirection.m6996equalsimpl0(r2, r9)
            if (r9 != 0) goto L_0x0064
            int r9 = r0.m6472getTextDirections_7Xco()
            boolean r9 = androidx.compose.ui.text.style.TextDirection.m6996equalsimpl0(r2, r9)
            if (r9 == 0) goto L_0x00b4
        L_0x0064:
            if (r4 == 0) goto L_0x0070
            androidx.compose.ui.text.PlatformParagraphStyle r9 = r0.getPlatformStyle()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x00b4
        L_0x0070:
            if (r5 == 0) goto L_0x007c
            androidx.compose.ui.text.style.LineHeightStyle r9 = r0.getLineHeightStyle()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x00b4
        L_0x007c:
            androidx.compose.ui.text.style.LineBreak$Companion r9 = androidx.compose.ui.text.style.LineBreak.Companion
            int r9 = r9.m6919getUnspecifiedrAG3T2k()
            boolean r9 = androidx.compose.ui.text.style.LineBreak.m6905equalsimpl0(r6, r9)
            if (r9 != 0) goto L_0x0092
            int r9 = r0.m6467getLineBreakrAG3T2k()
            boolean r9 = androidx.compose.ui.text.style.LineBreak.m6905equalsimpl0(r6, r9)
            if (r9 == 0) goto L_0x00b4
        L_0x0092:
            androidx.compose.ui.text.style.Hyphens$Companion r9 = androidx.compose.ui.text.style.Hyphens.Companion
            int r9 = r9.m6898getUnspecifiedvmbZdU8()
            boolean r9 = androidx.compose.ui.text.style.Hyphens.m6892equalsimpl0(r7, r9)
            if (r9 != 0) goto L_0x00a8
            int r9 = r0.m6465getHyphensvmbZdU8()
            boolean r9 = androidx.compose.ui.text.style.Hyphens.m6892equalsimpl0(r7, r9)
            if (r9 == 0) goto L_0x00b4
        L_0x00a8:
            if (r8 == 0) goto L_0x013a
            androidx.compose.ui.text.style.TextMotion r9 = r0.getTextMotion()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r9 != 0) goto L_0x013a
        L_0x00b4:
            boolean r9 = androidx.compose.ui.unit.TextUnitKt.m7324isUnspecifiedR2X_6o(r11)
            if (r9 == 0) goto L_0x00c0
            long r9 = r0.m6468getLineHeightXSAIIZE()
            r14 = r9
            goto L_0x00c1
        L_0x00c0:
            r14 = r11
        L_0x00c1:
            if (r3 != 0) goto L_0x00c7
            androidx.compose.ui.text.style.TextIndent r3 = r0.getTextIndent()
        L_0x00c7:
            r16 = r3
            androidx.compose.ui.text.style.TextAlign$Companion r3 = androidx.compose.ui.text.style.TextAlign.Companion
            int r3 = r3.m6992getUnspecifiede0LSkKk()
            boolean r3 = androidx.compose.ui.text.style.TextAlign.m6982equalsimpl0(r1, r3)
            if (r3 != 0) goto L_0x00d6
            goto L_0x00da
        L_0x00d6:
            int r1 = r0.m6470getTextAligne0LSkKk()
        L_0x00da:
            r12 = r1
            androidx.compose.ui.text.style.TextDirection$Companion r1 = androidx.compose.ui.text.style.TextDirection.Companion
            int r1 = r1.m7005getUnspecifieds_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m6996equalsimpl0(r2, r1)
            if (r1 != 0) goto L_0x00e9
            r13 = r2
            goto L_0x00ee
        L_0x00e9:
            int r1 = r0.m6472getTextDirections_7Xco()
            r13 = r1
        L_0x00ee:
            androidx.compose.ui.text.PlatformParagraphStyle r17 = mergePlatformStyle(r0, r4)
            if (r5 != 0) goto L_0x00fb
            androidx.compose.ui.text.style.LineHeightStyle r1 = r0.getLineHeightStyle()
            r18 = r1
            goto L_0x00fd
        L_0x00fb:
            r18 = r5
        L_0x00fd:
            androidx.compose.ui.text.style.LineBreak$Companion r1 = androidx.compose.ui.text.style.LineBreak.Companion
            int r1 = r1.m6919getUnspecifiedrAG3T2k()
            boolean r1 = androidx.compose.ui.text.style.LineBreak.m6905equalsimpl0(r6, r1)
            if (r1 != 0) goto L_0x010c
            r19 = r6
            goto L_0x0112
        L_0x010c:
            int r1 = r0.m6467getLineBreakrAG3T2k()
            r19 = r1
        L_0x0112:
            androidx.compose.ui.text.style.Hyphens$Companion r1 = androidx.compose.ui.text.style.Hyphens.Companion
            int r1 = r1.m6898getUnspecifiedvmbZdU8()
            boolean r1 = androidx.compose.ui.text.style.Hyphens.m6892equalsimpl0(r7, r1)
            if (r1 != 0) goto L_0x0121
            r20 = r7
            goto L_0x0127
        L_0x0121:
            int r1 = r0.m6465getHyphensvmbZdU8()
            r20 = r1
        L_0x0127:
            if (r8 != 0) goto L_0x0130
            androidx.compose.ui.text.style.TextMotion r0 = r0.getTextMotion()
            r21 = r0
            goto L_0x0132
        L_0x0130:
            r21 = r8
        L_0x0132:
            androidx.compose.ui.text.ParagraphStyle r11 = new androidx.compose.ui.text.ParagraphStyle
            r22 = 0
            r11.<init>((int) r12, (int) r13, (long) r14, (androidx.compose.ui.text.style.TextIndent) r16, (androidx.compose.ui.text.PlatformParagraphStyle) r17, (androidx.compose.ui.text.style.LineHeightStyle) r18, (int) r19, (int) r20, (androidx.compose.ui.text.style.TextMotion) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            return r11
        L_0x013a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyleKt.m6473fastMergej5T8yCg(androidx.compose.ui.text.ParagraphStyle, int, int, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, int, int, androidx.compose.ui.text.style.TextMotion):androidx.compose.ui.text.ParagraphStyle");
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (paragraphStyle.getPlatformStyle() == null) {
            return platformParagraphStyle;
        }
        if (platformParagraphStyle == null) {
            return paragraphStyle.getPlatformStyle();
        }
        return paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }
}
