package Archiver.command;

//Команда создания архива (упаковки файлов в архив)

import Archiver.ConsoleHelper;
import Archiver.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");
            ConsoleHelper.writeMessage("Введите полное имя файла или директории для архивации");
            Path path = Paths.get(ConsoleHelper.readString());
            getZipFileManager().createZip(path);
            ConsoleHelper.writeMessage("Архив создан.");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
