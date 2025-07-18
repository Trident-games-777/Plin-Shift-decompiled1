package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

final class EmojiInputConnection extends InputConnectionWrapper {
    private final EmojiCompatDeleteHelper mEmojiCompatDeleteHelper;
    private final TextView mTextView;

    EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new EmojiCompatDeleteHelper());
    }

    EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.mTextView = textView;
        this.mEmojiCompatDeleteHelper = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.updateEditorInfoAttrs(editorInfo);
    }

    public boolean deleteSurroundingText(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        return this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), i3, i4, false) || super.deleteSurroundingText(i3, i4);
    }

    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        return this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), i3, i4, true) || super.deleteSurroundingTextInCodePoints(i3, i4);
    }

    private Editable getEditable() {
        return this.mTextView.getEditableText();
    }

    public static class EmojiCompatDeleteHelper {
        public boolean handleDeleteSurroundingText(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
            return EmojiCompat.handleDeleteSurroundingText(inputConnection, editable, i, i2, z);
        }

        public void updateEditorInfoAttrs(EditorInfo editorInfo) {
            if (EmojiCompat.isConfigured()) {
                EmojiCompat.get().updateEditorInfo(editorInfo);
            }
        }
    }
}
