package com.plinkofortune.cash.winspin;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u000b\u001a\u00020\u0006*\u00020\u0002\u001a\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@¢\u0006\u0002\u0010\u0015\"%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"repo", "Lcom/plinkofortune/cash/winspin/GlobalRepo;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "storage", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getStorage", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "storage$delegate", "Lkotlin/properties/ReadOnlyProperty;", "appContext", "pream", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getPream", "()Landroidx/datastore/preferences/core/Preferences$Key;", "makePream", "", "root", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: GlobalRepo.kt */
public final class GlobalRepoKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GlobalRepoKt.class, StringFog.decrypt(new byte[]{-28, -31, 87, 124, -90, -91, -59}, new byte[]{-105, -107, 56, Ascii.SO, -57, -62, -96, 112}), StringFog.decrypt(new byte[]{-84, Ascii.FF, -64, Ascii.EM, -116, -4, Ascii.DC4, 113, -84, Ascii.FF, -100, 6, -103, -3, 2, 98, -92, 0, -48, 101, -101, -4, 8, 100, -82, 7, -64, 101, -69, -4, 8, 100, -82, 17, -64, 113, -47, -33, 7, 126, -81, Ascii.ESC, -37, 35, -100, -21, 73, 116, -86, Ascii.GS, -43, 57, -116, -4, Ascii.DC4, 117, -28, 10, -37, 56, -99, -68, 34, 113, -65, 8, -25, 62, -105, -31, 3, 43}, new byte[]{-53, 105, -76, 74, -8, -109, 102, Ascii.DLE}), 1))};
    private static final Preferences.Key<String> pream = PreferencesKeys.stringKey(StringFog.decrypt(new byte[]{85, 108, -31, -40, Ascii.DC2}, new byte[]{37, Ascii.RS, -124, -71, Byte.MAX_VALUE, 34, 9, Ascii.DC4}));
    private static final ReadOnlyProperty storage$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default(StringFog.decrypt(new byte[]{103, 3, -86, 40}, new byte[]{52, 119, -51, 73, 75, Ascii.DLE, Ascii.FF, 95}), (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);

    public static final GlobalRepo repo(CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(creationExtras, StringFog.decrypt(new byte[]{Utf8.REPLACEMENT_BYTE, -4, -35, SignedBytes.MAX_POWER_OF_TWO, -119, 93}, new byte[]{3, -120, -75, 41, -6, 99, Ascii.DC4, Ascii.DC2}));
        Object obj = creationExtras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
        Intrinsics.checkNotNull(obj, StringFog.decrypt(new byte[]{33, -48, 55, 53, -82, -83, -119, -123, 33, -54, 47, 121, -20, -85, -56, -120, 46, -42, 47, 121, -6, -95, -56, -123, 32, -53, 118, 55, -5, -94, -124, -53, 59, -36, 43, 60, -82, -83, -121, -122, 97, -43, 55, 48, -32, -91, -121, -115, 32, -41, 47, 44, -32, -85, -58, -120, 46, -42, 51, 119, -7, -89, -122, -104, Utf8.REPLACEMENT_BYTE, -52, 53, 119, -49, -66, -104}, new byte[]{79, -91, 91, 89, -114, -50, -24, -21}));
        return ((App) obj).getStorage();
    }

    public static final DataStore<Preferences> getStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, StringFog.decrypt(new byte[]{-12, -85, -120, -60, Ascii.DLE, -107}, new byte[]{-56, -33, -32, -83, 99, -85, 83, 38}));
        return (DataStore) storage$delegate.getValue(context, $$delegatedProperties[0]);
    }

    public static final Context appContext(CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(creationExtras, StringFog.decrypt(new byte[]{36, -11, 42, -4, -6, -27}, new byte[]{Ascii.CAN, -127, 66, -107, -119, -37, -25, 99}));
        Object obj = creationExtras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
        if (obj != null) {
            return (Context) obj;
        }
        throw new IllegalArgumentException(StringFog.decrypt(new byte[]{-26, -117, 5, Utf8.REPLACEMENT_BYTE, Byte.MAX_VALUE, Ascii.DC2, 84, Byte.MIN_VALUE, -108, -104, Ascii.NAK, 38, 99, 5, 17, -109, -43, -99, 84, 36, 99, Ascii.FF, 93, -54}, new byte[]{-76, -18, 116, 74, Ascii.SYN, 96, 49, -28}).toString());
    }

    public static final Preferences.Key<String> getPream() {
        return pream;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00fa, code lost:
        if (r11 == r3) goto L_0x0325;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0164, code lost:
        if (androidx.datastore.preferences.core.PreferencesKt.edit(getStorage(r0), new com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$2((kotlin.coroutines.Continuation<? super com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$2>) null), r2) == r3) goto L_0x0325;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x016a, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01b4, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(((androidx.datastore.preferences.core.Preferences) r1).get(pream), (java.lang.Object) com.plinkofortune.cash.winspin.StringFog.decrypt(new byte[]{-51, 2, -11, -120, com.google.common.base.Ascii.RS}, new byte[]{-67, 112, -102, -27, 113, com.google.common.base.Ascii.CR, 118, 119})) == false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01b8, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x01b9, code lost:
        r1 = com.plinkofortune.cash.winspin.leader.DROmTAqXrak.INSTANCE.zvSyKlNrddQ(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01d5, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) com.plinkofortune.cash.winspin.StringFog.decrypt(new byte[]{-28}, new byte[]{-44, Byte.MAX_VALUE, 17, 112, 68, 74, -22, -80})) != false) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        com.google.firebase.messaging.FirebaseMessaging.getInstance().deleteToken();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x02ed, code lost:
        if (androidx.datastore.preferences.core.PreferencesKt.edit(getStorage(r11), new com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$3((kotlin.coroutines.Continuation<? super com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$3>) null), r2) != r3) goto L_0x02f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x02f2, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0323, code lost:
        if (androidx.datastore.preferences.core.PreferencesKt.edit(getStorage(r0), new com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$4((kotlin.coroutines.Continuation<? super com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$4>) null), r2) == r3) goto L_0x0325;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0328, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object makePream(androidx.fragment.app.FragmentActivity r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$1
            if (r2 == 0) goto L_0x001a
            r2 = r1
            com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$1 r2 = (com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x001a
            int r1 = r2.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 - r3
            r2.label = r1
            goto L_0x001f
        L_0x001a:
            com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$1 r2 = new com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$1
            r2.<init>(r1)
        L_0x001f:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 5
            r6 = 0
            r7 = 2
            r8 = 8
            r9 = 1
            r10 = 0
            switch(r4) {
                case 0: goto L_0x00de;
                case 1: goto L_0x00c8;
                case 2: goto L_0x00c3;
                case 3: goto L_0x00aa;
                case 4: goto L_0x0091;
                case 5: goto L_0x006f;
                case 6: goto L_0x005a;
                case 7: goto L_0x0055;
                case 8: goto L_0x004c;
                case 9: goto L_0x0047;
                default: goto L_0x0031;
            }
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = 47
            byte[] r1 = new byte[r1]
            r1 = {29, 52, 25, 70, 111, 71, 29, 15, 89, 39, 16, 89, 58, 94, 23, 8, 94, 55, 16, 76, 32, 65, 23, 15, 89, 60, 27, 92, 32, 88, 23, 8, 94, 34, 28, 94, 39, 19, 17, 64, 12, 58, 0, 94, 38, 93, 23} // fill-array
            byte[] r2 = new byte[r8]
            r2 = {126, 85, 117, 42, 79, 51, 114, 47} // fill-array
            java.lang.String r1 = com.plinkofortune.cash.winspin.StringFog.decrypt(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0326
        L_0x004c:
            java.lang.Object r0 = r2.L$0
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x030c
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x02f0
        L_0x005a:
            java.lang.Object r0 = r2.L$3
            kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
            java.lang.Object r4 = r2.L$2
            com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT r4 = (com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT) r4
            java.lang.Object r5 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r11 = r2.L$0
            androidx.fragment.app.FragmentActivity r11 = (androidx.fragment.app.FragmentActivity) r11
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x02b1
        L_0x006f:
            java.lang.Object r0 = r2.L$5
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r4 = r2.L$4
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.L$3
            kotlin.jvm.internal.Ref$BooleanRef r5 = (kotlin.jvm.internal.Ref.BooleanRef) r5
            java.lang.Object r11 = r2.L$2
            com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT r11 = (com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT) r11
            java.lang.Object r12 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$0
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            kotlin.ResultKt.throwOnFailure(r1)
            r16 = r5
            r5 = r4
            r4 = r16
            goto L_0x0239
        L_0x0091:
            java.lang.Object r0 = r2.L$4
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r4 = r2.L$3
            kotlin.jvm.internal.Ref$BooleanRef r4 = (kotlin.jvm.internal.Ref.BooleanRef) r4
            java.lang.Object r11 = r2.L$2
            com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT r11 = (com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT) r11
            java.lang.Object r12 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$0
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0216
        L_0x00aa:
            java.lang.Object r0 = r2.L$4
            kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
            java.lang.Object r4 = r2.L$3
            kotlin.jvm.internal.Ref$BooleanRef r4 = (kotlin.jvm.internal.Ref.BooleanRef) r4
            java.lang.Object r11 = r2.L$2
            com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT r11 = (com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT) r11
            java.lang.Object r12 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$0
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x019a
        L_0x00c3:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0168
        L_0x00c8:
            java.lang.Object r0 = r2.L$2
            com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT r0 = (com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT) r0
            java.lang.Object r4 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r11 = r2.L$0
            androidx.fragment.app.FragmentActivity r11 = (androidx.fragment.app.FragmentActivity) r11
            kotlin.ResultKt.throwOnFailure(r1)
            r16 = r1
            r1 = r0
            r0 = r11
            r11 = r16
            goto L_0x00fe
        L_0x00de:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT r1 = new com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT
            r11 = r0
            android.content.Context r11 = (android.content.Context) r11
            r1.<init>(r11)
            r2.L$0 = r0
            r2.L$1 = r4
            r2.L$2 = r1
            r2.label = r9
            java.lang.Object r11 = r1.guXQOalOMxh(r2)
            if (r11 != r3) goto L_0x00fe
            goto L_0x0325
        L_0x00fe:
            java.lang.String r11 = (java.lang.String) r11
            kotlin.jvm.internal.Ref$BooleanRef r12 = new kotlin.jvm.internal.Ref$BooleanRef
            r12.<init>()
            r12.element = r9
            kotlin.jvm.internal.Ref$BooleanRef r13 = new kotlin.jvm.internal.Ref$BooleanRef
            r13.<init>()
            r14 = r11
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            if (r14 == 0) goto L_0x016b
            int r14 = r14.length()
            if (r14 != 0) goto L_0x0118
            goto L_0x016b
        L_0x0118:
            r13.element = r9
            com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$dHViWkENtHQ$1 r1 = new com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$dHViWkENtHQ$1
            r1.<init>(r12, r13, r0, r4)
            com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL r5 = new com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL
            com.plinkofortune.cash.winspin.terms.BkcRXzpXGNH r1 = (com.plinkofortune.cash.winspin.terms.BkcRXzpXGNH) r1
            com.plinkofortune.cash.winspin.profile.XTFyRyDbXjP r6 = com.plinkofortune.cash.winspin.profile.XTFyRyDbXjP.GlCXFNiLeCx
            r5.<init>(r0, r1, r6)
            r4.element = r5
            T r1 = r4.element
            com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL r1 = (com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL) r1
            r4 = 73
            byte[] r4 = new byte[r4]
            r4 = {63, 58, 25, -125, -54, -124, -96, -30, 63, 32, 1, -49, -120, -126, -31, -17, 48, 60, 1, -49, -98, -120, -31, -30, 62, 33, 88, -127, -97, -117, -83, -84, 37, 54, 5, -118, -54, -124, -82, -31, 127, 63, 25, -122, -124, -116, -82, -22, 62, 61, 1, -102, -124, -126, -17, -17, 48, 60, 29, -63, -99, -114, -81, -1, 33, 38, 27, -63, -71, -120, -83, -23, 32} // fill-array
            byte[] r5 = new byte[r8]
            r5 = {81, 79, 117, -17, -22, -25, -63, -116} // fill-array
            java.lang.String r4 = com.plinkofortune.cash.winspin.StringFog.decrypt(r4, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r4)
            r4 = r0
            com.plinkofortune.cash.winspin.Soleq r4 = (com.plinkofortune.cash.winspin.Soleq) r4
            android.os.Bundle r4 = r4.command()
            r1.load(r11, r4)
            android.content.Context r0 = (android.content.Context) r0
            androidx.datastore.core.DataStore r0 = getStorage(r0)
            com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$2 r1 = new com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$2
            r1.<init>(r10)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2.L$0 = r10
            r2.L$1 = r10
            r2.L$2 = r10
            r2.label = r7
            java.lang.Object r0 = androidx.datastore.preferences.core.PreferencesKt.edit(r0, r1, r2)
            if (r0 != r3) goto L_0x0168
            goto L_0x0325
        L_0x0168:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x016b:
            r11 = r0
            android.content.Context r11 = (android.content.Context) r11
            androidx.datastore.core.DataStore r11 = getStorage(r11)
            kotlinx.coroutines.flow.Flow r11 = r11.getData()
            r2.L$0 = r0
            r2.L$1 = r4
            r2.L$2 = r1
            r2.L$3 = r12
            r2.L$4 = r13
            r14 = 3
            r2.label = r14
            java.lang.Object r11 = kotlinx.coroutines.flow.FlowKt.first(r11, r2)
            if (r11 != r3) goto L_0x018b
            goto L_0x0325
        L_0x018b:
            r16 = r13
            r13 = r0
            r0 = r16
            r16 = r11
            r11 = r1
            r1 = r16
            r16 = r12
            r12 = r4
            r4 = r16
        L_0x019a:
            androidx.datastore.preferences.core.Preferences r1 = (androidx.datastore.preferences.core.Preferences) r1
            androidx.datastore.preferences.core.Preferences$Key<java.lang.String> r14 = pream
            java.lang.Object r1 = r1.get(r14)
            byte[] r14 = new byte[r5]
            r14 = {-51, 2, -11, -120, 30} // fill-array
            byte[] r15 = new byte[r8]
            r15 = {-67, 112, -102, -27, 113, 13, 118, 119} // fill-array
            java.lang.String r14 = com.plinkofortune.cash.winspin.StringFog.decrypt(r14, r15)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r14)
            if (r1 == 0) goto L_0x01b9
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01b9:
            com.plinkofortune.cash.winspin.leader.DROmTAqXrak r1 = com.plinkofortune.cash.winspin.leader.DROmTAqXrak.INSTANCE
            r14 = r13
            android.content.Context r14 = (android.content.Context) r14
            java.lang.String r1 = r1.zvSyKlNrddQ(r14)
            byte[] r14 = new byte[r9]
            r15 = -28
            r14[r6] = r15
            byte[] r15 = new byte[r8]
            r15 = {-44, 127, 17, 112, 68, 74, -22, -80} // fill-array
            java.lang.String r14 = com.plinkofortune.cash.winspin.StringFog.decrypt(r14, r15)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r14)
            if (r14 != 0) goto L_0x01de
            com.google.firebase.messaging.FirebaseMessaging r14 = com.google.firebase.messaging.FirebaseMessaging.getInstance()     // Catch:{ Exception -> 0x01de }
            r14.deleteToken()     // Catch:{ Exception -> 0x01de }
        L_0x01de:
            com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$dHViWkENtHQ$2 r14 = new com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$dHViWkENtHQ$2
            r14.<init>(r4, r0, r13, r12)
            com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL r4 = new com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL
            com.plinkofortune.cash.winspin.terms.BkcRXzpXGNH r14 = (com.plinkofortune.cash.winspin.terms.BkcRXzpXGNH) r14
            com.plinkofortune.cash.winspin.profile.XTFyRyDbXjP r15 = com.plinkofortune.cash.winspin.profile.XTFyRyDbXjP.GlCXFNiLeCx
            r4.<init>(r13, r14, r15)
            r12.element = r4
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$iQLhOuiIOxLa$1 r14 = new com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$iQLhOuiIOxLa$1
            r14.<init>(r13, r10)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r2.L$0 = r13
            r2.L$1 = r12
            r2.L$2 = r11
            r2.L$3 = r0
            r2.L$4 = r1
            r15 = 4
            r2.label = r15
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.withContext(r4, r14, r2)
            if (r4 != r3) goto L_0x0210
            goto L_0x0325
        L_0x0210:
            r16 = r4
            r4 = r0
            r0 = r1
            r1 = r16
        L_0x0216:
            java.lang.String r1 = (java.lang.String) r1
            com.plinkofortune.cash.winspin.seq.models.ZcTgPSXUgvzR r14 = com.plinkofortune.cash.winspin.seq.models.ZcTgPSXUgvzR.INSTANCE
            r15 = r13
            android.content.Context r15 = (android.content.Context) r15
            r2.L$0 = r13
            r2.L$1 = r12
            r2.L$2 = r11
            r2.L$3 = r4
            r2.L$4 = r0
            r2.L$5 = r1
            r2.label = r5
            java.lang.Object r5 = r14.bFIlzUavKeP(r15, r2)
            if (r5 != r3) goto L_0x0233
            goto L_0x0325
        L_0x0233:
            r16 = r5
            r5 = r0
            r0 = r1
            r1 = r16
        L_0x0239:
            java.lang.String r1 = (java.lang.String) r1
            com.plinkofortune.cash.winspin.policy.MjGvsjnRgWW r14 = new com.plinkofortune.cash.winspin.policy.MjGvsjnRgWW
            r14.<init>()
            r14.hJAUnFCEodUQ(r1)
            com.plinkofortune.cash.winspin.seq.models.BallInScreen$Companion r14 = com.plinkofortune.cash.winspin.seq.models.BallInScreen.Companion
            java.lang.String r14 = r14.getBall()
            java.lang.String r15 = com.plinkofortune.cash.winspin.nav.DMM.getAbValue()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r14)
            java.lang.String r14 = "privacypolicy/?8cl6zav32diiat="
            java.lang.StringBuilder r9 = r9.append(r14)
            java.lang.StringBuilder r0 = r9.append(r0)
            java.lang.String r9 = "&fnzodbsre6pxx8iax="
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "&mxy8kvszctkvqc2i="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r1 = "&qy9agp2qhrd8iq=darkmode|pip&30lfhoeu46="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r15)
            java.lang.String r0 = r0.toString()
            T r1 = r12.element
            com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL r1 = (com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL) r1
            r5 = 10
            byte[] r5 = new byte[r5]
            r5 = {-102, 53, 54, 2, 34, 99, 55, -50, -125, 34} // fill-array
            byte[] r9 = new byte[r8]
            r9 = {-24, 84, 83, 108, 86, 84, 14, -71} // fill-array
            java.lang.String r5 = com.plinkofortune.cash.winspin.StringFog.decrypt(r5, r9)
            r2.L$0 = r13
            r2.L$1 = r12
            r2.L$2 = r11
            r2.L$3 = r4
            r2.L$4 = r10
            r2.L$5 = r10
            r9 = 6
            r2.label = r9
            java.lang.Object r1 = r1.awaitUrl(r0, r5, r2)
            if (r1 != r3) goto L_0x02ad
            goto L_0x0325
        L_0x02ad:
            r0 = r4
            r4 = r11
            r5 = r12
            r11 = r13
        L_0x02b1:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r9 = java.lang.String.valueOf(r1)
            com.plinkofortune.cash.winspin.seq.models.BallInScreen$Companion r12 = com.plinkofortune.cash.winspin.seq.models.BallInScreen.Companion
            java.lang.String r12 = r12.getBall()
            boolean r6 = kotlin.text.StringsKt.startsWith$default(r9, r12, r6, r7, r10)
            if (r6 == 0) goto L_0x02f3
            T r0 = r5.element
            com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL r0 = (com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL) r0
            r0.disableBackPressCallback()
            com.google.firebase.messaging.FirebaseMessaging r0 = com.google.firebase.messaging.FirebaseMessaging.getInstance()     // Catch:{ Exception -> 0x02d1 }
            r0.deleteToken()     // Catch:{ Exception -> 0x02d1 }
        L_0x02d1:
            android.content.Context r11 = (android.content.Context) r11
            androidx.datastore.core.DataStore r0 = getStorage(r11)
            com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$3 r1 = new com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$3
            r1.<init>(r10)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2.L$0 = r10
            r2.L$1 = r10
            r2.L$2 = r10
            r2.L$3 = r10
            r4 = 7
            r2.label = r4
            java.lang.Object r0 = androidx.datastore.preferences.core.PreferencesKt.edit(r0, r1, r2)
            if (r0 != r3) goto L_0x02f0
            goto L_0x0325
        L_0x02f0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x02f3:
            r5 = 1
            r0.element = r5
            java.lang.String r0 = java.lang.String.valueOf(r1)
            r2.L$0 = r11
            r2.L$1 = r10
            r2.L$2 = r10
            r2.L$3 = r10
            r2.label = r8
            java.lang.Object r0 = r4.dpkCiLFfTmD(r0, r2)
            if (r0 != r3) goto L_0x030b
            goto L_0x0325
        L_0x030b:
            r0 = r11
        L_0x030c:
            android.content.Context r0 = (android.content.Context) r0
            androidx.datastore.core.DataStore r0 = getStorage(r0)
            com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$4 r1 = new com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$4
            r1.<init>(r10)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2.L$0 = r10
            r4 = 9
            r2.label = r4
            java.lang.Object r0 = androidx.datastore.preferences.core.PreferencesKt.edit(r0, r1, r2)
            if (r0 != r3) goto L_0x0326
        L_0x0325:
            return r3
        L_0x0326:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.GlobalRepoKt.makePream(androidx.fragment.app.FragmentActivity, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
