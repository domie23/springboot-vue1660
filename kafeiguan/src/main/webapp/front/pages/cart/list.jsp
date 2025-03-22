<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <!--通用-->
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0">
    <title>购物车列表页</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" href="../../xznstatic/css/aos.css" />
    <link rel="stylesheet" href="../../xznstatic/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../xznstatic/css/idangerous.swiper.css" />
    <link rel="stylesheet" href="../../xznstatic/css/lightbox.css">
    <link rel="stylesheet" href="../../xznstatic/css/app.css" />
    <link rel="stylesheet" href="../../xznstatic/css/apmin.css"/>
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/color.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/global.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/page.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/uzlist.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/fancybox.css" />
    <script type="text/javascript" src="../../xznstatic/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../xznstatic/js/superslide.2.1.1.min.js"></script>
    <script type="text/javascript" src="../../xznstatic/js/wow.min.js"></script>
    <script type="text/javascript" src="../../xznstatic/js/fancybox.js"></script>
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "../../../resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="../../../resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="../../../resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="../../../resources/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">
        var CATID = "0",
                BCID = "0",
                NAVCHILDER = "",
                ONCONTEXT = 0,
                ONCOPY = 0,
                ONSELECT = 0;
    </script>
    <style>

    body, h1, h2, h3, h4, h5, h6, hr, p, blockquote,
        /* structural elements 结构元素 */

    dl, dt, dd, ul, ol, li,
        /* list elements 列表元素 */


    th, td {
        /* table elements 表格元素 */
        margin: 0;
        padding: 0;
    }
    /* 设置默认字体 */

    body, button, input, select, textarea {
        /* for ie */
        /*font: 12px/1 Tahoma, Helvetica, Arial, "宋体", sans-serif;*/
        font: 12px/1 Tahoma, Helvetica, Arial, "\5b8b\4f53", sans-serif;
        /* 用 ascii 字符表示，使得在任何编码下都无问题 */
    }


    ul, ol {
        list-style: none;
    }
    /* 重置文本格式元素 */

    a {
        text-decoration: none;
        color: #000;
    }


    fieldset, img {
        border: none;
    }
    /* img 搭车：让链接里的 img 无边框 */
    /* 注：optgroup 无法扶正 */


    .cartMain{
        position: relative;
        width: 1200px;
        min-width: 1200px;
        max-width: 1200px;
        margin: 0 auto;
        padding: 0px 0px 100px;
        min-height: 210px;
    }

    /*购物车头部*/
    .cartMain_hd{
        background:#eee;
        width: 1200px;
        height: 50px;
        line-height: 50px;
        color: #3c3c3c;
    }
    .cartMain_hd .cartTop{
        height: 50px;
    }
    .cartMain_hd .cartTop .list_chk{
        width: 5%;
        text-indent: 30px;
    }
    .cartMain_hd .cartTop .list_con{
        width: 30%;
    }
    .cartMain_hd .cartTop .list_chk label{
        position: absolute;
        left: 10px;
        top:19px;
        margin: 0;
    }
    .cartMain_hd .cartTop .list_info{
        padding:0px;
        text-indent: 40px;
    }
    .cartMain_hd .cartTop .list_con{
        text-indent: -20px;
    }

    .cartMain_hd .order_lists .list_price{
        width: 15%;
    }
    .cartMain_hd .order_lists .list_amount{
        width: 15%;
    }
    .cartMain_hd .order_lists .list_sum{
        width: 20%;
    }

    .cartBox{
        width: 100%;
        margin-bottom: 15px;
    }
    .cartBox .shop_info{
        position: relative;
        width: 100%;
        height: 38px;
        background-color: #fff;
        line-height: 38px;
        vertical-align: baseline;
    }
    .cartBox .shop_info .all_check{
        position: relative;
        float: left;
        width: 30px;
        height: 38px;
    }

    .cartBox .shop_info .all_check input[type="checkbox"]{
        position: absolute;
        z-index: 0;
        left: -20px;
        top: -20px;
    }
    .cartBox .shop_info .all_check .shop{
        position: absolute;
        top:13px;
    }
    .cartBox .shop_info .shop_name{
        float: left;
    }
    /*商品列表*/
    .cartBox .order_content{
        border-top: 1px solid #ccc;
    }
    .cartBox .order_content a{
        display: block;
    }
    .order_lists{
        width: 100%;
        height: 130px;
        border-bottom: 1px solid #e7e7e7;
    }
    .order_lists:last-child{
        border-bottom: none;
    }
    .order_lists li{
        float: left;
        height: 100%;
    }

    .order_lists .list_chk{
        position: relative;
        width: 5%;
    }
    .order_lists .list_chk input[type="checkbox"]{
        position: absolute;
        z-index: 0;
        left: -20px;
        top: -20px;
    }
    .order_lists .list_chk label{
        margin: 50px 0 0 24px;
    }

    .order_lists .list_con{
        width: 30%;
    }
    .order_lists .list_con .list_img{
        width: 30%;
        height: 90px;
        margin-top: 20px;
        float: left;
    }
    .order_lists .list_con .list_img img{
        width: 100%;
        vertical-align: top;
    }
    .order_lists .list_con .list_text{
        margin: 50px 0 0 30px;
        line-height: 18px;
        width: 200px;
        float: left;
    }
    .order_lists .list_con .list_text a{
        color: #3c3c3c;
    }
    .order_lists .list_con .list_text a:hover{
        color: #fb0000;
        text-decoration: underline;
    }

    .order_lists .list_info{
        width: 252px;
        box-sizing: border-box;
        padding: 30px 0;
    }
    .order_lists .list_info p{
        color: #4c4c4c;
        line-height: 32px;
        margin-left: 35px;
    }
    .order_lists .list_price{
        width: 13%;
    }
    .order_lists .list_price .price{
        margin-top: 50px;
        line-height: 18px;
        color: #4c4c4c;
    }
    .order_lists .list_amount{
        width: 15%;
    }
    .order_lists .list_amount .amount_box{
        margin-top: 50px;
        width: 77px;
        height: 25px;
        position: relative;
    }
    .order_lists .list_amount .amount_box input{
        width: 39px;
        height: 15px;
        line-height: 15px;
        border:none;
        outline:none;
        color: #4c4c4c;
        text-align: center;
        padding: 4px 0;
        z-index: 2;
        position: absolute;
        left: 18px;
        float: left;
    }
    .order_lists .list_amount .amount_box a{
        float: left;
        height: 23px;
        width: 17px;
        border: 1px solid #e5e5e5;
        background: #f0f0f0;
        text-align: center;
        line-height: 23px;
        color: #444;
        position: absolute;
        top:0;
    }
    .order_lists .list_amount .amount_box a:hover{
        border-color: #ff873e;
        text-decoration: none;
        color: #fb0000;
        z-index: 3;
    }

    .order_lists .list_amount .amount_box .reduce{
        width:20px;
        height:20px;
        border-radius:10px;
        border:1px solid #b8b8b8;
        line-height:20px;
        left: -10px;
    }

    .order_lists .list_amount .amount_box .reSty{
        color: #4c4c4c;
    }
    .order_lists .list_amount .amount_box .reSty:hover{
        border-right: none;
        border-color: #fb0000;
        text-decoration: none;
        color: #cbcbcb;
    }

    .order_lists .list_amount .amount_box .plus{
        width:20px;
        height:20px;
        border-radius:10px;
        border:1px solid #b8b8b8;
        line-height:20px;
        right: -10px;
    }


    .order_lists .list_sum{
        margin-left:20px;
        width: 20%;
    }
    .order_lists .list_sum .sum_price{
        margin-left:10px;
        line-height: 18px;
        margin-top: 50px;
        font:"微软雅黑", "宋体", "黑体";
        font-size:18px;
        color: #fb0000;
    }
    .order_lists .list_op{
        width: 10%;
    }
    .order_lists .list_op .del{
        margin-top: 50px;
        line-height: 18px;
    }

    /*底部总计算价*/
    .bar-wrapper{
        width: 1200px;
        height: 50px;
        position: fixed;
        bottom: -1px;
        z-index: 99;
        background: #eee;
    }
    .bar-wrapper .bar-right{
        float: right;
        color: #3c3c3c;
    }
    .bar-wrapper .bar-right strong{
        color: #fb0000;
    }

    .bar-wrapper .bar-right .piece{
        float: left;
        min-width: 110px;
        margin-right: 20px;
        height: 50px;
        line-height: 50px;
    }
    .bar-wrapper .bar-right .piece .piece_num{
        display: inline-block;
        padding: 0 10px;
        font-size: 18px;
    }
    .bar-wrapper .bar-right .totalMoney{
        float: left;
        min-width: 100px;
        height: 50px;
        line-height: 50px;
    }
    .bar-wrapper .bar-right .totalMoney .total_text{
        float: right;
        font-weight: 400;
        font-size: 20px;
        vertical-align: middle;
        margin-right: 10px;
        margin-left: 15px;
    }
    .bar-wrapper .bar-right .calBtn{
        float: left;
    }
    .bar-wrapper .bar-right .calBtn a{
        display: block;
        width: 120px;
        height: 50px;
        color: #fff;
        background: #fb0000;
        cursor: pointer;
        font-size: 22px;
        letter-spacing: 5px;
        text-decoration: none;
        line-height: 50px;
        text-align: center;
        border-radius: 8px;
    }
    </style>
