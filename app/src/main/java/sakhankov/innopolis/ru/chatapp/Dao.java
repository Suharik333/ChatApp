package sakhankov.innopolis.ru.chatapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dao {
    private static final List<Chat> projects = new ArrayList<>();

    static {
        projects.add(new Chat("My Project", "1212:sfds:dfsf:sdfsdf:sdfs"));
        projects.add(new Chat("My Project", "1212:sfds:dfsf:sdfsdf:sdfs"));
        projects.add(new Chat("My Project", "1212:sfds:dfsf:sdfsdf:sdfs"));
        projects.add(new Chat("My Project", "1212:sfds:dfsf:sdfsdf:sdfs"));
        projects.add(new Chat("My Project", "1212:sfds:dfsf:sdfsdf:sdfs"));
    }

    public static List<Chat> getAllProjects() {
        return projects;
    }

    public static Chat getProjectById(int id) {
        return projects.get(id);
    }

    public static void saveProject(Chat project) {
        projects.add(project);
    }
}