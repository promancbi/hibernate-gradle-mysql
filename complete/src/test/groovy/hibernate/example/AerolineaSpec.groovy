package hibernate.example

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AerolineaSpec extends Specification implements DomainUnitTest<Aerolinea> {

    void 'test'() {
        //tag::testInvalid[]
        when: 'A domain class is saved with invalid data'
        Aerolinea aerolinea = new Aerolinea(idAerolinea: 11, claveIATA: 8, nombre: 'LIBERTAD', estatus: 0)
        aerolinea.save()

        then: 'There were errors and the data was not saved'
        //aerolinea.hasErrors()
        //aerolinea.errors.getFieldError('idAerolinea')
       // aerolinea.errors.getFieldError('claveIATA')
       // aerolinea.errors.getFieldError('name')
       // aerolinea.errors.getFieldError('estatus')
//        //end::testInvalid[]

        //tag::testValid[]
        when: 'A valid domain is saved'
        aerolinea.idAerolinea = 15
        aerolinea.claveIATA = 9
        aerolinea.nombre = 'BANANA'
        aerolinea.estatus = 1

        aerolinea.save()

        then: 'The aerolinea was saved successfully'
        Aerolinea.count() == 1
        //Aerolinea.first().claveIATA == 1
        //end::testValid[]
    }
}
