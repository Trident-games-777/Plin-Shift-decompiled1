package coil3.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsyncImageKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ AsyncImagePainter f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ Alignment f$3;
    public final /* synthetic */ ContentScale f$4;
    public final /* synthetic */ float f$5;
    public final /* synthetic */ ColorFilter f$6;
    public final /* synthetic */ boolean f$7;
    public final /* synthetic */ int f$8;

    public /* synthetic */ AsyncImageKt$$ExternalSyntheticLambda0(Modifier modifier, AsyncImagePainter asyncImagePainter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, int i) {
        this.f$0 = modifier;
        this.f$1 = asyncImagePainter;
        this.f$2 = str;
        this.f$3 = alignment;
        this.f$4 = contentScale;
        this.f$5 = f;
        this.f$6 = colorFilter;
        this.f$7 = z;
        this.f$8 = i;
    }

    public final Object invoke(Object obj, Object obj2) {
        return AsyncImageKt.Content$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, (Composer) obj, ((Integer) obj2).intValue());
    }
}
