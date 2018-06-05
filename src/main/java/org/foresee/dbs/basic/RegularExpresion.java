package org.foresee.dbs.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpresion {
	public static void main(String[] args) {
		String text="A horse is a horse, of course of course";
		String pattern="horse|course";
		Matcher matcher=Pattern.compile(pattern).matcher(text);
		while(matcher.find()){
			System.out.println("Matched: '"+matcher.group()+"' at position "+matcher.start()+" --- "+matcher.end());
		}
	}
}
