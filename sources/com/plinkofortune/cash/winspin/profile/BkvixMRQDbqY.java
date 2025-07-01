package com.plinkofortune.cash.winspin.profile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.FilesKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okio.Utf8;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007JD\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2$\u0010\u000b\u001a \u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u000e\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J<\u0010\u0012\u001a\u00020\u00072$\u0010\u000b\u001a \u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u000e\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/plinkofortune/cash/winspin/profile/BkvixMRQDbqY;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "save", "", "restore", "savedInstanceState", "Landroid/os/Bundle;", "function", "Lkotlin/reflect/KFunction2;", "", "Lkotlin/Function1;", "Landroid/webkit/WebView;", "ifDoNotRestoreState", "Lkotlin/Function0;", "restoreFromFile", "getListOfWebViews", "", "readBundleFromFile", "fileName", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: BkvixMRQDbqY.kt */
public final class BkvixMRQDbqY {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final FragmentActivity activity;

    public BkvixMRQDbqY(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, StringFog.decrypt(new byte[]{75, 51, 53, -18, 76, -38, -22, 48}, new byte[]{42, 80, 65, -121, 58, -77, -98, 73}));
        this.activity = fragmentActivity;
    }

    public final void save() {
        List<WebView> list;
        int i;
        int i2;
        byte[] bArr;
        List<WebView> list2;
        List<WebView> listOfWebViews = getListOfWebViews();
        if (!listOfWebViews.isEmpty()) {
            int i3 = 1;
            int i4 = 0;
            int i5 = 8;
            File file = new File(this.activity.getCacheDir(), StringFog.decrypt(new byte[]{-97}, new byte[]{-20, 32, 105, Ascii.NAK, 53, -20, -1, 117}));
            if (!file.exists()) {
                file.mkdir();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
            File file2 = new File(this.activity.getCacheDir(), StringFog.decrypt(new byte[]{-6, -92}, new byte[]{-119, -48, 41, -12, -26, -19, -117, 62}));
            if (!file2.exists()) {
                file2.mkdir();
            }
            File[] listFiles2 = file2.listFiles();
            if (listFiles2 != null) {
                for (File delete2 : listFiles2) {
                    delete2.delete();
                }
            }
            File file3 = new File(this.activity.getCacheDir(), StringFog.decrypt(new byte[]{38}, new byte[]{66, 120, -93, 107, -26, Ascii.SYN, -17, -99}));
            if (!file3.exists()) {
                file3.mkdir();
            }
            File[] listFiles3 = file3.listFiles();
            if (listFiles3 != null) {
                for (File delete3 : listFiles3) {
                    delete3.delete();
                }
            }
            int i6 = 0;
            for (Object next : listOfWebViews) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                WebView webView = (WebView) next;
                Bundle bundle = new Bundle();
                if (webView.saveState(bundle) != null) {
                    byte[] bArr2 = new byte[i5];
                    // fill-array-data instruction
                    bArr2[0] = 123;
                    bArr2[1] = 3;
                    bArr2[2] = -47;
                    bArr2[3] = -70;
                    bArr2[4] = 28;
                    bArr2[5] = -39;
                    bArr2[6] = 37;
                    bArr2[7] = 101;
                    SharedPreferences sharedPreferences = this.activity.getSharedPreferences(StringFog.decrypt(new byte[]{Ascii.FF, 80, -91, -37, 104, -68}, bArr2), i4);
                    byte[] bArr3 = new byte[i5];
                    // fill-array-data instruction
                    bArr3[0] = -47;
                    bArr3[1] = -11;
                    bArr3[2] = -100;
                    bArr3[3] = 54;
                    bArr3[4] = -65;
                    bArr3[5] = 102;
                    bArr3[6] = 12;
                    bArr3[7] = 26;
                    Intrinsics.checkNotNullExpressionValue(sharedPreferences, StringFog.decrypt(new byte[]{-74, -112, -24, 101, -41, 7, 126, Byte.MAX_VALUE, -75, -91, -18, 83, -39, 3, 126, Byte.MAX_VALUE, -65, -106, -7, 69, -105, 72, 34, 52, -8}, bArr3));
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    byte[] bArr4 = new byte[i5];
                    // fill-array-data instruction
                    bArr4[0] = -100;
                    bArr4[1] = 38;
                    bArr4[2] = -19;
                    bArr4[3] = 103;
                    bArr4[4] = 17;
                    bArr4[5] = -114;
                    bArr4[6] = -52;
                    bArr4[7] = -115;
                    edit.putInt(StringFog.decrypt(new byte[]{-14, 105, -102}, bArr4), CollectionsKt.getLastIndex(listOfWebViews));
                    edit.commit();
                    try {
                        FilesKt.writeText$default(new File(file, String.valueOf(i6)), String.valueOf(webView.getScrollY()), (Charset) null, 2, (Object) null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    File file4 = new File(file3, String.valueOf(i6));
                    List<Fragment> fragments = this.activity.getSupportFragmentManager().getFragments();
                    byte[] bArr5 = new byte[i5];
                    // fill-array-data instruction
                    bArr5[0] = 114;
                    bArr5[1] = -12;
                    bArr5[2] = 78;
                    bArr5[3] = -90;
                    bArr5[4] = 61;
                    bArr5[5] = -58;
                    bArr5[6] = 78;
                    bArr5[7] = -38;
                    Intrinsics.checkNotNullExpressionValue(fragments, StringFog.decrypt(new byte[]{Ascii.NAK, -111, 58, -32, 79, -89, 41, -73, Ascii.ETB, -102, 58, -43, Ascii.NAK, -24, 96, -12, 91}, bArr5));
                    if (!fragments.isEmpty()) {
                        List<Fragment> fragments2 = this.activity.getSupportFragmentManager().getFragments();
                        byte[] bArr6 = new byte[i5];
                        // fill-array-data instruction
                        bArr6[0] = 26;
                        bArr6[1] = -57;
                        bArr6[2] = 81;
                        bArr6[3] = -108;
                        bArr6[4] = -88;
                        bArr6[5] = -19;
                        bArr6[6] = -85;
                        bArr6[7] = -60;
                        Intrinsics.checkNotNullExpressionValue(fragments2, StringFog.decrypt(new byte[]{125, -94, 37, -46, -38, -116, -52, -87, Byte.MAX_VALUE, -87, 37, -25, Byte.MIN_VALUE, -61, -123, -22, 51}, bArr6));
                        Collection arrayList = new ArrayList();
                        for (Object next2 : fragments2) {
                            Fragment fragment = (Fragment) next2;
                            if (this.activity.getSupportFragmentManager().getFragments().size() == i3) {
                                list2 = listOfWebViews;
                            } else {
                                list2 = listOfWebViews;
                                Intrinsics.checkNotNull(fragment, StringFog.decrypt(new byte[]{-34, 106, 123, 82, -72, -44, 115, -111, -34, 112, 99, Ascii.RS, -6, -46, 50, -100, -47, 108, 99, Ascii.RS, -20, -40, 50, -111, -33, 113, 58, 80, -19, -37, 126, -33, -60, 102, 103, 91, -72, -44, 125, -110, -98, 111, 123, 87, -10, -36, 125, -103, -33, 109, 99, 75, -10, -46, 60, -100, -47, 108, Byte.MAX_VALUE, Ascii.DLE, -17, -34, 124, -116, -64, 118, 121, Ascii.DLE, -24, -59, 125, -103, -39, 115, 114, Ascii.DLE, -56, -44, 83, -117, -3, 81, 95, 111, -24, -3, 90, -101}, new byte[]{-80, Ascii.US, Ascii.ETB, 62, -104, -73, Ascii.DC2, -1}));
                                if (((PcAtMNHQpJHd) fragment).isRoot()) {
                                    listOfWebViews = list2;
                                    i3 = 1;
                                }
                            }
                            arrayList.add(next2);
                            listOfWebViews = list2;
                            i3 = 1;
                        }
                        list = listOfWebViews;
                        try {
                            Object obj = ((List) arrayList).get(i6);
                            Intrinsics.checkNotNull(obj, StringFog.decrypt(new byte[]{-97, -46, 1, 69, -24, -81, Base64.padSymbol, 45, -97, -56, Ascii.EM, 9, -86, -87, 124, 32, -112, -44, Ascii.EM, 9, -68, -93, 124, 45, -98, -55, SignedBytes.MAX_POWER_OF_TWO, 71, -67, -96, 48, 99, -123, -34, Ascii.GS, 76, -24, -81, 51, 46, -33, -41, 1, SignedBytes.MAX_POWER_OF_TWO, -90, -89, 51, 37, -98, -43, Ascii.EM, 92, -90, -87, 114, 32, -112, -44, 5, 7, -65, -91, 50, 48, -127, -50, 3, 7, -72, -66, 51, 37, -104, -53, 8, 7, -104, -81, Ascii.GS, 55, -68, -23, 37, 120, -72, -122, Ascii.DC4, 39}, new byte[]{-15, -89, 109, 41, -56, -52, 92, 67}));
                            FilesKt.writeText$default(file4, String.valueOf(((PcAtMNHQpJHd) obj).getIsDialog()), (Charset) null, 2, (Object) null);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        list = listOfWebViews;
                    }
                    File file5 = new File(file2, String.valueOf(i6));
                    if (file5.exists()) {
                        file5.delete();
                    }
                    try {
                        Parcel obtain = Parcel.obtain();
                        try {
                            try {
                                Intrinsics.checkNotNullExpressionValue(obtain, StringFog.decrypt(new byte[]{-20, -62, 7, 115, 108, 5, 92, 68, -83, -114, 90}, bArr));
                                i2 = 0;
                            } catch (Exception e3) {
                                e = e3;
                                i = 8;
                                i2 = 0;
                                e.printStackTrace();
                                i5 = i;
                                i6 = i7;
                                listOfWebViews = list;
                                i4 = i2;
                                i3 = 1;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            i = 8;
                            i2 = 0;
                            e.printStackTrace();
                            i5 = i;
                            i6 = i7;
                            listOfWebViews = list;
                            i4 = i2;
                            i3 = 1;
                        }
                        try {
                            bundle.writeToParcel(obtain, 0);
                            byte[] marshall = obtain.marshall();
                            obtain.recycle();
                            FileOutputStream openFileOutput = this.activity.openFileOutput(file5.getName(), 0);
                            i = 8;
                            try {
                                Intrinsics.checkNotNullExpressionValue(openFileOutput, StringFog.decrypt(new byte[]{121, Base64.padSymbol, -73, -54, -75, 88, -105, 114, 89, 56, -90, -44, -122, 69, -45, 57, 56, 99, -5}, new byte[]{Ascii.SYN, 77, -46, -92, -13, 49, -5, Ascii.ETB}));
                                openFileOutput.write(marshall);
                                openFileOutput.close();
                            } catch (Exception e5) {
                                e = e5;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            i = 8;
                            e.printStackTrace();
                            i5 = i;
                            i6 = i7;
                            listOfWebViews = list;
                            i4 = i2;
                            i3 = 1;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        i2 = 0;
                        i = 8;
                        e.printStackTrace();
                        i5 = i;
                        i6 = i7;
                        listOfWebViews = list;
                        i4 = i2;
                        i3 = 1;
                    }
                } else {
                    list = listOfWebViews;
                    i2 = i4;
                    i = i5;
                }
                i5 = i;
                i6 = i7;
                listOfWebViews = list;
                i4 = i2;
                i3 = 1;
            }
        }
    }

    public final void restore(Bundle bundle, KFunction<Unit> kFunction, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(kFunction, StringFog.decrypt(new byte[]{-52, -125, -52, -90, -37, Ascii.GS, Byte.MIN_VALUE, -52}, new byte[]{-86, -10, -94, -59, -81, 116, -17, -94}));
        Intrinsics.checkNotNullParameter(function0, StringFog.decrypt(new byte[]{19, 51, -127, 81, -110, 60, Ascii.CR, 70, Ascii.US, 38, -79, 81, -82, 54, 42, 96, Ascii.ESC, 33, -96}, new byte[]{122, 85, -59, 62, -36, 83, 121, Ascii.DC4}));
        if (bundle == null) {
            function0.invoke();
        } else {
            restoreFromFile(kFunction, function0);
        }
    }

    private final void restoreFromFile(KFunction<Unit> kFunction, Function0<Unit> function0) {
        File file = new File(this.activity.getCacheDir(), StringFog.decrypt(new byte[]{-25}, new byte[]{-108, -71, -118, Ascii.SYN, 7, -89, -92, -124}));
        File file2 = new File(this.activity.getCacheDir(), StringFog.decrypt(new byte[]{54, -40}, new byte[]{69, -84, Ascii.SUB, -33, 86, 49, -84, -2}));
        File file3 = new File(this.activity.getCacheDir(), StringFog.decrypt(new byte[]{109}, new byte[]{9, 81, 99, 104, 96, -28, -8, 124}));
        int i = this.activity.getSharedPreferences(StringFog.decrypt(new byte[]{-84, Ascii.SYN, 75, -49, Ascii.FF, -85}, new byte[]{-37, 69, Utf8.REPLACEMENT_BYTE, -82, 120, -50, 48, -29}), 0).getInt(StringFog.decrypt(new byte[]{-79, -119, -76}, new byte[]{-33, -58, -61, -117, 81, 111, -119, 67}), -1);
        if (i == -1) {
            SharedPreferences sharedPreferences = this.activity.getSharedPreferences(StringFog.decrypt(new byte[]{Ascii.VT, -90, -122, 101, 37, -54}, new byte[]{124, -11, -14, 4, 81, -81, -104, 43}), 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, StringFog.decrypt(new byte[]{-113, 98, -71, Ascii.GS, -11, 122, -109, -35, -116, 87, -65, 43, -5, 126, -109, -35, -122, 100, -88, Base64.padSymbol, -75, 53, -49, -106, -63}, new byte[]{-24, 7, -51, 78, -99, Ascii.ESC, -31, -72}));
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(StringFog.decrypt(new byte[]{55, 34, -68}, new byte[]{89, 109, -53, -104, -67, -10, 7, -52}), -1);
            edit.commit();
            return;
        }
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BkvixMRQDbqY$restoreFromFile$2(i, this, function0, file2, file3, kFunction, file, (Continuation<? super BkvixMRQDbqY$restoreFromFile$2>) null), 3, (Object) null);
    }

    private final List<WebView> getListOfWebViews() {
        View view;
        if (this.activity.getSupportFragmentManager().getFragments().isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<Fragment> fragments = this.activity.getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, StringFog.decrypt(new byte[]{126, 9, 5, 35, -88, 115, 102, -11, 124, 2, 5, Ascii.SYN, -14, 60, 47, -74, 48}, new byte[]{Ascii.EM, 108, 113, 101, -38, Ascii.DC2, 1, -104}));
        Collection arrayList = new ArrayList();
        for (Object next : fragments) {
            Fragment fragment = (Fragment) next;
            if (this.activity.getSupportFragmentManager().getFragments().size() != 1) {
                Intrinsics.checkNotNull(fragment, StringFog.decrypt(new byte[]{Byte.MIN_VALUE, 79, 67, -120, -25, 109, 126, 71, Byte.MIN_VALUE, 85, 91, -60, -91, 107, Utf8.REPLACEMENT_BYTE, 74, -113, 73, 91, -60, -77, 97, Utf8.REPLACEMENT_BYTE, 71, -127, 84, 2, -118, -78, 98, 115, 9, -102, 67, 95, -127, -25, 109, 112, 68, -64, 74, 67, -115, -87, 101, 112, 79, -127, 72, 91, -111, -87, 107, 49, 74, -113, 73, 71, -54, -80, 103, 113, 90, -98, 83, 65, -54, -73, 124, 112, 79, -121, 86, 74, -54, -105, 109, 94, 93, -93, 116, 103, -75, -73, 68, 87, 77}, new byte[]{-18, 58, 47, -28, -57, Ascii.SO, Ascii.US, 41}));
                if (((PcAtMNHQpJHd) fragment).isRoot()) {
                }
            }
            arrayList.add(next);
        }
        Iterable<Fragment> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Fragment view2 : iterable) {
            View view3 = view2.getView();
            Intrinsics.checkNotNull(view3, StringFog.decrypt(new byte[]{109, 89, -17, 124, -126, -9, 40, 75, 109, 67, -9, 48, -64, -15, 105, 70, 98, 95, -9, 48, -42, -5, 105, 75, 108, 66, -82, 126, -41, -8, 37, 5, 119, 85, -13, 117, -126, -11, 39, 65, 113, 67, -22, 116, -116, -29, 32, 65, 100, 73, -9, 62, -28, -26, 40, 72, 102, 96, -30, 105, -51, -31, Base64.padSymbol}, new byte[]{3, 44, -125, Ascii.DLE, -94, -108, 73, 37}));
            Iterator<View> it = ViewGroupKt.getChildren((FrameLayout) view3).iterator();
            while (true) {
                if (!it.hasNext()) {
                    view = null;
                    break;
                }
                view = it.next();
                if (view instanceof WebView) {
                    break;
                }
            }
            Intrinsics.checkNotNull(view, StringFog.decrypt(new byte[]{51, 71, -102, -7, -71, -50, -1, Ascii.SYN, 51, 93, -126, -75, -5, -56, -66, Ascii.ESC, 60, 65, -126, -75, -19, -62, -66, Ascii.SYN, 50, 92, -37, -5, -20, -63, -14, 88, 41, 75, -122, -16, -71, -52, -16, Ascii.FS, 47, 93, -97, -15, -73, -38, -5, Ascii.SUB, 54, 91, -126, -69, -50, -56, -4, 46, 52, 87, -127}, new byte[]{93, 50, -10, -107, -103, -83, -98, 120}));
            arrayList2.add((WebView) view);
        }
        return (List) arrayList2;
    }

    /* access modifiers changed from: private */
    public final Bundle readBundleFromFile(String str) {
        try {
            FileInputStream openFileInput = this.activity.openFileInput(str);
            int available = openFileInput.available();
            byte[] bArr = new byte[available];
            openFileInput.read(bArr);
            openFileInput.close();
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, StringFog.decrypt(new byte[]{-25, 49, -32, 53, -23, -100, 49, -43, -90, 125, -67}, new byte[]{-120, 83, -108, 84, Byte.MIN_VALUE, -14, Ascii.EM, -5}));
            obtain.unmarshall(bArr, 0, available);
            obtain.setDataPosition(0);
            Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            return bundle;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
