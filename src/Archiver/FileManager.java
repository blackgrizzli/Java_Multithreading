package Archiver;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path rootPath;  //  корневой путь директории, файлы которой нас интересуют
    private List<Path> fileList;  // список относительных путей файлов внутри rootPath

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        this.fileList = new ArrayList<>();
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException {
        if (Files.isRegularFile(path)) { //Проверить, если переданный путь path является обычным файлом
        fileList.add(this.rootPath.relativize(path));
        }
        if (Files.isDirectory(path)){ //Если переданный путь path, является директорией
            final DirectoryStream<Path> pathDirectoryStream = Files.newDirectoryStream(path);
            for (Path file : pathDirectoryStream) {
                collectFileList(file);
            }
            pathDirectoryStream.close();
        }
    }
}
