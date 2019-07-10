package timu;

import java.util.ArrayList;
import java.util.List;


/*
 * LeetCode上的题目
 * */
public class TestLeetCode1 {
	public static void main(String[] args) {
		System.out.println(countAndSay(10));   //报数
		
		System.out.println(getRow(5));
	}
	
	/*
	 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
	 1.     1
	 2.     11
	 3.     21
	 4.     1211
	 5.     111221
		
	 1 被读作  "one 1"  ("一个一") , 即 11。
	 11 被读作 "two 1s" ("两个一"）, 即 21。
	 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
		
	 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
	 示例 1:
	 输入: 1
	 输出: "1"

	 示例 2:
	 输入: 4
	 输出: "1211"
	* */
	public static String countAndSay(int n) {
		String str = "1";
		for(int i = 2; i <= n; i++) {
			StringBuilder sBuilder = new StringBuilder();	
			char temp = str.charAt(0);
			int count = 1;
			for(int j = 1; j < str.length(); j++) {   //从temp值的后一位开始循环
				char c = str.charAt(j);
				if(c==temp) {
					count++;
				}else {
					sBuilder.append(count).append(temp);
					temp = c;
					count = 1;
				}
			}
			sBuilder.append(count).append(temp);
			str = sBuilder.toString();    //将StringBuilder类对象转换为String类对象
		}
		return str;
	}
	
	/*
	 * 二进制求和
	 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
	 输入为非空字符串且只包含数字 1 和 0。

     示例 1:
	 输入: a = "11", b = "1"
	 输出: "100"

	 示例 2:
	 输入: a = "1010", b = "1011"
	 输出: "10101"
	 * */
//	public static String addBinary(String a, String b) {    // 转换为十进制的做法容易溢出
//		int a1=0, b1=0; 
//		for(int i = 0; i < a.length(); i++) {
//			a1 += (a.charAt(i) - '0') * (int)Math.pow(2, (a.length() - 1 - i));
//		}
//		for(int i = 0; i < b.length(); i++) {
//			b1 += (b.charAt(i) - '0') * (int)Math.pow(2, (b.length() - 1 - i));
//		}
//		int c = a1 + b1;
//		String s = Integer.toBinaryString(c);
//		return s;
//	}
	public static String addBinary(String a, String b) {
		int n = a.length() - 1, m = b.length() - 1, carry = 0;
		StringBuilder sBuilder = new StringBuilder();
		while(n >=0 || m >= 0) {
			int temp1 = (n >=0? a.charAt(n--) - '0' : 0);
			int temp2 = (m >=0? b.charAt(m--) - '0' : 0);
			sBuilder.append((temp1 + temp2 + carry) % 2);
			carry = (temp1 + temp2 + carry) / 2;
		}
		return sBuilder.reverse().toString();
	}
	
	/*
	 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
	 * 示例 1:
	 * 输入: a = 1, b = 2
	 * 输出: 3
	 * 
	 * 示例 2:
	 * 输入: a = -2, b = 3
	 * 输出: 1
	 * */
	public static int getSum(int a , int b) {
		int sum, carry;
		if(a==0)
			return b;
		if(b==0)
			return a;
		
		carry = (a & b) << 1;     //进位
		sum = a ^ b;   //异或得到同位相加的结果
		if(carry!=0)
			return getSum(sum, carry);
		return sum;
	}
	
	/*
	 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
	 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
	 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
	 * 
	 * 示例 1：
	 * 输入：["h","e","l","l","o"]
	 * 输出：["o","l","l","e","h"]
	 * 
	 * 示例 2：
	 * 输入：["H","a","n","n","a","h"]
	 * 输出：["h","a","n","n","a","H"]
	 * */
	public static void reverseString(char[] s) {
		int i = 0;
		int j = s.length - 1;
		while (i < j) {
			swap(s, i++, j--);
		}
	}
	public static void swap(char[] s, int a, int b) {
		char temp = s[a];
		s[a] = s[b];
		s[b] = temp;
	}
	
	/*
	 * 编写一个函数来查找字符串数组中的最长公共前缀。
	 * 如果不存在公共前缀，返回空字符串 ""。
	 * 
	 * 示例 1:
	 * 输入: ["flower","flow","flight"]
	 * 输出: "fl"
	 * 
	 * 示例 2:
	 * 输入: ["dog","racecar","car"]
	 * 输出: ""
	 * 解释: 输入不存在公共前缀。
	 * 
	 * 说明:
	 * 所有输入只包含小写字母 a-z 。
	 * */
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++) {
			while(strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if(prefix.isEmpty()) return "";
			}
		}
		return prefix;
	}
	
	
	/*
	 * 生成杨辉三角, 两层集合
	 * */
	public static List<List<Integer>> generate(int numRows){
		List<List<Integer>> triangle = new ArrayList<>();
		if(numRows == 0) return triangle;
		
//		triangle.add(new ArrayList<>());
		List<Integer> first = new ArrayList<>();
        triangle.add(first);
		triangle.get(0).add(1);        //第一行总是1
		
		for(int i = 1; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prerow = triangle.get(i - 1);
			
			row.add(1);    //第一位永远是1
			for(int j = 1; j < i; j++) {
				row.add(prerow.get(j-1) + prerow.get(j));
			}
			row.add(1);    //最后一位永远为1
			triangle.add(row);
		}		
		return triangle;	
	}
	
	/*
	 * 得到杨辉三角的第n行， 例如输入3， 输出:[1, 3, 3, 1]
	 * */
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        long num = 1;
        for(int i = 0; i <= rowIndex; i++){
            row.add((int)num);
            num = num * (rowIndex - i) / (i + 1);
        }
        return row;
    }
}

