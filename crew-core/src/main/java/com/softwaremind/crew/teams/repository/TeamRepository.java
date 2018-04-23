package com.softwaremind.crew.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwaremind.crew.teams.model.Team;

/**
 * Teams repository class
 *
 * @author Mateusz Michoński
 * @author Wiktor Religo
 * @since 09.04.2018
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
