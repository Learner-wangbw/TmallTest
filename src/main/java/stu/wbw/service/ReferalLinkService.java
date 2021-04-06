package stu.wbw.service;

import stu.wbw.pojo.ReferalLink;

import java.util.List;

public interface ReferalLinkService {
    //增加一个友情链接
    int addReferalLink(ReferalLink referalLink);
    //删除一个友情链接
    int deleteReferalLink(Integer id);
    //修改一个友情链接
    int updateReferalLink(ReferalLink referalLink);
    //查询一个友情链接
    ReferalLink queryReferalLinkById(Integer id);
    //查询所有友情链接
    List<ReferalLink> queryAllReferalLink();
}
