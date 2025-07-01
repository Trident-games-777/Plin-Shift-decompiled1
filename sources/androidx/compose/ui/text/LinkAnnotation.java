package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation;", "", "()V", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "Clickable", "Url", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LinkAnnotation.kt */
public abstract class LinkAnnotation {
    public static final int $stable = 0;

    public /* synthetic */ LinkAnnotation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract LinkInteractionListener getLinkInteractionListener();

    public abstract TextLinkStyles getStyles();

    private LinkAnnotation() {
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation$Url;", "Landroidx/compose/ui/text/LinkAnnotation;", "url", "", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "getUrl", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LinkAnnotation.kt */
    public static final class Url extends LinkAnnotation {
        public static final int $stable = 8;
        private final LinkInteractionListener linkInteractionListener;
        private final TextLinkStyles styles;
        private final String url;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Url(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : textLinkStyles, (i & 4) != 0 ? null : linkInteractionListener2);
        }

        public final String getUrl() {
            return this.url;
        }

        public TextLinkStyles getStyles() {
            return this.styles;
        }

        public LinkInteractionListener getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        public Url(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener2) {
            super((DefaultConstructorMarker) null);
            this.url = str;
            this.styles = textLinkStyles;
            this.linkInteractionListener = linkInteractionListener2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Url)) {
                return false;
            }
            Url url2 = (Url) obj;
            return Intrinsics.areEqual((Object) this.url, (Object) url2.url) && Intrinsics.areEqual((Object) getStyles(), (Object) url2.getStyles()) && Intrinsics.areEqual((Object) getLinkInteractionListener(), (Object) url2.getLinkInteractionListener());
        }

        public int hashCode() {
            int hashCode = this.url.hashCode() * 31;
            TextLinkStyles styles2 = getStyles();
            int i = 0;
            int hashCode2 = (hashCode + (styles2 != null ? styles2.hashCode() : 0)) * 31;
            LinkInteractionListener linkInteractionListener2 = getLinkInteractionListener();
            if (linkInteractionListener2 != null) {
                i = linkInteractionListener2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "LinkAnnotation.Url(url=" + this.url + ')';
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "Landroidx/compose/ui/text/LinkAnnotation;", "tag", "", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "getTag", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LinkAnnotation.kt */
    public static final class Clickable extends LinkAnnotation {
        public static final int $stable = 8;
        private final LinkInteractionListener linkInteractionListener;
        private final TextLinkStyles styles;
        private final String tag;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Clickable(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : textLinkStyles, linkInteractionListener2);
        }

        public final String getTag() {
            return this.tag;
        }

        public TextLinkStyles getStyles() {
            return this.styles;
        }

        public LinkInteractionListener getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        public Clickable(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener2) {
            super((DefaultConstructorMarker) null);
            this.tag = str;
            this.styles = textLinkStyles;
            this.linkInteractionListener = linkInteractionListener2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Clickable)) {
                return false;
            }
            Clickable clickable = (Clickable) obj;
            return Intrinsics.areEqual((Object) this.tag, (Object) clickable.tag) && Intrinsics.areEqual((Object) getStyles(), (Object) clickable.getStyles()) && Intrinsics.areEqual((Object) getLinkInteractionListener(), (Object) clickable.getLinkInteractionListener());
        }

        public int hashCode() {
            int hashCode = this.tag.hashCode() * 31;
            TextLinkStyles styles2 = getStyles();
            int i = 0;
            int hashCode2 = (hashCode + (styles2 != null ? styles2.hashCode() : 0)) * 31;
            LinkInteractionListener linkInteractionListener2 = getLinkInteractionListener();
            if (linkInteractionListener2 != null) {
                i = linkInteractionListener2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "LinkAnnotation.Clickable(tag=" + this.tag + ')';
        }
    }
}
