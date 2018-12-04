package groovyConfiguration

import com.example.springtest.bean.MyBean
import com.example.springtest.bean.MyOtherBean

beans {
    myOtherBean(MyOtherBean)

    myBean(MyBean, myOtherBean) {
        myValue = 'groovy value'
    }
}