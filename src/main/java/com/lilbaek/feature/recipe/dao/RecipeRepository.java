package com.lilbaek.feature.recipe.dao;

import com.lilbaek.feature.recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findByCategoryIgnoreCaseOrderByDateDesc(String category);
    List<Recipe> findByNameContainingIgnoreCaseOrderByDateDesc(String name);
}