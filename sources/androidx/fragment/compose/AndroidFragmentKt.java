package androidx.fragment.compose;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\n\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000bH\b¢\u0006\u0002\u0010\f\u001aY\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"AndroidFragment", "", "T", "Landroidx/fragment/app/Fragment;", "modifier", "Landroidx/compose/ui/Modifier;", "fragmentState", "Landroidx/fragment/compose/FragmentState;", "arguments", "Landroid/os/Bundle;", "onUpdate", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Landroidx/fragment/compose/FragmentState;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;Landroidx/compose/ui/Modifier;Landroidx/fragment/compose/FragmentState;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "fragment-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidFragment.kt */
public final class AndroidFragmentKt {
    public static final /* synthetic */ <T extends Fragment> void AndroidFragment(Modifier modifier, FragmentState fragmentState, Bundle bundle, Function1<? super T, Unit> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1765406104);
        ComposerKt.sourceInformation(composer, "CC(AndroidFragment)P(2,1)54@2199L23,58@2311L84:AndroidFragment.kt#dnbm1l");
        if ((i2 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        Modifier modifier2 = modifier;
        if ((i2 & 2) != 0) {
            fragmentState = FragmentStateKt.rememberFragmentState(composer, 0);
        }
        FragmentState fragmentState2 = fragmentState;
        if ((i2 & 4) != 0) {
            bundle = Bundle.EMPTY;
        }
        Bundle bundle2 = bundle;
        if ((i2 & 8) != 0) {
            Intrinsics.needClassReification();
            function1 = AndroidFragmentKt$AndroidFragment$1.INSTANCE;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Fragment> cls = Fragment.class;
        Class cls2 = cls;
        Composer composer2 = composer;
        AndroidFragment(cls, modifier2, fragmentState2, bundle2, function1, composer2, (i << 3) & 65520, 0);
        composer2.endReplaceableGroup();
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends androidx.fragment.app.Fragment> void AndroidFragment(java.lang.Class<T> r18, androidx.compose.ui.Modifier r19, androidx.fragment.compose.FragmentState r20, android.os.Bundle r21, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r1 = r18
            r9 = r24
            r0 = -1012439764(0xffffffffc3a7652c, float:-334.7904)
            r2 = r23
            androidx.compose.runtime.Composer r5 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(AndroidFragment)P(1,3,2)81@3256L23,85@3380L30,86@3429L23,87@3478L7,88@3512L72,91@3616L7,92@3651L50,93@3706L49,95@3835L2822,95@3761L2896:AndroidFragment.kt#dnbm1l"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            r2 = r25 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r9 | 6
            goto L_0x0029
        L_0x0019:
            r2 = r9 & 6
            if (r2 != 0) goto L_0x0028
            boolean r2 = r5.changedInstance(r1)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            r2 = r2 | r9
            goto L_0x0029
        L_0x0028:
            r2 = r9
        L_0x0029:
            r3 = r25 & 2
            if (r3 == 0) goto L_0x0030
            r2 = r2 | 48
            goto L_0x0043
        L_0x0030:
            r4 = r9 & 48
            if (r4 != 0) goto L_0x0043
            r4 = r19
            boolean r6 = r5.changed((java.lang.Object) r4)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r2 = r2 | r6
            goto L_0x0045
        L_0x0043:
            r4 = r19
        L_0x0045:
            r6 = r9 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005e
            r6 = r25 & 4
            if (r6 != 0) goto L_0x0058
            r6 = r20
            boolean r7 = r5.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005a
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r6 = r20
        L_0x005a:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r2 = r2 | r7
            goto L_0x0060
        L_0x005e:
            r6 = r20
        L_0x0060:
            r7 = r9 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0079
            r7 = r25 & 8
            if (r7 != 0) goto L_0x0073
            r7 = r21
            boolean r10 = r5.changedInstance(r7)
            if (r10 == 0) goto L_0x0075
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0073:
            r7 = r21
        L_0x0075:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r2 = r2 | r10
            goto L_0x007b
        L_0x0079:
            r7 = r21
        L_0x007b:
            r10 = r25 & 16
            if (r10 == 0) goto L_0x0082
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0095
        L_0x0082:
            r11 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0095
            r11 = r22
            boolean r12 = r5.changedInstance(r11)
            if (r12 == 0) goto L_0x0091
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r2 = r2 | r12
            goto L_0x0097
        L_0x0095:
            r11 = r22
        L_0x0097:
            r12 = r2 & 9363(0x2493, float:1.312E-41)
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r13) goto L_0x00ae
            boolean r12 = r5.getSkipping()
            if (r12 != 0) goto L_0x00a4
            goto L_0x00ae
        L_0x00a4:
            r5.skipToGroupEnd()
            r2 = r4
            r9 = r5
            r5 = r11
        L_0x00aa:
            r3 = r6
            r4 = r7
            goto L_0x022f
        L_0x00ae:
            r5.startDefaults()
            r12 = r9 & 1
            r13 = 0
            if (r12 == 0) goto L_0x00d2
            boolean r12 = r5.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00bd
            goto L_0x00d2
        L_0x00bd:
            r5.skipToGroupEnd()
            r3 = r25 & 4
            if (r3 == 0) goto L_0x00c6
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c6:
            r3 = r25 & 8
            if (r3 == 0) goto L_0x00cc
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00cc:
            r14 = r2
            r3 = r4
            r10 = r6
            r12 = r11
            r11 = r7
            goto L_0x00ff
        L_0x00d2:
            if (r3 == 0) goto L_0x00d9
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00da
        L_0x00d9:
            r3 = r4
        L_0x00da:
            r4 = r25 & 4
            if (r4 == 0) goto L_0x00e5
            androidx.fragment.compose.FragmentState r4 = androidx.fragment.compose.FragmentStateKt.rememberFragmentState(r5, r13)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00e6
        L_0x00e5:
            r4 = r6
        L_0x00e6:
            r6 = r25 & 8
            if (r6 == 0) goto L_0x00ef
            android.os.Bundle r6 = android.os.Bundle.EMPTY
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x00f0
        L_0x00ef:
            r6 = r7
        L_0x00f0:
            if (r10 == 0) goto L_0x00fb
            androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$2 r7 = androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$2.INSTANCE
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r14 = r2
            r10 = r4
            r11 = r6
            r12 = r7
            goto L_0x00ff
        L_0x00fb:
            r14 = r2
            r10 = r4
            r12 = r11
            r11 = r6
        L_0x00ff:
            r5.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x010e
            r2 = -1
            java.lang.String r4 = "androidx.fragment.compose.AndroidFragment (AndroidFragment.kt:84)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r2, r4)
        L_0x010e:
            int r0 = r14 >> 12
            r0 = r0 & 14
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r12, r5, r0)
            int r15 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r13)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r6)
            java.lang.Object r2 = r5.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            android.view.View r2 = (android.view.View) r2
            r7 = 485393906(0x1cee85f2, float:1.5784143E-21)
            r5.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):AndroidFragment.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r7)
            boolean r16 = r5.changed((java.lang.Object) r2)
            java.lang.Object r13 = r5.rememberedValue()
            if (r16 != 0) goto L_0x014e
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r16.getEmpty()
            if (r13 != r8) goto L_0x0155
        L_0x014e:
            androidx.fragment.app.FragmentManager r13 = androidx.fragment.app.FragmentManager.findFragmentManager(r2)
            r5.updateRememberedValue(r13)
        L_0x0155:
            androidx.fragment.app.FragmentManager r13 = (androidx.fragment.app.FragmentManager) r13
            r5.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r6)
            java.lang.Object r2 = r5.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r8 = r2
            android.content.Context r8 = (android.content.Context) r8
            r2 = 485398332(0x1cee973c, float:1.5788612E-21)
            r5.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r7)
            java.lang.Object r2 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x018a
            androidx.fragment.compose.FragmentContainerViewFactory r2 = new androidx.fragment.compose.FragmentContainerViewFactory
            r2.<init>(r15)
            r5.updateRememberedValue(r2)
        L_0x018a:
            androidx.fragment.compose.FragmentContainerViewFactory r2 = (androidx.fragment.compose.FragmentContainerViewFactory) r2
            r5.endReplaceableGroup()
            r4 = r2
            r2 = r4
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r6 = r14 & 112(0x70, float:1.57E-43)
            r16 = r7
            r7 = 4
            r17 = r4
            r4 = 0
            r9 = r16
            r16 = r12
            r12 = r9
            r9 = r17
            androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(r2, r3, r4, r5, r6, r7)
            r17 = r3
            r2 = r5
            java.lang.Object[] r3 = new java.lang.Object[]{r13, r9, r1, r10}
            r4 = 485406992(0x1ceeb910, float:1.5797356E-21)
            r2.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            boolean r4 = r2.changedInstance(r13)
            boolean r5 = r2.changedInstance(r9)
            r4 = r4 | r5
            boolean r5 = r2.changedInstance(r8)
            r4 = r4 | r5
            boolean r5 = r2.changedInstance(r1)
            r4 = r4 | r5
            r5 = r14 & 896(0x380, float:1.256E-42)
            r5 = r5 ^ 384(0x180, float:5.38E-43)
            r6 = 256(0x100, float:3.59E-43)
            if (r5 <= r6) goto L_0x01d6
            boolean r5 = r2.changed((java.lang.Object) r10)
            if (r5 != 0) goto L_0x01da
        L_0x01d6:
            r5 = r14 & 384(0x180, float:5.38E-43)
            if (r5 != r6) goto L_0x01dc
        L_0x01da:
            r5 = 1
            goto L_0x01dd
        L_0x01dc:
            r5 = 0
        L_0x01dd:
            r4 = r4 | r5
            boolean r5 = r2.changedInstance(r11)
            r4 = r4 | r5
            boolean r5 = r2.changed((int) r15)
            r4 = r4 | r5
            boolean r5 = r2.changed((java.lang.Object) r0)
            r4 = r4 | r5
            java.lang.Object r5 = r2.rememberedValue()
            if (r4 != 0) goto L_0x0201
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x01fc
            goto L_0x0201
        L_0x01fc:
            r9 = r2
            r6 = r10
            r7 = r11
            r10 = r3
            goto L_0x0217
        L_0x0201:
            r5 = r0
            androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1 r0 = new androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$3$1
            r4 = r9
            r9 = r2
            r2 = r4
            r4 = r1
            r6 = r10
            r7 = r11
            r1 = r13
            r10 = r3
            r3 = r8
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r5 = r0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r9.updateRememberedValue(r5)
        L_0x0217:
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r9.endReplaceableGroup()
            r0 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object[]) r10, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r5, (androidx.compose.runtime.Composer) r9, (int) r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0229
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0229:
            r5 = r16
            r2 = r17
            goto L_0x00aa
        L_0x022f:
            androidx.compose.runtime.ScopeUpdateScope r8 = r9.endRestartGroup()
            if (r8 == 0) goto L_0x0245
            androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$4 r0 = new androidx.fragment.compose.AndroidFragmentKt$AndroidFragment$4
            r1 = r18
            r6 = r24
            r7 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x0245:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.compose.AndroidFragmentKt.AndroidFragment(java.lang.Class, androidx.compose.ui.Modifier, androidx.fragment.compose.FragmentState, android.os.Bundle, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
