package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import java.lang.ref.WeakReference;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdfj extends zzcrq {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzddp zze;
    private final zzdgv zzf;
    private final zzcsl zzg;
    private final zzfqa zzh;
    private final zzcwz zzi;
    private final zzcad zzj;
    private boolean zzk = false;

    zzdfj(zzcrp zzcrp, Context context, @Nullable zzcfk zzcfk, zzddp zzddp, zzdgv zzdgv, zzcsl zzcsl, zzfqa zzfqa, zzcwz zzcwz, zzcad zzcad) {
        super(zzcrp);
        this.zzc = context;
        this.zzd = new WeakReference(zzcfk);
        this.zze = zzddp;
        this.zzf = zzdgv;
        this.zzg = zzcsl;
        this.zzh = zzfqa;
        this.zzi = zzcwz;
        this.zzj = zzcad;
    }

    public final void finalize() throws Throwable {
        try {
            zzcfk zzcfk = (zzcfk) this.zzd.get();
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzgB)).booleanValue()) {
                if (!this.zzk && zzcfk != null) {
                    zzges zzges = zzcaj.zze;
                    Objects.requireNonNull(zzcfk);
                    zzges.execute(new zzdfi(zzcfk));
                }
            } else if (zzcfk != null) {
                zzcfk.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean zza() {
        return this.zzg.zzg();
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:579)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:485)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        */
    public final boolean zzc(boolean r5, @javax.annotation.Nullable android.app.Activity r6) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzddp r0 = r4.zze
            r0.zzb()
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzaJ
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x004e
            com.google.android.gms.ads.internal.zzv.zzq()
            android.content.Context r0 = r4.zzc
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.zzG(r0)
            if (r0 == 0) goto L_0x004e
            java.lang.String r5 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)
            com.google.android.gms.internal.ads.zzcwz r5 = r4.zzi
            r5.zzb()
            com.google.android.gms.internal.ads.zzbce r5 = com.google.android.gms.internal.ads.zzbcn.zzaK
            com.google.android.gms.internal.ads.zzbcl r6 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r5 = r6.zza(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzfqa r5 = r4.zzh
            com.google.android.gms.internal.ads.zzfff r6 = r4.zza
            com.google.android.gms.internal.ads.zzffe r6 = r6.zzb
            com.google.android.gms.internal.ads.zzfew r6 = r6.zzb
            java.lang.String r6 = r6.zzb
            r5.zza(r6)
            goto L_0x00c4
        L_0x004e:
            java.lang.ref.WeakReference r0 = r4.zzd
            java.lang.Object r0 = r0.get()
            com.google.android.gms.internal.ads.zzcfk r0 = (com.google.android.gms.internal.ads.zzcfk) r0
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzlC
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r3 = 0
            if (r2 == 0) goto L_0x0092
            if (r0 == 0) goto L_0x0092
            com.google.android.gms.internal.ads.zzfet r0 = r0.zzD()
            if (r0 == 0) goto L_0x0092
            boolean r2 = r0.zzar
            if (r2 == 0) goto L_0x0092
            int r0 = r0.zzas
            com.google.android.gms.internal.ads.zzcad r2 = r4.zzj
            int r2 = r2.zzb()
            if (r0 == r2) goto L_0x0092
            java.lang.String r5 = "The interstitial consent form has been shown."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)
            com.google.android.gms.internal.ads.zzcwz r5 = r4.zzi
            r6 = 12
            java.lang.String r0 = "The consent form has already been shown."
            com.google.android.gms.ads.internal.client.zze r6 = com.google.android.gms.internal.ads.zzfgq.zzd(r6, r0, r3)
            r5.zza(r6)
            goto L_0x00c4
        L_0x0092:
            boolean r0 = r4.zzk
            if (r0 == 0) goto L_0x00a6
            java.lang.String r0 = "The interstitial ad has been shown."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            com.google.android.gms.internal.ads.zzcwz r0 = r4.zzi
            r2 = 10
            com.google.android.gms.ads.internal.client.zze r2 = com.google.android.gms.internal.ads.zzfgq.zzd(r2, r3, r3)
            r0.zza(r2)
        L_0x00a6:
            boolean r0 = r4.zzk
            if (r0 != 0) goto L_0x00c4
            if (r6 != 0) goto L_0x00ae
            android.content.Context r6 = r4.zzc
        L_0x00ae:
            com.google.android.gms.internal.ads.zzdgv r0 = r4.zzf     // Catch:{ zzdgu -> 0x00be }
            com.google.android.gms.internal.ads.zzcwz r2 = r4.zzi     // Catch:{ zzdgu -> 0x00be }
            r0.zza(r5, r6, r2)     // Catch:{ zzdgu -> 0x00be }
            com.google.android.gms.internal.ads.zzddp r5 = r4.zze     // Catch:{ zzdgu -> 0x00be }
            r5.zza()     // Catch:{ zzdgu -> 0x00be }
            r5 = 1
            r4.zzk = r5
            return r5
        L_0x00be:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzcwz r6 = r4.zzi
            r6.zzc(r5)
        L_0x00c4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdfj.zzc(boolean, android.app.Activity):boolean");
    }
}
