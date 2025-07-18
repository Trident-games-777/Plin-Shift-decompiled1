package com.google.android.material.color.utilities;

import java.util.HashMap;
import java.util.Map;

public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    public static TonalPalette fromInt(int i) {
        return fromHct(Hct.fromInt(i));
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double d, double d2) {
        return new TonalPalette(d, d2, createKeyColor(d, d2));
    }

    private TonalPalette(double d, double d2, Hct hct) {
        this.hue = d;
        this.chroma = d2;
        this.keyColor = hct;
    }

    private static Hct createKeyColor(double d, double d2) {
        Hct from = Hct.from(d, d2, 50.0d);
        double abs = Math.abs(from.getChroma() - d2);
        for (double d3 = 1.0d; d3 < 50.0d && Math.round(d2) != Math.round(from.getChroma()); d3 += 1.0d) {
            Hct from2 = Hct.from(d, d2, 50.0d + d3);
            double abs2 = Math.abs(from2.getChroma() - d2);
            if (abs2 < abs) {
                abs = abs2;
                from = from2;
            }
            Hct from3 = Hct.from(d, d2, 50.0d - d3);
            double abs3 = Math.abs(from3.getChroma() - d2);
            if (abs3 < abs) {
                abs = abs3;
                from = from3;
            }
        }
        return from;
    }

    public int tone(int i) {
        Integer num = this.cache.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(Hct.from(this.hue, this.chroma, (double) i).toInt());
            this.cache.put(Integer.valueOf(i), num);
        }
        return num.intValue();
    }

    public Hct getHct(double d) {
        return Hct.from(this.hue, this.chroma, d);
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }
}
