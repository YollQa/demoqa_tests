package guru.qa;


public class Main {
    public static void main(String[] args) {

        // 0) примитивне типы
        byte varByte = 55;  // диапазон -127 ... 128, default = 0
        short varShort = 32000; //диапазон  -32,768 ...  32,767 default = 0
        int varInt = 352343254; // диапазон -2^31 ... 2^31-1 default = 0
        long varLong = 4445952343254L;//  диапазон -2^63 ... 2^63-1 default = 0L
        float varFloat = 6.667868f; // -3.4E+38 ... 3.4E+38  default = 0.0f
        double varDouble = 1.9; // -1.7E+308...1.7E+308  default =0.0d
        boolean varBoolean = true; // true or false. default = false;
        char varChar = 'f'; // 16-разрядные символы Unicode.


    // Сложение
        byte varByteEx = 55;
        System.out.println(varByte + varByteEx); // 110

        int varIntEx = 18200;
        System.out.println(varInt + varIntEx); //352361454

        double varDoubleEx = 17.5;
        System.out.println(varDouble + varDoubleEx); //19.4

    // Вычитание
        float varFloatEx = 8.32f;
        System.out.println(varFloat - varFloatEx); //-1.6521316

        short varShortEx = 19000;
        System.out.println(varShort - varShortEx); //13000

    // Деление
        int varIntExemp = 69;
        System.out.println(varIntExemp / 5); //13
        System.out.println(varIntExemp % 5); //4

    // Умножение
        System.out.println(varDoubleEx * 2);//35,0

    // Операции с int и double
        int varExample = 10;
        System.out.println(varInt + varDoubleEx); // 3.523432715E8
        System.out.println(varExample + 1.1); // 11.1
        System.out.println(varExample / 2.5); // 4,0

    // Переполнение
        byte varByteExample = 127;
        System.out.println((short) (varShort + varLong)); // 31190
        System.out.println((byte) (varByteExample + 1)); // -128
    }
}