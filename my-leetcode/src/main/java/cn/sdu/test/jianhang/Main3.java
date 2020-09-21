package cn.sdu.test.jianhang;

import java.util.*;

/**
 * 二叉树异或最大值
 *
 * @author icatzfd
 * Created on 2020/9/9 19:15.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Tree> map = new HashMap();
        Tree root = null;
        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            int weight = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();

            Tree tree;
            if (!map.containsKey(id)) {
                tree = new Tree();
                tree.setId(id);
                tree.setWeight(weight);
                map.put(id, tree);
            } else {
                tree = map.get(id);
            }

            tree.setWeight(weight);

            if (i==0) {
                root = tree;
            }
            if (!map.containsKey(left)) {
                if (left == -1) {
                    tree.left = null;
                } else {
                    Tree leftTree = new Tree();
                    leftTree.setId(left);
                    map.put(left, leftTree);
                    tree.left = leftTree;
                }
            }

            if (!map.containsKey(right)) {
                if (right == -1) {
                    tree.right = null;
                } else {
                    Tree rightTree = new Tree();
                    rightTree.setId(right);
                    map.put(right, rightTree);
                    tree.right = rightTree;
                }

            }
        }

        List<List<Tree>> res = new ArrayList<>();
        List<Tree> path = new ArrayList<>();

        Map<Integer, Integer> rootValue = new HashMap<>();
        traversal(root, res, path);
        System.out.println(res);
        int max = Integer.MIN_VALUE;
        for (List<Tree> ph : res) {
            for (int j = 0; j < ph.size(); j++) {
                int temp = ph.get(j).getWeight();
                for (int k = j + 1; k < ph.size(); k++) {
                    temp ^= ph.get(k).getWeight();
                    max = Math.max(max, temp);
                }
            }
        }
        System.out.println(max);
    }

    public static void traversal(Tree root, List<List<Tree>> res, List<Tree> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        path.add(root);
        if (root.left != null) {
            traversal(root.left, res, path);
        }
        if (root.right != null) {
            traversal(root.right, res, path);
        }
        path.remove(path.size() - 1);
    }
}

class Tree {
    int id;
    int weight;
    Tree left;
    Tree right;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
