package coil3.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import coil3.compose.internal.AsyncImageState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsyncImageKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ AsyncImageState f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ boolean f$10;
    public final /* synthetic */ int f$11;
    public final /* synthetic */ int f$12;
    public final /* synthetic */ Modifier f$2;
    public final /* synthetic */ Function1 f$3;
    public final /* synthetic */ Function1 f$4;
    public final /* synthetic */ Alignment f$5;
    public final /* synthetic */ ContentScale f$6;
    public final /* synthetic */ float f$7;
    public final /* synthetic */ ColorFilter f$8;
    public final /* synthetic */ int f$9;

    public /* synthetic */ AsyncImageKt$$ExternalSyntheticLambda1(AsyncImageState asyncImageState, String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, int i2, int i3) {
        this.f$0 = asyncImageState;
        this.f$1 = str;
        this.f$2 = modifier;
        this.f$3 = function1;
        this.f$4 = function12;
        this.f$5 = alignment;
        this.f$6 = contentScale;
        this.f$7 = f;
        this.f$8 = colorFilter;
        this.f$9 = i;
        this.f$10 = z;
        this.f$11 = i2;
        this.f$12 = i3;
    }

    public final Object invoke(Object obj, Object obj2) {
        return AsyncImageKt.AsyncImage_76YX9Dk$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, (Composer) obj, ((Integer) obj2).intValue());
    }
}
