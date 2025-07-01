package com.plinkofortune.cash.winspin;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.gson.Gson;
import com.plinkofortune.cash.winspin.leader.LeaderModel;
import com.plinkofortune.cash.winspin.profile.ProfileData;
import com.plinkofortune.cash.winspin.rounds.RoundModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011J\u001c\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H@¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00120\u0011J\u001c\u0010\u0019\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012H@¢\u0006\u0002\u0010\u0016J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011J\u0016\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001cH@¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u0012H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/plinkofortune/cash/winspin/GlobalRepo;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "roundKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "leaderKey", "profileKey", "storage", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "getRounds", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/plinkofortune/cash/winspin/rounds/RoundModel;", "setRounds", "rounds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLeaders", "Lcom/plinkofortune/cash/winspin/leader/LeaderModel;", "setLeaders", "leaders", "getProfile", "Lcom/plinkofortune/cash/winspin/profile/ProfileData;", "setProfile", "profileData", "(Lcom/plinkofortune/cash/winspin/profile/ProfileData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateInitialLeaders", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: GlobalRepo.kt */
public final class GlobalRepo {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final Gson gson = new Gson();
    /* access modifiers changed from: private */
    public final Preferences.Key<String> leaderKey = PreferencesKeys.stringKey(StringFog.decrypt(new byte[]{80, -87, -89, -65, Ascii.NAK, 40}, new byte[]{60, -52, -58, -37, 112, 90, 111, Ascii.GS}));
    /* access modifiers changed from: private */
    public final Preferences.Key<String> profileKey = PreferencesKeys.stringKey(StringFog.decrypt(new byte[]{46, -7, 103, Byte.MAX_VALUE, -90, -86, -46}, new byte[]{94, -117, 8, Ascii.EM, -49, -58, -73, Ascii.CR}));
    /* access modifiers changed from: private */
    public final Preferences.Key<String> roundKey = PreferencesKeys.stringKey(StringFog.decrypt(new byte[]{41, -50, 4, 40, Ascii.RS}, new byte[]{91, -95, 113, 70, 122, -104, -28, -57}));
    /* access modifiers changed from: private */
    public final DataStore<Preferences> storage;

    public GlobalRepo(Context context) {
        Intrinsics.checkNotNullParameter(context, StringFog.decrypt(new byte[]{105, -1, 33, 77, -74, -43, 65}, new byte[]{10, -112, 79, 57, -45, -83, 53, 124}));
        this.storage = GlobalRepoKt.getStorage(context);
    }

    public final Flow<List<RoundModel>> getRounds() {
        return FlowKt.flowOn(new GlobalRepo$getRounds$$inlined$map$1(this.storage.getData(), this), Dispatchers.getDefault());
    }

