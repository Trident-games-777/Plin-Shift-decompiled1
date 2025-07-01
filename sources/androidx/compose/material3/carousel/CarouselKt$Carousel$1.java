package androidx.compose.material3.carousel;

import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/pager/PagerScope;", "page", "", "invoke", "(Landroidx/compose/foundation/pager/PagerScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Carousel.kt */
final class CarouselKt$Carousel$1 extends Lambda implements Function4<PagerScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ Function4<CarouselItemScope, Integer, Composer, Integer, Unit> $content;
    final /* synthetic */ CarouselPageSize $pageSize;
    final /* synthetic */ CarouselState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CarouselKt$Carousel$1(CarouselState carouselState, CarouselPageSize carouselPageSize, Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        super(4);
        this.$state = carouselState;
        this.$pageSize = carouselPageSize;
        this.$content = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((PagerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.pager.PagerScope r9, int r10, androidx.compose.runtime.Composer r11, int r12) {
        /*
            r8 = this;
            java.lang.String r9 = "C267@12634L35,268@12694L63,269@12786L389,286@13376L21,281@13189L404:Carousel.kt#dcf9yb"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0014
            r9 = -1
            java.lang.String r0 = "androidx.compose.material3.carousel.Carousel.<anonymous> (Carousel.kt:267)"
            r1 = 687111200(0x28f47c20, float:2.7143272E-14)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r12, r9, r0)
        L_0x0014:
            r9 = -685906675(0xffffffffd71de50d, float:-1.73607091E14)
            java.lang.String r0 = "CC(remember):Carousel.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r9, r0)
            java.lang.Object r9 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r9 != r1) goto L_0x0030
            androidx.compose.material3.carousel.CarouselItemInfoImpl r9 = new androidx.compose.material3.carousel.CarouselItemInfoImpl
            r9.<init>()
            r11.updateRememberedValue(r9)
        L_0x0030:
            r5 = r9
            androidx.compose.material3.carousel.CarouselItemInfoImpl r5 = (androidx.compose.material3.carousel.CarouselItemInfoImpl) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r9 = -685904727(0xffffffffd71deca9, float:-1.73639773E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r9, r0)
            java.lang.Object r9 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r9 != r1) goto L_0x0053
            androidx.compose.material3.carousel.CarouselItemScopeImpl r9 = new androidx.compose.material3.carousel.CarouselItemScopeImpl
            r1 = r5
            androidx.compose.material3.carousel.CarouselItemInfo r1 = (androidx.compose.material3.carousel.CarouselItemInfo) r1
            r9.<init>(r1)
            r11.updateRememberedValue(r9)
        L_0x0053:
            androidx.compose.material3.carousel.CarouselItemScopeImpl r9 = (androidx.compose.material3.carousel.CarouselItemScopeImpl) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r1 = -685901457(0xffffffffd71df96f, float:-1.73694635E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r0)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0072
            androidx.compose.material3.carousel.CarouselKt$Carousel$1$clipShape$1$1 r1 = new androidx.compose.material3.carousel.CarouselKt$Carousel$1$clipShape$1$1
            r1.<init>(r5)
            r11.updateRememberedValue(r1)
        L_0x0072:
            androidx.compose.material3.carousel.CarouselKt$Carousel$1$clipShape$1$1 r1 = (androidx.compose.material3.carousel.CarouselKt$Carousel$1$clipShape$1$1) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.material3.carousel.CarouselState r3 = r8.$state
            r4 = -685882945(0xffffffffd71e41bf, float:-1.74005215E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r0)
            androidx.compose.material3.carousel.CarouselPageSize r0 = r8.$pageSize
            boolean r0 = r11.changed((java.lang.Object) r0)
            androidx.compose.material3.carousel.CarouselPageSize r4 = r8.$pageSize
            java.lang.Object r6 = r11.rememberedValue()
            if (r0 != 0) goto L_0x0099
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r6 != r0) goto L_0x00a4
        L_0x0099:
            androidx.compose.material3.carousel.CarouselKt$Carousel$1$1$1 r0 = new androidx.compose.material3.carousel.CarouselKt$Carousel$1$1$1
            r0.<init>(r4)
            r6 = r0
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r11.updateRememberedValue(r6)
        L_0x00a4:
            r4 = r6
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r6 = r1
            androidx.compose.ui.graphics.Shape r6 = (androidx.compose.ui.graphics.Shape) r6
            r1 = r2
            r2 = r10
            androidx.compose.ui.Modifier r10 = androidx.compose.material3.carousel.CarouselKt.carouselItem(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function4<androidx.compose.material3.carousel.CarouselItemScope, java.lang.Integer, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r0 = r8.$content
            r1 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r3)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r3 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r1, r3)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r5 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r5)
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r3)
            androidx.compose.runtime.CompositionLocalMap r4 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r10 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r11, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            r6 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r7 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r6, r7)
            androidx.compose.runtime.Applier r6 = r11.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x00f5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00f5:
            r11.startReusableNode()
            boolean r6 = r11.getInserting()
            if (r6 == 0) goto L_0x0102
            r11.createNode(r5)
            goto L_0x0105
        L_0x0102:
            r11.useNode()
        L_0x0105:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3675constructorimpl(r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r4 = r5.getInserting()
            if (r4 != 0) goto L_0x0135
            java.lang.Object r4 = r5.rememberedValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x0143
        L_0x0135:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r5.updateRememberedValue(r4)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5.apply(r3, r1)
        L_0x0143:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r10, r1)
            r10 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r1 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r10, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r10 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r10 = (androidx.compose.foundation.layout.BoxScope) r10
            r10 = 1112607687(0x42510bc7, float:52.2615)
            java.lang.String r1 = "C291@13566L13:Carousel.kt#dcf9yb"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r10, r1)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r0.invoke(r9, r10, r11, r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r11.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0188
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0188:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt$Carousel$1.invoke(androidx.compose.foundation.pager.PagerScope, int, androidx.compose.runtime.Composer, int):void");
    }
}
