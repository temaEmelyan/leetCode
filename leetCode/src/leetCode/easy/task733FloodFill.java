package leetCode.easy;

import java.util.*;

public class task733FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int originalColor = image[sr][sc];

        if (originalColor == newColor) {
            return image;
        }

        Queue<Node> nodeQ = new ArrayDeque<>();
        nodeQ.add(new Node(sr, sc));

        while (!nodeQ.isEmpty()) {
            Node currentNode = nodeQ.poll();
            nodeQ.addAll(getNeighbourNodesOfOriginalColor(image, currentNode, originalColor));
            image[currentNode.r][currentNode.c] = newColor;
        }
        return image;
    }

    private static Collection<? extends Node> getNeighbourNodesOfOriginalColor(int[][] image, Node currentNode, int originalColor) {
        int c = currentNode.c;
        int r = currentNode.r;
        int nr = image.length;
        int nc = image[0].length;

        List<Node> nodes = new ArrayList<>();

        if (c - 1 >= 0 && image[r][c - 1] == originalColor) {
            nodes.add(new Node(r, c - 1));
        }
        if (r - 1 >= 0 && image[r - 1][c] == originalColor) {
            nodes.add(new Node(r - 1, c));
        }
        if (c + 1 < nc && image[r][c + 1] == originalColor) {
            nodes.add(new Node(r, c + 1));
        }
        if (r + 1 < nr && image[r + 1][c] == originalColor) {
            nodes.add(new Node(r + 1, c));
        }
        return nodes;
    }

    static class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
