package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.IndentationFixSpan_androidKt;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BÃ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ&\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\tJ\u001d\u0010]\u001a\u00020W2\u0006\u0010^\u001a\u00020\t2\u0006\u0010Z\u001a\u00020[H\u0000¢\u0006\u0002\b_J\u000e\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\tJ\u0010\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tH\u0002J\u000e\u0010e\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010f\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010g\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010h\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010i\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010j\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010k\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010l\u001a\u00020\t2\u0006\u0010b\u001a\u00020\tJ\u000e\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\tJ\u000e\u0010o\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u000e\u0010p\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u000e\u0010q\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u000e\u0010r\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010s\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010t\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010u\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u0016\u0010v\u001a\u00020\t2\u0006\u0010d\u001a\u00020\t2\u0006\u0010w\u001a\u00020\u0005J\u000e\u0010x\u001a\u00020\t2\u0006\u0010d\u001a\u00020\tJ\u0018\u0010y\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\t2\b\b\u0002\u0010z\u001a\u00020\u0010J2\u0010{\u001a\u0004\u0018\u00010\u00192\u0006\u0010H\u001a\u00020a2\u0006\u0010|\u001a\u00020\t2\u0018\u0010}\u001a\u0014\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020\u00100~J\u0018\u0010\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\t2\b\b\u0002\u0010z\u001a\u00020\u0010J#\u0010\u0001\u001a\u00020W2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u0001J\u000f\u0010\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\tJ\u000f\u0010\u0001\u001a\u00020\u00102\u0006\u0010b\u001a\u00020\tJ\u0011\u0010\u0001\u001a\u00020W2\b\u0010\u0001\u001a\u00030\u0001R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u00020\t8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b,\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u000e\u0010.\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0004¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0002038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010$\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010=\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u0018\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@X\u0004¢\u0006\u0004\n\u0002\u0010BR\u0011\u0010C\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bG\u0010ER\u000e\u0010H\u001a\u00020IX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010K\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001c\u0010P\u001a\u00020\t8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u0010$\u001a\u0004\bR\u0010&R\u0011\u0010S\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/android/TextLayout;", "", "charSequence", "", "width", "", "textPaint", "Landroid/text/TextPaint;", "alignment", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "textDirectionHeuristic", "lineSpacingMultiplier", "lineSpacingExtra", "includePadding", "", "fallbackLineSpacing", "maxLines", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "justificationMode", "leftIndents", "", "rightIndents", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "(Ljava/lang/CharSequence;FLandroid/text/TextPaint;ILandroid/text/TextUtils$TruncateAt;IFFZZIIIIII[I[ILandroidx/compose/ui/text/android/LayoutIntrinsics;)V", "backingLayoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "backingWordIterator", "Landroidx/compose/ui/text/android/selection/WordIterator;", "bottomPadding", "getBottomPadding$ui_text_release$annotations", "()V", "getBottomPadding$ui_text_release", "()I", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getFallbackLineSpacing", "height", "getHeight", "getIncludePadding", "isBoringLayout", "lastLineExtra", "lastLineFontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "layout", "Landroid/text/Layout;", "getLayout$annotations", "getLayout", "()Landroid/text/Layout;", "layoutHelper", "getLayoutHelper", "()Landroidx/compose/ui/text/android/LayoutHelper;", "getLayoutIntrinsics", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "leftPadding", "lineCount", "getLineCount", "lineHeightSpans", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "rect", "Landroid/graphics/Rect;", "rightPadding", "text", "getText", "()Ljava/lang/CharSequence;", "getTextPaint", "()Landroid/text/TextPaint;", "topPadding", "getTopPadding$ui_text_release$annotations", "getTopPadding$ui_text_release", "wordIterator", "getWordIterator", "()Landroidx/compose/ui/text/android/selection/WordIterator;", "fillBoundingBoxes", "", "startOffset", "endOffset", "array", "", "arrayStart", "fillLineHorizontalBounds", "lineIndex", "fillLineHorizontalBounds$ui_text_release", "getBoundingBox", "Landroid/graphics/RectF;", "offset", "getHorizontalPadding", "line", "getLineAscent", "getLineBaseline", "getLineBottom", "getLineDescent", "getLineEllipsisCount", "getLineEllipsisOffset", "getLineEnd", "getLineForOffset", "getLineForVertical", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineVisibleEnd", "getLineWidth", "getOffsetForHorizontal", "horizontal", "getParagraphDirection", "getPrimaryHorizontal", "upstream", "getRangeForRect", "granularity", "inclusionStrategy", "Lkotlin/Function2;", "getSecondaryHorizontal", "getSelectionPath", "start", "end", "dest", "Landroid/graphics/Path;", "isFallbackLinespacingApplied", "isFallbackLinespacingApplied$ui_text_release", "isLineEllipsized", "isRtlCharAt", "paint", "canvas", "Landroid/graphics/Canvas;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayout.android.kt */
public final class TextLayout {
    public static final int $stable = 8;
    private LayoutHelper backingLayoutHelper;
    private WordIterator backingWordIterator;
    private final int bottomPadding;
    private final boolean didExceedMaxLines;
    private final boolean fallbackLineSpacing;
    private final boolean includePadding;
    private final boolean isBoringLayout;
    private final int lastLineExtra;
    private final Paint.FontMetricsInt lastLineFontMetrics;
    private final Layout layout;
    private final LayoutIntrinsics layoutIntrinsics;
    private final float leftPadding;
    private final int lineCount;
    private final LineHeightStyleSpan[] lineHeightSpans;
    private final Rect rect;
    private final float rightPadding;
    private final TextPaint textPaint;
    private final int topPadding;

    public static /* synthetic */ void getBottomPadding$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getLayout$annotations() {
    }

    public static /* synthetic */ void getTopPadding$ui_text_release$annotations() {
    }

    /* JADX INFO: finally extract failed */
    public TextLayout(CharSequence charSequence, float f, TextPaint textPaint2, int i, TextUtils.TruncateAt truncateAt, int i2, float f2, float f3, boolean z, boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, int[] iArr, int[] iArr2, LayoutIntrinsics layoutIntrinsics2) {
        boolean z3;
        int i9;
        TextDirectionHeuristic textDirectionHeuristic;
        TextPaint textPaint3;
        Layout layout2;
        boolean z4;
        boolean z5;
        CharSequence charSequence2 = charSequence;
        float f4 = f;
        TextPaint textPaint4 = textPaint2;
        this.textPaint = textPaint4;
        boolean z6 = z;
        this.includePadding = z6;
        boolean z7 = z2;
        this.fallbackLineSpacing = z7;
        LayoutIntrinsics layoutIntrinsics3 = layoutIntrinsics2;
        this.layoutIntrinsics = layoutIntrinsics3;
        this.rect = new Rect();
        int length = charSequence2.length();
        TextDirectionHeuristic textDirectionHeuristic2 = TextLayout_androidKt.getTextDirectionHeuristic(i2);
        Layout.Alignment alignment = TextAlignmentAdapter.INSTANCE.get(i);
        boolean z8 = (charSequence2 instanceof Spanned) && ((Spanned) charSequence2).nextSpanTransition(-1, length, BaselineShiftSpan.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics boringMetrics = layoutIntrinsics3.getBoringMetrics();
            double d = (double) f4;
            int ceil = (int) ((float) Math.ceil(d));
            if (boringMetrics == null || layoutIntrinsics3.getMaxIntrinsicWidth() > f4 || z8) {
                this.isBoringLayout = false;
                textPaint3 = textPaint2;
                i9 = i3;
                z3 = false;
                textDirectionHeuristic = textDirectionHeuristic2;
                z4 = true;
                layout2 = StaticLayoutFactory.INSTANCE.create(charSequence, textPaint3, ceil, 0, charSequence.length(), textDirectionHeuristic, alignment, i9, truncateAt, (int) ((float) Math.ceil(d)), f2, f3, i8, z, z2, i4, i5, i6, i7, iArr, iArr2);
            } else {
                this.isBoringLayout = true;
                textPaint3 = textPaint2;
                i9 = i3;
                layout2 = BoringLayoutFactory.INSTANCE.create(charSequence2, textPaint4, ceil, boringMetrics, alignment, z6, z7, truncateAt, ceil);
                textDirectionHeuristic = textDirectionHeuristic2;
                z4 = true;
                z3 = false;
            }
            this.layout = layout2;
            Trace.endSection();
            int min = Math.min(layout2.getLineCount(), i9);
            this.lineCount = min;
            int i10 = min - 1;
            if (min >= i9 && (layout2.getEllipsisCount(i10) > 0 || layout2.getLineEnd(i10) != charSequence.length())) {
                z5 = z4;
            } else {
                z5 = z3;
            }
            this.didExceedMaxLines = z5;
            long access$getVerticalPaddings = TextLayout_androidKt.getVerticalPaddings(this);
            LineHeightStyleSpan[] access$getLineHeightSpans = TextLayout_androidKt.getLineHeightSpans(this);
            this.lineHeightSpans = access$getLineHeightSpans;
            long access$getLineHeightPaddings = access$getLineHeightSpans != null ? TextLayout_androidKt.getLineHeightPaddings(access$getLineHeightSpans) : TextLayout_androidKt.ZeroVerticalPadding;
            this.topPadding = Math.max(VerticalPaddings.m6617getTopPaddingimpl(access$getVerticalPaddings), VerticalPaddings.m6617getTopPaddingimpl(access$getLineHeightPaddings));
            this.bottomPadding = Math.max(VerticalPaddings.m6616getBottomPaddingimpl(access$getVerticalPaddings), VerticalPaddings.m6616getBottomPaddingimpl(access$getLineHeightPaddings));
            Paint.FontMetricsInt access$getLastLineMetrics = TextLayout_androidKt.getLastLineMetrics(this, textPaint3, textDirectionHeuristic, access$getLineHeightSpans);
            this.lastLineExtra = access$getLastLineMetrics != null ? access$getLastLineMetrics.bottom - ((int) getLineHeight(i10)) : z3;
            this.lastLineFontMetrics = access$getLastLineMetrics;
            this.leftPadding = IndentationFixSpan_androidKt.getEllipsizedLeftPadding$default(layout2, i10, (Paint) null, 2, (Object) null);
            this.rightPadding = IndentationFixSpan_androidKt.getEllipsizedRightPadding$default(layout2, i10, (Paint) null, 2, (Object) null);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final TextPaint getTextPaint() {
        return this.textPaint;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final boolean getFallbackLineSpacing() {
        return this.fallbackLineSpacing;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextLayout(java.lang.CharSequence r24, float r25, android.text.TextPaint r26, int r27, android.text.TextUtils.TruncateAt r28, int r29, float r30, float r31, boolean r32, boolean r33, int r34, int r35, int r36, int r37, int r38, int r39, int[] r40, int[] r41, androidx.compose.ui.text.android.LayoutIntrinsics r42, int r43, kotlin.jvm.internal.DefaultConstructorMarker r44) {
        /*
            r23 = this;
            r0 = r43
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r7 = r2
            goto L_0x000b
        L_0x0009:
            r7 = r27
        L_0x000b:
            r1 = r0 & 16
            r3 = 0
            if (r1 == 0) goto L_0x0012
            r8 = r3
            goto L_0x0014
        L_0x0012:
            r8 = r28
        L_0x0014:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001b
            r1 = 2
            r9 = r1
            goto L_0x001d
        L_0x001b:
            r9 = r29
        L_0x001d:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0025
            r1 = 1065353216(0x3f800000, float:1.0)
            r10 = r1
            goto L_0x0027
        L_0x0025:
            r10 = r30
        L_0x0027:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002e
            r1 = 0
            r11 = r1
            goto L_0x0030
        L_0x002e:
            r11 = r31
        L_0x0030:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0036
            r12 = r2
            goto L_0x0038
        L_0x0036:
            r12 = r32
        L_0x0038:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x003f
            r1 = 1
            r13 = r1
            goto L_0x0041
        L_0x003f:
            r13 = r33
        L_0x0041:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004a
            r1 = 2147483647(0x7fffffff, float:NaN)
            r14 = r1
            goto L_0x004c
        L_0x004a:
            r14 = r34
        L_0x004c:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0052
            r15 = r2
            goto L_0x0054
        L_0x0052:
            r15 = r35
        L_0x0054:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x005b
            r16 = r2
            goto L_0x005d
        L_0x005b:
            r16 = r36
        L_0x005d:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0064
            r17 = r2
            goto L_0x0066
        L_0x0064:
            r17 = r37
        L_0x0066:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x006d
            r18 = r2
            goto L_0x006f
        L_0x006d:
            r18 = r38
        L_0x006f:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0078
            r19 = r2
            goto L_0x007a
        L_0x0078:
            r19 = r39
        L_0x007a:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0082
            r20 = r3
            goto L_0x0084
        L_0x0082:
            r20 = r40
        L_0x0084:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008c
            r21 = r3
            goto L_0x008e
        L_0x008c:
            r21 = r41
        L_0x008e:
            r1 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x009f
            androidx.compose.ui.text.android.LayoutIntrinsics r0 = new androidx.compose.ui.text.android.LayoutIntrinsics
            r4 = r24
            r6 = r26
            r0.<init>(r4, r6, r9)
            r22 = r0
            goto L_0x00a5
        L_0x009f:
            r4 = r24
            r6 = r26
            r22 = r42
        L_0x00a5:
            r3 = r23
            r5 = r25
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.TextLayout.<init>(java.lang.CharSequence, float, android.text.TextPaint, int, android.text.TextUtils$TruncateAt, int, float, float, boolean, boolean, int, int, int, int, int, int, int[], int[], androidx.compose.ui.text.android.LayoutIntrinsics, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final LayoutIntrinsics getLayoutIntrinsics() {
        return this.layoutIntrinsics;
    }

    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public final float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final WordIterator getWordIterator() {
        WordIterator wordIterator = this.backingWordIterator;
        if (wordIterator != null) {
            return wordIterator;
        }
        WordIterator wordIterator2 = new WordIterator(this.layout.getText(), 0, this.layout.getText().length(), this.textPaint.getTextLocale());
        this.backingWordIterator = wordIterator2;
        return wordIterator2;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final int getTopPadding$ui_text_release() {
        return this.topPadding;
    }

    public final int getBottomPadding$ui_text_release() {
        return this.bottomPadding;
    }

    private final LayoutHelper getLayoutHelper() {
        LayoutHelper layoutHelper = this.backingLayoutHelper;
        if (layoutHelper == null) {
            LayoutHelper layoutHelper2 = new LayoutHelper(this.layout);
            this.backingLayoutHelper = layoutHelper2;
            return layoutHelper2;
        }
        Intrinsics.checkNotNull(layoutHelper);
        return layoutHelper;
    }

    public final CharSequence getText() {
        return this.layout.getText();
    }

    public final int getHeight() {
        int i;
        if (this.didExceedMaxLines) {
            i = this.layout.getLineBottom(this.lineCount - 1);
        } else {
            i = this.layout.getHeight();
        }
        return i + this.topPadding + this.bottomPadding + this.lastLineExtra;
    }

    private final float getHorizontalPadding(int i) {
        if (i == this.lineCount - 1) {
            return this.leftPadding + this.rightPadding;
        }
        return 0.0f;
    }

    public final float getLineLeft(int i) {
        return this.layout.getLineLeft(i) + (i == this.lineCount + -1 ? this.leftPadding : 0.0f);
    }

    public final float getLineRight(int i) {
        return this.layout.getLineRight(i) + (i == this.lineCount + -1 ? this.rightPadding : 0.0f);
    }

    public final float getLineTop(int i) {
        int i2;
        float lineTop = (float) this.layout.getLineTop(i);
        if (i == 0) {
            i2 = 0;
        } else {
            i2 = this.topPadding;
        }
        return lineTop + ((float) i2);
    }

    public final float getLineBottom(int i) {
        if (i == this.lineCount - 1 && this.lastLineFontMetrics != null) {
            return ((float) this.layout.getLineBottom(i - 1)) + ((float) this.lastLineFontMetrics.bottom);
        }
        return ((float) this.topPadding) + ((float) this.layout.getLineBottom(i)) + ((float) (i == this.lineCount + -1 ? this.bottomPadding : 0));
    }

    public final float getLineAscent(int i) {
        int lineAscent;
        Paint.FontMetricsInt fontMetricsInt;
        if (i != this.lineCount - 1 || (fontMetricsInt = this.lastLineFontMetrics) == null) {
            lineAscent = this.layout.getLineAscent(i);
        } else {
            lineAscent = fontMetricsInt.ascent;
        }
        return (float) lineAscent;
    }

    public final float getLineBaseline(int i) {
        float f;
        float f2 = (float) this.topPadding;
        if (i != this.lineCount - 1 || this.lastLineFontMetrics == null) {
            f = (float) this.layout.getLineBaseline(i);
        } else {
            f = getLineTop(i) - ((float) this.lastLineFontMetrics.ascent);
        }
        return f2 + f;
    }

    public final float getLineDescent(int i) {
        int lineDescent;
        Paint.FontMetricsInt fontMetricsInt;
        if (i != this.lineCount - 1 || (fontMetricsInt = this.lastLineFontMetrics) == null) {
            lineDescent = this.layout.getLineDescent(i);
        } else {
            lineDescent = fontMetricsInt.descent;
        }
        return (float) lineDescent;
    }

    public final float getLineHeight(int i) {
        return getLineBottom(i) - getLineTop(i);
    }

    public final float getLineWidth(int i) {
        return this.layout.getLineWidth(i);
    }

    public final int getLineStart(int i) {
        return this.layout.getLineStart(i);
    }

    public final int getLineEnd(int i) {
        if (this.layout.getEllipsisStart(i) == 0) {
            return this.layout.getLineEnd(i);
        }
        return this.layout.getText().length();
    }

    public final int getLineVisibleEnd(int i) {
        if (this.layout.getEllipsisStart(i) == 0) {
            return getLayoutHelper().getLineVisibleEnd(i);
        }
        return this.layout.getLineStart(i) + this.layout.getEllipsisStart(i);
    }

    public final boolean isLineEllipsized(int i) {
        return TextLayout_androidKt.isLineEllipsized(this.layout, i);
    }

    public final int getLineEllipsisOffset(int i) {
        return this.layout.getEllipsisStart(i);
    }

    public final int getLineEllipsisCount(int i) {
        return this.layout.getEllipsisCount(i);
    }

    public final int getLineForVertical(int i) {
        return this.layout.getLineForVertical(i - this.topPadding);
    }

    public final int getOffsetForHorizontal(int i, float f) {
        return this.layout.getOffsetForHorizontal(i, f + (((float) -1) * getHorizontalPadding(i)));
    }

    public static /* synthetic */ float getPrimaryHorizontal$default(TextLayout textLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayout.getPrimaryHorizontal(i, z);
    }

    public final float getPrimaryHorizontal(int i, boolean z) {
        return getLayoutHelper().getHorizontalPosition(i, true, z) + getHorizontalPadding(getLineForOffset(i));
    }

    public static /* synthetic */ float getSecondaryHorizontal$default(TextLayout textLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayout.getSecondaryHorizontal(i, z);
    }

    public final float getSecondaryHorizontal(int i, boolean z) {
        return getLayoutHelper().getHorizontalPosition(i, false, z) + getHorizontalPadding(getLineForOffset(i));
    }

    public final int getLineForOffset(int i) {
        return this.layout.getLineForOffset(i);
    }

    public final boolean isRtlCharAt(int i) {
        return this.layout.isRtlCharAt(i);
    }

    public final int getParagraphDirection(int i) {
        return this.layout.getParagraphDirection(i);
    }

    public final void getSelectionPath(int i, int i2, Path path) {
        this.layout.getSelectionPath(i, i2, path);
        if (this.topPadding != 0 && !path.isEmpty()) {
            path.offset(0.0f, (float) this.topPadding);
        }
    }

    public final int[] getRangeForRect(RectF rectF, int i, Function2<? super RectF, ? super RectF, Boolean> function2) {
        if (Build.VERSION.SDK_INT >= 34) {
            return AndroidLayoutApi34.INSTANCE.getRangeForRect$ui_text_release(this, rectF, i, function2);
        }
        return TextLayoutGetRangeForRectExtensions_androidKt.getRangeForRect(this, this.layout, getLayoutHelper(), rectF, i, function2);
    }

    public final void fillLineHorizontalBounds$ui_text_release(int i, float[] fArr) {
        float f;
        float f2;
        int lineStart = getLineStart(i);
        int lineEnd = getLineEnd(i);
        if (fArr.length >= (lineEnd - lineStart) * 2) {
            HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
            int i2 = 0;
            boolean z = true;
            if (getParagraphDirection(i) != 1) {
                z = false;
            }
            while (lineStart < lineEnd) {
                boolean isRtlCharAt = isRtlCharAt(lineStart);
                if (z && !isRtlCharAt) {
                    f = horizontalPositionCache.getPrimaryDownstream(lineStart);
                    f2 = horizontalPositionCache.getPrimaryUpstream(lineStart + 1);
                } else if (z && isRtlCharAt) {
                    f2 = horizontalPositionCache.getSecondaryDownstream(lineStart);
                    f = horizontalPositionCache.getSecondaryUpstream(lineStart + 1);
                } else if (isRtlCharAt) {
                    f2 = horizontalPositionCache.getPrimaryDownstream(lineStart);
                    f = horizontalPositionCache.getPrimaryUpstream(lineStart + 1);
                } else {
                    f = horizontalPositionCache.getSecondaryDownstream(lineStart);
                    f2 = horizontalPositionCache.getSecondaryUpstream(lineStart + 1);
                }
                fArr[i2] = f;
                fArr[i2 + 1] = f2;
                i2 += 2;
                lineStart++;
            }
            return;
        }
        throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2".toString());
    }

    public final void fillBoundingBoxes(int i, int i2, float[] fArr, int i3) {
        float f;
        float f2;
        int length = getText().length();
        if (i < 0) {
            throw new IllegalArgumentException("startOffset must be > 0".toString());
        } else if (i >= length) {
            throw new IllegalArgumentException("startOffset must be less than text length".toString());
        } else if (i2 <= i) {
            throw new IllegalArgumentException("endOffset must be greater than startOffset".toString());
        } else if (i2 <= length) {
            if (fArr.length - i3 >= (i2 - i) * 4) {
                int lineForOffset = getLineForOffset(i);
                int lineForOffset2 = getLineForOffset(i2 - 1);
                HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
                if (lineForOffset <= lineForOffset2) {
                    while (true) {
                        int lineStart = getLineStart(lineForOffset);
                        int lineEnd = getLineEnd(lineForOffset);
                        int min = Math.min(i2, lineEnd);
                        float lineTop = getLineTop(lineForOffset);
                        float lineBottom = getLineBottom(lineForOffset);
                        boolean z = true;
                        if (getParagraphDirection(lineForOffset) != 1) {
                            z = false;
                        }
                        for (int max = Math.max(i, lineStart); max < min; max++) {
                            boolean isRtlCharAt = isRtlCharAt(max);
                            if (z && !isRtlCharAt) {
                                f2 = horizontalPositionCache.getPrimaryDownstream(max);
                                f = horizontalPositionCache.getPrimaryUpstream(max + 1);
                            } else if (z && isRtlCharAt) {
                                f = horizontalPositionCache.getSecondaryDownstream(max);
                                f2 = horizontalPositionCache.getSecondaryUpstream(max + 1);
                            } else if (z || !isRtlCharAt) {
                                f2 = horizontalPositionCache.getSecondaryDownstream(max);
                                f = horizontalPositionCache.getSecondaryUpstream(max + 1);
                            } else {
                                f = horizontalPositionCache.getPrimaryDownstream(max);
                                f2 = horizontalPositionCache.getPrimaryUpstream(max + 1);
                            }
                            fArr[i3] = f2;
                            fArr[i3 + 1] = lineTop;
                            fArr[i3 + 2] = f;
                            fArr[i3 + 3] = lineBottom;
                            i3 += 4;
                        }
                        if (lineForOffset != lineForOffset2) {
                            lineForOffset++;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4".toString());
            }
        } else {
            throw new IllegalArgumentException("endOffset must be smaller or equal to text length".toString());
        }
    }

    public final RectF getBoundingBox(int i) {
        float f;
        float f2;
        float f3;
        float f4;
        int lineForOffset = getLineForOffset(i);
        float lineTop = getLineTop(lineForOffset);
        float lineBottom = getLineBottom(lineForOffset);
        boolean z = getParagraphDirection(lineForOffset) == 1;
        boolean isRtlCharAt = this.layout.isRtlCharAt(i);
        if (!z || isRtlCharAt) {
            if (z && isRtlCharAt) {
                f4 = getSecondaryHorizontal(i, false);
                f3 = getSecondaryHorizontal(i + 1, true);
            } else if (isRtlCharAt) {
                f4 = getPrimaryHorizontal(i, false);
                f3 = getPrimaryHorizontal(i + 1, true);
            } else {
                f2 = getSecondaryHorizontal(i, false);
                f = getSecondaryHorizontal(i + 1, true);
            }
            float f5 = f4;
            f2 = f3;
            f = f5;
        } else {
            f2 = getPrimaryHorizontal(i, false);
            f = getPrimaryHorizontal(i + 1, true);
        }
        return new RectF(f2, lineTop, f, lineBottom);
    }

    public final void paint(Canvas canvas) {
        if (canvas.getClipBounds(this.rect)) {
            int i = this.topPadding;
            if (i != 0) {
                canvas.translate(0.0f, (float) i);
            }
            TextAndroidCanvas access$getSharedTextAndroidCanvas$p = TextLayout_androidKt.SharedTextAndroidCanvas;
            access$getSharedTextAndroidCanvas$p.setCanvas(canvas);
            this.layout.draw(access$getSharedTextAndroidCanvas$p);
            int i2 = this.topPadding;
            if (i2 != 0) {
                canvas.translate(0.0f, ((float) -1) * ((float) i2));
            }
        }
    }

    public final boolean isFallbackLinespacingApplied$ui_text_release() {
        if (this.isBoringLayout) {
            BoringLayoutFactory boringLayoutFactory = BoringLayoutFactory.INSTANCE;
            Layout layout2 = this.layout;
            Intrinsics.checkNotNull(layout2, "null cannot be cast to non-null type android.text.BoringLayout");
            return boringLayoutFactory.isFallbackLineSpacingEnabled((BoringLayout) layout2);
        }
        StaticLayoutFactory staticLayoutFactory = StaticLayoutFactory.INSTANCE;
        Layout layout3 = this.layout;
        Intrinsics.checkNotNull(layout3, "null cannot be cast to non-null type android.text.StaticLayout");
        return staticLayoutFactory.isFallbackLineSpacingEnabled((StaticLayout) layout3, this.fallbackLineSpacing);
    }
}
