package androidx.compose.foundation.text.input.internal;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.inputmethod.ExtractedText;
import androidx.compose.foundation.content.PlatformTransferableContent;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002\u001a\u0016\u0010\u000b\u001a\u00020\f*\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"DEBUG_CLASS", "", "EXTRA_INPUT_CONTENT_INFO", "SIC_DEBUG", "", "getSIC_DEBUG$annotations", "()V", "STATELESS_TAG", "toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "toTransferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "extras", "Landroid/os/Bundle;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: StatelessInputConnection.android.kt */
public final class StatelessInputConnection_androidKt {
    private static final String DEBUG_CLASS = "StatelessInputConnection";
    private static final String EXTRA_INPUT_CONTENT_INFO = "EXTRA_INPUT_CONTENT_INFO";
    public static final boolean SIC_DEBUG = false;
    private static final String STATELESS_TAG = "StatelessIC";

    public static /* synthetic */ void getSIC_DEBUG$annotations() {
    }

    /* access modifiers changed from: private */
    public static final ExtractedText toExtractedText(TextFieldCharSequence textFieldCharSequence) {
        ExtractedText extractedText = new ExtractedText();
        CharSequence charSequence = textFieldCharSequence;
        extractedText.text = charSequence;
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = textFieldCharSequence.length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = TextRange.m6562getMinimpl(textFieldCharSequence.m1312getSelectiond9O1mEE());
        extractedText.selectionEnd = TextRange.m6561getMaximpl(textFieldCharSequence.m1312getSelectiond9O1mEE());
        extractedText.flags = StringsKt.contains$default(charSequence, 10, false, 2, (Object) null) ^ true ? 1 : 0;
        return extractedText;
    }

    public static final TransferableContent toTransferableContent(InputContentInfoCompat inputContentInfoCompat, Bundle bundle) {
        ClipEntry clipEntry = AndroidClipboardManager_androidKt.toClipEntry(new ClipData(inputContentInfoCompat.getDescription(), new ClipData.Item(inputContentInfoCompat.getContentUri())));
        int r7 = TransferableContent.Source.Companion.m367getKeyboardkB6V9T0();
        ClipMetadata clipMetadata = AndroidClipboardManager_androidKt.toClipMetadata(inputContentInfoCompat.getDescription());
        Uri linkUri = inputContentInfoCompat.getLinkUri();
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        return new TransferableContent(clipEntry, clipMetadata, r7, new PlatformTransferableContent(linkUri, bundle), (DefaultConstructorMarker) null);
    }
}
