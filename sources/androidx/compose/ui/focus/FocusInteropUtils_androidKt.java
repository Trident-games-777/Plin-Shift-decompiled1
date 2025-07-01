package androidx.compose.ui.focus;

import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a%\u0010\n\u001a\u00020\u000b*\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0003*\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"toFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "androidDirection", "", "toLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "androidLayoutDirection", "calculateBoundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroid/view/View;", "requestInteropFocus", "", "direction", "rect", "Landroid/graphics/Rect;", "(Landroid/view/View;Ljava/lang/Integer;Landroid/graphics/Rect;)Z", "toAndroidFocusDirection", "toAndroidFocusDirection-3ESFkO8", "(I)Ljava/lang/Integer;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusInteropUtils.android.kt */
public final class FocusInteropUtils_androidKt {
    public static final FocusDirection toFocusDirection(int i) {
        if (i == 1) {
            return FocusDirection.m3889boximpl(FocusDirection.Companion.m3903getPreviousdhqQ8s());
        }
        if (i == 2) {
            return FocusDirection.m3889boximpl(FocusDirection.Companion.m3902getNextdhqQ8s());
        }
        if (i == 17) {
            return FocusDirection.m3889boximpl(FocusDirection.Companion.m3901getLeftdhqQ8s());
        }
        if (i == 33) {
            return FocusDirection.m3889boximpl(FocusDirection.Companion.m3905getUpdhqQ8s());
        }
        if (i == 66) {
            return FocusDirection.m3889boximpl(FocusDirection.Companion.m3904getRightdhqQ8s());
        }
        if (i != 130) {
            return null;
        }
        return FocusDirection.m3889boximpl(FocusDirection.Companion.m3898getDowndhqQ8s());
    }

    /* renamed from: toAndroidFocusDirection-3ESFkO8  reason: not valid java name */
    public static final Integer m3906toAndroidFocusDirection3ESFkO8(int i) {
        if (FocusDirection.m3892equalsimpl0(i, FocusDirection.Companion.m3905getUpdhqQ8s())) {
            return 33;
        }
        if (FocusDirection.m3892equalsimpl0(i, FocusDirection.Companion.m3898getDowndhqQ8s())) {
            return 130;
        }
        if (FocusDirection.m3892equalsimpl0(i, FocusDirection.Companion.m3901getLeftdhqQ8s())) {
            return 17;
        }
        if (FocusDirection.m3892equalsimpl0(i, FocusDirection.Companion.m3904getRightdhqQ8s())) {
            return 66;
        }
        if (FocusDirection.m3892equalsimpl0(i, FocusDirection.Companion.m3902getNextdhqQ8s())) {
            return 2;
        }
        return FocusDirection.m3892equalsimpl0(i, FocusDirection.Companion.m3903getPreviousdhqQ8s()) ? 1 : null;
    }

    public static final LayoutDirection toLayoutDirection(int i) {
        if (i == 0) {
            return LayoutDirection.Ltr;
        }
        if (i != 1) {
            return null;
        }
        return LayoutDirection.Rtl;
    }

    public static final Rect calculateBoundingRect(View view) {
        int[] tempCoordinates = FocusInteropUtils.Companion.getTempCoordinates();
        view.getLocationInWindow(tempCoordinates);
        int i = tempCoordinates[0];
        return new Rect((float) i, (float) tempCoordinates[1], ((float) i) + ((float) view.getWidth()), ((float) tempCoordinates[1]) + ((float) view.getHeight()));
    }

    public static final boolean requestInteropFocus(View view, Integer num, android.graphics.Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if (viewGroup.isFocusable() && !view.hasFocus()) {
            return view.requestFocus(num.intValue(), rect);
        }
        if (view instanceof AndroidComposeView) {
            return view.requestFocus(num.intValue(), rect);
        }
        if (rect != null) {
            View findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
            if (findNextFocusFromRect != null) {
                return findNextFocusFromRect.requestFocus(num.intValue(), rect);
            }
            return view.requestFocus(num.intValue(), rect);
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, view.hasFocus() ? view.findFocus() : null, num.intValue());
        if (findNextFocus != null) {
            return findNextFocus.requestFocus(num.intValue());
        }
        return view.requestFocus(num.intValue());
    }
}
