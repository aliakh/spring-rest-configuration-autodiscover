package demo.dto

import org.hibernate.validator.constraints.NotEmpty

class Value {

    @NotEmpty
    var value: String? = null
}
