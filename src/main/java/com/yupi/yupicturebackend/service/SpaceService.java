package com.yupi.yupicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yupicturebackend.model.dto.space.SpaceAddRequest;
import com.yupi.yupicturebackend.model.dto.space.SpaceQueryRequest;
import com.yupi.yupicturebackend.model.enity.Space;
import com.yupi.yupicturebackend.model.enity.User;
import com.yupi.yupicturebackend.model.vo.SpaceVO;


import javax.servlet.http.HttpServletRequest;

/**
* @author LQY
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-03-21 17:09:04
*/
public interface SpaceService extends IService<Space> {

    /**
     * 用户创建空间
     *
     * @param spaceAddRequest
     * @param loginUser
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 校验
     *
     * @param space
     * @param add 是否为添加时校验
     */
    public void validSpace(Space space, boolean add);

    /**
     * 获取空间包装类( 单条 )
     *
     * @param space
     * @param request
     * @return
     */
    public SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    /**
     * 分页获取空间包装类(封装)
     * @param spacePage
     * @param request
     * @return
     */
    public Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    /**
     * 将查询请求转化为封装对象
     *
     * @param spaceQueryRequest
     * @return
     */
    public QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 根据空间级别填充空间对象
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 校验空间权限
     *
     * @param loginUser
     * @param space
     */
    void checkSpaceAuth(User loginUser, Space space);

}
