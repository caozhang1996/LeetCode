package timu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.css.Rect;

//leetCode上的数字相关题目
public class TestLeetCode4 {
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3};
		System.out.println(minMoves(nums));
	}
	/*
	 * 自除数 是指可以被它包含的每一位数除尽的数。
	 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
	 * 还有，自除数不允许包含 0 。
	 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
	 * 
	 * 示例 1：
	 * 输入： 
	 * 上边界left = 1, 下边界right = 22
	 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
	 * 
	 * 注意：
	 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
	 * */
	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> nums = new ArrayList<>();
        for(int i = left; i <= right; i++) {
        	int count = 0;
        	String str = String.valueOf(i);
        	for(int j = 0; j < str.length(); j++) {
        		int x = Integer.parseInt(str);
        		int y = Integer.parseInt(String.valueOf(str.charAt(j)));
        		if(y == 0)
        			continue;
        		if(x % y == 0)
        			count++;
        	}
        	if(count == str.length())
        		nums.add(Integer.parseInt(str));
        }
		return nums;
    }
	/*
	 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
	 * 
	 * 示例:
	 * 输入: 38
	 * 输出: 2 
	 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
	 * */
	public static int addDigits(int num) {
//		//暴力遍历法
//		int sum;
//		while(num >= 10) {
//			sum = 0;
//			while(num != 0) {
//				int temp = num % 10;
//				sum += temp;
//				num /= 10;
//			}
//			num = sum;
//		}
//		return num;
		
		
		//找规律
		if(num > 9) {
			  num=num%9;
	            if(num==0)
	            	return 9;
		}
		return num;
	}
	/*
	 * 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
	 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
	 * 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
	 * 投影就像影子，将三维形体映射到一个二维平面上。
	 * 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
	 * 返回所有三个投影的总面积。 
	 * 
	 * 示例 1：
	 * 输入：[[2]]
	 * 输出：5
	 * 
	 * 示例 2：
	 * 输入：[[1,2],[3,4]]
	 * 输出：17
	 * */
	public static int projectionArea(int[][] grid) {
		int xyArea = 0, yzArea = 0, zxArea = 0;    //分别表示在三个平面的投影
		int[][] temp = new int[grid.length][grid.length];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
				if(grid[i][j] != 0)
					xyArea++;
				temp[i][j] = grid[j][i];
			}
			zxArea += maxOfArray(grid[i]);		
		}
		for(int i = 0; i < temp.length; i++) {
			yzArea += maxOfArray(temp[i]);
		}
		return xyArea + yzArea + zxArea;
	}
	public static int maxOfArray(int[] a) {
		int max = a[0];
		for(int i = 1; i < a.length; i++) {
			if(a[i] > max)
				max = a[i];
		}
		return max;
	}
	/*
	 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。 
	 * 如果没有两个连续的 1，返回 0 。
	 * 
	 * 示例 1：
	 * 输入：22
	 * 输出：2
	 * 解释：
	 * 22 的二进制是 0b10110 。
	 * 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
	 * 第一对连续的 1 中，两个 1 之间的距离为 2 。
	 * 第二对连续的 1 中，两个 1 之间的距离为 1 。
	 * 答案取两个距离之中最大的，也就是 2 。
	 * 
	 * 示例 2：
	 * 输入：5
	 * 输出：2
	 * 解释：
	 * 5 的二进制是 0b101 。
	 * 
	 * 示例 3：
	 * 输入：6
	 * 输出：1
	 * 解释：
	 * 6 的二进制是 0b110 。
	 * 
	 * 示例 4：
	 * 输入：8
	 * 输出：0
	 * 解释：
	 * 8 的二进制是 0b1000 。
	 * 在 8 的二进制表示中没有连续的 1，所以返回 0 。
	 * 
	 * 提示：
	 * 1 <= N <= 10^9
	 * */
	public static int binaryGap(int N) {
		StringBuilder sB= new StringBuilder();
		while(N != 0) {
			int temp = N % 2;
			N = N / 2;
			sB.append(temp);
		}
		List<Integer> index = new ArrayList<>();
		for(int i = 0; i < sB.length(); i++) {
			if(sB.charAt(i) == '1')
				index.add(i);
		}
		if(index.size() == 1)
			return 0;
		int max = index.get(index.size() - 1) - index.get(index.size() - 2);
		for(int i = index.size() - 1; i >=0; i--) {
			if(i >=1 && (max < index.get(i) - index.get(i - 1)))
				max = index.get(i) - index.get(i - 1);
		}
		return max;
	}
	/*
	 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
	 * 
	 * 示例:
	 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
	 * 输出: 2
	 * 
	 * 注意:
	 * 	3 <= points.length <= 50.
	 * 	不存在重复的点。
	 * 	-50 <= points[i][j] <= 50.
	 *  结果误差值在 10^-6 以内都认为是正确答案。
	 * */
	public static double largestTriangleArea(int[][] points) {
		//使用坐标公式计算三角形的面积： S = |(x1 · y2 - x2 · y1) + (x2 · y3 - x3 · y2) + (x3 · y1 - x1 · y3)| / 2
		//三层暴力循环
		double area = 0;
		for(int i = 0; i < points.length; i++) {
			for(int j = i + 1; j < points.length; j++) {
				for(int k = j + 1 ; k < points.length; k++) {
					area = Math.max(area, Math.abs(points[i][0] * points[j][1] - points[j][0] * points[i][1] +
							points[j][0] * points[k][1] - points[k][0] * points[j][1] + 
							points[k][0] * points[i][1] - points[i][0] * points[k][1]) / 2.0);
				}
			}
		}
		return area;
	}
	
	/*
	 * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进
	 * 制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
	 * 
	 * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
	 * 给定十进制数 N，返回其二进制表示的反码所对应的十进制整数。
	 * 
	 * 示例 1：
	 * 输入：5
	 * 输出：2
	 * 解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
	 * 
	 * 示例 2：
	 * 输入：7
	 * 输出：0
	 * 解释：7 的二进制表示为 "111"，其二进制反码为 "000"，也就是十进制中的 0 。
	 * 
	 * 示例 3：
	 * 输入：10
	 * 输出：5
	 * 解释：10 的二进制表示为 "1010"，其二进制反码为 "0101"，也就是十进制中的 5 。
	 * */
	public static int bitwiseComplement(int N) {
		if(N == 0)
			return 1;
		StringBuilder sB= new StringBuilder();
		while(N != 0) {
			int temp = N % 2;
			N = N / 2;
			sB.append(temp);
		}
		char[] arary = sB.reverse().toString().toCharArray();
		for(int i = 0; i < arary.length; i++) {
			if(arary[i] == '1')
				arary[i] = '0';
			else if (arary[i] == '0')
				arary[i] = '1';
		}
		int num = 0;
		for(int i = 0; i < arary.length; i++) {
			num += (arary[i] - '0') * Math.pow(2, arary.length - 1 -i);
		}
		return num;
	}
	/*
	 * 编写一个算法来判断一个数是不是“快乐数”。
	 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个
	 * 过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
	 * 
	 * 示例: 
	 * 输入: 19
	 * 输出: true
	 * 
	 * 解释: (^表示平方)
	 * 1^2 + 9^2 = 82
	 * 8^2 + 2^2 = 68
	 * 6^2 + 8^2 = 100
	 * 1^2 + 0^2 + 0^2 = 1
	 * */
	public static boolean isHappy(int n) {             //递归的思想
		//找到规律：1-9中只有1和7是“快乐数”，其他均不是“快乐数”， 故若当前的n等于1或7，则直接返回true;
		//否则，若n < 10，且不等于1或7，则直接返回false。
		if(n == 1 || n == 7)
			return true;
		if(n < 10)
			return false;
		
		int sum = 0;
		while(n > 0) {
			int d = n % 10;
			sum += d * d;
			n = n / 10;
		}
		return isHappy(sum);
	}
	/*
	 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
	 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
	 * 请你返回最终形体的表面积。
	 * 
	 * 示例 1：
	 * 输入：[[2]]
	 * 输出：10
	 * 
	 * 示例 2：
	 * 输入：[[1,2],[3,4]]
	 * 输出：34
	 * 
	 * 示例 3：
	 * 输入：[[1,0],[0,2]]
	 * 输出：16
	 * 
	 * 示例 4：
	 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
	 * 输出：32
	 * 
	 * 示例 5：
	 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
	 * 输出：46
	 * 
	 * 提示：
	 * 1 <= N <= 50
	 * 0 <= grid[i][j] <= 50
	 * */
	public int surfaceArea(int[][] grid) {
		int length = grid.length; 
		int surface1 = 0; //记录每个位置上组合立方体的表面积 
		int surface2 = 0; //记录每个位置上组合立方体的邻接面积 
		for (int i = 0; i < length; i++) { 
			for (int j = 0; j < length; j++) { 
				if (grid[i][j] != 0) { 
					surface1 += grid[i][j] * 4 + 2; //记录当前位置上组合立方体的表面积 
					} 
				if (i != length - 1) { 
					surface2 += (grid[i][j] > grid[i + 1][j] ? grid[i + 1][j] : grid[i][j]) * 2; //记录 i 行与 i + 1 行的邻接面积 
					surface2 += (grid[j][i] > grid[j][i + 1] ? grid[j][i + 1] : grid[j][i]) * 2; //记录 i 列与 i + 1 列的邻接面积
					} 
				} 
			} 
		return surface1 - surface2; 
	}
	/*
	 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
	 * 
	 * 示例 1:
	 * 输入: [3,0,1]
	 * 输出: 2
	 * 
	 * 示例 2:
	 * 输入: [9,6,4,2,3,5,7,0,1]
	 * 输出: 8
	 * */
	public static int missingNumber(int[] nums) {
		Arrays.sort(nums);
		if(nums.length == 1)
            if(nums[0] == 0)
                return 1;
            if(nums[0] == 1)
                return 0;
        if(nums[nums.length - 1] != nums.length)
        	return nums.length;
        if(nums[0] != 0)
        	return 0;
		int ans = 0;
		for(int i = 0; i < nums.length; i++) {
			if(i != nums.length - 1 && (nums[i] + 1 != nums[i + 1])) {
				ans = nums[i] + 1;
			}
		}
		return ans;
	}
	/*
	 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
	 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i 
	 * < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
	 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
	 * 
	 * 示例 1:
	 * 输入: 
	 * m = 3, n = 3
	 * operations = [[2,2],[3,3]]
	 * 输出: 4
	 * 解释: 
	 * 初始状态, M = 
	 * [[0, 0, 0],
	 *  [0, 0, 0],
	 *  [0, 0, 0]]
	 * 
	 * 执行完操作 [2,2] 后, M = 
	 * [[1, 1, 0],
	 *  [1, 1, 0], 
	 *  [0, 0, 0]]
	 *  
	 * 执行完操作 [3,3] 后, M =  
	 * [[2, 2, 1], 
	 *  [2, 2, 1],
	 *  [1, 1, 1]]
	 * M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
	 * 
	 * 注意:
	 * 	m 和 n 的范围是 [1,40000]。
	 *  a 的范围是 [1,m]，b 的范围是 [1,n]。
	 *  操作数目不超过 10000。
	 * */
	public static int maxCount(int m, int n, int[][] ops) {
		//又一个脑筋急转弯。。每次操作都是左上角区域从（0, 0）到（a, b）的矩形，必定重叠，所以找最小的a乘最小的b就行
		for (int i = 0; i < ops.length; i++) {
            int[] op = ops[i];
            int rows = op[0] ;
            int columns = op[1] ;
            if (m > rows)
                m = rows;
            if (n > columns)
                n = columns;
        }
        return m * n;
	}
	/*
	 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
	 * 
	 * 示例 1:
	 * 输入: 1
	 * 输出: true
	 * 解释: 20 = 1
	 * 
	 * 示例 2:
	 * 输入: 16
	 * 输出: true
	 * 解释: 2^4 = 16
	 * 
	 * 示例 3:
	 * 输入: 218
	 * 输出: false
	 * */
	public static boolean isPowerOfTwo(int n) {
		if(n == 0)
			return false;
		if(n == 1)
			return true;
		while(n != 1) {
			int temp = n % 2;
			n = n / 2;
			if(temp != 0)
				return false;
		}
		return true;
	}
	/*
	 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
	 * 
	 * 示例 1:
	 * 输入: [1,2,3]
	 * 输出: 6
	 * 
	 * 示例 2:
	 * 输入: [1,2,3,4]
	 * 输出: 24
	 * 
	 * 注意:
	 * 给定的整型数组长度范围是[3,10^4]，数组中所有的元素范围是[-1000, 1000]。
	 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
	 * */
	public static int maximumProduct(int[] nums) {
		 Arrays.sort(nums);//排序 
		 int a=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];  //最大的三个数 
		 int b=nums[0]*nums[1]*nums[nums.length-1];                          //两个大负数乘一一个最大正数
		 return a>b?a:b;
	}
	/*
	 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
	 * 
	 * 示例 1:
	 * 输入: 27
	 * 输出: true
	 * 
	 * 示例 2:
	 * 输入: 0
	 * 输出: false
	 * 
	 * 示例 3:
	 * 输入: 9
	 * 输出: true
	 * 
	 * 示例 4:
	 * 输入: 45
	 * 输出: false
	 * 
	 * 进阶：
	 * 你能不使用循环或者递归来完成本题吗？
	 * */
	public static boolean isPowerOfThree(int n) {
		if(n == 0)
			return false;
		if(n == 1)
			return true;
		while(n != 1) {
			int temp = n % 3;
			n = n / 3;
			if(temp != 0)
				return false;
		}
		return true;
	}
	/*
	 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
	 * 说明：不要使用任何内置的库函数，如  sqrt。
	 * 
	 * 示例 1：
	 * 输入：16
	 * 输出：True
	 * 
	 * 示例 2：
	 * 输入：14
	 * 输出：False
	 * */
	public static boolean isPerfectSquare(int num) {
//		if(num == 0 || num == 1)        //这种解法耗时太长（遍历判断）
//			return true;
//		
//		for(int i = 1; i <= num / 2; i++) {
//			if(i * i == num) {
//				return true;
//			}
//		}
//		return false;
		
		//公式法：
		//利用 1+3+5+7+9+…+(2n-1)=n^2，即完全平方数肯定是前n个连续奇数的和
		int i=1;
        while(num>0)
        {
            num-=i;
            i+=2;
        }
        return num==0;
	}
	/*
	 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
	 * 
	 * 示例 1:
	 * 输入: 3
	 * 输出: 0
	 * 解释: 3! = 6, 尾数中没有零。
	 * 
	 * 示例 2:
	 * 输入: 5
	 * 输出: 1
	 * 解释: 5! = 120, 尾数中有 1 个零.
	 * 
	 * 说明: 你算法的时间复杂度应为 O(log n) 。
	 * */
	public static int trailingZeroes(int n) {
		
		return 0;
	}
	/*
	 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
	 * 
	 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
	 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
	 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
	 * 
	 * 示例 1：
	 * 输出："IDID"
	 * 输出：[0,4,1,3,2]
	 * 
	 * 示例 2：
	 * 输出："III"
	 * 输出：[0,1,2,3]
	 * 
	 * 示例 3：
	 * 输出："DDI"
	 * 输出：[3,2,0,1]
	 * 
	 * 提示：
	 * 1 <= S.length <= 1000
	 * S 只包含字符 "I" 或 "D"。
	 * * */
	public static int[] diStringMatch(String S) {
		int N = S.length();
		int n = 0;
		int [] ans = new int[S.length() + 1];
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == 'I') {
				ans[i] = n++;
			}else if (S.charAt(i) == 'D') {
				ans[i] = N--;
			}
		}
		ans[ans.length - 1] = N;
		return ans;
	}
	/*
	 * 给定一个Excel表格中的列名称，返回其相应的列序号。
	 * 
	 * 例如，
	 * A -> 1
	 * B -> 2
	 * C -> 3
	 * ...
	 * Z -> 26
	 * AA -> 27
	 * AB -> 28 
	 * ...
	 * 
	 * 示例 1:
	 * 输入: "A"
	 * 输出: 1
	 * 
	 * 示例 2:
	 * 输入: "AB"
	 * 输出: 28
	 * 
	 * 示例 3:
	 * 输入: "ZY"
	 * 输出: 701
	 * */
	public static int name(String s) {
		//该题目的意思其实就是26进制转十进制，其中1~26分别用A~Z表示，其实就是个进制转化问题
		int ans = 0;
		int n = s.length() - 1; //阶数
		for(int i = 0; i < s.length(); i++) {
			ans += Math.pow(26, n--) * (s.charAt(i) - 'A' + 1); //先执行，后减减
		}
		return ans;
	}
	/*
	 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
	 * 
	 * 如果不能形成任何面积不为零的三角形，返回 0。
	 * 
	 * 示例 1：
	 * 输入：[2,1,2]
	 * 输出：5
	 * 
	 * 示例 2：
	 * 输入：[1,2,1]
	 * 输出：0
	 * 
	 * 示例 3：
	 * 输入：[3,2,3,4]
	 * 输出：10
	 * 
	 * 示例 4：
	 * 输入：[3,6,2,3]
	 * 输出：8
	 * 
	 * 提示：
	 * 3 <= A.length <= 10000
	 * 1 <= A[i] <= 10^6
	 * */
	public static int largestPerimeter(int[] A) {
		Arrays.sort(A);    //先将数组A按升序排序
		for(int i= A.length - 1; i >= 0; i--) {
			if((i - 2 >= 0) && (A[i - 1] + A[i - 2] > A[i] && A[i - 1] + A[i] > A[i - 2] && A[i] + A[i - 2] > A[i - 1])) {
				return A[i] + A[i - 1] + A[i - 2];
			}
		}
		return 0;
	}
	/*
	 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
	 * 
	 * 示例:
	 * 输入:
	 * [1,2,3]
	 * 输出:3
	 * 
	 * 解释:
	 * 只需要3次移动（注意每次移动会增加两个元素的值）：
	 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
	 * */
	public static int minMoves(int[] nums) {
		//已知：长度为n的数组nums， 每次移动有n-1个元素增加1
		//求：数组元素都相等时，最小移动次数x
		//假设所有元素都相等时数字为k, 如果最小数字经过x次移动能够等于k, 则此时所有元素也能等于k, 此时移动次数为k-min(nums).
        //则有方程: 数组元素总和增加量 = 终止时数组元素总和 - 开始时数组元素总和
        //即方程: (k-min(nums)) * (n-1) = k * n - sum(nums)
        //求解后: k = sum(nums) - min(nums) * (n-1)
        //则可以得到最小移动次数  k-min(nums)
		int min = nums[0];
        for (int i = 0;i < nums.length; i++){
             min = min > nums[i]? nums[i] : min;
        }
        int count = 0;
        for (int item:nums){
        	count += (item-min);     //k-min(nums) = sum(nums) - n * min(nums)也就等于n个item - min累加
        }
        return count;
	}
	/*
	 * 编写一个程序判断给定的数是否为丑数。
	 * 丑数就是只包含质因数 2, 3, 5 的正整数。
	 * 
	 * 示例 1:
	 * 输入: 6
	 * 输出: true
	 * 解释: 6 = 2 × 3
	 * 
	 * 示例 2:
	 * 输入: 8
	 * 输出: true
	 * 解释: 8 = 2 × 2 × 2
	 * 
	 * 示例 3:
	 * 输入: 14
	 * 输出: false 
	 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
	 * 
	 * 说明：
	 * 	1 是丑数。
	 * 	输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
	 * */
	public static boolean isUgly(int num) {
		if(num == 0)
			return false;
		while(num != 1) {
			if(num % 2 == 0)
				num /= 2;
			else if(num % 3 == 0)
				num /= 3;
			else if(num % 5 == 0)
				num /= 5;
			else
				return false;
		}
		return true;
	}
	/*
	 * 除数博弈：
	 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
	 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
	 * 		选出任一 x，满足 0 < x < N 且 N % x == 0 。
	 * 		用 N - x 替换黑板上的数字 N 。
	 * 如果玩家无法执行这些操作，就会输掉游戏。
	 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
	 * 
	 * 示例 1：
	 * 输入：2
	 * 输出：true
	 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
	 * 
	 * 示例 2：
	 * 输入：3
	 * 输出：false
	 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
	 * 
	 * 提示：
	 * 		1 <= N <= 1000
	 * */
	public static boolean divisorGame(int N) {
		//1.数字N如果是奇数，它的因数必然都是奇数；若为偶数，则其因数可奇可偶。
		//2.无论N初始为多大的值，游戏最终只会进行到N=2时结束，那么谁轮到N=2时谁就会赢。
	    //3.因为爱丽丝先手，N初始若为偶数，爱丽丝则只需一直选1，使鲍勃一直面临N为奇数的情况，这样爱丽丝稳赢； 
		//  N初始若为奇数，那么爱丽丝第一次选完之后N必为偶数，那么鲍勃只需一直选1就会稳赢。
		//综述，判断N是奇数还是偶数，即可得出最终结果！
		return N % 2 == 0;
	}
	
}
