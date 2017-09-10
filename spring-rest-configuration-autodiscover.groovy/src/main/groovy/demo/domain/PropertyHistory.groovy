package demo.domain

import demo.service.core.Code

import javax.persistence.*
import java.time.LocalDateTime

@Entity
class PropertyHistory {

    @Id
    @GeneratedValue
    private Long id

    @Column(nullable = false)
    private LocalDateTime createDate

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Code code

    @Column(nullable = false)
    private String previousValue

    @Column(nullable = false)
    private String currentValue

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    LocalDateTime getCreateDate() {
        return createDate
    }

    void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate
    }

    Code getCode() {
        return code
    }

    void setCode(Code code) {
        this.code = code
    }

    String getPreviousValue() {
        return previousValue
    }

    void setPreviousValue(String previousValue) {
        this.previousValue = previousValue
    }

    String getCurrentValue() {
        return currentValue
    }

    void setCurrentValue(String currentValue) {
        this.currentValue = currentValue
    }
}
