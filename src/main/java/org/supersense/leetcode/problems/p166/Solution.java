package problems.p166;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		if (num == 0) {
			return "0";
		}
		StringBuffer sb = new StringBuffer();
		if (((double)numerator / denominator) < 0) {
			sb.append("-");
		}
		long fac = num / den;
		sb.append(fac);
		num %= den;
		if (num != 0) {
			sb.append(".");
		}
		Map<String, Integer> hm = new HashMap<String, Integer>();
		hm.put(Long.toString(num), sb.length());
		while (num != 0) {
			num *= 10;
			fac = num / den;
				if (hm.containsKey(Long.toString(num))) {
					int idx = hm.get(Long.toString(num)).intValue();
					sb.insert(idx, "(");
					sb.append(")");
					return sb.toString();
				}else{
					hm.put(Long.toString(num), sb.length());
				}
			sb.append(fac);
			num %= den;
		}
		return sb.toString();
	}
}
