package org.foresee.dbs.collect.reg;

public class LearnMatcher {
    public static void main(String[] args) {
//        String text="江流宛转绕芳甸<span style=\"color:#286345;\">(diàn)</span>，月照花林皆似霰<span style=\"color:#286345;\">(xiàn)</span>。";
//        Pattern pattern=Pattern.compile("<span");
        String text="滟()滟随波千万里，何处春江无月明！";
        String res=text.replaceAll("\\(.*?\\)", "");
        System.out.println(res);
    }
}
