package leetCode.notLeetCode;

import java.util.*;

/**
 * find the maximum number of connected nodes of the same color in a colored matrix
 * <p>
 * 1 1 1 0 0
 * 1 2 1 2 2
 * 1 1 2 1 0
 * 0 2 2 0 0
 * <p>
 * answer is 7. This group of ones:
 * <p>
 * 1 1 1 x x
 * 1 x 1 x x
 * 1 1 x x x
 * x x x x x
 */
public class TechLeadColorMatrix {

    private static Set<Node> visitedNodes = new HashSet<>();

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{0, 1, 1},
                new int[]{1, 1, 1},
                new int[]{0, 1, 3},
        };
        System.out.println(findMaxConnectedOfTheSameColor(grid));
    }

    private static int findMaxConnectedOfTheSameColor(int[][] grid) {
        int ny = grid.length;
        int nx = grid[0].length;

        int currentMax = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                Node currentNode = new Node(x, y, grid[y][x]);
                if (!visitedNodes.contains(currentNode)) {
                    int n = calculateConnectedColors(currentNode, grid, nx, ny);
                    if (n > currentMax) {
                        currentMax = n;
                    }
                }
            }
        }
        return currentMax;
    }

    private static int calculateConnectedColors(Node currentNode, int[][] grid, int nx, int ny) {
        int numberOfNodes = 1;
        Queue<Node> nodes = new ArrayDeque<>();
        visitedNodes.add(currentNode);
        List<Node> notVisitedNeighbours = getNotVisitedOfSameColor(currentNode, grid, nx, ny);

        nodes.addAll(notVisitedNeighbours);

        while (!nodes.isEmpty()) {
            numberOfNodes++;
            nodes.addAll(getNotVisitedOfSameColor(nodes.poll(), grid, nx, ny));
        }

        return numberOfNodes;
    }

    @SuppressWarnings("Duplicates")
    private static List<Node> getNotVisitedOfSameColor(Node node, int[][] grid, int nx, int ny) {

        List<Node> nodes = new ArrayList<>();

        int xMin1 = node.getX() - 1;
        int yMin1 = node.getY() - 1;

        int xPlus1 = node.getX() + 1;
        int yPlus1 = node.getY() + 1;

        int y = node.getY();
        int x = node.getX();
        if (xMin1 >= 0) {
            Node candidateNode = new Node(xMin1, y, grid[y][xMin1]);
            if (checkNotVisitedAndSameColor(candidateNode, node, visitedNodes)) {
                nodes.add(candidateNode);
                visitedNodes.add(candidateNode);
            }
        }
        if (yMin1 >= 0) {
            Node candidateNode = new Node(x, yMin1, grid[yMin1][x]);
            if (checkNotVisitedAndSameColor(candidateNode, node, visitedNodes)) {
                nodes.add(candidateNode);
                visitedNodes.add(candidateNode);
            }
        }
        if (xPlus1 < nx) {
            Node candidateNode = new Node(xPlus1, y, grid[y][xPlus1]);
            if (checkNotVisitedAndSameColor(candidateNode, node, visitedNodes)) {
                nodes.add(candidateNode);
                visitedNodes.add(candidateNode);
            }
        }
        if (yPlus1 < ny) {
            Node candidateNode = new Node(x, yPlus1, grid[yPlus1][x]);
            if (checkNotVisitedAndSameColor(candidateNode, node, visitedNodes)) {
                nodes.add(candidateNode);
                visitedNodes.add(candidateNode);
            }
        }
        return nodes;
    }

    private static boolean checkNotVisitedAndSameColor(Node candidateNode, Node node, Set<Node> visitedNodes) {
        if (node.getColor() != candidateNode.getColor()) {
            return false;
        }
        if (visitedNodes.contains(candidateNode)) {
            return false;
        }
        return true;
    }
}

class Node {

    private final int x;
    private final int y;
    private final int color;

    Node(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node node = (Node) o;

        if (x != node.x) {
            return false;
        }
        if (y != node.y) {
            return false;
        }
        return color == node.color;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + color;
        return result;
    }
}
