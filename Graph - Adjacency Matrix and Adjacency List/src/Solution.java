import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // Sample Input
    // No. Of Vertices: 5
    // No. Of Edges: 6
    // Source & Destination:
    // 3 5
    // 5 4
    // 5 1
    // 4 1
    // 4 2
    // 2 1

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Vertices:");
        int v = sc.nextInt();
        System.out.println("Enter Number of Edges:");
        int e = sc.nextInt();

        int[][] adjacencyMatrix = new int[v+1][v+1];
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            System.out.println("Enter Source:");
            int source = sc.nextInt();
            System.out.println("Enter Destination:");
            int dest = sc.nextInt();

            addEdge(adjacencyMatrix, source, dest);
            addEdge(adjacencyList, source, dest);
        }

        sc.close();

        printAdjacencyMatrix(adjacencyMatrix);
        printAdjacencyList(adjacencyList);
    }

    static void addEdge(int[][] adjacencyMatrix, int source, int dest) {
        adjacencyMatrix[source][dest] = 1;
        adjacencyMatrix[dest][source] = 1;
    }

    static void addEdge(List<List<Integer>> adjacencyList, int source, int dest) {
        adjacencyList.get(source).add(dest);
        adjacencyList.get(dest).add(source);
    }

    private static void printAdjacencyMatrix(int[][] adjacencyMatrix) {
        System.out.println("Adjacency Matrix");

        for (int i = 1; i < adjacencyMatrix.length; i++) {
            for (int j = 1; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printAdjacencyList(List<List<Integer>> adjacencyList) {
        System.out.println("Adjacency List");

        for (int i = 1; i < adjacencyList.size(); i++) {
            System.out.print(i + " ");
            List<Integer> list = adjacencyList.get(i);
            for (int n : list) {
                System.out.print("-> " + n);
            }
            System.out.println();
        }
    }
}
