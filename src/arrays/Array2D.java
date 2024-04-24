//package arrays;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//
//public class Array2D {
//   /* Find the minimum number of steps required in a 2D array of size (m, n)
//    to reach (m-1, n-1) from (0, 0). The array contains only 0(s) and 1(s) where cells with value 1 are not accessible.*/
//
//  //  [0,1],[0,0] [2 1]
//   // col
//  //  row
//   // steps
//    //
//
//   public int getMinimumDistance( int rows, int cols, int[][] matrix){
//       int [] row = {0,0,1,-1};
//       int [] col = {1,-1,0,0};
//       Queue<Tuple> q = new LinkedList<>();
//       int [][] visistedMatrix = new int[rows][cols];
//
//               if(matrix[0][0] != 0 && matrix[rows-1][cols-1] !=0){
//                   return -1;
//               }
//                 q.add(new Tuple(0,0,0));
//            visistedMatrix[0][0] = 1;
//
//
//             while(!q.isEmpty()){
//                 for(int x =0; x<q.size(); x++) {
//                     Tuple t = q.peek();
//                     int currenctDistance = t.distance;
//                     if(t.rowNumber == rows-1 && t.colNumber == cols -1){
//                         return t.distance;
//                     }
//                     for (int i = 0; i < row.length; i++) {
//                         int newRow = t.rowNumber + row[i];
//                         int newCol = t.colNumber + col[i];
//
//                         if (isValid(newRow, newCol, rows, cols, visistedMatrix, matrix)) {
//                             visistedMatrix[rows][cols] = 1;
//                             q.add(new Tuple(newRow,newCol,currenctDistance+1));
//                         } // if
//                     } // for
//                 }
//             } // while
//           return -1;
//       }
//
//      boolean isValid(int nr, int nc, int or, int oc, int[][] visistedMatrix, int[][] matrix){
//       if(nr>=0 && nc >=0 && nr<or && nc<oc && visistedMatrix[nr][nc] == 0 && matrix[nr][nc] == 0 ){
//           return true;
//       }
//       return false;
//       }
//
//   // Find all pairs of integers in an array whose sum is equal to a given number k.
//
////    {7, 9, 0, 7, 5, 20} = 8
////    [1,1,7,7] = 8 = 2
////     map [7, 0] count = 0
////         [1,1]    count = [7, 1] [1,7]
////
////
////
////    {-1, 0, 5, 7, 9, 20} = nlogn
////      i  =0            j = n-1
////
////    psvm()
//
//    // list of courses,
//    // n [0,1] -> [1,2] ->
////    0->1->2
////    [0] -
//    //   [A, B] -> b before A
//
//    List<Integer> getListOfCourses(ArrayList<ArrayList<Integer>> courseList, int n){
//     //  createGraphFromCourseList()
//     // getOrderedCourse()
//        ArrayList<ArrayList<Integer>> graphCourses =  createGraphFromCourseList(courseList, n);
//        return getOrderedCourse(graphCourses, n);
//    }
//
//    ArrayList<ArrayList<Integer>> createGraphFromCourseList(ArrayList<ArrayList<Integer>> courseList, int n) {
//        ArrayList<ArrayList<Integer>> grapgOfCourses = new ArrayList();
//        for (int i = 0; i < n; i++) {
//            grapgOfCourses.add(new ArrayList());
//        }
//        // [[0,1],[1,2],[2,3]]
//        // [[],[],[]]
//        //0->1->2
//        for (int i = 0; i < n; i++) {
//            List<Integer> innerList = grapgOfCourses.get(1);
//            innerList.add(grapgOfCourses.get(i).get(0));
//
//        }
//        return grapgOfCourses;
//    }
//
//    List<Integer>  getOrderedCourse(ArrayList<ArrayList<Integer>> courseList, int n){
//       List<Integer> orderResult = new ArrayList(n);
//    // [0,1,1]
//        // 0->1->2  0->[1]
//         1-.[2]
//        1-2
//                [0,1,0]
//       int [] courseIndegree = new int[n];
//       for(int i=0; i<courseList.size(); i++){
//          ArrayList<Integer> children = courseList.get(i);
//          for(int c :children) {
//              courseIndegree[c] = courseIndegree[c] + 1;
//          }
//       }
//
//       // process graph
//        Queue<Integer> q = new LinkedList<>();
//       for(int x =0; x<courseIndegree.length; x++){
//       if(courseIndegree[x] == 0){
//           q.add(x);
//       }
//    }
//
//       while(!q.isEmpty()){
//       int currentCourse = q.poll();
//       orderResult.add(currentCourse);
//
//       for(  int childCourse :courseList.get(currentCourse)){
//           courseIndegree[childCourse] = courseIndegree[childCourse] -1 ;
//           if(courseIndegree[childCourse] == 0){
//               q.add(childCourse);
//           }
//       }
//
//
//       }
//       if(orderResult.size() == n){
//           return orderResult;
//       }
//       return new ArrayList<>();
//    }
//
//
//    // tree whether it is complete
//
//    1        1
//
//    2 3    3    4
//  4         7     5
//    class Node
//       int val;
//   Node left;
//   Node right;
//   Node(val,left, right){
//       this.val = val;
//       left
//   }
//    }
//    boolean completeBinaryTree(Node root){
//       height == -1
//       }
//       return true;
//     }
//
//     int height(Node node){
//       if(node == null){
//           return 0;
//       }
//       int l = height(node.left);
//       if(l == -1){
//           -1
//       }
//         int r =height(node.right);
//         if(r == -1){
//             -1
//         }
//       if(r>l) {
//           resultflag = false;
//           return -1;
//
//       return  Math.Max(r,l)+1;
//}
//}
