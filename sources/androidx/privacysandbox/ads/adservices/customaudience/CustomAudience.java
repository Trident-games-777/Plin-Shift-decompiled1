package androidx.privacysandbox.ads.adservices.customaudience;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdData;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.time.Instant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001*Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "", "buyer", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "name", "", "dailyUpdateUri", "Landroid/net/Uri;", "biddingLogicUri", "ads", "", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "activationTime", "Ljava/time/Instant;", "expirationTime", "userBiddingSignals", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "trustedBiddingSignals", "Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Ljava/util/List;Ljava/time/Instant;Ljava/time/Instant;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;)V", "getActivationTime", "()Ljava/time/Instant;", "getAds", "()Ljava/util/List;", "getBiddingLogicUri", "()Landroid/net/Uri;", "getBuyer", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "getDailyUpdateUri", "getExpirationTime", "getName", "()Ljava/lang/String;", "getTrustedBiddingSignals", "()Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "getUserBiddingSignals", "()Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "equals", "", "other", "hashCode", "", "toString", "Builder", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CustomAudience.kt */
public final class CustomAudience {
    private final Instant activationTime;
    private final List<AdData> ads;
    private final Uri biddingLogicUri;
    private final AdTechIdentifier buyer;
    private final Uri dailyUpdateUri;
    private final Instant expirationTime;
    private final String name;
    private final TrustedBiddingData trustedBiddingSignals;
    private final AdSelectionSignals userBiddingSignals;

