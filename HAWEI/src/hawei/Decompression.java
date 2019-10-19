package hawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Decompression {
	public static void main(String[] args) {
		String input = "a11b2bac3bad3abcd2";
		
		char[] charArr = input.toCharArray();
		int start = 0, end = 0, freq;
		List<Entry> list = new ArrayList<>();
		while (end < charArr.length) {
			while (end < charArr.length && !Character.isDigit(charArr[end])) {
				end++;
			}
			String cur = new String(charArr, start, end - start);
			System.out.println("String is " + cur);
			freq = 0;
			while (end < charArr.length && Character.isDigit(charArr[end])) {
				freq = freq * 10 + charArr[end] - '0'; 
				end++;
			}
			start = end;
			System.out.println("Freq is " + freq);
			if (freq == 0) freq = 1;
			list.add(new Entry(cur, freq));
		}
		Collections.sort(list, new Comparator<Entry>() {
			@Override
			public int compare(Entry e1, Entry e2) {
				return e1.freq == e2.freq ? e1.str.compareToIgnoreCase(e2.str) : e1.freq.compareTo(e2.freq);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (Entry e : list) {
			for (int i = 0; i < e.freq; i++) {
				sb.append(e.str);
			}
		}
		String result = sb.toString();
		System.out.println(result);
	}
	
	static class Entry {
		String str;
		Integer freq;
		public Entry(String str, Integer freq) {
			this.str = str;
			this.freq = freq;
		}
	}
}
