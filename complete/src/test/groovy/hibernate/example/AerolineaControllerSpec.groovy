package hibernate.example

import grails.plugin.json.view.mvc.JsonViewResolver
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest

//tag::spec[]
@SuppressWarnings('MethodName')
class AerolineaControllerSpec extends HibernateSpec implements ControllerUnitTest<ProductController> {
//end::spec[]

    //tag::config[]
    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }
    //end::config[]

    //tag::setup[]
    void setup() {
        Aerolinea.saveAll(
                new Aerolinea(idAerolinea:1, claveIATA: 5, nombre: 'ACAPULCO', estatus: 1),
                new Aerolinea(idAerolinea:2, claveIATA: 6, nombre: 'PUERTO ESCONDIDO', estatus: 1),
                new Aerolinea(idAerolinea:3, claveIATA: 7, nombre: 'OAXACA', estatus: 0),
                new Aerolinea(idAerolinea:4, claveIATA: 8, nombre: 'TIERRA', estatus: 0)
        )
    }
    //end::setup[]

    //tag::test[]
    void 'test the search action finds results'() {
        when: 'A query is executed that finds results'

        controller.search(nombre:'OAX', max:10)
        then: 'The response is correct'
        response.json.size() == 1
        response.json[0].nombre == 'OAXACA'
    }
    //tag::test[]
}
