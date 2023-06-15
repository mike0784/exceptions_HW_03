package validation;



import title.titleData;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

//import MyException;

public class validationInputText {
    protected String text;
    protected titleData title;

    public validationInputText(titleData obj) {
        this.title = obj;
    }

    public HashMap<String, String> validName(String text)
    {
        HashMap<String, String> result = new HashMap<>();
        //Разбиение строки на слова
        String[] words = text.split(" ");

        //Проверка на полноту введенных данных
        if (words.length < 3)
            throw new MyException("Вы ввели ФИО не полностью");
        if (words.length > 3)
            throw new MyException("Вы ввели кроме ФИО что-то ещё");

        //Проверка на содержание недопустивых символов
        for (int i = 0; i < words.length; i++)
        {
            if (!words[i].matches("^[a-zA-Zа-яА-Я]*$"))
            {
                throw new MyException("Введенное слово: " + words[i] + " содержит недопустимый символ");
            }
            else {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
                result.put(title.title[i], words[i]);
            }
        }

        return result;
    }

    public String validData(String text)
    {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            pattern.parse(text);
        } catch (DateTimeParseException e) {
            System.out.println("Вы неправильно ввели дату рождения");
        }

        return text;
    }

    public String validSex(String text)
    {
        if (text.length() > 1)
            throw new MyException("Вы ввели слишком много символов");

        text = text.toUpperCase();
        if (!text.equals("W") && !text.equals("M"))
            throw new MyException("Введенный вами пол неизвестен");
        return text;
    }

    public String validTelephone(String text)
    {
        if (!text.matches("^[0-9]*$"))
            throw new MyException("Неправильный номер телефона. Имеются недопустимые символы. " + text);
        return text;
    }
}
