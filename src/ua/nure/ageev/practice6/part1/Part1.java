package ua.nure.ageev.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.setIn(new ByteArrayInputStream("asd 43 asdf asd 43\n434 asdf kasdf asdf stop".getBytes("cp1251")));
		Scanner sc = new Scanner(System.in);
		WordContainer wl = new WordContainer();
		while(sc.hasNext()){
			String tmp = sc.next();
			if(tmp.equalsIgnoreCase("stop")){break;}
			wl.add(new Word(tmp));
		}
		for (Word w : wl) {
			System.out.println(w);
		}
	}
}
