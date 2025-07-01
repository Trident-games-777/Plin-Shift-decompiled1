package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e\u001a+\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0006\u0010\u0012\u001a\u0002H\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0010\u0013\u001a&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u00152\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a*\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0000\u001aÀ\u0001\u0010\u001c\u001a\u00020\n*\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u00012\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u00152\b\u00109\u001a\u0004\u0018\u00010:H\u0000ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u0018\u0010=\u001a\u0004\u0018\u00010\u0015*\u00020\n2\b\u0010>\u001a\u0004\u0018\u00010\u0015H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultColor", "DefaultColorForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "DefaultLetterSpacing", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "fraction", "", "lerpDiscrete", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "lerpTextUnitInheritable", "t", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SpanStyle.kt */
public final class SpanStyleKt {
    private static final long DefaultBackgroundColor = Color.Companion.m4274getTransparent0d7_KjU();
    private static final long DefaultColor;
    /* access modifiers changed from: private */
    public static final TextForegroundStyle DefaultColorForegroundStyle;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    static {
        long r0 = Color.Companion.m4265getBlack0d7_KjU();
        DefaultColor = r0;
        DefaultColorForegroundStyle = TextForegroundStyle.Companion.m7008from8_81llA(r0);
    }

    /* renamed from: lerpTextUnitInheritable-C3pnCVY  reason: not valid java name */
    public static final long m6520lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        if (TextUnitKt.m7324isUnspecifiedR2X_6o(j) || TextUnitKt.m7324isUnspecifiedR2X_6o(j2)) {
            return ((TextUnit) lerpDiscrete(TextUnit.m7296boximpl(j), TextUnit.m7296boximpl(j2), f)).m7315unboximpl();
        }
        return TextUnitKt.m7326lerpC3pnCVY(j, j2, f);
    }

    public static final SpanStyle lerp(SpanStyle spanStyle, SpanStyle spanStyle2, float f) {
        float f2 = f;
        TextForegroundStyle lerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle$ui_text_release(), spanStyle2.getTextForegroundStyle$ui_text_release(), f2);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f2);
        long r5 = m6520lerpTextUnitInheritableC3pnCVY(spanStyle.m6515getFontSizeXSAIIZE(), spanStyle2.m6515getFontSizeXSAIIZE(), f2);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight lerp2 = FontWeightKt.lerp(fontWeight, fontWeight2, f2);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.m6516getFontStyle4Lr2A7w(), spanStyle2.m6516getFontStyle4Lr2A7w(), f2);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.m6517getFontSynthesisZQGJjVo(), spanStyle2.m6517getFontSynthesisZQGJjVo(), f2);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f2);
        long r12 = m6520lerpTextUnitInheritableC3pnCVY(spanStyle.m6518getLetterSpacingXSAIIZE(), spanStyle2.m6518getLetterSpacingXSAIIZE(), f2);
        BaselineShift r1 = spanStyle.m6513getBaselineShift5SSeXJ0();
        float r13 = r1 != null ? r1.m6875unboximpl() : BaselineShift.m6870constructorimpl(0.0f);
        BaselineShift r3 = spanStyle2.m6513getBaselineShift5SSeXJ0();
        float r14 = BaselineShiftKt.m6882lerpjWV1Mfo(r13, r3 != null ? r3.m6875unboximpl() : BaselineShift.m6870constructorimpl(0.0f), f2);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform lerp3 = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f2);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f2);
        TextForegroundStyle textForegroundStyle = lerp;
        long j = r5;
        long r2 = ColorKt.m4290lerpjxsXWHM(spanStyle.m6512getBackground0d7_KjU(), spanStyle2.m6512getBackground0d7_KjU(), f2);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f2);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        return new SpanStyle(textForegroundStyle, j, lerp2, fontStyle, fontSynthesis, fontFamily, str, r12, BaselineShift.m6869boximpl(r14), lerp3, localeList, r2, textDecoration, ShadowKt.lerp(shadow, shadow2, f2), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f2), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f2), (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.Companion.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle spanStyle) {
        long j;
        TextForegroundStyle takeOrElse = spanStyle.getTextForegroundStyle$ui_text_release().takeOrElse(SpanStyleKt$resolveSpanStyleDefaults$1.INSTANCE);
        long r4 = TextUnitKt.m7324isUnspecifiedR2X_6o(spanStyle.m6515getFontSizeXSAIIZE()) ? DefaultFontSize : spanStyle.m6515getFontSizeXSAIIZE();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle r0 = spanStyle.m6516getFontStyle4Lr2A7w();
        FontStyle r7 = FontStyle.m6675boximpl(r0 != null ? r0.m6681unboximpl() : FontStyle.Companion.m6685getNormal_LCdwA());
        FontSynthesis r02 = spanStyle.m6517getFontSynthesisZQGJjVo();
        FontSynthesis r8 = FontSynthesis.m6686boximpl(r02 != null ? r02.m6694unboximpl() : FontSynthesis.Companion.m6695getAllGVVA2EU());
        FontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        if (TextUnitKt.m7324isUnspecifiedR2X_6o(spanStyle.m6518getLetterSpacingXSAIIZE())) {
            j = DefaultLetterSpacing;
        } else {
            j = spanStyle.m6518getLetterSpacingXSAIIZE();
        }
        long j2 = j;
        BaselineShift r03 = spanStyle.m6513getBaselineShift5SSeXJ0();
        BaselineShift r13 = BaselineShift.m6869boximpl(r03 != null ? r03.m6875unboximpl() : BaselineShift.Companion.m6879getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long r04 = spanStyle.m6512getBackground0d7_KjU();
        if (r04 == 16) {
            r04 = DefaultBackgroundColor;
        }
        long j3 = r04;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        DrawStyle drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(takeOrElse, r4, fontWeight2, r7, r8, fontFamily2, str, j2, r13, textGeometricTransform2, localeList2, j3, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return spanStyle.getPlatformStyle();
        }
        return spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        if (androidx.compose.ui.unit.TextUnit.m7303equalsimpl0(r33, r21.m6518getLetterSpacingXSAIIZE()) != false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0028, code lost:
        if (androidx.compose.ui.unit.TextUnit.m7303equalsimpl0(r11, r21.m6515getFontSizeXSAIIZE()) != false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d6, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r21.getTextGeometricTransform()) != false) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e7, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r37, (java.lang.Object) r21.getLocaleList()) != false) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fa, code lost:
        if (androidx.compose.ui.graphics.Color.m4240equalsimpl0(r7, r21.m6512getBackground0d7_KjU()) != false) goto L_0x00ff;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0195  */
    /* renamed from: fastMerge-dSHsh3o  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.text.SpanStyle m6519fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle r21, long r22, androidx.compose.ui.graphics.Brush r24, float r25, long r26, androidx.compose.ui.text.font.FontWeight r28, androidx.compose.ui.text.font.FontStyle r29, androidx.compose.ui.text.font.FontSynthesis r30, androidx.compose.ui.text.font.FontFamily r31, java.lang.String r32, long r33, androidx.compose.ui.text.style.BaselineShift r35, androidx.compose.ui.text.style.TextGeometricTransform r36, androidx.compose.ui.text.intl.LocaleList r37, long r38, androidx.compose.ui.text.style.TextDecoration r40, androidx.compose.ui.graphics.Shadow r41, androidx.compose.ui.text.PlatformSpanStyle r42, androidx.compose.ui.graphics.drawscope.DrawStyle r43) {
        /*
            r1 = r22
            r3 = r24
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r35
            r15 = r40
            r0 = r41
            r4 = r42
            boolean r16 = androidx.compose.ui.unit.TextUnitKt.m7324isUnspecifiedR2X_6o(r26)
            r17 = 16
            if (r16 != 0) goto L_0x0033
            long r13 = r21.m6515getFontSizeXSAIIZE()
            r11 = r26
            boolean r13 = androidx.compose.ui.unit.TextUnit.m7303equalsimpl0(r11, r13)
            if (r13 == 0) goto L_0x002b
            goto L_0x0035
        L_0x002b:
            r14 = r36
        L_0x002d:
            r7 = r38
        L_0x002f:
            r5 = r43
            goto L_0x0127
        L_0x0033:
            r11 = r26
        L_0x0035:
            if (r3 != 0) goto L_0x0049
            int r13 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r13 == 0) goto L_0x0049
            androidx.compose.ui.text.style.TextForegroundStyle r13 = r21.getTextForegroundStyle$ui_text_release()
            long r13 = r13.m7007getColor0d7_KjU()
            boolean r13 = androidx.compose.ui.graphics.Color.m4240equalsimpl0(r1, r13)
            if (r13 == 0) goto L_0x002b
        L_0x0049:
            if (r6 == 0) goto L_0x0055
            androidx.compose.ui.text.font.FontStyle r13 = r21.m6516getFontStyle4Lr2A7w()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x002b
        L_0x0055:
            if (r5 == 0) goto L_0x0061
            androidx.compose.ui.text.font.FontWeight r13 = r21.getFontWeight()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x002b
        L_0x0061:
            if (r8 == 0) goto L_0x0069
            androidx.compose.ui.text.font.FontFamily r13 = r21.getFontFamily()
            if (r8 != r13) goto L_0x002b
        L_0x0069:
            boolean r13 = androidx.compose.ui.unit.TextUnitKt.m7324isUnspecifiedR2X_6o(r33)
            if (r13 != 0) goto L_0x007c
            long r13 = r21.m6518getLetterSpacingXSAIIZE()
            r5 = r33
            boolean r13 = androidx.compose.ui.unit.TextUnit.m7303equalsimpl0(r5, r13)
            if (r13 == 0) goto L_0x002b
            goto L_0x007e
        L_0x007c:
            r5 = r33
        L_0x007e:
            if (r15 == 0) goto L_0x008a
            androidx.compose.ui.text.style.TextDecoration r13 = r21.getTextDecoration()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x002b
        L_0x008a:
            androidx.compose.ui.text.style.TextForegroundStyle r13 = r21.getTextForegroundStyle$ui_text_release()
            androidx.compose.ui.graphics.Brush r13 = r13.getBrush()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x002b
            if (r3 == 0) goto L_0x00a6
            androidx.compose.ui.text.style.TextForegroundStyle r13 = r21.getTextForegroundStyle$ui_text_release()
            float r13 = r13.getAlpha()
            int r13 = (r25 > r13 ? 1 : (r25 == r13 ? 0 : -1))
            if (r13 != 0) goto L_0x002b
        L_0x00a6:
            if (r7 == 0) goto L_0x00b2
            androidx.compose.ui.text.font.FontSynthesis r13 = r21.m6517getFontSynthesisZQGJjVo()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x002b
        L_0x00b2:
            if (r9 == 0) goto L_0x00be
            java.lang.String r13 = r21.getFontFeatureSettings()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x002b
        L_0x00be:
            if (r10 == 0) goto L_0x00ca
            androidx.compose.ui.text.style.BaselineShift r13 = r21.m6513getBaselineShift5SSeXJ0()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x002b
        L_0x00ca:
            if (r36 == 0) goto L_0x00d9
            androidx.compose.ui.text.style.TextGeometricTransform r13 = r21.getTextGeometricTransform()
            r14 = r36
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x002d
            goto L_0x00db
        L_0x00d9:
            r14 = r36
        L_0x00db:
            if (r37 == 0) goto L_0x00ea
            androidx.compose.ui.text.intl.LocaleList r13 = r21.getLocaleList()
            r5 = r37
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r13)
            if (r6 == 0) goto L_0x002d
            goto L_0x00ec
        L_0x00ea:
            r5 = r37
        L_0x00ec:
            int r6 = (r38 > r17 ? 1 : (r38 == r17 ? 0 : -1))
            if (r6 == 0) goto L_0x00fd
            long r5 = r21.m6512getBackground0d7_KjU()
            r7 = r38
            boolean r5 = androidx.compose.ui.graphics.Color.m4240equalsimpl0(r7, r5)
            if (r5 == 0) goto L_0x002f
            goto L_0x00ff
        L_0x00fd:
            r7 = r38
        L_0x00ff:
            if (r0 == 0) goto L_0x010b
            androidx.compose.ui.graphics.Shadow r5 = r21.getShadow()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x002f
        L_0x010b:
            if (r4 == 0) goto L_0x0117
            androidx.compose.ui.text.PlatformSpanStyle r5 = r21.getPlatformStyle()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x002f
        L_0x0117:
            r5 = r43
            if (r5 == 0) goto L_0x0126
            androidx.compose.ui.graphics.drawscope.DrawStyle r6 = r21.getDrawStyle()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r6 != 0) goto L_0x0126
            goto L_0x0127
        L_0x0126:
            return r21
        L_0x0127:
            if (r3 == 0) goto L_0x0132
            androidx.compose.ui.text.style.TextForegroundStyle$Companion r1 = androidx.compose.ui.text.style.TextForegroundStyle.Companion
            r2 = r25
            androidx.compose.ui.text.style.TextForegroundStyle r1 = r1.from(r3, r2)
            goto L_0x0138
        L_0x0132:
            androidx.compose.ui.text.style.TextForegroundStyle$Companion r3 = androidx.compose.ui.text.style.TextForegroundStyle.Companion
            androidx.compose.ui.text.style.TextForegroundStyle r1 = r3.m7008from8_81llA(r1)
        L_0x0138:
            androidx.compose.ui.text.style.TextForegroundStyle r2 = r21.getTextForegroundStyle$ui_text_release()
            androidx.compose.ui.text.style.TextForegroundStyle r1 = r2.merge(r1)
            if (r31 != 0) goto L_0x0147
            androidx.compose.ui.text.font.FontFamily r2 = r21.getFontFamily()
            goto L_0x0149
        L_0x0147:
            r2 = r31
        L_0x0149:
            boolean r3 = androidx.compose.ui.unit.TextUnitKt.m7324isUnspecifiedR2X_6o(r11)
            if (r3 != 0) goto L_0x0150
            goto L_0x0154
        L_0x0150:
            long r11 = r21.m6515getFontSizeXSAIIZE()
        L_0x0154:
            if (r28 != 0) goto L_0x015b
            androidx.compose.ui.text.font.FontWeight r3 = r21.getFontWeight()
            goto L_0x015d
        L_0x015b:
            r3 = r28
        L_0x015d:
            if (r29 != 0) goto L_0x0164
            androidx.compose.ui.text.font.FontStyle r6 = r21.m6516getFontStyle4Lr2A7w()
            goto L_0x0166
        L_0x0164:
            r6 = r29
        L_0x0166:
            if (r30 != 0) goto L_0x016d
            androidx.compose.ui.text.font.FontSynthesis r13 = r21.m6517getFontSynthesisZQGJjVo()
            goto L_0x016f
        L_0x016d:
            r13 = r30
        L_0x016f:
            if (r9 != 0) goto L_0x0175
            java.lang.String r9 = r21.getFontFeatureSettings()
        L_0x0175:
            boolean r16 = androidx.compose.ui.unit.TextUnitKt.m7324isUnspecifiedR2X_6o(r33)
            if (r16 != 0) goto L_0x017e
            r19 = r33
            goto L_0x0182
        L_0x017e:
            long r19 = r21.m6518getLetterSpacingXSAIIZE()
        L_0x0182:
            if (r10 != 0) goto L_0x0188
            androidx.compose.ui.text.style.BaselineShift r10 = r21.m6513getBaselineShift5SSeXJ0()
        L_0x0188:
            if (r14 != 0) goto L_0x018e
            androidx.compose.ui.text.style.TextGeometricTransform r14 = r21.getTextGeometricTransform()
        L_0x018e:
            if (r37 != 0) goto L_0x0195
            androidx.compose.ui.text.intl.LocaleList r16 = r21.getLocaleList()
            goto L_0x0197
        L_0x0195:
            r16 = r37
        L_0x0197:
            int r17 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r17 == 0) goto L_0x019c
            goto L_0x01a0
        L_0x019c:
            long r7 = r21.m6512getBackground0d7_KjU()
        L_0x01a0:
            if (r15 != 0) goto L_0x01a6
            androidx.compose.ui.text.style.TextDecoration r15 = r21.getTextDecoration()
        L_0x01a6:
            if (r0 != 0) goto L_0x01ac
            androidx.compose.ui.graphics.Shadow r0 = r21.getShadow()
        L_0x01ac:
            r38 = r0
            r0 = r21
            androidx.compose.ui.text.PlatformSpanStyle r4 = mergePlatformStyle(r0, r4)
            if (r5 != 0) goto L_0x01bb
            androidx.compose.ui.graphics.drawscope.DrawStyle r0 = r0.getDrawStyle()
            goto L_0x01bc
        L_0x01bb:
            r0 = r5
        L_0x01bc:
            androidx.compose.ui.text.SpanStyle r5 = new androidx.compose.ui.text.SpanStyle
            r17 = 0
            r40 = r0
            r22 = r1
            r28 = r2
            r25 = r3
            r39 = r4
            r21 = r5
            r26 = r6
            r35 = r7
            r29 = r9
            r32 = r10
            r23 = r11
            r27 = r13
            r33 = r14
            r37 = r15
            r34 = r16
            r41 = r17
            r30 = r19
            r21.<init>((androidx.compose.ui.text.style.TextForegroundStyle) r22, (long) r23, (androidx.compose.ui.text.font.FontWeight) r25, (androidx.compose.ui.text.font.FontStyle) r26, (androidx.compose.ui.text.font.FontSynthesis) r27, (androidx.compose.ui.text.font.FontFamily) r28, (java.lang.String) r29, (long) r30, (androidx.compose.ui.text.style.BaselineShift) r32, (androidx.compose.ui.text.style.TextGeometricTransform) r33, (androidx.compose.ui.text.intl.LocaleList) r34, (long) r35, (androidx.compose.ui.text.style.TextDecoration) r37, (androidx.compose.ui.graphics.Shadow) r38, (androidx.compose.ui.text.PlatformSpanStyle) r39, (androidx.compose.ui.graphics.drawscope.DrawStyle) r40, (kotlin.jvm.internal.DefaultConstructorMarker) r41)
            r0 = r21
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyleKt.m6519fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle, long, androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, androidx.compose.ui.graphics.drawscope.DrawStyle):androidx.compose.ui.text.SpanStyle");
    }
}
