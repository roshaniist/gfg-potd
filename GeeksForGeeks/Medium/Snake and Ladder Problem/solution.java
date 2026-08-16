class Solution {
     public int minThrows(int n, int[] lad, int[] sn) {
         int total = n * n;

         // Board: start cell -> destination cell
         int[] move = new int[total + 1];

         for (int i = 0; i <= total; i++) {
             move[i] = -1;
         }

         // Ladders
         for (int i = 0; i < lad.length; i += 2) {
             move[lad[i]] = lad[i + 1];
         }

         // Snakes
         for (int i = 0; i < sn.length; i += 2) {
             move[sn[i]] = sn[i + 1];
         }

         // BFS
         boolean[] visited = new boolean[total + 1];

         int[] queue = new int[total + 1];
         int front = 0;
         int rear = 0;

         // Start from cell 1
         queue[rear++] = 1;
         visited[1] = true;

         int throwsCount = 0;

         while (front < rear) {
             int size = rear - front;

             // All cells reachable in one dice throw
             for (int i = 0; i < size; i++) {
                 int current = queue[front++];

                 if (current == total) {
                     return throwsCount;
                 }

                 for (int dice = 1; dice <= 6; dice++) {
                     int next = current + dice;

                     if (next > total) {
                         break;
                     }

                     // Snake or ladder
                     if (move[next] != -1) {
                         next = move[next];
                     }

                     if (!visited[next]) {
                         visited[next] = true;
                         queue[rear++] = next;
                     }
                 }
             }

             throwsCount++;
         }

         return -1;
     }
 }