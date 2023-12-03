package com.example.prac18;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
public class PaperDbHelper {

    public static ArrayList<Group> getGroups(){
        return Paper.book().read("groups", new ArrayList<>());
    }
    public static void saveGroups(ArrayList<Group> groups){
        Paper.book().write("groups", groups);
    }

    public static Boolean addGroup(Group group){
        ArrayList<Group> groups = getGroups();
        for (Group g: groups){
            if (g.getName().equals(group.getName())){
                return false;
            }
        }
        groups.add(group);
        saveGroups(groups);
        return true;
    }

    public static void deleteGroupById(int id){
        ArrayList<Group> groups = getGroups();
        groups.remove(id);
        Paper.book("groups").write("groups", groups);
        saveGroups(groups);
    }
}

