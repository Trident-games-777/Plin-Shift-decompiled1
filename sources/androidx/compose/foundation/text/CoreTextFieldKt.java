package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001fH\u0001¢\u0006\u0002\u0010#\u001a0\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010+\u001a\u0015\u0010,\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\u0010-\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u000200H\u0002\u001a \u00101\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0002\u001a0\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0002\u001a \u00107\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0013H\u0002\u001a2\u0010;\u001a\u00020\u0001*\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\r2\u0006\u00102\u001a\u000203H@¢\u0006\u0002\u0010@\u001a\u001c\u0010A\u001a\u00020\u0007*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u0010%\u001a\u00020&H\u0002¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0013X\u0002"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "endInputSession", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "notifyFocusedRect", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release", "writeable"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
public final class CoreTextFieldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r51v1, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.foundation.text.TextFieldScrollerPosition, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v29, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v55, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v64, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v60, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v48, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0458, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x045d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x04d4, code lost:
        if (r9 == null) goto L_0x04d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:422:0x0a39, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0a3e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x045b  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x048f  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0491  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x04a1  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x04b3  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04b8  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0503  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0517  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0599  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x05a7  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x05d3  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x065c  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x068b  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x06b1  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x06b3  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x06c3  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x06c5  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06d3  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x06d5  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x06e1  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x06ef  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x06fd  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0723  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0732  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x076b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x07a8  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x07ab  */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x07c5  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x07cb  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x0831  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x0833  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0839  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x083b  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x0856  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x085a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x08af  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x08b1  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x08c7  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x08cb  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x08f4  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x08f6  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x090b  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x090d  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x0927  */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x092a  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x096a  */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x096c  */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x0975  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0977  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x0983  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0985  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x09a4  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x09a6  */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x09b7  */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x09be  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x09f0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0a31  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x0a3c  */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0a64  */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x0a66  */
    /* JADX WARNING: Removed duplicated region for block: B:435:0x0a76  */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0a78  */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x0ab0  */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0ab3  */
    /* JADX WARNING: Removed duplicated region for block: B:452:0x0af3  */
    /* JADX WARNING: Removed duplicated region for block: B:453:0x0af5  */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x0b6d  */
    /* JADX WARNING: Removed duplicated region for block: B:468:0x0b6f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:470:0x0b72  */
    /* JADX WARNING: Removed duplicated region for block: B:471:0x0b7b  */
    /* JADX WARNING: Removed duplicated region for block: B:474:0x0bc6  */
    /* JADX WARNING: Removed duplicated region for block: B:478:0x0bea  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:480:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CoreTextField(androidx.compose.ui.text.input.TextFieldValue r48, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r49, androidx.compose.ui.Modifier r50, androidx.compose.ui.text.TextStyle r51, androidx.compose.ui.text.input.VisualTransformation r52, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r53, androidx.compose.foundation.interaction.MutableInteractionSource r54, androidx.compose.ui.graphics.Brush r55, boolean r56, int r57, int r58, androidx.compose.ui.text.input.ImeOptions r59, androidx.compose.foundation.text.KeyboardActions r60, boolean r61, boolean r62, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r63, androidx.compose.runtime.Composer r64, int r65, int r66, int r67) {
        /*
            r1 = r48
            r0 = r65
            r2 = r66
            r3 = r67
            r4 = -958708118(0xffffffffc6db466a, float:-28067.207)
            r5 = r64
            androidx.compose.runtime.Composer r4 = r5.startRestartGroup(r4)
            java.lang.String r5 = "C(CoreTextField)P(14,10,8,13,15,9,4!1,12,6,7,3,5,2,11)221@12329L29,222@12399L58,223@12503L72,228@12633L7,229@12694L7,230@12762L7,231@12827L7,232@12872L7,233@12941L7,241@13250L42,238@13157L135,244@13333L269,257@13907L21,258@13945L403,287@14747L26,290@14833L51,296@15136L7,297@15187L7,298@15244L7,303@15385L24,304@15443L37,311@15672L1487,352@17266L42,353@17334L970,353@17313L991,379@18375L28,380@18467L907,408@19636L516,425@20215L1473,462@21825L6646,616@28696L60,616@28670L86,620@28791L458,620@28762L487,647@29739L1132,694@31923L4765,694@31870L4818:CoreTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r3 & 1
            if (r5 == 0) goto L_0x001d
            r5 = r0 | 6
            goto L_0x002d
        L_0x001d:
            r5 = r0 & 6
            if (r5 != 0) goto L_0x002c
            boolean r5 = r4.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0029
            r5 = 4
            goto L_0x002a
        L_0x0029:
            r5 = 2
        L_0x002a:
            r5 = r5 | r0
            goto L_0x002d
        L_0x002c:
            r5 = r0
        L_0x002d:
            r8 = r3 & 2
            if (r8 == 0) goto L_0x0034
            r5 = r5 | 48
            goto L_0x0047
        L_0x0034:
            r8 = r0 & 48
            if (r8 != 0) goto L_0x0047
            r8 = r49
            boolean r11 = r4.changedInstance(r8)
            if (r11 == 0) goto L_0x0043
            r11 = 32
            goto L_0x0045
        L_0x0043:
            r11 = 16
        L_0x0045:
            r5 = r5 | r11
            goto L_0x0049
        L_0x0047:
            r8 = r49
        L_0x0049:
            r11 = r3 & 4
            if (r11 == 0) goto L_0x0050
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r14 = r0 & 384(0x180, float:5.38E-43)
            if (r14 != 0) goto L_0x0063
            r14 = r50
            boolean r15 = r4.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x005f
            r15 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r15 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r5 = r5 | r15
            goto L_0x0065
        L_0x0063:
            r14 = r50
        L_0x0065:
            r15 = r3 & 8
            r16 = 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x006e
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006e:
            r12 = r0 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x0082
            r12 = r51
            boolean r18 = r4.changed((java.lang.Object) r12)
            if (r18 == 0) goto L_0x007d
            r18 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r18 = r16
        L_0x007f:
            r5 = r5 | r18
            goto L_0x0084
        L_0x0082:
            r12 = r51
        L_0x0084:
            r18 = r3 & 16
            r19 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x008d
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008d:
            r6 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x00a1
            r6 = r52
            boolean r22 = r4.changed((java.lang.Object) r6)
            if (r22 == 0) goto L_0x009c
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r22 = r19
        L_0x009e:
            r5 = r5 | r22
            goto L_0x00a3
        L_0x00a1:
            r6 = r52
        L_0x00a3:
            r22 = r3 & 32
            r23 = 196608(0x30000, float:2.75506E-40)
            if (r22 == 0) goto L_0x00ae
            r5 = r5 | r23
            r10 = r53
            goto L_0x00c1
        L_0x00ae:
            r24 = r0 & r23
            r10 = r53
            if (r24 != 0) goto L_0x00c1
            boolean r25 = r4.changedInstance(r10)
            if (r25 == 0) goto L_0x00bd
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bd:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r5 = r5 | r25
        L_0x00c1:
            r25 = r3 & 64
            r26 = 1572864(0x180000, float:2.204052E-39)
            if (r25 == 0) goto L_0x00cc
            r5 = r5 | r26
            r9 = r54
            goto L_0x00df
        L_0x00cc:
            r26 = r0 & r26
            r9 = r54
            if (r26 != 0) goto L_0x00df
            boolean r27 = r4.changed((java.lang.Object) r9)
            if (r27 == 0) goto L_0x00db
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dd
        L_0x00db:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00dd:
            r5 = r5 | r27
        L_0x00df:
            r13 = r3 & 128(0x80, float:1.794E-43)
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            if (r13 == 0) goto L_0x00ea
            r5 = r5 | r28
            r7 = r55
            goto L_0x00fd
        L_0x00ea:
            r28 = r0 & r28
            r7 = r55
            if (r28 != 0) goto L_0x00fd
            boolean r29 = r4.changed((java.lang.Object) r7)
            if (r29 == 0) goto L_0x00f9
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fb
        L_0x00f9:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fb:
            r5 = r5 | r29
        L_0x00fd:
            r0 = r3 & 256(0x100, float:3.59E-43)
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0106
            r5 = r5 | r29
            goto L_0x011c
        L_0x0106:
            r29 = r65 & r29
            if (r29 != 0) goto L_0x011c
            r29 = r0
            r0 = r56
            boolean r30 = r4.changed((boolean) r0)
            if (r30 == 0) goto L_0x0117
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0119
        L_0x0117:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0119:
            r5 = r5 | r30
            goto L_0x0120
        L_0x011c:
            r29 = r0
            r0 = r56
        L_0x0120:
            r0 = r3 & 512(0x200, float:7.175E-43)
            r30 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0129
            r5 = r5 | r30
            goto L_0x013f
        L_0x0129:
            r30 = r65 & r30
            if (r30 != 0) goto L_0x013f
            r30 = r0
            r0 = r57
            boolean r31 = r4.changed((int) r0)
            if (r31 == 0) goto L_0x013a
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013c
        L_0x013a:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013c:
            r5 = r5 | r31
            goto L_0x0143
        L_0x013f:
            r30 = r0
            r0 = r57
        L_0x0143:
            r0 = r3 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0150
            r31 = r2 | 6
            r32 = r31
            r31 = r0
            r0 = r58
            goto L_0x016c
        L_0x0150:
            r31 = r2 & 6
            if (r31 != 0) goto L_0x0166
            r31 = r0
            r0 = r58
            boolean r32 = r4.changed((int) r0)
            if (r32 == 0) goto L_0x0161
            r32 = 4
            goto L_0x0163
        L_0x0161:
            r32 = 2
        L_0x0163:
            r32 = r2 | r32
            goto L_0x016c
        L_0x0166:
            r31 = r0
            r0 = r58
            r32 = r2
        L_0x016c:
            r33 = r2 & 48
            if (r33 != 0) goto L_0x0186
            r0 = r3 & 2048(0x800, float:2.87E-42)
            if (r0 != 0) goto L_0x017f
            r0 = r59
            boolean r33 = r4.changed((java.lang.Object) r0)
            if (r33 == 0) goto L_0x0181
            r33 = 32
            goto L_0x0183
        L_0x017f:
            r0 = r59
        L_0x0181:
            r33 = 16
        L_0x0183:
            r32 = r32 | r33
            goto L_0x0188
        L_0x0186:
            r0 = r59
        L_0x0188:
            r0 = r32
            r6 = r3 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0191
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01ad
        L_0x0191:
            r32 = r0
            r0 = r2 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01a9
            r0 = r60
            boolean r33 = r4.changed((java.lang.Object) r0)
            if (r33 == 0) goto L_0x01a2
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x01a4
        L_0x01a2:
            r17 = 128(0x80, float:1.794E-43)
        L_0x01a4:
            r17 = r32 | r17
            r0 = r17
            goto L_0x01ad
        L_0x01a9:
            r0 = r60
            r0 = r32
        L_0x01ad:
            r17 = r6
            r6 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x01b6
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01cf
        L_0x01b6:
            r20 = r0
            r0 = r2 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01cb
            r0 = r61
            boolean r32 = r4.changed((boolean) r0)
            if (r32 == 0) goto L_0x01c6
            r16 = 2048(0x800, float:2.87E-42)
        L_0x01c6:
            r16 = r20 | r16
            r0 = r16
            goto L_0x01cf
        L_0x01cb:
            r0 = r61
            r0 = r20
        L_0x01cf:
            r16 = r6
            r6 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x01dc
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r19 = r0
            r0 = r62
            goto L_0x01f3
        L_0x01dc:
            r20 = r0
            r0 = r2 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01ef
            r0 = r62
            boolean r32 = r4.changed((boolean) r0)
            if (r32 == 0) goto L_0x01ec
            r19 = 16384(0x4000, float:2.2959E-41)
        L_0x01ec:
            r19 = r20 | r19
            goto L_0x01f3
        L_0x01ef:
            r0 = r62
            r19 = r20
        L_0x01f3:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r3 & r20
            if (r20 == 0) goto L_0x01ff
            r19 = r19 | r23
            r0 = r63
            goto L_0x0212
        L_0x01ff:
            r23 = r2 & r23
            r0 = r63
            if (r23 != 0) goto L_0x0212
            boolean r23 = r4.changedInstance(r0)
            if (r23 == 0) goto L_0x020e
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0210
        L_0x020e:
            r23 = 65536(0x10000, float:9.18355E-41)
        L_0x0210:
            r19 = r19 | r23
        L_0x0212:
            r23 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r5 & r23
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x024b
            r0 = 74899(0x12493, float:1.04956E-40)
            r0 = r19 & r0
            r2 = 74898(0x12492, float:1.04954E-40)
            if (r0 != r2) goto L_0x024b
            boolean r0 = r4.getSkipping()
            if (r0 != 0) goto L_0x022d
            goto L_0x024b
        L_0x022d:
            r4.skipToGroupEnd()
            r5 = r52
            r11 = r58
            r13 = r60
            r15 = r62
            r16 = r63
            r45 = r4
            r8 = r7
            r7 = r9
            r6 = r10
            r4 = r12
            r3 = r14
            r9 = r56
            r10 = r57
            r12 = r59
            r14 = r61
            goto L_0x0be4
        L_0x024b:
            r4.startDefaults()
            r0 = r65 & 1
            if (r0 == 0) goto L_0x027e
            boolean r0 = r4.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0259
            goto L_0x027e
        L_0x0259:
            r4.skipToGroupEnd()
            r0 = r3 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0262
            r19 = r19 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0262:
            r8 = r52
            r6 = r56
            r11 = r58
            r16 = r62
            r18 = r63
            r15 = r3
            r2 = r9
            r17 = r10
            r3 = r12
            r0 = r14
            r13 = r19
            r9 = r57
            r10 = r59
            r12 = r60
            r14 = r61
            goto L_0x0314
        L_0x027e:
            if (r11 == 0) goto L_0x0285
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r14 = r0
        L_0x0285:
            if (r15 == 0) goto L_0x028e
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r12 = r0
        L_0x028e:
            if (r18 == 0) goto L_0x0297
            androidx.compose.ui.text.input.VisualTransformation$Companion r0 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r0 = r0.getNone()
            goto L_0x0299
        L_0x0297:
            r0 = r52
        L_0x0299:
            if (r22 == 0) goto L_0x029f
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1 r10 = androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1.INSTANCE
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
        L_0x029f:
            if (r25 == 0) goto L_0x02a2
            r9 = 0
        L_0x02a2:
            if (r13 == 0) goto L_0x02b4
            androidx.compose.ui.graphics.SolidColor r7 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r11 = androidx.compose.ui.graphics.Color.Companion
            long r2 = r11.m4275getUnspecified0d7_KjU()
            r11 = 0
            r7.<init>(r2, r11)
            r2 = r7
            androidx.compose.ui.graphics.Brush r2 = (androidx.compose.ui.graphics.Brush) r2
            goto L_0x02b5
        L_0x02b4:
            r2 = r7
        L_0x02b5:
            if (r29 == 0) goto L_0x02b9
            r3 = 1
            goto L_0x02bb
        L_0x02b9:
            r3 = r56
        L_0x02bb:
            if (r30 == 0) goto L_0x02c1
            r7 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02c3
        L_0x02c1:
            r7 = r57
        L_0x02c3:
            if (r31 == 0) goto L_0x02c7
            r11 = 1
            goto L_0x02c9
        L_0x02c7:
            r11 = r58
        L_0x02c9:
            r15 = r67
            r13 = r15 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x02d8
            androidx.compose.ui.text.input.ImeOptions$Companion r13 = androidx.compose.ui.text.input.ImeOptions.Companion
            androidx.compose.ui.text.input.ImeOptions r13 = r13.getDefault()
            r19 = r19 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02da
        L_0x02d8:
            r13 = r59
        L_0x02da:
            if (r17 == 0) goto L_0x02e3
            androidx.compose.foundation.text.KeyboardActions$Companion r17 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r17 = r17.getDefault()
            goto L_0x02e5
        L_0x02e3:
            r17 = r60
        L_0x02e5:
            if (r16 == 0) goto L_0x02ea
            r16 = 1
            goto L_0x02ec
        L_0x02ea:
            r16 = r61
        L_0x02ec:
            if (r6 == 0) goto L_0x02f0
            r6 = 0
            goto L_0x02f2
        L_0x02f0:
            r6 = r62
        L_0x02f2:
            if (r20 == 0) goto L_0x02ff
            androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt r18 = androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r18 = r18.m1180getLambda1$foundation_release()
            r8 = r7
            r7 = r2
            r2 = r9
            r9 = r8
            goto L_0x0305
        L_0x02ff:
            r8 = r7
            r7 = r2
            r2 = r9
            r9 = r8
            r18 = r63
        L_0x0305:
            r8 = r0
            r0 = r14
            r14 = r16
            r16 = r6
            r6 = r3
            r3 = r12
            r12 = r17
            r17 = r10
            r10 = r13
            r13 = r19
        L_0x0314:
            r4.endDefaults()
            boolean r19 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r57 = r3
            if (r19 == 0) goto L_0x032a
            r3 = -958708118(0xffffffffc6db466a, float:-28067.207)
            r58 = r6
            java.lang.String r6 = "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:220)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r5, r13, r6)
            goto L_0x032c
        L_0x032a:
            r58 = r6
        L_0x032c:
            r3 = -1705356604(0xffffffff9a5a52c4, float:-4.51482E-23)
            java.lang.String r6 = "CC(remember):CoreTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r3, r6)
            java.lang.Object r3 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r5
            java.lang.Object r5 = r19.getEmpty()
            if (r3 != r5) goto L_0x034a
            androidx.compose.ui.focus.FocusRequester r3 = new androidx.compose.ui.focus.FocusRequester
            r3.<init>()
            r4.updateRememberedValue(r3)
        L_0x034a:
            androidx.compose.ui.focus.FocusRequester r3 = (androidx.compose.ui.focus.FocusRequester) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r5 = -1705354335(0xffffffff9a5a5ba1, float:-4.515536E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r5, r6)
            java.lang.Object r5 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r63 = r7
            java.lang.Object r7 = r19.getEmpty()
            if (r5 != r7) goto L_0x036a
            androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter r5 = androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter()
            r4.updateRememberedValue(r5)
        L_0x036a:
            androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter r5 = (androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r7 = -1705350993(0xffffffff9a5a68af, float:-4.5165906E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r7, r6)
            java.lang.Object r7 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r22 = r11
            java.lang.Object r11 = r19.getEmpty()
            if (r7 != r11) goto L_0x038e
            androidx.compose.ui.text.input.TextInputService r7 = new androidx.compose.ui.text.input.TextInputService
            r11 = r5
            androidx.compose.ui.text.input.PlatformTextInputService r11 = (androidx.compose.ui.text.input.PlatformTextInputService) r11
            r7.<init>(r11)
            r4.updateRememberedValue(r7)
        L_0x038e:
            androidx.compose.ui.text.input.TextInputService r7 = (androidx.compose.ui.text.input.TextInputService) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r19 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            r25 = r13
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r12, r13)
            java.lang.Object r11 = r4.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r29 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            r59 = r11
            r11 = r29
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r12, r13)
            java.lang.Object r11 = r4.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.text.font.FontFamily$Resolver r11 = (androidx.compose.ui.text.font.FontFamily.Resolver) r11
            androidx.compose.runtime.ProvidableCompositionLocal r29 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            r60 = r11
            r11 = r29
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r12, r13)
            java.lang.Object r11 = r4.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.foundation.text.selection.TextSelectionColors r11 = (androidx.compose.foundation.text.selection.TextSelectionColors) r11
            long r29 = r11.m1672getBackgroundColor0d7_KjU()
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r12, r13)
            java.lang.Object r11 = r4.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.focus.FocusManager r11 = (androidx.compose.ui.focus.FocusManager) r11
            androidx.compose.runtime.ProvidableCompositionLocal r31 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalWindowInfo()
            r32 = r11
            r11 = r31
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r12, r13)
            java.lang.Object r11 = r4.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.WindowInfo r11 = (androidx.compose.ui.platform.WindowInfo) r11
            androidx.compose.runtime.ProvidableCompositionLocal r31 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalSoftwareKeyboardController()
            r15 = r31
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r12, r13)
            java.lang.Object r15 = r4.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.SoftwareKeyboardController r15 = (androidx.compose.ui.platform.SoftwareKeyboardController) r15
            r12 = 1
            if (r9 != r12) goto L_0x042a
            r12 = r25
            if (r58 != 0) goto L_0x042c
            boolean r33 = r10.getSingleLine()
            if (r33 == 0) goto L_0x042c
            androidx.compose.foundation.gestures.Orientation r33 = androidx.compose.foundation.gestures.Orientation.Horizontal
            goto L_0x042e
        L_0x042a:
            r12 = r25
        L_0x042c:
            androidx.compose.foundation.gestures.Orientation r33 = androidx.compose.foundation.gestures.Orientation.Vertical
        L_0x042e:
            r50 = r33
            java.lang.Object[] r33 = new java.lang.Object[]{r50}
            androidx.compose.foundation.text.TextFieldScrollerPosition$Companion r34 = androidx.compose.foundation.text.TextFieldScrollerPosition.Companion
            androidx.compose.runtime.saveable.Saver r34 = r34.getSaver()
            r35 = r0
            r0 = -1705327119(0xffffffff9a5ac5f1, float:-4.524124E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r6)
            r0 = r50
            boolean r36 = r4.changed((java.lang.Object) r0)
            r37 = r5
            java.lang.Object r5 = r4.rememberedValue()
            if (r36 != 0) goto L_0x045b
            androidx.compose.runtime.Composer$Companion r36 = androidx.compose.runtime.Composer.Companion
            r38 = r9
            java.lang.Object r9 = r36.getEmpty()
            if (r5 != r9) goto L_0x0467
            goto L_0x045d
        L_0x045b:
            r38 = r9
        L_0x045d:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
            r5.<init>(r0)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r4.updateRememberedValue(r5)
        L_0x0467:
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r0 = 0
            r9 = 4
            r36 = 0
            r55 = r0
            r54 = r4
            r53 = r5
            r56 = r9
            r50 = r33
            r51 = r34
            r52 = r36
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r50, r51, (java.lang.String) r52, r53, (androidx.compose.runtime.Composer) r54, (int) r55, (int) r56)
            androidx.compose.foundation.text.TextFieldScrollerPosition r0 = (androidx.compose.foundation.text.TextFieldScrollerPosition) r0
            r5 = -1705324236(0xffffffff9a5ad134, float:-4.5250336E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r5, r6)
            r5 = r20 & 14
            r9 = 4
            if (r5 != r9) goto L_0x0491
            r9 = 1
            goto L_0x0492
        L_0x0491:
            r9 = 0
        L_0x0492:
            r33 = 57344(0xe000, float:8.0356E-41)
            r50 = r9
            r9 = r20 & r33
            r20 = r0
            r0 = 16384(0x4000, float:2.2959E-41)
            if (r9 != r0) goto L_0x04a1
            r0 = 1
            goto L_0x04a2
        L_0x04a1:
            r0 = 0
        L_0x04a2:
            r0 = r50 | r0
            java.lang.Object r9 = r4.rememberedValue()
            if (r0 != 0) goto L_0x04b8
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r9 != r0) goto L_0x04b3
            goto L_0x04b8
        L_0x04b3:
            r33 = r10
            r34 = r11
            goto L_0x04dd
        L_0x04b8:
            androidx.compose.ui.text.AnnotatedString r0 = r1.getAnnotatedString()
            androidx.compose.ui.text.input.TransformedText r0 = androidx.compose.foundation.text.ValidatingOffsetMappingKt.filterWithValidation(r8, r0)
            androidx.compose.ui.text.TextRange r9 = r1.m6822getCompositionMzsxiRA()
            r33 = r10
            if (r9 == 0) goto L_0x04d7
            long r9 = r9.m6568unboximpl()
            r34 = r11
            androidx.compose.foundation.text.TextFieldDelegate$Companion r11 = androidx.compose.foundation.text.TextFieldDelegate.Companion
            androidx.compose.ui.text.input.TransformedText r9 = r11.m1264applyCompositionDecoration72CqOWE(r9, r0)
            if (r9 != 0) goto L_0x04da
            goto L_0x04d9
        L_0x04d7:
            r34 = r11
        L_0x04d9:
            r9 = r0
        L_0x04da:
            r4.updateRememberedValue(r9)
        L_0x04dd:
            androidx.compose.ui.text.input.TransformedText r9 = (androidx.compose.ui.text.input.TransformedText) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.text.AnnotatedString r0 = r9.getText()
            androidx.compose.ui.text.input.OffsetMapping r10 = r9.getOffsetMapping()
            r52 = r0
            r11 = 0
            androidx.compose.runtime.RecomposeScope r0 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r4, r11)
            r11 = -1705304518(0xffffffff9a5b1e3a, float:-4.5312555E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r11, r6)
            boolean r11 = r4.changed((java.lang.Object) r15)
            r50 = r11
            java.lang.Object r11 = r4.rememberedValue()
            if (r50 != 0) goto L_0x0517
            androidx.compose.runtime.Composer$Companion r36 = androidx.compose.runtime.Composer.Companion
            r39 = r9
            java.lang.Object r9 = r36.getEmpty()
            if (r11 != r9) goto L_0x050e
            goto L_0x0519
        L_0x050e:
            r41 = r52
            r42 = r57
            r40 = r58
            r36 = r60
            goto L_0x0552
        L_0x0517:
            r39 = r9
        L_0x0519:
            androidx.compose.foundation.text.LegacyTextFieldState r11 = new androidx.compose.foundation.text.LegacyTextFieldState
            androidx.compose.foundation.text.TextDelegate r9 = new androidx.compose.foundation.text.TextDelegate
            r36 = 300(0x12c, float:4.2E-43)
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r53 = r57
            r56 = r58
            r58 = r59
            r59 = r60
            r51 = r9
            r61 = r36
            r62 = r40
            r54 = r41
            r55 = r42
            r57 = r43
            r60 = r44
            r51.<init>(r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62)
            r41 = r52
            r42 = r53
            r40 = r56
            r36 = r59
            r59 = r58
            r11.<init>(r9, r0, r15)
            r4.updateRememberedValue(r11)
        L_0x0552:
            androidx.compose.foundation.text.LegacyTextFieldState r11 = (androidx.compose.foundation.text.LegacyTextFieldState) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.text.AnnotatedString r0 = r1.getAnnotatedString()
            r57 = r49
            r55 = r59
            r51 = r0
            r50 = r11
            r58 = r19
            r60 = r29
            r59 = r32
            r56 = r36
            r54 = r40
            r52 = r41
            r53 = r42
            r50.m1219updatefnh65Uc(r51, r52, r53, r54, r55, r56, r57, r58, r59, r60)
            r0 = r50
            r19 = r55
            r29 = r58
            r11 = r59
            androidx.compose.ui.text.input.EditProcessor r9 = r0.getProcessor()
            androidx.compose.ui.text.input.TextInputSession r15 = r0.getInputSession()
            r9.reset(r1, r15)
            r9 = -1705279231(0xffffffff9a5b8101, float:-4.5392347E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r9, r6)
            java.lang.Object r9 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r9 != r15) goto L_0x05a7
            androidx.compose.foundation.text.UndoManager r9 = new androidx.compose.foundation.text.UndoManager
            r32 = r11
            r1 = 0
            r11 = 1
            r15 = 0
            r9.<init>(r1, r11, r15)
            r4.updateRememberedValue(r9)
            goto L_0x05a9
        L_0x05a7:
            r32 = r11
        L_0x05a9:
            androidx.compose.foundation.text.UndoManager r9 = (androidx.compose.foundation.text.UndoManager) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r1 = 2
            r11 = 0
            r43 = 0
            r51 = r48
            r54 = r1
            r50 = r9
            r55 = r11
            r52 = r43
            androidx.compose.foundation.text.UndoManager.snapshotIfNeeded$default(r50, r51, r52, r54, r55)
            r1 = r51
            r11 = -1705276454(0xffffffff9a5b8bda, float:-4.540111E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r11, r6)
            java.lang.Object r11 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r11 != r15) goto L_0x05db
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r11 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager
            r11.<init>(r9)
            r4.updateRememberedValue(r11)
        L_0x05db:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r11 = (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r11.setOffsetMapping$foundation_release(r10)
            r11.setVisualTransformation$foundation_release(r8)
            kotlin.jvm.functions.Function1 r15 = r0.getOnValueChange()
            r11.setOnValueChange$foundation_release(r15)
            r11.setState$foundation_release(r0)
            r11.setValue$foundation_release(r1)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalClipboardManager()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r13)
            java.lang.Object r15 = r4.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.ClipboardManager r15 = (androidx.compose.ui.platform.ClipboardManager) r15
            r11.setClipboardManager$foundation_release(r15)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextToolbar()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r13)
            java.lang.Object r15 = r4.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.TextToolbar r15 = (androidx.compose.ui.platform.TextToolbar) r15
            r11.setTextToolbar(r15)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalHapticFeedback()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r13)
            java.lang.Object r1 = r4.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.hapticfeedback.HapticFeedback r1 = (androidx.compose.ui.hapticfeedback.HapticFeedback) r1
            r11.setHapticFeedBack(r1)
            r11.setFocusRequester(r3)
            r1 = r16 ^ 1
            r11.setEditable(r1)
            r11.setEnabled(r14)
            r1 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r13 = "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r13)
            r1 = -954367824(0xffffffffc71d80b0, float:-40320.688)
            java.lang.String r13 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r13)
            java.lang.Object r1 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r1 != r13) goto L_0x066d
            kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r4)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r13 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r13.<init>(r1)
            r4.updateRememberedValue(r13)
            r1 = r13
        L_0x066d:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            kotlinx.coroutines.CoroutineScope r1 = r1.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r13 = -1705256948(0xffffffff9a5bd80c, float:-4.546266E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r13, r6)
            java.lang.Object r13 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r13 != r15) goto L_0x0692
            androidx.compose.foundation.relocation.BringIntoViewRequester r13 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.BringIntoViewRequester()
            r4.updateRememberedValue(r13)
        L_0x0692:
            androidx.compose.foundation.relocation.BringIntoViewRequester r13 = (androidx.compose.foundation.relocation.BringIntoViewRequester) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.Modifier$Companion r15 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r15 = (androidx.compose.ui.Modifier) r15
            r30 = r9
            r9 = -1705248170(0xffffffff9a5bfa56, float:-4.5490358E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r9, r6)
            boolean r9 = r4.changedInstance(r0)
            r50 = r0
            r0 = r12 & 7168(0x1c00, float:1.0045E-41)
            r51 = r9
            r9 = 2048(0x800, float:2.87E-42)
            if (r0 != r9) goto L_0x06b3
            r9 = 1
            goto L_0x06b4
        L_0x06b3:
            r9 = 0
        L_0x06b4:
            r9 = r51 | r9
            r31 = 57344(0xe000, float:8.0356E-41)
            r51 = r9
            r9 = r12 & r31
            r31 = r12
            r12 = 16384(0x4000, float:2.2959E-41)
            if (r9 != r12) goto L_0x06c5
            r12 = 1
            goto L_0x06c6
        L_0x06c5:
            r12 = 0
        L_0x06c6:
            r12 = r51 | r12
            boolean r36 = r4.changedInstance(r7)
            r12 = r12 | r36
            r54 = r7
            r7 = 4
            if (r5 != r7) goto L_0x06d5
            r7 = 1
            goto L_0x06d6
        L_0x06d5:
            r7 = 0
        L_0x06d6:
            r7 = r7 | r12
            r12 = r31 & 112(0x70, float:1.57E-43)
            r12 = r12 ^ 48
            r51 = r7
            r7 = 32
            if (r12 <= r7) goto L_0x06ef
            r7 = r33
            boolean r33 = r4.changed((java.lang.Object) r7)
            if (r33 != 0) goto L_0x06ea
            goto L_0x06f1
        L_0x06ea:
            r33 = r7
            r52 = r14
            goto L_0x06fb
        L_0x06ef:
            r7 = r33
        L_0x06f1:
            r33 = r7
            r7 = r31 & 48
            r52 = r14
            r14 = 32
            if (r7 != r14) goto L_0x06fd
        L_0x06fb:
            r7 = 1
            goto L_0x06fe
        L_0x06fd:
            r7 = 0
        L_0x06fe:
            r7 = r51 | r7
            boolean r14 = r4.changedInstance(r10)
            r7 = r7 | r14
            boolean r14 = r4.changedInstance(r1)
            r7 = r7 | r14
            boolean r14 = r4.changedInstance(r13)
            r7 = r7 | r14
            boolean r14 = r4.changedInstance(r11)
            r7 = r7 | r14
            java.lang.Object r14 = r4.rememberedValue()
            if (r7 != 0) goto L_0x0732
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r14 != r7) goto L_0x0723
            goto L_0x0732
        L_0x0723:
            r7 = r54
            r36 = r13
            r1 = r14
            r13 = r33
            r33 = r8
            r14 = r11
            r11 = r50
            r8 = r52
            goto L_0x0760
        L_0x0732:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1 r7 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
            r55 = r48
            r51 = r50
            r59 = r1
            r50 = r7
            r57 = r10
            r58 = r11
            r60 = r13
            r53 = r16
            r56 = r33
            r50.<init>(r51, r52, r53, r54, r55, r56, r57, r58, r59, r60)
            r41 = r50
            r11 = r51
            r7 = r54
            r13 = r56
            r14 = r58
            r36 = r60
            r33 = r8
            r8 = r52
            r1 = r41
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r4.updateRememberedValue(r1)
        L_0x0760:
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.textFieldFocusModifier(r15, r8, r3, r2, r1)
            if (r8 == 0) goto L_0x076f
            if (r16 != 0) goto L_0x076f
            r15 = 1
            goto L_0x0770
        L_0x076f:
            r15 = 0
        L_0x0770:
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            r60 = r3
            r3 = 0
            androidx.compose.runtime.State r15 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r15, r4, r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r41 = r8
            r8 = -1705195503(0xffffffff9a5cc811, float:-4.5656546E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r6)
            boolean r8 = r4.changed((java.lang.Object) r15)
            boolean r43 = r4.changedInstance(r11)
            r8 = r8 | r43
            boolean r43 = r4.changedInstance(r7)
            r8 = r8 | r43
            boolean r43 = r4.changedInstance(r14)
            r8 = r8 | r43
            r54 = r7
            r7 = 32
            if (r12 <= r7) goto L_0x07ab
            boolean r24 = r4.changed((java.lang.Object) r13)
            if (r24 != 0) goto L_0x07a8
            goto L_0x07ab
        L_0x07a8:
            r50 = r8
            goto L_0x07b1
        L_0x07ab:
            r50 = r8
            r8 = r31 & 48
            if (r8 != r7) goto L_0x07b3
        L_0x07b1:
            r7 = 1
            goto L_0x07b4
        L_0x07b3:
            r7 = 0
        L_0x07b4:
            r7 = r50 | r7
            java.lang.Object r8 = r4.rememberedValue()
            if (r7 != 0) goto L_0x07cb
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x07c5
            goto L_0x07cb
        L_0x07c5:
            r7 = r15
            r15 = r8
            r8 = r7
            r7 = r54
            goto L_0x07e8
        L_0x07cb:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$1 r7 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$1
            r8 = 0
            r51 = r7
            r57 = r8
            r52 = r11
            r56 = r13
            r55 = r14
            r53 = r15
            r51.<init>(r52, r53, r54, r55, r56, r57)
            r15 = r51
            r8 = r53
            r7 = r54
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r4.updateRememberedValue(r15)
        L_0x07e8:
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r61 = r8
            r8 = 6
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r3, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r15, (androidx.compose.runtime.Composer) r4, (int) r8)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r8 = -1705163133(0xffffffff9a5d4683, float:-4.5758688E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r6)
            boolean r8 = r4.changedInstance(r11)
            java.lang.Object r15 = r4.rememberedValue()
            if (r8 != 0) goto L_0x080f
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r15 != r8) goto L_0x081a
        L_0x080f:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
            r8.<init>(r11)
            r15 = r8
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r4.updateRememberedValue(r15)
        L_0x081a:
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.text.selection.SelectionGesturesKt.updateSelectionTouchMode(r3, r15)
            r8 = -1705159310(0xffffffff9a5d5572, float:-4.577075E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r6)
            boolean r8 = r4.changedInstance(r11)
            r15 = 16384(0x4000, float:2.2959E-41)
            if (r9 != r15) goto L_0x0833
            r15 = 1
            goto L_0x0834
        L_0x0833:
            r15 = 0
        L_0x0834:
            r8 = r8 | r15
            r15 = 2048(0x800, float:2.87E-42)
            if (r0 != r15) goto L_0x083b
            r15 = 1
            goto L_0x083c
        L_0x083b:
            r15 = 0
        L_0x083c:
            r8 = r8 | r15
            boolean r15 = r4.changedInstance(r10)
            r8 = r8 | r15
            boolean r15 = r4.changedInstance(r14)
            r8 = r8 | r15
            java.lang.Object r15 = r4.rememberedValue()
            if (r8 != 0) goto L_0x085a
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r15 != r8) goto L_0x0856
            goto L_0x085a
        L_0x0856:
            r8 = r15
            r15 = r41
            goto L_0x0878
        L_0x085a:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
            r53 = r60
            r51 = r8
            r57 = r10
            r52 = r11
            r56 = r14
            r54 = r16
            r55 = r41
            r51.<init>(r52, r53, r54, r55, r56, r57)
            r41 = r51
            r15 = r55
            r8 = r41
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r4.updateRememberedValue(r8)
        L_0x0878:
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.text.TextFieldPressGestureFilterKt.tapPressTextFieldModifier(r3, r2, r15, r8)
            androidx.compose.foundation.text.selection.MouseSelectionObserver r8 = r14.getMouseSelectionObserver$foundation_release()
            r52 = r15
            androidx.compose.foundation.text.TextDragObserver r15 = r14.getTouchSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.text.selection.SelectionGesturesKt.selectionGestureInput(r3, r8, r15)
            androidx.compose.ui.input.pointer.PointerIcon r8 = androidx.compose.foundation.text.TextPointerIcon_androidKt.getTextPointerIcon()
            r62 = r1
            r21 = r2
            r1 = 0
            r2 = 2
            r15 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.pointer.PointerIconKt.pointerHoverIcon$default(r3, r8, r1, r2, r15)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r3 = -1705122293(0xffffffff9a5de60b, float:-4.5887556E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r3, r6)
            boolean r3 = r4.changedInstance(r11)
            r8 = 4
            if (r5 != r8) goto L_0x08b1
            r8 = 1
            goto L_0x08b2
        L_0x08b1:
            r8 = 0
        L_0x08b2:
            r3 = r3 | r8
            boolean r8 = r4.changedInstance(r10)
            r3 = r3 | r8
            java.lang.Object r8 = r4.rememberedValue()
            if (r3 != 0) goto L_0x08cb
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r8 != r3) goto L_0x08c7
            goto L_0x08cb
        L_0x08c7:
            r3 = r8
            r8 = r48
            goto L_0x08d7
        L_0x08cb:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
            r8 = r48
            r3.<init>(r11, r8, r10)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4.updateRememberedValue(r3)
        L_0x08d7:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.draw.DrawModifierKt.drawBehind(r1, r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r15 = -1705102808(0xffffffff9a5e3228, float:-4.594904E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r15, r6)
            boolean r15 = r4.changedInstance(r11)
            r64 = r1
            r1 = 2048(0x800, float:2.87E-42)
            if (r0 != r1) goto L_0x08f6
            r1 = 1
            goto L_0x08f7
        L_0x08f6:
            r1 = 0
        L_0x08f7:
            r1 = r1 | r15
            r15 = r34
            boolean r34 = r4.changed((java.lang.Object) r15)
            r1 = r1 | r34
            boolean r34 = r4.changedInstance(r14)
            r1 = r1 | r34
            r50 = r1
            r1 = 4
            if (r5 != r1) goto L_0x090d
            r1 = 1
            goto L_0x090e
        L_0x090d:
            r1 = 0
        L_0x090e:
            r1 = r50 | r1
            boolean r34 = r4.changedInstance(r10)
            r1 = r1 | r34
            r50 = r1
            java.lang.Object r1 = r4.rememberedValue()
            if (r50 != 0) goto L_0x092a
            androidx.compose.runtime.Composer$Companion r34 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r34.getEmpty()
            if (r1 != r8) goto L_0x0927
            goto L_0x092a
        L_0x0927:
            r8 = r52
            goto L_0x0942
        L_0x092a:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1 r1 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
            r55 = r48
            r50 = r1
            r56 = r10
            r51 = r11
            r54 = r14
            r53 = r15
            r50.<init>(r51, r52, r53, r54, r55, r56)
            r8 = r52
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r4.updateRememberedValue(r1)
        L_0x0942:
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r3, r1)
            r3 = r33
            r33 = r1
            boolean r1 = r3 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.Modifier$Companion r34 = androidx.compose.ui.Modifier.Companion
            r41 = r3
            r3 = r34
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r52 = r8
            r8 = -1705046115(0xffffffff9a5f0f9d, float:-4.612793E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r6)
            r8 = r39
            boolean r34 = r4.changedInstance(r8)
            r8 = 4
            if (r5 != r8) goto L_0x096c
            r8 = 1
            goto L_0x096d
        L_0x096c:
            r8 = 0
        L_0x096d:
            r8 = r34 | r8
            r50 = r8
            r8 = 2048(0x800, float:2.87E-42)
            if (r0 != r8) goto L_0x0977
            r0 = 1
            goto L_0x0978
        L_0x0977:
            r0 = 0
        L_0x0978:
            r0 = r50 | r0
            boolean r8 = r4.changed((boolean) r1)
            r0 = r0 | r8
            r8 = 16384(0x4000, float:2.2959E-41)
            if (r9 != r8) goto L_0x0985
            r8 = 1
            goto L_0x0986
        L_0x0985:
            r8 = 0
        L_0x0986:
            r0 = r0 | r8
            boolean r8 = r4.changedInstance(r11)
            r0 = r0 | r8
            boolean r8 = r4.changedInstance(r10)
            r0 = r0 | r8
            boolean r8 = r4.changedInstance(r14)
            r0 = r0 | r8
            r8 = 32
            if (r12 <= r8) goto L_0x09a0
            boolean r9 = r4.changed((java.lang.Object) r13)
            if (r9 != 0) goto L_0x09a4
        L_0x09a0:
            r9 = r31 & 48
            if (r9 != r8) goto L_0x09a6
        L_0x09a4:
            r8 = 1
            goto L_0x09a7
        L_0x09a6:
            r8 = 0
        L_0x09a7:
            r0 = r0 | r8
            java.lang.Object r8 = r4.rememberedValue()
            if (r0 != 0) goto L_0x09be
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r8 != r0) goto L_0x09b7
            goto L_0x09be
        L_0x09b7:
            r0 = r60
            r9 = r8
            r1 = r13
            r8 = r52
            goto L_0x09e4
        L_0x09be:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
            r53 = r52
            r50 = r0
            r54 = r1
            r58 = r10
            r57 = r11
            r56 = r13
            r59 = r14
            r55 = r16
            r51 = r39
            r52 = r48
            r50.<init>(r51, r52, r53, r54, r55, r56, r57, r58, r59, r60)
            r9 = r50
            r8 = r53
            r1 = r56
            r0 = r60
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r4.updateRememberedValue(r9)
        L_0x09e4:
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r13 = 1
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r3, r13, r9)
            if (r8 == 0) goto L_0x0a00
            if (r16 != 0) goto L_0x0a00
            boolean r9 = r15.isWindowFocused()
            if (r9 == 0) goto L_0x0a00
            boolean r9 = r11.hasHighlight()
            if (r9 != 0) goto L_0x0a00
            r9 = 1
            goto L_0x0a01
        L_0x0a00:
            r9 = 0
        L_0x0a01:
            androidx.compose.ui.Modifier$Companion r25 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r25 = (androidx.compose.ui.Modifier) r25
            r52 = r48
            r54 = r63
            r55 = r9
            r53 = r10
            r51 = r11
            r50 = r25
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.text.TextFieldCursorKt.cursor(r50, r51, r52, r53, r54, r55)
            r13 = r51
            r10 = r52
            r11 = r53
            r25 = r54
            r60 = r9
            r9 = -1704832829(0xffffffff9a6250c3, float:-4.6800943E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r9, r6)
            boolean r9 = r4.changedInstance(r14)
            r51 = r9
            java.lang.Object r9 = r4.rememberedValue()
            if (r51 != 0) goto L_0x0a3c
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            r57 = r11
            java.lang.Object r11 = r26.getEmpty()
            if (r9 != r11) goto L_0x0a48
            goto L_0x0a3e
        L_0x0a3c:
            r57 = r11
        L_0x0a3e:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1 r9 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
            r9.<init>(r14)
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r4.updateRememberedValue(r9)
        L_0x0a48:
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r11 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r14, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r9, (androidx.compose.runtime.Composer) r4, (int) r11)
            r9 = -1704829391(0xffffffff9a625e31, float:-4.6811792E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r9, r6)
            boolean r9 = r4.changedInstance(r13)
            boolean r23 = r4.changedInstance(r7)
            r9 = r9 | r23
            r11 = 4
            if (r5 != r11) goto L_0x0a66
            r5 = 1
            goto L_0x0a67
        L_0x0a66:
            r5 = 0
        L_0x0a67:
            r5 = r5 | r9
            r9 = 32
            if (r12 <= r9) goto L_0x0a72
            boolean r11 = r4.changed((java.lang.Object) r1)
            if (r11 != 0) goto L_0x0a76
        L_0x0a72:
            r11 = r31 & 48
            if (r11 != r9) goto L_0x0a78
        L_0x0a76:
            r9 = 1
            goto L_0x0a79
        L_0x0a78:
            r9 = 0
        L_0x0a79:
            r5 = r5 | r9
            java.lang.Object r9 = r4.rememberedValue()
            if (r5 != 0) goto L_0x0a88
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r9 != r5) goto L_0x0a93
        L_0x0a88:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
            r5.<init>(r13, r7, r10, r1)
            r9 = r5
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r4.updateRememberedValue(r9)
        L_0x0a93:
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            int r5 = r31 >> 3
            r5 = r5 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r9, (androidx.compose.runtime.Composer) r4, (int) r5)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            kotlin.jvm.functions.Function1 r7 = r13.getOnValueChange()
            r9 = r16 ^ 1
            r26 = r5
            r5 = r38
            r11 = 1
            if (r5 != r11) goto L_0x0ab3
            r27 = r11
            goto L_0x0ab5
        L_0x0ab3:
            r27 = 0
        L_0x0ab5:
            int r28 = r1.m6770getImeActioneUduSuo()
            r54 = r7
            r55 = r9
            r53 = r10
            r51 = r13
            r52 = r14
            r50 = r26
            r56 = r27
            r59 = r28
            r58 = r30
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.text.TextFieldKeyInputKt.m1274textFieldKeyInput2WJ9YEU(r50, r51, r52, r53, r54, r55, r56, r57, r58, r59)
            r10 = r57
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            boolean r11 = CoreTextField$lambda$11(r61)
            r38 = r5
            r5 = -1704798381(0xffffffff9a62d753, float:-4.6909642E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r5, r6)
            boolean r5 = r4.changedInstance(r13)
            r6 = 32
            if (r12 <= r6) goto L_0x0aef
            boolean r12 = r4.changed((java.lang.Object) r1)
            if (r12 != 0) goto L_0x0af3
        L_0x0aef:
            r12 = r31 & 48
            if (r12 != r6) goto L_0x0af5
        L_0x0af3:
            r6 = 1
            goto L_0x0af6
        L_0x0af5:
            r6 = 0
        L_0x0af6:
            r5 = r5 | r6
            r6 = r37
            boolean r12 = r4.changedInstance(r6)
            r5 = r5 | r12
            java.lang.Object r12 = r4.rememberedValue()
            if (r5 != 0) goto L_0x0b0c
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r12 != r5) goto L_0x0b17
        L_0x0b0c:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
            r5.<init>(r13, r0, r1, r6)
            r12 = r5
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r4.updateRememberedValue(r12)
        L_0x0b17:
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.handwriting.StylusHandwritingKt.stylusHandwriting(r9, r11, r12)
            r5 = r35
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(r5, r6, r13, r14)
            androidx.compose.ui.Modifier r0 = r6.then(r0)
            r6 = r62
            androidx.compose.ui.Modifier r0 = r0.then(r6)
            r11 = r32
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(r0, r13, r11)
            androidx.compose.ui.Modifier r0 = previewKeyEventToDeselectOnBack(r0, r13, r14)
            androidx.compose.ui.Modifier r0 = r0.then(r7)
            r6 = r20
            r9 = r21
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldScrollKt.textFieldScrollable(r0, r6, r9, r8)
            androidx.compose.ui.Modifier r0 = r0.then(r2)
            androidx.compose.ui.Modifier r0 = r0.then(r3)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1 r2 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
            r2.<init>(r13)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r2)
            if (r8 == 0) goto L_0x0b6f
            boolean r2 = r13.getHasFocus()
            if (r2 == 0) goto L_0x0b6f
            boolean r2 = r13.isInTouchMode()
            if (r2 == 0) goto L_0x0b6f
            boolean r2 = r15.isWindowFocused()
            if (r2 == 0) goto L_0x0b6f
            r15 = 1
            goto L_0x0b70
        L_0x0b6f:
            r15 = 0
        L_0x0b70:
            if (r15 == 0) goto L_0x0b7b
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.textFieldMagnifier(r2, r14)
            goto L_0x0b7f
        L_0x0b7b:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
        L_0x0b7f:
            r12 = r2
            r2 = r0
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
            r3 = r41
            r41 = r8
            r8 = r3
            r7 = r48
            r46 = r2
            r45 = r4
            r35 = r5
            r21 = r9
            r2 = r13
            r4 = r22
            r11 = r33
            r13 = r36
            r5 = r38
            r3 = r42
            r9 = r60
            r33 = r1
            r1 = r18
            r18 = r10
            r10 = r64
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r3 = r8
            r2 = 54
            r6 = -374338080(0xffffffffe9b00de0, float:-2.6604558E25)
            r7 = r45
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r13, r0, r7, r2)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r2 = 384(0x180, float:5.38E-43)
            r6 = r46
            CoreTextFieldRootBox(r6, r14, r0, r7, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0bc9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0bc9:
            r11 = r4
            r10 = r5
            r45 = r7
            r15 = r16
            r6 = r17
            r7 = r21
            r8 = r25
            r13 = r29
            r12 = r33
            r9 = r40
            r14 = r41
            r4 = r42
            r16 = r1
            r5 = r3
            r3 = r35
        L_0x0be4:
            androidx.compose.runtime.ScopeUpdateScope r0 = r45.endRestartGroup()
            if (r0 == 0) goto L_0x0c03
            r1 = r0
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6
            r2 = r49
            r17 = r65
            r18 = r66
            r19 = r67
            r47 = r1
            r1 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r47
            r1.updateScope(r0)
        L_0x0c03:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-20551815);
        ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextFieldRootBox)P(2,1)802@36846L95:CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(textFieldSelectionManager) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-20551815, i2, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:801)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r5 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r5, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1183915871, "C803@36902L33:CoreTextField.kt#423gt5");
            ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, startRestartGroup, (i2 >> 3) & WebSocketProtocol.PAYLOAD_SHORT);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$CoreTextFieldRootBox$2(modifier, textFieldSelectionManager, function2, i));
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new CoreTextFieldKt$previewKeyEventToDeselectOnBack$1(legacyTextFieldState, textFieldSelectionManager));
    }

    /* access modifiers changed from: private */
    public static final void tapToFocus(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z) {
        SoftwareKeyboardController keyboardController;
        if (!legacyTextFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else if (z && (keyboardController = legacyTextFieldState.getKeyboardController()) != null) {
            keyboardController.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        TextFieldValue textFieldValue2 = textFieldValue;
        legacyTextFieldState.setInputSession(TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, textFieldValue2, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(legacyTextFieldState, textFieldValue2, offsetMapping);
    }

    /* access modifiers changed from: private */
    public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession inputSession = legacyTextFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.Companion.onBlur$foundation_release(inputSession, legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange());
        }
        legacyTextFieldState.setInputSession((TextInputSession) null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect rect;
        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m6561getMaximpl(textFieldValue.m6823getSelectiond9O1mEE()));
        if (originalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed);
        } else if (originalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, (float) IntSize.m7282getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), (String) null, 0, 24, (Object) null)));
        }
        Object bringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
        return bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringIntoView : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(TextFieldSelectionManager textFieldSelectionManager, boolean z, Composer composer, int i) {
        int i2;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer startRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionToolbarAndHandles):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, i2, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1146)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(-1286242594);
                ComposerKt.sourceInformation(startRestartGroup, "");
                LegacyTextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
                TextLayoutResult textLayoutResult = null;
                if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null)) {
                    LegacyTextFieldState state$foundation_release2 = textFieldSelectionManager.getState$foundation_release();
                    if (!(state$foundation_release2 != null ? state$foundation_release2.isLayoutResultStale() : true)) {
                        textLayoutResult = value;
                    }
                }
                if (textLayoutResult == null) {
                    startRestartGroup.startReplaceGroup(-1285984396);
                } else {
                    startRestartGroup.startReplaceGroup(-1285984395);
                    ComposerKt.sourceInformation(startRestartGroup, "");
                    if (!TextRange.m6558getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().m6823getSelectiond9O1mEE())) {
                        startRestartGroup.startReplaceGroup(-1680616096);
                        ComposerKt.sourceInformation(startRestartGroup, "");
                        int originalToTransformed = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m6564getStartimpl(textFieldSelectionManager.getValue$foundation_release().m6823getSelectiond9O1mEE()));
                        int originalToTransformed2 = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m6559getEndimpl(textFieldSelectionManager.getValue$foundation_release().m6823getSelectiond9O1mEE()));
                        ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(originalToTransformed);
                        ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(originalToTransformed2 - 1, 0));
                        LegacyTextFieldState state$foundation_release3 = textFieldSelectionManager.getState$foundation_release();
                        if (state$foundation_release3 == null || !state$foundation_release3.getShowSelectionHandleStart()) {
                            startRestartGroup.startReplaceGroup(-1679975078);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(-1680216289);
                            ComposerKt.sourceInformation(startRestartGroup, "1158@51449L203");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, startRestartGroup, ((i2 << 6) & 896) | 6);
                            startRestartGroup.endReplaceGroup();
                        }
                        LegacyTextFieldState state$foundation_release4 = textFieldSelectionManager.getState$foundation_release();
                        if (state$foundation_release4 == null || !state$foundation_release4.getShowSelectionHandleEnd()) {
                            startRestartGroup.startReplaceGroup(-1679655654);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(-1679895904);
                            ComposerKt.sourceInformation(startRestartGroup, "1165@51772L202");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, startRestartGroup, ((i2 << 6) & 896) | 6);
                            startRestartGroup.endReplaceGroup();
                        }
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-1679637798);
                        startRestartGroup.endReplaceGroup();
                    }
                    LegacyTextFieldState state$foundation_release5 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release5 != null) {
                        if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                            state$foundation_release5.setShowFloatingToolbar(false);
                        }
                        if (state$foundation_release5.getHasFocus()) {
                            if (state$foundation_release5.getShowFloatingToolbar()) {
                                textFieldSelectionManager.showSelectionToolbar$foundation_release();
                            } else {
                                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(651305535);
                startRestartGroup.endReplaceGroup();
                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$SelectionToolbarAndHandles$2(textFieldSelectionManager, z, i));
        }
    }

    public static final void TextFieldCursorHandle(TextFieldSelectionManager textFieldSelectionManager, Composer composer, int i) {
        int i2;
        AnnotatedString transformedText$foundation_release;
        Composer startRestartGroup = composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436003720, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1189)");
            }
            LegacyTextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
            if (state$foundation_release == null || !state$foundation_release.getShowCursorHandle() || (transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release()) == null || transformedText$foundation_release.length() <= 0) {
                startRestartGroup.startReplaceGroup(-284257090);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-285446808);
                ComposerKt.sourceInformation(startRestartGroup, "1191@52866L50,1192@52979L7,1194@53039L12,1196@53125L601,1208@53754L309,1193@52996L1077");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -424850346, "CC(remember):CoreTextField.kt#9igjgp");
                boolean changed = startRestartGroup.changed((Object) textFieldSelectionManager);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                long r3 = textFieldSelectionManager.m1650getCursorPositiontuRUvjQ$foundation_release((Density) consume);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -424844848, "CC(remember):CoreTextField.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed(r3);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new CoreTextFieldKt$TextFieldCursorHandle$1$1(r3);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -424841507, "CC(remember):CoreTextField.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(textDragObserver) | startRestartGroup.changedInstance(textFieldSelectionManager);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(textDragObserver, textFieldSelectionManager, (Continuation<? super CoreTextFieldKt$TextFieldCursorHandle$2$1>) null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue3);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -424821671, "CC(remember):CoreTextField.kt#9igjgp");
                boolean changed3 = startRestartGroup.changed(r3);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new CoreTextFieldKt$TextFieldCursorHandle$3$1(r3);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                AndroidCursorHandle_androidKt.m1153CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) rememberedValue4, 1, (Object) null), 0, startRestartGroup, 0, 4);
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
            endRestartGroup.updateScope(new CoreTextFieldKt$TextFieldCursorHandle$4(textFieldSelectionManager, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult == null) {
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                return;
            }
            TextInputSession inputSession = legacyTextFieldState.getInputSession();
            if (inputSession == null) {
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                return;
            }
            LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
            if (layoutCoordinates == null) {
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                return;
            }
            TextFieldDelegate.Companion.notifyFocusedRect$foundation_release(textFieldValue, legacyTextFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        } catch (Throwable th) {
            Throwable th2 = th;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
