package answers;

public class Question6 {

	static int minDistance(int dist[], Boolean sptSet[], int nV) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
        for (int v = 0; v < nV; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
        return min_index; 
    } 

    public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
    	//dijikstra
    	
    	int dist[] = new int[numServers]; 
		Boolean vis[] = new Boolean[numServers];

		for (int i = 0; i < numServers; i++) {
			dist[i] = Integer.MAX_VALUE;
			vis[i] = false;
		}

		dist[0] = 0;

		for (int i = 0; i < numServers - 1; i++) {

			int u = minDistance(dist, vis, numServers);

			vis[u] = true;

			for (int j = 0; j < numServers; j++)
				if (!vis[j] && dist[u] != Integer.MAX_VALUE && dist[u] + times[u][j] < dist[j])
					dist[j] = dist[u] + times[u][j];
		}

		return dist[targetServer];
	}

}
