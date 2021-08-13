/*
A format for expressing an ordered list of integers is to use a comma separated list of either

    individual integers
    or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'.
    The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers. For example "12,13,15-17"

Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.

Example:

Solution.rangeExtraction(new int[] {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
# returns "-6,-3-1,3-5,7-11,14,15,17-20"

 */

public class RangeExtraction {
    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[] {-8,-6,-4}));
    }

    public static String rangeExtraction(int[] arr) {
        String result ="";
        int start;
        int end = arr[0];
        int i=0;
        while ( i <arr.length ){
            start = arr[i];
            if (i == arr.length-1){
                end = arr[i];
            }else {
                if (arr[i] != arr[i + 1] - 1) {
                    end = arr[i];
                } else {
                    while (i < arr.length - 1 && arr[i] == arr[i + 1] - 1) {
                        end = arr[i + 1];
                        i++;
                    }
                }

            }
            i++;
            if (start==end) result += start +",";
            else if (start == end-1) {
                result += start +",";
                result += end +",";
            } else result += start + "-" + end + ",";
        }
        return result.substring(0,result.length()-1);
    }
}
