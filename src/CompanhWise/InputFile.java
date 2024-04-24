package CompanhWise;

import java.util.List;


public class InputFile {
    int size;
    String file;
    List<String> collection;

    public InputFile(final int size, final String file, final List<String> collection) {
        this.size = size;
        this.file = file;
        this.collection = collection;
    }

    public InputFile(final int size, final String file) {
        this.size = size;
        this.file = file;
    }

    public int getSize() {
        return size;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    public String getFile() {
        return file;
    }

    public void setFile(final String file) {
        this.file = file;
    }

    public List<String> getCollection() {
        return collection;
    }

    public void setCollection(final List<String> collection) {
        this.collection = collection;
    }
}
