package com.google.firebase.messaging;

import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FirebaseMessaging$$ExternalSyntheticLambda12 implements OnSuccessListener {
    public final /* synthetic */ FirebaseMessaging f$0;

    public /* synthetic */ FirebaseMessaging$$ExternalSyntheticLambda12(FirebaseMessaging firebaseMessaging) {
        this.f$0 = firebaseMessaging;
    }

    public final void onSuccess(Object obj) {
        this.f$0.m7750lambda$handleProxiedNotificationData$5$comgooglefirebasemessagingFirebaseMessaging((CloudMessage) obj);
    }
}
