package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0001H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "T", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
final class SharedTransitionScopeImpl$sharedBoundsImpl$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ BoundsTransform $boundsTransform;
    final /* synthetic */ SharedTransitionScope.OverlayClip $clipInOverlayDuringTransition;
    final /* synthetic */ Transition<T> $parentTransition;
    final /* synthetic */ SharedTransitionScope.PlaceHolderSize $placeHolderSize;
    final /* synthetic */ boolean $renderInOverlayDuringTransition;
    final /* synthetic */ boolean $renderOnlyWhenVisible;
    final /* synthetic */ SharedTransitionScope.SharedContentState $sharedContentState;
    final /* synthetic */ Function1<T, Boolean> $visible;
    final /* synthetic */ float $zIndexInOverlay;
    final /* synthetic */ SharedTransitionScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedTransitionScopeImpl$sharedBoundsImpl$1(SharedTransitionScope.SharedContentState sharedContentState, Transition<T> transition, Function1<? super T, Boolean> function1, SharedTransitionScopeImpl sharedTransitionScopeImpl, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z, SharedTransitionScope.OverlayClip overlayClip, float f, boolean z2, BoundsTransform boundsTransform) {
        super(3);
        this.$sharedContentState = sharedContentState;
        this.$parentTransition = transition;
        this.$visible = function1;
        this.this$0 = sharedTransitionScopeImpl;
        this.$placeHolderSize = placeHolderSize;
        this.$renderOnlyWhenVisible = z;
        this.$clipInOverlayDuringTransition = overlayClip;
        this.$zIndexInOverlay = f;
        this.$renderInOverlayDuringTransition = z2;
        this.$boundsTransform = boundsTransform;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: androidx.compose.animation.BoundsAnimation} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r14, androidx.compose.runtime.Composer r15, int r16) {
        /*
            r13 = this;
            r3 = r15
            r0 = -1843478929(0xffffffff921ebe6f, float:-5.0090737E-28)
            r15.startReplaceGroup(r0)
            java.lang.String r1 = "C:SharedTransitionScope.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r4 = -1
            if (r2 == 0) goto L_0x001a
            java.lang.String r2 = "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous> (SharedTransitionScope.kt:968)"
            r5 = r16
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r4, r2)
        L_0x001a:
            androidx.compose.animation.SharedTransitionScope$SharedContentState r0 = r13.$sharedContentState
            java.lang.Object r0 = r0.getKey()
            r2 = -359675295(0xffffffffea8fca61, float:-8.691605E25)
            r15.startMovableGroup(r2, r0)
            java.lang.String r2 = "970@51556L35,1006@53390L522"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = -359676293(0xffffffffea8fc67b, float:-8.6906845E25)
            java.lang.String r6 = "CC(remember):SharedTransitionScope.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r2, r6)
            androidx.compose.animation.SharedTransitionScopeImpl r2 = r13.this$0
            java.lang.Object r5 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r5 != r7) goto L_0x0048
            androidx.compose.animation.SharedElement r5 = r2.sharedElementsFor(r0)
            r15.updateRememberedValue(r5)
        L_0x0048:
            r7 = r5
            androidx.compose.animation.SharedElement r7 = (androidx.compose.animation.SharedElement) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r2 = -359672306(0xffffffffea8fd60e, float:-8.694362E25)
            androidx.compose.animation.core.Transition<T> r5 = r13.$parentTransition
            r15.startMovableGroup(r2, r5)
            java.lang.String r2 = "*997@53029L278"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            androidx.compose.animation.core.Transition<T> r2 = r13.$parentTransition
            r5 = 0
            r8 = 1
            if (r2 == 0) goto L_0x0117
            r2 = 1735101820(0x676b8d7c, float:1.11236605E24)
            r15.startReplaceGroup(r2)
            java.lang.String r2 = "974@51759L53"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r0
            androidx.compose.animation.core.Transition<T> r0 = r13.$parentTransition
            java.lang.String r2 = r2.toString()
            kotlin.jvm.functions.Function1<T, java.lang.Boolean> r8 = r13.$visible
            r9 = 1215497572(0x48730564, float:248853.56)
            java.lang.String r10 = "CC(createChildTransition)1813@74138L36,1814@74198L74,1815@74295L39,1816@74346L63:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r9, r10)
            r9 = 272027253(0x1036ce75, float:3.605222E-29)
            java.lang.String r10 = "CC(remember):Transition.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r9, r10)
            boolean r9 = r15.changed((java.lang.Object) r0)
            java.lang.Object r10 = r15.rememberedValue()
            if (r9 != 0) goto L_0x0097
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x009e
        L_0x0097:
            java.lang.Object r10 = r0.getCurrentState()
            r15.updateRememberedValue(r10)
        L_0x009e:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            boolean r9 = r0.isSeeking()
            if (r9 == 0) goto L_0x00ab
            java.lang.Object r10 = r0.getCurrentState()
        L_0x00ab:
            r9 = 1329676753(0x4f4141d1, float:3.24231603E9)
            r15.startReplaceGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r12 = "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharedTransitionScope.kt:974)"
            if (r11 == 0) goto L_0x00bf
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r5, r4, r12)
        L_0x00bf:
            java.lang.Object r10 = r8.invoke(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x00d2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00d2:
            r15.endReplaceGroup()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            java.lang.Object r11 = r0.getTargetState()
            r15.startReplaceGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00ec
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r5, r4, r12)
        L_0x00ec:
            java.lang.Object r1 = r8.invoke(r11)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x00ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ff:
            r15.endReplaceGroup()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r5 = 0
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r10
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(r0, r1, r2, r3, r4, r5)
            r3 = r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r15.endReplaceGroup()
            goto L_0x017d
        L_0x0117:
            r0 = 1735245009(0x676dbcd1, float:1.1226839E24)
            r15.startReplaceGroup(r0)
            java.lang.String r0 = "*979@52034L707,992@52800L35"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            kotlin.jvm.functions.Function1<T, java.lang.Boolean> r0 = r13.$visible
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Function1<kotlin.Unit, kotlin.Boolean>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.lang.Object r0 = kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, r8)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = -359660325(0xffffffffea9004db, float:-8.705412E25)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r1, r6)
            java.lang.Object r1 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0164
            androidx.compose.animation.core.MutableTransitionState r1 = new androidx.compose.animation.core.MutableTransitionState
            androidx.compose.ui.geometry.Rect r2 = r7.getCurrentBounds()
            if (r2 == 0) goto L_0x0159
            if (r0 != 0) goto L_0x015a
            r5 = r8
            goto L_0x015a
        L_0x0159:
            r5 = r0
        L_0x015a:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)
            r1.<init>(r2)
            r15.updateRememberedValue(r1)
        L_0x0164:
            androidx.compose.animation.core.MutableTransitionState r1 = (androidx.compose.animation.core.MutableTransitionState) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.setTargetState$animation_core_release(r0)
            androidx.compose.animation.core.TransitionState r1 = (androidx.compose.animation.core.TransitionState) r1
            int r0 = androidx.compose.animation.core.MutableTransitionState.$stable
            r2 = 2
            r4 = 0
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.rememberTransition(r1, r4, r15, r0, r2)
            r15.endReplaceGroup()
        L_0x017d:
            androidx.compose.animation.SharedTransitionScopeImpl r1 = r13.this$0
            boolean r1 = r1.isTransitionActive()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2 = -359633642(0xffffffffea906d16, float:-8.730023E25)
            r15.startMovableGroup(r2, r1)
            java.lang.String r1 = "995@52949L45"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            androidx.compose.ui.geometry.Rect$Companion r1 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.animation.core.TwoWayConverter r1 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.geometry.Rect.Companion) r1)
            r4 = 0
            r5 = 2
            r2 = 0
            androidx.compose.animation.core.Transition$DeferredAnimation r1 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r0, r1, r2, r3, r4, r5)
            r15.endMovableGroup()
            r2 = -359628914(0xffffffffea907f8e, float:-8.734384E25)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r2, r6)
            boolean r2 = r15.changed((java.lang.Object) r0)
            androidx.compose.animation.SharedTransitionScopeImpl r4 = r13.this$0
            androidx.compose.animation.BoundsTransform r5 = r13.$boundsTransform
            java.lang.Object r6 = r15.rememberedValue()
            if (r2 != 0) goto L_0x01be
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r6 != r2) goto L_0x01c8
        L_0x01be:
            androidx.compose.animation.BoundsAnimation r6 = new androidx.compose.animation.BoundsAnimation
            androidx.compose.animation.SharedTransitionScope r4 = (androidx.compose.animation.SharedTransitionScope) r4
            r6.<init>(r4, r0, r1, r5)
            r15.updateRememberedValue(r6)
        L_0x01c8:
            r2 = r6
            androidx.compose.animation.BoundsAnimation r2 = (androidx.compose.animation.BoundsAnimation) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.animation.BoundsTransform r0 = r13.$boundsTransform
            r2.updateAnimation(r1, r0)
            r15.endMovableGroup()
            androidx.compose.animation.SharedTransitionScopeImpl r0 = r13.this$0
            androidx.compose.animation.SharedTransitionScope$PlaceHolderSize r3 = r13.$placeHolderSize
            boolean r4 = r13.$renderOnlyWhenVisible
            androidx.compose.animation.SharedTransitionScope$SharedContentState r5 = r13.$sharedContentState
            androidx.compose.animation.SharedTransitionScope$OverlayClip r6 = r13.$clipInOverlayDuringTransition
            r1 = r7
            float r7 = r13.$zIndexInOverlay
            boolean r8 = r13.$renderInOverlayDuringTransition
            r10 = 0
            r9 = r15
            androidx.compose.animation.SharedElementInternalState r0 = r0.rememberSharedElementState(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r15.endMovableGroup()
            androidx.compose.animation.SharedBoundsNodeElement r1 = new androidx.compose.animation.SharedBoundsNodeElement
            r1.<init>(r0)
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r0 = r14.then(r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0202
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0202:
            r15.endReplaceGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.SharedTransitionScopeImpl$sharedBoundsImpl$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
