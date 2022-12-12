package day07.part1;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private final String name;
    private final Directory outerDir;
    private final List<Directory> subDirs;
    private int totalFileSizes;


    protected Directory(String name) {
        this(name, null);
    }

    protected Directory(String name, Directory outerDir) {

        this.name = name;
        this.outerDir = outerDir;
        this.subDirs = new ArrayList<>();
        this.totalFileSizes = 0;

    }

    protected void addSubDir(Directory subDir) {
        subDirs.add(subDir);
    }

    protected Directory getSubDir(String name) {

        if(name.equals("/")) return this;

        for(Directory dir : subDirs) {
            if(dir.name.equals(name)) return dir;
        }

        return null;

    }

    protected Directory getOuterDir() {
        if(outerDir == null) {
            System.out.println("Ayo there ain't no outerDir dud" + this.name);
            throw new RuntimeException();
        }
        return outerDir;
    }

    protected void addFile(int fileSize) {
        totalFileSizes += fileSize;
    }

    protected int getTotalSize(List<Integer> sizes) {
        int subSizes = 0;
        for (Directory dir : subDirs) subSizes += dir.getTotalSize(sizes);
        if(this.totalFileSizes + subSizes <= 100000) sizes.add(this.totalFileSizes + subSizes);
        return this.totalFileSizes + subSizes;
    }

    protected String getName() {
        return name;
    }

}
