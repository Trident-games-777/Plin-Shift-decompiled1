package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bq\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014B5\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0015BM\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0016Be\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0017Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0018Jr\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013ø\u0001\u0000¢\u0006\u0004\b<\u0010=J@\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?JX\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010AJp\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ|\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010I\u001a\u00020JH\u0016J\u0014\u0010K\u001a\u00020\u00002\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010L\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\u0000H\u0002J\b\u0010M\u001a\u00020NH\u0016R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00118GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0004\u0018\u00010\u000f8GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010!R\"\u0010\"\u001a\u0004\u0018\u00010\u00038GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010%R\"\u0010&\u001a\u0004\u0018\u00010\u00058GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010)R\u0019\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\b5\u0010+R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\b6\u0010+R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006O"}, d2 = {"Landroidx/compose/ui/text/ParagraphStyle;", "", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "Landroidx/compose/ui/unit/TextUnit;", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "deprecated_boxing_hyphens", "getHyphens-EaSxIns$annotations", "()V", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "deprecated_boxing_lineBreak", "getLineBreak-LgCVezo$annotations", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "deprecated_boxing_textAlign", "getTextAlign-buA522U$annotations", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "deprecated_boxing_textDirection", "getTextDirection-mmuk1to$annotations", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getHyphens-vmbZdU8", "()I", "I", "getLineBreak-rAG3T2k", "getLineHeight-XSAIIZE", "()J", "J", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "getTextAlign-e0LSkKk", "getTextDirection-s_7X-co", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "copy", "copy-ykzQM6k", "(IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-Elsmlbk", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-xPh5V4g", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-ciSxzs0", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-NH1kkwU", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "equals", "", "other", "hashCode", "", "merge", "plus", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ParagraphStyle.kt */
public final class ParagraphStyle {
    public static final int $stable = 0;
    private final int hyphens;
    private final int lineBreak;
    private final long lineHeight;
    private final LineHeightStyle lineHeightStyle;
    private final PlatformParagraphStyle platformStyle;
    private final int textAlign;
    private final int textDirection;
    private final TextIndent textIndent;
    private final TextMotion textMotion;

    public /* synthetic */ ParagraphStyle(int i, int i2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, int i3, int i4, TextMotion textMotion2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, textIndent2, platformParagraphStyle, lineHeightStyle2, i3, i4, textMotion2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, TextMotion textMotion2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2, platformParagraphStyle, lineHeightStyle2, lineBreak2, hyphens2, textMotion2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable constructors.")
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2, platformParagraphStyle, lineHeightStyle2, lineBreak2, hyphens2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructors.")
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2, platformParagraphStyle, lineHeightStyle2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getHyphens-EaSxIns$annotations  reason: not valid java name */
    public static /* synthetic */ void m6455getHyphensEaSxIns$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getLineBreak-LgCVezo$annotations  reason: not valid java name */
    public static /* synthetic */ void m6456getLineBreakLgCVezo$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getTextAlign-buA522U$annotations  reason: not valid java name */
    public static /* synthetic */ void m6457getTextAlignbuA522U$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getTextDirection-mmuk1to$annotations  reason: not valid java name */
    public static /* synthetic */ void m6458getTextDirectionmmuk1to$annotations() {
    }

    private ParagraphStyle(int i, int i2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, int i3, int i4, TextMotion textMotion2) {
        this.textAlign = i;
        this.textDirection = i2;
        this.lineHeight = j;
        this.textIndent = textIndent2;
        this.platformStyle = platformParagraphStyle;
        this.lineHeightStyle = lineHeightStyle2;
        this.lineBreak = i3;
        this.hyphens = i4;
        this.textMotion = textMotion2;
        if (!TextUnit.m7303equalsimpl0(j, TextUnit.Companion.m7317getUnspecifiedXSAIIZE()) && TextUnit.m7306getValueimpl(j) < 0.0f) {
            throw new IllegalStateException(("lineHeight can't be negative (" + TextUnit.m7306getValueimpl(j) + ')').toString());
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ParagraphStyle(int r12, int r13, long r14, androidx.compose.ui.text.style.TextIndent r16, androidx.compose.ui.text.PlatformParagraphStyle r17, androidx.compose.ui.text.style.LineHeightStyle r18, int r19, int r20, androidx.compose.ui.text.style.TextMotion r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.text.style.TextAlign$Companion r1 = androidx.compose.ui.text.style.TextAlign.Companion
            int r1 = r1.m6992getUnspecifiede0LSkKk()
            goto L_0x000e
        L_0x000d:
            r1 = r12
        L_0x000e:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0019
            androidx.compose.ui.text.style.TextDirection$Companion r2 = androidx.compose.ui.text.style.TextDirection.Companion
            int r2 = r2.m7005getUnspecifieds_7Xco()
            goto L_0x001a
        L_0x0019:
            r2 = r13
        L_0x001a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0025
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m7317getUnspecifiedXSAIIZE()
            goto L_0x0026
        L_0x0025:
            r3 = r14
        L_0x0026:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x002d
            r5 = r6
            goto L_0x002f
        L_0x002d:
            r5 = r16
        L_0x002f:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0035
            r7 = r6
            goto L_0x0037
        L_0x0035:
            r7 = r17
        L_0x0037:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x003d
            r8 = r6
            goto L_0x003f
        L_0x003d:
            r8 = r18
        L_0x003f:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x004a
            androidx.compose.ui.text.style.LineBreak$Companion r9 = androidx.compose.ui.text.style.LineBreak.Companion
            int r9 = r9.m6919getUnspecifiedrAG3T2k()
            goto L_0x004c
        L_0x004a:
            r9 = r19
        L_0x004c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0057
            androidx.compose.ui.text.style.Hyphens$Companion r10 = androidx.compose.ui.text.style.Hyphens.Companion
            int r10 = r10.m6898getUnspecifiedvmbZdU8()
            goto L_0x0059
        L_0x0057:
            r10 = r20
        L_0x0059:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r6 = r21
        L_0x0060:
            r0 = 0
            r12 = r11
            r23 = r0
            r13 = r1
            r14 = r2
            r15 = r3
            r17 = r5
            r22 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r12.<init>((int) r13, (int) r14, (long) r15, (androidx.compose.ui.text.style.TextIndent) r17, (androidx.compose.ui.text.PlatformParagraphStyle) r18, (androidx.compose.ui.text.style.LineHeightStyle) r19, (int) r20, (int) r21, (androidx.compose.ui.text.style.TextMotion) r22, (kotlin.jvm.internal.DefaultConstructorMarker) r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyle.<init>(int, int, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, int, int, androidx.compose.ui.text.style.TextMotion, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getTextAlign-e0LSkKk  reason: not valid java name */
    public final int m6470getTextAligne0LSkKk() {
        return this.textAlign;
    }

    /* renamed from: getTextDirection-s_7X-co  reason: not valid java name */
    public final int m6472getTextDirections_7Xco() {
        return this.textDirection;
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m6468getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public final PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    /* renamed from: getLineBreak-rAG3T2k  reason: not valid java name */
    public final int m6467getLineBreakrAG3T2k() {
        return this.lineBreak;
    }

    /* renamed from: getHyphens-vmbZdU8  reason: not valid java name */
    public final int m6465getHyphensvmbZdU8() {
        return this.hyphens;
    }

    public final TextMotion getTextMotion() {
        return this.textMotion;
    }

    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m6469getTextAlignbuA522U() {
        return TextAlign.m6979boximpl(this.textAlign);
    }

    /* renamed from: getTextDirection-mmuk1to  reason: not valid java name */
    public final TextDirection m6471getTextDirectionmmuk1to() {
        return TextDirection.m6993boximpl(this.textDirection);
    }

    /* renamed from: getHyphens-EaSxIns  reason: not valid java name */
    public final Hyphens m6464getHyphensEaSxIns() {
        return Hyphens.m6889boximpl(this.hyphens);
    }

    /* renamed from: getLineBreak-LgCVezo  reason: not valid java name */
    public final LineBreak m6466getLineBreakLgCVezo() {
        return LineBreak.m6899boximpl(this.lineBreak);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ParagraphStyle(androidx.compose.ui.text.style.TextAlign r8, androidx.compose.ui.text.style.TextDirection r9, long r10, androidx.compose.ui.text.style.TextIndent r12, androidx.compose.ui.text.PlatformParagraphStyle r13, androidx.compose.ui.text.style.LineHeightStyle r14, androidx.compose.ui.text.style.LineBreak r15, androidx.compose.ui.text.style.Hyphens r16, androidx.compose.ui.text.style.TextMotion r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r7 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0008
            r8 = r2
        L_0x0008:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000d
            r9 = r2
        L_0x000d:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0017
            androidx.compose.ui.unit.TextUnit$Companion r10 = androidx.compose.ui.unit.TextUnit.Companion
            long r10 = r10.m7317getUnspecifiedXSAIIZE()
        L_0x0017:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001d
            r1 = r2
            goto L_0x001e
        L_0x001d:
            r1 = r12
        L_0x001e:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0024
            r3 = r2
            goto L_0x0025
        L_0x0024:
            r3 = r13
        L_0x0025:
            r4 = r0 & 32
            if (r4 == 0) goto L_0x002b
            r4 = r2
            goto L_0x002c
        L_0x002b:
            r4 = r14
        L_0x002c:
            r5 = r0 & 64
            if (r5 == 0) goto L_0x0032
            r5 = r2
            goto L_0x0033
        L_0x0032:
            r5 = r15
        L_0x0033:
            r6 = r0 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0039
            r6 = r2
            goto L_0x003b
        L_0x0039:
            r6 = r16
        L_0x003b:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r2 = r17
        L_0x0042:
            r0 = 0
            r11 = r10
            r19 = r0
            r13 = r1
            r18 = r2
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r10 = r9
            r9 = r8
            r8 = r7
            r8.<init>((androidx.compose.ui.text.style.TextAlign) r9, (androidx.compose.ui.text.style.TextDirection) r10, (long) r11, (androidx.compose.ui.text.style.TextIndent) r13, (androidx.compose.ui.text.PlatformParagraphStyle) r14, (androidx.compose.ui.text.style.LineHeightStyle) r15, (androidx.compose.ui.text.style.LineBreak) r16, (androidx.compose.ui.text.style.Hyphens) r17, (androidx.compose.ui.text.style.TextMotion) r18, (kotlin.jvm.internal.DefaultConstructorMarker) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyle.<init>(androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, androidx.compose.ui.text.style.TextMotion, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ParagraphStyle(androidx.compose.ui.text.style.TextAlign r13, androidx.compose.ui.text.style.TextDirection r14, long r15, androidx.compose.ui.text.style.TextIndent r17, androidx.compose.ui.text.PlatformParagraphStyle r18, androidx.compose.ui.text.style.LineHeightStyle r19, androidx.compose.ui.text.style.LineBreak r20, androidx.compose.ui.text.style.Hyphens r21, androidx.compose.ui.text.style.TextMotion r22) {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x0007
            int r13 = r13.m6985unboximpl()
            goto L_0x000d
        L_0x0007:
            androidx.compose.ui.text.style.TextAlign$Companion r13 = androidx.compose.ui.text.style.TextAlign.Companion
            int r13 = r13.m6992getUnspecifiede0LSkKk()
        L_0x000d:
            r1 = r13
            if (r14 == 0) goto L_0x0015
            int r13 = r14.m6999unboximpl()
            goto L_0x001b
        L_0x0015:
            androidx.compose.ui.text.style.TextDirection$Companion r13 = androidx.compose.ui.text.style.TextDirection.Companion
            int r13 = r13.m7005getUnspecifieds_7Xco()
        L_0x001b:
            r2 = r13
            if (r20 == 0) goto L_0x0023
            int r13 = r20.m6911unboximpl()
            goto L_0x0029
        L_0x0023:
            androidx.compose.ui.text.style.LineBreak$Companion r13 = androidx.compose.ui.text.style.LineBreak.Companion
            int r13 = r13.m6919getUnspecifiedrAG3T2k()
        L_0x0029:
            r8 = r13
            if (r21 == 0) goto L_0x0031
            int r13 = r21.m6895unboximpl()
            goto L_0x0037
        L_0x0031:
            androidx.compose.ui.text.style.Hyphens$Companion r13 = androidx.compose.ui.text.style.Hyphens.Companion
            int r13 = r13.m6898getUnspecifiedvmbZdU8()
        L_0x0037:
            r9 = r13
            r11 = 0
            r0 = r12
            r3 = r15
            r5 = r17
            r6 = r18
            r7 = r19
            r10 = r22
            r0.<init>((int) r1, (int) r2, (long) r3, (androidx.compose.ui.text.style.TextIndent) r5, (androidx.compose.ui.text.PlatformParagraphStyle) r6, (androidx.compose.ui.text.style.LineHeightStyle) r7, (int) r8, (int) r9, (androidx.compose.ui.text.style.TextMotion) r10, (kotlin.jvm.internal.DefaultConstructorMarker) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyle.<init>(androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, androidx.compose.ui.text.style.TextMotion):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign2, (i & 2) != 0 ? null : textDirection2, (i & 4) != 0 ? TextUnit.Companion.m7317getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2) {
        this(textAlign2 != null ? textAlign2.m6985unboximpl() : TextAlign.Companion.m6992getUnspecifiede0LSkKk(), textDirection2 != null ? textDirection2.m6999unboximpl() : TextDirection.Companion.m7005getUnspecifieds_7Xco(), j, textIndent2, (PlatformParagraphStyle) null, (LineHeightStyle) null, LineBreak.Companion.m6919getUnspecifiedrAG3T2k(), Hyphens.Companion.m6898getUnspecifiedvmbZdU8(), (TextMotion) null, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ParagraphStyle(androidx.compose.ui.text.style.TextAlign r3, androidx.compose.ui.text.style.TextDirection r4, long r5, androidx.compose.ui.text.style.TextIndent r7, androidx.compose.ui.text.PlatformParagraphStyle r8, androidx.compose.ui.text.style.LineHeightStyle r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r2 = this;
            r0 = r10 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0006
            r3 = r1
        L_0x0006:
            r0 = r10 & 2
            if (r0 == 0) goto L_0x000b
            r4 = r1
        L_0x000b:
            r0 = r10 & 4
            if (r0 == 0) goto L_0x0015
            androidx.compose.ui.unit.TextUnit$Companion r5 = androidx.compose.ui.unit.TextUnit.Companion
            long r5 = r5.m7317getUnspecifiedXSAIIZE()
        L_0x0015:
            r0 = r10 & 8
            if (r0 == 0) goto L_0x001a
            r7 = r1
        L_0x001a:
            r0 = r10 & 16
            if (r0 == 0) goto L_0x001f
            r8 = r1
        L_0x001f:
            r0 = r10 & 32
            if (r0 == 0) goto L_0x0024
            r9 = r1
        L_0x0024:
            r0 = 0
            r10 = r9
            r11 = r0
            r9 = r8
            r8 = r7
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r3.<init>(r4, r5, r6, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyle.<init>(androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2) {
        this(textAlign2 != null ? textAlign2.m6985unboximpl() : TextAlign.Companion.m6992getUnspecifiede0LSkKk(), textDirection2 != null ? textDirection2.m6999unboximpl() : TextDirection.Companion.m7005getUnspecifieds_7Xco(), j, textIndent2, platformParagraphStyle, lineHeightStyle2, LineBreak.Companion.m6919getUnspecifiedrAG3T2k(), Hyphens.Companion.m6898getUnspecifiedvmbZdU8(), (TextMotion) null, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ParagraphStyle(androidx.compose.ui.text.style.TextAlign r6, androidx.compose.ui.text.style.TextDirection r7, long r8, androidx.compose.ui.text.style.TextIndent r10, androidx.compose.ui.text.PlatformParagraphStyle r11, androidx.compose.ui.text.style.LineHeightStyle r12, androidx.compose.ui.text.style.LineBreak r13, androidx.compose.ui.text.style.Hyphens r14, int r15, kotlin.jvm.internal.DefaultConstructorMarker r16) {
        /*
            r5 = this;
            r1 = r15 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0006
            r6 = r2
        L_0x0006:
            r1 = r15 & 2
            if (r1 == 0) goto L_0x000b
            r7 = r2
        L_0x000b:
            r1 = r15 & 4
            if (r1 == 0) goto L_0x0015
            androidx.compose.ui.unit.TextUnit$Companion r8 = androidx.compose.ui.unit.TextUnit.Companion
            long r8 = r8.m7317getUnspecifiedXSAIIZE()
        L_0x0015:
            r1 = r15 & 8
            if (r1 == 0) goto L_0x001a
            r10 = r2
        L_0x001a:
            r1 = r15 & 16
            if (r1 == 0) goto L_0x0020
            r1 = r2
            goto L_0x0021
        L_0x0020:
            r1 = r11
        L_0x0021:
            r3 = r15 & 32
            if (r3 == 0) goto L_0x0027
            r3 = r2
            goto L_0x0028
        L_0x0027:
            r3 = r12
        L_0x0028:
            r4 = r15 & 64
            if (r4 == 0) goto L_0x002e
            r4 = r2
            goto L_0x002f
        L_0x002e:
            r4 = r13
        L_0x002f:
            r0 = r15 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r2 = r14
        L_0x0035:
            r0 = 0
            r11 = r10
            r16 = r0
            r12 = r1
            r15 = r2
            r13 = r3
            r14 = r4
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r6.<init>((androidx.compose.ui.text.style.TextAlign) r7, (androidx.compose.ui.text.style.TextDirection) r8, (long) r9, (androidx.compose.ui.text.style.TextIndent) r11, (androidx.compose.ui.text.PlatformParagraphStyle) r12, (androidx.compose.ui.text.style.LineHeightStyle) r13, (androidx.compose.ui.text.style.LineBreak) r14, (androidx.compose.ui.text.style.Hyphens) r15, (kotlin.jvm.internal.DefaultConstructorMarker) r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyle.<init>(androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ParagraphStyle(androidx.compose.ui.text.style.TextAlign r13, androidx.compose.ui.text.style.TextDirection r14, long r15, androidx.compose.ui.text.style.TextIndent r17, androidx.compose.ui.text.PlatformParagraphStyle r18, androidx.compose.ui.text.style.LineHeightStyle r19, androidx.compose.ui.text.style.LineBreak r20, androidx.compose.ui.text.style.Hyphens r21) {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x0007
            int r13 = r13.m6985unboximpl()
            goto L_0x000d
        L_0x0007:
            androidx.compose.ui.text.style.TextAlign$Companion r13 = androidx.compose.ui.text.style.TextAlign.Companion
            int r13 = r13.m6992getUnspecifiede0LSkKk()
        L_0x000d:
            r1 = r13
            if (r14 == 0) goto L_0x0015
            int r13 = r14.m6999unboximpl()
            goto L_0x001b
        L_0x0015:
            androidx.compose.ui.text.style.TextDirection$Companion r13 = androidx.compose.ui.text.style.TextDirection.Companion
            int r13 = r13.m7005getUnspecifieds_7Xco()
        L_0x001b:
            r2 = r13
            if (r20 == 0) goto L_0x0023
            int r13 = r20.m6911unboximpl()
            goto L_0x0029
        L_0x0023:
            androidx.compose.ui.text.style.LineBreak$Companion r13 = androidx.compose.ui.text.style.LineBreak.Companion
            int r13 = r13.m6919getUnspecifiedrAG3T2k()
        L_0x0029:
            r8 = r13
            if (r21 == 0) goto L_0x0031
            int r13 = r21.m6895unboximpl()
            goto L_0x0037
        L_0x0031:
            androidx.compose.ui.text.style.Hyphens$Companion r13 = androidx.compose.ui.text.style.Hyphens.Companion
            int r13 = r13.m6898getUnspecifiedvmbZdU8()
        L_0x0037:
            r9 = r13
            r10 = 0
            r11 = 0
            r0 = r12
            r3 = r15
            r5 = r17
            r6 = r18
            r7 = r19
            r0.<init>((int) r1, (int) r2, (long) r3, (androidx.compose.ui.text.style.TextIndent) r5, (androidx.compose.ui.text.PlatformParagraphStyle) r6, (androidx.compose.ui.text.style.LineHeightStyle) r7, (int) r8, (int) r9, (androidx.compose.ui.text.style.TextMotion) r10, (kotlin.jvm.internal.DefaultConstructorMarker) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyle.<init>(androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens):void");
    }

    public static /* synthetic */ ParagraphStyle merge$default(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            paragraphStyle2 = null;
        }
        return paragraphStyle.merge(paragraphStyle2);
    }

    public final ParagraphStyle merge(ParagraphStyle paragraphStyle) {
        if (paragraphStyle == null) {
            return this;
        }
        return ParagraphStyleKt.m6473fastMergej5T8yCg(this, paragraphStyle.textAlign, paragraphStyle.textDirection, paragraphStyle.lineHeight, paragraphStyle.textIndent, paragraphStyle.platformStyle, paragraphStyle.lineHeightStyle, paragraphStyle.lineBreak, paragraphStyle.hyphens, paragraphStyle.textMotion);
    }

    public final ParagraphStyle plus(ParagraphStyle paragraphStyle) {
        return merge(paragraphStyle);
    }

    /* renamed from: copy-Elsmlbk$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6450copyElsmlbk$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign2 = TextAlign.m6979boximpl(paragraphStyle.textAlign);
        }
        if ((i & 2) != 0) {
            textDirection2 = TextDirection.m6993boximpl(paragraphStyle.textDirection);
        }
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        if ((i & 8) != 0) {
            textIndent2 = paragraphStyle.textIndent;
        }
        TextIndent textIndent3 = textIndent2;
        TextDirection textDirection3 = textDirection2;
        return paragraphStyle.m6459copyElsmlbk(textAlign2, textDirection3, j, textIndent3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-Elsmlbk  reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6459copyElsmlbk(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2) {
        return new ParagraphStyle(textAlign2 != null ? textAlign2.m6985unboximpl() : TextAlign.Companion.m6992getUnspecifiede0LSkKk(), textDirection2 != null ? textDirection2.m6999unboximpl() : TextDirection.Companion.m7005getUnspecifieds_7Xco(), j, textIndent2, this.platformStyle, this.lineHeightStyle, this.lineBreak, this.hyphens, this.textMotion, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-xPh5V4g$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6453copyxPh5V4g$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign2 = TextAlign.m6979boximpl(paragraphStyle.textAlign);
        }
        if ((i & 2) != 0) {
            textDirection2 = TextDirection.m6993boximpl(paragraphStyle.textDirection);
        }
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        if ((i & 8) != 0) {
            textIndent2 = paragraphStyle.textIndent;
        }
        if ((i & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        if ((i & 32) != 0) {
            lineHeightStyle2 = paragraphStyle.lineHeightStyle;
        }
        LineHeightStyle lineHeightStyle3 = lineHeightStyle2;
        TextIndent textIndent3 = textIndent2;
        long j2 = j;
        TextDirection textDirection3 = textDirection2;
        return paragraphStyle.m6462copyxPh5V4g(textAlign2, textDirection3, j2, textIndent3, platformParagraphStyle, lineHeightStyle3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-xPh5V4g  reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6462copyxPh5V4g(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2) {
        return new ParagraphStyle(textAlign2 != null ? textAlign2.m6985unboximpl() : TextAlign.Companion.m6992getUnspecifiede0LSkKk(), textDirection2 != null ? textDirection2.m6999unboximpl() : TextDirection.Companion.m7005getUnspecifieds_7Xco(), j, textIndent2, platformParagraphStyle, lineHeightStyle2, this.lineBreak, this.hyphens, this.textMotion, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-ciSxzs0$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6452copyciSxzs0$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign2 = TextAlign.m6979boximpl(paragraphStyle.textAlign);
        }
        if ((i & 2) != 0) {
            textDirection2 = TextDirection.m6993boximpl(paragraphStyle.textDirection);
        }
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        if ((i & 8) != 0) {
            textIndent2 = paragraphStyle.textIndent;
        }
        if ((i & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        if ((i & 32) != 0) {
            lineHeightStyle2 = paragraphStyle.lineHeightStyle;
        }
        if ((i & 64) != 0) {
            lineBreak2 = LineBreak.m6899boximpl(paragraphStyle.lineBreak);
        }
        if ((i & 128) != 0) {
            hyphens2 = Hyphens.m6889boximpl(paragraphStyle.hyphens);
        }
        Hyphens hyphens3 = hyphens2;
        LineHeightStyle lineHeightStyle3 = lineHeightStyle2;
        TextIndent textIndent3 = textIndent2;
        long j2 = j;
        TextDirection textDirection3 = textDirection2;
        return paragraphStyle.m6461copyciSxzs0(textAlign2, textDirection3, j2, textIndent3, platformParagraphStyle, lineHeightStyle3, lineBreak2, hyphens3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-ciSxzs0  reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6461copyciSxzs0(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2) {
        return new ParagraphStyle(textAlign2 != null ? textAlign2.m6985unboximpl() : TextAlign.Companion.m6992getUnspecifiede0LSkKk(), textDirection2 != null ? textDirection2.m6999unboximpl() : TextDirection.Companion.m7005getUnspecifieds_7Xco(), j, textIndent2, platformParagraphStyle, lineHeightStyle2, lineBreak2 != null ? lineBreak2.m6911unboximpl() : LineBreak.Companion.m6919getUnspecifiedrAG3T2k(), hyphens2 != null ? hyphens2.m6895unboximpl() : Hyphens.Companion.m6898getUnspecifiedvmbZdU8(), this.textMotion, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-NH1kkwU$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6451copyNH1kkwU$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, TextMotion textMotion2, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign2 = TextAlign.m6979boximpl(paragraphStyle.textAlign);
        }
        if ((i & 2) != 0) {
            textDirection2 = TextDirection.m6993boximpl(paragraphStyle.textDirection);
        }
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        if ((i & 8) != 0) {
            textIndent2 = paragraphStyle.textIndent;
        }
        if ((i & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        if ((i & 32) != 0) {
            lineHeightStyle2 = paragraphStyle.lineHeightStyle;
        }
        if ((i & 64) != 0) {
            lineBreak2 = LineBreak.m6899boximpl(paragraphStyle.lineBreak);
        }
        if ((i & 128) != 0) {
            hyphens2 = Hyphens.m6889boximpl(paragraphStyle.hyphens);
        }
        if ((i & 256) != 0) {
            textMotion2 = paragraphStyle.textMotion;
        }
        Hyphens hyphens3 = hyphens2;
        TextMotion textMotion3 = textMotion2;
        long j2 = j;
        TextDirection textDirection3 = textDirection2;
        return paragraphStyle.m6460copyNH1kkwU(textAlign2, textDirection3, j2, textIndent2, platformParagraphStyle, lineHeightStyle2, lineBreak2, hyphens3, textMotion3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* renamed from: copy-NH1kkwU  reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6460copyNH1kkwU(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, TextMotion textMotion2) {
        int i;
        int r1 = textAlign2 != null ? textAlign2.m6985unboximpl() : TextAlign.Companion.m6992getUnspecifiede0LSkKk();
        int r2 = textDirection2 != null ? textDirection2.m6999unboximpl() : TextDirection.Companion.m7005getUnspecifieds_7Xco();
        int r8 = lineBreak2 != null ? lineBreak2.m6911unboximpl() : LineBreak.Companion.m6919getUnspecifiedrAG3T2k();
        if (hyphens2 != null) {
            i = hyphens2.m6895unboximpl();
        } else {
            i = Hyphens.Companion.m6898getUnspecifiedvmbZdU8();
        }
        return new ParagraphStyle(r1, r2, j, textIndent2, platformParagraphStyle, lineHeightStyle2, r8, i, textMotion2, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-ykzQM6k$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6454copyykzQM6k$default(ParagraphStyle paragraphStyle, int i, int i2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, int i3, int i4, TextMotion textMotion2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = paragraphStyle.textAlign;
        }
        if ((i5 & 2) != 0) {
            i2 = paragraphStyle.textDirection;
        }
        if ((i5 & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        if ((i5 & 8) != 0) {
            textIndent2 = paragraphStyle.textIndent;
        }
        if ((i5 & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        if ((i5 & 32) != 0) {
            lineHeightStyle2 = paragraphStyle.lineHeightStyle;
        }
        if ((i5 & 64) != 0) {
            i3 = paragraphStyle.lineBreak;
        }
        if ((i5 & 128) != 0) {
            i4 = paragraphStyle.hyphens;
        }
        if ((i5 & 256) != 0) {
            textMotion2 = paragraphStyle.textMotion;
        }
        int i6 = i4;
        TextMotion textMotion3 = textMotion2;
        long j2 = j;
        int i7 = i2;
        return paragraphStyle.m6463copyykzQM6k(i, i7, j2, textIndent2, platformParagraphStyle, lineHeightStyle2, i3, i6, textMotion3);
    }

    /* renamed from: copy-ykzQM6k  reason: not valid java name */
    public final ParagraphStyle m6463copyykzQM6k(int i, int i2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, int i3, int i4, TextMotion textMotion2) {
        return new ParagraphStyle(i, i2, j, textIndent2, platformParagraphStyle, lineHeightStyle2, i3, i4, textMotion2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
        return TextAlign.m6982equalsimpl0(this.textAlign, paragraphStyle.textAlign) && TextDirection.m6996equalsimpl0(this.textDirection, paragraphStyle.textDirection) && TextUnit.m7303equalsimpl0(this.lineHeight, paragraphStyle.lineHeight) && Intrinsics.areEqual((Object) this.textIndent, (Object) paragraphStyle.textIndent) && Intrinsics.areEqual((Object) this.platformStyle, (Object) paragraphStyle.platformStyle) && Intrinsics.areEqual((Object) this.lineHeightStyle, (Object) paragraphStyle.lineHeightStyle) && LineBreak.m6905equalsimpl0(this.lineBreak, paragraphStyle.lineBreak) && Hyphens.m6892equalsimpl0(this.hyphens, paragraphStyle.hyphens) && Intrinsics.areEqual((Object) this.textMotion, (Object) paragraphStyle.textMotion);
    }

    public int hashCode() {
        int r0 = ((((TextAlign.m6983hashCodeimpl(this.textAlign) * 31) + TextDirection.m6997hashCodeimpl(this.textDirection)) * 31) + TextUnit.m7307hashCodeimpl(this.lineHeight)) * 31;
        TextIndent textIndent2 = this.textIndent;
        int i = 0;
        int hashCode = (r0 + (textIndent2 != null ? textIndent2.hashCode() : 0)) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.platformStyle;
        int hashCode2 = (hashCode + (platformParagraphStyle != null ? platformParagraphStyle.hashCode() : 0)) * 31;
        LineHeightStyle lineHeightStyle2 = this.lineHeightStyle;
        int hashCode3 = (((((hashCode2 + (lineHeightStyle2 != null ? lineHeightStyle2.hashCode() : 0)) * 31) + LineBreak.m6909hashCodeimpl(this.lineBreak)) * 31) + Hyphens.m6893hashCodeimpl(this.hyphens)) * 31;
        TextMotion textMotion2 = this.textMotion;
        if (textMotion2 != null) {
            i = textMotion2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + TextAlign.m6984toStringimpl(this.textAlign) + ", textDirection=" + TextDirection.m6998toStringimpl(this.textDirection) + ", lineHeight=" + TextUnit.m7313toStringimpl(this.lineHeight) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ", lineBreak=" + LineBreak.m6910toStringimpl(this.lineBreak) + ", hyphens=" + Hyphens.m6894toStringimpl(this.hyphens) + ", textMotion=" + this.textMotion + ')';
    }
}
