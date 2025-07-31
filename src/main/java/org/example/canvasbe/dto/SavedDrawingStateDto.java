package org.example.canvasbe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class SavedDrawingStateDto {
    
    @JsonProperty("canvasName")
    @NotBlank(message = "canvasName is required")
    private String name;
    
    @JsonProperty("canvas")
    @NotNull(message = "canvas list is required")
    private List<ShapeDto> shapes;
    
    public SavedDrawingStateDto() {}
    
    public SavedDrawingStateDto(String name, List<ShapeDto> shapes) {
        this.name = name;
        this.shapes = shapes;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<ShapeDto> getShapes() {
        return shapes;
    }
    
    public void setShapes(List<ShapeDto> shapes) {
        this.shapes = shapes;
    }
} 