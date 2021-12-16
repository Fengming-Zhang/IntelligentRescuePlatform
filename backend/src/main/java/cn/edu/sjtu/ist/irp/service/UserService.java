package cn.edu.sjtu.ist.irp.service;

import cn.edu.sjtu.ist.irp.dao.UserDao;
import cn.edu.sjtu.ist.irp.entity.FamilyMember;
import cn.edu.sjtu.ist.irp.entity.RescueMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dyanjun
 * @date 2021/12/16 22:01
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Integer loginFamilyMember(String username){
        FamilyMember familyMember = userDao.getFamilyMemberByUsername(username);
        if(familyMember==null) throw new RuntimeException("家属不存在");
        return familyMember.getId();
    }

    public Integer loginRescueMember(String username){
        RescueMember rescueMember = userDao.getRescueMemberByUsername(username);
        if(rescueMember==null) throw new RuntimeException("救援人员不存在");
        return rescueMember.getId();
    }

    public FamilyMember registerFamilyMember(FamilyMember domain){
        FamilyMember familyMember = userDao.createFamilyMember(domain);
        return familyMember;
    }

    public RescueMember registerRescueMember(RescueMember domain){
        // TODO 更新定位
        RescueMember rescueMember = userDao.createRescueMember(domain);
        return rescueMember;
    }
}
