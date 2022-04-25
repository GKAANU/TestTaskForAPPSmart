package com.KaanCaseForAPPSmart.API;

import com.KaanCaseForAPPSmart.API.pojo.Category;
import com.KaanCaseForAPPSmart.API.pojo.Pet;
import com.KaanCaseForAPPSmart.API.pojo.Tag;

import java.util.ArrayList;
import java.util.List;

public class ApiExecutor {

    /**
     * Methods
     */

    public static Pet initializePet(String animalCategory, String animalName, String animalTag){
        Pet myPet = new Pet();
        Tag tag = new Tag();
        Category category = new Category();

        category.setName(animalCategory);
        tag.setName(animalTag);
        myPet.setName(animalName);
        List<Tag> tagList = new ArrayList<Tag>();
        tagList.add(tag);
        myPet.setTags(tagList);
        myPet.setCategory(category);
        myPet.setStatus("available");
        return myPet;
    }


}
