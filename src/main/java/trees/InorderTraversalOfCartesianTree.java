package trees;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InorderTraversalOfCartesianTree {

    public TreeNode buildTree(ArrayList<Integer> inorder) {
        TreeMap<Integer, Integer> treeMap = IntStream.range(0, inorder.size())
                .boxed()
                .collect(Collectors.toMap(inorder::get, Function.identity(), (a, b) -> a, TreeMap::new));
        return solve(treeMap);
    }

    private TreeNode solve(TreeMap<Integer, Integer> map) {
        if (map.isEmpty()) {
            return null;
        }
        Map.Entry<Integer, Integer> rootValue = map.pollLastEntry();

        Map<Boolean, TreeMap<Integer, Integer>> partitionedMap = map.keySet().stream()
                .collect(Collectors.partitioningBy(key -> map.get(key) < rootValue.getValue(),
                        Collectors.toMap(Function.identity(), map::get,
                                (a, b) -> a,
                                TreeMap::new)));

        TreeNode root = new TreeNode(rootValue.getKey());
        root.left = solve(partitionedMap.get(true));
        root.right = solve(partitionedMap.get(false));
        return root;
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
