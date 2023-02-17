package Archiver;

import Archiver.command.ExitCommand;
import Archiver.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь к архиву.");
        Path path = Paths.get(bufferedReader.readLine());

        ZipFileManager zipFileManager = new ZipFileManager(path);

        System.out.println("Введите путь к файлу, который нужно сжать");
        Path path1 = Paths.get(bufferedReader.readLine());
        zipFileManager.createZip(path1);

        while (true) {
            Operation operation = null;
            try {
                operation = askOperation();
                if (operation.ordinal() == 5) {
                    break;
                }
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e){
                System.out.println("Произошла ошибка. Проверьте введенные данные.");
            }
        }

        ExitCommand exit = new ExitCommand();
        exit.execute();
    }

    public static Operation askOperation() throws Exception {
        ConsoleHelper.writeMessage("Выберите операцию:\n" +
                "0 - упаковать файлы в архив\n" +
                "1 - добавить файл в архив\n" +
                "2 - удалить файл из архива\n" +
                "3 - распаковать архив\n" +
                "4 - просмотреть содержимое архива\n" +
                "5 - выход");


        return switch (ConsoleHelper.readInt()) {
            case 0 -> Operation.CREATE;
            case 1 -> Operation.ADD;
            case 2 -> Operation.REMOVE;
            case 3 -> Operation.EXTRACT;
            case 4 -> Operation.CONTENT;
            case 5 -> Operation.EXIT;
            default -> throw new IllegalStateException("Unexpected value: " + askOperation());
        };
    }
}

