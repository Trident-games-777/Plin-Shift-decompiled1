package androidx.compose.foundation.text.input;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a&\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0001\u001a\u0012\u0010\r\u001a\u00020\f*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0006\u001a\u0012\u0010\u000f\u001a\u00020\f*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"TextFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "initialValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "rememberTextFieldState", "initialText", "", "initialSelection", "Landroidx/compose/ui/text/TextRange;", "rememberTextFieldState-Le-punE", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/text/input/TextFieldState;", "clearText", "", "setTextAndPlaceCursorAtEnd", "text", "setTextAndSelectAll", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldState.kt */
public final class TextFieldStateKt {
    public static final TextFieldState TextFieldState(TextFieldValue textFieldValue) {
        return new TextFieldState(textFieldValue.getText(), textFieldValue.m6823getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: rememberTextFieldState-Le-punE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.text.input.TextFieldState m1316rememberTextFieldStateLepunE(java.lang.String r7, long r8, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            java.lang.String r0 = "C(rememberTextFieldState)P(1,0:c#ui.text.TextRange)620@26335L53,620@26288L100:TextFieldState.kt#hp9ohv"
            r1 = 1125389485(0x431414ad, float:148.08076)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x000e
            java.lang.String r7 = ""
        L_0x000e:
            r12 = r12 & 2
            if (r12 == 0) goto L_0x001a
            int r8 = r7.length()
            long r8 = androidx.compose.ui.text.TextRangeKt.TextRange(r8)
        L_0x001a:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x0026
            r12 = -1
            java.lang.String r0 = "androidx.compose.foundation.text.input.rememberTextFieldState (TextFieldState.kt:620)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r11, r12, r0)
        L_0x0026:
            r12 = 0
            java.lang.Object[] r0 = new java.lang.Object[r12]
            androidx.compose.foundation.text.input.TextFieldState$Saver r1 = androidx.compose.foundation.text.input.TextFieldState.Saver.INSTANCE
            androidx.compose.runtime.saveable.Saver r1 = (androidx.compose.runtime.saveable.Saver) r1
            r2 = 975793873(0x3a296ed1, float:6.4633513E-4)
            java.lang.String r3 = "CC(remember):TextFieldState.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r3)
            r2 = r11 & 14
            r2 = r2 ^ 6
            r3 = 4
            r4 = 1
            if (r2 <= r3) goto L_0x0043
            boolean r2 = r10.changed((java.lang.Object) r7)
            if (r2 != 0) goto L_0x0047
        L_0x0043:
            r2 = r11 & 6
            if (r2 != r3) goto L_0x0049
        L_0x0047:
            r2 = r4
            goto L_0x004a
        L_0x0049:
            r2 = r12
        L_0x004a:
            r3 = r11 & 112(0x70, float:1.57E-43)
            r3 = r3 ^ 48
            r5 = 32
            if (r3 <= r5) goto L_0x0058
            boolean r3 = r10.changed((long) r8)
            if (r3 != 0) goto L_0x005c
        L_0x0058:
            r11 = r11 & 48
            if (r11 != r5) goto L_0x005d
        L_0x005c:
            r12 = r4
        L_0x005d:
            r11 = r2 | r12
            java.lang.Object r12 = r10.rememberedValue()
            if (r11 != 0) goto L_0x006d
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x0078
        L_0x006d:
            androidx.compose.foundation.text.input.TextFieldStateKt$rememberTextFieldState$1$1 r11 = new androidx.compose.foundation.text.input.TextFieldStateKt$rememberTextFieldState$1$1
            r11.<init>(r7, r8)
            r12 = r11
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r10.updateRememberedValue(r12)
        L_0x0078:
            r3 = r12
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r5 = 48
            r6 = 4
            r2 = 0
            r4 = r10
            java.lang.Object r7 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.foundation.text.input.TextFieldState r7 = (androidx.compose.foundation.text.input.TextFieldState) r7
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0092
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0092:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.TextFieldStateKt.m1316rememberTextFieldStateLepunE(java.lang.String, long, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.text.input.TextFieldState");
    }

    public static final void setTextAndPlaceCursorAtEnd(TextFieldState textFieldState, String str) {
        TextFieldBuffer startEdit = textFieldState.startEdit();
        try {
            startEdit.replace(0, startEdit.getLength(), str);
            TextFieldBufferKt.placeCursorAtEnd(startEdit);
            textFieldState.commitEdit(startEdit);
        } finally {
            textFieldState.finishEditing();
        }
    }

    public static final void setTextAndSelectAll(TextFieldState textFieldState, String str) {
        TextFieldBuffer startEdit = textFieldState.startEdit();
        try {
            startEdit.replace(0, startEdit.getLength(), str);
            TextFieldBufferKt.selectAll(startEdit);
            textFieldState.commitEdit(startEdit);
        } finally {
            textFieldState.finishEditing();
        }
    }

    public static final void clearText(TextFieldState textFieldState) {
        TextFieldBuffer startEdit = textFieldState.startEdit();
        try {
            TextFieldBufferKt.delete(startEdit, 0, startEdit.getLength());
            TextFieldBufferKt.placeCursorAtEnd(startEdit);
            textFieldState.commitEdit(startEdit);
        } finally {
            textFieldState.finishEditing();
        }
    }
}
