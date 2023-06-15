package WorkFile;

import title.titleData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class writerFile {
    protected String dir;
    protected titleData title;
    public writerFile(String dir, titleData obj){
        this.title = obj;
        this.dir = dir;
        Path path = Paths.get(this.dir);
        if (!Files.isDirectory(path))
        {
            try {
                Files.createDirectories(Paths.get(this.dir));
            } catch (IOException e) {
                System.out.println("Не возможно создать каталог: " + this.dir);
            }
        }


    }

    public void writer(HashMap<String, String> text) {
        String file = this.dir + "/" + text.get("Фамилия") + ".txt";
        Path path = Paths.get(file);
        if (!Files.exists(Path.of(file)))
        {
            try {
                Files.createFile(Path.of(file));
            } catch(IOException e)
            {
                System.out.println("IOException: " + e.getMessage() + "\nНе удалось создать файл");
            }

        }
        String str = "";
        int size = text.size();
        for(int i = 0; i < size; i++)
        {
            str = str + this.title.title[i] + ": " + text.get(this.title.title[i]) + " ";
        }
        str = str + "\n";
        try {
            Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Запись в файл успешна");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
