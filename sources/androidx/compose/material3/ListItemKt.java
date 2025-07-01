package androidx.compose.material3;

import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a©\u0001\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0015\b\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001at\u0010'\u001a\u00020\u00172\u0013\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001a2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0013\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001aH\u0003¢\u0006\u0002\u0010-\u001a5\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a\u001a\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u000208H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001aV\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020<2\u0006\u00107\u001a\u0002082\u0006\u00106\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001aN\u0010G\u001a\u00020<*\u00020=2\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020<2\u0006\u0010M\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a\u0014\u0010P\u001a\u00020Q*\u00020R2\u0006\u0010S\u001a\u00020<H\u0002\u001an\u0010T\u001a\u00020U*\u00020V2\u0006\u0010W\u001a\u00020<2\u0006\u0010X\u001a\u00020<2\b\u0010Y\u001a\u0004\u0018\u00010Z2\b\u0010[\u001a\u0004\u0018\u00010Z2\b\u0010\\\u001a\u0004\u0018\u00010Z2\b\u0010]\u001a\u0004\u0018\u00010Z2\b\u0010^\u001a\u0004\u0018\u00010Z2\u0006\u0010_\u001a\u00020Q2\u0006\u0010`\u001a\u00020<2\u0006\u0010a\u001a\u00020<2\u0006\u0010b\u001a\u00020<H\u0002\u001a\u0014\u0010c\u001a\u00020<*\u00020<2\u0006\u0010d\u001a\u00020<H\u0002\"\u001e\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001e\u0010\u0007\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u001e\u0010\n\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005\"\u001e\u0010\r\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0005\"\u001e\u0010\u0010\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0005\"\u001e\u0010\u0013\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006e"}, d2 = {"LeadingContentEndPadding", "Landroidx/compose/ui/unit/Dp;", "getLeadingContentEndPadding$annotations", "()V", "getLeadingContentEndPadding", "()F", "F", "ListItemEndPadding", "getListItemEndPadding$annotations", "getListItemEndPadding", "ListItemStartPadding", "getListItemStartPadding$annotations", "getListItemStartPadding", "ListItemThreeLineVerticalPadding", "getListItemThreeLineVerticalPadding$annotations", "getListItemThreeLineVerticalPadding", "ListItemVerticalPadding", "getListItemVerticalPadding$annotations", "getListItemVerticalPadding", "TrailingContentStartPadding", "getTrailingContentStartPadding$annotations", "getTrailingContentStartPadding", "ListItem", "", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineContent", "supportingContent", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "ListItemLayout", "leading", "trailing", "headline", "overline", "supporting", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ProvideTextStyleFromToken", "color", "Landroidx/compose/ui/graphics/Color;", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "content", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "verticalPadding", "listItemType", "Landroidx/compose/material3/ListItemType;", "verticalPadding-yh95HIg", "(I)F", "calculateHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "leadingHeight", "trailingHeight", "headlineHeight", "overlineHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "calculateHeight-N4Jib3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIIJ)I", "calculateWidth", "leadingWidth", "trailingWidth", "headlineWidth", "overlineWidth", "supportingWidth", "horizontalPadding", "calculateWidth-yeHjK3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIJ)I", "isSupportingMultilineHeuristic", "", "Landroidx/compose/ui/unit/Density;", "estimatedSupportingHeight", "place", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "width", "height", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "headlinePlaceable", "overlinePlaceable", "supportingPlaceable", "isThreeLine", "startPadding", "endPadding", "topPadding", "subtractConstraintSafely", "n", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
public final class ListItemKt {
    private static final float LeadingContentEndPadding;
    private static final float ListItemEndPadding;
    private static final float ListItemStartPadding;
    private static final float ListItemThreeLineVerticalPadding = Dp.m7111constructorimpl((float) 12);
    private static final float ListItemVerticalPadding = Dp.m7111constructorimpl((float) 8);
    private static final float TrailingContentStartPadding;

    public static /* synthetic */ void getLeadingContentEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemStartPadding$annotations() {
    }

    public static /* synthetic */ void getListItemThreeLineVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getListItemVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getTrailingContentStartPadding$annotations() {
    }

