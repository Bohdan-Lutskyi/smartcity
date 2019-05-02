package com.smartcity.DAO;

import com.smartcity.domain.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO {

    Comment create(Comment comment);

    Comment get(long id);

    Comment update(Comment comment);

    boolean delete(long id);
}
