package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$SearchBarImpl$useFullScreenShape$2$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBarImpl$useFullScreenShape$2$1(Animatable<Float, AnimationVector1D> animatable) {
        super(0);
        this.$animationProgress = animatable;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(this.$animationProgress.getValue().floatValue() == 1.0f);
    }
}
