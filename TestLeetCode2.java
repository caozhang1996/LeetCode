package timu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * leetCode上的数组相关题目
 * */                                               
public class TestLeetCode2 {
	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
	}
	
	/*
	 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
	 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
	 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
	 * 
	 * 示例 1:
	 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
	 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
	 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
	 * 		然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
	 * 
	 * 示例 2:
	 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
	 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
	 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
	 * 		然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
	 * 
	 * 说明:
	 * 1 <= A.length = A[0].length <= 20
	 * 0 <= A[i][j] <= 1
	 * */
	public static int[][] flipAndInvertImage(int[][] A) {
		for(int i = 0; i < A.length; i++) {
			//先水平翻转，翻转就是将数组中的元素翻转
			for(int x = 0, y = A[i].length - 1; x < y; x++, y--) {
				int temp = A[i][x];
				A[i][x] = A[i][y];
				A[i][y] = temp;
			}
			
			//后反转图片，即0变1,1变0
			for(int j = 0; j < A[i].length; j++) {
				if(A[i][j] == 0)
					A[i][j] = 1;
				else if (A[i][j] == 1)
					A[i][j] = 0;
			}
		}
		return A;
	}
	
	/*
	 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
	 * 
	 * 示例 1：
	 * 输入：[-4,-1,0,3,10]
	 * 输出：[0,1,9,16,100]
	 * 
	 * 示例 2：
	 * 输入：[-7,-3,2,3,11]
	 * 输出：[4,9,9,49,121]
	 * 
	 * 提示：
	 * 1 <= A.length <= 10000
	 * -10000 <= A[i] <= 10000
	 * A 已按非递减顺序排序。
	 * */
	public static int[] sortedSquares(int[] A) {
		
		for(int i = 0; i < A.length; i++) {
			A[i] = A[i] * A[i];
		}
		
		for(int i = 0; i < A.length - 1; i++) {
			int t = i;
			for(int j = i + 1; j < A.length; j++) {
				if(A[t] > A[j])
					t = j;
			}
			if(t != i) {
				int temp = A[i];
				A[i] = A[t];
				A[t] = temp;
			}	
		}
		return A;
	}
	
	/*
	 * 校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
	 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
	 * 
	 * 示例：
	 * 输入：[1,1,4,2,1,3]
	 * 输出：3
	 * 解释：
	 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
	 * 
	 * 提示：
	 * 1 <= heights.length <= 100
	 * 1 <= heights[i] <= 100
	 * */
	public static int heightChecker(int[] heights) {
		int count = 0;
		int[] temp_height = Arrays.copyOf(heights, heights.length);
		//先排序, 可以将for循环排序替换为调用函数来代替，节省时间
//		for(int i = 0; i < heights.length - 1; i++) {
//			int t = i;
//			for(int j = i + 1; j <heights.length; j++) {
//				if(heights[t] > heights[j])
//					t = j;
//			}
//			if (t != i) {
//				int temp = heights[i];
//				heights[i] = heights[t];
//				heights[t] = temp;
//			}
//		}
		Arrays.sort(temp_height);
		//后依次比较得出人数
		for(int i = 0; i < heights.length; i++) {
			if(temp_height[i] != heights[i])
				count++;
		}
		return count;
	}
	
	/*
	 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
	 * 
	 * 示例 1:
	 * 输入: [1,4,3,2]
	 * 输出: 4
	 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
	 * 
	 * 提示:
	 * n 是正整数,范围在 [1, 10000].
	 * 数组中的元素范围在 [-10000, 10000].
	 * */
	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);   //先排序
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			 if(i % 2 ==0)
				 sum += nums[i];
		}
		return sum;
	}
	
	/*
	 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
	 * 
	 * F(0) = 0,   F(1) = 1
	 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
	 * 
	 * 给定 N，计算 F(N)。
	 * 示例 1：
	 * 输入：2
	 * 输出：1
	 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
	 * 
	 * 示例 2：
	 * 输入：3
	 * 输出：2
	 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
	 * 
	 * 示例 3：
	 * 输入：4
	 * 输出：3
	 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
	 * 
	 * 提示：
	 * 0 ≤ N ≤ 30
	 * */
	public static int fib(int N) {
		if(N == 0)
			return 0;
		if(N == 1)
			return 1;
		
		int x = 0, y = 1, num = 0;
		for(int i = 2; i <= N; i++) {
			num = x + y;
			x = y;
			y = num;
		}
		return num;
	}
	/*
	 * 给定一个矩阵 A， 返回 A 的转置矩阵。
	 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
	 * 
	 * 示例 1：
	 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
	 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
	 * 
	 * 示例 2：
	 * 输入：[[1,2,3],[4,5,6]]
	 * 输出：[[1,4],[2,5],[3,6]]
	 * 
	 * 提示：
	 *  1 <= A.length <= 1000
	 *  1 <= A[0].length <= 1000
	 * */
	public static int[][] transpose(int[][] A) {
		 int H = A.length;     //数组的列
	     int W = A[0].length;  //数组的行
	     int[][] B = new int[W][H];
	        
        for(int i = 0; i < W; i++){
            for(int j = 0; j < H; j++){
                B[i][j] = A[j][i];
            }
        }
        return B;
	}
	
	/*
	 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
	 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
	 * 你可以返回任何满足上述条件的数组作为答案。
	 * 
	 * 示例：
	 * 输入：[4,2,5,7]
	 * 输出：[4,5,2,7]
	 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
	 * 
	 * 提示：
	 * 2 <= A.length <= 20000
	 * A.length % 2 == 0
	 * 0 <= A[i] <= 1000
	 * */
	public static int[] sortArrayByParityII(int[] A) {
		int[] B = new int[A.length];
		int j = 0, k = A.length - 1;
		for(int i = 0; i < A.length ; i++) {
			if(A[i] % 2 ==0) {
				B[j] = A[i];
				j += 2;
			}else {
				B[k] = A[i];
				k -= 2;
			}	
		}
		return B;
	}
	
	/*
	 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
	 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。你可以按任意顺序返回答案。
	 * 
	 * 示例 1：
	 * 输入：["bella","label","roller"]
	 * 输出：["e","l","l"]
	 * 
	 * 示例 2：
	 * 输入：["cool","lock","cook"]
	 * 输出：["c","o"]
	 * 
	 * 提示：
	 * 1 <= A.length <= 100
	 * 1 <= A[i].length <= 100
	 * A[i][j] 是小写字母
	 * */
	public static List<String> commonChars(String[] A) {
		int[] map = new int[26];       //map存放A数组第一个字符串的映射值
		boolean flag = true;
		List<String> ans = new ArrayList<>();
		for(String a: A) {
			char[] chars = a.toCharArray();
			if(flag) {
				for(char c: chars) {
					map[c - 'a']++;
				}
				flag = false;
			}
			if(!flag) {
				int[] temp_map = new int[26];  //temp_map存放A数组第一个字符串之后的映射值
				for(char c: chars) {
					temp_map[c - 'a']++;
				}
				//比较map和temp_map的值
				for(int i = 0; i < map.length; i++) {
					if(map[i] > temp_map[i])
						map[i] = temp_map[i];
				}
			}
		}
		//整理map数组，将每个单词中重复的字符输出
		for(int i = 0; i < map.length; i++) {     //map中存放的是重复字母出现的次数
			if(map[i] != 0) {
				String temp = String.valueOf((char)(i + 'a'));
				for(int j = 0; j < map[i]; j++){
					ans.add(temp);
				}
			}
		}
		return ans;
	}
	
	/**
	 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
	 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
	 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
	 * 
	 * 示例 1:
	 * 输入:
	 * nums =[[1,2],
	 *        [3,4]]
	 * r = 1, c = 4
	 * 输出: 
	 * [[1,2,3,4]]
	 * 解释:
	 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
	 * 
	 * 示例 2:
	 * 输入: 
	 * nums = [[1,2],
	 *         [3,4]]
	 * r = 2, c = 4
	 * 输出: 
	 * [[1,2],
	 * [3,4]]
	 * 解释:
	 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
	 * */
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		//双指针方法
		int oldR = nums.length;
		int oldC = nums[0].length;
		int row = 0, col = 0;
		if(r * c != oldR * oldC)
			return nums;
		
		int[][] ans = new int[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c ; j++) {
				if(col >= oldC) {
					row++;
					col = 0;
				}
				ans[i][j] = nums[row][col];
				col++;
			}
		}
		return ans;
	}
	
	/**
	 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
	 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
	 * 
	 * 示例 1:
	 * 输入: [3,2,3]
	 * 输出: 3
	 * 
	 * 示例 2:
	 * 输入: [2,2,1,1,1,2,2]
	 * 输出: 2
	 * */
	public static int majorityElement(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int majority = 0, count = 0;
		for(int num: nums) {
			set.add(num);
		}
		Object[] objs = set.toArray();
		for(int i = 0; i < objs.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				if((int)objs[i] == nums[j]) {
					count++;
				}
				if(count > nums.length / 2) {
					majority = (int)objs[i];
				}
			}
			count = 0;
		}
		return majority;	
	}
	public static int  majorityElementCopy(int[] nums) {
		//栈的思想
		//空栈：入栈
		//栈顶 = 元素：入栈
		//不相等则出栈
		return 0;
	}
	
	/*
	 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
	 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
	 * 
	 * 示例 1:
	 * 输入:
	 * matrix = [
	 * [1,2,3,4],
	 * [5,1,2,3],
	 * [9,5,1,2]]
	 * 输出: True
	 * 解释:
	 * 在上述矩阵中, 其对角线为:
	 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
	 * 各条对角线上的所有元素均相同, 因此答案是True。
	 * 
	 * 示例 2:
	 * 输入:
	 * matrix = [
	 * [1,2],
	 * [2,2]]
	 * 输出: False
	 * 解释: 
	 * 对角线"[1, 2]"上的元素不同。
	 * 
	 * 说明:
	 * matrix 是一个包含整数的二维数组。
	 * matrix 的行数和列数均在 [1, 20]范围内。
	 * matrix[i][j] 包含的整数在 [0, 99]范围内。
	 * */
	public static boolean isToeplitzMatrix(int[][] matrix) {
		//存在python版本，一样的思路
		//把第一行和第一列排除在外 比较每一个值和他的左上角
		
		return false;
	}
	/*
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	 * 
	 * 示例:
	 * 输入: [0,1,0,3,12]
	 * 输出: [1,3,12,0,0]
	 * 
	 * 说明:
	 * 必须在原数组上操作，不能拷贝额外的数组。
	 * 尽量减少操作次数。
	 * */
	public static void moveZeros(int[] nums) {              //双指针
		//思路：可以先把所有非0的元素移到前面，然后将后面的位置补0。 使用指针i，指向需要插入的下标，
		//使用指针j指向遍历的下标。遍历一遍，如果j指向的位置为0，则i不变，j++后移；如果j指向的位置不为0，则将j位置的元素值赋值到i位置，然后i++。
		int i = 0;
		for(int j = 0; j < nums.length; j++) {
			if(nums[j] != 0) {
				nums[i] = nums[j];
				i++;
			}
		}
		//将后面的位置补零
		for(int k = i; k < nums.length; k++) {
			nums[k] = 0;
		}
	}
	public static void moveZreosCopy(int[] nums) {  //移动0的第二种方法
		int i = 0;
		for(int j = 0; j < nums.length; j++) {
			if(nums[j] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		}
	}
	/*	只出现一次的数字！！！！
	 * 
	 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
	 * 
	 * 说明：
	 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
	 * 
	 * 示例 1:
	 * 输入: [2,2,1]
	 * 输出: 1
	 * 
	 * 示例 2:
	 * 输入: [4,1,2,1,2]
	 * 输出: 4
	 * */
	public static int singleNumber(int[] nums) {
		//采用异或（异或的特性是两个相同的数异或得到0， 0再与任何数异或得到该数本省 例如： a^b^a = b）
		
		return 0;
	}
	/*
	 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
	 * 
	 * 示例 1:
	 * 输入: s = "anagram", t = "nagaram"
	 * 输出: true
	 * 
	 * 示例 2:
	 * 输入: s = "rat", t = "car"
	 * 输出: false
	 * 
	 * 说明:
	 * 你可以假设字符串只包含小写字母。
	 * */
	public static boolean isAnagram(String s, String t) {
		//hash映射
		return false;
	}
	
	/*
	 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	 * 
	 * 示例:
	 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
	 * 输出: 6
	 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	 * 
	 * 进阶:
	 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
	 * */
	public static int maxSubArray(int[] nums) {
		int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
	}
	
	/* 买卖股票的最佳时机
	 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
	 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
	 * 
	 * 注意你不能在买入股票前卖出股票。
	 * 示例 1:
	 * 输入: [7,1,5,3,6,4]
	 * 输出: 5
	 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最
	 * 大利润 = 6-1 = 5 。
	 * 		注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
	 * 
	 * 示例 2:
	 * 输入: [7,6,4,3,1]
	 * 输出: 0
	 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
	 * */
	public static int maxProfit(int[] prices) {         //时间复杂度为O(n^2),耗时太长,需要优化
		if(prices.length <= 1)
			return 0;
		//找出数组中两元素相减的最大值
		int max = prices[1] - prices[0];
		for(int i = 0; i < prices.length - 1; i++) {
			for(int j = i + 1; j < prices.length; j++) {
				if(max < prices[j] - prices[i])
					max = prices[j] - prices[i];
				if(max < 0)
					continue;
			}
		}
		if(max < 0)
			return 0;
		return max;
	}
	/*
	 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
	 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
	 * 给出两个矩形，判断它们是否重叠并返回结果。
	 * 
	 * 示例 1：
	 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
	 * 输出：true
	 * 
	 * 示例 2：
	 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
	 * 输出：false
	 * 
	 * 说明：
	 * 		两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
	 * 		矩形中的所有坐标都处于 -10^9 和 10^9 之间。
	 * */
	public static boolean isRectangleOverlap(int[] rect1, int[] rect2) {
		//不重叠的情况有四种
		if(rect1[0] >= rect2[2] 
				|| rect2[0] >= rect1[2]
			    || rect2[1] >= rect1[3]
			    || rect1[1] >= rect2[3]) {
			return false;
		}
		return true;
	}
	/*存在重复元素
	 * 
	 * 给定一个整数数组，判断是否存在重复元素。
	 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
	 * 
	 * 示例 1:
	 * 输入: [1,2,3,1]
	 * 输出: true
	 * 
	 * 示例 2:
	 * 输入: [1,2,3,4]
	 * 输出: false
	 * 
	 * 示例 3:
	 * 输入: [1,1,1,3,3,4,3,2,4,2]
	 * 输出: true
	 * */
	public boolean containsDuplicate(int[] nums) {
        //set去重，如果set的长度和nums一样则没有重复元素，反之则有,时间复杂度为O(n)
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        if(set.size() == nums.length)
            return false;
        else
            return true;
    }
	
	/*两个数组的交集
	 * 
	 * 给定两个数组，编写一个函数来计算它们的交集。
	 * 
	 * 示例 1:
	 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
	 * 输出: [2]
	 * 
	 * 示例 2:
	 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	 * 输出: [9,4]
	 * 
	 * 说明:
	 * 输出结果中的每个元素一定是唯一的。
	 * 我们可以不考虑输出结果的顺序。
	 * */
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>(); 
		int index = 0;    // 数组ans的指针
		for(int i = 0; i < nums1.length; i++) {
			for(int j = 0; j < nums2.length; j++) {
				if(nums1[i] == nums2[j]) {
					set.add(nums1[i]);
					break;
				}
			}
		}
		Object[] obj = set.toArray();
		int[] ans = new int[obj.length];
		for(int i = 0; i < obj.length; i++) {
			ans[i] = (int)(obj[i]);
		}
		return ans;
	}
	/*
	 * 柠檬水找零：
	 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
	 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
	 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
	 * 
	 * 注意，一开始你手头没有任何零钱。
	 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
	 * 
	 * 示例 1：
	 * 输入：[5,5,5,10,20]
	 * 输出：true
	 * 解释：
	 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
	 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
	 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
	 * 由于所有客户都得到了正确的找零，所以我们输出 true。
	 * 
	 * 示例 2：
	 * 输入：[5,5,10]
	 * 输出：true
	 * 
	 * 示例 3：
	 * 输入：[10,10]
	 * 输出：false
	 * 
	 * 示例 4：
	 * 输入：[5,5,10,10,20]
	 * 输出：false
	 * 解释：
	 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
	 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
	 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
	 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
	 * */
	public static boolean lemonadeChange(int[] bills) {
		int fiveNumbers = 0;
		int tenNumbers = 0;
		
		for(int i = 0; i < bills.length; i++) {
			if(bills[i] == 5)
				fiveNumbers++;
			if(bills[i] == 10) {
				if(fiveNumbers > 0) {
					tenNumbers++;
					fiveNumbers--;
				}else
					return false;
			}
			if(bills[i] == 20) {
				if(fiveNumbers > 0 && tenNumbers > 0) {
					fiveNumbers--;
					tenNumbers--;
				}else if (fiveNumbers > 2) {
					fiveNumbers -= 3;
				}else
					return false;
			}
		}
		return true;
	}
	
	/**找到所有数组中消失的数字
	 * 
	 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
	 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
	 * 
	 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
	 * 示例:
	 * 输入:
	 * [4,3,2,7,8,2,3,1]
	 * 输出:
	 * [5,6]
	 * */
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		/*
		 * 找出 1 - n 中没有出现的数字。不能使用额外的空间，两次循环时间复杂度为 2O(n)，即为 O(n)。
		 * 解题思路：使用数组的下标来标记数字的出现于否，通过一遍遍历即可标记出全部已经出现的数组
		 *
		 * [4,3,2,7,8,2,3,1] 初始数据
		 *
		 * [4,3,2,-7,8,2,3,1] 第一个数据 4 出现，将数组的第四个也就是下标 3 的数据修改为负数。-7 计算时，通过绝对值处理一下即可不影响数据的计算
		 * [4,3,-2,-7,8,2,3,1]
		 * [4,-3,-2,-7,8,2,3,1]
		 * [4,-3,-2,-7,8,2,-3,1]
		 * [4,-3,-2,-7,8,2,-3,-1]
		 * [4,-3,-2,-7,8,2,-3,-1]
		 * [4,-3,-2,-7,8,2,-3,-1]
		 * [-4,-3,-2,-7,8,2,-3,-1]
		 *
		 * 计算结束，数组的第五个，第六个依然为整数，证明 5,6 没有出现
		 * */
		List<Integer> ans = new ArrayList<>();
		
		return ans;
	}
	/*
	 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
	 * 返回重复了 N 次的那个元素。
	 * 
	 * 示例 1：
	 * 输入：[1,2,3,3]
	 * 输出：3
	 * 
	 * 示例 2：
	 * 输入：[2,1,2,5,3,2]
	 * 输出：2
	 * 
	 * 示例 3：
	 * 输入：[5,1,5,2,5,3,5,4]
	 * 输出：5 
	 * 
	 * 提示：
	 * 		4 <= A.length <= 10000
	 * 		0 <= A[i] < 10000
	 * 		A.length 为偶数
	 **/
	public static int repeatedNTimes(int[] A) {
        int N = A.length / 2;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            set.add(A[i]);
            sum += A[i];
        }
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
        	sum -= iterator.next();
        }
        return sum / (N -1);
    }
	/*分糖果2
	 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
	 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
	 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
	 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
	 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
	 * 
	 * 示例 1：
	 * 输入：candies = 7, num_people = 4
	 * 输出：[1,2,3,1]
	 * 解释：
	 * 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
	 * 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
	 * 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
	 * 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
	 * 
	 * 示例 2：
	 * 输入：candies = 10, num_people = 3
	 * 输出：[5,2,3]
	 * 解释：
	 * 第一次，ans[0] += 1，数组变为 [1,0,0]。
	 * 第二次，ans[1] += 2，数组变为 [1,2,0]。
	 * 第三次，ans[2] += 3，数组变为 [1,2,3]。
	 * 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
	 * */
	public static int[] distributeCandies(int candies, int num_people) {
		int[] ans = new int[num_people];
		int i = 0;       //数组索引
		int given = 1;   //初始给糖数量
		while(candies != 0) {
			ans[i] = given;
			candies -= given;
			given++;
			if(candies < given)
				given = candies;
			i++;
			if(i > ans.length - 1)
				i = 0;
		}
		return ans;
	}
	/*
	 * 写一个程序，输出从 1 到 n 数字的字符串表示。
	 * 
	 * 1. 如果 n 是3的倍数，输出“Fizz”；
	 * 2. 如果 n 是5的倍数，输出“Buzz”；
	 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
	 * 
	 * 示例：
	 * n = 15,

		返回:
		[
		    "1",
		    "2",
		    "Fizz",
		    "4",
		    "Buzz",
		    "Fizz",
		    "7",
		    "8",
		    "Fizz",
		    "Buzz",
		    "11",
		    "Fizz",
		    "13",
		    "14",
		    "FizzBuzz"
		]
	 * */
	public static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			if(i % 3 == 0 && i % 5 ==0) {
				list.add("FizzBuzz");
			}else if(i % 3 == 0)
				list.add("Fizz");
			else if(i % 5 ==0)
				list.add("Buzz");
			else 
				list.add(String.valueOf(i));
		}
		return list;
	}
}
