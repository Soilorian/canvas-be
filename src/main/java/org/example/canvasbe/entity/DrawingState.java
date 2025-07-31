package org.example.canvasbe.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "drawing_states")
public class DrawingState {
    
    @Id
    private String id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @OneToMany(mappedBy = "drawingState", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Shape> shapes = new ArrayList<>();
    
    public DrawingState() {
        this.id = UUID.randomUUID().toString();
    }
    
    public DrawingState(String name) {
        this();
        this.name = name;
    }
    
    public DrawingState(String name, List<Shape> shapes) {
        this(name);
        this.shapes = shapes;
        if (shapes != null) {
            shapes.forEach(shape -> shape.setDrawingState(this));
        }
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Shape> getShapes() {
        return shapes;
    }
    
    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
        if (shapes != null) {
            shapes.forEach(shape -> shape.setDrawingState(this));
        }
    }
    
    public void addShape(Shape shape) {
        shapes.add(shape);
        shape.setDrawingState(this);
    }
    
    public void removeShape(Shape shape) {
        shapes.remove(shape);
        shape.setDrawingState(null);
    }
} 