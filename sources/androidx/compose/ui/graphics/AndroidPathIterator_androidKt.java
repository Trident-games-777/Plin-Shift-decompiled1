package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.PathIterator;
import androidx.compose.ui.graphics.PathSegment;
import androidx.graphics.path.PathSegment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"PathIterator", "Landroidx/compose/ui/graphics/PathIterator;", "path", "Landroidx/compose/ui/graphics/Path;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "", "toPathSegmentType", "Landroidx/compose/ui/graphics/PathSegment$Type;", "Landroidx/graphics/path/PathSegment$Type;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPathIterator.android.kt */
public final class AndroidPathIterator_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidPathIterator.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.graphics.path.PathSegment$Type[] r0 = androidx.graphics.path.PathSegment.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Move     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Line     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Quadratic     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Conic     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Cubic     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Close     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Done     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidPathIterator_androidKt.WhenMappings.<clinit>():void");
        }
    }

    public static final PathIterator PathIterator(Path path, PathIterator.ConicEvaluation conicEvaluation, float f) {
        return new AndroidPathIterator(path, conicEvaluation, f);
    }

    public static /* synthetic */ PathIterator PathIterator$default(Path path, PathIterator.ConicEvaluation conicEvaluation, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            conicEvaluation = PathIterator.ConicEvaluation.AsQuadratics;
        }
        if ((i & 4) != 0) {
            f = 0.25f;
        }
        return PathIterator(path, conicEvaluation, f);
    }

    /* access modifiers changed from: private */
    public static final PathSegment.Type toPathSegmentType(PathSegment.Type type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return PathSegment.Type.Move;
            case 2:
                return PathSegment.Type.Line;
            case 3:
                return PathSegment.Type.Quadratic;
            case 4:
                return PathSegment.Type.Conic;
            case 5:
                return PathSegment.Type.Cubic;
            case 6:
                return PathSegment.Type.Close;
            case 7:
                return PathSegment.Type.Done;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
