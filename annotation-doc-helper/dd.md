# Spring Boot 全注解速查手册（超全整理版）

---

## 一、核心配置注解
| 注解                          | 说明                                                                                    | 示例                                                                 |
|------------------------------|---------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| `@SpringBootApplication`      | 主启动类注解，包含`@Configuration`+`@EnableAutoConfiguration`+`@ComponentScan`         | `@SpringBootApplication\npublic class App { ... }`                 |
| `@Configuration`             | 声明为配置类                                                                           | `@Configuration\npublic class AppConfig { ... }`                   |
| `@ComponentScan`             | 组件扫描路径                                                                           | `@ComponentScan({"com.service", "com.dao"})`                       |
| `@Import`                    | 导入其他配置类                                                                         | `@Import({SecurityConfig.class, CacheConfig.class})`              |
| `@ConditionalOnProperty`     | 根据配置条件实例化Bean                                                                 | `@ConditionalOnProperty(name="feature.enabled", havingValue="true")` |
| `@ConditionalOnClass`        | 当类路径存在指定类时生效                                                               | `@ConditionalOnClass(DataSource.class)`                           |

---

## 二、Web开发注解
| 注解                          | 说明                                                                                    | 示例                                                                 |
|------------------------------|---------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| `@RestController`            | 组合`@Controller`+`@ResponseBody`                                                     | `@RestController\npublic class UserController { ... }`             |
| `@RequestMapping`            | 请求映射通用注解                                                                       | `@RequestMapping(value="/api", method=RequestMethod.GET)`          |
| `@GetMapping`                | GET请求映射                                                                            | `@GetMapping("/users/{id}")`                                      |
| `@PostMapping`               | POST请求映射                                                                           | `@PostMapping("/users")`                                          |
| `@RequestParam`              | 获取URL参数                                                                            | `getUser(@RequestParam(defaultValue="0") int id)`                  |
| `@PathVariable`              | 获取路径变量                                                                           | `@GetMapping("/users/{id}")`                                      |
| `@RequestBody`               | 获取请求体内容                                                                         | `createUser(@RequestBody User user)`                               |
| `@ResponseStatus`            | 自定义响应状态码                                                                       | `@ResponseStatus(HttpStatus.CREATED)`                             |
| `@CrossOrigin`               | 允许跨域请求                                                                           | `@CrossOrigin(origins = "https://domain.com")`                     |
| `@ExceptionHandler`          | 控制器异常处理                                                                         | `@ExceptionHandler(NotFoundException.class)`                       |

---

## 三、数据访问注解
| 注解                          | 说明                                                                                    | 示例                                                                 |
|------------------------------|---------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| `@Entity`                    | JPA实体类声明                                                                          | `@Entity\n@Table(name = "t_users")`                                |
| `@Repository`                | 数据仓库组件                                                                           | `@Repository\npublic interface UserRepo extends JpaRepository<...>`|
| `@Transactional`             | 声明式事务                                                                             | `@Transactional(rollbackFor = Exception.class)`                    |
| `@Query`                     | 自定义查询语句                                                                         | `@Query("SELECT u FROM User u WHERE u.age > :age")`                |
| `@Modifying`                 | 标记数据修改操作                                                                       | `@Modifying\n@Query("UPDATE User u SET u.name=?1 WHERE u.id=?2")`  |
| `@EnableJpaRepositories`     | 启用JPA仓库                                                                            | `@EnableJpaRepositories("com.example.dao")`                        |

---

## 四、功能增强注解
| 注解                          | 说明                                                                                    | 示例                                                                 |
|------------------------------|---------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| `@Scheduled`                 | 定时任务                                                                               | `@Scheduled(fixedRate = 5000)`                                    |
| `@Async`                     | 异步方法调用                                                                           | `@Async\npublic void asyncProcess() { ... }`                       |
| `@Cacheable`                 | 方法结果缓存                                                                           | `@Cacheable(value="users", key="#id")`                             |
| `@CacheEvict`                | 清除缓存                                                                               | `@CacheEvict(value="users", allEntries=true)`                      |
| `@Aspect`                    | 声明切面类                                                                             | `@Aspect\n@Component`                                              |
| `@Around`                    | 环绕通知                                                                               | `@Around("execution(* com.service.*.*(..))")`                       |

