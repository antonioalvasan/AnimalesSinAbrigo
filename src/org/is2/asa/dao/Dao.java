package org.is2.asa.dao;

import java.io.InputStream;
import java.util.List;

//DAO design pattern used

public interface Dao<T> {
    //all DAO must have funcs
    T get(int id); //Returns the item in id's position. This object can be null.

    List<T> getAll(); //Returns the list of objects.

    void add(T t); //Adds an object into the dao.

    void update(T t); //Updates the object if that object already exists.

    void delete(T t); //Deletes the object if that object exists.

    void load(InputStream in); //Initializes the object list from an inputStream (always a JSON file).
}