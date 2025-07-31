package org.example.canvasbe.service.impl;

import org.example.canvasbe.dto.SavedDrawingStateDto;
import org.example.canvasbe.dto.ShapeDto;
import org.example.canvasbe.entity.DrawingState;
import org.example.canvasbe.entity.Shape;
import org.example.canvasbe.exception.DrawingStateNotFoundException;
import org.example.canvasbe.repository.DrawingStateRepository;
import org.example.canvasbe.service.DrawingStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DrawingStateServiceImpl implements DrawingStateService {
    
    private final DrawingStateRepository drawingStateRepository;
    
    @Autowired
    public DrawingStateServiceImpl(DrawingStateRepository drawingStateRepository) {
        this.drawingStateRepository = drawingStateRepository;
    }
    
    @Override
    public SavedDrawingStateDto saveDrawingState(SavedDrawingStateDto savedDrawingStateDto) {
        // Convert DTO to entity
        DrawingState drawingState = convertToEntity(savedDrawingStateDto);
        
        // Save to database
        DrawingState savedDrawingState = drawingStateRepository.save(drawingState);
        
        // Convert back to DTO and return
        return convertToDto(savedDrawingState);
    }
    
    @Override
    public SavedDrawingStateDto getDrawingStateByName(String name) {
        DrawingState drawingState = drawingStateRepository.findByName(name)
                .orElseThrow(() -> new DrawingStateNotFoundException("Drawing state not found with name: " + name));
        
        return convertToDto(drawingState);
    }
    
    /**
     * Convert DrawingStateDto to DrawingState entity
     */
    private DrawingState convertToEntity(SavedDrawingStateDto dto) {
        DrawingState entity = new DrawingState(dto.getName());
        
        if (dto.getShapes() != null) {
            List<Shape> shapes = dto.getShapes().stream()
                    .map(this::convertShapeToEntity)
                    .collect(Collectors.toList());
            entity.setShapes(shapes);
        }
        
        return entity;
    }
    
    /**
     * Convert ShapeDto to Shape entity
     */
    private Shape convertShapeToEntity(ShapeDto dto) {
        Shape shape = new Shape();
        shape.setId(dto.getId());
        shape.setType(dto.getType());
        shape.setX(dto.getX());
        shape.setY(dto.getY());
        shape.setWidth(dto.getWidth());
        shape.setHeight(dto.getHeight());
        shape.setRotation(dto.getRotation());
        shape.setColor(dto.getColor());
        return shape;
    }
    
    /**
     * Convert DrawingState entity to DrawingStateDto
     */
    private SavedDrawingStateDto convertToDto(DrawingState entity) {
        List<ShapeDto> shapeDtos = entity.getShapes().stream()
                .map(this::convertShapeToDto)
                .collect(Collectors.toList());
        
        return new SavedDrawingStateDto(entity.getName(), shapeDtos);
    }
    
    /**
     * Convert Shape entity to ShapeDto
     */
    private ShapeDto convertShapeToDto(Shape entity) {
        return new ShapeDto(
                entity.getId(),
                entity.getType(),
                entity.getX(),
                entity.getY(),
                entity.getWidth(),
                entity.getHeight(),
                entity.getRotation(),
                entity.getColor()
        );
    }
} 