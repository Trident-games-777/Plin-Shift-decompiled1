package coil3.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SubcomposeAsyncImageKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ SubcomposeAsyncImageScope f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ int f$10;
    public final /* synthetic */ Painter f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ Alignment f$4;
    public final /* synthetic */ ContentScale f$5;
    public final /* synthetic */ float f$6;
    public final /* synthetic */ ColorFilter f$7;
    public final /* synthetic */ boolean f$8;
    public final /* synthetic */ int f$9;

    public /* synthetic */ SubcomposeAsyncImageKt$$ExternalSyntheticLambda1(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, int i, int i2) {
        this.f$0 = subcomposeAsyncImageScope;
        this.f$1 = modifier;
        this.f$2 = painter;
        this.f$3 = str;
        this.f$4 = alignment;
        this.f$5 = contentScale;
        this.f$6 = f;
        this.f$7 = colorFilter;
        this.f$8 = z;
        this.f$9 = i;
        this.f$10 = i2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return SubcomposeAsyncImageKt.SubcomposeAsyncImageContent$lambda$4(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, (Composer) obj, ((Integer) obj2).intValue());
    }
}
