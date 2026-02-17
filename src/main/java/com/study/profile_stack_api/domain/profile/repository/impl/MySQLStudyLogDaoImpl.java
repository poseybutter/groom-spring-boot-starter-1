package com.study.profile_stack_api.domain.profile.repository.impl;

import com.study.profile_stack_api.domain.profile.entity.Position;
import com.study.profile_stack_api.domain.profile.entity.Profile;
import com.study.profile_stack_api.domain.profile.repository.dao.ProfileDao;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class MySQLStudyLogDaoImpl implements ProfileDao {
    // DB 접근을 도와주는 jdbc 유틸
    private final JdbcTemplate jdbcTemplate;
    public MySQLStudyLogDaoImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    // === Create ===
    @Override
    public Profile save(Profile profile) {
        return null;
    }

    // === Read ===
    @Override
    public Optional<Profile> findById(Long id) {
        String sql = "SELECT * FROM profile WHERE id = ?";
        try {
            Profile profile = jdbcTemplate.queryForObject(sql, (row, index) -> {
                Profile item = new Profile();
                item.setId(row.getLong("id"));
                item.setName(row.getString("name"));
                item.setEmail(row.getString("email"));
                item.setBio(row.getString("bio"));
                String position = row.getString("position");
                item.setPosition(Position.valueOf(position));
                item.setCareerYears(row.getInt("career_years"));
                item.setGithubUrl(row.getString("github_url"));
                item.setBlogUrl(row.getString("blog_url"));
                item.setCreatedAt(row.getTimestamp("created_at").toLocalDateTime());
                item.setUpdatedAt(row.getTimestamp("updated_at").toLocalDateTime());
                return item;
            }, id);
            return Optional.ofNullable(profile);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Profile> findWithPage(int offset, int limit) {
        return List.of();
    }

    @Override
    public List<Profile> findByPosition(String position) {
        return List.of();
    }


    // === Update ===
    @Override
    public Optional<Profile> update(Profile profile) {
        return Optional.empty();
    }


    // === Delete ===
    @Override
    public boolean deleteById(Long id) {
        return false;
    }


    // === Utils ===
    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
