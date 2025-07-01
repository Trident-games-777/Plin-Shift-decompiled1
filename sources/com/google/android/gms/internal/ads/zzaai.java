package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.view.Surface;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.WorkRequest;
import java.nio.ByteBuffer;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaai extends zzsy implements zzaao {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private long zzA;
    private int zzB;
    private long zzC;
    private zzci zzD;
    private zzci zzE;
    private int zzF;
    private int zzG;
    private zzaam zzH;
    private long zzI;
    private long zzJ;
    private boolean zzK;
    private final Context zze;
    private final boolean zzf;
    private final zzabf zzg;
    private final boolean zzh;
    private final zzaap zzi;
    private final zzaan zzj;
    private zzaah zzk;
    private boolean zzl;
    private boolean zzm;
    private zzabl zzn = null;
    private boolean zzo;
    private List zzp;
    /* access modifiers changed from: private */
    public Surface zzq;
    private zzaal zzr;
    private zzee zzs;
    private boolean zzt;
    private int zzu;
    private int zzv;
    private long zzw;
    private int zzx;
    private int zzy;
    private int zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaai(Context context, zzsl zzsl, zzta zzta, long j, boolean z, Handler handler, zzabg zzabg, int i, float f) {
        super(2, zzsl, zzta, false, 30.0f);
        zzabl zzabl = null;
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        this.zzg = new zzabf(handler, zzabg);
        this.zzf = true;
        this.zzi = new zzaap(applicationContext, this, 0);
        this.zzj = new zzaan();
        this.zzh = "NVIDIA".equals(zzen.zzc);
        this.zzs = zzee.zza;
        this.zzu = 1;
        this.zzv = 0;
        this.zzD = zzci.zza;
        this.zzG = 0;
        this.zzE = null;
        this.zzF = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        this.zzI = -9223372036854775807L;
        this.zzJ = -9223372036854775807L;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x04c3, code lost:
        if (r13.equals("deb") != false) goto L_0x078b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:508:0x079e, code lost:
        if (r0.equals("JSN-L21") == false) goto L_0x07a2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static final boolean zzaU(java.lang.String r17) {
        /*
            java.lang.String r0 = "OMX.google"
            r1 = r17
            boolean r0 = r1.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            java.lang.Class<com.google.android.gms.internal.ads.zzaai> r2 = com.google.android.gms.internal.ads.zzaai.class
            monitor-enter(r2)
            boolean r0 = zzc     // Catch:{ all -> 0x07aa }
            if (r0 != 0) goto L_0x07a6
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x07aa }
            r3 = 28
            r4 = 5
            r5 = 6
            r6 = 4
            r7 = 7
            r8 = 2
            r9 = 3
            r10 = -1
            r11 = 1
            if (r0 > r3) goto L_0x0083
            java.lang.String r0 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ all -> 0x07aa }
            int r12 = r0.hashCode()     // Catch:{ all -> 0x07aa }
            switch(r12) {
                case -1339091551: goto L_0x0071;
                case -1220081023: goto L_0x0067;
                case -1220066608: goto L_0x005d;
                case -1012436106: goto L_0x0053;
                case -760312546: goto L_0x0049;
                case -64886864: goto L_0x003f;
                case 3415681: goto L_0x0035;
                case 825323514: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x007b
        L_0x002b:
            java.lang.String r12 = "machuca"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = r4
            goto L_0x007c
        L_0x0035:
            java.lang.String r12 = "once"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = r5
            goto L_0x007c
        L_0x003f:
            java.lang.String r12 = "magnolia"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = r6
            goto L_0x007c
        L_0x0049:
            java.lang.String r12 = "aquaman"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = r1
            goto L_0x007c
        L_0x0053:
            java.lang.String r12 = "oneday"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = r7
            goto L_0x007c
        L_0x005d:
            java.lang.String r12 = "dangalUHD"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = r8
            goto L_0x007c
        L_0x0067:
            java.lang.String r12 = "dangalFHD"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = r9
            goto L_0x007c
        L_0x0071:
            java.lang.String r12 = "dangal"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x007b
            r0 = r11
            goto L_0x007c
        L_0x007b:
            r0 = r10
        L_0x007c:
            switch(r0) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x0083
        L_0x0080:
            r1 = r11
            goto L_0x07a2
        L_0x0083:
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x07aa }
            r12 = 27
            if (r0 > r12) goto L_0x0094
            java.lang.String r0 = "HWEML"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ all -> 0x07aa }
            boolean r0 = r0.equals(r13)     // Catch:{ all -> 0x07aa }
            if (r0 == 0) goto L_0x0094
            goto L_0x0080
        L_0x0094:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzen.zzd     // Catch:{ all -> 0x07aa }
            int r13 = r0.hashCode()     // Catch:{ all -> 0x07aa }
            r14 = 8
            switch(r13) {
                case -349662828: goto L_0x00f1;
                case -321033677: goto L_0x00e7;
                case 2006354: goto L_0x00dd;
                case 2006367: goto L_0x00d3;
                case 2006371: goto L_0x00c9;
                case 1785421873: goto L_0x00bf;
                case 1785421876: goto L_0x00b5;
                case 1798172390: goto L_0x00ab;
                case 2119412532: goto L_0x00a1;
                default: goto L_0x009f;
            }
        L_0x009f:
            goto L_0x00fb
        L_0x00a1:
            java.lang.String r13 = "AFTEUFF014"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = r4
            goto L_0x00fc
        L_0x00ab:
            java.lang.String r13 = "AFTSO001"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = r14
            goto L_0x00fc
        L_0x00b5:
            java.lang.String r13 = "AFTEU014"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = r6
            goto L_0x00fc
        L_0x00bf:
            java.lang.String r13 = "AFTEU011"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = r9
            goto L_0x00fc
        L_0x00c9:
            java.lang.String r13 = "AFTR"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = r8
            goto L_0x00fc
        L_0x00d3:
            java.lang.String r13 = "AFTN"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = r11
            goto L_0x00fc
        L_0x00dd:
            java.lang.String r13 = "AFTA"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = r1
            goto L_0x00fc
        L_0x00e7:
            java.lang.String r13 = "AFTKMST12"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = r7
            goto L_0x00fc
        L_0x00f1:
            java.lang.String r13 = "AFTJMST12"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00fb
            r13 = r5
            goto L_0x00fc
        L_0x00fb:
            r13 = r10
        L_0x00fc:
            switch(r13) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                case 8: goto L_0x0080;
                default: goto L_0x00ff;
            }
        L_0x00ff:
            int r13 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x07aa }
            r15 = 26
            if (r13 > r15) goto L_0x07a2
            java.lang.String r13 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ all -> 0x07aa }
            int r16 = r13.hashCode()     // Catch:{ all -> 0x07aa }
            switch(r16) {
                case -2144781245: goto L_0x077f;
                case -2144781185: goto L_0x0774;
                case -2144781160: goto L_0x0769;
                case -2097309513: goto L_0x075e;
                case -2022874474: goto L_0x0753;
                case -1978993182: goto L_0x0748;
                case -1978990237: goto L_0x073d;
                case -1936688988: goto L_0x0732;
                case -1936688066: goto L_0x0727;
                case -1936688065: goto L_0x071b;
                case -1931988508: goto L_0x070f;
                case -1885099851: goto L_0x0703;
                case -1696512866: goto L_0x06f7;
                case -1680025915: goto L_0x06eb;
                case -1615810839: goto L_0x06df;
                case -1600724499: goto L_0x06d3;
                case -1554255044: goto L_0x06c7;
                case -1481772737: goto L_0x06bb;
                case -1481772730: goto L_0x06af;
                case -1481772729: goto L_0x06a3;
                case -1320080169: goto L_0x0697;
                case -1217592143: goto L_0x068b;
                case -1180384755: goto L_0x067f;
                case -1139198265: goto L_0x0673;
                case -1052835013: goto L_0x0667;
                case -993250464: goto L_0x065c;
                case -993250458: goto L_0x0651;
                case -965403638: goto L_0x0645;
                case -958336948: goto L_0x0639;
                case -879245230: goto L_0x062d;
                case -842500323: goto L_0x0621;
                case -821392978: goto L_0x0615;
                case -797483286: goto L_0x0609;
                case -794946968: goto L_0x05fd;
                case -788334647: goto L_0x05f1;
                case -782144577: goto L_0x05e5;
                case -575125681: goto L_0x05d9;
                case -521118391: goto L_0x05cd;
                case -430914369: goto L_0x05c1;
                case -290434366: goto L_0x05b5;
                case -282781963: goto L_0x05a9;
                case -277133239: goto L_0x059d;
                case -173639913: goto L_0x0591;
                case -56598463: goto L_0x0585;
                case 2126: goto L_0x0579;
                case 2564: goto L_0x056d;
                case 2715: goto L_0x0561;
                case 2719: goto L_0x0555;
                case 3091: goto L_0x0549;
                case 3483: goto L_0x053d;
                case 73405: goto L_0x0531;
                case 75537: goto L_0x0525;
                case 75739: goto L_0x0519;
                case 76779: goto L_0x050d;
                case 78669: goto L_0x0501;
                case 79305: goto L_0x04f5;
                case 80618: goto L_0x04e9;
                case 88274: goto L_0x04dd;
                case 98846: goto L_0x04d2;
                case 98848: goto L_0x04c7;
                case 99329: goto L_0x04bd;
                case 101481: goto L_0x04b1;
                case 1513190: goto L_0x04a6;
                case 1514184: goto L_0x049b;
                case 1514185: goto L_0x0490;
                case 2133089: goto L_0x0484;
                case 2133091: goto L_0x0478;
                case 2133120: goto L_0x046c;
                case 2133151: goto L_0x0460;
                case 2133182: goto L_0x0454;
                case 2133184: goto L_0x0448;
                case 2436959: goto L_0x043c;
                case 2463773: goto L_0x0430;
                case 2464648: goto L_0x0424;
                case 2689555: goto L_0x0418;
                case 3154429: goto L_0x040c;
                case 3284551: goto L_0x0400;
                case 3351335: goto L_0x03f4;
                case 3386211: goto L_0x03e8;
                case 41325051: goto L_0x03dc;
                case 51349633: goto L_0x03d1;
                case 51350594: goto L_0x03c6;
                case 55178625: goto L_0x03ba;
                case 61542055: goto L_0x03af;
                case 65355429: goto L_0x03a3;
                case 66214468: goto L_0x0397;
                case 66214470: goto L_0x038b;
                case 66214473: goto L_0x037f;
                case 66215429: goto L_0x0373;
                case 66215431: goto L_0x0367;
                case 66215433: goto L_0x035b;
                case 66216390: goto L_0x034f;
                case 76402249: goto L_0x0343;
                case 76404105: goto L_0x0337;
                case 76404911: goto L_0x032b;
                case 80963634: goto L_0x031f;
                case 82882791: goto L_0x0313;
                case 98715550: goto L_0x0307;
                case 101370885: goto L_0x02fb;
                case 102844228: goto L_0x02ef;
                case 165221241: goto L_0x02e4;
                case 182191441: goto L_0x02d8;
                case 245388979: goto L_0x02cc;
                case 287431619: goto L_0x02c0;
                case 307593612: goto L_0x02b4;
                case 308517133: goto L_0x02a8;
                case 316215098: goto L_0x029c;
                case 316215116: goto L_0x0290;
                case 316246811: goto L_0x0284;
                case 316246818: goto L_0x0278;
                case 407160593: goto L_0x026c;
                case 507412548: goto L_0x0260;
                case 793982701: goto L_0x0254;
                case 794038622: goto L_0x0248;
                case 794040393: goto L_0x023c;
                case 835649806: goto L_0x0230;
                case 917340916: goto L_0x0224;
                case 958008161: goto L_0x0218;
                case 1060579533: goto L_0x020c;
                case 1150207623: goto L_0x0200;
                case 1176899427: goto L_0x01f4;
                case 1280332038: goto L_0x01e8;
                case 1306947716: goto L_0x01dc;
                case 1349174697: goto L_0x01d0;
                case 1522194893: goto L_0x01c4;
                case 1691543273: goto L_0x01b8;
                case 1691544261: goto L_0x01ac;
                case 1709443163: goto L_0x01a0;
                case 1865889110: goto L_0x0194;
                case 1906253259: goto L_0x0188;
                case 1977196784: goto L_0x017c;
                case 2006372676: goto L_0x0170;
                case 2019281702: goto L_0x0164;
                case 2029784656: goto L_0x0158;
                case 2030379515: goto L_0x014c;
                case 2033393791: goto L_0x0140;
                case 2047190025: goto L_0x0134;
                case 2047252157: goto L_0x0128;
                case 2048319463: goto L_0x011c;
                case 2048855701: goto L_0x0110;
                default: goto L_0x010e;
            }
        L_0x010e:
            goto L_0x078a
        L_0x0110:
            java.lang.String r3 = "HWWAS-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 66
            goto L_0x078b
        L_0x011c:
            java.lang.String r3 = "HWVNS-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 65
            goto L_0x078b
        L_0x0128:
            java.lang.String r3 = "ELUGA_Prim"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 33
            goto L_0x078b
        L_0x0134:
            java.lang.String r3 = "ELUGA_Note"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 32
            goto L_0x078b
        L_0x0140:
            java.lang.String r3 = "ASUS_X00AD_2"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 14
            goto L_0x078b
        L_0x014c:
            java.lang.String r3 = "HWCAM-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 64
            goto L_0x078b
        L_0x0158:
            java.lang.String r3 = "HWBLN-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 63
            goto L_0x078b
        L_0x0164:
            java.lang.String r3 = "DM-01K"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 29
            goto L_0x078b
        L_0x0170:
            java.lang.String r3 = "BRAVIA_ATV3_4K"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 19
            goto L_0x078b
        L_0x017c:
            java.lang.String r3 = "Infinix-X572"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 69
            goto L_0x078b
        L_0x0188:
            java.lang.String r3 = "PB2-670M"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 100
            goto L_0x078b
        L_0x0194:
            java.lang.String r3 = "santoni"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 117(0x75, float:1.64E-43)
            goto L_0x078b
        L_0x01a0:
            java.lang.String r3 = "iball8735_9806"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 68
            goto L_0x078b
        L_0x01ac:
            java.lang.String r3 = "CPH1715"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 24
            goto L_0x078b
        L_0x01b8:
            java.lang.String r3 = "CPH1609"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 23
            goto L_0x078b
        L_0x01c4:
            java.lang.String r3 = "woods_f"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 133(0x85, float:1.86E-43)
            goto L_0x078b
        L_0x01d0:
            java.lang.String r3 = "htc_e56ml_dtul"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 61
            goto L_0x078b
        L_0x01dc:
            java.lang.String r3 = "EverStar_S"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 35
            goto L_0x078b
        L_0x01e8:
            java.lang.String r3 = "hwALE-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 62
            goto L_0x078b
        L_0x01f4:
            java.lang.String r3 = "itel_S41"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 71
            goto L_0x078b
        L_0x0200:
            java.lang.String r3 = "LS-5017"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 78
            goto L_0x078b
        L_0x020c:
            java.lang.String r3 = "panell_d"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 96
            goto L_0x078b
        L_0x0218:
            java.lang.String r3 = "j2xlteins"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 72
            goto L_0x078b
        L_0x0224:
            java.lang.String r3 = "A7000plus"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 10
            goto L_0x078b
        L_0x0230:
            java.lang.String r3 = "manning"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 81
            goto L_0x078b
        L_0x023c:
            java.lang.String r3 = "GIONEE_WBL7519"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 59
            goto L_0x078b
        L_0x0248:
            java.lang.String r3 = "GIONEE_WBL7365"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 58
            goto L_0x078b
        L_0x0254:
            java.lang.String r3 = "GIONEE_WBL5708"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 57
            goto L_0x078b
        L_0x0260:
            java.lang.String r3 = "QM16XE_U"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 114(0x72, float:1.6E-43)
            goto L_0x078b
        L_0x026c:
            java.lang.String r3 = "Pixi5-10_4G"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 106(0x6a, float:1.49E-43)
            goto L_0x078b
        L_0x0278:
            java.lang.String r3 = "TB3-850M"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 125(0x7d, float:1.75E-43)
            goto L_0x078b
        L_0x0284:
            java.lang.String r3 = "TB3-850F"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 124(0x7c, float:1.74E-43)
            goto L_0x078b
        L_0x0290:
            java.lang.String r3 = "TB3-730X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 123(0x7b, float:1.72E-43)
            goto L_0x078b
        L_0x029c:
            java.lang.String r3 = "TB3-730F"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 122(0x7a, float:1.71E-43)
            goto L_0x078b
        L_0x02a8:
            java.lang.String r3 = "A7020a48"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 12
            goto L_0x078b
        L_0x02b4:
            java.lang.String r3 = "A7010a48"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 11
            goto L_0x078b
        L_0x02c0:
            java.lang.String r3 = "griffin"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 60
            goto L_0x078b
        L_0x02cc:
            java.lang.String r3 = "marino_f"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 82
            goto L_0x078b
        L_0x02d8:
            java.lang.String r3 = "CPY83_I00"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 25
            goto L_0x078b
        L_0x02e4:
            java.lang.String r3 = "A2016a40"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = r14
            goto L_0x078b
        L_0x02ef:
            java.lang.String r3 = "le_x6"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 77
            goto L_0x078b
        L_0x02fb:
            java.lang.String r3 = "l5460"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 76
            goto L_0x078b
        L_0x0307:
            java.lang.String r3 = "i9031"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 67
            goto L_0x078b
        L_0x0313:
            java.lang.String r3 = "X3_HK"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 135(0x87, float:1.89E-43)
            goto L_0x078b
        L_0x031f:
            java.lang.String r3 = "V23GB"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x078b
        L_0x032b:
            java.lang.String r3 = "Q4310"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 112(0x70, float:1.57E-43)
            goto L_0x078b
        L_0x0337:
            java.lang.String r3 = "Q4260"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 110(0x6e, float:1.54E-43)
            goto L_0x078b
        L_0x0343:
            java.lang.String r3 = "PRO7S"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 108(0x6c, float:1.51E-43)
            goto L_0x078b
        L_0x034f:
            java.lang.String r3 = "F3311"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 48
            goto L_0x078b
        L_0x035b:
            java.lang.String r3 = "F3215"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 47
            goto L_0x078b
        L_0x0367:
            java.lang.String r3 = "F3213"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 46
            goto L_0x078b
        L_0x0373:
            java.lang.String r3 = "F3211"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 45
            goto L_0x078b
        L_0x037f:
            java.lang.String r3 = "F3116"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 44
            goto L_0x078b
        L_0x038b:
            java.lang.String r3 = "F3113"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 43
            goto L_0x078b
        L_0x0397:
            java.lang.String r3 = "F3111"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 42
            goto L_0x078b
        L_0x03a3:
            java.lang.String r3 = "E5643"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 30
            goto L_0x078b
        L_0x03af:
            java.lang.String r3 = "A1601"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = r7
            goto L_0x078b
        L_0x03ba:
            java.lang.String r3 = "Aura_Note_2"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 15
            goto L_0x078b
        L_0x03c6:
            java.lang.String r3 = "602LV"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = r6
            goto L_0x078b
        L_0x03d1:
            java.lang.String r3 = "601LV"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = r9
            goto L_0x078b
        L_0x03dc:
            java.lang.String r3 = "MEIZU_M5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 83
            goto L_0x078b
        L_0x03e8:
            java.lang.String r3 = "p212"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 92
            goto L_0x078b
        L_0x03f4:
            java.lang.String r3 = "mido"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 85
            goto L_0x078b
        L_0x0400:
            java.lang.String r3 = "kate"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 75
            goto L_0x078b
        L_0x040c:
            java.lang.String r3 = "fugu"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 50
            goto L_0x078b
        L_0x0418:
            java.lang.String r3 = "XE2X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 136(0x88, float:1.9E-43)
            goto L_0x078b
        L_0x0424:
            java.lang.String r3 = "Q427"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 111(0x6f, float:1.56E-43)
            goto L_0x078b
        L_0x0430:
            java.lang.String r3 = "Q350"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 109(0x6d, float:1.53E-43)
            goto L_0x078b
        L_0x043c:
            java.lang.String r3 = "P681"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 93
            goto L_0x078b
        L_0x0448:
            java.lang.String r3 = "F04J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 41
            goto L_0x078b
        L_0x0454:
            java.lang.String r3 = "F04H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 40
            goto L_0x078b
        L_0x0460:
            java.lang.String r3 = "F03H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 39
            goto L_0x078b
        L_0x046c:
            java.lang.String r3 = "F02H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 38
            goto L_0x078b
        L_0x0478:
            java.lang.String r3 = "F01J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 37
            goto L_0x078b
        L_0x0484:
            java.lang.String r3 = "F01H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 36
            goto L_0x078b
        L_0x0490:
            java.lang.String r3 = "1714"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = r8
            goto L_0x078b
        L_0x049b:
            java.lang.String r3 = "1713"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = r11
            goto L_0x078b
        L_0x04a6:
            java.lang.String r3 = "1601"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = r1
            goto L_0x078b
        L_0x04b1:
            java.lang.String r3 = "flo"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 49
            goto L_0x078b
        L_0x04bd:
            java.lang.String r4 = "deb"
            boolean r4 = r13.equals(r4)
            if (r4 == 0) goto L_0x078a
            goto L_0x078b
        L_0x04c7:
            java.lang.String r3 = "cv3"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = r12
            goto L_0x078b
        L_0x04d2:
            java.lang.String r3 = "cv1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = r15
            goto L_0x078b
        L_0x04dd:
            java.lang.String r3 = "Z80"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 139(0x8b, float:1.95E-43)
            goto L_0x078b
        L_0x04e9:
            java.lang.String r3 = "QX1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 115(0x73, float:1.61E-43)
            goto L_0x078b
        L_0x04f5:
            java.lang.String r3 = "PLE"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 107(0x6b, float:1.5E-43)
            goto L_0x078b
        L_0x0501:
            java.lang.String r3 = "P85"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 94
            goto L_0x078b
        L_0x050d:
            java.lang.String r3 = "MX6"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 86
            goto L_0x078b
        L_0x0519:
            java.lang.String r3 = "M5c"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 80
            goto L_0x078b
        L_0x0525:
            java.lang.String r3 = "M04"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 79
            goto L_0x078b
        L_0x0531:
            java.lang.String r3 = "JGZ"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 73
            goto L_0x078b
        L_0x053d:
            java.lang.String r3 = "mh"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 84
            goto L_0x078b
        L_0x0549:
            java.lang.String r3 = "b5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 16
            goto L_0x078b
        L_0x0555:
            java.lang.String r3 = "V5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 129(0x81, float:1.81E-43)
            goto L_0x078b
        L_0x0561:
            java.lang.String r3 = "V1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 127(0x7f, float:1.78E-43)
            goto L_0x078b
        L_0x056d:
            java.lang.String r3 = "Q5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 113(0x71, float:1.58E-43)
            goto L_0x078b
        L_0x0579:
            java.lang.String r3 = "C1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 20
            goto L_0x078b
        L_0x0585:
            java.lang.String r3 = "woods_fn"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 134(0x86, float:1.88E-43)
            goto L_0x078b
        L_0x0591:
            java.lang.String r3 = "ELUGA_A3_Pro"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 31
            goto L_0x078b
        L_0x059d:
            java.lang.String r3 = "Z12_PRO"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 138(0x8a, float:1.93E-43)
            goto L_0x078b
        L_0x05a9:
            java.lang.String r3 = "BLACK-1X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 17
            goto L_0x078b
        L_0x05b5:
            java.lang.String r3 = "taido_row"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 121(0x79, float:1.7E-43)
            goto L_0x078b
        L_0x05c1:
            java.lang.String r3 = "Pixi4-7_3G"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 105(0x69, float:1.47E-43)
            goto L_0x078b
        L_0x05cd:
            java.lang.String r3 = "GIONEE_GBL7360"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 53
            goto L_0x078b
        L_0x05d9:
            java.lang.String r3 = "GiONEE_CBL7513"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 51
            goto L_0x078b
        L_0x05e5:
            java.lang.String r3 = "OnePlus5T"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 91
            goto L_0x078b
        L_0x05f1:
            java.lang.String r3 = "whyred"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 132(0x84, float:1.85E-43)
            goto L_0x078b
        L_0x05fd:
            java.lang.String r3 = "watson"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 131(0x83, float:1.84E-43)
            goto L_0x078b
        L_0x0609:
            java.lang.String r3 = "SVP-DTV15"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 119(0x77, float:1.67E-43)
            goto L_0x078b
        L_0x0615:
            java.lang.String r3 = "A7000-a"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 9
            goto L_0x078b
        L_0x0621:
            java.lang.String r3 = "nicklaus_f"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 88
            goto L_0x078b
        L_0x062d:
            java.lang.String r3 = "tcl_eu"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 126(0x7e, float:1.77E-43)
            goto L_0x078b
        L_0x0639:
            java.lang.String r3 = "ELUGA_Ray_X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 34
            goto L_0x078b
        L_0x0645:
            java.lang.String r3 = "s905x018"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 120(0x78, float:1.68E-43)
            goto L_0x078b
        L_0x0651:
            java.lang.String r3 = "A10-70L"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = r5
            goto L_0x078b
        L_0x065c:
            java.lang.String r3 = "A10-70F"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = r4
            goto L_0x078b
        L_0x0667:
            java.lang.String r3 = "namath"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 87
            goto L_0x078b
        L_0x0673:
            java.lang.String r3 = "Slate_Pro"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 118(0x76, float:1.65E-43)
            goto L_0x078b
        L_0x067f:
            java.lang.String r3 = "iris60"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 70
            goto L_0x078b
        L_0x068b:
            java.lang.String r3 = "BRAVIA_ATV2"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 18
            goto L_0x078b
        L_0x0697:
            java.lang.String r3 = "GiONEE_GBL7319"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 52
            goto L_0x078b
        L_0x06a3:
            java.lang.String r3 = "panell_dt"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 99
            goto L_0x078b
        L_0x06af:
            java.lang.String r3 = "panell_ds"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 98
            goto L_0x078b
        L_0x06bb:
            java.lang.String r3 = "panell_dl"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 97
            goto L_0x078b
        L_0x06c7:
            java.lang.String r3 = "vernee_M5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 130(0x82, float:1.82E-43)
            goto L_0x078b
        L_0x06d3:
            java.lang.String r3 = "pacificrim"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 95
            goto L_0x078b
        L_0x06df:
            java.lang.String r3 = "Phantom6"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 104(0x68, float:1.46E-43)
            goto L_0x078b
        L_0x06eb:
            java.lang.String r3 = "ComioS1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 21
            goto L_0x078b
        L_0x06f7:
            java.lang.String r3 = "XT1663"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 137(0x89, float:1.92E-43)
            goto L_0x078b
        L_0x0703:
            java.lang.String r3 = "RAIJIN"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 116(0x74, float:1.63E-43)
            goto L_0x078b
        L_0x070f:
            java.lang.String r3 = "AquaPowerM"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 13
            goto L_0x078b
        L_0x071b:
            java.lang.String r3 = "PGN611"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 103(0x67, float:1.44E-43)
            goto L_0x078b
        L_0x0727:
            java.lang.String r3 = "PGN610"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 102(0x66, float:1.43E-43)
            goto L_0x078b
        L_0x0732:
            java.lang.String r3 = "PGN528"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x078b
        L_0x073d:
            java.lang.String r3 = "NX573J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 90
            goto L_0x078b
        L_0x0748:
            java.lang.String r3 = "NX541J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 89
            goto L_0x078b
        L_0x0753:
            java.lang.String r3 = "CP8676_I02"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 22
            goto L_0x078b
        L_0x075e:
            java.lang.String r3 = "K50a40"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 74
            goto L_0x078b
        L_0x0769:
            java.lang.String r3 = "GIONEE_SWW1631"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 56
            goto L_0x078b
        L_0x0774:
            java.lang.String r3 = "GIONEE_SWW1627"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 55
            goto L_0x078b
        L_0x077f:
            java.lang.String r3 = "GIONEE_SWW1609"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x078a
            r3 = 54
            goto L_0x078b
        L_0x078a:
            r3 = r10
        L_0x078b:
            switch(r3) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                case 8: goto L_0x0080;
                case 9: goto L_0x0080;
                case 10: goto L_0x0080;
                case 11: goto L_0x0080;
                case 12: goto L_0x0080;
                case 13: goto L_0x0080;
                case 14: goto L_0x0080;
                case 15: goto L_0x0080;
                case 16: goto L_0x0080;
                case 17: goto L_0x0080;
                case 18: goto L_0x0080;
                case 19: goto L_0x0080;
                case 20: goto L_0x0080;
                case 21: goto L_0x0080;
                case 22: goto L_0x0080;
                case 23: goto L_0x0080;
                case 24: goto L_0x0080;
                case 25: goto L_0x0080;
                case 26: goto L_0x0080;
                case 27: goto L_0x0080;
                case 28: goto L_0x0080;
                case 29: goto L_0x0080;
                case 30: goto L_0x0080;
                case 31: goto L_0x0080;
                case 32: goto L_0x0080;
                case 33: goto L_0x0080;
                case 34: goto L_0x0080;
                case 35: goto L_0x0080;
                case 36: goto L_0x0080;
                case 37: goto L_0x0080;
                case 38: goto L_0x0080;
                case 39: goto L_0x0080;
                case 40: goto L_0x0080;
                case 41: goto L_0x0080;
                case 42: goto L_0x0080;
                case 43: goto L_0x0080;
                case 44: goto L_0x0080;
                case 45: goto L_0x0080;
                case 46: goto L_0x0080;
                case 47: goto L_0x0080;
                case 48: goto L_0x0080;
                case 49: goto L_0x0080;
                case 50: goto L_0x0080;
                case 51: goto L_0x0080;
                case 52: goto L_0x0080;
                case 53: goto L_0x0080;
                case 54: goto L_0x0080;
                case 55: goto L_0x0080;
                case 56: goto L_0x0080;
                case 57: goto L_0x0080;
                case 58: goto L_0x0080;
                case 59: goto L_0x0080;
                case 60: goto L_0x0080;
                case 61: goto L_0x0080;
                case 62: goto L_0x0080;
                case 63: goto L_0x0080;
                case 64: goto L_0x0080;
                case 65: goto L_0x0080;
                case 66: goto L_0x0080;
                case 67: goto L_0x0080;
                case 68: goto L_0x0080;
                case 69: goto L_0x0080;
                case 70: goto L_0x0080;
                case 71: goto L_0x0080;
                case 72: goto L_0x0080;
                case 73: goto L_0x0080;
                case 74: goto L_0x0080;
                case 75: goto L_0x0080;
                case 76: goto L_0x0080;
                case 77: goto L_0x0080;
                case 78: goto L_0x0080;
                case 79: goto L_0x0080;
                case 80: goto L_0x0080;
                case 81: goto L_0x0080;
                case 82: goto L_0x0080;
                case 83: goto L_0x0080;
                case 84: goto L_0x0080;
                case 85: goto L_0x0080;
                case 86: goto L_0x0080;
                case 87: goto L_0x0080;
                case 88: goto L_0x0080;
                case 89: goto L_0x0080;
                case 90: goto L_0x0080;
                case 91: goto L_0x0080;
                case 92: goto L_0x0080;
                case 93: goto L_0x0080;
                case 94: goto L_0x0080;
                case 95: goto L_0x0080;
                case 96: goto L_0x0080;
                case 97: goto L_0x0080;
                case 98: goto L_0x0080;
                case 99: goto L_0x0080;
                case 100: goto L_0x0080;
                case 101: goto L_0x0080;
                case 102: goto L_0x0080;
                case 103: goto L_0x0080;
                case 104: goto L_0x0080;
                case 105: goto L_0x0080;
                case 106: goto L_0x0080;
                case 107: goto L_0x0080;
                case 108: goto L_0x0080;
                case 109: goto L_0x0080;
                case 110: goto L_0x0080;
                case 111: goto L_0x0080;
                case 112: goto L_0x0080;
                case 113: goto L_0x0080;
                case 114: goto L_0x0080;
                case 115: goto L_0x0080;
                case 116: goto L_0x0080;
                case 117: goto L_0x0080;
                case 118: goto L_0x0080;
                case 119: goto L_0x0080;
                case 120: goto L_0x0080;
                case 121: goto L_0x0080;
                case 122: goto L_0x0080;
                case 123: goto L_0x0080;
                case 124: goto L_0x0080;
                case 125: goto L_0x0080;
                case 126: goto L_0x0080;
                case 127: goto L_0x0080;
                case 128: goto L_0x0080;
                case 129: goto L_0x0080;
                case 130: goto L_0x0080;
                case 131: goto L_0x0080;
                case 132: goto L_0x0080;
                case 133: goto L_0x0080;
                case 134: goto L_0x0080;
                case 135: goto L_0x0080;
                case 136: goto L_0x0080;
                case 137: goto L_0x0080;
                case 138: goto L_0x0080;
                case 139: goto L_0x0080;
                default: goto L_0x078e;
            }
        L_0x078e:
            int r3 = r0.hashCode()     // Catch:{ all -> 0x07aa }
            r4 = -594534941(0xffffffffdc901de3, float:-3.2452206E17)
            if (r3 == r4) goto L_0x0798
            goto L_0x07a2
        L_0x0798:
            java.lang.String r3 = "JSN-L21"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x07a2
            goto L_0x0080
        L_0x07a2:
            zzd = r1     // Catch:{ all -> 0x07aa }
            zzc = r11     // Catch:{ all -> 0x07aa }
        L_0x07a6:
            monitor-exit(r2)     // Catch:{ all -> 0x07aa }
            boolean r0 = zzd
            return r0
        L_0x07aa:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x07aa }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaai.zzaU(java.lang.String):boolean");
    }

    protected static final boolean zzaV(zzsq zzsq) {
        return zzen.zza >= 35 && zzsq.zzh;
    }

    private final Surface zzaW(zzsq zzsq) {
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            return zzabl.zzd();
        }
        Surface surface = this.zzq;
        if (surface != null) {
            return surface;
        }
        if (zzaV(zzsq)) {
            return null;
        }
        zzdb.zzf(zzbc(zzsq));
        zzaal zzaal = this.zzr;
        if (!(zzaal == null || zzaal.zza == zzsq.zzf)) {
            zzba();
        }
        if (this.zzr == null) {
            this.zzr = zzaal.zza(this.zze, zzsq.zzf);
        }
        return this.zzr;
    }

    private static List zzaX(Context context, zzta zzta, zzad zzad, boolean z, boolean z2) throws zztf {
        if (zzad.zzo == null) {
            return zzfzo.zzn();
        }
        if (zzen.zza >= 26 && "video/dolby-vision".equals(zzad.zzo) && !zzaag.zza(context)) {
            List zzc2 = zztl.zzc(zzta, zzad, z, z2);
            if (!zzc2.isEmpty()) {
                return zzc2;
            }
        }
        return zztl.zze(zzta, zzad, z, z2);
    }

    private final void zzaY() {
        zzci zzci = this.zzE;
        if (zzci != null) {
            this.zzg.zzt(zzci);
        }
    }

    /* access modifiers changed from: private */
    @RequiresNonNull({"displaySurface"})
    public final void zzaZ() {
        this.zzg.zzq(this.zzq);
        this.zzt = true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007a, code lost:
        if (r3.equals("video/av01") != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d5, code lost:
        return ((r0 * r1) * 3) / r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0029, code lost:
        r11 = ((java.lang.Integer) r11.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzad(com.google.android.gms.internal.ads.zzsq r10, com.google.android.gms.internal.ads.zzad r11) {
        /*
            int r0 = r11.zzu
            int r1 = r11.zzv
            r2 = -1
            if (r0 == r2) goto L_0x00d6
            if (r1 != r2) goto L_0x000b
            goto L_0x00d6
        L_0x000b:
            java.lang.String r3 = r11.zzo
            r3.getClass()
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            r5 = 2
            r6 = 1
            java.lang.String r7 = "video/avc"
            java.lang.String r8 = "video/hevc"
            if (r4 == 0) goto L_0x003c
            int r3 = com.google.android.gms.internal.ads.zztl.zza
            android.util.Pair r11 = com.google.android.gms.internal.ads.zzdd.zza(r11)
            if (r11 == 0) goto L_0x003b
            java.lang.Object r11 = r11.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r11 == r3) goto L_0x0039
            if (r11 == r6) goto L_0x0039
            if (r11 != r5) goto L_0x003b
        L_0x0039:
            r3 = r7
            goto L_0x003c
        L_0x003b:
            r3 = r8
        L_0x003c:
            int r11 = r3.hashCode()
            r4 = 3
            r9 = 4
            switch(r11) {
                case -1664118616: goto L_0x007d;
                case -1662735862: goto L_0x0074;
                case -1662541442: goto L_0x006c;
                case 1187890754: goto L_0x0062;
                case 1331836730: goto L_0x005a;
                case 1599127256: goto L_0x0050;
                case 1599127257: goto L_0x0046;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x0087
        L_0x0046:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0087
            r5 = 6
            goto L_0x0088
        L_0x0050:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0087
            r5 = r4
            goto L_0x0088
        L_0x005a:
            boolean r11 = r3.equals(r7)
            if (r11 == 0) goto L_0x0087
            r5 = 5
            goto L_0x0088
        L_0x0062:
            java.lang.String r11 = "video/mp4v-es"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0087
            r5 = r6
            goto L_0x0088
        L_0x006c:
            boolean r11 = r3.equals(r8)
            if (r11 == 0) goto L_0x0087
            r5 = r9
            goto L_0x0088
        L_0x0074:
            java.lang.String r11 = "video/av01"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0087
            goto L_0x0088
        L_0x007d:
            java.lang.String r11 = "video/3gpp"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0087
            r5 = 0
            goto L_0x0088
        L_0x0087:
            r5 = r2
        L_0x0088:
            switch(r5) {
                case 0: goto L_0x00d2;
                case 1: goto L_0x00d2;
                case 2: goto L_0x00d2;
                case 3: goto L_0x00d2;
                case 4: goto L_0x00c8;
                case 5: goto L_0x008f;
                case 6: goto L_0x008c;
                default: goto L_0x008b;
            }
        L_0x008b:
            goto L_0x00d6
        L_0x008c:
            r9 = 8
            goto L_0x00d2
        L_0x008f:
            java.lang.String r11 = "BRAVIA 4K 2015"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzen.zzd
            boolean r11 = r11.equals(r3)
            if (r11 != 0) goto L_0x00d6
            java.lang.String r11 = "Amazon"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzen.zzc
            boolean r11 = r11.equals(r3)
            if (r11 == 0) goto L_0x00bb
            java.lang.String r11 = "KFSOWI"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzen.zzd
            boolean r11 = r11.equals(r3)
            if (r11 != 0) goto L_0x00d6
            java.lang.String r11 = "AFTS"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzen.zzd
            boolean r11 = r11.equals(r3)
            if (r11 == 0) goto L_0x00bb
            boolean r10 = r10.zzf
            if (r10 != 0) goto L_0x00d6
        L_0x00bb:
            int r0 = r0 + 15
            int r1 = r1 + 15
            int r0 = r0 / 16
            int r1 = r1 / 16
            int r0 = r0 * r1
            int r0 = r0 * 768
            int r0 = r0 / r9
            return r0
        L_0x00c8:
            int r0 = r0 * r1
            int r0 = r0 * r4
            int r0 = r0 / r9
            r10 = 2097152(0x200000, float:2.938736E-39)
            int r10 = java.lang.Math.max(r10, r0)
            return r10
        L_0x00d2:
            int r0 = r0 * r1
            int r0 = r0 * r4
            int r0 = r0 / r9
            return r0
        L_0x00d6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaai.zzad(com.google.android.gms.internal.ads.zzsq, com.google.android.gms.internal.ads.zzad):int");
    }

    protected static int zzae(zzsq zzsq, zzad zzad) {
        if (zzad.zzp == -1) {
            return zzad(zzsq, zzad);
        }
        int size = zzad.zzr.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((byte[]) zzad.zzr.get(i2)).length;
        }
        return zzad.zzp + i;
    }

    private final void zzba() {
        zzaal zzaal = this.zzr;
        if (zzaal != null) {
            zzaal.release();
            this.zzr = null;
        }
    }

    private final boolean zzbb(zzsq zzsq) {
        return this.zzq != null || zzaV(zzsq) || zzbc(zzsq);
    }

    private final boolean zzbc(zzsq zzsq) {
        if (zzen.zza < 23 || zzaU(zzsq.zza)) {
            return false;
        }
        if (!zzsq.zzf || zzaal.zzb(this.zze)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void zzA() {
        zzabl zzabl = this.zzn;
        if (zzabl != null && this.zzf) {
            zzabl.zzo();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzC() {
        try {
            super.zzC();
        } finally {
            this.zzo = false;
            this.zzI = -9223372036854775807L;
            zzba();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzD() {
        this.zzx = 0;
        this.zzw = zzi().zzb();
        this.zzA = 0;
        this.zzB = 0;
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            zzabl.zzm();
        } else {
            this.zzi.zzg();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzE() {
        if (this.zzx > 0) {
            long zzb2 = zzi().zzb();
            this.zzg.zzd(this.zzx, zzb2 - this.zzw);
            this.zzx = 0;
            this.zzw = zzb2;
        }
        int i = this.zzB;
        if (i != 0) {
            this.zzg.zzr(this.zzA, i);
            this.zzA = 0;
            this.zzB = 0;
        }
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            zzabl.zzn();
        } else {
            this.zzi.zzh();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzF(zzad[] zzadArr, long j, long j2, zzur zzur) throws zzig {
        super.zzF(zzadArr, j, j2, zzur);
        if (this.zzI == -9223372036854775807L) {
            this.zzI = j;
        }
        zzbv zzh2 = zzh();
        if (zzh2.zzo()) {
            this.zzJ = -9223372036854775807L;
            return;
        }
        zzur zzur2 = zzur;
        this.zzJ = zzh2.zzn(zzur.zza, new zzbt()).zzd;
    }

    public final void zzM(float f, float f2) throws zzig {
        super.zzM(f, f2);
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            zzabl.zzt(f);
        } else {
            this.zzi.zzn(f);
        }
    }

    public final String zzU() {
        return "MediaCodecVideoRenderer";
    }

    public final void zzV(long j, long j2) throws zzig {
        super.zzV(j, j2);
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            try {
                zzabl.zzp(j, j2);
            } catch (zzabk e) {
                throw zzcY(e, e.zza, false, 7001);
            }
        }
    }

    public final boolean zzW() {
        return super.zzW() && this.zzn == null;
    }

    public final boolean zzX() {
        boolean zzX = super.zzX();
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            return zzabl.zzy(zzX);
        }
        if (!zzX || (zzaz() != null && this.zzq != null)) {
            return this.zzi.zzo(zzX);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final float zzZ(float f, zzad zzad, zzad[] zzadArr) {
        float f2 = -1.0f;
        for (zzad zzad2 : zzadArr) {
            float f3 = zzad2.zzw;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    /* access modifiers changed from: protected */
    public final zzsp zzaA(Throwable th, zzsq zzsq) {
        return new zzaad(th, zzsq, this.zzq);
    }

    /* access modifiers changed from: protected */
    public final void zzaD(long j) {
        super.zzaD(j);
        this.zzz--;
    }

    /* access modifiers changed from: protected */
    public final void zzaE(zzhm zzhm) throws zzig {
        this.zzz++;
        int i = zzen.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzaF(zzad zzad) throws zzig {
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            try {
                zzabl.zzh(zzad);
            } catch (zzabk e) {
                throw zzcY(e, zzad, false, 7000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzaH() {
        super.zzaH();
        this.zzz = 0;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaN(zzsq zzsq) {
        return zzbb(zzsq);
    }

    /* access modifiers changed from: protected */
    public final boolean zzaO(zzhm zzhm) {
        if (zzhm.zzi() && !zzQ() && !zzhm.zzh() && this.zzJ != -9223372036854775807L) {
            return this.zzJ - (zzhm.zze - zzav()) > 100000 && !zzhm.zzl() && zzhm.zze < zzf();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzaQ(zzsn zzsn, int i, long j) {
        Trace.beginSection("skipVideoBuffer");
        zzsn.zzo(i, false);
        Trace.endSection();
        this.zza.zzf++;
    }

    /* access modifiers changed from: protected */
    public final void zzaR(int i, int i2) {
        zzhx zzhx = this.zza;
        zzhx.zzh += i;
        int i3 = i + i2;
        zzhx.zzg += i3;
        this.zzx += i3;
        int i4 = this.zzy + i3;
        this.zzy = i4;
        zzhx.zzi = Math.max(i4, zzhx.zzi);
    }

    /* access modifiers changed from: protected */
    public final void zzaS(long j) {
        zzhx zzhx = this.zza;
        zzhx.zzk += j;
        zzhx.zzl++;
        this.zzA += j;
        this.zzB++;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaT(long j, boolean z) throws zzig {
        int zzd2 = zzd(j);
        if (zzd2 == 0) {
            return false;
        }
        if (z) {
            zzhx zzhx = this.zza;
            zzhx.zzd += zzd2;
            zzhx.zzf += this.zzz;
        } else {
            this.zza.zzj++;
            zzaR(zzd2, this.zzz);
        }
        zzaJ();
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            zzabl.zzg(false);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final int zzaa(zzta zzta, zzad zzad) throws zztf {
        boolean z;
        int i = 128;
        if (!zzbg.zzi(zzad.zzo)) {
            return 128;
        }
        int i2 = 1;
        int i3 = 0;
        boolean z2 = zzad.zzs != null;
        List zzaX = zzaX(this.zze, zzta, zzad, z2, false);
        if (z2 && zzaX.isEmpty()) {
            zzaX = zzaX(this.zze, zzta, zzad, false, false);
        }
        if (!zzaX.isEmpty()) {
            if (!zzaP(zzad)) {
                i2 = 2;
            } else {
                zzsq zzsq = (zzsq) zzaX.get(0);
                boolean zze2 = zzsq.zze(zzad);
                if (!zze2) {
                    int i4 = 1;
                    while (true) {
                        if (i4 >= zzaX.size()) {
                            break;
                        }
                        zzsq zzsq2 = (zzsq) zzaX.get(i4);
                        if (zzsq2.zze(zzad)) {
                            zze2 = true;
                            z = false;
                            zzsq = zzsq2;
                            break;
                        }
                        i4++;
                    }
                }
                z = true;
                int i5 = true != zze2 ? 3 : 4;
                int i6 = true != zzsq.zzf(zzad) ? 8 : 16;
                int i7 = true != zzsq.zzg ? 0 : 64;
                if (true != z) {
                    i = 0;
                }
                if (zzen.zza >= 26 && "video/dolby-vision".equals(zzad.zzo) && !zzaag.zza(this.zze)) {
                    i = 256;
                }
                if (zze2) {
                    List zzaX2 = zzaX(this.zze, zzta, zzad, z2, true);
                    if (!zzaX2.isEmpty()) {
                        zzsq zzsq3 = (zzsq) zztl.zzf(zzaX2, zzad).get(0);
                        if (zzsq3.zze(zzad) && zzsq3.zzf(zzad)) {
                            i3 = 32;
                        }
                    }
                }
                return i5 | i6 | i3 | i7 | i;
            }
        }
        return i2 | 128;
    }

    /* access modifiers changed from: protected */
    public final zzhy zzab(zzsq zzsq, zzad zzad, zzad zzad2) {
        int i;
        int i2;
        zzhy zzb2 = zzsq.zzb(zzad, zzad2);
        int i3 = zzb2.zze;
        zzaah zzaah = this.zzk;
        zzaah.getClass();
        zzaah zzaah2 = zzaah;
        if (zzad2.zzu > zzaah.zza || zzad2.zzv > zzaah.zzb) {
            i3 |= 256;
        }
        if (zzae(zzsq, zzad2) > zzaah.zzc) {
            i3 |= 64;
        }
        String str = zzsq.zza;
        if (i3 != 0) {
            i2 = 0;
            i = i3;
        } else {
            i = 0;
            i2 = zzb2.zzd;
        }
        return new zzhy(str, zzad, zzad2, i2, i);
    }

    /* access modifiers changed from: protected */
    public final zzhy zzac(zzkj zzkj) throws zzig {
        zzhy zzac = super.zzac(zzkj);
        zzad zzad = zzkj.zza;
        zzad.getClass();
        zzad zzad2 = zzad;
        this.zzg.zzf(zzad, zzac);
        return zzac;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e9, code lost:
        r4 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzsk zzaf(com.google.android.gms.internal.ads.zzsq r20, com.google.android.gms.internal.ads.zzad r21, android.media.MediaCrypto r22, float r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r23
            com.google.android.gms.internal.ads.zzad[] r4 = r0.zzT()
            int r5 = r4.length
            int r6 = zzae(r20, r21)
            int r7 = r2.zzu
            int r8 = r2.zzv
            r10 = -1
            r12 = 1
            if (r5 != r12) goto L_0x002c
            if (r6 == r10) goto L_0x0125
            int r4 = zzad(r20, r21)
            if (r4 == r10) goto L_0x0125
            float r5 = (float) r6
            r6 = 1069547520(0x3fc00000, float:1.5)
            float r5 = r5 * r6
            int r5 = (int) r5
            int r6 = java.lang.Math.min(r5, r4)
            goto L_0x0125
        L_0x002c:
            r13 = 0
            r14 = 0
        L_0x002e:
            if (r13 >= r5) goto L_0x0071
            r15 = r4[r13]
            com.google.android.gms.internal.ads.zzm r9 = r2.zzB
            if (r9 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzm r9 = r15.zzB
            if (r9 != 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzab r9 = r15.zzb()
            com.google.android.gms.internal.ads.zzm r15 = r2.zzB
            r9.zzB(r15)
            com.google.android.gms.internal.ads.zzad r15 = r9.zzaf()
        L_0x0047:
            com.google.android.gms.internal.ads.zzhy r9 = r1.zzb(r2, r15)
            int r9 = r9.zzd
            if (r9 == 0) goto L_0x006e
            int r9 = r15.zzu
            if (r9 == r10) goto L_0x005a
            int r11 = r15.zzv
            if (r11 != r10) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r11 = 0
            goto L_0x005b
        L_0x005a:
            r11 = r12
        L_0x005b:
            r14 = r14 | r11
            int r7 = java.lang.Math.max(r7, r9)
            int r9 = r15.zzv
            int r8 = java.lang.Math.max(r8, r9)
            int r9 = zzae(r1, r15)
            int r6 = java.lang.Math.max(r6, r9)
        L_0x006e:
            int r13 = r13 + 1
            goto L_0x002e
        L_0x0071:
            if (r14 == 0) goto L_0x0125
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Resolutions unknown. Codec max resolution: "
            r4.<init>(r5)
            r4.append(r7)
            java.lang.String r5 = "x"
            r4.append(r5)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            java.lang.String r9 = "MediaCodecVideoRenderer"
            com.google.android.gms.internal.ads.zzdt.zzf(r9, r4)
            int r4 = r2.zzv
            int r10 = r2.zzu
            if (r4 <= r10) goto L_0x0096
            r11 = r12
            goto L_0x0097
        L_0x0096:
            r11 = 0
        L_0x0097:
            if (r11 == 0) goto L_0x009b
            r13 = r4
            goto L_0x009c
        L_0x009b:
            r13 = r10
        L_0x009c:
            if (r12 != r11) goto L_0x009f
            r4 = r10
        L_0x009f:
            int[] r10 = zzb
            r14 = 0
        L_0x00a2:
            r15 = 9
            if (r14 >= r15) goto L_0x00e9
            float r15 = (float) r4
            float r12 = (float) r13
            r16 = r10
            r10 = r16[r14]
            r17 = r12
            float r12 = (float) r10
            if (r10 <= r13) goto L_0x00e9
            float r15 = r15 / r17
            float r12 = r12 * r15
            int r12 = (int) r12
            if (r12 > r4) goto L_0x00b8
            goto L_0x00e9
        L_0x00b8:
            r15 = 1
            if (r15 == r11) goto L_0x00bf
            r17 = r4
            r4 = r10
            goto L_0x00c2
        L_0x00bf:
            r17 = r4
            r4 = r12
        L_0x00c2:
            if (r15 != r11) goto L_0x00c5
            goto L_0x00c6
        L_0x00c5:
            r10 = r12
        L_0x00c6:
            android.graphics.Point r4 = r1.zza(r4, r10)
            float r10 = r2.zzw
            if (r4 == 0) goto L_0x00dd
            r12 = r11
            double r10 = (double) r10
            int r15 = r4.x
            r18 = r12
            int r12 = r4.y
            boolean r10 = r1.zzg(r15, r12, r10)
            if (r10 == 0) goto L_0x00df
            goto L_0x00ea
        L_0x00dd:
            r18 = r11
        L_0x00df:
            int r14 = r14 + 1
            r10 = r16
            r4 = r17
            r11 = r18
            r12 = 1
            goto L_0x00a2
        L_0x00e9:
            r4 = 0
        L_0x00ea:
            if (r4 == 0) goto L_0x0125
            int r10 = r4.x
            int r7 = java.lang.Math.max(r7, r10)
            int r4 = r4.y
            int r8 = java.lang.Math.max(r8, r4)
            com.google.android.gms.internal.ads.zzab r4 = r2.zzb()
            r4.zzae(r7)
            r4.zzJ(r8)
            com.google.android.gms.internal.ads.zzad r4 = r4.zzaf()
            int r4 = zzad(r1, r4)
            int r6 = java.lang.Math.max(r6, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r10 = "Codec max resolution adjusted to: "
            r4.<init>(r10)
            r4.append(r7)
            r4.append(r5)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r9, r4)
        L_0x0125:
            java.lang.String r4 = r1.zzc
            com.google.android.gms.internal.ads.zzaah r5 = new com.google.android.gms.internal.ads.zzaah
            r5.<init>(r7, r8, r6)
            r0.zzk = r5
            boolean r6 = r0.zzh
            android.media.MediaFormat r7 = new android.media.MediaFormat
            r7.<init>()
            java.lang.String r8 = "mime"
            r7.setString(r8, r4)
            int r4 = r2.zzu
            java.lang.String r8 = "width"
            r7.setInteger(r8, r4)
            int r4 = r2.zzv
            java.lang.String r8 = "height"
            r7.setInteger(r8, r4)
            java.util.List r4 = r2.zzr
            com.google.android.gms.internal.ads.zzdw.zzb(r7, r4)
            float r4 = r2.zzw
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r9 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x015a
            java.lang.String r9 = "frame-rate"
            r7.setFloat(r9, r4)
        L_0x015a:
            int r4 = r2.zzx
            java.lang.String r9 = "rotation-degrees"
            com.google.android.gms.internal.ads.zzdw.zza(r7, r9, r4)
            com.google.android.gms.internal.ads.zzm r4 = r2.zzB
            if (r4 == 0) goto L_0x0187
            java.lang.String r9 = "color-transfer"
            int r10 = r4.zzd
            com.google.android.gms.internal.ads.zzdw.zza(r7, r9, r10)
            java.lang.String r9 = "color-standard"
            int r10 = r4.zzb
            com.google.android.gms.internal.ads.zzdw.zza(r7, r9, r10)
            java.lang.String r9 = "color-range"
            int r10 = r4.zzc
            com.google.android.gms.internal.ads.zzdw.zza(r7, r9, r10)
            byte[] r4 = r4.zze
            if (r4 == 0) goto L_0x0187
            java.lang.String r9 = "hdr-static-info"
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r4)
            r7.setByteBuffer(r9, r4)
        L_0x0187:
            java.lang.String r4 = r2.zzo
            java.lang.String r9 = "video/dolby-vision"
            boolean r4 = r9.equals(r4)
            if (r4 == 0) goto L_0x01a6
            int r4 = com.google.android.gms.internal.ads.zztl.zza
            android.util.Pair r4 = com.google.android.gms.internal.ads.zzdd.zza(r2)
            if (r4 == 0) goto L_0x01a6
            java.lang.Object r4 = r4.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.String r9 = "profile"
            com.google.android.gms.internal.ads.zzdw.zza(r7, r9, r4)
        L_0x01a6:
            int r4 = r5.zza
            java.lang.String r9 = "max-width"
            r7.setInteger(r9, r4)
            int r4 = r5.zzb
            java.lang.String r9 = "max-height"
            r7.setInteger(r9, r4)
            int r4 = r5.zzc
            java.lang.String r5 = "max-input-size"
            com.google.android.gms.internal.ads.zzdw.zza(r7, r5, r4)
            int r4 = com.google.android.gms.internal.ads.zzen.zza
            r5 = 23
            if (r4 < r5) goto L_0x01d0
            java.lang.String r4 = "priority"
            r5 = 0
            r7.setInteger(r4, r5)
            int r4 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x01d0
            java.lang.String r4 = "operating-rate"
            r7.setFloat(r4, r3)
        L_0x01d0:
            if (r6 == 0) goto L_0x01df
            java.lang.String r3 = "no-post-process"
            r15 = 1
            r7.setInteger(r3, r15)
            java.lang.String r3 = "auto-frc"
            r5 = 0
            r7.setInteger(r3, r5)
            goto L_0x01e0
        L_0x01df:
            r5 = 0
        L_0x01e0:
            int r3 = com.google.android.gms.internal.ads.zzen.zza
            r4 = 35
            if (r3 < r4) goto L_0x01f2
            int r3 = r0.zzF
            int r3 = -r3
            int r3 = java.lang.Math.max(r5, r3)
            java.lang.String r4 = "importance"
            r7.setInteger(r4, r3)
        L_0x01f2:
            android.view.Surface r3 = r19.zzaW(r20)
            com.google.android.gms.internal.ads.zzabl r4 = r0.zzn
            if (r4 == 0) goto L_0x0208
            android.content.Context r4 = r0.zze
            boolean r4 = com.google.android.gms.internal.ads.zzen.zzK(r4)
            if (r4 != 0) goto L_0x0208
            java.lang.String r4 = "allow-frame-drop"
            r5 = 0
            r7.setInteger(r4, r5)
        L_0x0208:
            r4 = 0
            com.google.android.gms.internal.ads.zzsk r1 = com.google.android.gms.internal.ads.zzsk.zzb(r1, r7, r2, r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaai.zzaf(com.google.android.gms.internal.ads.zzsq, com.google.android.gms.internal.ads.zzad, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzsk");
    }

    /* access modifiers changed from: protected */
    public final List zzag(zzta zzta, zzad zzad, boolean z) throws zztf {
        return zztl.zzf(zzaX(this.zze, zzta, zzad, false, false), zzad);
    }

    /* access modifiers changed from: protected */
    public final void zzaj(zzhm zzhm) throws zzig {
        if (this.zzm) {
            ByteBuffer byteBuffer = zzhm.zzf;
            byteBuffer.getClass();
            ByteBuffer byteBuffer2 = byteBuffer;
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b != -75 || s != 60 || s2 != 1 || b2 != 4) {
                    return;
                }
                if (b3 == 0 || b3 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    zzsn zzaz = zzaz();
                    zzaz.getClass();
                    zzsn zzsn = zzaz;
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    zzaz.zzq(bundle);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzak(Exception exc) {
        zzdt.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    /* access modifiers changed from: protected */
    public final void zzal(String str, zzsk zzsk, long j, long j2) {
        String str2 = str;
        this.zzg.zza(str2, j, j2);
        this.zzl = zzaU(str2);
        zzsq zzaB = zzaB();
        zzaB.getClass();
        zzsq zzsq = zzaB;
        boolean z = false;
        if (zzen.zza >= 29 && "video/x-vnd.on2.vp9".equals(zzaB.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] zzh2 = zzaB.zzh();
            int length = zzh2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (zzh2[i].profile == 16384) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        this.zzm = z;
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        this.zzg.zzb(str);
    }

    /* access modifiers changed from: protected */
    public final void zzan(zzad zzad, MediaFormat mediaFormat) {
        int i;
        int i2;
        zzsn zzaz = zzaz();
        if (zzaz != null) {
            zzaz.zzr(this.zzu);
        }
        mediaFormat.getClass();
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        float f = zzad.zzy;
        if (zzen.zza >= 30 && mediaFormat.containsKey("sar-width") && mediaFormat.containsKey("sar-height")) {
            f = ((float) mediaFormat.getInteger("sar-width")) / ((float) mediaFormat.getInteger("sar-height"));
        }
        int i3 = zzad.zzx;
        if (i3 == 90 || i3 == 270) {
            f = 1.0f / f;
            int i4 = i2;
            i2 = i;
            i = i4;
        }
        this.zzD = new zzci(i, i2, f);
        zzabl zzabl = this.zzn;
        if (zzabl == null || !this.zzK) {
            this.zzi.zzl(zzad.zzw);
        } else {
            zzab zzb2 = zzad.zzb();
            zzb2.zzae(i);
            zzb2.zzJ(i2);
            zzb2.zzV(f);
            zzabl.zzj(1, zzb2.zzaf());
        }
        this.zzK = false;
    }

    /* access modifiers changed from: protected */
    public final void zzao(zzsn zzsn, int i, long j, long j2) {
        Trace.beginSection("releaseOutputBuffer");
        zzsn.zzn(i, j2);
        Trace.endSection();
        this.zza.zze++;
        this.zzy = 0;
        if (this.zzn == null) {
            zzci zzci = this.zzD;
            if (!zzci.equals(zzci.zza) && !zzci.equals(this.zzE)) {
                this.zzE = zzci;
                this.zzg.zzt(zzci);
            }
            if (this.zzi.zzp() && this.zzq != null) {
                zzaZ();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzap() {
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            zzabl.zzu(zzaw(), zzav(), -this.zzI, zzf());
        } else {
            this.zzi.zzf();
        }
        this.zzK = true;
    }

    /* access modifiers changed from: protected */
    public final int zzau(zzhm zzhm) {
        int i = zzen.zza;
        return 0;
    }

    public final void zzt() {
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            zzabl.zzf();
        } else {
            this.zzi.zzb();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzx() {
        this.zzE = null;
        this.zzJ = -9223372036854775807L;
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            zzabl.zzk();
        } else {
            this.zzi.zzd();
        }
        this.zzt = false;
        try {
            super.zzx();
        } finally {
            this.zzg.zzc(this.zza);
            this.zzg.zzt(zzci.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzy(boolean z, boolean z2) throws zzig {
        super.zzy(z, z2);
        zzn();
        this.zzg.zze(this.zza);
        if (!this.zzo) {
            if (this.zzp != null && this.zzn == null) {
                zzzp zzzp = new zzzp(this.zze, this.zzi);
                zzzp.zzd(zzi());
                this.zzn = zzzp.zze().zzh();
            }
            this.zzo = true;
        }
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            zzabl.zzr(new zzaae(this), zzgey.zzb());
            zzaam zzaam = this.zzH;
            if (zzaam != null) {
                this.zzn.zzw(zzaam);
            }
            if (this.zzq != null && !this.zzs.equals(zzee.zza)) {
                this.zzn.zzs(this.zzq, this.zzs);
            }
            this.zzn.zzq(this.zzv);
            this.zzn.zzt(zzat());
            List list = this.zzp;
            if (list != null) {
                this.zzn.zzv(list);
            }
            this.zzn.zzl(z2);
            return;
        }
        this.zzi.zzk(zzi());
        this.zzi.zze(z2);
    }

    /* access modifiers changed from: protected */
    public final void zzz(long j, boolean z) throws zzig {
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            zzabl.zzg(true);
            this.zzn.zzu(zzaw(), zzav(), -this.zzI, zzf());
            this.zzK = true;
        }
        super.zzz(j, z);
        if (this.zzn == null) {
            this.zzi.zzi();
        }
        if (z) {
            zzabl zzabl2 = this.zzn;
            if (zzabl2 != null) {
                zzabl2.zzi(false);
            } else {
                this.zzi.zzc(false);
            }
        }
        this.zzy = 0;
    }

    /* access modifiers changed from: protected */
    public final boolean zzar(long j, long j2, zzsn zzsn, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzad zzad) throws zzig {
        zzsn.getClass();
        long zzav = j3 - zzav();
        zzabl zzabl = this.zzn;
        if (zzabl != null) {
            try {
                return zzabl.zzx(j3 + (-this.zzI), z2, j, j2, new zzaaf(this, zzsn, i, zzav));
            } catch (zzabk e) {
                throw zzcY(e, e.zza, false, 7001);
            }
        } else {
            zzsn zzsn2 = zzsn;
            int i4 = i;
            long j4 = zzav;
            long j5 = j;
            long j6 = j3;
            int zza = this.zzi.zza(j6, j5, j2, zzaw(), z2, this.zzj);
            if (zza == 4) {
                return false;
            }
            if (z && !z2) {
                zzaQ(zzsn2, i4, j4);
                return true;
            } else if (this.zzq == null) {
                if (this.zzj.zzc() >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    return false;
                }
                zzaQ(zzsn2, i4, j4);
                zzaS(this.zzj.zzc());
                return true;
            } else if (zza == 0) {
                zzao(zzsn, i, j4, zzi().zzc());
                zzaS(this.zzj.zzc());
                return true;
            } else if (zza == 1) {
                zzaan zzaan = this.zzj;
                zzsn zzsn3 = zzsn2;
                long zzd2 = zzaan.zzd();
                long zzc2 = zzaan.zzc();
                if (zzd2 == this.zzC) {
                    zzaQ(zzsn2, i4, j4);
                } else {
                    zzao(zzsn2, i4, j4, zzd2);
                }
                zzaS(zzc2);
                this.zzC = zzd2;
                return true;
            } else if (zza == 2) {
                Trace.beginSection("dropVideoBuffer");
                zzsn2.zzo(i4, false);
                Trace.endSection();
                zzaR(0, 1);
                zzaS(this.zzj.zzc());
                return true;
            } else if (zza == 3) {
                zzaQ(zzsn2, i4, j4);
                zzaS(this.zzj.zzc());
                return true;
            } else if (zza == 5) {
                return false;
            } else {
                throw new IllegalStateException(String.valueOf(zza));
            }
        }
    }

    public final void zzu(int i, Object obj) throws zzig {
        if (i == 1) {
            Surface surface = obj instanceof Surface ? (Surface) obj : null;
            if (this.zzq != surface) {
                this.zzq = surface;
                if (this.zzn == null) {
                    this.zzi.zzm(surface);
                }
                this.zzt = false;
                int zzcV = zzcV();
                zzsn zzaz = zzaz();
                if (zzaz != null && this.zzn == null) {
                    zzsq zzaB = zzaB();
                    zzaB.getClass();
                    zzsq zzsq = zzaB;
                    boolean zzbb = zzbb(zzaB);
                    if (zzen.zza < 23 || !zzbb || this.zzl) {
                        zzaG();
                        zzaC();
                    } else {
                        Surface zzaW = zzaW(zzaB);
                        if (zzen.zza >= 23 && zzaW != null) {
                            zzaz.zzp(zzaW);
                        } else if (zzen.zza >= 35) {
                            zzaz.zzi();
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                }
                if (surface != null) {
                    zzaY();
                    if (zzcV == 2) {
                        zzabl zzabl = this.zzn;
                        if (zzabl != null) {
                            zzabl.zzi(true);
                        } else {
                            this.zzi.zzc(true);
                        }
                    }
                } else {
                    this.zzE = null;
                    zzabl zzabl2 = this.zzn;
                    if (zzabl2 != null) {
                        zzabl2.zze();
                    }
                }
            } else if (surface != null) {
                zzaY();
                Surface surface2 = this.zzq;
                if (surface2 != null && this.zzt) {
                    this.zzg.zzq(surface2);
                }
            }
        } else if (i == 7) {
            obj.getClass();
            zzaam zzaam = (zzaam) obj;
            this.zzH = zzaam;
            zzabl zzabl3 = this.zzn;
            if (zzabl3 != null) {
                zzabl3.zzw(zzaam);
            }
        } else if (i == 10) {
            obj.getClass();
            int intValue = ((Integer) obj).intValue();
            if (this.zzG != intValue) {
                this.zzG = intValue;
            }
        } else if (i == 16) {
            obj.getClass();
            this.zzF = ((Integer) obj).intValue();
            zzsn zzaz2 = zzaz();
            if (zzaz2 != null && zzen.zza >= 35) {
                Bundle bundle = new Bundle();
                bundle.putInt("importance", Math.max(0, -this.zzF));
                zzaz2.zzq(bundle);
            }
        } else if (i == 4) {
            obj.getClass();
            int intValue2 = ((Integer) obj).intValue();
            this.zzu = intValue2;
            zzsn zzaz3 = zzaz();
            if (zzaz3 != null) {
                zzaz3.zzr(intValue2);
            }
        } else if (i == 5) {
            obj.getClass();
            int intValue3 = ((Integer) obj).intValue();
            this.zzv = intValue3;
            zzabl zzabl4 = this.zzn;
            if (zzabl4 != null) {
                zzabl4.zzq(intValue3);
            } else {
                this.zzi.zzj(intValue3);
            }
        } else if (i == 13) {
            obj.getClass();
            List list = (List) obj;
            this.zzp = list;
            zzabl zzabl5 = this.zzn;
            if (zzabl5 != null) {
                zzabl5.zzv(list);
            }
        } else if (i != 14) {
            super.zzu(i, obj);
        } else {
            obj.getClass();
            zzee zzee = (zzee) obj;
            if (zzee.zzb() != 0 && zzee.zza() != 0) {
                this.zzs = zzee;
                zzabl zzabl6 = this.zzn;
                if (zzabl6 != null) {
                    Surface surface3 = this.zzq;
                    zzdb.zzb(surface3);
                    Surface surface4 = surface3;
                    zzabl6.zzs(surface3, zzee);
                }
            }
        }
    }
}
