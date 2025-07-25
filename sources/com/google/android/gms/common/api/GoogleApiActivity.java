package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    protected int zaa = 0;

    public static Intent zaa(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra(CloudMessagingReceiver.IntentKeys.PENDING_INTENT, pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zab() {
        /*
            r12 = this;
            android.content.Intent r0 = r12.getIntent()
            android.os.Bundle r1 = r0.getExtras()
            java.lang.String r2 = "GoogleApiActivity"
            if (r1 != 0) goto L_0x0015
            java.lang.String r0 = "Activity started without extras"
            android.util.Log.e(r2, r0)
            r12.finish()
            return
        L_0x0015:
            java.lang.String r0 = "pending_intent"
            java.lang.Object r0 = r1.get(r0)
            r3 = r0
            android.app.PendingIntent r3 = (android.app.PendingIntent) r3
            java.lang.String r0 = "error_code"
            java.lang.Object r0 = r1.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r3 != 0) goto L_0x0034
            if (r0 == 0) goto L_0x002b
            goto L_0x0034
        L_0x002b:
            java.lang.String r0 = "Activity started without resolution"
            android.util.Log.e(r2, r0)
            r12.finish()
            return
        L_0x0034:
            r4 = 1
            if (r3 == 0) goto L_0x00ab
            android.content.IntentSender r6 = r3.getIntentSender()     // Catch:{ ActivityNotFoundException -> 0x0056, SendIntentException -> 0x004b }
            r10 = 0
            r11 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r5 = r12
            r5.startIntentSenderForResult(r6, r7, r8, r9, r10, r11)     // Catch:{ ActivityNotFoundException -> 0x0049, SendIntentException -> 0x0047 }
            r5.zaa = r4     // Catch:{ ActivityNotFoundException -> 0x0049, SendIntentException -> 0x0047 }
            return
        L_0x0047:
            r0 = move-exception
            goto L_0x004d
        L_0x0049:
            r0 = move-exception
            goto L_0x0058
        L_0x004b:
            r0 = move-exception
            r5 = r12
        L_0x004d:
            java.lang.String r1 = "Failed to launch pendingIntent"
            android.util.Log.e(r2, r1, r0)
            r12.finish()
            return
        L_0x0056:
            r0 = move-exception
            r5 = r12
        L_0x0058:
            java.lang.String r6 = "notify_manager"
            boolean r1 = r1.getBoolean(r6, r4)
            if (r1 == 0) goto L_0x007b
            com.google.android.gms.common.api.internal.GoogleApiManager r0 = com.google.android.gms.common.api.internal.GoogleApiManager.zak(r12)
            com.google.android.gms.common.ConnectionResult r1 = new com.google.android.gms.common.ConnectionResult
            r2 = 22
            r3 = 0
            r1.<init>(r2, r3)
            android.content.Intent r2 = r12.getIntent()
            java.lang.String r3 = "failing_client_id"
            r6 = -1
            int r2 = r2.getIntExtra(r3, r6)
            r0.zax(r1, r2)
            goto L_0x00a5
        L_0x007b:
            java.lang.String r1 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "Activity not found while launching "
            r3.<init>(r6)
            r3.append(r1)
            java.lang.String r1 = "."
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r3 = android.os.Build.FINGERPRINT
            java.lang.String r6 = "generic"
            boolean r3 = r3.contains(r6)
            if (r3 == 0) goto L_0x00a2
            java.lang.String r3 = " This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store."
            java.lang.String r1 = r1.concat(r3)
        L_0x00a2:
            android.util.Log.e(r2, r1, r0)
        L_0x00a5:
            r5.zaa = r4
            r12.finish()
            return
        L_0x00ab:
            r5 = r12
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            com.google.android.gms.common.GoogleApiAvailability r1 = com.google.android.gms.common.GoogleApiAvailability.getInstance()
            r2 = 2
            r1.showErrorDialogFragment((android.app.Activity) r12, (int) r0, (int) r2, (android.content.DialogInterface.OnCancelListener) r12)
            r5.zaa = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApiActivity.zab():void");
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.zaa = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                GoogleApiManager zak = GoogleApiManager.zak(this);
                if (i2 == -1) {
                    zak.zay();
                } else if (i2 == 0) {
                    zak.zax(new ConnectionResult(13, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i == 2) {
            this.zaa = 0;
            setResult(i2, intent);
        }
        finish();
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zaa = 0;
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zaa = bundle.getInt("resolution");
        }
        if (this.zaa != 1) {
            zab();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.zaa);
        super.onSaveInstanceState(bundle);
    }
}
