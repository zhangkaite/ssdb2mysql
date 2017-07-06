package com.okay.praxisservice.entity;

import java.util.Date;

/**
 * Created by kate on 2017/6/30.
 */
public class StudentExcise {
    private Long id;
    /**
     * 关联学生
     **/
    private Long studentId;
    /**
     * 问题
     **/
    private Long questionId;
    /**
     * 做题的来源
     **/
    private String exerciseSource;
    /**
     * 做题的来源
     **/
    private String exerciseSourceZh;
    /**
     * 创建的时间
     **/
    private Date createTime;
    /**
     * 学生提交答案
     **/
    private String submitAnswer;
    /**
     * 答题图片来源
     **/
    private Integer pictureSource;
    /**
     * 答题状态 7/无答案，6/有答案未批改，1/对，2/错，5/半对
     **/
    private String result;
    //添加智能批改结果
    private String intellResult;
    /**
     * 提交答案时间
     **/
    private Date submitTime;
    /**
     * 班级Id
     **/
    private Long classId;
    /**
     * 批改人Id
     **/
    private Long correctorId;
    /**
     * 批改角色
     **/
    private String correctorRole;
    private Long parentQuestionId;
    private Date correctorTime;
    private Date lastUpdateTime;
    private Integer structId;
    private String questionType;
    /**
     * 场景id：作业测评发布表id、错题重做源答题记录id、错题强化源答题记录id、课程同步习题发布表id。
     */
    private Long resourceId;
    /**
     * 教师批注
     */
    private String postilTeacher;
    /**
     * 教师批注时间
     **/
    private Date postilTeacherDate;

    /**
     * 重做状态
     */
    private String redoStatus;
    /**
     * 错题来源场景
     */
    private String redoSource;
    /**
     * 错题来源场景
     */
    private String redoSourceZh;
    private Integer year;

    /***
     * 同一答题场景下 通过子场景区分不同的答题业务场景
     */
    private Integer subExerciseSource;
    private String intellPostil;
    private String intellResource;
    private String postilSvgFlag;
    private String tableName;
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPostilSvgFlag() {
        return postilSvgFlag;
    }

    public void setPostilSvgFlag(String postilSvgFlag) {
        this.postilSvgFlag = postilSvgFlag;
    }

    public String getIntellResource() {
        return intellResource;
    }

    public void setIntellResource(String intellResource) {
        this.intellResource = intellResource;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getExerciseSource() {
        return exerciseSource;
    }

    public void setExerciseSource(String exerciseSource) {
        this.exerciseSource = exerciseSource;
    }

    public String getExerciseSourceZh() {
        return exerciseSourceZh;
    }

    public void setExerciseSourceZh(String exerciseSourceZh) {
        this.exerciseSourceZh = exerciseSourceZh;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSubmitAnswer() {
        return submitAnswer;
    }

    public void setSubmitAnswer(String submitAnswer) {
        this.submitAnswer = submitAnswer;
    }

    public Integer getPictureSource() {
        return pictureSource;
    }

    public void setPictureSource(Integer pictureSource) {
        this.pictureSource = pictureSource;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getIntellResult() {
        return intellResult;
    }

    public void setIntellResult(String intellResult) {
        this.intellResult = intellResult;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getCorrectorId() {
        return correctorId;
    }

    public void setCorrectorId(Long correctorId) {
        this.correctorId = correctorId;
    }

    public String getCorrectorRole() {
        return correctorRole;
    }

    public void setCorrectorRole(String correctorRole) {
        this.correctorRole = correctorRole;
    }

    public Long getParentQuestionId() {
        return parentQuestionId;
    }

    public void setParentQuestionId(Long parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
    }

    public Date getCorrectorTime() {
        return correctorTime;
    }

    public void setCorrectorTime(Date correctorTime) {
        this.correctorTime = correctorTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getStructId() {
        return structId;
    }

    public void setStructId(Integer structId) {
        this.structId = structId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getPostilTeacher() {
        return postilTeacher;
    }

    public void setPostilTeacher(String postilTeacher) {
        this.postilTeacher = postilTeacher;
    }

    public Date getPostilTeacherDate() {
        return postilTeacherDate;
    }

    public void setPostilTeacherDate(Date postilTeacherDate) {
        this.postilTeacherDate = postilTeacherDate;
    }

    public String getRedoStatus() {
        return redoStatus;
    }

    public void setRedoStatus(String redoStatus) {
        this.redoStatus = redoStatus;
    }

    public String getRedoSource() {
        return redoSource;
    }

    public void setRedoSource(String redoSource) {
        this.redoSource = redoSource;
    }

    public String getRedoSourceZh() {
        return redoSourceZh;
    }

    public void setRedoSourceZh(String redoSourceZh) {
        this.redoSourceZh = redoSourceZh;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSubExerciseSource() {
        return subExerciseSource;
    }

    public void setSubExerciseSource(Integer subExerciseSource) {
        this.subExerciseSource = subExerciseSource;
    }

    public String getIntellPostil() {
        return intellPostil;
    }

    public void setIntellPostil(String intellPostil) {
        this.intellPostil = intellPostil;
    }
}
