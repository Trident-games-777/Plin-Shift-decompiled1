package com.plinkofortune.cash.winspin.rounds;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/plinkofortune/cash/winspin/rounds/ZabgTpCHxFDS$iQLhOuiIOxLa$2$1", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "onInstallReferrerSetupFinished", "", "responseCode", "", "onInstallReferrerServiceDisconnected", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ZabgTpCHxFDS.kt */
public final class ZabgTpCHxFDS$iQLhOuiIOxLa$2$1 implements InstallReferrerStateListener {
    final /* synthetic */ InstallReferrerClient $client;
    final /* synthetic */ Context $context;
    final /* synthetic */ CancellableContinuation<String> $continuation;
    final /* synthetic */ int $retryCount;
    final /* synthetic */ ZabgTpCHxFDS this$0;

    ZabgTpCHxFDS$iQLhOuiIOxLa$2$1(ZabgTpCHxFDS zabgTpCHxFDS, InstallReferrerClient installReferrerClient, CancellableContinuation<? super String> cancellableContinuation, int i, Context context) {
        this.this$0 = zabgTpCHxFDS;
        this.$client = installReferrerClient;
        this.$continuation = cancellableContinuation;
        this.$retryCount = i;
        this.$context = context;
    }

    public void onInstallReferrerSetupFinished(int i) {
        if (!this.this$0.getPassed()) {
            if (i == 0) {
                ReferrerDetails installReferrer = this.$client.getInstallReferrer();
                if (this.$continuation.isActive()) {
                    Result.Companion companion = Result.Companion;
                    this.$continuation.resumeWith(Result.m7823constructorimpl(installReferrer.getInstallReferrer()));
                    this.this$0.setPassed(true);
                }
            } else if (i != 1 && i != 2) {
                try {
                    if (this.$continuation.isActive()) {
                        Result.Companion companion2 = Result.Companion;
                        this.$continuation.resumeWith(Result.m7823constructorimpl(StringFog.decrypt(new byte[]{-63, 2, -72, Ascii.EM}, new byte[]{-81, 119, -44, 117, -125, 53, -99, -57})));
                        this.this$0.setPassed(true);
                    }
                } catch (Exception unused) {
                    int i2 = this.$retryCount;
                    if (i2 > 0) {
                        this.this$0.retryConnection(this.$context, i2 - 1);
                    } else if (this.$continuation.isActive()) {
                        Result.Companion companion3 = Result.Companion;
                        this.$continuation.resumeWith(Result.m7823constructorimpl(StringFog.decrypt(new byte[]{-122, -100, -76, -37}, new byte[]{-24, -23, -40, -73, -125, -60, -2, 78})));
                        this.this$0.setPassed(true);
                    }
                }
            } else if (this.$continuation.isActive()) {
                Result.Companion companion4 = Result.Companion;
                this.$continuation.resumeWith(Result.m7823constructorimpl(StringFog.decrypt(new byte[]{19, 4, -22, -113}, new byte[]{125, 113, -122, -29, 6, -52, 80, -54})));
                this.this$0.setPassed(true);
            }
        }
    }

    public void onInstallReferrerServiceDisconnected() {
        int i = this.$retryCount;
        if (i > 0) {
            this.this$0.retryConnection(this.$context, i - 1);
        } else if (this.$continuation.isActive()) {
            Result.Companion companion = Result.Companion;
            this.$continuation.resumeWith(Result.m7823constructorimpl(StringFog.decrypt(new byte[]{Ascii.EM, 87, 45, -33}, new byte[]{119, 34, 65, -77, -95, Ascii.SI, 44, 92})));
            this.this$0.setPassed(true);
        }
    }
}
