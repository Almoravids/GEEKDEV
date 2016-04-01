package Service.interfaces;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import beans.Alert;

public interface IAlert {
    public boolean insert(Alert Alert) throws DataAccessException, ClassNotFoundException, SQLException;
    public boolean delete(int episodeId,String username) throws DataAccessException, ClassNotFoundException, SQLException;
}
