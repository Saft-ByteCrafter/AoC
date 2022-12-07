package day07.part2;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private final String name;
    private final Directory outerDir;
    private final List<Directory> subDirs;
    private int totalFileSizes;
    private int totalSize;


    public Directory(String name) {
        this(name, null);
    }

    public Directory(String name, Directory outerDir) {

        this.name = name;
        this.outerDir = outerDir;
        this.subDirs = new ArrayList<>();
        this.totalFileSizes = 0;
        this.totalSize = 0;

    }

    public void addSubDir(Directory subDir) {
        subDirs.add(subDir);
    }

    public Directory getSubDir(String name) {

        if (name.equals("/")) return this;

        for (Directory dir : subDirs) {
            if (dir.name.equals(name)) return dir;
        }

        return null;

    }

    public Directory getOuterDir() {
        if (outerDir == null) {
            System.out.println("Ayo there ain't no outerDir dud" + this.name);
            throw new RuntimeException();
        }
        return outerDir;
    }

    public void addFile(int fileSize) {
        totalFileSizes += fileSize;
    }

    public int getSize() {
        if (this.totalSize == 0) {
            int subSizes = 0;
            for (Directory dir : subDirs) subSizes += dir.getSize();
            this.totalSize = this.totalFileSizes + subSizes;
        }
        return totalSize;
    }

    public int getBestSize(int needed, int best) {
        for(Directory dir : subDirs) {
            int size = dir.getBestSize(needed, best);
            if(size >= needed && (size < best || best == -1)) best = size;
        }
        if (this.totalSize >= needed && (this.totalSize < best || best == -1)) best = this.totalSize;
        return best;
    }

    public String getName() {
        return name;
    }

}
