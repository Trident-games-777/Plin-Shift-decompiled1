package androidx.compose.foundation.pager;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.reflect.KProperty0;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÞ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"21\u0010#\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010$¢\u0006\u0002\b'¢\u0006\u0002\b(H\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u0004\u001a\u00020\u000521\u0010#\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010$¢\u0006\u0002\b'¢\u0006\u0002\b(2#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100,H\u0003¢\u0006\u0002\u0010/\u001a\u0014\u00100\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-uYRUAWA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZIFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPager.kt */
public final class LazyLayoutPagerKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: androidx.compose.foundation.pager.PagerWrapperFlingBehavior} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v46, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v48, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v49, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v32, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v51, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v54, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v57, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v59, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v65, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0121  */
    /* renamed from: Pager-uYRUAWA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1089PageruYRUAWA(androidx.compose.ui.Modifier r30, androidx.compose.foundation.pager.PagerState r31, androidx.compose.foundation.layout.PaddingValues r32, boolean r33, androidx.compose.foundation.gestures.Orientation r34, androidx.compose.foundation.gestures.TargetedFlingBehavior r35, boolean r36, int r37, float r38, androidx.compose.foundation.pager.PageSize r39, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r40, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r41, androidx.compose.ui.Alignment.Horizontal r42, androidx.compose.ui.Alignment.Vertical r43, androidx.compose.foundation.gestures.snapping.SnapPosition r44, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, int r47, int r48, int r49) {
        /*
            r1 = r30
            r2 = r31
            r0 = r34
            r8 = r35
            r9 = r36
            r10 = r40
            r11 = r47
            r12 = r48
            r13 = r49
            r3 = 538371694(0x2016e66e, float:1.2781737E-19)
            r4 = r46
            androidx.compose.runtime.Composer r15 = r4.startRestartGroup(r3)
            java.lang.String r3 = "C(Pager)P(5,13,1,11,6,2,14!1,10:c#ui.unit.Dp,9,8,4!1,15,12)111@5277L19,107@5162L134,113@5323L24,128@5906L19,115@5373L558,131@5957L92,136@6083L94,140@6237L7,141@6278L147,152@6576L277,166@7108L154,172@7425L7,165@7052L482,176@7548L385,148@6431L1730:LazyLayoutPager.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x0027
            r3 = r11 | 6
            goto L_0x0037
        L_0x0027:
            r3 = r11 & 6
            if (r3 != 0) goto L_0x0036
            boolean r3 = r15.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0033
            r3 = 4
            goto L_0x0034
        L_0x0033:
            r3 = 2
        L_0x0034:
            r3 = r3 | r11
            goto L_0x0037
        L_0x0036:
            r3 = r11
        L_0x0037:
            r5 = r13 & 2
            if (r5 == 0) goto L_0x003e
            r3 = r3 | 48
            goto L_0x004e
        L_0x003e:
            r5 = r11 & 48
            if (r5 != 0) goto L_0x004e
            boolean r5 = r15.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x004b
            r5 = 32
            goto L_0x004d
        L_0x004b:
            r5 = 16
        L_0x004d:
            r3 = r3 | r5
        L_0x004e:
            r5 = r13 & 4
            r16 = 256(0x100, float:3.59E-43)
            r17 = 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x0059
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x0059:
            r5 = r11 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x006d
            r5 = r32
            boolean r18 = r15.changed((java.lang.Object) r5)
            if (r18 == 0) goto L_0x0068
            r18 = r16
            goto L_0x006a
        L_0x0068:
            r18 = r17
        L_0x006a:
            r3 = r3 | r18
            goto L_0x006f
        L_0x006d:
            r5 = r32
        L_0x006f:
            r18 = r13 & 8
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x007a
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x008e
        L_0x007a:
            r4 = r11 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x008e
            r4 = r33
            boolean r18 = r15.changed((boolean) r4)
            if (r18 == 0) goto L_0x0089
            r18 = r19
            goto L_0x008b
        L_0x0089:
            r18 = r20
        L_0x008b:
            r3 = r3 | r18
            goto L_0x0090
        L_0x008e:
            r4 = r33
        L_0x0090:
            r18 = r13 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x009b
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ab
        L_0x009b:
            r6 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x00ab
            boolean r6 = r15.changed((java.lang.Object) r0)
            if (r6 == 0) goto L_0x00a8
            r6 = r21
            goto L_0x00aa
        L_0x00a8:
            r6 = r22
        L_0x00aa:
            r3 = r3 | r6
        L_0x00ab:
            r6 = r13 & 32
            r24 = 196608(0x30000, float:2.75506E-40)
            if (r6 == 0) goto L_0x00b4
            r3 = r3 | r24
            goto L_0x00c4
        L_0x00b4:
            r6 = r11 & r24
            if (r6 != 0) goto L_0x00c4
            boolean r6 = r15.changed((java.lang.Object) r8)
            if (r6 == 0) goto L_0x00c1
            r6 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r6 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r3 = r3 | r6
        L_0x00c4:
            r6 = r13 & 64
            if (r6 == 0) goto L_0x00cc
            r6 = 1572864(0x180000, float:2.204052E-39)
        L_0x00ca:
            r3 = r3 | r6
            goto L_0x00dd
        L_0x00cc:
            r6 = 1572864(0x180000, float:2.204052E-39)
            r6 = r6 & r11
            if (r6 != 0) goto L_0x00dd
            boolean r6 = r15.changed((boolean) r9)
            if (r6 == 0) goto L_0x00da
            r6 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ca
        L_0x00da:
            r6 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00ca
        L_0x00dd:
            r6 = r13 & 128(0x80, float:1.794E-43)
            r25 = 12582912(0xc00000, float:1.7632415E-38)
            if (r6 == 0) goto L_0x00e8
            r3 = r3 | r25
            r7 = r37
            goto L_0x00fb
        L_0x00e8:
            r25 = r11 & r25
            r7 = r37
            if (r25 != 0) goto L_0x00fb
            boolean r26 = r15.changed((int) r7)
            if (r26 == 0) goto L_0x00f7
            r26 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r26 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r3 = r3 | r26
        L_0x00fb:
            r14 = r13 & 256(0x100, float:3.59E-43)
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            if (r14 == 0) goto L_0x0106
            r3 = r3 | r27
            r0 = r38
            goto L_0x0119
        L_0x0106:
            r27 = r11 & r27
            r0 = r38
            if (r27 != 0) goto L_0x0119
            boolean r27 = r15.changed((float) r0)
            if (r27 == 0) goto L_0x0115
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r27 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r3 = r3 | r27
        L_0x0119:
            r0 = r13 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0121
            r0 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r0
            goto L_0x0136
        L_0x0121:
            r0 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 & r11
            if (r0 != 0) goto L_0x0136
            r0 = r39
            boolean r27 = r15.changed((java.lang.Object) r0)
            if (r27 == 0) goto L_0x0131
            r27 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0133
        L_0x0131:
            r27 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0133:
            r3 = r3 | r27
            goto L_0x0138
        L_0x0136:
            r0 = r39
        L_0x0138:
            r0 = r13 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x013f
            r0 = r12 | 6
            goto L_0x014f
        L_0x013f:
            r0 = r12 & 6
            if (r0 != 0) goto L_0x014e
            boolean r0 = r15.changedInstance(r10)
            if (r0 == 0) goto L_0x014b
            r0 = 4
            goto L_0x014c
        L_0x014b:
            r0 = 2
        L_0x014c:
            r0 = r0 | r12
            goto L_0x014f
        L_0x014e:
            r0 = r12
        L_0x014f:
            r46 = r0
            r0 = r13 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0158
            r0 = r46 | 48
            goto L_0x0172
        L_0x0158:
            r0 = r12 & 48
            if (r0 != 0) goto L_0x016e
            r0 = r41
            boolean r27 = r15.changedInstance(r0)
            if (r27 == 0) goto L_0x0167
            r18 = 32
            goto L_0x0169
        L_0x0167:
            r18 = 16
        L_0x0169:
            r18 = r46 | r18
            r0 = r18
            goto L_0x0172
        L_0x016e:
            r0 = r41
            r0 = r46
        L_0x0172:
            r4 = r13 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x0179
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x018b
        L_0x0179:
            r4 = r12 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x018b
            r4 = r42
            boolean r18 = r15.changed((java.lang.Object) r4)
            if (r18 == 0) goto L_0x0186
            goto L_0x0188
        L_0x0186:
            r16 = r17
        L_0x0188:
            r0 = r0 | r16
            goto L_0x018d
        L_0x018b:
            r4 = r42
        L_0x018d:
            r4 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x0194
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01a6
        L_0x0194:
            r4 = r12 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x01a6
            r4 = r43
            boolean r16 = r15.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x01a1
            goto L_0x01a3
        L_0x01a1:
            r19 = r20
        L_0x01a3:
            r0 = r0 | r19
            goto L_0x01a8
        L_0x01a6:
            r4 = r43
        L_0x01a8:
            r4 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x01af
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01c1
        L_0x01af:
            r4 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r4 != 0) goto L_0x01c1
            r4 = r44
            boolean r16 = r15.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x01bc
            goto L_0x01be
        L_0x01bc:
            r21 = r22
        L_0x01be:
            r0 = r0 | r21
            goto L_0x01c3
        L_0x01c1:
            r4 = r44
        L_0x01c3:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r13 & r16
            if (r16 == 0) goto L_0x01cd
            r0 = r0 | r24
            goto L_0x01e7
        L_0x01cd:
            r16 = r12 & r24
            r46 = r0
            r0 = r45
            if (r16 != 0) goto L_0x01e5
            boolean r16 = r15.changedInstance(r0)
            if (r16 == 0) goto L_0x01de
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01e0
        L_0x01de:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x01e0:
            r16 = r46 | r16
            r0 = r16
            goto L_0x01e7
        L_0x01e5:
            r0 = r46
        L_0x01e7:
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r4 = r3 & r16
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r4 != r5) goto L_0x020c
            r4 = 74899(0x12493, float:1.04956E-40)
            r4 = r4 & r0
            r5 = 74898(0x12492, float:1.04954E-40)
            if (r4 != r5) goto L_0x020c
            boolean r4 = r15.getSkipping()
            if (r4 != 0) goto L_0x0201
            goto L_0x020c
        L_0x0201:
            r15.skipToGroupEnd()
            r9 = r38
            r13 = r2
            r8 = r7
            r11 = r10
            r6 = r15
            goto L_0x04aa
        L_0x020c:
            r4 = 0
            if (r6 == 0) goto L_0x0212
            r16 = r4
            goto L_0x0214
        L_0x0212:
            r16 = r7
        L_0x0214:
            if (r14 == 0) goto L_0x021d
            float r5 = (float) r4
            float r5 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r5)
            r14 = r5
            goto L_0x021f
        L_0x021d:
            r14 = r38
        L_0x021f:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x022d
            r5 = 538371694(0x2016e66e, float:1.2781737E-19)
            java.lang.String r6 = "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:101)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r0, r6)
        L_0x022d:
            if (r16 < 0) goto L_0x04df
            r5 = 1863502769(0x6f12cbb1, float:4.543106E28)
            java.lang.String r6 = "CC(remember):LazyLayoutPager.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r5, r6)
            r5 = r3 & 112(0x70, float:1.57E-43)
            r18 = 1
            r7 = 32
            if (r5 != r7) goto L_0x0242
            r17 = r18
            goto L_0x0244
        L_0x0242:
            r17 = r4
        L_0x0244:
            java.lang.Object r4 = r15.rememberedValue()
            if (r17 != 0) goto L_0x0252
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r17.getEmpty()
            if (r4 != r7) goto L_0x025c
        L_0x0252:
            androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$pagerItemProvider$1$1 r4 = new androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$pagerItemProvider$1$1
            r4.<init>(r2)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r15.updateRememberedValue(r4)
        L_0x025c:
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            int r7 = r3 >> 3
            r17 = r0
            r0 = r7 & 14
            int r19 = r17 >> 12
            r20 = r19 & 112(0x70, float:1.57E-43)
            r20 = r0 | r20
            int r2 = r17 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r2 = r20 | r2
            r37 = r0
            r1 = r5
            r0 = r6
            r28 = r7
            r6 = r15
            r8 = 32
            r20 = 0
            r7 = r2
            r15 = r3
            r5 = r4
            r2 = r31
            r4 = r41
            r3 = r45
            kotlin.jvm.functions.Function0 r5 = rememberPagerItemProviderLambda(r2, r3, r4, r5, r6, r7)
            r3 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r4 = "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r4)
            r3 = -954367824(0xffffffffc71d80b0, float:-40320.688)
            java.lang.String r4 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r4)
            java.lang.Object r3 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x02b8
            kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            kotlinx.coroutines.CoroutineScope r3 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r3, r6)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r4 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r4.<init>(r3)
            r6.updateRememberedValue(r4)
            r3 = r4
        L_0x02b8:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            kotlinx.coroutines.CoroutineScope r3 = r3.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r4 = 1863522897(0x6f131a51, float:4.552611E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r0)
            if (r1 != r8) goto L_0x02cf
            r4 = r18
            goto L_0x02d1
        L_0x02cf:
            r4 = r20
        L_0x02d1:
            java.lang.Object r7 = r6.rememberedValue()
            if (r4 != 0) goto L_0x02df
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r7 != r4) goto L_0x02ea
        L_0x02df:
            androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$measurePolicy$1$1 r4 = new androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$measurePolicy$1$1
            r4.<init>(r2)
            r7 = r4
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r6.updateRememberedValue(r7)
        L_0x02ea:
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r4 = r15 & 7168(0x1c00, float:1.0045E-41)
            r21 = 65520(0xfff0, float:9.1813E-41)
            r21 = r15 & r21
            r22 = r1
            int r1 = r15 >> 6
            r23 = 458752(0x70000, float:6.42848E-40)
            r24 = r1 & r23
            r21 = r21 | r24
            r24 = 3670016(0x380000, float:5.142788E-39)
            r24 = r1 & r24
            r21 = r21 | r24
            r24 = 29360128(0x1c00000, float:7.052966E-38)
            r24 = r1 & r24
            r21 = r21 | r24
            int r17 = r17 << 18
            r24 = 234881024(0xe000000, float:1.5777218E-30)
            r24 = r17 & r24
            r21 = r21 | r24
            r24 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r17 & r24
            r17 = r21 | r17
            r19 = r19 & 14
            r9 = r39
            r10 = r42
            r11 = r43
            r12 = r44
            r38 = r1
            r13 = r3
            r21 = r4
            r1 = r8
            r8 = r14
            r4 = r32
            r3 = r2
            r2 = r5
            r14 = r7
            r7 = r16
            r16 = r17
            r17 = r19
            r5 = r33
            r19 = r15
            r15 = r6
            r6 = r34
            kotlin.jvm.functions.Function2 r14 = androidx.compose.foundation.pager.PagerMeasurePolicyKt.m1099rememberPagerMeasurePolicy8u0NR3k(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r5 = r6
            r16 = r8
            r10 = r13
            r6 = r15
            r13 = r3
            r15 = r7
            androidx.compose.foundation.gestures.Orientation r3 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r5 != r3) goto L_0x034f
            r4 = r18
            goto L_0x0351
        L_0x034f:
            r4 = r20
        L_0x0351:
            r11 = r37
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r4 = androidx.compose.foundation.pager.PagerSemanticsKt.rememberPagerSemanticState(r13, r4, r6, r11)
            r3 = 1863528636(0x6f1330bc, float:4.5553213E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r0)
            r12 = r22
            if (r12 != r1) goto L_0x0364
            r3 = r18
            goto L_0x0366
        L_0x0364:
            r3 = r20
        L_0x0366:
            r7 = r19 & r23
            r8 = 131072(0x20000, float:1.83671E-40)
            if (r7 != r8) goto L_0x036f
            r7 = r18
            goto L_0x0371
        L_0x036f:
            r7 = r20
        L_0x0371:
            r3 = r3 | r7
            java.lang.Object r7 = r6.rememberedValue()
            if (r3 != 0) goto L_0x0384
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r7 != r3) goto L_0x0381
            goto L_0x0384
        L_0x0381:
            r3 = r35
            goto L_0x038e
        L_0x0384:
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior r7 = new androidx.compose.foundation.pager.PagerWrapperFlingBehavior
            r3 = r35
            r7.<init>(r3, r13)
            r6.updateRememberedValue(r7)
        L_0x038e:
            r17 = r7
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior r17 = (androidx.compose.foundation.pager.PagerWrapperFlingBehavior) r17
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r8, r9)
            java.lang.Object r7 = r6.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.foundation.gestures.BringIntoViewSpec r7 = (androidx.compose.foundation.gestures.BringIntoViewSpec) r7
            r8 = 1863534929(0x6f134951, float:4.558293E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r8, r0)
            if (r12 != r1) goto L_0x03b7
            r0 = r18
            goto L_0x03b9
        L_0x03b7:
            r0 = r20
        L_0x03b9:
            boolean r1 = r6.changed((java.lang.Object) r7)
            r0 = r0 | r1
            java.lang.Object r1 = r6.rememberedValue()
            if (r0 != 0) goto L_0x03cc
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x03d4
        L_0x03cc:
            androidx.compose.foundation.pager.PagerBringIntoViewSpec r1 = new androidx.compose.foundation.pager.PagerBringIntoViewSpec
            r1.<init>(r13, r7)
            r6.updateRememberedValue(r1)
        L_0x03d4:
            androidx.compose.foundation.pager.PagerBringIntoViewSpec r1 = (androidx.compose.foundation.pager.PagerBringIntoViewSpec) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.layout.RemeasurementModifier r0 = r13.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r7 = r30
            androidx.compose.ui.Modifier r0 = r7.then(r0)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r8 = r13.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            androidx.compose.ui.Modifier r0 = r0.then(r8)
            r8 = r28
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r38 & r9
            r8 = r8 | r9
            int r9 = r19 << 6
            r9 = r9 & r23
            r9 = r9 | r8
            r7 = r33
            r3 = r2
            r8 = r6
            r6 = r36
            r2 = r0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r2, r3, r4, r5, r6, r7, r8, r9)
            r22 = r3
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r5 != r2) goto L_0x0412
            r4 = r18
            goto L_0x0414
        L_0x0412:
            r4 = r20
        L_0x0414:
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.pager.PagerKt.pagerSemantics(r0, r13, r4, r10, r6)
            int r0 = r19 >> 18
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r11
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState r3 = androidx.compose.foundation.pager.PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(r13, r15, r8, r0)
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo r4 = r13.getBeyondBoundsInfo$foundation_release()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r7, r9)
            java.lang.Object r0 = r8.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            int r7 = androidx.compose.runtime.collection.MutableVector.$stable
            int r7 = r7 << 6
            r7 = r7 | r21
            int r11 = r19 << 3
            r9 = r11 & r23
            r7 = r7 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r19 & r9
            r10 = r7 | r9
            r7 = r5
            r9 = r8
            r5 = r33
            r8 = r6
            r6 = r0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r6 = r9
            r3 = r13
            androidx.compose.foundation.gestures.ScrollableState r3 = (androidx.compose.foundation.gestures.ScrollableState) r3
            r7 = r17
            androidx.compose.foundation.gestures.FlingBehavior r7 = (androidx.compose.foundation.gestures.FlingBehavior) r7
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = r13.getInternalInteractionSource$foundation_release()
            r9 = r1
            androidx.compose.foundation.gestures.BringIntoViewSpec r9 = (androidx.compose.foundation.gestures.BringIntoViewSpec) r9
            r0 = r38
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | r12
            int r1 = r19 >> 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r11
            r11 = r0 | r1
            r12 = 0
            r4 = r34
            r5 = r36
            r10 = r6
            r6 = r33
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ScrollingContainerKt.scrollingContainer(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r6 = r10
            androidx.compose.ui.Modifier r0 = dragDirectionDetector(r0, r13)
            r1 = 0
            r2 = 0
            r11 = r40
            r3 = 2
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r0, r11, r1, r3, r2)
            r8 = r6
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r6 = r13.getPrefetchState$foundation_release()
            r9 = 0
            r10 = 0
            r7 = r14
            r4 = r22
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r4, (androidx.compose.ui.Modifier) r5, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r6, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            r6 = r8
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04a7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04a7:
            r8 = r15
            r9 = r16
        L_0x04aa:
            androidx.compose.runtime.ScopeUpdateScope r0 = r6.endRestartGroup()
            if (r0 == 0) goto L_0x04de
            r1 = r0
            androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$2 r0 = new androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$2
            r3 = r32
            r4 = r33
            r5 = r34
            r6 = r35
            r7 = r36
            r10 = r39
            r12 = r41
            r14 = r43
            r15 = r44
            r16 = r45
            r17 = r47
            r18 = r48
            r19 = r49
            r29 = r1
            r2 = r13
            r1 = r30
            r13 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r29
            r1.updateScope(r0)
        L_0x04de:
            return
        L_0x04df:
            r15 = r16
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "beyondViewportPageCount should be greater than or equal to 0, you selected "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r15)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt.m1089PageruYRUAWA(androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, int, float, androidx.compose.foundation.pager.PageSize, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapPosition, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(PagerState pagerState, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Function1<? super Integer, ? extends Object> function1, Function0<Integer> function0, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1372505274, "C(rememberPagerItemProviderLambda)P(3,1)259@10522L33,260@10576L25,261@10613L677:LazyLayoutPager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1372505274, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:258)");
        }
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composer, (i >> 3) & 14);
        State<T> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 6) & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1578864961, "CC(remember):LazyLayoutPager.kt#9igjgp");
        boolean z = false;
        boolean changed = ((((i & 14) ^ 6) > 4 && composer.changed((Object) pagerState)) || (i & 6) == 4) | composer.changed((Object) rememberUpdatedState) | composer.changed((Object) rememberUpdatedState2);
        if ((((i & 7168) ^ 3072) > 2048 && composer.changed((Object) function0)) || (i & 3072) == 2048) {
            z = true;
        }
        boolean z2 = changed | z;
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1(rememberUpdatedState, rememberUpdatedState2, function0)), pagerState)));
            composer.updateRememberedValue(rememberedValue);
        }
        KProperty0 kProperty0 = (KProperty0) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return kProperty0;
    }

    private static final Modifier dragDirectionDetector(Modifier modifier, PagerState pagerState) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) pagerState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new LazyLayoutPagerKt$dragDirectionDetector$1(pagerState, (Continuation<? super LazyLayoutPagerKt$dragDirectionDetector$1>) null)));
    }
}
