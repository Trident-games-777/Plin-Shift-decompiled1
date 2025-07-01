package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.Layout;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidLayoutApi34$$ExternalSyntheticLambda0 implements Layout.TextInclusionStrategy {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ AndroidLayoutApi34$$ExternalSyntheticLambda0(Function2 function2) {
        this.f$0 = function2;
    }

    public final boolean isSegmentInside(RectF rectF, RectF rectF2) {
        return AndroidLayoutApi34.getRangeForRect$lambda$0(this.f$0, rectF, rectF2);
    }
}
