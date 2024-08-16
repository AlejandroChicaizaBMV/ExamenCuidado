package DataAccess;

import java.util.List;

public interface IDAO<T> {

    public boolean create(T entity) throws Exception;

    public List<T> readAll() throws Exception;

    public boolean update(T entity) throws Exception;

    public boolean delete(Integer n) throws Exception;

    public T readBy(Integer n) throws Exception;

    public Integer getMaxRow() throws Exception;
}