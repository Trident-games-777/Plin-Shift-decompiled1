package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.EditCommand;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\"\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0007\u001a\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a(\u0010\u0013\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a&\u0010\u001b\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a(\u0010\u001b\u001a\u00020\u0001*\u00020 2\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010!\u001a2\u0010\u001b\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a<\u0010&\u001a\u00020\t*\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a.\u0010,\u001a\u00020\t*\u00020\u001c2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a.\u0010,\u001a\u00020\t*\u00020 2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00105\u001a:\u0010,\u001a\u00020\t*\u0004\u0018\u00010\u00142\u0006\u0010-\u001a\u00020.2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a6\u00108\u001a\u00020\t*\u00020\u001c2\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a6\u00108\u001a\u00020\t*\u00020 2\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010=\u001a\u0014\u0010>\u001a\u00020?*\u00020'2\u0006\u0010@\u001a\u00020\u0001H\u0002\u001a\f\u0010A\u001a\u00020?*\u00020\u0001H\u0002\u001a\f\u0010B\u001a\u00020?*\u00020\u0001H\u0002\u001a\f\u0010C\u001a\u00020?*\u00020\u0001H\u0002\u001a\f\u0010D\u001a\u00020?*\u00020\u0001H\u0002\u001a\u0019\u0010E\u001a\u00020\t*\u00020\u00102\u0006\u0010@\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010F\u001a\u0011\u0010G\u001a\u00020\u0016*\u00020HH\u0002¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J"}, d2 = {"LINE_FEED_CODE_POINT", "", "NBSP_CODE_POINT", "compoundEditCommand", "Landroidx/compose/ui/text/input/EditCommand;", "editCommands", "", "([Landroidx/compose/ui/text/input/EditCommand;)Landroidx/compose/ui/text/input/EditCommand;", "enclosure", "Landroidx/compose/ui/text/TextRange;", "a", "b", "enclosure-pWDy79M", "(JJ)J", "adjustHandwritingDeleteGestureRange", "text", "", "adjustHandwritingDeleteGestureRange-72CqOWE", "(JLjava/lang/CharSequence;)J", "getLineForHandwritingGesture", "Landroidx/compose/ui/text/MultiParagraph;", "localPoint", "Landroidx/compose/ui/geometry/Offset;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getLineForHandwritingGesture-d-4ec7I", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "getOffsetForHandwritingGesture", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "pointInScreen", "getOffsetForHandwritingGesture-d-4ec7I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getOffsetForHandwritingGesture-ubNVwUQ", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)I", "getRangeForRemoveSpaceGesture", "Landroidx/compose/ui/text/TextLayoutResult;", "startPointInScreen", "endPointerInScreen", "getRangeForRemoveSpaceGesture-5iVPX68", "(Landroidx/compose/ui/text/TextLayoutResult;JJLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)J", "getRangeForScreenRect", "rectInScreen", "Landroidx/compose/ui/geometry/Rect;", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForScreenRect-OH9lIzo", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRect-O048IG0", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/layout/LayoutCoordinates;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRects", "startRectInScreen", "endRectInScreen", "getRangeForScreenRects-O048IG0", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "isBiDiBoundary", "", "offset", "isNewline", "isPunctuation", "isWhitespace", "isWhitespaceExceptNewline", "rangeOfWhitespaces", "(Ljava/lang/CharSequence;I)J", "toOffset", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandwritingGesture.android.kt */
public final class HandwritingGesture_androidKt {
    private static final int LINE_FEED_CODE_POINT = 10;
    private static final int NBSP_CODE_POINT = 160;

