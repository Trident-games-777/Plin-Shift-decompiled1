package androidx.graphics.path;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0004J1\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/graphics/path/ConicConverter;", "", "()V", "currentQuadratic", "", "getCurrentQuadratic", "()I", "setCurrentQuadratic", "(I)V", "<set-?>", "quadraticCount", "getQuadraticCount", "quadraticData", "", "convert", "", "points", "weight", "", "tolerance", "offset", "internalConicToQuadratics", "conicPoints", "quadraticPoints", "nextQuadratic", "", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ConicConverter.kt */
public final class ConicConverter {
    private int currentQuadratic;
    private int quadraticCount;
    private float[] quadraticData = new float[130];

    private final native int internalConicToQuadratics(float[] fArr, int i, float[] fArr2, float f, float f2);

    public final int getQuadraticCount() {
        return this.quadraticCount;
    }

    public final int getCurrentQuadratic() {
        return this.currentQuadratic;
    }

    public final void setCurrentQuadratic(int i) {
        this.currentQuadratic = i;
    }

    public static /* synthetic */ boolean nextQuadratic$default(ConicConverter conicConverter, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return conicConverter.nextQuadratic(fArr, i);
    }

    public final boolean nextQuadratic(float[] fArr, int i) {
        Intrinsics.checkNotNullParameter(fArr, "points");
        int i2 = this.currentQuadratic;
        if (i2 >= this.quadraticCount) {
            return false;
        }
        int i3 = i2 * 4;
        float[] fArr2 = this.quadraticData;
        fArr[i] = fArr2[i3];
        fArr[i + 1] = fArr2[i3 + 1];
        fArr[i + 2] = fArr2[i3 + 2];
        fArr[i + 3] = fArr2[i3 + 3];
        fArr[i + 4] = fArr2[i3 + 4];
        fArr[i + 5] = fArr2[i3 + 5];
        this.currentQuadratic = i2 + 1;
        return true;
    }

    public static /* synthetic */ void convert$default(ConicConverter conicConverter, float[] fArr, float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        conicConverter.convert(fArr, f, f2, i);
    }

    public final void convert(float[] fArr, float f, float f2, int i) {
        Intrinsics.checkNotNullParameter(fArr, "points");
        float[] fArr2 = fArr;
        float f3 = f;
        float f4 = f2;
        int i2 = i;
        int internalConicToQuadratics = internalConicToQuadratics(fArr2, i2, this.quadraticData, f3, f4);
        float[] fArr3 = fArr2;
        int i3 = i2;
        float f5 = f3;
        float f6 = f4;
        this.quadraticCount = internalConicToQuadratics;
        int i4 = (internalConicToQuadratics * 4) + 2;
        if (i4 > this.quadraticData.length) {
            float[] fArr4 = new float[i4];
            this.quadraticData = fArr4;
            this.quadraticCount = internalConicToQuadratics(fArr3, i3, fArr4, f5, f6);
        }
        this.currentQuadratic = 0;
    }
}
