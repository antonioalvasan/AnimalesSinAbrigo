package org.is2.asa.control;

import org.is2.asa.dao.AnimalDao;
import org.is2.asa.model.Animal;

import java.util.List;

public class AnimalListController {

    AnimalDao animalDao;

    public AnimalListController(AnimalDao animalDao){
        this.animalDao=animalDao;
    }


    public List<Animal> getAll() {
        return animalDao.getAll();
    }
}
