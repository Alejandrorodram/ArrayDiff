package arraydiff;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayDiff {

	public static void main(String[] args) {
		System.out.println(arrayDiff1(new int [] {1,2,2}, new int[] {2}));
		System.out.println(arrayDiff2(new int [] {1,2,2}, new int[] {2}));
		System.out.println(arrayDiff3(new int [] {1,2,2}, new int[] {2}));
	}

	public static int[] arrayDiff1(int[] a, int[] b) {
		List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
		List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
		listA.removeAll(listB);
		return listA.stream().mapToInt(e -> e).toArray();
	}

	public static int[] arrayDiff2(int[] a, int[] b) {
		return IntStream.of(a).filter(x -> IntStream.of(b).noneMatch(y -> y == x)).toArray();
	}

	public static int[] arrayDiff3(int[] a, int[] b) {
		
		for (int search : b) {
			int index = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] != search) {
					a[index++] = a[i];
				}
			}
			a = Arrays.copyOf(a, index);
		}
		return a;
	}

}
