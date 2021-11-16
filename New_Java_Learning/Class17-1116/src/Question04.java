public class Question04 {
    public static void main(String[] args) {
        String getString = "bb bbb bb bbb b bb";
        int targetNum = lookForShortest(getString);
        System.out.println(targetNum);
    }

    public static int lookForShortest(String s) {
        int minPosition = Integer.MAX_VALUE;
        for(String arrayString : s.split(" ")){
            if (arrayString.length() < minPosition){
                minPosition = arrayString.length();
            }
        }
        return minPosition;
    }
}
