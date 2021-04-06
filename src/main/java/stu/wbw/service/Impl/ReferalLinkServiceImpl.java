package stu.wbw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.wbw.mapper.ReferalLinkMapper;
import stu.wbw.pojo.ReferalLink;
import stu.wbw.service.ReferalLinkService;

import java.util.List;

@Service
public class ReferalLinkServiceImpl implements ReferalLinkService {
    @Autowired
    ReferalLinkMapper referalLinkMapper;
    @Override
    public int addReferalLink(ReferalLink referalLink) {
        return referalLinkMapper.addReferalLink(referalLink);
    }

    @Override
    public int deleteReferalLink(Integer id) {
        return referalLinkMapper.deleteReferalLink(id);
    }

    @Override
    public int updateReferalLink(ReferalLink referalLink) {
        return referalLinkMapper.updateReferalLink(referalLink);
    }

    @Override
    public ReferalLink queryReferalLinkById(Integer id) {
        return referalLinkMapper.queryReferalLinkById(id);
    }

    @Override
    public List<ReferalLink> queryAllReferalLink() {
        return referalLinkMapper.queryAllReferalLink();
    }
}
