package trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;
import java.util.function.Predicate;

public class TreeTwoSumTwo {

    public int t2Sum(TreeNode A, int B) {
        return solve(A, B) ? 1 : 0;
    }

    private boolean solve(TreeNode root, int target) {
        Deque<TreeNode> leftStack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<>();
        TreeNode curLeft = root;
        TreeNode curRight = root;
        while (curLeft != null) {
            leftStack.push(curLeft);
            curLeft = curLeft.left;
        }
        while (curRight != null) {
            rightStack.push(curRight);
            curRight = curRight.right;
        }
        curLeft = leftStack.pop();
        curRight = rightStack.pop();
        while (curRight != curLeft) {
            if (curRight.val + curLeft.val == target) {
                return true;
            } else if (curRight.val + curLeft.val > target) {
                curRight = moveRight(curRight, rightStack);
            } else {
                curLeft = moveLeft(curLeft, leftStack);
            }
        }
        return false;
    }

    private TreeNode moveRight(TreeNode root, Deque<TreeNode> stack) {
        return move(root, stack, r -> r.left != null, r -> r.left, r -> r.right);
    }

    private TreeNode moveLeft(TreeNode root, Deque<TreeNode> stack) {
        return move(root, stack, r -> r.right != null, r -> r.right, r -> r.left);
    }

    private TreeNode move(TreeNode root, Deque<TreeNode> stack, Predicate<TreeNode> pred,
                          Function<TreeNode, TreeNode> initMove, Function<TreeNode, TreeNode> fartherMove) {
        if (pred.test(root)) {
            root = initMove.apply(root);
            while (root != null) {
                stack.push(root);
                root = fartherMove.apply(root);
            }
        }
        return stack.pop();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
