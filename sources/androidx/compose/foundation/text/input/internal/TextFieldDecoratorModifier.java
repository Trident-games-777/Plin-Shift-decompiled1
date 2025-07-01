package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0017\u001a\u00020\u0014HÂ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0019\u001a\u00020\bHÂ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÂ\u0003J\t\u0010\u001b\u001a\u00020\fHÂ\u0003J\t\u0010\u001c\u001a\u00020\fHÂ\u0003J\t\u0010\u001d\u001a\u00020\u000fHÂ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0011HÂ\u0003J\t\u0010\u001f\u001a\u00020\fHÂ\u0003Jq\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\b\u0010!\u001a\u00020\u0002H\u0016J\u0013\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0002H\u0016J\f\u0010,\u001a\u00020**\u00020-H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActionHandler", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "singleLine", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
public final class TextFieldDecoratorModifier extends ModifierNodeElement<TextFieldDecoratorModifierNode> {
    public static final int $stable = 0;
    private final boolean enabled;
    private final InputTransformation filter;
    private final MutableInteractionSource interactionSource;
    private final KeyboardActionHandler keyboardActionHandler;
    private final KeyboardOptions keyboardOptions;
    private final boolean readOnly;
    private final boolean singleLine;
    private final TextFieldSelectionState textFieldSelectionState;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;

    private final TransformedTextFieldState component1() {
        return this.textFieldState;
    }

    private final MutableInteractionSource component10() {
        return this.interactionSource;
    }

    private final TextLayoutState component2() {
        return this.textLayoutState;
    }

    private final TextFieldSelectionState component3() {
        return this.textFieldSelectionState;
    }

    private final InputTransformation component4() {
        return this.filter;
    }

    private final boolean component5() {
        return this.enabled;
    }

    private final boolean component6() {
        return this.readOnly;
    }

    private final KeyboardOptions component7() {
        return this.keyboardOptions;
    }

    private final KeyboardActionHandler component8() {
        return this.keyboardActionHandler;
    }

    private final boolean component9() {
        return this.singleLine;
    }

