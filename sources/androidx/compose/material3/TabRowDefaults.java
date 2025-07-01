package androidx.compose.material3;

import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.material3.tokens.SecondaryNavigationTabTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJD\u0010 \u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%J0\u0010&\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010\u001fJ\u0012\u0010(\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010)\u001a\u00020*R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\u00020\t8GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u00020\t8GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0010\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0014\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0016\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0017\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+²\u0006\n\u0010,\u001a\u00020\u0004X\u0002²\u0006\n\u0010-\u001a\u00020\u0004X\u0002"}, d2 = {"Landroidx/compose/material3/TabRowDefaults;", "", "()V", "ScrollableTabRowEdgeStartPadding", "Landroidx/compose/ui/unit/Dp;", "getScrollableTabRowEdgeStartPadding-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor$annotations", "getContentColor", "primaryContainerColor", "getPrimaryContainerColor", "primaryContentColor", "getPrimaryContentColor", "secondaryContainerColor", "getSecondaryContainerColor", "secondaryContentColor", "getSecondaryContentColor", "Indicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "height", "color", "Indicator-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "PrimaryIndicator", "width", "shape", "Landroidx/compose/ui/graphics/Shape;", "PrimaryIndicator-10LGxhE", "(Landroidx/compose/ui/Modifier;FFJLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "SecondaryIndicator", "SecondaryIndicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material3/TabPosition;", "material3_release", "currentTabWidth", "indicatorOffset"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();
    private static final float ScrollableTabRowEdgeStartPadding = Dp.m7111constructorimpl((float) 52);

    @Deprecated(message = "Use TabRowDefaults.primaryContainerColor instead", replaceWith = @ReplaceWith(expression = "primaryContainerColor", imports = {}))
    public static /* synthetic */ void getContainerColor$annotations() {
    }

    @Deprecated(message = "Use TabRowDefaults.primaryContentColor instead", replaceWith = @ReplaceWith(expression = "primaryContentColor", imports = {}))
    public static /* synthetic */ void getContentColor$annotations() {
    }

    private TabRowDefaults() {
    }

    /* renamed from: getScrollableTabRowEdgeStartPadding-D9Ej5fM  reason: not valid java name */
    public final float m2584getScrollableTabRowEdgeStartPaddingD9Ej5fM() {
        return ScrollableTabRowEdgeStartPadding;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2026555673, "C1159@49855L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2026555673, i, -1, "androidx.compose.material3.TabRowDefaults.<get-containerColor> (TabRow.kt:1159)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getPrimaryContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2069154037, "C1163@50026L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2069154037, i, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContainerColor> (TabRow.kt:1163)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getSecondaryContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1938007129, "C1167@50203L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1938007129, i, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContainerColor> (TabRow.kt:1167)");
        }
        long value = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1163072359, "C1175@50509L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1163072359, i, -1, "androidx.compose.material3.TabRowDefaults.<get-contentColor> (TabRow.kt:1175)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getPrimaryContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1410362619, "C1179@50682L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1410362619, i, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContentColor> (TabRow.kt:1179)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getSecondaryContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1166419479, "C1183@50861L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1166419479, i, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContentColor> (TabRow.kt:1183)");
        }
        long value = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d6  */
    @kotlin.Deprecated(message = "Use SecondaryIndicator instead.", replaceWith = @kotlin.ReplaceWith(expression = "SecondaryIndicator(modifier, height, color)", imports = {}))
    /* renamed from: Indicator-9IZ8Weo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2581Indicator9IZ8Weo(androidx.compose.ui.Modifier r14, float r15, long r16, androidx.compose.runtime.Composer r18, int r19, int r20) {
        /*
            r13 = this;
            r6 = r19
            r0 = 1454716052(0x56b53494, float:9.9618713E13)
            r1 = r18
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Indicator)P(2,1:c#ui.unit.Dp,0:c#ui.graphics.Color)1202@51501L11,1204@51588L69:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r20 & 1
            if (r2 == 0) goto L_0x0017
            r3 = r6 | 6
            goto L_0x0027
        L_0x0017:
            r3 = r6 & 6
            if (r3 != 0) goto L_0x0026
            boolean r3 = r1.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0023
            r3 = 4
            goto L_0x0024
        L_0x0023:
            r3 = 2
        L_0x0024:
            r3 = r3 | r6
            goto L_0x0027
        L_0x0026:
            r3 = r6
        L_0x0027:
            r4 = r20 & 2
            if (r4 == 0) goto L_0x002e
            r3 = r3 | 48
            goto L_0x003e
        L_0x002e:
            r5 = r6 & 48
            if (r5 != 0) goto L_0x003e
            boolean r5 = r1.changed((float) r15)
            if (r5 == 0) goto L_0x003b
            r5 = 32
            goto L_0x003d
        L_0x003b:
            r5 = 16
        L_0x003d:
            r3 = r3 | r5
        L_0x003e:
            r5 = r6 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0055
            r5 = r20 & 4
            r7 = r16
            if (r5 != 0) goto L_0x0051
            boolean r5 = r1.changed((long) r7)
            if (r5 == 0) goto L_0x0051
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0053
        L_0x0051:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0053:
            r3 = r3 | r5
            goto L_0x0057
        L_0x0055:
            r7 = r16
        L_0x0057:
            r5 = r3 & 147(0x93, float:2.06E-43)
            r9 = 146(0x92, float:2.05E-43)
            if (r5 != r9) goto L_0x006c
            boolean r5 = r1.getSkipping()
            if (r5 != 0) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            r1.skipToGroupEnd()
            r4 = r7
        L_0x0068:
            r2 = r14
            r3 = r15
            goto L_0x00db
        L_0x006c:
            r1.startDefaults()
            r5 = r6 & 1
            if (r5 == 0) goto L_0x0085
            boolean r5 = r1.getDefaultsInvalid()
            if (r5 == 0) goto L_0x007a
            goto L_0x0085
        L_0x007a:
            r1.skipToGroupEnd()
            r2 = r20 & 4
            if (r2 == 0) goto L_0x0083
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0083:
            r8 = r7
            goto L_0x00ab
        L_0x0085:
            if (r2 == 0) goto L_0x008b
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
        L_0x008b:
            if (r4 == 0) goto L_0x0093
            androidx.compose.material3.tokens.PrimaryNavigationTabTokens r15 = androidx.compose.material3.tokens.PrimaryNavigationTabTokens.INSTANCE
            float r15 = r15.m3480getActiveIndicatorHeightD9Ej5fM()
        L_0x0093:
            r2 = r20 & 4
            if (r2 == 0) goto L_0x0083
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material3.ColorScheme r2 = r2.getColorScheme(r1, r4)
            androidx.compose.material3.tokens.PrimaryNavigationTabTokens r4 = androidx.compose.material3.tokens.PrimaryNavigationTabTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getActiveIndicatorColor()
            long r4 = androidx.compose.material3.ColorSchemeKt.fromToken(r2, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r8 = r4
        L_0x00ab:
            r1.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00ba
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.TabRowDefaults.Indicator (TabRow.kt:1203)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r2, r4)
        L_0x00ba:
            r0 = 0
            r2 = 0
            r3 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r14, r0, r3, r2)
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r0, r15)
            r11 = 2
            r12 = 0
            r10 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m248backgroundbw27NRU$default(r7, r8, r10, r11, r12)
            r2 = 0
            androidx.compose.foundation.layout.BoxKt.Box(r0, r1, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00d9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00d9:
            r4 = r8
            goto L_0x0068
        L_0x00db:
            androidx.compose.runtime.ScopeUpdateScope r14 = r1.endRestartGroup()
            if (r14 == 0) goto L_0x00ee
            androidx.compose.material3.TabRowDefaults$Indicator$1 r0 = new androidx.compose.material3.TabRowDefaults$Indicator$1
            r1 = r13
            r7 = r20
            r0.<init>(r1, r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowDefaults.m2581Indicator9IZ8Weo(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* renamed from: PrimaryIndicator-10LGxhE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2582PrimaryIndicator10LGxhE(androidx.compose.ui.Modifier r17, float r18, float r19, long r20, androidx.compose.ui.graphics.Shape r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r16 = this;
            r8 = r24
            r0 = -1895596205(0xffffffff8f037f53, float:-6.4833204E-30)
            r1 = r23
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(PrimaryIndicator)P(2,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.graphics.Color)1222@52283L5,1225@52377L174:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r25 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r8 | 6
            r4 = r3
            r3 = r17
            goto L_0x002e
        L_0x001a:
            r3 = r8 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r17
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r8
            goto L_0x002e
        L_0x002b:
            r3 = r17
            r4 = r8
        L_0x002e:
            r5 = r25 & 2
            if (r5 == 0) goto L_0x0035
            r4 = r4 | 48
            goto L_0x0048
        L_0x0035:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x0048
            r6 = r18
            boolean r7 = r1.changed((float) r6)
            if (r7 == 0) goto L_0x0044
            r7 = 32
            goto L_0x0046
        L_0x0044:
            r7 = 16
        L_0x0046:
            r4 = r4 | r7
            goto L_0x004a
        L_0x0048:
            r6 = r18
        L_0x004a:
            r7 = r25 & 4
            if (r7 == 0) goto L_0x0051
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r9 = r8 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0064
            r9 = r19
            boolean r10 = r1.changed((float) r9)
            if (r10 == 0) goto L_0x0060
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r4 = r4 | r10
            goto L_0x0066
        L_0x0064:
            r9 = r19
        L_0x0066:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007f
            r10 = r25 & 8
            if (r10 != 0) goto L_0x0079
            r10 = r20
            boolean r12 = r1.changed((long) r10)
            if (r12 == 0) goto L_0x007b
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x0079:
            r10 = r20
        L_0x007b:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r4 = r4 | r12
            goto L_0x0081
        L_0x007f:
            r10 = r20
        L_0x0081:
            r12 = r25 & 16
            if (r12 == 0) goto L_0x0088
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r13 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009b
            r13 = r22
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r4 = r4 | r14
            goto L_0x009d
        L_0x009b:
            r13 = r22
        L_0x009d:
            r14 = r4 & 9363(0x2493, float:1.312E-41)
            r15 = 9362(0x2492, float:1.3119E-41)
            if (r14 != r15) goto L_0x00b4
            boolean r14 = r1.getSkipping()
            if (r14 != 0) goto L_0x00aa
            goto L_0x00b4
        L_0x00aa:
            r1.skipToGroupEnd()
            r2 = r3
        L_0x00ae:
            r3 = r6
            r4 = r9
            r5 = r10
            r7 = r13
            goto L_0x012d
        L_0x00b4:
            r1.startDefaults()
            r14 = r8 & 1
            if (r14 == 0) goto L_0x00cd
            boolean r14 = r1.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00c2
            goto L_0x00cd
        L_0x00c2:
            r1.skipToGroupEnd()
            r2 = r25 & 8
            if (r2 == 0) goto L_0x00cb
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00cb:
            r2 = r3
            goto L_0x0104
        L_0x00cd:
            if (r2 == 0) goto L_0x00d4
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00d5
        L_0x00d4:
            r2 = r3
        L_0x00d5:
            if (r5 == 0) goto L_0x00df
            r3 = 24
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            r6 = r3
        L_0x00df:
            if (r7 == 0) goto L_0x00e8
            androidx.compose.material3.tokens.PrimaryNavigationTabTokens r3 = androidx.compose.material3.tokens.PrimaryNavigationTabTokens.INSTANCE
            float r3 = r3.m3480getActiveIndicatorHeightD9Ej5fM()
            r9 = r3
        L_0x00e8:
            r3 = r25 & 8
            if (r3 == 0) goto L_0x00f9
            androidx.compose.material3.tokens.PrimaryNavigationTabTokens r3 = androidx.compose.material3.tokens.PrimaryNavigationTabTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r3 = r3.getActiveIndicatorColor()
            r5 = 6
            long r10 = androidx.compose.material3.ColorSchemeKt.getValue(r3, r1, r5)
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00f9:
            if (r12 == 0) goto L_0x0104
            androidx.compose.material3.tokens.PrimaryNavigationTabTokens r3 = androidx.compose.material3.tokens.PrimaryNavigationTabTokens.INSTANCE
            androidx.compose.foundation.shape.RoundedCornerShape r3 = r3.getActiveIndicatorShape()
            androidx.compose.ui.graphics.Shape r3 = (androidx.compose.ui.graphics.Shape) r3
            r13 = r3
        L_0x0104:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0113
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1224)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r3, r5)
        L_0x0113:
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m834requiredHeight3ABfNKs(r2, r9)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m842requiredWidth3ABfNKs(r0, r6)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m247backgroundbw27NRU(r0, r10, r13)
            r3 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r1, r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00ae
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x00ae
        L_0x012d:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x0141
            androidx.compose.material3.TabRowDefaults$PrimaryIndicator$1 r0 = new androidx.compose.material3.TabRowDefaults$PrimaryIndicator$1
            r1 = r16
            r9 = r25
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0141:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowDefaults.m2582PrimaryIndicator10LGxhE(androidx.compose.ui.Modifier, float, float, long, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d0  */
    /* renamed from: SecondaryIndicator-9IZ8Weo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2583SecondaryIndicator9IZ8Weo(androidx.compose.ui.Modifier r14, float r15, long r16, androidx.compose.runtime.Composer r18, int r19, int r20) {
        /*
            r13 = this;
            r6 = r19
            r0 = -1498258020(0xffffffffa6b2659c, float:-1.2378772E-15)
            r1 = r18
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(SecondaryIndicator)P(2,1:c#ui.unit.Dp,0:c#ui.graphics.Color)1245@53068L5,1247@53090L69:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r20 & 1
            if (r2 == 0) goto L_0x0017
            r3 = r6 | 6
            goto L_0x0027
        L_0x0017:
            r3 = r6 & 6
            if (r3 != 0) goto L_0x0026
            boolean r3 = r1.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0023
            r3 = 4
            goto L_0x0024
        L_0x0023:
            r3 = 2
        L_0x0024:
            r3 = r3 | r6
            goto L_0x0027
        L_0x0026:
            r3 = r6
        L_0x0027:
            r4 = r20 & 2
            if (r4 == 0) goto L_0x002e
            r3 = r3 | 48
            goto L_0x003e
        L_0x002e:
            r5 = r6 & 48
            if (r5 != 0) goto L_0x003e
            boolean r5 = r1.changed((float) r15)
            if (r5 == 0) goto L_0x003b
            r5 = 32
            goto L_0x003d
        L_0x003b:
            r5 = 16
        L_0x003d:
            r3 = r3 | r5
        L_0x003e:
            r5 = r6 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0055
            r5 = r20 & 4
            r7 = r16
            if (r5 != 0) goto L_0x0051
            boolean r5 = r1.changed((long) r7)
            if (r5 == 0) goto L_0x0051
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0053
        L_0x0051:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0053:
            r3 = r3 | r5
            goto L_0x0057
        L_0x0055:
            r7 = r16
        L_0x0057:
            r5 = r3 & 147(0x93, float:2.06E-43)
            r9 = 146(0x92, float:2.05E-43)
            if (r5 != r9) goto L_0x006c
            boolean r5 = r1.getSkipping()
            if (r5 != 0) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            r1.skipToGroupEnd()
            r4 = r7
        L_0x0068:
            r2 = r14
            r3 = r15
            goto L_0x00d5
        L_0x006c:
            r1.startDefaults()
            r5 = r6 & 1
            if (r5 == 0) goto L_0x0085
            boolean r5 = r1.getDefaultsInvalid()
            if (r5 == 0) goto L_0x007a
            goto L_0x0085
        L_0x007a:
            r1.skipToGroupEnd()
            r2 = r20 & 4
            if (r2 == 0) goto L_0x0083
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0083:
            r8 = r7
            goto L_0x00a5
        L_0x0085:
            if (r2 == 0) goto L_0x008b
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
        L_0x008b:
            if (r4 == 0) goto L_0x0093
            androidx.compose.material3.tokens.PrimaryNavigationTabTokens r15 = androidx.compose.material3.tokens.PrimaryNavigationTabTokens.INSTANCE
            float r15 = r15.m3480getActiveIndicatorHeightD9Ej5fM()
        L_0x0093:
            r2 = r20 & 4
            if (r2 == 0) goto L_0x0083
            androidx.compose.material3.tokens.PrimaryNavigationTabTokens r2 = androidx.compose.material3.tokens.PrimaryNavigationTabTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r2 = r2.getActiveIndicatorColor()
            r4 = 6
            long r4 = androidx.compose.material3.ColorSchemeKt.getValue(r2, r1, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r8 = r4
        L_0x00a5:
            r1.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00b4
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.TabRowDefaults.SecondaryIndicator (TabRow.kt:1246)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r2, r4)
        L_0x00b4:
            r0 = 0
            r2 = 0
            r3 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r14, r0, r3, r2)
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r0, r15)
            r11 = 2
            r12 = 0
            r10 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m248backgroundbw27NRU$default(r7, r8, r10, r11, r12)
            r2 = 0
            androidx.compose.foundation.layout.BoxKt.Box(r0, r1, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00d3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00d3:
            r4 = r8
            goto L_0x0068
        L_0x00d5:
            androidx.compose.runtime.ScopeUpdateScope r14 = r1.endRestartGroup()
            if (r14 == 0) goto L_0x00e8
            androidx.compose.material3.TabRowDefaults$SecondaryIndicator$1 r0 = new androidx.compose.material3.TabRowDefaults$SecondaryIndicator$1
            r1 = r13
            r7 = r20
            r0.<init>(r1, r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowDefaults.m2583SecondaryIndicator9IZ8Weo(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }

    public final Modifier tabIndicatorOffset(Modifier modifier, TabPosition tabPosition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1(tabPosition) : InspectableValueKt.getNoInspectorInfo(), new TabRowDefaults$tabIndicatorOffset$2(tabPosition));
    }
}
