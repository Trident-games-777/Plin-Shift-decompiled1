package androidx.compose.material3;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0003¢\u0006\u0002\u0010\u0017\u001a\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002\u001aV\u0010\u001e\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u000e\u0010)\u001a\u00020\u001b*\u0004\u0018\u00010*H\u0002\u001a\f\u0010+\u001a\u00020\u001b*\u00020\u0012H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,²\u0006\f\u0010-\u001a\u0004\u0018\u00010*X\u0002²\u0006\n\u0010.\u001a\u00020\u0019X\u0002²\u0006\n\u0010/\u001a\u00020\u0019X\u0002"}, d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SoftKeyboardListener", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "onKeyboardVisibilityChange", "Lkotlin/Function0;", "(Landroid/view/View;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/geometry/Rect;", "anchorBounds", "verticalMargin", "expandable", "anchorType", "Landroidx/compose/material3/MenuAnchorType;", "expandedDescription", "", "collapsedDescription", "toggleDescription", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "expandable-Gq7TBQ4", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Landroidx/compose/ui/Modifier;", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getWindowBounds", "material3_release", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
public final class ExposedDropdownMenu_androidKt {
    /* access modifiers changed from: private */
    public static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m7111constructorimpl((float) 16);

    /* JADX WARNING: Removed duplicated region for block: B:132:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ExposedDropdownMenuBox(boolean r27, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, kotlin.jvm.functions.Function3<? super androidx.compose.material3.ExposedDropdownMenuBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r1 = r27
            r2 = r28
            r11 = r30
            r12 = r32
            r0 = 2067579792(0x7b3cc390, float:9.801183E35)
            r3 = r31
            androidx.compose.runtime.Composer r13 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(ExposedDropdownMenuBox)P(1,3,2)140@6498L7,141@6531L7,142@6570L7,146@6683L53,147@6760L33,148@6819L33,150@6879L29,151@6970L7,152@7008L31,153@7071L32,154@7132L37,155@7196L62,158@7284L2210,200@9543L361,199@9500L442,225@10317L47,225@10306L58,229@10529L27,229@10497L59:ExposedDropdownMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            r3 = r33 & 1
            r4 = 2
            if (r3 == 0) goto L_0x001e
            r3 = r12 | 6
            goto L_0x002e
        L_0x001e:
            r3 = r12 & 6
            if (r3 != 0) goto L_0x002d
            boolean r3 = r13.changed((boolean) r1)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = r4
        L_0x002b:
            r3 = r3 | r12
            goto L_0x002e
        L_0x002d:
            r3 = r12
        L_0x002e:
            r5 = r33 & 2
            if (r5 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0045
        L_0x0035:
            r5 = r12 & 48
            if (r5 != 0) goto L_0x0045
            boolean r5 = r13.changedInstance(r2)
            if (r5 == 0) goto L_0x0042
            r5 = 32
            goto L_0x0044
        L_0x0042:
            r5 = 16
        L_0x0044:
            r3 = r3 | r5
        L_0x0045:
            r5 = r33 & 4
            if (r5 == 0) goto L_0x004c
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r6 = r12 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005f
            r6 = r29
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005b
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r3 = r3 | r7
            goto L_0x0061
        L_0x005f:
            r6 = r29
        L_0x0061:
            r7 = r33 & 8
            if (r7 == 0) goto L_0x0068
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0078
        L_0x0068:
            r7 = r12 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0078
            boolean r7 = r13.changedInstance(r11)
            if (r7 == 0) goto L_0x0075
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r7
        L_0x0078:
            r7 = r3 & 1171(0x493, float:1.641E-42)
            r8 = 1170(0x492, float:1.64E-42)
            if (r7 != r8) goto L_0x008b
            boolean r7 = r13.getSkipping()
            if (r7 != 0) goto L_0x0085
            goto L_0x008b
        L_0x0085:
            r13.skipToGroupEnd()
            r3 = r6
            goto L_0x0406
        L_0x008b:
            if (r5 == 0) goto L_0x0092
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x0093
        L_0x0092:
            r5 = r6
        L_0x0093:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x009f
            r6 = -1
            java.lang.String r7 = "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.android.kt:139)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r6, r7)
        L_0x009f:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalConfiguration()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r7)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            android.content.res.Configuration r0 = (android.content.res.Configuration) r0
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r7)
            java.lang.Object r8 = r13.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            android.view.View r8 = (android.view.View) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r7)
            java.lang.Object r9 = r13.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            float r10 = androidx.compose.material3.MenuKt.getMenuVerticalMargin()
            int r18 = r9.m7086roundToPx0680j_4(r10)
            r10 = 426259219(0x19683313, float:1.2004433E-23)
            java.lang.String r15 = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r10, r15)
            java.lang.Object r10 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r16.getEmpty()
            r6 = 0
            if (r10 != r14) goto L_0x00fe
            androidx.compose.runtime.MutableState r10 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r6, r4, r6)
            r13.updateRememberedValue(r10)
        L_0x00fe:
            r19 = r10
            androidx.compose.runtime.MutableState r19 = (androidx.compose.runtime.MutableState) r19
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r10 = 426261663(0x19683c9f, float:1.2006361E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r10, r15)
            java.lang.Object r10 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            r4 = 0
            if (r10 != r14) goto L_0x011f
            androidx.compose.runtime.MutableIntState r10 = androidx.compose.runtime.SnapshotIntStateKt.mutableIntStateOf(r4)
            r13.updateRememberedValue(r10)
        L_0x011f:
            r20 = r10
            androidx.compose.runtime.MutableIntState r20 = (androidx.compose.runtime.MutableIntState) r20
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r10 = 426263551(0x196843ff, float:1.20078506E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r10, r15)
            java.lang.Object r10 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r10 != r14) goto L_0x013f
            androidx.compose.runtime.MutableIntState r10 = androidx.compose.runtime.SnapshotIntStateKt.mutableIntStateOf(r4)
            r13.updateRememberedValue(r10)
        L_0x013f:
            androidx.compose.runtime.MutableIntState r10 = (androidx.compose.runtime.MutableIntState) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r14 = 426265467(0x19684b7b, float:1.2009362E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r14, r15)
            java.lang.Object r14 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r17.getEmpty()
            if (r14 != r6) goto L_0x015e
            androidx.compose.ui.focus.FocusRequester r14 = new androidx.compose.ui.focus.FocusRequester
            r14.<init>()
            r13.updateRememberedValue(r14)
        L_0x015e:
            androidx.compose.ui.focus.FocusRequester r14 = (androidx.compose.ui.focus.FocusRequester) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalSoftwareKeyboardController()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r7)
            java.lang.Object r4 = r13.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r6 = r4
            androidx.compose.ui.platform.SoftwareKeyboardController r6 = (androidx.compose.ui.platform.SoftwareKeyboardController) r6
            androidx.compose.material3.internal.Strings$Companion r4 = androidx.compose.material3.internal.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_dropdown_menu_expanded
            int r4 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r4)
            r7 = 0
            java.lang.String r4 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r4, r13, r7)
            androidx.compose.material3.internal.Strings$Companion r17 = androidx.compose.material3.internal.Strings.Companion
            int r17 = androidx.compose.material3.R.string.m3c_dropdown_menu_collapsed
            int r1 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r17)
            java.lang.String r1 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r1, r13, r7)
            androidx.compose.material3.internal.Strings$Companion r17 = androidx.compose.material3.internal.Strings.Companion
            int r17 = androidx.compose.material3.R.string.m3c_dropdown_menu_toggle
            r29 = r1
            int r1 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r17)
            java.lang.String r1 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r1, r13, r7)
            r7 = 426275644(0x1968733c, float:1.201739E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r7, r15)
            java.lang.Object r7 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r23 = r1
            java.lang.Object r1 = r22.getEmpty()
            if (r7 != r1) goto L_0x01c7
            androidx.compose.material3.MenuAnchorType$Companion r1 = androidx.compose.material3.MenuAnchorType.Companion
            java.lang.String r1 = r1.m2200getPrimaryNotEditableMg6Rgbw()
            androidx.compose.material3.MenuAnchorType r1 = androidx.compose.material3.MenuAnchorType.m2192boximpl(r1)
            r2 = 0
            r7 = 2
            androidx.compose.runtime.MutableState r7 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r2, r7, r2)
            r13.updateRememberedValue(r7)
        L_0x01c7:
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r1 = 426280608(0x196886a0, float:1.2021306E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r15)
            r1 = r3 & 14
            r22 = 1
            r2 = 4
            if (r1 != r2) goto L_0x01dc
            r2 = r22
            goto L_0x01dd
        L_0x01dc:
            r2 = 0
        L_0x01dd:
            r12 = r3 & 112(0x70, float:1.57E-43)
            r16 = r1
            r1 = 32
            if (r12 != r1) goto L_0x01e8
            r1 = r22
            goto L_0x01e9
        L_0x01e8:
            r1 = 0
        L_0x01e9:
            r1 = r1 | r2
            boolean r0 = r13.changed((java.lang.Object) r0)
            r0 = r0 | r1
            boolean r1 = r13.changed((java.lang.Object) r8)
            r0 = r0 | r1
            boolean r1 = r13.changed((java.lang.Object) r9)
            r0 = r0 | r1
            java.lang.Object r1 = r13.rememberedValue()
            if (r0 != 0) goto L_0x021d
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0208
            goto L_0x021d
        L_0x0208:
            r2 = r28
            r0 = r1
            r23 = r3
            r11 = r5
            r25 = r9
            r24 = r12
            r3 = r14
            r26 = r16
            r12 = r18
            r9 = r20
            r1 = r27
            r14 = r8
            goto L_0x0240
        L_0x021d:
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 r0 = new androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
            r2 = r27
            r11 = r5
            r25 = r9
            r24 = r12
            r1 = r14
            r26 = r16
            r12 = r18
            r9 = r20
            r5 = r23
            r23 = r3
            r3 = r4
            r14 = r8
            r8 = r28
            r4 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r3 = r1
            r1 = r2
            r2 = r8
            r13.updateRememberedValue(r0)
        L_0x0240:
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 r0 = (androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r4 = 426351047(0x196999c7, float:1.2076873E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r15)
            boolean r4 = r13.changedInstance(r14)
            boolean r5 = r13.changed((int) r12)
            r4 = r4 | r5
            java.lang.Object r5 = r13.rememberedValue()
            if (r4 != 0) goto L_0x0267
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x0263
            goto L_0x0267
        L_0x0263:
            r4 = r10
            r10 = r19
            goto L_0x027f
        L_0x0267:
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1$1 r16 = new androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1$1
            r20 = r9
            r21 = r10
            r18 = r12
            r17 = r14
            r16.<init>(r17, r18, r19, r20, r21)
            r10 = r19
            r4 = r21
            r5 = r16
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r13.updateRememberedValue(r5)
        L_0x027f:
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r11, r5)
            r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r7 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r7)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getTopStart()
            r7 = 0
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r6, r7)
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r9 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r9)
            int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r13, r7)
            androidx.compose.runtime.CompositionLocalMap r7 = r13.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r13, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            r16 = r8
            r8 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r17 = r11
            java.lang.String r11 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r11)
            androidx.compose.runtime.Applier r8 = r13.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x02cc
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02cc:
            r13.startReusableNode()
            boolean r8 = r13.getInserting()
            if (r8 == 0) goto L_0x02d9
            r13.createNode(r9)
            goto L_0x02dc
        L_0x02d9:
            r13.useNode()
        L_0x02dc:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m3675constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r6, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r7, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            boolean r7 = r8.getInserting()
            if (r7 != 0) goto L_0x030c
            java.lang.Object r7 = r8.rememberedValue()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r16)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r7 != 0) goto L_0x031a
        L_0x030c:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)
            r8.updateRememberedValue(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)
            r8.apply(r7, r6)
        L_0x031a:
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r5, r6)
            r5 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r6 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r5 = (androidx.compose.foundation.layout.BoxScope) r5
            r5 = -615130921(0xffffffffdb55d8d7, float:-6.0192588E16)
            java.lang.String r6 = "C211@9927L9:ExposedDropdownMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            int r5 = r23 >> 6
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r11 = r30
            r11.invoke(r0, r13, r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r13.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r0 = 426363998(0x1969cc5e, float:1.2087089E-23)
            r13.startReplaceGroup(r0)
            java.lang.String r0 = "215@10008L286,215@9972L322"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            if (r1 == 0) goto L_0x0396
            r0 = 426365852(0x1969d39c, float:1.2088552E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r15)
            boolean r0 = r13.changedInstance(r14)
            boolean r5 = r13.changed((int) r12)
            r0 = r0 | r5
            java.lang.Object r5 = r13.rememberedValue()
            if (r0 != 0) goto L_0x0380
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r5 != r0) goto L_0x038b
        L_0x0380:
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1 r0 = new androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1
            r0.<init>(r14, r12, r10, r4)
            r5 = r0
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r13.updateRememberedValue(r5)
        L_0x038b:
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r9 = r25
            r7 = 0
            SoftKeyboardListener(r14, r9, r5, r13, r7)
        L_0x0396:
            r13.endReplaceGroup()
            r0 = 426375501(0x1969f94d, float:1.20961636E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r15)
            r0 = r26
            r4 = 4
            if (r0 != r4) goto L_0x03a7
            r4 = r22
            goto L_0x03a8
        L_0x03a7:
            r4 = 0
        L_0x03a8:
            java.lang.Object r5 = r13.rememberedValue()
            if (r4 != 0) goto L_0x03b6
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x03c1
        L_0x03b6:
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4$1 r4 = new androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4$1
            r4.<init>(r1, r3)
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r13.updateRememberedValue(r5)
        L_0x03c1:
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r7 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r5, r13, r7)
            r3 = 426382265(0x196a13b9, float:1.21014994E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r3, r15)
            r3 = r24
            r4 = 32
            if (r3 != r4) goto L_0x03d9
            r4 = r22
            goto L_0x03da
        L_0x03d9:
            r4 = 0
        L_0x03da:
            java.lang.Object r3 = r13.rememberedValue()
            if (r4 != 0) goto L_0x03e8
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x03f2
        L_0x03e8:
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$1 r3 = new androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$1
            r3.<init>(r2)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r13.updateRememberedValue(r3)
        L_0x03f2:
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r7 = 0
            androidx.activity.compose.BackHandlerKt.BackHandler(r1, r3, r13, r0, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0404
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0404:
            r3 = r17
        L_0x0406:
            androidx.compose.runtime.ScopeUpdateScope r7 = r13.endRestartGroup()
            if (r7 == 0) goto L_0x041b
            androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$6 r0 = new androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$6
            r5 = r32
            r6 = r33
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x041b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState<LayoutCoordinates> mutableState) {
        return (LayoutCoordinates) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$5(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$8(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* access modifiers changed from: private */
    public static final void SoftKeyboardListener(View view, Density density, Function0<Unit> function0, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1319522472);
        ComposerKt.sourceInformation(startRestartGroup, "C(SoftKeyboardListener)P(2)240@10912L1420,240@10880L1452:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(view) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) density) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1319522472, i2, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:237)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1935200244, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(view) | ((i2 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1(view, function0);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(view, density, (Function1) rememberedValue, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExposedDropdownMenu_androidKt$SoftKeyboardListener$2(view, density, function0, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: expandable-Gq7TBQ4  reason: not valid java name */
    public static final Modifier m2064expandableGq7TBQ4(Modifier modifier, boolean z, Function0<Unit> function0, String str, String str2, String str3, String str4, SoftwareKeyboardController softwareKeyboardController) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new ExposedDropdownMenu_androidKt$expandable$1(str, function0, (Continuation<? super ExposedDropdownMenu_androidKt$expandable$1>) null)), false, new ExposedDropdownMenu_androidKt$expandable$2(str, z, str2, str3, str4, function0, softwareKeyboardController), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final int calculateMaxHeight(Rect rect, Rect rect2, int i) {
        int i2;
        if (rect2 == null) {
            return 0;
        }
        float f = (float) i;
        float top = rect.getTop() + f;
        float bottom = rect.getBottom() - f;
        if (rect2.getTop() > rect.getBottom() || rect2.getBottom() < rect.getTop()) {
            i2 = MathKt.roundToInt(bottom - top);
        } else {
            i2 = MathKt.roundToInt(Math.max(rect2.getTop() - top, bottom - rect2.getBottom()));
        }
        return Math.max(i2, 0);
    }

    /* access modifiers changed from: private */
    public static final Rect getWindowBounds(View view) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return RectHelper_androidKt.toComposeRect(rect);
    }

    /* access modifiers changed from: private */
    public static final Rect getAnchorBounds(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates == null ? Rect.Companion.getZero() : RectKt.m4027Recttz77jQw(LayoutCoordinatesKt.positionInWindow(layoutCoordinates), IntSizeKt.m7295toSizeozmzZPI(layoutCoordinates.m5800getSizeYbymL2g()));
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$3(MutableState<LayoutCoordinates> mutableState, LayoutCoordinates layoutCoordinates) {
        mutableState.setValue(layoutCoordinates);
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$6(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$9(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
    }
}
