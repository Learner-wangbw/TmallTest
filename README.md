# TmallTest
基于 Spring + SpringMVC + Mybatis框架构建的模仿天猫前端，个人实现后端的ssm项目
# 模仿天猫项目介绍

## 项目环境

Tomcat9.0+JDK1.8+Mysql5.5



## 项目相关技术

1. 使用Spring+Springmvc+Mybatis作为项目架构

2. 使用Mysql5.5数据库,数据库连接池使用c3p0

3. 使用Maven作为项目管理

4. 前台内容展示页面使用Bootstrap框架

5. 后台管理页面随意找的一个模板

   ### 功能：

   * 前台：
     * 登录、注册、注销
     * 可搜索产品
     * 查看购物车
     * 查看个人订单
     * 支付
     * 发布评价、查看评价
     * ...
   * 后台：
     + 分类管理：增、删、改、查；
     + 分类管理-产品管理、分类管理-属性管理
     + 产品管理：增、删、改、查以及添加产品图片
     + 用户管理：增、删、改、查
     + 订单管理：查，该
     + 推荐链接管理（太懒了，没有任何功能，只能查看）

   更多功能可以自行运行体验



## 一些规定

- 全站没有商家，只有一家 Tmall ，后台没有验证，可以直接进入（可自行添加）
- 前台的路径就是默认路径，后台的路径需要加上 “/admin” 后缀，如访问后台则为：localhost/admin （默认为分类管理页）

- 产品的图片是默认放置在 `img/product/产品的id号/` 目录下的，并且默认的五张图片分别为：1.jpg、2.jpg.....5.jpg，用于默认显示的图片均为 1.jpg

## 前台页面

> 1.首页

![首页](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E9%A6%96%E9%A1%B5.png)

> 2.产品展示

![产品展示页](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E4%BA%A7%E5%93%81%E5%B1%95%E7%A4%BA%E9%A1%B5.png)

> 尾页

![尾页](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E5%B0%BE%E9%A1%B5.png)

> 登录页面

![登录页面](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E7%99%BB%E5%BD%95%E9%A1%B5%E9%9D%A2.png)

> 注册页面

![注册页面](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E6%B3%A8%E5%86%8C%E9%A1%B5%E9%9D%A2.png)

> 订单页面

![订单页面](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E8%AE%A2%E5%8D%95%E9%A1%B5%E9%9D%A2.png)

> 购物车页面

![购物车页面](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E8%B4%AD%E7%89%A9%E8%BD%A6%E9%A1%B5%E9%9D%A2.png)

> 结算页面

![结算页面](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E7%BB%93%E7%AE%97%E9%A1%B5%E9%9D%A2.png)

> 支付页面

![支付页面](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E6%94%AF%E4%BB%98%E9%A1%B5%E9%9D%A2.png)

> 交易成功页面

![交易成功页面](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E4%BA%A4%E6%98%93%E6%88%90%E5%8A%9F%E9%A1%B5%E9%9D%A2.png)

## 后台页面

> 分类管理

![后台页面_分类管理](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E5%90%8E%E5%8F%B0%E9%A1%B5%E9%9D%A2_%E5%88%86%E7%B1%BB%E7%AE%A1%E7%90%86.png)

> 用户管理

![后台页面_用户管理](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E5%90%8E%E5%8F%B0%E9%A1%B5%E9%9D%A2_%E7%94%A8%E6%88%B7%E7%AE%A1%E7%90%86.png)

> 订单管理

![后台页面_订单管理](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E5%90%8E%E5%8F%B0%E9%A1%B5%E9%9D%A2_%E8%AE%A2%E5%8D%95%E7%AE%A1%E7%90%86.png)

> 推荐链接管理

![后台页面_推荐链接管理](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E5%90%8E%E5%8F%B0%E9%A1%B5%E9%9D%A2_%E6%8E%A8%E8%8D%90%E9%93%BE%E6%8E%A5%E7%AE%A1%E7%90%86.png)

> 分类管理_产品管理

![后台页面_分类管理_产品管理](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E5%90%8E%E5%8F%B0%E9%A1%B5%E9%9D%A2_%E5%88%86%E7%B1%BB%E7%AE%A1%E7%90%86_%E4%BA%A7%E5%93%81%E7%AE%A1%E7%90%86.png)

> 分类管理-产品管理-图片管理

![后台页面_分类管理_产品管理_图片管理](https://github.com/Learner-wangbw/TmallTest/blob/master/images-folder/%E5%90%8E%E5%8F%B0%E9%A1%B5%E9%9D%A2_%E5%88%86%E7%B1%BB%E7%AE%A1%E7%90%86_%E4%BA%A7%E5%93%81%E7%AE%A1%E7%90%86_%E5%9B%BE%E7%89%87%E7%AE%A1%E7%90%86.png)