    /* access modifiers changed from: private */
    /* renamed from: adjustHandwritingDeleteGestureRange-72CqOWE  reason: not valid java name */
    public static final long m1367adjustHandwritingDeleteGestureRange72CqOWE(long j, CharSequence charSequence) {
        int r0 = TextRange.m6564getStartimpl(j);
        int r1 = TextRange.m6559getEndimpl(j);
        int i = 10;
        int codePointBefore = r0 > 0 ? Character.codePointBefore(charSequence, r0) : 10;
        if (r1 < charSequence.length()) {
            i = Character.codePointAt(charSequence, r1);
        }
        if (isWhitespaceExceptNewline(codePointBefore) && (isWhitespace(i) || isPunctuation(i))) {
            do {
                r0 -= Character.charCount(codePointBefore);
                if (r0 == 0) {
                    break;
                }
                codePointBefore = Character.codePointBefore(charSequence, r0);
            } while (isWhitespaceExceptNewline(codePointBefore));
            return TextRangeKt.TextRange(r0, r1);
        } else if (!isWhitespaceExceptNewline(i)) {
            return j;
        } else {
            if (!isWhitespace(codePointBefore) && !isPunctuation(codePointBefore)) {
                return j;
            }
            do {
                r1 += Character.charCount(i);
                if (r1 == charSequence.length()) {
                    break;
                }
                i = Character.codePointAt(charSequence, r1);
            } while (isWhitespaceExceptNewline(i));
            return TextRangeKt.TextRange(r0, r1);
        }
    }

    private static final boolean isNewline(int i) {
        int type = Character.getType(i);
        return type == 14 || type == 13 || i == 10;
    }

    private static final boolean isWhitespace(int i) {
        return Character.isWhitespace(i) || i == NBSP_CODE_POINT;
    }

    private static final boolean isWhitespaceExceptNewline(int i) {
        return isWhitespace(i) && !isNewline(i);
    }

    private static final boolean isPunctuation(int i) {
        int type = Character.getType(i);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }

    /* access modifiers changed from: private */
    public static final long toOffset(PointF pointF) {
        return OffsetKt.Offset(pointF.x, pointF.y);
    }

    /* access modifiers changed from: private */
    /* renamed from: getRangeForScreenRect-OH9lIzo  reason: not valid java name */
    public static final long m1376getRangeForScreenRectOH9lIzo(TextLayoutState textLayoutState, Rect rect, int i, TextInclusionStrategy textInclusionStrategy) {
        TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
        return m1374getRangeForScreenRectO048IG0(layoutResult != null ? layoutResult.getMultiParagraph() : null, rect, textLayoutState.getTextLayoutNodeCoordinates(), i, textInclusionStrategy);
    }

    /* access modifiers changed from: private */
    /* renamed from: getRangeForScreenRects-O048IG0  reason: not valid java name */
    public static final long m1378getRangeForScreenRectsO048IG0(TextLayoutState textLayoutState, Rect rect, Rect rect2, int i, TextInclusionStrategy textInclusionStrategy) {
        long r0 = m1376getRangeForScreenRectOH9lIzo(textLayoutState, rect, i, textInclusionStrategy);
        if (TextRange.m6558getCollapsedimpl(r0)) {
            return TextRange.Companion.m6569getZerod9O1mEE();
        }
        long r2 = m1376getRangeForScreenRectOH9lIzo(textLayoutState, rect2, i, textInclusionStrategy);
        if (TextRange.m6558getCollapsedimpl(r2)) {
            return TextRange.Companion.m6569getZerod9O1mEE();
        }
        return m1368enclosurepWDy79M(r0, r2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getValue();
     */
    /* renamed from: getRangeForScreenRect-OH9lIzo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long m1375getRangeForScreenRectOH9lIzo(androidx.compose.foundation.text.LegacyTextFieldState r1, androidx.compose.ui.geometry.Rect r2, int r3, androidx.compose.ui.text.TextInclusionStrategy r4) {
        /*
            androidx.compose.foundation.text.TextLayoutResultProxy r0 = r1.getLayoutResult()
            if (r0 == 0) goto L_0x0011
            androidx.compose.ui.text.TextLayoutResult r0 = r0.getValue()
            if (r0 == 0) goto L_0x0011
            androidx.compose.ui.text.MultiParagraph r0 = r0.getMultiParagraph()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            androidx.compose.ui.layout.LayoutCoordinates r1 = r1.getLayoutCoordinates()
            long r1 = m1374getRangeForScreenRectO048IG0(r0, r2, r1, r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.m1375getRangeForScreenRectOH9lIzo(androidx.compose.foundation.text.LegacyTextFieldState, androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.text.TextInclusionStrategy):long");
    }

    /* access modifiers changed from: private */
    /* renamed from: getRangeForScreenRects-O048IG0  reason: not valid java name */
    public static final long m1377getRangeForScreenRectsO048IG0(LegacyTextFieldState legacyTextFieldState, Rect rect, Rect rect2, int i, TextInclusionStrategy textInclusionStrategy) {
        long r0 = m1375getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect, i, textInclusionStrategy);
        if (TextRange.m6558getCollapsedimpl(r0)) {
            return TextRange.Companion.m6569getZerod9O1mEE();
        }
        long r2 = m1375getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect2, i, textInclusionStrategy);
        if (TextRange.m6558getCollapsedimpl(r2)) {
            return TextRange.Companion.m6569getZerod9O1mEE();
        }
        return m1368enclosurepWDy79M(r0, r2);
    }

