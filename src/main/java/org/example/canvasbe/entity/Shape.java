package org.example.canvasbe.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "shapes")
public class Shape {
    
    @Id
    private String id;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShapeType type;
    
    @Column(nullable = false)
    private Double x;
    
    @Column(nullable = false)
    private Double y;
    
    @Column(nullable = false)
    private Double width;
    
    @Column(nullable = false)
    private Double height;
    
    @Column(nullable = false)
    private Double rotation;
    
    @Column(nullable = false)
    private String color;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drawing_state_id")
    private DrawingState drawingState;
    
    public Shape() {
        this.id = UUID.randomUUID().toString();
    }
    
    public Shape(ShapeType type, Double x, Double y, Double width, Double height, Double rotation, String color) {
        this();
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
    
    public DrawingState getDrawingState() {
        return drawingState;
    }
    
    public void setDrawingState(DrawingState drawingState) {
        this.drawingState = drawingState;
    }
} 