package coil3.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcoil3/target/ImageViewTarget;", "Lcoil3/target/GenericViewTarget;", "Landroid/widget/ImageView;", "view", "<init>", "(Landroid/widget/ImageView;)V", "getView", "()Landroid/widget/ImageView;", "value", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ImageViewTarget.kt */
public class ImageViewTarget extends GenericViewTarget<ImageView> {
    private final ImageView view;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageViewTarget) && Intrinsics.areEqual((Object) this.view, (Object) ((ImageViewTarget) obj).view);
    }

    public int hashCode() {
        return this.view.hashCode();
    }

    public String toString() {
        return "ImageViewTarget(view=" + this.view + ')';
    }

    public ImageView getView() {
        return this.view;
    }

    public ImageViewTarget(ImageView imageView) {
        this.view = imageView;
    }

    public Drawable getDrawable() {
        return getView().getDrawable();
    }

    public void setDrawable(Drawable drawable) {
        getView().setImageDrawable(drawable);
    }
}
