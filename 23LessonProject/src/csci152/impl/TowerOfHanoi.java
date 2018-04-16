
package csci152.impl;

import csci152.adt.Stack;

public class TowerOfHanoi {

	private Stack<Integer>[] post = new ArrayStack[3];
	private int numMoves = 0;
	
	public TowerOfHanoi(int numDiscs) {
		/*
		 TODO: Initialize all three posts to new stack objects,
		 and push onto post[0] the integers:
		    numDiscs, numDiscs-1, numDiscs-2, ..., 1 
		 */
		for(int i = 0; i<3; i++) {
			post[i] = new ArrayStack<>();
		}

		for(int i = numDiscs; i>0; i--) {
			post[0].push(i);
		}
	}
	
	public void moveDisc(int from, int to) throws Exception {

		/*
		 TODO:  Moves the integer from the top of post[from] to
		 post[to].  Throws an exception if either index is not
		 0, 1, or 2; or if post[from] is empty; or if the value
		 on top of post[from] is bigger than the topmost item of
		 post[to].
		 */

		if(from < 0 || from > 2 || to < 0 || to > 2) throw new Exception("Index out of range!");
		int val = 0;

		try {
			val = post[from].pop();
		} catch (Exception ex) {
			System.out.println("An error has occured at moveDisk(): " + ex.getMessage());
			return;
		}

		if(pushValid(to, val)) {
			post[to].push(val);
			numMoves++;
		} else throw new Exception("The destination stack has a value smaller than the given one");
	}

	public boolean pushValid(int to, int value) {
		if(post[to].getSize() == 0) return true;
		boolean result = false;
		int val = 0;

		try {
			val = post[to].pop();
			result = value < val;
			post[to].push(val);
		} catch (Exception ex) {
			System.out.println("An error has occured at pushValid(): " + ex.getMessage());
		}

		return result;
	}

	public int getValue(int from) {
		if(post[from].getSize() == 0) return -1;
		int value = 0;
		try {
			value = post[from].pop();
			post[from].push(value);
		} catch (Exception ex) {
			System.out.println("An error has occured at getValue(): " + ex.getMessage());
		}
		return value;
	}
	
	public boolean isFinished() {
		/*
		 TODO:  Returns true if and only if all of the discs are
		 on post[2] (i.e., post[0] and post[1] are empty)
		 */
		return post[0].getSize() == 0 && post[1].getSize() == 0;
	}
	
	public int getNumMoves() {
		return numMoves;
	}
	
	public String toString() {
		/* 
		 TODO:  Returns some string representation of the current
		 game state.... this should help with debugging
		 */
		int size = 0, maxSize = 0;
		for(int i = 0; i<3; i++) {
			if(post[i].getSize()>maxSize) maxSize = post[i].getSize();
		}
		int[][] vals = new int[3][maxSize];
		Stack<Integer> backup = new ArrayStack<>();
		int val = 0;
		String contents = "";
		for(int i = 0; i<3; i++) {
			size = post[i].getSize();
			contents += "#"+i+":{ ";
			for(int j = 0; j< size; j++) {
				try {
					val = post[i].pop();
					vals[i][j] = val;
					contents += val + " ";
					backup.push(val);
				} catch (Exception ex) {
					System.out.println("An error has occured at toString(): " + ex.getMessage());
				}
			}
			for(int j = 0; j< size; j++) {
				try {
					val = backup.pop();
					post[i].push(val);
				} catch (Exception ex) {
					System.out.println("An error has occured at toString(): " + ex.getMessage());
				}
			}
			contents += " }\n";
		}

		return contents;
	}
	
}
