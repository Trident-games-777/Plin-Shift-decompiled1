package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzffe {
    public final List zza;
    public final zzfew zzb;
    public final List zzc;
    public final zzbvx zzd;

    zzffe(JsonReader jsonReader, zzbvx zzbvx) throws IllegalStateException, IOException, JSONException, NumberFormatException, AssertionError {
        Bundle bundle;
        Bundle bundle2;
        this.zzd = zzbvx;
        if (!(!((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue() || zzbvx == null || (bundle2 = zzbvx.zzm) == null)) {
            bundle2.putLong(zzdrv.SERVER_RESPONSE_PARSE_START.zza(), zzv.zzC().currentTimeMillis());
        }
        List emptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzfew zzfew = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        emptyList = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            emptyList.add(new zzfet(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (nextName2.equals("common")) {
                        zzfew = new zzfew(jsonReader);
                        if (!(!((Boolean) zzbe.zzc().zza(zzbcn.zzcj)).booleanValue() || zzbvx == null || (bundle = zzbvx.zzm) == null)) {
                            bundle.putLong(zzdrv.NORMALIZATION_AD_RESPONSE_START.zza(), zzfew.zzs);
                            zzbvx.zzm.putLong(zzdrv.NORMALIZATION_AD_RESPONSE_END.zza(), zzfew.zzt);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (nextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    JSONObject jSONObject = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if ("name".equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if ("info".equals(nextName3)) {
                            jSONObject = zzbr.zzi(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList.add(new zzffd(str, jSONObject));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.zzc = arrayList;
        this.zza = emptyList;
        this.zzb = zzfew == null ? new zzfew(new JsonReader(new StringReader("{}"))) : zzfew;
    }

    public static zzffe zza(Reader reader, zzbvx zzbvx) throws zzfex {
        try {
            zzffe zzffe = new zzffe(new JsonReader(reader), zzbvx);
            IOUtils.closeQuietly((Closeable) reader);
            return zzffe;
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e) {
            throw new zzfex("unable to parse ServerResponse", e);
        } catch (Throwable th) {
            IOUtils.closeQuietly((Closeable) reader);
            throw th;
        }
    }
}
