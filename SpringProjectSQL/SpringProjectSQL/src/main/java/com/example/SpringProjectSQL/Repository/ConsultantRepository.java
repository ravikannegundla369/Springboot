package com.example.SpringProjectSQL.Repository;

import com.example.SpringProjectSQL.model.Consultant;
import com.example.SpringProjectSQL.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepository extends JpaRepository<Consultant,Integer> {

}
