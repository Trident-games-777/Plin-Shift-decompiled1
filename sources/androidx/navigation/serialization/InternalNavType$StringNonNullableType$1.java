package androidx.navigation.serialization;

import android.net.Uri;
import android.os.Bundle;
import androidx.navigation.NavType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"androidx/navigation/serialization/InternalNavType$StringNonNullableType$1", "Landroidx/navigation/NavType;", "", "name", "getName", "()Ljava/lang/String;", "get", "bundle", "Landroid/os/Bundle;", "key", "parseValue", "value", "put", "", "serializeAsValue", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavTypeConverter.kt */
public final class InternalNavType$StringNonNullableType$1 extends NavType<String> {
    public String parseValue(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return str;
    }

    InternalNavType$StringNonNullableType$1() {
        super(false);
    }

    public String getName() {
        return "string_non_nullable";
    }

    public void put(Bundle bundle, String str, String str2) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        bundle.putString(str, str2);
    }

    public String get(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        String string = bundle.getString(str);
        return string == null ? "null" : string;
    }

    public String serializeAsValue(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        String encode = Uri.encode(str);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(value)");
        return encode;
    }
}
