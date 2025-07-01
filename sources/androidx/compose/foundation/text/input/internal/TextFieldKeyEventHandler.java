package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyEventHelpers_androidKt;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JP\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J:\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J:\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\n2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00170%¢\u0006\u0002\b'H\bJ\f\u0010(\u001a\u00020)*\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "", "()V", "deadKeyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "preparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "onKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "", "onKeyEvent-6ptp14s", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZZLkotlin/jvm/functions/Function0;)Z", "onPreKeyEvent", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "preparedSelectionContext", "state", "isFromSoftKeyboard", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", "Lkotlin/ExtensionFunctionType;", "getVisibleTextLayoutHeight", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldKeyEventHandler.kt */
public abstract class TextFieldKeyEventHandler {
    public static final int $stable = 8;
    private final DeadKeyCombiner deadKeyCombiner = new DeadKeyCombiner();
    private final KeyMapping keyMapping = KeyMapping_androidKt.getPlatformDefaultKeyMapping();
    private final TextFieldPreparedSelectionState preparedSelectionState = new TextFieldPreparedSelectionState();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldKeyEventHandler.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(98:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|(2:95|96)|97|99) */
        /* JADX WARNING: Can't wrap try/catch for region: R(99:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|99) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x010e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0118 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0122 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0136 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0140 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x014a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0154 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x015e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0168 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0172 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x017c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0186 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0190 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x019a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x01a4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x01ae */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x01b8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x01c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x01cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x01d6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.compose.foundation.text.KeyCommand[] r0 = androidx.compose.foundation.text.KeyCommand.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.COPY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.PASTE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.CUT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LEFT_CHAR     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.RIGHT_CHAR     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LEFT_WORD     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.RIGHT_WORD     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.PREV_PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.NEXT_PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.UP     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DOWN     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.PAGE_UP     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.PAGE_DOWN     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LINE_START     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LINE_END     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LINE_LEFT     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.LINE_RIGHT     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.HOME     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.END     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_PREV_CHAR     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_NEXT_CHAR     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_PREV_WORD     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_NEXT_WORD     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_FROM_LINE_START     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DELETE_TO_LINE_END     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.NEW_LINE     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.TAB     // Catch:{ NoSuchFieldError -> 0x010e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_ALL     // Catch:{ NoSuchFieldError -> 0x0118 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0118 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0118 }
            L_0x0118:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LEFT_CHAR     // Catch:{ NoSuchFieldError -> 0x0122 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0122 }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0122 }
            L_0x0122:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_RIGHT_CHAR     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LEFT_WORD     // Catch:{ NoSuchFieldError -> 0x0136 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0136 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0136 }
            L_0x0136:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_RIGHT_WORD     // Catch:{ NoSuchFieldError -> 0x0140 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0140 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0140 }
            L_0x0140:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_PREV_PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x014a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x014a }
                r2 = 33
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x014a }
            L_0x014a:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_NEXT_PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x0154 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0154 }
                r2 = 34
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0154 }
            L_0x0154:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LINE_START     // Catch:{ NoSuchFieldError -> 0x015e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015e }
                r2 = 35
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015e }
            L_0x015e:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LINE_END     // Catch:{ NoSuchFieldError -> 0x0168 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0168 }
                r2 = 36
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0168 }
            L_0x0168:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LINE_LEFT     // Catch:{ NoSuchFieldError -> 0x0172 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0172 }
                r2 = 37
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0172 }
            L_0x0172:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_LINE_RIGHT     // Catch:{ NoSuchFieldError -> 0x017c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x017c }
                r2 = 38
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x017c }
            L_0x017c:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_UP     // Catch:{ NoSuchFieldError -> 0x0186 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0186 }
                r2 = 39
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0186 }
            L_0x0186:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_DOWN     // Catch:{ NoSuchFieldError -> 0x0190 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0190 }
                r2 = 40
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0190 }
            L_0x0190:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_PAGE_UP     // Catch:{ NoSuchFieldError -> 0x019a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x019a }
                r2 = 41
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x019a }
            L_0x019a:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_PAGE_DOWN     // Catch:{ NoSuchFieldError -> 0x01a4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a4 }
                r2 = 42
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01a4 }
            L_0x01a4:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_HOME     // Catch:{ NoSuchFieldError -> 0x01ae }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01ae }
                r2 = 43
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01ae }
            L_0x01ae:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.SELECT_END     // Catch:{ NoSuchFieldError -> 0x01b8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b8 }
                r2 = 44
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01b8 }
            L_0x01b8:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.DESELECT     // Catch:{ NoSuchFieldError -> 0x01c2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01c2 }
                r2 = 45
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01c2 }
            L_0x01c2:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.UNDO     // Catch:{ NoSuchFieldError -> 0x01cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01cc }
                r2 = 46
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01cc }
            L_0x01cc:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.REDO     // Catch:{ NoSuchFieldError -> 0x01d6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01d6 }
                r2 = 47
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01d6 }
            L_0x01d6:
                androidx.compose.foundation.text.KeyCommand r1 = androidx.compose.foundation.text.KeyCommand.CHARACTER_PALETTE     // Catch:{ NoSuchFieldError -> 0x01e0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01e0 }
                r2 = 48
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01e0 }
            L_0x01e0:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler.WhenMappings.<clinit>():void");
        }
    }

    /* renamed from: onPreKeyEvent-MyFupTE  reason: not valid java name */
    public boolean m1417onPreKeyEventMyFupTE(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController softwareKeyboardController) {
        if (TextRange.m6558getCollapsedimpl(transformedTextFieldState.getVisualText().m1312getSelectiond9O1mEE()) || !KeyEventHelpers_androidKt.m1189cancelsTextSelectionZmokQxo(keyEvent)) {
            return false;
        }
        textFieldSelectionState.deselect();
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x03f6, code lost:
        if (androidx.compose.ui.text.TextRange.m6557equalsimpl0(r6.m1470getSelectiond9O1mEE(), r6.getInitialValue().m1312getSelectiond9O1mEE()) != false) goto L_0x0401;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x03f8, code lost:
        r18.m1449selectCharsIn5zctL8(r6.m1470getSelectiond9O1mEE());
     */
    /* renamed from: onKeyEvent-6ptp14s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m1416onKeyEvent6ptp14s(android.view.KeyEvent r17, androidx.compose.foundation.text.input.internal.TransformedTextFieldState r18, androidx.compose.foundation.text.input.internal.TextLayoutState r19, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r20, boolean r21, boolean r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = androidx.compose.ui.input.key.KeyEvent_androidKt.m5431getTypeZmokQxo(r1)
            androidx.compose.ui.input.key.KeyEventType$Companion r3 = androidx.compose.ui.input.key.KeyEventType.Companion
            int r3 = r3.m5427getKeyDownCS__XNY()
            boolean r2 = androidx.compose.ui.input.key.KeyEventType.m5423equalsimpl0(r2, r3)
            r3 = 0
            if (r2 != 0) goto L_0x0016
            return r3
        L_0x0016:
            boolean r2 = androidx.compose.foundation.text.TextFieldKeyInput_androidKt.m1277isTypedEventZmokQxo(r1)
            r4 = 1
            if (r2 == 0) goto L_0x0067
            androidx.compose.foundation.text.DeadKeyCombiner r2 = r0.deadKeyCombiner
            java.lang.Integer r2 = r2.m1186consumeZmokQxo(r1)
            if (r2 == 0) goto L_0x0067
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r6 = 2
            r5.<init>(r6)
            int r2 = r2.intValue()
            java.lang.StringBuilder r2 = androidx.compose.foundation.text.StringHelpers_jvmKt.appendCodePointX(r5, r2)
            java.lang.String r2 = r2.toString()
            if (r21 == 0) goto L_0x0066
            boolean r1 = androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler_androidKt.m1419isFromSoftKeyboardZmokQxo(r1)
            r1 = r1 ^ r4
            androidx.compose.foundation.text.input.TextFieldState r3 = r18.textFieldState
            androidx.compose.foundation.text.input.InputTransformation r5 = r18.inputTransformation
            androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior r6 = androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior.MergeIfPossible
            androidx.compose.foundation.text.input.internal.EditingBuffer r7 = r3.getMainBuffer$foundation_release()
            androidx.compose.foundation.text.input.internal.ChangeTracker r7 = r7.getChangeTracker()
            r7.clearChanges()
            androidx.compose.foundation.text.input.internal.EditingBuffer r7 = r3.getMainBuffer$foundation_release()
            r7.commitComposition()
            androidx.compose.foundation.text.input.internal.EditCommandKt.commitText(r7, r2, r4)
            r3.commitEditAsUser(r5, r1, r6)
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState r1 = r0.preparedSelectionState
            r1.resetCachedX()
            return r4
        L_0x0066:
            return r3
        L_0x0067:
            androidx.compose.foundation.text.KeyMapping r2 = r0.keyMapping
            androidx.compose.foundation.text.KeyCommand r2 = r2.m1190mapZmokQxo(r1)
            if (r2 == 0) goto L_0x0401
            boolean r5 = r2.getEditsText()
            if (r5 == 0) goto L_0x0079
            if (r21 != 0) goto L_0x0079
            goto L_0x0401
        L_0x0079:
            boolean r9 = androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler_androidKt.m1419isFromSoftKeyboardZmokQxo(r1)
            androidx.compose.ui.text.TextLayoutResult r8 = r19.getLayoutResult()
            r1 = r19
            float r10 = r0.getVisibleTextLayoutHeight(r1)
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r6 = new androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState r11 = r0.preparedSelectionState
            r7 = r18
            r6.<init>(r7, r8, r9, r10, r11)
            int[] r1 = androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = -1
            r5 = 0
            java.lang.String r7 = ""
            switch(r1) {
                case 1: goto L_0x03e0;
                case 2: goto L_0x03dc;
                case 3: goto L_0x03d8;
                case 4: goto L_0x03d0;
                case 5: goto L_0x03c8;
                case 6: goto L_0x03c4;
                case 7: goto L_0x03c0;
                case 8: goto L_0x03bc;
                case 9: goto L_0x03b8;
                case 10: goto L_0x03b4;
                case 11: goto L_0x03b0;
                case 12: goto L_0x03ac;
                case 13: goto L_0x03a8;
                case 14: goto L_0x03a4;
                case 15: goto L_0x03a0;
                case 16: goto L_0x039c;
                case 17: goto L_0x0398;
                case 18: goto L_0x0394;
                case 19: goto L_0x0390;
                case 20: goto L_0x0328;
                case 21: goto L_0x02bf;
                case 22: goto L_0x0277;
                case 23: goto L_0x022f;
                case 24: goto L_0x01e7;
                case 25: goto L_0x019f;
                case 26: goto L_0x0172;
                case 27: goto L_0x014a;
                case 28: goto L_0x0145;
                case 29: goto L_0x013c;
                case 30: goto L_0x0133;
                case 31: goto L_0x012a;
                case 32: goto L_0x0121;
                case 33: goto L_0x0118;
                case 34: goto L_0x010f;
                case 35: goto L_0x0106;
                case 36: goto L_0x00fd;
                case 37: goto L_0x00f4;
                case 38: goto L_0x00eb;
                case 39: goto L_0x00e2;
                case 40: goto L_0x00d9;
                case 41: goto L_0x00d0;
                case 42: goto L_0x00c7;
                case 43: goto L_0x00be;
                case 44: goto L_0x00b5;
                case 45: goto L_0x00b0;
                case 46: goto L_0x00ab;
                case 47: goto L_0x00a6;
                case 48: goto L_0x00a1;
                default: goto L_0x009f;
            }
        L_0x009f:
            goto L_0x03e5
        L_0x00a1:
            androidx.compose.foundation.text.KeyEventHelpers_androidKt.showCharacterPalette()
            goto L_0x03e5
        L_0x00a6:
            r18.redo()
            goto L_0x03e5
        L_0x00ab:
            r18.undo()
            goto L_0x03e5
        L_0x00b0:
            r6.deselect()
            goto L_0x03e5
        L_0x00b5:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorToEnd()
            r1.selectMovement()
            goto L_0x03e5
        L_0x00be:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorToHome()
            r1.selectMovement()
            goto L_0x03e5
        L_0x00c7:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorDownByPage()
            r1.selectMovement()
            goto L_0x03e5
        L_0x00d0:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorUpByPage()
            r1.selectMovement()
            goto L_0x03e5
        L_0x00d9:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorDownByLine()
            r1.selectMovement()
            goto L_0x03e5
        L_0x00e2:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorUpByLine()
            r1.selectMovement()
            goto L_0x03e5
        L_0x00eb:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorToLineRightSide()
            r1.selectMovement()
            goto L_0x03e5
        L_0x00f4:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorToLineLeftSide()
            r1.selectMovement()
            goto L_0x03e5
        L_0x00fd:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorToLineEnd()
            r1.selectMovement()
            goto L_0x03e5
        L_0x0106:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorToLineStart()
            r1.selectMovement()
            goto L_0x03e5
        L_0x010f:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorNextByParagraph()
            r1.selectMovement()
            goto L_0x03e5
        L_0x0118:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorPrevByParagraph()
            r1.selectMovement()
            goto L_0x03e5
        L_0x0121:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorRightByWord()
            r1.selectMovement()
            goto L_0x03e5
        L_0x012a:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorLeftByWord()
            r1.selectMovement()
            goto L_0x03e5
        L_0x0133:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorRight()
            r1.selectMovement()
            goto L_0x03e5
        L_0x013c:
            androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection r1 = r6.moveCursorLeft()
            r1.selectMovement()
            goto L_0x03e5
        L_0x0145:
            r6.selectAll()
            goto L_0x03e5
        L_0x014a:
            if (r22 != 0) goto L_0x03e6
            androidx.compose.foundation.text.input.TextFieldState r1 = r18.textFieldState
            androidx.compose.foundation.text.input.InputTransformation r2 = r18.inputTransformation
            androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior r3 = androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior.MergeIfPossible
            androidx.compose.foundation.text.input.internal.EditingBuffer r5 = r1.getMainBuffer$foundation_release()
            androidx.compose.foundation.text.input.internal.ChangeTracker r5 = r5.getChangeTracker()
            r5.clearChanges()
            androidx.compose.foundation.text.input.internal.EditingBuffer r5 = r1.getMainBuffer$foundation_release()
            r5.commitComposition()
            java.lang.String r7 = "\t"
            androidx.compose.foundation.text.input.internal.EditCommandKt.commitText(r5, r7, r4)
            r1.commitEditAsUser(r2, r4, r3)
            goto L_0x03e5
        L_0x0172:
            if (r22 != 0) goto L_0x019a
            androidx.compose.foundation.text.input.TextFieldState r1 = r18.textFieldState
            androidx.compose.foundation.text.input.InputTransformation r2 = r18.inputTransformation
            androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior r3 = androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior.MergeIfPossible
            androidx.compose.foundation.text.input.internal.EditingBuffer r5 = r1.getMainBuffer$foundation_release()
            androidx.compose.foundation.text.input.internal.ChangeTracker r5 = r5.getChangeTracker()
            r5.clearChanges()
            androidx.compose.foundation.text.input.internal.EditingBuffer r5 = r1.getMainBuffer$foundation_release()
            r5.commitComposition()
            java.lang.String r7 = "\n"
            androidx.compose.foundation.text.input.internal.EditCommandKt.commitText(r5, r7, r4)
            r1.commitEditAsUser(r2, r4, r3)
            goto L_0x03e5
        L_0x019a:
            r23.invoke()
            goto L_0x03e5
        L_0x019f:
            long r1 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6558getCollapsedimpl(r1)
            if (r1 != 0) goto L_0x01c2
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            long r10 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x01c2:
            long r1 = r6.m1470getSelectiond9O1mEE()
            int r1 = androidx.compose.ui.text.TextRange.m6564getStartimpl(r1)
            int r2 = r6.getLineEndByOffset()
            long r10 = androidx.compose.ui.text.TextRangeKt.TextRange(r1, r2)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x01e7:
            long r1 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6558getCollapsedimpl(r1)
            if (r1 != 0) goto L_0x020a
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            long r10 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x020a:
            int r1 = r6.getLineStartByOffset()
            long r2 = r6.m1470getSelectiond9O1mEE()
            int r2 = androidx.compose.ui.text.TextRange.m6559getEndimpl(r2)
            long r10 = androidx.compose.ui.text.TextRangeKt.TextRange(r1, r2)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x022f:
            long r1 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6558getCollapsedimpl(r1)
            if (r1 != 0) goto L_0x0252
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            long r10 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x0252:
            long r1 = r6.m1470getSelectiond9O1mEE()
            int r1 = androidx.compose.ui.text.TextRange.m6564getStartimpl(r1)
            int r2 = r6.getNextWordOffset()
            long r10 = androidx.compose.ui.text.TextRangeKt.TextRange(r1, r2)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x0277:
            long r1 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6558getCollapsedimpl(r1)
            if (r1 != 0) goto L_0x029a
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            long r10 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x029a:
            int r1 = r6.getPreviousWordOffset()
            long r2 = r6.m1470getSelectiond9O1mEE()
            int r2 = androidx.compose.ui.text.TextRange.m6559getEndimpl(r2)
            long r10 = androidx.compose.ui.text.TextRangeKt.TextRange(r1, r2)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x02bf:
            long r8 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6558getCollapsedimpl(r8)
            if (r1 != 0) goto L_0x02e2
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            long r10 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x02e2:
            int r1 = r6.getNextCharacterIndex()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3 = r1
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r3 == r2) goto L_0x02f4
            goto L_0x02f5
        L_0x02f4:
            r1 = r5
        L_0x02f5:
            if (r1 == 0) goto L_0x030d
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            long r2 = r6.m1470getSelectiond9O1mEE()
            int r2 = androidx.compose.ui.text.TextRange.m6564getStartimpl(r2)
            long r1 = androidx.compose.ui.text.TextRangeKt.TextRange(r2, r1)
            androidx.compose.ui.text.TextRange r5 = androidx.compose.ui.text.TextRange.m6552boximpl(r1)
        L_0x030d:
            if (r5 == 0) goto L_0x03e5
            long r10 = r5.m6568unboximpl()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x0328:
            long r8 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6558getCollapsedimpl(r8)
            if (r1 != 0) goto L_0x034b
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            long r10 = r6.m1470getSelectiond9O1mEE()
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x034b:
            int r1 = r6.getPrecedingCharacterIndex()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3 = r1
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r3 == r2) goto L_0x035d
            goto L_0x035e
        L_0x035d:
            r1 = r5
        L_0x035e:
            if (r1 == 0) goto L_0x0376
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            long r2 = r6.m1470getSelectiond9O1mEE()
            int r2 = androidx.compose.ui.text.TextRange.m6559getEndimpl(r2)
            long r1 = androidx.compose.ui.text.TextRangeKt.TextRange(r1, r2)
            androidx.compose.ui.text.TextRange r5 = androidx.compose.ui.text.TextRange.m6552boximpl(r1)
        L_0x0376:
            if (r5 == 0) goto L_0x03e5
            long r10 = r5.m6568unboximpl()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r8 = r6.state
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r1 = r6.isFromSoftKeyboard
            r13 = r1 ^ 1
            r14 = 4
            r15 = 0
            r12 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1442replaceTextM8tDOmk$default(r8, r9, r10, r12, r13, r14, r15)
            goto L_0x03e5
        L_0x0390:
            r6.moveCursorToEnd()
            goto L_0x03e5
        L_0x0394:
            r6.moveCursorToHome()
            goto L_0x03e5
        L_0x0398:
            r6.moveCursorToLineRightSide()
            goto L_0x03e5
        L_0x039c:
            r6.moveCursorToLineLeftSide()
            goto L_0x03e5
        L_0x03a0:
            r6.moveCursorToLineEnd()
            goto L_0x03e5
        L_0x03a4:
            r6.moveCursorToLineStart()
            goto L_0x03e5
        L_0x03a8:
            r6.moveCursorDownByPage()
            goto L_0x03e5
        L_0x03ac:
            r6.moveCursorUpByPage()
            goto L_0x03e5
        L_0x03b0:
            r6.moveCursorDownByLine()
            goto L_0x03e5
        L_0x03b4:
            r6.moveCursorUpByLine()
            goto L_0x03e5
        L_0x03b8:
            r6.moveCursorNextByParagraph()
            goto L_0x03e5
        L_0x03bc:
            r6.moveCursorPrevByParagraph()
            goto L_0x03e5
        L_0x03c0:
            r6.moveCursorRightByWord()
            goto L_0x03e5
        L_0x03c4:
            r6.moveCursorLeftByWord()
            goto L_0x03e5
        L_0x03c8:
            androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$onKeyEvent$2$2 r1 = androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$onKeyEvent$2$2.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r6.collapseRightOr(r1)
            goto L_0x03e5
        L_0x03d0:
            androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$onKeyEvent$2$1 r1 = androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$onKeyEvent$2$1.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r6.collapseLeftOr(r1)
            goto L_0x03e5
        L_0x03d8:
            r20.cut()
            goto L_0x03e5
        L_0x03dc:
            r20.paste()
            goto L_0x03e5
        L_0x03e0:
            r1 = r20
            r1.copy(r3)
        L_0x03e5:
            r3 = r4
        L_0x03e6:
            long r1 = r6.m1470getSelectiond9O1mEE()
            androidx.compose.foundation.text.input.TextFieldCharSequence r4 = r6.getInitialValue()
            long r4 = r4.m1312getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m6557equalsimpl0(r1, r4)
            if (r1 != 0) goto L_0x0401
            long r1 = r6.m1470getSelectiond9O1mEE()
            r7 = r18
            r7.m1449selectCharsIn5zctL8(r1)
        L_0x0401:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler.m1416onKeyEvent6ptp14s(android.view.KeyEvent, androidx.compose.foundation.text.input.internal.TransformedTextFieldState, androidx.compose.foundation.text.input.internal.TextLayoutState, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, boolean, boolean, kotlin.jvm.functions.Function0):boolean");
    }

    private final void preparedSelectionContext(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, boolean z, Function1<? super TextFieldPreparedSelection, Unit> function1) {
        TransformedTextFieldState transformedTextFieldState2 = transformedTextFieldState;
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(transformedTextFieldState2, textLayoutState.getLayoutResult(), z, getVisibleTextLayoutHeight(textLayoutState), this.preparedSelectionState);
        function1.invoke(textFieldPreparedSelection);
        if (!TextRange.m6557equalsimpl0(textFieldPreparedSelection.m1470getSelectiond9O1mEE(), textFieldPreparedSelection.getInitialValue().m1312getSelectiond9O1mEE())) {
            transformedTextFieldState2.m1449selectCharsIn5zctL8(textFieldPreparedSelection.m1470getSelectiond9O1mEE());
        }
    }

    private final float getVisibleTextLayoutHeight(TextLayoutState textLayoutState) {
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null) {
            return Float.NaN;
        }
        Rect rect = null;
        if (!textLayoutNodeCoordinates.isAttached()) {
            textLayoutNodeCoordinates = null;
        }
        if (textLayoutNodeCoordinates == null) {
            return Float.NaN;
        }
        LayoutCoordinates decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates();
        if (decoratorNodeCoordinates != null) {
            if (!decoratorNodeCoordinates.isAttached()) {
                decoratorNodeCoordinates = null;
            }
            if (decoratorNodeCoordinates != null) {
                rect = LayoutCoordinates.localBoundingBoxOf$default(decoratorNodeCoordinates, textLayoutNodeCoordinates, false, 2, (Object) null);
            }
        }
        if (rect != null) {
            return Size.m4053getHeightimpl(rect.m4020getSizeNHjbRc());
        }
        return Float.NaN;
    }
}
