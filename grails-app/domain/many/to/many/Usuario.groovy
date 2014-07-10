package many.to.many

class Usuario {

    String nombre

    Set<Circulo> circulos = []

    static hasMany = [
        circulos: Circulo,
    ]

    static constraints = {
        nombre blank: false, nullable: false
    }
}
