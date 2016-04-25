package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoComment;
import beans.Comment;

public class CommentDao implements IDaoComment<Comment,Integer>{

	@Override
	public boolean insert(Comment comment) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs;
		rs=DaoConnection.getConnection().update("insert into user_comment values(?,?,?,?,systimestamp)",
				comment.getId(),
				comment.getEpisode(),
				comment.getUser().getUserName(),
				comment.getComment());
		return DaoTools.getResult(rs);
	}

	@Override
	public boolean delete(Integer commentId) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs;
		rs=DaoConnection.getConnection().update("delete from user_comment where id_comment="+commentId);
		return DaoTools.getResult(rs);
	}

	@Override
	public boolean update(Comment comment) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs;
		rs=DaoConnection.getConnection().update("update user_comment set message=? where id_comment=?",comment.getComment(),comment.getId());
		return DaoTools.getResult(rs);
	}

	@Override
	public List<Comment> getAll(Integer episodeId) throws DataAccessException, ClassNotFoundException, SQLException {
		return  DaoConnection.getConnection().query("select * from user_comment natural join visitor  where id_episode="+episodeId,new Comment());
	}

	@Override
	public int getNextCommentId() throws DataAccessException, ClassNotFoundException, SQLException {
		return  DaoConnection.getConnection().queryForObject("select user_comment_seq.nextVal from dual",Integer.class);
	}
    
}
