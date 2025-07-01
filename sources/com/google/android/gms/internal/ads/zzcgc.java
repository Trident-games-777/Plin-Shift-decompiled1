package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcgc extends FrameLayout implements zzcfk {
    private final zzcfk zza;
    private final zzcbu zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzcgc(zzcfk zzcfk) {
        super(zzcfk.getContext());
        this.zza = zzcfk;
        this.zzb = new zzcbu(zzcfk.zzE(), this, this);
        addView((View) zzcfk);
    }

    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    public final void destroy() {
        zzeeu zzP;
        zzeew zzQ = zzQ();
        if (zzQ != null) {
            zzs.zza.post(new zzcga(zzQ));
            zzcfk zzcfk = this.zza;
            zzftd zzftd = zzs.zza;
            Objects.requireNonNull(zzcfk);
            zzftd.postDelayed(new zzcfy(zzcfk), (long) ((Integer) zzbe.zzc().zza(zzbcn.zzfc)).intValue());
            return;
        }
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfe)).booleanValue() || (zzP = zzP()) == null) {
            this.zza.destroy();
        } else {
            zzs.zza.post(new zzcgb(this, zzP));
        }
    }

    public final void goBack() {
        this.zza.goBack();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, "text/html", str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", (String) null);
    }

    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    public final void onAdClicked() {
        zzcfk zzcfk = this.zza;
        if (zzcfk != null) {
            zzcfk.onAdClicked();
        }
    }

    public final void onPause() {
        this.zzb.zzf();
        this.zza.onPause();
    }

    public final void onResume() {
        this.zza.onResume();
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    public final void zzA(int i) {
        this.zza.zzA(i);
    }

    public final void zzB(int i) {
        this.zzb.zzg(i);
    }

    public final void zzC(zzcgm zzcgm) {
        this.zza.zzC(zzcgm);
    }

    public final zzfet zzD() {
        return this.zza.zzD();
    }

    public final Context zzE() {
        return this.zza.zzE();
    }

    public final View zzF() {
        return this;
    }

    public final WebView zzG() {
        return (WebView) this.zza;
    }

    public final WebViewClient zzH() {
        return this.zza.zzH();
    }

    public final zzavc zzI() {
        return this.zza.zzI();
    }

    public final zzazz zzJ() {
        return this.zza.zzJ();
    }

    public final zzbfm zzK() {
        return this.zza.zzK();
    }

    public final zzm zzL() {
        return this.zza.zzL();
    }

    public final zzm zzM() {
        return this.zza.zzM();
    }

    public final zzchc zzN() {
        return ((zzcgj) this.zza).zzaO();
    }

    public final zzche zzO() {
        return this.zza.zzO();
    }

    public final zzeeu zzP() {
        return this.zza.zzP();
    }

    public final zzeew zzQ() {
        return this.zza.zzQ();
    }

    public final zzfew zzR() {
        return this.zza.zzR();
    }

    public final zzffs zzS() {
        return this.zza.zzS();
    }

    public final ListenableFuture zzT() {
        return this.zza.zzT();
    }

    public final String zzU() {
        return this.zza.zzU();
    }

    public final List zzV() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != this.zza) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    public final void zzW(zzfet zzfet, zzfew zzfew) {
        this.zza.zzW(zzfet, zzfew);
    }

    public final void zzX() {
        this.zzb.zze();
        this.zza.zzX();
    }

    public final void zzY() {
        this.zza.zzY();
    }

    public final void zzZ(int i) {
        this.zza.zzZ(i);
    }

    public final void zza(String str) {
        ((zzcgj) this.zza).zzaT(str);
    }

    public final void zzaA(String str, Predicate predicate) {
        this.zza.zzaA(str, predicate);
    }

    public final boolean zzaB() {
        return this.zza.zzaB();
    }

    public final boolean zzaC() {
        return this.zza.zzaC();
    }

    public final boolean zzaD(boolean z, int i) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzaT)).booleanValue()) {
            return false;
        }
        if (this.zza.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zza.getParent()).removeView((View) this.zza);
        }
        this.zza.zzaD(z, i);
        return true;
    }

    public final boolean zzaE() {
        return this.zza.zzaE();
    }

    public final boolean zzaF() {
        return this.zza.zzaF();
    }

    public final boolean zzaG() {
        return this.zzc.get();
    }

    public final boolean zzaH() {
        return this.zza.zzaH();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaI(boolean z) {
        zzcfk zzcfk = this.zza;
        zzftd zzftd = zzs.zza;
        Objects.requireNonNull(zzcfk);
        zzftd.post(new zzcfy(zzcfk));
    }

    public final void zzaJ(zzc zzc2, boolean z, boolean z2) {
        this.zza.zzaJ(zzc2, z, z2);
    }

    public final void zzaK(String str, String str2, int i) {
        this.zza.zzaK(str, str2, 14);
    }

    public final void zzaL(boolean z, int i, boolean z2) {
        this.zza.zzaL(z, i, z2);
    }

    public final void zzaM(boolean z, int i, String str, String str2, boolean z2) {
        this.zza.zzaM(z, i, str, str2, z2);
    }

    public final void zzaN(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zza.zzaN(z, i, str, z2, z3);
    }

    public final void zzaa() {
        this.zza.zzaa();
    }

    public final void zzab() {
        this.zza.zzab();
    }

    public final void zzac(boolean z) {
        this.zza.zzac(z);
    }

    public final void zzad() {
        this.zza.zzad();
    }

    public final void zzae(String str, String str2, String str3) {
        this.zza.zzae(str, str2, (String) null);
    }

    public final void zzaf() {
        this.zza.zzaf();
    }

    public final void zzag(String str, zzbjr zzbjr) {
        this.zza.zzag(str, zzbjr);
    }

    public final void zzah() {
        zzeew zzQ;
        zzeeu zzP;
        TextView textView = new TextView(getContext());
        zzv.zzq();
        textView.setText(zzs.zzy());
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfe)).booleanValue() || (zzP = zzP()) == null) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzfd)).booleanValue() && (zzQ = zzQ()) != null && zzQ.zzb()) {
                zzv.zzB().zzg(zzQ.zza(), textView);
                return;
            }
            return;
        }
        zzP.zza(textView);
    }

    public final void zzai(zzm zzm) {
        this.zza.zzai(zzm);
    }

    public final void zzaj(zzche zzche) {
        this.zza.zzaj(zzche);
    }

    public final void zzak(zzazz zzazz) {
        this.zza.zzak(zzazz);
    }

    public final void zzal(boolean z) {
        this.zza.zzal(z);
    }

    public final void zzam() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    public final void zzan(Context context) {
        this.zza.zzan(context);
    }

    public final void zzao(boolean z) {
        this.zza.zzao(z);
    }

    public final void zzap(zzbfk zzbfk) {
        this.zza.zzap(zzbfk);
    }

    public final void zzaq(boolean z) {
        this.zza.zzaq(z);
    }

    public final void zzar(zzbfm zzbfm) {
        this.zza.zzar(zzbfm);
    }

    public final void zzas(zzeeu zzeeu) {
        this.zza.zzas(zzeeu);
    }

    public final void zzat(zzeew zzeew) {
        this.zza.zzat(zzeew);
    }

    public final void zzau(int i) {
        this.zza.zzau(i);
    }

    public final void zzav(boolean z) {
        this.zza.zzav(true);
    }

    public final void zzaw(zzm zzm) {
        this.zza.zzaw(zzm);
    }

    public final void zzax(boolean z) {
        this.zza.zzax(z);
    }

    public final void zzay(boolean z) {
        this.zza.zzay(z);
    }

    public final void zzaz(String str, zzbjr zzbjr) {
        this.zza.zzaz(str, zzbjr);
    }

    public final void zzb(String str, String str2) {
        this.zza.zzb("window.inspectorInfo", str2);
    }

    public final void zzd(String str, Map map) {
        this.zza.zzd(str, map);
    }

    public final void zzdG() {
        zzcfk zzcfk = this.zza;
        if (zzcfk != null) {
            zzcfk.zzdG();
        }
    }

    public final void zzdf() {
        zzcfk zzcfk = this.zza;
        if (zzcfk != null) {
            zzcfk.zzdf();
        }
    }

    public final void zzdg() {
        this.zza.zzdg();
    }

    public final void zzdh() {
        this.zza.zzdh();
    }

    public final String zzdi() {
        return this.zza.zzdi();
    }

    public final void zzdp(zzayl zzayl) {
        this.zza.zzdp(zzayl);
    }

    public final void zze(String str, JSONObject jSONObject) {
        this.zza.zze(str, jSONObject);
    }

    public final int zzf() {
        return this.zza.zzf();
    }

    public final int zzg() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdV)).booleanValue()) {
            return this.zza.getMeasuredHeight();
        }
        return getMeasuredHeight();
    }

    public final int zzh() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdV)).booleanValue()) {
            return this.zza.getMeasuredWidth();
        }
        return getMeasuredWidth();
    }

    public final Activity zzi() {
        return this.zza.zzi();
    }

    public final zza zzj() {
        return this.zza.zzj();
    }

    public final zzbcz zzk() {
        return this.zza.zzk();
    }

    public final void zzl(String str, JSONObject jSONObject) {
        ((zzcgj) this.zza).zzb(str, jSONObject.toString());
    }

    public final zzbda zzm() {
        return this.zza.zzm();
    }

    public final VersionInfoParcel zzn() {
        return this.zza.zzn();
    }

    public final zzcbu zzo() {
        return this.zzb;
    }

    public final zzcdr zzp(String str) {
        return this.zza.zzp(str);
    }

    public final zzcgm zzq() {
        return this.zza.zzq();
    }

    public final String zzr() {
        return this.zza.zzr();
    }

    public final void zzt(String str, zzcdr zzcdr) {
        this.zza.zzt(str, zzcdr);
    }

    public final void zzu() {
        this.zza.zzu();
    }

    public final void zzv(boolean z, long j) {
        this.zza.zzv(z, j);
    }

    public final void zzw() {
        this.zza.zzw();
    }

    public final void zzx(int i) {
    }

    public final void zzy(int i) {
    }

    public final void zzz(boolean z) {
        this.zza.zzz(false);
    }
}
