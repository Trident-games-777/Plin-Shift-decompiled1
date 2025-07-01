package androidx.compose.ui.graphics.layer;

import android.os.Handler;
import android.os.Message;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LayerManager$$ExternalSyntheticLambda1 implements Handler.Callback {
    public final /* synthetic */ LayerManager f$0;

    public /* synthetic */ LayerManager$$ExternalSyntheticLambda1(LayerManager layerManager) {
        this.f$0 = layerManager;
    }

    public final boolean handleMessage(Message message) {
        return LayerManager.handler$lambda$0(this.f$0, message);
    }
}
