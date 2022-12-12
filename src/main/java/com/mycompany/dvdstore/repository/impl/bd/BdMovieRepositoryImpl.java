package com.mycompany.dvdstore.repository.impl.bd;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class BdMovieRepositoryImpl extends NamedParameterJdbcDaoSupport implements MovieRepository {

    @Autowired
    BdMovieRepositoryImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Movie addMovie(Movie movie) {
        KeyHolder kh = new GeneratedKeyHolder();
        String sql = "INSERT INTO Movie (id, title, genre, description) " +
                "VALUES(:id, :title, :genre, :description)";
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(movie);
        getNamedParameterJdbcTemplate().update(sql, parameters, kh);
        movie.setId(kh.getKey().longValue());
        return movie;
    }

    @Override
    public List<Movie> list() {
        String sql = "Select id, title, genre from Movie";
        
        return getJdbcTemplate().query(sql,(rs, rowNum) -> {
         return new Movie(
                 rs.getLong("id"),
                 rs.getString("title"),
                 rs.getString("genre"));
        });
    }

    @Override
    public Movie getById(Long id) {
        String sql = "Select id, title, genre, description from Movie where id = ?";
        Movie movie = getJdbcTemplate().queryForObject(sql, (rs, rowNum) ->{
            return new Movie(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("genre"),
                    rs.getString(("description"))
            );
        }, id);
        return movie;
    }

}