    /* access modifiers changed from: private */
    public static final long rangeOfWhitespaces(CharSequence charSequence, int i) {
        int i2 = i;
        while (i2 > 0) {
            int codePointBefore = CodepointHelpers_jvmKt.codePointBefore(charSequence, i2);
            if (!isWhitespace(codePointBefore)) {
                break;
            }
            i2 -= Character.charCount(codePointBefore);
        }
        while (i < charSequence.length()) {
            int codePointAt = CodepointHelpers_jvmKt.codePointAt(charSequence, i);
            if (!isWhitespace(codePointAt)) {
                break;
            }
            i += CodepointHelpers_jvmKt.charCount(codePointAt);
        }
        return TextRangeKt.TextRange(i2, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: getOffsetForHandwritingGesture-d-4ec7I  reason: not valid java name */
    public static final int m1371getOffsetForHandwritingGestured4ec7I(TextLayoutState textLayoutState, long j, ViewConfiguration viewConfiguration) {
        MultiParagraph multiParagraph;
        TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
        if (layoutResult == null || (multiParagraph = layoutResult.getMultiParagraph()) == null) {
            return -1;
        }
        return m1372getOffsetForHandwritingGestureubNVwUQ(multiParagraph, j, textLayoutState.getTextLayoutNodeCoordinates(), viewConfiguration);
    }

    /* access modifiers changed from: private */
    /* renamed from: getOffsetForHandwritingGesture-d-4ec7I  reason: not valid java name */
    public static final int m1370getOffsetForHandwritingGestured4ec7I(LegacyTextFieldState legacyTextFieldState, long j, ViewConfiguration viewConfiguration) {
        TextLayoutResult value;
        MultiParagraph multiParagraph;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult == null || (value = layoutResult.getValue()) == null || (multiParagraph = value.getMultiParagraph()) == null) {
            return -1;
        }
        return m1372getOffsetForHandwritingGestureubNVwUQ(multiParagraph, j, legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
    }

    /* access modifiers changed from: private */
    public static final boolean isBiDiBoundary(TextLayoutResult textLayoutResult, int i) {
        int lineForOffset = textLayoutResult.getLineForOffset(i);
        return (i == textLayoutResult.getLineStart(lineForOffset) || i == TextLayoutResult.getLineEnd$default(textLayoutResult, lineForOffset, false, 2, (Object) null)) ? textLayoutResult.getParagraphDirection(i) != textLayoutResult.getBidiRunDirection(i) : textLayoutResult.getBidiRunDirection(i) != textLayoutResult.getBidiRunDirection(i - 1);
    }

    /* renamed from: getRangeForScreenRect-O048IG0  reason: not valid java name */
    private static final long m1374getRangeForScreenRectO048IG0(MultiParagraph multiParagraph, Rect rect, LayoutCoordinates layoutCoordinates, int i, TextInclusionStrategy textInclusionStrategy) {
        if (multiParagraph == null || layoutCoordinates == null) {
            return TextRange.Companion.m6569getZerod9O1mEE();
        }
        return multiParagraph.m6424getRangeForRect86BmAI(rect.m4024translatek4lQ0M(layoutCoordinates.m5806screenToLocalMKHz9U(Offset.Companion.m4003getZeroF1C5BW0())), i, textInclusionStrategy);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r10.m5806screenToLocalMKHz9U(r8);
     */
    /* renamed from: getOffsetForHandwritingGesture-ubNVwUQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int m1372getOffsetForHandwritingGestureubNVwUQ(androidx.compose.ui.text.MultiParagraph r7, long r8, androidx.compose.ui.layout.LayoutCoordinates r10, androidx.compose.ui.platform.ViewConfiguration r11) {
        /*
            r0 = -1
            if (r10 == 0) goto L_0x0027
            long r1 = r10.m5806screenToLocalMKHz9U(r8)
            int r8 = m1369getLineForHandwritingGestured4ec7I(r7, r1, r11)
            if (r8 != r0) goto L_0x000e
            return r0
        L_0x000e:
            float r9 = r7.getLineTop(r8)
            float r8 = r7.getLineBottom(r8)
            float r9 = r9 + r8
            r8 = 1073741824(0x40000000, float:2.0)
            float r4 = r9 / r8
            r5 = 1
            r6 = 0
            r3 = 0
            long r8 = androidx.compose.ui.geometry.Offset.m3981copydBAh8RU$default(r1, r3, r4, r5, r6)
            int r7 = r7.m6423getOffsetForPositionk4lQ0M(r8)
            return r7
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.m1372getOffsetForHandwritingGestureubNVwUQ(androidx.compose.ui.text.MultiParagraph, long, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.platform.ViewConfiguration):int");
    }

    /* access modifiers changed from: private */
    /* renamed from: getRangeForRemoveSpaceGesture-5iVPX68  reason: not valid java name */
    public static final long m1373getRangeForRemoveSpaceGesture5iVPX68(TextLayoutResult textLayoutResult, long j, long j2, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        if (textLayoutResult == null || layoutCoordinates == null) {
            return TextRange.Companion.m6569getZerod9O1mEE();
        }
        long r4 = layoutCoordinates.m5806screenToLocalMKHz9U(j);
        long r6 = layoutCoordinates.m5806screenToLocalMKHz9U(j2);
        int r8 = m1369getLineForHandwritingGestured4ec7I(textLayoutResult.getMultiParagraph(), r4, viewConfiguration);
        int r9 = m1369getLineForHandwritingGestured4ec7I(textLayoutResult.getMultiParagraph(), r6, viewConfiguration);
        if (r8 != -1) {
            if (r9 != -1) {
                r8 = Math.min(r8, r9);
            }
            r9 = r8;
        } else if (r9 == -1) {
            return TextRange.Companion.m6569getZerod9O1mEE();
        }
        float lineTop = (textLayoutResult.getLineTop(r9) + textLayoutResult.getLineBottom(r9)) / ((float) 2);
        return textLayoutResult.getMultiParagraph().m6424getRangeForRect86BmAI(new Rect(Math.min(Offset.m3987getXimpl(r4), Offset.m3987getXimpl(r6)), lineTop - 0.1f, Math.max(Offset.m3987getXimpl(r4), Offset.m3987getXimpl(r6)), lineTop + 0.1f), TextGranularity.Companion.m6528getCharacterDRrd7Zo(), TextInclusionStrategy.Companion.getAnyOverlap());
    }

    /* renamed from: getLineForHandwritingGesture-d-4ec7I  reason: not valid java name */
    private static final int m1369getLineForHandwritingGestured4ec7I(MultiParagraph multiParagraph, long j, ViewConfiguration viewConfiguration) {
        float handwritingGestureLineMargin = viewConfiguration != null ? viewConfiguration.getHandwritingGestureLineMargin() : 0.0f;
        int lineForVerticalPosition = multiParagraph.getLineForVerticalPosition(Offset.m3988getYimpl(j));
        if (Offset.m3988getYimpl(j) < multiParagraph.getLineTop(lineForVerticalPosition) - handwritingGestureLineMargin || Offset.m3988getYimpl(j) > multiParagraph.getLineBottom(lineForVerticalPosition) + handwritingGestureLineMargin || Offset.m3987getXimpl(j) < (-handwritingGestureLineMargin) || Offset.m3987getXimpl(j) > multiParagraph.getWidth() + handwritingGestureLineMargin) {
            return -1;
        }
        return lineForVerticalPosition;
    }

    /* access modifiers changed from: private */
    public static final EditCommand compoundEditCommand(EditCommand... editCommandArr) {
        return new HandwritingGesture_androidKt$compoundEditCommand$1(editCommandArr);
    }

    /* renamed from: enclosure-pWDy79M  reason: not valid java name */
    private static final long m1368enclosurepWDy79M(long j, long j2) {
        return TextRangeKt.TextRange(Math.min(TextRange.m6564getStartimpl(j), TextRange.m6564getStartimpl(j)), Math.max(TextRange.m6559getEndimpl(j2), TextRange.m6559getEndimpl(j2)));
    }
}
