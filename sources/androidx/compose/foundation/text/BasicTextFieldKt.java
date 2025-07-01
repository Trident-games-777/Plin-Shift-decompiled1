package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÛ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u001728\b\u0002\u0010\u0018\u001a2\u0012\u0004\u0012\u00020\u001a\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019¢\u0006\u0002\b 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010*\u001añ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u001728\b\u0002\u0010\u0018\u001a2\u0012\u0004\u0012\u00020\u001a\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019¢\u0006\u0002\b 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010-\u001a\u00020\fH\u0001¢\u0006\u0002\u0010.\u001aâ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010=\u001aî\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010>\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010?\u001aâ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020@2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010A\u001aî\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020@2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0006022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010>\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$23\b\u0002\u0010:\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b;¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000602¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010B\u001a\u0015\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\u0010F\u001a\u0015\u0010G\u001a\u00020\u00062\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006H²\u0006\n\u0010I\u001a\u00020JX\u0002²\u0006\n\u0010K\u001a\u00020JX\u0002²\u0006\n\u0010L\u001a\u00020JX\u0002²\u0006\n\u0010M\u001a\u000200X\u0002²\u0006\n\u0010N\u001a\u00020@X\u0002"}, d2 = {"DefaultTextFieldDecorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "MinTouchTargetSizeForHandles", "Landroidx/compose/ui/unit/DpSize;", "J", "BasicTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "decorator", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "isPassword", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/runtime/Composer;III)V", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "decorationBox", "Landroidx/compose/runtime/Composable;", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "TextFieldCursorHandle", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "foundation_release", "cursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "startHandleState", "endHandleState", "textFieldValueState", "lastTextValue"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
public final class BasicTextFieldKt {
    /* access modifiers changed from: private */
    public static final TextFieldDecorator DefaultTextFieldDecorator = BasicTextFieldKt$DefaultTextFieldDecorator$1.INSTANCE;
    private static final long MinTouchTargetSizeForHandles;

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x034a  */
    /* JADX WARNING: Removed duplicated region for block: B:228:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(androidx.compose.foundation.text.input.TextFieldState r37, androidx.compose.ui.Modifier r38, boolean r39, boolean r40, androidx.compose.foundation.text.input.InputTransformation r41, androidx.compose.ui.text.TextStyle r42, androidx.compose.foundation.text.KeyboardOptions r43, androidx.compose.foundation.text.input.KeyboardActionHandler r44, androidx.compose.foundation.text.input.TextFieldLineLimits r45, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.ui.graphics.Brush r48, androidx.compose.foundation.text.input.OutputTransformation r49, androidx.compose.foundation.text.input.TextFieldDecorator r50, androidx.compose.foundation.ScrollState r51, androidx.compose.runtime.Composer r52, int r53, int r54, int r55) {
        /*
            r0 = r50
            r1 = r53
            r2 = r54
            r3 = r55
            r4 = 469439921(0x1bfb15b1, float:4.1538484E-22)
            r5 = r52
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r4)
            java.lang.String r6 = "C(BasicTextField)P(13,7,2,11,3,14,5,8,6,9,4!1,10)184@10988L21,188@11134L610:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = r3 & 1
            if (r6 == 0) goto L_0x0020
            r6 = r1 | 6
            r9 = r6
            r6 = r37
            goto L_0x0034
        L_0x0020:
            r6 = r1 & 6
            if (r6 != 0) goto L_0x0031
            r6 = r37
            boolean r9 = r5.changed((java.lang.Object) r6)
            if (r9 == 0) goto L_0x002e
            r9 = 4
            goto L_0x002f
        L_0x002e:
            r9 = 2
        L_0x002f:
            r9 = r9 | r1
            goto L_0x0034
        L_0x0031:
            r6 = r37
            r9 = r1
        L_0x0034:
            r10 = r3 & 2
            if (r10 == 0) goto L_0x003b
            r9 = r9 | 48
            goto L_0x004e
        L_0x003b:
            r13 = r1 & 48
            if (r13 != 0) goto L_0x004e
            r13 = r38
            boolean r14 = r5.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x004a
            r14 = 32
            goto L_0x004c
        L_0x004a:
            r14 = 16
        L_0x004c:
            r9 = r9 | r14
            goto L_0x0050
        L_0x004e:
            r13 = r38
        L_0x0050:
            r14 = r3 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x0059
            r9 = r9 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x0059:
            r7 = r1 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x006d
            r7 = r39
            boolean r17 = r5.changed((boolean) r7)
            if (r17 == 0) goto L_0x0068
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r17 = r16
        L_0x006a:
            r9 = r9 | r17
            goto L_0x006f
        L_0x006d:
            r7 = r39
        L_0x006f:
            r17 = r3 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x007a
            r9 = r9 | 3072(0xc00, float:4.305E-42)
            goto L_0x008e
        L_0x007a:
            r8 = r1 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x008e
            r8 = r40
            boolean r21 = r5.changed((boolean) r8)
            if (r21 == 0) goto L_0x0089
            r21 = r18
            goto L_0x008b
        L_0x0089:
            r21 = r19
        L_0x008b:
            r9 = r9 | r21
            goto L_0x0090
        L_0x008e:
            r8 = r40
        L_0x0090:
            r21 = r3 & 16
            r22 = 8192(0x2000, float:1.14794E-41)
            r23 = 16384(0x4000, float:2.2959E-41)
            if (r21 == 0) goto L_0x009b
            r9 = r9 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00af
        L_0x009b:
            r11 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x00af
            r11 = r41
            boolean r25 = r5.changed((java.lang.Object) r11)
            if (r25 == 0) goto L_0x00aa
            r25 = r23
            goto L_0x00ac
        L_0x00aa:
            r25 = r22
        L_0x00ac:
            r9 = r9 | r25
            goto L_0x00b1
        L_0x00af:
            r11 = r41
        L_0x00b1:
            r25 = r3 & 32
            r26 = 196608(0x30000, float:2.75506E-40)
            if (r25 == 0) goto L_0x00bc
            r9 = r9 | r26
            r12 = r42
            goto L_0x00cf
        L_0x00bc:
            r26 = r1 & r26
            r12 = r42
            if (r26 != 0) goto L_0x00cf
            boolean r27 = r5.changed((java.lang.Object) r12)
            if (r27 == 0) goto L_0x00cb
            r27 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cd
        L_0x00cb:
            r27 = 65536(0x10000, float:9.18355E-41)
        L_0x00cd:
            r9 = r9 | r27
        L_0x00cf:
            r27 = r3 & 64
            r28 = 1572864(0x180000, float:2.204052E-39)
            if (r27 == 0) goto L_0x00da
            r9 = r9 | r28
            r15 = r43
            goto L_0x00ed
        L_0x00da:
            r28 = r1 & r28
            r15 = r43
            if (r28 != 0) goto L_0x00ed
            boolean r29 = r5.changed((java.lang.Object) r15)
            if (r29 == 0) goto L_0x00e9
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00eb
        L_0x00e9:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x00eb:
            r9 = r9 | r29
        L_0x00ed:
            r4 = r3 & 128(0x80, float:1.794E-43)
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            if (r4 == 0) goto L_0x00f8
            r9 = r9 | r30
            r1 = r44
            goto L_0x010b
        L_0x00f8:
            r30 = r1 & r30
            r1 = r44
            if (r30 != 0) goto L_0x010b
            boolean r30 = r5.changed((java.lang.Object) r1)
            if (r30 == 0) goto L_0x0107
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0109
        L_0x0107:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x0109:
            r9 = r9 | r30
        L_0x010b:
            r1 = r3 & 256(0x100, float:3.59E-43)
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x0114
            r9 = r9 | r30
            goto L_0x012a
        L_0x0114:
            r30 = r53 & r30
            if (r30 != 0) goto L_0x012a
            r30 = r1
            r1 = r45
            boolean r31 = r5.changed((java.lang.Object) r1)
            if (r31 == 0) goto L_0x0125
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0127
        L_0x0125:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0127:
            r9 = r9 | r31
            goto L_0x012e
        L_0x012a:
            r30 = r1
            r1 = r45
        L_0x012e:
            r1 = r3 & 512(0x200, float:7.175E-43)
            r31 = 805306368(0x30000000, float:4.656613E-10)
            if (r1 == 0) goto L_0x0137
            r9 = r9 | r31
            goto L_0x014d
        L_0x0137:
            r31 = r53 & r31
            if (r31 != 0) goto L_0x014d
            r31 = r1
            r1 = r46
            boolean r32 = r5.changedInstance(r1)
            if (r32 == 0) goto L_0x0148
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014a
        L_0x0148:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014a:
            r9 = r9 | r32
            goto L_0x0151
        L_0x014d:
            r31 = r1
            r1 = r46
        L_0x0151:
            r1 = r3 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x015c
            r20 = r2 | 6
            r32 = r1
            r1 = r47
            goto L_0x0178
        L_0x015c:
            r32 = r2 & 6
            if (r32 != 0) goto L_0x0172
            r32 = r1
            r1 = r47
            boolean r33 = r5.changed((java.lang.Object) r1)
            if (r33 == 0) goto L_0x016d
            r20 = 4
            goto L_0x016f
        L_0x016d:
            r20 = 2
        L_0x016f:
            r20 = r2 | r20
            goto L_0x0178
        L_0x0172:
            r32 = r1
            r1 = r47
            r20 = r2
        L_0x0178:
            r1 = r3 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0181
            r20 = r20 | 48
            r33 = r1
            goto L_0x019b
        L_0x0181:
            r33 = r2 & 48
            if (r33 != 0) goto L_0x0197
            r33 = r1
            r1 = r48
            boolean r34 = r5.changed((java.lang.Object) r1)
            if (r34 == 0) goto L_0x0192
            r24 = 32
            goto L_0x0194
        L_0x0192:
            r24 = 16
        L_0x0194:
            r20 = r20 | r24
            goto L_0x019b
        L_0x0197:
            r33 = r1
            r1 = r48
        L_0x019b:
            r1 = r20
            r20 = r4
            r4 = r3 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x01a6
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x01bf
        L_0x01a6:
            r24 = r1
            r1 = r2 & 384(0x180, float:5.38E-43)
            if (r1 != 0) goto L_0x01bb
            r1 = r49
            boolean r26 = r5.changed((java.lang.Object) r1)
            if (r26 == 0) goto L_0x01b6
            r16 = 256(0x100, float:3.59E-43)
        L_0x01b6:
            r16 = r24 | r16
            r1 = r16
            goto L_0x01bf
        L_0x01bb:
            r1 = r49
            r1 = r24
        L_0x01bf:
            r16 = r4
            r4 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x01c8
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x01e5
        L_0x01c8:
            r24 = r1
            r1 = r2 & 3072(0xc00, float:4.305E-42)
            if (r1 != 0) goto L_0x01e3
            r1 = r2 & 4096(0x1000, float:5.74E-42)
            if (r1 != 0) goto L_0x01d7
            boolean r1 = r5.changed((java.lang.Object) r0)
            goto L_0x01db
        L_0x01d7:
            boolean r1 = r5.changedInstance(r0)
        L_0x01db:
            if (r1 == 0) goto L_0x01de
            goto L_0x01e0
        L_0x01de:
            r18 = r19
        L_0x01e0:
            r1 = r24 | r18
            goto L_0x01e5
        L_0x01e3:
            r1 = r24
        L_0x01e5:
            r0 = r2 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01fd
            r0 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r0 != 0) goto L_0x01f8
            r0 = r51
            boolean r18 = r5.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x01fa
            r22 = r23
            goto L_0x01fa
        L_0x01f8:
            r0 = r51
        L_0x01fa:
            r1 = r1 | r22
            goto L_0x01ff
        L_0x01fd:
            r0 = r51
        L_0x01ff:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r9 & r18
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x0233
            r0 = r1 & 9363(0x2493, float:1.312E-41)
            r2 = 9362(0x2492, float:1.3119E-41)
            if (r0 != r2) goto L_0x0233
            boolean r0 = r5.getSkipping()
            if (r0 != 0) goto L_0x0216
            goto L_0x0233
        L_0x0216:
            r5.skipToGroupEnd()
            r9 = r45
            r10 = r46
            r14 = r50
            r22 = r5
            r3 = r7
            r4 = r8
            r5 = r11
            r6 = r12
            r2 = r13
            r7 = r15
            r8 = r44
            r11 = r47
            r12 = r48
            r13 = r49
            r15 = r51
            goto L_0x0344
        L_0x0233:
            r5.startDefaults()
            r0 = r53 & 1
            if (r0 == 0) goto L_0x0260
            boolean r0 = r5.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0241
            goto L_0x0260
        L_0x0241:
            r5.skipToGroupEnd()
            r0 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x024c
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r0
        L_0x024c:
            r17 = r45
            r18 = r46
            r16 = r48
            r0 = r49
            r19 = r50
            r20 = r51
            r10 = r12
            r14 = r15
            r12 = r44
            r15 = r47
            goto L_0x02e7
        L_0x0260:
            if (r10 == 0) goto L_0x0267
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r13 = r0
        L_0x0267:
            r0 = 1
            if (r14 == 0) goto L_0x026b
            r7 = r0
        L_0x026b:
            r2 = 0
            if (r17 == 0) goto L_0x026f
            r8 = r2
        L_0x026f:
            r10 = 0
            if (r21 == 0) goto L_0x0273
            r11 = r10
        L_0x0273:
            if (r25 == 0) goto L_0x027b
            androidx.compose.ui.text.TextStyle$Companion r12 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r12 = r12.getDefault()
        L_0x027b:
            if (r27 == 0) goto L_0x0284
            androidx.compose.foundation.text.KeyboardOptions$Companion r14 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r14 = r14.getDefault()
            goto L_0x0285
        L_0x0284:
            r14 = r15
        L_0x0285:
            if (r20 == 0) goto L_0x0289
            r15 = r10
            goto L_0x028b
        L_0x0289:
            r15 = r44
        L_0x028b:
            if (r30 == 0) goto L_0x0294
            androidx.compose.foundation.text.input.TextFieldLineLimits$Companion r17 = androidx.compose.foundation.text.input.TextFieldLineLimits.Companion
            androidx.compose.foundation.text.input.TextFieldLineLimits r17 = r17.getDefault()
            goto L_0x0296
        L_0x0294:
            r17 = r45
        L_0x0296:
            if (r31 == 0) goto L_0x029b
            r18 = r10
            goto L_0x029d
        L_0x029b:
            r18 = r46
        L_0x029d:
            if (r32 == 0) goto L_0x02a2
            r19 = r10
            goto L_0x02a4
        L_0x02a2:
            r19 = r47
        L_0x02a4:
            if (r33 == 0) goto L_0x02af
            androidx.compose.foundation.text.BasicTextFieldDefaults r20 = androidx.compose.foundation.text.BasicTextFieldDefaults.INSTANCE
            androidx.compose.ui.graphics.SolidColor r20 = r20.getCursorBrush()
            androidx.compose.ui.graphics.Brush r20 = (androidx.compose.ui.graphics.Brush) r20
            goto L_0x02b1
        L_0x02af:
            r20 = r48
        L_0x02b1:
            if (r16 == 0) goto L_0x02b6
            r16 = r10
            goto L_0x02b8
        L_0x02b6:
            r16 = r49
        L_0x02b8:
            if (r4 == 0) goto L_0x02bb
            goto L_0x02bd
        L_0x02bb:
            r10 = r50
        L_0x02bd:
            r4 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x02da
            androidx.compose.foundation.ScrollState r0 = androidx.compose.foundation.ScrollKt.rememberScrollState(r2, r5, r2, r0)
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
            r36 = r20
            r20 = r0
            r0 = r16
            r16 = r36
            r36 = r19
            r19 = r10
            r10 = r12
            r12 = r15
            r15 = r36
            goto L_0x02e7
        L_0x02da:
            r0 = r19
            r19 = r10
            r10 = r12
            r12 = r15
            r15 = r0
            r0 = r16
            r16 = r20
            r20 = r51
        L_0x02e7:
            r5.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x02f8
            java.lang.String r2 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:187)"
            r4 = 469439921(0x1bfb15b1, float:4.1538484E-22)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r9, r1, r2)
        L_0x02f8:
            r2 = 2147483646(0x7ffffffe, float:NaN)
            r23 = r9 & r2
            r2 = r1 & 14
            r2 = r2 | 384(0x180, float:5.38E-43)
            r4 = r1 & 112(0x70, float:1.57E-43)
            r2 = r2 | r4
            int r1 = r1 << 3
            r4 = r1 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r1
            r2 = r2 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r4
            r24 = r2 | r1
            r25 = 65536(0x10000, float:9.18355E-41)
            r6 = r13
            r13 = r17
            r17 = 0
            r21 = 0
            r22 = r5
            r9 = r11
            r11 = r14
            r14 = r18
            r5 = r37
            r18 = r0
            BasicTextField(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0332
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0332:
            r2 = r6
            r3 = r7
            r4 = r8
            r5 = r9
            r6 = r10
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            r11 = r15
            r12 = r16
            r13 = r18
            r14 = r19
            r15 = r20
        L_0x0344:
            androidx.compose.runtime.ScopeUpdateScope r0 = r22.endRestartGroup()
            if (r0 == 0) goto L_0x0361
            r1 = r0
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1
            r16 = r53
            r17 = r54
            r18 = r55
            r35 = r1
            r1 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r35
            r1.updateScope(r0)
        L_0x0361:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.foundation.text.input.TextFieldState, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.input.KeyboardActionHandler, androidx.compose.foundation.text.input.TextFieldLineLimits, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text.input.OutputTransformation, androidx.compose.foundation.text.input.TextFieldDecorator, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x0777  */
    /* JADX WARNING: Removed duplicated region for block: B:349:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(androidx.compose.foundation.text.input.TextFieldState r43, androidx.compose.ui.Modifier r44, boolean r45, boolean r46, androidx.compose.foundation.text.input.InputTransformation r47, androidx.compose.ui.text.TextStyle r48, androidx.compose.foundation.text.KeyboardOptions r49, androidx.compose.foundation.text.input.KeyboardActionHandler r50, androidx.compose.foundation.text.input.TextFieldLineLimits r51, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r52, androidx.compose.foundation.interaction.MutableInteractionSource r53, androidx.compose.ui.graphics.Brush r54, androidx.compose.foundation.text.input.internal.CodepointTransformation r55, androidx.compose.foundation.text.input.OutputTransformation r56, androidx.compose.foundation.text.input.TextFieldDecorator r57, androidx.compose.foundation.ScrollState r58, boolean r59, androidx.compose.runtime.Composer r60, int r61, int r62, int r63) {
        /*
            r1 = r43
            r0 = r57
            r2 = r61
            r3 = r62
            r4 = r63
            r5 = 965149429(0x398702f5, float:2.575141E-4)
            r6 = r60
            androidx.compose.runtime.Composer r5 = r6.startRestartGroup(r5)
            java.lang.String r6 = "C(BasicTextField)P(15,9,3,13,4,16,7,10,8,11,5,1!1,12!1,14)234@12943L21,239@13149L7,240@13204L7,241@13249L7,247@13619L25,248@13693L25,251@13806L797,271@14801L48,273@14885L357,284@15295L7,285@15359L7,286@15413L7,287@15436L520,287@15425L531,303@16004L83,303@15962L125,342@17504L3096:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = r4 & 1
            if (r6 == 0) goto L_0x001f
            r6 = r2 | 6
            goto L_0x002f
        L_0x001f:
            r6 = r2 & 6
            if (r6 != 0) goto L_0x002e
            boolean r6 = r5.changed((java.lang.Object) r1)
            if (r6 == 0) goto L_0x002b
            r6 = 4
            goto L_0x002c
        L_0x002b:
            r6 = 2
        L_0x002c:
            r6 = r6 | r2
            goto L_0x002f
        L_0x002e:
            r6 = r2
        L_0x002f:
            r9 = r4 & 2
            if (r9 == 0) goto L_0x0036
            r6 = r6 | 48
            goto L_0x0049
        L_0x0036:
            r12 = r2 & 48
            if (r12 != 0) goto L_0x0049
            r12 = r44
            boolean r13 = r5.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0045
            r13 = 32
            goto L_0x0047
        L_0x0045:
            r13 = 16
        L_0x0047:
            r6 = r6 | r13
            goto L_0x004b
        L_0x0049:
            r12 = r44
        L_0x004b:
            r13 = r4 & 4
            if (r13 == 0) goto L_0x0052
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0052:
            r10 = r2 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x0066
            r10 = r45
            boolean r16 = r5.changed((boolean) r10)
            if (r16 == 0) goto L_0x0061
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r6 = r6 | r16
            goto L_0x0068
        L_0x0066:
            r10 = r45
        L_0x0068:
            r16 = r4 & 8
            r17 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0071
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x0071:
            r14 = r2 & 3072(0xc00, float:4.305E-42)
            if (r14 != 0) goto L_0x0085
            r14 = r46
            boolean r20 = r5.changed((boolean) r14)
            if (r20 == 0) goto L_0x0080
            r20 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r20 = r17
        L_0x0082:
            r6 = r6 | r20
            goto L_0x0087
        L_0x0085:
            r14 = r46
        L_0x0087:
            r20 = r4 & 16
            if (r20 == 0) goto L_0x008e
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008e:
            r8 = r2 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x00a2
            r8 = r47
            boolean r21 = r5.changed((java.lang.Object) r8)
            if (r21 == 0) goto L_0x009d
            r21 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r21 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r6 = r6 | r21
            goto L_0x00a4
        L_0x00a2:
            r8 = r47
        L_0x00a4:
            r21 = r4 & 32
            r22 = 196608(0x30000, float:2.75506E-40)
            if (r21 == 0) goto L_0x00af
            r6 = r6 | r22
            r11 = r48
            goto L_0x00c2
        L_0x00af:
            r22 = r2 & r22
            r11 = r48
            if (r22 != 0) goto L_0x00c2
            boolean r23 = r5.changed((java.lang.Object) r11)
            if (r23 == 0) goto L_0x00be
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r23 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r6 = r6 | r23
        L_0x00c2:
            r23 = r4 & 64
            r24 = 1572864(0x180000, float:2.204052E-39)
            if (r23 == 0) goto L_0x00cd
            r6 = r6 | r24
            r15 = r49
            goto L_0x00e0
        L_0x00cd:
            r25 = r2 & r24
            r15 = r49
            if (r25 != 0) goto L_0x00e0
            boolean r26 = r5.changed((java.lang.Object) r15)
            if (r26 == 0) goto L_0x00dc
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r6 = r6 | r26
        L_0x00e0:
            r7 = r4 & 128(0x80, float:1.794E-43)
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            if (r7 == 0) goto L_0x00eb
            r6 = r6 | r27
            r2 = r50
            goto L_0x00fe
        L_0x00eb:
            r27 = r2 & r27
            r2 = r50
            if (r27 != 0) goto L_0x00fe
            boolean r27 = r5.changed((java.lang.Object) r2)
            if (r27 == 0) goto L_0x00fa
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fc
        L_0x00fa:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fc:
            r6 = r6 | r27
        L_0x00fe:
            r2 = r4 & 256(0x100, float:3.59E-43)
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            if (r2 == 0) goto L_0x0107
            r6 = r6 | r27
            goto L_0x011d
        L_0x0107:
            r27 = r61 & r27
            if (r27 != 0) goto L_0x011d
            r27 = r2
            r2 = r51
            boolean r28 = r5.changed((java.lang.Object) r2)
            if (r28 == 0) goto L_0x0118
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011a
        L_0x0118:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011a:
            r6 = r6 | r28
            goto L_0x0121
        L_0x011d:
            r27 = r2
            r2 = r51
        L_0x0121:
            r2 = r4 & 512(0x200, float:7.175E-43)
            r28 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x012a
            r6 = r6 | r28
            goto L_0x0140
        L_0x012a:
            r28 = r61 & r28
            if (r28 != 0) goto L_0x0140
            r28 = r2
            r2 = r52
            boolean r29 = r5.changedInstance(r2)
            if (r29 == 0) goto L_0x013b
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013d
        L_0x013b:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013d:
            r6 = r6 | r29
            goto L_0x0144
        L_0x0140:
            r28 = r2
            r2 = r52
        L_0x0144:
            r2 = r4 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0151
            r29 = r3 | 6
            r30 = r29
            r29 = r2
            r2 = r53
            goto L_0x016d
        L_0x0151:
            r29 = r3 & 6
            if (r29 != 0) goto L_0x0167
            r29 = r2
            r2 = r53
            boolean r30 = r5.changed((java.lang.Object) r2)
            if (r30 == 0) goto L_0x0162
            r30 = 4
            goto L_0x0164
        L_0x0162:
            r30 = 2
        L_0x0164:
            r30 = r3 | r30
            goto L_0x016d
        L_0x0167:
            r29 = r2
            r2 = r53
            r30 = r3
        L_0x016d:
            r2 = r4 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0176
            r30 = r30 | 48
            r31 = r2
            goto L_0x0190
        L_0x0176:
            r31 = r3 & 48
            if (r31 != 0) goto L_0x018c
            r31 = r2
            r2 = r54
            boolean r32 = r5.changed((java.lang.Object) r2)
            if (r32 == 0) goto L_0x0187
            r18 = 32
            goto L_0x0189
        L_0x0187:
            r18 = 16
        L_0x0189:
            r30 = r30 | r18
            goto L_0x0190
        L_0x018c:
            r31 = r2
            r2 = r54
        L_0x0190:
            r2 = r30
            r18 = r7
            r7 = r4 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x019b
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x01b7
        L_0x019b:
            r30 = r2
            r2 = r3 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x01b3
            r2 = r55
            boolean r32 = r5.changed((java.lang.Object) r2)
            if (r32 == 0) goto L_0x01ac
            r19 = 256(0x100, float:3.59E-43)
            goto L_0x01ae
        L_0x01ac:
            r19 = 128(0x80, float:1.794E-43)
        L_0x01ae:
            r19 = r30 | r19
            r2 = r19
            goto L_0x01b7
        L_0x01b3:
            r2 = r55
            r2 = r30
        L_0x01b7:
            r19 = r7
            r7 = r4 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x01c0
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x01d9
        L_0x01c0:
            r30 = r2
            r2 = r3 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x01d5
            r2 = r56
            boolean r32 = r5.changed((java.lang.Object) r2)
            if (r32 == 0) goto L_0x01d0
            r17 = 2048(0x800, float:2.87E-42)
        L_0x01d0:
            r17 = r30 | r17
            r2 = r17
            goto L_0x01d9
        L_0x01d5:
            r2 = r56
            r2 = r30
        L_0x01d9:
            r17 = r7
            r7 = r4 & 16384(0x4000, float:2.2959E-41)
            r30 = 32768(0x8000, float:4.5918E-41)
            if (r7 == 0) goto L_0x01e5
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0204
        L_0x01e5:
            r32 = r2
            r2 = r3 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x0202
            r2 = r3 & r30
            if (r2 != 0) goto L_0x01f4
            boolean r2 = r5.changed((java.lang.Object) r0)
            goto L_0x01f8
        L_0x01f4:
            boolean r2 = r5.changedInstance(r0)
        L_0x01f8:
            if (r2 == 0) goto L_0x01fd
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x01ff
        L_0x01fd:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x01ff:
            r2 = r32 | r2
            goto L_0x0204
        L_0x0202:
            r2 = r32
        L_0x0204:
            r32 = 196608(0x30000, float:2.75506E-40)
            r32 = r3 & r32
            if (r32 != 0) goto L_0x021e
            r32 = r4 & r30
            r0 = r58
            if (r32 != 0) goto L_0x0219
            boolean r32 = r5.changed((java.lang.Object) r0)
            if (r32 == 0) goto L_0x0219
            r32 = 131072(0x20000, float:1.83671E-40)
            goto L_0x021b
        L_0x0219:
            r32 = 65536(0x10000, float:9.18355E-41)
        L_0x021b:
            r2 = r2 | r32
            goto L_0x0220
        L_0x021e:
            r0 = r58
        L_0x0220:
            r32 = 65536(0x10000, float:9.18355E-41)
            r32 = r4 & r32
            if (r32 == 0) goto L_0x022b
            r2 = r2 | r24
            r0 = r59
            goto L_0x023e
        L_0x022b:
            r24 = r3 & r24
            r0 = r59
            if (r24 != 0) goto L_0x023e
            boolean r24 = r5.changed((boolean) r0)
            if (r24 == 0) goto L_0x023a
            r24 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023c
        L_0x023a:
            r24 = 524288(0x80000, float:7.34684E-40)
        L_0x023c:
            r2 = r2 | r24
        L_0x023e:
            r24 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r6 & r24
            r60 = r2
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x027b
            r0 = 599187(0x92493, float:8.3964E-40)
            r0 = r60 & r0
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r2) goto L_0x027b
            boolean r0 = r5.getSkipping()
            if (r0 != 0) goto L_0x025b
            goto L_0x027b
        L_0x025b:
            r5.skipToGroupEnd()
            r9 = r51
            r13 = r55
            r16 = r58
            r17 = r59
            r0 = r5
            r5 = r8
            r3 = r10
            r6 = r11
            r2 = r12
            r4 = r14
            r7 = r15
            r8 = r50
            r10 = r52
            r11 = r53
            r12 = r54
            r14 = r56
            r15 = r57
            goto L_0x0771
        L_0x027b:
            r5.startDefaults()
            r0 = r61 & 1
            r2 = 1
            if (r0 == 0) goto L_0x02c5
            boolean r0 = r5.getDefaultsInvalid()
            if (r0 == 0) goto L_0x028a
            goto L_0x02c5
        L_0x028a:
            r5.skipToGroupEnd()
            r0 = r4 & r30
            if (r0 == 0) goto L_0x02ad
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r60 & r0
            r9 = r51
            r13 = r52
            r16 = r53
            r18 = r54
            r19 = r55
            r7 = r56
            r17 = r57
            r20 = r58
            r21 = r59
            r2 = r0
            r0 = r50
            goto L_0x034b
        L_0x02ad:
            r0 = r50
            r9 = r51
            r13 = r52
            r16 = r53
            r18 = r54
            r19 = r55
            r7 = r56
            r17 = r57
            r20 = r58
            r21 = r59
            r2 = r60
            goto L_0x034b
        L_0x02c5:
            if (r9 == 0) goto L_0x02cc
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r12 = r0
        L_0x02cc:
            if (r13 == 0) goto L_0x02cf
            r10 = r2
        L_0x02cf:
            if (r16 == 0) goto L_0x02d2
            r14 = 0
        L_0x02d2:
            if (r20 == 0) goto L_0x02d5
            r8 = 0
        L_0x02d5:
            if (r21 == 0) goto L_0x02de
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r11 = r0
        L_0x02de:
            if (r23 == 0) goto L_0x02e7
            androidx.compose.foundation.text.KeyboardOptions$Companion r0 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r0 = r0.getDefault()
            r15 = r0
        L_0x02e7:
            if (r18 == 0) goto L_0x02eb
            r0 = 0
            goto L_0x02ed
        L_0x02eb:
            r0 = r50
        L_0x02ed:
            if (r27 == 0) goto L_0x02f6
            androidx.compose.foundation.text.input.TextFieldLineLimits$Companion r9 = androidx.compose.foundation.text.input.TextFieldLineLimits.Companion
            androidx.compose.foundation.text.input.TextFieldLineLimits r9 = r9.getDefault()
            goto L_0x02f8
        L_0x02f6:
            r9 = r51
        L_0x02f8:
            if (r28 == 0) goto L_0x02fc
            r13 = 0
            goto L_0x02fe
        L_0x02fc:
            r13 = r52
        L_0x02fe:
            if (r29 == 0) goto L_0x0303
            r16 = 0
            goto L_0x0305
        L_0x0303:
            r16 = r53
        L_0x0305:
            if (r31 == 0) goto L_0x0310
            androidx.compose.foundation.text.BasicTextFieldDefaults r18 = androidx.compose.foundation.text.BasicTextFieldDefaults.INSTANCE
            androidx.compose.ui.graphics.SolidColor r18 = r18.getCursorBrush()
            androidx.compose.ui.graphics.Brush r18 = (androidx.compose.ui.graphics.Brush) r18
            goto L_0x0312
        L_0x0310:
            r18 = r54
        L_0x0312:
            if (r19 == 0) goto L_0x0317
            r19 = 0
            goto L_0x0319
        L_0x0317:
            r19 = r55
        L_0x0319:
            if (r17 == 0) goto L_0x031e
            r17 = 0
            goto L_0x0320
        L_0x031e:
            r17 = r56
        L_0x0320:
            if (r7 == 0) goto L_0x0324
            r7 = 0
            goto L_0x0326
        L_0x0324:
            r7 = r57
        L_0x0326:
            r20 = r4 & r30
            r44 = r0
            if (r20 == 0) goto L_0x0337
            r0 = 0
            androidx.compose.foundation.ScrollState r20 = androidx.compose.foundation.ScrollKt.rememberScrollState(r0, r5, r0, r2)
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r60 & r0
            goto L_0x033b
        L_0x0337:
            r20 = r58
            r0 = r60
        L_0x033b:
            r2 = r17
            r17 = r7
            r7 = r2
            if (r32 == 0) goto L_0x0346
            r2 = r0
            r21 = 0
            goto L_0x0349
        L_0x0346:
            r21 = r59
            r2 = r0
        L_0x0349:
            r0 = r44
        L_0x034b:
            r5.endDefaults()
            boolean r27 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r55 = r0
            if (r27 == 0) goto L_0x035e
            r0 = 965149429(0x398702f5, float:2.575141E-4)
            java.lang.String r3 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:238)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r2, r3)
        L_0x035e:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r4)
            java.lang.Object r0 = r5.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r27 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r47 = r0
            r0 = r27
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r4)
            java.lang.Object r0 = r5.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            androidx.compose.runtime.ProvidableCompositionLocal r27 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalWindowInfo()
            r48 = r10
            r10 = r27
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r4)
            java.lang.Object r10 = r5.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.WindowInfo r10 = (androidx.compose.ui.platform.WindowInfo) r10
            androidx.compose.foundation.text.input.TextFieldLineLimits$SingleLine r3 = androidx.compose.foundation.text.input.TextFieldLineLimits.SingleLine.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r3)
            r59 = r3
            java.lang.String r3 = "CC(remember):BasicTextField.kt#9igjgp"
            r27 = r9
            if (r16 != 0) goto L_0x03e0
            r9 = 96938805(0x5c72b35, float:1.8729742E-35)
            r5.startReplaceGroup(r9)
            java.lang.String r9 = "245@13454L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r9)
            r9 = -1243798931(0xffffffffb5dd226d, float:-1.6475802E-6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r3)
            java.lang.Object r9 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r28 = androidx.compose.runtime.Composer.Companion
            r44 = r10
            java.lang.Object r10 = r28.getEmpty()
            if (r9 != r10) goto L_0x03d5
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r5.updateRememberedValue(r9)
        L_0x03d5:
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = (androidx.compose.foundation.interaction.MutableInteractionSource) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r5.endReplaceGroup()
            r39 = r9
            goto L_0x03ed
        L_0x03e0:
            r44 = r10
            r9 = -1243799582(0xffffffffb5dd1fe2, float:-1.6475062E-6)
            r5.startReplaceGroup(r9)
            r5.endReplaceGroup()
            r39 = r16
        L_0x03ed:
            if (r59 == 0) goto L_0x03f2
            androidx.compose.foundation.gestures.Orientation r9 = androidx.compose.foundation.gestures.Orientation.Horizontal
            goto L_0x03f4
        L_0x03f2:
            androidx.compose.foundation.gestures.Orientation r9 = androidx.compose.foundation.gestures.Orientation.Vertical
        L_0x03f4:
            r10 = r39
            androidx.compose.foundation.interaction.InteractionSource r10 = (androidx.compose.foundation.interaction.InteractionSource) r10
            r56 = r11
            r11 = 0
            androidx.compose.runtime.State r28 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r10, r5, r11)
            java.lang.Object r28 = r28.getValue()
            java.lang.Boolean r28 = (java.lang.Boolean) r28
            boolean r28 = r28.booleanValue()
            androidx.compose.runtime.State r10 = androidx.compose.foundation.interaction.HoverInteractionKt.collectIsHoveredAsState(r10, r5, r11)
            java.lang.Object r10 = r10.getValue()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            boolean r11 = r44.isWindowFocused()
            r57 = r10
            r10 = -1243786909(0xffffffffb5dd5163, float:-1.648947E-6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r3)
            r10 = r6 & 14
            r58 = r11
            r11 = 4
            if (r10 != r11) goto L_0x042c
            r10 = 1
            goto L_0x042d
        L_0x042c:
            r10 = 0
        L_0x042d:
            r11 = r2 & 896(0x380, float:1.256E-42)
            r44 = r10
            r10 = 256(0x100, float:3.59E-43)
            if (r11 != r10) goto L_0x0437
            r10 = 1
            goto L_0x0438
        L_0x0437:
            r10 = 0
        L_0x0438:
            r10 = r44 | r10
            r11 = r2 & 7168(0x1c00, float:1.0045E-41)
            r26 = r2
            r2 = 2048(0x800, float:2.87E-42)
            if (r11 != r2) goto L_0x0444
            r2 = 1
            goto L_0x0445
        L_0x0444:
            r2 = 0
        L_0x0445:
            r2 = r2 | r10
            java.lang.Object r10 = r5.rememberedValue()
            if (r2 != 0) goto L_0x0454
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r10 != r2) goto L_0x0469
        L_0x0454:
            if (r19 != 0) goto L_0x045f
            androidx.compose.foundation.text.input.internal.SingleLineCodepointTransformation r2 = androidx.compose.foundation.text.input.internal.SingleLineCodepointTransformation.INSTANCE
            if (r59 == 0) goto L_0x045b
            goto L_0x045c
        L_0x045b:
            r2 = 0
        L_0x045c:
            androidx.compose.foundation.text.input.internal.CodepointTransformation r2 = (androidx.compose.foundation.text.input.internal.CodepointTransformation) r2
            goto L_0x0461
        L_0x045f:
            r2 = r19
        L_0x0461:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r10 = new androidx.compose.foundation.text.input.internal.TransformedTextFieldState
            r10.<init>(r1, r8, r2, r7)
            r5.updateRememberedValue(r10)
        L_0x0469:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r10 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r2 = -1243755818(0xffffffffb5ddcad6, float:-1.6524816E-6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r3)
            boolean r2 = r5.changed((java.lang.Object) r10)
            java.lang.Object r11 = r5.rememberedValue()
            if (r2 != 0) goto L_0x0486
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r11 != r2) goto L_0x048e
        L_0x0486:
            androidx.compose.foundation.text.input.internal.TextLayoutState r11 = new androidx.compose.foundation.text.input.internal.TextLayoutState
            r11.<init>()
            r5.updateRememberedValue(r11)
        L_0x048e:
            androidx.compose.foundation.text.input.internal.TextLayoutState r11 = (androidx.compose.foundation.text.input.internal.TextLayoutState) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r2 = -1243752821(0xffffffffb5ddd68b, float:-1.6528223E-6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r3)
            boolean r2 = r5.changed((java.lang.Object) r10)
            java.lang.Object r1 = r5.rememberedValue()
            if (r2 != 0) goto L_0x04b5
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x04ac
            goto L_0x04b5
        L_0x04ac:
            r2 = r47
            r29 = r21
            r21 = r14
            r14 = r48
            goto L_0x04de
        L_0x04b5:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r1 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState
            if (r28 == 0) goto L_0x04be
            if (r58 == 0) goto L_0x04be
            r50 = 1
            goto L_0x04c0
        L_0x04be:
            r50 = 0
        L_0x04c0:
            r44 = r1
            r45 = r10
            r46 = r11
            r49 = r14
            r51 = r21
            r44.<init>(r45, r46, r47, r48, r49, r50, r51)
            r1 = r44
            r10 = r45
            r11 = r46
            r2 = r47
            r14 = r48
            r21 = r49
            r29 = r51
            r5.updateRememberedValue(r1)
        L_0x04de:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r1 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ProvidableCompositionLocal r30 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalHapticFeedback()
            r31 = r7
            r7 = r30
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r46 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r8, r4)
            java.lang.Object r7 = r5.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.hapticfeedback.HapticFeedback r7 = (androidx.compose.ui.hapticfeedback.HapticFeedback) r7
            androidx.compose.runtime.ProvidableCompositionLocal r30 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalClipboardManager()
            r60 = r11
            r11 = r30
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r8, r4)
            java.lang.Object r11 = r5.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.ClipboardManager r11 = (androidx.compose.ui.platform.ClipboardManager) r11
            androidx.compose.runtime.ProvidableCompositionLocal r30 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextToolbar()
            r32 = r13
            r13 = r30
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r8, r4)
            java.lang.Object r4 = r5.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.TextToolbar r4 = (androidx.compose.ui.platform.TextToolbar) r4
            r8 = -1243735026(0xffffffffb5de1c0e, float:-1.6548454E-6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r8, r3)
            boolean r8 = r5.changed((java.lang.Object) r10)
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r6
            r44 = r8
            r8 = 16384(0x4000, float:2.2959E-41)
            if (r13 != r8) goto L_0x0540
            r8 = 1
            goto L_0x0541
        L_0x0540:
            r8 = 0
        L_0x0541:
            r8 = r44 | r8
            boolean r13 = r5.changedInstance(r1)
            r8 = r8 | r13
            boolean r13 = r5.changedInstance(r7)
            r8 = r8 | r13
            boolean r13 = r5.changedInstance(r11)
            r8 = r8 | r13
            boolean r13 = r5.changedInstance(r4)
            r8 = r8 | r13
            boolean r13 = r5.changed((java.lang.Object) r2)
            r8 = r8 | r13
            r13 = r6 & 896(0x380, float:1.256E-42)
            r47 = r1
            r1 = 256(0x100, float:3.59E-43)
            if (r13 != r1) goto L_0x0566
            r1 = 1
            goto L_0x0567
        L_0x0566:
            r1 = 0
        L_0x0567:
            r1 = r1 | r8
            r8 = r6 & 7168(0x1c00, float:1.0045E-41)
            r13 = 2048(0x800, float:2.87E-42)
            if (r8 != r13) goto L_0x0570
            r8 = 1
            goto L_0x0571
        L_0x0570:
            r8 = 0
        L_0x0571:
            r1 = r1 | r8
            r8 = 3670016(0x380000, float:5.142788E-39)
            r8 = r26 & r8
            r13 = 1048576(0x100000, float:1.469368E-39)
            if (r8 != r13) goto L_0x057c
            r8 = 1
            goto L_0x057d
        L_0x057c:
            r8 = 0
        L_0x057d:
            r1 = r1 | r8
            java.lang.Object r8 = r5.rememberedValue()
            if (r1 != 0) goto L_0x0593
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r8 != r1) goto L_0x058d
            goto L_0x0593
        L_0x058d:
            r1 = r47
            r2 = r8
            r8 = r46
            goto L_0x05b5
        L_0x0593:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$2$1 r1 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$2$1
            r44 = r1
            r51 = r2
            r50 = r4
            r48 = r7
            r45 = r10
            r49 = r11
            r52 = r14
            r53 = r21
            r54 = r29
            r44.<init>(r45, r46, r47, r48, r49, r50, r51, r52, r53, r54)
            r2 = r44
            r8 = r46
            r1 = r47
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r5.updateRememberedValue(r2)
        L_0x05b5:
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r11 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r2, r5, r11)
            r2 = -1243717287(0xffffffffb5de6159, float:-1.6568621E-6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r3)
            boolean r2 = r5.changedInstance(r1)
            java.lang.Object r3 = r5.rememberedValue()
            if (r2 != 0) goto L_0x05d6
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x05e1
        L_0x05d6:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1 r2 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
            r2.<init>(r1)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r5.updateRememberedValue(r3)
        L_0x05e1:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r11 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r3, (androidx.compose.runtime.Composer) r5, (int) r11)
            androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier r2 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier
            r52 = r55
            r53 = r59
            r46 = r60
            r47 = r1
            r44 = r2
            r48 = r8
            r45 = r10
            r49 = r14
            r51 = r15
            r50 = r21
            r54 = r39
            r44.<init>(r45, r46, r47, r48, r49, r50, r51, r52, r53, r54)
            r4 = r44
            r11 = r46
            r3 = r47
            r7 = r52
            r1 = r53
            r2 = r54
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.ui.Modifier r4 = r12.then(r4)
            androidx.compose.ui.Modifier r33 = androidx.compose.foundation.FocusableKt.focusable(r4, r14, r2)
            r34 = r20
            androidx.compose.foundation.gestures.ScrollableState r34 = (androidx.compose.foundation.gestures.ScrollableState) r34
            if (r14 == 0) goto L_0x062c
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$InputType r4 = r3.getDirectDragGestureInitiator()
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$InputType r13 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.InputType.None
            if (r4 != r13) goto L_0x062c
            r36 = 1
            goto L_0x062e
        L_0x062c:
            r36 = 0
        L_0x062e:
            androidx.compose.foundation.gestures.ScrollableDefaults r4 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r13 = 0
            boolean r37 = r4.reverseDirection(r0, r9, r13)
            r40 = 16
            r41 = 0
            r38 = 0
            r39 = r2
            r35 = r9
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.gestures.ScrollableKt.scrollable$default(r33, r34, r35, r36, r37, r38, r39, r40, r41)
            androidx.compose.ui.input.pointer.PointerIcon r2 = androidx.compose.foundation.text.TextPointerIcon_androidKt.getTextPointerIcon()
            r4 = 2
            r9 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.input.pointer.PointerIconKt.pointerHoverIcon$default(r0, r2, r13, r4, r9)
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r4 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r4)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            r4 = 1
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r2, r4)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r9 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r9)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r13)
            androidx.compose.runtime.CompositionLocalMap r9 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r5, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            r59 = r1
            r1 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r47 = r3
            java.lang.String r3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r1, r3)
            androidx.compose.runtime.Applier r1 = r5.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x0691
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0691:
            r5.startReusableNode()
            boolean r1 = r5.getInserting()
            if (r1 == 0) goto L_0x069e
            r5.createNode(r13)
            goto L_0x06a1
        L_0x069e:
            r5.useNode()
        L_0x06a1:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m3675constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r2, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r9, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            boolean r3 = r1.getInserting()
            if (r3 != 0) goto L_0x06d1
            java.lang.Object r3 = r1.rememberedValue()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r9)
            if (r3 != 0) goto L_0x06df
        L_0x06d1:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r1.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r1.apply(r3, r2)
        L_0x06df:
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r0, r2)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r1 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 1236622543(0x49b55ccf, float:1485721.9)
            java.lang.String r1 = "C343@17621L2973,343@17571L3023:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r1)
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
            r53 = r47
            r48 = r56
            r51 = r57
            r50 = r58
            r44 = r0
            r52 = r10
            r47 = r11
            r55 = r14
            r45 = r17
            r54 = r18
            r57 = r20
            r56 = r21
            r46 = r27
            r49 = r28
            r60 = r32
            r58 = r35
            r44.<init>(r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60)
            r2 = r45
            r11 = r48
            r1 = r53
            r3 = 54
            r4 = -673241599(0xffffffffd7df2601, float:-4.90708637E14)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r9, r0, r5, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r3 = r6 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 384(0x180, float:5.38E-43)
            androidx.compose.foundation.text.ContextMenu_androidKt.ContextMenuArea(r1, r14, r0, r5, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r5.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0757
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0757:
            r0 = r5
            r5 = r8
            r6 = r11
            r3 = r14
            r11 = r16
            r13 = r19
            r16 = r20
            r4 = r21
            r9 = r27
            r17 = r29
            r14 = r31
            r10 = r32
            r8 = r7
            r7 = r15
            r15 = r2
            r2 = r12
            r12 = r18
        L_0x0771:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x078e
            r1 = r0
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5
            r18 = r61
            r19 = r62
            r20 = r63
            r42 = r1
            r1 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r42
            r1.updateScope(r0)
        L_0x078e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.foundation.text.input.TextFieldState, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.input.KeyboardActionHandler, androidx.compose.foundation.text.input.TextFieldLineLimits, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text.input.internal.CodepointTransformation, androidx.compose.foundation.text.input.OutputTransformation, androidx.compose.foundation.text.input.TextFieldDecorator, androidx.compose.foundation.ScrollState, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void TextFieldCursorHandle(TextFieldSelectionState textFieldSelectionState, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1991581797);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle)416@20789L124:BasicTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1991581797, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (BasicTextField.kt:414)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -425876736, "CC(remember):BasicTextField.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new BasicTextFieldKt$TextFieldCursorHandle$cursorHandleState$2$1(textFieldSelectionState));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (TextFieldCursorHandle$lambda$9((State) rememberedValue).getVisible()) {
                startRestartGroup.startReplaceGroup(-317108348);
                ComposerKt.sourceInformation(startRestartGroup, "423@21002L142,429@21224L87,422@20959L426");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -425869902, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(textFieldSelectionState);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new BasicTextFieldKt$TextFieldCursorHandle$1$1(textFieldSelectionState);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -425862853, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance2 = startRestartGroup.changedInstance(textFieldSelectionState);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new BasicTextFieldKt$TextFieldCursorHandle$2$1(textFieldSelectionState, (Continuation<? super BasicTextFieldKt$TextFieldCursorHandle$2$1>) null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                AndroidCursorHandle_androidKt.m1153CursorHandleUSBMPiE(offsetProvider, SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) textFieldSelectionState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue3), MinTouchTargetSizeForHandles, startRestartGroup, 384, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-316683586);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTextFieldKt$TextFieldCursorHandle$3(textFieldSelectionState, i));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: androidx.compose.foundation.text.selection.OffsetProvider} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: androidx.compose.foundation.text.selection.OffsetProvider} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextFieldSelectionHandles(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r12, androidx.compose.runtime.Composer r13, int r14) {
        /*
            r0 = 2025287684(0x78b77004, float:2.9764446E34)
            androidx.compose.runtime.Composer r8 = r13.startRestartGroup(r0)
            java.lang.String r13 = "C(TextFieldSelectionHandles)442@21589L149,465@22467L150:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r13)
            r13 = r14 & 6
            r1 = 2
            if (r13 != 0) goto L_0x001c
            boolean r13 = r8.changedInstance(r12)
            if (r13 == 0) goto L_0x0019
            r13 = 4
            goto L_0x001a
        L_0x0019:
            r13 = r1
        L_0x001a:
            r13 = r13 | r14
            goto L_0x001d
        L_0x001c:
            r13 = r14
        L_0x001d:
            r2 = r13 & 3
            if (r2 != r1) goto L_0x002d
            boolean r1 = r8.getSkipping()
            if (r1 != 0) goto L_0x0028
            goto L_0x002d
        L_0x0028:
            r8.skipToGroupEnd()
            goto L_0x01b7
        L_0x002d:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0039
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:440)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r1, r2)
        L_0x0039:
            r13 = -1983345958(0xffffffff89c88ada, float:-4.8278824E-33)
            java.lang.String r0 = "CC(remember):BasicTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r13, r0)
            java.lang.Object r13 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r13 != r1) goto L_0x005b
            androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$startHandleState$2$1 r13 = new androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$startHandleState$2$1
            r13.<init>(r12)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            androidx.compose.runtime.State r13 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r13)
            r8.updateRememberedValue(r13)
        L_0x005b:
            androidx.compose.runtime.State r13 = (androidx.compose.runtime.State) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r1 = TextFieldSelectionHandles$lambda$13(r13)
            boolean r1 = r1.getVisible()
            r11 = 0
            if (r1 == 0) goto L_0x00ec
            r1 = -1353986043(0xffffffffaf4bd005, float:-1.8536646E-10)
            r8.startReplaceGroup(r1)
            java.lang.String r1 = "449@21829L167,457@22207L86,448@21783L584"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = -1983338260(0xffffffff89c8a8ec, float:-4.8307102E-33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r0)
            boolean r1 = r8.changedInstance(r12)
            java.lang.Object r2 = r8.rememberedValue()
            if (r1 != 0) goto L_0x008e
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0099
        L_0x008e:
            androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$1$1 r1 = new androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$1$1
            r1.<init>(r12)
            r2 = r1
            androidx.compose.foundation.text.selection.OffsetProvider r2 = (androidx.compose.foundation.text.selection.OffsetProvider) r2
            r8.updateRememberedValue(r2)
        L_0x0099:
            r1 = r2
            androidx.compose.foundation.text.selection.OffsetProvider r1 = (androidx.compose.foundation.text.selection.OffsetProvider) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r2 = TextFieldSelectionHandles$lambda$13(r13)
            androidx.compose.ui.text.style.ResolvedTextDirection r3 = r2.getDirection()
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r13 = TextFieldSelectionHandles$lambda$13(r13)
            boolean r4 = r13.getHandlesCrossed()
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            r2 = -1983326245(0xffffffff89c8d7db, float:-4.8351238E-33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r0)
            boolean r2 = r8.changedInstance(r12)
            java.lang.Object r5 = r8.rememberedValue()
            if (r2 != 0) goto L_0x00cb
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r5 != r2) goto L_0x00d6
        L_0x00cb:
            androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$2$1 r2 = new androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$2$1
            r2.<init>(r12, r11)
            r5 = r2
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r8.updateRememberedValue(r5)
        L_0x00d6:
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r13, (java.lang.Object) r12, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r5)
            long r5 = MinTouchTargetSizeForHandles
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 0
            r2 = 1
            androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.m1553SelectionHandlepzduO1o(r1, r2, r3, r4, r5, r7, r8, r9, r10)
            r8.endReplaceGroup()
            goto L_0x00f5
        L_0x00ec:
            r13 = -1353409443(0xffffffffaf549c5d, float:-1.9336839E-10)
            r8.startReplaceGroup(r13)
            r8.endReplaceGroup()
        L_0x00f5:
            r13 = -1983317861(0xffffffff89c8f89b, float:-4.8382036E-33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r13, r0)
            java.lang.Object r13 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r13 != r1) goto L_0x0115
            androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$endHandleState$2$1 r13 = new androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$endHandleState$2$1
            r13.<init>(r12)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            androidx.compose.runtime.State r13 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r13)
            r8.updateRememberedValue(r13)
        L_0x0115:
            androidx.compose.runtime.State r13 = (androidx.compose.runtime.State) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r1 = TextFieldSelectionHandles$lambda$17(r13)
            boolean r1 = r1.getVisible()
            if (r1 == 0) goto L_0x01a5
            r1 = -1353116090(0xffffffffaf591646, float:-1.9743948E-10)
            r8.startReplaceGroup(r1)
            java.lang.String r1 = "472@22706L168,480@23082L87,471@22660L583"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = -1983310195(0xffffffff89c9168d, float:-4.8410197E-33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r0)
            boolean r1 = r8.changedInstance(r12)
            java.lang.Object r2 = r8.rememberedValue()
            if (r1 != 0) goto L_0x0147
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0152
        L_0x0147:
            androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$3$1 r1 = new androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$3$1
            r1.<init>(r12)
            r2 = r1
            androidx.compose.foundation.text.selection.OffsetProvider r2 = (androidx.compose.foundation.text.selection.OffsetProvider) r2
            r8.updateRememberedValue(r2)
        L_0x0152:
            r1 = r2
            androidx.compose.foundation.text.selection.OffsetProvider r1 = (androidx.compose.foundation.text.selection.OffsetProvider) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r2 = TextFieldSelectionHandles$lambda$17(r13)
            androidx.compose.ui.text.style.ResolvedTextDirection r3 = r2.getDirection()
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r13 = TextFieldSelectionHandles$lambda$17(r13)
            boolean r4 = r13.getHandlesCrossed()
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            r2 = -1983298244(0xffffffff89c9453c, float:-4.8454098E-33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r0)
            boolean r0 = r8.changedInstance(r12)
            java.lang.Object r2 = r8.rememberedValue()
            if (r0 != 0) goto L_0x0184
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x018f
        L_0x0184:
            androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$4$1 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$4$1
            r0.<init>(r12, r11)
            r2 = r0
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r8.updateRememberedValue(r2)
        L_0x018f:
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r13, (java.lang.Object) r12, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r2)
            long r5 = MinTouchTargetSizeForHandles
            r9 = 24624(0x6030, float:3.4506E-41)
            r10 = 0
            r2 = 0
            androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.m1553SelectionHandlepzduO1o(r1, r2, r3, r4, r5, r7, r8, r9, r10)
            r8.endReplaceGroup()
            goto L_0x01ae
        L_0x01a5:
            r13 = -1352540451(0xffffffffaf61dedd, float:-2.0542808E-10)
            r8.startReplaceGroup(r13)
            r8.endReplaceGroup()
        L_0x01ae:
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x01b7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b7:
            androidx.compose.runtime.ScopeUpdateScope r13 = r8.endRestartGroup()
            if (r13 == 0) goto L_0x01c7
            androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$5 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$5
            r0.<init>(r12, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x01c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.TextFieldSelectionHandles(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, androidx.compose.runtime.Composer, int):void");
    }

    static {
        float f = (float) 40;
        MinTouchTargetSizeForHandles = DpKt.m7133DpSizeYgX7TsA(Dp.m7111constructorimpl(f), Dp.m7111constructorimpl(f));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:235:0x03b3, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x03b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x04a4  */
    /* JADX WARNING: Removed duplicated region for block: B:271:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(java.lang.String r36, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r37, androidx.compose.ui.Modifier r38, boolean r39, boolean r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.KeyboardActions r43, boolean r44, int r45, int r46, androidx.compose.ui.text.input.VisualTransformation r47, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r48, androidx.compose.foundation.interaction.MutableInteractionSource r49, androidx.compose.ui.graphics.Brush r50, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, int r53, int r54, int r55) {
        /*
            r1 = r36
            r2 = r37
            r0 = r53
            r3 = r54
            r4 = r55
            r5 = 945255183(0x3857730f, float:5.136715E-5)
            r6 = r52
            androidx.compose.runtime.Composer r6 = r6.startRestartGroup(r5)
            java.lang.String r7 = "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)614@31167L57,620@31520L216,620@31509L227,629@32057L41,633@32175L373,631@32104L1032:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r7)
            r7 = r4 & 1
            if (r7 == 0) goto L_0x001f
            r7 = r0 | 6
            goto L_0x002f
        L_0x001f:
            r7 = r0 & 6
            if (r7 != 0) goto L_0x002e
            boolean r7 = r6.changed((java.lang.Object) r1)
            if (r7 == 0) goto L_0x002b
            r7 = 4
            goto L_0x002c
        L_0x002b:
            r7 = 2
        L_0x002c:
            r7 = r7 | r0
            goto L_0x002f
        L_0x002e:
            r7 = r0
        L_0x002f:
            r10 = r4 & 2
            if (r10 == 0) goto L_0x0036
            r7 = r7 | 48
            goto L_0x0046
        L_0x0036:
            r10 = r0 & 48
            if (r10 != 0) goto L_0x0046
            boolean r10 = r6.changedInstance(r2)
            if (r10 == 0) goto L_0x0043
            r10 = 32
            goto L_0x0045
        L_0x0043:
            r10 = 16
        L_0x0045:
            r7 = r7 | r10
        L_0x0046:
            r10 = r4 & 4
            if (r10 == 0) goto L_0x004d
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004d:
            r15 = r0 & 384(0x180, float:5.38E-43)
            if (r15 != 0) goto L_0x0061
            r15 = r38
            boolean r16 = r6.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x005c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r7 = r7 | r16
            goto L_0x0063
        L_0x0061:
            r15 = r38
        L_0x0063:
            r16 = r4 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x006e
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006e:
            r11 = r0 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0082
            r11 = r39
            boolean r19 = r6.changed((boolean) r11)
            if (r19 == 0) goto L_0x007d
            r19 = r17
            goto L_0x007f
        L_0x007d:
            r19 = r18
        L_0x007f:
            r7 = r7 | r19
            goto L_0x0084
        L_0x0082:
            r11 = r39
        L_0x0084:
            r19 = r4 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x008f
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x008f:
            r13 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x00a3
            r13 = r40
            boolean r23 = r6.changed((boolean) r13)
            if (r23 == 0) goto L_0x009e
            r23 = r20
            goto L_0x00a0
        L_0x009e:
            r23 = r21
        L_0x00a0:
            r7 = r7 | r23
            goto L_0x00a5
        L_0x00a3:
            r13 = r40
        L_0x00a5:
            r23 = r4 & 32
            r24 = 196608(0x30000, float:2.75506E-40)
            if (r23 == 0) goto L_0x00b0
            r7 = r7 | r24
            r14 = r41
            goto L_0x00c3
        L_0x00b0:
            r25 = r0 & r24
            r14 = r41
            if (r25 != 0) goto L_0x00c3
            boolean r26 = r6.changed((java.lang.Object) r14)
            if (r26 == 0) goto L_0x00bf
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r7 = r7 | r26
        L_0x00c3:
            r26 = r4 & 64
            r27 = 1572864(0x180000, float:2.204052E-39)
            if (r26 == 0) goto L_0x00ce
            r7 = r7 | r27
            r12 = r42
            goto L_0x00e1
        L_0x00ce:
            r27 = r0 & r27
            r12 = r42
            if (r27 != 0) goto L_0x00e1
            boolean r28 = r6.changed((java.lang.Object) r12)
            if (r28 == 0) goto L_0x00dd
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r7 = r7 | r28
        L_0x00e1:
            r8 = r4 & 128(0x80, float:1.794E-43)
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            if (r8 == 0) goto L_0x00ec
            r7 = r7 | r29
            r9 = r43
            goto L_0x00ff
        L_0x00ec:
            r29 = r0 & r29
            r9 = r43
            if (r29 != 0) goto L_0x00ff
            boolean r30 = r6.changed((java.lang.Object) r9)
            if (r30 == 0) goto L_0x00fb
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fd
        L_0x00fb:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fd:
            r7 = r7 | r30
        L_0x00ff:
            r5 = r4 & 256(0x100, float:3.59E-43)
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            if (r5 == 0) goto L_0x010a
            r7 = r7 | r31
            r0 = r44
            goto L_0x011d
        L_0x010a:
            r31 = r0 & r31
            r0 = r44
            if (r31 != 0) goto L_0x011d
            boolean r31 = r6.changed((boolean) r0)
            if (r31 == 0) goto L_0x0119
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011b
        L_0x0119:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011b:
            r7 = r7 | r31
        L_0x011d:
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r31 = r53 & r31
            if (r31 != 0) goto L_0x0139
            r0 = r4 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0132
            r0 = r45
            boolean r31 = r6.changed((int) r0)
            if (r31 == 0) goto L_0x0134
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0136
        L_0x0132:
            r0 = r45
        L_0x0134:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0136:
            r7 = r7 | r31
            goto L_0x013b
        L_0x0139:
            r0 = r45
        L_0x013b:
            r0 = r4 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0148
            r31 = r3 | 6
            r32 = r31
            r31 = r0
            r0 = r46
            goto L_0x0164
        L_0x0148:
            r31 = r3 & 6
            if (r31 != 0) goto L_0x015e
            r31 = r0
            r0 = r46
            boolean r32 = r6.changed((int) r0)
            if (r32 == 0) goto L_0x0159
            r32 = 4
            goto L_0x015b
        L_0x0159:
            r32 = 2
        L_0x015b:
            r32 = r3 | r32
            goto L_0x0164
        L_0x015e:
            r31 = r0
            r0 = r46
            r32 = r3
        L_0x0164:
            r0 = r4 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x016d
            r32 = r32 | 48
            r33 = r0
            goto L_0x0187
        L_0x016d:
            r33 = r3 & 48
            if (r33 != 0) goto L_0x0183
            r33 = r0
            r0 = r47
            boolean r34 = r6.changed((java.lang.Object) r0)
            if (r34 == 0) goto L_0x017e
            r34 = 32
            goto L_0x0180
        L_0x017e:
            r34 = 16
        L_0x0180:
            r32 = r32 | r34
            goto L_0x0187
        L_0x0183:
            r33 = r0
            r0 = r47
        L_0x0187:
            r0 = r32
            r1 = r4 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0190
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01ac
        L_0x0190:
            r32 = r0
            r0 = r3 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01a8
            r0 = r48
            boolean r34 = r6.changedInstance(r0)
            if (r34 == 0) goto L_0x01a1
            r22 = 256(0x100, float:3.59E-43)
            goto L_0x01a3
        L_0x01a1:
            r22 = 128(0x80, float:1.794E-43)
        L_0x01a3:
            r22 = r32 | r22
            r0 = r22
            goto L_0x01ac
        L_0x01a8:
            r0 = r48
            r0 = r32
        L_0x01ac:
            r22 = r1
            r1 = r4 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x01b5
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01cf
        L_0x01b5:
            r25 = r0
            r0 = r3 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01cb
            r0 = r49
            boolean r32 = r6.changed((java.lang.Object) r0)
            if (r32 == 0) goto L_0x01c4
            goto L_0x01c6
        L_0x01c4:
            r17 = r18
        L_0x01c6:
            r17 = r25 | r17
            r0 = r17
            goto L_0x01cf
        L_0x01cb:
            r0 = r49
            r0 = r25
        L_0x01cf:
            r17 = r1
            r1 = r4 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x01da
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r18 = r0
            goto L_0x01ee
        L_0x01da:
            r18 = r0
            r0 = r3 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01ee
            r0 = r50
            boolean r25 = r6.changed((java.lang.Object) r0)
            if (r25 == 0) goto L_0x01e9
            goto L_0x01eb
        L_0x01e9:
            r20 = r21
        L_0x01eb:
            r18 = r18 | r20
            goto L_0x01f0
        L_0x01ee:
            r0 = r50
        L_0x01f0:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r4 & r20
            if (r20 == 0) goto L_0x01fa
            r18 = r18 | r24
            goto L_0x020d
        L_0x01fa:
            r21 = r3 & r24
            r0 = r51
            if (r21 != 0) goto L_0x020d
            boolean r21 = r6.changedInstance(r0)
            if (r21 == 0) goto L_0x0209
            r21 = 131072(0x20000, float:1.83671E-40)
            goto L_0x020b
        L_0x0209:
            r21 = 65536(0x10000, float:9.18355E-41)
        L_0x020b:
            r18 = r18 | r21
        L_0x020d:
            r0 = r18
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r21 = r1
            r1 = r7 & r18
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r3) goto L_0x0248
            r1 = 74899(0x12493, float:1.04956E-40)
            r1 = r1 & r0
            r3 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r3) goto L_0x0248
            boolean r1 = r6.getSkipping()
            if (r1 != 0) goto L_0x022b
            goto L_0x0248
        L_0x022b:
            r6.skipToGroupEnd()
            r10 = r45
            r16 = r51
            r22 = r6
            r8 = r9
            r4 = r11
            r7 = r12
            r5 = r13
            r6 = r14
            r3 = r15
            r9 = r44
            r11 = r46
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            goto L_0x049e
        L_0x0248:
            r6.startDefaults()
            r1 = r53 & 1
            r18 = 1
            if (r1 == 0) goto L_0x027f
            boolean r1 = r6.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0258
            goto L_0x027f
        L_0x0258:
            r6.skipToGroupEnd()
            r1 = r4 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0263
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r7 = r7 & r1
        L_0x0263:
            r1 = r18
            r18 = r9
            r9 = r14
            r14 = r1
            r3 = r44
            r4 = r45
            r5 = r46
            r10 = r47
            r16 = r48
            r21 = r51
            r1 = r12
            r20 = r13
            r8 = r15
            r12 = r49
            r13 = r50
            goto L_0x0327
        L_0x027f:
            if (r10 == 0) goto L_0x0286
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r15 = r1
        L_0x0286:
            if (r16 == 0) goto L_0x028a
            r11 = r18
        L_0x028a:
            if (r19 == 0) goto L_0x028d
            r13 = 0
        L_0x028d:
            if (r23 == 0) goto L_0x0296
            androidx.compose.ui.text.TextStyle$Companion r1 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r1 = r1.getDefault()
            r14 = r1
        L_0x0296:
            if (r26 == 0) goto L_0x029f
            androidx.compose.foundation.text.KeyboardOptions$Companion r1 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r1 = r1.getDefault()
            r12 = r1
        L_0x029f:
            if (r8 == 0) goto L_0x02a8
            androidx.compose.foundation.text.KeyboardActions$Companion r1 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r1 = r1.getDefault()
            goto L_0x02a9
        L_0x02a8:
            r1 = r9
        L_0x02a9:
            if (r5 == 0) goto L_0x02ad
            r5 = 0
            goto L_0x02af
        L_0x02ad:
            r5 = r44
        L_0x02af:
            r8 = r4 & 512(0x200, float:7.175E-43)
            if (r8 == 0) goto L_0x02c0
            if (r5 == 0) goto L_0x02b8
            r8 = r18
            goto L_0x02bb
        L_0x02b8:
            r8 = 2147483647(0x7fffffff, float:NaN)
        L_0x02bb:
            r9 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r7 = r7 & r9
            goto L_0x02c2
        L_0x02c0:
            r8 = r45
        L_0x02c2:
            if (r31 == 0) goto L_0x02c7
            r9 = r18
            goto L_0x02c9
        L_0x02c7:
            r9 = r46
        L_0x02c9:
            if (r33 == 0) goto L_0x02d2
            androidx.compose.ui.text.input.VisualTransformation$Companion r10 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r10 = r10.getNone()
            goto L_0x02d4
        L_0x02d2:
            r10 = r47
        L_0x02d4:
            if (r22 == 0) goto L_0x02db
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6 r16 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6.INSTANCE
            kotlin.jvm.functions.Function1 r16 = (kotlin.jvm.functions.Function1) r16
            goto L_0x02dd
        L_0x02db:
            r16 = r48
        L_0x02dd:
            if (r17 == 0) goto L_0x02e2
            r17 = 0
            goto L_0x02e4
        L_0x02e2:
            r17 = r49
        L_0x02e4:
            if (r21 == 0) goto L_0x02fa
            androidx.compose.ui.graphics.SolidColor r3 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r21 = androidx.compose.ui.graphics.Color.Companion
            r38 = r5
            long r4 = r21.m4265getBlack0d7_KjU()
            r39 = r1
            r1 = 0
            r3.<init>(r4, r1)
            r1 = r3
            androidx.compose.ui.graphics.Brush r1 = (androidx.compose.ui.graphics.Brush) r1
            goto L_0x0300
        L_0x02fa:
            r39 = r1
            r38 = r5
            r1 = r50
        L_0x0300:
            if (r20 == 0) goto L_0x0315
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r3 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r3 = r3.m1176getLambda1$foundation_release()
            r21 = r3
            r4 = r8
            r5 = r9
            r20 = r13
            r9 = r14
            r8 = r15
            r14 = r18
            r3 = r38
            goto L_0x0321
        L_0x0315:
            r3 = r38
            r21 = r51
            r4 = r8
            r5 = r9
            r20 = r13
            r9 = r14
            r8 = r15
            r14 = r18
        L_0x0321:
            r18 = r39
            r13 = r1
            r1 = r12
            r12 = r17
        L_0x0327:
            r6.endDefaults()
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x0338
            java.lang.String r15 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:611)"
            r14 = 945255183(0x3857730f, float:5.136715E-5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r7, r0, r15)
        L_0x0338:
            r14 = -1243232097(0xffffffffb5e5c89f, float:-1.7120218E-6)
            java.lang.String r15 = "CC(remember):BasicTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r14, r15)
            java.lang.Object r14 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r22 = r0
            java.lang.Object r0 = r17.getEmpty()
            if (r14 != r0) goto L_0x0373
            androidx.compose.ui.text.input.TextFieldValue r0 = new androidx.compose.ui.text.input.TextFieldValue
            r14 = 6
            r17 = 0
            r23 = 0
            r25 = 0
            r39 = r36
            r38 = r0
            r43 = r14
            r44 = r17
            r40 = r23
            r42 = r25
            r38.<init>((java.lang.String) r39, (long) r40, (androidx.compose.ui.text.TextRange) r42, (int) r43, (kotlin.jvm.internal.DefaultConstructorMarker) r44)
            r46 = r4
            r4 = 0
            r14 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r4, r14, r4)
            r6.updateRememberedValue(r0)
            r14 = r0
            goto L_0x0375
        L_0x0373:
            r46 = r4
        L_0x0375:
            androidx.compose.runtime.MutableState r14 = (androidx.compose.runtime.MutableState) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.text.input.TextFieldValue r0 = BasicTextField$lambda$21(r14)
            r4 = 6
            r17 = 0
            r23 = 0
            r25 = 0
            r39 = r36
            r38 = r0
            r43 = r4
            r44 = r17
            r40 = r23
            r42 = r25
            androidx.compose.ui.text.input.TextFieldValue r0 = androidx.compose.ui.text.input.TextFieldValue.m6819copy3r_uNRQ$default((androidx.compose.ui.text.input.TextFieldValue) r38, (java.lang.String) r39, (long) r40, (androidx.compose.ui.text.TextRange) r42, (int) r43, (java.lang.Object) r44)
            r4 = r39
            r38 = r5
            r5 = -1243220642(0xffffffffb5e5f55e, float:-1.7133241E-6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r5, r15)
            boolean r5 = r6.changed((java.lang.Object) r0)
            r39 = r5
            java.lang.Object r5 = r6.rememberedValue()
            if (r39 != 0) goto L_0x03b6
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r39 = r8
            java.lang.Object r8 = r17.getEmpty()
            if (r5 != r8) goto L_0x03c2
            goto L_0x03b8
        L_0x03b6:
            r39 = r8
        L_0x03b8:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1 r5 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
            r5.<init>(r0, r14)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r6.updateRememberedValue(r5)
        L_0x03c2:
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r8 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r5, r6, r8)
            r5 = -1243203633(0xffffffffb5e637cf, float:-1.7152578E-6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r5, r15)
            r5 = r7 & 14
            r8 = 4
            if (r5 != r8) goto L_0x03d8
            r5 = 1
            goto L_0x03d9
        L_0x03d8:
            r5 = 0
        L_0x03d9:
            java.lang.Object r8 = r6.rememberedValue()
            if (r5 != 0) goto L_0x03e7
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r8 != r5) goto L_0x03f0
        L_0x03e7:
            r5 = 2
            r8 = 0
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r8, r5, r8)
            r6.updateRememberedValue(r8)
        L_0x03f0:
            androidx.compose.runtime.MutableState r8 = (androidx.compose.runtime.MutableState) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.text.input.ImeOptions r17 = r1.toImeOptions$foundation_release(r3)
            r5 = r3 ^ 1
            r19 = r11
            r11 = r16
            if (r3 == 0) goto L_0x0404
            r16 = 1
            goto L_0x0406
        L_0x0404:
            r16 = r38
        L_0x0406:
            if (r3 == 0) goto L_0x040b
            r23 = 1
            goto L_0x040d
        L_0x040b:
            r23 = r46
        L_0x040d:
            r40 = r0
            r0 = -1243199525(0xffffffffb5e647db, float:-1.7157248E-6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r15)
            boolean r0 = r6.changed((java.lang.Object) r8)
            r15 = r7 & 112(0x70, float:1.57E-43)
            r41 = r0
            r0 = 32
            if (r15 != r0) goto L_0x0423
            r0 = 1
            goto L_0x0424
        L_0x0423:
            r0 = 0
        L_0x0424:
            r0 = r41 | r0
            java.lang.Object r15 = r6.rememberedValue()
            if (r0 != 0) goto L_0x0434
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r15 != r0) goto L_0x043f
        L_0x0434:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
            r0.<init>(r2, r14, r8)
            r15 = r0
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r6.updateRememberedValue(r15)
        L_0x043f:
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r0 = r7 & 896(0x380, float:1.256E-42)
            int r8 = r7 >> 6
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r8
            int r8 = r22 << 9
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r8
            r0 = r0 | r14
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r8
            r0 = r0 | r14
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r8
            r0 = r0 | r14
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            r8 = r8 & r14
            r0 = r0 | r8
            int r8 = r7 >> 15
            r8 = r8 & 896(0x380, float:1.256E-42)
            r14 = r7 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | r14
            r14 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r14
            r7 = r7 | r8
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r22 & r8
            r24 = r7 | r8
            r25 = 0
            r8 = r39
            r14 = r5
            r22 = r6
            r7 = r15
            r15 = r23
            r6 = r40
            r23 = r0
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x048a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x048a:
            r7 = r1
            r6 = r9
            r14 = r12
            r15 = r13
            r4 = r19
            r5 = r20
            r16 = r21
            r9 = r3
            r3 = r8
            r12 = r10
            r13 = r11
            r8 = r18
            r11 = r38
            r10 = r46
        L_0x049e:
            androidx.compose.runtime.ScopeUpdateScope r0 = r22.endRestartGroup()
            if (r0 == 0) goto L_0x04bb
            r1 = r0
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9
            r17 = r53
            r18 = r54
            r19 = r55
            r35 = r1
            r1 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r35
            r1.updateScope(r0)
        L_0x04bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final TextFieldValue BasicTextField$lambda$21(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final String BasicTextField$lambda$25(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:254:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(androidx.compose.ui.text.input.TextFieldValue r37, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, boolean r40, boolean r41, androidx.compose.ui.text.TextStyle r42, androidx.compose.foundation.text.KeyboardOptions r43, androidx.compose.foundation.text.KeyboardActions r44, boolean r45, int r46, int r47, androidx.compose.ui.text.input.VisualTransformation r48, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, androidx.compose.ui.graphics.Brush r51, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, androidx.compose.runtime.Composer r53, int r54, int r55, int r56) {
        /*
            r0 = r37
            r1 = r38
            r2 = r54
            r3 = r55
            r4 = r56
            r5 = 1804514146(0x6b8eb362, float:3.4502916E26)
            r6 = r53
            androidx.compose.runtime.Composer r6 = r6.startRestartGroup(r5)
            java.lang.String r7 = "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)766@39969L90,764@39907L740:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r7)
            r7 = r4 & 1
            if (r7 == 0) goto L_0x001f
            r7 = r2 | 6
            goto L_0x002f
        L_0x001f:
            r7 = r2 & 6
            if (r7 != 0) goto L_0x002e
            boolean r7 = r6.changed((java.lang.Object) r0)
            if (r7 == 0) goto L_0x002b
            r7 = 4
            goto L_0x002c
        L_0x002b:
            r7 = 2
        L_0x002c:
            r7 = r7 | r2
            goto L_0x002f
        L_0x002e:
            r7 = r2
        L_0x002f:
            r10 = r4 & 2
            if (r10 == 0) goto L_0x0036
            r7 = r7 | 48
            goto L_0x0046
        L_0x0036:
            r10 = r2 & 48
            if (r10 != 0) goto L_0x0046
            boolean r10 = r6.changedInstance(r1)
            if (r10 == 0) goto L_0x0043
            r10 = 32
            goto L_0x0045
        L_0x0043:
            r10 = 16
        L_0x0045:
            r7 = r7 | r10
        L_0x0046:
            r10 = r4 & 4
            if (r10 == 0) goto L_0x004d
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004d:
            r15 = r2 & 384(0x180, float:5.38E-43)
            if (r15 != 0) goto L_0x0061
            r15 = r39
            boolean r16 = r6.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x005c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r7 = r7 | r16
            goto L_0x0063
        L_0x0061:
            r15 = r39
        L_0x0063:
            r16 = r4 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x006e
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006e:
            r8 = r2 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0082
            r8 = r40
            boolean r19 = r6.changed((boolean) r8)
            if (r19 == 0) goto L_0x007d
            r19 = r17
            goto L_0x007f
        L_0x007d:
            r19 = r18
        L_0x007f:
            r7 = r7 | r19
            goto L_0x0084
        L_0x0082:
            r8 = r40
        L_0x0084:
            r19 = r4 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x008f
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x008f:
            r11 = r2 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x00a3
            r11 = r41
            boolean r23 = r6.changed((boolean) r11)
            if (r23 == 0) goto L_0x009e
            r23 = r20
            goto L_0x00a0
        L_0x009e:
            r23 = r21
        L_0x00a0:
            r7 = r7 | r23
            goto L_0x00a5
        L_0x00a3:
            r11 = r41
        L_0x00a5:
            r23 = r4 & 32
            r24 = 65536(0x10000, float:9.18355E-41)
            r25 = 196608(0x30000, float:2.75506E-40)
            if (r23 == 0) goto L_0x00b2
            r7 = r7 | r25
            r13 = r42
            goto L_0x00c5
        L_0x00b2:
            r26 = r2 & r25
            r13 = r42
            if (r26 != 0) goto L_0x00c5
            boolean r27 = r6.changed((java.lang.Object) r13)
            if (r27 == 0) goto L_0x00c1
            r27 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r27 = r24
        L_0x00c3:
            r7 = r7 | r27
        L_0x00c5:
            r27 = r4 & 64
            r28 = 1572864(0x180000, float:2.204052E-39)
            if (r27 == 0) goto L_0x00d0
            r7 = r7 | r28
            r14 = r43
            goto L_0x00e3
        L_0x00d0:
            r28 = r2 & r28
            r14 = r43
            if (r28 != 0) goto L_0x00e3
            boolean r29 = r6.changed((java.lang.Object) r14)
            if (r29 == 0) goto L_0x00df
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r7 = r7 | r29
        L_0x00e3:
            r12 = r4 & 128(0x80, float:1.794E-43)
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            if (r12 == 0) goto L_0x00ee
            r7 = r7 | r30
            r9 = r44
            goto L_0x0101
        L_0x00ee:
            r30 = r2 & r30
            r9 = r44
            if (r30 != 0) goto L_0x0101
            boolean r31 = r6.changed((java.lang.Object) r9)
            if (r31 == 0) goto L_0x00fd
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ff
        L_0x00fd:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ff:
            r7 = r7 | r31
        L_0x0101:
            r5 = r4 & 256(0x100, float:3.59E-43)
            r32 = 100663296(0x6000000, float:2.4074124E-35)
            if (r5 == 0) goto L_0x010c
            r7 = r7 | r32
            r2 = r45
            goto L_0x011f
        L_0x010c:
            r32 = r2 & r32
            r2 = r45
            if (r32 != 0) goto L_0x011f
            boolean r32 = r6.changed((boolean) r2)
            if (r32 == 0) goto L_0x011b
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011d
        L_0x011b:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011d:
            r7 = r7 | r32
        L_0x011f:
            r32 = 805306368(0x30000000, float:4.656613E-10)
            r32 = r54 & r32
            if (r32 != 0) goto L_0x013b
            r2 = r4 & 512(0x200, float:7.175E-43)
            if (r2 != 0) goto L_0x0134
            r2 = r46
            boolean r32 = r6.changed((int) r2)
            if (r32 == 0) goto L_0x0136
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0138
        L_0x0134:
            r2 = r46
        L_0x0136:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0138:
            r7 = r7 | r32
            goto L_0x013d
        L_0x013b:
            r2 = r46
        L_0x013d:
            r2 = r4 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x014a
            r32 = r3 | 6
            r33 = r32
            r32 = r2
            r2 = r47
            goto L_0x0166
        L_0x014a:
            r32 = r3 & 6
            if (r32 != 0) goto L_0x0160
            r32 = r2
            r2 = r47
            boolean r33 = r6.changed((int) r2)
            if (r33 == 0) goto L_0x015b
            r33 = 4
            goto L_0x015d
        L_0x015b:
            r33 = 2
        L_0x015d:
            r33 = r3 | r33
            goto L_0x0166
        L_0x0160:
            r32 = r2
            r2 = r47
            r33 = r3
        L_0x0166:
            r2 = r4 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x016f
            r33 = r33 | 48
            r34 = r2
            goto L_0x0189
        L_0x016f:
            r34 = r3 & 48
            if (r34 != 0) goto L_0x0185
            r34 = r2
            r2 = r48
            boolean r35 = r6.changed((java.lang.Object) r2)
            if (r35 == 0) goto L_0x0180
            r22 = 32
            goto L_0x0182
        L_0x0180:
            r22 = 16
        L_0x0182:
            r33 = r33 | r22
            goto L_0x0189
        L_0x0185:
            r34 = r2
            r2 = r48
        L_0x0189:
            r2 = r33
            r22 = r5
            r5 = r4 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x0194
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x01b0
        L_0x0194:
            r33 = r2
            r2 = r3 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x01ac
            r2 = r49
            boolean r35 = r6.changedInstance(r2)
            if (r35 == 0) goto L_0x01a5
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x01a7
        L_0x01a5:
            r28 = 128(0x80, float:1.794E-43)
        L_0x01a7:
            r26 = r33 | r28
            r2 = r26
            goto L_0x01b0
        L_0x01ac:
            r2 = r49
            r2 = r33
        L_0x01b0:
            r26 = r5
            r5 = r4 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01b9
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x01d3
        L_0x01b9:
            r28 = r2
            r2 = r3 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x01cf
            r2 = r50
            boolean r33 = r6.changed((java.lang.Object) r2)
            if (r33 == 0) goto L_0x01c8
            goto L_0x01ca
        L_0x01c8:
            r17 = r18
        L_0x01ca:
            r17 = r28 | r17
            r2 = r17
            goto L_0x01d3
        L_0x01cf:
            r2 = r50
            r2 = r28
        L_0x01d3:
            r17 = r5
            r5 = r4 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x01de
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r18 = r2
            goto L_0x01f2
        L_0x01de:
            r18 = r2
            r2 = r3 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x01f2
            r2 = r51
            boolean r28 = r6.changed((java.lang.Object) r2)
            if (r28 == 0) goto L_0x01ed
            goto L_0x01ef
        L_0x01ed:
            r20 = r21
        L_0x01ef:
            r18 = r18 | r20
            goto L_0x01f4
        L_0x01f2:
            r2 = r51
        L_0x01f4:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r4 & r20
            if (r20 == 0) goto L_0x01fe
            r18 = r18 | r25
            goto L_0x020e
        L_0x01fe:
            r21 = r3 & r25
            r2 = r52
            if (r21 != 0) goto L_0x020e
            boolean r21 = r6.changedInstance(r2)
            if (r21 == 0) goto L_0x020c
            r24 = 131072(0x20000, float:1.83671E-40)
        L_0x020c:
            r18 = r18 | r24
        L_0x020e:
            r2 = r18
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r3 = r7 & r18
            r18 = r5
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x0248
            r3 = 74899(0x12493, float:1.04956E-40)
            r3 = r3 & r2
            r5 = 74898(0x12492, float:1.04954E-40)
            if (r3 != r5) goto L_0x0248
            boolean r3 = r6.getSkipping()
            if (r3 != 0) goto L_0x022c
            goto L_0x0248
        L_0x022c:
            r6.skipToGroupEnd()
            r10 = r46
            r12 = r48
            r16 = r52
            r0 = r6
            r4 = r8
            r8 = r9
            r5 = r11
            r6 = r13
            r7 = r14
            r3 = r15
            r9 = r45
            r11 = r47
            r13 = r49
            r14 = r50
            r15 = r51
            goto L_0x03fe
        L_0x0248:
            r6.startDefaults()
            r3 = r54 & 1
            r21 = 1
            if (r3 == 0) goto L_0x027b
            boolean r3 = r6.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0258
            goto L_0x027b
        L_0x0258:
            r6.skipToGroupEnd()
            r3 = r4 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0263
            r3 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r7 = r7 & r3
        L_0x0263:
            r5 = r45
            r20 = r46
            r22 = r47
            r16 = r48
            r19 = r49
            r17 = r50
            r12 = r9
            r3 = r13
            r4 = r14
            r9 = r7
            r13 = r8
            r14 = r11
            r7 = r51
        L_0x0277:
            r8 = r52
            goto L_0x0324
        L_0x027b:
            if (r10 == 0) goto L_0x0282
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r15 = r3
        L_0x0282:
            if (r16 == 0) goto L_0x0286
            r8 = r21
        L_0x0286:
            if (r19 == 0) goto L_0x0289
            r11 = 0
        L_0x0289:
            if (r23 == 0) goto L_0x0292
            androidx.compose.ui.text.TextStyle$Companion r3 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r3 = r3.getDefault()
            r13 = r3
        L_0x0292:
            if (r27 == 0) goto L_0x029b
            androidx.compose.foundation.text.KeyboardOptions$Companion r3 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r3 = r3.getDefault()
            r14 = r3
        L_0x029b:
            if (r12 == 0) goto L_0x02a4
            androidx.compose.foundation.text.KeyboardActions$Companion r3 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r3 = r3.getDefault()
            goto L_0x02a5
        L_0x02a4:
            r3 = r9
        L_0x02a5:
            if (r22 == 0) goto L_0x02a9
            r9 = 0
            goto L_0x02ab
        L_0x02a9:
            r9 = r45
        L_0x02ab:
            r10 = r4 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x02bc
            if (r9 == 0) goto L_0x02b4
            r10 = r21
            goto L_0x02b7
        L_0x02b4:
            r10 = 2147483647(0x7fffffff, float:NaN)
        L_0x02b7:
            r12 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r7 = r7 & r12
            goto L_0x02be
        L_0x02bc:
            r10 = r46
        L_0x02be:
            if (r32 == 0) goto L_0x02c3
            r12 = r21
            goto L_0x02c5
        L_0x02c3:
            r12 = r47
        L_0x02c5:
            if (r34 == 0) goto L_0x02ce
            androidx.compose.ui.text.input.VisualTransformation$Companion r16 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r16 = r16.getNone()
            goto L_0x02d0
        L_0x02ce:
            r16 = r48
        L_0x02d0:
            if (r26 == 0) goto L_0x02d7
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$10 r19 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$10.INSTANCE
            kotlin.jvm.functions.Function1 r19 = (kotlin.jvm.functions.Function1) r19
            goto L_0x02d9
        L_0x02d7:
            r19 = r49
        L_0x02d9:
            if (r17 == 0) goto L_0x02de
            r17 = 0
            goto L_0x02e0
        L_0x02de:
            r17 = r50
        L_0x02e0:
            if (r18 == 0) goto L_0x02f6
            androidx.compose.ui.graphics.SolidColor r5 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r18 = androidx.compose.ui.graphics.Color.Companion
            r39 = r3
            long r3 = r18.m4265getBlack0d7_KjU()
            r40 = r7
            r7 = 0
            r5.<init>(r3, r7)
            r3 = r5
            androidx.compose.ui.graphics.Brush r3 = (androidx.compose.ui.graphics.Brush) r3
            goto L_0x02fc
        L_0x02f6:
            r39 = r3
            r40 = r7
            r3 = r51
        L_0x02fc:
            if (r20 == 0) goto L_0x0314
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r4 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1177getLambda2$foundation_release()
            r7 = r3
            r5 = r9
            r20 = r10
            r22 = r12
            r3 = r13
            r12 = r39
            r9 = r40
            r13 = r8
            r8 = r4
            r4 = r14
            r14 = r11
            goto L_0x0324
        L_0x0314:
            r7 = r3
            r5 = r9
            r20 = r10
            r22 = r12
            r3 = r13
            r4 = r14
            r12 = r39
            r9 = r40
            r13 = r8
            r14 = r11
            goto L_0x0277
        L_0x0324:
            r6.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0335
            java.lang.String r10 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:763)"
            r11 = 1804514146(0x6b8eb362, float:3.4502916E26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r9, r2, r10)
        L_0x0335:
            androidx.compose.ui.text.input.ImeOptions r11 = r4.toImeOptions$foundation_release(r5)
            r18 = r2
            r2 = r15
            r15 = r8
            r8 = r5 ^ 1
            if (r5 == 0) goto L_0x0344
            r10 = r21
            goto L_0x0346
        L_0x0344:
            r10 = r22
        L_0x0346:
            if (r5 == 0) goto L_0x034b
            r23 = r21
            goto L_0x034d
        L_0x034b:
            r23 = r20
        L_0x034d:
            r39 = r2
            r2 = -1242950400(0xffffffffb5ea1500, float:-1.744047E-6)
            r40 = r3
            java.lang.String r3 = "CC(remember):BasicTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            r2 = r9 & 14
            r3 = 4
            if (r2 != r3) goto L_0x0361
            r2 = r21
            goto L_0x0362
        L_0x0361:
            r2 = 0
        L_0x0362:
            r3 = r9 & 112(0x70, float:1.57E-43)
            r41 = r2
            r2 = 32
            if (r3 != r2) goto L_0x036b
            goto L_0x036d
        L_0x036b:
            r21 = 0
        L_0x036d:
            r2 = r41 | r21
            java.lang.Object r3 = r6.rememberedValue()
            if (r2 != 0) goto L_0x037d
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0388
        L_0x037d:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$11$1 r2 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$11$1
            r2.<init>(r0, r1)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r6.updateRememberedValue(r3)
        L_0x0388:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r2 = r9 & 910(0x38e, float:1.275E-42)
            int r0 = r9 >> 6
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r18 << 9
            r21 = 57344(0xe000, float:8.0356E-41)
            r21 = r2 & r21
            r0 = r0 | r21
            r21 = 458752(0x70000, float:6.42848E-40)
            r21 = r2 & r21
            r0 = r0 | r21
            r21 = 3670016(0x380000, float:5.142788E-39)
            r21 = r2 & r21
            r0 = r0 | r21
            r21 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r21
            r0 = r0 | r2
            int r2 = r9 >> 15
            r2 = r2 & 896(0x380, float:1.256E-42)
            r41 = r0
            r0 = r9 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r9
            r0 = r0 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r18 & r2
            r18 = r0 | r2
            r9 = r5
            r5 = r19
            r19 = 0
            r0 = r23
            r23 = r9
            r9 = r0
            r0 = r37
            r2 = r39
            r1 = r3
            r21 = r4
            r4 = r16
            r3 = r40
            r16 = r6
            r6 = r17
            r17 = r41
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03e9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03e9:
            r8 = r12
            r0 = r16
            r10 = r20
            r11 = r22
            r9 = r23
            r12 = r4
            r4 = r13
            r16 = r15
            r13 = r5
            r15 = r7
            r5 = r14
            r7 = r21
            r14 = r6
            r6 = r3
            r3 = r2
        L_0x03fe:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x041d
            r1 = r0
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$12 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$12
            r2 = r38
            r17 = r54
            r18 = r55
            r19 = r56
            r36 = r1
            r1 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r36
            r1.updateScope(r0)
        L_0x041d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012e  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void BasicTextField(java.lang.String r35, kotlin.jvm.functions.Function1 r36, androidx.compose.ui.Modifier r37, boolean r38, boolean r39, androidx.compose.ui.text.TextStyle r40, androidx.compose.foundation.text.KeyboardOptions r41, androidx.compose.foundation.text.KeyboardActions r42, boolean r43, int r44, androidx.compose.ui.text.input.VisualTransformation r45, kotlin.jvm.functions.Function1 r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.ui.graphics.Brush r48, kotlin.jvm.functions.Function3 r49, androidx.compose.runtime.Composer r50, int r51, int r52, int r53) {
        /*
            r0 = r51
            r1 = r52
            r2 = r53
            r3 = -454732590(0xffffffffe4e554d2, float:-3.384333E22)
            r4 = r50
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r3)
            java.lang.String r5 = "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)803@41337L39,808@41577L579:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r2 & 1
            if (r5 == 0) goto L_0x001e
            r5 = r0 | 6
            r8 = r5
            r5 = r35
            goto L_0x0032
        L_0x001e:
            r5 = r0 & 6
            if (r5 != 0) goto L_0x002f
            r5 = r35
            boolean r8 = r4.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x002c
            r8 = 4
            goto L_0x002d
        L_0x002c:
            r8 = 2
        L_0x002d:
            r8 = r8 | r0
            goto L_0x0032
        L_0x002f:
            r5 = r35
            r8 = r0
        L_0x0032:
            r9 = r2 & 2
            if (r9 == 0) goto L_0x0039
            r8 = r8 | 48
            goto L_0x004c
        L_0x0039:
            r9 = r0 & 48
            if (r9 != 0) goto L_0x004c
            r9 = r36
            boolean r12 = r4.changedInstance(r9)
            if (r12 == 0) goto L_0x0048
            r12 = 32
            goto L_0x004a
        L_0x0048:
            r12 = 16
        L_0x004a:
            r8 = r8 | r12
            goto L_0x004e
        L_0x004c:
            r9 = r36
        L_0x004e:
            r12 = r2 & 4
            if (r12 == 0) goto L_0x0055
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0055:
            r15 = r0 & 384(0x180, float:5.38E-43)
            if (r15 != 0) goto L_0x0069
            r15 = r37
            boolean r16 = r4.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x0064
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r8 = r8 | r16
            goto L_0x006b
        L_0x0069:
            r15 = r37
        L_0x006b:
            r16 = r2 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0076
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x0076:
            r6 = r0 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x008a
            r6 = r38
            boolean r19 = r4.changed((boolean) r6)
            if (r19 == 0) goto L_0x0085
            r19 = r17
            goto L_0x0087
        L_0x0085:
            r19 = r18
        L_0x0087:
            r8 = r8 | r19
            goto L_0x008c
        L_0x008a:
            r6 = r38
        L_0x008c:
            r19 = r2 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0097
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ab
        L_0x0097:
            r7 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x00ab
            r7 = r39
            boolean r23 = r4.changed((boolean) r7)
            if (r23 == 0) goto L_0x00a6
            r23 = r20
            goto L_0x00a8
        L_0x00a6:
            r23 = r21
        L_0x00a8:
            r8 = r8 | r23
            goto L_0x00ad
        L_0x00ab:
            r7 = r39
        L_0x00ad:
            r23 = r2 & 32
            r24 = 196608(0x30000, float:2.75506E-40)
            if (r23 == 0) goto L_0x00b8
            r8 = r8 | r24
            r10 = r40
            goto L_0x00cb
        L_0x00b8:
            r24 = r0 & r24
            r10 = r40
            if (r24 != 0) goto L_0x00cb
            boolean r25 = r4.changed((java.lang.Object) r10)
            if (r25 == 0) goto L_0x00c7
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r8 = r8 | r25
        L_0x00cb:
            r25 = r2 & 64
            r26 = 1572864(0x180000, float:2.204052E-39)
            if (r25 == 0) goto L_0x00d6
            r8 = r8 | r26
            r11 = r41
            goto L_0x00e9
        L_0x00d6:
            r26 = r0 & r26
            r11 = r41
            if (r26 != 0) goto L_0x00e9
            boolean r27 = r4.changed((java.lang.Object) r11)
            if (r27 == 0) goto L_0x00e5
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r8 = r8 | r27
        L_0x00e9:
            r13 = r2 & 128(0x80, float:1.794E-43)
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            if (r13 == 0) goto L_0x00f4
            r8 = r8 | r28
            r14 = r42
            goto L_0x0107
        L_0x00f4:
            r28 = r0 & r28
            r14 = r42
            if (r28 != 0) goto L_0x0107
            boolean r29 = r4.changed((java.lang.Object) r14)
            if (r29 == 0) goto L_0x0103
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r8 = r8 | r29
        L_0x0107:
            r3 = r2 & 256(0x100, float:3.59E-43)
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            if (r3 == 0) goto L_0x0112
            r8 = r8 | r30
            r0 = r43
            goto L_0x0125
        L_0x0112:
            r30 = r0 & r30
            r0 = r43
            if (r30 != 0) goto L_0x0125
            boolean r30 = r4.changed((boolean) r0)
            if (r30 == 0) goto L_0x0121
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0123
        L_0x0121:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0123:
            r8 = r8 | r30
        L_0x0125:
            r0 = r2 & 512(0x200, float:7.175E-43)
            r30 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x012e
            r8 = r8 | r30
            goto L_0x0144
        L_0x012e:
            r30 = r51 & r30
            if (r30 != 0) goto L_0x0144
            r30 = r0
            r0 = r44
            boolean r31 = r4.changed((int) r0)
            if (r31 == 0) goto L_0x013f
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0141
        L_0x013f:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0141:
            r8 = r8 | r31
            goto L_0x0148
        L_0x0144:
            r30 = r0
            r0 = r44
        L_0x0148:
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0153
            r22 = r1 | 6
            r31 = r0
            r0 = r45
            goto L_0x016f
        L_0x0153:
            r31 = r1 & 6
            if (r31 != 0) goto L_0x0169
            r31 = r0
            r0 = r45
            boolean r32 = r4.changed((java.lang.Object) r0)
            if (r32 == 0) goto L_0x0164
            r22 = 4
            goto L_0x0166
        L_0x0164:
            r22 = 2
        L_0x0166:
            r22 = r1 | r22
            goto L_0x016f
        L_0x0169:
            r31 = r0
            r0 = r45
            r22 = r1
        L_0x016f:
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0178
            r22 = r22 | 48
            r32 = r0
            goto L_0x0192
        L_0x0178:
            r32 = r1 & 48
            if (r32 != 0) goto L_0x018e
            r32 = r0
            r0 = r46
            boolean r33 = r4.changedInstance(r0)
            if (r33 == 0) goto L_0x0189
            r24 = 32
            goto L_0x018b
        L_0x0189:
            r24 = 16
        L_0x018b:
            r22 = r22 | r24
            goto L_0x0192
        L_0x018e:
            r32 = r0
            r0 = r46
        L_0x0192:
            r0 = r22
            r22 = r3
            r3 = r2 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x019d
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01b7
        L_0x019d:
            r24 = r0
            r0 = r1 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01b3
            r0 = r47
            boolean r26 = r4.changed((java.lang.Object) r0)
            if (r26 == 0) goto L_0x01ae
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01b0
        L_0x01ae:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01b0:
            r24 = r24 | r27
            goto L_0x01b5
        L_0x01b3:
            r0 = r47
        L_0x01b5:
            r0 = r24
        L_0x01b7:
            r24 = r3
            r3 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x01c0
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01da
        L_0x01c0:
            r26 = r0
            r0 = r1 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01d6
            r0 = r48
            boolean r27 = r4.changed((java.lang.Object) r0)
            if (r27 == 0) goto L_0x01cf
            goto L_0x01d1
        L_0x01cf:
            r17 = r18
        L_0x01d1:
            r17 = r26 | r17
            r0 = r17
            goto L_0x01da
        L_0x01d6:
            r0 = r48
            r0 = r26
        L_0x01da:
            r17 = r3
            r3 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x01e3
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01fb
        L_0x01e3:
            r18 = r0
            r0 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01f7
            r0 = r49
            boolean r26 = r4.changedInstance(r0)
            if (r26 == 0) goto L_0x01f2
            goto L_0x01f4
        L_0x01f2:
            r20 = r21
        L_0x01f4:
            r18 = r18 | r20
            goto L_0x01f9
        L_0x01f7:
            r0 = r49
        L_0x01f9:
            r0 = r18
        L_0x01fb:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r8 & r18
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x022d
            r1 = r0 & 9363(0x2493, float:1.312E-41)
            r2 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r2) goto L_0x022d
            boolean r1 = r4.getSkipping()
            if (r1 != 0) goto L_0x0212
            goto L_0x022d
        L_0x0212:
            r4.skipToGroupEnd()
            r9 = r43
            r12 = r46
            r13 = r47
            r20 = r4
            r4 = r6
            r5 = r7
            r6 = r10
            r7 = r11
            r8 = r14
            r3 = r15
            r10 = r44
            r11 = r45
            r14 = r48
            r15 = r49
            goto L_0x0332
        L_0x022d:
            if (r12 == 0) goto L_0x0234
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r15 = r1
        L_0x0234:
            if (r16 == 0) goto L_0x0238
            r1 = 1
            goto L_0x0239
        L_0x0238:
            r1 = r6
        L_0x0239:
            if (r19 == 0) goto L_0x023d
            r2 = 0
            goto L_0x023e
        L_0x023d:
            r2 = r7
        L_0x023e:
            if (r23 == 0) goto L_0x0247
            androidx.compose.ui.text.TextStyle$Companion r6 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r6 = r6.getDefault()
            goto L_0x0248
        L_0x0247:
            r6 = r10
        L_0x0248:
            if (r25 == 0) goto L_0x0252
            androidx.compose.foundation.text.KeyboardOptions$Companion r7 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r7 = r7.getDefault()
            r10 = r7
            goto L_0x0253
        L_0x0252:
            r10 = r11
        L_0x0253:
            if (r13 == 0) goto L_0x025d
            androidx.compose.foundation.text.KeyboardActions$Companion r7 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r7 = r7.getDefault()
            r11 = r7
            goto L_0x025e
        L_0x025d:
            r11 = r14
        L_0x025e:
            if (r22 == 0) goto L_0x0263
            r7 = 0
            r12 = r7
            goto L_0x0265
        L_0x0263:
            r12 = r43
        L_0x0265:
            if (r30 == 0) goto L_0x026c
            r7 = 2147483647(0x7fffffff, float:NaN)
            r13 = r7
            goto L_0x026e
        L_0x026c:
            r13 = r44
        L_0x026e:
            if (r31 == 0) goto L_0x0277
            androidx.compose.ui.text.input.VisualTransformation$Companion r7 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r7 = r7.getNone()
            goto L_0x0279
        L_0x0277:
            r7 = r45
        L_0x0279:
            if (r32 == 0) goto L_0x0282
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$13 r14 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$13.INSTANCE
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r16 = r14
            goto L_0x0284
        L_0x0282:
            r16 = r46
        L_0x0284:
            if (r24 == 0) goto L_0x02a9
            r14 = -1242906675(0xffffffffb5eabfcd, float:-1.749018E-6)
            r37 = r1
            java.lang.String r1 = "CC(remember):BasicTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r14, r1)
            java.lang.Object r1 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r1 != r14) goto L_0x02a3
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r1)
        L_0x02a3:
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            goto L_0x02ad
        L_0x02a9:
            r37 = r1
            r1 = r47
        L_0x02ad:
            if (r17 == 0) goto L_0x02c7
            androidx.compose.ui.graphics.SolidColor r14 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r17 = androidx.compose.ui.graphics.Color.Companion
            r39 = r1
            r38 = r2
            long r1 = r17.m4265getBlack0d7_KjU()
            r17 = r3
            r3 = 0
            r14.<init>(r1, r3)
            r1 = r14
            androidx.compose.ui.graphics.Brush r1 = (androidx.compose.ui.graphics.Brush) r1
            r18 = r1
            goto L_0x02cf
        L_0x02c7:
            r39 = r1
            r38 = r2
            r17 = r3
            r18 = r48
        L_0x02cf:
            if (r17 == 0) goto L_0x02da
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r1 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r1 = r1.m1178getLambda3$foundation_release()
            r19 = r1
            goto L_0x02dc
        L_0x02da:
            r19 = r49
        L_0x02dc:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x02ea
            java.lang.String r1 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:807)"
            r2 = -454732590(0xffffffffe4e554d2, float:-3.384333E22)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r8, r0, r1)
        L_0x02ea:
            r1 = 2147483646(0x7ffffffe, float:NaN)
            r21 = r8 & r1
            int r0 = r0 << 3
            r1 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r0
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r2
            r22 = r1 | r0
            r23 = 0
            r14 = 1
            r8 = r38
            r17 = r39
            r20 = r4
            r4 = r5
            r5 = r9
            r9 = r6
            r6 = r15
            r15 = r7
            r7 = r37
            BasicTextField((java.lang.String) r4, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r5, (androidx.compose.ui.Modifier) r6, (boolean) r7, (boolean) r8, (androidx.compose.ui.text.TextStyle) r9, (androidx.compose.foundation.text.KeyboardOptions) r10, (androidx.compose.foundation.text.KeyboardActions) r11, (boolean) r12, (int) r13, (int) r14, (androidx.compose.ui.text.input.VisualTransformation) r15, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r16, (androidx.compose.foundation.interaction.MutableInteractionSource) r17, (androidx.compose.ui.graphics.Brush) r18, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22, (int) r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0321
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0321:
            r3 = r6
            r4 = r7
            r5 = r8
            r6 = r9
            r7 = r10
            r8 = r11
            r9 = r12
            r10 = r13
            r11 = r15
            r12 = r16
            r13 = r17
            r14 = r18
            r15 = r19
        L_0x0332:
            androidx.compose.runtime.ScopeUpdateScope r0 = r20.endRestartGroup()
            if (r0 == 0) goto L_0x0351
            r1 = r0
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$15 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$15
            r2 = r36
            r16 = r51
            r17 = r52
            r18 = r53
            r34 = r1
            r1 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r34
            r1.updateScope(r0)
        L_0x0351:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012e  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void BasicTextField(androidx.compose.ui.text.input.TextFieldValue r35, kotlin.jvm.functions.Function1 r36, androidx.compose.ui.Modifier r37, boolean r38, boolean r39, androidx.compose.ui.text.TextStyle r40, androidx.compose.foundation.text.KeyboardOptions r41, androidx.compose.foundation.text.KeyboardActions r42, boolean r43, int r44, androidx.compose.ui.text.input.VisualTransformation r45, kotlin.jvm.functions.Function1 r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.ui.graphics.Brush r48, kotlin.jvm.functions.Function3 r49, androidx.compose.runtime.Composer r50, int r51, int r52, int r53) {
        /*
            r0 = r51
            r1 = r52
            r2 = r53
            r3 = -560482651(0xffffffffde97b6a5, float:-5.4660533E18)
            r4 = r50
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r3)
            java.lang.String r5 = "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)843@42862L39,848@43102L579:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r2 & 1
            if (r5 == 0) goto L_0x001e
            r5 = r0 | 6
            r8 = r5
            r5 = r35
            goto L_0x0032
        L_0x001e:
            r5 = r0 & 6
            if (r5 != 0) goto L_0x002f
            r5 = r35
            boolean r8 = r4.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x002c
            r8 = 4
            goto L_0x002d
        L_0x002c:
            r8 = 2
        L_0x002d:
            r8 = r8 | r0
            goto L_0x0032
        L_0x002f:
            r5 = r35
            r8 = r0
        L_0x0032:
            r9 = r2 & 2
            if (r9 == 0) goto L_0x0039
            r8 = r8 | 48
            goto L_0x004c
        L_0x0039:
            r9 = r0 & 48
            if (r9 != 0) goto L_0x004c
            r9 = r36
            boolean r12 = r4.changedInstance(r9)
            if (r12 == 0) goto L_0x0048
            r12 = 32
            goto L_0x004a
        L_0x0048:
            r12 = 16
        L_0x004a:
            r8 = r8 | r12
            goto L_0x004e
        L_0x004c:
            r9 = r36
        L_0x004e:
            r12 = r2 & 4
            if (r12 == 0) goto L_0x0055
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0055:
            r15 = r0 & 384(0x180, float:5.38E-43)
            if (r15 != 0) goto L_0x0069
            r15 = r37
            boolean r16 = r4.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x0064
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r8 = r8 | r16
            goto L_0x006b
        L_0x0069:
            r15 = r37
        L_0x006b:
            r16 = r2 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0076
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x0076:
            r6 = r0 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x008a
            r6 = r38
            boolean r19 = r4.changed((boolean) r6)
            if (r19 == 0) goto L_0x0085
            r19 = r17
            goto L_0x0087
        L_0x0085:
            r19 = r18
        L_0x0087:
            r8 = r8 | r19
            goto L_0x008c
        L_0x008a:
            r6 = r38
        L_0x008c:
            r19 = r2 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0097
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ab
        L_0x0097:
            r7 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x00ab
            r7 = r39
            boolean r23 = r4.changed((boolean) r7)
            if (r23 == 0) goto L_0x00a6
            r23 = r20
            goto L_0x00a8
        L_0x00a6:
            r23 = r21
        L_0x00a8:
            r8 = r8 | r23
            goto L_0x00ad
        L_0x00ab:
            r7 = r39
        L_0x00ad:
            r23 = r2 & 32
            r24 = 196608(0x30000, float:2.75506E-40)
            if (r23 == 0) goto L_0x00b8
            r8 = r8 | r24
            r10 = r40
            goto L_0x00cb
        L_0x00b8:
            r24 = r0 & r24
            r10 = r40
            if (r24 != 0) goto L_0x00cb
            boolean r25 = r4.changed((java.lang.Object) r10)
            if (r25 == 0) goto L_0x00c7
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r8 = r8 | r25
        L_0x00cb:
            r25 = r2 & 64
            r26 = 1572864(0x180000, float:2.204052E-39)
            if (r25 == 0) goto L_0x00d6
            r8 = r8 | r26
            r11 = r41
            goto L_0x00e9
        L_0x00d6:
            r26 = r0 & r26
            r11 = r41
            if (r26 != 0) goto L_0x00e9
            boolean r27 = r4.changed((java.lang.Object) r11)
            if (r27 == 0) goto L_0x00e5
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r8 = r8 | r27
        L_0x00e9:
            r13 = r2 & 128(0x80, float:1.794E-43)
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            if (r13 == 0) goto L_0x00f4
            r8 = r8 | r28
            r14 = r42
            goto L_0x0107
        L_0x00f4:
            r28 = r0 & r28
            r14 = r42
            if (r28 != 0) goto L_0x0107
            boolean r29 = r4.changed((java.lang.Object) r14)
            if (r29 == 0) goto L_0x0103
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r8 = r8 | r29
        L_0x0107:
            r3 = r2 & 256(0x100, float:3.59E-43)
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            if (r3 == 0) goto L_0x0112
            r8 = r8 | r30
            r0 = r43
            goto L_0x0125
        L_0x0112:
            r30 = r0 & r30
            r0 = r43
            if (r30 != 0) goto L_0x0125
            boolean r30 = r4.changed((boolean) r0)
            if (r30 == 0) goto L_0x0121
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0123
        L_0x0121:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0123:
            r8 = r8 | r30
        L_0x0125:
            r0 = r2 & 512(0x200, float:7.175E-43)
            r30 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x012e
            r8 = r8 | r30
            goto L_0x0144
        L_0x012e:
            r30 = r51 & r30
            if (r30 != 0) goto L_0x0144
            r30 = r0
            r0 = r44
            boolean r31 = r4.changed((int) r0)
            if (r31 == 0) goto L_0x013f
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0141
        L_0x013f:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0141:
            r8 = r8 | r31
            goto L_0x0148
        L_0x0144:
            r30 = r0
            r0 = r44
        L_0x0148:
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0153
            r22 = r1 | 6
            r31 = r0
            r0 = r45
            goto L_0x016f
        L_0x0153:
            r31 = r1 & 6
            if (r31 != 0) goto L_0x0169
            r31 = r0
            r0 = r45
            boolean r32 = r4.changed((java.lang.Object) r0)
            if (r32 == 0) goto L_0x0164
            r22 = 4
            goto L_0x0166
        L_0x0164:
            r22 = 2
        L_0x0166:
            r22 = r1 | r22
            goto L_0x016f
        L_0x0169:
            r31 = r0
            r0 = r45
            r22 = r1
        L_0x016f:
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0178
            r22 = r22 | 48
            r32 = r0
            goto L_0x0192
        L_0x0178:
            r32 = r1 & 48
            if (r32 != 0) goto L_0x018e
            r32 = r0
            r0 = r46
            boolean r33 = r4.changedInstance(r0)
            if (r33 == 0) goto L_0x0189
            r24 = 32
            goto L_0x018b
        L_0x0189:
            r24 = 16
        L_0x018b:
            r22 = r22 | r24
            goto L_0x0192
        L_0x018e:
            r32 = r0
            r0 = r46
        L_0x0192:
            r0 = r22
            r22 = r3
            r3 = r2 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x019d
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01b7
        L_0x019d:
            r24 = r0
            r0 = r1 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01b3
            r0 = r47
            boolean r26 = r4.changed((java.lang.Object) r0)
            if (r26 == 0) goto L_0x01ae
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01b0
        L_0x01ae:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01b0:
            r24 = r24 | r27
            goto L_0x01b5
        L_0x01b3:
            r0 = r47
        L_0x01b5:
            r0 = r24
        L_0x01b7:
            r24 = r3
            r3 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x01c0
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01da
        L_0x01c0:
            r26 = r0
            r0 = r1 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01d6
            r0 = r48
            boolean r27 = r4.changed((java.lang.Object) r0)
            if (r27 == 0) goto L_0x01cf
            goto L_0x01d1
        L_0x01cf:
            r17 = r18
        L_0x01d1:
            r17 = r26 | r17
            r0 = r17
            goto L_0x01da
        L_0x01d6:
            r0 = r48
            r0 = r26
        L_0x01da:
            r17 = r3
            r3 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x01e3
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01fb
        L_0x01e3:
            r18 = r0
            r0 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01f7
            r0 = r49
            boolean r26 = r4.changedInstance(r0)
            if (r26 == 0) goto L_0x01f2
            goto L_0x01f4
        L_0x01f2:
            r20 = r21
        L_0x01f4:
            r18 = r18 | r20
            goto L_0x01f9
        L_0x01f7:
            r0 = r49
        L_0x01f9:
            r0 = r18
        L_0x01fb:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r8 & r18
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x022d
            r1 = r0 & 9363(0x2493, float:1.312E-41)
            r2 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r2) goto L_0x022d
            boolean r1 = r4.getSkipping()
            if (r1 != 0) goto L_0x0212
            goto L_0x022d
        L_0x0212:
            r4.skipToGroupEnd()
            r9 = r43
            r12 = r46
            r13 = r47
            r20 = r4
            r4 = r6
            r5 = r7
            r6 = r10
            r7 = r11
            r8 = r14
            r3 = r15
            r10 = r44
            r11 = r45
            r14 = r48
            r15 = r49
            goto L_0x0332
        L_0x022d:
            if (r12 == 0) goto L_0x0234
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r15 = r1
        L_0x0234:
            if (r16 == 0) goto L_0x0238
            r1 = 1
            goto L_0x0239
        L_0x0238:
            r1 = r6
        L_0x0239:
            if (r19 == 0) goto L_0x023d
            r2 = 0
            goto L_0x023e
        L_0x023d:
            r2 = r7
        L_0x023e:
            if (r23 == 0) goto L_0x0247
            androidx.compose.ui.text.TextStyle$Companion r6 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r6 = r6.getDefault()
            goto L_0x0248
        L_0x0247:
            r6 = r10
        L_0x0248:
            if (r25 == 0) goto L_0x0252
            androidx.compose.foundation.text.KeyboardOptions$Companion r7 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r7 = r7.getDefault()
            r10 = r7
            goto L_0x0253
        L_0x0252:
            r10 = r11
        L_0x0253:
            if (r13 == 0) goto L_0x025d
            androidx.compose.foundation.text.KeyboardActions$Companion r7 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r7 = r7.getDefault()
            r11 = r7
            goto L_0x025e
        L_0x025d:
            r11 = r14
        L_0x025e:
            if (r22 == 0) goto L_0x0263
            r7 = 0
            r12 = r7
            goto L_0x0265
        L_0x0263:
            r12 = r43
        L_0x0265:
            if (r30 == 0) goto L_0x026c
            r7 = 2147483647(0x7fffffff, float:NaN)
            r13 = r7
            goto L_0x026e
        L_0x026c:
            r13 = r44
        L_0x026e:
            if (r31 == 0) goto L_0x0277
            androidx.compose.ui.text.input.VisualTransformation$Companion r7 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r7 = r7.getNone()
            goto L_0x0279
        L_0x0277:
            r7 = r45
        L_0x0279:
            if (r32 == 0) goto L_0x0282
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$16 r14 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$16.INSTANCE
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r16 = r14
            goto L_0x0284
        L_0x0282:
            r16 = r46
        L_0x0284:
            if (r24 == 0) goto L_0x02a9
            r14 = -1242857875(0xffffffffb5eb7e6d, float:-1.7545659E-6)
            r37 = r1
            java.lang.String r1 = "CC(remember):BasicTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r14, r1)
            java.lang.Object r1 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r1 != r14) goto L_0x02a3
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r1)
        L_0x02a3:
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            goto L_0x02ad
        L_0x02a9:
            r37 = r1
            r1 = r47
        L_0x02ad:
            if (r17 == 0) goto L_0x02c7
            androidx.compose.ui.graphics.SolidColor r14 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r17 = androidx.compose.ui.graphics.Color.Companion
            r39 = r1
            r38 = r2
            long r1 = r17.m4265getBlack0d7_KjU()
            r17 = r3
            r3 = 0
            r14.<init>(r1, r3)
            r1 = r14
            androidx.compose.ui.graphics.Brush r1 = (androidx.compose.ui.graphics.Brush) r1
            r18 = r1
            goto L_0x02cf
        L_0x02c7:
            r39 = r1
            r38 = r2
            r17 = r3
            r18 = r48
        L_0x02cf:
            if (r17 == 0) goto L_0x02da
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r1 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r1 = r1.m1179getLambda4$foundation_release()
            r19 = r1
            goto L_0x02dc
        L_0x02da:
            r19 = r49
        L_0x02dc:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x02ea
            java.lang.String r1 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:847)"
            r2 = -560482651(0xffffffffde97b6a5, float:-5.4660533E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r8, r0, r1)
        L_0x02ea:
            r1 = 2147483646(0x7ffffffe, float:NaN)
            r21 = r8 & r1
            int r0 = r0 << 3
            r1 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r0
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r2
            r22 = r1 | r0
            r23 = 0
            r14 = 1
            r8 = r38
            r17 = r39
            r20 = r4
            r4 = r5
            r5 = r9
            r9 = r6
            r6 = r15
            r15 = r7
            r7 = r37
            BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r4, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r5, (androidx.compose.ui.Modifier) r6, (boolean) r7, (boolean) r8, (androidx.compose.ui.text.TextStyle) r9, (androidx.compose.foundation.text.KeyboardOptions) r10, (androidx.compose.foundation.text.KeyboardActions) r11, (boolean) r12, (int) r13, (int) r14, (androidx.compose.ui.text.input.VisualTransformation) r15, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r16, (androidx.compose.foundation.interaction.MutableInteractionSource) r17, (androidx.compose.ui.graphics.Brush) r18, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22, (int) r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0321
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0321:
            r3 = r6
            r4 = r7
            r5 = r8
            r6 = r9
            r7 = r10
            r8 = r11
            r9 = r12
            r10 = r13
            r11 = r15
            r12 = r16
            r13 = r17
            r14 = r18
            r15 = r19
        L_0x0332:
            androidx.compose.runtime.ScopeUpdateScope r0 = r20.endRestartGroup()
            if (r0 == 0) goto L_0x0351
            r1 = r0
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$18 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$18
            r2 = r36
            r16 = r51
            r17 = r52
            r18 = r53
            r34 = r1
            r1 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r34
            r1.updateScope(r0)
        L_0x0351:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final TextFieldHandleState TextFieldCursorHandle$lambda$9(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$13(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$17(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    /* access modifiers changed from: private */
    public static final void BasicTextField$lambda$22(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* access modifiers changed from: private */
    public static final void BasicTextField$lambda$26(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }
}
