package com.example.sampleapp.model;

import org.hibernate.mapping.PrimaryKey;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.rmi.server.UID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "buy_courses")
@EntityListeners(AuditingEntityListener.class)
public class BuyCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "cand_id")

    private String cand_id= UUID.randomUUID().toString();
    @Column(name = "pro_id")

        private String proId =System.currentTimeMillis()+"";
    @Column(name = "pro_name")
    private String pro_name;
    @Column(name = "pro_cov_img")

    private String pro_cov_img;
    @Column(name = "act_price")

    private String act_price;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    @Column(name = "dis_price")

    private String dis_price;
    @Column(name = "star_point")

    private String star_point;
    @Column(name = "publisher")

    private String publisher;
    @Column(name = "cred_point")

    private String cred_point;
    @Column(name = "duration")
    private String duration;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "total_amt")
    private String total_amt;

    @Column(name = "cr_date")

    private String cr_date =date();
    @Column(name = "is_active")

    private String is_active;

    public BuyCourses() {

    }


    public Integer getId() {
        return id;
    }
    public String date(){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
       Date dateobj = new Date();
        System.out.println(df.format(dateobj));
                return   df.format(dateobj);
    }

    public String getCand_id() {
        return cand_id;
    }

    public void setCand_id(String cand_id) {
        this.cand_id = cand_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_cov_img() {
        return pro_cov_img;
    }

    public void setPro_cov_img(String pro_cov_img) {
        this.pro_cov_img = pro_cov_img;
    }

    public String getAct_price() {
        return act_price;
    }

    public void setAct_price(String act_price) {
        this.act_price = act_price;
    }

    public String getDis_price() {
        return dis_price;
    }

    public void setDis_price(String dis_price) {
        this.dis_price = dis_price;
    }

    public String getStar_point() {
        return star_point;
    }

    public void setStar_point(String star_point) {
        this.star_point = star_point;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCred_point() {
        return cred_point;
    }

    public void setCred_point(String cred_point) {
        this.cred_point = cred_point;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(String total_amt) {
        this.total_amt = total_amt;
    }

    public String getCr_date() {
        return cr_date;
    }

    public void setCr_date(String cr_date) {
        this.cr_date = cr_date;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }
}
