import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindMedian {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
		List<Float> out = new ArrayList<Float>();
		int N = scan.nextInt();
		PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(N, Collections.reverseOrder());
		PriorityQueue<Integer> minQ = new PriorityQueue<Integer>(N);
		int first = scan.nextInt();
		out.add((float)first);
		if (N>=2) {
			int second = scan.nextInt();
			out.add((float) ((first+second)/2.0));
			if (first<second) {
				maxQ.add(first);
				minQ.add(second);
			} else {
				maxQ.add(second);
				minQ.add(first);
			}
		}
				
		for (int i=2; i<N; i++) {
			int num = scan.nextInt();
			if (num<minQ.peek()) {
				maxQ.add(num);
			} else {
				minQ.add(num);
			}
			if (maxQ.size() == minQ.size()) {
				out.add( (float) ((maxQ.peek()+minQ.peek())/2.0));
			} else if (maxQ.size() == minQ.size()+1) {
				out.add((float)maxQ.peek());
			} else if (minQ.size() == maxQ.size()+1) {
				out.add((float)minQ.peek());
			} else if (maxQ.size() == minQ.size()+2) {
				int a = maxQ.poll();
				minQ.add(a);
                out.add( (float) ((maxQ.peek()+minQ.peek())/2.0));
			} else {
				int a = minQ.poll();
				maxQ.add(a);
                out.add( (float) ((maxQ.peek()+minQ.peek())/2.0));
			}
		}
		for (float f : out) {
			System.out.printf("%.1f\n", f);
		}
    }
}
