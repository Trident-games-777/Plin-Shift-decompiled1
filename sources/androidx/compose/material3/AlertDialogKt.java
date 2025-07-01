package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u001aB\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a¦\u0001\u0010\u0019\u001a\u00020\u000f2\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\b\u00172\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\b\u00172\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\b\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!H\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a5\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00012\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001aÇ\u0001\u0010.\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0013\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\b\u00172\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\b\u00172\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\b\u00172\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\b\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001aB\u00103\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\b\u0010\u0006\"\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"ButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonsMainAxisSpacing", "DialogMaxWidth", "getDialogMaxWidth", "()F", "DialogMinWidth", "getDialogMinWidth", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TextPadding", "TitlePadding", "AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AlertDialogContent", "buttons", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "buttonContentColor", "iconContentColor", "titleContentColor", "textContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogImpl", "confirmButton", "dismissButton", "AlertDialogImpl-wrnwzgE", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "BasicAlertDialog", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
public final class AlertDialogKt {
    /* access modifiers changed from: private */
    public static final float ButtonsCrossAxisSpacing = Dp.m7111constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final float ButtonsMainAxisSpacing = Dp.m7111constructorimpl((float) 8);
    private static final float DialogMaxWidth = Dp.m7111constructorimpl((float) 560);
    private static final float DialogMinWidth = Dp.m7111constructorimpl((float) 280);
    /* access modifiers changed from: private */
    public static final PaddingValues DialogPadding;
    /* access modifiers changed from: private */
    public static final PaddingValues IconPadding;
    /* access modifiers changed from: private */
    public static final PaddingValues TextPadding;
    /* access modifiers changed from: private */
    public static final PaddingValues TitlePadding;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicAlertDialog(kotlin.jvm.functions.Function0<kotlin.Unit> r16, androidx.compose.ui.Modifier r17, androidx.compose.ui.window.DialogProperties r18, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r4 = r19
            r5 = r21
            r0 = -1922902937(0xffffffff8d62d467, float:-6.9897297E-31)
            r1 = r20
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BasicAlertDialog)P(2,1,3)149@6931L384,146@6839L476:AlertDialog.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r22 & 1
            if (r1 == 0) goto L_0x001c
            r1 = r5 | 6
            r2 = r1
            r1 = r16
            goto L_0x0030
        L_0x001c:
            r1 = r5 & 6
            if (r1 != 0) goto L_0x002d
            r1 = r16
            boolean r2 = r9.changedInstance(r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r5
            goto L_0x0030
        L_0x002d:
            r1 = r16
            r2 = r5
        L_0x0030:
            r3 = r22 & 2
            if (r3 == 0) goto L_0x0037
            r2 = r2 | 48
            goto L_0x004a
        L_0x0037:
            r6 = r5 & 48
            if (r6 != 0) goto L_0x004a
            r6 = r17
            boolean r7 = r9.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0046
            r7 = 32
            goto L_0x0048
        L_0x0046:
            r7 = 16
        L_0x0048:
            r2 = r2 | r7
            goto L_0x004c
        L_0x004a:
            r6 = r17
        L_0x004c:
            r7 = r22 & 4
            if (r7 == 0) goto L_0x0053
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r8 = r5 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0066
            r8 = r18
            boolean r10 = r9.changed((java.lang.Object) r8)
            if (r10 == 0) goto L_0x0062
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r2 = r2 | r10
            goto L_0x0068
        L_0x0066:
            r8 = r18
        L_0x0068:
            r10 = r22 & 8
            if (r10 == 0) goto L_0x006f
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006f:
            r10 = r5 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007f
            boolean r10 = r9.changedInstance(r4)
            if (r10 == 0) goto L_0x007c
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r2 = r2 | r10
        L_0x007f:
            r10 = r2 & 1171(0x493, float:1.641E-42)
            r11 = 1170(0x492, float:1.64E-42)
            if (r10 != r11) goto L_0x0092
            boolean r10 = r9.getSkipping()
            if (r10 != 0) goto L_0x008c
            goto L_0x0092
        L_0x008c:
            r9.skipToGroupEnd()
            r2 = r6
            r3 = r8
            goto L_0x00e1
        L_0x0092:
            if (r3 == 0) goto L_0x0099
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x009a
        L_0x0099:
            r3 = r6
        L_0x009a:
            if (r7 == 0) goto L_0x00a8
            androidx.compose.ui.window.DialogProperties r10 = new androidx.compose.ui.window.DialogProperties
            r14 = 7
            r15 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r10.<init>((boolean) r11, (boolean) r12, (boolean) r13, (int) r14, (kotlin.jvm.internal.DefaultConstructorMarker) r15)
            r7 = r10
            goto L_0x00a9
        L_0x00a8:
            r7 = r8
        L_0x00a9:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x00b5
            r6 = -1
            java.lang.String r8 = "androidx.compose.material3.BasicAlertDialog (AlertDialog.kt:145)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r6, r8)
        L_0x00b5:
            androidx.compose.material3.AlertDialogKt$BasicAlertDialog$1 r0 = new androidx.compose.material3.AlertDialogKt$BasicAlertDialog$1
            r0.<init>(r3, r4)
            r6 = 54
            r8 = 905289008(0x35f59d30, float:1.829967E-6)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r8, r10, r0, r9, r6)
            r8 = r0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r0 = r2 & 14
            r0 = r0 | 384(0x180, float:5.38E-43)
            int r2 = r2 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r10 = r0 | r2
            r11 = 0
            r6 = r1
            androidx.compose.ui.window.AndroidDialog_androidKt.Dialog(r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00df
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00df:
            r2 = r3
            r3 = r7
        L_0x00e1:
            androidx.compose.runtime.ScopeUpdateScope r7 = r9.endRestartGroup()
            if (r7 == 0) goto L_0x00f5
            androidx.compose.material3.AlertDialogKt$BasicAlertDialog$2 r0 = new androidx.compose.material3.AlertDialogKt$BasicAlertDialog$2
            r1 = r16
            r6 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x00f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.BasicAlertDialog(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(message = "Use BasicAlertDialog instead", replaceWith = @kotlin.ReplaceWith(expression = "BasicAlertDialog(onDismissRequest, modifier, properties, content)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AlertDialog(kotlin.jvm.functions.Function0<kotlin.Unit> r17, androidx.compose.ui.Modifier r18, androidx.compose.ui.window.DialogProperties r19, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r5 = r22
            r0 = 325249497(0x1362e9d9, float:2.8640506E-27)
            r1 = r21
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AlertDialog)P(2,1,3)201@8986L65:AlertDialog.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r23 & 1
            if (r1 == 0) goto L_0x001a
            r1 = r5 | 6
            r2 = r1
            r1 = r17
            goto L_0x002e
        L_0x001a:
            r1 = r5 & 6
            if (r1 != 0) goto L_0x002b
            r1 = r17
            boolean r2 = r10.changedInstance(r1)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = 2
        L_0x0029:
            r2 = r2 | r5
            goto L_0x002e
        L_0x002b:
            r1 = r17
            r2 = r5
        L_0x002e:
            r3 = r23 & 2
            if (r3 == 0) goto L_0x0035
            r2 = r2 | 48
            goto L_0x0048
        L_0x0035:
            r4 = r5 & 48
            if (r4 != 0) goto L_0x0048
            r4 = r18
            boolean r6 = r10.changed((java.lang.Object) r4)
            if (r6 == 0) goto L_0x0044
            r6 = 32
            goto L_0x0046
        L_0x0044:
            r6 = 16
        L_0x0046:
            r2 = r2 | r6
            goto L_0x004a
        L_0x0048:
            r4 = r18
        L_0x004a:
            r6 = r23 & 4
            if (r6 == 0) goto L_0x0051
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r7 = r5 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0064
            r7 = r19
            boolean r8 = r10.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0060
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r2 = r2 | r8
            goto L_0x0066
        L_0x0064:
            r7 = r19
        L_0x0066:
            r8 = r23 & 8
            if (r8 == 0) goto L_0x006f
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r9 = r20
            goto L_0x0081
        L_0x006f:
            r8 = r5 & 3072(0xc00, float:4.305E-42)
            r9 = r20
            if (r8 != 0) goto L_0x0081
            boolean r8 = r10.changedInstance(r9)
            if (r8 == 0) goto L_0x007e
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r2 = r2 | r8
        L_0x0081:
            r8 = r2 & 1171(0x493, float:1.641E-42)
            r11 = 1170(0x492, float:1.64E-42)
            if (r8 != r11) goto L_0x0094
            boolean r8 = r10.getSkipping()
            if (r8 != 0) goto L_0x008e
            goto L_0x0094
        L_0x008e:
            r10.skipToGroupEnd()
            r2 = r4
            r3 = r7
            goto L_0x00cb
        L_0x0094:
            if (r3 == 0) goto L_0x009b
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x009c
        L_0x009b:
            r3 = r4
        L_0x009c:
            if (r6 == 0) goto L_0x00ab
            androidx.compose.ui.window.DialogProperties r11 = new androidx.compose.ui.window.DialogProperties
            r15 = 7
            r16 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r11.<init>((boolean) r12, (boolean) r13, (boolean) r14, (int) r15, (kotlin.jvm.internal.DefaultConstructorMarker) r16)
            r8 = r11
            goto L_0x00ac
        L_0x00ab:
            r8 = r7
        L_0x00ac:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x00b8
            r4 = -1
            java.lang.String r6 = "androidx.compose.material3.AlertDialog (AlertDialog.kt:201)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r4, r6)
        L_0x00b8:
            r11 = r2 & 8190(0x1ffe, float:1.1477E-41)
            r12 = 0
            r6 = r1
            r7 = r3
            BasicAlertDialog(r6, r7, r8, r9, r10, r11, r12)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00c9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00c9:
            r2 = r7
            r3 = r8
        L_0x00cb:
            androidx.compose.runtime.ScopeUpdateScope r7 = r10.endRestartGroup()
            if (r7 == 0) goto L_0x00e1
            androidx.compose.material3.AlertDialogKt$AlertDialog$1 r0 = new androidx.compose.material3.AlertDialogKt$AlertDialog$1
            r1 = r17
            r4 = r20
            r6 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.AlertDialog(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: AlertDialogImpl-wrnwzgE  reason: not valid java name */
    public static final void m1706AlertDialogImplwrnwzgE(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, Composer composer, int i, int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i4;
        float f2;
        int i5 = i;
        int i6 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-919826268);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialogImpl)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)251@10652L1109,247@10522L1239:AlertDialog.kt#uh7d8r");
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            Function0<Unit> function02 = function0;
            i3 = i5;
        }
        if ((i5 & 48) == 0) {
            function26 = function2;
            i3 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
        } else {
            function26 = function2;
        }
        if ((i5 & 384) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier2 = modifier;
        }
        int i7 = 1024;
        if ((i5 & 3072) == 0) {
            function27 = function22;
            i3 |= startRestartGroup.changedInstance(function27) ? 2048 : 1024;
        } else {
            function27 = function22;
        }
        if ((i5 & 24576) == 0) {
            function28 = function23;
            i3 |= startRestartGroup.changedInstance(function28) ? 16384 : 8192;
        } else {
            function28 = function23;
        }
        Function2<? super Composer, ? super Integer, Unit> function29 = function24;
        if ((i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changedInstance(function29) ? 131072 : 65536;
        }
        Function2<? super Composer, ? super Integer, Unit> function210 = function25;
        if ((i5 & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function210) ? 1048576 : 524288;
        }
        Shape shape2 = shape;
        if ((i5 & 12582912) == 0) {
            i3 |= startRestartGroup.changed((Object) shape2) ? 8388608 : 4194304;
        }
        long j5 = j;
        if ((i5 & 100663296) == 0) {
            i3 |= startRestartGroup.changed(j5) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        long j6 = j2;
        if ((i5 & 805306368) == 0) {
            i3 |= startRestartGroup.changed(j6) ? 536870912 : 268435456;
        }
        long j7 = j3;
        if ((i6 & 6) == 0) {
            i4 = i6 | (startRestartGroup.changed(j7) ? 4 : 2);
        } else {
            i4 = i6;
        }
        long j8 = j4;
        if ((i6 & 48) == 0) {
            i4 |= startRestartGroup.changed(j8) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            f2 = f;
            i4 |= startRestartGroup.changed(f2) ? 256 : 128;
        } else {
            f2 = f;
        }
        if ((i6 & 3072) == 0) {
            if (startRestartGroup.changed((Object) dialogProperties)) {
                i7 = 2048;
            }
            i4 |= i7;
        } else {
            DialogProperties dialogProperties2 = dialogProperties;
        }
        int i8 = i4;
        if ((i3 & 306783379) == 306783378 && (i8 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-919826268, i3, i8, "androidx.compose.material3.AlertDialogImpl (AlertDialog.kt:247)");
            }
            BasicAlertDialog(function0, modifier, dialogProperties, ComposableLambdaKt.rememberComposableLambda(-1852840226, true, new AlertDialogKt$AlertDialogImpl$1(function28, function29, function210, shape2, j5, f2, j2, j3, j4, function27, function26), startRestartGroup, 54), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 3) & 112) | ((i8 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AlertDialogKt$AlertDialogImpl$2(function0, function2, modifier, function22, function23, function24, function25, shape, j, j2, j3, j4, f, dialogProperties, i, i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0124  */
    /* renamed from: AlertDialogContent-4hvqGtA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1704AlertDialogContent4hvqGtA(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.graphics.Shape r34, long r35, float r37, long r38, long r40, long r42, long r44, androidx.compose.runtime.Composer r46, int r47, int r48, int r49) {
        /*
            r0 = r47
            r1 = r49
            r2 = 1522575799(0x5ac0a9b7, float:2.71148995E16)
            r3 = r46
            androidx.compose.runtime.Composer r13 = r3.startRestartGroup(r2)
            java.lang.String r3 = "C(AlertDialogContent)P(1,5,3,9,7,6,2:c#ui.graphics.Color,11:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.Color,10:c#ui.graphics.Color,8:c#ui.graphics.Color)299@12328L2062,294@12188L2202:AlertDialog.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            r3 = r1 & 1
            if (r3 == 0) goto L_0x001c
            r3 = r0 | 6
            r6 = r3
            r3 = r29
            goto L_0x0030
        L_0x001c:
            r3 = r0 & 6
            if (r3 != 0) goto L_0x002d
            r3 = r29
            boolean r6 = r13.changedInstance(r3)
            if (r6 == 0) goto L_0x002a
            r6 = 4
            goto L_0x002b
        L_0x002a:
            r6 = 2
        L_0x002b:
            r6 = r6 | r0
            goto L_0x0030
        L_0x002d:
            r3 = r29
            r6 = r0
        L_0x0030:
            r7 = r1 & 2
            if (r7 == 0) goto L_0x0037
            r6 = r6 | 48
            goto L_0x004a
        L_0x0037:
            r10 = r0 & 48
            if (r10 != 0) goto L_0x004a
            r10 = r30
            boolean r11 = r13.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0046
            r11 = 32
            goto L_0x0048
        L_0x0046:
            r11 = 16
        L_0x0048:
            r6 = r6 | r11
            goto L_0x004c
        L_0x004a:
            r10 = r30
        L_0x004c:
            r11 = r1 & 4
            if (r11 == 0) goto L_0x0055
            r6 = r6 | 384(0x180, float:5.38E-43)
            r15 = r31
            goto L_0x0067
        L_0x0055:
            r11 = r0 & 384(0x180, float:5.38E-43)
            r15 = r31
            if (r11 != 0) goto L_0x0067
            boolean r11 = r13.changedInstance(r15)
            if (r11 == 0) goto L_0x0064
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r6 = r6 | r11
        L_0x0067:
            r11 = r1 & 8
            if (r11 == 0) goto L_0x006e
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r11 = r0 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0081
            r11 = r32
            boolean r12 = r13.changedInstance(r11)
            if (r12 == 0) goto L_0x007d
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r6 = r6 | r12
            goto L_0x0083
        L_0x0081:
            r11 = r32
        L_0x0083:
            r12 = r1 & 16
            if (r12 == 0) goto L_0x008a
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x008a:
            r12 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009d
            r12 = r33
            boolean r14 = r13.changedInstance(r12)
            if (r14 == 0) goto L_0x0099
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r6 = r6 | r14
            goto L_0x009f
        L_0x009d:
            r12 = r33
        L_0x009f:
            r14 = r1 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a8
            r6 = r6 | r16
            goto L_0x00bc
        L_0x00a8:
            r14 = r0 & r16
            if (r14 != 0) goto L_0x00bc
            r14 = r34
            boolean r16 = r13.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x00b7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r6 = r6 | r16
            goto L_0x00be
        L_0x00bc:
            r14 = r34
        L_0x00be:
            r16 = r1 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c9
            r6 = r6 | r17
            r4 = r35
            goto L_0x00dc
        L_0x00c9:
            r16 = r0 & r17
            r4 = r35
            if (r16 != 0) goto L_0x00dc
            boolean r17 = r13.changed((long) r4)
            if (r17 == 0) goto L_0x00d8
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r6 = r6 | r17
        L_0x00dc:
            r8 = r1 & 128(0x80, float:1.794E-43)
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            if (r8 == 0) goto L_0x00e5
            r6 = r6 | r27
            goto L_0x00f9
        L_0x00e5:
            r8 = r0 & r27
            if (r8 != 0) goto L_0x00f9
            r8 = r37
            boolean r18 = r13.changed((float) r8)
            if (r18 == 0) goto L_0x00f4
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f6
        L_0x00f4:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f6:
            r6 = r6 | r18
            goto L_0x00fb
        L_0x00f9:
            r8 = r37
        L_0x00fb:
            r9 = r1 & 256(0x100, float:3.59E-43)
            r19 = 100663296(0x6000000, float:2.4074124E-35)
            if (r9 == 0) goto L_0x0106
            r6 = r6 | r19
            r2 = r38
            goto L_0x0119
        L_0x0106:
            r9 = r0 & r19
            r2 = r38
            if (r9 != 0) goto L_0x0119
            boolean r19 = r13.changed((long) r2)
            if (r19 == 0) goto L_0x0115
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r6 = r6 | r19
        L_0x0119:
            r9 = r1 & 512(0x200, float:7.175E-43)
            r20 = 805306368(0x30000000, float:4.656613E-10)
            if (r9 == 0) goto L_0x0124
            r6 = r6 | r20
            r2 = r40
            goto L_0x0136
        L_0x0124:
            r9 = r0 & r20
            r2 = r40
            if (r9 != 0) goto L_0x0136
            boolean r9 = r13.changed((long) r2)
            if (r9 == 0) goto L_0x0133
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0135
        L_0x0133:
            r9 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0135:
            r6 = r6 | r9
        L_0x0136:
            r9 = r1 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x013f
            r9 = r48 | 6
            r2 = r42
            goto L_0x0155
        L_0x013f:
            r9 = r48 & 6
            r2 = r42
            if (r9 != 0) goto L_0x0153
            boolean r9 = r13.changed((long) r2)
            if (r9 == 0) goto L_0x014e
            r16 = 4
            goto L_0x0150
        L_0x014e:
            r16 = 2
        L_0x0150:
            r9 = r48 | r16
            goto L_0x0155
        L_0x0153:
            r9 = r48
        L_0x0155:
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x015c
            r9 = r9 | 48
            goto L_0x0170
        L_0x015c:
            r0 = r48 & 48
            if (r0 != 0) goto L_0x0170
            r0 = r44
            boolean r16 = r13.changed((long) r0)
            if (r16 == 0) goto L_0x016b
            r17 = 32
            goto L_0x016d
        L_0x016b:
            r17 = 16
        L_0x016d:
            r9 = r9 | r17
            goto L_0x0172
        L_0x0170:
            r0 = r44
        L_0x0172:
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r6 & r16
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x018e
            r0 = r9 & 19
            r1 = 18
            if (r0 != r1) goto L_0x018e
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x0189
            goto L_0x018e
        L_0x0189:
            r13.skipToGroupEnd()
            r2 = r10
            goto L_0x01f3
        L_0x018e:
            if (r7 == 0) goto L_0x0195
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0196
        L_0x0195:
            r0 = r10
        L_0x0196:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01a4
            java.lang.String r1 = "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:293)"
            r7 = 1522575799(0x5ac0a9b7, float:2.71148995E16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r6, r9, r1)
        L_0x01a4:
            androidx.compose.material3.AlertDialogKt$AlertDialogContent$1 r14 = new androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
            r26 = r29
            r24 = r38
            r18 = r40
            r22 = r44
            r20 = r2
            r16 = r11
            r17 = r12
            r14.<init>(r15, r16, r17, r18, r20, r22, r24, r26)
            r1 = 54
            r2 = -2126308228(0xffffffff81431c7c, float:-3.583628E-38)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r2, r3, r14, r13, r1)
            r12 = r1
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            int r1 = r6 >> 3
            r1 = r1 & 14
            r1 = r1 | r27
            int r2 = r6 >> 12
            r3 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r6 >> 9
            r3 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r3
            r14 = r1 | r2
            r15 = 104(0x68, float:1.46E-43)
            r7 = 0
            r10 = 0
            r11 = 0
            r9 = r37
            r3 = r0
            r5 = r4
            r4 = r34
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01f2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01f2:
            r2 = r3
        L_0x01f3:
            androidx.compose.runtime.ScopeUpdateScope r0 = r13.endRestartGroup()
            if (r0 == 0) goto L_0x0224
            r1 = r0
            androidx.compose.material3.AlertDialogKt$AlertDialogContent$2 r0 = new androidx.compose.material3.AlertDialogKt$AlertDialogContent$2
            r3 = r31
            r4 = r32
            r5 = r33
            r6 = r34
            r7 = r35
            r9 = r37
            r10 = r38
            r12 = r40
            r14 = r42
            r16 = r44
            r18 = r47
            r19 = r48
            r20 = r49
            r28 = r1
            r1 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r10, r12, r14, r16, r18, r19, r20)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r28
            r1.updateScope(r0)
        L_0x0224:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.m1704AlertDialogContent4hvqGtA(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, long, float, long, long, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: AlertDialogFlowRow-ixp7dh8  reason: not valid java name */
    public static final void m1705AlertDialogFlowRowixp7dh8(float f, float f2, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(586821353);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)365@14664L3370,365@14648L3386:AlertDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586821353, i2, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:364)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -767073803, "CC(remember):AlertDialog.kt#9igjgp");
            boolean z = true;
            boolean z2 = (i2 & 14) == 4;
            if ((i2 & 112) != 32) {
                z = false;
            }
            boolean z3 = z2 | z;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AlertDialogKt$AlertDialogFlowRow$1$1(f, f2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i3 = ((((i2 >> 6) & 14) << 6) & 896) | 6;
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
            Updater.m3682setimpl(r5, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            startRestartGroup.endNode();
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
            endRestartGroup.updateScope(new AlertDialogKt$AlertDialogFlowRow$2(f, f2, function2, i));
        }
    }

    public static final float getDialogMinWidth() {
        return DialogMinWidth;
    }

    public static final float getDialogMaxWidth() {
        return DialogMaxWidth;
    }

    static {
        float f = (float) 24;
        DialogPadding = PaddingKt.m768PaddingValues0680j_4(Dp.m7111constructorimpl(f));
        float f2 = (float) 16;
        IconPadding = PaddingKt.m772PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m7111constructorimpl(f2), 7, (Object) null);
        TitlePadding = PaddingKt.m772PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m7111constructorimpl(f2), 7, (Object) null);
        TextPadding = PaddingKt.m772PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m7111constructorimpl(f), 7, (Object) null);
    }
}
