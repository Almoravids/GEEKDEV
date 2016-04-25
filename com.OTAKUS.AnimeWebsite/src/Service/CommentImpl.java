package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.CommentDao;
import Service.interfaces.IComment;
import beans.Comment;

public class CommentImpl implements IComment<Comment,Integer> {
     CommentDao commentDao;
     {
    	 commentDao=new CommentDao();
     }
	@Override
	public boolean insert(Comment comment) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=commentDao.insert(comment);
		return rs;
	}

	@Override
	public boolean delete(Integer commentId) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=commentDao.delete(commentId);
		return rs;
	}

	@Override
	public boolean update(Comment comment) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=commentDao.update(comment);
		return rs;
	}

	@Override
	public List<Comment> get(Integer episodeId) throws DataAccessException, ClassNotFoundException, SQLException {
		return commentDao.getAll(episodeId);
	}

	@Override
	public int getNextCommentId() throws DataAccessException, ClassNotFoundException, SQLException {
		return commentDao.getNextCommentId();
	}

}
