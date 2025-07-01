package androidx.compose.ui.text;

import android.graphics.Typeface;
import android.text.Html;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.text.HtmlCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(d1 = {"\u0000i\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002\u001a8\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002\u001a(\u0010\u0015\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002\u001a*\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a$\u0010\u001c\u001a\u00020\u0019*\u00020\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0001\u001a\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0002\u001a\u000e\u0010 \u001a\u0004\u0018\u00010!*\u00020\"H\u0002\u001a\f\u0010 \u001a\u00020!*\u00020#H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006$"}, d2 = {"AnnotationTag", "", "ContentHandlerReplacementTag", "TagHandler", "androidx/compose/ui/text/Html_androidKt$TagHandler$1", "Landroidx/compose/ui/text/Html_androidKt$TagHandler$1;", "optionalFontFamilyFromName", "Landroidx/compose/ui/text/font/FontFamily;", "familyName", "addSpan", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "span", "", "start", "", "end", "linkStyles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "addSpans", "spanned", "Landroid/text/Spanned;", "fromHtml", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/AnnotatedString$Companion;", "htmlString", "toAnnotatedString", "toParagraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "Landroid/text/style/AlignmentSpan;", "toSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroid/text/style/StyleSpan;", "Landroid/text/style/TypefaceSpan;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Html.android.kt */
public final class Html_androidKt {
    private static final String AnnotationTag = "annotation";
    private static final String ContentHandlerReplacementTag = "ContentHandlerReplacementTag";
    private static final Html_androidKt$TagHandler$1 TagHandler = new Html_androidKt$TagHandler$1();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Html.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                android.text.Layout$Alignment[] r0 = android.text.Layout.Alignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.Html_androidKt.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ AnnotatedString fromHtml$default(AnnotatedString.Companion companion, String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener, int i, Object obj) {
        if ((i & 2) != 0) {
            textLinkStyles = null;
        }
        if ((i & 4) != 0) {
            linkInteractionListener = null;
        }
        return fromHtml(companion, str, textLinkStyles, linkInteractionListener);
    }

    public static final AnnotatedString fromHtml(AnnotatedString.Companion companion, String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        return toAnnotatedString(HtmlCompat.fromHtml("<ContentHandlerReplacementTag />" + str, 63, (Html.ImageGetter) null, TagHandler), textLinkStyles, linkInteractionListener);
    }

    public static /* synthetic */ AnnotatedString toAnnotatedString$default(Spanned spanned, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener, int i, Object obj) {
        if ((i & 1) != 0) {
            textLinkStyles = null;
        }
        if ((i & 2) != 0) {
            linkInteractionListener = null;
        }
        return toAnnotatedString(spanned, textLinkStyles, linkInteractionListener);
    }

    public static final AnnotatedString toAnnotatedString(Spanned spanned, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        AnnotatedString.Builder append = new AnnotatedString.Builder(spanned.length()).append((CharSequence) spanned);
        addSpans(append, spanned, textLinkStyles, linkInteractionListener);
        return append.toAnnotatedString();
    }

    private static final void addSpans(AnnotatedString.Builder builder, Spanned spanned, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        for (Object obj : spanned.getSpans(0, builder.getLength(), Object.class)) {
            long TextRange = TextRangeKt.TextRange(spanned.getSpanStart(obj), spanned.getSpanEnd(obj));
            addSpan(builder, obj, TextRange.m6564getStartimpl(TextRange), TextRange.m6559getEndimpl(TextRange), textLinkStyles, linkInteractionListener);
        }
    }

    private static final void addSpan(AnnotatedString.Builder builder, Object obj, int i, int i2, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        String url;
        AnnotatedString.Builder builder2 = builder;
        Object obj2 = obj;
        int i3 = i;
        int i4 = i2;
        if (obj2 instanceof AbsoluteSizeSpan) {
            return;
        }
        if (obj2 instanceof AlignmentSpan) {
            builder2.addStyle(toParagraphStyle((AlignmentSpan) obj2), i3, i4);
        } else if (obj2 instanceof AnnotationSpan) {
            AnnotationSpan annotationSpan = (AnnotationSpan) obj2;
            builder2.addStringAnnotation(annotationSpan.getKey(), annotationSpan.getValue(), i3, i4);
        } else if (obj2 instanceof BackgroundColorSpan) {
            builder2.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, ColorKt.Color(((BackgroundColorSpan) obj2).getBackgroundColor()), (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63487, (DefaultConstructorMarker) null), i3, i4);
        } else if (obj2 instanceof ForegroundColorSpan) {
            builder2.addStyle(new SpanStyle(ColorKt.Color(((ForegroundColorSpan) obj2).getForegroundColor()), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), i3, i4);
        } else if (obj2 instanceof RelativeSizeSpan) {
            builder2.addStyle(new SpanStyle(0, TextUnitKt.getEm(((RelativeSizeSpan) obj2).getSizeChange()), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, (int) Utf8.REPLACEMENT_CODE_POINT, (DefaultConstructorMarker) null), i3, i4);
        } else if (obj2 instanceof StrikethroughSpan) {
            builder2.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getLineThrough(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), i3, i4);
        } else if (obj2 instanceof StyleSpan) {
            SpanStyle spanStyle = toSpanStyle((StyleSpan) obj2);
            if (spanStyle != null) {
                builder2.addStyle(spanStyle, i3, i4);
            }
        } else if (obj2 instanceof SubscriptSpan) {
            builder2.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, BaselineShift.m6869boximpl(BaselineShift.Companion.m6880getSubscripty9eOQZs()), (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65279, (DefaultConstructorMarker) null), i3, i4);
        } else if (obj2 instanceof SuperscriptSpan) {
            builder2.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, BaselineShift.m6869boximpl(BaselineShift.Companion.m6881getSuperscripty9eOQZs()), (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65279, (DefaultConstructorMarker) null), i3, i4);
        } else if (obj2 instanceof TypefaceSpan) {
            builder2.addStyle(toSpanStyle((TypefaceSpan) obj2), i3, i4);
        } else if (obj2 instanceof UnderlineSpan) {
            builder2.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), i3, i4);
        } else if ((obj2 instanceof URLSpan) && (url = ((URLSpan) obj2).getURL()) != null) {
            builder2.addLink(new LinkAnnotation.Url(url, textLinkStyles, linkInteractionListener), i3, i4);
        }
    }

    private static final ParagraphStyle toParagraphStyle(AlignmentSpan alignmentSpan) {
        int i;
        Layout.Alignment alignment = alignmentSpan.getAlignment();
        int i2 = alignment == null ? -1 : WhenMappings.$EnumSwitchMapping$0[alignment.ordinal()];
        if (i2 == 1) {
            i = TextAlign.Companion.m6991getStarte0LSkKk();
        } else if (i2 == 2) {
            i = TextAlign.Companion.m6986getCentere0LSkKk();
        } else if (i2 != 3) {
            i = TextAlign.Companion.m6992getUnspecifiede0LSkKk();
        } else {
            i = TextAlign.Companion.m6987getEnde0LSkKk();
        }
        return new ParagraphStyle(i, 0, 0, (TextIndent) null, (PlatformParagraphStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 510, (DefaultConstructorMarker) null);
    }

    private static final SpanStyle toSpanStyle(StyleSpan styleSpan) {
        int style = styleSpan.getStyle();
        if (style == 1) {
            return new SpanStyle(0, 0, FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null);
        }
        if (style == 2) {
            return new SpanStyle(0, 0, (FontWeight) null, FontStyle.m6675boximpl(FontStyle.Companion.m6684getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (DefaultConstructorMarker) null);
        }
        if (style != 3) {
            return null;
        }
        return new SpanStyle(0, 0, FontWeight.Companion.getBold(), FontStyle.m6675boximpl(FontStyle.Companion.m6684getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65523, (DefaultConstructorMarker) null);
    }

    private static final SpanStyle toSpanStyle(TypefaceSpan typefaceSpan) {
        FontFamily optionalFontFamilyFromName;
        String family = typefaceSpan.getFamily();
        if (Intrinsics.areEqual((Object) family, (Object) FontFamily.Companion.getCursive().getName())) {
            optionalFontFamilyFromName = FontFamily.Companion.getCursive();
        } else if (Intrinsics.areEqual((Object) family, (Object) FontFamily.Companion.getMonospace().getName())) {
            optionalFontFamilyFromName = FontFamily.Companion.getMonospace();
        } else if (Intrinsics.areEqual((Object) family, (Object) FontFamily.Companion.getSansSerif().getName())) {
            optionalFontFamilyFromName = FontFamily.Companion.getSansSerif();
        } else if (Intrinsics.areEqual((Object) family, (Object) FontFamily.Companion.getSerif().getName())) {
            optionalFontFamilyFromName = FontFamily.Companion.getSerif();
        } else {
            optionalFontFamilyFromName = optionalFontFamilyFromName(typefaceSpan.getFamily());
        }
        return new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, optionalFontFamilyFromName, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65503, (DefaultConstructorMarker) null);
    }

    private static final FontFamily optionalFontFamilyFromName(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Typeface create = Typeface.create(str, 0);
            if (Intrinsics.areEqual((Object) create, (Object) Typeface.DEFAULT) || Intrinsics.areEqual((Object) create, (Object) Typeface.create(Typeface.DEFAULT, 0))) {
                create = null;
            }
            if (create != null) {
                return AndroidTypeface_androidKt.FontFamily(create);
            }
        }
        return null;
    }
}
