package com.example.dzykfc.mapper;


import com.example.dzykfc.entity.GouWuChe;
import com.example.dzykfc.entity.QDGouWuChe;
import com.example.dzykfc.entity.ZhuangTai;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GouWuCheMapper {
    //向购物车插入数据，在数据库中的菜品数量的默认值为1，后面修改就可
    @Insert("insert into GouWuChe( DingId, CaiId) values (#{dingId}, #{caiId})")
    int chaRuShuJuGouWuChe(@Param("dingId") String dingId,
                           @Param("caiId") int caiId);

    //传入dingId与caiId 对购物车进行查看
    @Select("select * from GouWuChe where dingId = #{dingId} and caiId = #{caiId}")
    List<GouWuChe> DCIdCK(@Param("dingId") String dingId,
                          @Param("caiId") int caiId);


    //同时将订单状态写入ZhuangTai表

    @Insert("insert into ZhuangTai( DingId, WeiId, DingTime) values (#{dingId}, #{weiId}, #{dingTime})")
    int chaRuShuJuZhuangTai(@Param("dingId") String dingId,
                            @Param("weiId") int weiId,
                            @Param("dingTime") String dingTime);

    //显示购物车数据
    @Select("select * from GouWuChe where dingId = #{dingId}")
    List<GouWuChe> gouWuCheShuJuXS(@Param("dingId")String dingId);

    //删除购物车中符合的菜品记录
    @Delete("delete from GouWuChe where caiId = #{caiId} and dingId = #{dingId}")
    int ifCaiIdCai(@Param("caiId") int caiId,
                   @Param("dingId")String dingId);

    //显示状态表的数据
    @Select("select * from ZhuangTai")
    List<ZhuangTai> zhuangTaiShuJuXS();

    //获得购物车的DingId，CaiPinShuLiang，状态表的ZhuangTai，DingTime，座位表的Wei等。并且是未支付状态
    @Select("select GouWuChe.DingId,GouWuChe.CaiPinShuLiang,ZhuangTai.ZhuangTaiId,ZhuangTai.DingTime,WeiHao.Wei," +
            " CaiPinBiao.Cai,CaiJG,GouWuChe.CaiId,YongHu.YongHuRS  " +
            " from GouWuChe " +
            " join CaiPinBiao on GouWuChe.CaiId = CaiPinBiao.CaiId" +
            " join ZhuangTai on GouWuChe.DingId = ZhuangTai.DingId" +
            " join WeiHao on ZhuangTai.WeiId = WeiHao.WeiId " +
            " join YongHu on GouWuChe.DingId = YongHu.DingId " +
            " where GouWuChe.DingId = #{dingId} and ZhuangTaiId = 2")
    List<QDGouWuChe> qDGouWuCheXS(@Param("dingId") String dingId);

    //获得购物车的DingId，CaiPinShuLiang，状态表的ZhuangTai，DingTime，座位表的Wei等。并且是完成支付状态
    @Select("select GouWuChe.DingId,GouWuChe.CaiPinShuLiang,ZhuangTai.ZhuangTaiId,ZhuangTai.DingTime,WeiHao.Wei," +
            " CaiPinBiao.Cai,CaiJG,GouWuChe.CaiId,YongHu.YongHuRS  " +
            " from GouWuChe " +
            " join CaiPinBiao on GouWuChe.CaiId = CaiPinBiao.CaiId" +
            " join ZhuangTai on GouWuChe.DingId = ZhuangTai.DingId" +
            " join WeiHao on ZhuangTai.WeiId = WeiHao.WeiId " +
            " join YongHu on GouWuChe.DingId = YongHu.DingId " +
            " where GouWuChe.DingId = #{dingId} and ZhuangTaiId = 1")
    List<QDGouWuChe> qD2GouWuCheXS(@Param("dingId") String dingId);

    //获得购物车的DingId，CaiPinShuLiang，状态表的ZhuangTai，DingTime，座位表的Wei等。并且是超时的
    @Select("select GouWuChe.DingId,GouWuChe.CaiPinShuLiang,ZhuangTai.ZhuangTaiId,ZhuangTai.DingTime,WeiHao.Wei," +
            " CaiPinBiao.Cai,CaiJG,GouWuChe.CaiId,YongHu.YongHuRS  " +
            " from GouWuChe " +
            " join CaiPinBiao on GouWuChe.CaiId = CaiPinBiao.CaiId" +
            " join ZhuangTai on GouWuChe.DingId = ZhuangTai.DingId" +
            " join WeiHao on ZhuangTai.WeiId = WeiHao.WeiId " +
            " join YongHu on GouWuChe.DingId = YongHu.DingId " +
            " where GouWuChe.DingId = #{dingId} and ZhuangTaiId = 1")
    List<QDGouWuChe> qD3GouWuCheXS(@Param("dingId") String dingId);





    //向购物车中的某个商品进行加一操作
    @Update("update GouWuChe set CaiPinShuLiang = CaiPinShuLiang +1 " +
            " where caiId = #{caiId}")
    int shuliangADD(@Param("caiId") int caiId,
                    @Param("dingId") String dingId);

    //向购物车中的某个商品进行减一操作
    @Update("update GouWuChe set CaiPinShuLiang = CaiPinShuLiang -1 " +
            " where caiId = #{caiId} and dingId = #{dingId}")
    int shuliangSUB(@Param("caiId") int caiId,
                    @Param("dingId")String dingId);



    //当订单完成支付时，将订单状态改为1
    //但是目前有个问题是不知道是哪个订单要改状态，毕竟前端不能返回
    //所以判断现在目前是哪个用户是处于在线状态。获取他的dingId将他的dingId传入这里
    @Update("update ZhuangTai set ZhuangTaiId = 1 where DingId = #{dingId}")
    int setdingdanWCZF(@Param("dingId") String dingId);
}

