
@RestController
class Web {

    @GetMapping('/')
    def index(){
       [new Person(name:"Felipe",email:"f@m.c"),
        new Person(name:"Manuel",email:"m@m.c")]       
    }

}

class Person {
   String name
   String email
}
