package org.is2.asa.dao;

import org.is2.asa.model.Animal;
import org.is2.asa.model.Dog;
import org.is2.asa.model.Species;
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

    public AnimalDao(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public Animal get(int id) {
        return animals.get(id);
    }

    @Override
    public List<Animal> getAll() {
        return animals;
    }

    @Override
    public void add(Animal animal) {
        if(!existsAnimal(animal))  animals.add(animal);
        else System.out.println("This animal already exists. Please try again.");
    }

    @Override
    public void update(Animal animal) {
        if(existsAnimal(animal)){
            animals.get(animal.getIdentifier()).setName(animal.getName());
            animals.get(animal.getIdentifier()).setAge(animal.getAge());
            animals.get(animal.getIdentifier()).setWeight(animal.getWeight());
            animals.get(animal.getIdentifier()).setDescription(animal.getDescription());
            animals.get(animal.getIdentifier()).changeState(animal.getState());
            animals.get(animal.getIdentifier()).setLinkedUser(animal.getLinkedUser());
        }
    }

    public boolean existsAnimal(Animal animal){
        int i = 0;
        boolean exists = false;
        while(!exists && i < animals.size()){
            if(Objects.equals(animals.get(i).getIdentifier(), animal.getIdentifier())) exists = true; // Null safe equals
            else i++;
        }
        return exists;
    }

    @Override
    public void delete(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void load(InputStream in) {
        JSONObject jsonInput = new JSONObject(new JSONTokener(in));
        JSONArray animalArray = jsonInput.getJSONArray("animals");
        Animal animalAux;

        for(int i = 0; i < animalArray.length(); i++){
            add(animalAbstractFactory.generateObject(animalArray.getJSONObject(i)));
        }

    }

}