    public final Object setRounds(List<RoundModel> list, Continuation<? super Preferences> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GlobalRepo$setRounds$2(this, list, (Continuation<? super GlobalRepo$setRounds$2>) null), continuation);
    }

    public final Flow<List<LeaderModel>> getLeaders() {
        return FlowKt.flowOn(new GlobalRepo$getLeaders$$inlined$map$1(this.storage.getData(), this), Dispatchers.getDefault());
    }

    public final Object setLeaders(List<LeaderModel> list, Continuation<? super Preferences> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GlobalRepo$setLeaders$2(this, list, (Continuation<? super GlobalRepo$setLeaders$2>) null), continuation);
    }

    public final Flow<ProfileData> getProfile() {
        return FlowKt.flowOn(new GlobalRepo$getProfile$$inlined$map$1(this.storage.getData(), this), Dispatchers.getDefault());
    }

    public final Object setProfile(ProfileData profileData, Continuation<? super Preferences> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GlobalRepo$setProfile$2(this, profileData, (Continuation<? super GlobalRepo$setProfile$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final List<LeaderModel> generateInitialLeaders() {
        return CollectionsKt.listOf(new LeaderModel(1, StringFog.decrypt(new byte[]{-27, -21, -91, -10, -69, -65, -20, -117, -38, -27}, new byte[]{-74, -125, -60, -110, -44, -56, -69, -28}), 400), new LeaderModel(2, StringFog.decrypt(new byte[]{37, 40, -52, 7, 69, Ascii.GS, 43, 66, Ascii.SO, 51}, new byte[]{107, 65, -85, 111, 49, 79, 66, 38}), 392), new LeaderModel(3, StringFog.decrypt(new byte[]{-88, 79, -27, -41, Ascii.SUB, -86, Ascii.RS, 34}, new byte[]{-31, Base64.padSymbol, -118, -71, 92, -61, 109, 86}), 386), new LeaderModel(4, StringFog.decrypt(new byte[]{17, -78, 121, 68, 101, -80, -112, 1, 38, -65, 100}, new byte[]{86, -38, Ascii.SYN, 55, 17, -29, -2, 104}), 379), new LeaderModel(5, StringFog.decrypt(new byte[]{-61, -63, -8, 84, -73, -94, 67, -97, -13, -64}, new byte[]{-127, -83, -103, 46, -46, -15, 55, -16}), 371), new LeaderModel(6, StringFog.decrypt(new byte[]{122, -15, 77, 45, 7, -94, -59, -113, 91, -30}, new byte[]{62, -112, Utf8.REPLACEMENT_BYTE, 70, 79, -41, -85, -5}), 364), new LeaderModel(7, StringFog.decrypt(new byte[]{10, -15, -95, 38, 96, -26, -51, 87, 62, -3}, new byte[]{89, -104, -51, 67, Ascii.SO, -110, -120, 51}), 358), new LeaderModel(8, StringFog.decrypt(new byte[]{-73, -31, 83, 76, 85, 7, -67, -79, -108}, new byte[]{-15, -109, 60, Utf8.REPLACEMENT_BYTE, 33, 69, -60, -59}), 351), new LeaderModel(9, StringFog.decrypt(new byte[]{33, 6, Ascii.FF, 94, 104, 42}, new byte[]{119, 111, 124, 59, Ascii.SUB, 114, -113, -106}), 343), new LeaderModel(10, StringFog.decrypt(new byte[]{97, -57, Ascii.FF, -7, -76, 81, -1, 48, 77, -51}, new byte[]{34, -75, 101, -108, -57, 62, -111, 118}), 336), new LeaderModel(11, StringFog.decrypt(new byte[]{Ascii.ESC, 60, -54, -122, -75, -39, 50, -40, 40, 49}, new byte[]{75, 84, -85, -24, -63, -74, 95, -103}), 328), new LeaderModel(12, StringFog.decrypt(new byte[]{-76, -62, -20, -126, -85, -16, Ascii.DLE, 60, -119, -47, -26, -126}, new byte[]{-25, -74, -125, -16, -58, -78, 98, 85}), 321), new LeaderModel(13, StringFog.decrypt(new byte[]{-79, 65, SignedBytes.MAX_POWER_OF_TWO, -10, 86, -72, 33, 99, -124, 93}, new byte[]{-27, 41, 53, -104, 50, -35, 83, 32}), 313), new LeaderModel(14, StringFog.decrypt(new byte[]{92, 126, 43, -40, -125, -112, 78, -41, 102, 100, 41}, new byte[]{Ascii.SI, 10, 78, -71, -17, -28, 38, Byte.MIN_VALUE}), 306), new LeaderModel(15, StringFog.decrypt(new byte[]{6, 83, -54, 5, 96, 54, -60, -54, 35, 89}, new byte[]{72, 60, -68, 100, 51, 66, -74, -93}), 298), new LeaderModel(16, StringFog.decrypt(new byte[]{-51, Ascii.VT, 6, 56, Ascii.SO, 95, -104, 56, -32, Ascii.US}, new byte[]{-116, 121, 101, 76, 103, 60, -49, 87}), 289), new LeaderModel(17, StringFog.decrypt(new byte[]{Byte.MAX_VALUE, Byte.MAX_VALUE, 0, 36, 49, Ascii.SYN, -96, -122, 65, Byte.MAX_VALUE}, new byte[]{59, Ascii.SUB, 97, 80, 89, 84, -52, -25}), 277), new LeaderModel(18, StringFog.decrypt(new byte[]{-103, Ascii.CAN, 43, 39, 95, -109, 19, -97, -79}, new byte[]{-38, 97, 73, 66, 45, -37, 114, -24}), 265), new LeaderModel(19, StringFog.decrypt(new byte[]{-34, -103, -34, 120, -41, 46, 86, -77, -17}, new byte[]{-118, -16, -86, Ascii.EM, -71, 109, 57, -63}), 249), new LeaderModel(20, StringFog.decrypt(new byte[]{86, -57, -34, 109, -114, 121, 125, 119, 116, -50, -47}, new byte[]{Ascii.DLE, -85, -65, 0, -21, 46, Ascii.FS, 5}), 230));
    }
}
