package com.smartcity.DAO;

import com.smartcity.domain.Comment;

public interface CommentDAO {

    Comment save(Comment budget);

    Comment findById(Integer id);

    boolean deleteById(Integer id);
}
