package com.plinkofortune.cash.winspin.profile;

import android.net.Uri;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0002²\u0006\f\u0010\b\u001a\u0004\u0018\u00010\tX\u0002²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\tX\u0002²\u0006\n\u0010\u000b\u001a\u00020\fX\u0002²\u0006\f\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0002"}, d2 = {"ProfileScreen", "", "back", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "profile", "Lcom/plinkofortune/cash/winspin/profile/ProfileData;", "actualPath", "", "actualNickname", "exec", "", "actualUri", "Landroid/net/Uri;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: ProfileScreen.kt */
public final class ProfileScreenKt {
    /* access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$16(Function0 function0, int i, Composer composer, int i2) {
        ProfileScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ProfileScreen(kotlin.jvm.functions.Function0<kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23) {
        /*
            r0 = r21
            r1 = r23
            r2 = 4
            byte[] r3 = new byte[r2]
            r3 = {85, -1, -5, 59} // fill-array
            r4 = 8
            byte[] r5 = new byte[r4]
            r5 = {55, -98, -104, 80, -102, -23, -118, 36} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = -1315622725(0xffffffffb19530bb, float:-4.3420108E-9)
            r5 = r22
            androidx.compose.runtime.Composer r10 = r5.startRestartGroup(r3)
            r3 = r1 & 6
            r13 = 2
            if (r3 != 0) goto L_0x0030
            boolean r3 = r10.changedInstance(r0)
            if (r3 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r2 = r13
        L_0x002e:
            r2 = r2 | r1
            goto L_0x0031
        L_0x0030:
            r2 = r1
        L_0x0031:
            r3 = r2 & 3
            if (r3 != r13) goto L_0x0041
            boolean r3 = r10.getSkipping()
            if (r3 != 0) goto L_0x003c
            goto L_0x0041
        L_0x003c:
            r10.skipToGroupEnd()
            goto L_0x021f
        L_0x0041:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x005e
            r3 = 74
            byte[] r3 = new byte[r3]
            r3 = {-59, 112, 53, 40, 7, -81, -117, -107, -51, 112, 62, 105, 5, -73, -105, -107, -61, 49, 59, 103, 4, -85, -52, -116, -49, 113, 43, 118, 30, -83, -52, -117, -44, 112, 62, 111, 27, -90, -52, -85, -44, 112, 62, 111, 27, -90, -79, -104, -44, 122, 61, 104, 87, -21, -78, -119, -55, 121, 49, 106, 18, -112, -127, -119, -61, 122, 54, 40, 28, -73, -40, -50, -105, 54} // fill-array
            byte[] r5 = new byte[r4]
            r5 = {-90, 31, 88, 6, 119, -61, -30, -5} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r5)
            r5 = -1315622725(0xffffffffb19530bb, float:-4.3420108E-9)
            r6 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r6, r3)
        L_0x005e:
            com.plinkofortune.cash.winspin.profile.ProfileVIewModel$Companion r3 = com.plinkofortune.cash.winspin.profile.ProfileVIewModel.Companion
            androidx.lifecycle.ViewModelProvider$Factory r8 = r3.getFactory()
            r3 = 1729797275(0x671a9c9b, float:7.301333E23)
            r10.startReplaceableGroup(r3)
            r3 = 62
            byte[] r3 = new byte[r3]
            r3 = {-115, -111, 101, 67, 103, 53, -29, -58, -95, -74, 40, 89, 39, 0, -68, -72, -30, -32, 97, 4, 39, 122, -95, -65, -114, -32, 120, 5, 60, 28, -93, -89, -8, -26, 13, 7, 54, 103, -93, -57, -8, -31, 119, 99, 103, 53, -29, -58, -95, -74, 40, 89, 32, 59, -32, -88, -3, -90, 39, 84, 56, 103} // fill-array
            byte[] r5 = new byte[r4]
            r5 = {-50, -46, 77, 53, 14, 80, -108, -117} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner r3 = androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.INSTANCE
            r5 = 6
            androidx.lifecycle.ViewModelStoreOwner r6 = r3.getCurrent(r10, r5)
            if (r6 == 0) goto L_0x022e
            boolean r3 = r6 instanceof androidx.lifecycle.HasDefaultViewModelProviderFactory
            if (r3 == 0) goto L_0x0092
            r3 = r6
            androidx.lifecycle.HasDefaultViewModelProviderFactory r3 = (androidx.lifecycle.HasDefaultViewModelProviderFactory) r3
            androidx.lifecycle.viewmodel.CreationExtras r3 = r3.getDefaultViewModelCreationExtras()
            goto L_0x0096
        L_0x0092:
            androidx.lifecycle.viewmodel.CreationExtras$Empty r3 = androidx.lifecycle.viewmodel.CreationExtras.Empty.INSTANCE
            androidx.lifecycle.viewmodel.CreationExtras r3 = (androidx.lifecycle.viewmodel.CreationExtras) r3
        L_0x0096:
            r9 = r3
            java.lang.Class<com.plinkofortune.cash.winspin.profile.ProfileVIewModel> r3 = com.plinkofortune.cash.winspin.profile.ProfileVIewModel.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            r11 = 0
            r12 = 0
            r7 = 0
            androidx.lifecycle.ViewModel r3 = androidx.lifecycle.viewmodel.compose.ViewModelKt.viewModel(r5, (androidx.lifecycle.ViewModelStoreOwner) r6, (java.lang.String) r7, (androidx.lifecycle.ViewModelProvider.Factory) r8, (androidx.lifecycle.viewmodel.CreationExtras) r9, (androidx.compose.runtime.Composer) r10, (int) r11, (int) r12)
            r10.endReplaceableGroup()
            r16 = r3
            com.plinkofortune.cash.winspin.profile.ProfileVIewModel r16 = (com.plinkofortune.cash.winspin.profile.ProfileVIewModel) r16
            kotlinx.coroutines.flow.StateFlow r3 = r16.getProfile()
            r5 = 1
            r6 = 0
            r7 = 0
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r3, r6, r10, r7, r5)
            com.plinkofortune.cash.winspin.profile.ProfileData r5 = ProfileScreen$lambda$0(r3)
            if (r5 == 0) goto L_0x00c1
            java.lang.String r5 = r5.getPath()
            goto L_0x00c2
        L_0x00c1:
            r5 = r6
        L_0x00c2:
            r8 = -1162592983(0xffffffffbab43d29, float:-0.0013751137)
            r10.startReplaceGroup(r8)
            boolean r5 = r10.changed((java.lang.Object) r5)
            java.lang.Object r8 = r10.rememberedValue()
            if (r5 != 0) goto L_0x00da
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r8 != r5) goto L_0x00ed
        L_0x00da:
            com.plinkofortune.cash.winspin.profile.ProfileData r5 = ProfileScreen$lambda$0(r3)
            if (r5 == 0) goto L_0x00e5
            java.lang.String r5 = r5.getPath()
            goto L_0x00e6
        L_0x00e5:
            r5 = r6
        L_0x00e6:
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r6, r13, r6)
            r10.updateRememberedValue(r8)
        L_0x00ed:
            r19 = r8
            androidx.compose.runtime.MutableState r19 = (androidx.compose.runtime.MutableState) r19
            r10.endReplaceGroup()
            com.plinkofortune.cash.winspin.profile.ProfileData r5 = ProfileScreen$lambda$0(r3)
            if (r5 == 0) goto L_0x00ff
            java.lang.String r5 = r5.getName()
            goto L_0x0100
        L_0x00ff:
            r5 = r6
        L_0x0100:
            r8 = -1162589879(0xffffffffbab44949, float:-0.0013754751)
            r10.startReplaceGroup(r8)
            boolean r5 = r10.changed((java.lang.Object) r5)
            java.lang.Object r8 = r10.rememberedValue()
            if (r5 != 0) goto L_0x0118
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r8 != r5) goto L_0x012b
        L_0x0118:
            com.plinkofortune.cash.winspin.profile.ProfileData r3 = ProfileScreen$lambda$0(r3)
            if (r3 == 0) goto L_0x0123
            java.lang.String r3 = r3.getName()
            goto L_0x0124
        L_0x0123:
            r3 = r6
        L_0x0124:
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r6, r13, r6)
            r10.updateRememberedValue(r8)
        L_0x012b:
            r15 = r8
            androidx.compose.runtime.MutableState r15 = (androidx.compose.runtime.MutableState) r15
            r10.endReplaceGroup()
            r3 = -1162587118(0xffffffffbab45412, float:-0.0013757965)
            r10.startReplaceGroup(r3)
            java.lang.Object r3 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r3 != r5) goto L_0x014e
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r6, r13, r6)
            r10.updateRememberedValue(r3)
        L_0x014e:
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            r10.endReplaceGroup()
            r5 = -1162584719(0xffffffffbab45d71, float:-0.0013760758)
            r10.startReplaceGroup(r5)
            java.lang.Object r5 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r5 != r8) goto L_0x016c
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r6, r13, r6)
            r10.updateRememberedValue(r5)
        L_0x016c:
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            r10.endReplaceGroup()
            androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia r8 = new androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia
            r8.<init>()
            androidx.activity.result.contract.ActivityResultContract r8 = (androidx.activity.result.contract.ActivityResultContract) r8
            r9 = -1162579254(0xffffffffbab472ca, float:-0.001376712)
            r10.startReplaceGroup(r9)
            java.lang.Object r9 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r9 != r11) goto L_0x0192
            com.plinkofortune.cash.winspin.profile.ProfileScreenKt$$ExternalSyntheticLambda0 r9 = new com.plinkofortune.cash.winspin.profile.ProfileScreenKt$$ExternalSyntheticLambda0
            r9.<init>(r5)
            r10.updateRememberedValue(r9)
        L_0x0192:
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r10.endReplaceGroup()
            r11 = 48
            androidx.activity.compose.ManagedActivityResultLauncher r17 = androidx.activity.compose.ActivityResultRegistryKt.rememberLauncherForActivityResult(r8, r9, r10, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 29
            byte[] r9 = new byte[r9]
            r9 = {-71, 95, -95, 4, -70, -108, 79, -105, -119, 117, -17, 46, -70, -105, 115, -105, -103, 125, -9, 105, -66, -115, 28, -63, -109, 123, -15, 32, -91} // fill-array
            byte[] r4 = new byte[r4]
            r4 = {-6, 28, -101, 71, -43, -7, 63, -8} // fill-array
            java.lang.String r4 = com.plinkofortune.cash.winspin.StringFog.decrypt(r9, r4)
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r9, r4)
            java.lang.Object r4 = r10.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            android.content.Context r4 = (android.content.Context) r4
            boolean r8 = ProfileScreen$lambda$8(r3)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r9 = -1162575766(0xffffffffbab4806a, float:-0.001377118)
            r10.startReplaceGroup(r9)
            boolean r9 = r10.changedInstance(r4)
            boolean r11 = r10.changed((java.lang.Object) r15)
            r9 = r9 | r11
            java.lang.Object r11 = r10.rememberedValue()
            if (r9 != 0) goto L_0x01e7
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r11 != r9) goto L_0x01f2
        L_0x01e7:
            com.plinkofortune.cash.winspin.profile.ProfileScreenKt$ProfileScreen$1$1 r9 = new com.plinkofortune.cash.winspin.profile.ProfileScreenKt$ProfileScreen$1$1
            r9.<init>(r4, r3, r15, r6)
            r11 = r9
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateRememberedValue(r11)
        L_0x01f2:
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.endReplaceGroup()
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r8, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r11, (androidx.compose.runtime.Composer) r10, (int) r7)
            com.plinkofortune.cash.winspin.profile.ProfileScreenKt$ProfileScreen$2 r14 = new com.plinkofortune.cash.winspin.profile.ProfileScreenKt$ProfileScreen$2
            r20 = r3
            r18 = r5
            r14.<init>(r15, r16, r17, r18, r19, r20)
            r3 = 985285840(0x3aba44d0, float:0.0014211182)
            r4 = 1
            r5 = 54
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r3, r4, r14, r10, r5)
            kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
            r2 = r2 & 14
            r2 = r2 | 48
            com.plinkofortune.cash.winspin.ToolbarColumnKt.ToolbarColumn(r0, r3, r10, r2)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x021f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x021f:
            androidx.compose.runtime.ScopeUpdateScope r2 = r10.endRestartGroup()
            if (r2 == 0) goto L_0x022d
            com.plinkofortune.cash.winspin.profile.ProfileScreenKt$$ExternalSyntheticLambda1 r3 = new com.plinkofortune.cash.winspin.profile.ProfileScreenKt$$ExternalSyntheticLambda1
            r3.<init>(r0, r1)
            r2.updateScope(r3)
        L_0x022d:
            return
        L_0x022e:
            r0 = 64
            byte[] r0 = new byte[r0]
            r0 = {-57, -88, 64, 126, 39, -66, 78, -40, -26, -93, 5, 68, 29, -81, 86, -25, -20, -120, 23, 70, 43, -87, 25, -30, -24, -76, 64, 88, 60, -76, 79, -4, -19, -94, 4, 8, 56, -78, 88, -75, -59, -88, 3, 73, 34, -115, 80, -16, -2, -118, 15, 76, 43, -73, 106, -31, -26, -75, 5, 103, 57, -75, 92, -25} // fill-array
            byte[] r1 = new byte[r4]
            r1 = {-119, -57, 96, 40, 78, -37, 57, -107} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r1)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.profile.ProfileScreenKt.ProfileScreen(kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final String ProfileScreen$lambda$2(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final String ProfileScreen$lambda$5(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final boolean ProfileScreen$lambda$8(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void ProfileScreen$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static final Uri ProfileScreen$lambda$11(MutableState<Uri> mutableState) {
        return (Uri) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final Unit ProfileScreen$lambda$14$lambda$13(MutableState mutableState, Uri uri) {
        ProfileScreen$lambda$12(mutableState, uri);
        return Unit.INSTANCE;
    }

    private static final ProfileData ProfileScreen$lambda$0(State<ProfileData> state) {
        return state.getValue();
    }

    private static final void ProfileScreen$lambda$3(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* access modifiers changed from: private */
    public static final void ProfileScreen$lambda$6(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    private static final void ProfileScreen$lambda$12(MutableState<Uri> mutableState, Uri uri) {
        mutableState.setValue(uri);
    }
}
