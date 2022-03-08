package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {

        /*ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(new Integer[] {1,2,3}));
        ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(new Integer[] {4,5,6}));
        ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(new Integer[] {7,8,9}));*/

        ArrayList<Integer> row4 = new ArrayList<>(Arrays.asList(new Integer[]{1, 2}));
        ArrayList<Integer> row5 = new ArrayList<>(Arrays.asList(new Integer[]{3, 4}));

        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        /*mat.add(row1);
        mat.add(row2);
        mat.add(row3);*/

        mat.add(row4);
        mat.add(row5);

        mat.stream().forEach(integers -> System.out.println(integers));
        System.out.println();

        rotate(mat);

        mat.stream().forEach(integers -> System.out.println(integers));
    }

    public static void rotate(ArrayList<ArrayList<Integer>> mat) {

        int n = mat.size();
        int m = mat.get(0).size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat.get(i).get(j);
                mat.get(i).set(j, mat.get(j).get(i));
                mat.get(j).set(i, temp);
            }
        }
        System.out.println();

        mat.stream().forEach(integers -> System.out.println(integers));

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = mat.get(i).get(j);
                mat.get(i).set(j, mat.get(i).get(m - j - 1));
                mat.get(i).set(m - j - 1, temp);
            }
        }

    }
}
