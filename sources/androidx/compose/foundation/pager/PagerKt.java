package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aâ\u0001\u0010'\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0017\u0010,\u001a\u00020\u00012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\b\u001aL\u00100\u001a\u00020\u000b*\u00020\u001e2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u000bH\u0000\u001a,\u00109\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "currentPageOffset", "layoutSize", "spaceBetweenPages", "beforeContentPadding", "afterContentPadding", "currentPage", "currentPageOffsetFraction", "", "pageCount", "pagerSemantics", "isVertical", "scope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
public final class PagerKt {
    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012b  */
    /* renamed from: HorizontalPager-oI3XNZo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1093HorizontalPageroI3XNZo(androidx.compose.foundation.pager.PagerState r34, androidx.compose.ui.Modifier r35, androidx.compose.foundation.layout.PaddingValues r36, androidx.compose.foundation.pager.PageSize r37, int r38, float r39, androidx.compose.ui.Alignment.Vertical r40, androidx.compose.foundation.gestures.TargetedFlingBehavior r41, boolean r42, boolean r43, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r44, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r45, androidx.compose.foundation.gestures.snapping.SnapPosition r46, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, int r49, int r50, int r51) {
        /*
            r1 = r34
            r9 = r49
            r10 = r50
            r11 = r51
            r12 = 1870896258(0x6f839c82, float:8.1463485E28)
            r0 = r48
            androidx.compose.runtime.Composer r6 = r0.startRestartGroup(r12)
            java.lang.String r0 = "C(HorizontalPager)P(11,4,1,7!1,8:c#ui.unit.Dp,13!1,12,9!1,6,10)114@6534L28,118@6750L79,125@6952L661:Pager.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x001d
            r0 = r9 | 6
            goto L_0x002d
        L_0x001d:
            r0 = r9 & 6
            if (r0 != 0) goto L_0x002c
            boolean r0 = r6.changed((java.lang.Object) r1)
            if (r0 == 0) goto L_0x0029
            r0 = 4
            goto L_0x002a
        L_0x0029:
            r0 = 2
        L_0x002a:
            r0 = r0 | r9
            goto L_0x002d
        L_0x002c:
            r0 = r9
        L_0x002d:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0034
            r0 = r0 | 48
            goto L_0x0047
        L_0x0034:
            r8 = r9 & 48
            if (r8 != 0) goto L_0x0047
            r8 = r35
            boolean r13 = r6.changed((java.lang.Object) r8)
            if (r13 == 0) goto L_0x0043
            r13 = 32
            goto L_0x0045
        L_0x0043:
            r13 = 16
        L_0x0045:
            r0 = r0 | r13
            goto L_0x0049
        L_0x0047:
            r8 = r35
        L_0x0049:
            r13 = r11 & 4
            if (r13 == 0) goto L_0x0050
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0050:
            r2 = r9 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x0064
            r2 = r36
            boolean r16 = r6.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x005f
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r0 = r0 | r16
            goto L_0x0066
        L_0x0064:
            r2 = r36
        L_0x0066:
            r16 = r11 & 8
            r17 = 1024(0x400, float:1.435E-42)
            r18 = 2048(0x800, float:2.87E-42)
            if (r16 == 0) goto L_0x0071
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x0071:
            r3 = r9 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0085
            r3 = r37
            boolean r20 = r6.changed((java.lang.Object) r3)
            if (r20 == 0) goto L_0x0080
            r20 = r18
            goto L_0x0082
        L_0x0080:
            r20 = r17
        L_0x0082:
            r0 = r0 | r20
            goto L_0x0087
        L_0x0085:
            r3 = r37
        L_0x0087:
            r20 = r11 & 16
            if (r20 == 0) goto L_0x008e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008e:
            r5 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x00a2
            r5 = r38
            boolean r22 = r6.changed((int) r5)
            if (r22 == 0) goto L_0x009d
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r22
            goto L_0x00a4
        L_0x00a2:
            r5 = r38
        L_0x00a4:
            r22 = r11 & 32
            r23 = 196608(0x30000, float:2.75506E-40)
            if (r22 == 0) goto L_0x00af
            r0 = r0 | r23
            r7 = r39
            goto L_0x00c2
        L_0x00af:
            r24 = r9 & r23
            r7 = r39
            if (r24 != 0) goto L_0x00c2
            boolean r25 = r6.changed((float) r7)
            if (r25 == 0) goto L_0x00be
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r0 = r0 | r25
        L_0x00c2:
            r25 = r11 & 64
            r26 = 1572864(0x180000, float:2.204052E-39)
            if (r25 == 0) goto L_0x00cd
            r0 = r0 | r26
            r14 = r40
            goto L_0x00e0
        L_0x00cd:
            r26 = r9 & r26
            r14 = r40
            if (r26 != 0) goto L_0x00e0
            boolean r27 = r6.changed((java.lang.Object) r14)
            if (r27 == 0) goto L_0x00dc
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r0 = r0 | r27
        L_0x00e0:
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            r27 = r9 & r27
            if (r27 != 0) goto L_0x00fc
            r15 = r11 & 128(0x80, float:1.794E-43)
            if (r15 != 0) goto L_0x00f5
            r15 = r41
            boolean r28 = r6.changed((java.lang.Object) r15)
            if (r28 == 0) goto L_0x00f7
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f5:
            r15 = r41
        L_0x00f7:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r0 = r0 | r28
            goto L_0x00fe
        L_0x00fc:
            r15 = r41
        L_0x00fe:
            r12 = r11 & 256(0x100, float:3.59E-43)
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            if (r12 == 0) goto L_0x0109
            r0 = r0 | r29
            r2 = r42
            goto L_0x011c
        L_0x0109:
            r29 = r9 & r29
            r2 = r42
            if (r29 != 0) goto L_0x011c
            boolean r29 = r6.changed((boolean) r2)
            if (r29 == 0) goto L_0x0118
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011a
        L_0x0118:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011a:
            r0 = r0 | r29
        L_0x011c:
            r2 = r11 & 512(0x200, float:7.175E-43)
            r29 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x012b
            r0 = r0 | r29
            r30 = r0
            r29 = r2
            r2 = r43
            goto L_0x0147
        L_0x012b:
            r29 = r9 & r29
            if (r29 != 0) goto L_0x0141
            r29 = r2
            r2 = r43
            boolean r30 = r6.changed((boolean) r2)
            if (r30 == 0) goto L_0x013c
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013e
        L_0x013c:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013e:
            r0 = r0 | r30
            goto L_0x0145
        L_0x0141:
            r29 = r2
            r2 = r43
        L_0x0145:
            r30 = r0
        L_0x0147:
            r0 = r11 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0150
            r19 = r10 | 6
            r2 = r44
            goto L_0x0166
        L_0x0150:
            r31 = r10 & 6
            r2 = r44
            if (r31 != 0) goto L_0x0164
            boolean r31 = r6.changedInstance(r2)
            if (r31 == 0) goto L_0x015f
            r19 = 4
            goto L_0x0161
        L_0x015f:
            r19 = 2
        L_0x0161:
            r19 = r10 | r19
            goto L_0x0166
        L_0x0164:
            r19 = r10
        L_0x0166:
            r31 = r10 & 48
            if (r31 != 0) goto L_0x0182
            r31 = r0
            r0 = r11 & 2048(0x800, float:2.87E-42)
            if (r0 != 0) goto L_0x017b
            r0 = r45
            boolean r32 = r6.changedInstance(r0)
            if (r32 == 0) goto L_0x017d
            r21 = 32
            goto L_0x017f
        L_0x017b:
            r0 = r45
        L_0x017d:
            r21 = 16
        L_0x017f:
            r19 = r19 | r21
            goto L_0x0186
        L_0x0182:
            r31 = r0
            r0 = r45
        L_0x0186:
            r0 = r19
            r2 = r11 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x018f
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01a9
        L_0x018f:
            r19 = r0
            r0 = r10 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01a5
            r0 = r46
            boolean r21 = r6.changed((java.lang.Object) r0)
            if (r21 == 0) goto L_0x01a0
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x01a2
        L_0x01a0:
            r26 = 128(0x80, float:1.794E-43)
        L_0x01a2:
            r19 = r19 | r26
            goto L_0x01a7
        L_0x01a5:
            r0 = r46
        L_0x01a7:
            r0 = r19
        L_0x01a9:
            r1 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x01b0
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c1
        L_0x01b0:
            r1 = r10 & 3072(0xc00, float:4.305E-42)
            if (r1 != 0) goto L_0x01c1
            r1 = r47
            boolean r19 = r6.changedInstance(r1)
            if (r19 == 0) goto L_0x01be
            r17 = r18
        L_0x01be:
            r0 = r0 | r17
            goto L_0x01c3
        L_0x01c1:
            r1 = r47
        L_0x01c3:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r30 & r17
            r17 = r2
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x01f4
            r1 = r0 & 1171(0x493, float:1.641E-42)
            r2 = 1170(0x492, float:1.64E-42)
            if (r1 != r2) goto L_0x01f4
            boolean r1 = r6.getSkipping()
            if (r1 != 0) goto L_0x01dc
            goto L_0x01f4
        L_0x01dc:
            r6.skipToGroupEnd()
            r9 = r42
            r10 = r43
            r11 = r44
            r12 = r45
            r13 = r46
            r4 = r3
            r16 = r6
            r6 = r7
            r2 = r8
            r7 = r14
            r8 = r15
            r3 = r36
            goto L_0x0399
        L_0x01f4:
            r6.startDefaults()
            r1 = r9 & 1
            if (r1 == 0) goto L_0x022f
            boolean r1 = r6.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0202
            goto L_0x022f
        L_0x0202:
            r6.skipToGroupEnd()
            r1 = r11 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x020e
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r30 = r30 & r1
        L_0x020e:
            r1 = r11 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0214
            r0 = r0 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0214:
            r1 = r34
            r2 = r36
            r11 = r44
            r10 = r45
            r4 = r0
            r9 = r3
            r16 = r6
            r0 = r8
            r13 = r14
            r12 = r30
            r6 = r42
            r3 = r43
            r14 = r46
            r8 = r7
            r7 = r5
            r5 = r15
            goto L_0x02fc
        L_0x022f:
            if (r4 == 0) goto L_0x0238
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r18 = r1
            goto L_0x023a
        L_0x0238:
            r18 = r8
        L_0x023a:
            r1 = 0
            if (r13 == 0) goto L_0x0248
            float r2 = (float) r1
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r2)
            androidx.compose.foundation.layout.PaddingValues r2 = androidx.compose.foundation.layout.PaddingKt.m768PaddingValues0680j_4(r2)
            r13 = r2
            goto L_0x024a
        L_0x0248:
            r13 = r36
        L_0x024a:
            if (r16 == 0) goto L_0x0253
            androidx.compose.foundation.pager.PageSize$Fill r2 = androidx.compose.foundation.pager.PageSize.Fill.INSTANCE
            androidx.compose.foundation.pager.PageSize r2 = (androidx.compose.foundation.pager.PageSize) r2
            r16 = r2
            goto L_0x0255
        L_0x0253:
            r16 = r3
        L_0x0255:
            if (r20 == 0) goto L_0x025a
            r19 = r1
            goto L_0x025c
        L_0x025a:
            r19 = r5
        L_0x025c:
            if (r22 == 0) goto L_0x0266
            float r2 = (float) r1
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r2)
            r20 = r2
            goto L_0x0268
        L_0x0266:
            r20 = r7
        L_0x0268:
            if (r25 == 0) goto L_0x0271
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r2 = r2.getCenterVertically()
            r14 = r2
        L_0x0271:
            r2 = r11 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0299
            r2 = r0
            androidx.compose.foundation.pager.PagerDefaults r0 = androidx.compose.foundation.pager.PagerDefaults.INSTANCE
            r3 = r30 & 14
            r7 = r3 | r23
            r8 = 30
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r15 = r5
            r5 = 0
            r22 = r1
            r21 = r17
            r1 = r34
            r17 = r15
            androidx.compose.foundation.gestures.TargetedFlingBehavior r0 = r0.flingBehavior(r1, r2, r3, r4, r5, r6, r7, r8)
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r30 = r30 & r2
            r15 = r0
            goto L_0x02a1
        L_0x0299:
            r22 = r1
            r21 = r17
            r1 = r34
            r17 = r0
        L_0x02a1:
            if (r12 == 0) goto L_0x02a5
            r0 = 1
            goto L_0x02a7
        L_0x02a5:
            r0 = r42
        L_0x02a7:
            if (r29 == 0) goto L_0x02aa
            goto L_0x02ac
        L_0x02aa:
            r22 = r43
        L_0x02ac:
            if (r31 == 0) goto L_0x02b0
            r2 = 0
            goto L_0x02b2
        L_0x02b0:
            r2 = r44
        L_0x02b2:
            r3 = r11 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x02c7
            androidx.compose.foundation.pager.PagerDefaults r3 = androidx.compose.foundation.pager.PagerDefaults.INSTANCE
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Horizontal
            r5 = r30 & 14
            r5 = r5 | 432(0x1b0, float:6.05E-43)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r3.pageNestedScrollConnection(r1, r4, r6, r5)
            r4 = r17 & -113(0xffffffffffffff8f, float:NaN)
            r17 = r4
            goto L_0x02c9
        L_0x02c7:
            r3 = r45
        L_0x02c9:
            if (r21 == 0) goto L_0x02e4
            androidx.compose.foundation.gestures.snapping.SnapPosition$Start r4 = androidx.compose.foundation.gestures.snapping.SnapPosition.Start.INSTANCE
            androidx.compose.foundation.gestures.snapping.SnapPosition r4 = (androidx.compose.foundation.gestures.snapping.SnapPosition) r4
            r11 = r2
            r10 = r3
            r2 = r13
            r13 = r14
            r5 = r15
            r9 = r16
            r7 = r19
            r8 = r20
            r3 = r22
            r12 = r30
            r14 = r4
            r16 = r6
            r4 = r17
            goto L_0x02f9
        L_0x02e4:
            r11 = r2
            r10 = r3
            r2 = r13
            r13 = r14
            r5 = r15
            r9 = r16
            r4 = r17
            r7 = r19
            r8 = r20
            r3 = r22
            r12 = r30
            r14 = r46
            r16 = r6
        L_0x02f9:
            r6 = r0
            r0 = r18
        L_0x02fc:
            r16.endDefaults()
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x0310
            java.lang.String r15 = "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:124)"
            r35 = r0
            r0 = 1870896258(0x6f839c82, float:8.1463485E28)
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r4, r15)
            goto L_0x0312
        L_0x0310:
            r35 = r0
        L_0x0312:
            r0 = r4
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Horizontal
            androidx.compose.ui.Alignment$Companion r15 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r15 = r15.getCenterHorizontally()
            int r17 = r12 >> 3
            r36 = r0
            r0 = r17 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r17 = r12 << 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r0 = r0 | r17
            r37 = r0
            r0 = r12 & 896(0x380, float:1.256E-42)
            r0 = r37 | r0
            r37 = r0
            int r0 = r12 >> 18
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r37 | r0
            int r17 = r12 >> 6
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r17 & r18
            r0 = r0 | r18
            r18 = 3670016(0x380000, float:5.142788E-39)
            r17 = r17 & r18
            r0 = r0 | r17
            int r17 = r12 << 9
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r17 & r18
            r0 = r0 | r18
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r17 & r18
            r0 = r0 | r17
            int r17 = r12 << 18
            r18 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r17 & r18
            r17 = r0 | r17
            int r0 = r36 >> 3
            r0 = r0 & 14
            r0 = r0 | 384(0x180, float:5.38E-43)
            int r18 = r36 << 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r0 = r0 | r18
            int r12 = r12 >> 9
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r12
            int r12 = r36 << 6
            r18 = 57344(0xe000, float:8.0356E-41)
            r18 = r12 & r18
            r0 = r0 | r18
            r18 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r18
            r18 = r0 | r12
            r19 = 0
            r0 = r35
            r12 = r15
            r15 = r47
            androidx.compose.foundation.pager.LazyLayoutPagerKt.m1089PageruYRUAWA(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x038e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x038e:
            r4 = r9
            r12 = r10
            r10 = r3
            r9 = r6
            r6 = r8
            r3 = r2
            r8 = r5
            r5 = r7
            r7 = r13
            r13 = r14
            r2 = r0
        L_0x0399:
            androidx.compose.runtime.ScopeUpdateScope r0 = r16.endRestartGroup()
            if (r0 == 0) goto L_0x03b8
            r1 = r0
            androidx.compose.foundation.pager.PagerKt$HorizontalPager$1 r0 = new androidx.compose.foundation.pager.PagerKt$HorizontalPager$1
            r14 = r47
            r15 = r49
            r16 = r50
            r17 = r51
            r33 = r1
            r1 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r33
            r1.updateScope(r0)
        L_0x03b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m1093HorizontalPageroI3XNZo(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, androidx.compose.foundation.gestures.snapping.SnapPosition, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012b  */
    /* renamed from: VerticalPager-oI3XNZo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1094VerticalPageroI3XNZo(androidx.compose.foundation.pager.PagerState r34, androidx.compose.ui.Modifier r35, androidx.compose.foundation.layout.PaddingValues r36, androidx.compose.foundation.pager.PageSize r37, int r38, float r39, androidx.compose.ui.Alignment.Horizontal r40, androidx.compose.foundation.gestures.TargetedFlingBehavior r41, boolean r42, boolean r43, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r44, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r45, androidx.compose.foundation.gestures.snapping.SnapPosition r46, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, int r49, int r50, int r51) {
        /*
            r1 = r34
            r9 = r49
            r10 = r50
            r11 = r51
            r12 = 909160706(0x3630b102, float:2.6329076E-6)
            r0 = r48
            androidx.compose.runtime.Composer r6 = r0.startRestartGroup(r12)
            java.lang.String r0 = "C(VerticalPager)P(12,5,1,8!1,9:c#ui.unit.Dp,3!1,13,10!1,7,11)201@11541L28,205@11757L77,212@11957L659:Pager.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x001d
            r0 = r9 | 6
            goto L_0x002d
        L_0x001d:
            r0 = r9 & 6
            if (r0 != 0) goto L_0x002c
            boolean r0 = r6.changed((java.lang.Object) r1)
            if (r0 == 0) goto L_0x0029
            r0 = 4
            goto L_0x002a
        L_0x0029:
            r0 = 2
        L_0x002a:
            r0 = r0 | r9
            goto L_0x002d
        L_0x002c:
            r0 = r9
        L_0x002d:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0034
            r0 = r0 | 48
            goto L_0x0047
        L_0x0034:
            r8 = r9 & 48
            if (r8 != 0) goto L_0x0047
            r8 = r35
            boolean r13 = r6.changed((java.lang.Object) r8)
            if (r13 == 0) goto L_0x0043
            r13 = 32
            goto L_0x0045
        L_0x0043:
            r13 = 16
        L_0x0045:
            r0 = r0 | r13
            goto L_0x0049
        L_0x0047:
            r8 = r35
        L_0x0049:
            r13 = r11 & 4
            if (r13 == 0) goto L_0x0050
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0050:
            r2 = r9 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x0064
            r2 = r36
            boolean r16 = r6.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x005f
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r0 = r0 | r16
            goto L_0x0066
        L_0x0064:
            r2 = r36
        L_0x0066:
            r16 = r11 & 8
            r17 = 1024(0x400, float:1.435E-42)
            r18 = 2048(0x800, float:2.87E-42)
            if (r16 == 0) goto L_0x0071
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x0071:
            r3 = r9 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0085
            r3 = r37
            boolean r20 = r6.changed((java.lang.Object) r3)
            if (r20 == 0) goto L_0x0080
            r20 = r18
            goto L_0x0082
        L_0x0080:
            r20 = r17
        L_0x0082:
            r0 = r0 | r20
            goto L_0x0087
        L_0x0085:
            r3 = r37
        L_0x0087:
            r20 = r11 & 16
            if (r20 == 0) goto L_0x008e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008e:
            r5 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x00a2
            r5 = r38
            boolean r22 = r6.changed((int) r5)
            if (r22 == 0) goto L_0x009d
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r22
            goto L_0x00a4
        L_0x00a2:
            r5 = r38
        L_0x00a4:
            r22 = r11 & 32
            r23 = 196608(0x30000, float:2.75506E-40)
            if (r22 == 0) goto L_0x00af
            r0 = r0 | r23
            r7 = r39
            goto L_0x00c2
        L_0x00af:
            r24 = r9 & r23
            r7 = r39
            if (r24 != 0) goto L_0x00c2
            boolean r25 = r6.changed((float) r7)
            if (r25 == 0) goto L_0x00be
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r0 = r0 | r25
        L_0x00c2:
            r25 = r11 & 64
            r26 = 1572864(0x180000, float:2.204052E-39)
            if (r25 == 0) goto L_0x00cd
            r0 = r0 | r26
            r14 = r40
            goto L_0x00e0
        L_0x00cd:
            r26 = r9 & r26
            r14 = r40
            if (r26 != 0) goto L_0x00e0
            boolean r27 = r6.changed((java.lang.Object) r14)
            if (r27 == 0) goto L_0x00dc
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r0 = r0 | r27
        L_0x00e0:
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            r27 = r9 & r27
            if (r27 != 0) goto L_0x00fc
            r15 = r11 & 128(0x80, float:1.794E-43)
            if (r15 != 0) goto L_0x00f5
            r15 = r41
            boolean r28 = r6.changed((java.lang.Object) r15)
            if (r28 == 0) goto L_0x00f7
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f5:
            r15 = r41
        L_0x00f7:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r0 = r0 | r28
            goto L_0x00fe
        L_0x00fc:
            r15 = r41
        L_0x00fe:
            r12 = r11 & 256(0x100, float:3.59E-43)
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            if (r12 == 0) goto L_0x0109
            r0 = r0 | r29
            r2 = r42
            goto L_0x011c
        L_0x0109:
            r29 = r9 & r29
            r2 = r42
            if (r29 != 0) goto L_0x011c
            boolean r29 = r6.changed((boolean) r2)
            if (r29 == 0) goto L_0x0118
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011a
        L_0x0118:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011a:
            r0 = r0 | r29
        L_0x011c:
            r2 = r11 & 512(0x200, float:7.175E-43)
            r29 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x012b
            r0 = r0 | r29
            r30 = r0
            r29 = r2
            r2 = r43
            goto L_0x0147
        L_0x012b:
            r29 = r9 & r29
            if (r29 != 0) goto L_0x0141
            r29 = r2
            r2 = r43
            boolean r30 = r6.changed((boolean) r2)
            if (r30 == 0) goto L_0x013c
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013e
        L_0x013c:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013e:
            r0 = r0 | r30
            goto L_0x0145
        L_0x0141:
            r29 = r2
            r2 = r43
        L_0x0145:
            r30 = r0
        L_0x0147:
            r0 = r11 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0150
            r19 = r10 | 6
            r2 = r44
            goto L_0x0166
        L_0x0150:
            r31 = r10 & 6
            r2 = r44
            if (r31 != 0) goto L_0x0164
            boolean r31 = r6.changedInstance(r2)
            if (r31 == 0) goto L_0x015f
            r19 = 4
            goto L_0x0161
        L_0x015f:
            r19 = 2
        L_0x0161:
            r19 = r10 | r19
            goto L_0x0166
        L_0x0164:
            r19 = r10
        L_0x0166:
            r31 = r10 & 48
            if (r31 != 0) goto L_0x0182
            r31 = r0
            r0 = r11 & 2048(0x800, float:2.87E-42)
            if (r0 != 0) goto L_0x017b
            r0 = r45
            boolean r32 = r6.changedInstance(r0)
            if (r32 == 0) goto L_0x017d
            r21 = 32
            goto L_0x017f
        L_0x017b:
            r0 = r45
        L_0x017d:
            r21 = 16
        L_0x017f:
            r19 = r19 | r21
            goto L_0x0186
        L_0x0182:
            r31 = r0
            r0 = r45
        L_0x0186:
            r0 = r19
            r2 = r11 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x018f
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01a9
        L_0x018f:
            r19 = r0
            r0 = r10 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01a5
            r0 = r46
            boolean r21 = r6.changed((java.lang.Object) r0)
            if (r21 == 0) goto L_0x01a0
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x01a2
        L_0x01a0:
            r26 = 128(0x80, float:1.794E-43)
        L_0x01a2:
            r19 = r19 | r26
            goto L_0x01a7
        L_0x01a5:
            r0 = r46
        L_0x01a7:
            r0 = r19
        L_0x01a9:
            r1 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x01b0
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c1
        L_0x01b0:
            r1 = r10 & 3072(0xc00, float:4.305E-42)
            if (r1 != 0) goto L_0x01c1
            r1 = r47
            boolean r19 = r6.changedInstance(r1)
            if (r19 == 0) goto L_0x01be
            r17 = r18
        L_0x01be:
            r0 = r0 | r17
            goto L_0x01c3
        L_0x01c1:
            r1 = r47
        L_0x01c3:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r30 & r17
            r17 = r2
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x01f4
            r1 = r0 & 1171(0x493, float:1.641E-42)
            r2 = 1170(0x492, float:1.64E-42)
            if (r1 != r2) goto L_0x01f4
            boolean r1 = r6.getSkipping()
            if (r1 != 0) goto L_0x01dc
            goto L_0x01f4
        L_0x01dc:
            r6.skipToGroupEnd()
            r9 = r42
            r10 = r43
            r11 = r44
            r12 = r45
            r13 = r46
            r4 = r3
            r16 = r6
            r6 = r7
            r2 = r8
            r7 = r14
            r8 = r15
            r3 = r36
            goto L_0x0399
        L_0x01f4:
            r6.startDefaults()
            r1 = r9 & 1
            if (r1 == 0) goto L_0x022f
            boolean r1 = r6.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0202
            goto L_0x022f
        L_0x0202:
            r6.skipToGroupEnd()
            r1 = r11 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x020e
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r30 = r30 & r1
        L_0x020e:
            r1 = r11 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0214
            r0 = r0 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0214:
            r1 = r34
            r2 = r36
            r11 = r44
            r10 = r45
            r4 = r0
            r9 = r3
            r16 = r6
            r0 = r8
            r12 = r14
            r13 = r30
            r6 = r42
            r3 = r43
            r14 = r46
            r8 = r7
            r7 = r5
            r5 = r15
            goto L_0x02fc
        L_0x022f:
            if (r4 == 0) goto L_0x0238
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r18 = r1
            goto L_0x023a
        L_0x0238:
            r18 = r8
        L_0x023a:
            r1 = 0
            if (r13 == 0) goto L_0x0248
            float r2 = (float) r1
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r2)
            androidx.compose.foundation.layout.PaddingValues r2 = androidx.compose.foundation.layout.PaddingKt.m768PaddingValues0680j_4(r2)
            r13 = r2
            goto L_0x024a
        L_0x0248:
            r13 = r36
        L_0x024a:
            if (r16 == 0) goto L_0x0253
            androidx.compose.foundation.pager.PageSize$Fill r2 = androidx.compose.foundation.pager.PageSize.Fill.INSTANCE
            androidx.compose.foundation.pager.PageSize r2 = (androidx.compose.foundation.pager.PageSize) r2
            r16 = r2
            goto L_0x0255
        L_0x0253:
            r16 = r3
        L_0x0255:
            if (r20 == 0) goto L_0x025a
            r19 = r1
            goto L_0x025c
        L_0x025a:
            r19 = r5
        L_0x025c:
            if (r22 == 0) goto L_0x0266
            float r2 = (float) r1
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r2)
            r20 = r2
            goto L_0x0268
        L_0x0266:
            r20 = r7
        L_0x0268:
            if (r25 == 0) goto L_0x0271
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getCenterHorizontally()
            r14 = r2
        L_0x0271:
            r2 = r11 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0299
            r2 = r0
            androidx.compose.foundation.pager.PagerDefaults r0 = androidx.compose.foundation.pager.PagerDefaults.INSTANCE
            r3 = r30 & 14
            r7 = r3 | r23
            r8 = 30
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r15 = r5
            r5 = 0
            r22 = r1
            r21 = r17
            r1 = r34
            r17 = r15
            androidx.compose.foundation.gestures.TargetedFlingBehavior r0 = r0.flingBehavior(r1, r2, r3, r4, r5, r6, r7, r8)
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r30 = r30 & r2
            r15 = r0
            goto L_0x02a1
        L_0x0299:
            r22 = r1
            r21 = r17
            r1 = r34
            r17 = r0
        L_0x02a1:
            if (r12 == 0) goto L_0x02a5
            r0 = 1
            goto L_0x02a7
        L_0x02a5:
            r0 = r42
        L_0x02a7:
            if (r29 == 0) goto L_0x02aa
            goto L_0x02ac
        L_0x02aa:
            r22 = r43
        L_0x02ac:
            if (r31 == 0) goto L_0x02b0
            r2 = 0
            goto L_0x02b2
        L_0x02b0:
            r2 = r44
        L_0x02b2:
            r3 = r11 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x02c7
            androidx.compose.foundation.pager.PagerDefaults r3 = androidx.compose.foundation.pager.PagerDefaults.INSTANCE
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Vertical
            r5 = r30 & 14
            r5 = r5 | 432(0x1b0, float:6.05E-43)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r3.pageNestedScrollConnection(r1, r4, r6, r5)
            r4 = r17 & -113(0xffffffffffffff8f, float:NaN)
            r17 = r4
            goto L_0x02c9
        L_0x02c7:
            r3 = r45
        L_0x02c9:
            if (r21 == 0) goto L_0x02e4
            androidx.compose.foundation.gestures.snapping.SnapPosition$Start r4 = androidx.compose.foundation.gestures.snapping.SnapPosition.Start.INSTANCE
            androidx.compose.foundation.gestures.snapping.SnapPosition r4 = (androidx.compose.foundation.gestures.snapping.SnapPosition) r4
            r11 = r2
            r10 = r3
            r2 = r13
            r12 = r14
            r5 = r15
            r9 = r16
            r7 = r19
            r8 = r20
            r3 = r22
            r13 = r30
            r14 = r4
            r16 = r6
            r4 = r17
            goto L_0x02f9
        L_0x02e4:
            r11 = r2
            r10 = r3
            r2 = r13
            r12 = r14
            r5 = r15
            r9 = r16
            r4 = r17
            r7 = r19
            r8 = r20
            r3 = r22
            r13 = r30
            r14 = r46
            r16 = r6
        L_0x02f9:
            r6 = r0
            r0 = r18
        L_0x02fc:
            r16.endDefaults()
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x0310
            java.lang.String r15 = "androidx.compose.foundation.pager.VerticalPager (Pager.kt:211)"
            r35 = r0
            r0 = 909160706(0x3630b102, float:2.6329076E-6)
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r4, r15)
            goto L_0x0312
        L_0x0310:
            r35 = r0
        L_0x0312:
            r0 = r4
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Vertical
            androidx.compose.ui.Alignment$Companion r15 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r15 = r15.getCenterVertically()
            int r17 = r13 >> 3
            r36 = r0
            r0 = r17 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r17 = r13 << 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r0 = r0 | r17
            r37 = r0
            r0 = r13 & 896(0x380, float:1.256E-42)
            r0 = r37 | r0
            r37 = r0
            int r0 = r13 >> 18
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r37 | r0
            int r17 = r13 >> 6
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r17 & r18
            r0 = r0 | r18
            r18 = 3670016(0x380000, float:5.142788E-39)
            r17 = r17 & r18
            r0 = r0 | r17
            int r17 = r13 << 9
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r17 & r18
            r0 = r0 | r18
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r17 & r18
            r0 = r0 | r17
            int r17 = r13 << 18
            r18 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r17 & r18
            r17 = r0 | r17
            int r0 = r36 >> 3
            r0 = r0 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r18 = r36 << 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r0 = r0 | r18
            int r13 = r13 >> 12
            r13 = r13 & 896(0x380, float:1.256E-42)
            r0 = r0 | r13
            int r13 = r36 << 6
            r18 = 57344(0xe000, float:8.0356E-41)
            r18 = r13 & r18
            r0 = r0 | r18
            r18 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r18
            r18 = r0 | r13
            r19 = 0
            r0 = r35
            r13 = r15
            r15 = r47
            androidx.compose.foundation.pager.LazyLayoutPagerKt.m1089PageruYRUAWA(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x038e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x038e:
            r4 = r9
            r13 = r14
            r9 = r6
            r6 = r8
            r8 = r5
            r5 = r7
            r7 = r12
            r12 = r10
            r10 = r3
            r3 = r2
            r2 = r0
        L_0x0399:
            androidx.compose.runtime.ScopeUpdateScope r0 = r16.endRestartGroup()
            if (r0 == 0) goto L_0x03b8
            r1 = r0
            androidx.compose.foundation.pager.PagerKt$VerticalPager$1 r0 = new androidx.compose.foundation.pager.PagerKt$VerticalPager$1
            r14 = r47
            r15 = r49
            r16 = r50
            r17 = r51
            r33 = r1
            r1 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r33
            r1.updateScope(r0)
        L_0x03b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m1094VerticalPageroI3XNZo(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, androidx.compose.foundation.gestures.snapping.SnapPosition, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final int currentPageOffset(SnapPosition snapPosition, int i, int i2, int i3, int i4, int i5, int i6, float f, int i7) {
        int i8 = i2;
        return MathKt.roundToInt(((float) snapPosition.position(i, i8, i4, i5, i6, i7)) - (f * ((float) (i8 + i3))));
    }

    /* access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollForward()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$pagerSemantics$performForwardPaging$1(pagerState, (Continuation<? super PagerKt$pagerSemantics$performForwardPaging$1>) null), 3, (Object) null);
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollBackward()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$pagerSemantics$performBackwardPaging$1(pagerState, (Continuation<? super PagerKt$pagerSemantics$performBackwardPaging$1>) null), 3, (Object) null);
        return true;
    }

    public static final Modifier pagerSemantics(Modifier modifier, PagerState pagerState, boolean z, CoroutineScope coroutineScope, boolean z2) {
        if (z2) {
            return modifier.then(SemanticsModifierKt.semantics$default(Modifier.Companion, false, new PagerKt$pagerSemantics$1(z, pagerState, coroutineScope), 1, (Object) null));
        }
        return modifier.then(Modifier.Companion);
    }
}
