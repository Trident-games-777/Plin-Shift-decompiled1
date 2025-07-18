package androidx.interpolator.view.animation;

import androidx.compose.runtime.ComposerKt;

public class FastOutLinearInInterpolator extends LookupTableInterpolator {
    private static final float[] VALUES;

    public /* bridge */ /* synthetic */ float getInterpolation(float f) {
        return super.getInterpolation(f);
    }

    static {
        float[] fArr = new float[ComposerKt.providerKey];
        // fill-array-data instruction
        fArr[0] = 0;
        fArr[1] = 953267991;
        fArr[2] = 961656599;
        fArr[3] = 973279855;
        fArr[4] = 978433815;
        fArr[5] = 984245443;
        fArr[6] = 988540410;
        fArr[7] = 991775058;
        fArr[8] = 995211031;
        fArr[9] = 998445679;
        fArr[10] = 1000378414;
        fArr[11] = 1002525898;
        fArr[12] = 1004673381;
        fArr[13] = 1006941661;
        fArr[14] = 1008230151;
        fArr[15] = 1009626015;
        fArr[16] = 1011129254;
        fArr[17] = 1012739867;
        fArr[18] = 1014457854;
        fArr[19] = 1015598704;
        fArr[20] = 1016511385;
        fArr[21] = 1017424065;
        fArr[22] = 1018444120;
        fArr[23] = 1019464175;
        fArr[24] = 1020537917;
        fArr[25] = 1021611658;
        fArr[26] = 1022739087;
        fArr[27] = 1023665190;
        fArr[28] = 1024282591;
        fArr[29] = 1024899993;
        fArr[30] = 1025517394;
        fArr[31] = 1026188483;
        fArr[32] = 1026859572;
        fArr[33] = 1027530660;
        fArr[34] = 1028228592;
        fArr[35] = 1028953368;
        fArr[36] = 1029704987;
        fArr[37] = 1030429763;
        fArr[38] = 1031208226;
        fArr[39] = 1031892736;
        fArr[40] = 1032295390;
        fArr[41] = 1032698043;
        fArr[42] = 1033100696;
        fArr[43] = 1033530193;
        fArr[44] = 1033946268;
        fArr[45] = 1034375764;
        fArr[46] = 1034818683;
        fArr[47] = 1035275023;
        fArr[48] = 1035717942;
        fArr[49] = 1036187704;
        fArr[50] = 1036644044;
        fArr[51] = 1037113806;
        fArr[52] = 1037596990;
        fArr[53] = 1038080174;
        fArr[54] = 1038576779;
        fArr[55] = 1039073385;
        fArr[56] = 1039583412;
        fArr[57] = 1040093440;
        fArr[58] = 1040395429;
        fArr[59] = 1040657154;
        fArr[60] = 1040918879;
        fArr[61] = 1041187314;
        fArr[62] = 1041455750;
        fArr[63] = 1041730896;
        fArr[64] = 1042006042;
        fArr[65] = 1042281189;
        fArr[66] = 1042563046;
        fArr[67] = 1042851614;
        fArr[68] = 1043133471;
        fArr[69] = 1043422039;
        fArr[70] = 1043717318;
        fArr[71] = 1044012597;
        fArr[72] = 1044307876;
        fArr[73] = 1044609866;
        fArr[74] = 1044911856;
        fArr[75] = 1045213846;
        fArr[76] = 1045522547;
        fArr[77] = 1045831247;
        fArr[78] = 1046146659;
        fArr[79] = 1046455360;
        fArr[80] = 1046777482;
        fArr[81] = 1047092894;
        fArr[82] = 1047415017;
        fArr[83] = 1047743850;
        fArr[84] = 1048065973;
        fArr[85] = 1048394806;
        fArr[86] = 1048653175;
        fArr[87] = 1048817592;
        fArr[88] = 1048985364;
        fArr[89] = 1049156492;
        fArr[90] = 1049324264;
        fArr[91] = 1049495391;
        fArr[92] = 1049669874;
        fArr[93] = 1049841002;
        fArr[94] = 1050015485;
        fArr[95] = 1050193324;
        fArr[96] = 1050367807;
        fArr[97] = 1050545645;
        fArr[98] = 1050726839;
        fArr[99] = 1050904678;
        fArr[100] = 1051085872;
        fArr[101] = 1051267065;
        fArr[102] = 1051451615;
        fArr[103] = 1051636164;
        fArr[104] = 1051820714;
        fArr[105] = 1052005263;
        fArr[106] = 1052193168;
        fArr[107] = 1052381073;
        fArr[108] = 1052568977;
        fArr[109] = 1052760238;
        fArr[110] = 1052951498;
        fArr[111] = 1053142758;
        fArr[112] = 1053334018;
        fArr[113] = 1053528634;
        fArr[114] = 1053723250;
        fArr[115] = 1053917866;
        fArr[116] = 1054115837;
        fArr[117] = 1054313808;
        fArr[118] = 1054511779;
        fArr[119] = 1054713106;
        fArr[120] = 1054911077;
        fArr[121] = 1055112403;
        fArr[122] = 1055313730;
        fArr[123] = 1055518412;
        fArr[124] = 1055723094;
        fArr[125] = 1055927776;
        fArr[126] = 1056132458;
        fArr[127] = 1056340496;
        fArr[128] = 1056548533;
        fArr[129] = 1056756571;
        fArr[130] = 1056964608;
        fArr[131] = 1057070304;
        fArr[132] = 1057176001;
        fArr[133] = 1057281697;
        fArr[134] = 1057387394;
        fArr[135] = 1057494768;
        fArr[136] = 1057602142;
        fArr[137] = 1057709516;
        fArr[138] = 1057816891;
        fArr[139] = 1057925942;
        fArr[140] = 1058034994;
        fArr[141] = 1058144046;
        fArr[142] = 1058253098;
        fArr[143] = 1058363828;
        fArr[144] = 1058474557;
        fArr[145] = 1058585287;
        fArr[146] = 1058697694;
        fArr[147] = 1058808424;
        fArr[148] = 1058920831;
        fArr[149] = 1059033239;
        fArr[150] = 1059147324;
        fArr[151] = 1059261409;
        fArr[152] = 1059373816;
        fArr[153] = 1059489579;
        fArr[154] = 1059603664;
        fArr[155] = 1059719427;
        fArr[156] = 1059833512;
        fArr[157] = 1059950952;
        fArr[158] = 1060066715;
        fArr[159] = 1060184156;
        fArr[160] = 1060299919;
        fArr[161] = 1060419037;
        fArr[162] = 1060536477;
        fArr[163] = 1060653918;
        fArr[164] = 1060773036;
        fArr[165] = 1060892154;
        fArr[166] = 1061012950;
        fArr[167] = 1061132068;
        fArr[168] = 1061252864;
        fArr[169] = 1061373660;
        fArr[170] = 1061494456;
        fArr[171] = 1061616930;
        fArr[172] = 1061739404;
        fArr[173] = 1061861877;
        fArr[174] = 1061984351;
        fArr[175] = 1062108502;
        fArr[176] = 1062232654;
        fArr[177] = 1062356805;
        fArr[178] = 1062480957;
        fArr[179] = 1062606786;
        fArr[180] = 1062730937;
        fArr[181] = 1062858444;
        fArr[182] = 1062984273;
        fArr[183] = 1063111780;
        fArr[184] = 1063239287;
        fArr[185] = 1063366794;
        fArr[186] = 1063494300;
        fArr[187] = 1063623485;
        fArr[188] = 1063752670;
        fArr[189] = 1063883532;
        fArr[190] = 1064012716;
        fArr[191] = 1064145256;
        fArr[192] = 1064276119;
        fArr[193] = 1064408659;
        fArr[194] = 1064541199;
        fArr[195] = 1064673739;
        fArr[196] = 1064807956;
        fArr[197] = 1064942174;
        fArr[198] = 1065078070;
        fArr[199] = 1065215643;
        fArr[200] = 1065353216;
        VALUES = fArr;
    }

    public FastOutLinearInInterpolator() {
        super(VALUES);
    }
}
