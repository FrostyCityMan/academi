package net.mem;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemMainTest {

    public static void main(String[] args) {
        // MyBatis-3 기반 JDBC연습

        try {
            //1) DB 환경 설정 관련 파일 가져오기
            String resource = "config/jdbc.xml";
            InputStream is = Resources.getResourceAsStream(resource);

            //2) DB연결하기 위한 팩토리빈 생성
            //   -> DBOpen + MemberDAO
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
            System.out.println("-------DB연결 성공");

            //3)쿼리문 생성
            //  -> PreparedStatement와 비슷한 기능
            SqlSession sql = ssf.openSession(true);

            //4)쿼리문 실행
            // 행추가
//            int result=sql.insert("mem.insertRow",new MemDTO("오필승",25));
//            sql.insert("mem.insertRow",new MemDTO("낙화",25));
//            sql.insert("mem.insertRow",new MemDTO("김도훈",43));
//            sql.insert("mem.insertRow",new MemDTO("전우치",21));
//            sql.insert("mem.insertRow",new MemDTO("진달래",65));
//            sql.insert("mem.insertRow",new MemDTO("개나리",35));
//            System.out.println("행추가 결과"+result);

            //행수정
            // ->rownum4 행의 이름과 나이 수정하기
//            int result = sql.update("mem.updateRow", new MemDTO(3, "낙화", 28));
//            System.out.println("행수정 결과" + result);

            //행삭제
            // age=25 delete
//            int result = sql.delete("mem.deleteRow", new MemDTO("오필승", 25));
//            System.out.println("행삭제 결과"+result);
//
//            // 전체목록
//            //selectList
//            List<MemDTO> list = sql.selectList("mem.selectAll");
//            for (int i = 0; i < list.size(); i++) {
//                MemDTO dto = list.get(i);
//                System.out.print(dto.getNum() + " ");
//                System.out.print(dto.getName() + " ");
//                System.out.print(dto.getAge() + " ");
//                System.out.println();
//
//            }//end of for

            //이름에 '화'글자가 있는 행 검색
            // list search name '*화*'
//            List<MemDTO> list = sql.selectList("mem.search", "화");
//            for (int i = 0; i < list.size(); i++) {
//                MemDTO dto = list.get(i);
//                System.out.print(dto.getNum() + " ");
//                System.out.print(dto.getName() + " ");
//                System.out.print(dto.getAge() + " ");
//                System.out.println();
//            }//end of for


            // dd 검색
            // ->num=12 행 검색보기
            // read rownum3
            MemDTO dto = sql.selectOne("mem.readRow", 21);
            System.out.print(dto.getNum() + " ");
            System.out.print(dto.getName() + " ");
            System.out.print(dto.getAge() + " ");
            System.out.println();

        } catch (Exception e) {
            System.out.println("실패: " + e);
        }

    }//main() end
}//class end