package com.smartcity.DAO;

import com.smartcity.domain.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO {

    Comment save(Comment budget);

    Comment findById(Integer id);

    boolean deleteById(Integer id);
}