    /* access modifiers changed from: private */
    public static final int subtractConstraintSafely(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : i - i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0100  */
    /* renamed from: ListItem-HXNGIdc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2169ListItemHXNGIdc(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.Modifier r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.material3.ListItemColors r42, float r43, float r44, androidx.compose.runtime.Composer r45, int r46, int r47) {
        /*
            r1 = r36
            r10 = r46
            r11 = r47
            r0 = -1647707763(0xffffffff9dc9f98d, float:-5.3462286E-21)
            r2 = r45
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(ListItem)P(1,3,4,6,2,8!1,7:c#ui.unit.Dp,5:c#ui.unit.Dp)100@4555L8,104@4735L176,157@6562L5,162@6761L288,155@6438L611:ListItem.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r11 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r10 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r10
            goto L_0x002b
        L_0x002a:
            r3 = r10
        L_0x002b:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r37
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r37
        L_0x0047:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0061
            r7 = r38
            boolean r8 = r2.changedInstance(r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r38
        L_0x0063:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x006a
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r9 = r10 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007d
            r9 = r39
            boolean r12 = r2.changedInstance(r9)
            if (r12 == 0) goto L_0x0079
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r3 = r3 | r12
            goto L_0x007f
        L_0x007d:
            r9 = r39
        L_0x007f:
            r12 = r11 & 16
            if (r12 == 0) goto L_0x0086
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r13 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0099
            r13 = r40
            boolean r14 = r2.changedInstance(r13)
            if (r14 == 0) goto L_0x0095
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r3 = r3 | r14
            goto L_0x009b
        L_0x0099:
            r13 = r40
        L_0x009b:
            r14 = r11 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a3
            r3 = r3 | r15
            goto L_0x00b6
        L_0x00a3:
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00b6
            r15 = r41
            boolean r16 = r2.changedInstance(r15)
            if (r16 == 0) goto L_0x00b1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r3 = r3 | r16
            goto L_0x00b8
        L_0x00b6:
            r15 = r41
        L_0x00b8:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00d2
            r16 = r11 & 64
            r0 = r42
            if (r16 != 0) goto L_0x00cd
            boolean r16 = r2.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x00cd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00cd:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cf:
            r3 = r3 | r16
            goto L_0x00d4
        L_0x00d2:
            r0 = r42
        L_0x00d4:
            r13 = r11 & 128(0x80, float:1.794E-43)
            r34 = 12582912(0xc00000, float:1.7632415E-38)
            if (r13 == 0) goto L_0x00dd
            r3 = r3 | r34
            goto L_0x00f3
        L_0x00dd:
            r16 = r10 & r34
            if (r16 != 0) goto L_0x00f3
            r16 = r13
            r13 = r43
            boolean r17 = r2.changed((float) r13)
            if (r17 == 0) goto L_0x00ee
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f0
        L_0x00ee:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f0:
            r3 = r3 | r17
            goto L_0x00f7
        L_0x00f3:
            r16 = r13
            r13 = r43
        L_0x00f7:
            r13 = r11 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r13 == 0) goto L_0x0100
            r3 = r3 | r17
            goto L_0x0116
        L_0x0100:
            r17 = r10 & r17
            if (r17 != 0) goto L_0x0116
            r17 = r13
            r13 = r44
            boolean r18 = r2.changed((float) r13)
            if (r18 == 0) goto L_0x0111
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0111:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0113:
            r3 = r3 | r18
            goto L_0x011a
        L_0x0116:
            r17 = r13
            r13 = r44
        L_0x011a:
            r18 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r3 & r18
            r31 = r2
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x013d
            boolean r0 = r31.getSkipping()
            if (r0 != 0) goto L_0x012d
            goto L_0x013d
        L_0x012d:
            r31.skipToGroupEnd()
            r8 = r43
            r2 = r5
            r3 = r7
            r4 = r9
            r9 = r13
            r6 = r15
            r5 = r40
            r7 = r42
            goto L_0x02ed
        L_0x013d:
            r31.startDefaults()
            r0 = r10 & 1
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r35 = 0
            if (r0 == 0) goto L_0x0165
            boolean r0 = r31.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0150
            goto L_0x0165
        L_0x0150:
            r31.skipToGroupEnd()
            r0 = r11 & 64
            if (r0 == 0) goto L_0x0158
            r3 = r3 & r2
        L_0x0158:
            r0 = r40
            r2 = r42
            r18 = r43
            r19 = r13
            r4 = r15
            r13 = r31
            goto L_0x01ce
        L_0x0165:
            if (r4 == 0) goto L_0x016c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x016c:
            if (r6 == 0) goto L_0x0170
            r7 = r35
        L_0x0170:
            if (r8 == 0) goto L_0x0174
            r9 = r35
        L_0x0174:
            if (r12 == 0) goto L_0x0179
            r0 = r35
            goto L_0x017b
        L_0x0179:
            r0 = r40
        L_0x017b:
            if (r14 == 0) goto L_0x0180
            r4 = r35
            goto L_0x0181
        L_0x0180:
            r4 = r15
        L_0x0181:
            r6 = r11 & 64
            if (r6 == 0) goto L_0x01a9
            androidx.compose.material3.ListItemDefaults r12 = androidx.compose.material3.ListItemDefaults.INSTANCE
            r32 = 805306368(0x30000000, float:4.656613E-10)
            r33 = 511(0x1ff, float:7.16E-43)
            r13 = 0
            r6 = r16
            r15 = 0
            r8 = r17
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            androidx.compose.material3.ListItemColors r12 = r12.m2167colorsJ08w3E(r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r32, r33)
            r13 = r31
            r3 = r3 & r2
            goto L_0x01b1
        L_0x01a9:
            r6 = r16
            r8 = r17
            r13 = r31
            r12 = r42
        L_0x01b1:
            if (r6 == 0) goto L_0x01ba
            androidx.compose.material3.ListItemDefaults r2 = androidx.compose.material3.ListItemDefaults.INSTANCE
            float r2 = r2.m2168getElevationD9Ej5fM()
            goto L_0x01bc
        L_0x01ba:
            r2 = r43
        L_0x01bc:
            if (r8 == 0) goto L_0x01c9
            androidx.compose.material3.ListItemDefaults r6 = androidx.compose.material3.ListItemDefaults.INSTANCE
            float r6 = r6.m2168getElevationD9Ej5fM()
            r18 = r2
            r19 = r6
            goto L_0x01cd
        L_0x01c9:
            r19 = r44
            r18 = r2
        L_0x01cd:
            r2 = r12
        L_0x01ce:
            r13.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x01e0
            r6 = -1
            java.lang.String r8 = "androidx.compose.material3.ListItem (ListItem.kt:103)"
            r12 = -1647707763(0xffffffff9dc9f98d, float:-5.3462286E-21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r3, r6, r8)
        L_0x01e0:
            androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1 r6 = new androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
            r6.<init>(r2, r1)
            r8 = -403249643(0xffffffffe7f6e615, float:-2.3318928E24)
            r12 = 1
            r14 = 54
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r8, r12, r6, r13, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r8 = 1640970492(0x61cf38fc, float:4.7782277E20)
            r13.startReplaceGroup(r8)
            java.lang.String r8 = "*113@5021L204"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r8)
            if (r9 != 0) goto L_0x0201
            r8 = r35
            goto L_0x020f
        L_0x0201:
            androidx.compose.material3.ListItemKt$ListItem$decoratedSupportingContent$1$1 r8 = new androidx.compose.material3.ListItemKt$ListItem$decoratedSupportingContent$1$1
            r8.<init>(r2, r9)
            r15 = -1020860251(0xffffffffc326e8a5, float:-166.90877)
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r15, r12, r8, r13, r14)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
        L_0x020f:
            r13.endReplaceGroup()
            r15 = 1640980724(0x61cf60f4, float:4.7818278E20)
            r13.startReplaceGroup(r15)
            java.lang.String r15 = "*123@5341L196"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r15)
            if (r7 != 0) goto L_0x0222
            r1 = r35
            goto L_0x0230
        L_0x0222:
            androidx.compose.material3.ListItemKt$ListItem$decoratedOverlineContent$1$1 r15 = new androidx.compose.material3.ListItemKt$ListItem$decoratedOverlineContent$1$1
            r15.<init>(r2, r7)
            r1 = -764441232(0xffffffffd26f8d70, float:-2.57217528E11)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r1, r12, r15, r13, r14)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
        L_0x0230:
            r13.endReplaceGroup()
            r15 = 1640990750(0x61cf881e, float:4.7853554E20)
            r13.startReplaceGroup(r15)
            java.lang.String r15 = "*133@5651L302"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r15)
            if (r0 != 0) goto L_0x0245
            r43 = r0
            r0 = r35
            goto L_0x0255
        L_0x0245:
            androidx.compose.material3.ListItemKt$ListItem$decoratedLeadingContent$1$1 r15 = new androidx.compose.material3.ListItemKt$ListItem$decoratedLeadingContent$1$1
            r15.<init>(r2, r0)
            r43 = r0
            r0 = 1400509200(0x537a1310, float:1.07406164E12)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r12, r15, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
        L_0x0255:
            r13.endReplaceGroup()
            r15 = 1641004177(0x61cfbc91, float:4.7900796E20)
            r13.startReplaceGroup(r15)
            java.lang.String r15 = "*144@6069L353"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r15)
            if (r4 != 0) goto L_0x0268
            r38 = r0
            goto L_0x027a
        L_0x0268:
            androidx.compose.material3.ListItemKt$ListItem$decoratedTrailingContent$1$1 r15 = new androidx.compose.material3.ListItemKt$ListItem$decoratedTrailingContent$1$1
            r15.<init>(r2, r4)
            r38 = r0
            r0 = 1512306332(0x5a23f69c, float:1.15378928E16)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r12, r15, r13, r14)
            r35 = r0
            kotlin.jvm.functions.Function2 r35 = (kotlin.jvm.functions.Function2) r35
        L_0x027a:
            r13.endReplaceGroup()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material3.ListItemKt$ListItem$1 r15 = androidx.compose.material3.ListItemKt$ListItem$1.INSTANCE
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r0, r12, r15)
            androidx.compose.ui.Modifier r0 = r0.then(r5)
            androidx.compose.material3.ListItemDefaults r15 = androidx.compose.material3.ListItemDefaults.INSTANCE
            r14 = 6
            androidx.compose.ui.graphics.Shape r14 = r15.getShape(r13, r14)
            r16 = r14
            long r14 = r2.m2152containerColor0d7_KjU$material3_release()
            r20 = r16
            long r16 = r2.m2162headlineColorvNxB06k$material3_release(r12)
            androidx.compose.material3.ListItemKt$ListItem$2 r21 = new androidx.compose.material3.ListItemKt$ListItem$2
            r41 = r1
            r40 = r6
            r42 = r8
            r37 = r21
            r39 = r35
            r37.<init>(r38, r39, r40, r41, r42)
            r1 = r37
            r6 = 1502590376(0x598fb5a8, float:5.0563319E15)
            r8 = 54
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r12, r1, r13, r8)
            r21 = r1
            kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
            int r1 = r3 >> 9
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r1
            r3 = r3 | r34
            r6 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r6
            r23 = r3 | r1
            r24 = 64
            r31 = r13
            r13 = r20
            r20 = 0
            r12 = r0
            r22 = r31
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r12, r13, r14, r16, r18, r19, r20, r21, r22, r23, r24)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02e2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e2:
            r6 = r4
            r3 = r7
            r4 = r9
            r8 = r18
            r9 = r19
            r7 = r2
            r2 = r5
            r5 = r43
        L_0x02ed:
            androidx.compose.runtime.ScopeUpdateScope r12 = r31.endRestartGroup()
            if (r12 == 0) goto L_0x02ff
            androidx.compose.material3.ListItemKt$ListItem$3 r0 = new androidx.compose.material3.ListItemKt$ListItem$3
            r1 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x02ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ListItemKt.m2169ListItemHXNGIdc(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.ListItemColors, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void ListItemLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2052297037);
        ComposerKt.sourceInformation(startRestartGroup, "C(ListItemLayout)P(1,4)181@7324L36,182@7365L261:ListItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 16384 : 8192;
        }
        if ((i2 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2052297037, i2, -1, "androidx.compose.material3.ListItemLayout (ListItem.kt:180)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -748109790, "CC(remember):ListItem.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ListItemMeasurePolicy();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ListItemMeasurePolicy listItemMeasurePolicy = (ListItemMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Function2[] function2Arr = new Function2[5];
            function2Arr[0] = function23;
            function2Arr[1] = function24 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1923getLambda1$material3_release() : function24;
            function2Arr[2] = function25 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1924getLambda2$material3_release() : function25;
            function2Arr[3] = function2 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1925getLambda3$material3_release() : function2;
            function2Arr[4] = function22 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1926getLambda4$material3_release() : function22;
            List listOf = CollectionsKt.listOf(function2Arr);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
            Modifier modifier = Modifier.Companion;
            Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -290761997, "CC(remember):Layout.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(listItemMeasurePolicy);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r6 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r6, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r6, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            combineAsVirtualLayouts.invoke(startRestartGroup, 0);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$ListItemLayout$1(function2, function22, function23, function24, function25, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-yeHjK3Y  reason: not valid java name */
    public static final int m2176calculateWidthyeHjK3Y(IntrinsicMeasureScope intrinsicMeasureScope, int i, int i2, int i3, int i4, int i5, int i6, long j) {
        if (Constraints.m7048getHasBoundedWidthimpl(j)) {
            return Constraints.m7052getMaxWidthimpl(j);
        }
        return i6 + i + Math.max(i3, Math.max(i4, i5)) + i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-N4Jib3Y  reason: not valid java name */
    public static final int m2175calculateHeightN4Jib3Y(IntrinsicMeasureScope intrinsicMeasureScope, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        float f;
        if (ListItemType.m2183equalsimpl0(i6, ListItemType.Companion.m2188getOneLineAlXitO8())) {
            f = ListTokens.INSTANCE.m3333getListItemOneLineContainerHeightD9Ej5fM();
        } else if (ListItemType.m2183equalsimpl0(i6, ListItemType.Companion.m2190getTwoLineAlXitO8())) {
            f = ListTokens.INSTANCE.m3338getListItemTwoLineContainerHeightD9Ej5fM();
        } else {
            f = ListTokens.INSTANCE.m3335getListItemThreeLineContainerHeightD9Ej5fM();
        }
        return RangesKt.coerceAtMost(Math.max(Math.max(Constraints.m7053getMinHeightimpl(j), intrinsicMeasureScope.m7086roundToPx0680j_4(f)), i7 + Math.max(i, Math.max(i3 + i4 + i5, i2))), Constraints.m7051getMaxHeightimpl(j));
    }

    /* access modifiers changed from: private */
    public static final MeasureResult place(MeasureScope measureScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z, int i3, int i4, int i5) {
        Placeable placeable6 = placeable;
        return MeasureScope.layout$default(measureScope, i, i2, (Map) null, new ListItemKt$place$1(placeable6, placeable2, i3, z, i5, placeable3, placeable4, placeable5, i2, i, i4), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: ProvideTextStyleFromToken-3J-VO9M  reason: not valid java name */
    public static final void m2170ProvideTextStyleFromToken3JVO9M(long j, TypographyKeyTokens typographyKeyTokens, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        long j2;
        Composer startRestartGroup = composer.startRestartGroup(1133967795);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyleFromToken)P(0:c#ui.graphics.Color,2)659@26906L5,657@26816L128:ListItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) typographyKeyTokens) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133967795, i2, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:657)");
            }
            j2 = j;
            Function2<? super Composer, ? super Integer, Unit> function23 = function2;
            ProvideContentColorTextStyleKt.m2920ProvideContentColorTextStyle3JVO9M(j2, TypographyKt.getValue(typographyKeyTokens, startRestartGroup, (i2 >> 3) & 14), function23, startRestartGroup, i2 & 910);
            function22 = function23;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            j2 = j;
            function22 = function2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$ProvideTextStyleFromToken$1(j2, typographyKeyTokens, function22, i));
        }
    }

    public static final float getListItemVerticalPadding() {
        return ListItemVerticalPadding;
    }

    public static final float getListItemThreeLineVerticalPadding() {
        return ListItemThreeLineVerticalPadding;
    }

    public static final float getListItemStartPadding() {
        return ListItemStartPadding;
    }

    public static final float getListItemEndPadding() {
        return ListItemEndPadding;
    }

    public static final float getLeadingContentEndPadding() {
        return LeadingContentEndPadding;
    }

    public static final float getTrailingContentStartPadding() {
        return TrailingContentStartPadding;
    }

    /* access modifiers changed from: private */
    public static final boolean isSupportingMultilineHeuristic(Density density, int i) {
        return i > density.m7085roundToPxR2X_6o(TextUnitKt.getSp(30));
    }

    /* access modifiers changed from: private */
    /* renamed from: verticalPadding-yh95HIg  reason: not valid java name */
    public static final float m2177verticalPaddingyh95HIg(int i) {
        if (ListItemType.m2183equalsimpl0(i, ListItemType.Companion.m2189getThreeLineAlXitO8())) {
            return ListItemThreeLineVerticalPadding;
        }
        return ListItemVerticalPadding;
    }

    static {
        float f = (float) 16;
        ListItemStartPadding = Dp.m7111constructorimpl(f);
        ListItemEndPadding = Dp.m7111constructorimpl(f);
        LeadingContentEndPadding = Dp.m7111constructorimpl(f);
        TrailingContentStartPadding = Dp.m7111constructorimpl(f);
    }
}
