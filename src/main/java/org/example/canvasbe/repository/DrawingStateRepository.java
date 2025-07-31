package org.example.canvasbe.repository;

import org.example.canvasbe.entity.DrawingState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrawingStateRepository extends JpaRepository<DrawingState, String> {

    Optional<DrawingState> findByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);
} 