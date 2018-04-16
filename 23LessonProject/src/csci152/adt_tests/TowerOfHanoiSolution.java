package csci152.adt_tests;

import csci152.adt.Queue;
import csci152.impl.LinkedListQueue;
import csci152.impl.TowerOfHanoi;

public class TowerOfHanoiSolution {

    public static void main(String[] args){

        solveTower(20);

    }

    public static void solveTower(int numOfBlocks) {
        boolean left = numOfBlocks%2 != 0;
        print("Leftwards: " + left);
        TowerOfHanoi tower = new TowerOfHanoi(numOfBlocks);
        Queue<Integer> indexes = new LinkedListQueue();
        if(left) {
            indexes.enqueue(2);
            indexes.enqueue(1);
            indexes.enqueue(0);
        } else {
            indexes.enqueue(1);
            indexes.enqueue(2);
            indexes.enqueue(0);
        }
        int count = 0, smallestTo = 0, smallestPos = 0;

        print(tower);

        while(true) {
            print(tower);
            if(tower.isFinished()) {
                break;
            }
            if(count %2 == 0) {
                print("FIRST");
                try {
                    smallestTo = indexes.dequeue();
                    indexes.enqueue(smallestTo);
                    tower.moveDisc(smallestPos, smallestTo);
                } catch (Exception ex) {
                    print(ex.getMessage());
                }
                smallestPos = smallestTo;
            } else {
                print("SECOND");
                outerloop:
                for(int i = 0; i<3; i++) {
                    if(i == smallestPos || tower.getValue(i) == -1) continue;
                    for(int j = 0; j<3; j++) {
                        // Whether push is valid or not to the index J
                        print("Against " + j);
                        if(tower.pushValid(j, tower.getValue(i))) {
                            try {
                                tower.moveDisc(i, j);
                            } catch (Exception ex) {
                                print(ex.getMessage());
                            }
                            break outerloop;
                        }
                    }
                }
            }
            count++;
        }

        print("TOWER IS FINISHED in " + tower.getNumMoves());

    }

    public static void print(Object ob) {
        System.out.println(ob);
    }

}
