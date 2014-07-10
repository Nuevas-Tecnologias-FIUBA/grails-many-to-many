package many.to.many

class AmistadController {

    def crearUsuario() {
        Usuario u = Usuario.withTransaction {
            Usuario u = new Usuario(nombre: params.nombre)
            u.save(failOnError: true)
        }
        render "${u}"
    }

    def crearCirculo() {
        Circulo c = Circulo.withTransaction {
            Circulo c = new Circulo(nombre: params.nombre)
            c.save(failOnError: true)
        }
        render "${c}"
    }

    def crearAmistad() {
        Usuario.withTransaction {
            Circulo c = Circulo.get(params.circulo)
            Usuario u = Usuario.get(params.usuario)
            if (!c || !u) throw new RuntimeException("no existe usuario=${u} o circulo=${c}")
            u.addToCirculos(c)
        }
        render "Listo!"
    }

    def index() {
    }
}
