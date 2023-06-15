public class MyException extends RuntimeException {
    public MyException(String e)
    {
        super("Ошибка обработки: " + e);
    }
}
