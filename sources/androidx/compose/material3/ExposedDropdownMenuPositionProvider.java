package androidx.compose.material3;

import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00128\b\u0002\u0010\n\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\u0010\u0011J2\u0010%\u001a\u00020&2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000RA\u0010\n\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "density", "Landroidx/compose/ui/unit/Density;", "topWindowInsets", "", "keyboardSignalState", "Landroidx/compose/runtime/State;", "", "verticalMargin", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/ParameterName;", "name", "anchorBounds", "menuBounds", "(Landroidx/compose/ui/unit/Density;ILandroidx/compose/runtime/State;ILkotlin/jvm/functions/Function2;)V", "bottomToAnchorTop", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToWindowBottom", "getDensity", "()Landroidx/compose/ui/unit/Density;", "endToAnchorEnd", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "getKeyboardSignalState", "()Landroidx/compose/runtime/State;", "leftToWindowLeft", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "rightToWindowRight", "startToAnchorStart", "topToAnchorBottom", "topToWindowTop", "getTopWindowInsets", "()I", "getVerticalMargin", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
public final class ExposedDropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final MenuPosition.Vertical bottomToAnchorTop;
    private final MenuPosition.Vertical bottomToWindowBottom;
    private final Density density;
    private final MenuPosition.Horizontal endToAnchorEnd;
    private final State<Unit> keyboardSignalState;
    private final MenuPosition.Horizontal leftToWindowLeft;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;
    private final MenuPosition.Horizontal rightToWindowRight;
    private final MenuPosition.Horizontal startToAnchorStart;
    private final MenuPosition.Vertical topToAnchorBottom;
    private final MenuPosition.Vertical topToWindowTop;
    private final int topWindowInsets;
    private final int verticalMargin;

    public ExposedDropdownMenuPositionProvider(Density density2, int i, State<Unit> state, int i2, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        this.density = density2;
        this.topWindowInsets = i;
        this.keyboardSignalState = state;
        this.verticalMargin = i2;
        this.onPositionCalculated = function2;
        this.startToAnchorStart = MenuPosition.startToAnchorStart$default(MenuPosition.INSTANCE, 0, 1, (Object) null);
        this.endToAnchorEnd = MenuPosition.endToAnchorEnd$default(MenuPosition.INSTANCE, 0, 1, (Object) null);
        this.leftToWindowLeft = MenuPosition.leftToWindowLeft$default(MenuPosition.INSTANCE, 0, 1, (Object) null);
        this.rightToWindowRight = MenuPosition.rightToWindowRight$default(MenuPosition.INSTANCE, 0, 1, (Object) null);
        this.topToAnchorBottom = MenuPosition.topToAnchorBottom$default(MenuPosition.INSTANCE, 0, 1, (Object) null);
        this.bottomToAnchorTop = MenuPosition.bottomToAnchorTop$default(MenuPosition.INSTANCE, 0, 1, (Object) null);
        this.topToWindowTop = MenuPosition.INSTANCE.topToWindowTop(i2);
        this.bottomToWindowBottom = MenuPosition.INSTANCE.bottomToWindowBottom(i2);
    }

    public final Density getDensity() {
        return this.density;
    }

    public final int getTopWindowInsets() {
        return this.topWindowInsets;
    }

    public final State<Unit> getKeyboardSignalState() {
        return this.keyboardSignalState;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExposedDropdownMenuPositionProvider(Density density2, int i, State state, int i2, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(density2, i, (i3 & 4) != 0 ? null : state, (i3 & 8) != 0 ? density2.m7086roundToPx0680j_4(MenuKt.getMenuVerticalMargin()) : i2, (i3 & 16) != 0 ? AnonymousClass2.INSTANCE : function2);
    }

    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    public long m2062calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        MenuPosition.Horizontal horizontal;
        int i;
        MenuPosition.Vertical vertical;
        int r7;
        State<Unit> state = this.keyboardSignalState;
        if (state != null) {
            state.getValue();
        }
        long IntSize = IntSizeKt.IntSize(IntSize.m7283getWidthimpl(j), IntSize.m7282getHeightimpl(j) + this.topWindowInsets);
        MenuPosition.Horizontal[] horizontalArr = new MenuPosition.Horizontal[3];
        int i2 = 0;
        horizontalArr[0] = this.startToAnchorStart;
        horizontalArr[1] = this.endToAnchorEnd;
        if (IntOffset.m7241getXimpl(intRect.m7264getCenternOccac()) < IntSize.m7283getWidthimpl(IntSize) / 2) {
            horizontal = this.leftToWindowLeft;
        } else {
            horizontal = this.rightToWindowRight;
        }
        horizontalArr[2] = horizontal;
        List listOf = CollectionsKt.listOf(horizontalArr);
        int size = listOf.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i = 0;
                break;
            }
            i = ((MenuPosition.Horizontal) listOf.get(i3)).m2918position95KtPRI(intRect, IntSize, IntSize.m7283getWidthimpl(j2), layoutDirection);
            if (i3 == CollectionsKt.getLastIndex(listOf) || (i >= 0 && IntSize.m7283getWidthimpl(j2) + i <= IntSize.m7283getWidthimpl(IntSize))) {
                break;
            }
            i3++;
        }
        MenuPosition.Vertical[] verticalArr = new MenuPosition.Vertical[3];
        verticalArr[0] = this.topToAnchorBottom;
        verticalArr[1] = this.bottomToAnchorTop;
        if (IntOffset.m7242getYimpl(intRect.m7264getCenternOccac()) < IntSize.m7282getHeightimpl(IntSize) / 2) {
            vertical = this.topToWindowTop;
        } else {
            vertical = this.bottomToWindowBottom;
        }
        verticalArr[2] = vertical;
        List listOf2 = CollectionsKt.listOf(verticalArr);
        int size2 = listOf2.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size2) {
                break;
            }
            r7 = ((MenuPosition.Vertical) listOf2.get(i4)).m2919positionJVtK1S4(intRect, IntSize, IntSize.m7282getHeightimpl(j2));
            if (i4 == CollectionsKt.getLastIndex(listOf2) || (r7 >= 0 && IntSize.m7282getHeightimpl(j2) + r7 <= IntSize.m7282getHeightimpl(IntSize))) {
                i2 = r7;
            } else {
                i4++;
            }
        }
        i2 = r7;
        long IntOffset = IntOffsetKt.IntOffset(i, i2);
        this.onPositionCalculated.invoke(intRect, IntRectKt.m7273IntRectVbeCjmY(IntOffset, j2));
        return IntOffset;
    }
}
