package androidx.compose.material3.carousel;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/material3/carousel/CarouselState;", "it", "", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CarouselState.kt */
final class CarouselState$Companion$Saver$2 extends Lambda implements Function1<List, CarouselState> {
    public static final CarouselState$Companion$Saver$2 INSTANCE = new CarouselState$Companion$Saver$2();

    CarouselState$Companion$Saver$2() {
        super(1);
    }

    public final CarouselState invoke(final List<? extends Object> list) {
        Object obj = list.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        Object obj2 = list.get(1);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
        return new CarouselState(intValue, ((Float) obj2).floatValue(), new Function0<Integer>() {
            public final Integer invoke() {
                Object obj = list.get(2);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                return (Integer) obj;
            }
        });
    }
}
