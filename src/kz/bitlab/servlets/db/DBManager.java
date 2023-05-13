package kz.bitlab.servlets.db;

import java.util.ArrayList;

public class DBManager {


    public  static Long id = 6L;
    private static final ArrayList<Items> items = new ArrayList<>();

    static {
        items.add(new Items(1L,"Cоздать веб приложение на JAVA EE","23-10-2021",1499.99)
        );
    }
    static {
        items.add(new Items(2L,"Убраться дома и закупить продукты","25-10-2021",999.99)
        );
    }
    static {
        items.add(new Items(3L,"Выполнить все домашние задания","28-10-2021",1099.99)
        );
    }
    static {
        items.add(new Items(4L,"Записаться на качку","12-12-2021",199.99)
        );
    }
    static {
        items.add(new Items(5L,"Учить Итальянский","01-05-2021",299.99)
        );
    }

    public static ArrayList<Items> getTasks(){
        return items;
    }

    public static void addTask(Items task){
        task.setId(id);
        items.add(task);
        id++;
    }

    public static Items getTask(int id){
        return  items.
                stream().
                filter(tasks -> tasks.getId()==id).
                findFirst().
                orElse(null);
    }

    public static void updateTask(Items example){
        for (int i = 0; i< items.size(); i++){
            if(items.get(i).getId()== example.getId()){
                items.set(i,example);
                break;
            }
        }
    }

    public static void deleteTask(int id){
        for(int i = 0; i< items.size(); i++){
            if(items.get(i).getId()==id){
                items.remove(i);
                break;
            }
        }
    }

}