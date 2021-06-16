package ${package.Controller};

import io.swagger.annotations.Api;
import ${package.Entity}.${entity};
import ${package.ServiceImpl}.${table.serviceImplName};
import org.springframework.web.bind.annotation.*;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
@Api(value = "${table.controllerName}", tags = {"${table.comment!}操作接口"})
public class ${table.controllerName} extends ${superControllerClass}<${table.serviceImplName},${entity}> {
<#else>
public class ${table.controllerName} {
</#if>

}
</#if>
