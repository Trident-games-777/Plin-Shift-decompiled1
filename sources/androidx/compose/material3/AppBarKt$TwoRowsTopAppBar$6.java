package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TwoRowsTopAppBar$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $actionsRow;
    final /* synthetic */ float $bottomTitleAlpha;
    final /* synthetic */ float $collapsedHeight;
    final /* synthetic */ TopAppBarColors $colors;
    final /* synthetic */ float $expandedHeight;
    final /* synthetic */ boolean $hideBottomRowSemantics;
    final /* synthetic */ boolean $hideTopRowSemantics;
    final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;
    final /* synthetic */ Function2<Composer, Integer, Unit> $smallTitle;
    final /* synthetic */ TextStyle $smallTitleTextStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ Ref.IntRef $titleBottomPaddingPx;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ float $topTitleAlpha;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$TwoRowsTopAppBar$6(WindowInsets windowInsets, float f, TopAppBarColors topAppBarColors, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, float f2, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, float f3, TopAppBarScrollBehavior topAppBarScrollBehavior, Function2<? super Composer, ? super Integer, Unit> function24, TextStyle textStyle2, float f4, Ref.IntRef intRef, boolean z2) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$collapsedHeight = f;
        this.$colors = topAppBarColors;
        this.$smallTitle = function2;
        this.$smallTitleTextStyle = textStyle;
        this.$topTitleAlpha = f2;
        this.$hideTopRowSemantics = z;
        this.$navigationIcon = function22;
        this.$actionsRow = function23;
        this.$expandedHeight = f3;
        this.$scrollBehavior = topAppBarScrollBehavior;
        this.$title = function24;
        this.$titleTextStyle = textStyle2;
        this.$bottomTitleAlpha = f4;
        this.$titleBottomPaddingPx = intRef;
        this.$hideBottomRowSemantics = z2;
    }

    /* access modifiers changed from: private */
    public static final float invoke$lambda$3$lambda$0() {
        return 0.0f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.compose.material3.ScrolledOffset} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r35, int r36) {
        /*
            r34 = this;
            r0 = r34
            r1 = r35
            r2 = r36
            java.lang.String r3 = "C2043@93243L2293:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 3
            r4 = 2
            if (r3 != r4) goto L_0x001b
            boolean r3 = r1.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001b
        L_0x0017:
            r1.skipToGroupEnd()
            return
        L_0x001b:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002a
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:2043)"
            r5 = -1350062619(0xffffffffaf87ade5, float:-2.4679916E-10)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x002a:
            androidx.compose.foundation.layout.WindowInsets r2 = r0.$windowInsets
            float r3 = r0.$collapsedHeight
            androidx.compose.material3.TopAppBarColors r4 = r0.$colors
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r9 = r0.$smallTitle
            androidx.compose.ui.text.TextStyle r10 = r0.$smallTitleTextStyle
            float r11 = r0.$topTitleAlpha
            boolean r15 = r0.$hideTopRowSemantics
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$navigationIcon
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r6 = r0.$actionsRow
            float r7 = r0.$expandedHeight
            androidx.compose.material3.TopAppBarScrollBehavior r8 = r0.$scrollBehavior
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r12 = r0.$title
            androidx.compose.ui.text.TextStyle r13 = r0.$titleTextStyle
            float r14 = r0.$bottomTitleAlpha
            r16 = r14
            kotlin.jvm.internal.Ref$IntRef r14 = r0.$titleBottomPaddingPx
            r17 = r14
            boolean r14 = r0.$hideBottomRowSemantics
            r0 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r18 = r4
            java.lang.String r4 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r4)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.layout.Arrangement r4 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r4 = r4.getTop()
            androidx.compose.ui.Alignment$Companion r19 = androidx.compose.ui.Alignment.Companion
            r20 = r5
            androidx.compose.ui.Alignment$Horizontal r5 = r19.getStart()
            r19 = r6
            r6 = 0
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r4, r5, r1, r6)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r36 = r7
            java.lang.String r7 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r7)
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r6)
            androidx.compose.runtime.CompositionLocalMap r6 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r1, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            r21 = r5
            r5 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r22 = r8
            java.lang.String r8 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r8)
            androidx.compose.runtime.Applier r5 = r1.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x00a4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00a4:
            r1.startReusableNode()
            boolean r5 = r1.getInserting()
            if (r5 == 0) goto L_0x00b1
            r1.createNode(r7)
            goto L_0x00b4
        L_0x00b1:
            r1.useNode()
        L_0x00b4:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3675constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r4, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r6, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            boolean r6 = r5.getInserting()
            if (r6 != 0) goto L_0x00e4
            java.lang.Object r6 = r5.rememberedValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r21)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 != 0) goto L_0x00f2
        L_0x00e4:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r21)
            r5.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r21)
            r5.apply(r6, r4)
        L_0x00f2:
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r0, r4)
            r0 = -384862393(0xffffffffe90f7747, float:-1.0839979E25)
            java.lang.String r4 = "C87@4365L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r4)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r0 = 251887626(0xf03800a, float:6.483458E-30)
            java.lang.String r4 = "C2044@93264L1012,2073@94812L45,2064@94289L1237:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r4)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.windowInsetsPadding(r0, r2)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.ClipKt.clipToBounds(r0)
            r4 = 0
            r5 = 1
            r6 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m833heightInVpY3zN4$default(r0, r4, r3, r5, r6)
            r7 = r2
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$6$$ExternalSyntheticLambda0 r2 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$6$$ExternalSyntheticLambda0
            r2.<init>()
            r8 = r3
            r21 = r4
            long r3 = r18.m2862getNavigationIconContentColor0d7_KjU()
            r24 = r5
            r23 = r6
            long r5 = r18.m2864getTitleContentColor0d7_KjU()
            r25 = r7
            r26 = r8
            long r7 = r18.m2860getActionIconContentColor0d7_KjU()
            androidx.compose.foundation.layout.Arrangement r27 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r27 = r27.getCenter()
            androidx.compose.foundation.layout.Arrangement$Vertical r27 = (androidx.compose.foundation.layout.Arrangement.Vertical) r27
            androidx.compose.foundation.layout.Arrangement r28 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r28 = r28.getStart()
            r29 = r17
            r17 = r19
            r19 = 905969712(0x36000030, float:1.9073595E-6)
            r30 = r16
            r16 = r20
            r20 = 3078(0xc06, float:4.313E-42)
            r31 = r14
            r14 = 0
            r23 = r12
            r24 = r13
            r21 = r18
            r32 = r22
            r12 = r27
            r13 = r28
            r33 = r29
            r22 = r36
            r18 = r1
            r1 = r0
            r0 = r25
            androidx.compose.material3.AppBarKt.m1723TopAppBarLayoutkXwM9vE(r1, r2, r3, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r1 = r18
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.foundation.layout.WindowInsetsSides$Companion r3 = androidx.compose.foundation.layout.WindowInsetsSides.Companion
            int r3 = r3.m898getHorizontalJoeWqyM()
            androidx.compose.foundation.layout.WindowInsets r0 = androidx.compose.foundation.layout.WindowInsetsKt.m874onlybOOhFvg(r0, r3)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.windowInsetsPadding(r2, r0)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.ClipKt.clipToBounds(r0)
            float r7 = r22 - r26
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r7)
            r3 = 0
            r4 = 1
            r5 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m833heightInVpY3zN4$default(r0, r5, r2, r4, r3)
            r2 = 1947835376(0x74199bf0, float:4.8680677E31)
            java.lang.String r3 = "CC(remember):AppBar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r2, r3)
            r2 = r32
            boolean r3 = r1.changed((java.lang.Object) r2)
            java.lang.Object r4 = r1.rememberedValue()
            if (r3 != 0) goto L_0x01b6
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x01be
        L_0x01b6:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$6$$ExternalSyntheticLambda1 r4 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$6$$ExternalSyntheticLambda1
            r4.<init>(r2)
            r1.updateRememberedValue(r4)
        L_0x01be:
            r2 = r4
            androidx.compose.material3.ScrolledOffset r2 = (androidx.compose.material3.ScrolledOffset) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            long r3 = r21.m2862getNavigationIconContentColor0d7_KjU()
            long r5 = r21.m2864getTitleContentColor0d7_KjU()
            long r7 = r21.m2860getActionIconContentColor0d7_KjU()
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r12 = r9.getBottom()
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r13 = r9.getStart()
            r9 = r33
            int r14 = r9.element
            androidx.compose.material3.ComposableSingletons$AppBarKt r9 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r16 = r9.m1905getLambda17$material3_release()
            androidx.compose.material3.ComposableSingletons$AppBarKt r9 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r17 = r9.m1906getLambda18$material3_release()
            r19 = 905969664(0x36000000, float:1.9073486E-6)
            r20 = 3456(0xd80, float:4.843E-42)
            r18 = r1
            r9 = r23
            r10 = r24
            r11 = r30
            r15 = r31
            r1 = r0
            androidx.compose.material3.AppBarKt.m1723TopAppBarLayoutkXwM9vE(r1, r2, r3, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
            r35.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0219
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0219:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$6.invoke(androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final float invoke$lambda$3$lambda$2$lambda$1(TopAppBarScrollBehavior topAppBarScrollBehavior) {
        TopAppBarState state;
        if (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) {
            return 0.0f;
        }
        return state.getHeightOffset();
    }
}
