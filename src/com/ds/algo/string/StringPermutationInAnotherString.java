package com.ds.algo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/***
 * 
 * @author ASHWINI
 * Find all permutation of "abbc" in "cbabadcbbabbcbabaabccbabc",print start and end index for each permutation.
 *
 */
public class StringPermutationInAnotherString {

	public static void main(String[] args) {
		String s1 = "abbc";
		String s2 = "cbabadcbbabbcbabaabccbabcdasghcghasdgfhagsjfgsdgfuytw7ghjcgfAWE6UsdgxhcUIECJHXCKJaufuydausgcfhasdgdghaFSGDF6wedtaysfcgfsdyATWED6TAYSDGCHAfsdtARW6EDTaygdshgaFSDFadfghAFSDHGFahgsdfgAFDFasdfHATFgvXVVSDSDSDFDGHFAfhgsdhfghsdgfhghgfhgsdhfghsagdfhgsdfhgshdafghasdgfhgsdhgfsddgfajsdfriucvcacsagvaadscvscaccvaccavcav";
		List<int[][]> output = new ArrayList<int[][]>();

		if (s1.length() > s2.length())
			return;
		Map<Character,Integer> searchMap = getMap(s1);
		Map<Character,Integer> windowMap = getMap(s2.substring(0,s1.length()));
		int i=0,j=s1.length()-1;
			
		for(;j<s2.length() && (i + s1.length() -1 == j);){
			
			if(searchMap.equals(windowMap))
				output.add(new int[][]{{i,j}});
			
			char ch1 = s2.charAt(i);
			int ch1Count = windowMap.get(ch1);
			if(ch1Count == 1){
				windowMap.remove(ch1);
			}else {
				windowMap.put(ch1, ch1Count -1);
			}
			++i;
			++j;
			if(j>=s2.length())
				break;
			char ch2 = s2.charAt(j);
			
			Integer ch2Count = windowMap.get(ch2);
			ch2Count = ch2Count == null ? 1:ch2Count +1;
			windowMap.put(ch2, ch2Count);
		}
		
		output.forEach(x->System.out.println(Arrays.deepToString(x)));
		
	}

	private static Map<Character, Integer> getMap(String s1) {
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		IntStream.range(0, s1.length()).forEach(x -> {
			char ch = s1.charAt(x);
			Integer value = map1.get(ch);
			value = value == null ? 1 : value + 1;
			map1.put(ch, value);
 		});
		return map1;
	}
}
