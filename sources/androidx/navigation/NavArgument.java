package androidx.navigation;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB9\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavArgument;", "", "type", "Landroidx/navigation/NavType;", "isNullable", "", "defaultValue", "defaultValuePresent", "unknownDefaultValuePresent", "(Landroidx/navigation/NavType;ZLjava/lang/Object;ZZ)V", "getDefaultValue", "()Ljava/lang/Object;", "isDefaultValuePresent", "()Z", "isDefaultValueUnknown", "isDefaultValueUnknown$navigation_common_release", "getType", "()Landroidx/navigation/NavType;", "equals", "other", "hashCode", "", "putDefaultValue", "", "name", "", "bundle", "Landroid/os/Bundle;", "toString", "verify", "Builder", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavArgument.kt */
public final class NavArgument {
    private final Object defaultValue;
    private final boolean isDefaultValuePresent;
    private final boolean isDefaultValueUnknown;
    private final boolean isNullable;
    private final NavType<Object> type;

    public NavArgument(NavType<Object> navType, boolean z, Object obj, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(navType, "type");
        if (!navType.isNullableAllowed() && z) {
            throw new IllegalArgumentException((navType.getName() + " does not allow nullable values").toString());
        } else if (z || !z2 || obj != null) {
            this.type = navType;
            this.isNullable = z;
            this.defaultValue = obj;
            this.isDefaultValuePresent = z2 || z3;
            this.isDefaultValueUnknown = z3;
        } else {
            throw new IllegalArgumentException(("Argument with type " + navType.getName() + " has null value but is not nullable.").toString());
        }
    }

    public final NavType<Object> getType() {
        return this.type;
    }

    public final boolean isNullable() {
        return this.isNullable;
    }

    public final boolean isDefaultValuePresent() {
        return this.isDefaultValuePresent;
    }

    public final boolean isDefaultValueUnknown$navigation_common_release() {
        return this.isDefaultValueUnknown;
    }

    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    public final void putDefaultValue(String str, Bundle bundle) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (this.isDefaultValuePresent && (obj = this.defaultValue) != null) {
            this.type.put(bundle, str, obj);
        }
    }

    public final boolean verify(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!this.isNullable && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.type.get(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" Type: " + this.type);
        sb.append(" Nullable: " + this.isNullable);
        if (this.isDefaultValuePresent) {
            sb.append(" DefaultValue: " + this.defaultValue);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            NavArgument navArgument = (NavArgument) obj;
            if (this.isNullable != navArgument.isNullable || this.isDefaultValuePresent != navArgument.isDefaultValuePresent || !Intrinsics.areEqual((Object) this.type, (Object) navArgument.type)) {
                return false;
            }
            Object obj2 = this.defaultValue;
            if (obj2 != null) {
                return Intrinsics.areEqual(obj2, navArgument.defaultValue);
            }
            if (navArgument.defaultValue == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.type.hashCode() * 31) + (this.isNullable ? 1 : 0)) * 31) + (this.isDefaultValuePresent ? 1 : 0)) * 31;
        Object obj = this.defaultValue;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\u000e\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u000f0\bJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0011R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavArgument$Builder;", "", "()V", "defaultValue", "defaultValuePresent", "", "isNullable", "type", "Landroidx/navigation/NavType;", "unknownDefaultValuePresent", "build", "Landroidx/navigation/NavArgument;", "setDefaultValue", "setIsNullable", "setType", "T", "setUnknownDefaultValuePresent", "setUnknownDefaultValuePresent$navigation_common_release", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavArgument.kt */
    public static final class Builder {
        private Object defaultValue;
        private boolean defaultValuePresent;
        private boolean isNullable;
        private NavType<Object> type;
        private boolean unknownDefaultValuePresent;

        public final <T> Builder setType(NavType<T> navType) {
            Intrinsics.checkNotNullParameter(navType, "type");
            this.type = navType;
            return this;
        }

        public final Builder setIsNullable(boolean z) {
            this.isNullable = z;
            return this;
        }

        public final Builder setDefaultValue(Object obj) {
            this.defaultValue = obj;
            this.defaultValuePresent = true;
            return this;
        }

        public final Builder setUnknownDefaultValuePresent$navigation_common_release(boolean z) {
            this.unknownDefaultValuePresent = z;
            return this;
        }

        public final NavArgument build() {
            NavType<Object> navType = this.type;
            if (navType == null) {
                navType = NavType.Companion.inferFromValueType(this.defaultValue);
                Intrinsics.checkNotNull(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any?>");
            }
            return new NavArgument(navType, this.isNullable, this.defaultValue, this.defaultValuePresent, this.unknownDefaultValuePresent);
        }
    }
}
