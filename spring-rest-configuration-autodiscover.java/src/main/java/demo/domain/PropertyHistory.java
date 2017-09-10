package demo.domain;

import demo.service.core.Code;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PropertyHistory {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Code code;

    @Column(nullable = false)
    private String previousValue;

    @Column(nullable = false)
    private String currentValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(String previousValue) {
        this.previousValue = previousValue;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }
}
