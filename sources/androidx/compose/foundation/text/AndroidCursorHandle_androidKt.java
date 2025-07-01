package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0014\u001a\f\u0010\u0015\u001a\u00020\u000e*\u00020\u000eH\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"CursorHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getCursorHandleHeight", "()F", "F", "CursorHandleWidth", "getCursorHandleWidth", "Sqrt2", "", "CursorHandle", "", "offsetProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "CursorHandle-USBMPiE", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DefaultCursorHandle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "drawCursorHandle", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCursorHandle.android.kt */
public final class AndroidCursorHandle_androidKt {
    private static final float CursorHandleHeight;
    private static final float CursorHandleWidth;
    private static final float Sqrt2 = 1.4142135f;

    public static final float getCursorHandleHeight() {
        return CursorHandleHeight;
    }

    public static final float getCursorHandleWidth() {
        return CursorHandleWidth;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007e, code lost:
        if ((r14 & 4) != 0) goto L_0x008b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fc  */
    /* renamed from: CursorHandle-USBMPiE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1153CursorHandleUSBMPiE(androidx.compose.foundation.text.selection.OffsetProvider r8, androidx.compose.ui.Modifier r9, long r10, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 1776202187(0x69deb1cb, float:3.3652642E25)
            androidx.compose.runtime.Composer r12 = r12.startRestartGroup(r0)
            java.lang.String r1 = "C(CursorHandle)P(2,1,0:c#ui.unit.DpSize)52@2192L241,63@2551L458,60@2438L571:AndroidCursorHandle.android.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            r2 = 4
            if (r1 == 0) goto L_0x0014
            r1 = r13 | 6
            goto L_0x002d
        L_0x0014:
            r1 = r13 & 6
            if (r1 != 0) goto L_0x002c
            r1 = r13 & 8
            if (r1 != 0) goto L_0x0021
            boolean r1 = r12.changed((java.lang.Object) r8)
            goto L_0x0025
        L_0x0021:
            boolean r1 = r12.changedInstance(r8)
        L_0x0025:
            if (r1 == 0) goto L_0x0029
            r1 = r2
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r13
            goto L_0x002d
        L_0x002c:
            r1 = r13
        L_0x002d:
            r3 = r14 & 2
            if (r3 == 0) goto L_0x0034
            r1 = r1 | 48
            goto L_0x0044
        L_0x0034:
            r3 = r13 & 48
            if (r3 != 0) goto L_0x0044
            boolean r3 = r12.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x0041
            r3 = 32
            goto L_0x0043
        L_0x0041:
            r3 = 16
        L_0x0043:
            r1 = r1 | r3
        L_0x0044:
            r3 = r13 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0058
            r3 = r14 & 4
            if (r3 != 0) goto L_0x0055
            boolean r3 = r12.changed((long) r10)
            if (r3 == 0) goto L_0x0055
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0057
        L_0x0055:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0057:
            r1 = r1 | r3
        L_0x0058:
            r3 = r1 & 147(0x93, float:2.06E-43)
            r4 = 146(0x92, float:2.05E-43)
            if (r3 != r4) goto L_0x006b
            boolean r3 = r12.getSkipping()
            if (r3 != 0) goto L_0x0065
            goto L_0x006b
        L_0x0065:
            r12.skipToGroupEnd()
        L_0x0068:
            r4 = r10
            goto L_0x0101
        L_0x006b:
            r12.startDefaults()
            r3 = r13 & 1
            if (r3 == 0) goto L_0x0081
            boolean r3 = r12.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0079
            goto L_0x0081
        L_0x0079:
            r12.skipToGroupEnd()
            r3 = r14 & 4
            if (r3 == 0) goto L_0x008d
            goto L_0x008b
        L_0x0081:
            r3 = r14 & 4
            if (r3 == 0) goto L_0x008d
            androidx.compose.ui.unit.DpSize$Companion r10 = androidx.compose.ui.unit.DpSize.Companion
            long r10 = r10.m7218getUnspecifiedMYxV2XQ()
        L_0x008b:
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x008d:
            r12.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x009c
            r3 = -1
            java.lang.String r4 = "androidx.compose.foundation.text.CursorHandle (AndroidCursorHandle.android.kt:51)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r3, r4)
        L_0x009c:
            r0 = -533359786(0xffffffffe0359356, float:-5.2335584E19)
            java.lang.String r3 = "CC(remember):AndroidCursorHandle.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r3)
            r0 = r1 & 14
            r3 = 0
            r4 = 1
            if (r0 == r2) goto L_0x00b7
            r1 = r1 & 8
            if (r1 == 0) goto L_0x00b5
            boolean r1 = r12.changedInstance(r8)
            if (r1 == 0) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r1 = r3
            goto L_0x00b8
        L_0x00b7:
            r1 = r4
        L_0x00b8:
            java.lang.Object r2 = r12.rememberedValue()
            if (r1 != 0) goto L_0x00c6
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x00d1
        L_0x00c6:
            androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$finalModifier$1$1 r1 = new androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$finalModifier$1$1
            r1.<init>(r8)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12.updateRememberedValue(r2)
        L_0x00d1:
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r1 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r9, r3, r2, r4, r1)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopCenter()
            androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$1 r3 = new androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$1
            r3.<init>(r10, r1)
            r1 = 54
            r5 = -1653527038(0xffffffff9d712e02, float:-3.191987E-21)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r4, r3, r12, r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0 = r0 | 432(0x1b0, float:6.05E-43)
            androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.HandlePopup(r8, r2, r1, r12, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0068
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0068
        L_0x0101:
            androidx.compose.runtime.ScopeUpdateScope r10 = r12.endRestartGroup()
            if (r10 == 0) goto L_0x0115
            androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$2 r1 = new androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$2
            r2 = r8
            r3 = r9
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r10.updateScope(r1)
        L_0x0115:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.AndroidCursorHandle_androidKt.m1153CursorHandleUSBMPiE(androidx.compose.foundation.text.selection.OffsetProvider, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void DefaultCursorHandle(Modifier modifier, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(694251107);
        ComposerKt.sourceInformation(startRestartGroup, "C(DefaultCursorHandle)83@3117L79:AndroidCursorHandle.android.kt#423gt5");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i3 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(694251107, i3, -1, "androidx.compose.foundation.text.DefaultCursorHandle (AndroidCursorHandle.android.kt:82)");
            }
            SpacerKt.Spacer(drawCursorHandle(SizeKt.m847sizeVpY3zN4(modifier, CursorHandleWidth, CursorHandleHeight)), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidCursorHandle_androidKt$DefaultCursorHandle$1(modifier, i, i2));
        }
    }

    private static final Modifier drawCursorHandle(Modifier modifier) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, AndroidCursorHandle_androidKt$drawCursorHandle$1.INSTANCE, 1, (Object) null);
    }

    static {
        float r0 = Dp.m7111constructorimpl((float) 25);
        CursorHandleHeight = r0;
        CursorHandleWidth = Dp.m7111constructorimpl(Dp.m7111constructorimpl(r0 * 2.0f) / 2.4142137f);
    }
}