</head>
<body >
<div id="app">

    <div style="height: 100px;width: 1200px;margin: 0 auto;">
        <h1 style="font-size: 30px;margin-top: 35px;float: left;width: 150px"><i style="font-size: 30px;" class="layui-icon">&#xe657;</i>购物车 </h1>
        <el-steps :active="1" finish-status="success" simple style="margin-top: 30px;float: right;width: 700px">
            <el-step title="购物车" ></el-step>
            <el-step title="确认订单" ></el-step>
            <el-step title="完成订单" ></el-step>
        </el-steps>
    </div>
    <!-- 标题 -->
    <section class="cartMain">
        <div class="cartMain_hd">
            <ul class="order_lists cartTop">
                <li class="list_chk">
                </li>
                <li class="list_con"><span style="margin-left: 20px">名称</span></li>
                <li class="list_price">单价（元）</li>
                <li class="list_amount">数量</li>
                <li class="list_sum">小计（元）</li>
                <li class="list_op">操作</li>
            </ul>
        </div>
        <div class="cartBox">
            <div class="shop_info">
            </div>
            <div class="order_content">
                <ul class="order_lists" v-for="(item,index) in dataList" v-bind:key="index">
                    <li class="list_chk">
                    </li>
                    <li class="list_con">
                        <div class="list_img"><img :src="item.shangpinPhoto"></div>
                        <div class="list_text">{{item.shangpinName}}</div>
                    </li>
                    <li class="list_price">
                        <p class="price">{{item.shangpinNewMoney}} RMB</p>
                    </li>
                    <li class="list_amount">
                        <div class="amount_box">
                            <a @click="reduceCartNum(index)" class="reduce reSty">-</a>
                            <input type="text" :value="item.buyNumber" id="buyNumber" name="buyNumber" class="sum">
                            <a @click="addCartNum(index)" class="plus">+</a>
                        </div>
                    </li>
                    <li class="list_sum">
                        <p class="sum_price">{{(item.shangpinNewMoney*item.buyNumber).toFixed(2)}} RMB</p>
                    </li>
                    <li class="list_op">
                        <p class="del"><a  @click="deleteCart(index)"class="delBtn"><i class="layui-icon">&#xe640;</i> 移除商品</a></p>
                    </li>
                </ul>
            </div>
        </div>

        <!--底部-->
        <div class="bar-wrapper">
            <div class="bar-right">
                <div class="piece">共<strong class="piece_num">{{dataList.length}}</strong>件商品</div>
                <div class="totalMoney">共计: <strong class="total_text">{{totalZongjiaMoney.toFixed(2)}}RMB</strong></div>
                <div class="calBtn"><a @click="buyClick" >下单</a></div>
            </div>
        </div>
    </section>

