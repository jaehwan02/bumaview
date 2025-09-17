package org.example.backend.domain.folder.repository;

import org.example.backend.domain.folder.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
