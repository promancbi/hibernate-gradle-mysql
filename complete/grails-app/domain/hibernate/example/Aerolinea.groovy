package hibernate.example

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Aerolinea {

    Integer idAerolinea
    Integer claveIATA
    String nombre
    Integer estatus

    //tag::constraints[]
    static constraints = {
    }
    //end::constraints[]
}
