package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoComment;
import beans.Comment;

public class CommentDao implements IDaoComment<Comment,Integer>{

	@Override
	public boolean insert(Comment Comment) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer commentId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Comment Comment) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Comment> getAll(Integer episodeId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
