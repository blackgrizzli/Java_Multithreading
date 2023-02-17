package Archiver.command;

/**
 * отвечает за свойства каждого файла в архиве.
 * Свойства - это набор, состоящий из: имя файла,размер файла до и после сжатия, метод сжатия.
 */
public class FileProperties {
    private String name;             // имя файла
    private long size;               //Размер в байтах
    private long compressedSize;     // Размер после сжатия в байтах
    private int compressionMethod;   // Метод сжатия

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    public long getCompressionRatio() {
        return 100 - ((compressedSize * 100) / size);
    }

    @Override
    public String toString() {
        if (size > 0) {
            return String.format("%s %d Kb (%d) сжатие: %d%%", name, size / 1024, compressedSize / 1024, getCompressionRatio());
        } else {
            return name;
        }
    }
}
