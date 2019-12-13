package com.example.demo.pojo;

public class Pet {
    private Integer id;

    private String petName;

    private Integer petType;

    private String petImagePath;

    private String petContent;

    private Double petPrice;

    private Integer petAge;

    private Integer petVariety;

    private String petComment;

    private Integer petState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName == null ? null : petName.trim();
    }

    public Integer getPetType() {
        return petType;
    }

    public void setPetType(Integer petType) {
        this.petType = petType;
    }

    public String getPetImagePath() {
        return petImagePath;
    }

    public void setPetImagePath(String petImagePath) {
        this.petImagePath = petImagePath == null ? null : petImagePath.trim();
    }

    public String getPetContent() {
        return petContent;
    }

    public void setPetContent(String petContent) {
        this.petContent = petContent == null ? null : petContent.trim();
    }

    public Double getPetPrice() {
        return petPrice;
    }

    public void setPetPrice(Double petPrice) {
        this.petPrice = petPrice;
    }

    public Integer getPetAge() {
        return petAge;
    }

    public void setPetAge(Integer petAge) {
        this.petAge = petAge;
    }

    public Integer getPetVariety() {
        return petVariety;
    }

    public void setPetVariety(Integer petVariety) {
        this.petVariety = petVariety;
    }

    public String getPetComment() {
        return petComment;
    }

    public void setPetComment(String petComment) {
        this.petComment = petComment == null ? null : petComment.trim();
    }

    public Integer getPetState() {
        return petState;
    }

    public void setPetState(Integer petState) {
        this.petState = petState;
    }
}