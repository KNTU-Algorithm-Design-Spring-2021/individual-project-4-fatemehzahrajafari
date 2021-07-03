import java.util.*;
 public class Graph {
    static int array1[];
    static boolean bfs(int matrix[][], int s, int t, int array[],int vertex)
    {
        boolean []visited = new boolean[vertex];
        Queue <Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        array[s] = -1;

        while (!queue.isEmpty())
        {
            int u = queue.peek();
            queue.remove();

            for (int v = 0; v < vertex; v++)
            {
                if (visited[v] == false &&
                        matrix[u][v] > 0)
                {
                    queue.add(v);
                    array[v] = u;
                    visited[v] = true;

                }
            }
        }


        return (visited[t] == true);

    }


      static int isFindPaths(int graph[][], int source, int destination,int vertex) {
        int i, j;

          int []solution = new int[vertex];
        int [][]matrixGraph = new int[vertex][vertex];
        for (i = 0; i < vertex; i++)
            for (j = 0; j < vertex; j++)
                matrixGraph[i][j] = graph[i][j];



        int max_flow = 0;

        while (bfs(matrixGraph, source, destination, solution,vertex))
        {

            int path_flow = Integer.MAX_VALUE;
            for (j = destination; j != source; j = solution[j])
            {
                i = solution[j];

                path_flow = Math.min(path_flow, matrixGraph[i][j]);

            }

            for (j = destination; j != source; j = solution[j])
            {
                i = solution[j];

                matrixGraph[i][j] -= path_flow;
                matrixGraph[j][i] += path_flow;
            }


            max_flow += path_flow;
        }


        return max_flow;
    }

     static void  bfsPrintPath( int matrix[][],int source, int destination,int vertex)
     {
         int array[][]=new int[vertex][vertex];
         int array1[]=new int[vertex];
         int solution[] = new int[vertex] ;
         for(int i = 0 ; i < vertex -1 ; i ++ ){
             solution[i] = -1 ;
         }
         boolean visited[] = new boolean[vertex];
         for (int i = 0; i < vertex; ++i)
             visited[i] = false;
         LinkedList<Integer> queue
                 = new LinkedList<Integer>();
         queue.add(source);
         visited[source] = true;
         solution[source] = -1;
         while (queue.size() != 0) {
             int u = queue.pop();
             for (int v = 0; v < vertex; v++) {
                 if (visited[v] == false && array[u][v] > 0) {
                     queue.add(v);
                     solution[v] = u;
                     array1[v] = u ;
                     visited[v] = true;
                 }

             }
         }
         int j = destination ;
         while(j!=source-1){
             int count = j+1 ;
             System.out.print(count);
             if(solution[j]>=0){
                 array[j][solution[j]] = 0 ;
                 array[solution[j]][j] =0 ;
             }
             j  = solution[j] ;
             int answer = j+1;
             System.out.println(","+ answer );

         }

     }
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         //v is number of vertex
         System.out.println("Enter the number of Vertex : ");
         int vertex = scanner.nextInt();
         //Adjacency matrix for Directional graph
         System.out.println("Enter the Adjacency matrix : ");
         int matrix[][] = new int[vertex][vertex];
         for (int i=0;i<vertex;i++){
             for (int j=0;j<vertex;j++){
                 matrix[i][j] = scanner.nextInt();
             }
         }
         //source is vertex first
         System.out.println("Enter the Source : ");
         int source = scanner.nextInt();

         //destination is vertex end
         System.out.println("Enter the Destination : ");
         int destination = scanner.nextInt();
         int max=0;
         max=isFindPaths(matrix, source, destination,vertex);
         System.out.println("This graph can have " + max +
                 " paths with separate edges " +
                 source + " to "+ destination);
          array1 = new int[matrix.length] ;

         System.out.println("number one path from source to destination : " );
          bfsPrintPath(matrix,source,destination,vertex);
         System.out.println("number two path from source to destination : " );
          bfsPrintPath(matrix,source,destination,vertex);

     }

}

