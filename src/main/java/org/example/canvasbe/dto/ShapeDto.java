package org.example.canvasbe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import org.example.canvasbe.entity.ShapeType;

public class ShapeDto {
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("type")
    @NotNull(message = "Shape type is required")
    private ShapeType type;
    
    @JsonProperty("x")
    @NotNull(message = "X coordinate is required")
    @DecimalMin(value = "0.0", message = "X coordinate must be non-negative")
    private Double x;
    
    @JsonProperty("y")
    @NotNull(message = "Y coordinate is required")
    @DecimalMin(value = "0.0", message = "Y coordinate must be non-negative")
    private Double y;
    
    @JsonProperty("width")
    @NotNull(message = "Width is required")
    @DecimalMin(value = "0.1", message = "Width must be positive")
    private Double width;
    
    @JsonProperty("height")
    @NotNull(message = "Height is required")
    @DecimalMin(value = "0.1", message = "Height must be positive")
    private Double height;
    
    @JsonProperty("rotation")
    @NotNull(message = "Rotation is required")
    private Double rotation;
    
    @JsonProperty("color")
    @NotNull(message = "Color is required")
    private String color;
    
    public ShapeDto() {}
    
    public ShapeDto(String id, ShapeType type, Double x, Double y, Double width, Double height, Double rotation, String color) {
        this.id = id;
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.color = color;
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public ShapeType getType() {
        return type;
    }
    
    public void setType(ShapeType type) {
        this.type = type;
    }
    
    public Double getX() {
        return x;
    }
    
    public void setX(Double x) {
        this.x = x;
    }
    
    public Double getY() {
        return y;
    }
    
    public void setY(Double y) {
        this.y = y;
    }
    
    public Double getWidth() {
        return width;
    }
    
    public void setWidth(Double width) {
        this.width = width;
    }
    
    public Double getHeight() {
        return height;
    }
    
    public void setHeight(Double height) {
        this.height = height;
    }
    
    public Double getRotation() {
        return rotation;
    }
    
    public void setRotation(Double rotation) {
        this.rotation = rotation;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
} 