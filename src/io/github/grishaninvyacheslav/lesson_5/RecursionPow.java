package io.github.grishaninvyacheslav.lesson_5;

public class RecursionPow {
    public static void main(String[] args) {
        System.out.println(pow(2, 10));
    }

    public static int pow(int base, int exp){
        if(exp == 0){
            return 1;
        }

        return base * pow(base, exp - 1);
    }
}
