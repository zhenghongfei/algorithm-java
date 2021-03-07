package alg.binarytree;

/**
 * <PRE>
 * 二叉树的遍历:遍历即将树的所有结点访问且仅访问一次
 * 按照根节点位置的不同分为：
 * <li>前序遍历:abdefgc
 * <li>中序遍历:debgfac
 * <li>后序遍历:edgfbca
 * <li>分层遍历:abcdfeg
 * 		  a
 * 		/   \
 *     b     c
 *   /   \  
 *  d     f
 *   \   /
 *    e g
 * </PRE>
 * 
 * @author Hongfei 2016年4月17日
 * @since 0.1
 */
public class TreeNode {
	public String val;
	public TreeNode left;
	public TreeNode right;

	TreeNode(String val) {
		this.val = val;
	}
}
