import WorkFile.writerFile;
import title.titleData;
import validation.validationInputText;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String str;


        HashMap<String, String> result = new HashMap<>();
        titleData title = new titleData();
        validationInputText check = new validationInputText(title);
        writerFile f = new writerFile("C:/Archiv", title);
        while (true)
        {
            System.out.print("Введите Фамилию Имя Отчество: ");
            str = in.nextLine();
            result = check.validName(str);

            System.out.print("Введите дату рождения (дд.мм.гггг): ");
            str = in.nextLine();
            result.put(title.title[3], check.validData(str));

            System.out.print("Введите пол (W-женский, M-мужской): ");
            str = in.nextLine();
            result.put(title.title[4], check.validSex(str));

            System.out.print("Введите номер телефона: ");
            str = in.nextLine();
            result.put(title.title[5], check.validTelephone(str));

            f.writer(result);
            System.out.print("Хотите продолжить? (Y/n): ");
            str = in.nextLine().toUpperCase();
            if (str.equals("N"))
            {
                System.out.println("Выход");
                break;
            } else if (!str.equals("Y")) {
                throw new RuntimeException("Вы ввели неправильное значение.\nНе знаю что делать.");
            }
        }

    }
}