package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a»\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000526\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u001621\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0001\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a}\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00142\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0018\u0010(\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H\u0000\u001a\u0018\u0010+\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H\u0001\u001a \u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\bH\u0002\u001a\u0019\u00101\u001a\u00020\b*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00102\u001a\u0019\u00103\u001a\u00020\b*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00102\u001a:\u00104\u001a\u00020\u0013*\u00020\u00132\u0006\u00105\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"Carousel", "", "state", "Landroidx/compose/material3/carousel/CarouselState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "keylineList", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "availableSpace", "itemSpacing", "Landroidx/compose/material3/carousel/KeylineList;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "maxNonFocalVisibleItemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "content", "Landroidx/compose/material3/carousel/CarouselItemScope;", "itemIndex", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Carousel-V-95POc", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ILandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalMultiBrowseCarousel", "preferredItemWidth", "minSmallItemWidth", "maxSmallItemWidth", "HorizontalMultiBrowseCarousel-zCIJ0Nk", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;FFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalUncontainedCarousel", "itemWidth", "HorizontalUncontainedCarousel-9QcgTRs", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "calculateCurrentScrollOffset", "strategy", "Landroidx/compose/material3/carousel/Strategy;", "calculateMaxScrollOffset", "getProgress", "before", "Landroidx/compose/material3/carousel/Keyline;", "after", "unadjustedOffset", "calculateAfterContentPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)F", "calculateBeforeContentPadding", "carouselItem", "index", "Lkotlin/Function0;", "carouselItemInfo", "Landroidx/compose/material3/carousel/CarouselItemInfoImpl;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Carousel.kt */
public final class CarouselKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00ff  */
    /* renamed from: HorizontalMultiBrowseCarousel-zCIJ0Nk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2895HorizontalMultiBrowseCarouselzCIJ0Nk(androidx.compose.material3.carousel.CarouselState r24, float r25, androidx.compose.ui.Modifier r26, float r27, androidx.compose.foundation.gestures.TargetedFlingBehavior r28, float r29, float r30, androidx.compose.foundation.layout.PaddingValues r31, kotlin.jvm.functions.Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r1 = r24
            r12 = r34
            r13 = r35
            r6 = -1825706865(0xffffffff932dec8f, float:-2.1952302E-27)
            r0 = r33
            androidx.compose.runtime.Composer r9 = r0.startRestartGroup(r6)
            java.lang.String r0 = "C(HorizontalMultiBrowseCarousel)P(8,7:c#ui.unit.Dp,6,3:c#ui.unit.Dp,2,5:c#ui.unit.Dp,4:c#ui.unit.Dp,1)106@5374L41,112@5703L7,116@5816L554,113@5715L1048:Carousel.kt#dcf9yb"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r0 = r13 & 1
            if (r0 == 0) goto L_0x001b
            r0 = r12 | 6
            goto L_0x002b
        L_0x001b:
            r0 = r12 & 6
            if (r0 != 0) goto L_0x002a
            boolean r0 = r9.changedInstance(r1)
            if (r0 == 0) goto L_0x0027
            r0 = 4
            goto L_0x0028
        L_0x0027:
            r0 = 2
        L_0x0028:
            r0 = r0 | r12
            goto L_0x002b
        L_0x002a:
            r0 = r12
        L_0x002b:
            r2 = r13 & 2
            if (r2 == 0) goto L_0x0034
            r0 = r0 | 48
            r8 = r25
            goto L_0x0046
        L_0x0034:
            r2 = r12 & 48
            r8 = r25
            if (r2 != 0) goto L_0x0046
            boolean r2 = r9.changed((float) r8)
            if (r2 == 0) goto L_0x0043
            r2 = 32
            goto L_0x0045
        L_0x0043:
            r2 = 16
        L_0x0045:
            r0 = r0 | r2
        L_0x0046:
            r2 = r13 & 4
            if (r2 == 0) goto L_0x004d
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r3 = r12 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0060
            r3 = r26
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005c
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r0 = r0 | r4
            goto L_0x0062
        L_0x0060:
            r3 = r26
        L_0x0062:
            r4 = r13 & 8
            if (r4 == 0) goto L_0x0069
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r5 = r12 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007c
            r5 = r27
            boolean r10 = r9.changed((float) r5)
            if (r10 == 0) goto L_0x0078
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r0 = r0 | r10
            goto L_0x007e
        L_0x007c:
            r5 = r27
        L_0x007e:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0097
            r10 = r13 & 16
            if (r10 != 0) goto L_0x0091
            r10 = r28
            boolean r11 = r9.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0093
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0091:
            r10 = r28
        L_0x0093:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r0 = r0 | r11
            goto L_0x0099
        L_0x0097:
            r10 = r28
        L_0x0099:
            r11 = r13 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r11 == 0) goto L_0x00a1
            r0 = r0 | r15
            goto L_0x00b4
        L_0x00a1:
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00b4
            r15 = r29
            boolean r16 = r9.changed((float) r15)
            if (r16 == 0) goto L_0x00af
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r0 = r0 | r16
            goto L_0x00b6
        L_0x00b4:
            r15 = r29
        L_0x00b6:
            r16 = r13 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c1
            r0 = r0 | r17
            r14 = r30
            goto L_0x00d4
        L_0x00c1:
            r17 = r12 & r17
            r14 = r30
            if (r17 != 0) goto L_0x00d4
            boolean r18 = r9.changed((float) r14)
            if (r18 == 0) goto L_0x00d0
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r0 = r0 | r18
        L_0x00d4:
            r7 = r13 & 128(0x80, float:1.794E-43)
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            if (r7 == 0) goto L_0x00df
            r0 = r0 | r19
            r6 = r31
            goto L_0x00f2
        L_0x00df:
            r19 = r12 & r19
            r6 = r31
            if (r19 != 0) goto L_0x00f2
            boolean r20 = r9.changed((java.lang.Object) r6)
            if (r20 == 0) goto L_0x00ee
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f0
        L_0x00ee:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f0:
            r0 = r0 | r20
        L_0x00f2:
            r20 = r0
            r0 = r13 & 256(0x100, float:3.59E-43)
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00ff
            r0 = r20 | r21
            r20 = r0
            goto L_0x0113
        L_0x00ff:
            r0 = r12 & r21
            if (r0 != 0) goto L_0x0113
            r0 = r32
            boolean r21 = r9.changedInstance(r0)
            if (r21 == 0) goto L_0x010e
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0110
        L_0x010e:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0110:
            r20 = r20 | r21
            goto L_0x0115
        L_0x0113:
            r0 = r32
        L_0x0115:
            r21 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r20 & r21
            r1 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r1) goto L_0x0131
            boolean r0 = r9.getSkipping()
            if (r0 != 0) goto L_0x0126
            goto L_0x0131
        L_0x0126:
            r9.skipToGroupEnd()
            r4 = r5
            r8 = r6
            r7 = r10
            r5 = r3
            r3 = r9
        L_0x012e:
            r6 = r15
            goto L_0x027b
        L_0x0131:
            r9.startDefaults()
            r0 = r12 & 1
            r21 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = 0
            if (r0 == 0) goto L_0x0158
            boolean r0 = r9.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0143
            goto L_0x0158
        L_0x0143:
            r9.skipToGroupEnd()
            r0 = r13 & 16
            if (r0 == 0) goto L_0x014c
            r20 = r20 & r21
        L_0x014c:
            r0 = r6
            r7 = r10
            r2 = r20
            r6 = r5
            r5 = r3
            r3 = r9
            r9 = r1
            r1 = r24
            goto L_0x01b1
        L_0x0158:
            if (r2 == 0) goto L_0x0161
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r22 = r0
            goto L_0x0163
        L_0x0161:
            r22 = r3
        L_0x0163:
            if (r4 == 0) goto L_0x016d
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r0)
            r23 = r0
            goto L_0x016f
        L_0x016d:
            r23 = r5
        L_0x016f:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0187
            androidx.compose.material3.carousel.CarouselDefaults r0 = androidx.compose.material3.carousel.CarouselDefaults.INSTANCE
            r2 = r20 & 14
            r4 = r2 | 384(0x180, float:5.38E-43)
            r5 = 2
            r2 = 0
            r3 = r9
            r9 = r1
            r1 = r24
            androidx.compose.foundation.gestures.TargetedFlingBehavior r0 = r0.singleAdvanceFlingBehavior(r1, r2, r3, r4, r5)
            r20 = r20 & r21
            r10 = r0
            goto L_0x018b
        L_0x0187:
            r3 = r9
            r9 = r1
            r1 = r24
        L_0x018b:
            if (r11 == 0) goto L_0x0194
            androidx.compose.material3.carousel.CarouselDefaults r0 = androidx.compose.material3.carousel.CarouselDefaults.INSTANCE
            float r0 = r0.m2892getMinSmallItemSizeD9Ej5fM$material3_release()
            r15 = r0
        L_0x0194:
            if (r16 == 0) goto L_0x019d
            androidx.compose.material3.carousel.CarouselDefaults r0 = androidx.compose.material3.carousel.CarouselDefaults.INSTANCE
            float r0 = r0.m2891getMaxSmallItemSizeD9Ej5fM$material3_release()
            r14 = r0
        L_0x019d:
            if (r7 == 0) goto L_0x01a9
            float r0 = (float) r9
            float r0 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r0)
            androidx.compose.foundation.layout.PaddingValues r0 = androidx.compose.foundation.layout.PaddingKt.m768PaddingValues0680j_4(r0)
            goto L_0x01aa
        L_0x01a9:
            r0 = r6
        L_0x01aa:
            r7 = r10
            r2 = r20
            r5 = r22
            r6 = r23
        L_0x01b1:
            r3.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x01c3
            r4 = -1
            java.lang.String r10 = "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:111)"
            r11 = -1825706865(0xffffffff932dec8f, float:-2.1952302E-27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r2, r4, r10)
        L_0x01c3:
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r11 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r10, r11)
            java.lang.Object r4 = r3.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.foundation.gestures.Orientation r10 = androidx.compose.foundation.gestures.Orientation.Horizontal
            r11 = 1995157598(0x76ebb05e, float:2.3901698E33)
            java.lang.String r9 = "CC(remember):Carousel.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r11, r9)
            boolean r9 = r3.changed((java.lang.Object) r4)
            r11 = r2 & 112(0x70, float:1.57E-43)
            r19 = 1
            r20 = r0
            r0 = 32
            if (r11 != r0) goto L_0x01f5
            r0 = r19
            goto L_0x01f6
        L_0x01f5:
            r0 = 0
        L_0x01f6:
            r0 = r0 | r9
            boolean r9 = r3.changedInstance(r1)
            r0 = r0 | r9
            r9 = 458752(0x70000, float:6.42848E-40)
            r11 = r2 & r9
            r18 = r9
            r9 = 131072(0x20000, float:1.83671E-40)
            if (r11 != r9) goto L_0x0209
            r9 = r19
            goto L_0x020a
        L_0x0209:
            r9 = 0
        L_0x020a:
            r0 = r0 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r2
            r11 = 1048576(0x100000, float:1.469368E-39)
            if (r9 != r11) goto L_0x0215
            r16 = r19
            goto L_0x0217
        L_0x0215:
            r16 = 0
        L_0x0217:
            r0 = r0 | r16
            java.lang.Object r9 = r3.rememberedValue()
            if (r0 != 0) goto L_0x0227
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r9 != r0) goto L_0x023e
        L_0x0227:
            androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$1$1 r0 = new androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$1$1
            r26 = r0
            r29 = r1
            r27 = r4
            r28 = r8
            r31 = r14
            r30 = r15
            r26.<init>(r27, r28, r29, r30, r31)
            r9 = r0
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r3.updateRememberedValue(r9)
        L_0x023e:
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r0 = r2 & 14
            r0 = r0 | 24624(0x6030, float:3.4506E-41)
            int r1 = r2 >> 12
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r2 << 9
            r4 = r1 & r18
            r0 = r0 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r1
            r0 = r0 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r4
            r0 = r0 | r1
            r1 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r2
            r0 = r0 | r1
            r11 = 0
            r4 = 2
            r8 = r32
            r2 = r9
            r1 = r10
            r10 = r0
            r9 = r3
            r3 = r20
            r0 = r24
            m2894CarouselV95POc(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = r9
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0276
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0276:
            r4 = r6
            r8 = r20
            goto L_0x012e
        L_0x027b:
            androidx.compose.runtime.ScopeUpdateScope r15 = r3.endRestartGroup()
            if (r15 == 0) goto L_0x0296
            androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$2 r0 = new androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$2
            r1 = r24
            r2 = r25
            r9 = r32
            r3 = r5
            r5 = r7
            r10 = r12
            r11 = r13
            r7 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0296:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m2895HorizontalMultiBrowseCarouselzCIJ0Nk(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, float, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00eb  */
    /* renamed from: HorizontalUncontainedCarousel-9QcgTRs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2896HorizontalUncontainedCarousel9QcgTRs(androidx.compose.material3.carousel.CarouselState r21, float r22, androidx.compose.ui.Modifier r23, float r24, androidx.compose.foundation.gestures.TargetedFlingBehavior r25, androidx.compose.foundation.layout.PaddingValues r26, kotlin.jvm.functions.Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r2 = r22
            r8 = r29
            r0 = 529322840(0x1f8cd358, float:5.9641945E-20)
            r1 = r28
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(HorizontalUncontainedCarousel)P(6,4:c#ui.unit.Dp,5,3:c#ui.unit.Dp,2,1)175@8483L21,179@8666L7,183@8779L337,180@8678L818:Carousel.kt#dcf9yb"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r30 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r8 | 6
            r9 = r21
            goto L_0x002d
        L_0x001b:
            r3 = r8 & 6
            r9 = r21
            if (r3 != 0) goto L_0x002c
            boolean r3 = r1.changedInstance(r9)
            if (r3 == 0) goto L_0x0029
            r3 = 4
            goto L_0x002a
        L_0x0029:
            r3 = 2
        L_0x002a:
            r3 = r3 | r8
            goto L_0x002d
        L_0x002c:
            r3 = r8
        L_0x002d:
            r4 = r30 & 2
            if (r4 == 0) goto L_0x0034
            r3 = r3 | 48
            goto L_0x0044
        L_0x0034:
            r4 = r8 & 48
            if (r4 != 0) goto L_0x0044
            boolean r4 = r1.changed((float) r2)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r3 = r3 | r4
        L_0x0044:
            r4 = r30 & 4
            if (r4 == 0) goto L_0x004b
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r6 = r8 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005e
            r6 = r23
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005a
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r3 = r3 | r7
            goto L_0x0060
        L_0x005e:
            r6 = r23
        L_0x0060:
            r7 = r30 & 8
            if (r7 == 0) goto L_0x0067
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007a
            r10 = r24
            boolean r11 = r1.changed((float) r10)
            if (r11 == 0) goto L_0x0076
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r3 = r3 | r11
            goto L_0x007c
        L_0x007a:
            r10 = r24
        L_0x007c:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0095
            r11 = r30 & 16
            if (r11 != 0) goto L_0x008f
            r11 = r25
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0091
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x008f:
            r11 = r25
        L_0x0091:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r3 = r3 | r12
            goto L_0x0097
        L_0x0095:
            r11 = r25
        L_0x0097:
            r12 = r30 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x009f
            r3 = r3 | r13
            goto L_0x00b1
        L_0x009f:
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00b1
            r13 = r26
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00ad
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r3 = r3 | r14
            goto L_0x00b3
        L_0x00b1:
            r13 = r26
        L_0x00b3:
            r14 = r30 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00bb
            r3 = r3 | r15
            goto L_0x00ce
        L_0x00bb:
            r14 = r8 & r15
            if (r14 != 0) goto L_0x00ce
            r14 = r27
            boolean r15 = r1.changedInstance(r14)
            if (r15 == 0) goto L_0x00ca
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00ca:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00cc:
            r3 = r3 | r15
            goto L_0x00d0
        L_0x00ce:
            r14 = r27
        L_0x00d0:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r3
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r5) goto L_0x00eb
            boolean r5 = r1.getSkipping()
            if (r5 != 0) goto L_0x00e0
            goto L_0x00eb
        L_0x00e0:
            r1.skipToGroupEnd()
            r18 = r1
            r3 = r6
            r4 = r10
            r5 = r11
            r6 = r13
            goto L_0x01cd
        L_0x00eb:
            r1.startDefaults()
            r5 = r8 & 1
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r15 = 0
            r0 = 6
            if (r5 == 0) goto L_0x010d
            boolean r5 = r1.getDefaultsInvalid()
            if (r5 == 0) goto L_0x00fe
            goto L_0x010d
        L_0x00fe:
            r1.skipToGroupEnd()
            r4 = r30 & 16
            if (r4 == 0) goto L_0x0107
            r3 = r3 & r16
        L_0x0107:
            r16 = r11
            r12 = r13
        L_0x010a:
            r4 = r15
            r15 = r10
            goto L_0x0138
        L_0x010d:
            if (r4 == 0) goto L_0x0114
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r6 = r4
        L_0x0114:
            if (r7 == 0) goto L_0x011c
            float r4 = (float) r15
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            r10 = r4
        L_0x011c:
            r4 = r30 & 16
            if (r4 == 0) goto L_0x0129
            androidx.compose.material3.carousel.CarouselDefaults r4 = androidx.compose.material3.carousel.CarouselDefaults.INSTANCE
            androidx.compose.foundation.gestures.TargetedFlingBehavior r4 = r4.noSnapFlingBehavior(r1, r0)
            r3 = r3 & r16
            r11 = r4
        L_0x0129:
            if (r12 == 0) goto L_0x0107
            float r4 = (float) r15
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            androidx.compose.foundation.layout.PaddingValues r4 = androidx.compose.foundation.layout.PaddingKt.m768PaddingValues0680j_4(r4)
            r12 = r4
            r16 = r11
            goto L_0x010a
        L_0x0138:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x014a
            r5 = -1
            java.lang.String r7 = "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:178)"
            r10 = 529322840(0x1f8cd358, float:5.9641945E-20)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r3, r5, r7)
        L_0x014a:
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r10)
            java.lang.Object r5 = r1.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.foundation.gestures.Orientation r10 = androidx.compose.foundation.gestures.Orientation.Horizontal
            r7 = 1883505148(0x704401fc, float:2.4264584E29)
            java.lang.String r11 = "CC(remember):Carousel.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r11)
            boolean r7 = r1.changed((java.lang.Object) r5)
            r11 = r3 & 112(0x70, float:1.57E-43)
            r13 = 32
            if (r11 != r13) goto L_0x0176
            r4 = 1
        L_0x0176:
            r4 = r4 | r7
            java.lang.Object r7 = r1.rememberedValue()
            if (r4 != 0) goto L_0x0185
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r7 != r4) goto L_0x0190
        L_0x0185:
            androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$1$1 r4 = new androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$1$1
            r4.<init>(r5, r2)
            r7 = r4
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r1.updateRememberedValue(r7)
        L_0x0190:
            r11 = r7
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r4 = r3 & 14
            r4 = r4 | 24624(0x6030, float:3.4506E-41)
            int r5 = r3 >> 6
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r5
            int r5 = r3 << 9
            r7 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r5
            r4 = r4 | r7
            r7 = 3670016(0x380000, float:5.142788E-39)
            r7 = r7 & r5
            r4 = r4 | r7
            r7 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r7
            r4 = r4 | r5
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            int r0 = r3 << 6
            r0 = r0 & r5
            r19 = r4 | r0
            r20 = 0
            r13 = 0
            r18 = r1
            r17 = r14
            r14 = r6
            m2894CarouselV95POc(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01c8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c8:
            r6 = r12
            r3 = r14
            r4 = r15
            r5 = r16
        L_0x01cd:
            androidx.compose.runtime.ScopeUpdateScope r10 = r18.endRestartGroup()
            if (r10 == 0) goto L_0x01e3
            androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$2 r0 = new androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$2
            r1 = r21
            r7 = r27
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m2896HorizontalUncontainedCarousel9QcgTRs(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:141:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011d  */
    /* renamed from: Carousel-V-95POc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2894CarouselV95POc(androidx.compose.material3.carousel.CarouselState r32, androidx.compose.foundation.gestures.Orientation r33, kotlin.jvm.functions.Function2<? super java.lang.Float, ? super java.lang.Float, androidx.compose.material3.carousel.KeylineList> r34, androidx.compose.foundation.layout.PaddingValues r35, int r36, androidx.compose.ui.Modifier r37, float r38, androidx.compose.foundation.gestures.TargetedFlingBehavior r39, kotlin.jvm.functions.Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r1 = r32
            r6 = r33
            r7 = r34
            r8 = r35
            r9 = r40
            r10 = r42
            r11 = r43
            r12 = -2035733443(0xffffffff86a92c3d, float:-6.3635737E-35)
            r0 = r41
            androidx.compose.runtime.Composer r3 = r0.startRestartGroup(r12)
            java.lang.String r0 = "C(Carousel)P(8,7,4,1,5,6,3:c#ui.unit.Dp,2)239@11411L41,242@11572L42,243@11660L41,245@11729L118:Carousel.kt#dcf9yb"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x0023
            r0 = r10 | 6
            goto L_0x0033
        L_0x0023:
            r0 = r10 & 6
            if (r0 != 0) goto L_0x0032
            boolean r0 = r3.changedInstance(r1)
            if (r0 == 0) goto L_0x002f
            r0 = 4
            goto L_0x0030
        L_0x002f:
            r0 = 2
        L_0x0030:
            r0 = r0 | r10
            goto L_0x0033
        L_0x0032:
            r0 = r10
        L_0x0033:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x003a
            r0 = r0 | 48
            goto L_0x004a
        L_0x003a:
            r2 = r10 & 48
            if (r2 != 0) goto L_0x004a
            boolean r2 = r3.changed((java.lang.Object) r6)
            if (r2 == 0) goto L_0x0047
            r2 = 32
            goto L_0x0049
        L_0x0047:
            r2 = 16
        L_0x0049:
            r0 = r0 | r2
        L_0x004a:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x0051
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x0051:
            r2 = r10 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x0061
            boolean r2 = r3.changedInstance(r7)
            if (r2 == 0) goto L_0x005e
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r0 = r0 | r2
        L_0x0061:
            r2 = r11 & 8
            if (r2 == 0) goto L_0x0068
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0078
        L_0x0068:
            r2 = r10 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x0078
            boolean r2 = r3.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0075
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r0 = r0 | r2
        L_0x0078:
            r2 = r11 & 16
            if (r2 == 0) goto L_0x0081
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r14 = r36
            goto L_0x0093
        L_0x0081:
            r2 = r10 & 24576(0x6000, float:3.4438E-41)
            r14 = r36
            if (r2 != 0) goto L_0x0093
            boolean r2 = r3.changed((int) r14)
            if (r2 == 0) goto L_0x0090
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x0090:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r0 = r0 | r2
        L_0x0093:
            r2 = r11 & 32
            r4 = 196608(0x30000, float:2.75506E-40)
            if (r2 == 0) goto L_0x009b
            r0 = r0 | r4
            goto L_0x00ad
        L_0x009b:
            r4 = r4 & r10
            if (r4 != 0) goto L_0x00ad
            r4 = r37
            boolean r5 = r3.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x00a9
            r5 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ab
        L_0x00a9:
            r5 = 65536(0x10000, float:9.18355E-41)
        L_0x00ab:
            r0 = r0 | r5
            goto L_0x00af
        L_0x00ad:
            r4 = r37
        L_0x00af:
            r5 = r11 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r5 == 0) goto L_0x00b7
            r0 = r0 | r15
            goto L_0x00ca
        L_0x00b7:
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00ca
            r15 = r38
            boolean r16 = r3.changed((float) r15)
            if (r16 == 0) goto L_0x00c5
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c7
        L_0x00c5:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00c7:
            r0 = r0 | r16
            goto L_0x00cc
        L_0x00ca:
            r15 = r38
        L_0x00cc:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00e8
            r13 = r11 & 128(0x80, float:1.794E-43)
            if (r13 != 0) goto L_0x00e1
            r13 = r39
            boolean r16 = r3.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x00e3
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e5
        L_0x00e1:
            r13 = r39
        L_0x00e3:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e5:
            r0 = r0 | r16
            goto L_0x00ea
        L_0x00e8:
            r13 = r39
        L_0x00ea:
            r12 = r11 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r12 == 0) goto L_0x00f3
            r0 = r0 | r17
            goto L_0x0103
        L_0x00f3:
            r12 = r10 & r17
            if (r12 != 0) goto L_0x0103
            boolean r12 = r3.changedInstance(r9)
            if (r12 == 0) goto L_0x0100
            r12 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0102
        L_0x0100:
            r12 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0102:
            r0 = r0 | r12
        L_0x0103:
            r12 = r0
            r0 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r0 & r12
            r1 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r1) goto L_0x011d
            boolean r0 = r3.getSkipping()
            if (r0 != 0) goto L_0x0114
            goto L_0x011d
        L_0x0114:
            r3.skipToGroupEnd()
            r1 = r32
            r8 = r13
            r7 = r15
            goto L_0x02e6
        L_0x011d:
            r3.startDefaults()
            r0 = r10 & 1
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = 0
            if (r0 == 0) goto L_0x0141
            boolean r0 = r3.getDefaultsInvalid()
            if (r0 == 0) goto L_0x012f
            goto L_0x0141
        L_0x012f:
            r3.skipToGroupEnd()
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0138
            r12 = r12 & r17
        L_0x0138:
            r19 = r1
            r20 = r13
            r18 = r15
            r1 = r32
            goto L_0x0177
        L_0x0141:
            if (r2 == 0) goto L_0x014a
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r18 = r0
            goto L_0x014c
        L_0x014a:
            r18 = r4
        L_0x014c:
            if (r5 == 0) goto L_0x0154
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r0)
            r15 = r0
        L_0x0154:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x016d
            androidx.compose.material3.carousel.CarouselDefaults r0 = androidx.compose.material3.carousel.CarouselDefaults.INSTANCE
            r2 = r12 & 14
            r4 = r2 | 384(0x180, float:5.38E-43)
            r5 = 2
            r2 = 0
            r19 = r1
            r1 = r32
            androidx.compose.foundation.gestures.TargetedFlingBehavior r0 = r0.singleAdvanceFlingBehavior(r1, r2, r3, r4, r5)
            r12 = r12 & r17
            r20 = r0
            goto L_0x0173
        L_0x016d:
            r19 = r1
            r1 = r32
            r20 = r13
        L_0x0173:
            r4 = r18
            r18 = r15
        L_0x0177:
            r3.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0189
            r0 = -1
            java.lang.String r2 = "androidx.compose.material3.carousel.Carousel (Carousel.kt:241)"
            r5 = -2035733443(0xffffffff86a92c3d, float:-6.3635737E-35)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r12, r0, r2)
        L_0x0189:
            int r0 = r12 >> 9
            r0 = r0 & 14
            r2 = r12 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            float r2 = calculateBeforeContentPadding(r8, r6, r3, r0)
            float r0 = calculateAfterContentPadding(r8, r6, r3, r0)
            r5 = 2025986753(0x78c21ac1, float:3.1495257E34)
            java.lang.String r13 = "CC(remember):Carousel.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r5, r13)
            r5 = r12 & 896(0x380, float:1.256E-42)
            r13 = 1
            r15 = 256(0x100, float:3.59E-43)
            if (r5 != r15) goto L_0x01a9
            r19 = r13
        L_0x01a9:
            java.lang.Object r5 = r3.rememberedValue()
            if (r19 != 0) goto L_0x01b7
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r5 != r15) goto L_0x01bf
        L_0x01b7:
            androidx.compose.material3.carousel.CarouselPageSize r5 = new androidx.compose.material3.carousel.CarouselPageSize
            r5.<init>(r7, r2, r0)
            r3.updateRememberedValue(r5)
        L_0x01bf:
            androidx.compose.material3.carousel.CarouselPageSize r5 = (androidx.compose.material3.carousel.CarouselPageSize) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.foundation.gestures.snapping.SnapPosition r25 = androidx.compose.material3.carousel.KeylineSnapPositionKt.KeylineSnapPosition(r5)
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
            if (r6 != r0) goto L_0x0238
            r0 = -1618653092(0xffffffff9f85505c, float:-5.6460634E-20)
            r3.startReplaceGroup(r0)
            java.lang.String r0 = "266@12589L1014,252@11960L1643"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            androidx.compose.foundation.pager.PagerState r0 = r1.getPagerState$material3_release()
            float r27 = r8.m792calculateTopPaddingD9Ej5fM()
            float r29 = r8.m789calculateBottomPaddingD9Ej5fM()
            r30 = 5
            r31 = 0
            r26 = 0
            r28 = 0
            androidx.compose.foundation.layout.PaddingValues r15 = androidx.compose.foundation.layout.PaddingKt.m772PaddingValuesa9UjIt4$default(r26, r27, r28, r29, r30, r31)
            r16 = r5
            androidx.compose.foundation.pager.PageSize r16 = (androidx.compose.foundation.pager.PageSize) r16
            androidx.compose.material3.carousel.CarouselKt$Carousel$1 r2 = new androidx.compose.material3.carousel.CarouselKt$Carousel$1
            r2.<init>(r1, r5, r9)
            r5 = 687111200(0x28f47c20, float:2.7143272E-14)
            r38 = r0
            r0 = 54
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r13, r2, r3, r0)
            r26 = r0
            kotlin.jvm.functions.Function4 r26 = (kotlin.jvm.functions.Function4) r26
            int r0 = r12 >> 12
            r0 = r0 & 112(0x70, float:1.57E-43)
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r12
            r0 = r0 | r2
            int r2 = r12 >> 3
            r5 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r5
            r0 = r0 | r2
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r12
            r28 = r0 | r2
            r29 = 3072(0xc00, float:4.305E-42)
            r30 = 3904(0xf40, float:5.47E-42)
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r13 = r38
            r27 = r3
            r17 = r14
            r14 = r4
            androidx.compose.foundation.pager.PagerKt.m1093HorizontalPageroI3XNZo(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            r3.endReplaceGroup()
            goto L_0x02d8
        L_0x0238:
            r14 = r4
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r6 != r0) goto L_0x02cf
            r0 = -1616959128(0xffffffff9f9f2968, float:-6.740762E-20)
            r3.startReplaceGroup(r0)
            java.lang.String r0 = "300@13962L7,301@14054L7,309@14347L1014,295@13666L1695"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            androidx.compose.foundation.pager.PagerState r0 = r1.getPagerState$material3_release()
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r15 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r4, r15)
            java.lang.Object r2 = r3.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            float r26 = androidx.compose.foundation.layout.PaddingKt.calculateStartPadding(r8, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            java.lang.String r15 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r4, r15)
            java.lang.Object r2 = r3.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            float r28 = androidx.compose.foundation.layout.PaddingKt.calculateEndPadding(r8, r2)
            r30 = 10
            r31 = 0
            r27 = 0
            r29 = 0
            androidx.compose.foundation.layout.PaddingValues r15 = androidx.compose.foundation.layout.PaddingKt.m772PaddingValuesa9UjIt4$default(r26, r27, r28, r29, r30, r31)
            r16 = r5
            androidx.compose.foundation.pager.PageSize r16 = (androidx.compose.foundation.pager.PageSize) r16
            androidx.compose.material3.carousel.CarouselKt$Carousel$2 r2 = new androidx.compose.material3.carousel.CarouselKt$Carousel$2
            r2.<init>(r1, r5, r9)
            r4 = -817308503(0xffffffffcf48dca9, float:-3.36990438E9)
            r5 = 54
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r13, r2, r3, r5)
            r26 = r2
            kotlin.jvm.functions.Function4 r26 = (kotlin.jvm.functions.Function4) r26
            int r2 = r12 >> 12
            r2 = r2 & 112(0x70, float:1.57E-43)
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r12
            r2 = r2 | r4
            int r4 = r12 >> 3
            r5 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r5
            r2 = r2 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r12
            r28 = r2 | r4
            r29 = 3072(0xc00, float:4.305E-42)
            r30 = 3904(0xf40, float:5.47E-42)
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r17 = r36
            r13 = r0
            r27 = r3
            androidx.compose.foundation.pager.PagerKt.m1094VerticalPageroI3XNZo(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            r3.endReplaceGroup()
            goto L_0x02d8
        L_0x02cf:
            r0 = -1615314857(0xffffffff9fb84057, float:-7.803347E-20)
            r3.startReplaceGroup(r0)
            r3.endReplaceGroup()
        L_0x02d8:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02e1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e1:
            r4 = r14
            r7 = r18
            r8 = r20
        L_0x02e6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r3.endRestartGroup()
            if (r12 == 0) goto L_0x02fe
            androidx.compose.material3.carousel.CarouselKt$Carousel$3 r0 = new androidx.compose.material3.carousel.CarouselKt$Carousel$3
            r3 = r34
            r5 = r36
            r2 = r6
            r6 = r4
            r4 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x02fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m2894CarouselV95POc(androidx.compose.material3.carousel.CarouselState, androidx.compose.foundation.gestures.Orientation, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, int, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float calculateBeforeContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        float f;
        ComposerKt.sourceInformationMarkerStart(composer, 1896839347, "C(calculateBeforeContentPadding)*349@15698L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896839347, i, -1, "androidx.compose.material3.carousel.calculateBeforeContentPadding (Carousel.kt:341)");
        }
        composer.startReplaceGroup(295830617);
        ComposerKt.sourceInformation(composer, "346@15649L7");
        if (orientation == Orientation.Vertical) {
            f = paddingValues.m792calculateTopPaddingD9Ej5fM();
        } else {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            f = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) consume);
        }
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        float r3 = ((Density) consume2).m7091toPx0680j_4(f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return r3;
    }

    private static final float calculateAfterContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        float f;
        ComposerKt.sourceInformationMarkerStart(composer, 1018496720, "C(calculateAfterContentPadding)*361@16056L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1018496720, i, -1, "androidx.compose.material3.carousel.calculateAfterContentPadding (Carousel.kt:353)");
        }
        composer.startReplaceGroup(-587616383);
        ComposerKt.sourceInformation(composer, "358@16007L7");
        if (orientation == Orientation.Vertical) {
            f = paddingValues.m789calculateBottomPaddingD9Ej5fM();
        } else {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            f = PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) consume);
        }
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        float r3 = ((Density) consume2).m7091toPx0680j_4(f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return r3;
    }

    public static final Modifier carouselItem(Modifier modifier, int i, CarouselState carouselState, Function0<Strategy> function0, CarouselItemInfoImpl carouselItemInfoImpl, Shape shape) {
        return LayoutModifierKt.layout(modifier, new CarouselKt$carouselItem$1(function0, carouselState, i, carouselItemInfoImpl, shape));
    }

    public static final float calculateCurrentScrollOffset(CarouselState carouselState, Strategy strategy) {
        float itemMainAxisSize = strategy.getItemMainAxisSize() + strategy.getItemSpacing();
        return ((((float) carouselState.getPagerState$material3_release().getCurrentPage()) * itemMainAxisSize) + (carouselState.getPagerState$material3_release().getCurrentPageOffsetFraction() * itemMainAxisSize)) - ((float) KeylineSnapPositionKt.getSnapPositionOffset(strategy, carouselState.getPagerState$material3_release().getCurrentPage(), carouselState.getPagerState$material3_release().getPageCount()));
    }

    public static final float calculateMaxScrollOffset(CarouselState carouselState, Strategy strategy) {
        float pageCount = (float) carouselState.getPagerState$material3_release().getPageCount();
        return RangesKt.coerceAtLeast(((strategy.getItemMainAxisSize() * pageCount) + (strategy.getItemSpacing() * (pageCount - ((float) 1)))) - strategy.getAvailableSpace(), 0.0f);
    }

    /* access modifiers changed from: private */
    public static final float getProgress(Keyline keyline, Keyline keyline2, float f) {
        if (Intrinsics.areEqual((Object) keyline, (Object) keyline2)) {
            return 1.0f;
        }
        return (f - keyline.getUnadjustedOffset()) / (keyline2.getUnadjustedOffset() - keyline.getUnadjustedOffset());
    }
}
