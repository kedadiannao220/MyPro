package com.pgy.mail;

import org.hibernate.validator.constraints.NotBlank;

import java.io.File;
import java.util.Date;

public class MailBody {

    // ====================头部验证信息===================
    /**
     * 邮件服务器地址
     */
    @NotBlank(message = "邮件服务器地址不能为空") private String host;

    /**
     * 邮件服务器端口号
     */
    @NotBlank(message = "邮件服务器端口号不能为空") private int port;

    @NotBlank(message = "用户名不能为空") private String username;

    @NotBlank(message = "密码不能为空") private String password;

    /**
     * 协议类型
     */
    private String protocal = "smtp";

    private String encoding = "UTF-8";

    // ====================邮件主体信息===================
    /**
     * 发件人
     */
    @NotBlank(message = "发件人不能为空") private String from;

    /**
     * 收件人列表
     */
    @NotBlank(message = "收件人不能为空") private String[] to;

    /**
     * 抄送人列表
     */
    private String[] cc;

    /**
     * 密件抄送
     */
    private String[] bcc;

    /**
     * 回复
     */
    private String replyTo;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String text;

    /**
     * 发送日期
     */
    private Date sendDate;

    /**
     * 附件显示名称
     */
    private String attachmentFilename;

    /**
     * 是否是html格式
     * 默认是false，不以html格式展示
     * 若为true，则以html格式展示 
     */
    private boolean isHtml = false;

    /**
     * html当中引用的id
     */
    private String contentId;

    /**
     * 附件
     */
    private File file;

    // ==================== 其他信息 ===================
    private String timeout = "2500";

    // =========================================
    //          setter and getter
    // =========================================
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProtocal() {
        return protocal;
    }

    public void setProtocal(String protocal) {
        this.protocal = protocal;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getBcc() {
        return bcc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getAttachmentFilename() {
        return attachmentFilename;
    }

    public void setAttachmentFilename(String attachmentFilename) {
        this.attachmentFilename = attachmentFilename;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public boolean isHtml() {
        return isHtml;
    }

    public void setHtml(boolean isHtml) {
        this.isHtml = isHtml;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public void setInline(String contentId, File file) {
        this.contentId = contentId;
        this.file = file;
    }
}
