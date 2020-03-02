package com.aladdin.nacos.provider.dao.self;

import com.aladdin.nacos.provider.entity.self.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;

/**
 * @author lgc
 **/
@Repository
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 分页查询
     * <p>
     * page 参数必须放第一个，后面可以加自定义参数，在xml获取
     *
     * @param page
     * @return
     */
    IPage<Student> listStudentPage(Page page);
}
