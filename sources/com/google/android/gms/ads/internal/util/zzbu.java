package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzfet;
import com.google.android.gms.internal.ads.zzfwf;
import com.google.android.gms.internal.ads.zzfxd;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbu {
    public static Point zza(MotionEvent motionEvent, View view) {
        int[] zzj = zzj(view);
        return new Point(((int) motionEvent.getRawX()) - zzj[0], ((int) motionEvent.getRawY()) - zzj[1]);
    }

    public static WindowManager.LayoutParams zzb() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) zzbe.zzc().zza(zzbcn.zzhI)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    public static JSONObject zzc(String str, Context context, Point point, Point point2) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("x", zzbc.zzb().zzb(context, point2.x));
                    jSONObject3.put("y", zzbc.zzb().zzb(context, point2.y));
                    jSONObject3.put("start_x", zzbc.zzb().zzb(context, point.x));
                    jSONObject3.put("start_y", zzbc.zzb().zzb(context, point.y));
                    jSONObject = jSONObject3;
                } catch (JSONException e) {
                    zzm.zzh("Error occurred while putting signals into JSON object.", e);
                }
                jSONObject2.put("click_point", jSONObject);
                jSONObject2.put("asset_id", str);
                return jSONObject2;
            } catch (Exception e2) {
                e = e2;
                jSONObject = jSONObject2;
                zzm.zzh("Error occurred while grabbing click signals.", e);
                return jSONObject;
            }
        } catch (Exception e3) {
            e = e3;
            zzm.zzh("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
    }

    public static JSONObject zzd(Context context, Map map, Map map2, View view, ImageView.ScaleType scaleType) {
        Iterator it;
        String str;
        String str2;
        JSONObject jSONObject;
        Context context2 = context;
        Map map3 = map2;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject2 = new JSONObject();
        if (!(map == null || view == null)) {
            int[] zzj = zzj(view);
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] zzj2 = zzj(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    int[] iArr = zzj;
                    try {
                        it = it2;
                        try {
                            jSONObject4.put("width", zzbc.zzb().zzb(context2, view2.getMeasuredWidth()));
                            jSONObject4.put("height", zzbc.zzb().zzb(context2, view2.getMeasuredHeight()));
                            jSONObject4.put("x", zzbc.zzb().zzb(context2, zzj2[0] - iArr[0]));
                            jSONObject4.put("y", zzbc.zzb().zzb(context2, zzj2[1] - iArr[1]));
                            jSONObject4.put(str4, str3);
                            jSONObject3.put("frame", jSONObject4);
                            Rect rect = new Rect();
                            if (view2.getLocalVisibleRect(rect)) {
                                jSONObject = zzk(context2, rect);
                            } else {
                                jSONObject = new JSONObject();
                                jSONObject.put("width", 0);
                                jSONObject.put("height", 0);
                                jSONObject.put("x", zzbc.zzb().zzb(context2, zzj2[0] - iArr[0]));
                                jSONObject.put("y", zzbc.zzb().zzb(context2, zzj2[1] - iArr[1]));
                                jSONObject.put(str4, str3);
                            }
                            jSONObject3.put("visible_bounds", jSONObject);
                            if (((String) entry.getKey()).equals("3010")) {
                                if (((Boolean) zzbe.zzc().zza(zzbcn.zzhD)).booleanValue()) {
                                    jSONObject3.put("mediaview_graphics_matrix", view2.getMatrix().toShortString());
                                }
                                if (((Boolean) zzbe.zzc().zza(zzbcn.zzhE)).booleanValue()) {
                                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                                    jSONObject3.put("view_width_layout_type", zzl(layoutParams.width) - 1);
                                    jSONObject3.put("view_height_layout_type", zzl(layoutParams.height) - 1);
                                }
                                if (((Boolean) zzbe.zzc().zza(zzbcn.zzhF)).booleanValue()) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(Integer.valueOf(view2.getId()));
                                    for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                        arrayList.add(Integer.valueOf(((View) parent).getId()));
                                    }
                                    jSONObject3.put("view_path", TextUtils.join(RemoteSettings.FORWARD_SLASH_STRING, arrayList));
                                }
                                if (scaleType != null) {
                                    jSONObject3.put("mediaview_scale_type", scaleType.ordinal());
                                }
                            }
                            if (view2 instanceof TextView) {
                                TextView textView = (TextView) view2;
                                jSONObject3.put("text_color", textView.getCurrentTextColor());
                                str2 = str3;
                                str = str4;
                                try {
                                    jSONObject3.put("font_size", (double) textView.getTextSize());
                                    jSONObject3.put("text", textView.getText());
                                } catch (JSONException unused) {
                                    zzm.zzj("Unable to get asset views information");
                                    it2 = it;
                                    zzj = iArr;
                                    str3 = str2;
                                    str4 = str;
                                }
                            } else {
                                str2 = str3;
                                str = str4;
                            }
                            jSONObject3.put("is_clickable", map3 != null && map3.containsKey(entry.getKey()) && view2.isClickable());
                            jSONObject2.put((String) entry.getKey(), jSONObject3);
                        } catch (JSONException unused2) {
                            str2 = str3;
                            str = str4;
                            zzm.zzj("Unable to get asset views information");
                            it2 = it;
                            zzj = iArr;
                            str3 = str2;
                            str4 = str;
                        }
                    } catch (JSONException unused3) {
                        str2 = str3;
                        str = str4;
                        it = it2;
                        zzm.zzj("Unable to get asset views information");
                        it2 = it;
                        zzj = iArr;
                        str3 = str2;
                        str4 = str;
                    }
                    it2 = it;
                    zzj = iArr;
                    str3 = str2;
                    str4 = str;
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject zze(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                zzv.zzq();
                jSONObject.put("can_show_on_lock_screen", zzs.zzn(view));
                zzv.zzq();
                jSONObject.put("is_keyguard_locked", zzs.zzD(context));
                return jSONObject;
            } catch (JSONException unused) {
                zzm.zzj("Unable to get lock screen information");
            }
        }
        return jSONObject;
    }

    public static JSONObject zzf(View view) {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                boolean z = false;
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzhC)).booleanValue()) {
                    zzv.zzq();
                    ViewParent parent = view.getParent();
                    while (parent != null && !(parent instanceof ScrollView)) {
                        parent = parent.getParent();
                    }
                    if (parent != null) {
                        z = true;
                    }
                    jSONObject.put("contained_in_scroll_view", z);
                    return jSONObject;
                }
                zzv.zzq();
                ViewParent parent2 = view.getParent();
                while (parent2 != null && !(parent2 instanceof AdapterView)) {
                    parent2 = parent2.getParent();
                }
                if (parent2 == null) {
                    i = -1;
                } else {
                    i = ((AdapterView) parent2).getPositionForView(view);
                }
                if (i != -1) {
                    z = true;
                }
                jSONObject.put("contained_in_scroll_view", z);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x010c A[SYNTHETIC, Splitter:B:22:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0164 A[Catch:{ JSONException -> 0x016a }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0182 A[SYNTHETIC, Splitter:B:54:0x0182] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject zzg(android.content.Context r17, android.view.View r18) {
        /*
            r0 = r17
            r1 = r18
            java.lang.String r2 = "window"
            java.lang.String r3 = "relative_to"
            java.lang.String r4 = "y"
            java.lang.String r5 = "x"
            java.lang.String r6 = "height"
            java.lang.String r7 = "width"
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            if (r1 != 0) goto L_0x0019
            goto L_0x01a4
        L_0x0019:
            r9 = 2
            r10 = 1
            r11 = 0
            int[] r12 = zzj(r1)     // Catch:{ Exception -> 0x00ff }
            int[] r13 = new int[r9]     // Catch:{ Exception -> 0x00ff }
            int r14 = r1.getMeasuredWidth()     // Catch:{ Exception -> 0x00ff }
            r13[r11] = r14     // Catch:{ Exception -> 0x00ff }
            int r14 = r1.getMeasuredHeight()     // Catch:{ Exception -> 0x00ff }
            r13[r10] = r14     // Catch:{ Exception -> 0x00ff }
            android.view.ViewParent r14 = r1.getParent()     // Catch:{ Exception -> 0x00ff }
        L_0x0032:
            boolean r15 = r14 instanceof android.view.ViewGroup     // Catch:{ Exception -> 0x00ff }
            if (r15 == 0) goto L_0x005b
            r15 = r14
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ Exception -> 0x00ff }
            int r9 = r15.getMeasuredWidth()     // Catch:{ Exception -> 0x00ff }
            r16 = r10
            r10 = r13[r11]     // Catch:{ Exception -> 0x0101 }
            int r9 = java.lang.Math.min(r9, r10)     // Catch:{ Exception -> 0x0101 }
            r13[r11] = r9     // Catch:{ Exception -> 0x0101 }
            int r9 = r15.getMeasuredHeight()     // Catch:{ Exception -> 0x0101 }
            r10 = r13[r16]     // Catch:{ Exception -> 0x0101 }
            int r9 = java.lang.Math.min(r9, r10)     // Catch:{ Exception -> 0x0101 }
            r13[r16] = r9     // Catch:{ Exception -> 0x0101 }
            android.view.ViewParent r14 = r14.getParent()     // Catch:{ Exception -> 0x0101 }
            r10 = r16
            r9 = 2
            goto L_0x0032
        L_0x005b:
            r16 = r10
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0101 }
            r9.<init>()     // Catch:{ Exception -> 0x0101 }
            int r10 = r1.getMeasuredWidth()     // Catch:{ Exception -> 0x0101 }
            com.google.android.gms.ads.internal.util.client.zzf r14 = com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ Exception -> 0x0101 }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x0101 }
            r9.put(r7, r10)     // Catch:{ Exception -> 0x0101 }
            int r10 = r1.getMeasuredHeight()     // Catch:{ Exception -> 0x0101 }
            com.google.android.gms.ads.internal.util.client.zzf r14 = com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ Exception -> 0x0101 }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x0101 }
            r9.put(r6, r10)     // Catch:{ Exception -> 0x0101 }
            r10 = r12[r11]     // Catch:{ Exception -> 0x0101 }
            com.google.android.gms.ads.internal.util.client.zzf r14 = com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ Exception -> 0x0101 }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x0101 }
            r9.put(r5, r10)     // Catch:{ Exception -> 0x0101 }
            r10 = r12[r16]     // Catch:{ Exception -> 0x0101 }
            com.google.android.gms.ads.internal.util.client.zzf r14 = com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ Exception -> 0x0101 }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x0101 }
            r9.put(r4, r10)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r10 = "maximum_visible_width"
            r14 = r13[r11]     // Catch:{ Exception -> 0x0101 }
            com.google.android.gms.ads.internal.util.client.zzf r15 = com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ Exception -> 0x0101 }
            int r14 = r15.zzb(r0, r14)     // Catch:{ Exception -> 0x0101 }
            r9.put(r10, r14)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r10 = "maximum_visible_height"
            r13 = r13[r16]     // Catch:{ Exception -> 0x0101 }
            com.google.android.gms.ads.internal.util.client.zzf r14 = com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ Exception -> 0x0101 }
            int r13 = r14.zzb(r0, r13)     // Catch:{ Exception -> 0x0101 }
            r9.put(r10, r13)     // Catch:{ Exception -> 0x0101 }
            r9.put(r3, r2)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r10 = "frame"
            r8.put(r10, r9)     // Catch:{ Exception -> 0x0101 }
            android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ Exception -> 0x0101 }
            r9.<init>()     // Catch:{ Exception -> 0x0101 }
            boolean r10 = r1.getGlobalVisibleRect(r9)     // Catch:{ Exception -> 0x0101 }
            if (r10 == 0) goto L_0x00d0
            org.json.JSONObject r0 = zzk(r0, r9)     // Catch:{ Exception -> 0x0101 }
            goto L_0x00f9
        L_0x00d0:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0101 }
            r9.<init>()     // Catch:{ Exception -> 0x0101 }
            r9.put(r7, r11)     // Catch:{ Exception -> 0x0101 }
            r9.put(r6, r11)     // Catch:{ Exception -> 0x0101 }
            r6 = r12[r11]     // Catch:{ Exception -> 0x0101 }
            com.google.android.gms.ads.internal.util.client.zzf r7 = com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ Exception -> 0x0101 }
            int r6 = r7.zzb(r0, r6)     // Catch:{ Exception -> 0x0101 }
            r9.put(r5, r6)     // Catch:{ Exception -> 0x0101 }
            r5 = r12[r16]     // Catch:{ Exception -> 0x0101 }
            com.google.android.gms.ads.internal.util.client.zzf r6 = com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ Exception -> 0x0101 }
            int r0 = r6.zzb(r0, r5)     // Catch:{ Exception -> 0x0101 }
            r9.put(r4, r0)     // Catch:{ Exception -> 0x0101 }
            r9.put(r3, r2)     // Catch:{ Exception -> 0x0101 }
            r0 = r9
        L_0x00f9:
            java.lang.String r2 = "visible_bounds"
            r8.put(r2, r0)     // Catch:{ Exception -> 0x0101 }
            goto L_0x0106
        L_0x00ff:
            r16 = r10
        L_0x0101:
            java.lang.String r0 = "Unable to get native ad view bounding box"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
        L_0x0106:
            android.view.ViewParent r0 = r1.getParent()
            if (r0 == 0) goto L_0x012b
            java.lang.Class r2 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x012b, SecurityException -> 0x0125, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x0121 }
            java.lang.String r3 = "getTemplateTypeName"
            java.lang.Class[] r4 = new java.lang.Class[r11]     // Catch:{ NoSuchMethodException -> 0x012b, SecurityException -> 0x0125, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x0121 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x012b, SecurityException -> 0x0125, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x0121 }
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ NoSuchMethodException -> 0x012b, SecurityException -> 0x0125, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x0121 }
            java.lang.Object r0 = r2.invoke(r0, r3)     // Catch:{ NoSuchMethodException -> 0x012b, SecurityException -> 0x0125, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x0121 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NoSuchMethodException -> 0x012b, SecurityException -> 0x0125, IllegalAccessException -> 0x0123, InvocationTargetException -> 0x0121 }
            goto L_0x012d
        L_0x0121:
            r0 = move-exception
            goto L_0x0126
        L_0x0123:
            r0 = move-exception
            goto L_0x0126
        L_0x0125:
            r0 = move-exception
        L_0x0126:
            java.lang.String r2 = "Cannot access method getTemplateTypeName: "
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
        L_0x012b:
            java.lang.String r0 = ""
        L_0x012d:
            r2 = -1
            int r3 = r0.hashCode()     // Catch:{ JSONException -> 0x016a }
            r4 = -2066603854(0xffffffff84d220b2, float:-4.940079E-36)
            if (r3 == r4) goto L_0x0148
            r4 = 2019754500(0x78630204, float:1.8417067E34)
            if (r3 == r4) goto L_0x013d
            goto L_0x0152
        L_0x013d:
            java.lang.String r3 = "medium_template"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0152
            r0 = r16
            goto L_0x0153
        L_0x0148:
            java.lang.String r3 = "small_template"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0152
            r0 = r11
            goto L_0x0153
        L_0x0152:
            r0 = r2
        L_0x0153:
            java.lang.String r3 = "native_template_type"
            if (r0 == 0) goto L_0x0164
            r4 = r16
            if (r0 == r4) goto L_0x015f
            r8.put(r3, r11)     // Catch:{ JSONException -> 0x016a }
            goto L_0x0170
        L_0x015f:
            r4 = 2
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x016a }
            goto L_0x0170
        L_0x0164:
            r4 = r16
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x016a }
            goto L_0x0170
        L_0x016a:
            r0 = move-exception
            java.lang.String r3 = "Could not log native template signal to JSON"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r3, r0)
        L_0x0170:
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzhE
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r3.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01a4
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "view_width_layout_type"
            int r3 = r0.width     // Catch:{ Exception -> 0x019f }
            int r3 = zzl(r3)     // Catch:{ Exception -> 0x019f }
            int r3 = r3 + r2
            r8.put(r1, r3)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "view_height_layout_type"
            int r0 = r0.height     // Catch:{ Exception -> 0x019f }
            int r0 = zzl(r0)     // Catch:{ Exception -> 0x019f }
            int r0 = r0 + r2
            r8.put(r1, r0)     // Catch:{ Exception -> 0x019f }
            goto L_0x01a4
        L_0x019f:
            java.lang.String r0 = "Unable to get native ad view layout types"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
        L_0x01a4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbu.zzg(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static boolean zzh(Context context, zzfet zzfet) {
        if (!zzfet.zzN) {
            return false;
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhG)).booleanValue()) {
            return ((Boolean) zzbe.zzc().zza(zzbcn.zzhJ)).booleanValue();
        }
        String str = (String) zzbe.zzc().zza(zzbcn.zzhH);
        if (!str.isEmpty() && context != null) {
            String packageName = context.getPackageName();
            for (String equals : zzfxd.zzb(zzfwf.zzc(';')).zzc(str)) {
                if (equals.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean zzi(int i) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzdA)).booleanValue()) {
            return true;
        }
        return ((Boolean) zzbe.zzc().zza(zzbcn.zzdB)).booleanValue() || i <= 15299999;
    }

    public static int[] zzj(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    private static JSONObject zzk(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzbc.zzb().zzb(context, rect.right - rect.left));
        jSONObject.put("height", zzbc.zzb().zzb(context, rect.bottom - rect.top));
        jSONObject.put("x", zzbc.zzb().zzb(context, rect.left));
        jSONObject.put("y", zzbc.zzb().zzb(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private static int zzl(int i) {
        if (i != -2) {
            return i != -1 ? 2 : 3;
        }
        return 4;
    }
}
