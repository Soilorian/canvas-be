package org.example.canvasbe.controller;

import org.example.canvasbe.dto.SavedDrawingStateDto;
import org.example.canvasbe.service.DrawingStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping()
@CrossOrigin(origins = "*")
public class DrawingStateController {
    
    private final DrawingStateService drawingStateService;
    
    @Autowired
    public DrawingStateController(DrawingStateService drawingStateService) {
        this.drawingStateService = drawingStateService;
    }

    @PostMapping("/api/canvas/save")
    public ResponseEntity<SavedDrawingStateDto> saveDrawingState(@Valid @RequestBody SavedDrawingStateDto savedDrawingStateDto) {
        SavedDrawingStateDto savedDrawingState = drawingStateService.saveDrawingState(savedDrawingStateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDrawingState);
    }

    @GetMapping("/api/canvas/load")
    public ResponseEntity<SavedDrawingStateDto> getDrawingStateByName(@RequestParam("canvasName") String name) {
        SavedDrawingStateDto drawingState = drawingStateService.getDrawingStateByName(name);
        return ResponseEntity.ok(drawingState);
    }
}