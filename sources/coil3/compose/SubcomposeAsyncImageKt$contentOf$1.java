package coil3.compose;

import androidx.compose.runtime.Composer;
import coil3.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: SubcomposeAsyncImage.kt */
final class SubcomposeAsyncImageKt$contentOf$1 implements Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> {
    final /* synthetic */ Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Error, Composer, Integer, Unit> $error;
    final /* synthetic */ Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> $loading;
    final /* synthetic */ Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Success, Composer, Integer, Unit> $success;

    SubcomposeAsyncImageKt$contentOf$1(Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43) {
        this.$loading = function4;
        this.$success = function42;
        this.$error = function43;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SubcomposeAsyncImageScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(coil3.compose.SubcomposeAsyncImageScope r13, androidx.compose.runtime.Composer r14, int r15) {
        /*
            r12 = this;
            r1 = r15 & 6
            if (r1 != 0) goto L_0x000f
            boolean r1 = r14.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x000c
            r1 = 4
            goto L_0x000d
        L_0x000c:
            r1 = 2
        L_0x000d:
            r1 = r1 | r15
            goto L_0x0010
        L_0x000f:
            r1 = r15
        L_0x0010:
            r2 = r1 & 19
            r3 = 18
            if (r2 != r3) goto L_0x0021
            boolean r2 = r14.getSkipping()
            if (r2 != 0) goto L_0x001d
            goto L_0x0021
        L_0x001d:
            r14.skipToGroupEnd()
            return
        L_0x0021:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0030
            r2 = -1
            java.lang.String r3 = "coil3.compose.contentOf.<anonymous> (SubcomposeAsyncImage.kt:303)"
            r4 = -1106738291(0xffffffffbe08838d, float:-0.13331433)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x0030:
            coil3.compose.AsyncImagePainter r2 = r13.getPainter()
            kotlinx.coroutines.flow.StateFlow r2 = r2.getState()
            r3 = 0
            r4 = 1
            r5 = 0
            androidx.compose.runtime.State r2 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r2, r5, r14, r3, r4)
            java.lang.Object r2 = r2.getValue()
            coil3.compose.AsyncImagePainter$State r2 = (coil3.compose.AsyncImagePainter.State) r2
            boolean r3 = r2 instanceof coil3.compose.AsyncImagePainter.State.Loading
            if (r3 == 0) goto L_0x006e
            kotlin.jvm.functions.Function4<coil3.compose.SubcomposeAsyncImageScope, coil3.compose.AsyncImagePainter$State$Loading, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r12.$loading
            if (r3 == 0) goto L_0x0064
            r3 = 1362365438(0x51340bfe, float:4.8330957E10)
            r14.startReplaceGroup(r3)
            kotlin.jvm.functions.Function4<coil3.compose.SubcomposeAsyncImageScope, coil3.compose.AsyncImagePainter$State$Loading, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r12.$loading
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.invoke(r13, r2, r14, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r14.endReplaceGroup()
            goto L_0x00b5
        L_0x0064:
            r2 = -716324199(0xffffffffd54dc299, float:-1.41397296E13)
            r14.startReplaceGroup(r2)
            r14.endReplaceGroup()
            goto L_0x00cd
        L_0x006e:
            boolean r3 = r2 instanceof coil3.compose.AsyncImagePainter.State.Success
            if (r3 == 0) goto L_0x0097
            kotlin.jvm.functions.Function4<coil3.compose.SubcomposeAsyncImageScope, coil3.compose.AsyncImagePainter$State$Success, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r12.$success
            if (r3 == 0) goto L_0x008d
            r3 = 1362368446(0x513417be, float:4.8343278E10)
            r14.startReplaceGroup(r3)
            kotlin.jvm.functions.Function4<coil3.compose.SubcomposeAsyncImageScope, coil3.compose.AsyncImagePainter$State$Success, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r12.$success
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.invoke(r13, r2, r14, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r14.endReplaceGroup()
            goto L_0x00b5
        L_0x008d:
            r2 = -716230951(0xffffffffd54f2ed9, float:-1.42375073E13)
            r14.startReplaceGroup(r2)
            r14.endReplaceGroup()
            goto L_0x00cd
        L_0x0097:
            boolean r3 = r2 instanceof coil3.compose.AsyncImagePainter.State.Error
            if (r3 == 0) goto L_0x00c9
            kotlin.jvm.functions.Function4<coil3.compose.SubcomposeAsyncImageScope, coil3.compose.AsyncImagePainter$State$Error, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r12.$error
            if (r3 == 0) goto L_0x00bf
            r3 = 1362371262(0x513422be, float:4.8354812E10)
            r14.startReplaceGroup(r3)
            kotlin.jvm.functions.Function4<coil3.compose.SubcomposeAsyncImageScope, coil3.compose.AsyncImagePainter$State$Error, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r12.$error
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.invoke(r13, r2, r14, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r14.endReplaceGroup()
        L_0x00b5:
            r0 = -715997831(0xffffffffd552bd79, float:-1.44819513E13)
            r14.startReplaceGroup(r0)
        L_0x00bb:
            r14.endReplaceGroup()
            goto L_0x00e5
        L_0x00bf:
            r2 = -716143655(0xffffffffd55083d9, float:-1.43290437E13)
            r14.startReplaceGroup(r2)
            r14.endReplaceGroup()
            goto L_0x00cd
        L_0x00c9:
            boolean r2 = r2 instanceof coil3.compose.AsyncImagePainter.State.Empty
            if (r2 == 0) goto L_0x00ef
        L_0x00cd:
            r2 = 1362375718(0x51343426, float:4.8373064E10)
            r14.startReplaceGroup(r2)
            r10 = r1 & 14
            r11 = 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r0 = r13
            r9 = r14
            coil3.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x00bb
        L_0x00e5:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00ee
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ee:
            return
        L_0x00ef:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.compose.SubcomposeAsyncImageKt$contentOf$1.invoke(coil3.compose.SubcomposeAsyncImageScope, androidx.compose.runtime.Composer, int):void");
    }
}
