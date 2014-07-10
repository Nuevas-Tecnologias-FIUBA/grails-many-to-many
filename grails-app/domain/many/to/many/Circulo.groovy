package many.to.many

class Circulo {

    String nombre

    Set<Usuario> usuarios = []

    static belongsTo = Usuario

    static hasMany = [
        usuarios: Usuario,
    ]

    static constraints = {
        nombre blank: false, nullable: false
    }
}
