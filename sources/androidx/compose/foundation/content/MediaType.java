package androidx.compose.foundation.content;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/content/MediaType;", "", "representation", "", "(Ljava/lang/String;)V", "getRepresentation", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MediaType.android.kt */
public final class MediaType {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public static final MediaType All = new MediaType("*/*");
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final MediaType HtmlText = new MediaType("text/html");
    /* access modifiers changed from: private */
    public static final MediaType Image = new MediaType("image/*");
    /* access modifiers changed from: private */
    public static final MediaType PlainText = new MediaType("text/plain");
    /* access modifiers changed from: private */
    public static final MediaType Text = new MediaType("text/*");
    private final String representation;

    public MediaType(String str) {
        this.representation = str;
    }

    public final String getRepresentation() {
        return this.representation;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/content/MediaType$Companion;", "", "()V", "All", "Landroidx/compose/foundation/content/MediaType;", "getAll", "()Landroidx/compose/foundation/content/MediaType;", "HtmlText", "getHtmlText", "Image", "getImage", "PlainText", "getPlainText", "Text", "getText", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MediaType.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaType getText() {
            return MediaType.Text;
        }

        public final MediaType getPlainText() {
            return MediaType.PlainText;
        }

        public final MediaType getHtmlText() {
            return MediaType.HtmlText;
        }

        public final MediaType getImage() {
            return MediaType.Image;
        }

        public final MediaType getAll() {
            return MediaType.All;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaType)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.representation, (Object) ((MediaType) obj).representation);
    }

    public int hashCode() {
        return this.representation.hashCode();
    }

    public String toString() {
        return "MediaType(representation='" + this.representation + "')";
    }
}
