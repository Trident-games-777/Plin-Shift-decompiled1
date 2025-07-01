package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u000b\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "fromDecorationToTextLayout", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "offset", "fromDecorationToTextLayout-Uv8p0NA", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "fromTextLayoutToCore", "fromTextLayoutToCore-Uv8p0NA", "fromWindowToDecoration", "fromWindowToDecoration-Uv8p0NA", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayoutState.kt */
public final class TextLayoutStateKt {
    /* renamed from: coerceIn-3MmeM6k  reason: not valid java name */
    public static final long m1436coerceIn3MmeM6k(long j, Rect rect) {
        float f;
        float f2;
        if (Offset.m3987getXimpl(j) < rect.getLeft()) {
            f = rect.getLeft();
        } else if (Offset.m3987getXimpl(j) > rect.getRight()) {
            f = rect.getRight();
        } else {
            f = Offset.m3987getXimpl(j);
        }
        if (Offset.m3988getYimpl(j) < rect.getTop()) {
            f2 = rect.getTop();
        } else if (Offset.m3988getYimpl(j) > rect.getBottom()) {
            f2 = rect.getBottom();
        } else {
            f2 = Offset.m3988getYimpl(j);
        }
        return OffsetKt.Offset(f, f2);
    }

    /* renamed from: fromTextLayoutToCore-Uv8p0NA  reason: not valid java name */
    public static final long m1438fromTextLayoutToCoreUv8p0NA(TextLayoutState textLayoutState, long j) {
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            Offset offset = null;
            if (!textLayoutNodeCoordinates.isAttached()) {
                textLayoutNodeCoordinates = null;
            }
            if (textLayoutNodeCoordinates != null) {
                LayoutCoordinates coreNodeCoordinates = textLayoutState.getCoreNodeCoordinates();
                if (coreNodeCoordinates != null) {
                    if (!coreNodeCoordinates.isAttached()) {
                        coreNodeCoordinates = null;
                    }
                    if (coreNodeCoordinates != null) {
                        offset = Offset.m3976boximpl(coreNodeCoordinates.m5801localPositionOfR5De75A(textLayoutNodeCoordinates, j));
                    }
                }
                if (offset != null) {
                    return offset.m3997unboximpl();
                }
            }
        }
        return j;
    }

    /* renamed from: fromDecorationToTextLayout-Uv8p0NA  reason: not valid java name */
    public static final long m1437fromDecorationToTextLayoutUv8p0NA(TextLayoutState textLayoutState, long j) {
        Offset offset;
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            LayoutCoordinates decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates();
            if (decoratorNodeCoordinates != null) {
                offset = Offset.m3976boximpl((!textLayoutNodeCoordinates.isAttached() || !decoratorNodeCoordinates.isAttached()) ? j : textLayoutNodeCoordinates.m5801localPositionOfR5De75A(decoratorNodeCoordinates, j));
            } else {
                offset = null;
            }
            if (offset != null) {
                return offset.m3997unboximpl();
            }
        }
        return j;
    }

    /* renamed from: fromWindowToDecoration-Uv8p0NA  reason: not valid java name */
    public static final long m1439fromWindowToDecorationUv8p0NA(TextLayoutState textLayoutState, long j) {
        LayoutCoordinates decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates();
        return (decoratorNodeCoordinates == null || !decoratorNodeCoordinates.isAttached()) ? j : decoratorNodeCoordinates.m5809windowToLocalMKHz9U(j);
    }
}
