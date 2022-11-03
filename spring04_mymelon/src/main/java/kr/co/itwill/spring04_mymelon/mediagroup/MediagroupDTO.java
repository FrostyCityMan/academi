package kr.co.itwill.spring04_mymelon.mediagroup;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediagroupDTO {

    private int mediagroupno;
    private String title;

    // 기본 생성자, getter, setter, toString
}
