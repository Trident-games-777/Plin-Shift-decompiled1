package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\r\u0010\u0010\u001a\u00020\u0002H\u0010¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0010¢\u0006\u0002\b\u0014R\u000e\u0010\u0005\u001a\u00020\u0002X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/internal/FloatArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([F)V", "buffer", "<set-?>", "", "position", "getPosition$kotlinx_serialization_core", "()I", "append", "", "c", "", "append$kotlinx_serialization_core", "build", "build$kotlinx_serialization_core", "ensureCapacity", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PrimitiveArraysSerializers.kt */
public final class FloatArrayBuilder extends PrimitiveArrayBuilder<float[]> {
    private float[] buffer;
    private int position;

    public FloatArrayBuilder(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "bufferWithData");
        this.buffer = fArr;
        this.position = fArr.length;
        ensureCapacity$kotlinx_serialization_core(10);
    }

    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }

    public void ensureCapacity$kotlinx_serialization_core(int i) {
        float[] fArr = this.buffer;
        if (fArr.length < i) {
            float[] copyOf = Arrays.copyOf(fArr, RangesKt.coerceAtLeast(i, fArr.length * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.buffer = copyOf;
        }
    }

    public final void append$kotlinx_serialization_core(float f) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, (Object) null);
        float[] fArr = this.buffer;
        int position$kotlinx_serialization_core = getPosition$kotlinx_serialization_core();
        this.position = position$kotlinx_serialization_core + 1;
        fArr[position$kotlinx_serialization_core] = f;
    }

    public float[] build$kotlinx_serialization_core() {
        float[] copyOf = Arrays.copyOf(this.buffer, getPosition$kotlinx_serialization_core());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }
}
