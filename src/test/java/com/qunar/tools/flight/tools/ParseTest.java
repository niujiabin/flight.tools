package com.qunar.tools.flight.tools;

/**
 * Created by jiabin.niu on 2019.02.27 10:46
 */
public class ParseTest {

    public static void main(String[] args) {

        String s = " yregukq0718\n" +
                "nmtm5328\n" +
                "flogtvt3034\n" +
                "hvjbclo4000\n" +
                "qmlawqt0410\n" +
                "btbu3654\n" +
                "ciwplzh5839\n" +
                "gezfddj5205\n" +
                "ruqnneu2804\n" +
                "xymmiwh1477\n" +
                "xusogaf6940";
        String a = s.replace("\n", ",").replace("  ","").replace(" ","");
        System.out.println(a);

    }
}
