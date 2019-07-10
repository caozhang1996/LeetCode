package timu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * leetCode上的字符串相关题目
 * */   
public class TestLeetCode3 {
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 3, 5, 2, 4};
		int[] nums2 = new int[] {6, 5, 4, 3, 2, 1, 7};
		int[] ans = nextGreaterElement(nums1, nums2);
	}
	
	/*
	 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
	 * 
	 * 示例 1：
	 * 输入: "Hello"
	 * 输出: "hello"
	 * 
	 * 示例 2：
	 * 输入: "here"
	 * 输出: "here"
	 * 
	 * 示例 3：
	 * 输入: "LOVELY"
	 * 输出: "lovely"
	 * */
	public static String toLowerCase(String str) {
		char[] arr = str.toCharArray();   //先转换为字符数组
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= 65 && arr[i] <= 90) {   //是大写字母
				arr[i] = (char)(arr[i] + 32);
			}
		}
		return String.valueOf(arr);
	}
	
	/*
	 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
	 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
	 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
	 * "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
	 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。
	 * 例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
	 * 返回我们可以获得所有词不同单词翻译的数量。
	 * 
	 * 例如:
	 * 输入: words = ["gin", "zen", "gig", "msg"]
	 * 输出: 2
	 * 解释: 
	 * 各单词翻译如下:
	 * "gin" -> "--...-."
	 * "zen" -> "--...-."
	 * "gig" -> "--...--."
	 * "msg" -> "--...--."
	 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
	 * */
	 public int uniqueMorseRepresentations(String[] words) {
		 String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
				  "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		 Set<String> res = new HashSet<>();
		 
		 for(int i = 0; i < words.length; i++) {
			 String str = "";
			 for(int j = 0; j < words[i].toCharArray().length; j++) {
				 str +=morse[words[i].toCharArray()[j] - 'a'];
			 }
			 res.add(str);
		 }
		 return res.size();
	 }
	 
	 /*
	  * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
	  * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
	  * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
	  * 
	  * 示例 1:
	  * 输入: "UD"
	  * 输出: true
	  * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
	  * 
	  * 示例 2:
	  * 输入: "LL"
	  * 输出: false
	  * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
	  * */
	 public static boolean judgeCircle(String moves) {
		 int uNums = 0, dNums = 0, lNums = 0, rNums = 0;   //记录上下左右移动的数量
		 char[] chars = moves.toCharArray();
		 for(int i = 0; i < chars.length; i++) {
			 if(chars[i] == 'U')
				 uNums += 1;
			 else if (chars[i] == 'D')
				 dNums += 1;
			 else if (chars[i] == 'L')
				 lNums += 1;
			 else if (chars[i] == 'R')
				 rNums += 1;
		 }
		 if(uNums == dNums && lNums == rNums)
			 return true;
		 else
			 return false;
	}
	 /*
	  * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
	  * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
	  * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
	  * 
	  * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名
	  * 称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一
	  * 电子邮件地址。 （请注意，此规则不适用于域名。）
	  * 
	  * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 
	  * m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
	  * 
	  * 可以同时使用这两个规则。
	  * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
	  * 
	  * 示例：
	  * 输入：["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
	  * 输出：2
	  * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
	  * 
	  * 提示：																			
	  * 1 <= emails[i].length <= 100
	  * 1 <= emails.length <= 100
	  * 每封 emails[i] 都包含有且仅有一个 '@' 字符。
	  * */
	 public static int numUniqueEmails(String[] emails) {
		 Set<String> sets = new HashSet<>();
	        for (int i = 0; i < emails.length; i++) {
	            if (emails[i].indexOf("@") != -1){    //返回指定子字符串在此字符串中第一次出现处的索引。未找到的情况返回-1
	                String suffix = emails[i].substring(emails[i].indexOf("@"),emails[i].length());  //得到@****.com的后缀
	                if  ("com".equals(suffix.substring(suffix.length()-3,suffix.length()))){
	                    String prefix = emails[i].substring(0,emails[i].indexOf("@"));   //@前面的前缀
	                    //祛除 +号 祛除 「.」
	                    if (prefix.indexOf("+") != -1){
	                        prefix = prefix.substring(0,prefix.indexOf("+"));
	                    }
	                    while (prefix.indexOf(".") != -1){
	                    	prefix=prefix.substring(0,prefix.indexOf("."))+prefix.substring(prefix.indexOf(".")+1,prefix.length());
	                    	}
	                    String newUrl = prefix + suffix;
	                    sets.add(newUrl);
	                    }
	                } 
	            }
		 return sets.size();
	}
	 /*
	  * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
	  * 示例 1:
	  * 输入: "Let's take LeetCode contest"
	  * 输出: "s'teL ekat edoCteeL tsetnoc" 
	  * 
	  * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
	  * */
	 public static String reverseWords(String s) {
		//查看python版本
		return null;
	}
	 /*
	  * 给定一个单词，你需要判断单词的大写使用是否正确。
	  * 
	  * 我们定义，在以下情况时，单词的大写用法是正确的：
	  * 	全部字母都是大写，比如"USA"。
	  * 	单词中所有字母都不是大写，比如"leetcode"。
	  * 	如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
	  * 否则，我们定义这个单词没有正确使用大写字母。
	  * 
	  * 示例 1:
	  * 输入: "USA"
	  * 输出: True
	  * 
	  * 示例 2:
	  * 输入: "FlaG"
	  * 输出: False
	  * 
	  * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
	  * */
	 public static boolean detectCapitalUse(String word) {
		 boolean flag = false;
		 int A_count = 0, a_count = 0;
		 if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
			 for(int i = 1; i < word.length(); i++) {
				 if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
					 A_count++;
				 else
					 a_count++;
				 
			 }
		 }else {
			 for(int i = 1; i < word.length(); i++) {
				 if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
					 a_count++;
				 else
					 A_count++;
				 
			 }
			 if(A_count > a_count) {    //防止像‘mL’这种情况发生
				 return false; 
			 }
		 }
		 if (A_count == (word.length() - 1) || a_count == (word.length() - 1)) {
			flag = true;
		}
		return flag; 
	}
	 /*
	  * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
	  * 
	  * 示例 1：
	  * 输入："ab-cd"
	  * 输出："dc-ba"
	  * 
	  * 示例 2：
	  * 输入："a-bC-dEf-ghIj
	  * 输出："j-Ih-gfE-dCba"
	  * 
	  * 示例 3：
	  * 输入："Test1ng-Leet=code-Q!"
	  * 输出："Qedo1ct-eeLg=ntse-T!"
	  * 
	  * 提示：
	  * S.length <= 100
	  * 33 <= S[i].ASCIIcode <= 122 
	  * S 中不包含 \ or "
	  * */
	 public static String reverseOnlyLetters(String S) {
		 char[] chars = S.toCharArray();
		 List<Integer> char_index = new ArrayList<>();    //存放字母索引
		 for(int i = 0; i < S.length(); i++) {
			 if((S.charAt(i) >= 'A' && S.charAt(i)<= 'Z') || (S.charAt(i) >= 'a' && S.charAt(i)<= 'z'))
				 char_index.add(i);		
		 }
		 for(int i = 0, j = char_index.size() - 1; i < j; i++, j--) {
			 char temp = chars[char_index.get(i)];
			 chars[char_index.get(i)] = chars[char_index.get(j)];
			 chars[char_index.get(j)] = temp;
		 }
		 return String.valueOf(chars);
	}
	 /*
	  * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字
	  * 符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
	  * 
	  * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
	  * 
	  * 注意：
	  * 你可以假设两个字符串均只含有小写字母。
	  * 	canConstruct("a", "b") -> false
	  * 	canConstruct("aa", "ab") -> false
	  * 	canConstruct("aa", "aab") -> true
	  * 	canConstruct("txtd", "dttxgt") -> true
	  * */
	 public boolean canConstruct(String ransomNote, String magazine) {
		 int[] char_nums = new int[26];
		 for(int i = 0; i < magazine.length(); i++) {
			 char_nums[magazine.charAt(i) - 'a']++;
		 }
		 for(int i = 0; i < ransomNote.length(); i++) {
			 if(char_nums[ransomNote.charAt(i) - 'a'] == 0)
				 return false;
			 char_nums[ransomNote.charAt(i) - 'a']--;
		 } 
		 return true;
	 }
	 /*
	  * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
	  * 	'A' : Absent，缺勤
	  * 	'L' : Late，迟到
	  * 	'P' : Present，到场
	  * 
	  * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
	  * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
	  * 
	  * 示例 1:
	  * 输入: "PPALLP"
	  * 输出: True
	  * 
	  * 示例 2:
	  * 输入: "PPALLL"
	  * 输出: False
	  * */
	 public static boolean checkRecord(String s) {
		 int count = 0;
		 for(int i = 0; i < s.length(); i++) {
			 if(s.charAt(i) == 'A')
				 count++;
			 if(i < s.length() && s.charAt(i) == 'L') {
				 if(i+1 < s.length() && s.charAt(i+1) == 'L') {
					 if(i+2 < s.length() && s.charAt(i+2) == 'L')
						 return false;
				 }
			 }
		 }
		 if(count > 1)
			 return false;
		 return true;
	}
	 /*
	  * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
	  * 
	  * 示例 1:
	  * 输入: "hello"
	  * 输出: "holle"
	  * 
	  * 示例 2:
	  * 输入: "leetcode"
	  * 输出: "leotcede"
	  * 说明:
	  * 元音字母不包含字母"y"。
	  * */
	 public static String reverseVowels(String s) {
		 char[] chars = s.toCharArray();
		 List<Integer> index = new ArrayList<>();
		 for(int i = 0; i < chars.length; i++) {
			 if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
				 index.add(i);
			 }	
			 if(chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U') {
				 index.add(i);
			 }	 
		 }
		 for(int x = 0, y = index.size() - 1; x < y; x++, y--) {
			 char temp = chars[index.get(x)];
			 chars[index.get(x)] = chars[index.get(y)];
			 chars[index.get(y)] = temp;
		 }
		 return String.valueOf(chars);
	 }
	 
	 /*
	  * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少
	  * 于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
	  * 
	  * 示例:
	  * 输入: s = "abcdefg", k = 2
	  * 输出: "bacdfeg"
	  * 
	  * 要求:
	  *   该字符串只包含小写的英文字母。
	  *   给定字符串的长度和 k 在[1, 10000]范围内。
	  * */
	 public static String reverseStr(String s, int k) {
		 //将翻转所有字符问题变成了分段翻转
		 int index = 0;
		 int len = s.length();
		 StringBuilder sb = new StringBuilder();
		 while(len >= 2 * k) {
			 sb.append(new StringBuilder(s.substring(index, index + k)).reverse().append(s.substring(index + k, index + 2 * k)));
			 len -= 2 * k;
			 index += 2 * k;
		 }
		 if(len < k)
			 sb.append(new StringBuilder(s.substring(index)).reverse());
		 else if(len < 2 * k)
			 sb.append(new StringBuilder(s.substring(index, index + k)).reverse().append(s.substring(index + k)));
 		 return sb.toString();
	}
	 /*
	  * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
	  * 
	  * 注意：
	  *  	num1 和num2 的长度都小于 5100.
	  * 	num1 和num2 都只包含数字 0-9.
	  * 	num1 和num2 都不包含任何前导零。
	  * 	你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
	  * */
	 public static String addStrings(String num1, String num2) {
		 int carry = 0;    //进位
		 StringBuilder str = new StringBuilder("");   //空字符串
		 for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
			 int num1Int = 0;
			 if(i >= 0) {
				 num1Int = num1.charAt(i) - '0';
			 }
			 int num2Int = 0;
			 if(j >= 0) {
				 num2Int = num2.charAt(j) - '0';
			 }
			 int sum = num1Int + num2Int + carry;
			 str.append(sum % 10);
			 carry = sum / 10;
		 }
		 if(carry > 0)         //两个数组的第一位相加有进位时，将进位放入字符串
			 str.append(carry);
		 return str.reverse().toString();
	 }
	 /*
	  * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	  * 说明：本题中，我们将空字符串定义为有效的回文串。
	  * 
	  * 示例 1:
	  * 输入: "A man, a plan, a canal: Panama"
	  * 输出: true
	  * 
	  * 示例 2:
	  * 输入: "race a car"
	  * 输出: false
	  * */
	 public static boolean isPalindrome(String s) {
		 char[] sChars = s.toCharArray();
		 List<Character> chars = new ArrayList<>();
		 for(int i = 0; i < sChars.length; i++) {
			 if((sChars[i] >= 'A' && sChars[i] <= 'Z') || (sChars[i] >= 'a' && sChars[i] <= 'z') || (sChars[i] >= '0' && sChars[i] <= '9')) {
				 if(sChars[i]>= 'A' && sChars[i] <= 'Z')
					 sChars[i] = (char) (sChars[i] + 32);
				 chars.add(sChars[i]);
			 }
		 }
		 char[] chars1 = new char[chars.size()];
		 char[] chars2 = new char[chars.size()];
		 for(int i = 0; i < chars.size(); i++) {
			 chars1[i] = chars.get(i);
			 chars2[i] = chars.get(i);
		 }
		 for(int x = 0, y = chars1.length - 1; x < y; x++, y--) {
			 char temp = chars1[x];
			 chars1[x] = chars1[y];
			 chars1[y] = temp;
		 }
		 for(int i = 0; i < chars1.length; i++) {
			 if (chars1[i] != chars2[i]) {
				return false;
			}
		 }
		 return true;
		 
		 //调用库函数，这种方法也行
//		 int i = 0, j = s.length() - 1; 
//		 while(i < j){ 
//			 while(i < j && !Character.isLetterOrDigit(s.charAt(i)))  //确定指定字符是否为字母或数字。
//				 i++; 
//			 while(i < j && !Character.isLetterOrDigit(s.charAt(j))) 
//				 j--; 
//			 if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) 
//				 return false; 
//			 i++; j--;  
//			 } 
//		 return true;
	}
	 /*
	  * 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列
	  * 为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
	  * 
	  * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序
	  * 列，任何字符串为其自身的子序列。
	  * 
	  * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
	  * 
	  * 示例 :
	  * 输入: "aba", "cdc"
	  * 输出: 3
	  * 解析: 最长特殊序列可为 "aba" (或 "cdc")
	  * 
	  * 说明:
	  * 	两个字符串长度均小于100。
	  * 	字符串中的字符仅含有 'a'~'z'。
	  * */
	 public static int findLUSlength(String a, String b) {
		 /*
		  * 注意题目中的独有两个字，
		  * s1 = 'ab',s2 = 'a',因为ab是s1独有，所以最长子序列为ab，
		  * s1 = 'ab', s2 = 'ab', 因为ab是两个串都有，ab排除，a也是两个串都有，排除，b也是两个串都有，排除。所以最长特殊序列不存在，返回-1
		  * 通过以上分析，我们可以得出结论，如果：两个串相等（不仅长度相等，内容也相等），那么他们的最长特殊序列不存在。返回-1
		  * 如果两个串长度不一样，那么长的串 永远也不可能是 短串的子序列，即len(s1) > len(s2),则最长特殊序列为s1,返回长度大的数
		  * */
		 if(a.equals(b))
			 return -1;
		 return a.length() > b.length()? a.length() : b.length();
	}
	 /*
	  * 你将得到一个字符串数组 A。
	  * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
	  * 一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，交换 S[j] 和 S [i]。
	  * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
	  * 返回 A 中特殊等价字符串组的数量。
	  * 
	  * 示例 1：
	  * 输入：["a","b","c","a","c","c"]
	  * 输出：3
	  * 解释：3 组 ["a","a"]，["b"]，["c","c","c"]
	  * 
	  * 示例 2：
	  * 输入：["aa","bb","ab","ba"]
	  * 输出：4
	  * 解释：4 组 ["aa"]，["bb"]，["ab"]，["ba"]
	  * 
	  * 示例 3：
	  * 输入：["abc","acb","bac","bca","cab","cba"]
	  * 输出：3
	  * 解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
	  * 
	  * 示例 4：
	  * 输入：["abcd","cdab","adcb","cbad"]
	  * 输出：1
	  * 解释：1 组 ["abcd","cdab","adcb","cbad"]
	  * */
	 public static int  numSpecialEquivGroups(String[] A) {
		//对列表中的每个字符串，取其奇数位字符和偶数位字符。如果两个字符串特殊等价，则他们奇数位字符和偶数位字符应该是使用的同样的字符。
		Set<String> set = new HashSet<>();
		for(String str: A) { 
			int[] count = new int[52];     //前26个int数据用来存放偶数索引上的字符映射，后26个int数据用来存放奇数索引上的字符映射
			for(int i = 0; i < str.length(); i++) {
				count[str.charAt(i) - 'a' + 26*(i % 2)]++;
			}
			set.add(Arrays.toString(count));
		} 
		return set.size();
	}
	 /*
	 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的
	 * 数。要求每位数字都要被旋转。
	 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自
	 * 己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
	 * 
	 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
	 * 示例:
	 * 输入: 10
	 * 输出: 4
	 * 解释: 
	 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
	 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
	 * 
	 * 注意:
	 * 		N 的取值范围是 [1, 10000]。
	 * */
	public static int romateDigits(int N) {
		//思路：好数等价为一个数满足下面的两个条件
		//	1.只由0,1,8,2,5,6,9这几个数字构成
		//	2.至少存在一个2或5或6或9
		int count = 0;
		for(int i = 1; i <= N; i++) {
			if(judge(i))
				count++;
		}
		return count;
	}
	public static boolean judge(int num) {
		boolean flag = false;
		//String str = "0182569";    //只有由这些数构成才能称为好数
		while(num != 0) {
			int mod = num % 10;
			if(mod == 3 || mod == 4 || mod == 7)    //当mod=3，4,7时，这些数不存在str中，故索引返回-1
				return false;
			else if (mod == 2 || mod == 5 || mod == 6 || mod == 9) {
				flag = true;
			}
			num /= 10;
		}
		return flag;
	}
	/*
	 * 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
	 * 对于每条日志，其第一个字为字母数字标识符。然后，要么：
	 * 		标识符后面的每个字将仅由小写字母组成，或；
	 * 		标识符后面的每个字将仅由数字组成。
	 * 
	 * 我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
	 * 将日志重新排序，使得所有字母日志都排在数字日志之前。字母日志按内容字母顺序排序，忽略标识符；在内容
	 * 相同时，按标识符排序。数字日志应该按原来的顺序排列。
	 * 
	 * 返回日志的最终顺序。
	 * 
	 * 示例 ：
	 * 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
	 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
	 * 
	 * 提示：
	 * 		0 <= logs.length <= 100
	 * 		3 <= logs[i].length <= 100
	 * 		logs[i] 保证有一个标识符，并且标识符后面有一个字。
	 * */
	public static String[] reorderLogFiles(String[] logs) {
		
		return null;
	}
	/*
	 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的
	 * 所有0和所有1都是组合在一起的。重复出现的子串要计算它们出现的次数。
	 * 
	 * 示例 1 :
	 * 输入: "00110011"
	 * 输出: 6
	 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
	 * 请注意，一些重复出现的子串要计算它们出现的次数。
	 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
	 * 
	 * 示例 2 :
	 * 输入: "10101"
	 * 输出: 4
	 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
	 * 
	 * 注意：
	 * s.length 在1到50,000之间。
	 * s 只包含“0”或“1”字符。
	 * */
	public static int countBinarySubstrings(String s) {
		//找到01或者10的切换点，往两边扩张。这种方法是最容易想到的，但是速度不是最优
		if(s == null)
			return 0;
		int ans = 0;      //返回值
		for(int i = 0; i < s.length() - 1; i++) {
			int j = i + 1;     //j是i的下一个索引
			char a = s.charAt(i);
			char b = s.charAt(j);
			
			if(a != b) {
				//01 or 10
				ans++;
				int start = i - 1;
				int end = j + 1;
				while(start >= 0 && end < s.length()) {
					if(s.charAt(start) == s.charAt(end)) {
						//0011 or 1100
						ans++;
						start--;
						end++;
					}
		 			else
						break;
				}
			}
		}
		return ans;
	}
	/*
	 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
	 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
	 * 
	 * 示例 1：
	 * 输入：name = "alex", typed = "aaleex"
	 * 输出：true
	 * 解释：'alex' 中的 'a' 和 'e' 被长按。
	 * 
	 * 示例 2：
	 * 输入：name = "saeed", typed = "ssaaedd"
	 * 输出：false
	 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
	 * 
	 * 示例 3：
	 * 输入：name = "leelee", typed = "lleeelee"
	 * 输出：true
	 * 
	 * 示例 4：
	 * 输入：name = "laiden", typed = "laiden"
	 * 输出：true
	 * 解释：长按名字中的字符并不是必要的。
	 * 
	 * 提示：
	 * 		name.length <= 1000
	 * 		typed.length <= 1000
	 * 		name 和 typed 的字符都是小写字母。
	 * */
	public static boolean isLongPressedName(String name, String typed) {
		int i = 0;  //i是name的索引
		for(int j = 0; i < name.length() && j < typed.length(); j++) {  //j是typed的索引
			if(name.charAt(i) == typed.charAt(j)) {
				i++;
			}else if (i == 0 || name.charAt(i - 1) != typed.charAt(j)) {  //当i=0时，不执行后面的
				return false;
			}
		}
		return i == name.length();
	}
	/*
	 * 字符串中的第一个唯一字符：
	 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
	 * 
	 * 案例:
	 * s = "leetcode"
	 * 返回 0.
	 * 
	 * s = "loveleetcode",
	 * 返回 2.
	 * 
	 * 注意事项：您可以假定该字符串只包含小写字母。
	 * */
	public static int firstUniqueChar(String s) {
		//indexOf()和lastIndexOf()来判断一个字符是否重复
		int index = -1;
		for(char ch = 'a'; ch <= 'z'; ch++) {
			int beginIndex = s.indexOf(ch);
			if(beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
				index = (index == -1 || index > beginIndex)? beginIndex : index; //取小的，越小代表越前。
			}
		}
		return index;
	}
	/*
	 * 实现 strStr() 函数：
	 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第
	 * 一个位置 (从0开始)。如果不存在，则返回  -1。
	 * 
	 * 示例 1:
	 * 输入: haystack = "hello", needle = "ll"
	 * 输出: 2
	 * 
	 * 示例 2:
	 * 输入: haystack = "aaaaa", needle = "bba"
	 * 输出: -1
	 * 
	 * 说明:
	 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
	 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
	 * */
	public static int strStr(String haystack, String needle) {
		int lenH = haystack.length();
		int lenN = needle.length();
		int ans = -1;
		for(int i = 0; i <= lenH - lenN; i++) {
			String substr = haystack.substring(i, i + lenN);
			if(substr.equals(needle)) {
				return i;
			}
		}
		return ans;
	}
	/*
	 * 给定一组字符，使用原地算法将其压缩。
	 * 压缩后的长度必须始终小于或等于原数组长度。
	 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
	 * 在完成原地修改输入数组后，返回数组的新长度。
	 * 
	 * 进阶：
	 * 你能否仅使用O(1) 空间解决问题？
	 * 
	 * 示例 1：
	 * 输入：
	 * ["a","a","b","b","c","c","c"]
	 * 输出：
	 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
	 * 
	 * 说明：
	 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
	 * 示例 2：
	 * 输入：
	 * ["a"]
	 * 
	 * 输出：
	 * 返回1，输入数组的前1个字符应该是：["a"]
	 * 说明：
	 * 没有任何字符串被替代。
	 * 
	 * 示例 3：
	 * 输入：
	 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
	 * 输出：
	 * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
	 * 
	 * 说明：
	 * 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
	 * 注意每个数字在数组中都有它自己的位置。
	 * 
	 * 注意：
	 * 所有字符都有一个ASCII值在[35, 126]区间内。
	 * 1 <= len(chars) <= 1000。
	 * */
	public static int  compress(char[] chars) {
		
		return 0;
	}
	/*
	 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
	 * 返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
	 * 
	 * 示例 1：
	 * 输入：str1 = "ABCABC", str2 = "ABC"
	 * 输出："ABC"
	 * 
	 * 示例 2：
	 * 输入：str1 = "ABABAB", str2 = "ABAB"
	 * 输出："AB"
	 * 
	 * 示例 3：
	 * 输入：str1 = "LEET", str2 = "CODE"
	 * 输出：""
	 * 
	 * 提示：
	 * 		1 <= str1.length <= 1000
	 * 		1 <= str2.length <= 1000
	 * 		str1[i] 和 str2[i] 为大写英文字母
	 * */
	public static String gcdOfStrings(String str1, String str2) {
		//长串减去短串形成新串， 新串和短串再比出长短串再互减
		if(str1 == null || str2 == null) {
			return "";
		}
		String longStr = (str1.length() > str2.length())? str1 : str2;
		String shortStr = (str1.length() > str2.length())? str2 : str1;
		while(longStr.length() != shortStr.length()) {
			if(longStr.indexOf(shortStr) == 0) {
				String tempStr = longStr.substring(shortStr.length(), longStr.length());
				longStr = (tempStr.length() > shortStr.length())? tempStr : shortStr;
				shortStr = (tempStr.length() < shortStr.length())? tempStr : shortStr;
			}else
				return "";	
		}
		if(longStr.equals(shortStr))
			return longStr;
		else
			return "";
	}
	/*
	 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写
	 * 英文字母，并且长度不超过10000。
	 * 
	 * 示例 1:
	 * 输入: "abab"
	 * 输出: True
	 * 解释: 可由子字符串 "ab" 重复两次构成。
	 * 
	 * 示例 2:
	 * 输入: "aba"
	 * 输出: False
	 * 
	 * 示例 3:
	 * 输入: "abcabcabcabc"
	 * 输出: True
	 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
	 * */
	public static boolean repeatedSubstringPattern(String s) {
		//将字符串s加上本身，再判断s在2s中的索引是否存在
		
		return (s + s).substring(1, s.length() * 2 - 1).indexOf(s) != -1;
	}
	/**
	 * 有效的字符串：
	 * 
	 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	 * 
	 * 有效字符串需满足：
	 * 左括号必须用相同类型的右括号闭合。
	 * 左括号必须以正确的顺序闭合。
	 * 
	 * 注意空字符串可被认为是有效字符串。
	 * 示例 1:
	 * 输入: "()"
	 * 输出: true
	 * 
	 * 示例 2:
	 * 输入: "()[]{}"
	 * 输出: true
	 * 
	 * 示例 3:
	 * 输入: "(]"
	 * 输出: false
	 * 
	 * 示例 4:
	 * 输入: "([)]"
	 * 输出: false
	 * 
	 * 示例 5:
	 * 输入: "{[]}"
	 * 输出: true
	 **/
	public static boolean isValid(String s) {
		//使用栈的思想
		return false;
	}
	/*
	 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
	 * 如果不存在最后一个单词，请返回 0 。
	 * 
	 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
	 * 
	 * 示例:
	 * 输入: "Hello World"
	 * 输出: 5
	 * */
	public static int lengthOfLastWord(String s) {
		String[] strs = s.split(" ");
		if(strs.length > 0)
			return strs[strs.length - 1].length();
		return 0;
	}
	/*
	 * 给定两个字符串 s 和 t，它们只包含小写字母。
	 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
	 * 请找出在 t 中被添加的字母。
	 * 
	 * 示例:
	 * 输入：
	 * s = "abcd"
	 * t = "abcde"
	 * 
	 * 输出：
	 * e
	 * 
	 * 解释：
	 * 'e' 是那个被添加的字母。
	 * */
	public static char findTheDifference(String s, String t) {
		//利用ASCII码
		char sum = 0;       
		for(char c: t.toCharArray()) {
			sum += c;
		}
		for(char c: s.toCharArray()){
			sum -= c;
		}
		return sum;
	}
	/*
	 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需
	 * 要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
	 * 
	 * 示例 1:
	 * 输入: candies = [1,1,2,2,3,3]
	 * 输出: 3
	 * 解析: 一共有三种种类的糖果，每一种都有两个。
	 * 		最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
	 * 
	 * 示例 2 :
	 * 输入: candies = [1,1,2,3]
	 * 输出: 2
	 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
	 * 
	 * 注意:
	 * 数组的长度为[2, 10,000]，并且确定为偶数。
	 * 数组中数字的大小在范围[-100,000, 100,000]内。
	 * */
	public static int distributeCandies(int[] candies) {
		Set<Integer> classes = new HashSet<>();
		
		return 0;
	}
	
	public static boolean isPowerOfFour(int num) {
        //位运算
        if(num < 0 || (num & (num - 1)) != 0){       //不是2的幂次方的数，返回true 
            return false;
        }
        //4的二进制数，1在偶数位上， 其余位都为0，
        //将num与1010101做与运算，为1则为4的幂次方，反之为2的幂次方
        //0x5 = 0101b
        if((num & 0x55555555) != 0)
        	return true;
        return false;
        //return (boolean)(num & 0x55555555);     //或者 return num % 3 == 1;
    }
	/*
	 * 宝石和石头：
	 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 
	 * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
	 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
	 * 
	 * 示例 1:
	 * 输入: J = "aA", S = "aAAbbbb"
	 * 输出: 3
	 * 
	 * 示例 2:
	 * 输入: J = "z", S = "ZZ"
	 * 输出: 0
	 * 
	 * 注意:
	 * S 和 J 最多含有50个字母。
	 * J 中的字符不重复。
	 * */
	public static int  numJewelsInStones(String J, String S) {
		//循环嵌套
		int count = 0;
		for(int i = 0; i < J.length(); i++) {
			for(int j = 0; j < S.length(); j++) {
				if(J.charAt(i) == S.charAt(j))
					count++;
			}
		}
		return count;
	}
	/*
	 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
	 * 
	 * 示例 1：
	 * 输入：00000000000000000000000000001011
	 * 输出：3
	 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
	 * 
	 * 示例 2：
	 * 输入：00000000000000000000000010000000
	 * 输出：1
	 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
	 * 
	 * 示例 3：
	 * 输入：11111111111111111111111111111101
	 * 输出：31
	 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
	 * */
	public static int hanmingWeight(int n) {
		//该方法占用时间太长
//		int count = 0;
//		String str = Integer.toBinaryString(n);
//		for(int i = 0; i < str.length(); i++) {
//			if(str.charAt(i) == '1')
//				count++;
//		}
//		return count;
		
		//位运算
		int count = 0;
		while(n > 0){
			count++;
			n = n & (n - 1);
		}
		return count;
	}
	/*
	 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
	 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
	 * 示例 1：
	 * 输入：address = "1.1.1.1"
	 * 输出："1[.]1[.]1[.]1"
	 * 
	 * 示例 2：
	 * 输入：address = "255.100.50.0"
	 * 输出："255[.]100[.]50[.]0"
	 * */
	public static String defangIPaddr(String address) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< address.length(); i++) {
			if(address.charAt(i) != '.')
				sb.append(address.charAt(i));
			else
				sb.append("[.]");
		}
		return sb.toString();
	}
	/*
	 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中
	 * 的字符 C 的最短距离的数组。
	 * 
	 * 示例 1:
	 * 输入: S = "loveleetcode", C = 'e'
	 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
	 * */
	public static int[] shortestToChar(String s, char C) {
		return null;
	}
	/*
	 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
	 * 
	 * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个
	 * 比 x 大的元素。如果不存在，对应位置输出-1。
	 * 
	 * 示例 1:
	 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
	 * 输出: [-1,3,-1]
	 * 解释:
	 *		对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
	 * 		对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
	 * 		对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
	 * 
	 * 示例 2:
	 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
	 * 输出: [3,-1]
	 * 解释:
	 * 		对于num1中的数字2，第二个数组中的下一个较大数字是3。
	 * 		对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
	 * */
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] ans = new int[nums1.length];
		for(int i = 0; i < nums1.length; i++) {
			for(int j = 0; j < nums2.length; j++) {
				if(nums1[i] == nums2[j]) {
					for(int k = j + 1; k < nums2.length; k++) {
						if(nums1[i] == nums2[k]) {
							
						}
					}
				}
			}
		}
		return ans;
	}
}

//Employee info
class Employee {
 // It's the unique id of each node;
 // unique id of this employee
 public int id;
 // the importance value of this employee
 public int importance;
 // the id of direct subordinates
 public List<Integer> subordinates;
};
