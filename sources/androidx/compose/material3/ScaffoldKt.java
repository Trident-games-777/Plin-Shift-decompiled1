package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a±\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0001\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0002\b\t2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scaffold.kt */
public final class ScaffoldKt {
    /* access modifiers changed from: private */
    public static final float FabSpacing = Dp.m7111constructorimpl((float) 16);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0122  */
    /* renamed from: Scaffold-TvnljyQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2391ScaffoldTvnljyQ(androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, int r33, long r34, long r36, androidx.compose.foundation.layout.WindowInsets r38, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r13 = r41
            r14 = r42
            r0 = -1219521777(0xffffffffb74f930f, float:-1.2372401E-5)
            r1 = r40
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Scaffold)P(7,9!1,8,5,6:c#material3.FabPosition,1:c#ui.graphics.Color,3:c#ui.graphics.Color,4)90@4654L11,91@4704L31,92@4794L19,95@4889L74,98@5047L224,104@5347L314,96@4968L693:Scaffold.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r14 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r13 | 6
            r4 = r3
            r3 = r28
            goto L_0x0030
        L_0x001c:
            r3 = r13 & 6
            if (r3 != 0) goto L_0x002d
            r3 = r28
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r13
            goto L_0x0030
        L_0x002d:
            r3 = r28
            r4 = r13
        L_0x0030:
            r5 = r14 & 2
            if (r5 == 0) goto L_0x0037
            r4 = r4 | 48
            goto L_0x004a
        L_0x0037:
            r6 = r13 & 48
            if (r6 != 0) goto L_0x004a
            r6 = r29
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x0046
            r7 = 32
            goto L_0x0048
        L_0x0046:
            r7 = 16
        L_0x0048:
            r4 = r4 | r7
            goto L_0x004c
        L_0x004a:
            r6 = r29
        L_0x004c:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0053
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r8 = r13 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0066
            r8 = r30
            boolean r9 = r1.changedInstance(r8)
            if (r9 == 0) goto L_0x0062
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r4 = r4 | r9
            goto L_0x0068
        L_0x0066:
            r8 = r30
        L_0x0068:
            r9 = r14 & 8
            if (r9 == 0) goto L_0x006f
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r10 = r13 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0082
            r10 = r31
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x007e
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r4 = r4 | r11
            goto L_0x0084
        L_0x0082:
            r10 = r31
        L_0x0084:
            r11 = r14 & 16
            if (r11 == 0) goto L_0x008b
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x008b:
            r12 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009e
            r12 = r32
            boolean r15 = r1.changedInstance(r12)
            if (r15 == 0) goto L_0x009a
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r4 = r4 | r15
            goto L_0x00a0
        L_0x009e:
            r12 = r32
        L_0x00a0:
            r15 = r14 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r15 == 0) goto L_0x00ab
            r4 = r4 | r16
            r0 = r33
            goto L_0x00be
        L_0x00ab:
            r16 = r13 & r16
            r0 = r33
            if (r16 != 0) goto L_0x00be
            boolean r17 = r1.changed((int) r0)
            if (r17 == 0) goto L_0x00ba
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r4 = r4 | r17
        L_0x00be:
            r17 = 1572864(0x180000, float:2.204052E-39)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00da
            r17 = r14 & 64
            r40 = r2
            r2 = r34
            if (r17 != 0) goto L_0x00d5
            boolean r17 = r1.changed((long) r2)
            if (r17 == 0) goto L_0x00d5
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r4 = r4 | r17
            goto L_0x00de
        L_0x00da:
            r40 = r2
            r2 = r34
        L_0x00de:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r18 = r13 & r17
            if (r18 != 0) goto L_0x00f7
            r0 = r14 & 128(0x80, float:1.794E-43)
            r2 = r36
            if (r0 != 0) goto L_0x00f3
            boolean r0 = r1.changed((long) r2)
            if (r0 == 0) goto L_0x00f3
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f5
        L_0x00f3:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f5:
            r4 = r4 | r0
            goto L_0x00f9
        L_0x00f7:
            r2 = r36
        L_0x00f9:
            r0 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r13 & r0
            r19 = r0
            if (r18 != 0) goto L_0x0117
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0110
            r0 = r38
            boolean r20 = r1.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x0112
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0114
        L_0x0110:
            r0 = r38
        L_0x0112:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0114:
            r4 = r4 | r20
            goto L_0x0119
        L_0x0117:
            r0 = r38
        L_0x0119:
            r0 = r14 & 512(0x200, float:7.175E-43)
            r20 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0122
            r4 = r4 | r20
            goto L_0x0136
        L_0x0122:
            r0 = r13 & r20
            if (r0 != 0) goto L_0x0136
            r0 = r39
            boolean r20 = r1.changedInstance(r0)
            if (r20 == 0) goto L_0x0131
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0133
        L_0x0131:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0133:
            r4 = r4 | r20
            goto L_0x0138
        L_0x0136:
            r0 = r39
        L_0x0138:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r4 & r20
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x015e
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0149
            goto L_0x015e
        L_0x0149:
            r1.skipToGroupEnd()
            r11 = r38
            r25 = r1
            r2 = r6
            r3 = r8
            r4 = r10
            r5 = r12
            r1 = r28
            r6 = r33
            r7 = r34
            r9 = r36
            goto L_0x02f9
        L_0x015e:
            r1.startDefaults()
            r0 = r13 & 1
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r3 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r20 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x019a
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0175
            goto L_0x019a
        L_0x0175:
            r1.skipToGroupEnd()
            r0 = r14 & 64
            if (r0 == 0) goto L_0x017e
            r4 = r4 & r20
        L_0x017e:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0183
            r4 = r4 & r3
        L_0x0183:
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0188
            r4 = r4 & r2
        L_0x0188:
            r0 = r28
            r9 = r33
            r2 = r34
            r11 = r38
            r5 = r6
            r6 = r8
            r7 = r10
            r8 = r12
            r10 = r19
            r19 = r36
            goto L_0x0215
        L_0x019a:
            if (r40 == 0) goto L_0x01a1
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01a3
        L_0x01a1:
            r0 = r28
        L_0x01a3:
            if (r5 == 0) goto L_0x01ac
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r5 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r5 = r5.m1931getLambda1$material3_release()
            goto L_0x01ad
        L_0x01ac:
            r5 = r6
        L_0x01ad:
            if (r7 == 0) goto L_0x01b6
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r6 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r6 = r6.m1932getLambda2$material3_release()
            goto L_0x01b7
        L_0x01b6:
            r6 = r8
        L_0x01b7:
            if (r9 == 0) goto L_0x01c0
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r7 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r7 = r7.m1933getLambda3$material3_release()
            goto L_0x01c1
        L_0x01c0:
            r7 = r10
        L_0x01c1:
            if (r11 == 0) goto L_0x01ca
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r8 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r8 = r8.m1934getLambda4$material3_release()
            goto L_0x01cb
        L_0x01ca:
            r8 = r12
        L_0x01cb:
            if (r15 == 0) goto L_0x01d4
            androidx.compose.material3.FabPosition$Companion r9 = androidx.compose.material3.FabPosition.Companion
            int r9 = r9.m2079getEndERTFSPs()
            goto L_0x01d6
        L_0x01d4:
            r9 = r33
        L_0x01d6:
            r10 = r14 & 64
            r11 = 6
            if (r10 == 0) goto L_0x01ed
            androidx.compose.material3.MaterialTheme r10 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r10 = r10.getColorScheme(r1, r11)
            long r21 = r10.m1848getBackground0d7_KjU()
            r4 = r4 & r20
            r10 = r2
            r40 = r3
            r2 = r21
            goto L_0x01f2
        L_0x01ed:
            r10 = r2
            r40 = r3
            r2 = r34
        L_0x01f2:
            r12 = r14 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0201
            int r12 = r4 >> 18
            r12 = r12 & 14
            long r20 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r2, r1, r12)
            r4 = r4 & r40
            goto L_0x0203
        L_0x0201:
            r20 = r36
        L_0x0203:
            r12 = r14 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x020f
            androidx.compose.material3.ScaffoldDefaults r12 = androidx.compose.material3.ScaffoldDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r11 = r12.getContentWindowInsets(r1, r11)
            r4 = r4 & r10
            goto L_0x0211
        L_0x020f:
            r11 = r38
        L_0x0211:
            r10 = r19
            r19 = r20
        L_0x0215:
            r1.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x022a
            r12 = -1
            java.lang.String r15 = "androidx.compose.material3.Scaffold (Scaffold.kt:94)"
            r28 = r10
            r10 = -1219521777(0xffffffffb74f930f, float:-1.2372401E-5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r4, r12, r15)
            goto L_0x022c
        L_0x022a:
            r28 = r10
        L_0x022c:
            r10 = -1794939901(0xffffffff95036403, float:-2.6534135E-26)
            java.lang.String r12 = "CC(remember):Scaffold.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r10, r12)
            r10 = 234881024(0xe000000, float:1.5777218E-30)
            r10 = r10 & r4
            r10 = r10 ^ r28
            r15 = 67108864(0x4000000, float:1.5046328E-36)
            if (r10 <= r15) goto L_0x0243
            boolean r16 = r1.changed((java.lang.Object) r11)
            if (r16 != 0) goto L_0x0247
        L_0x0243:
            r12 = r4 & r28
            if (r12 != r15) goto L_0x0249
        L_0x0247:
            r12 = 1
            goto L_0x024a
        L_0x0249:
            r12 = 0
        L_0x024a:
            java.lang.Object r15 = r1.rememberedValue()
            if (r12 != 0) goto L_0x0258
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r15 != r12) goto L_0x0260
        L_0x0258:
            androidx.compose.material3.internal.MutableWindowInsets r15 = new androidx.compose.material3.internal.MutableWindowInsets
            r15.<init>(r11)
            r1.updateRememberedValue(r15)
        L_0x0260:
            androidx.compose.material3.internal.MutableWindowInsets r15 = (androidx.compose.material3.internal.MutableWindowInsets) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r12 = -1794934695(0xffffffff95037859, float:-2.6550177E-26)
            r37 = r2
            java.lang.String r2 = "CC(remember):Scaffold.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r12, r2)
            boolean r2 = r1.changed((java.lang.Object) r15)
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            if (r10 <= r3) goto L_0x027d
            boolean r10 = r1.changed((java.lang.Object) r11)
            if (r10 != 0) goto L_0x0281
        L_0x027d:
            r10 = r4 & r28
            if (r10 != r3) goto L_0x0283
        L_0x0281:
            r3 = 1
            goto L_0x0284
        L_0x0283:
            r3 = 0
        L_0x0284:
            r2 = r2 | r3
            java.lang.Object r3 = r1.rememberedValue()
            if (r2 != 0) goto L_0x0293
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x029e
        L_0x0293:
            androidx.compose.material3.ScaffoldKt$Scaffold$1$1 r2 = new androidx.compose.material3.ScaffoldKt$Scaffold$1$1
            r2.<init>(r15, r11)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r1.updateRememberedValue(r3)
        L_0x029e:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(r0, r3)
            androidx.compose.material3.ScaffoldKt$Scaffold$2 r3 = new androidx.compose.material3.ScaffoldKt$Scaffold$2
            r31 = r39
            r28 = r3
            r30 = r5
            r35 = r6
            r32 = r7
            r33 = r8
            r29 = r9
            r34 = r15
            r28.<init>(r29, r30, r31, r32, r33, r34, r35)
            r10 = 54
            r12 = -1979205334(0xffffffff8a07b92a, float:-6.534839E-33)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r12, r15, r3, r1, r10)
            r24 = r3
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            int r3 = r4 >> 12
            r4 = r3 & 896(0x380, float:1.256E-42)
            r4 = r4 | r17
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r26 = r4 | r3
            r27 = 114(0x72, float:1.6E-43)
            r16 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r17 = r37
            r25 = r1
            r15 = r2
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r27)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x02ef
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02ef:
            r1 = r0
            r2 = r5
            r3 = r6
            r4 = r7
            r5 = r8
            r6 = r9
            r7 = r17
            r9 = r19
        L_0x02f9:
            androidx.compose.runtime.ScopeUpdateScope r15 = r25.endRestartGroup()
            if (r15 == 0) goto L_0x030b
            androidx.compose.material3.ScaffoldKt$Scaffold$3 r0 = new androidx.compose.material3.ScaffoldKt$Scaffold$3
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x030b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ScaffoldKt.m2391ScaffoldTvnljyQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, int, long, long, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-FMILGgc  reason: not valid java name */
    public static final void m2392ScaffoldLayoutFMILGgc(int i, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, int i2) {
        int i3;
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32;
        Function2<? super Composer, ? super Integer, Unit> function25;
        WindowInsets windowInsets2;
        int i4;
        int i5 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-975511942);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScaffoldLayout)P(4:c#material3.FabPosition,6,1,5,3,2)139@6582L6951,139@6565L6968:Scaffold.kt#uh7d8r");
        int i6 = i;
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed(i6) ? 4 : 2) | i5;
        } else {
            i3 = i5;
        }
        Function2<? super Composer, ? super Integer, Unit> function26 = function2;
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            function32 = function3;
            i3 |= startRestartGroup.changedInstance(function32) ? 256 : 128;
        } else {
            function32 = function3;
        }
        Function2<? super Composer, ? super Integer, Unit> function27 = function22;
        if ((i5 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function27) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            function25 = function23;
            i3 |= startRestartGroup.changedInstance(function25) ? 16384 : 8192;
        } else {
            function25 = function23;
        }
        if ((196608 & i5) == 0) {
            windowInsets2 = windowInsets;
            i3 |= startRestartGroup.changed((Object) windowInsets2) ? 131072 : 65536;
        } else {
            windowInsets2 = windowInsets;
        }
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        if ((i5 & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function28) ? 1048576 : 524288;
        }
        if ((i3 & 599187) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, i3, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:138)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1690368138, "CC(remember):Scaffold.kt#9igjgp");
            boolean z = ((i3 & 112) == 32) | ((i3 & 7168) == 2048) | ((458752 & i3) == 131072) | ((57344 & i3) == 16384) | ((i3 & 14) == 4) | ((3670016 & i3) == 1048576) | ((i3 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                i4 = 0;
                rememberedValue = new ScaffoldKt$ScaffoldLayout$1$1(function26, function27, function25, i6, windowInsets2, function28, function32);
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                i4 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, (Function2) rememberedValue, startRestartGroup, i4, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ScaffoldKt$ScaffoldLayout$2(i, function2, function3, function22, function23, windowInsets, function24, i5));
        }
    }
}
