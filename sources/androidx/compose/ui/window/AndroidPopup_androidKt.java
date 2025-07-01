package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aD\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0017\u001a(\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00022\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u0012H\u0001¢\u0006\u0002\u0010\u001a\u001a+\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0013\b\b\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u0012H\b¢\u0006\u0002\u0010\u001e\u001a \u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020!H\u0002\u001a\u001c\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0006*\u00020\u00102\u0006\u0010*\u001a\u00020!H\u0002\u001a\f\u0010+\u001a\u00020!*\u00020'H\u0000\u001a\f\u0010,\u001a\u00020-*\u00020.H\u0002\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/²\u0006\u0015\u00100\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u0012X\u0002"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "PopupPropertiesBaseFlags", "", "Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createFlags", "focusable", "", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "clippingEnabled", "isPopupLayout", "view", "Landroid/view/View;", "testTag", "flagsWithSecureFlagInherited", "isParentFlagSecureEnabled", "isFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "ui_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class AndroidPopup_androidKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, AndroidPopup_androidKt$LocalPopupTestTag$1.INSTANCE, 1, (Object) null);
    private static final int PopupPropertiesBaseFlags = 262144;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* renamed from: Popup-K5zGePQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m7371PopupK5zGePQ(androidx.compose.ui.Alignment r24, long r25, kotlin.jvm.functions.Function0<kotlin.Unit> r27, androidx.compose.ui.window.PopupProperties r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r7 = r31
            r0 = 295309329(0x119a1011, float:2.4306818E-28)
            r1 = r30
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)269@12290L128,276@12424L165:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r32 & 1
            if (r1 == 0) goto L_0x001a
            r3 = r7 | 6
            r4 = r3
            r3 = r24
            goto L_0x002e
        L_0x001a:
            r3 = r7 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r24
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r7
            goto L_0x002e
        L_0x002b:
            r3 = r24
            r4 = r7
        L_0x002e:
            r5 = r32 & 2
            if (r5 == 0) goto L_0x0035
            r4 = r4 | 48
            goto L_0x0048
        L_0x0035:
            r8 = r7 & 48
            if (r8 != 0) goto L_0x0048
            r8 = r25
            boolean r10 = r12.changed((long) r8)
            if (r10 == 0) goto L_0x0044
            r10 = 32
            goto L_0x0046
        L_0x0044:
            r10 = 16
        L_0x0046:
            r4 = r4 | r10
            goto L_0x004a
        L_0x0048:
            r8 = r25
        L_0x004a:
            r10 = r32 & 4
            if (r10 == 0) goto L_0x0051
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r11 = r7 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0064
            r11 = r27
            boolean r13 = r12.changedInstance(r11)
            if (r13 == 0) goto L_0x0060
            r13 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r13 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r4 = r4 | r13
            goto L_0x0066
        L_0x0064:
            r11 = r27
        L_0x0066:
            r13 = r32 & 8
            if (r13 == 0) goto L_0x006d
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r14 = r7 & 3072(0xc00, float:4.305E-42)
            if (r14 != 0) goto L_0x0080
            r14 = r28
            boolean r15 = r12.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x007c
            r15 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r15 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r4 = r4 | r15
            goto L_0x0082
        L_0x0080:
            r14 = r28
        L_0x0082:
            r15 = r32 & 16
            if (r15 == 0) goto L_0x0089
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x0089:
            r15 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r15 != 0) goto L_0x009d
            r15 = r29
            boolean r16 = r12.changedInstance(r15)
            if (r16 == 0) goto L_0x0098
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r4 = r4 | r16
            goto L_0x009f
        L_0x009d:
            r15 = r29
        L_0x009f:
            r6 = r4 & 9363(0x2493, float:1.312E-41)
            r2 = 9362(0x2492, float:1.3119E-41)
            if (r6 != r2) goto L_0x00b5
            boolean r2 = r12.getSkipping()
            if (r2 != 0) goto L_0x00ac
            goto L_0x00b5
        L_0x00ac:
            r12.skipToGroupEnd()
            r1 = r3
            r2 = r8
            r4 = r11
            r5 = r14
            goto L_0x013d
        L_0x00b5:
            if (r1 == 0) goto L_0x00be
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            goto L_0x00bf
        L_0x00be:
            r1 = r3
        L_0x00bf:
            r2 = 0
            if (r5 == 0) goto L_0x00c7
            long r5 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r2, r2)
            goto L_0x00c8
        L_0x00c7:
            r5 = r8
        L_0x00c8:
            r3 = 0
            if (r10 == 0) goto L_0x00cd
            r9 = r3
            goto L_0x00ce
        L_0x00cd:
            r9 = r11
        L_0x00ce:
            if (r13 == 0) goto L_0x00e4
            androidx.compose.ui.window.PopupProperties r17 = new androidx.compose.ui.window.PopupProperties
            r22 = 15
            r23 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r17.<init>((boolean) r18, (boolean) r19, (boolean) r20, (boolean) r21, (int) r22, (kotlin.jvm.internal.DefaultConstructorMarker) r23)
            r10 = r17
            goto L_0x00e5
        L_0x00e4:
            r10 = r14
        L_0x00e5:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x00f1
            r8 = -1
            java.lang.String r11 = "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:268)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r8, r11)
        L_0x00f1:
            r0 = -1370836537(0xffffffffae4ab1c7, float:-4.608738E-11)
            java.lang.String r8 = "CC(remember):AndroidPopup.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r8)
            r0 = r4 & 14
            r8 = 1
            r11 = 4
            if (r0 != r11) goto L_0x0101
            r0 = r8
            goto L_0x0102
        L_0x0101:
            r0 = r2
        L_0x0102:
            r11 = r4 & 112(0x70, float:1.57E-43)
            r13 = 32
            if (r11 != r13) goto L_0x0109
            r2 = r8
        L_0x0109:
            r0 = r0 | r2
            java.lang.Object r2 = r12.rememberedValue()
            if (r0 != 0) goto L_0x0118
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0120
        L_0x0118:
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r2 = new androidx.compose.ui.window.AlignmentOffsetPositionProvider
            r2.<init>(r1, r5, r3)
            r12.updateRememberedValue(r2)
        L_0x0120:
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r2 = (androidx.compose.ui.window.AlignmentOffsetPositionProvider) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r8 = r2
            androidx.compose.ui.window.PopupPositionProvider r8 = (androidx.compose.ui.window.PopupPositionProvider) r8
            int r0 = r4 >> 3
            r13 = r0 & 8176(0x1ff0, float:1.1457E-41)
            r14 = 0
            r11 = r15
            Popup(r8, r9, r10, r11, r12, r13, r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x013a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x013a:
            r2 = r5
            r4 = r9
            r5 = r10
        L_0x013d:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 == 0) goto L_0x0151
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1
            r6 = r29
            r8 = r32
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0151:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.m7371PopupK5zGePQ(androidx.compose.ui.Alignment, long, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Popup(androidx.compose.ui.window.PopupPositionProvider r26, kotlin.jvm.functions.Function0<kotlin.Unit> r27, androidx.compose.ui.window.PopupProperties r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r1 = r26
            r11 = r29
            r12 = r31
            r0 = -830247068(0xffffffffce836f64, float:-1.1025577E9)
            r2 = r30
            androidx.compose.runtime.Composer r6 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Popup)P(2,1,3)303@13293L7,304@13332L7,305@13376L7,306@13431L7,307@13467L28,308@13522L29,309@13570L38,310@13631L944,338@14611L387,338@14581L417,353@15015L218,353@15004L229,362@15279L126,362@15239L166,374@15996L147,374@15968L175,387@16413L573,395@16993L99,384@16321L771:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r2)
            r2 = r32 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r12 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r12 & 6
            if (r2 != 0) goto L_0x002a
            boolean r2 = r6.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r12
            goto L_0x002b
        L_0x002a:
            r2 = r12
        L_0x002b:
            r3 = r32 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r12 & 48
            if (r4 != 0) goto L_0x0045
            r4 = r27
            boolean r5 = r6.changedInstance(r4)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r2 = r2 | r5
            goto L_0x0047
        L_0x0045:
            r4 = r27
        L_0x0047:
            r5 = r32 & 4
            if (r5 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r12 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0061
            r7 = r28
            boolean r8 = r6.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r28
        L_0x0063:
            r8 = r32 & 8
            if (r8 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x006a:
            r8 = r12 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007a
            boolean r8 = r6.changedInstance(r11)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r8
        L_0x007a:
            r9 = r2
            r2 = r9 & 1171(0x493, float:1.641E-42)
            r8 = 1170(0x492, float:1.64E-42)
            if (r2 != r8) goto L_0x0090
            boolean r2 = r6.getSkipping()
            if (r2 != 0) goto L_0x0088
            goto L_0x0090
        L_0x0088:
            r6.skipToGroupEnd()
            r2 = r4
            r11 = r6
            r3 = r7
            goto L_0x0398
        L_0x0090:
            r10 = 0
            if (r3 == 0) goto L_0x0096
            r18 = r10
            goto L_0x0098
        L_0x0096:
            r18 = r4
        L_0x0098:
            if (r5 == 0) goto L_0x00ac
            androidx.compose.ui.window.PopupProperties r19 = new androidx.compose.ui.window.PopupProperties
            r24 = 15
            r25 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r19.<init>((boolean) r20, (boolean) r21, (boolean) r22, (boolean) r23, (int) r24, (kotlin.jvm.internal.DefaultConstructorMarker) r25)
            goto L_0x00ae
        L_0x00ac:
            r19 = r7
        L_0x00ae:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00ba
            r2 = -1
            java.lang.String r3 = "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:302)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r2, r3)
        L_0x00ba:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            java.lang.Object r0 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            android.view.View r0 = (android.view.View) r0
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            java.lang.Object r4 = r6.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r16 = r4
            androidx.compose.ui.unit.Density r16 = (androidx.compose.ui.unit.Density) r16
            androidx.compose.runtime.ProvidableCompositionLocal<java.lang.String> r4 = LocalPopupTestTag
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            java.lang.Object r4 = r6.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r20 = r4
            java.lang.String r20 = (java.lang.String) r20
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            java.lang.Object r2 = r6.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r21 = r2
            androidx.compose.ui.unit.LayoutDirection r21 = (androidx.compose.ui.unit.LayoutDirection) r21
            r2 = 0
            androidx.compose.runtime.CompositionContext r3 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r6, r2)
            int r4 = r9 >> 9
            r4 = r4 & 14
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r11, r6, r4)
            r5 = r2
            java.lang.Object[] r2 = new java.lang.Object[r5]
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1 r7 = androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1.INSTANCE
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r8 = r5
            r5 = r7
            r7 = 3072(0xc00, float:4.305E-42)
            r17 = r8
            r8 = 6
            r22 = r3
            r3 = 0
            r23 = r4
            r4 = 0
            r13 = r21
            r15 = r22
            r14 = r23
            java.lang.Object r2 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r2, r3, (java.lang.String) r4, r5, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            r3 = r6
            r7 = r2
            java.util.UUID r7 = (java.util.UUID) r7
            r2 = -1370792809(0xffffffffae4b5c97, float:-4.6239092E-11)
            java.lang.String r4 = "CC(remember):AndroidPopup.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r2, r4)
            java.lang.Object r2 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            r6 = 1
            if (r2 != r5) goto L_0x0185
            r5 = r4
            r4 = r0
            androidx.compose.ui.window.PopupLayout r0 = new androidx.compose.ui.window.PopupLayout
            r2 = r9
            r9 = 128(0x80, float:1.794E-43)
            r8 = r10
            r10 = 0
            r17 = r8
            r8 = 0
            r27 = r2
            r11 = r3
            r12 = r6
            r21 = r13
            r2 = r19
            r3 = r20
            r6 = r1
            r13 = r5
            r5 = r16
            r1 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = r6
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1 r2 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
            r2.<init>(r0, r14)
            r4 = 1302892335(0x4da88f2f, float:3.53494496E8)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r4, r12, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.setContent(r15, r2)
            r11.updateRememberedValue(r0)
            r2 = r0
            goto L_0x018e
        L_0x0185:
            r11 = r3
            r12 = r6
            r27 = r9
            r21 = r13
            r3 = r20
            r13 = r4
        L_0x018e:
            androidx.compose.ui.window.PopupLayout r2 = (androidx.compose.ui.window.PopupLayout) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r0 = -1370762006(0xffffffffae4bd4ea, float:-4.6345962E-11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r13)
            boolean r0 = r11.changedInstance(r2)
            r4 = r27 & 112(0x70, float:1.57E-43)
            r5 = 32
            if (r4 != r5) goto L_0x01a5
            r5 = r12
            goto L_0x01a6
        L_0x01a5:
            r5 = 0
        L_0x01a6:
            r0 = r0 | r5
            r5 = r27
            r6 = r5 & 896(0x380, float:1.256E-42)
            r7 = 256(0x100, float:3.59E-43)
            if (r6 != r7) goto L_0x01b1
            r7 = r12
            goto L_0x01b2
        L_0x01b1:
            r7 = 0
        L_0x01b2:
            r0 = r0 | r7
            boolean r7 = r11.changed((java.lang.Object) r3)
            r0 = r0 | r7
            r7 = r21
            boolean r8 = r11.changed((java.lang.Object) r7)
            r0 = r0 | r8
            java.lang.Object r8 = r11.rememberedValue()
            if (r0 != 0) goto L_0x01cd
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r8 != r0) goto L_0x01df
        L_0x01cd:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1 r16 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
            r17 = r2
            r20 = r3
            r21 = r7
            r16.<init>(r17, r18, r19, r20, r21)
            r8 = r16
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r11.updateRememberedValue(r8)
        L_0x01df:
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r0 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r2, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r8, (androidx.compose.runtime.Composer) r11, (int) r0)
            r0 = -1370749247(0xffffffffae4c06c1, float:-4.639023E-11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r13)
            boolean r0 = r11.changedInstance(r2)
            r8 = 32
            if (r4 != r8) goto L_0x01f8
            r4 = r12
            goto L_0x01f9
        L_0x01f8:
            r4 = 0
        L_0x01f9:
            r0 = r0 | r4
            r4 = 256(0x100, float:3.59E-43)
            if (r6 != r4) goto L_0x0200
            r4 = r12
            goto L_0x0201
        L_0x0200:
            r4 = 0
        L_0x0201:
            r0 = r0 | r4
            boolean r4 = r11.changed((java.lang.Object) r3)
            r0 = r0 | r4
            boolean r4 = r11.changed((java.lang.Object) r7)
            r0 = r0 | r4
            java.lang.Object r4 = r11.rememberedValue()
            if (r0 != 0) goto L_0x021a
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r4 != r0) goto L_0x022c
        L_0x021a:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1 r16 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
            r17 = r2
            r20 = r3
            r21 = r7
            r16.<init>(r17, r18, r19, r20, r21)
            r4 = r16
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r11.updateRememberedValue(r4)
        L_0x022c:
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r0 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r4, r11, r0)
            r0 = -1370740891(0xffffffffae4c2765, float:-4.641922E-11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r13)
            boolean r0 = r11.changedInstance(r2)
            r3 = r5 & 14
            r4 = 4
            if (r3 != r4) goto L_0x0245
            goto L_0x0246
        L_0x0245:
            r12 = 0
        L_0x0246:
            r0 = r0 | r12
            java.lang.Object r4 = r11.rememberedValue()
            if (r0 != 0) goto L_0x0255
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r4 != r0) goto L_0x0260
        L_0x0255:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
            r0.<init>(r2, r1)
            r4 = r0
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r11.updateRememberedValue(r4)
        L_0x0260:
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r4, (androidx.compose.runtime.Composer) r11, (int) r3)
            r0 = -1370717926(0xffffffffae4c811a, float:-4.6498895E-11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r13)
            boolean r0 = r11.changedInstance(r2)
            java.lang.Object r3 = r11.rememberedValue()
            if (r0 != 0) goto L_0x0280
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x028c
        L_0x0280:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1
            r8 = 0
            r0.<init>(r2, r8)
            r3 = r0
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r11.updateRememberedValue(r3)
        L_0x028c:
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r0 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r2, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r3, (androidx.compose.runtime.Composer) r11, (int) r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r3 = -1370704156(0xffffffffae4cb6e4, float:-4.654667E-11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r13)
            boolean r3 = r11.changedInstance(r2)
            java.lang.Object r4 = r11.rememberedValue()
            if (r3 != 0) goto L_0x02b1
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x02bc
        L_0x02b1:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1 r3 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
            r3.<init>(r2)
            r4 = r3
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r11.updateRememberedValue(r4)
        L_0x02bc:
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r4)
            r3 = -1370686070(0xffffffffae4cfd8a, float:-4.6609418E-11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r13)
            boolean r3 = r11.changedInstance(r2)
            boolean r4 = r11.changed((java.lang.Object) r7)
            r3 = r3 | r4
            java.lang.Object r4 = r11.rememberedValue()
            if (r3 != 0) goto L_0x02e2
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x02ed
        L_0x02e2:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1 r3 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
            r3.<init>(r2, r7)
            r4 = r3
            androidx.compose.ui.layout.MeasurePolicy r4 = (androidx.compose.ui.layout.MeasurePolicy) r4
            r11.updateRememberedValue(r4)
        L_0x02ed:
            androidx.compose.ui.layout.MeasurePolicy r4 = (androidx.compose.ui.layout.MeasurePolicy) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r3 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r2, r3)
            r5 = 0
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r5)
            androidx.compose.runtime.CompositionLocalMap r3 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r11, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            r6 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r7 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r6, r7)
            androidx.compose.runtime.Applier r6 = r11.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0320
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0320:
            r11.startReusableNode()
            boolean r6 = r11.getInserting()
            if (r6 == 0) goto L_0x032d
            r11.createNode(r5)
            goto L_0x0330
        L_0x032d:
            r11.useNode()
        L_0x0330:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3675constructorimpl(r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r4, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r3, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r4 = r5.getInserting()
            if (r4 != 0) goto L_0x0360
            java.lang.Object r4 = r5.rememberedValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x036e
        L_0x0360:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r5.updateRememberedValue(r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.apply(r2, r3)
        L_0x036e:
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r0, r2)
            r0 = 2112480445(0x7de9e4bd, float:3.8862225E37)
            java.lang.String r2 = "C:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r11.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0394
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0394:
            r2 = r18
            r3 = r19
        L_0x0398:
            androidx.compose.runtime.ScopeUpdateScope r7 = r11.endRestartGroup()
            if (r7 == 0) goto L_0x03ae
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9
            r4 = r29
            r5 = r31
            r6 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x03ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.Popup(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final int createFlags(boolean z, SecureFlagPolicy secureFlagPolicy, boolean z2) {
        int i = !z ? 262152 : 262144;
        if (secureFlagPolicy == SecureFlagPolicy.SecureOn) {
            i |= 8192;
        }
        return !z2 ? i | 512 : i;
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final void PopupTestTag(String str, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-498879600);
        ComposerKt.sourceInformation(startRestartGroup, "C(PopupTestTag)P(1)429@18089L75:AndroidPopup.android.kt#2oxthz");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-498879600, i2, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:428)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) LocalPopupTestTag.provides(str), function2, startRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidPopup_androidKt$PopupTestTag$1(str, function2, i));
        }
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1406149896, "CC(SimpleStack)P(1)437@18427L979:AndroidPopup.android.kt#2oxthz");
        MeasurePolicy measurePolicy = AndroidPopup_androidKt$SimpleStack$1.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        int i2 = (((((i << 3) & 112) | (((i >> 3) & 14) | 384)) << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer r3 = Updater.m3675constructorimpl(composer);
        Updater.m3682setimpl(r3, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3682setimpl(r3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r3.getInserting() || !Intrinsics.areEqual(r3.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m3682setimpl(r3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        function2.invoke(composer, Integer.valueOf((i2 >> 6) & 14));
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final int flagsWithSecureFlagInherited(PopupProperties popupProperties, boolean z) {
        if (popupProperties.getInheritSecurePolicy$ui_release() && z) {
            return popupProperties.getFlags$ui_release() | 8192;
        }
        if (!popupProperties.getInheritSecurePolicy$ui_release() || z) {
            return popupProperties.getFlags$ui_release();
        }
        return popupProperties.getFlags$ui_release() & -8193;
    }

    /* access modifiers changed from: private */
    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    public static final boolean isPopupLayout(View view, String str) {
        if (view instanceof PopupLayout) {
            return str == null || Intrinsics.areEqual((Object) str, (Object) ((PopupLayout) view).getTestTag());
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Popup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