</div></div>


<script src="../../xznstatic/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../layui/layui.js"></script>
<script src="../../js/vue.js"></script>
<!-- 引入element组件库 -->
<script src="../../xznstatic/js/element.min.js"></script>
<!-- 引入element样式 -->
<link rel="stylesheet" href="../../xznstatic/css/element.min.css">
<script src="../../js/config.js"></script>
<script src="../../modules/config.js"></script>
<script src="../../js/utils.js"></script>

<script>
    var vue = new Vue({
        el: '#app',
        data: {
            id:null,
            detail: {},
            swiperList: [],//轮播图
            dataList: [],//数据
        // 当前表字典表数据
            cartTypes: 0,//类型
            limit: 8,
            projectName: projectName,//项目名
            centerMenu: centerMenu

        },
        updated: function() {
            layui.form.render(null, 'myForm');
        },
        filters: {
            //把字符串去除无用字符 如果字段长度大于60  就截取到60
            subString: function(val) {
                if (val) {
                    val = val.replace(/<[^<>]+>/g, '').replace(/undefined/g, '');
                    if (val.length > 60) {
                        val = val.substring(0, 60);
                        val+='...';
                    }

                    return val;
                }
                return '';
            }
        },
        computed: {
            totalZongjiaMoney: function() {
                var total = 0;
                for (var item of this.dataList) {
                    total += item.shangpinNewMoney * item.buyNumber
                }
                return total;
            }
        },
        methods: {
            jump(url) {
                jump(url);
            }
            ,jumpCheck(url,check1,check2) {
                if(check1 == "2" || check1 == 2){//级联表的逻辑删除字段[1:未删除 2:已删除]
                    layui.layer.msg("已经被删除", {
                        time: 2000,
                        icon: 2
                    });
                    return false;
                }
                if(check2 == "2"  || check2 == 2){//是否下架[1:上架 2:下架]
                    layui.layer.msg("已经下架", {
                        time: 2000,
                        icon: 2
                    });
                    return false;
                }
                this.jump(url);
            }
			// 添加数量
			,addCartNum(index) {
				// 查询对应的商品的详情信息，判断是否有商品限次，库存的判断
				var item = this.dataList[index];
				layui.http.request(`shangpin/info/${item.shangpinId}`, 'get', {}, function(res) {
					// 库存限制
					if (res.data.shangpinKucunNumber && res.data.shangpinKucunNumber > 0 && res.data.shangpinKucunNumber  <= item.buyNumber) {
						layui.layer.msg(`商品库存不足`, {
							time: 2000,
							icon: 5
						});
						return
					}
					item.buyNumber = item.buyNumber + 1;
					layui.http.requestJson(`cart/update`, 'post', item, function(res) {});
				});
			},
			// 减少数量
			reduceCartNum(index) {
				var item = this.dataList[index];
				if (item.buyNumber > 1) {
					item.buyNumber = item.buyNumber - 1;
					layui.http.requestJson(`cart/update`, 'post', item, function(res) {});
				}
			},
			// 删除
			deleteCart(index) {
				var item = this.dataList[index];
				layui.http.requestJson(`cart/delete`, 'post', [item.id], function(res) {
					window.location.reload();
				});
			},
			// 购买
			buyClick() {
				localStorage.setItem('shangpins', JSON.stringify(this.dataList));
				window.location.href = '../shangpinOrder/confirm.jsp'
			}
        }
    });

    layui.use(['layer', 'element', 'carousel', 'laypage','form', 'http', 'jquery', 'laydate', 'tinymce'], function() {
        var layer = layui.layer;
        var element = layui.element;
        var carousel = layui.carousel;
        var laypage = layui.laypage;
        var http = layui.http;
        var form = layui.form;
        var laydate = layui.laydate;
        var tinymce = layui.tinymce;
        window.jQuery = window.$ = jquery = layui.jquery;

        var limit = 8;

        // 获取轮播图 数据
        http.request('config/list', 'get', {
            page: 1,
            limit: 5
        }, function(res) {
            if (res.data.list.length > 0) {
                let swiperList = [];
                res.data.list.forEach(element => {
                    if (element.value != null) {
                        swiperList.push({
                            img: element.value
                        });
                    }
                });
                vue.swiperList = swiperList;
                vue.$nextTick(()=>{
                    var mySwiper = new Swiper('.ng-swiper', {
                        speed: 400,
                        spaceBetween: 100,
                        pagination: '.ng-swiper .swiper-pagination',
                        autoplay : 5000,
                        loop : true,
                        autoplayDisableOnInteraction : false,
                        calculateHeight : true
                    });
                    $(".ng-swiper-ovleft").bind("click",function (){ mySwiper.swipePrev();});
                    $(".ng-swiper-ovright").bind("click",function (){ mySwiper.swipeNext();});
                });
            }
        });
        // 查询当前字典表相关
    // 当前表的字典表




        // 获取列表数据
        http.request('cart/page', 'get', {
            page: 1,
            limit: limit,
            yonghuId: localStorage.getItem('userid')
        }, function(res) {
            vue.dataList = res.data.list
            // 分页
            laypage.render({
                elem: 'pager',
                count: res.data.total,
                limit: limit,
                jump: function(obj, first) {
                    //首次不执行
                    if (!first) {
                        http.request('news/list', 'get', {
                            page: obj.curr,
                            limit: obj.limit,
                            yonghuId: localStorage.getItem('userid')
                        }, function(res) {
                            vue.dataList = res.data.list
                        })
                    }
                }
            });
        })
    });
