package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000]\n\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0001\u001a\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\f2\u0006\u0010\u0011\u001a\u00020\u00122&\u0010\u0013\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0000\u001a\f\u0010\u001c\u001a\u00020\u001b*\u00020\nH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001d"}, d2 = {"NoopSpan", "androidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1", "Landroidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1;", "createCharSequence", "", "text", "", "contextFontSize", "", "contextTextStyle", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "useEmojiCompat", "", "isIncludeFontPaddingEnabled", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidParagraphHelper.android.kt */
public final class AndroidParagraphHelper_androidKt {
    private static final AndroidParagraphHelper_androidKt$NoopSpan$1 NoopSpan = new AndroidParagraphHelper_androidKt$NoopSpan$1();

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r14 = r14.getParagraphStyle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.CharSequence createCharSequence(java.lang.String r7, float r8, androidx.compose.ui.text.TextStyle r9, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> r10, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> r11, androidx.compose.ui.unit.Density r12, kotlin.jvm.functions.Function4<? super androidx.compose.ui.text.font.FontFamily, ? super androidx.compose.ui.text.font.FontWeight, ? super androidx.compose.ui.text.font.FontStyle, ? super androidx.compose.ui.text.font.FontSynthesis, ? extends android.graphics.Typeface> r13, boolean r14) {
        /*
            r0 = 0
            if (r14 == 0) goto L_0x0049
            boolean r14 = androidx.emoji2.text.EmojiCompat.isConfigured()
            if (r14 == 0) goto L_0x0049
            androidx.compose.ui.text.PlatformTextStyle r14 = r9.getPlatformStyle()
            if (r14 == 0) goto L_0x001e
            androidx.compose.ui.text.PlatformParagraphStyle r14 = r14.getParagraphStyle()
            if (r14 == 0) goto L_0x001e
            int r14 = r14.m6493getEmojiSupportMatch_3YsG6Y()
            androidx.compose.ui.text.EmojiSupportMatch r14 = androidx.compose.ui.text.EmojiSupportMatch.m6409boximpl(r14)
            goto L_0x001f
        L_0x001e:
            r14 = 0
        L_0x001f:
            androidx.compose.ui.text.EmojiSupportMatch$Companion r1 = androidx.compose.ui.text.EmojiSupportMatch.Companion
            int r1 = r1.m6416getAll_3YsG6Y()
            if (r14 != 0) goto L_0x0029
            r6 = r0
            goto L_0x0032
        L_0x0029:
            int r14 = r14.m6415unboximpl()
            boolean r14 = androidx.compose.ui.text.EmojiSupportMatch.m6412equalsimpl0(r14, r1)
            r6 = r14
        L_0x0032:
            androidx.emoji2.text.EmojiCompat r1 = androidx.emoji2.text.EmojiCompat.get()
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r4 = r7.length()
            r5 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            java.lang.CharSequence r14 = r1.process(r2, r3, r4, r5, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            goto L_0x004c
        L_0x0049:
            r14 = r7
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
        L_0x004c:
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L_0x0073
            boolean r1 = r11.isEmpty()
            if (r1 == 0) goto L_0x0073
            androidx.compose.ui.text.style.TextIndent r1 = r9.getTextIndent()
            androidx.compose.ui.text.style.TextIndent$Companion r2 = androidx.compose.ui.text.style.TextIndent.Companion
            androidx.compose.ui.text.style.TextIndent r2 = r2.getNone()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0073
            long r1 = r9.m6603getLineHeightXSAIIZE()
            boolean r1 = androidx.compose.ui.unit.TextUnitKt.m7324isUnspecifiedR2X_6o(r1)
            if (r1 == 0) goto L_0x0073
            return r14
        L_0x0073:
            boolean r1 = r14 instanceof android.text.Spannable
            if (r1 == 0) goto L_0x007a
            android.text.Spannable r14 = (android.text.Spannable) r14
            goto L_0x0082
        L_0x007a:
            android.text.SpannableString r1 = new android.text.SpannableString
            r1.<init>(r14)
            r14 = r1
            android.text.Spannable r14 = (android.text.Spannable) r14
        L_0x0082:
            r1 = r14
            androidx.compose.ui.text.style.TextDecoration r14 = r9.getTextDecoration()
            androidx.compose.ui.text.style.TextDecoration$Companion r2 = androidx.compose.ui.text.style.TextDecoration.Companion
            androidx.compose.ui.text.style.TextDecoration r2 = r2.getUnderline()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r2)
            if (r14 == 0) goto L_0x009c
            androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt$NoopSpan$1 r14 = NoopSpan
            int r7 = r7.length()
            androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt.setSpan(r1, r14, r0, r7)
        L_0x009c:
            boolean r7 = isIncludeFontPaddingEnabled(r9)
            if (r7 == 0) goto L_0x00b2
            androidx.compose.ui.text.style.LineHeightStyle r7 = r9.getLineHeightStyle()
            if (r7 != 0) goto L_0x00b2
            long r2 = r9.m6603getLineHeightXSAIIZE()
            androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt.m6863setLineHeightr9BaKPg(r1, r2, r8, r12)
            r4 = r8
            r5 = r12
            goto L_0x00c8
        L_0x00b2:
            androidx.compose.ui.text.style.LineHeightStyle r7 = r9.getLineHeightStyle()
            if (r7 != 0) goto L_0x00be
            androidx.compose.ui.text.style.LineHeightStyle$Companion r7 = androidx.compose.ui.text.style.LineHeightStyle.Companion
            androidx.compose.ui.text.style.LineHeightStyle r7 = r7.getDefault()
        L_0x00be:
            r6 = r7
            long r2 = r9.m6603getLineHeightXSAIIZE()
            r4 = r8
            r5 = r12
            androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt.m6862setLineHeightKmRG4DE(r1, r2, r4, r5, r6)
        L_0x00c8:
            androidx.compose.ui.text.style.TextIndent r7 = r9.getTextIndent()
            androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt.setTextIndent(r1, r7, r4, r5)
            androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt.setSpanStyles(r1, r9, r10, r5, r13)
            androidx.compose.ui.text.platform.extensions.PlaceholderExtensions_androidKt.setPlaceholders(r1, r11, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt.createCharSequence(java.lang.String, float, androidx.compose.ui.text.TextStyle, java.util.List, java.util.List, androidx.compose.ui.unit.Density, kotlin.jvm.functions.Function4, boolean):java.lang.CharSequence");
    }

    public static final boolean isIncludeFontPaddingEnabled(TextStyle textStyle) {
        PlatformParagraphStyle paragraphStyle;
        PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
        if (platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) {
            return false;
        }
        return paragraphStyle.getIncludeFontPadding();
    }
}
