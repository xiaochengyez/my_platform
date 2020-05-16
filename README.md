# my_platform
测试平台的实现
##一、增加实体类

```$xslt
@Data
@Entity(name = "cases")
@Table(name = "interface_cases")
@ApiModel(description = "用例模型")
public class Cases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "id必须为空")
    @Column(name = "id")
    @ApiModelProperty(value = "用例ID", name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "用例名不能为空")
    @ApiModelProperty(value = "用例名称", name = "name", required = true, example = "登录用例")
    private String name;
 
```

##二、dao层编码
 ```$xslt
      
 @Repository
 public interface CaseRepository extends JpaRepository<Cases,Long> {

 }
     
 ```
  
##三、service层用例

```$xslt

public interface CaseService {
    long getCount();

    List<Cases> findAll();

    Optional<Cases> findUserById(Long id);

    Cases save(Cases user);

    void update(Long id,String name);

    void deleteById(Long id);

    
```

##四、controller层用例

```$xslt

@RestController
@RequestMapping(value = "/case",produces = "application/json")
public class CaseControllor {

    @Autowired
    private CaseService caseService;

    @GetMapping("/findById")
    public ResponseResult<Cases> findcaseById( Long id){

        Cases cases= caseService.findUserById(id);
        return ResponseResult.successWithData(cases);
    }


    
```


##五、启动查看Swagger文档
###1、使用jenkinsfile自动打包容器化部署
###2、使用dockerfile创建新镜像

http://localhost:8801/cases/swagger-ui.html#/

![swagger](https://github.com/little-success/auto_test_platform/blob/master/document/img/swagger.jpg)



![Relative date](https://img.shields.io/date/1589909993)
![language](https://img.shields.io/badge/language-java-green.svg)
