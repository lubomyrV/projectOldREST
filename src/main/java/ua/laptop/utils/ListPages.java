package ua.laptop.utils;

import java.util.TreeSet;

public class ListPages {
    private TreeSet<Integer> listPages = new TreeSet<>();
    private int totalPages = 0;

    public TreeSet<Integer> pages(int totalPages){
        if(listPages.isEmpty()){
            for (int i = 0; i < totalPages; i++) {
                listPages.add(i);
            }
        }
        if(totalPages != listPages.size()){
            listPages.clear();
            for (int i = 0; i < totalPages; i++) {
                listPages.add(i);
            }
        }
        return listPages;
    }

    public ListPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public TreeSet<Integer> getListPages() {
        return listPages;
    }

    public void setListPages(TreeSet<Integer> listPages) {
        this.listPages = listPages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "ListPages{" +
                "listPages=" + listPages +
                ", totalPages=" + totalPages +
                '}';
    }




}
