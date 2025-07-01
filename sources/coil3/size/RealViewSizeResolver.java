package coil3.size;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcoil3/size/RealViewSizeResolver;", "T", "Landroid/view/View;", "Lcoil3/size/ViewSizeResolver;", "view", "subtractPadding", "", "<init>", "(Landroid/view/View;Z)V", "getView", "()Landroid/view/View;", "Landroid/view/View;", "getSubtractPadding", "()Z", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: RealViewSizeResolver.kt */
public final class RealViewSizeResolver<T extends View> implements ViewSizeResolver<T> {
    private final boolean subtractPadding;
    private final T view;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealViewSizeResolver)) {
            return false;
        }
        RealViewSizeResolver realViewSizeResolver = (RealViewSizeResolver) obj;
        return Intrinsics.areEqual((Object) this.view, (Object) realViewSizeResolver.view) && this.subtractPadding == realViewSizeResolver.subtractPadding;
    }

    public int hashCode() {
        return (this.view.hashCode() * 31) + Boolean.hashCode(this.subtractPadding);
    }

    public String toString() {
        return "RealViewSizeResolver(view=" + this.view + ", subtractPadding=" + this.subtractPadding + ')';
    }

    public RealViewSizeResolver(T t, boolean z) {
        this.view = t;
        this.subtractPadding = z;
    }

    public T getView() {
        return this.view;
    }

    public boolean getSubtractPadding() {
        return this.subtractPadding;
    }
}
