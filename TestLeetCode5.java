package timu;

/**
 * LeetCode上递归，动态规划相关的题目
 * */
public class TestLeetCode5 {
	public static void main(String[] args) {
		int[] nums = new int[] {4, 1, 1, 9, 1};
		System.out.println(chooesNum(nums, 4));
	} 
	/*
	 * 在一个数组中选择不相邻的数，使得这些数想加最大
	 * 
	 * 例如：[4, 1, 1, 9, 1]
	 * 输出：13（选择4和9）
	 * */
	public static int chooesNum(int[] nums, int i) {
		//递归方程式：
		//opt(i) = max(选i的值， 不选i的值)， i表示数组的索引
		//         选i的值: opt(i - 2) + nums[i]
		//		   不选i的值: opt(i - 1)
		if(i == 0)
			return nums[0];
		else if (i == 1)
			return Math.max(nums[0], nums[1]);
		else {
			int A = chooesNum(nums, i - 2) + nums[i];
			int B = chooesNum(nums, i - 1);
			return Math.max(A, B);
		}
	}
	public static int chooesNum2(int[] nums) {
		//动态规划的思路求解
		//见下面打家劫舍代码
		return 0;
	}
	/**
	 * 0-1背包问题
	 * */
	
	/**打家劫舍：
	 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因
	 * 素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
	 * 
	 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
	 * 示例 1:
	 * 输入: [1,2,3,1]
	 * 输出: 4
	 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
	 * 偷窃到的最高金额 = 1 + 3 = 4 。
	 * 
	 * 示例 2:
	 * 输入: [2,7,9,3,1]
	 * 输出: 12
	 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
	 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
	 * */
	public static int rob(int[] nums) {
		int[] opt = new int[nums.length];
		opt[0] = nums[0];
		opt[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < nums.length; i++) {
			int A = opt[i - 2] + nums[i];
			int B = opt[i - 1];
			opt[i] = Math.max(A, B);
		}
		return opt[opt.length - 1];
	}
}
