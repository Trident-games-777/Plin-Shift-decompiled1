package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$Snackbar$actionComposable$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $actionColor;
    final /* synthetic */ String $actionLabel;
    final /* synthetic */ SnackbarData $snackbarData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarKt$Snackbar$actionComposable$1(long j, SnackbarData snackbarData, String str) {
        super(2);
        this.$actionColor = j;
        this.$snackbarData = snackbarData;
        this.$actionLabel = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r14, int r15) {
        /*
            r13 = this;
            r0 = r15
            java.lang.String r1 = "C217@10171L44,218@10247L32,219@10311L21,216@10115L235:Snackbar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r0 & 3
            r2 = 2
            if (r1 != r2) goto L_0x0016
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x0012
            goto L_0x0016
        L_0x0012:
            r14.skipToGroupEnd()
            return
        L_0x0016:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0025
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:216)"
            r3 = -1378313599(0xffffffffadd89a81, float:-2.462497E-11)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r15, r1, r2)
        L_0x0025:
            androidx.compose.material3.ButtonDefaults r0 = androidx.compose.material3.ButtonDefaults.INSTANCE
            long r3 = r13.$actionColor
            r10 = 24576(0x6000, float:3.4438E-41)
            r11 = 13
            r1 = 0
            r5 = 0
            r7 = 0
            r9 = r14
            androidx.compose.material3.ButtonColors r4 = r0.m1772textButtonColorsro_MJ88(r1, r3, r5, r7, r9, r10, r11)
            r0 = 642119911(0x2645f8e7, float:6.868543E-16)
            java.lang.String r1 = "CC(remember):Snackbar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r1)
            androidx.compose.material3.SnackbarData r0 = r13.$snackbarData
            boolean r0 = r14.changed((java.lang.Object) r0)
            androidx.compose.material3.SnackbarData r1 = r13.$snackbarData
            java.lang.Object r2 = r14.rememberedValue()
            if (r0 != 0) goto L_0x0056
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0061
        L_0x0056:
            androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1 r0 = new androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1
            r0.<init>(r1)
            r2 = r0
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r14.updateRememberedValue(r2)
        L_0x0061:
            r0 = r2
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$2 r1 = new androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$2
            java.lang.String r2 = r13.$actionLabel
            r1.<init>(r2)
            r2 = 54
            r3 = 521110564(0x1f0f8424, float:3.0390732E-20)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r3, r5, r1, r14, r2)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r11 = 805306368(0x30000000, float:4.656613E-10)
            r12 = 494(0x1ee, float:6.92E-43)
            r9 = r1
            r1 = 0
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = r14
            androidx.compose.material3.ButtonKt.TextButton(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0093
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
