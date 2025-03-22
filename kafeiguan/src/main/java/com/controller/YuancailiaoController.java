
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 原材料
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yuancailiao")
public class YuancailiaoController {
    private static final Logger logger = LoggerFactory.getLogger(YuancailiaoController.class);

    @Autowired
    private YuancailiaoService yuancailiaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = yuancailiaoService.queryPage(params);

        //字典表数据转换
        List<YuancailiaoView> list =(List<YuancailiaoView>)page.getList();
        for(YuancailiaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YuancailiaoEntity yuancailiao = yuancailiaoService.selectById(id);
        if(yuancailiao !=null){
            //entity转view
            YuancailiaoView view = new YuancailiaoView();
            BeanUtils.copyProperties( yuancailiao , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YuancailiaoEntity yuancailiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yuancailiao:{}",this.getClass().getName(),yuancailiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YuancailiaoEntity> queryWrapper = new EntityWrapper<YuancailiaoEntity>()
            .eq("yuancailiao_uuid_number", yuancailiao.getYuancailiaoUuidNumber())
            .eq("yuancailiao_name", yuancailiao.getYuancailiaoName())
            .eq("yuancailiao_danwei", yuancailiao.getYuancailiaoDanwei())
            .eq("yuancailiao_types", yuancailiao.getYuancailiaoTypes())
            .eq("yuancailiao_kucun_number", yuancailiao.getYuancailiaoKucunNumber())
            .eq("yuancailiao_price", yuancailiao.getYuancailiaoPrice())
            .eq("yuancailiao_clicknum", yuancailiao.getYuancailiaoClicknum())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuancailiaoEntity yuancailiaoEntity = yuancailiaoService.selectOne(queryWrapper);
        if(yuancailiaoEntity==null){
            yuancailiao.setYuancailiaoClicknum(1);
            yuancailiao.setCreateTime(new Date());
            yuancailiaoService.insert(yuancailiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuancailiaoEntity yuancailiao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yuancailiao:{}",this.getClass().getName(),yuancailiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<YuancailiaoEntity> queryWrapper = new EntityWrapper<YuancailiaoEntity>()
            .notIn("id",yuancailiao.getId())
            .andNew()
            .eq("yuancailiao_uuid_number", yuancailiao.getYuancailiaoUuidNumber())
            .eq("yuancailiao_name", yuancailiao.getYuancailiaoName())
            .eq("yuancailiao_danwei", yuancailiao.getYuancailiaoDanwei())
            .eq("yuancailiao_types", yuancailiao.getYuancailiaoTypes())
            .eq("yuancailiao_kucun_number", yuancailiao.getYuancailiaoKucunNumber())
            .eq("yuancailiao_price", yuancailiao.getYuancailiaoPrice())
            .eq("yuancailiao_clicknum", yuancailiao.getYuancailiaoClicknum())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuancailiaoEntity yuancailiaoEntity = yuancailiaoService.selectOne(queryWrapper);
        if("".equals(yuancailiao.getYuancailiaoPhoto()) || "null".equals(yuancailiao.getYuancailiaoPhoto())){
                yuancailiao.setYuancailiaoPhoto(null);
        }
        if(yuancailiaoEntity==null){
            yuancailiaoService.updateById(yuancailiao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yuancailiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YuancailiaoEntity> yuancailiaoList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YuancailiaoEntity yuancailiaoEntity = new YuancailiaoEntity();
//                            yuancailiaoEntity.setYuancailiaoUuidNumber(data.get(0));                    //原材料编号 要改的
//                            yuancailiaoEntity.setYuancailiaoName(data.get(0));                    //原材料名称 要改的
//                            yuancailiaoEntity.setYuancailiaoPhoto("");//详情和图片
//                            yuancailiaoEntity.setYuancailiaoDanwei(data.get(0));                    //单位 要改的
//                            yuancailiaoEntity.setYuancailiaoTypes(Integer.valueOf(data.get(0)));   //原材料类型 要改的
//                            yuancailiaoEntity.setYuancailiaoKucunNumber(Integer.valueOf(data.get(0)));   //原材料库存 要改的
//                            yuancailiaoEntity.setYuancailiaoPrice(Integer.valueOf(data.get(0)));   //购买获得积分 要改的
//                            yuancailiaoEntity.setYuancailiaoJinjiaMoney(data.get(0));                    //原材料进价 要改的
//                            yuancailiaoEntity.setYuancailiaoClicknum(Integer.valueOf(data.get(0)));   //热度 要改的
//                            yuancailiaoEntity.setYuancailiaoContent("");//详情和图片
//                            yuancailiaoEntity.setCreateTime(date);//时间
                            yuancailiaoList.add(yuancailiaoEntity);


                            //把要查询是否重复的字段放入map中
                                //原材料编号
                                if(seachFields.containsKey("yuancailiaoUuidNumber")){
                                    List<String> yuancailiaoUuidNumber = seachFields.get("yuancailiaoUuidNumber");
                                    yuancailiaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yuancailiaoUuidNumber = new ArrayList<>();
                                    yuancailiaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yuancailiaoUuidNumber",yuancailiaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //原材料编号
                        List<YuancailiaoEntity> yuancailiaoEntities_yuancailiaoUuidNumber = yuancailiaoService.selectList(new EntityWrapper<YuancailiaoEntity>().in("yuancailiao_uuid_number", seachFields.get("yuancailiaoUuidNumber")));
                        if(yuancailiaoEntities_yuancailiaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YuancailiaoEntity s:yuancailiaoEntities_yuancailiaoUuidNumber){
                                repeatFields.add(s.getYuancailiaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [原材料编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yuancailiaoService.insertBatch(yuancailiaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = yuancailiaoService.queryPage(params);

        //字典表数据转换
        List<YuancailiaoView> list =(List<YuancailiaoView>)page.getList();
        for(YuancailiaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YuancailiaoEntity yuancailiao = yuancailiaoService.selectById(id);
            if(yuancailiao !=null){

                //点击数量加1
                yuancailiao.setYuancailiaoClicknum(yuancailiao.getYuancailiaoClicknum()+1);
                yuancailiaoService.updateById(yuancailiao);

                //entity转view
                YuancailiaoView view = new YuancailiaoView();
                BeanUtils.copyProperties( yuancailiao , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YuancailiaoEntity yuancailiao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yuancailiao:{}",this.getClass().getName(),yuancailiao.toString());
        Wrapper<YuancailiaoEntity> queryWrapper = new EntityWrapper<YuancailiaoEntity>()
            .eq("yuancailiao_uuid_number", yuancailiao.getYuancailiaoUuidNumber())
            .eq("yuancailiao_name", yuancailiao.getYuancailiaoName())
            .eq("yuancailiao_danwei", yuancailiao.getYuancailiaoDanwei())
            .eq("yuancailiao_types", yuancailiao.getYuancailiaoTypes())
            .eq("yuancailiao_kucun_number", yuancailiao.getYuancailiaoKucunNumber())
            .eq("yuancailiao_price", yuancailiao.getYuancailiaoPrice())
            .eq("yuancailiao_clicknum", yuancailiao.getYuancailiaoClicknum())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuancailiaoEntity yuancailiaoEntity = yuancailiaoService.selectOne(queryWrapper);
        if(yuancailiaoEntity==null){
            yuancailiao.setCreateTime(new Date());
        yuancailiaoService.insert(yuancailiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
