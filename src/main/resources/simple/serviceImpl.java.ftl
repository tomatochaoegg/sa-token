package ${package.ServiceImpl};

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${superServiceImplClassPackage};
import ${package.Service}.${table.serviceName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    /**
     * 获取表格数据
     *
     * @param ${entity?uncap_first}
     * @return
     */
    public IPage<${entity}> getPageListByEntity(${entity} ${entity?uncap_first}) {
        LambdaQueryWrapper<${entity}> queryWrapper = Wrappers.lambdaQuery();
    <#list table.fields as field>
        <#if field.propertyType == "String" && !field.keyFlag>
        queryWrapper.like(StrUtil.isNotBlank(${entity?uncap_first}.get${field.capitalName}()), ${entity}::get${field.capitalName}, ${entity?uncap_first}.get${field.capitalName}());
        </#if>
    </#list>
        return super.page(${entity?uncap_first}, queryWrapper);
    }

}
</#if>
