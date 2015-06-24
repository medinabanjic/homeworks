package ba.bitcamp.exercises.ass9_14;

public class ArrayManipulation {

	public static void extendArray(Computer[] array) {
		Computer[] newArray = new Computer[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;

	}

	public static void shrinkArray(Computer[] array, int n) {
		Computer[] newArray = new Computer[array.length - 1];
		int j = 0;
		for (int i = 0; i < newArray.length; i++) {
			if (n == j) {
				j++;
			}
			newArray[i] = array[j];
			j++;
		}
		array = newArray;
	}

}
