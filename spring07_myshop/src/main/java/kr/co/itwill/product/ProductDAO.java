package kr.co.itwill.product;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {

    public ProductDAO() {
        System.out.println("ProductDAO started");
    }

    //스프링 빈으로 생성된 객체를 가져옴
    @Autowired
    SqlSession sqlSession;

    public List<Map<String, Object>> list() {
        return sqlSession.selectList("product.list");
    }

    //Map insert
    public void insert(Map<String, Object> map) {
        sqlSession.insert("product.insert", map);
    }

    //void search
    public List<Map<String, Object>> search(String product_name) {
        return sqlSession.selectList("product.search", "%" + product_name + "%");
    }//end of search

    //Map detail
    public Map<String, Object> detail(String product_code) {
        return sqlSession.selectOne("product.detail", product_code);
    }//end of detail

    //Map update
    public void update(Map<String, Object> map) {
        sqlSession.update("product.update", map);
    }

    //String filename
    public String filename(int product_code) {
        return sqlSession.selectOne("product.filename", product_code);
    }//end of filename

    //Map delete int code
    public void delete(int product_code) {
        sqlSession.delete("product.delete", product_code);
    }//end of delete


} //end of ProductDAO class
