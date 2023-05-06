package week7laboratory1;

import javax.swing.JOptionPane;

public class setTheory {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		//set A and B
		int A[] = {1,2,3};
		int B[] = {2,3,4};
		
		setTheory set = new setTheory();
		
		String output = ("Created by me Mr.Clyde Allen Yu :D\n" +
				         "Set A : {" + set.display(A) + "}\n" + 
		                 "Set B : {" + set.display(B) + "}\n" +
			             "Union : {" + set.display(sortArray(set.union(A, B))) + "}\n" +
		                 "Union All : {" + set.display(sortArray(set.unionAll(A, B)))  + "}\n" +
			             "Intersection : {" +set.display(sortArray(set.intersection(A, B))) + "}\n" + 
		                 "Difference A \\ B : {" + set.display(sortArray(set.difference(A, B))) + "}\n" +
			             "Complement A` : {" + set.display(sortArray(set.complement(A, set.union(A, B)))) + "}\n" +
			             "Complement B` : {" + set.display(sortArray(set.complement(B, set.union(A, B)))) + "}\n" +
			             "Symmetric Difference : {" +  set.display(sortArray(set.symmetricDifference(A, B))) + "}"); 
		
		JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.PLAIN_MESSAGE);
	}
	//display the array
	public String display(int x[]) {
		String displayOutput = "";
		for(int element : x) {
			displayOutput += element + " ";
			if(element != x[x.length-1]) {
				displayOutput += ", ";
			}
		}
		return displayOutput;
	}
	
	//rearrange the array in ascending order
	public static int[] sortArray(int x[]) {
		for(int i = 0; i < (x.length - 1); i++) {
			for(int j = 0; j < (x.length - i - 1); j++) {
				if(x[j] > x[j+1]) {
					int temp = x[j];
					x[j] = x[j+1];
					x[j+1] = temp;
				}
			}
		}
		return x;
			
	}
	
	//1. Union 
	public int[] union(int x[], int y[]) {
		int xy[] = new int[x.length + y.length];		
		int i = 0;
		
		//adding all elements from both sets to the new array 
		for(int element : x) {
			xy[i++] = element;
		}
		
		for(int element : y) {
			if(!contains(x, element)) { //anti duplicate
				xy[i++] = element;
			}
		}
		
		return trimArray(xy,i);

    }
	
	//2. Union All
	public int[] unionAll(int x[], int y[]) {
		int xy[] = new int[x.length + y.length];		
		int i = 0;
		
		
		//same as union that for each element in both sets, add them to the new array
		for(int element : x) {
			xy[i++] = element;
		}
		
		for(int element : y) {
			xy[i++] = element;
		}
		
		return trimArray(xy,i);
	}
	
	//3. Intersection
	public int[] intersection(int x[], int y[]) {
		int length = 0;
		
		//determining the length of the array by checking if set B contains the element
		for(int i = 0; i < x.length; i++) {
			for(int j = 0; j < y.length; j++) {
				if(x[i] == y[j]) {
					length++;
					break;
				}
			}
		}
		
		
		//making the intersected array with the new length
		int xy[] = new int[length];
		int index = 0;
		
		for(int i = 0; i < x.length; i++) {
			for(int j = 0; j < y.length; j++) {
				if(x[i] == y[j]) {
					xy[index++] = x[i];
					break;
				}
			}
		}
		
		return xy;
		
	}
	
	//4. Difference
	public int[] difference(int x[], int y[]) {
		int diff[] = new int[x.length];
		int i = 0;
		/* checks that for each element on set A, it would check that if that element is on set B
		 if yes then it would be added to the diff array
		*/
		for(int element : x) {
			if(!contains(y, element)) {
				diff[i++] = element;
			}
		}
		
		return trimArray(diff, i);
	}
	
	//5. Complement
	public int[] complement(int x[], int U[]) {
		// using the difference of Union set and the chosen set aka the complement of the chosen set
		return difference(U, x);
	}
	
	//6. Symmetric Difference
	public int[] symmetricDifference(int x[], int y[]) {
		int xy[] = new int[x.length + y.length];
		int i = 0;
		for(int element : x) {
			if(!contains(y, element)){
				xy[i++] = element;
			}
		}
		
		for(int element : y) {
			if(!contains(x, element)) {
				xy[i++] = element;
			}
		}
		
		return trimArray(xy, i);
	}
	
	//checks if the chosen element is on the set
	public static boolean contains(int[] x, int element) {
		boolean contains = false;
		for(int y : x) {
			if(element == y) {
				contains = true;
			}
		}
		
	    return contains;
	}
	
	//resize the array to a certain size
	public static int[] trimArray(int[] x, int size) {
		int[] y = new int[size];
		for(int i = 0; i < size; i++) {
			y[i] = x[i];
		}
		
		return y;
	}

}
