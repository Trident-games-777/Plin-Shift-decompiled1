package coil3;

import android.net.Uri;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toCoilUri", "Lcoil3/Uri;", "Landroid/net/Uri;", "toAndroidUri", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: Uri.android.kt */
public final class Uri_androidKt {
    public static final Uri toCoilUri(Uri uri) {
        return UriKt.toUri$default(uri.toString(), (String) null, 1, (Object) null);
    }

    public static final Uri toAndroidUri(Uri uri) {
        return Uri.parse(uri.toString());
    }
}
