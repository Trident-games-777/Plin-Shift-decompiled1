package androidx.navigation;

import android.os.Bundle;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Landroidx/navigation/NavAction;", "", "destinationId", "", "navOptions", "Landroidx/navigation/NavOptions;", "defaultArguments", "Landroid/os/Bundle;", "(ILandroidx/navigation/NavOptions;Landroid/os/Bundle;)V", "getDefaultArguments", "()Landroid/os/Bundle;", "setDefaultArguments", "(Landroid/os/Bundle;)V", "getDestinationId", "()I", "getNavOptions", "()Landroidx/navigation/NavOptions;", "setNavOptions", "(Landroidx/navigation/NavOptions;)V", "equals", "", "other", "hashCode", "toString", "", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavAction.kt */
public final class NavAction {
    private Bundle defaultArguments;
    private final int destinationId;
    private NavOptions navOptions;

    public NavAction(int i) {
        this(i, (NavOptions) null, (Bundle) null, 6, (DefaultConstructorMarker) null);
    }

    public NavAction(int i, NavOptions navOptions2) {
        this(i, navOptions2, (Bundle) null, 4, (DefaultConstructorMarker) null);
    }

    public NavAction(int i, NavOptions navOptions2, Bundle bundle) {
        this.destinationId = i;
        this.navOptions = navOptions2;
        this.defaultArguments = bundle;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavAction(int i, NavOptions navOptions2, Bundle bundle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : navOptions2, (i2 & 4) != 0 ? null : bundle);
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    public final NavOptions getNavOptions() {
        return this.navOptions;
    }

    public final void setNavOptions(NavOptions navOptions2) {
        this.navOptions = navOptions2;
    }

    public final Bundle getDefaultArguments() {
        return this.defaultArguments;
    }

    public final void setDefaultArguments(Bundle bundle) {
        this.defaultArguments = bundle;
    }

    public boolean equals(Object obj) {
        Set keySet;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NavAction)) {
            NavAction navAction = (NavAction) obj;
            if (this.destinationId == navAction.destinationId && Intrinsics.areEqual((Object) this.navOptions, (Object) navAction.navOptions)) {
                if (!Intrinsics.areEqual((Object) this.defaultArguments, (Object) navAction.defaultArguments)) {
                    Bundle bundle = this.defaultArguments;
                    if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
                        Iterable<String> iterable = keySet;
                        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                            for (String str : iterable) {
                                Bundle bundle2 = this.defaultArguments;
                                Object obj2 = null;
                                Object obj3 = bundle2 != null ? bundle2.get(str) : null;
                                Bundle bundle3 = navAction.defaultArguments;
                                if (bundle3 != null) {
                                    obj2 = bundle3.get(str);
                                }
                                if (!Intrinsics.areEqual(obj3, obj2)) {
                                }
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Set<String> keySet;
        int hashCode = Integer.hashCode(this.destinationId) * 31;
        NavOptions navOptions2 = this.navOptions;
        int hashCode2 = hashCode + (navOptions2 != null ? navOptions2.hashCode() : 0);
        Bundle bundle = this.defaultArguments;
        if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
            for (String str : keySet) {
                int i = hashCode2 * 31;
                Bundle bundle2 = this.defaultArguments;
                Object obj = bundle2 != null ? bundle2.get(str) : null;
                hashCode2 = i + (obj != null ? obj.hashCode() : 0);
            }
        }
        return hashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(0x");
        sb.append(Integer.toHexString(this.destinationId));
        sb.append(")");
        if (this.navOptions != null) {
            sb.append(" navOptions=");
            sb.append(this.navOptions);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
