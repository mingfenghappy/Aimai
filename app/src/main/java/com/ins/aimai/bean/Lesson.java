package com.ins.aimai.bean;

import java.io.Serializable;

/**
 * 课程 entity
 * Created by Eric Xie on 2017/7/13 0013.
 */
public class Lesson implements Serializable {

    /** ID */
    private int id;

    /** 课程名 */
    private String curriculumName;

    /** 课程介绍 */
    private String curriculumDescribe;

    /** 年度 */
    private long year;

    /** 封面 */
    private String cover;

    /** 行业ID */
    private int tradeId;

    /** 行业名称 */
    private String tradeName;

    /** 地区ID */
    private int cityId;

    /** 培训阶段ID */
    private int curriculumStageId;

    /** 培训阶段 */
    private String stageName;

    /** 单价 */
    private double price;

    /** 课程类型ID */
    private int curriculumTypeId;

    /** 课程类型 */
    private String typeName;

    /** 发布状态 0:未发布  1:已发布 缺省值 0 */
    private int releaseStatus;

    /** 发布时间 */
    private long releaseTime;

    /** 创建时间 */
    private long createTime;

    /** 发布人 */
    private int releaseUserId;

    /** 发布人名字 */
    private String releaseUserName;

    /** 是否有效 0：无效 1：有效  缺省值 1*/
    private int isValid;

    /** 课程类别  0：试听课程  1：收费课程 */
    private int type;

    /** 是否是推荐课程 0：否 1：是 缺省值 1 */
    private int isRecommend;

    /** 排序ID 降序排列 */
    private int sortNum;


    /** 课程下的 视频数量 */
    private int videoNum;

    /** 总高清视频时长 秒 */
    private int hdSeconds;

    /** 总流畅视频时长 秒 */
    private int lowSeconds;

    /** 用户 是否拥有该课程 0：不拥有  1：拥有 */
    private int isOwn;

    /** 获取 ID */
    public int getId() {
        return this.id;
    }

    /** 设置 ID */
    public void setId(int id) {
        this.id = id;
    }

    /** 获取 课程名 */
    public String getCurriculumName() {
        return this.curriculumName;
    }

    /** 设置 课程名 */
    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    /** 获取 课程介绍 */
    public String getCurriculumDescribe() {
        return this.curriculumDescribe;
    }

    /** 设置 课程介绍 */
    public void setCurriculumDescribe(String curriculumDescribe) {
        this.curriculumDescribe = curriculumDescribe;
    }

    /** 获取 年度 */
    public long getYear() {
        return this.year;
    }

    /** 设置 年度 */
    public void setYear(long year) {
        this.year = year;
    }

    /** 获取 封面 */
    public String getCover() {
        return this.cover;
    }

    /** 设置 封面 */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /** 获取 行业ID */
    public int getTradeId() {
        return this.tradeId;
    }

    /** 设置 行业ID */
    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    /** 获取 行业名称 */
    public String getTradeName() {
        return this.tradeName;
    }

    /** 设置 行业名称 */
    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    /** 获取 地区ID */
    public int getCityId() {
        return this.cityId;
    }

    /** 设置 地区ID */
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    /** 获取 培训阶段ID */
    public int getCurriculumStageId() {
        return this.curriculumStageId;
    }

    /** 设置 培训阶段ID */
    public void setCurriculumStageId(int curriculumStageId) {
        this.curriculumStageId = curriculumStageId;
    }

    /** 获取 培训阶段 */
    public String getStageName() {
        return this.stageName;
    }

    /** 设置 培训阶段 */
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    /** 获取 单价 */
    public double getPrice() {
        return this.price;
    }

    /** 设置 单价 */
    public void setPrice(double price) {
        this.price = price;
    }

    /** 获取 课程类型ID */
    public int getCurriculumTypeId() {
        return this.curriculumTypeId;
    }

    /** 设置 课程类型ID */
    public void setCurriculumTypeId(int curriculumTypeId) {
        this.curriculumTypeId = curriculumTypeId;
    }

    /** 获取 课程类型 */
    public String getTypeName() {
        return this.typeName;
    }

    /** 设置 课程类型 */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /** 获取 发布状态 0:未发布  1:已发布 缺省值 0 */
    public int getReleaseStatus() {
        return this.releaseStatus;
    }

    /** 设置 发布状态 0:未发布  1:已发布 缺省值 0 */
    public void setReleaseStatus(int releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    /** 获取 发布时间 */
    public long getReleaseTime() {
        return this.releaseTime;
    }

    /** 设置 发布时间 */
    public void setReleaseTime(long releaseTime) {
        this.releaseTime = releaseTime;
    }

    /** 获取 创建时间 */
    public long getCreateTime() {
        return this.createTime;
    }

    /** 设置 创建时间 */
    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    /** 获取 发布人 */
    public int getReleaseUserId() {
        return this.releaseUserId;
    }

    /** 设置 发布人 */
    public void setReleaseUserId(int releaseUserId) {
        this.releaseUserId = releaseUserId;
    }

    /** 获取 发布人名字 */
    public String getReleaseUserName() {
        return this.releaseUserName;
    }

    /** 设置 发布人名字 */
    public void setReleaseUserName(String releaseUserName) {
        this.releaseUserName = releaseUserName;
    }

    /** 获取 是否有效 0：无效 1：有效  缺省值 1*/
    public int getIsValid() {
        return this.isValid;
    }

    /** 设置 是否有效 0：无效 1：有效  缺省值 1*/
    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    /** 获取 课程类别  0：试听课程  1：收费课程 */
    public int getType() {
        return this.type;
    }

    /** 设置 课程类别  0：试听课程  1：收费课程 */
    public void setType(int type) {
        this.type = type;
    }

    /** 获取 是否是推荐课程 0：否 1：是 缺省值 1 */
    public int getIsRecommend() {
        return this.isRecommend;
    }

    /** 设置 是否是推荐课程 0：否 1：是 缺省值 1 */
    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    /** 获取 排序ID 降序排列 */
    public int getSortNum() {
        return this.sortNum;
    }

    /** 设置 排序ID 降序排列 */
    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }
    /** 获取 课程下的 视频数量 */
    public int getVideoNum() {
        return this.videoNum;
    }

    /** 设置 课程下的 视频数量 */
    public void setVideoNum(int videoNum) {
        this.videoNum = videoNum;
    }

    /** 获取 总高清视频时长 秒 */
    public int getHdSeconds() {
        return this.hdSeconds;
    }

    /** 设置 总高清视频时长 秒 */
    public void setHdSeconds(int hdSeconds) {
        this.hdSeconds = hdSeconds;
    }

    /** 获取 总流畅视频时长 秒 */
    public int getLowSeconds() {
        return this.lowSeconds;
    }

    /** 设置 总流畅视频时长 秒 */
    public void setLowSeconds(int lowSeconds) {
        this.lowSeconds = lowSeconds;
    }

    /** 获取 用户 是否拥有该课程 0：不拥有  1：拥有 */
    public int getIsOwn() {
        return this.isOwn;
    }

    /** 设置 用户 是否拥有该课程 0：不拥有  1：拥有 */
    public void setIsOwn(int isOwn) {
        this.isOwn = isOwn;
    }

}