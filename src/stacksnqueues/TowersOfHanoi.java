package stacksnqueues;

/**
 * Created by mayanknarasimhan on 21/12/14.
 *
 * Description:
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different
 * sizes which can slide on to any tower. The puzzle starts with disks sorted in
 * ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
 * You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next tower.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */
public class TowersOfHanoi {
    Stack[] towers = {new Stack(), new Stack(), new Stack()};
    int disks;

    public static void main (String args[]) {
        TowersOfHanoi toh = new TowersOfHanoi(5);
        System.out.println("Tower 1: " + toh.towers[0]);
        System.out.println("Tower 3: " + toh.towers[2]);
        toh.hanoi(5, 0, 2, 1);
        System.out.println("Tower 1: " + toh.towers[0]);
        System.out.println("Tower 3: " + toh.towers[2]);
    }

    public TowersOfHanoi (int _disks) {
        disks = _disks;
        for (int i = disks; i > 0; i--)
            towers[0].push(i);
    }

    public void hanoi (int numDisks, int from, int to, int buffer) {
        if (numDisks == 1) {
            moveDisk(from, to);
            return;
        }
        hanoi(numDisks - 1, from, buffer, to);
        moveDisk(from, to);
        hanoi(numDisks - 1, buffer, to, from);
    }

    public void moveDisk (int from, int to) {
        towers[to].push(towers[from].pop());
        System.out.println("Move disk from tower " + (from+1) + " ===> " + (to+1));
    }
}
