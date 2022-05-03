package org.is2.asa.dao;

import org.is2.asa.model.Animal;
import org.is2.asa.model.Dog;
import org.is2.asa.model.Species;
import org.is2.asa.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.awt.SystemColor.info;
import org.is2.asa.factories.*;

//DAO design pattern used

public class AnimalDao implements Dao<Animal>{

    private List<Animal> animals = new ArrayList<>();
    private AbstractFactory<Animal> animalAbstractFactory;

    public AnimalDao() {
        this.animalAbstractFactory = new AnimalFactory();
    }

    @Override
    public Animal get(int id) {
        return animals.get(id);
    }

    @Override
    public List<Animal> getAll() {
        return animals;
    }

    //adding an animal to animals
    @Override
    public void add(Animal animal) {
        if(!existsAnimal(animal))  animals.add(animal);
        else System.out.println("This animal already exists. Please try again.");
    }

    //animal update
    @Override
    public void update(Animal animal) {

        if(existsAnimal(animal)){
            int i=findanimal(animal);
            animals.get(i).setName(animal.getName());
            animals.get(i).setAge(animal.getAge());
            animals.get(i).setWeight(animal.getWeight());
            animals.get(i).setDescription(animal.getDescription());
            animals.get(i).changeState(animal.getState());
        }
    }

    //checking if animal exists
    public boolean existsAnimal(Animal animal){
        int i = 0;
        boolean exists = false;
        while(!exists && i < animals.size()){
            if(Objects.equals(animals.get(i).getIdentifier(), animal.getIdentifier())) exists = true; // Null safe equals
            else i++;
        }
        return exists;
    }

    //deleting an animal from animals
    @Override
    public void delete(Animal animal) {
        animals.remove(animal);
    }

    //loading animals from json
    @Override
    public void load(InputStream in) {
        JSONObject jsonInput = new JSONObject(new JSONTokener(in));
        JSONArray animalArray = jsonInput.getJSONArray("animals");

        for(int i = 0; i < animalArray.length(); i++){
            add(animalAbstractFactory.generateObject(animalArray.getJSONObject(i)));
        }

    }

    //storing animals information into a json
    public String storeAsJSON(){
        JSONObject animalsJSON = new JSONObject();
        JSONArray animalsJSONArray = new JSONArray();

        for(Animal a : animals){
            animalsJSONArray.put(a.toJson());
        }
        animalsJSON.put("animals", animalsJSONArray);

        return animalsJSON.toString();
    }

    //finding animal in animals list
    public int findanimal(Animal animal){
        int i = 0;
        boolean exists = false;
        while(!exists && i < animals.size()){
            if(Objects.equals(animals.get(i).getIdentifier(), animal.getIdentifier())) exists = true; // Null safe equals
            else i++;
        }
        if (i==animals.size()) return -1;
        return i;
    }

}