    public CustomAudience(AdTechIdentifier adTechIdentifier, String str, Uri uri, Uri uri2, List<AdData> list, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals, TrustedBiddingData trustedBiddingData) {
        Intrinsics.checkNotNullParameter(adTechIdentifier, "buyer");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(uri, "dailyUpdateUri");
        Intrinsics.checkNotNullParameter(uri2, "biddingLogicUri");
        Intrinsics.checkNotNullParameter(list, "ads");
        this.buyer = adTechIdentifier;
        this.name = str;
        this.dailyUpdateUri = uri;
        this.biddingLogicUri = uri2;
        this.ads = list;
        this.activationTime = instant;
        this.expirationTime = instant2;
        this.userBiddingSignals = adSelectionSignals;
        this.trustedBiddingSignals = trustedBiddingData;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomAudience(androidx.privacysandbox.ads.adservices.common.AdTechIdentifier r2, java.lang.String r3, android.net.Uri r4, android.net.Uri r5, java.util.List r6, java.time.Instant r7, java.time.Instant r8, androidx.privacysandbox.ads.adservices.common.AdSelectionSignals r9, androidx.privacysandbox.ads.adservices.customaudience.TrustedBiddingData r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r1 = this;
            r12 = r11 & 32
            r0 = 0
            if (r12 == 0) goto L_0x0006
            r7 = r0
        L_0x0006:
            r12 = r11 & 64
            if (r12 == 0) goto L_0x000b
            r8 = r0
        L_0x000b:
            r12 = r11 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0010
            r9 = r0
        L_0x0010:
            r11 = r11 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0016
            r11 = r0
            goto L_0x0017
        L_0x0016:
            r11 = r10
        L_0x0017:
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.customaudience.CustomAudience.<init>(androidx.privacysandbox.ads.adservices.common.AdTechIdentifier, java.lang.String, android.net.Uri, android.net.Uri, java.util.List, java.time.Instant, java.time.Instant, androidx.privacysandbox.ads.adservices.common.AdSelectionSignals, androidx.privacysandbox.ads.adservices.customaudience.TrustedBiddingData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final AdTechIdentifier getBuyer() {
        return this.buyer;
    }

    public final String getName() {
        return this.name;
    }

    public final Uri getDailyUpdateUri() {
        return this.dailyUpdateUri;
    }

    public final Uri getBiddingLogicUri() {
        return this.biddingLogicUri;
    }

    public final List<AdData> getAds() {
        return this.ads;
    }

    public final Instant getActivationTime() {
        return this.activationTime;
    }

    public final Instant getExpirationTime() {
        return this.expirationTime;
    }

    public final AdSelectionSignals getUserBiddingSignals() {
        return this.userBiddingSignals;
    }

    public final TrustedBiddingData getTrustedBiddingSignals() {
        return this.trustedBiddingSignals;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomAudience)) {
            return false;
        }
        CustomAudience customAudience = (CustomAudience) obj;
        return Intrinsics.areEqual((Object) this.buyer, (Object) customAudience.buyer) && Intrinsics.areEqual((Object) this.name, (Object) customAudience.name) && Intrinsics.areEqual((Object) this.activationTime, (Object) customAudience.activationTime) && Intrinsics.areEqual((Object) this.expirationTime, (Object) customAudience.expirationTime) && Intrinsics.areEqual((Object) this.dailyUpdateUri, (Object) customAudience.dailyUpdateUri) && Intrinsics.areEqual((Object) this.userBiddingSignals, (Object) customAudience.userBiddingSignals) && Intrinsics.areEqual((Object) this.trustedBiddingSignals, (Object) customAudience.trustedBiddingSignals) && Intrinsics.areEqual((Object) this.ads, (Object) customAudience.ads);
    }

    public int hashCode() {
        int hashCode = ((this.buyer.hashCode() * 31) + this.name.hashCode()) * 31;
        Instant instant = this.activationTime;
        int i = 0;
        int hashCode2 = (hashCode + (instant != null ? instant.hashCode() : 0)) * 31;
        Instant instant2 = this.expirationTime;
        int hashCode3 = (((hashCode2 + (instant2 != null ? instant2.hashCode() : 0)) * 31) + this.dailyUpdateUri.hashCode()) * 31;
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        int hashCode4 = (hashCode3 + (adSelectionSignals != null ? adSelectionSignals.hashCode() : 0)) * 31;
        TrustedBiddingData trustedBiddingData = this.trustedBiddingSignals;
        if (trustedBiddingData != null) {
            i = trustedBiddingData.hashCode();
        }
        return ((((hashCode4 + i) * 31) + this.biddingLogicUri.hashCode()) * 31) + this.ads.hashCode();
    }

    public String toString() {
        return "CustomAudience: buyer=" + this.biddingLogicUri + ", activationTime=" + this.activationTime + ", expirationTime=" + this.expirationTime + ", dailyUpdateUri=" + this.dailyUpdateUri + ", userBiddingSignals=" + this.userBiddingSignals + ", trustedBiddingSignals=" + this.trustedBiddingSignals + ", biddingLogicUri=" + this.biddingLogicUri + ", ads=" + this.ads;
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u0017\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder;", "", "buyer", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "name", "", "dailyUpdateUri", "Landroid/net/Uri;", "biddingLogicUri", "ads", "", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Ljava/util/List;)V", "activationTime", "Ljava/time/Instant;", "expirationTime", "trustedBiddingData", "Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "userBiddingSignals", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "build", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "setActivationTime", "setAds", "setBiddingLogicUri", "setBuyer", "setDailyUpdateUri", "setExpirationTime", "setName", "setTrustedBiddingData", "trustedBiddingSignals", "setUserBiddingSignals", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CustomAudience.kt */
    public static final class Builder {
        private Instant activationTime;
        private List<AdData> ads;
        private Uri biddingLogicUri;
        private AdTechIdentifier buyer;
        private Uri dailyUpdateUri;
        private Instant expirationTime;
        private String name;
        private TrustedBiddingData trustedBiddingData;
        private AdSelectionSignals userBiddingSignals;

        public Builder(AdTechIdentifier adTechIdentifier, String str, Uri uri, Uri uri2, List<AdData> list) {
            Intrinsics.checkNotNullParameter(adTechIdentifier, "buyer");
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(uri, "dailyUpdateUri");
            Intrinsics.checkNotNullParameter(uri2, "biddingLogicUri");
            Intrinsics.checkNotNullParameter(list, "ads");
            this.buyer = adTechIdentifier;
            this.name = str;
            this.dailyUpdateUri = uri;
            this.biddingLogicUri = uri2;
            this.ads = list;
        }

        public final Builder setBuyer(AdTechIdentifier adTechIdentifier) {
            Intrinsics.checkNotNullParameter(adTechIdentifier, "buyer");
            Builder builder = this;
            this.buyer = adTechIdentifier;
            return this;
        }

        public final Builder setName(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            Builder builder = this;
            this.name = str;
            return this;
        }

        public final Builder setActivationTime(Instant instant) {
            Intrinsics.checkNotNullParameter(instant, "activationTime");
            Builder builder = this;
            this.activationTime = instant;
            return this;
        }

        public final Builder setExpirationTime(Instant instant) {
            Intrinsics.checkNotNullParameter(instant, "expirationTime");
            Builder builder = this;
            this.expirationTime = instant;
            return this;
        }

        public final Builder setDailyUpdateUri(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "dailyUpdateUri");
            Builder builder = this;
            this.dailyUpdateUri = uri;
            return this;
        }

        public final Builder setUserBiddingSignals(AdSelectionSignals adSelectionSignals) {
            Intrinsics.checkNotNullParameter(adSelectionSignals, "userBiddingSignals");
            Builder builder = this;
            this.userBiddingSignals = adSelectionSignals;
            return this;
        }

        public final Builder setTrustedBiddingData(TrustedBiddingData trustedBiddingData2) {
            Intrinsics.checkNotNullParameter(trustedBiddingData2, "trustedBiddingSignals");
            Builder builder = this;
            this.trustedBiddingData = trustedBiddingData2;
            return this;
        }

        public final Builder setBiddingLogicUri(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "biddingLogicUri");
            Builder builder = this;
            this.biddingLogicUri = uri;
            return this;
        }

        public final Builder setAds(List<AdData> list) {
            Intrinsics.checkNotNullParameter(list, "ads");
            Builder builder = this;
            this.ads = list;
            return this;
        }

        public final CustomAudience build() {
            return new CustomAudience(this.buyer, this.name, this.dailyUpdateUri, this.biddingLogicUri, this.ads, this.activationTime, this.expirationTime, this.userBiddingSignals, this.trustedBiddingData);
        }
    }
}
