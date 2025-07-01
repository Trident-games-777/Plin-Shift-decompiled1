package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0001\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0001\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012.\b\u0002\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0001\u0010(\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a \u0001\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2,\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u0001\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001c\u001a\u0001\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u001f\u001a\u0001\u00102\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102.\b\u0002\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u001f\u001an\u00104\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a~\u00107\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102,\u0010\u0013\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"0!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b8\u00106\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "TabRowIndicatorSpec", "PrimaryScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "Landroidx/compose/material3/TabIndicatorScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PrimaryTabRow", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowImpl", "ScrollableTabRowImpl-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScrollableTabRowWithSubcomposeImpl", "ScrollableTabRowWithSubcomposeImpl-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-qhFBPw4", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "TabRow", "TabRow-pAZo6Ak", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "TabRowWithSubcomposeImpl-DTcfvLk", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
public final class TabRowKt {
    /* access modifiers changed from: private */
    public static final float ScrollableTabRowMinimumTabWidth = Dp.m7111constructorimpl((float) 90);
    /* access modifiers changed from: private */
    public static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);
    /* access modifiers changed from: private */
    public static final AnimationSpec<Dp> TabRowIndicatorSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f1  */
    /* renamed from: PrimaryTabRow-pAZo6Ak  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2587PrimaryTabRowpAZo6Ak(int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TabIndicatorScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r1 = r21
            r10 = r31
            r0 = -1884787284(0xffffffff8fa86dac, float:-1.6608323E-29)
            r2 = r30
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(PrimaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)154@7555L21,155@7619L19,156@7698L189,165@8005L76:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r32 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r10 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((int) r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r10
            goto L_0x0029
        L_0x0028:
            r3 = r10
        L_0x0029:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0043
            r5 = r22
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r3 = r3 | r6
            goto L_0x0045
        L_0x0043:
            r5 = r22
        L_0x0045:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005e
            r6 = r32 & 4
            if (r6 != 0) goto L_0x0058
            r6 = r23
            boolean r8 = r2.changed((long) r6)
            if (r8 == 0) goto L_0x005a
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r6 = r23
        L_0x005a:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r3 = r3 | r8
            goto L_0x0060
        L_0x005e:
            r6 = r23
        L_0x0060:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0079
            r8 = r32 & 8
            if (r8 != 0) goto L_0x0073
            r8 = r25
            boolean r11 = r2.changed((long) r8)
            if (r11 == 0) goto L_0x0075
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0073:
            r8 = r25
        L_0x0075:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r11
            goto L_0x007b
        L_0x0079:
            r8 = r25
        L_0x007b:
            r11 = r32 & 16
            if (r11 == 0) goto L_0x0082
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0095
        L_0x0082:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0095
            r12 = r27
            boolean r13 = r2.changedInstance(r12)
            if (r13 == 0) goto L_0x0091
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r3 = r3 | r13
            goto L_0x0097
        L_0x0095:
            r12 = r27
        L_0x0097:
            r13 = r32 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x009f
            r3 = r3 | r14
            goto L_0x00b1
        L_0x009f:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b1
            r14 = r28
            boolean r15 = r2.changedInstance(r14)
            if (r15 == 0) goto L_0x00ad
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r3 = r3 | r15
            goto L_0x00b3
        L_0x00b1:
            r14 = r28
        L_0x00b3:
            r15 = r32 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bc
            r3 = r3 | r16
            goto L_0x00d0
        L_0x00bc:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d0
            r15 = r29
            boolean r16 = r2.changedInstance(r15)
            if (r16 == 0) goto L_0x00cb
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r3 = r3 | r16
            goto L_0x00d2
        L_0x00d0:
            r15 = r29
        L_0x00d2:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r3 & r16
            r30 = r4
            r4 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r4) goto L_0x00f1
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00f1
        L_0x00e5:
            r2.skipToGroupEnd()
            r19 = r2
            r2 = r5
            r3 = r6
            r5 = r8
            r7 = r12
            r8 = r14
            goto L_0x018d
        L_0x00f1:
            r2.startDefaults()
            r0 = r10 & 1
            if (r0 == 0) goto L_0x0119
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00ff
            goto L_0x0119
        L_0x00ff:
            r2.skipToGroupEnd()
            r0 = r32 & 4
            if (r0 == 0) goto L_0x0108
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0108:
            r0 = r32 & 8
            if (r0 == 0) goto L_0x010e
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x010e:
            r11 = r5
            r16 = r12
            r17 = r14
            r0 = -1884787284(0xffffffff8fa86dac, float:-1.6608323E-29)
            r12 = r6
            r14 = r8
            goto L_0x0160
        L_0x0119:
            if (r30 == 0) goto L_0x0120
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x0120:
            r0 = r32 & 4
            r4 = 6
            if (r0 == 0) goto L_0x012d
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r6 = r0.getPrimaryContainerColor(r2, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012d:
            r0 = r32 & 8
            if (r0 == 0) goto L_0x013a
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r8 = r0.getPrimaryContentColor(r2, r4)
            r0 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r3 = r0
        L_0x013a:
            if (r11 == 0) goto L_0x014e
            androidx.compose.material3.TabRowKt$PrimaryTabRow$1 r0 = new androidx.compose.material3.TabRowKt$PrimaryTabRow$1
            r0.<init>(r1)
            r4 = 54
            r11 = -2021049253(0xffffffff87893c5b, float:-2.0648943E-34)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r11, r12, r0, r2, r4)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r12 = r0
        L_0x014e:
            if (r13 == 0) goto L_0x010e
            androidx.compose.material3.ComposableSingletons$TabRowKt r0 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m1940getLambda1$material3_release()
            r17 = r0
            r11 = r5
            r14 = r8
            r16 = r12
            r0 = -1884787284(0xffffffff8fa86dac, float:-1.6608323E-29)
            r12 = r6
        L_0x0160:
            r2.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x016f
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.PrimaryTabRow (TabRow.kt:164)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r4, r5)
        L_0x016f:
            int r0 = r3 >> 3
            r3 = 524286(0x7fffe, float:7.34681E-40)
            r20 = r0 & r3
            r18 = r29
            r19 = r2
            m2594TabRowImplDTcfvLk(r11, r12, r14, r16, r17, r18, r19, r20)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0186
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0186:
            r2 = r11
            r3 = r12
            r5 = r14
            r7 = r16
            r8 = r17
        L_0x018d:
            androidx.compose.runtime.ScopeUpdateScope r12 = r19.endRestartGroup()
            if (r12 == 0) goto L_0x01a1
            androidx.compose.material3.TabRowKt$PrimaryTabRow$2 r0 = new androidx.compose.material3.TabRowKt$PrimaryTabRow$2
            r9 = r29
            r11 = r32
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2587PrimaryTabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f1  */
    /* renamed from: SecondaryTabRow-pAZo6Ak  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2592SecondaryTabRowpAZo6Ak(int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TabIndicatorScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r1 = r21
            r10 = r31
            r0 = -1909540706(0xffffffff8e2eb89e, float:-2.1536046E-30)
            r2 = r30
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(SecondaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)208@10501L23,209@10567L21,211@10668L160,219@10946L76:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r32 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r10 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((int) r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r10
            goto L_0x0029
        L_0x0028:
            r3 = r10
        L_0x0029:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0043
            r5 = r22
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r3 = r3 | r6
            goto L_0x0045
        L_0x0043:
            r5 = r22
        L_0x0045:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005e
            r6 = r32 & 4
            if (r6 != 0) goto L_0x0058
            r6 = r23
            boolean r8 = r2.changed((long) r6)
            if (r8 == 0) goto L_0x005a
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r6 = r23
        L_0x005a:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r3 = r3 | r8
            goto L_0x0060
        L_0x005e:
            r6 = r23
        L_0x0060:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0079
            r8 = r32 & 8
            if (r8 != 0) goto L_0x0073
            r8 = r25
            boolean r11 = r2.changed((long) r8)
            if (r11 == 0) goto L_0x0075
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0073:
            r8 = r25
        L_0x0075:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r11
            goto L_0x007b
        L_0x0079:
            r8 = r25
        L_0x007b:
            r11 = r32 & 16
            if (r11 == 0) goto L_0x0082
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0095
        L_0x0082:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0095
            r12 = r27
            boolean r13 = r2.changedInstance(r12)
            if (r13 == 0) goto L_0x0091
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r3 = r3 | r13
            goto L_0x0097
        L_0x0095:
            r12 = r27
        L_0x0097:
            r13 = r32 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x009f
            r3 = r3 | r14
            goto L_0x00b1
        L_0x009f:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b1
            r14 = r28
            boolean r15 = r2.changedInstance(r14)
            if (r15 == 0) goto L_0x00ad
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r3 = r3 | r15
            goto L_0x00b3
        L_0x00b1:
            r14 = r28
        L_0x00b3:
            r15 = r32 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bc
            r3 = r3 | r16
            goto L_0x00d0
        L_0x00bc:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d0
            r15 = r29
            boolean r16 = r2.changedInstance(r15)
            if (r16 == 0) goto L_0x00cb
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r3 = r3 | r16
            goto L_0x00d2
        L_0x00d0:
            r15 = r29
        L_0x00d2:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r3 & r16
            r30 = r4
            r4 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r4) goto L_0x00f1
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00f1
        L_0x00e5:
            r2.skipToGroupEnd()
            r19 = r2
            r2 = r5
            r3 = r6
            r5 = r8
            r7 = r12
            r8 = r14
            goto L_0x018d
        L_0x00f1:
            r2.startDefaults()
            r0 = r10 & 1
            if (r0 == 0) goto L_0x0119
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00ff
            goto L_0x0119
        L_0x00ff:
            r2.skipToGroupEnd()
            r0 = r32 & 4
            if (r0 == 0) goto L_0x0108
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0108:
            r0 = r32 & 8
            if (r0 == 0) goto L_0x010e
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x010e:
            r11 = r5
            r16 = r12
            r17 = r14
            r0 = -1909540706(0xffffffff8e2eb89e, float:-2.1536046E-30)
            r12 = r6
            r14 = r8
            goto L_0x0160
        L_0x0119:
            if (r30 == 0) goto L_0x0120
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x0120:
            r0 = r32 & 4
            r4 = 6
            if (r0 == 0) goto L_0x012d
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r6 = r0.getSecondaryContainerColor(r2, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012d:
            r0 = r32 & 8
            if (r0 == 0) goto L_0x013a
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r8 = r0.getSecondaryContentColor(r2, r4)
            r0 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r3 = r0
        L_0x013a:
            if (r11 == 0) goto L_0x014e
            androidx.compose.material3.TabRowKt$SecondaryTabRow$1 r0 = new androidx.compose.material3.TabRowKt$SecondaryTabRow$1
            r0.<init>(r1)
            r4 = 54
            r11 = 286693261(0x1116978d, float:1.1879614E-28)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r11, r12, r0, r2, r4)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r12 = r0
        L_0x014e:
            if (r13 == 0) goto L_0x010e
            androidx.compose.material3.ComposableSingletons$TabRowKt r0 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m1941getLambda2$material3_release()
            r17 = r0
            r11 = r5
            r14 = r8
            r16 = r12
            r0 = -1909540706(0xffffffff8e2eb89e, float:-2.1536046E-30)
            r12 = r6
        L_0x0160:
            r2.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x016f
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.SecondaryTabRow (TabRow.kt:218)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r4, r5)
        L_0x016f:
            int r0 = r3 >> 3
            r3 = 524286(0x7fffe, float:7.34681E-40)
            r20 = r0 & r3
            r18 = r29
            r19 = r2
            m2594TabRowImplDTcfvLk(r11, r12, r14, r16, r17, r18, r19, r20)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0186
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0186:
            r2 = r11
            r3 = r12
            r5 = r14
            r7 = r16
            r8 = r17
        L_0x018d:
            androidx.compose.runtime.ScopeUpdateScope r12 = r19.endRestartGroup()
            if (r12 == 0) goto L_0x01a1
            androidx.compose.material3.TabRowKt$SecondaryTabRow$2 r0 = new androidx.compose.material3.TabRowKt$SecondaryTabRow$2
            r9 = r29
            r11 = r32
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2592SecondaryTabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f1  */
    /* renamed from: TabRow-pAZo6Ak  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2593TabRowpAZo6Ak(int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r1 = r21
            r10 = r31
            r0 = -1199178586(0xffffffffb885fca6, float:-6.388994E-5)
            r2 = r30
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)302@15283L21,303@15347L19,305@15459L246,315@15823L90:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r32 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r10 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((int) r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r10
            goto L_0x0029
        L_0x0028:
            r3 = r10
        L_0x0029:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0043
            r5 = r22
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r3 = r3 | r6
            goto L_0x0045
        L_0x0043:
            r5 = r22
        L_0x0045:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005e
            r6 = r32 & 4
            if (r6 != 0) goto L_0x0058
            r6 = r23
            boolean r8 = r2.changed((long) r6)
            if (r8 == 0) goto L_0x005a
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r6 = r23
        L_0x005a:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r3 = r3 | r8
            goto L_0x0060
        L_0x005e:
            r6 = r23
        L_0x0060:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0079
            r8 = r32 & 8
            if (r8 != 0) goto L_0x0073
            r8 = r25
            boolean r11 = r2.changed((long) r8)
            if (r11 == 0) goto L_0x0075
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0073:
            r8 = r25
        L_0x0075:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r11
            goto L_0x007b
        L_0x0079:
            r8 = r25
        L_0x007b:
            r11 = r32 & 16
            if (r11 == 0) goto L_0x0082
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0095
        L_0x0082:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0095
            r12 = r27
            boolean r13 = r2.changedInstance(r12)
            if (r13 == 0) goto L_0x0091
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r3 = r3 | r13
            goto L_0x0097
        L_0x0095:
            r12 = r27
        L_0x0097:
            r13 = r32 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x009f
            r3 = r3 | r14
            goto L_0x00b1
        L_0x009f:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b1
            r14 = r28
            boolean r15 = r2.changedInstance(r14)
            if (r15 == 0) goto L_0x00ad
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r3 = r3 | r15
            goto L_0x00b3
        L_0x00b1:
            r14 = r28
        L_0x00b3:
            r15 = r32 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bc
            r3 = r3 | r16
            goto L_0x00d0
        L_0x00bc:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d0
            r15 = r29
            boolean r16 = r2.changedInstance(r15)
            if (r16 == 0) goto L_0x00cb
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r3 = r3 | r16
            goto L_0x00d2
        L_0x00d0:
            r15 = r29
        L_0x00d2:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r3 & r16
            r30 = r4
            r4 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r4) goto L_0x00f1
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00f1
        L_0x00e5:
            r2.skipToGroupEnd()
            r19 = r2
            r2 = r5
            r3 = r6
            r5 = r8
            r7 = r12
            r8 = r14
            goto L_0x018d
        L_0x00f1:
            r2.startDefaults()
            r0 = r10 & 1
            if (r0 == 0) goto L_0x0119
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00ff
            goto L_0x0119
        L_0x00ff:
            r2.skipToGroupEnd()
            r0 = r32 & 4
            if (r0 == 0) goto L_0x0108
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0108:
            r0 = r32 & 8
            if (r0 == 0) goto L_0x010e
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x010e:
            r11 = r5
            r16 = r12
            r17 = r14
            r0 = -1199178586(0xffffffffb885fca6, float:-6.388994E-5)
            r12 = r6
            r14 = r8
            goto L_0x0160
        L_0x0119:
            if (r30 == 0) goto L_0x0120
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x0120:
            r0 = r32 & 4
            r4 = 6
            if (r0 == 0) goto L_0x012d
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r6 = r0.getPrimaryContainerColor(r2, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012d:
            r0 = r32 & 8
            if (r0 == 0) goto L_0x013a
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r8 = r0.getPrimaryContentColor(r2, r4)
            r0 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r3 = r0
        L_0x013a:
            if (r11 == 0) goto L_0x014e
            androidx.compose.material3.TabRowKt$TabRow$1 r0 = new androidx.compose.material3.TabRowKt$TabRow$1
            r0.<init>(r1)
            r4 = 54
            r11 = -2052073983(0xffffffff85afd601, float:-1.6535534E-35)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r11, r12, r0, r2, r4)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r12 = r0
        L_0x014e:
            if (r13 == 0) goto L_0x010e
            androidx.compose.material3.ComposableSingletons$TabRowKt r0 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m1942getLambda3$material3_release()
            r17 = r0
            r11 = r5
            r14 = r8
            r16 = r12
            r0 = -1199178586(0xffffffffb885fca6, float:-6.388994E-5)
            r12 = r6
        L_0x0160:
            r2.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x016f
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.TabRow (TabRow.kt:314)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r4, r5)
        L_0x016f:
            int r0 = r3 >> 3
            r3 = 524286(0x7fffe, float:7.34681E-40)
            r20 = r0 & r3
            r18 = r29
            r19 = r2
            m2595TabRowWithSubcomposeImplDTcfvLk(r11, r12, r14, r16, r17, r18, r19, r20)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0186
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0186:
            r2 = r11
            r3 = r12
            r5 = r14
            r7 = r16
            r8 = r17
        L_0x018d:
            androidx.compose.runtime.ScopeUpdateScope r12 = r19.endRestartGroup()
            if (r12 == 0) goto L_0x01a1
            androidx.compose.material3.TabRowKt$TabRow$2 r0 = new androidx.compose.material3.TabRowKt$TabRow$2
            r9 = r29
            r11 = r32
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2593TabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fe  */
    /* renamed from: PrimaryScrollableTabRow-qhFBPw4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2586PrimaryScrollableTabRowqhFBPw4(int r21, androidx.compose.ui.Modifier r22, androidx.compose.foundation.ScrollState r23, long r24, long r26, float r28, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TabIndicatorScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r0 = r21
            r13 = r33
            r14 = r34
            r1 = -1763241113(0xffffffff96e71367, float:-3.7332307E-25)
            r2 = r32
            androidx.compose.runtime.Composer r11 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(PrimaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)357@18289L21,358@18355L21,359@18419L19,362@18589L198,371@18905L328:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = r14 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r13 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r13 & 6
            if (r2 != 0) goto L_0x002a
            boolean r2 = r11.changed((int) r0)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r13
            goto L_0x002b
        L_0x002a:
            r2 = r13
        L_0x002b:
            r3 = r14 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r13 & 48
            if (r4 != 0) goto L_0x0045
            r4 = r22
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r2 = r2 | r5
            goto L_0x0047
        L_0x0045:
            r4 = r22
        L_0x0047:
            r5 = r13 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0060
            r5 = r14 & 4
            if (r5 != 0) goto L_0x005a
            r5 = r23
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r5 = r23
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r6
            goto L_0x0062
        L_0x0060:
            r5 = r23
        L_0x0062:
            r6 = r13 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007b
            r6 = r14 & 8
            if (r6 != 0) goto L_0x0075
            r6 = r24
            boolean r8 = r11.changed((long) r6)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r6 = r24
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r8
            goto L_0x007d
        L_0x007b:
            r6 = r24
        L_0x007d:
            r8 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x0096
            r8 = r14 & 16
            if (r8 != 0) goto L_0x0090
            r8 = r26
            boolean r10 = r11.changed((long) r8)
            if (r10 == 0) goto L_0x0092
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0090:
            r8 = r26
        L_0x0092:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r2 = r2 | r10
            goto L_0x0098
        L_0x0096:
            r8 = r26
        L_0x0098:
            r10 = r14 & 32
            r12 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a0
            r2 = r2 | r12
            goto L_0x00b2
        L_0x00a0:
            r12 = r12 & r13
            if (r12 != 0) goto L_0x00b2
            r12 = r28
            boolean r15 = r11.changed((float) r12)
            if (r15 == 0) goto L_0x00ae
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ae:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r2 = r2 | r15
            goto L_0x00b4
        L_0x00b2:
            r12 = r28
        L_0x00b4:
            r15 = r14 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bf
            r2 = r2 | r16
            r1 = r29
            goto L_0x00d2
        L_0x00bf:
            r16 = r13 & r16
            r1 = r29
            if (r16 != 0) goto L_0x00d2
            boolean r17 = r11.changedInstance(r1)
            if (r17 == 0) goto L_0x00ce
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r2 = r2 | r17
        L_0x00d2:
            r1 = r14 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r1 == 0) goto L_0x00db
            r2 = r2 | r17
            goto L_0x00f1
        L_0x00db:
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00f1
            r17 = r1
            r1 = r30
            boolean r18 = r11.changedInstance(r1)
            if (r18 == 0) goto L_0x00ec
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r2 = r2 | r18
            goto L_0x00f5
        L_0x00f1:
            r17 = r1
            r1 = r30
        L_0x00f5:
            r1 = r14 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x00fe
            r2 = r2 | r18
            goto L_0x0112
        L_0x00fe:
            r1 = r13 & r18
            if (r1 != 0) goto L_0x0112
            r1 = r31
            boolean r18 = r11.changedInstance(r1)
            if (r18 == 0) goto L_0x010d
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010d:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r2 = r2 | r18
            goto L_0x0114
        L_0x0112:
            r1 = r31
        L_0x0114:
            r18 = 38347923(0x2492493, float:1.4777644E-37)
            r1 = r2 & r18
            r32 = r3
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r1 != r3) goto L_0x0135
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x0127
            goto L_0x0135
        L_0x0127:
            r11.skipToGroupEnd()
            r10 = r30
            r2 = r4
            r3 = r5
            r4 = r6
            r6 = r8
            r8 = r12
            r9 = r29
            goto L_0x0221
        L_0x0135:
            r11.startDefaults()
            r1 = r13 & 1
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x0166
            boolean r1 = r11.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0146
            goto L_0x0166
        L_0x0146:
            r11.skipToGroupEnd()
            r1 = r14 & 4
            if (r1 == 0) goto L_0x014f
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x014f:
            r1 = r14 & 8
            if (r1 == 0) goto L_0x0155
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0155:
            r1 = r14 & 16
            if (r1 == 0) goto L_0x015a
            r2 = r2 & r3
        L_0x015a:
            r10 = r2
            r1 = r4
            r2 = r6
            r6 = r12
            r7 = r5
            r4 = r8
            r8 = r29
            r9 = r30
            goto L_0x01d3
        L_0x0166:
            if (r32 == 0) goto L_0x016d
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r4 = r1
        L_0x016d:
            r1 = r14 & 4
            r32 = r3
            r3 = 1
            if (r1 == 0) goto L_0x017c
            r1 = 0
            androidx.compose.foundation.ScrollState r1 = androidx.compose.foundation.ScrollKt.rememberScrollState(r1, r11, r1, r3)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r5 = r1
        L_0x017c:
            r1 = r14 & 8
            r3 = 6
            if (r1 == 0) goto L_0x0189
            androidx.compose.material3.TabRowDefaults r1 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r6 = r1.getPrimaryContainerColor(r11, r3)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0189:
            r1 = r14 & 16
            if (r1 == 0) goto L_0x0196
            androidx.compose.material3.TabRowDefaults r1 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r8 = r1.getPrimaryContentColor(r11, r3)
            r1 = r2 & r32
            r2 = r1
        L_0x0196:
            if (r10 == 0) goto L_0x019f
            androidx.compose.material3.TabRowDefaults r1 = androidx.compose.material3.TabRowDefaults.INSTANCE
            float r1 = r1.m2584getScrollableTabRowEdgeStartPaddingD9Ej5fM()
            r12 = r1
        L_0x019f:
            if (r15 == 0) goto L_0x01b3
            androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$1 r1 = new androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$1
            r1.<init>(r0)
            r3 = 54
            r10 = 1601820568(0x5f79d798, float:1.8003025E19)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r10, r15, r1, r11, r3)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            goto L_0x01b5
        L_0x01b3:
            r1 = r29
        L_0x01b5:
            if (r17 == 0) goto L_0x01c7
            androidx.compose.material3.ComposableSingletons$TabRowKt r3 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1943getLambda4$material3_release()
            r10 = r2
            r19 = r8
            r8 = r1
            r9 = r3
            r1 = r4
            r2 = r6
            r6 = r12
            r7 = r5
            goto L_0x01d1
        L_0x01c7:
            r10 = r2
            r2 = r6
            r6 = r12
            r7 = r5
            r19 = r8
            r9 = r30
            r8 = r1
            r1 = r4
        L_0x01d1:
            r4 = r19
        L_0x01d3:
            r11.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x01e5
            r12 = -1
            java.lang.String r15 = "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:370)"
            r0 = -1763241113(0xffffffff96e71367, float:-3.7332307E-25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r12, r15)
        L_0x01e5:
            r0 = r10 & 126(0x7e, float:1.77E-43)
            int r12 = r10 >> 3
            r15 = r12 & 896(0x380, float:1.256E-42)
            r0 = r0 | r15
            r15 = r12 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r15
            r15 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r15
            r0 = r0 | r12
            int r12 = r10 << 9
            r15 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r15
            r0 = r0 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r10
            r0 = r0 | r12
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r12 = r12 & r10
            r0 = r0 | r12
            r12 = 234881024(0xe000000, float:1.5777218E-30)
            r10 = r10 & r12
            r12 = r0 | r10
            r0 = r21
            r10 = r31
            m2589ScrollableTabRowImplsKfQg0A(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0217
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0217:
            r10 = r9
            r9 = r8
            r8 = r6
            r19 = r2
            r2 = r1
            r3 = r7
            r6 = r4
            r4 = r19
        L_0x0221:
            androidx.compose.runtime.ScopeUpdateScope r15 = r11.endRestartGroup()
            if (r15 == 0) goto L_0x0237
            androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$2 r0 = new androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$2
            r1 = r21
            r11 = r31
            r12 = r13
            r13 = r14
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0237:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2586PrimaryScrollableTabRowqhFBPw4(int, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fe  */
    /* renamed from: SecondaryScrollableTabRow-qhFBPw4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2591SecondaryScrollableTabRowqhFBPw4(int r21, androidx.compose.ui.Modifier r22, androidx.compose.foundation.ScrollState r23, long r24, long r26, float r28, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TabIndicatorScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r0 = r21
            r13 = r33
            r14 = r34
            r1 = 1821940917(0x6c989cb5, float:1.475974E27)
            r2 = r32
            androidx.compose.runtime.Composer r11 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(SecondaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)427@21884L21,428@21950L23,429@22016L21,432@22188L160,440@22466L327:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = r14 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r13 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r13 & 6
            if (r2 != 0) goto L_0x002a
            boolean r2 = r11.changed((int) r0)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r13
            goto L_0x002b
        L_0x002a:
            r2 = r13
        L_0x002b:
            r3 = r14 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r13 & 48
            if (r4 != 0) goto L_0x0045
            r4 = r22
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r2 = r2 | r5
            goto L_0x0047
        L_0x0045:
            r4 = r22
        L_0x0047:
            r5 = r13 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0060
            r5 = r14 & 4
            if (r5 != 0) goto L_0x005a
            r5 = r23
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r5 = r23
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r6
            goto L_0x0062
        L_0x0060:
            r5 = r23
        L_0x0062:
            r6 = r13 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007b
            r6 = r14 & 8
            if (r6 != 0) goto L_0x0075
            r6 = r24
            boolean r8 = r11.changed((long) r6)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r6 = r24
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r8
            goto L_0x007d
        L_0x007b:
            r6 = r24
        L_0x007d:
            r8 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x0096
            r8 = r14 & 16
            if (r8 != 0) goto L_0x0090
            r8 = r26
            boolean r10 = r11.changed((long) r8)
            if (r10 == 0) goto L_0x0092
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0090:
            r8 = r26
        L_0x0092:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r2 = r2 | r10
            goto L_0x0098
        L_0x0096:
            r8 = r26
        L_0x0098:
            r10 = r14 & 32
            r12 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a0
            r2 = r2 | r12
            goto L_0x00b2
        L_0x00a0:
            r12 = r12 & r13
            if (r12 != 0) goto L_0x00b2
            r12 = r28
            boolean r15 = r11.changed((float) r12)
            if (r15 == 0) goto L_0x00ae
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ae:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r2 = r2 | r15
            goto L_0x00b4
        L_0x00b2:
            r12 = r28
        L_0x00b4:
            r15 = r14 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bf
            r2 = r2 | r16
            r1 = r29
            goto L_0x00d2
        L_0x00bf:
            r16 = r13 & r16
            r1 = r29
            if (r16 != 0) goto L_0x00d2
            boolean r17 = r11.changedInstance(r1)
            if (r17 == 0) goto L_0x00ce
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r2 = r2 | r17
        L_0x00d2:
            r1 = r14 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r1 == 0) goto L_0x00db
            r2 = r2 | r17
            goto L_0x00f1
        L_0x00db:
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00f1
            r17 = r1
            r1 = r30
            boolean r18 = r11.changedInstance(r1)
            if (r18 == 0) goto L_0x00ec
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r2 = r2 | r18
            goto L_0x00f5
        L_0x00f1:
            r17 = r1
            r1 = r30
        L_0x00f5:
            r1 = r14 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x00fe
            r2 = r2 | r18
            goto L_0x0112
        L_0x00fe:
            r1 = r13 & r18
            if (r1 != 0) goto L_0x0112
            r1 = r31
            boolean r18 = r11.changedInstance(r1)
            if (r18 == 0) goto L_0x010d
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010d:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r2 = r2 | r18
            goto L_0x0114
        L_0x0112:
            r1 = r31
        L_0x0114:
            r18 = 38347923(0x2492493, float:1.4777644E-37)
            r1 = r2 & r18
            r32 = r3
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r1 != r3) goto L_0x0135
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x0127
            goto L_0x0135
        L_0x0127:
            r11.skipToGroupEnd()
            r10 = r30
            r2 = r4
            r3 = r5
            r4 = r6
            r6 = r8
            r8 = r12
            r9 = r29
            goto L_0x0221
        L_0x0135:
            r11.startDefaults()
            r1 = r13 & 1
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x0166
            boolean r1 = r11.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0146
            goto L_0x0166
        L_0x0146:
            r11.skipToGroupEnd()
            r1 = r14 & 4
            if (r1 == 0) goto L_0x014f
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x014f:
            r1 = r14 & 8
            if (r1 == 0) goto L_0x0155
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0155:
            r1 = r14 & 16
            if (r1 == 0) goto L_0x015a
            r2 = r2 & r3
        L_0x015a:
            r10 = r2
            r1 = r4
            r2 = r6
            r6 = r12
            r7 = r5
            r4 = r8
            r8 = r29
            r9 = r30
            goto L_0x01d3
        L_0x0166:
            if (r32 == 0) goto L_0x016d
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r4 = r1
        L_0x016d:
            r1 = r14 & 4
            r32 = r3
            r3 = 1
            if (r1 == 0) goto L_0x017c
            r1 = 0
            androidx.compose.foundation.ScrollState r1 = androidx.compose.foundation.ScrollKt.rememberScrollState(r1, r11, r1, r3)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r5 = r1
        L_0x017c:
            r1 = r14 & 8
            r3 = 6
            if (r1 == 0) goto L_0x0189
            androidx.compose.material3.TabRowDefaults r1 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r6 = r1.getSecondaryContainerColor(r11, r3)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0189:
            r1 = r14 & 16
            if (r1 == 0) goto L_0x0196
            androidx.compose.material3.TabRowDefaults r1 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r8 = r1.getSecondaryContentColor(r11, r3)
            r1 = r2 & r32
            r2 = r1
        L_0x0196:
            if (r10 == 0) goto L_0x019f
            androidx.compose.material3.TabRowDefaults r1 = androidx.compose.material3.TabRowDefaults.INSTANCE
            float r1 = r1.m2584getScrollableTabRowEdgeStartPaddingD9Ej5fM()
            r12 = r1
        L_0x019f:
            if (r15 == 0) goto L_0x01b3
            androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$1 r1 = new androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$1
            r1.<init>(r0)
            r3 = 54
            r10 = 1535842470(0x5b8b18a6, float:7.8304246E16)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r10, r15, r1, r11, r3)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            goto L_0x01b5
        L_0x01b3:
            r1 = r29
        L_0x01b5:
            if (r17 == 0) goto L_0x01c7
            androidx.compose.material3.ComposableSingletons$TabRowKt r3 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1944getLambda5$material3_release()
            r10 = r2
            r19 = r8
            r8 = r1
            r9 = r3
            r1 = r4
            r2 = r6
            r6 = r12
            r7 = r5
            goto L_0x01d1
        L_0x01c7:
            r10 = r2
            r2 = r6
            r6 = r12
            r7 = r5
            r19 = r8
            r9 = r30
            r8 = r1
            r1 = r4
        L_0x01d1:
            r4 = r19
        L_0x01d3:
            r11.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x01e5
            r12 = -1
            java.lang.String r15 = "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:439)"
            r0 = 1821940917(0x6c989cb5, float:1.475974E27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r12, r15)
        L_0x01e5:
            r0 = r10 & 126(0x7e, float:1.77E-43)
            int r12 = r10 >> 3
            r15 = r12 & 896(0x380, float:1.256E-42)
            r0 = r0 | r15
            r15 = r12 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r15
            r15 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r15
            r0 = r0 | r12
            int r12 = r10 << 9
            r15 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r15
            r0 = r0 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r10
            r0 = r0 | r12
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r12 = r12 & r10
            r0 = r0 | r12
            r12 = 234881024(0xe000000, float:1.5777218E-30)
            r10 = r10 & r12
            r12 = r0 | r10
            r0 = r21
            r10 = r31
            m2589ScrollableTabRowImplsKfQg0A(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0217
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0217:
            r10 = r9
            r9 = r8
            r8 = r6
            r19 = r2
            r2 = r1
            r3 = r7
            r6 = r4
            r4 = r19
        L_0x0221:
            androidx.compose.runtime.ScopeUpdateScope r15 = r11.endRestartGroup()
            if (r15 == 0) goto L_0x0237
            androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$2 r0 = new androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$2
            r1 = r21
            r11 = r31
            r12 = r13
            r13 = r14
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0237:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2591SecondaryScrollableTabRowqhFBPw4(int, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0112  */
    /* renamed from: ScrollableTabRow-sKfQg0A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2588ScrollableTabRowsKfQg0A(int r19, androidx.compose.ui.Modifier r20, long r21, long r23, float r25, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r0 = r19
            r14 = r30
            r15 = r31
            r1 = -497821003(0xffffffffe253dab5, float:-9.770056E20)
            r2 = r29
            androidx.compose.runtime.Composer r11 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)495@25349L21,496@25413L19,499@25596L164,516@26202L21,507@25878L351:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = r15 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r14 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r14 & 6
            if (r2 != 0) goto L_0x002a
            boolean r2 = r11.changed((int) r0)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r14
            goto L_0x002b
        L_0x002a:
            r2 = r14
        L_0x002b:
            r3 = r15 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r14 & 48
            if (r4 != 0) goto L_0x0045
            r4 = r20
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r2 = r2 | r5
            goto L_0x0047
        L_0x0045:
            r4 = r20
        L_0x0047:
            r5 = r14 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0060
            r5 = r15 & 4
            if (r5 != 0) goto L_0x005a
            r5 = r21
            boolean r7 = r11.changed((long) r5)
            if (r7 == 0) goto L_0x005c
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r5 = r21
        L_0x005c:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r7
            goto L_0x0062
        L_0x0060:
            r5 = r21
        L_0x0062:
            r7 = r14 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007b
            r7 = r15 & 8
            if (r7 != 0) goto L_0x0075
            r7 = r23
            boolean r9 = r11.changed((long) r7)
            if (r9 == 0) goto L_0x0077
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r7 = r23
        L_0x0077:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r9
            goto L_0x007d
        L_0x007b:
            r7 = r23
        L_0x007d:
            r9 = r15 & 16
            if (r9 == 0) goto L_0x0084
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0084:
            r10 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0097
            r10 = r25
            boolean r12 = r11.changed((float) r10)
            if (r12 == 0) goto L_0x0093
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r2 = r2 | r12
            goto L_0x0099
        L_0x0097:
            r10 = r25
        L_0x0099:
            r12 = r15 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a1
            r2 = r2 | r13
            goto L_0x00b4
        L_0x00a1:
            r13 = r13 & r14
            if (r13 != 0) goto L_0x00b4
            r13 = r26
            boolean r16 = r11.changedInstance(r13)
            if (r16 == 0) goto L_0x00af
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r2 = r2 | r16
            goto L_0x00b6
        L_0x00b4:
            r13 = r26
        L_0x00b6:
            r16 = r15 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c1
            r2 = r2 | r17
            r1 = r27
            goto L_0x00d4
        L_0x00c1:
            r17 = r14 & r17
            r1 = r27
            if (r17 != 0) goto L_0x00d4
            boolean r18 = r11.changedInstance(r1)
            if (r18 == 0) goto L_0x00d0
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r2 = r2 | r18
        L_0x00d4:
            r1 = r15 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r1 == 0) goto L_0x00dd
            r2 = r2 | r18
            goto L_0x00f1
        L_0x00dd:
            r1 = r14 & r18
            if (r1 != 0) goto L_0x00f1
            r1 = r28
            boolean r18 = r11.changedInstance(r1)
            if (r18 == 0) goto L_0x00ec
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r2 = r2 | r18
            goto L_0x00f3
        L_0x00f1:
            r1 = r28
        L_0x00f3:
            r18 = 4793491(0x492493, float:6.717112E-39)
            r1 = r2 & r18
            r29 = r3
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r3) goto L_0x0112
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x0106
            goto L_0x0112
        L_0x0106:
            r11.skipToGroupEnd()
            r9 = r27
            r2 = r4
            r3 = r5
            r5 = r7
            r7 = r10
            r8 = r13
            goto L_0x01d1
        L_0x0112:
            r11.startDefaults()
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0138
            boolean r1 = r11.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0120
            goto L_0x0138
        L_0x0120:
            r11.skipToGroupEnd()
            r1 = r15 & 4
            if (r1 == 0) goto L_0x0129
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0129:
            r1 = r15 & 8
            if (r1 == 0) goto L_0x012f
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x012f:
            r9 = r2
            r2 = r4
            r3 = r5
            r5 = r7
            r7 = r10
            r1 = r13
            r8 = r27
            goto L_0x0185
        L_0x0138:
            if (r29 == 0) goto L_0x013f
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r4 = r1
        L_0x013f:
            r1 = r15 & 4
            r3 = 6
            if (r1 == 0) goto L_0x014c
            androidx.compose.material3.TabRowDefaults r1 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r5 = r1.getPrimaryContainerColor(r11, r3)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x014c:
            r1 = r15 & 8
            if (r1 == 0) goto L_0x0159
            androidx.compose.material3.TabRowDefaults r1 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r7 = r1.getPrimaryContentColor(r11, r3)
            r1 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            r2 = r1
        L_0x0159:
            if (r9 == 0) goto L_0x0162
            androidx.compose.material3.TabRowDefaults r1 = androidx.compose.material3.TabRowDefaults.INSTANCE
            float r1 = r1.m2584getScrollableTabRowEdgeStartPaddingD9Ej5fM()
            r10 = r1
        L_0x0162:
            if (r12 == 0) goto L_0x0176
            androidx.compose.material3.TabRowKt$ScrollableTabRow$1 r1 = new androidx.compose.material3.TabRowKt$ScrollableTabRow$1
            r1.<init>(r0)
            r3 = 54
            r9 = -913748678(0xffffffffc9894d3a, float:-1124775.2)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r9, r12, r1, r11, r3)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r13 = r1
        L_0x0176:
            if (r16 == 0) goto L_0x012f
            androidx.compose.material3.ComposableSingletons$TabRowKt r1 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r1 = r1.m1945getLambda6$material3_release()
            r9 = r2
            r2 = r4
            r3 = r5
            r5 = r7
            r7 = r10
            r8 = r1
            r1 = r13
        L_0x0185:
            r11.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0197
            r10 = -1
            java.lang.String r12 = "androidx.compose.material3.ScrollableTabRow (TabRow.kt:506)"
            r13 = -497821003(0xffffffffe253dab5, float:-9.770056E20)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r9, r10, r12)
        L_0x0197:
            r10 = 0
            r12 = 1
            androidx.compose.foundation.ScrollState r10 = androidx.compose.foundation.ScrollKt.rememberScrollState(r10, r11, r10, r12)
            r12 = r9 & 14
            int r13 = r9 >> 12
            r13 = r13 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            int r13 = r9 << 3
            r0 = r13 & 896(0x380, float:1.256E-42)
            r0 = r0 | r12
            r12 = r13 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r13
            r0 = r0 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r13
            r0 = r0 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r9
            r0 = r0 | r12
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r9 = r9 & r12
            r12 = r0 | r9
            r13 = 0
            r0 = r19
            r9 = r28
            m2590ScrollableTabRowWithSubcomposeImplqhFBPw4(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01cf
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01cf:
            r9 = r8
            r8 = r1
        L_0x01d1:
            androidx.compose.runtime.ScopeUpdateScope r13 = r11.endRestartGroup()
            if (r13 == 0) goto L_0x01e7
            androidx.compose.material3.TabRowKt$ScrollableTabRow$2 r0 = new androidx.compose.material3.TabRowKt$ScrollableTabRow$2
            r1 = r19
            r10 = r28
            r11 = r14
            r12 = r15
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x01e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2588ScrollableTabRowsKfQg0A(int, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: TabRowImpl-DTcfvLk  reason: not valid java name */
    public static final void m2594TabRowImplDTcfvLk(Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Modifier modifier2;
        Composer composer2;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1757425411);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)575@27973L4041,571@27843L4171:TabRow.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i2 = i3;
        }
        long j3 = j;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 32 : 16;
        }
        long j4 = j2;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757425411, i2, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:570)");
            }
            int i4 = i2 << 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2536SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), (Shape) null, j3, j4, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-65106680, true, new TabRowKt$TabRowImpl$1(function24, function23, function32), startRestartGroup, 54), composer2, (i4 & 896) | 12582912 | (i4 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabRowKt$TabRowImpl$2(modifier2, j, j2, function32, function23, function24, i3));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ScrollableTabRowImpl-sKfQg0A  reason: not valid java name */
    public static final void m2589ScrollableTabRowImplsKfQg0A(int i, Modifier modifier, long j, long j2, float f, ScrollState scrollState, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i2) {
        int i3;
        float f2;
        ScrollState scrollState2;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        Modifier modifier2 = modifier;
        int i4 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-1594140035);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollableTabRowImpl)P(7,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,6,4)709@32727L5081,699@32393L5415:TabRow.kt#uh7d8r");
        int i5 = i;
        if ((i4 & 6) == 0) {
            i3 = (startRestartGroup.changed(i5) ? 4 : 2) | i4;
        } else {
            i3 = i4;
        }
        if ((i4 & 48) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier2) ? 32 : 16;
        }
        long j3 = j;
        if ((i4 & 384) == 0) {
            i3 |= startRestartGroup.changed(j3) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i3 |= startRestartGroup.changed(j2) ? 2048 : 1024;
        } else {
            long j4 = j2;
        }
        if ((i4 & 24576) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        if ((196608 & i4) == 0) {
            scrollState2 = scrollState;
            i3 |= startRestartGroup.changed((Object) scrollState2) ? 131072 : 65536;
        } else {
            scrollState2 = scrollState;
        }
        if ((1572864 & i4) == 0) {
            function32 = function3;
            i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
        } else {
            function32 = function3;
        }
        if ((i4 & 12582912) == 0) {
            function23 = function2;
            i3 |= startRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        } else {
            function23 = function2;
        }
        if ((100663296 & i4) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        }
        if ((i3 & 38347923) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1594140035, i3, -1, "androidx.compose.material3.ScrollableTabRowImpl (TabRow.kt:698)");
            }
            composer2 = startRestartGroup;
            SurfaceKt.m2536SurfaceT9BRK9s(ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), Alignment.Companion.getCenterStart(), false, 2, (Object) null), scrollState2, false, (FlingBehavior) null, false, 14, (Object) null))), (Shape) null, j, j2, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1556158104, true, new TabRowKt$ScrollableTabRowImpl$1(scrollState, function22, function23, f2, i5, function32), startRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabRowKt$ScrollableTabRowImpl$2(i, modifier, j, j2, f, scrollState, function3, function2, function22, i4));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: TabRowWithSubcomposeImpl-DTcfvLk  reason: not valid java name */
    public static final void m2595TabRowWithSubcomposeImplDTcfvLk(Modifier modifier, long j, long j2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Modifier modifier2;
        Composer composer2;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-160898917);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowWithSubcomposeImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)947@41323L2218,943@41193L2348:TabRow.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i2 = i3;
        }
        long j3 = j;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 32 : 16;
        }
        long j4 = j2;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160898917, i2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:942)");
            }
            int i4 = i2 << 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2536SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), (Shape) null, j3, j4, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1617702432, true, new TabRowKt$TabRowWithSubcomposeImpl$1(function24, function23, function32), startRestartGroup, 54), composer2, (i4 & 896) | 12582912 | (i4 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabRowKt$TabRowWithSubcomposeImpl$2(modifier2, j, j2, function32, function23, function24, i3));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0100  */
    /* renamed from: ScrollableTabRowWithSubcomposeImpl-qhFBPw4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2590ScrollableTabRowWithSubcomposeImplqhFBPw4(int r27, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, long r30, long r32, float r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.foundation.ScrollState r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r12 = r39
            r13 = r40
            r0 = -955409947(0xffffffffc70d99e5, float:-36249.895)
            r1 = r38
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ScrollableTabRowWithSubcomposeImpl)P(7,4,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp!1,8)1008@43780L21,1009@43844L19,1015@44165L3880,1015@44083L3962:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r12 | 6
            r3 = r2
            r2 = r27
            goto L_0x0030
        L_0x001c:
            r2 = r12 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r27
            boolean r3 = r1.changed((int) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r12
            goto L_0x0030
        L_0x002d:
            r2 = r27
            r3 = r12
        L_0x0030:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r4 = r12 & 48
            if (r4 != 0) goto L_0x004a
            r4 = r28
            boolean r5 = r1.changedInstance(r4)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r3 = r3 | r5
            goto L_0x004c
        L_0x004a:
            r4 = r28
        L_0x004c:
            r5 = r13 & 4
            if (r5 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r6 = r12 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0066
            r6 = r29
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0062
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r7
            goto L_0x0068
        L_0x0066:
            r6 = r29
        L_0x0068:
            r7 = r12 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0081
            r7 = r13 & 8
            if (r7 != 0) goto L_0x007b
            r7 = r30
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x007d
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007b:
            r7 = r30
        L_0x007d:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r3 = r3 | r9
            goto L_0x0083
        L_0x0081:
            r7 = r30
        L_0x0083:
            r9 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009c
            r9 = r13 & 16
            if (r9 != 0) goto L_0x0096
            r9 = r32
            boolean r11 = r1.changed((long) r9)
            if (r11 == 0) goto L_0x0098
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0096:
            r9 = r32
        L_0x0098:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r3 = r3 | r11
            goto L_0x009e
        L_0x009c:
            r9 = r32
        L_0x009e:
            r11 = r13 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r11 == 0) goto L_0x00a6
            r3 = r3 | r14
            goto L_0x00b8
        L_0x00a6:
            r14 = r14 & r12
            if (r14 != 0) goto L_0x00b8
            r14 = r34
            boolean r15 = r1.changed((float) r14)
            if (r15 == 0) goto L_0x00b4
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b4:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r3 = r3 | r15
            goto L_0x00ba
        L_0x00b8:
            r14 = r34
        L_0x00ba:
            r15 = r13 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c5
            r3 = r3 | r16
            r0 = r35
            goto L_0x00d8
        L_0x00c5:
            r16 = r12 & r16
            r0 = r35
            if (r16 != 0) goto L_0x00d8
            boolean r17 = r1.changedInstance(r0)
            if (r17 == 0) goto L_0x00d4
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r3 = r3 | r17
        L_0x00d8:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e1
            r3 = r3 | r17
            goto L_0x00f5
        L_0x00e1:
            r0 = r12 & r17
            if (r0 != 0) goto L_0x00f5
            r0 = r36
            boolean r18 = r1.changedInstance(r0)
            if (r18 == 0) goto L_0x00f0
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00f0:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r3 = r3 | r18
            goto L_0x00f7
        L_0x00f5:
            r0 = r36
        L_0x00f7:
            r0 = r13 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0100
            r3 = r3 | r18
            goto L_0x0114
        L_0x0100:
            r0 = r12 & r18
            if (r0 != 0) goto L_0x0114
            r0 = r37
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010f
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0111
        L_0x010f:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0111:
            r3 = r3 | r18
            goto L_0x0116
        L_0x0114:
            r0 = r37
        L_0x0116:
            r18 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r3 & r18
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x0134
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0127
            goto L_0x0134
        L_0x0127:
            r1.skipToGroupEnd()
            r24 = r1
            r3 = r6
            r4 = r7
            r6 = r9
            r8 = r14
            r9 = r35
            goto L_0x01f7
        L_0x0134:
            r1.startDefaults()
            r0 = r12 & 1
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0161
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0145
            goto L_0x0161
        L_0x0145:
            r1.skipToGroupEnd()
            r0 = r13 & 8
            if (r0 == 0) goto L_0x014e
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014e:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0153
            r3 = r3 & r2
        L_0x0153:
            r2 = r35
        L_0x0155:
            r18 = r9
            r0 = r14
            r5 = r17
            r14 = r6
            r16 = r7
            r6 = -955409947(0xffffffffc70d99e5, float:-36249.895)
            goto L_0x0195
        L_0x0161:
            if (r5 == 0) goto L_0x0168
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x0168:
            r0 = r13 & 8
            r5 = 6
            if (r0 == 0) goto L_0x0175
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r7 = r0.getPrimaryContainerColor(r1, r5)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0175:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0182
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r9 = r0.getPrimaryContentColor(r1, r5)
            r0 = r3 & r2
            r3 = r0
        L_0x0182:
            if (r11 == 0) goto L_0x018b
            androidx.compose.material3.TabRowDefaults r0 = androidx.compose.material3.TabRowDefaults.INSTANCE
            float r0 = r0.m2584getScrollableTabRowEdgeStartPaddingD9Ej5fM()
            r14 = r0
        L_0x018b:
            if (r15 == 0) goto L_0x0153
            androidx.compose.material3.ComposableSingletons$TabRowKt r0 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m1946getLambda7$material3_release()
            r2 = r0
            goto L_0x0155
        L_0x0195:
            r1.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x01a4
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:1014)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r3, r7, r8)
        L_0x01a4:
            androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1 r6 = new androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1
            r35 = r27
            r32 = r36
            r30 = r37
            r31 = r0
            r33 = r2
            r34 = r4
            r29 = r6
            r29.<init>(r30, r31, r32, r33, r34, r35)
            r0 = r29
            r2 = r31
            r4 = r33
            r6 = 54
            r7 = -1572959552(0xffffffffa23e8ac0, float:-2.5823255E-18)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r8, r0, r1, r6)
            r23 = r0
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            int r0 = r3 >> 6
            r0 = r0 & 14
            r0 = r0 | r5
            int r3 = r3 >> 3
            r5 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r5
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r25 = r0 | r3
            r26 = 114(0x72, float:1.6E-43)
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = r1
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r14, r15, r16, r18, r20, r21, r22, r23, r24, r25, r26)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01f0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01f0:
            r8 = r2
            r9 = r4
            r3 = r14
            r4 = r16
            r6 = r18
        L_0x01f7:
            androidx.compose.runtime.ScopeUpdateScope r14 = r24.endRestartGroup()
            if (r14 == 0) goto L_0x020f
            androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$2 r0 = new androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$2
            r1 = r27
            r2 = r28
            r10 = r36
            r11 = r37
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x020f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2590ScrollableTabRowWithSubcomposeImplqhFBPw4(int, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int):void");
    }
}
