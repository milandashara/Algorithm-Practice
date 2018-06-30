package babylon;

/**
 * Created by milanashara on 5/20/17.
 *
 * Longest Zombie cluster
 */
public class Solution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int output = zombieCluster(new String[]{
                "1100",
                "1110",
                "0110",
                "0001"});



        System.out.println(output);




    }

    /*
     * Complete the function below.
     */
    static int zombieCluster(String[] zombies) {

        int N = zombies.length;

        int[][] matrix = new int [N][N];
        for(int i = 0; i<N; i++) {
            for (int j = 0 ; j<N; j++) {
                matrix[i][j] = Integer.parseInt(zombies[i].charAt(j) + "");
            }
        }

        boolean visited[] = new boolean[N];


        int count = 0;
        for (int i = 0; i < N; ++i) {
            if(!visited[i]) {
                dfs(i,matrix,visited);
                count++;
            }
        }
        return count;

    }

    public static void dfs(int i, int[][] matrix, boolean[] visited) {
        if(!visited[i]){
            visited[i] = true; // Mark node as "visited"


            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==1 && !visited[j]) {
                    dfs(j, matrix, visited); // Visit node
                }
            }
        }
    }





}
