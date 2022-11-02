package kr.co_itwill.mediagroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MediagroupDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    StringBuilder sql = null;

    public MediagroupDAO() {
        System.out.println("--------MediagroupDAO Start----------------");
    }

    //비즈니스 로직 구현
    public int create(MediagroupDTO dto) {
        int cnt = 0;
        try {
            sql = new StringBuilder();
            sql.append(" INSERT INTO mediagroup(mediagroupno, title )");
            sql.append(" VALUES (mediagroup_seq.nextval, ? ) ");
            cnt = jdbcTemplate.update(sql.toString(), dto.getTitle());
        } catch (Exception e) {
            System.out.println("미디어 그룹 등록 실패" + e);
        }//end
        return cnt;
    }

    public List<MediagroupDTO> list() {
        List<MediagroupDTO> list = null;
        try {
            sql = new StringBuilder();
            sql.append(" SELECT mediagroupno, title ");
            sql.append(" FROM mediagroup");
            sql.append(" ORDER BY mediagroupno DESC");
            RowMapper<MediagroupDTO> rowMapper = new RowMapper<MediagroupDTO>() {
                @Override
                public MediagroupDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                    MediagroupDTO dto = new MediagroupDTO();
                    dto.setMediagroupno(rs.getInt("mediagroupno"));
                    dto.setTitle(rs.getString("title"));
                    return dto;
                }
            };//end of rowmapper
            list = jdbcTemplate.query(sql.toString(), rowMapper);
        } catch (Exception e) {
            System.out.println("미디어 그룹 등록 실패" + e);
        }//end of try-catch
        return list;
    }//end of list
}//end of class
