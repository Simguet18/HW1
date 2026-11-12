public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        int n = m.length;

        //path to itself is 0
        if (i == j) {
          return 0;
        }

        //Queue using array
        int[] queue = new int[n];
        int head = 0;
        int tail = 0;

        //Distances tracking array
        int[] distances = new int[n];
        for (int k = 0; k < n; k++) {
            distances[k] = -1; // -1 means "unvisited"
        }

        // Initialize the start node (vertex i)
        queue[tail] = i;
        tail++;
        distances[i] = 0;

        // BFS loop
        while (head < tail) {
            int current = queue[head];
            head++;

            // Loop through all possible neighbors of 'current'
            for (int neighbor = 0; neighbor < n; neighbor++) {
            
                // Is there an edge AND is it unvisited?
                if (m[current][neighbor] == 1 && distances[neighbor] == -1) {
                
                    // The distance is 1 more than the current node's distance
                    distances[neighbor] = distances[current] + 1;
                
                    // If this neighbor is our target (vertex j), done.
                    if (neighbor == j) {
                        return distances[neighbor];
                    }
                
                
                    // Otherwise, add it to the queue to explore its neighbors later
                    queue[tail] = neighbor;
                    tail++;
                }
            }
        }

    // 6. If the loop finishes and we never found the destination
    return -1;
}


    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}