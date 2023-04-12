public class RotateString {

    public static void main(String[] args) {
        RotateString mainObj = new RotateString();
        System.out.println(mainObj.rotate("abcdef", 1, 2));
    }

    public int rotate(String input1, int input2, int input3){
        int n = input1.length();
        int sum = input2 + input3;
        int pos = n -1;
        int turns = 0;
        do{
            pos -= sum;
            if(pos < 0){
                pos = n + (pos+1); //wrap around
            }
            ++turns;
        }while(pos != 0);

        return turns;
    }
}
