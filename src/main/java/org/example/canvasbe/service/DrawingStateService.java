package org.example.canvasbe.service;

import org.example.canvasbe.dto.SavedDrawingStateDto;

public interface DrawingStateService {

    SavedDrawingStateDto saveDrawingState(SavedDrawingStateDto savedDrawingStateDto);

    SavedDrawingStateDto getDrawingStateByName(String name);
} 