</script>

<script src="../../xznstatic/js/idangerous.swiper.min.js"></script>
<script src="../../xznstatic/js/aos.js" type="text/javascript" charset="utf-8"></script>
<script src="../../xznstatic/js/jquery.superslide.2.1.1.js"></script>
<script src="../../xznstatic/js/app.js"></script>
<script src="../../xznstatic/js/lightbox.js"></script>

<script>
    window.xznResize = function() {
        var mySwiper2 = new Swiper('.ng-inzep',{
            calculateHeight : true,
            loop : true,
            paginationClickable :true,
            pagination: ".ng-inzep .swiper-pagination"
        });

        $(document).bind("scroll",function (){
            if($(".ng-swip-porlist").length > 0){
                if($(window).width() > 769){
                    mySwiper2.params.slidesPerView = 4;
                    mySwiper3.params.slidesPerView = 4;
                }else if($(window).width() < 769){
                    if($(window).width() < 480){
                        mySwiper2.params.slidesPerView = 2;
                        mySwiper3.params.slidesPerView = 2;
                    }else{
                        mySwiper2.params.slidesPerView = 3;
                        mySwiper3.params.slidesPerView = 3;
                    }
                }
            }
        });

        $(window).bind("resize", function () {
            // 强制关闭导航
            if ($(window).width() > 992) { $(".ipad-nav").slideUp(); };

            if ($(".ng-swip-porlist").length > 0) {
                if ($(window).width() > 769) {
                    mySwiper2.params.slidesPerView = 4;
                    mySwiper3.params.slidesPerView = 4;
                } else if ($(window).width() < 769) {
                    if ($(window).width() < 480) {
                        mySwiper2.params.slidesPerView = 2;
                        mySwiper3.params.slidesPerView = 2;
                    } else {
                        mySwiper2.params.slidesPerView = 3;
                        mySwiper3.params.slidesPerView = 3;
                    }
                }
            }

            Spirit_dynamicBG($(".ng-inswbg"), 1600, 616, $(".ng-inswbg"));
            Spirit_CallBack($(".ng-porlist-doc>a"), 280, 200);
            Spirit_CallBack($(".ng-incontlst-img"), 368, 240);
            Spirit_CallBack($(".ng-inzep-ims"), 400, 270);
            Spirit_CallBack($(".ng-isenst-img"), 368, 240);
            Spirit_CallBack($(".ng-prslist-img"), 100, 100);
            Spirit_CallBack($(".ng-vrslist-img"), 260, 170);
            Spirit_CallBack($(".ng-newbve-img-ikk"), 368, 240);

            $(".ng-subc-swiper").css({ "height": $(".ng-subc-swiper").width() });

            if ($(window).width() < 640) {
                $(".am-inside-swf").css({
                    "min-height": $(window).height() - 60
                });
            } else {
                $(".am-inside-swf").css({
                    "min-height": "auto"
                });
            }
        }).resize();
    }
</script>
</body>
</html>
