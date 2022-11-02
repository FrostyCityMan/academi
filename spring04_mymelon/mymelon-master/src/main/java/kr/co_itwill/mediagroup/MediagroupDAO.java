package kr.co_itwill.mediagroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MediagroupDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    StringBuilder sql=null;
    public MediagroupDAO() {
        System.out.println("--------MediagroupDAO Start----------------");
    }
    //비즈니스 로직 구현
    public int create(MediagroupDTO dto) {
        int cnt=0;
        try{

        }catch(Exception e){
            System.out.println("미디어 그룹 등록 실패"+e);
        }//end
    return cnt;
    }
}//end of class
