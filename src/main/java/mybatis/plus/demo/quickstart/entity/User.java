package mybatis.plus.demo.quickstart.entity;

import lombok.Data;

/**
 * @ClassName User
 * @Description
 * @Author fanglichun
 * @Date 2020-08-16 16:46
 * @Version 1.0
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
