package com.vengat.Student.repo;

import com.vengat.Student.model.Student;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s){
        System.out.println("saving " + s);
        String sql = "Insert into student ( id , name, marks ) values (?, ?, ?)";
        int rows = jdbc.update(sql, s.getId(),s.getName(),s.getMarks() );
        System.out.println(rows);
    }

    public List<Student> findAll() {

        String sql="select * from student";

        RowMapper<Student> mapper=new
                RowMapper<Student>() {

                    @Override
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException
                    {
                        Student s=new Student();
                        s.setId(rs.getInt("id"));
                        s.setName(rs.getString("name"));
                        s.setMarks(rs.getInt("marks"));
                        return s;
                    }
                };
        return jdbc.query(sql, mapper); }
}
