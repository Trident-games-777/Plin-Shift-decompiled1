package androidx.compose.ui.platform;

import android.content.ClipData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/ClipEntry;", "", "clipData", "Landroid/content/ClipData;", "(Landroid/content/ClipData;)V", "getClipData", "()Landroid/content/ClipData;", "clipMetadata", "Landroidx/compose/ui/platform/ClipMetadata;", "getClipMetadata", "()Landroidx/compose/ui/platform/ClipMetadata;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidClipboardManager.android.kt */
public final class ClipEntry {
    public static final int $stable = 8;
    private final ClipData clipData;

    public ClipEntry(ClipData clipData2) {
        this.clipData = clipData2;
    }

    public final ClipData getClipData() {
        return this.clipData;
    }

    public final ClipMetadata getClipMetadata() {
        return AndroidClipboardManager_androidKt.toClipMetadata(this.clipData.getDescription());
    }
}
