package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Track;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findByTitle(String title);

}