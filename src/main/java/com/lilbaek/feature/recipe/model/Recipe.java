package com.lilbaek.feature.recipe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Recipe")
public class Recipe {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column(name = "UserEmail")
    @JsonIgnore
    private String userEmail;

    @Column(name = "Name")
    @NotBlank
    private String name;

    @Column(name = "Description")
    @NotBlank
    private String description;

    @Column(name = "Category")
    @NotBlank
    private String category;

    @Column(name = "Date")
    private LocalDateTime date;

    @Column(name = "Ingredients")
    @ElementCollection
    @NotEmpty
    private List<String> ingredients;

    @Column(name = "Directions")
    @ElementCollection
    @NotEmpty
    private List<String> directions;

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", ingredients=" + ingredients +
                ", directions=" + directions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id) && Objects.equals(userEmail, recipe.userEmail) && Objects.equals(name, recipe.name) && Objects.equals(description, recipe.description) && Objects.equals(category, recipe.category) && Objects.equals(date, recipe.date) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(directions, recipe.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEmail, name, description, category, date, ingredients, directions);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void update(Recipe recipe) {
        setName(recipe.getName());
        setDescription(recipe.getDescription());
        setIngredients(recipe.getIngredients());
        setDirections(recipe.getDirections());
        setCategory(recipe.getCategory());
        setDate(LocalDateTime.now());
    }
}