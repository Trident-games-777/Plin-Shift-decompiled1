package androidx.privacysandbox.ads.adservices.common;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdData;", "", "renderUri", "Landroid/net/Uri;", "metadata", "", "(Landroid/net/Uri;Ljava/lang/String;)V", "getMetadata", "()Ljava/lang/String;", "getRenderUri", "()Landroid/net/Uri;", "equals", "", "other", "hashCode", "", "toString", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdData.kt */
public final class AdData {
    private final String metadata;
    private final Uri renderUri;

    public AdData(Uri uri, String str) {
        Intrinsics.checkNotNullParameter(uri, "renderUri");
        Intrinsics.checkNotNullParameter(str, "metadata");
        this.renderUri = uri;
        this.metadata = str;
    }

    public final Uri getRenderUri() {
        return this.renderUri;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdData)) {
            return false;
        }
        AdData adData = (AdData) obj;
        return Intrinsics.areEqual((Object) this.renderUri, (Object) adData.renderUri) && Intrinsics.areEqual((Object) this.metadata, (Object) adData.metadata);
    }

    public int hashCode() {
        return (this.renderUri.hashCode() * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "AdData: renderUri=" + this.renderUri + ", metadata='" + this.metadata + '\'';
    }
}
