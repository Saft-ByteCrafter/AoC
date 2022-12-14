package day13.part1;

import java.util.List;

public class ListThingy { // yes i know this is kinda scuffed, but hey, it works, so ig?

    private final List<ListThingy> contentList;
    private final int contentValue;

    public ListThingy(List<ListThingy> list){
        contentList = list;
        contentValue = 0;
    }

    public ListThingy(int value) {
        contentValue = value;
        contentList = null;
    }

    public boolean hasSublist(){
        return contentList != null;
    }

    public List<ListThingy> getContent() {
        return contentList;
    }

    public int getValue() {
        return contentValue;
    }

    public String toString() {
        return contentList == null ? contentValue + "" : contentList.toString();
    }

}
