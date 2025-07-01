package coil3.transition;

import android.graphics.drawable.Drawable;
import coil3.Image;
import coil3.Image_androidKt;
import coil3.decode.DataSource;
import coil3.request.ErrorResult;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import coil3.size.Scale;
import coil3.transition.Transition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcoil3/transition/CrossfadeTransition;", "Lcoil3/transition/Transition;", "target", "Lcoil3/transition/TransitionTarget;", "result", "Lcoil3/request/ImageResult;", "durationMillis", "", "preferExactIntrinsicSize", "", "<init>", "(Lcoil3/transition/TransitionTarget;Lcoil3/request/ImageResult;IZ)V", "getDurationMillis", "()I", "getPreferExactIntrinsicSize", "()Z", "transition", "", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: CrossfadeTransition.kt */
public final class CrossfadeTransition implements Transition {
    private final int durationMillis;
    private final boolean preferExactIntrinsicSize;
    private final ImageResult result;
    private final TransitionTarget target;

    public CrossfadeTransition(TransitionTarget transitionTarget, ImageResult imageResult) {
        this(transitionTarget, imageResult, 0, false, 12, (DefaultConstructorMarker) null);
    }

    public CrossfadeTransition(TransitionTarget transitionTarget, ImageResult imageResult, int i) {
        this(transitionTarget, imageResult, i, false, 8, (DefaultConstructorMarker) null);
    }

    public CrossfadeTransition(TransitionTarget transitionTarget, ImageResult imageResult, int i, boolean z) {
        this.target = transitionTarget;
        this.result = imageResult;
        this.durationMillis = i;
        this.preferExactIntrinsicSize = z;
        if (i <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CrossfadeTransition(TransitionTarget transitionTarget, ImageResult imageResult, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(transitionTarget, imageResult, (i2 & 4) != 0 ? 200 : i, (i2 & 8) != 0 ? false : z);
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    public void transition() {
        Drawable drawable = this.target.getDrawable();
        Image image = this.result.getImage();
        Drawable asDrawable = image != null ? Image_androidKt.asDrawable(image, this.target.getView().getResources()) : null;
        Scale scale = this.result.getRequest().getScale();
        int i = this.durationMillis;
        ImageResult imageResult = this.result;
        CrossfadeDrawable crossfadeDrawable = new CrossfadeDrawable(drawable, asDrawable, scale, i, !(imageResult instanceof SuccessResult) || !((SuccessResult) imageResult).isPlaceholderCached(), this.preferExactIntrinsicSize);
        ImageResult imageResult2 = this.result;
        if (imageResult2 instanceof SuccessResult) {
            this.target.onSuccess(Image_androidKt.asImage((Drawable) crossfadeDrawable));
        } else if (imageResult2 instanceof ErrorResult) {
            this.target.onError(Image_androidKt.asImage((Drawable) crossfadeDrawable));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcoil3/transition/CrossfadeTransition$Factory;", "Lcoil3/transition/Transition$Factory;", "durationMillis", "", "preferExactIntrinsicSize", "", "<init>", "(IZ)V", "getDurationMillis", "()I", "getPreferExactIntrinsicSize", "()Z", "create", "Lcoil3/transition/Transition;", "target", "Lcoil3/transition/TransitionTarget;", "result", "Lcoil3/request/ImageResult;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: CrossfadeTransition.kt */
    public static final class Factory implements Transition.Factory {
        private final int durationMillis;
        private final boolean preferExactIntrinsicSize;

        public Factory() {
            this(0, false, 3, (DefaultConstructorMarker) null);
        }

        public Factory(int i) {
            this(i, false, 2, (DefaultConstructorMarker) null);
        }

        public Factory(int i, boolean z) {
            this.durationMillis = i;
            this.preferExactIntrinsicSize = z;
            if (i <= 0) {
                throw new IllegalArgumentException("durationMillis must be > 0.".toString());
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 200 : i, (i2 & 2) != 0 ? false : z);
        }

        public final int getDurationMillis() {
            return this.durationMillis;
        }

        public final boolean getPreferExactIntrinsicSize() {
            return this.preferExactIntrinsicSize;
        }

        public Transition create(TransitionTarget transitionTarget, ImageResult imageResult) {
            if (!(imageResult instanceof SuccessResult)) {
                return Transition.Factory.NONE.create(transitionTarget, imageResult);
            }
            if (((SuccessResult) imageResult).getDataSource() == DataSource.MEMORY_CACHE) {
                return Transition.Factory.NONE.create(transitionTarget, imageResult);
            }
            return new CrossfadeTransition(transitionTarget, imageResult, this.durationMillis, this.preferExactIntrinsicSize);
        }
    }
}
