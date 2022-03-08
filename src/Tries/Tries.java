package Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        ;
        Trie trie = new Trie();
        while (t-- > 0) {
            String str = sc.next();
            trie.insert(str);
        }

//        int  q= sc.nextInt();
//
//        while (q-- > 0) {
//            String search = sc.next();
//            System.out.println("String "+search+" is "+(trie.search(search) ? "present" : "not present")+" in Trie");
//        }

        String pre = sc.next();
        trie.print_strings_with_prefix(pre);
    }

    static class Node {
        Character ch; // Data of trie
        boolean isTerminal; // Check whether it's last node of nay word
        HashMap<Character, Node> children; // Map that store children with key as child and value as it's child Node location

        public Node(Character ch) {
            this.ch = ch;
            this.isTerminal = false;
            this.children = new HashMap<>();
        }
    }

    static class Trie {
        Node root;

        public Trie() {
            this.root = new Node('\0');
        }

        void insert(String str) {
            Node temp = root;

            for (int i = 0; i < str.length(); i++) {

                Character ch = str.charAt(i);

                if (temp.children.containsKey(ch) == true) {
//                    When child get found in root node i.e it's present
                    temp = temp.children.get(ch); // This means we are moving to it's children address
                } else {
//                    if child is not found in root node

                    Node newNode = new Node(ch);
                    temp.children.put(ch, newNode);
                    temp = newNode;
                }
            }

            temp.isTerminal = true;
            return;
        }

        boolean search(String str) {
            Node temp = root;

            for (int i = 0; i < str.length(); i++) {

                Character ch = str.charAt(i);

                if (temp.children.containsKey(ch) == true) {
//                    When child get found in root node i.e it's present
                    temp = temp.children.get(ch); // This means we are moving to it's children address
                } else {
//                    if child is not found in root node then there is no word exist
                    return false;
                }
            }

            return temp.isTerminal;
        }

        void print_strings_with_prefix(String pre) {
            Node temp = root;

            for (int i = 0; i < pre.length(); i++) {
                Character ch = pre.charAt(i);

                if (temp.children.containsKey(ch)) {
                    temp = temp.children.get(ch);
                } else {
                    return;
                }
            }

            dfs(temp, pre, "");


        }

        void dfs(Node root, String pre, String output) {
            if (root == null)
                return;

            if (root.isTerminal == true)
                System.out.println(pre + output);

            for (Map.Entry<Character, Node> child : root.children.entrySet()) {
                dfs(child.getValue(), pre, output + child.getKey());
            }
        }
    }

}