---

## 五、配置与属性注解
| 注解                          | 说明                                                                                    | 示例                                                                 |
|------------------------------|---------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| `@Value`                     | 注入单个属性                                                                           | `@Value("${app.timeout:3000}") private int timeout;`               |
| `@ConfigurationProperties`   | 批量绑定属性                                                                           | `@ConfigurationProperties(prefix = "spring.datasource")`           |
| `@PropertySource`            | 加载外部配置文件                                                                       | `@PropertySource("classpath:custom.yml")`                          |
| `@EnableConfigurationProperties` | 启用配置属性绑定                                                                 | `@EnableConfigurationProperties(DataSourceProperties.class)`       |

---

## 六、测试相关注解
| 注解                          | 说明                                                                                    | 示例                                                                 |
|------------------------------|---------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| `@SpringBootTest`            | 集成测试入口                                                                           | `@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)`     |
| `@WebMvcTest`                | Web层切片测试                                                                          | `@WebMvcTest(UserController.class)`                                |
| `@DataJpaTest`               | JPA测试切片                                                                            | `@DataJpaTest\npublic class UserRepositoryTest { ... }`            |
| `@MockBean`                  | 创建Mock Bean                                                                          | `@MockBean private UserService userService;`                       |
| `@Test`                      | 标记测试方法                                                                           | `@Test\nvoid testCreateUser() { ... }`                             |
| `@TestPropertySource`        | 测试专用配置                                                                           | `@TestPropertySource(properties = {"app.env=test"})`               |

---

## 七、安全相关注解（Spring Security）
| 注解                          | 说明                                                                                    | 示例                                                                 |
|------------------------------|---------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| `@EnableWebSecurity`         | 启用Web安全                                                                            | `@EnableWebSecurity\npublic class SecurityConfig { ... }`          |
| `@PreAuthorize`              | 方法级权限控制                                                                         | `@PreAuthorize("hasRole('ADMIN')")`                                |
| `@PostAuthorize`             | 方法执行后权限验证                                                                     | `@PostAuthorize("returnObject.owner == authentication.name")`      |
| `@Secured`                   | 角色验证                                                                               | `@Secured({"ROLE_USER", "ROLE_ADMIN"})`                            |
| `@WithMockUser`              | 测试时模拟用户                                                                         | `@WithMockUser(username="admin", roles={"ADMIN"})`                 |

---

## 八、监控与健康检查（Actuator）
| 注解                          | 说明                                                                                    | 示例                                                                 |
|------------------------------|---------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| `@Endpoint`                  | 自定义Actuator端点                                                                     | `@Endpoint(id = "custom")`                                         |
| `@ReadOperation`             | 定义GET端点操作                                                                        | `@ReadOperation\npublic String info() { ... }`                     |
| `@WriteOperation`            | 定义POST端点操作                                                                       | `@WriteOperation\npublic void reload() { ... }`                    |
| `@HealthIndicator`           | 自定义健康检查                                                                         | `@Component\n@HealthIndicator("my-service")`                       |

---

## 九、验证相关注解（Validation）
| 注解                          | 说明                                                                                    | 示例                                                                 |
|------------------------------|---------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| `@Valid`                     | 触发参数验证                                                                           | `createUser(@Valid @RequestBody User user)`                        |
| `@NotBlank`                  | 字符串非空验证                                                                         | `@NotBlank private String username;`                               |
| `@Email`                     | 邮箱格式验证                                                                           | `@Email private String email;`                                     |
| `@Size`                      | 长度/大小验证                                                                          | `@Size(min=6, max=20) private String password;`                     |
| `@Pattern`                   | 正则验证                                                                               | `@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")`                      |

---

> 📌 **使用说明**
> 1. 按模块快速定位所需注解
> 2. 在IDE中配合`Ctrl+点击`查看源码文档
> 3. 组合使用注解实现复杂功能（如`@Valid`+`@RequestBody`）
>
> 🔗 **扩展资源**
> - [Spring Boot官方文档](https://spring.io/projects/spring-boot)
> - [Spring注解驱动开发实战](https://www.example.com)