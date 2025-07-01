package com.plinkofortune.cash.winspin.profile;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.GlobalRepo;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/plinkofortune/cash/winspin/profile/ProfileVIewModel;", "Landroidx/lifecycle/ViewModel;", "appContext", "Landroid/content/Context;", "repo", "Lcom/plinkofortune/cash/winspin/GlobalRepo;", "<init>", "(Landroid/content/Context;Lcom/plinkofortune/cash/winspin/GlobalRepo;)V", "profile", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/plinkofortune/cash/winspin/profile/ProfileData;", "getProfile", "()Lkotlinx/coroutines/flow/StateFlow;", "save", "", "nickname", "", "uri", "Landroid/net/Uri;", "getPath", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ProfileVIewModel.kt */
public final class ProfileVIewModel extends ViewModel {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ViewModelProvider.Factory Factory = new ProfileVIewModel$Companion$Factory$1();
    private final Context appContext;
    private final StateFlow<ProfileData> profile;
    /* access modifiers changed from: private */
    public final GlobalRepo repo;

    public ProfileVIewModel(Context context, GlobalRepo globalRepo) {
        Intrinsics.checkNotNullParameter(context, StringFog.decrypt(new byte[]{17, Ascii.RS, -39, 111, -7, 95, -100, -98, 8, Ascii.SUB}, new byte[]{112, 110, -87, 44, -106, 49, -24, -5}));
        Intrinsics.checkNotNullParameter(globalRepo, StringFog.decrypt(new byte[]{-55, Byte.MIN_VALUE, 62, 59}, new byte[]{-69, -27, 78, 84, Ascii.ESC, Ascii.FS, -73, 43}));
        this.appContext = context;
        this.repo = globalRepo;
        this.profile = FlowKt.stateIn(globalRepo.getProfile(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getEagerly(), null);
    }

    public final StateFlow<ProfileData> getProfile() {
        return this.profile;
    }

    public final void save(String str, Uri uri) {
        Intrinsics.checkNotNullParameter(str, StringFog.decrypt(new byte[]{42, -47, -34, -70, -99, 70, 49, 100}, new byte[]{68, -72, -67, -47, -13, 39, 92, 1}));
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new ProfileVIewModel$save$1(this, uri, str, (Continuation<? super ProfileVIewModel$save$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getPath(android.net.Uri r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x006c }
            android.content.Context r2 = r5.appContext     // Catch:{ Exception -> 0x006c }
            java.io.File r2 = r2.getFilesDir()     // Catch:{ Exception -> 0x006c }
            r3 = 7
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x006c }
            r3 = {19, -100, 68, 54, 0, -89, 101} // fill-array     // Catch:{ Exception -> 0x006c }
            r4 = 8
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x006c }
            r4 = {99, -18, 33, 69, 97, -47, 0, -45} // fill-array     // Catch:{ Exception -> 0x006c }
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r4)     // Catch:{ Exception -> 0x006c }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x006c }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x006c }
            if (r2 == 0) goto L_0x002c
            r1.delete()     // Catch:{ Exception -> 0x006c }
            r1.createNewFile()     // Catch:{ Exception -> 0x006c }
        L_0x002c:
            android.content.Context r2 = r5.appContext     // Catch:{ Exception -> 0x006c }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x006c }
            java.io.InputStream r6 = r2.openInputStream(r6)     // Catch:{ Exception -> 0x006c }
            if (r6 == 0) goto L_0x0067
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ Exception -> 0x006c }
            r2 = r6
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x0060 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0060 }
            r3.<init>(r1)     // Catch:{ all -> 0x0060 }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x0060 }
            r4 = r3
            java.io.FileOutputStream r4 = (java.io.FileOutputStream) r4     // Catch:{ all -> 0x0059 }
            byte[] r2 = kotlin.io.ByteStreamsKt.readBytes(r2)     // Catch:{ all -> 0x0059 }
            r4.write(r2)     // Catch:{ all -> 0x0059 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0059 }
            kotlin.io.CloseableKt.closeFinally(r3, r0)     // Catch:{ all -> 0x0060 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0060 }
            kotlin.io.CloseableKt.closeFinally(r6, r0)     // Catch:{ Exception -> 0x006c }
            goto L_0x0067
        L_0x0059:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x005b }
        L_0x005b:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r1)     // Catch:{ all -> 0x0060 }
            throw r2     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0062 }
        L_0x0062:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r1)     // Catch:{ Exception -> 0x006c }
            throw r2     // Catch:{ Exception -> 0x006c }
        L_0x0067:
            java.lang.String r6 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x006c }
            return r6
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.profile.ProfileVIewModel.getPath(android.net.Uri):java.lang.String");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/plinkofortune/cash/winspin/profile/ProfileVIewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ProfileVIewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return ProfileVIewModel.Factory;
        }
    }
}
