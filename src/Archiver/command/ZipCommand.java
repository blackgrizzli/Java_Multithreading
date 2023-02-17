package Archiver.command;

import Archiver.ConsoleHelper;
import Archiver.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь к архиву");
        String name = ConsoleHelper.readString();
        Path path = Paths.get(name);
        return new ZipFileManager(path);
    }
}

