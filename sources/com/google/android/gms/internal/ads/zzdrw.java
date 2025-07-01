package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdrw {
    public static final zzfzo zza;
    public static final zzfzo zzb;
    private final String zzc;
    private final zzdrv zzd;
    private final zzdrv zze;

    static {
        zzdrv zzdrv = zzdrv.PUBLIC_API_CALL;
        zzdrv zzdrv2 = zzdrv.PUBLIC_API_CALLBACK;
        zzdrw zzdrw = new zzdrw("tqgt", zzdrv, zzdrv2);
        zzdrv zzdrv3 = zzdrv.PUBLIC_API_CALL;
        zzdrv zzdrv4 = zzdrv.DYNAMITE_ENTER;
        zzdrw zzdrw2 = new zzdrw("l.dl", zzdrv3, zzdrv4);
        zzdrv zzdrv5 = zzdrv.CLIENT_SIGNALS_START;
        zzdrw zzdrw3 = new zzdrw("l.rcc", zzdrv4, zzdrv5);
        zzdrv zzdrv6 = zzdrv.CLIENT_SIGNALS_END;
        zzdrw zzdrw4 = new zzdrw("l.cs", zzdrv5, zzdrv6);
        zzdrw zzdrw5 = zzdrw3;
        zzdrw zzdrw6 = new zzdrw("l.cts", zzdrv6, zzdrv.SERVICE_CONNECTED);
        zzdrw zzdrw7 = zzdrw5;
        zzdrv zzdrv7 = zzdrv.GMS_SIGNALS_START;
        zzdrv zzdrv8 = zzdrv.GMS_SIGNALS_END;
        zzdrw zzdrw8 = new zzdrw("l.gs", zzdrv7, zzdrv8);
        zzdrw zzdrw9 = zzdrw7;
        zzdrv zzdrv9 = zzdrv.GET_SIGNALS_SDKCORE_START;
        zzdrw zzdrw10 = new zzdrw("l.jse", zzdrv8, zzdrv9);
        zzdrw zzdrw11 = zzdrw9;
        zzdrw zzdrw12 = zzdrw;
        zzdrv zzdrv10 = zzdrv.GET_SIGNALS_SDKCORE_END;
        zzdrw zzdrw13 = zzdrw2;
        zzdrw zzdrw14 = new zzdrw("l.gs-sdkcore", zzdrv9, zzdrv10);
        zzdrw zzdrw15 = new zzdrw("l.gs-pp", zzdrv10, zzdrv2);
        zzdrw zzdrw16 = zzdrw11;
        zzdrv zzdrv11 = zzdrv.RENDERING_START;
        zzdrw zzdrw17 = new zzdrw("l.render", zzdrv11, zzdrv2);
        zzdrw zzdrw18 = zzdrw16;
        zzdrv zzdrv12 = zzdrv.RENDERING_WEBVIEW_CREATION_START;
        zzdrw zzdrw19 = new zzdrw("l.render.pre", zzdrv11, zzdrv12);
        zzdrv zzdrv13 = zzdrv.RENDERING_WEBVIEW_CREATION_END;
        zzdrw zzdrw20 = new zzdrw("l.render.wvc", zzdrv12, zzdrv13);
        zzdrw zzdrw21 = new zzdrw("l.render.acc", zzdrv13, zzdrv.RENDERING_AD_COMPONENT_CREATION_END);
        zzdrw zzdrw22 = zzdrw6;
        zzdrw zzdrw23 = new zzdrw("l.render.cfg-wv", zzdrv.RENDERING_CONFIGURE_WEBVIEW_START, zzdrv.RENDERING_CONFIGURE_WEBVIEW_END);
        zzdrv zzdrv14 = zzdrv.RENDERING_WEBVIEW_LOAD_HTML_START;
        zzdrw zzdrw24 = zzdrw8;
        zzdrv zzdrv15 = zzdrv.RENDERING_WEBVIEW_LOAD_HTML_END;
        zzdrw[] zzdrwArr = {zzdrw21, zzdrw23, new zzdrw("l.render.wvlh", zzdrv14, zzdrv15), new zzdrw("l.render.post", zzdrv15, zzdrv2)};
        zzdrw zzdrw25 = zzdrw12;
        zza = zzfzo.zzt(zzdrw25, zzdrw13, zzdrw18, zzdrw4, zzdrw22, zzdrw24, zzdrw10, zzdrw14, zzdrw15, zzdrw17, zzdrw19, zzdrw20, zzdrwArr);
        zzdrv zzdrv16 = zzdrv.PUBLIC_API_CALL;
        zzdrv zzdrv17 = zzdrv.PUBLIC_API_CALLBACK;
        zzdrw zzdrw26 = new zzdrw("l.al", zzdrv16, zzdrv17);
        zzdrv zzdrv18 = zzdrv.DYNAMITE_ENTER;
        zzdrw zzdrw27 = new zzdrw("l.al2", zzdrv18, zzdrv17);
        zzdrw zzdrw28 = new zzdrw("l.dl", zzdrv16, zzdrv18);
        zzdrv zzdrv19 = zzdrv.CLIENT_SIGNALS_START;
        zzdrw zzdrw29 = new zzdrw("l.rcc", zzdrv18, zzdrv19);
        zzdrv zzdrv20 = zzdrv.CLIENT_SIGNALS_END;
        zzdrw zzdrw30 = new zzdrw("l.cs", zzdrv19, zzdrv20);
        zzdrw zzdrw31 = new zzdrw("l.cts", zzdrv20, zzdrv.SERVICE_CONNECTED);
        zzdrv zzdrv21 = zzdrv.GMS_SIGNALS_START;
        zzdrv zzdrv22 = zzdrv.GMS_SIGNALS_END;
        zzdrw zzdrw32 = new zzdrw("l.gs", zzdrv21, zzdrv22);
        zzdrv zzdrv23 = zzdrv.GET_AD_DICTIONARY_SDKCORE_START;
        zzdrw zzdrw33 = new zzdrw("l.jse", zzdrv22, zzdrv23);
        zzdrv zzdrv24 = zzdrv.GET_AD_DICTIONARY_SDKCORE_END;
        zzdrw zzdrw34 = new zzdrw("l.gad-js", zzdrv23, zzdrv24);
        zzdrv zzdrv25 = zzdrv.HTTP_RESPONSE_READY;
        zzdrw zzdrw35 = new zzdrw("l.http", zzdrv24, zzdrv25);
        zzdrv zzdrv26 = zzdrv.NORMALIZATION_AD_RESPONSE_START;
        zzdrw zzdrw36 = new zzdrw("l.jse-nml", zzdrv25, zzdrv26);
        zzdrv zzdrv27 = zzdrv.NORMALIZATION_AD_RESPONSE_END;
        zzdrw zzdrw37 = new zzdrw("l.nml-js", zzdrv26, zzdrv27);
        zzdrv zzdrv28 = zzdrv.BINDER_CALL_START;
        zzdrw zzdrw38 = zzdrw26;
        zzdrw zzdrw39 = new zzdrw("l.nml-gmsg", zzdrv27, zzdrv28);
        zzdrv zzdrv29 = zzdrv.SERVER_RESPONSE_PARSE_START;
        zzdrw zzdrw40 = zzdrw29;
        zzdrw zzdrw41 = new zzdrw("l.binder", zzdrv28, zzdrv29);
        zzdrv zzdrv30 = zzdrv.RENDERING_START;
        zzdrw zzdrw42 = zzdrw41;
        zzdrw zzdrw43 = new zzdrw("l.sr", zzdrv29, zzdrv30);
        zzdrw zzdrw44 = new zzdrw("l.render", zzdrv30, zzdrv17);
        zzdrv zzdrv31 = zzdrv.RENDERING_WEBVIEW_CREATION_START;
        zzdrw zzdrw45 = zzdrw43;
        zzdrv zzdrv32 = zzdrv.RENDERING_WEBVIEW_CREATION_END;
        zzdrw zzdrw46 = zzdrw27;
        zzdrw zzdrw47 = new zzdrw("l.render.wvc", zzdrv31, zzdrv32);
        zzdrw zzdrw48 = zzdrw30;
        zzdrw zzdrw49 = zzdrw28;
        zzdrw zzdrw50 = new zzdrw("l.render.acc", zzdrv32, zzdrv.RENDERING_AD_COMPONENT_CREATION_END);
        zzdrw zzdrw51 = new zzdrw("l.render.cfg-wv", zzdrv.RENDERING_CONFIGURE_WEBVIEW_START, zzdrv.RENDERING_CONFIGURE_WEBVIEW_END);
        zzdrw zzdrw52 = new zzdrw("l.render.pre", zzdrv30, zzdrv31);
        zzdrv zzdrv33 = zzdrv.RENDERING_WEBVIEW_LOAD_HTML_END;
        zzdrw zzdrw53 = zzdrw51;
        zzdrw zzdrw54 = zzdrw52;
        zzdrw zzdrw55 = zzdrw39;
        zzdrw zzdrw56 = zzdrw47;
        zzdrw[] zzdrwArr2 = {zzdrw55, zzdrw42, zzdrw45, zzdrw44, zzdrw56, zzdrw50, zzdrw53, zzdrw54, new zzdrw("l.render.post", zzdrv33, zzdrv17), new zzdrw("l.render.wvlh", zzdrv.RENDERING_WEBVIEW_LOAD_HTML_START, zzdrv33)};
        zzdrw zzdrw57 = zzdrw46;
        zzdrw zzdrw58 = zzdrw49;
        zzb = zzfzo.zzt(zzdrw38, zzdrw57, zzdrw58, zzdrw40, zzdrw48, zzdrw31, zzdrw32, zzdrw33, zzdrw34, zzdrw35, zzdrw36, zzdrw37, zzdrwArr2);
    }

    public zzdrw(String str, zzdrv zzdrv, zzdrv zzdrv2) {
        this.zzc = str;
        this.zzd = zzdrv;
        this.zze = zzdrv2;
    }

    public final zzdrv zza() {
        return this.zzd;
    }

    public final zzdrv zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }
}
