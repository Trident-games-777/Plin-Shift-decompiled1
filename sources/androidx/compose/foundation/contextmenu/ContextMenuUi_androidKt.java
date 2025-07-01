package androidx.compose.foundation.contextmenu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a=\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0001¢\u0006\u0002\u0010\u0014\u001ai\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2*\b\u0002\u0010\u001a\u001a$\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010¢\u0006\u0002\b\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0 H\u0001¢\u0006\u0002\u0010!\u001aN\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0 2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00012\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\b\u0013H\u0001¢\u0006\u0002\u0010(\u001aF\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0 2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\b\u0013H\u0001¢\u0006\u0002\u0010)\u001a!\u0010*\u001a\u00020\u00012\b\b\u0003\u0010+\u001a\u00020,2\b\b\u0003\u0010-\u001a\u00020,H\u0001¢\u0006\u0002\u0010.\u001a \u0010/\u001a\u00020\u001b*\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a \u00104\u001a\u00020\u001b*\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00103\u001a2\u00106\u001a\u00020\u001b*\u0002072\b\b\u0001\u00108\u001a\u00020,2\b\b\u0001\u00109\u001a\u00020,2\u0006\u00101\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\"\u0010<\u001a\u0004\u0018\u000100*\u0002072\b\b\u0001\u00108\u001a\u00020,2\b\b\u0001\u00109\u001a\u00020,H\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"DefaultContextMenuColors", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "getDefaultContextMenuColors$annotations", "()V", "getDefaultContextMenuColors", "()Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "DefaultPopupProperties", "Landroidx/compose/ui/window/PopupProperties;", "DisabledAlpha", "", "ContextMenuColumn", "", "colors", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ContextMenuItem", "label", "", "enabled", "", "leadingIcon", "Landroidx/compose/ui/graphics/Color;", "Lkotlin/ParameterName;", "name", "iconColor", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;ZLandroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ContextMenuPopup", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "onDismiss", "contextMenuBuilderBlock", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/contextmenu/ContextMenuColors;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "computeContextMenuColors", "backgroundStyleId", "", "foregroundStyleId", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "disabledColor", "Landroid/content/res/ColorStateList;", "defaultColor", "disabledColor-4WTKRHQ", "(Landroid/content/res/ColorStateList;J)J", "enabledColor", "enabledColor-4WTKRHQ", "resolveColor", "Landroid/content/Context;", "resId", "attrId", "resolveColor-g2O1Hgs", "(Landroid/content/Context;IIJ)J", "resolveColorStateList", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextMenuUi.android.kt */
public final class ContextMenuUi_androidKt {
    private static final ContextMenuColors DefaultContextMenuColors = new ContextMenuColors(Color.Companion.m4276getWhite0d7_KjU(), Color.Companion.m4265getBlack0d7_KjU(), Color.Companion.m4265getBlack0d7_KjU(), Color.m4238copywmQWz5c$default(Color.Companion.m4265getBlack0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(Color.Companion.m4265getBlack0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
    private static final PopupProperties DefaultPopupProperties = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
    private static final float DisabledAlpha = 0.38f;

    public static /* synthetic */ void getDefaultContextMenuColors$annotations() {
    }

    public static final void ContextMenuPopup(PopupPositionProvider popupPositionProvider, Function0<Unit> function0, Modifier modifier, Function1<? super ContextMenuScope, Unit> function1, Composer composer, int i, int i2) {
        int i3;
        Function1<? super ContextMenuScope, Unit> function12;
        Modifier modifier2;
        Function0<Unit> function02;
        PopupPositionProvider popupPositionProvider2;
        Composer startRestartGroup = composer.startRestartGroup(712057293);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextMenuPopup)P(3,2,1)108@4164L26,104@4014L241:ContextMenuUi.android.kt#3xeu6s");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) popupPositionProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            Modifier modifier3 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(712057293, i3, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:103)");
            }
            PopupPositionProvider popupPositionProvider3 = popupPositionProvider;
            Function0<Unit> function03 = function0;
            Function1<? super ContextMenuScope, Unit> function13 = function1;
            ContextMenuPopup(popupPositionProvider3, function03, modifier3, computeContextMenuColors(0, 0, startRestartGroup, 0, 3), function13, startRestartGroup, (i3 & 1022) | ((i3 << 3) & 57344), 0);
            popupPositionProvider2 = popupPositionProvider3;
            function02 = function03;
            function12 = function13;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            startRestartGroup.skipToGroupEnd();
            function12 = function1;
            modifier2 = modifier;
            function02 = function0;
            popupPositionProvider2 = popupPositionProvider;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ContextMenuUi_androidKt$ContextMenuPopup$1(popupPositionProvider2, function02, modifier2, function12, i, i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ContextMenuPopup(androidx.compose.ui.window.PopupPositionProvider r14, kotlin.jvm.functions.Function0<kotlin.Unit> r15, androidx.compose.ui.Modifier r16, androidx.compose.foundation.contextmenu.ContextMenuColors r17, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.contextmenu.ContextMenuScope, kotlin.Unit> r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r4 = r17
            r5 = r18
            r6 = r20
            r0 = 1447189339(0x56425b5b, float:5.3424406E13)
            r1 = r19
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ContextMenuPopup)P(4,3,2)126@4681L257,122@4530L408:ContextMenuUi.android.kt#3xeu6s"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r21 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r6 | 6
            goto L_0x002b
        L_0x001b:
            r1 = r6 & 6
            if (r1 != 0) goto L_0x002a
            boolean r1 = r11.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r6
            goto L_0x002b
        L_0x002a:
            r1 = r6
        L_0x002b:
            r2 = r21 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0042
        L_0x0032:
            r2 = r6 & 48
            if (r2 != 0) goto L_0x0042
            boolean r2 = r11.changedInstance(r15)
            if (r2 == 0) goto L_0x003f
            r2 = 32
            goto L_0x0041
        L_0x003f:
            r2 = 16
        L_0x0041:
            r1 = r1 | r2
        L_0x0042:
            r2 = r21 & 4
            if (r2 == 0) goto L_0x0049
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005c
        L_0x0049:
            r3 = r6 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x005c
            r3 = r16
            boolean r7 = r11.changed((java.lang.Object) r3)
            if (r7 == 0) goto L_0x0058
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r1 = r1 | r7
            goto L_0x005e
        L_0x005c:
            r3 = r16
        L_0x005e:
            r7 = r21 & 8
            if (r7 == 0) goto L_0x0065
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0075
        L_0x0065:
            r7 = r6 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0075
            boolean r7 = r11.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x0072
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0074
        L_0x0072:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0074:
            r1 = r1 | r7
        L_0x0075:
            r7 = r21 & 16
            if (r7 == 0) goto L_0x007c
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x008c
        L_0x007c:
            r7 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x008c
            boolean r7 = r11.changedInstance(r5)
            if (r7 == 0) goto L_0x0089
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008b
        L_0x0089:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x008b:
            r1 = r1 | r7
        L_0x008c:
            r7 = r1 & 9363(0x2493, float:1.312E-41)
            r8 = 9362(0x2492, float:1.3119E-41)
            if (r7 != r8) goto L_0x009d
            boolean r7 = r11.getSkipping()
            if (r7 != 0) goto L_0x0099
            goto L_0x009d
        L_0x0099:
            r11.skipToGroupEnd()
            goto L_0x00dd
        L_0x009d:
            if (r2 == 0) goto L_0x00a4
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00a5
        L_0x00a4:
            r2 = r3
        L_0x00a5:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00b1
            r3 = -1
            java.lang.String r7 = "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:121)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r3, r7)
        L_0x00b1:
            androidx.compose.ui.window.PopupProperties r9 = DefaultPopupProperties
            androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$2 r0 = new androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$2
            r0.<init>(r4, r2, r5)
            r3 = 54
            r7 = 795909757(0x2f709e7d, float:2.1884179E-10)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r8, r0, r11, r3)
            r10 = r0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0 = r1 & 14
            r0 = r0 | 3456(0xd80, float:4.843E-42)
            r1 = r1 & 112(0x70, float:1.57E-43)
            r12 = r0 | r1
            r13 = 0
            r7 = r14
            r8 = r15
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00dc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00dc:
            r3 = r2
        L_0x00dd:
            androidx.compose.runtime.ScopeUpdateScope r8 = r11.endRestartGroup()
            if (r8 == 0) goto L_0x00f1
            androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$3 r0 = new androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$3
            r1 = r14
            r2 = r15
            r7 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuPopup(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.contextmenu.ContextMenuColors, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ContextMenuColumn(androidx.compose.foundation.contextmenu.ContextMenuColors r23, androidx.compose.ui.Modifier r24, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r3 = r25
            r4 = r27
            r0 = -921259293(0xffffffffc916b2e3, float:-617262.2)
            r1 = r26
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ContextMenuColumn)P(!1,2)154@5499L21,145@5128L427:ContextMenuUi.android.kt#3xeu6s"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r28 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r4 | 6
            r5 = r2
            r2 = r23
            goto L_0x0030
        L_0x001c:
            r2 = r4 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r23
            boolean r5 = r1.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x002a
            r5 = 4
            goto L_0x002b
        L_0x002a:
            r5 = 2
        L_0x002b:
            r5 = r5 | r4
            goto L_0x0030
        L_0x002d:
            r2 = r23
            r5 = r4
        L_0x0030:
            r6 = r28 & 2
            if (r6 == 0) goto L_0x0037
            r5 = r5 | 48
            goto L_0x004a
        L_0x0037:
            r7 = r4 & 48
            if (r7 != 0) goto L_0x004a
            r7 = r24
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0046
            r8 = 32
            goto L_0x0048
        L_0x0046:
            r8 = 16
        L_0x0048:
            r5 = r5 | r8
            goto L_0x004c
        L_0x004a:
            r7 = r24
        L_0x004c:
            r8 = r28 & 4
            if (r8 == 0) goto L_0x0053
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0053:
            r8 = r4 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0063
            boolean r8 = r1.changedInstance(r3)
            if (r8 == 0) goto L_0x0060
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r5 = r5 | r8
        L_0x0063:
            r8 = r5 & 147(0x93, float:2.06E-43)
            r9 = 146(0x92, float:2.05E-43)
            if (r8 != r9) goto L_0x0075
            boolean r8 = r1.getSkipping()
            if (r8 != 0) goto L_0x0070
            goto L_0x0075
        L_0x0070:
            r1.skipToGroupEnd()
            goto L_0x01a8
        L_0x0075:
            if (r6 == 0) goto L_0x007c
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r7 = r6
        L_0x007c:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0088
            r6 = -1
            java.lang.String r8 = "androidx.compose.foundation.contextmenu.ContextMenuColumn (ContextMenuUi.android.kt:144)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r6, r8)
        L_0x0088:
            androidx.compose.foundation.contextmenu.ContextMenuSpec r0 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r8 = r0.m385getMenuContainerElevationD9Ej5fM()
            androidx.compose.foundation.contextmenu.ContextMenuSpec r0 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r0 = r0.m377getCornerRadiusD9Ej5fM()
            androidx.compose.foundation.shape.RoundedCornerShape r0 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(r0)
            r9 = r0
            androidx.compose.ui.graphics.Shape r9 = (androidx.compose.ui.graphics.Shape) r9
            r15 = 28
            r16 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            androidx.compose.ui.Modifier r17 = androidx.compose.ui.draw.ShadowKt.m3885shadows4CzXII$default(r7, r8, r9, r10, r11, r13, r15, r16)
            long r18 = r2.m368getBackgroundColor0d7_KjU()
            r21 = 2
            r22 = 0
            r20 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m248backgroundbw27NRU$default(r17, r18, r20, r21, r22)
            androidx.compose.foundation.layout.IntrinsicSize r6 = androidx.compose.foundation.layout.IntrinsicSize.Max
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.IntrinsicKt.width(r0, r6)
            androidx.compose.foundation.contextmenu.ContextMenuSpec r6 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r6 = r6.m386getVerticalPaddingD9Ej5fM()
            r8 = 0
            r9 = 0
            r10 = 1
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.PaddingKt.m777paddingVpY3zN4$default(r0, r9, r6, r10, r8)
            r0 = 0
            androidx.compose.foundation.ScrollState r12 = androidx.compose.foundation.ScrollKt.rememberScrollState(r0, r1, r0, r10)
            r16 = 14
            r17 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.ScrollKt.verticalScroll$default(r11, r12, r13, r14, r15, r16, r17)
            int r5 = r5 << 3
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r8 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            java.lang.String r9 = "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r8, r9)
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r8 = r8.getTop()
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r9 = r9.getStart()
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r8, r9, r1, r0)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r10 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r9, r10)
            int r0 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r0)
            androidx.compose.runtime.CompositionLocalMap r9 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            r11 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r12 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r11, r12)
            androidx.compose.runtime.Applier r11 = r1.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0122
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0122:
            r1.startReusableNode()
            boolean r11 = r1.getInserting()
            if (r11 == 0) goto L_0x012f
            r1.createNode(r10)
            goto L_0x0132
        L_0x012f:
            r1.useNode()
        L_0x0132:
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m3675constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r8, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r9, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetCompositeKeyHash()
            boolean r9 = r10.getInserting()
            if (r9 != 0) goto L_0x0162
            java.lang.Object r9 = r10.rememberedValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r0)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r9 != 0) goto L_0x0170
        L_0x0162:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
            r10.updateRememberedValue(r9)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.apply(r0, r8)
        L_0x0170:
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r6, r0)
            r0 = -384784025(0xffffffffe910a967, float:-1.0930331E25)
            java.lang.String r6 = "C88@4444L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r6)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r5 = r5 >> 6
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | 6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.invoke(r0, r1, r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r1.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a8:
            androidx.compose.runtime.ScopeUpdateScope r6 = r1.endRestartGroup()
            if (r6 == 0) goto L_0x01bc
            androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuColumn$1 r0 = new androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuColumn$1
            r5 = r28
            r1 = r2
            r2 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r6.updateScope(r0)
        L_0x01bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuColumn(androidx.compose.foundation.contextmenu.ContextMenuColors, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ContextMenuItem(java.lang.String r25, boolean r26, androidx.compose.foundation.contextmenu.ContextMenuColors r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.Color, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r1 = r26
            r7 = r30
            r8 = r32
            r0 = 791018367(0x2f25fb7f, float:1.5096012E-10)
            r2 = r31
            androidx.compose.runtime.Composer r9 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(ContextMenuItem)P(2,1!1,4)189@6696L221,182@6391L1588:ContextMenuUi.android.kt#3xeu6s"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r33 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r8 | 6
            r3 = r2
            r2 = r25
            goto L_0x0032
        L_0x001e:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002f
            r2 = r25
            boolean r3 = r9.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r8
            goto L_0x0032
        L_0x002f:
            r2 = r25
            r3 = r8
        L_0x0032:
            r4 = r33 & 2
            r5 = 32
            if (r4 == 0) goto L_0x003b
            r3 = r3 | 48
            goto L_0x004a
        L_0x003b:
            r4 = r8 & 48
            if (r4 != 0) goto L_0x004a
            boolean r4 = r9.changed((boolean) r1)
            if (r4 == 0) goto L_0x0047
            r4 = r5
            goto L_0x0049
        L_0x0047:
            r4 = 16
        L_0x0049:
            r3 = r3 | r4
        L_0x004a:
            r4 = r33 & 4
            if (r4 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            r11 = r27
            goto L_0x0065
        L_0x0053:
            r4 = r8 & 384(0x180, float:5.38E-43)
            r11 = r27
            if (r4 != 0) goto L_0x0065
            boolean r4 = r9.changed((java.lang.Object) r11)
            if (r4 == 0) goto L_0x0062
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r4
        L_0x0065:
            r4 = r33 & 8
            if (r4 == 0) goto L_0x006c
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r6 = r8 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007f
            r6 = r28
            boolean r12 = r9.changed((java.lang.Object) r6)
            if (r12 == 0) goto L_0x007b
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r3 = r3 | r12
            goto L_0x0081
        L_0x007f:
            r6 = r28
        L_0x0081:
            r12 = r33 & 16
            if (r12 == 0) goto L_0x0088
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r13 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009b
            r13 = r29
            boolean r14 = r9.changedInstance(r13)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r14
            goto L_0x009d
        L_0x009b:
            r13 = r29
        L_0x009d:
            r14 = r33 & 32
            r15 = 131072(0x20000, float:1.83671E-40)
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a8
            r3 = r3 | r16
            goto L_0x00b7
        L_0x00a8:
            r14 = r8 & r16
            if (r14 != 0) goto L_0x00b7
            boolean r14 = r9.changedInstance(r7)
            if (r14 == 0) goto L_0x00b4
            r14 = r15
            goto L_0x00b6
        L_0x00b4:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r3 = r3 | r14
        L_0x00b7:
            r14 = r3
            r3 = 74899(0x12493, float:1.04956E-40)
            r3 = r3 & r14
            r10 = 74898(0x12492, float:1.04954E-40)
            if (r3 != r10) goto L_0x00d1
            boolean r3 = r9.getSkipping()
            if (r3 != 0) goto L_0x00c8
            goto L_0x00d1
        L_0x00c8:
            r9.skipToGroupEnd()
            r4 = r6
            r18 = r9
            r5 = r13
            goto L_0x0376
        L_0x00d1:
            if (r4 == 0) goto L_0x00d8
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00d9
        L_0x00d8:
            r3 = r6
        L_0x00d9:
            r10 = 0
            if (r12 == 0) goto L_0x00de
            r12 = r10
            goto L_0x00df
        L_0x00de:
            r12 = r13
        L_0x00df:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x00eb
            r4 = -1
            java.lang.String r6 = "androidx.compose.foundation.contextmenu.ContextMenuItem (ContextMenuUi.android.kt:181)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r4, r6)
        L_0x00eb:
            androidx.compose.foundation.contextmenu.ContextMenuSpec r0 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            androidx.compose.ui.Alignment$Vertical r13 = r0.getLabelVerticalTextAlignment()
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.contextmenu.ContextMenuSpec r4 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r4 = r4.m379getHorizontalPaddingD9Ej5fM()
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r16 = r0.m623spacedBy0680j_4(r4)
            r0 = -1814201532(0xffffffff93dd7b44, float:-5.5909793E-27)
            java.lang.String r4 = "CC(remember):ContextMenuUi.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r4)
            r0 = r14 & 112(0x70, float:1.57E-43)
            r4 = 0
            r6 = 1
            if (r0 != r5) goto L_0x010d
            r0 = r6
            goto L_0x010e
        L_0x010d:
            r0 = r4
        L_0x010e:
            r5 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r14
            if (r5 != r15) goto L_0x0115
            r5 = r6
            goto L_0x0116
        L_0x0115:
            r5 = r4
        L_0x0116:
            r0 = r0 | r5
            java.lang.Object r5 = r9.rememberedValue()
            if (r0 != 0) goto L_0x0125
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r5 != r0) goto L_0x0130
        L_0x0125:
            androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuItem$1$1 r0 = new androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuItem$1$1
            r0.<init>(r1, r7)
            r5 = r0
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r9.updateRememberedValue(r5)
        L_0x0130:
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r0 = r4
            r4 = r5
            r5 = 4
            r15 = r6
            r6 = 0
            r17 = r0
            r0 = r3
            r3 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.ClickableKt.m281clickableXHw0xAI$default(r0, r1, r2, r3, r4, r5, r6)
            r1 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r3, r1, r15, r10)
            androidx.compose.foundation.contextmenu.ContextMenuSpec r3 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r3 = r3.m376getContainerWidthMinD9Ej5fM()
            androidx.compose.foundation.contextmenu.ContextMenuSpec r4 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r4 = r4.m375getContainerWidthMaxD9Ej5fM()
            androidx.compose.foundation.contextmenu.ContextMenuSpec r5 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r5 = r5.m384getListItemHeightD9Ej5fM()
            androidx.compose.foundation.contextmenu.ContextMenuSpec r6 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r6 = r6.m384getListItemHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m848sizeInqDBjuR0(r2, r3, r5, r4, r6)
            androidx.compose.foundation.contextmenu.ContextMenuSpec r3 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r3 = r3.m379getHorizontalPaddingD9Ej5fM()
            r4 = 2
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m777paddingVpY3zN4$default(r2, r3, r1, r4, r10)
            r2 = 693286680(0x2952b718, float:4.6788176E-14)
            java.lang.String r3 = "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r3)
            r2 = r16
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r2
            r3 = 54
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r2, r13, r9, r3)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r4 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r3, r4)
            r5 = 0
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r5)
            androidx.compose.runtime.CompositionLocalMap r5 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r9, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            r13 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r15 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r13, r15)
            androidx.compose.runtime.Applier r13 = r9.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x01ae
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01ae:
            r9.startReusableNode()
            boolean r13 = r9.getInserting()
            if (r13 == 0) goto L_0x01bb
            r9.createNode(r10)
            goto L_0x01be
        L_0x01bb:
            r9.useNode()
        L_0x01be:
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m3675constructorimpl(r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r2, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r5, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            boolean r5 = r10.getInserting()
            if (r5 != 0) goto L_0x01ee
            java.lang.Object r5 = r10.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r13)
            if (r5 != 0) goto L_0x01fc
        L_0x01ee:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r10.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r10.apply(r5, r2)
        L_0x01fc:
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r1, r2)
            r1 = -407840262(0xffffffffe7b0d9fa, float:-1.6703149E24)
            java.lang.String r2 = "C101@5126L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r2)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            r2 = 554565222(0x210dfe66, float:4.810935E-19)
            java.lang.String r5 = "C212@7698L275:ContextMenuUi.android.kt#3xeu6s"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r5)
            if (r12 != 0) goto L_0x0226
            r2 = 554568909(0x210e0ccd, float:4.8128413E-19)
            r9.startReplaceGroup(r2)
        L_0x0221:
            r9.endReplaceGroup()
            goto L_0x0323
        L_0x0226:
            r2 = 554568910(0x210e0cce, float:4.812842E-19)
            r9.startReplaceGroup(r2)
            java.lang.String r2 = "*204@7349L330"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r18 = r2
            androidx.compose.ui.Modifier r18 = (androidx.compose.ui.Modifier) r18
            androidx.compose.foundation.contextmenu.ContextMenuSpec r2 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r19 = r2.m380getIconSizeD9Ej5fM()
            androidx.compose.foundation.contextmenu.ContextMenuSpec r2 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r21 = r2.m380getIconSizeD9Ej5fM()
            androidx.compose.foundation.contextmenu.ContextMenuSpec r2 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            float r22 = r2.m380getIconSizeD9Ej5fM()
            r23 = 2
            r24 = 0
            r20 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m841requiredSizeInqDBjuR0$default(r18, r19, r20, r21, r22, r23, r24)
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r6 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r5, r6)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            r6 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r5, r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r3, r4)
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r6)
            androidx.compose.runtime.CompositionLocalMap r4 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r9, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            r10 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r10, r15)
            androidx.compose.runtime.Applier r10 = r9.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x028c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x028c:
            r9.startReusableNode()
            boolean r10 = r9.getInserting()
            if (r10 == 0) goto L_0x0299
            r9.createNode(r6)
            goto L_0x029c
        L_0x0299:
            r9.useNode()
        L_0x029c:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3675constructorimpl(r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r5, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r4, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            boolean r5 = r6.getInserting()
            if (r5 != 0) goto L_0x02cc
            java.lang.Object r5 = r6.rememberedValue()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r10)
            if (r5 != 0) goto L_0x02da
        L_0x02cc:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r6.updateRememberedValue(r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6.apply(r3, r4)
        L_0x02da:
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r2, r3)
            r2 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r3 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r2 = -1218311042(0xffffffffb7620c7e, float:-1.3473558E-5)
            java.lang.String r3 = "C210@7612L65:ContextMenuUi.android.kt#3xeu6s"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r3)
            if (r26 == 0) goto L_0x02fe
            long r2 = r11.m371getIconColor0d7_KjU()
            goto L_0x0302
        L_0x02fe:
            long r2 = r11.m369getDisabledIconColor0d7_KjU()
        L_0x0302:
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m4229boximpl(r2)
            r17 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r17)
            r12.invoke(r2, r9, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r9.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            goto L_0x0221
        L_0x0323:
            androidx.compose.foundation.contextmenu.ContextMenuSpec r2 = androidx.compose.foundation.contextmenu.ContextMenuSpec.INSTANCE
            if (r26 == 0) goto L_0x032c
            long r3 = r11.m372getTextColor0d7_KjU()
            goto L_0x0330
        L_0x032c:
            long r3 = r11.m370getDisabledTextColor0d7_KjU()
        L_0x0330:
            androidx.compose.ui.text.TextStyle r2 = r2.m387textStyle8_81llA(r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = 1065353216(0x3f800000, float:1.0)
            r15 = 1
            androidx.compose.ui.Modifier r10 = r1.weight(r3, r4, r15)
            r1 = r14 & 14
            r3 = 1572864(0x180000, float:2.204052E-39)
            r19 = r1 | r3
            r20 = 440(0x1b8, float:6.17E-43)
            r13 = r12
            r12 = 0
            r1 = r13
            r13 = 0
            r14 = 0
            r15 = 1
            r16 = 0
            r17 = 0
            r11 = r2
            r18 = r9
            r9 = r25
            androidx.compose.foundation.text.BasicTextKt.m1166BasicTextVhcvRP8((java.lang.String) r9, (androidx.compose.ui.Modifier) r10, (androidx.compose.ui.text.TextStyle) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (int) r13, (boolean) r14, (int) r15, (int) r16, (androidx.compose.ui.graphics.ColorProducer) r17, (androidx.compose.runtime.Composer) r18, (int) r19, (int) r20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r18)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r18)
            r18.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r18)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r18)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r18)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0374
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0374:
            r4 = r0
            r5 = r1
        L_0x0376:
            androidx.compose.runtime.ScopeUpdateScope r9 = r18.endRestartGroup()
            if (r9 == 0) goto L_0x0390
            androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuItem$3 r0 = new androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuItem$3
            r1 = r25
            r2 = r26
            r3 = r27
            r6 = r7
            r7 = r8
            r8 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0390:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuItem(java.lang.String, boolean, androidx.compose.foundation.contextmenu.ContextMenuColors, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final ContextMenuColors getDefaultContextMenuColors() {
        return DefaultContextMenuColors;
    }

    public static final ContextMenuColors computeContextMenuColors(int i, int i2, Composer composer, int i3, int i4) {
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, 1689505294, "C(computeContextMenuColors)355@13081L7,356@13137L7,356@13100L846:ContextMenuUi.android.kt#3xeu6s");
        int i5 = (i4 & 1) != 0 ? 16973958 : i;
        int i6 = (i4 & 2) != 0 ? 16973952 : i2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1689505294, i3, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:354)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer2.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerStart(composer2, -753201361, "CC(remember):ContextMenuUi.android.kt#9igjgp");
        boolean changed = composer2.changed((Object) (Configuration) consume2) | composer2.changed((Object) context);
        Object rememberedValue = composer2.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            ContextMenuColors contextMenuColors = DefaultContextMenuColors;
            long r9 = m391resolveColorg2O1Hgs(context, i5, 16842801, contextMenuColors.m368getBackgroundColor0d7_KjU());
            ColorStateList resolveColorStateList = resolveColorStateList(context, i6, 16842806);
            long r11 = m390enabledColor4WTKRHQ(resolveColorStateList, contextMenuColors.m372getTextColor0d7_KjU());
            long r15 = m389disabledColor4WTKRHQ(resolveColorStateList, contextMenuColors.m370getDisabledTextColor0d7_KjU());
            ContextMenuColors contextMenuColors2 = new ContextMenuColors(r9, r11, r11, r15, r15, (DefaultConstructorMarker) null);
            composer2.updateRememberedValue(contextMenuColors2);
            rememberedValue = contextMenuColors2;
        }
        ContextMenuColors contextMenuColors3 = (ContextMenuColors) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return contextMenuColors3;
    }

    /* renamed from: resolveColor-g2O1Hgs  reason: not valid java name */
    private static final long m391resolveColorg2O1Hgs(Context context, int i, int i2, long j) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i2});
        int r1 = ColorKt.m4293toArgb8_81llA(j);
        int color = obtainStyledAttributes.getColor(0, r1);
        obtainStyledAttributes.recycle();
        if (color == r1) {
            return j;
        }
        return ColorKt.Color(color);
    }

    private static final ColorStateList resolveColorStateList(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i2});
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
        obtainStyledAttributes.recycle();
        return colorStateList;
    }

    /* renamed from: enabledColor-4WTKRHQ  reason: not valid java name */
    private static final long m390enabledColor4WTKRHQ(ColorStateList colorStateList, long j) {
        int r0 = ColorKt.m4293toArgb8_81llA(j);
        Integer valueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{16842910}, r0)) : null;
        return (valueOf == null || valueOf.intValue() == r0) ? j : ColorKt.Color(valueOf.intValue());
    }

    /* renamed from: disabledColor-4WTKRHQ  reason: not valid java name */
    private static final long m389disabledColor4WTKRHQ(ColorStateList colorStateList, long j) {
        int r0 = ColorKt.m4293toArgb8_81llA(j);
        Integer valueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{-16842910}, r0)) : null;
        return (valueOf == null || valueOf.intValue() == r0) ? j : ColorKt.Color(valueOf.intValue());
    }
}
