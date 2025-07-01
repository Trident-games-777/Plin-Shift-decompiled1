package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0007¢\u0006\u0002\u0010\u000b\u001a0\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a:\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001aD\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0017\u001aN\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0019\u001aH\u0010\f\u001a\u00020\u00042\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u001b\"\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001c\u001a6\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010\u001f\u001a0\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a:\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001aD\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0017\u001aN\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0019\u001aH\u0010 \u001a\u00020\u00042\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u001b\"\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001c\u001a6\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020!2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010$\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006%²\u0006\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0002"}, d2 = {"LifecycleResumeEffectNoParamError", "", "LifecycleStartEffectNoParamError", "LifecycleEventEffect", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onEvent", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle$Event;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LifecycleResumeEffect", "effects", "Lkotlin/Function1;", "Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;", "Landroidx/lifecycle/compose/LifecyclePauseOrDisposeEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key1", "", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "keys", "", "([Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LifecycleResumeEffectImpl", "scope", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LifecycleStartEffect", "Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;", "Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "LifecycleStartEffectImpl", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "lifecycle-runtime-compose_release", "currentOnEvent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LifecycleEffect.kt */
public final class LifecycleEffectKt {
    private static final String LifecycleResumeEffectNoParamError = "LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";
    private static final String LifecycleStartEffectNoParamError = "LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0075, code lost:
        if ((r12 & 2) != 0) goto L_0x0093;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LifecycleEventEffect(androidx.lifecycle.Lifecycle.Event r7, androidx.lifecycle.LifecycleOwner r8, kotlin.jvm.functions.Function0<kotlin.Unit> r9, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            r0 = -709389590(0xffffffffd5b792ea, float:-2.52302024E13)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            java.lang.String r1 = "C(LifecycleEventEffect)55@2410L7,65@2841L29,66@2908L299,66@2875L332:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r12 & 1
            r2 = 4
            if (r1 == 0) goto L_0x0014
            r1 = r11 | 6
            goto L_0x0024
        L_0x0014:
            r1 = r11 & 6
            if (r1 != 0) goto L_0x0023
            boolean r1 = r10.changed((java.lang.Object) r7)
            if (r1 == 0) goto L_0x0020
            r1 = r2
            goto L_0x0021
        L_0x0020:
            r1 = 2
        L_0x0021:
            r1 = r1 | r11
            goto L_0x0024
        L_0x0023:
            r1 = r11
        L_0x0024:
            r3 = r11 & 48
            if (r3 != 0) goto L_0x0038
            r3 = r12 & 2
            if (r3 != 0) goto L_0x0035
            boolean r3 = r10.changedInstance(r8)
            if (r3 == 0) goto L_0x0035
            r3 = 32
            goto L_0x0037
        L_0x0035:
            r3 = 16
        L_0x0037:
            r1 = r1 | r3
        L_0x0038:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x003f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x004f
        L_0x003f:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x004f
            boolean r3 = r10.changedInstance(r9)
            if (r3 == 0) goto L_0x004c
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x004e
        L_0x004c:
            r3 = 128(0x80, float:1.794E-43)
        L_0x004e:
            r1 = r1 | r3
        L_0x004f:
            r3 = r1 & 147(0x93, float:2.06E-43)
            r4 = 146(0x92, float:2.05E-43)
            if (r3 != r4) goto L_0x0062
            boolean r3 = r10.getSkipping()
            if (r3 != 0) goto L_0x005c
            goto L_0x0062
        L_0x005c:
            r10.skipToGroupEnd()
        L_0x005f:
            r3 = r8
            goto L_0x00f9
        L_0x0062:
            r10.startDefaults()
            r3 = r11 & 1
            if (r3 == 0) goto L_0x0078
            boolean r3 = r10.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0070
            goto L_0x0078
        L_0x0070:
            r10.skipToGroupEnd()
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0095
            goto L_0x0093
        L_0x0078:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0095
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r4)
            java.lang.Object r8 = r10.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.lifecycle.LifecycleOwner r8 = (androidx.lifecycle.LifecycleOwner) r8
        L_0x0093:
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0095:
            r10.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00a4
            r3 = -1
            java.lang.String r4 = "androidx.lifecycle.compose.LifecycleEventEffect (LifecycleEffect.kt:57)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r3, r4)
        L_0x00a4:
            androidx.lifecycle.Lifecycle$Event r0 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY
            if (r7 == r0) goto L_0x010e
            int r0 = r1 >> 6
            r0 = r0 & 14
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r9, r10, r0)
            r3 = 380955345(0x16b4ead1, float:2.9228758E-25)
            java.lang.String r4 = "CC(remember):LifecycleEffect.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r4)
            r3 = r1 & 14
            if (r3 != r2) goto L_0x00be
            r2 = 1
            goto L_0x00bf
        L_0x00be:
            r2 = 0
        L_0x00bf:
            boolean r3 = r10.changed((java.lang.Object) r0)
            r2 = r2 | r3
            boolean r3 = r10.changedInstance(r8)
            r2 = r2 | r3
            java.lang.Object r3 = r10.rememberedValue()
            if (r2 != 0) goto L_0x00d7
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x00e2
        L_0x00d7:
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$1$1 r2 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$1$1
            r2.<init>(r8, r7, r0)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r10.updateRememberedValue(r3)
        L_0x00e2:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            int r0 = r1 >> 3
            r0 = r0 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r8, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r3, (androidx.compose.runtime.Composer) r10, (int) r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x005f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x005f
        L_0x00f9:
            androidx.compose.runtime.ScopeUpdateScope r8 = r10.endRestartGroup()
            if (r8 == 0) goto L_0x010d
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$2 r1 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$2
            r2 = r7
            r4 = r9
            r5 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r8.updateScope(r1)
        L_0x010d:
            return
        L_0x010e:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "LifecycleEventEffect cannot be used to listen for Lifecycle.Event.ON_DESTROY, since Compose disposes of the composition before ON_DESTROY observers are invoked."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleEventEffect(androidx.lifecycle.Lifecycle$Event, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0074, code lost:
        if ((r12 & 2) != 0) goto L_0x0092;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LifecycleStartEffect(java.lang.Object r7, androidx.lifecycle.LifecycleOwner r8, kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            r0 = -1408314671(0xffffffffac0ed2d1, float:-2.029644E-12)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            java.lang.String r1 = "C(LifecycleStartEffect)P(1,2)133@5830L7,136@5967L102,139@6074L80:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0013
            r1 = r11 | 6
            goto L_0x0023
        L_0x0013:
            r1 = r11 & 6
            if (r1 != 0) goto L_0x0022
            boolean r1 = r10.changedInstance(r7)
            if (r1 == 0) goto L_0x001f
            r1 = 4
            goto L_0x0020
        L_0x001f:
            r1 = 2
        L_0x0020:
            r1 = r1 | r11
            goto L_0x0023
        L_0x0022:
            r1 = r11
        L_0x0023:
            r2 = r11 & 48
            if (r2 != 0) goto L_0x0037
            r2 = r12 & 2
            if (r2 != 0) goto L_0x0034
            boolean r2 = r10.changedInstance(r8)
            if (r2 == 0) goto L_0x0034
            r2 = 32
            goto L_0x0036
        L_0x0034:
            r2 = 16
        L_0x0036:
            r1 = r1 | r2
        L_0x0037:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x003e
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x004e
        L_0x003e:
            r2 = r11 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x004e
            boolean r2 = r10.changedInstance(r9)
            if (r2 == 0) goto L_0x004b
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004d
        L_0x004b:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004d:
            r1 = r1 | r2
        L_0x004e:
            r2 = r1 & 147(0x93, float:2.06E-43)
            r3 = 146(0x92, float:2.05E-43)
            if (r2 != r3) goto L_0x0061
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L_0x005b
            goto L_0x0061
        L_0x005b:
            r10.skipToGroupEnd()
        L_0x005e:
            r3 = r8
            goto L_0x00e8
        L_0x0061:
            r10.startDefaults()
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0077
            boolean r2 = r10.getDefaultsInvalid()
            if (r2 == 0) goto L_0x006f
            goto L_0x0077
        L_0x006f:
            r10.skipToGroupEnd()
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0094
            goto L_0x0092
        L_0x0077:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0094
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r3)
            java.lang.Object r8 = r10.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.lifecycle.LifecycleOwner r8 = (androidx.lifecycle.LifecycleOwner) r8
        L_0x0092:
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0094:
            r10.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00a3
            r2 = -1
            java.lang.String r3 = "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:135)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00a3:
            r0 = -1877970380(0xffffffff90107234, float:-2.848697E-29)
            java.lang.String r2 = "CC(remember):LifecycleEffect.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r2)
            boolean r0 = r10.changed((java.lang.Object) r7)
            boolean r2 = r10.changed((java.lang.Object) r8)
            r0 = r0 | r2
            java.lang.Object r2 = r10.rememberedValue()
            if (r0 != 0) goto L_0x00c2
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x00ce
        L_0x00c2:
            androidx.lifecycle.compose.LifecycleStartStopEffectScope r2 = new androidx.lifecycle.compose.LifecycleStartStopEffectScope
            androidx.lifecycle.Lifecycle r0 = r8.getLifecycle()
            r2.<init>(r0)
            r10.updateRememberedValue(r2)
        L_0x00ce:
            androidx.lifecycle.compose.LifecycleStartStopEffectScope r2 = (androidx.lifecycle.compose.LifecycleStartStopEffectScope) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            int r0 = r1 >> 3
            r0 = r0 & 14
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            LifecycleStartEffectImpl(r8, r2, r9, r10, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x005e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x005e
        L_0x00e8:
            androidx.compose.runtime.ScopeUpdateScope r8 = r10.endRestartGroup()
            if (r8 == 0) goto L_0x00fc
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$1 r1 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$1
            r2 = r7
            r4 = r9
            r5 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r8.updateScope(r1)
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008b, code lost:
        if ((r14 & 4) != 0) goto L_0x00a9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LifecycleStartEffect(java.lang.Object r8, java.lang.Object r9, androidx.lifecycle.LifecycleOwner r10, kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 696924721(0x298a3a31, float:6.138526E-14)
            androidx.compose.runtime.Composer r12 = r12.startRestartGroup(r0)
            java.lang.String r1 = "C(LifecycleStartEffect)P(1,2,3)196@8866L7,199@9003L108,202@9116L80:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0013
            r1 = r13 | 6
            goto L_0x0023
        L_0x0013:
            r1 = r13 & 6
            if (r1 != 0) goto L_0x0022
            boolean r1 = r12.changedInstance(r8)
            if (r1 == 0) goto L_0x001f
            r1 = 4
            goto L_0x0020
        L_0x001f:
            r1 = 2
        L_0x0020:
            r1 = r1 | r13
            goto L_0x0023
        L_0x0022:
            r1 = r13
        L_0x0023:
            r2 = r14 & 2
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 48
            goto L_0x003a
        L_0x002a:
            r2 = r13 & 48
            if (r2 != 0) goto L_0x003a
            boolean r2 = r12.changedInstance(r9)
            if (r2 == 0) goto L_0x0037
            r2 = 32
            goto L_0x0039
        L_0x0037:
            r2 = 16
        L_0x0039:
            r1 = r1 | r2
        L_0x003a:
            r2 = r13 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x004e
            r2 = r14 & 4
            if (r2 != 0) goto L_0x004b
            boolean r2 = r12.changedInstance(r10)
            if (r2 == 0) goto L_0x004b
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004d
        L_0x004b:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004d:
            r1 = r1 | r2
        L_0x004e:
            r2 = r14 & 8
            if (r2 == 0) goto L_0x0055
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0065
        L_0x0055:
            r2 = r13 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x0065
            boolean r2 = r12.changedInstance(r11)
            if (r2 == 0) goto L_0x0062
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r1 = r1 | r2
        L_0x0065:
            r2 = r1 & 1171(0x493, float:1.641E-42)
            r3 = 1170(0x492, float:1.64E-42)
            if (r2 != r3) goto L_0x0078
            boolean r2 = r12.getSkipping()
            if (r2 != 0) goto L_0x0072
            goto L_0x0078
        L_0x0072:
            r12.skipToGroupEnd()
        L_0x0075:
            r4 = r10
            goto L_0x0106
        L_0x0078:
            r12.startDefaults()
            r2 = r13 & 1
            if (r2 == 0) goto L_0x008e
            boolean r2 = r12.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0086
            goto L_0x008e
        L_0x0086:
            r12.skipToGroupEnd()
            r2 = r14 & 4
            if (r2 == 0) goto L_0x00ab
            goto L_0x00a9
        L_0x008e:
            r2 = r14 & 4
            if (r2 == 0) goto L_0x00ab
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r3)
            java.lang.Object r10 = r12.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.lifecycle.LifecycleOwner r10 = (androidx.lifecycle.LifecycleOwner) r10
        L_0x00a9:
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00ab:
            r12.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00ba
            r2 = -1
            java.lang.String r3 = "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:198)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00ba:
            r0 = -1877873222(0xffffffff9011edba, float:-2.8779346E-29)
            java.lang.String r2 = "CC(remember):LifecycleEffect.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r2)
            boolean r0 = r12.changed((java.lang.Object) r8)
            boolean r2 = r12.changed((java.lang.Object) r9)
            r0 = r0 | r2
            boolean r2 = r12.changed((java.lang.Object) r10)
            r0 = r0 | r2
            java.lang.Object r2 = r12.rememberedValue()
            if (r0 != 0) goto L_0x00de
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x00ea
        L_0x00de:
            androidx.lifecycle.compose.LifecycleStartStopEffectScope r2 = new androidx.lifecycle.compose.LifecycleStartStopEffectScope
            androidx.lifecycle.Lifecycle r0 = r10.getLifecycle()
            r2.<init>(r0)
            r12.updateRememberedValue(r2)
        L_0x00ea:
            androidx.lifecycle.compose.LifecycleStartStopEffectScope r2 = (androidx.lifecycle.compose.LifecycleStartStopEffectScope) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            int r0 = r1 >> 6
            r0 = r0 & 14
            int r1 = r1 >> 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            LifecycleStartEffectImpl(r10, r2, r11, r12, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0075
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0075
        L_0x0106:
            androidx.compose.runtime.ScopeUpdateScope r10 = r12.endRestartGroup()
            if (r10 == 0) goto L_0x011b
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$2 r1 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$2
            r2 = r8
            r3 = r9
            r5 = r11
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r10.updateScope(r1)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a2, code lost:
        if ((r15 & 8) != 0) goto L_0x00c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LifecycleStartEffect(java.lang.Object r8, java.lang.Object r9, java.lang.Object r10, androidx.lifecycle.LifecycleOwner r11, kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            r0 = 574812561(0x2242f191, float:2.6419787E-18)
            androidx.compose.runtime.Composer r1 = r13.startRestartGroup(r0)
            java.lang.String r2 = "C(LifecycleStartEffect)P(1,2,3,4)261@12007L7,264@12144L114,267@12263L80:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r15 & 1
            if (r2 == 0) goto L_0x0013
            r2 = r14 | 6
            goto L_0x0023
        L_0x0013:
            r2 = r14 & 6
            if (r2 != 0) goto L_0x0022
            boolean r2 = r1.changedInstance(r8)
            if (r2 == 0) goto L_0x001f
            r2 = 4
            goto L_0x0020
        L_0x001f:
            r2 = 2
        L_0x0020:
            r2 = r2 | r14
            goto L_0x0023
        L_0x0022:
            r2 = r14
        L_0x0023:
            r3 = r15 & 2
            if (r3 == 0) goto L_0x002a
            r2 = r2 | 48
            goto L_0x003a
        L_0x002a:
            r3 = r14 & 48
            if (r3 != 0) goto L_0x003a
            boolean r3 = r1.changedInstance(r9)
            if (r3 == 0) goto L_0x0037
            r3 = 32
            goto L_0x0039
        L_0x0037:
            r3 = 16
        L_0x0039:
            r2 = r2 | r3
        L_0x003a:
            r3 = r15 & 4
            if (r3 == 0) goto L_0x0041
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0051
        L_0x0041:
            r3 = r14 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0051
            boolean r3 = r1.changedInstance(r10)
            if (r3 == 0) goto L_0x004e
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0050
        L_0x004e:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0050:
            r2 = r2 | r3
        L_0x0051:
            r3 = r14 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0065
            r3 = r15 & 8
            if (r3 != 0) goto L_0x0062
            boolean r3 = r1.changedInstance(r11)
            if (r3 == 0) goto L_0x0062
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r2 = r2 | r3
        L_0x0065:
            r3 = r15 & 16
            if (r3 == 0) goto L_0x006c
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x007c
        L_0x006c:
            r3 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x007c
            boolean r3 = r1.changedInstance(r12)
            if (r3 == 0) goto L_0x0079
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007b
        L_0x0079:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x007b:
            r2 = r2 | r3
        L_0x007c:
            r3 = r2 & 9363(0x2493, float:1.312E-41)
            r4 = 9362(0x2492, float:1.3119E-41)
            if (r3 != r4) goto L_0x008f
            boolean r3 = r1.getSkipping()
            if (r3 != 0) goto L_0x0089
            goto L_0x008f
        L_0x0089:
            r1.skipToGroupEnd()
        L_0x008c:
            r4 = r11
            goto L_0x0122
        L_0x008f:
            r1.startDefaults()
            r3 = r14 & 1
            if (r3 == 0) goto L_0x00a5
            boolean r3 = r1.getDefaultsInvalid()
            if (r3 == 0) goto L_0x009d
            goto L_0x00a5
        L_0x009d:
            r1.skipToGroupEnd()
            r3 = r15 & 8
            if (r3 == 0) goto L_0x00c2
            goto L_0x00c0
        L_0x00a5:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x00c2
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r3, r4)
            java.lang.Object r11 = r1.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.lifecycle.LifecycleOwner r11 = (androidx.lifecycle.LifecycleOwner) r11
        L_0x00c0:
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00c2:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00d1
            r3 = -1
            java.lang.String r4 = "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:263)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x00d1:
            r0 = -1877772704(0xffffffff90137660, float:-2.908183E-29)
            java.lang.String r3 = "CC(remember):LifecycleEffect.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r3)
            boolean r0 = r1.changed((java.lang.Object) r8)
            boolean r3 = r1.changed((java.lang.Object) r9)
            r0 = r0 | r3
            boolean r3 = r1.changed((java.lang.Object) r10)
            r0 = r0 | r3
            boolean r3 = r1.changed((java.lang.Object) r11)
            r0 = r0 | r3
            java.lang.Object r3 = r1.rememberedValue()
            if (r0 != 0) goto L_0x00fa
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x0106
        L_0x00fa:
            androidx.lifecycle.compose.LifecycleStartStopEffectScope r3 = new androidx.lifecycle.compose.LifecycleStartStopEffectScope
            androidx.lifecycle.Lifecycle r0 = r11.getLifecycle()
            r3.<init>(r0)
            r1.updateRememberedValue(r3)
        L_0x0106:
            androidx.lifecycle.compose.LifecycleStartStopEffectScope r3 = (androidx.lifecycle.compose.LifecycleStartStopEffectScope) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            int r0 = r2 >> 9
            r0 = r0 & 14
            int r2 = r2 >> 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            LifecycleStartEffectImpl(r11, r3, r12, r1, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x008c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x008c
        L_0x0122:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x0138
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$3 r0 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$3
            r1 = r8
            r2 = r9
            r3 = r10
            r5 = r12
            r6 = r14
            r7 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008c, code lost:
        if ((r12 & 2) != 0) goto L_0x00aa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dd A[LOOP:1: B:50:0x00db->B:51:0x00dd, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0116  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LifecycleStartEffect(java.lang.Object[] r7, androidx.lifecycle.LifecycleOwner r8, kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            r0 = -1510305724(0xffffffffa5fa9044, float:-4.3465845E-16)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            java.lang.String r1 = "C(LifecycleStartEffect)P(1,2)325@15110L103,328@15218L80:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r11 & 48
            if (r1 != 0) goto L_0x0021
            r1 = r12 & 2
            if (r1 != 0) goto L_0x001d
            boolean r1 = r10.changedInstance(r8)
            if (r1 == 0) goto L_0x001d
            r1 = 32
            goto L_0x001f
        L_0x001d:
            r1 = 16
        L_0x001f:
            r1 = r1 | r11
            goto L_0x0022
        L_0x0021:
            r1 = r11
        L_0x0022:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x0029
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0039
        L_0x0029:
            r2 = r11 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x0039
            boolean r2 = r10.changedInstance(r9)
            if (r2 == 0) goto L_0x0036
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0038
        L_0x0036:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0038:
            r1 = r1 | r2
        L_0x0039:
            int r2 = r7.length
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = -1877684705(0xffffffff9014ce1f, float:-2.9346643E-29)
            r10.startMovableGroup(r3, r2)
            java.lang.String r2 = "322@14973L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            int r2 = r7.length
            r3 = 0
            r4 = r3
        L_0x004c:
            if (r4 >= r2) goto L_0x005d
            r5 = r7[r4]
            boolean r5 = r10.changedInstance(r5)
            if (r5 == 0) goto L_0x0058
            r5 = 4
            goto L_0x0059
        L_0x0058:
            r5 = r3
        L_0x0059:
            r1 = r1 | r5
            int r4 = r4 + 1
            goto L_0x004c
        L_0x005d:
            r10.endMovableGroup()
            r2 = r1 & 14
            if (r2 != 0) goto L_0x0066
            r1 = r1 | 2
        L_0x0066:
            r2 = r1 & 147(0x93, float:2.06E-43)
            r4 = 146(0x92, float:2.05E-43)
            if (r2 != r4) goto L_0x0079
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L_0x0073
            goto L_0x0079
        L_0x0073:
            r10.skipToGroupEnd()
        L_0x0076:
            r3 = r8
            goto L_0x011b
        L_0x0079:
            r10.startDefaults()
            r2 = r11 & 1
            if (r2 == 0) goto L_0x008f
            boolean r2 = r10.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0087
            goto L_0x008f
        L_0x0087:
            r10.skipToGroupEnd()
            r2 = r12 & 2
            if (r2 == 0) goto L_0x00ac
            goto L_0x00aa
        L_0x008f:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x00ac
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r4)
            java.lang.Object r8 = r10.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.lifecycle.LifecycleOwner r8 = (androidx.lifecycle.LifecycleOwner) r8
        L_0x00aa:
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ac:
            r10.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00bb
            r2 = -1
            java.lang.String r4 = "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:324)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r4)
        L_0x00bb:
            kotlin.jvm.internal.SpreadBuilder r0 = new kotlin.jvm.internal.SpreadBuilder
            r2 = 2
            r0.<init>(r2)
            r0.addSpread(r7)
            r0.add(r8)
            int r2 = r0.size()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Object[] r0 = r0.toArray(r2)
            r2 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            java.lang.String r4 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r4)
            int r2 = r0.length
            r4 = r3
        L_0x00db:
            if (r3 >= r2) goto L_0x00e7
            r5 = r0[r3]
            boolean r5 = r10.changed((java.lang.Object) r5)
            r4 = r4 | r5
            int r3 = r3 + 1
            goto L_0x00db
        L_0x00e7:
            java.lang.Object r0 = r10.rememberedValue()
            if (r4 != 0) goto L_0x00f5
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x0101
        L_0x00f5:
            androidx.lifecycle.compose.LifecycleStartStopEffectScope r0 = new androidx.lifecycle.compose.LifecycleStartStopEffectScope
            androidx.lifecycle.Lifecycle r2 = r8.getLifecycle()
            r0.<init>(r2)
            r10.updateRememberedValue(r0)
        L_0x0101:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.lifecycle.compose.LifecycleStartStopEffectScope r0 = (androidx.lifecycle.compose.LifecycleStartStopEffectScope) r0
            int r2 = r1 >> 3
            r2 = r2 & 14
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            LifecycleStartEffectImpl(r8, r0, r9, r10, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0076
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0076
        L_0x011b:
            androidx.compose.runtime.ScopeUpdateScope r8 = r10.endRestartGroup()
            if (r8 == 0) goto L_0x012f
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$4 r1 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$4
            r2 = r7
            r4 = r9
            r5 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r8.updateScope(r1)
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object[], androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if ((r7 & 1) != 0) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LifecycleStartEffect(androidx.lifecycle.LifecycleOwner r3, kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r4, androidx.compose.runtime.Composer r5, int r6, int r7) {
        /*
            r0 = -50807951(0xfffffffffcf8bb71, float:-1.0331931E37)
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r0)
            java.lang.String r1 = "C(LifecycleStartEffect)P(1)348@16079L7:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            r1 = r6 & 1
            if (r1 != 0) goto L_0x002b
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L_0x0017
            goto L_0x002b
        L_0x0017:
            r5.skipToGroupEnd()
            androidx.compose.runtime.ScopeUpdateScope r5 = r5.endRestartGroup()
            if (r5 == 0) goto L_0x002a
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$5 r0 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$5
            r0.<init>(r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r5.updateScope(r0)
        L_0x002a:
            return
        L_0x002b:
            r5.startDefaults()
            if (r1 == 0) goto L_0x003f
            boolean r3 = r5.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0037
            goto L_0x003f
        L_0x0037:
            r5.skipToGroupEnd()
            r3 = r7 & 1
            if (r3 == 0) goto L_0x005c
            goto L_0x005a
        L_0x003f:
            r3 = r7 & 1
            if (r3 == 0) goto L_0x005c
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r7)
            java.lang.Object r3 = r5.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.lifecycle.LifecycleOwner r3 = (androidx.lifecycle.LifecycleOwner) r3
        L_0x005a:
            r6 = r6 & -15
        L_0x005c:
            r5.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x006b
            r3 = -1
            java.lang.String r4 = "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:350)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r3, r4)
        L_0x006b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key."
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void LifecycleStartEffectImpl(LifecycleOwner lifecycleOwner, LifecycleStartStopEffectScope lifecycleStartStopEffectScope, Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(228371534);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleStartEffectImpl)P(1,2)358@16483L661,358@16443L701:LifecycleEffect.kt#2vxrgp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(lifecycleStartStopEffectScope) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(228371534, i2, -1, "androidx.lifecycle.compose.LifecycleStartEffectImpl (LifecycleEffect.kt:357)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1076218333, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(lifecycleStartStopEffectScope) | ((i2 & 896) == 256) | startRestartGroup.changedInstance(lifecycleOwner);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new LifecycleEffectKt$LifecycleStartEffectImpl$1$1(lifecycleOwner, lifecycleStartStopEffectScope, function1);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(lifecycleOwner, lifecycleStartStopEffectScope, (Function1) rememberedValue, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LifecycleEffectKt$LifecycleStartEffectImpl$2(lifecycleOwner, lifecycleStartStopEffectScope, function1, i));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0074, code lost:
        if ((r12 & 2) != 0) goto L_0x0092;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LifecycleResumeEffect(java.lang.Object r7, androidx.lifecycle.LifecycleOwner r8, kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            r0 = 1220373486(0x48bd6bee, float:387935.44)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            java.lang.String r1 = "C(LifecycleResumeEffect)P(1,2)465@21161L7,468@21303L104,471@21412L83:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0013
            r1 = r11 | 6
            goto L_0x0023
        L_0x0013:
            r1 = r11 & 6
            if (r1 != 0) goto L_0x0022
            boolean r1 = r10.changedInstance(r7)
            if (r1 == 0) goto L_0x001f
            r1 = 4
            goto L_0x0020
        L_0x001f:
            r1 = 2
        L_0x0020:
            r1 = r1 | r11
            goto L_0x0023
        L_0x0022:
            r1 = r11
        L_0x0023:
            r2 = r11 & 48
            if (r2 != 0) goto L_0x0037
            r2 = r12 & 2
            if (r2 != 0) goto L_0x0034
            boolean r2 = r10.changedInstance(r8)
            if (r2 == 0) goto L_0x0034
            r2 = 32
            goto L_0x0036
        L_0x0034:
            r2 = 16
        L_0x0036:
            r1 = r1 | r2
        L_0x0037:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x003e
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x004e
        L_0x003e:
            r2 = r11 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x004e
            boolean r2 = r10.changedInstance(r9)
            if (r2 == 0) goto L_0x004b
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004d
        L_0x004b:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004d:
            r1 = r1 | r2
        L_0x004e:
            r2 = r1 & 147(0x93, float:2.06E-43)
            r3 = 146(0x92, float:2.05E-43)
            if (r2 != r3) goto L_0x0061
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L_0x005b
            goto L_0x0061
        L_0x005b:
            r10.skipToGroupEnd()
        L_0x005e:
            r3 = r8
            goto L_0x00e8
        L_0x0061:
            r10.startDefaults()
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0077
            boolean r2 = r10.getDefaultsInvalid()
            if (r2 == 0) goto L_0x006f
            goto L_0x0077
        L_0x006f:
            r10.skipToGroupEnd()
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0094
            goto L_0x0092
        L_0x0077:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0094
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r3)
            java.lang.Object r8 = r10.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.lifecycle.LifecycleOwner r8 = (androidx.lifecycle.LifecycleOwner) r8
        L_0x0092:
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0094:
            r10.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00a3
            r2 = -1
            java.lang.String r3 = "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:467)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00a3:
            r0 = 1469999915(0x579e6b2b, float:3.4836624E14)
            java.lang.String r2 = "CC(remember):LifecycleEffect.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r2)
            boolean r0 = r10.changed((java.lang.Object) r7)
            boolean r2 = r10.changed((java.lang.Object) r8)
            r0 = r0 | r2
            java.lang.Object r2 = r10.rememberedValue()
            if (r0 != 0) goto L_0x00c2
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x00ce
        L_0x00c2:
            androidx.lifecycle.compose.LifecycleResumePauseEffectScope r2 = new androidx.lifecycle.compose.LifecycleResumePauseEffectScope
            androidx.lifecycle.Lifecycle r0 = r8.getLifecycle()
            r2.<init>(r0)
            r10.updateRememberedValue(r2)
        L_0x00ce:
            androidx.lifecycle.compose.LifecycleResumePauseEffectScope r2 = (androidx.lifecycle.compose.LifecycleResumePauseEffectScope) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            int r0 = r1 >> 3
            r0 = r0 & 14
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            LifecycleResumeEffectImpl(r8, r2, r9, r10, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x005e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x005e
        L_0x00e8:
            androidx.compose.runtime.ScopeUpdateScope r8 = r10.endRestartGroup()
            if (r8 == 0) goto L_0x00fc
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$1 r1 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$1
            r2 = r7
            r4 = r9
            r5 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r8.updateScope(r1)
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008b, code lost:
        if ((r14 & 4) != 0) goto L_0x00a9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LifecycleResumeEffect(java.lang.Object r8, java.lang.Object r9, androidx.lifecycle.LifecycleOwner r10, kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 752680142(0x2cdcfcce, float:6.280843E-12)
            androidx.compose.runtime.Composer r12 = r12.startRestartGroup(r0)
            java.lang.String r1 = "C(LifecycleResumeEffect)P(1,2,3)528@24243L7,531@24385L110,534@24500L83:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0013
            r1 = r13 | 6
            goto L_0x0023
        L_0x0013:
            r1 = r13 & 6
            if (r1 != 0) goto L_0x0022
            boolean r1 = r12.changedInstance(r8)
            if (r1 == 0) goto L_0x001f
            r1 = 4
            goto L_0x0020
        L_0x001f:
            r1 = 2
        L_0x0020:
            r1 = r1 | r13
            goto L_0x0023
        L_0x0022:
            r1 = r13
        L_0x0023:
            r2 = r14 & 2
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 48
            goto L_0x003a
        L_0x002a:
            r2 = r13 & 48
            if (r2 != 0) goto L_0x003a
            boolean r2 = r12.changedInstance(r9)
            if (r2 == 0) goto L_0x0037
            r2 = 32
            goto L_0x0039
        L_0x0037:
            r2 = 16
        L_0x0039:
            r1 = r1 | r2
        L_0x003a:
            r2 = r13 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x004e
            r2 = r14 & 4
            if (r2 != 0) goto L_0x004b
            boolean r2 = r12.changedInstance(r10)
            if (r2 == 0) goto L_0x004b
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004d
        L_0x004b:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004d:
            r1 = r1 | r2
        L_0x004e:
            r2 = r14 & 8
            if (r2 == 0) goto L_0x0055
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0065
        L_0x0055:
            r2 = r13 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x0065
            boolean r2 = r12.changedInstance(r11)
            if (r2 == 0) goto L_0x0062
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r1 = r1 | r2
        L_0x0065:
            r2 = r1 & 1171(0x493, float:1.641E-42)
            r3 = 1170(0x492, float:1.64E-42)
            if (r2 != r3) goto L_0x0078
            boolean r2 = r12.getSkipping()
            if (r2 != 0) goto L_0x0072
            goto L_0x0078
        L_0x0072:
            r12.skipToGroupEnd()
        L_0x0075:
            r4 = r10
            goto L_0x0106
        L_0x0078:
            r12.startDefaults()
            r2 = r13 & 1
            if (r2 == 0) goto L_0x008e
            boolean r2 = r12.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0086
            goto L_0x008e
        L_0x0086:
            r12.skipToGroupEnd()
            r2 = r14 & 4
            if (r2 == 0) goto L_0x00ab
            goto L_0x00a9
        L_0x008e:
            r2 = r14 & 4
            if (r2 == 0) goto L_0x00ab
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r2, r3)
            java.lang.Object r10 = r12.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.lifecycle.LifecycleOwner r10 = (androidx.lifecycle.LifecycleOwner) r10
        L_0x00a9:
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00ab:
            r12.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00ba
            r2 = -1
            java.lang.String r3 = "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:530)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00ba:
            r0 = 1470098545(0x579fec71, float:3.51675714E14)
            java.lang.String r2 = "CC(remember):LifecycleEffect.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r2)
            boolean r0 = r12.changed((java.lang.Object) r8)
            boolean r2 = r12.changed((java.lang.Object) r9)
            r0 = r0 | r2
            boolean r2 = r12.changed((java.lang.Object) r10)
            r0 = r0 | r2
            java.lang.Object r2 = r12.rememberedValue()
            if (r0 != 0) goto L_0x00de
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x00ea
        L_0x00de:
            androidx.lifecycle.compose.LifecycleResumePauseEffectScope r2 = new androidx.lifecycle.compose.LifecycleResumePauseEffectScope
            androidx.lifecycle.Lifecycle r0 = r10.getLifecycle()
            r2.<init>(r0)
            r12.updateRememberedValue(r2)
        L_0x00ea:
            androidx.lifecycle.compose.LifecycleResumePauseEffectScope r2 = (androidx.lifecycle.compose.LifecycleResumePauseEffectScope) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            int r0 = r1 >> 6
            r0 = r0 & 14
            int r1 = r1 >> 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            LifecycleResumeEffectImpl(r10, r2, r11, r12, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0075
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0075
        L_0x0106:
            androidx.compose.runtime.ScopeUpdateScope r10 = r12.endRestartGroup()
            if (r10 == 0) goto L_0x011b
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$2 r1 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$2
            r2 = r8
            r3 = r9
            r5 = r11
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r10.updateScope(r1)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a2, code lost:
        if ((r15 & 8) != 0) goto L_0x00c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LifecycleResumeEffect(java.lang.Object r8, java.lang.Object r9, java.lang.Object r10, androidx.lifecycle.LifecycleOwner r11, kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            r0 = -485941842(0xffffffffe3091dae, float:-2.5293426E21)
            androidx.compose.runtime.Composer r1 = r13.startRestartGroup(r0)
            java.lang.String r2 = "C(LifecycleResumeEffect)P(1,2,3,4)593@27424L7,596@27566L116,599@27687L83:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r15 & 1
            if (r2 == 0) goto L_0x0013
            r2 = r14 | 6
            goto L_0x0023
        L_0x0013:
            r2 = r14 & 6
            if (r2 != 0) goto L_0x0022
            boolean r2 = r1.changedInstance(r8)
            if (r2 == 0) goto L_0x001f
            r2 = 4
            goto L_0x0020
        L_0x001f:
            r2 = 2
        L_0x0020:
            r2 = r2 | r14
            goto L_0x0023
        L_0x0022:
            r2 = r14
        L_0x0023:
            r3 = r15 & 2
            if (r3 == 0) goto L_0x002a
            r2 = r2 | 48
            goto L_0x003a
        L_0x002a:
            r3 = r14 & 48
            if (r3 != 0) goto L_0x003a
            boolean r3 = r1.changedInstance(r9)
            if (r3 == 0) goto L_0x0037
            r3 = 32
            goto L_0x0039
        L_0x0037:
            r3 = 16
        L_0x0039:
            r2 = r2 | r3
        L_0x003a:
            r3 = r15 & 4
            if (r3 == 0) goto L_0x0041
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0051
        L_0x0041:
            r3 = r14 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0051
            boolean r3 = r1.changedInstance(r10)
            if (r3 == 0) goto L_0x004e
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0050
        L_0x004e:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0050:
            r2 = r2 | r3
        L_0x0051:
            r3 = r14 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0065
            r3 = r15 & 8
            if (r3 != 0) goto L_0x0062
            boolean r3 = r1.changedInstance(r11)
            if (r3 == 0) goto L_0x0062
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r2 = r2 | r3
        L_0x0065:
            r3 = r15 & 16
            if (r3 == 0) goto L_0x006c
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x007c
        L_0x006c:
            r3 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x007c
            boolean r3 = r1.changedInstance(r12)
            if (r3 == 0) goto L_0x0079
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007b
        L_0x0079:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x007b:
            r2 = r2 | r3
        L_0x007c:
            r3 = r2 & 9363(0x2493, float:1.312E-41)
            r4 = 9362(0x2492, float:1.3119E-41)
            if (r3 != r4) goto L_0x008f
            boolean r3 = r1.getSkipping()
            if (r3 != 0) goto L_0x0089
            goto L_0x008f
        L_0x0089:
            r1.skipToGroupEnd()
        L_0x008c:
            r4 = r11
            goto L_0x0122
        L_0x008f:
            r1.startDefaults()
            r3 = r14 & 1
            if (r3 == 0) goto L_0x00a5
            boolean r3 = r1.getDefaultsInvalid()
            if (r3 == 0) goto L_0x009d
            goto L_0x00a5
        L_0x009d:
            r1.skipToGroupEnd()
            r3 = r15 & 8
            if (r3 == 0) goto L_0x00c2
            goto L_0x00c0
        L_0x00a5:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x00c2
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r3, r4)
            java.lang.Object r11 = r1.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.lifecycle.LifecycleOwner r11 = (androidx.lifecycle.LifecycleOwner) r11
        L_0x00c0:
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00c2:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00d1
            r3 = -1
            java.lang.String r4 = "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:595)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x00d1:
            r0 = 1470200343(0x57a17a17, float:3.55091488E14)
            java.lang.String r3 = "CC(remember):LifecycleEffect.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r3)
            boolean r0 = r1.changed((java.lang.Object) r8)
            boolean r3 = r1.changed((java.lang.Object) r9)
            r0 = r0 | r3
            boolean r3 = r1.changed((java.lang.Object) r10)
            r0 = r0 | r3
            boolean r3 = r1.changed((java.lang.Object) r11)
            r0 = r0 | r3
            java.lang.Object r3 = r1.rememberedValue()
            if (r0 != 0) goto L_0x00fa
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x0106
        L_0x00fa:
            androidx.lifecycle.compose.LifecycleResumePauseEffectScope r3 = new androidx.lifecycle.compose.LifecycleResumePauseEffectScope
            androidx.lifecycle.Lifecycle r0 = r11.getLifecycle()
            r3.<init>(r0)
            r1.updateRememberedValue(r3)
        L_0x0106:
            androidx.lifecycle.compose.LifecycleResumePauseEffectScope r3 = (androidx.lifecycle.compose.LifecycleResumePauseEffectScope) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            int r0 = r2 >> 9
            r0 = r0 & 14
            int r2 = r2 >> 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            LifecycleResumeEffectImpl(r11, r3, r12, r1, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x008c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x008c
        L_0x0122:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x0138
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$3 r0 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$3
            r1 = r8
            r2 = r9
            r3 = r10
            r5 = r12
            r6 = r14
            r7 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008c, code lost:
        if ((r12 & 2) != 0) goto L_0x00aa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dd A[LOOP:1: B:50:0x00db->B:51:0x00dd, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0116  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LifecycleResumeEffect(java.lang.Object[] r7, androidx.lifecycle.LifecycleOwner r8, kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            r0 = -781756895(0xffffffffd1675621, float:-6.2098903E10)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            java.lang.String r1 = "C(LifecycleResumeEffect)P(1,2)657@30578L105,660@30688L83:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r11 & 48
            if (r1 != 0) goto L_0x0021
            r1 = r12 & 2
            if (r1 != 0) goto L_0x001d
            boolean r1 = r10.changedInstance(r8)
            if (r1 == 0) goto L_0x001d
            r1 = 32
            goto L_0x001f
        L_0x001d:
            r1 = 16
        L_0x001f:
            r1 = r1 | r11
            goto L_0x0022
        L_0x0021:
            r1 = r11
        L_0x0022:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x0029
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0039
        L_0x0029:
            r2 = r11 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x0039
            boolean r2 = r10.changedInstance(r9)
            if (r2 == 0) goto L_0x0036
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0038
        L_0x0036:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0038:
            r1 = r1 | r2
        L_0x0039:
            int r2 = r7.length
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 1470289652(0x57a2d6f4, float:3.58088201E14)
            r10.startMovableGroup(r3, r2)
            java.lang.String r2 = "654@30436L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            int r2 = r7.length
            r3 = 0
            r4 = r3
        L_0x004c:
            if (r4 >= r2) goto L_0x005d
            r5 = r7[r4]
            boolean r5 = r10.changedInstance(r5)
            if (r5 == 0) goto L_0x0058
            r5 = 4
            goto L_0x0059
        L_0x0058:
            r5 = r3
        L_0x0059:
            r1 = r1 | r5
            int r4 = r4 + 1
            goto L_0x004c
        L_0x005d:
            r10.endMovableGroup()
            r2 = r1 & 14
            if (r2 != 0) goto L_0x0066
            r1 = r1 | 2
        L_0x0066:
            r2 = r1 & 147(0x93, float:2.06E-43)
            r4 = 146(0x92, float:2.05E-43)
            if (r2 != r4) goto L_0x0079
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L_0x0073
            goto L_0x0079
        L_0x0073:
            r10.skipToGroupEnd()
        L_0x0076:
            r3 = r8
            goto L_0x011b
        L_0x0079:
            r10.startDefaults()
            r2 = r11 & 1
            if (r2 == 0) goto L_0x008f
            boolean r2 = r10.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0087
            goto L_0x008f
        L_0x0087:
            r10.skipToGroupEnd()
            r2 = r12 & 2
            if (r2 == 0) goto L_0x00ac
            goto L_0x00aa
        L_0x008f:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x00ac
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r4)
            java.lang.Object r8 = r10.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.lifecycle.LifecycleOwner r8 = (androidx.lifecycle.LifecycleOwner) r8
        L_0x00aa:
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ac:
            r10.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00bb
            r2 = -1
            java.lang.String r4 = "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:656)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r4)
        L_0x00bb:
            kotlin.jvm.internal.SpreadBuilder r0 = new kotlin.jvm.internal.SpreadBuilder
            r2 = 2
            r0.<init>(r2)
            r0.addSpread(r7)
            r0.add(r8)
            int r2 = r0.size()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Object[] r0 = r0.toArray(r2)
            r2 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            java.lang.String r4 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r4)
            int r2 = r0.length
            r4 = r3
        L_0x00db:
            if (r3 >= r2) goto L_0x00e7
            r5 = r0[r3]
            boolean r5 = r10.changed((java.lang.Object) r5)
            r4 = r4 | r5
            int r3 = r3 + 1
            goto L_0x00db
        L_0x00e7:
            java.lang.Object r0 = r10.rememberedValue()
            if (r4 != 0) goto L_0x00f5
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x0101
        L_0x00f5:
            androidx.lifecycle.compose.LifecycleResumePauseEffectScope r0 = new androidx.lifecycle.compose.LifecycleResumePauseEffectScope
            androidx.lifecycle.Lifecycle r2 = r8.getLifecycle()
            r0.<init>(r2)
            r10.updateRememberedValue(r0)
        L_0x0101:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.lifecycle.compose.LifecycleResumePauseEffectScope r0 = (androidx.lifecycle.compose.LifecycleResumePauseEffectScope) r0
            int r2 = r1 >> 3
            r2 = r2 & 14
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            LifecycleResumeEffectImpl(r8, r0, r9, r10, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0076
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0076
        L_0x011b:
            androidx.compose.runtime.ScopeUpdateScope r8 = r10.endRestartGroup()
            if (r8 == 0) goto L_0x012f
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$4 r1 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$4
            r2 = r7
            r4 = r9
            r5 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r8.updateScope(r1)
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object[], androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if ((r7 & 1) != 0) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LifecycleResumeEffect(androidx.lifecycle.LifecycleOwner r3, kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r4, androidx.compose.runtime.Composer r5, int r6, int r7) {
        /*
            r0 = -747476210(0xffffffffd3726b0e, float:-1.04117817E12)
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r0)
            java.lang.String r1 = "C(LifecycleResumeEffect)P(1)680@31558L7:LifecycleEffect.kt#2vxrgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            r1 = r6 & 1
            if (r1 != 0) goto L_0x002b
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L_0x0017
            goto L_0x002b
        L_0x0017:
            r5.skipToGroupEnd()
            androidx.compose.runtime.ScopeUpdateScope r5 = r5.endRestartGroup()
            if (r5 == 0) goto L_0x002a
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$5 r0 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$5
            r0.<init>(r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r5.updateScope(r0)
        L_0x002a:
            return
        L_0x002b:
            r5.startDefaults()
            if (r1 == 0) goto L_0x003f
            boolean r3 = r5.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0037
            goto L_0x003f
        L_0x0037:
            r5.skipToGroupEnd()
            r3 = r7 & 1
            if (r3 == 0) goto L_0x005c
            goto L_0x005a
        L_0x003f:
            r3 = r7 & 1
            if (r3 == 0) goto L_0x005c
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r7)
            java.lang.Object r3 = r5.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.lifecycle.LifecycleOwner r3 = (androidx.lifecycle.LifecycleOwner) r3
        L_0x005a:
            r6 = r6 & -15
        L_0x005c:
            r5.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x006b
            r3 = -1
            java.lang.String r4 = "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:682)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r3, r4)
        L_0x006b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key."
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void LifecycleResumeEffectImpl(LifecycleOwner lifecycleOwner, LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(912823238);
        ComposerKt.sourceInformation(startRestartGroup, "C(LifecycleResumeEffectImpl)P(1,2)690@31972L670,690@31932L710:LifecycleEffect.kt#2vxrgp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(lifecycleResumePauseEffectScope) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(912823238, i2, -1, "androidx.lifecycle.compose.LifecycleResumeEffectImpl (LifecycleEffect.kt:689)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 657407937, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(lifecycleResumePauseEffectScope) | ((i2 & 896) == 256) | startRestartGroup.changedInstance(lifecycleOwner);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new LifecycleEffectKt$LifecycleResumeEffectImpl$1$1(lifecycleOwner, lifecycleResumePauseEffectScope, function1);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(lifecycleOwner, lifecycleResumePauseEffectScope, (Function1) rememberedValue, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LifecycleEffectKt$LifecycleResumeEffectImpl$2(lifecycleOwner, lifecycleResumePauseEffectScope, function1, i));
        }
    }

    /* access modifiers changed from: private */
    public static final Function0<Unit> LifecycleEventEffect$lambda$0(State<? extends Function0<Unit>> state) {
        return (Function0) state.getValue();
    }
}
