package com.xuecheng.manage_cms.dao;


import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest  {
    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void findAll(){

        List<CmsPage> all= cmsPageRepository.findAll();
        System.out.println(all);
    }

    //测试分页查询
    @Test
    public void findPage(){
        int page=0;
        int size=10;
        Pageable pageable= PageRequest.of(page,size);
        Page<CmsPage> alls= cmsPageRepository.findAll(pageable);
        System.out.println(alls);
    }

}
