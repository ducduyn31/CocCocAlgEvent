package io.github.ducduyn31;

import java.util.Scanner;

public class LevenshteinEditDistance {

	private char[] x, y, z;
	private short i, j;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Your initial String: ");
		String s1 = scan.nextLine();
		System.out.println("Your output String: ");
		String s2 = scan.nextLine();
		scan.close();

		LevenshteinEditDistance l = new LevenshteinEditDistance(s1, s2);
		// System.out.println(l.copy() + l.copy() + l.replace('t') + l.delete()
		// + l.copy() + l.insert('u')
		// + l.copy() + l.insert('s') + l.copy() + l.replace('i') +
		// l.replace('c'));
		// System.out.println("algorithm");
		// System.out.println(String.copyValueOf(l.z));
		System.out.println(l.work());
	}

	/*
	 * Replace = Insert + Delete
	 * 
	 */

	private LevenshteinEditDistance(String input, String output) {
		this.x = input.toCharArray();
		this.y = output.toCharArray();
		this.z = new char[1000];
		i = 0;
		j = 0;
	}

	private short copy() {
		z[j] = x[i];
		i++;
		j++;
		return 0;
	}

	private short replace(char c) {
		z[j] = c;
		i++;
		j++;
		return 1;
	}

	private short delete() {
		i++;
		return 1;
	}

	private short insert(char c) {
		z[j] = c;
		j++;
		return 1;
	}

	// Shortest: CCRDCICICRR

	private int work() {
		int sum = 0;
		String o = String.copyValueOf(y);
		int balancePoint = o.length();
		int currentScore = x.length;

		while (new String(z).trim() != o && (i < x.length)) {
			if (i < x.length && j < y.length) {
				if (x[i] == y[j]) {
					sum += copy();
					System.out.print(" C ");
				} else {
					if (disttonextChar(i, y[j]) > 1) {
						if (currentScore < balancePoint) {
							currentScore++;
							sum += insert(y[j]);
							System.out.print(" I ");
						} else {
							currentScore--;
							sum += delete();
							System.out.print(" D ");
						}
					} else if (disttonextChar(i, y[j]) == 1) {
						sum += delete();
						currentScore--;
						System.out.print(" D ");
					} else {
						sum += insert(y[j]);
						currentScore++;
						System.out.print(" I ");
					}

				}
			}

			if (new String(z).trim().equals(o) && (i < x.length)) {
				sum += delete();

				System.out.print(" D ");
				currentScore--;
				
			}
		}

		System.out.println(String.copyValueOf(z));
		return sum;
	}

	private int disttonextChar(int start, char c) {
		int dist = 0;

		for (dist = start; dist < x.length; dist++) {
			if (x[dist] == c)
				break;
			else if (dist == (x.length - 1) && x[dist] != c)
				return -1;
		}

		return dist - start;
	}
}
