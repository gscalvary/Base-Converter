package com.oliver;

public class BaseConverter {

    public static String convert(int bFrom, String s, int bTo) {

        if(s == null || s.isEmpty()) throw new IllegalArgumentException();

        // Convert to base 10.
        int b10 = 0;
        for(int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            char c = s.charAt(i);
            switch(c) {
                case '0':
                    b10 += 0 * Math.pow(bFrom, j);
                    break;
                case '1':
                    b10 += 1 * Math.pow(bFrom, j);
                    break;
                case '2':
                    b10 += 2 * Math.pow(bFrom, j);
                    break;
                case '3':
                    b10 += 3 * Math.pow(bFrom, j);
                    break;
                case '4':
                    b10 += 4 * Math.pow(bFrom, j);
                    break;
                case '5':
                    b10 += 5 * Math.pow(bFrom, j);
                    break;
                case '6':
                    b10 += 6 * Math.pow(bFrom, j);
                    break;
                case '7':
                    b10 += 7 * Math.pow(bFrom, j);
                    break;
                case '8':
                    b10 += 8 * Math.pow(bFrom, j);
                    break;
                case '9':
                    b10 += 9 * Math.pow(bFrom, j);
                    break;
                case 'A':
                    b10 += 10 * Math.pow(bFrom, j);
                    break;
                case 'B':
                    b10 += 11 * Math.pow(bFrom, j);
                    break;
                case 'C':
                    b10 += 12 * Math.pow(bFrom, j);
                    break;
                case 'D':
                    b10 += 13 * Math.pow(bFrom, j);
                    break;
                case 'E':
                    b10 += 14 * Math.pow(bFrom, j);
                    break;
                case 'F':
                    b10 += 15 * Math.pow(bFrom, j);
                    break;
                case '-':
                    b10 *= -1;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        return convertFromTen(bTo, b10);
    }

    private static String convertFromTen(int bTo, int b10) {

        StringBuilder sb = new StringBuilder();

        // Handle a negative number first so the rest of the method may handle just positive numbers.
        if(b10 < 0) {
            sb.append("-");
            b10 *= -1;
        }

        // Find the largest "from" base power that fits in the integer being converted.
        int maxPower = 0;
        while (Math.pow(bTo, maxPower) <= b10) {
            maxPower++;
        }
        --maxPower;

        // Convert.
        for(int i = maxPower; i >= 0; i--) {
            int applied = (int)Math.pow(bTo, i);
            int nextNumber = b10 / applied;
            switch(nextNumber) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    sb.append(nextNumber);
                    break;
                case 10:
                    sb.append("A");
                    break;
                case 11:
                    sb.append("B");
                    break;
                case 12:
                    sb.append("C");
                    break;
                case 13:
                    sb.append("D");
                    break;
                case 14:
                    sb.append("E");
                    break;
                case 15:
                    sb.append("F");
                    break;
                default:
                    throw new IndexOutOfBoundsException("Tried to translate: " + nextNumber);
            }
            b10 -= nextNumber * applied;
        }

        return sb.toString();
    }
}
