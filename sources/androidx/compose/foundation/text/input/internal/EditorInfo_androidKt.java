package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.input.ImeOptions;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a@\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"hasFlag", "", "bits", "", "flag", "update", "", "Landroid/view/inputmethod/EditorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "contentMimeTypes", "", "", "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: EditorInfo.android.kt */
public final class EditorInfo_androidKt {
    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: update-pLxbY9I$default  reason: not valid java name */
    public static /* synthetic */ void m1352updatepLxbY9I$default(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr, int i, Object obj) {
        if ((i & 8) != 0) {
            strArr = null;
        }
        m1351updatepLxbY9I(editorInfo, charSequence, j, imeOptions, strArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ee  */
    /* renamed from: update-pLxbY9I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1351updatepLxbY9I(android.view.inputmethod.EditorInfo r7, java.lang.CharSequence r8, long r9, androidx.compose.ui.text.input.ImeOptions r11, java.lang.String[] r12) {
        /*
            int r0 = r11.m6770getImeActioneUduSuo()
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6754getDefaulteUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6741equalsimpl0(r0, r1)
            r2 = 3
            r3 = 2
            r4 = 6
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L_0x001f
            boolean r0 = r11.getSingleLine()
            if (r0 == 0) goto L_0x001d
            goto L_0x007f
        L_0x001d:
            r4 = r5
            goto L_0x007f
        L_0x001f:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6758getNoneeUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6741equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x002d
            r4 = r6
            goto L_0x007f
        L_0x002d:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6756getGoeUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6741equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x003b
            r4 = r3
            goto L_0x007f
        L_0x003b:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6757getNexteUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6741equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0049
            r4 = 5
            goto L_0x007f
        L_0x0049:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6759getPreviouseUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6741equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0057
            r4 = 7
            goto L_0x007f
        L_0x0057:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6760getSearcheUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6741equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0065
            r4 = r2
            goto L_0x007f
        L_0x0065:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6761getSendeUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6741equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0073
            r4 = 4
            goto L_0x007f
        L_0x0073:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6755getDoneeUduSuo()
            boolean r0 = androidx.compose.ui.text.input.ImeAction.m6741equalsimpl0(r0, r1)
            if (r0 == 0) goto L_0x01fe
        L_0x007f:
            r7.imeOptions = r4
            androidx.compose.ui.text.input.PlatformImeOptions r0 = r11.getPlatformImeOptions()
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = r0.getPrivateImeOptions()
            if (r0 == 0) goto L_0x008f
            r7.privateImeOptions = r0
        L_0x008f:
            androidx.compose.foundation.text.input.internal.LocaleListHelper r0 = androidx.compose.foundation.text.input.internal.LocaleListHelper.INSTANCE
            androidx.compose.ui.text.intl.LocaleList r1 = r11.getHintLocales()
            r0.setHintLocales(r7, r1)
            int r0 = r11.m6771getKeyboardTypePjHm6EE()
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6815getTextPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6794equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00ab
        L_0x00a8:
            r2 = r6
            goto L_0x0124
        L_0x00ab:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6808getAsciiPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6794equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00bf
            int r0 = r7.imeOptions
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            r7.imeOptions = r0
            goto L_0x00a8
        L_0x00bf:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6811getNumberPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6794equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00cd
            r2 = r3
            goto L_0x0124
        L_0x00cd:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6814getPhonePjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6794equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00da
            goto L_0x0124
        L_0x00da:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6817getUriPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6794equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00e9
            r2 = 17
            goto L_0x0124
        L_0x00e9:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6810getEmailPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6794equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00f8
            r2 = 33
            goto L_0x0124
        L_0x00f8:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6813getPasswordPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6794equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0107
            r2 = 129(0x81, float:1.81E-43)
            goto L_0x0124
        L_0x0107:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6812getNumberPasswordPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6794equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0116
            r2 = 18
            goto L_0x0124
        L_0x0116:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6809getDecimalPjHm6EE()
            boolean r0 = androidx.compose.ui.text.input.KeyboardType.m6794equalsimpl0(r0, r1)
            if (r0 == 0) goto L_0x01f2
            r2 = 8194(0x2002, float:1.1482E-41)
        L_0x0124:
            r7.inputType = r2
            boolean r0 = r11.getSingleLine()
            if (r0 != 0) goto L_0x0152
            int r0 = r7.inputType
            boolean r0 = hasFlag(r0, r6)
            if (r0 == 0) goto L_0x0152
            int r0 = r7.inputType
            r1 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 | r1
            r7.inputType = r0
            int r0 = r11.m6770getImeActioneUduSuo()
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6754getDefaulteUduSuo()
            boolean r0 = androidx.compose.ui.text.input.ImeAction.m6741equalsimpl0(r0, r1)
            if (r0 == 0) goto L_0x0152
            int r0 = r7.imeOptions
            r1 = 1073741824(0x40000000, float:2.0)
            r0 = r0 | r1
            r7.imeOptions = r0
        L_0x0152:
            int r0 = r7.inputType
            boolean r0 = hasFlag(r0, r6)
            if (r0 == 0) goto L_0x01a4
            int r0 = r11.m6769getCapitalizationIUNYP9k()
            androidx.compose.ui.text.input.KeyboardCapitalization$Companion r1 = androidx.compose.ui.text.input.KeyboardCapitalization.Companion
            int r1 = r1.m6786getCharactersIUNYP9k()
            boolean r1 = androidx.compose.ui.text.input.KeyboardCapitalization.m6777equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0171
            int r0 = r7.inputType
            r0 = r0 | 4096(0x1000, float:5.74E-42)
            r7.inputType = r0
            goto L_0x0196
        L_0x0171:
            androidx.compose.ui.text.input.KeyboardCapitalization$Companion r1 = androidx.compose.ui.text.input.KeyboardCapitalization.Companion
            int r1 = r1.m6790getWordsIUNYP9k()
            boolean r1 = androidx.compose.ui.text.input.KeyboardCapitalization.m6777equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0184
            int r0 = r7.inputType
            r0 = r0 | 8192(0x2000, float:1.14794E-41)
            r7.inputType = r0
            goto L_0x0196
        L_0x0184:
            androidx.compose.ui.text.input.KeyboardCapitalization$Companion r1 = androidx.compose.ui.text.input.KeyboardCapitalization.Companion
            int r1 = r1.m6788getSentencesIUNYP9k()
            boolean r0 = androidx.compose.ui.text.input.KeyboardCapitalization.m6777equalsimpl0(r0, r1)
            if (r0 == 0) goto L_0x0196
            int r0 = r7.inputType
            r0 = r0 | 16384(0x4000, float:2.2959E-41)
            r7.inputType = r0
        L_0x0196:
            boolean r0 = r11.getAutoCorrect()
            if (r0 == 0) goto L_0x01a4
            int r0 = r7.inputType
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 | r1
            r7.inputType = r0
        L_0x01a4:
            int r0 = androidx.compose.ui.text.TextRange.m6564getStartimpl(r9)
            r7.initialSelStart = r0
            int r9 = androidx.compose.ui.text.TextRange.m6559getEndimpl(r9)
            r7.initialSelEnd = r9
            androidx.core.view.inputmethod.EditorInfoCompat.setInitialSurroundingText(r7, r8)
            if (r12 == 0) goto L_0x01b8
            androidx.core.view.inputmethod.EditorInfoCompat.setContentMimeTypes(r7, r12)
        L_0x01b8:
            int r8 = r7.imeOptions
            r9 = 33554432(0x2000000, float:9.403955E-38)
            r8 = r8 | r9
            r7.imeOptions = r8
            boolean r8 = androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt.isStylusHandwritingSupported()
            if (r8 == 0) goto L_0x01ee
            int r8 = r11.m6771getKeyboardTypePjHm6EE()
            androidx.compose.ui.text.input.KeyboardType$Companion r9 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r9 = r9.m6813getPasswordPjHm6EE()
            boolean r8 = androidx.compose.ui.text.input.KeyboardType.m6794equalsimpl0(r8, r9)
            if (r8 != 0) goto L_0x01ee
            int r8 = r11.m6771getKeyboardTypePjHm6EE()
            androidx.compose.ui.text.input.KeyboardType$Companion r9 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r9 = r9.m6812getNumberPasswordPjHm6EE()
            boolean r8 = androidx.compose.ui.text.input.KeyboardType.m6794equalsimpl0(r8, r9)
            if (r8 != 0) goto L_0x01ee
            androidx.core.view.inputmethod.EditorInfoCompat.setStylusHandwritingEnabled(r7, r6)
            androidx.compose.foundation.text.input.internal.EditorInfoApi34 r8 = androidx.compose.foundation.text.input.internal.EditorInfoApi34.INSTANCE
            r8.setHandwritingGestures(r7)
            return
        L_0x01ee:
            androidx.core.view.inputmethod.EditorInfoCompat.setStylusHandwritingEnabled(r7, r5)
            return
        L_0x01f2:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Invalid Keyboard Type"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x01fe:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "invalid ImeAction"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.EditorInfo_androidKt.m1351updatepLxbY9I(android.view.inputmethod.EditorInfo, java.lang.CharSequence, long, androidx.compose.ui.text.input.ImeOptions, java.lang.String[]):void");
    }
}
