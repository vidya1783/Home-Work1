package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(long parkId) {
        Park retrievedPark = null;
        String sqlGetPark = "SELECT park_id, park_name, date_established,area, has_camping " +
                "FROM park WHERE park_id = ?";
        SqlRowSet foundParks = jdbcTemplate.queryForRowSet(sqlGetPark, parkId);
        if(foundParks.next())
        {
            retrievedPark = mapRowToPark(foundParks);
        }
        return retrievedPark;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> stateParks = new ArrayList<>();
        String sql = "SELECT p.park_id, park_name, date_established, area, has_camping " +
                "FROM park P" +
                "INNER JOIN park_state ps ON p.park_id = ps.park_id"+
                "WHERE ps.state_abbreviation = ?;";
        SqlRowSet stateParkResults = jdbcTemplate.queryForObject ();
        return new ArrayList<Park>();
    }

    @Override
    public Park createPark(Park park) {
        return new Park();
    }

    @Override
    public void updatePark(Park park) {

    }

    @Override
    public void deletePark(long parkId) {

    }

    @Override
    public void addParkToState(long parkId, String stateAbbreviation) {

    }

    @Override
    public void removeParkFromState(long parkId, String stateAbbreviation) {

    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park newPark = new Park();
        newPark.setParkId(rowSet.getLong("park_id"));
        newPark.setParkName(rowSet.getString("park_name"));
        newPark.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        newPark.setArea(rowSet.getDouble("area"));
        newPark.setHasCamping(rowSet.getBoolean("has_camping"));

        return newPark;
    }
}
