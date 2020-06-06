/**
 * 
 */
package com.ds.algo.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ASHWINI Generate all permutations of ABC
 *
 */
public class StringPermutation {
	private static List<String> allPermutations(String str) {
		List<String> output = new ArrayList<String>();
		if(str != null){
		
			if(str.length() == 0){
				output.add("");
				return output;
			}
				
			if(str.length() ==1){
				output.add(str);
				return output;
			} 
			if(str.length()>1){
				char firstChar = str.charAt(0);
				String excludingFirstChar = str.substring(1);
				List<String> list = allPermutations(excludingFirstChar);
				list.forEach(x-> output.addAll(insert(x, firstChar)));
				return output;
			}
		}
		return output; 
	}
	
	private static List<String> insert(String str,char ch){
		List<String> output = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			sb.append(str.substring(0, i)).append(ch).append(str.substring(i));
			output.add(sb.toString());
			sb.delete(0, sb.length());
		}
		output.add(str+ch);
		return output;
	}

	public static void main(String[] args) {
		String str = "ab";
		System.out.println(allPermutations(str));

	}

}
