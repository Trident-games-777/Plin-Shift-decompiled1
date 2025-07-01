package androidx.compose.material3;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a0\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a0\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a0\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\t\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "HorizontalDivider", "HorizontalDivider-9IZ8Weo", "VerticalDivider", "VerticalDivider-9IZ8Weo", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Divider.kt */
public final class DividerKt {
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0078, code lost:
        if ((r14 & 4) != 0) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fb  */
    /* renamed from: HorizontalDivider-9IZ8Weo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2034HorizontalDivider9IZ8Weo(androidx.compose.ui.Modifier r8, float r9, long r10, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 75144485(0x47a9d25, float:2.9459516E-36)
            androidx.compose.runtime.Composer r12 = r12.startRestartGroup(r0)
            java.lang.String r1 = "C(HorizontalDivider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)52@2069L5,54@2134L220,54@2084L270:Divider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0013
            r2 = r13 | 6
            goto L_0x0023
        L_0x0013:
            r2 = r13 & 6
            if (r2 != 0) goto L_0x0022
            boolean r2 = r12.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x001f
            r2 = 4
            goto L_0x0020
        L_0x001f:
            r2 = 2
        L_0x0020:
            r2 = r2 | r13
            goto L_0x0023
        L_0x0022:
            r2 = r13
        L_0x0023:
            r3 = r14 & 2
            r4 = 32
            if (r3 == 0) goto L_0x002c
            r2 = r2 | 48
            goto L_0x003b
        L_0x002c:
            r5 = r13 & 48
            if (r5 != 0) goto L_0x003b
            boolean r5 = r12.changed((float) r9)
            if (r5 == 0) goto L_0x0038
            r5 = r4
            goto L_0x003a
        L_0x0038:
            r5 = 16
        L_0x003a:
            r2 = r2 | r5
        L_0x003b:
            r5 = r13 & 384(0x180, float:5.38E-43)
            r6 = 256(0x100, float:3.59E-43)
            if (r5 != 0) goto L_0x0050
            r5 = r14 & 4
            if (r5 != 0) goto L_0x004d
            boolean r5 = r12.changed((long) r10)
            if (r5 == 0) goto L_0x004d
            r5 = r6
            goto L_0x004f
        L_0x004d:
            r5 = 128(0x80, float:1.794E-43)
        L_0x004f:
            r2 = r2 | r5
        L_0x0050:
            r5 = r2 & 147(0x93, float:2.06E-43)
            r7 = 146(0x92, float:2.05E-43)
            if (r5 != r7) goto L_0x0065
            boolean r5 = r12.getSkipping()
            if (r5 != 0) goto L_0x005d
            goto L_0x0065
        L_0x005d:
            r12.skipToGroupEnd()
        L_0x0060:
            r2 = r8
            r3 = r9
            r4 = r10
            goto L_0x0100
        L_0x0065:
            r12.startDefaults()
            r5 = r13 & 1
            if (r5 == 0) goto L_0x007d
            boolean r5 = r12.getDefaultsInvalid()
            if (r5 == 0) goto L_0x0073
            goto L_0x007d
        L_0x0073:
            r12.skipToGroupEnd()
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0097
        L_0x007a:
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0097
        L_0x007d:
            if (r1 == 0) goto L_0x0083
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
        L_0x0083:
            if (r3 == 0) goto L_0x008b
            androidx.compose.material3.DividerDefaults r9 = androidx.compose.material3.DividerDefaults.INSTANCE
            float r9 = r9.m2032getThicknessD9Ej5fM()
        L_0x008b:
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0097
            androidx.compose.material3.DividerDefaults r10 = androidx.compose.material3.DividerDefaults.INSTANCE
            r11 = 6
            long r10 = r10.getColor(r12, r11)
            goto L_0x007a
        L_0x0097:
            r12.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00a6
            r1 = -1
            java.lang.String r3 = "androidx.compose.material3.HorizontalDivider (Divider.kt:54)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r1, r3)
        L_0x00a6:
            r0 = 0
            r1 = 0
            r3 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r8, r0, r3, r1)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r0, r9)
            r1 = -873178642(0xffffffffcbf459ee, float:-3.2027612E7)
            java.lang.String r5 = "CC(remember):Divider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r5)
            r1 = r2 & 112(0x70, float:1.57E-43)
            r5 = 0
            if (r1 != r4) goto L_0x00c0
            r1 = r3
            goto L_0x00c1
        L_0x00c0:
            r1 = r5
        L_0x00c1:
            r4 = r2 & 896(0x380, float:1.256E-42)
            r4 = r4 ^ 384(0x180, float:5.38E-43)
            if (r4 <= r6) goto L_0x00cd
            boolean r4 = r12.changed((long) r10)
            if (r4 != 0) goto L_0x00d3
        L_0x00cd:
            r2 = r2 & 384(0x180, float:5.38E-43)
            if (r2 != r6) goto L_0x00d2
            goto L_0x00d3
        L_0x00d2:
            r3 = r5
        L_0x00d3:
            r1 = r1 | r3
            java.lang.Object r2 = r12.rememberedValue()
            if (r1 != 0) goto L_0x00e2
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x00ed
        L_0x00e2:
            androidx.compose.material3.DividerKt$HorizontalDivider$1$1 r1 = new androidx.compose.material3.DividerKt$HorizontalDivider$1$1
            r1.<init>(r9, r10)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12.updateRememberedValue(r2)
        L_0x00ed:
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.foundation.CanvasKt.Canvas(r0, r2, r12, r5)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0060
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0060
        L_0x0100:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 == 0) goto L_0x0112
            androidx.compose.material3.DividerKt$HorizontalDivider$2 r1 = new androidx.compose.material3.DividerKt$HorizontalDivider$2
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r8.updateScope(r1)
        L_0x0112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DividerKt.m2034HorizontalDivider9IZ8Weo(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0078, code lost:
        if ((r14 & 4) != 0) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fb  */
    /* renamed from: VerticalDivider-9IZ8Weo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2035VerticalDivider9IZ8Weo(androidx.compose.ui.Modifier r8, float r9, long r10, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = -1534852205(0xffffffffa4840393, float:-5.725193E-17)
            androidx.compose.runtime.Composer r12 = r12.startRestartGroup(r0)
            java.lang.String r1 = "C(VerticalDivider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)81@3089L5,83@3154L221,83@3104L271:Divider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0013
            r2 = r13 | 6
            goto L_0x0023
        L_0x0013:
            r2 = r13 & 6
            if (r2 != 0) goto L_0x0022
            boolean r2 = r12.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x001f
            r2 = 4
            goto L_0x0020
        L_0x001f:
            r2 = 2
        L_0x0020:
            r2 = r2 | r13
            goto L_0x0023
        L_0x0022:
            r2 = r13
        L_0x0023:
            r3 = r14 & 2
            r4 = 32
            if (r3 == 0) goto L_0x002c
            r2 = r2 | 48
            goto L_0x003b
        L_0x002c:
            r5 = r13 & 48
            if (r5 != 0) goto L_0x003b
            boolean r5 = r12.changed((float) r9)
            if (r5 == 0) goto L_0x0038
            r5 = r4
            goto L_0x003a
        L_0x0038:
            r5 = 16
        L_0x003a:
            r2 = r2 | r5
        L_0x003b:
            r5 = r13 & 384(0x180, float:5.38E-43)
            r6 = 256(0x100, float:3.59E-43)
            if (r5 != 0) goto L_0x0050
            r5 = r14 & 4
            if (r5 != 0) goto L_0x004d
            boolean r5 = r12.changed((long) r10)
            if (r5 == 0) goto L_0x004d
            r5 = r6
            goto L_0x004f
        L_0x004d:
            r5 = 128(0x80, float:1.794E-43)
        L_0x004f:
            r2 = r2 | r5
        L_0x0050:
            r5 = r2 & 147(0x93, float:2.06E-43)
            r7 = 146(0x92, float:2.05E-43)
            if (r5 != r7) goto L_0x0065
            boolean r5 = r12.getSkipping()
            if (r5 != 0) goto L_0x005d
            goto L_0x0065
        L_0x005d:
            r12.skipToGroupEnd()
        L_0x0060:
            r2 = r8
            r3 = r9
            r4 = r10
            goto L_0x0100
        L_0x0065:
            r12.startDefaults()
            r5 = r13 & 1
            if (r5 == 0) goto L_0x007d
            boolean r5 = r12.getDefaultsInvalid()
            if (r5 == 0) goto L_0x0073
            goto L_0x007d
        L_0x0073:
            r12.skipToGroupEnd()
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0097
        L_0x007a:
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0097
        L_0x007d:
            if (r1 == 0) goto L_0x0083
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
        L_0x0083:
            if (r3 == 0) goto L_0x008b
            androidx.compose.material3.DividerDefaults r9 = androidx.compose.material3.DividerDefaults.INSTANCE
            float r9 = r9.m2032getThicknessD9Ej5fM()
        L_0x008b:
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0097
            androidx.compose.material3.DividerDefaults r10 = androidx.compose.material3.DividerDefaults.INSTANCE
            r11 = 6
            long r10 = r10.getColor(r12, r11)
            goto L_0x007a
        L_0x0097:
            r12.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00a6
            r1 = -1
            java.lang.String r3 = "androidx.compose.material3.VerticalDivider (Divider.kt:83)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r1, r3)
        L_0x00a6:
            r0 = 0
            r1 = 0
            r3 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r8, r0, r3, r1)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r0, r9)
            r1 = -662977123(0xffffffffd87bc59d, float:-1.10730464E15)
            java.lang.String r5 = "CC(remember):Divider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r5)
            r1 = r2 & 112(0x70, float:1.57E-43)
            r5 = 0
            if (r1 != r4) goto L_0x00c0
            r1 = r3
            goto L_0x00c1
        L_0x00c0:
            r1 = r5
        L_0x00c1:
            r4 = r2 & 896(0x380, float:1.256E-42)
            r4 = r4 ^ 384(0x180, float:5.38E-43)
            if (r4 <= r6) goto L_0x00cd
            boolean r4 = r12.changed((long) r10)
            if (r4 != 0) goto L_0x00d3
        L_0x00cd:
            r2 = r2 & 384(0x180, float:5.38E-43)
            if (r2 != r6) goto L_0x00d2
            goto L_0x00d3
        L_0x00d2:
            r3 = r5
        L_0x00d3:
            r1 = r1 | r3
            java.lang.Object r2 = r12.rememberedValue()
            if (r1 != 0) goto L_0x00e2
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x00ed
        L_0x00e2:
            androidx.compose.material3.DividerKt$VerticalDivider$1$1 r1 = new androidx.compose.material3.DividerKt$VerticalDivider$1$1
            r1.<init>(r9, r10)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12.updateRememberedValue(r2)
        L_0x00ed:
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.foundation.CanvasKt.Canvas(r0, r2, r12, r5)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0060
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0060
        L_0x0100:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 == 0) goto L_0x0112
            androidx.compose.material3.DividerKt$VerticalDivider$2 r1 = new androidx.compose.material3.DividerKt$VerticalDivider$2
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r8.updateScope(r1)
        L_0x0112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DividerKt.m2035VerticalDivider9IZ8Weo(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0079, code lost:
        if ((r18 & 4) != 0) goto L_0x007b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0102  */
    @kotlin.Deprecated(message = "Renamed to HorizontalDivider", replaceWith = @kotlin.ReplaceWith(expression = "HorizontalDivider(modifier, thickness, color)", imports = {}))
    /* renamed from: Divider-9IZ8Weo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2033Divider9IZ8Weo(androidx.compose.ui.Modifier r12, float r13, long r14, androidx.compose.runtime.Composer r16, int r17, int r18) {
        /*
            r5 = r17
            r0 = 1562471785(0x5d216d69, float:7.270043E17)
            r1 = r16
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Divider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)100@3659L5,108@3840L78:Divider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r18 & 1
            if (r2 == 0) goto L_0x0017
            r3 = r5 | 6
            goto L_0x0027
        L_0x0017:
            r3 = r5 & 6
            if (r3 != 0) goto L_0x0026
            boolean r3 = r1.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x0023
            r3 = 4
            goto L_0x0024
        L_0x0023:
            r3 = 2
        L_0x0024:
            r3 = r3 | r5
            goto L_0x0027
        L_0x0026:
            r3 = r5
        L_0x0027:
            r4 = r18 & 2
            if (r4 == 0) goto L_0x002e
            r3 = r3 | 48
            goto L_0x003e
        L_0x002e:
            r6 = r5 & 48
            if (r6 != 0) goto L_0x003e
            boolean r6 = r1.changed((float) r13)
            if (r6 == 0) goto L_0x003b
            r6 = 32
            goto L_0x003d
        L_0x003b:
            r6 = 16
        L_0x003d:
            r3 = r3 | r6
        L_0x003e:
            r6 = r5 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0052
            r6 = r18 & 4
            if (r6 != 0) goto L_0x004f
            boolean r6 = r1.changed((long) r14)
            if (r6 == 0) goto L_0x004f
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0051
        L_0x004f:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0051:
            r3 = r3 | r6
        L_0x0052:
            r6 = r3 & 147(0x93, float:2.06E-43)
            r7 = 146(0x92, float:2.05E-43)
            if (r6 != r7) goto L_0x0066
            boolean r6 = r1.getSkipping()
            if (r6 != 0) goto L_0x005f
            goto L_0x0066
        L_0x005f:
            r1.skipToGroupEnd()
            r3 = r14
        L_0x0063:
            r2 = r13
            goto L_0x0108
        L_0x0066:
            r1.startDefaults()
            r6 = r5 & 1
            if (r6 == 0) goto L_0x007f
            boolean r6 = r1.getDefaultsInvalid()
            if (r6 == 0) goto L_0x0074
            goto L_0x007f
        L_0x0074:
            r1.skipToGroupEnd()
            r2 = r18 & 4
            if (r2 == 0) goto L_0x007d
        L_0x007b:
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x007d:
            r7 = r14
            goto L_0x0099
        L_0x007f:
            if (r2 == 0) goto L_0x0085
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
        L_0x0085:
            if (r4 == 0) goto L_0x008d
            androidx.compose.material3.DividerDefaults r13 = androidx.compose.material3.DividerDefaults.INSTANCE
            float r13 = r13.m2032getThicknessD9Ej5fM()
        L_0x008d:
            r2 = r18 & 4
            if (r2 == 0) goto L_0x007d
            androidx.compose.material3.DividerDefaults r14 = androidx.compose.material3.DividerDefaults.INSTANCE
            r15 = 6
            long r14 = r14.getColor(r1, r15)
            goto L_0x007b
        L_0x0099:
            r1.endDefaults()
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x00a8
            r14 = -1
            java.lang.String r15 = "androidx.compose.material3.Divider (Divider.kt:101)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r14, r15)
        L_0x00a8:
            r14 = -433645095(0xffffffffe62719d9, float:-1.97278E23)
            r1.startReplaceGroup(r14)
            java.lang.String r14 = "*104@3767L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            androidx.compose.ui.unit.Dp$Companion r14 = androidx.compose.ui.unit.Dp.Companion
            float r14 = r14.m7129getHairlineD9Ej5fM()
            boolean r14 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r13, r14)
            if (r14 == 0) goto L_0x00e2
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r0 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r15, r0)
            java.lang.Object r14 = r1.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            float r14 = r14.getDensity()
            r15 = 1065353216(0x3f800000, float:1.0)
            float r15 = r15 / r14
            float r14 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r15)
            goto L_0x00e3
        L_0x00e2:
            r14 = r13
        L_0x00e3:
            r1.endReplaceGroup()
            r15 = 0
            r0 = 0
            r2 = 1
            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r12, r15, r2, r0)
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r15, r14)
            r10 = 2
            r11 = 0
            r9 = 0
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.BackgroundKt.m248backgroundbw27NRU$default(r6, r7, r9, r10, r11)
            r15 = 0
            androidx.compose.foundation.layout.BoxKt.Box(r14, r1, r15)
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0105
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0105:
            r3 = r7
            goto L_0x0063
        L_0x0108:
            androidx.compose.runtime.ScopeUpdateScope r13 = r1.endRestartGroup()
            if (r13 == 0) goto L_0x011b
            androidx.compose.material3.DividerKt$Divider$1 r0 = new androidx.compose.material3.DividerKt$Divider$1
            r1 = r12
            r6 = r18
            r0.<init>(r1, r2, r3, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DividerKt.m2033Divider9IZ8Weo(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }
}
