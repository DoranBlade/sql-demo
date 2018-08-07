package top.apower.sqldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan({
        "top.apower.sqldemo.mapper",
        "top.apower.sqldemo.mapper.custom"
})
public class SqlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlDemoApplication.class, args);
    }
}
