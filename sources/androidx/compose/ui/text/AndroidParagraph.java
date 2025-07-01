package androidx.compose.ui.text;

import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary_androidKt;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001Bg\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016B%\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0019JJ\u0010K\u001a\u0002002\u0006\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\r2\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010P\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\rH\u0002J,\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\b\b\u0001\u0010Z\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b[\u0010\\J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\rH\u0016J\u0010\u0010`\u001a\u00020<2\u0006\u0010_\u001a\u00020\rH\u0016J\u0010\u0010a\u001a\u00020<2\u0006\u0010_\u001a\u00020\rH\u0016J\u0018\u0010b\u001a\u00020(2\u0006\u0010_\u001a\u00020\r2\u0006\u0010c\u001a\u00020\u000fH\u0016J\u0015\u0010d\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0000¢\u0006\u0002\bfJ\u0010\u0010g\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010h\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0015\u0010i\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0000¢\u0006\u0002\bjJ\u0018\u0010k\u001a\u00020\r2\u0006\u0010e\u001a\u00020\r2\u0006\u0010l\u001a\u00020\u000fH\u0016J\u0010\u0010m\u001a\u00020\r2\u0006\u0010_\u001a\u00020\rH\u0016J\u0010\u0010n\u001a\u00020\r2\u0006\u0010o\u001a\u00020(H\u0016J\u0010\u0010p\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010q\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010r\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010s\u001a\u00020\r2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010t\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010u\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u001a\u0010v\u001a\u00020\r2\u0006\u0010w\u001a\u00020xH\u0016ø\u0001\u0000¢\u0006\u0004\by\u0010zJ\u0010\u0010{\u001a\u00020^2\u0006\u0010_\u001a\u00020\rH\u0016J\u0018\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\r2\u0006\u0010\u001a\u00020\rH\u0016J2\u0010\u0001\u001a\u00020W2\u0007\u0010\u0001\u001a\u00020<2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J \u0010\u0001\u001a\u00020W2\u0006\u0010_\u001a\u00020\rH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\rH\u0016J\u0013\u0010\u0001\u001a\u00020U2\b\u0010\u0001\u001a\u00030\u0001H\u0002J`\u0010\u0001\u001a\u00020U2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020(2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JA\u0010\u0001\u001a\u00020U2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JW\u0010\u0001\u001a\u00020U2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010¡\u0001J\u001d\u0010¢\u0001\u001a\f\u0012\u0005\u0012\u00030¤\u0001\u0018\u00010£\u0001*\u000200H\u0002¢\u0006\u0003\u0010¥\u0001J\u001c\u0010¦\u0001\u001a\u00020\u000f*\u00030§\u00012\f\u0010¨\u0001\u001a\u0007\u0012\u0002\b\u00030©\u0001H\u0002R\u001c\u0010\u001a\u001a\u00020\u001b8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010*R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0014\u00107\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010*R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@8@X\u0004¢\u0006\f\u0012\u0004\bA\u0010\u001d\u001a\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020E8@X\u0004¢\u0006\f\u0012\u0004\bF\u0010\u001d\u001a\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010*\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006ª\u0001"}, d2 = {"Landroidx/compose/ui/text/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "ellipsis", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IZJLandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IZJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "charSequence", "", "getCharSequence$ui_text_release$annotations", "()V", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getConstraints-msEJaDk", "()J", "J", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getEllipsis", "firstBaseline", "", "getFirstBaseline", "()F", "height", "getHeight", "lastBaseline", "getLastBaseline", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "textLocale", "Ljava/util/Locale;", "getTextLocale$ui_text_release$annotations", "getTextLocale$ui_text_release", "()Ljava/util/Locale;", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release$annotations", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "width", "getWidth", "constructTextLayout", "alignment", "justificationMode", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "hyphens", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "fillBoundingBoxes", "", "range", "Landroidx/compose/ui/text/TextRange;", "array", "", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineAscent", "lineIndex", "getLineAscent$ui_text_release", "getLineBaseline", "getLineBottom", "getLineDescent", "getLineDescent$ui_text_release", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getRangeForRect", "rect", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getWordBoundary", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "getShaderBrushSpans", "", "Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "hasSpan", "Landroid/text/Spanned;", "clazz", "Ljava/lang/Class;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidParagraph.android.kt */
public final class AndroidParagraph implements Paragraph {
    public static final int $stable = 8;
    private final CharSequence charSequence;
    private final long constraints;
    private final boolean ellipsis;
    private final TextLayout layout;
    private final int maxLines;
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    private final List<Rect> placeholderRects;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidParagraph.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.compose.ui.text.style.ResolvedTextDirection[] r0 = androidx.compose.ui.text.style.ResolvedTextDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.text.style.ResolvedTextDirection r1 = androidx.compose.ui.text.style.ResolvedTextDirection.Ltr     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.text.style.ResolvedTextDirection r1 = androidx.compose.ui.text.style.ResolvedTextDirection.Rtl     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AndroidParagraph.WhenMappings.<clinit>():void");
        }
    }

    public /* synthetic */ AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i, boolean z, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidParagraphIntrinsics, i, z, j);
    }

    public /* synthetic */ AndroidParagraph(String str, TextStyle textStyle, List list, List list2, int i, boolean z, long j, FontFamily.Resolver resolver, Density density, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, list, list2, i, z, j, resolver, density);
    }

    public static /* synthetic */ void getCharSequence$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextLocale$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextPaint$ui_text_release$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.util.List<androidx.compose.ui.geometry.Rect>} */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01d2, code lost:
        r4 = r4 + r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01fc, code lost:
        r4 = r4 - ((float) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01fe, code lost:
        r10 = new androidx.compose.ui.geometry.Rect(r8, r4, r9, ((float) r7.getHeightPx()) + r4);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AndroidParagraph(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r17, int r18, boolean r19, long r20) {
        /*
            r16 = this;
            r0 = r16
            r4 = r18
            r9 = r19
            r0.<init>()
            r1 = r17
            r0.paragraphIntrinsics = r1
            r0.maxLines = r4
            r0.ellipsis = r9
            r10 = r20
            r0.constraints = r10
            int r2 = androidx.compose.ui.unit.Constraints.m7053getMinHeightimpl(r10)
            if (r2 != 0) goto L_0x0225
            int r2 = androidx.compose.ui.unit.Constraints.m7054getMinWidthimpl(r10)
            if (r2 != 0) goto L_0x0225
            r12 = 1
            if (r4 < r12) goto L_0x0219
            androidx.compose.ui.text.TextStyle r13 = r1.getStyle()
            boolean r2 = androidx.compose.ui.text.AndroidParagraph_androidKt.shouldAttachIndentationFixSpan(r13, r9)
            if (r2 == 0) goto L_0x0037
            java.lang.CharSequence r1 = r1.getCharSequence$ui_text_release()
            java.lang.CharSequence r1 = androidx.compose.ui.text.AndroidParagraph_androidKt.attachIndentationFixSpan(r1)
            goto L_0x003b
        L_0x0037:
            java.lang.CharSequence r1 = r1.getCharSequence$ui_text_release()
        L_0x003b:
            r0.charSequence = r1
            int r1 = r13.m6605getTextAligne0LSkKk()
            int r1 = androidx.compose.ui.text.AndroidParagraph_androidKt.m6402toLayoutAlignaXe7zB0(r1)
            int r2 = r13.m6605getTextAligne0LSkKk()
            androidx.compose.ui.text.style.TextAlign$Companion r3 = androidx.compose.ui.text.style.TextAlign.Companion
            int r3 = r3.m6988getJustifye0LSkKk()
            boolean r2 = androidx.compose.ui.text.style.TextAlign.m6982equalsimpl0(r2, r3)
            androidx.compose.ui.text.ParagraphStyle r3 = r13.getParagraphStyle$ui_text_release()
            int r3 = r3.m6465getHyphensvmbZdU8()
            int r5 = androidx.compose.ui.text.AndroidParagraph_androidKt.m6404toLayoutHyphenationFrequency3fSNIE(r3)
            int r3 = r13.m6602getLineBreakrAG3T2k()
            int r3 = androidx.compose.ui.text.style.LineBreak.m6906getStrategyfcGXIks(r3)
            int r6 = androidx.compose.ui.text.AndroidParagraph_androidKt.m6403toLayoutBreakStrategyxImikfE(r3)
            int r3 = r13.m6602getLineBreakrAG3T2k()
            int r3 = androidx.compose.ui.text.style.LineBreak.m6907getStrictnessusljTpc(r3)
            int r7 = androidx.compose.ui.text.AndroidParagraph_androidKt.m6405toLayoutLineBreakStylehpcqdu8(r3)
            int r3 = r13.m6602getLineBreakrAG3T2k()
            int r3 = androidx.compose.ui.text.style.LineBreak.m6908getWordBreakjp8hJ3c(r3)
            int r8 = androidx.compose.ui.text.AndroidParagraph_androidKt.m6406toLayoutLineBreakWordStylewPN0Rpw(r3)
            r14 = 0
            if (r9 == 0) goto L_0x0089
            android.text.TextUtils$TruncateAt r3 = android.text.TextUtils.TruncateAt.END
            goto L_0x008a
        L_0x0089:
            r3 = r14
        L_0x008a:
            androidx.compose.ui.text.android.TextLayout r15 = r0.constructTextLayout(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r9 == 0) goto L_0x00b8
            int r0 = r15.getHeight()
            int r9 = androidx.compose.ui.unit.Constraints.m7051getMaxHeightimpl(r10)
            if (r0 <= r9) goto L_0x00b8
            if (r4 <= r12) goto L_0x00b8
            int r0 = androidx.compose.ui.unit.Constraints.m7051getMaxHeightimpl(r10)
            int r0 = androidx.compose.ui.text.AndroidParagraph_androidKt.numberOfLinesThatFitMaxHeight(r15, r0)
            if (r0 < 0) goto L_0x00b3
            if (r0 == r4) goto L_0x00b3
            int r4 = kotlin.ranges.RangesKt.coerceAtLeast((int) r0, (int) r12)
            r0 = r16
            androidx.compose.ui.text.android.TextLayout r15 = r0.constructTextLayout(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x00b5
        L_0x00b3:
            r0 = r16
        L_0x00b5:
            r0.layout = r15
            goto L_0x00bc
        L_0x00b8:
            r0 = r16
            r0.layout = r15
        L_0x00bc:
            androidx.compose.ui.text.platform.AndroidTextPaint r1 = r0.getTextPaint$ui_text_release()
            androidx.compose.ui.graphics.Brush r2 = r13.getBrush()
            float r3 = r0.getWidth()
            float r4 = r0.getHeight()
            long r3 = androidx.compose.ui.geometry.SizeKt.Size(r3, r4)
            float r5 = r13.getAlpha()
            r1.m6846setBrush12SF9DM(r2, r3, r5)
            androidx.compose.ui.text.android.TextLayout r1 = r0.layout
            androidx.compose.ui.text.platform.style.ShaderBrushSpan[] r1 = r0.getShaderBrushSpans(r1)
            if (r1 == 0) goto L_0x00ff
            java.util.Iterator r1 = kotlin.jvm.internal.ArrayIteratorKt.iterator(r1)
        L_0x00e3:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00ff
            java.lang.Object r2 = r1.next()
            androidx.compose.ui.text.platform.style.ShaderBrushSpan r2 = (androidx.compose.ui.text.platform.style.ShaderBrushSpan) r2
            float r3 = r0.getWidth()
            float r4 = r0.getHeight()
            long r3 = androidx.compose.ui.geometry.SizeKt.Size(r3, r4)
            r2.m6868setSizeuvyYCjk(r3)
            goto L_0x00e3
        L_0x00ff:
            java.lang.CharSequence r1 = r0.charSequence
            boolean r2 = r1 instanceof android.text.Spanned
            if (r2 != 0) goto L_0x010b
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0216
        L_0x010b:
            r2 = r1
            android.text.Spanned r2 = (android.text.Spanned) r2
            int r1 = r1.length()
            java.lang.Class<androidx.compose.ui.text.android.style.PlaceholderSpan> r3 = androidx.compose.ui.text.android.style.PlaceholderSpan.class
            r4 = 0
            java.lang.Object[] r1 = r2.getSpans(r4, r1, r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            int r5 = r1.length
            r3.<init>(r5)
            java.util.Collection r3 = (java.util.Collection) r3
            int r5 = r1.length
            r6 = r4
        L_0x0123:
            if (r6 >= r5) goto L_0x0213
            r7 = r1[r6]
            androidx.compose.ui.text.android.style.PlaceholderSpan r7 = (androidx.compose.ui.text.android.style.PlaceholderSpan) r7
            int r8 = r2.getSpanStart(r7)
            int r9 = r2.getSpanEnd(r7)
            androidx.compose.ui.text.android.TextLayout r10 = r0.layout
            int r10 = r10.getLineForOffset(r8)
            int r11 = r0.maxLines
            if (r10 < r11) goto L_0x013d
            r11 = r12
            goto L_0x013e
        L_0x013d:
            r11 = r4
        L_0x013e:
            androidx.compose.ui.text.android.TextLayout r13 = r0.layout
            int r13 = r13.getLineEllipsisCount(r10)
            if (r13 <= 0) goto L_0x0150
            androidx.compose.ui.text.android.TextLayout r13 = r0.layout
            int r13 = r13.getLineEllipsisOffset(r10)
            if (r9 <= r13) goto L_0x0150
            r13 = r12
            goto L_0x0151
        L_0x0150:
            r13 = r4
        L_0x0151:
            androidx.compose.ui.text.android.TextLayout r15 = r0.layout
            int r15 = r15.getLineEnd(r10)
            if (r9 <= r15) goto L_0x015b
            r9 = r12
            goto L_0x015c
        L_0x015b:
            r9 = r4
        L_0x015c:
            if (r13 != 0) goto L_0x020a
            if (r9 != 0) goto L_0x020a
            if (r11 == 0) goto L_0x0164
            goto L_0x020a
        L_0x0164:
            androidx.compose.ui.text.style.ResolvedTextDirection r9 = r0.getBidiRunDirection(r8)
            int[] r11 = androidx.compose.ui.text.AndroidParagraph.WhenMappings.$EnumSwitchMapping$0
            int r9 = r9.ordinal()
            r9 = r11[r9]
            r11 = 2
            if (r9 == r12) goto L_0x0186
            if (r9 != r11) goto L_0x0180
            float r8 = r0.getHorizontalPosition(r8, r12)
            int r9 = r7.getWidthPx()
            float r9 = (float) r9
            float r8 = r8 - r9
            goto L_0x018a
        L_0x0180:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0186:
            float r8 = r0.getHorizontalPosition(r8, r12)
        L_0x018a:
            int r9 = r7.getWidthPx()
            float r9 = (float) r9
            float r9 = r9 + r8
            androidx.compose.ui.text.android.TextLayout r13 = r0.layout
            int r15 = r7.getVerticalAlign()
            switch(r15) {
                case 0: goto L_0x01f4;
                case 1: goto L_0x01ef;
                case 2: goto L_0x01e6;
                case 3: goto L_0x01d4;
                case 4: goto L_0x01c7;
                case 5: goto L_0x01b6;
                case 6: goto L_0x01a1;
                default: goto L_0x0199;
            }
        L_0x0199:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected verticalAlignment"
            r1.<init>(r2)
            throw r1
        L_0x01a1:
            android.graphics.Paint$FontMetricsInt r15 = r7.getFontMetrics()
            int r4 = r15.ascent
            int r15 = r15.descent
            int r4 = r4 + r15
            int r15 = r7.getHeightPx()
            int r4 = r4 - r15
            int r4 = r4 / r11
            float r4 = (float) r4
            float r10 = r13.getLineBaseline(r10)
            goto L_0x01d2
        L_0x01b6:
            android.graphics.Paint$FontMetricsInt r4 = r7.getFontMetrics()
            int r4 = r4.descent
            float r4 = (float) r4
            float r10 = r13.getLineBaseline(r10)
            float r4 = r4 + r10
            int r10 = r7.getHeightPx()
            goto L_0x01fc
        L_0x01c7:
            android.graphics.Paint$FontMetricsInt r4 = r7.getFontMetrics()
            int r4 = r4.ascent
            float r4 = (float) r4
            float r10 = r13.getLineBaseline(r10)
        L_0x01d2:
            float r4 = r4 + r10
            goto L_0x01fe
        L_0x01d4:
            float r4 = r13.getLineTop(r10)
            float r10 = r13.getLineBottom(r10)
            float r4 = r4 + r10
            int r10 = r7.getHeightPx()
            float r10 = (float) r10
            float r4 = r4 - r10
            float r10 = (float) r11
            float r4 = r4 / r10
            goto L_0x01fe
        L_0x01e6:
            float r4 = r13.getLineBottom(r10)
            int r10 = r7.getHeightPx()
            goto L_0x01fc
        L_0x01ef:
            float r4 = r13.getLineTop(r10)
            goto L_0x01fe
        L_0x01f4:
            float r4 = r13.getLineBaseline(r10)
            int r10 = r7.getHeightPx()
        L_0x01fc:
            float r10 = (float) r10
            float r4 = r4 - r10
        L_0x01fe:
            int r7 = r7.getHeightPx()
            float r7 = (float) r7
            float r7 = r7 + r4
            androidx.compose.ui.geometry.Rect r10 = new androidx.compose.ui.geometry.Rect
            r10.<init>(r8, r4, r9, r7)
            goto L_0x020b
        L_0x020a:
            r10 = r14
        L_0x020b:
            r3.add(r10)
            int r6 = r6 + 1
            r4 = 0
            goto L_0x0123
        L_0x0213:
            r1 = r3
            java.util.List r1 = (java.util.List) r1
        L_0x0216:
            r0.placeholderRects = r1
            return
        L_0x0219:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "maxLines should be greater than 0"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0225:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AndroidParagraph.<init>(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics, int, boolean, long):void");
    }

    public final AndroidParagraphIntrinsics getParagraphIntrinsics() {
        return this.paragraphIntrinsics;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final boolean getEllipsis() {
        return this.ellipsis;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m6389getConstraintsmsEJaDk() {
        return this.constraints;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AndroidParagraph(java.lang.String r8, androidx.compose.ui.text.TextStyle r9, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> r10, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> r11, int r12, boolean r13, long r14, androidx.compose.ui.text.font.FontFamily.Resolver r16, androidx.compose.ui.unit.Density r17) {
        /*
            r7 = this;
            androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r0 = new androidx.compose.ui.text.platform.AndroidParagraphIntrinsics
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r16
            r6 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r6 = 0
            r2 = r12
            r3 = r13
            r4 = r14
            r1 = r0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AndroidParagraph.<init>(java.lang.String, androidx.compose.ui.text.TextStyle, java.util.List, java.util.List, int, boolean, long, androidx.compose.ui.text.font.FontFamily$Resolver, androidx.compose.ui.unit.Density):void");
    }

    public final CharSequence getCharSequence$ui_text_release() {
        return this.charSequence;
    }

    public float getWidth() {
        return (float) Constraints.m7052getMaxWidthimpl(this.constraints);
    }

    public float getHeight() {
        return (float) this.layout.getHeight();
    }

    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    public float getFirstBaseline() {
        return getLineBaseline(0);
    }

    public float getLastBaseline() {
        return getLineBaseline(getLineCount() - 1);
    }

    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    public final Locale getTextLocale$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release().getTextLocale();
    }

    public int getLineCount() {
        return this.layout.getLineCount();
    }

    public List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release();
    }

    public int getLineForVerticalPosition(float f) {
        return this.layout.getLineForVertical((int) f);
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M  reason: not valid java name */
    public int m6390getOffsetForPositionk4lQ0M(long j) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical((int) Offset.m3988getYimpl(j)), Offset.m3987getXimpl(j));
    }

    /* renamed from: getRangeForRect-8-6BmAI  reason: not valid java name */
    public long m6391getRangeForRect86BmAI(Rect rect, int i, TextInclusionStrategy textInclusionStrategy) {
        int[] rangeForRect = this.layout.getRangeForRect(RectHelper_androidKt.toAndroidRectF(rect), AndroidParagraph_androidKt.m6407toLayoutTextGranularityduNsdkg(i), new AndroidParagraph$getRangeForRect$range$1(textInclusionStrategy));
        if (rangeForRect == null) {
            return TextRange.Companion.m6569getZerod9O1mEE();
        }
        return TextRangeKt.TextRange(rangeForRect[0], rangeForRect[1]);
    }

    public Rect getBoundingBox(int i) {
        if (i < 0 || i >= this.charSequence.length()) {
            throw new IllegalArgumentException(("offset(" + i + ") is out of bounds [0," + this.charSequence.length() + ')').toString());
        }
        RectF boundingBox = this.layout.getBoundingBox(i);
        return new Rect(boundingBox.left, boundingBox.top, boundingBox.right, boundingBox.bottom);
    }

    /* renamed from: fillBoundingBoxes-8ffj60Q  reason: not valid java name */
    public void m6388fillBoundingBoxes8ffj60Q(long j, float[] fArr, int i) {
        this.layout.fillBoundingBoxes(TextRange.m6562getMinimpl(j), TextRange.m6561getMaximpl(j), fArr, i);
    }

    public Path getPathForRange(int i, int i2) {
        if (i < 0 || i > i2 || i2 > this.charSequence.length()) {
            throw new IllegalArgumentException(("start(" + i + ") or end(" + i2 + ") is out of range [0.." + this.charSequence.length() + "], or start > end!").toString());
        }
        android.graphics.Path path = new android.graphics.Path();
        this.layout.getSelectionPath(i, i2, path);
        return AndroidPath_androidKt.asComposePath(path);
    }

    public Rect getCursorRect(int i) {
        if (i < 0 || i > this.charSequence.length()) {
            throw new IllegalArgumentException(("offset(" + i + ") is out of bounds [0," + this.charSequence.length() + ']').toString());
        }
        float primaryHorizontal$default = TextLayout.getPrimaryHorizontal$default(this.layout, i, false, 2, (Object) null);
        int lineForOffset = this.layout.getLineForOffset(i);
        return new Rect(primaryHorizontal$default, this.layout.getLineTop(lineForOffset), primaryHorizontal$default, this.layout.getLineBottom(lineForOffset));
    }

    /* renamed from: getWordBoundary--jx7JFs  reason: not valid java name */
    public long m6392getWordBoundaryjx7JFs(int i) {
        WordIterator wordIterator = this.layout.getWordIterator();
        return TextRangeKt.TextRange(WordBoundary_androidKt.getWordStart(wordIterator, i), WordBoundary_androidKt.getWordEnd(wordIterator, i));
    }

    public float getLineLeft(int i) {
        return this.layout.getLineLeft(i);
    }

    public float getLineRight(int i) {
        return this.layout.getLineRight(i);
    }

    public float getLineTop(int i) {
        return this.layout.getLineTop(i);
    }

    public final float getLineAscent$ui_text_release(int i) {
        return this.layout.getLineAscent(i);
    }

    public float getLineBaseline(int i) {
        return this.layout.getLineBaseline(i);
    }

    public final float getLineDescent$ui_text_release(int i) {
        return this.layout.getLineDescent(i);
    }

    public float getLineBottom(int i) {
        return this.layout.getLineBottom(i);
    }

    public float getLineHeight(int i) {
        return this.layout.getLineHeight(i);
    }

    public float getLineWidth(int i) {
        return this.layout.getLineWidth(i);
    }

    public int getLineStart(int i) {
        return this.layout.getLineStart(i);
    }

    public int getLineEnd(int i, boolean z) {
        if (z) {
            return this.layout.getLineVisibleEnd(i);
        }
        return this.layout.getLineEnd(i);
    }

    public boolean isLineEllipsized(int i) {
        return this.layout.isLineEllipsized(i);
    }

    public int getLineForOffset(int i) {
        return this.layout.getLineForOffset(i);
    }

    public float getHorizontalPosition(int i, boolean z) {
        if (z) {
            return TextLayout.getPrimaryHorizontal$default(this.layout, i, false, 2, (Object) null);
        }
        return TextLayout.getSecondaryHorizontal$default(this.layout, i, false, 2, (Object) null);
    }

    public ResolvedTextDirection getParagraphDirection(int i) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(i)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    public ResolvedTextDirection getBidiRunDirection(int i) {
        if (this.layout.isRtlCharAt(i)) {
            return ResolvedTextDirection.Rtl;
        }
        return ResolvedTextDirection.Ltr;
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout textLayout) {
        if (!(textLayout.getText() instanceof Spanned)) {
            return null;
        }
        CharSequence text = textLayout.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
        if (!hasSpan((Spanned) text, ShaderBrushSpan.class)) {
            return null;
        }
        CharSequence text2 = textLayout.getText();
        Intrinsics.checkNotNull(text2, "null cannot be cast to non-null type android.text.Spanned");
        return (ShaderBrushSpan[]) ((Spanned) text2).getSpans(0, textLayout.getText().length(), ShaderBrushSpan.class);
    }

    private final boolean hasSpan(Spanned spanned, Class<?> cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    /* renamed from: paint-RPmYEkk  reason: not valid java name */
    public void m6394paintRPmYEkk(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration) {
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m6848setColor8_81llA(j);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        paint(canvas);
    }

    /* renamed from: paint-LG529CI  reason: not valid java name */
    public void m6393paintLG529CI(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        int r0 = getTextPaint$ui_text_release().m6843getBlendMode0nO6VwU();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m6848setColor8_81llA(j);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        textPaint$ui_text_release.m6845setBlendModes9anfk8(i);
        paint(canvas);
        getTextPaint$ui_text_release().m6845setBlendModes9anfk8(r0);
    }

    /* renamed from: paint-hn5TExg  reason: not valid java name */
    public void m6395painthn5TExg(Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        int r0 = getTextPaint$ui_text_release().m6843getBlendMode0nO6VwU();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m6846setBrush12SF9DM(brush, SizeKt.Size(getWidth(), getHeight()), f);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        textPaint$ui_text_release.m6845setBlendModes9anfk8(i);
        paint(canvas);
        getTextPaint$ui_text_release().m6845setBlendModes9anfk8(r0);
    }

    private final void paint(Canvas canvas) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    private final TextLayout constructTextLayout(int i, int i2, TextUtils.TruncateAt truncateAt, int i3, int i4, int i5, int i6, int i7) {
        CharSequence charSequence2 = this.charSequence;
        float width = getWidth();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        int textDirectionHeuristic$ui_text_release = this.paragraphIntrinsics.getTextDirectionHeuristic$ui_text_release();
        LayoutIntrinsics layoutIntrinsics$ui_text_release = this.paragraphIntrinsics.getLayoutIntrinsics$ui_text_release();
        return new TextLayout(charSequence2, width, textPaint$ui_text_release, i, truncateAt, textDirectionHeuristic$ui_text_release, 1.0f, 0.0f, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(this.paragraphIntrinsics.getStyle()), true, i3, i5, i6, i7, i4, i2, (int[]) null, (int[]) null, layoutIntrinsics$ui_text_release, 196736, (DefaultConstructorMarker) null);
    }
}
