package Archiver;

import Archiver.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    private static final Map<Operation, Command> ALL_KNOWN_COMMANDS_MAP = new HashMap<>();

    static {
//        CREATE, // создать архив
//        ADD, // добавить файл в архив
//        REMOVE, // удалить файл из архива
//        EXTRACT, // извлеч содержимое архива
//        CONTENT, // просмотреть содержимое архива
//        EXIT // выйти из программы
        ALL_KNOWN_COMMANDS_MAP.put(Operation.CREATE,new ZipCreateCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.ADD,new ZipAddCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.REMOVE,new ZipRemoveCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.EXTRACT,new ZipExtractCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.CONTENT,new ZipContentCommand());
    }

    private CommandExecutor(){

    }

   public static void execute(Operation operation) throws Exception{
      ALL_KNOWN_COMMANDS_MAP.get(operation).execute();
   }
}
