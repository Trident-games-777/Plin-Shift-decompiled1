package coil3.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil3.Image;
import coil3.transition.TransitionTarget;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0004J\b\u0010\u001d\u001a\u00020\u0011H\u0004R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcoil3/target/GenericViewTarget;", "T", "Landroid/view/View;", "Lcoil3/target/ViewTarget;", "Lcoil3/transition/TransitionTarget;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "isStarted", "", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "onStart", "", "placeholder", "Lcoil3/Image;", "onError", "error", "onSuccess", "result", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "updateImage", "image", "updateAnimation", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: GenericViewTarget.kt */
public abstract class GenericViewTarget<T extends View> implements ViewTarget<T>, TransitionTarget, DefaultLifecycleObserver {
    private boolean isStarted;

    public abstract Drawable getDrawable();

    public abstract void setDrawable(Drawable drawable);

    public void onStart(Image image) {
        updateImage(image);
    }

    public void onError(Image image) {
        updateImage(image);
    }

    public void onSuccess(Image image) {
        updateImage(image);
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        this.isStarted = true;
        updateAnimation();
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        this.isStarted = false;
        updateAnimation();
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.graphics.drawable.Drawable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateImage(coil3.Image r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0010
            android.view.View r1 = r3.getView()
            android.content.res.Resources r1 = r1.getResources()
            android.graphics.drawable.Drawable r4 = coil3.Image_androidKt.asDrawable(r4, r1)
            goto L_0x0011
        L_0x0010:
            r4 = r0
        L_0x0011:
            android.graphics.drawable.Drawable r1 = r3.getDrawable()
            boolean r2 = r1 instanceof android.graphics.drawable.Animatable
            if (r2 == 0) goto L_0x001c
            r0 = r1
            android.graphics.drawable.Animatable r0 = (android.graphics.drawable.Animatable) r0
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.stop()
        L_0x0021:
            r3.setDrawable(r4)
            r3.updateAnimation()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.target.GenericViewTarget.updateImage(coil3.Image):void");
    }

    /* access modifiers changed from: protected */
    public final void updateAnimation() {
        Drawable drawable = getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            if (this.isStarted) {
                animatable.start();
            } else {
                animatable.stop();
            }
        }
    }
}
