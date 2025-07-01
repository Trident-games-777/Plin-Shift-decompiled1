package androidx.compose.material3;

import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aU\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001b\u001aO\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010 \u001a6\u0010!\u001a\u00020\u000b*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a>\u0010+\u001a\u00020\u000b*\u00020\"2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material3/CheckDrawingCache;)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxSize = Dp.m7111constructorimpl((float) 20);
    /* access modifiers changed from: private */
    public static final float RadiusSize;
    /* access modifiers changed from: private */
    public static final float StrokeWidth;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Checkbox.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.ui.state.ToggleableState[] r0 = androidx.compose.ui.state.ToggleableState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.On     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Off     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Indeterminate     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.WhenMappings.<clinit>():void");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Checkbox(boolean r18, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r19, androidx.compose.ui.Modifier r20, boolean r21, androidx.compose.material3.CheckboxColors r22, androidx.compose.foundation.interaction.MutableInteractionSource r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r1 = r18
            r2 = r19
            r7 = r25
            r0 = -1406741137(0xffffffffac26d56f, float:-2.3708498E-12)
            r3 = r24
            androidx.compose.runtime.Composer r14 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(Checkbox)P(!1,5,4,2)96@4296L8,99@4370L356:Checkbox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r3)
            r3 = r26 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r7 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r7 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r14.changed((boolean) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r7
            goto L_0x002b
        L_0x002a:
            r3 = r7
        L_0x002b:
            r5 = r26 & 2
            r6 = 32
            if (r5 == 0) goto L_0x0034
            r3 = r3 | 48
            goto L_0x0043
        L_0x0034:
            r5 = r7 & 48
            if (r5 != 0) goto L_0x0043
            boolean r5 = r14.changedInstance(r2)
            if (r5 == 0) goto L_0x0040
            r5 = r6
            goto L_0x0042
        L_0x0040:
            r5 = 16
        L_0x0042:
            r3 = r3 | r5
        L_0x0043:
            r5 = r26 & 4
            if (r5 == 0) goto L_0x004a
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005d
        L_0x004a:
            r8 = r7 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x005d
            r8 = r20
            boolean r9 = r14.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0059
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r3 = r3 | r9
            goto L_0x005f
        L_0x005d:
            r8 = r20
        L_0x005f:
            r9 = r26 & 8
            if (r9 == 0) goto L_0x0066
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r10 = r7 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0079
            r10 = r21
            boolean r11 = r14.changed((boolean) r10)
            if (r11 == 0) goto L_0x0075
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r11
            goto L_0x007b
        L_0x0079:
            r10 = r21
        L_0x007b:
            r11 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0094
            r11 = r26 & 16
            if (r11 != 0) goto L_0x008e
            r11 = r22
            boolean r12 = r14.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0090
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x008e:
            r11 = r22
        L_0x0090:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r3 = r3 | r12
            goto L_0x0096
        L_0x0094:
            r11 = r22
        L_0x0096:
            r12 = r26 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x009e
            r3 = r3 | r13
            goto L_0x00b0
        L_0x009e:
            r13 = r13 & r7
            if (r13 != 0) goto L_0x00b0
            r13 = r23
            boolean r15 = r14.changed((java.lang.Object) r13)
            if (r15 == 0) goto L_0x00ac
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00ac:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r3 = r3 | r15
            goto L_0x00b2
        L_0x00b0:
            r13 = r23
        L_0x00b2:
            r15 = 74899(0x12493, float:1.04956E-40)
            r15 = r15 & r3
            r4 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r4) goto L_0x00cb
            boolean r4 = r14.getSkipping()
            if (r4 != 0) goto L_0x00c2
            goto L_0x00cb
        L_0x00c2:
            r14.skipToGroupEnd()
            r3 = r8
            r4 = r10
            r5 = r11
        L_0x00c8:
            r6 = r13
            goto L_0x0180
        L_0x00cb:
            r14.startDefaults()
            r4 = r7 & 1
            r15 = 0
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r17 = 1
            if (r4 == 0) goto L_0x00ec
            boolean r4 = r14.getDefaultsInvalid()
            if (r4 == 0) goto L_0x00df
            goto L_0x00ec
        L_0x00df:
            r14.skipToGroupEnd()
            r4 = r26 & 16
            if (r4 == 0) goto L_0x00e8
            r3 = r3 & r16
        L_0x00e8:
            r12 = r11
        L_0x00e9:
            r11 = r10
            r10 = r8
            goto L_0x010a
        L_0x00ec:
            if (r5 == 0) goto L_0x00f3
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r8 = r4
        L_0x00f3:
            if (r9 == 0) goto L_0x00f7
            r10 = r17
        L_0x00f7:
            r4 = r26 & 16
            if (r4 == 0) goto L_0x0105
            androidx.compose.material3.CheckboxDefaults r4 = androidx.compose.material3.CheckboxDefaults.INSTANCE
            r5 = 6
            androidx.compose.material3.CheckboxColors r4 = r4.colors(r14, r5)
            r3 = r3 & r16
            r11 = r4
        L_0x0105:
            if (r12 == 0) goto L_0x00e8
            r12 = r11
            r13 = r15
            goto L_0x00e9
        L_0x010a:
            r14.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0119
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.Checkbox (Checkbox.kt:98)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r4, r5)
        L_0x0119:
            androidx.compose.ui.state.ToggleableState r8 = androidx.compose.ui.state.ToggleableStateKt.ToggleableState(r1)
            r0 = 1046936362(0x3e66fb2a, float:0.22556749)
            r14.startReplaceGroup(r0)
            java.lang.String r0 = "103@4507L29"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            if (r2 == 0) goto L_0x0164
            r0 = 1046937763(0x3e6700a3, float:0.22558837)
            java.lang.String r4 = "CC(remember):Checkbox.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r4)
            r0 = r3 & 112(0x70, float:1.57E-43)
            r4 = 0
            if (r0 != r6) goto L_0x013a
            r0 = r17
            goto L_0x013b
        L_0x013a:
            r0 = r4
        L_0x013b:
            r5 = r3 & 14
            r6 = 4
            if (r5 != r6) goto L_0x0141
            goto L_0x0143
        L_0x0141:
            r17 = r4
        L_0x0143:
            r0 = r0 | r17
            java.lang.Object r4 = r14.rememberedValue()
            if (r0 != 0) goto L_0x0153
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r4 != r0) goto L_0x015e
        L_0x0153:
            androidx.compose.material3.CheckboxKt$Checkbox$1$1 r0 = new androidx.compose.material3.CheckboxKt$Checkbox$1$1
            r0.<init>(r2, r1)
            r4 = r0
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r14.updateRememberedValue(r4)
        L_0x015e:
            r15 = r4
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
        L_0x0164:
            r9 = r15
            r14.endReplaceGroup()
            r0 = 524160(0x7ff80, float:7.34505E-40)
            r15 = r3 & r0
            r16 = 0
            TriStateCheckbox(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017b:
            r3 = r10
            r4 = r11
            r5 = r12
            goto L_0x00c8
        L_0x0180:
            androidx.compose.runtime.ScopeUpdateScope r9 = r14.endRestartGroup()
            if (r9 == 0) goto L_0x0192
            androidx.compose.material3.CheckboxKt$Checkbox$2 r0 = new androidx.compose.material3.CheckboxKt$Checkbox$2
            r8 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0192:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.Checkbox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TriStateCheckbox(androidx.compose.ui.state.ToggleableState r17, kotlin.jvm.functions.Function0<kotlin.Unit> r18, androidx.compose.ui.Modifier r19, boolean r20, androidx.compose.material3.CheckboxColors r21, androidx.compose.foundation.interaction.MutableInteractionSource r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r2 = r18
            r7 = r24
            r0 = -1608358065(0xffffffffa022674f, float:-1.3756116E-19)
            r1 = r23
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TriStateCheckbox)P(5,4,3,1)149@6731L8,169@7373L460:Checkbox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r25 & 1
            r3 = 2
            if (r1 == 0) goto L_0x001d
            r1 = r7 | 6
            r4 = r1
            r1 = r17
            goto L_0x0031
        L_0x001d:
            r1 = r7 & 6
            if (r1 != 0) goto L_0x002e
            r1 = r17
            boolean r4 = r12.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x002b
            r4 = 4
            goto L_0x002c
        L_0x002b:
            r4 = r3
        L_0x002c:
            r4 = r4 | r7
            goto L_0x0031
        L_0x002e:
            r1 = r17
            r4 = r7
        L_0x0031:
            r5 = r25 & 2
            if (r5 == 0) goto L_0x0038
            r4 = r4 | 48
            goto L_0x0048
        L_0x0038:
            r5 = r7 & 48
            if (r5 != 0) goto L_0x0048
            boolean r5 = r12.changedInstance(r2)
            if (r5 == 0) goto L_0x0045
            r5 = 32
            goto L_0x0047
        L_0x0045:
            r5 = 16
        L_0x0047:
            r4 = r4 | r5
        L_0x0048:
            r5 = r25 & 4
            if (r5 == 0) goto L_0x004f
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r6 = r7 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0062
            r6 = r19
            boolean r8 = r12.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x005e
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r4 = r4 | r8
            goto L_0x0064
        L_0x0062:
            r6 = r19
        L_0x0064:
            r8 = r25 & 8
            if (r8 == 0) goto L_0x006b
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r9 = r7 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007e
            r9 = r20
            boolean r10 = r12.changed((boolean) r9)
            if (r10 == 0) goto L_0x007a
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r4 = r4 | r10
            goto L_0x0080
        L_0x007e:
            r9 = r20
        L_0x0080:
            r10 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0099
            r10 = r25 & 16
            if (r10 != 0) goto L_0x0093
            r10 = r21
            boolean r11 = r12.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0095
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r10 = r21
        L_0x0095:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r4 = r4 | r11
            goto L_0x009b
        L_0x0099:
            r10 = r21
        L_0x009b:
            r11 = r25 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r11 == 0) goto L_0x00a3
            r4 = r4 | r13
            goto L_0x00b5
        L_0x00a3:
            r13 = r13 & r7
            if (r13 != 0) goto L_0x00b5
            r13 = r22
            boolean r14 = r12.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b1
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r4 = r4 | r14
            goto L_0x00b7
        L_0x00b5:
            r13 = r22
        L_0x00b7:
            r14 = 74899(0x12493, float:1.04956E-40)
            r14 = r14 & r4
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00d0
            boolean r14 = r12.getSkipping()
            if (r14 != 0) goto L_0x00c7
            goto L_0x00d0
        L_0x00c7:
            r12.skipToGroupEnd()
            r3 = r6
            r4 = r9
            r5 = r10
        L_0x00cd:
            r6 = r13
            goto L_0x01ae
        L_0x00d0:
            r12.startDefaults()
            r14 = r7 & 1
            r15 = -57345(0xffffffffffff1fff, float:NaN)
            if (r14 == 0) goto L_0x00f0
            boolean r14 = r12.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00e1
            goto L_0x00f0
        L_0x00e1:
            r12.skipToGroupEnd()
            r5 = r25 & 16
            if (r5 == 0) goto L_0x00e9
            r4 = r4 & r15
        L_0x00e9:
            r5 = r4
            r15 = r6
            r4 = r9
            r16 = r10
            r2 = r13
            goto L_0x0117
        L_0x00f0:
            if (r5 == 0) goto L_0x00f7
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x00f8
        L_0x00f7:
            r5 = r6
        L_0x00f8:
            if (r8 == 0) goto L_0x00fc
            r6 = 1
            r9 = r6
        L_0x00fc:
            r6 = r25 & 16
            if (r6 == 0) goto L_0x0109
            androidx.compose.material3.CheckboxDefaults r6 = androidx.compose.material3.CheckboxDefaults.INSTANCE
            r8 = 6
            androidx.compose.material3.CheckboxColors r6 = r6.colors(r12, r8)
            r4 = r4 & r15
            r10 = r6
        L_0x0109:
            if (r11 == 0) goto L_0x0111
            r6 = 0
            r15 = r5
            r2 = r6
            r16 = r10
            goto L_0x0115
        L_0x0111:
            r15 = r5
            r16 = r10
            r2 = r13
        L_0x0115:
            r5 = r4
            r4 = r9
        L_0x0117:
            r12.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0126
            r6 = -1
            java.lang.String r8 = "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:151)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r6, r8)
        L_0x0126:
            r0 = -97239746(0xfffffffffa343d3e, float:-2.339639E35)
            r12.startReplaceGroup(r0)
            java.lang.String r0 = "161@7145L161"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            if (r18 == 0) goto L_0x0162
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r6 = androidx.compose.ui.semantics.Role.Companion
            int r6 = r6.m6368getCheckboxo7Vup1c()
            androidx.compose.material3.tokens.CheckboxTokens r8 = androidx.compose.material3.tokens.CheckboxTokens.INSTANCE
            float r8 = r8.m3051getStateLayerSizeD9Ej5fM()
            float r3 = (float) r3
            float r8 = r8 / r3
            float r9 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r8)
            r13 = 54
            r14 = 4
            r8 = 0
            r10 = 0
            androidx.compose.foundation.Indication r3 = androidx.compose.material3.RippleKt.m2389rippleOrFallbackImplementation9IZ8Weo(r8, r9, r10, r12, r13, r14)
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.semantics.Role r6 = androidx.compose.ui.semantics.Role.m6360boximpl(r6)
            r8 = r5
            r5 = r6
            r6 = r18
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m1117triStateToggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            r13 = r2
            r1 = r4
            goto L_0x0169
        L_0x0162:
            r13 = r2
            r1 = r4
            r8 = r5
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x0169:
            r12.endReplaceGroup()
            if (r18 == 0) goto L_0x0177
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r2 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r2)
            goto L_0x017b
        L_0x0177:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
        L_0x017b:
            androidx.compose.ui.Modifier r2 = r15.then(r2)
            androidx.compose.ui.Modifier r0 = r2.then(r0)
            float r2 = CheckboxDefaultPadding
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m775padding3ABfNKs(r0, r2)
            int r0 = r8 >> 9
            r0 = r0 & 14
            int r2 = r8 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r8 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r6 = r0 | r2
            r2 = r17
            r5 = r12
            r4 = r16
            CheckboxImpl(r1, r2, r3, r4, r5, r6)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a9:
            r5 = r4
            r3 = r15
            r4 = r1
            goto L_0x00cd
        L_0x01ae:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 == 0) goto L_0x01c4
            androidx.compose.material3.CheckboxKt$TriStateCheckbox$1 r0 = new androidx.compose.material3.CheckboxKt$TriStateCheckbox$1
            r1 = r17
            r2 = r18
            r8 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x01c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.TriStateCheckbox(androidx.compose.ui.state.ToggleableState, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CheckboxImpl(boolean r35, androidx.compose.ui.state.ToggleableState r36, androidx.compose.ui.Modifier r37, androidx.compose.material3.CheckboxColors r38, androidx.compose.runtime.Composer r39, int r40) {
        /*
            r1 = r35
            r2 = r36
            r3 = r37
            r4 = r38
            r5 = r40
            r0 = 2007131616(0x77a265e0, float:6.5876434E33)
            r6 = r39
            androidx.compose.runtime.Composer r12 = r6.startRestartGroup(r0)
            java.lang.String r6 = "C(CheckboxImpl)P(1,3,2)272@12420L23,274@12491L499,291@13057L514,306@13593L32,307@13654L21,308@13702L24,309@13756L27,310@13866L538,310@13788L616:Checkbox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            r6 = r5 & 6
            r14 = 2
            if (r6 != 0) goto L_0x0028
            boolean r6 = r12.changed((boolean) r1)
            if (r6 == 0) goto L_0x0025
            r6 = 4
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r6 = r6 | r5
            goto L_0x0029
        L_0x0028:
            r6 = r5
        L_0x0029:
            r7 = r5 & 48
            if (r7 != 0) goto L_0x0039
            boolean r7 = r12.changed((java.lang.Object) r2)
            if (r7 == 0) goto L_0x0036
            r7 = 32
            goto L_0x0038
        L_0x0036:
            r7 = 16
        L_0x0038:
            r6 = r6 | r7
        L_0x0039:
            r7 = r5 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0049
            boolean r7 = r12.changed((java.lang.Object) r3)
            if (r7 == 0) goto L_0x0046
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0048
        L_0x0046:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0048:
            r6 = r6 | r7
        L_0x0049:
            r7 = r5 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0059
            boolean r7 = r12.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x0056
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0058
        L_0x0056:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0058:
            r6 = r6 | r7
        L_0x0059:
            r15 = r6
            r6 = r15 & 1171(0x493, float:1.641E-42)
            r7 = 1170(0x492, float:1.64E-42)
            if (r6 != r7) goto L_0x006c
            boolean r6 = r12.getSkipping()
            if (r6 != 0) goto L_0x0067
            goto L_0x006c
        L_0x0067:
            r12.skipToGroupEnd()
            goto L_0x02dc
        L_0x006c:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r7 = -1
            if (r6 == 0) goto L_0x0078
            java.lang.String r6 = "androidx.compose.material3.CheckboxImpl (Checkbox.kt:271)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r7, r6)
        L_0x0078:
            int r0 = r15 >> 3
            r6 = r0 & 14
            r8 = 0
            r9 = r6
            androidx.compose.animation.core.Transition r6 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r8, (androidx.compose.runtime.Composer) r12, (int) r9, (int) r14)
            androidx.compose.material3.CheckboxKt$CheckboxImpl$checkDrawFraction$1 r10 = androidx.compose.material3.CheckboxKt$CheckboxImpl$checkDrawFraction$1.INSTANCE
            kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
            r11 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            java.lang.String r13 = "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r11, r13)
            kotlin.jvm.internal.FloatCompanionObject r16 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r16 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r16)
            r39 = r13
            r13 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            java.lang.String r14 = "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r13, r14)
            java.lang.Object r17 = r6.getCurrentState()
            androidx.compose.ui.state.ToggleableState r17 = (androidx.compose.ui.state.ToggleableState) r17
            r8 = 1800065638(0x6b4ad266, float:2.451966E26)
            r12.startReplaceGroup(r8)
            java.lang.String r13 = "C:Checkbox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            boolean r19 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r11 = "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:283)"
            r5 = 0
            if (r19 == 0) goto L_0x00bb
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r5, r7, r11)
        L_0x00bb:
            int[] r19 = androidx.compose.material3.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r17 = r17.ordinal()
            r5 = r19[r17]
            r7 = 1
            r8 = 3
            r21 = 0
            r22 = 1065353216(0x3f800000, float:1.0)
            if (r5 == r7) goto L_0x00da
            r7 = 2
            if (r5 == r7) goto L_0x00d7
            if (r5 != r8) goto L_0x00d1
            goto L_0x00da
        L_0x00d1:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00d7:
            r5 = r21
            goto L_0x00dc
        L_0x00da:
            r5 = r22
        L_0x00dc:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00e5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00e5:
            r12.endReplaceGroup()
            java.lang.Float r7 = java.lang.Float.valueOf(r5)
            java.lang.Object r5 = r6.getTargetState()
            androidx.compose.ui.state.ToggleableState r5 = (androidx.compose.ui.state.ToggleableState) r5
            r8 = 1800065638(0x6b4ad266, float:2.451966E26)
            r12.startReplaceGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            boolean r19 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r19 == 0) goto L_0x010b
            r19 = r5
            r17 = r6
            r5 = 0
            r6 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r5, r6, r11)
            goto L_0x0110
        L_0x010b:
            r19 = r5
            r17 = r6
            r6 = -1
        L_0x0110:
            int[] r5 = androidx.compose.material3.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r8 = r19.ordinal()
            r5 = r5[r8]
            r8 = 1
            if (r5 == r8) goto L_0x012c
            r11 = 2
            if (r5 == r11) goto L_0x0128
            r11 = 3
            if (r5 != r11) goto L_0x0122
            goto L_0x012d
        L_0x0122:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0128:
            r11 = 3
            r5 = r21
            goto L_0x012f
        L_0x012c:
            r11 = 3
        L_0x012d:
            r5 = r22
        L_0x012f:
            boolean r19 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r19 == 0) goto L_0x0138
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0138:
            r12.endReplaceGroup()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            androidx.compose.animation.core.Transition$Segment r6 = r17.getSegment()
            r20 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r20)
            java.lang.Object r6 = r10.invoke(r6, r12, r8)
            androidx.compose.animation.core.FiniteAnimationSpec r6 = (androidx.compose.animation.core.FiniteAnimationSpec) r6
            r23 = r11
            java.lang.String r11 = "FloatAnimation"
            r8 = r13
            r13 = 0
            r25 = r8
            r10 = r16
            r8 = r5
            r16 = r15
            r15 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r5 = r39
            r39 = r9
            r9 = r6
            r6 = r17
            androidx.compose.runtime.State r32 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 r7 = androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1.INSTANCE
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r15, r5)
            kotlin.jvm.internal.FloatCompanionObject r5 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r10 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r5)
            r5 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r5, r14)
            java.lang.Object r5 = r6.getCurrentState()
            androidx.compose.ui.state.ToggleableState r5 = (androidx.compose.ui.state.ToggleableState) r5
            r8 = -1426969489(0xffffffffaaf22c6f, float:-4.3018668E-13)
            r12.startReplaceGroup(r8)
            r9 = r25
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r9)
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r14 = "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:300)"
            if (r11 == 0) goto L_0x01a2
            r11 = 0
            r15 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r11, r15, r14)
            goto L_0x01a3
        L_0x01a2:
            r15 = -1
        L_0x01a3:
            int[] r11 = androidx.compose.material3.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r11[r5]
            r11 = 1
            if (r5 == r11) goto L_0x01bd
            r13 = 2
            if (r5 == r13) goto L_0x01bd
            r13 = 3
            if (r5 != r13) goto L_0x01b7
            r5 = r22
            goto L_0x01c0
        L_0x01b7:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01bd:
            r13 = 3
            r5 = r21
        L_0x01c0:
            boolean r18 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r18 == 0) goto L_0x01c9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c9:
            r12.endReplaceGroup()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.Object r18 = r6.getTargetState()
            androidx.compose.ui.state.ToggleableState r18 = (androidx.compose.ui.state.ToggleableState) r18
            r12.startReplaceGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r9)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01e6
            r9 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r9, r15, r14)
        L_0x01e6:
            int[] r8 = androidx.compose.material3.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r9 = r18.ordinal()
            r8 = r8[r9]
            if (r8 == r11) goto L_0x01fe
            r11 = 2
            if (r8 == r11) goto L_0x01fe
            if (r8 != r13) goto L_0x01f8
            r21 = r22
            goto L_0x01fe
        L_0x01f8:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01fe:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0207
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0207:
            r12.endReplaceGroup()
            java.lang.Float r8 = java.lang.Float.valueOf(r21)
            androidx.compose.animation.core.Transition$Segment r9 = r6.getSegment()
            r20 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r20)
            java.lang.Object r7 = r7.invoke(r9, r12, r11)
            r9 = r7
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            java.lang.String r11 = "FloatAnimation"
            r7 = r5
            r5 = r32
            r13 = 0
            androidx.compose.runtime.State r6 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r7 = 974828454(0x3a1ab3a6, float:5.9014035E-4)
            java.lang.String r8 = "CC(remember):Checkbox.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r7, r8)
            java.lang.Object r7 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r7 != r9) goto L_0x0257
            androidx.compose.material3.CheckDrawingCache r24 = new androidx.compose.material3.CheckDrawingCache
            r28 = 7
            r29 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r24.<init>(r25, r26, r27, r28, r29)
            r7 = r24
            r12.updateRememberedValue(r7)
        L_0x0257:
            r34 = r7
            androidx.compose.material3.CheckDrawingCache r34 = (androidx.compose.material3.CheckDrawingCache) r34
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            int r7 = r16 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r39 | r7
            androidx.compose.runtime.State r7 = r4.checkmarkColor$material3_release(r2, r12, r7)
            r9 = r16 & 126(0x7e, float:1.77E-43)
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | r9
            androidx.compose.runtime.State r9 = r4.boxColor$material3_release(r1, r2, r12, r0)
            androidx.compose.runtime.State r0 = r4.borderColor$material3_release(r1, r2, r12, r0)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r10.getCenter()
            r11 = 0
            r13 = 0
            r14 = 2
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r3, r10, r13, r14, r11)
            float r11 = CheckboxSize
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.SizeKt.m837requiredSize3ABfNKs(r10, r11)
            r11 = 974837696(0x3a1ad7c0, float:5.906783E-4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r11, r8)
            boolean r8 = r12.changed((java.lang.Object) r9)
            boolean r11 = r12.changed((java.lang.Object) r0)
            r8 = r8 | r11
            boolean r11 = r12.changed((java.lang.Object) r7)
            r8 = r8 | r11
            boolean r11 = r12.changed((java.lang.Object) r5)
            r8 = r8 | r11
            boolean r11 = r12.changed((java.lang.Object) r6)
            r8 = r8 | r11
            java.lang.Object r11 = r12.rememberedValue()
            if (r8 != 0) goto L_0x02b4
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r11 != r8) goto L_0x02ca
        L_0x02b4:
            androidx.compose.material3.CheckboxKt$CheckboxImpl$1$1 r28 = new androidx.compose.material3.CheckboxKt$CheckboxImpl$1$1
            r30 = r0
            r32 = r5
            r33 = r6
            r31 = r7
            r29 = r9
            r28.<init>(r29, r30, r31, r32, r33, r34)
            r11 = r28
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r12.updateRememberedValue(r11)
        L_0x02ca:
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r13 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r10, r11, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02dc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02dc:
            androidx.compose.runtime.ScopeUpdateScope r6 = r12.endRestartGroup()
            if (r6 == 0) goto L_0x02ee
            androidx.compose.material3.CheckboxKt$CheckboxImpl$2 r0 = new androidx.compose.material3.CheckboxKt$CheckboxImpl$2
            r5 = r40
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r6.updateScope(r0)
        L_0x02ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.CheckboxImpl(boolean, androidx.compose.ui.state.ToggleableState, androidx.compose.ui.Modifier, androidx.compose.material3.CheckboxColors, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs  reason: not valid java name */
    public static final void m1805drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f;
        float f4 = f2 / 2.0f;
        float f5 = f2;
        Stroke stroke = new Stroke(f5, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null);
        float r3 = Size.m4056getWidthimpl(drawScope.m4865getSizeNHjbRc());
        if (Color.m4240equalsimpl0(j, j2)) {
            DrawScope.m4842drawRoundRectuAw5IA$default(drawScope, j, 0, SizeKt.Size(r3, r3), CornerRadiusKt.CornerRadius$default(f3, 0.0f, 2, (Object) null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 226, (Object) null);
            return;
        }
        float f6 = r3 - (((float) 2) * f5);
        DrawScope drawScope2 = drawScope;
        DrawScope.m4842drawRoundRectuAw5IA$default(drawScope2, j, OffsetKt.Offset(f5, f5), SizeKt.Size(f6, f6), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f3 - f5), 0.0f, 2, (Object) null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
        float f7 = r3 - f5;
        DrawScope.m4842drawRoundRectuAw5IA$default(drawScope2, j2, OffsetKt.Offset(f4, f4), SizeKt.Size(f7, f7), CornerRadiusKt.CornerRadius$default(f3 - f4, 0.0f, 2, (Object) null), stroke, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCheck-3IgeMak  reason: not valid java name */
    public static final void m1806drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        float f4 = f2;
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.Companion.m4636getSquareKaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
        float r2 = Size.m4056getWidthimpl(drawScope.m4865getSizeNHjbRc());
        float lerp = MathHelpersKt.lerp(0.4f, 0.5f, f4);
        float lerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f4);
        float lerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f4);
        float lerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f4);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * r2, lerp3 * r2);
        checkDrawingCache.getCheckPath().lineTo(lerp * r2, lerp2 * r2);
        checkDrawingCache.getCheckPath().lineTo(0.8f * r2, r2 * lerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m4836drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, (ColorFilter) null, 0, 52, (Object) null);
    }

    static {
        float f = (float) 2;
        CheckboxDefaultPadding = Dp.m7111constructorimpl(f);
        StrokeWidth = Dp.m7111constructorimpl(f);
        RadiusSize = Dp.m7111constructorimpl(f);
    }
}
