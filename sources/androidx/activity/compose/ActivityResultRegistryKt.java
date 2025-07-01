package androidx.activity.compose;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"rememberLauncherForActivityResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "onResult", "Lkotlin/Function1;", "", "(Landroidx/activity/result/contract/ActivityResultContract;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ActivityResultRegistry.kt */
public final class ActivityResultRegistryKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <I, O> androidx.activity.compose.ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(androidx.activity.result.contract.ActivityResultContract<I, O> r11, kotlin.jvm.functions.Function1<? super O, kotlin.Unit> r12, androidx.compose.runtime.Composer r13, int r14) {
        /*
            r0 = -1408504823(0xffffffffac0bec09, float:-1.9884114E-12)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "C(rememberLauncherForActivityResult)86@3568L30,87@3625L30,91@3794L49,*93@3924L7,96@4078L46,97@4152L85,103@4420L204,103@4364L260:ActivityResultRegistry.kt#q1dkbc"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            r0 = r14 & 14
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r11, r13, r0)
            int r1 = r14 >> 3
            r1 = r1 & 14
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r12, r13, r1)
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1 r5 = androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1.INSTANCE
            r6 = r5
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r8 = 3072(0xc00, float:4.305E-42)
            r9 = 6
            r4 = 0
            r5 = 0
            r7 = r13
            java.lang.Object r3 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r3, r4, (java.lang.String) r5, r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            java.lang.String r3 = (java.lang.String) r3
            androidx.activity.compose.LocalActivityResultRegistryOwner r4 = androidx.activity.compose.LocalActivityResultRegistryOwner.INSTANCE
            r6 = 6
            androidx.activity.result.ActivityResultRegistryOwner r4 = r4.getCurrent(r13, r6)
            if (r4 == 0) goto L_0x00d9
            androidx.activity.result.ActivityResultRegistry r4 = r4.getActivityResultRegistry()
            r5 = -1672765924(0xffffffff9c4b9e1c, float:-6.7371417E-22)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):ActivityResultRegistry.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            java.lang.Object r8 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r8 != r9) goto L_0x0059
            androidx.activity.compose.ActivityResultLauncherHolder r8 = new androidx.activity.compose.ActivityResultLauncherHolder
            r8.<init>()
            r13.updateRememberedValue(r8)
        L_0x0059:
            androidx.activity.compose.ActivityResultLauncherHolder r8 = (androidx.activity.compose.ActivityResultLauncherHolder) r8
            r13.endReplaceableGroup()
            r9 = -1672765850(0xffffffff9c4b9e66, float:-6.737179E-22)
            r13.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            java.lang.Object r9 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r9 != r10) goto L_0x007b
            androidx.activity.compose.ManagedActivityResultLauncher r9 = new androidx.activity.compose.ManagedActivityResultLauncher
            r9.<init>(r8, r0)
            r13.updateRememberedValue(r9)
        L_0x007b:
            androidx.activity.compose.ManagedActivityResultLauncher r9 = (androidx.activity.compose.ManagedActivityResultLauncher) r9
            r13.endReplaceableGroup()
            r0 = -1672765582(0xffffffff9c4b9f72, float:-6.7373144E-22)
            r13.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            boolean r0 = r13.changed((java.lang.Object) r8)
            boolean r5 = r13.changed((java.lang.Object) r4)
            r0 = r0 | r5
            boolean r5 = r13.changed((java.lang.Object) r3)
            r0 = r0 | r5
            boolean r5 = r13.changed((java.lang.Object) r11)
            r0 = r0 | r5
            boolean r5 = r13.changed((java.lang.Object) r1)
            r0 = r0 | r5
            java.lang.Object r5 = r13.rememberedValue()
            if (r0 != 0) goto L_0x00b3
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r5 != r0) goto L_0x00b0
            goto L_0x00b3
        L_0x00b0:
            r1 = r3
            r0 = r4
            goto L_0x00c6
        L_0x00b3:
            androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1 r0 = new androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1
            r5 = r1
            r2 = r4
            r1 = r8
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = r2
            r2 = r0
            r0 = r1
            r1 = r3
            r5 = r2
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r13.updateRememberedValue(r5)
        L_0x00c6:
            r3 = r5
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r13.endReplaceableGroup()
            int r2 = r14 << 6
            r5 = r2 & 896(0x380, float:1.256E-42)
            r2 = r11
            r4 = r13
            androidx.compose.runtime.EffectsKt.DisposableEffect(r0, r1, r2, r3, r4, r5)
            r13.endReplaceableGroup()
            return r9
        L_0x00d9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.compose.ActivityResultRegistryKt.rememberLauncherForActivityResult(androidx.activity.result.contract.ActivityResultContract, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):androidx.activity.compose.ManagedActivityResultLauncher");
    }
}
