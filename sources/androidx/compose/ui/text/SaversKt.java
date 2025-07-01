package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001ay\u0010Q\u001a\u000e\u0012\u0004\u0012\u0002HR\u0012\u0004\u0012\u0002HS0\u0011\"\u0004\b\u0000\u0010R\"\b\b\u0001\u0010S*\u00020\u00032.\u0010T\u001a*\u0012\u0004\u0012\u00020V\u0012\u0013\u0012\u0011HR¢\u0006\f\bW\u0012\b\bX\u0012\u0004\b\b(Y\u0012\u0006\u0012\u0004\u0018\u0001HS0U¢\u0006\u0002\bZ2#\u0010[\u001a\u001f\u0012\u0013\u0012\u0011HS¢\u0006\f\bW\u0012\b\bX\u0012\u0004\b\b(Y\u0012\u0006\u0012\u0004\u0018\u0001HR0\\H\u0002\u001aL\u0010[\u001a\u0004\u0018\u0001H]\"\u0014\b\u0000\u0010^*\u000e\u0012\u0004\u0012\u0002HR\u0012\u0004\u0012\u0002HS0\u0001\"\u0004\b\u0001\u0010R\"\u0004\b\u0002\u0010S\"\u0006\b\u0003\u0010]\u0018\u00012\b\u0010Y\u001a\u0004\u0018\u0001HS2\u0006\u0010_\u001a\u0002H^H\b¢\u0006\u0002\u0010`\u001a\"\u0010[\u001a\u0004\u0018\u0001H]\"\u0006\b\u0000\u0010]\u0018\u00012\b\u0010Y\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0002\u0010a\u001aI\u0010T\u001a\u00020\u0003\"\u0014\b\u0000\u0010^*\u000e\u0012\u0004\u0012\u0002HR\u0012\u0004\u0012\u0002HS0\u0001\"\u0004\b\u0001\u0010R\"\u0004\b\u0002\u0010S2\b\u0010Y\u001a\u0004\u0018\u0001HR2\u0006\u0010_\u001a\u0002H^2\u0006\u0010b\u001a\u00020VH\u0000¢\u0006\u0002\u0010c\u001a\u001f\u0010T\u001a\u0004\u0018\u0001H^\"\u0004\b\u0000\u0010^2\b\u0010Y\u001a\u0004\u0018\u0001H^H\u0000¢\u0006\u0002\u0010a\" \u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"(\u0010\u0006\u001a\u001c\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\b0\u0007\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"(\u0010\t\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\b\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000b\"\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0011X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u0011X\u0004¢\u0006\u0002\n\u0000\" \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0005\"\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\" \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0005\"\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\" \u0010+\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0005\"\u001a\u0010.\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00030\u0011X\u0004¢\u0006\u0002\n\u0000\" \u00102\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\b\n\u0000\u0012\u0004\b4\u0010\u000b\"\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u0001*\u0002088@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0001*\u00020;8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010<\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00030\u0001*\u00020=8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010>\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00030\u0001*\u00020?8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010@\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0001*\u00020A8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010B\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030\u0001*\u00020C8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010D\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00030\u0001*\u00020E8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010F\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001*\u00020G8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010H\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00030\u0001*\u00020I8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010J\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00030\u0001*\u00020K8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010L\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00030\u0001*\u00020M8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010N\"$\u00107\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00030\u0001*\u00020O8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010P¨\u0006d"}, d2 = {"AnnotatedStringSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/AnnotatedString;", "", "getAnnotatedStringSaver", "()Landroidx/compose/runtime/saveable/Saver;", "AnnotationRangeListSaver", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "AnnotationRangeSaver", "getAnnotationRangeSaver$annotations", "()V", "BaselineShiftSaver", "Landroidx/compose/ui/text/style/BaselineShift;", "ClickableSaver", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "ColorSaver", "Landroidx/compose/ui/text/NonNullValueClassSaver;", "Landroidx/compose/ui/graphics/Color;", "FontWeightSaver", "Landroidx/compose/ui/text/font/FontWeight;", "LinkSaver", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "LocaleListSaver", "Landroidx/compose/ui/text/intl/LocaleList;", "LocaleSaver", "Landroidx/compose/ui/text/intl/Locale;", "OffsetSaver", "Landroidx/compose/ui/geometry/Offset;", "ParagraphStyleSaver", "Landroidx/compose/ui/text/ParagraphStyle;", "getParagraphStyleSaver", "ShadowSaver", "Landroidx/compose/ui/graphics/Shadow;", "SpanStyleSaver", "Landroidx/compose/ui/text/SpanStyle;", "getSpanStyleSaver", "TextDecorationSaver", "Landroidx/compose/ui/text/style/TextDecoration;", "TextGeometricTransformSaver", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "TextIndentSaver", "Landroidx/compose/ui/text/style/TextIndent;", "TextLinkStylesSaver", "Landroidx/compose/ui/text/TextLinkStyles;", "getTextLinkStylesSaver", "TextRangeSaver", "Landroidx/compose/ui/text/TextRange;", "TextUnitSaver", "Landroidx/compose/ui/unit/TextUnit;", "UrlAnnotationSaver", "Landroidx/compose/ui/text/UrlAnnotation;", "getUrlAnnotationSaver$annotations", "VerbatimTtsAnnotationSaver", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "Saver", "Landroidx/compose/ui/geometry/Offset$Companion;", "getSaver", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Color$Companion;", "(Landroidx/compose/ui/graphics/Color$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Shadow$Companion;", "(Landroidx/compose/ui/graphics/Shadow$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/TextRange$Companion;", "(Landroidx/compose/ui/text/TextRange$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/Locale$Companion;", "(Landroidx/compose/ui/text/intl/Locale$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/LocaleList$Companion;", "(Landroidx/compose/ui/text/intl/LocaleList$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/BaselineShift$Companion;", "(Landroidx/compose/ui/text/style/BaselineShift$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextDecoration$Companion;", "(Landroidx/compose/ui/text/style/TextDecoration$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "(Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextIndent$Companion;", "(Landroidx/compose/ui/text/style/TextIndent$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/unit/TextUnit$Companion;", "(Landroidx/compose/ui/unit/TextUnit$Companion;)Landroidx/compose/runtime/saveable/Saver;", "NonNullValueClassSaver", "Original", "Saveable", "save", "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/ExtensionFunctionType;", "restore", "Lkotlin/Function1;", "Result", "T", "saver", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;)Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "scope", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaverScope;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
public final class SaversKt {
    private static final Saver<AnnotatedString, Object> AnnotatedStringSaver = SaverKt.Saver(SaversKt$AnnotatedStringSaver$1.INSTANCE, SaversKt$AnnotatedStringSaver$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final Saver<List<AnnotatedString.Range<? extends Object>>, Object> AnnotationRangeListSaver = SaverKt.Saver(SaversKt$AnnotationRangeListSaver$1.INSTANCE, SaversKt$AnnotationRangeListSaver$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final Saver<AnnotatedString.Range<? extends Object>, Object> AnnotationRangeSaver = SaverKt.Saver(SaversKt$AnnotationRangeSaver$1.INSTANCE, SaversKt$AnnotationRangeSaver$2.INSTANCE);
    private static final Saver<BaselineShift, Object> BaselineShiftSaver = SaverKt.Saver(SaversKt$BaselineShiftSaver$1.INSTANCE, SaversKt$BaselineShiftSaver$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final Saver<LinkAnnotation.Clickable, Object> ClickableSaver = SaverKt.Saver(SaversKt$ClickableSaver$1.INSTANCE, SaversKt$ClickableSaver$2.INSTANCE);
    private static final NonNullValueClassSaver<Color, Object> ColorSaver = NonNullValueClassSaver(SaversKt$ColorSaver$1.INSTANCE, SaversKt$ColorSaver$2.INSTANCE);
    private static final Saver<FontWeight, Object> FontWeightSaver = SaverKt.Saver(SaversKt$FontWeightSaver$1.INSTANCE, SaversKt$FontWeightSaver$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final Saver<LinkAnnotation.Url, Object> LinkSaver = SaverKt.Saver(SaversKt$LinkSaver$1.INSTANCE, SaversKt$LinkSaver$2.INSTANCE);
    private static final Saver<LocaleList, Object> LocaleListSaver = SaverKt.Saver(SaversKt$LocaleListSaver$1.INSTANCE, SaversKt$LocaleListSaver$2.INSTANCE);
    private static final Saver<Locale, Object> LocaleSaver = SaverKt.Saver(SaversKt$LocaleSaver$1.INSTANCE, SaversKt$LocaleSaver$2.INSTANCE);
    private static final NonNullValueClassSaver<Offset, Object> OffsetSaver = NonNullValueClassSaver(SaversKt$OffsetSaver$1.INSTANCE, SaversKt$OffsetSaver$2.INSTANCE);
    private static final Saver<ParagraphStyle, Object> ParagraphStyleSaver = SaverKt.Saver(SaversKt$ParagraphStyleSaver$1.INSTANCE, SaversKt$ParagraphStyleSaver$2.INSTANCE);
    private static final Saver<Shadow, Object> ShadowSaver = SaverKt.Saver(SaversKt$ShadowSaver$1.INSTANCE, SaversKt$ShadowSaver$2.INSTANCE);
    private static final Saver<SpanStyle, Object> SpanStyleSaver = SaverKt.Saver(SaversKt$SpanStyleSaver$1.INSTANCE, SaversKt$SpanStyleSaver$2.INSTANCE);
    private static final Saver<TextDecoration, Object> TextDecorationSaver = SaverKt.Saver(SaversKt$TextDecorationSaver$1.INSTANCE, SaversKt$TextDecorationSaver$2.INSTANCE);
    private static final Saver<TextGeometricTransform, Object> TextGeometricTransformSaver = SaverKt.Saver(SaversKt$TextGeometricTransformSaver$1.INSTANCE, SaversKt$TextGeometricTransformSaver$2.INSTANCE);
    private static final Saver<TextIndent, Object> TextIndentSaver = SaverKt.Saver(SaversKt$TextIndentSaver$1.INSTANCE, SaversKt$TextIndentSaver$2.INSTANCE);
    private static final Saver<TextLinkStyles, Object> TextLinkStylesSaver = SaverKt.Saver(SaversKt$TextLinkStylesSaver$1.INSTANCE, SaversKt$TextLinkStylesSaver$2.INSTANCE);
    private static final Saver<TextRange, Object> TextRangeSaver = SaverKt.Saver(SaversKt$TextRangeSaver$1.INSTANCE, SaversKt$TextRangeSaver$2.INSTANCE);
    private static final NonNullValueClassSaver<TextUnit, Object> TextUnitSaver = NonNullValueClassSaver(SaversKt$TextUnitSaver$1.INSTANCE, SaversKt$TextUnitSaver$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final Saver<UrlAnnotation, Object> UrlAnnotationSaver = SaverKt.Saver(SaversKt$UrlAnnotationSaver$1.INSTANCE, SaversKt$UrlAnnotationSaver$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final Saver<VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver = SaverKt.Saver(SaversKt$VerbatimTtsAnnotationSaver$1.INSTANCE, SaversKt$VerbatimTtsAnnotationSaver$2.INSTANCE);

    private static /* synthetic */ void getAnnotationRangeSaver$annotations() {
    }

    private static /* synthetic */ void getUrlAnnotationSaver$annotations() {
    }

    public static final <T> T save(T t) {
        return t;
    }

    public static final <T extends Saver<Original, Saveable>, Original, Saveable> Object save(Original original, T t, SaverScope saverScope) {
        Object save;
        if (original == null || (save = t.save(saverScope, original)) == null) {
            return false;
        }
        return save;
    }

    public static final /* synthetic */ <T extends Saver<Original, Saveable>, Original, Saveable, Result> Result restore(Saveable saveable, T t) {
        if ((Intrinsics.areEqual((Object) saveable, (Object) false) && !(t instanceof NonNullValueClassSaver)) || saveable == null) {
            return null;
        }
        Saver saver = (Saver) t;
        Result restore = t.restore(saveable);
        Intrinsics.reifiedOperationMarker(1, "Result");
        Object obj = (Object) restore;
        return restore;
    }

    private static final <Original, Saveable> NonNullValueClassSaver<Original, Saveable> NonNullValueClassSaver(Function2<? super SaverScope, ? super Original, ? extends Saveable> function2, Function1<? super Saveable, ? extends Original> function1) {
        return new SaversKt$NonNullValueClassSaver$1(function2, function1);
    }

    public static final /* synthetic */ <Result> Result restore(Object obj) {
        if (obj == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(1, "Result");
        Object obj2 = obj;
        return obj;
    }

    public static final Saver<AnnotatedString, Object> getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    public static final Saver<ParagraphStyle, Object> getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    public static final Saver<SpanStyle, Object> getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    public static final Saver<TextLinkStyles, Object> getTextLinkStylesSaver() {
        return TextLinkStylesSaver;
    }

    public static final Saver<TextDecoration, Object> getSaver(TextDecoration.Companion companion) {
        return TextDecorationSaver;
    }

    public static final Saver<TextGeometricTransform, Object> getSaver(TextGeometricTransform.Companion companion) {
        return TextGeometricTransformSaver;
    }

    public static final Saver<TextIndent, Object> getSaver(TextIndent.Companion companion) {
        return TextIndentSaver;
    }

    public static final Saver<FontWeight, Object> getSaver(FontWeight.Companion companion) {
        return FontWeightSaver;
    }

    public static final Saver<BaselineShift, Object> getSaver(BaselineShift.Companion companion) {
        return BaselineShiftSaver;
    }

    public static final Saver<TextRange, Object> getSaver(TextRange.Companion companion) {
        return TextRangeSaver;
    }

    public static final Saver<Shadow, Object> getSaver(Shadow.Companion companion) {
        return ShadowSaver;
    }

    public static final Saver<Color, Object> getSaver(Color.Companion companion) {
        return ColorSaver;
    }

    public static final Saver<TextUnit, Object> getSaver(TextUnit.Companion companion) {
        return TextUnitSaver;
    }

    public static final Saver<Offset, Object> getSaver(Offset.Companion companion) {
        return OffsetSaver;
    }

    public static final Saver<LocaleList, Object> getSaver(LocaleList.Companion companion) {
        return LocaleListSaver;
    }

    public static final Saver<Locale, Object> getSaver(Locale.Companion companion) {
        return LocaleSaver;
    }
}
