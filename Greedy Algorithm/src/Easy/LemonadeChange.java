package Easy;

public class LemonadeChange {

    static boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                if (fives == 0) return false;

                fives--;
                tens++;
            } else {
                if (tens != 0 && fives != 0) {
                    tens--;
                    fives--;
                } else if (fives >= 3) {
                    fives -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,20,10,10};

        System.out.println(lemonadeChange(bills));
    }
}
