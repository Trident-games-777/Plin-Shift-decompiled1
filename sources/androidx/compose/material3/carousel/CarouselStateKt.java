package androidx.compose.material3.carousel;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"rememberCarouselState", "Landroidx/compose/material3/carousel/CarouselState;", "initialItem", "", "itemCount", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/carousel/CarouselState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CarouselState.kt */
public final class CarouselStateKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.carousel.CarouselState rememberCarouselState(int r11, kotlin.jvm.functions.Function0<java.lang.Integer> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            java.lang.String r0 = "C(rememberCarouselState)*103@3725L181,103@3679L227:CarouselState.kt#dcf9yb"
            r1 = -217285684(0xfffffffff30c7bcc, float:-1.1130256E31)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r0)
            r0 = 1
            r15 = r15 & r0
            r2 = 0
            if (r15 == 0) goto L_0x000e
            r11 = r2
        L_0x000e:
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x001a
            r15 = -1
            java.lang.String r3 = "androidx.compose.material3.carousel.rememberCarouselState (CarouselState.kt:102)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r14, r15, r3)
        L_0x001a:
            java.lang.Object[] r4 = new java.lang.Object[r2]
            androidx.compose.material3.carousel.CarouselState$Companion r15 = androidx.compose.material3.carousel.CarouselState.Companion
            androidx.compose.runtime.saveable.Saver r5 = r15.getSaver()
            r15 = -1536566770(0xffffffffa469da0e, float:-5.070852E-17)
            java.lang.String r1 = "CC(remember):CarouselState.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r15, r1)
            r15 = r14 & 14
            r15 = r15 ^ 6
            r1 = 4
            if (r15 <= r1) goto L_0x0037
            boolean r15 = r13.changed((int) r11)
            if (r15 != 0) goto L_0x003b
        L_0x0037:
            r15 = r14 & 6
            if (r15 != r1) goto L_0x003d
        L_0x003b:
            r15 = r0
            goto L_0x003e
        L_0x003d:
            r15 = r2
        L_0x003e:
            r1 = r14 & 112(0x70, float:1.57E-43)
            r1 = r1 ^ 48
            r3 = 32
            if (r1 <= r3) goto L_0x004c
            boolean r1 = r13.changed((java.lang.Object) r12)
            if (r1 != 0) goto L_0x0052
        L_0x004c:
            r14 = r14 & 48
            if (r14 != r3) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r0 = r2
        L_0x0052:
            r14 = r15 | r0
            java.lang.Object r15 = r13.rememberedValue()
            if (r14 != 0) goto L_0x0062
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r15 != r14) goto L_0x006d
        L_0x0062:
            androidx.compose.material3.carousel.CarouselStateKt$rememberCarouselState$1$1 r14 = new androidx.compose.material3.carousel.CarouselStateKt$rememberCarouselState$1$1
            r14.<init>(r11, r12)
            r15 = r14
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r13.updateRememberedValue(r15)
        L_0x006d:
            r7 = r15
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r9 = 0
            r10 = 4
            r6 = 0
            r8 = r13
            java.lang.Object r11 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r4, r5, (java.lang.String) r6, r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            androidx.compose.material3.carousel.CarouselState r11 = (androidx.compose.material3.carousel.CarouselState) r11
            androidx.compose.runtime.MutableState r13 = r11.getItemCountState()
            r13.setValue(r12)
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x008d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x008d:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselStateKt.rememberCarouselState(int, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.carousel.CarouselState");
    }
}
