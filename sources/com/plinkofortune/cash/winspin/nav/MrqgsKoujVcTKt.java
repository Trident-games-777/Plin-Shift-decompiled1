package com.plinkofortune.cash.winspin.nav;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"%\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"kAkoxkZYxfv", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getKAkoxkZYxfv", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "kAkoxkZYxfv$delegate", "Lkotlin/properties/ReadOnlyProperty;", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: MrqgsKoujVcT.kt */
public final class MrqgsKoujVcTKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MrqgsKoujVcTKt.class, StringFog.decrypt(new byte[]{-66, -121, -14, 51, -19, -94, -79, -83, -83, -96, -17}, new byte[]{-43, -58, -103, 92, -107, -55, -21, -12}), StringFog.decrypt(new byte[]{-39, Ascii.VT, 67, 55, -49, -66, 56, -103, -43, 52, 110, 4, -24, -93, Byte.MAX_VALUE, -83, -33, 0, 83, Ascii.SO, -31, -68, 51, -50, -35, 1, 89, 8, -21, -69, 35, -50, -3, 1, 89, 8, -21, -83, 35, -38, -105, 34, 86, Ascii.DC2, -22, -89, 56, -120, -38, Ascii.SYN, Ascii.CAN, Ascii.CAN, -17, -95, 54, -110, -54, 1, 69, Ascii.EM, -95, -74, 56, -109, -37, 65, 115, Ascii.GS, -6, -76, 4, -107, -47, Ascii.FS, 82, 71}, new byte[]{-66, 110, 55, 124, -114, -43, 87, -31}), 1))};
    private static final ReadOnlyProperty kAkoxkZYxfv$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default(StringFog.decrypt(new byte[]{-13, -49, -94, -54, 87, -29, -4, -13, -18, -14, -126, -15}, new byte[]{-126, -117, -8, -65, 37, -105, -122, -117}), (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);

    /* access modifiers changed from: private */
    public static final DataStore<Preferences> getKAkoxkZYxfv(Context context) {
        return (DataStore) kAkoxkZYxfv$delegate.getValue(context, $$delegatedProperties[0]);
    }
}
