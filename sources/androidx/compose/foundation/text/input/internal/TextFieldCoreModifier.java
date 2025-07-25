package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÂ\u0003J\t\u0010\u0017\u001a\u00020\tHÂ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÂ\u0003J\t\u0010\u0019\u001a\u00020\rHÂ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÂ\u0003J\t\u0010\u001b\u001a\u00020\u0010HÂ\u0003J\t\u0010\u001c\u001a\u00020\u0012HÂ\u0003Jc\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0013\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0002H\u0016J\f\u0010)\u001a\u00020'*\u00020*H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "isFocused", "", "isDragHovered", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCoreModifier.kt */
public final class TextFieldCoreModifier extends ModifierNodeElement<TextFieldCoreModifierNode> {
    public static final int $stable = 0;
    private final Brush cursorBrush;
    private final boolean isDragHovered;
    private final boolean isFocused;
    private final Orientation orientation;
    private final ScrollState scrollState;
    private final TextFieldSelectionState textFieldSelectionState;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private final boolean writeable;

    private final boolean component1() {
        return this.isFocused;
    }

    private final boolean component2() {
        return this.isDragHovered;
    }

    private final TextLayoutState component3() {
        return this.textLayoutState;
    }

    private final TransformedTextFieldState component4() {
        return this.textFieldState;
    }

    private final TextFieldSelectionState component5() {
        return this.textFieldSelectionState;
    }

    private final Brush component6() {
        return this.cursorBrush;
    }

    private final boolean component7() {
        return this.writeable;
    }

    private final ScrollState component8() {
        return this.scrollState;
    }

    private final Orientation component9() {
        return this.orientation;
    }

    public static /* synthetic */ TextFieldCoreModifier copy$default(TextFieldCoreModifier textFieldCoreModifier, boolean z, boolean z2, TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, Brush brush, boolean z3, ScrollState scrollState2, Orientation orientation2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = textFieldCoreModifier.isFocused;
        }
        if ((i & 2) != 0) {
            z2 = textFieldCoreModifier.isDragHovered;
        }
        if ((i & 4) != 0) {
            textLayoutState2 = textFieldCoreModifier.textLayoutState;
        }
        if ((i & 8) != 0) {
            transformedTextFieldState = textFieldCoreModifier.textFieldState;
        }
        if ((i & 16) != 0) {
            textFieldSelectionState2 = textFieldCoreModifier.textFieldSelectionState;
        }
        if ((i & 32) != 0) {
            brush = textFieldCoreModifier.cursorBrush;
        }
        if ((i & 64) != 0) {
            z3 = textFieldCoreModifier.writeable;
        }
        if ((i & 128) != 0) {
            scrollState2 = textFieldCoreModifier.scrollState;
        }
        if ((i & 256) != 0) {
            orientation2 = textFieldCoreModifier.orientation;
        }
        ScrollState scrollState3 = scrollState2;
        Orientation orientation3 = orientation2;
        Brush brush2 = brush;
        boolean z4 = z3;
        TransformedTextFieldState transformedTextFieldState2 = transformedTextFieldState;
        TextFieldSelectionState textFieldSelectionState3 = textFieldSelectionState2;
        return textFieldCoreModifier.copy(z, z2, textLayoutState2, transformedTextFieldState2, textFieldSelectionState3, brush2, z4, scrollState3, orientation3);
    }

    public final TextFieldCoreModifier copy(boolean z, boolean z2, TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, Brush brush, boolean z3, ScrollState scrollState2, Orientation orientation2) {
        return new TextFieldCoreModifier(z, z2, textLayoutState2, transformedTextFieldState, textFieldSelectionState2, brush, z3, scrollState2, orientation2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldCoreModifier)) {
            return false;
        }
        TextFieldCoreModifier textFieldCoreModifier = (TextFieldCoreModifier) obj;
        return this.isFocused == textFieldCoreModifier.isFocused && this.isDragHovered == textFieldCoreModifier.isDragHovered && Intrinsics.areEqual((Object) this.textLayoutState, (Object) textFieldCoreModifier.textLayoutState) && Intrinsics.areEqual((Object) this.textFieldState, (Object) textFieldCoreModifier.textFieldState) && Intrinsics.areEqual((Object) this.textFieldSelectionState, (Object) textFieldCoreModifier.textFieldSelectionState) && Intrinsics.areEqual((Object) this.cursorBrush, (Object) textFieldCoreModifier.cursorBrush) && this.writeable == textFieldCoreModifier.writeable && Intrinsics.areEqual((Object) this.scrollState, (Object) textFieldCoreModifier.scrollState) && this.orientation == textFieldCoreModifier.orientation;
    }

    public int hashCode() {
        return (((((((((((((((Boolean.hashCode(this.isFocused) * 31) + Boolean.hashCode(this.isDragHovered)) * 31) + this.textLayoutState.hashCode()) * 31) + this.textFieldState.hashCode()) * 31) + this.textFieldSelectionState.hashCode()) * 31) + this.cursorBrush.hashCode()) * 31) + Boolean.hashCode(this.writeable)) * 31) + this.scrollState.hashCode()) * 31) + this.orientation.hashCode();
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public String toString() {
        return "TextFieldCoreModifier(isFocused=" + this.isFocused + ", isDragHovered=" + this.isDragHovered + ", textLayoutState=" + this.textLayoutState + ", textFieldState=" + this.textFieldState + ", textFieldSelectionState=" + this.textFieldSelectionState + ", cursorBrush=" + this.cursorBrush + ", writeable=" + this.writeable + ", scrollState=" + this.scrollState + ", orientation=" + this.orientation + ')';
    }

    public TextFieldCoreModifier(boolean z, boolean z2, TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, Brush brush, boolean z3, ScrollState scrollState2, Orientation orientation2) {
        this.isFocused = z;
        this.isDragHovered = z2;
        this.textLayoutState = textLayoutState2;
        this.textFieldState = transformedTextFieldState;
        this.textFieldSelectionState = textFieldSelectionState2;
        this.cursorBrush = brush;
        this.writeable = z3;
        this.scrollState = scrollState2;
        this.orientation = orientation2;
    }

    public TextFieldCoreModifierNode create() {
        return new TextFieldCoreModifierNode(this.isFocused, this.isDragHovered, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation);
    }

    public void update(TextFieldCoreModifierNode textFieldCoreModifierNode) {
        textFieldCoreModifierNode.updateNode(this.isFocused, this.isDragHovered, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation);
    }
}
