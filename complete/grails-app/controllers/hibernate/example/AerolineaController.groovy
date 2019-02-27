package hibernate.example

import grails.rest.RestfulController

//tag::controller[]
import groovy.transform.CompileStatic

@CompileStatic
class AerolineaController extends RestfulController {

    static responseFormats = ['json', 'xml']
    AerolineaController() {
        super(Aerolinea)
    }

    // tag::searchAction[]
    def search(String cad, Integer max ) { // <1>
        if (cad) {
            //tag::whereQuery[]
            def query = Aerolinea.where { // <2>
                nombre ==~ "%${cad}%"
            }
            //end::whereQuery[]
            //tag::respond[]
            respond query.list(max: Math.min( max ?: 10, 100)) // <3>
            //end::respond[]
        }
        else {
            respond([]) // <4>
        }
    }
    //end::searchAction[]
}