    public static /* synthetic */ TextFieldDecoratorModifier copy$default(TextFieldDecoratorModifier textFieldDecoratorModifier, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, TextFieldSelectionState textFieldSelectionState2, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions2, KeyboardActionHandler keyboardActionHandler2, boolean z3, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 1) != 0) {
            transformedTextFieldState = textFieldDecoratorModifier.textFieldState;
        }
        if ((i & 2) != 0) {
            textLayoutState2 = textFieldDecoratorModifier.textLayoutState;
        }
        if ((i & 4) != 0) {
            textFieldSelectionState2 = textFieldDecoratorModifier.textFieldSelectionState;
        }
        if ((i & 8) != 0) {
            inputTransformation = textFieldDecoratorModifier.filter;
        }
        if ((i & 16) != 0) {
            z = textFieldDecoratorModifier.enabled;
        }
        if ((i & 32) != 0) {
            z2 = textFieldDecoratorModifier.readOnly;
        }
        if ((i & 64) != 0) {
            keyboardOptions2 = textFieldDecoratorModifier.keyboardOptions;
        }
        if ((i & 128) != 0) {
            keyboardActionHandler2 = textFieldDecoratorModifier.keyboardActionHandler;
        }
        if ((i & 256) != 0) {
            z3 = textFieldDecoratorModifier.singleLine;
        }
        if ((i & 512) != 0) {
            mutableInteractionSource = textFieldDecoratorModifier.interactionSource;
        }
        boolean z4 = z3;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        KeyboardOptions keyboardOptions3 = keyboardOptions2;
        KeyboardActionHandler keyboardActionHandler3 = keyboardActionHandler2;
        boolean z5 = z;
        boolean z6 = z2;
        InputTransformation inputTransformation2 = inputTransformation;
        TextLayoutState textLayoutState3 = textLayoutState2;
        return textFieldDecoratorModifier.copy(transformedTextFieldState, textLayoutState3, textFieldSelectionState2, inputTransformation2, z5, z6, keyboardOptions3, keyboardActionHandler3, z4, mutableInteractionSource2);
    }

    public final TextFieldDecoratorModifier copy(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, TextFieldSelectionState textFieldSelectionState2, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions2, KeyboardActionHandler keyboardActionHandler2, boolean z3, MutableInteractionSource mutableInteractionSource) {
        return new TextFieldDecoratorModifier(transformedTextFieldState, textLayoutState2, textFieldSelectionState2, inputTransformation, z, z2, keyboardOptions2, keyboardActionHandler2, z3, mutableInteractionSource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldDecoratorModifier)) {
            return false;
        }
        TextFieldDecoratorModifier textFieldDecoratorModifier = (TextFieldDecoratorModifier) obj;
        return Intrinsics.areEqual((Object) this.textFieldState, (Object) textFieldDecoratorModifier.textFieldState) && Intrinsics.areEqual((Object) this.textLayoutState, (Object) textFieldDecoratorModifier.textLayoutState) && Intrinsics.areEqual((Object) this.textFieldSelectionState, (Object) textFieldDecoratorModifier.textFieldSelectionState) && Intrinsics.areEqual((Object) this.filter, (Object) textFieldDecoratorModifier.filter) && this.enabled == textFieldDecoratorModifier.enabled && this.readOnly == textFieldDecoratorModifier.readOnly && Intrinsics.areEqual((Object) this.keyboardOptions, (Object) textFieldDecoratorModifier.keyboardOptions) && Intrinsics.areEqual((Object) this.keyboardActionHandler, (Object) textFieldDecoratorModifier.keyboardActionHandler) && this.singleLine == textFieldDecoratorModifier.singleLine && Intrinsics.areEqual((Object) this.interactionSource, (Object) textFieldDecoratorModifier.interactionSource);
    }

    public int hashCode() {
        int hashCode = ((((this.textFieldState.hashCode() * 31) + this.textLayoutState.hashCode()) * 31) + this.textFieldSelectionState.hashCode()) * 31;
        InputTransformation inputTransformation = this.filter;
        int i = 0;
        int hashCode2 = (((((((hashCode + (inputTransformation == null ? 0 : inputTransformation.hashCode())) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.readOnly)) * 31) + this.keyboardOptions.hashCode()) * 31;
        KeyboardActionHandler keyboardActionHandler2 = this.keyboardActionHandler;
        if (keyboardActionHandler2 != null) {
            i = keyboardActionHandler2.hashCode();
        }
        return ((((hashCode2 + i) * 31) + Boolean.hashCode(this.singleLine)) * 31) + this.interactionSource.hashCode();
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public String toString() {
        return "TextFieldDecoratorModifier(textFieldState=" + this.textFieldState + ", textLayoutState=" + this.textLayoutState + ", textFieldSelectionState=" + this.textFieldSelectionState + ", filter=" + this.filter + ", enabled=" + this.enabled + ", readOnly=" + this.readOnly + ", keyboardOptions=" + this.keyboardOptions + ", keyboardActionHandler=" + this.keyboardActionHandler + ", singleLine=" + this.singleLine + ", interactionSource=" + this.interactionSource + ')';
    }

    public TextFieldDecoratorModifier(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, TextFieldSelectionState textFieldSelectionState2, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions2, KeyboardActionHandler keyboardActionHandler2, boolean z3, MutableInteractionSource mutableInteractionSource) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState2;
        this.textFieldSelectionState = textFieldSelectionState2;
        this.filter = inputTransformation;
        this.enabled = z;
        this.readOnly = z2;
        this.keyboardOptions = keyboardOptions2;
        this.keyboardActionHandler = keyboardActionHandler2;
        this.singleLine = z3;
        this.interactionSource = mutableInteractionSource;
    }

    public TextFieldDecoratorModifierNode create() {
        return new TextFieldDecoratorModifierNode(this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.filter, this.enabled, this.readOnly, this.keyboardOptions, this.keyboardActionHandler, this.singleLine, this.interactionSource);
    }

    public void update(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        textFieldDecoratorModifierNode.updateNode(this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.filter, this.enabled, this.readOnly, this.keyboardOptions, this.keyboardActionHandler, this.singleLine, this.interactionSource);
    }
}
