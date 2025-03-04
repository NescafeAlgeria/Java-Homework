import java.util.*;

///  Mitila Alin

public class GraphGenerator {
    private int n, k;
    private int[][] adjMatrix;
    private Random rand = new Random();

    public GraphGenerator(int n, int k) {
        this.n = n;
        this.k = k;
        this.adjMatrix = new int[n][n];
        generateRandomGraph();
    }

    private void generateRandomGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                adjMatrix[i][j] = adjMatrix[j][i] = rand.nextBoolean() ? 1 : 0;
            }
        }
        ensureClique(k);
        ensureStableSet(k);
    }

    private void ensureClique(int k) {
        List<Integer> cliqueNodes = getRandomNodes(k);
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                adjMatrix[cliqueNodes.get(i)][cliqueNodes.get(j)] = 1;
                adjMatrix[cliqueNodes.get(j)][cliqueNodes.get(i)] = 1;
            }
        }
    }

    private void ensureStableSet(int k) {
        List<Integer> stableNodes = getRandomNodes(k);
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                adjMatrix[stableNodes.get(i)][stableNodes.get(j)] = 0;
                adjMatrix[stableNodes.get(j)][stableNodes.get(i)] = 0;
            }
        }
    }

    private List<Integer> getRandomNodes(int k) {
        List<Integer> nodes = new ArrayList<>();
        while (nodes.size() < k) {
            int node = rand.nextInt(n);
            if (!nodes.contains(node)) {
                nodes.add(node);
            }
        }
        return nodes;
    }

    public void displayMatrix() {
        for (int[] row : adjMatrix) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "● " : "○ ");
            }
            System.out.println();
        }
    }

    public void displayGraphProperties() {
        int edges = 0;
        int[] degrees = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjMatrix[i][j] == 1) edges++;
            }
        }

        for (int i = 0; i < n; i++) {
            degrees[i] = Arrays.stream(adjMatrix[i]).sum();
        }

        int maxDegree = Arrays.stream(degrees).max().orElse(0);
        int minDegree = Arrays.stream(degrees).min().orElse(0);
        int sumDegrees = Arrays.stream(degrees).sum();

        System.out.println("Number of edges (m): " + edges);
        System.out.println("Max degree (ΔG): " + maxDegree);
        System.out.println("Min degree (δG): " + minDegree);
        System.out.println("Sum of degrees: " + sumDegrees);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        if (args.length != 2) {
            System.out.println("Usage: java GraphGenerator <n> <k>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        GraphGenerator graph = new GraphGenerator(n, k);

        graph.displayGraphProperties();
        if (n <= 100) {
            graph.displayMatrix();
        }
        else{
            long endTime   = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println("Elapsed time: " + elapsedTime + " ns");
        }

    }
}
