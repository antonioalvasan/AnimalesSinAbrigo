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

//DAO design pattern used

public class DogAnimalDao implements Dao<Dog>{

    private List<Dog> animals = new ArrayList<Dog>();

    public DogAnimalDao(List<Dog> animals) {
        this.animals = animals;
    }

    @Override
    public Dog get(int id) {
        return animals.get(id);
    }

    @Override
    public List<Dog> getAll() {
        return animals;
    }

    @Override
    public void add(Dog animal) {
        if(!existsAnimal(animal))  animals.add(animal);
        else System.out.println("This animal already exists. Please try again.");
    }

    @Override
    public void update(Dog animal) {
        if(existsAnimal(animal)){
            animals.get(animal.getIdentifier()).setName(animal.getName());
            animals.get(animal.getIdentifier()).setAge(animal.getAge());
            animals.get(animal.getIdentifier()).setWeight(animal.getWeight());
            animals.get(animal.getIdentifier()).setDescription(animal.getDescription());
            animals.get(animal.getIdentifier()).changeState(animal.getState());
        }
    }

    public boolean existsAnimal(Dog animal){
        int i = 0;
        boolean exists = false;
        while(!exists && i < animals.size()){
            if(Objects.equals(animals.get(i).getIdentifier(), animal.getIdentifier())) exists = true; // Null safe equals
            else i++;
        }
        return exists;
    }

    @Override
    public void delete(Dog animal) {
        animals.remove(animal);
    }

    @Override
    public void load(InputStream in) {
        JSONObject jsonInput = new JSONObject(new JSONTokener(in));
        JSONArray animalArray = jsonInput.getJSONArray("animals");
        Dog animalAux;

        for (int i = 0; i < animalArray.length(); i++){
           // animalAux = createInstance(animalArray.getJSONObject(i));
           // animals.add(animalAux);
        }
        
    }

    //Factory need - *temporary*
    /*
    private Dog createInstance(JSONObject info) {
        int identifier, age;
        String name, description;
        Species species;
        double weight;


        if(info.getString("species").equals("DOG")) species = Species.DOG;
        else return null;

        JSONObject data = info.getJSONObject("data");
        identifier = data.getInt("Identifier");
        name = data.getString("Name");
        age = data.getInt("Age");
        weight = data.getDouble("Weight");
        description = data.getString("Description");

        return new Dog(identifier, name, age, weight, description, species);

    }*/
}
