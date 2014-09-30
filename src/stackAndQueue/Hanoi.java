package stackAndQueue;

import java.util.Stack;

public class Hanoi {
	private Tower[] towers = new Tower[3];
	private int diskNum;
	
	public Hanoi(int diskNum) {
		this.diskNum = diskNum;
		
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}
		
		for (int i = diskNum; i > 0; i--) {
			towers[0].add(i);
		}
	}
	
	public void play() {
		moveDisks(diskNum, towers[0], towers[2], towers[1]);
	}
	
	private void moveDisks(int disks, Tower from, Tower dest, Tower buffer) {
		if (disks > 0) {
			moveDisks(disks - 1, from, buffer, dest);
			from.moveTopTo(dest);
			moveDisks(disks - 1, buffer, dest, from);
		}
	}
		
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi(5);
		hanoi.play();

	}
}

class Tower {
	private Stack<Integer> disks = new Stack<Integer>();
	private int index;
	
	public Tower(int i) {
		index = i;
	}
	
	public int index() {
		return index;
	}
	
	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk " + d);
		} else {
			disks.push(d);
		}
	}
	
	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
		System.out.print("Move disk " + top + " from tower" + index() + " to tower" + t.index + "\n");
	}
}

