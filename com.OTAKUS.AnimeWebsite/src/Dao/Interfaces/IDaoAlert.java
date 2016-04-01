package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Alert;

public interface IDaoAlert {
    public boolean insert(Alert Alert) throws DataAccessException, ClassNotFoundException, SQLException;
    public boolean delete(int episodeId,String username) throws DataAccessException, ClassNotFoundException, SQLException;
    public  List<Alert> getAll() throws DataAccessException, ClassNotFoundException, SQLException;
}
