package Geeks4GeeksArray;
public class LongestNum {
    public String longestNum(int[] numbers) {
        String longestNum = "";
        for (String num : ConvertIntToString(numbers)) {
            longestNum = longestNum + num;
        }
        System.out.println("LongestNum: "+longestNum);
        return longestNum;
    }

    public String[] ConvertIntToString(int[] numbers) {
        String[] integerAsString = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            integerAsString[i] = String.valueOf(numbers[i]);
        }
        return sortedStringArray(integerAsString);
    }

    public String[] sortedStringArray(String[] sortString) {
        for (int i = 1; i < sortString.length; i++) {
            int iIndex = i;
            String temp = sortString[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp.compareTo(sortString[j]) > 0) {
                    sortString[iIndex] = sortString[j];
                    sortString[j] = temp;
                    iIndex--;
                }
            }
        }
        return otherDigitsCheck(sortString);
    }
    //If there is more than one digit no at an index of string array.

    public String[] otherDigitsCheck(String[] moreThanOne) {
        for (int i = 0; i < moreThanOne.length - 1; i++) {
            if (moreThanOne[i].length() > 1) {
                String temp = moreThanOne[i];
                if (moreThanOne[i].charAt(0) == moreThanOne[i + 1].charAt(0)) {
                    int index = 1;
                    int flag = 0;
                    int length = moreThanOne[i + 1].length();
                    while (flag == 0) {
                        int prevStringNextDigitCheck = Integer.parseInt(Character.toString(moreThanOne[i].charAt(index)));
                        int nextStringNextDigitCheck = Integer.parseInt(Character.toString(moreThanOne[i].charAt(0)));
                        if ((prevStringNextDigitCheck < nextStringNextDigitCheck) && length == 1) {
                            moreThanOne[i] = moreThanOne[i + 1];
                            moreThanOne[i + 1] = temp;
                            break;
                        } else if (prevStringNextDigitCheck > nextStringNextDigitCheck) {
                            break;
                        } else {
                            index++;
                            length--;
                            flag = 0;
                        }
                    }
                }
            }
        }
        return moreThanOne;
    }

    public static void main(String[] args) {
        LongestNum obj = new LongestNum();
        obj.longestNum(new int[]{10, 5, 2213, 6, 221});
    }
}
