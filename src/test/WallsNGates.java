package test;

import java.util.LinkedList;

import tools.io;

public class WallsNGates {
	private static final int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        if(rooms != null && rooms.length > 0 && rooms[0].length > 0) {
            LinkedList<Integer> qRow = new LinkedList<>(), qCol = new LinkedList<>();
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for(int row = 0; row < rooms.length; row++) {
                for(int col = 0; col < rooms[0].length; col++) {
                    if(rooms[row][col] == 0) {
                        qRow.addLast(row);
                        qCol.addLast(col);
                    }
                }
            }
            while(!qRow.isEmpty() && !qCol.isEmpty()) {
                int size = qRow.size();
                for(int i = 0; i < size; i++) {
                    int currR = qRow.pollFirst(), currC = qCol.pollFirst();
                    for(int d = 0; d < dirs.length; d++) {
                        int newR = currR + dirs[d][0], newC = currC + dirs[d][1];
                        if(0 <= newR && newR < rooms.length && 0 <= newC && newC < rooms[0].length
                            && rooms[newR][newC] == Integer.MAX_VALUE) {
                            rooms[newR][newC] = rooms[currR][currC] + 1;
                            qRow.addLast(newR);
                            qCol.addLast(newC);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
    	int[][] rooms = {{INF, -1,  0,INF},
    					 {INF,INF,INF, -1},
    					 {INF, -1,INF, -1},
    					 {  0, -1,INF,INF}};
    	new WallsNGates().wallsAndGates(rooms);
    	for(int[] row : rooms){
    		for(int i : row)
    			io.p(i + "\t");
    		io.pl("");
		}
    }
}
