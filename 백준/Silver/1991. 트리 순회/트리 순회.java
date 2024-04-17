import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        public void createNode(String a, String b, String c) {
            if (root == null) {
                root = new Node(a);
                if (!b.equals(".")) {
                    root.left = new Node(b);
                }
                if (!c.equals(".")) {
                    root.right = new Node(c);
                }
                return;
            }
            recursiveNode(root, a, b, c);
        }

        public void recursiveNode(Node n, String data, String left, String right) {
            if (n == null) return;
            if (n.data.equals(data)) {
                if (left.equals(".")) {
                    n.left = null;
                } else {
                    n.left = new Node(left);
                }
                if (right.equals(".")) {
                    n.right = null;
                } else {
                    n.right = new Node(right);
                }
                return;
            }
            recursiveNode(n.left, data, left, right);
            recursiveNode(n.right, data, left, right);
        }

        public void preOrderTraversal(Node node) {
            if (node != null) {
                sb.append(node.data);
                if (node.left != null) preOrderTraversal(node.left);
                if (node.right != null) preOrderTraversal(node.right);
            }
        }

        public void inOrderTraversal(Node node) {
            if (node != null) {
                if (node.left != null) inOrderTraversal(node.left);
                sb.append(node.data);
                if (node.right != null) inOrderTraversal(node.right);
            }
        }

        public void postOrderTraversal(Node node){
            if(node !=null){
                if(node.left != null) postOrderTraversal(node.left);
                if(node.right != null ) postOrderTraversal(node.right);
                sb.append(node.data);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeN = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < nodeN; i++) {
            String[] inNode = br.readLine().split(" ");
            tree.createNode(inNode[0], inNode[1], inNode[2]);
        }
        tree.preOrderTraversal(tree.root);
        sb.append("\n");
        tree.inOrderTraversal(tree.root);
        sb.append("\n");
        tree.postOrderTraversal(tree.root);
        System.out.println(sb);
    }
}
